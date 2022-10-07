package com.ashera.core;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

import com.ashera.css.StyleSheet;
import com.ashera.model.Errors;
import com.ashera.model.ModelDataType;
import com.ashera.model.ModelExpressionParser;
import com.ashera.model.ModelExpressionParser.ModelStoreVarHolder;
import com.ashera.model.ModelScope;
import com.ashera.model.ModelStore;
import com.ashera.utils.FileUtils;
import com.ashera.widget.EventExpressionParser;
import com.ashera.widget.IRoot;
import com.ashera.widget.IWidget;
import com.ashera.widget.PluginInvoker;
import com.ashera.widget.bus.Event.StandardEvents;
import com.ashera.widget.bus.EventBus;

import androidx.fragment.app.Fragment;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GenericFragment extends Fragment implements IFragment{
    private IActivity activity;
	private String id;
	private String fileName;
	private Object view;
	private EventBus eventBus = new EventBus();
	private Map<String, Object> userData;
	private IWidget rootWidget;
	private StyleSheet styleSheet;
	private Map<String, Object> devData;
	private Map<String, Object> tempCache;
	private int x = -1, y = -1, width = -1, height = -1;
	private String DELLOC_EVENT = StandardEvents.dealloc.toString();
	private final static String POSTMEASURE_EVENT = StandardEvents.postMeasure.toString();
	private final static String PREMEASURE_EVENT = StandardEvents.preMeasure.toString();
	private WeakHashMap<IWidget, List<Object>> listeners;
	private List<Object> disposables;
	private boolean measuring;
	private Stack<Boolean> disableRemeasures = new Stack<>();

	@Override
	public void addListener(IWidget widget, Object listener) {
		if (listeners == null) {
			listeners = new WeakHashMap<>();
		}
		
		List<Object> objects = this.listeners.get(widget);
		if (objects == null) {
			objects = new ArrayList<>();
			this.listeners.put(widget, objects);
		}
		objects.add(listener);
	}
	
	@Override
	public <T> List<T> getListener(Class<T> type) {
		if (listeners == null) {
			return null;
		}
		
		return (List<T>) listeners.values().stream().flatMap(List::stream).filter((o) -> o.getClass() == type).collect(Collectors.toList());
	}
	
	@Override
	public <T> java.util.List<T> getListener(com.ashera.widget.IWidget widget, java.lang.Class<T> type) {
		if (listeners == null) {
			return null;
		}
		return (List<T>) listeners.get(widget).stream().filter((o) -> o.getClass() == type).collect(Collectors.toList());
	}
	
	@Override
	public void removeListener(IWidget widget, Object listener) {
		listeners.get(widget).remove(listener);
	}
	
	@Override
	public List<Object> getDisposables() {
		return disposables;
	}

	@Override
	public void addDisposable(Object disposable) {
		if (disposables == null) {
			disposables = new ArrayList<>();
		}
		disposables.add(disposable);
	}
	
	public void clear() {
    	eventBus.notifyObservers(DELLOC_EVENT, null);
    	eventBus.offAll();

		view = null;
		rootWidget = null;
		styleSheet = null;
		devData = null;
		tempCache = null;
		eventBus = null;
		userData = null;
		PluginInvoker.releaseNativeResources(disposables);
	}	

    public static Bundle getInitialBundle(String resId, String fileName, List<Map<String, Object>> scopedObjects) {
    	Bundle bundle = new Bundle();
    	bundle.putString("fileName", fileName);
    	bundle.putString("id", resId);
    	
        if (scopedObjects != null && !scopedObjects.isEmpty()) {
        	int scopedObjectCount = scopedObjects.size();
			bundle.putInt("count", scopedObjectCount);
        	for (int i = 0; i < scopedObjectCount; i++) {
        		Map<String, Object> map = scopedObjects.get(i);
            	bundle.putString("expression" + i, PluginInvoker.getString(map.get("expression")));

            	Object payload = map.get("payload");
            	if (payload instanceof java.io.Serializable) {
            		bundle.putSerializable("payload" + i, (java.io.Serializable) payload);
            	} else {
            		PluginInvoker.putObjectToBundle(bundle, "payload" + i, payload);
            	}
        	}
        }
    	
        return bundle;
    }
    
    // This event fires 1st, before creation of fragment or any views
    // The onAttach method is called when the Fragment instance is associated with an Activity. 
    // This does not mean the Activity is fully initialized.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IActivity){
        	onAttach((IActivity) context);
        }
    }
    
    @Override
    public void onAttach(IActivity activity) {
		this.activity = activity;
        this.id = UUID.randomUUID().toString();
        Bundle args = getArguments();
        this.fileName = args.getString("fileName");
        int scopedObjectCount = args.getInt("count");
        
        for (int i = 0; i < scopedObjectCount; i++) {
	        String expression = args.getString("expression" + i);
			
			if (expression != null && !expression.isEmpty()) {
				Object payload = args.getSerializable("payload" + i);
		        ModelStoreVarHolder modelStoreVarHolder = ModelExpressionParser.parseModelStoreVarExpression(expression);
		        String varName = modelStoreVarHolder.varName;
		        ModelScope varScope = modelStoreVarHolder.varScope;
		        ModelDataType varType = modelStoreVarHolder.varType;
		        Object modelData = ModelStore.changeModelDataType(varType, payload);
		        ModelStore.storeModelToScope(varName, varScope, modelData, this, null, null);
			}
        }
		sendLifeCycleEvent("onAttach", fileName, getEventData("onAttach"));

	}
       
    // This event fires 2nd, before views are created for the fragment
    // The onCreate method is called when the Fragment instance is being created, or re-created.
    // Use onCreate for any standard setup that does not require the activity to be fully created
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.onCreate();
    }
    
    @Override
    public void onCreate() {
        readFileInDevMode();
		sendLifeCycleEvent("onCreate", fileName, getEventData("onCreate"));
    }
    
   
    private void readFileInDevMode() {
        if ("dev".equals(this.activity.getAssetMode())) {
        	devData = new HashMap<>();
            HashMap<String, String> urlMap = new HashMap<>();
            String devServerIp = activity.getDevServerIp();
			urlMap.put("www/" + this.fileName, String.format("http://%s/%s", devServerIp, "app/src/main/res/" + this.fileName));
            urlMap.put("www/css/styles.css", String.format("http://%s/%s", devServerIp, "app/src/main/assets/www/css/styles.css"));

            urlMap.put("strings", String.format("http://%s/%s", devServerIp, "src/strings.properties"));
            urlMap.put("colors", String.format("http://%s/%s", devServerIp, "src/colors.properties"));
            urlMap.put("dimens", String.format("http://%s/%s", devServerIp, "src/dimens.properties"));
            Map<String, String> resultMap = FileUtils.readFilesContent(urlMap);
            
            devData.putAll(resultMap);
            Properties strings = getFileAsProperties("strings", resultMap);            
            Properties colors = getFileAsProperties("colors", resultMap);
            Properties dimens = getFileAsProperties("dimens", resultMap);

            devData.put("strings", strings);
            devData.put("colors", colors);
            devData.put("dimens", dimens);
        }        
    }
    
    
    @SuppressLint("NewApi")
    public Properties getFileAsProperties(String property, Map<String, String> resultMap) {
        StringReader stringReader = new StringReader(resultMap.get(property));
        Properties properties = new Properties();
        
        try {
            try {
                properties.load(stringReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            stringReader.close();
        }
        return properties;
    }
    @Override
    public void onResume() {
    	super.onResume();
    	sendLifeCycleEvent("onResume", fileName, getEventData("onResume"));
    }

	private String getEventData(String key) {
		Object myData = getUserData(key);
		if (myData == null) {
			return null;
		}
		String onResumeEventExpr = PluginInvoker.getString(myData);
		return onResumeEventExpr;
	}

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation. 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    	return (View) onCreateView(false);

    }
    
    @Override
    public Object onCreateView(boolean measure) {
		if (view == null) {
            try {
				IWidget widget = PluginInvoker.parseFile(fileName, false, this);
				
				if (measure) {
					remeasure();
				}
				
				view = widget.asNativeWidget();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
            return view;
        } else {
    	    return view;
        }
	}
	
	@Override
	public void onPause() {
		super.onPause();
		
		sendLifeCycleEvent("onPause", fileName, getEventData("onPause"));
	}
	
    // This event is triggered soon after onCreateView().
    // onViewCreated() is only called if the view returned from onCreateView() is non-null.
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // This method is called when the fragment is no longer connected to the Activity
    // Any references saved in onAttach should be nulled out here to prevent memory leaks. 
    @Override
    public void onDetach() {
        super.onDetach();
        sendLifeCycleEvent("onDetach", fileName, getEventData("onDetach"));
		activity = null;

    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	sendLifeCycleEvent("onDestroy", fileName, getEventData("onDestroy"));
    	clear();
    }
    
	@Override
	public void onCloseDialog() {
		sendLifeCycleEvent("onCloseDialog", fileName, getEventData("onCloseDialog"));
	}
        
    // This method is called after the parent Activity's onCreate() method has completed.
    // Accessing the view hierarchy of the parent activity must be done in the onActivityCreated.
    // At this point, it is safe to search for activity View objects by their ID, for example.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    
	private void sendLifeCycleEvent(String action, String fileName, String eventExpression) {
	    Map<String, Object> dataMap = com.ashera.widget.PluginInvoker.getJSONCompatMap();
		dataMap.put("action", "nativeevent");
		dataMap.put("event", action);
		dataMap.put("actionUrl", fileName);
		dataMap.put("fragmentId", id);
		
		if (eventExpression != null) {
			EventExpressionParser.parseEventExpression(eventExpression, dataMap);
			rootWidget.updateModelToEventMap(dataMap, (String) dataMap.get(EventExpressionParser.KEY_EVENT),
					(String) dataMap.get(EventExpressionParser.KEY_EVENT_ARGS));
		}
		activity.sendEventMessage(dataMap);		
	}
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public IWidget getRootWidget() {
		return rootWidget;
	}

	@Override
	public IActivity getRootActivity() {
		return activity;
	}
	@Override
	public Object getArgumentsBundle() {
		return getArguments();
	}
	@Override
	public void setRootWidget(IWidget widget) {
		rootWidget = widget;
	}

	@Override
	public Object getUserData(String key) {
		if (userData == null) {
			userData = new HashMap<>();
		}
		
		return userData.get(key);		
	}
	
	@Override
	public void storeUserData(String key, Object object) {
		if (userData == null) {
			userData = new HashMap<>();
		}
		
		userData.put(key, object);
	}
	
	@Override
	public boolean hasDevData(String key) {
		return devData != null && devData.containsKey(key);
	}
	@Override
	public Object getDevData(String key) {
		if (devData == null) {
			return null;
		}
		return devData.get(key);
	}
	@Override
	public StyleSheet getStyleSheet() {
		return this.styleSheet;
	}
	@Override
	public void setStyleSheet(StyleSheet styleSheet) {
		this.styleSheet = styleSheet;
	}

	@Override
	public boolean isViewLoaded() {
		return view != null;
	}

	@Override
	public void storeInTempCache(String key, Object object) {
		if (tempCache == null) {
			tempCache = new HashMap<>();
		}
		
		tempCache.put(key, object);

	}

	@Override
	public Object getFromTempCache(String key) {
		if (tempCache == null) {
			return null;
		}
		return tempCache.get(key);
	}

	@Override
	public void setFrame(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void remeasure() {
		if (isMeasuring()) {
			return;
		}
		measuring = true;
		eventBus.notifyObservers(PREMEASURE_EVENT, new com.ashera.widget.bus.Event(com.ashera.widget.bus.Event.StandardEvents.preMeasure));

		if (x == -1 && y == -1 && width == -1 && height == -1) {
			((IRoot) rootWidget).measure();
		} else {
			((IRoot) rootWidget).measure(x, y, width, height);			
		}
		
		eventBus.notifyObservers(POSTMEASURE_EVENT, new com.ashera.widget.bus.Event(com.ashera.widget.bus.Event.StandardEvents.postMeasure));
		measuring = false;
	}

	public boolean isMeasuring() {
		return measuring || disableRemeasures.size() > 0;
	}

	@Override
	public Object getParentForRootWidget() {
		return activity.getRootWidget();
	}

	@Override
	public String getFragmentId() {
		return id;
	}

	@Override
	public String getActionUrl() {
		return fileName;
	}

	@Override
	public void disableRemeasure() {
		disableRemeasures.push(true);
		
	}

	@Override
	public void enableRemeasure() {
		disableRemeasures.pop();
	}

	@Override
	public void addError(com.ashera.model.Error error) {
		getFatalErrors().addError(error);
		((IRoot)rootWidget).displayErrorIndicator();
	}
	
	@Override
	public boolean hasErrors() {
		return getFatalErrors().getErrors().size() > 0;
	}
	
	private Errors getFatalErrors() {
		String errorKey = "fatalErrors";
		Errors errors = (Errors) getUserData(errorKey);
		if (errors == null) {
			errors = new Errors();
			storeUserData(errorKey, errors);
		}
		return errors;
	}
}
