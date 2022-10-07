package com.ashera.layout;

//start - imports
import java.util.*;

import r.android.annotation.SuppressLint;
import r.android.content.Context;
import r.android.os.Build;
import r.android.view.*;
import r.android.widget.*;
import r.android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import r.android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

//end - imports

public class ListViewImpl extends ScrollViewImpl {
    //start - body
    public final static String LOCAL_NAME = "ListView"; 
    public final static String GROUP_NAME = "ListView";       
    private LinearLayoutImpl linearLayoutImpl;
    
    public ListViewImpl() {
        super(GROUP_NAME, LOCAL_NAME);
    }

    @Override
    public void create(
    		IFragment fragment,
            java.util.Map<java.lang.String, java.lang.Object> params) {
        super.create(fragment, params);
        nativeCreate(params);
    }

    @Override
    public IWidget newInstance() {
        return new ListViewImpl();
    }
    
		@SuppressLint("NewApi")
		final static class ChoiceMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("multipleChoice",  0x2);
				mapping.put("multipleChoiceModal",  0x3);
				mapping.put("none",  0x0);
				mapping.put("singleChoice",  0x1);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}

    @Override
    public void loadAttributes(String localName) {
        super.loadAttributes(localName);
            new LinearLayoutImpl().loadAttributes(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemClick").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("listheader").withType("template"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("listfooter").withType("template"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("divider").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dividerHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("footerDividersEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("headerDividersEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemLongClick").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrollChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("stackFromBottom").withType("boolean"));
		ConverterFactory.register("ListView.choiceMode", new ChoiceMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("choiceMode").withType("ListView.choiceMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("listSelector").withType("drawable"));
    }
    @Override
    public void setAttribute(WidgetAttribute key, String strValue,
            Object objValue, ILifeCycleDecorator decorator) {
        super.setAttribute(key, strValue, objValue, decorator);
        Object nativeWidget = asNativeWidget();
        switch (key.getAttributeName()) {
            case "onItemClick": {
                
                            setOnItemClick(objValue);
                
            }
            break;
            case "listheader": {
                
                             addHeaderTemplate(objValue);
                
            }
            break;
            case "listfooter": {
                
                             addFooterTemplate(objValue);
                
            }
            break;
            case "divider": {
                
                             setDivider(key, strValue, objValue, decorator);
                
            }
            break;
            case "dividerHeight": {
                
                             setDividerHeight(objValue);
                
            }
            break;
            case "footerDividersEnabled": {
                
                             setFooterDividersEnabled(objValue);
                
            }
            break;
            case "headerDividersEnabled": {
                
                             setHeaderDividersEnabled (objValue);
                
            }
            break;
            case "onItemLongClick": {
                
                             setOnItemLongClick(objValue);
                
            }
            break;
            case "onScrollChange": {
                
                             setOnScroll(key, strValue, objValue, decorator);
                
            }
            break;
            case "stackFromBottom": {
                
                             setStackFromBottom(objValue);
                
            }
            break;
            case "choiceMode": {
                
                             setChoiceMode(objValue);
                
            }
            break;
            case "listSelector": {
                
                             setListSelector(strValue, objValue);
                
            }
            break;
        default:
            break;
        }

        this.setAttributesOnComposite(key, strValue, objValue, decorator);
    }

	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object attributeValue = ViewGroupImpl.getAttribute(this, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "divider": {
return getDivider(key, decorator);			}
			case "dividerHeight": {
return getDividerHeight();			}
			case "stackFromBottom": {
return getStackFromBottom();			}
			case "choiceMode": {
return getChoiceMode();			}
			case "listSelector": {
return getListSelector();			}
		}
		return null;
	}
	
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
    }
    
    

	@Override
	public void updateModelToEventMap(Map<String, Object> eventMap, String eventType, String eventParams) {
	    if (eventMap.containsKey("position") && eventType.startsWith("onItem")) {
	    	int position = PluginInvoker.getInt(eventMap.get("position"));
	        position = updatePosition(eventMap, position);
	        if (position >= 0 && position < dataList.size()) {  
	            com.ashera.model.LoopParam loopParam = dataList.get(position);
	            updateModelToEventMap(eventMap, eventParams, loopParam);
	        }
	    } else {
	        super.updateModelToEventMap(eventMap, eventType, eventParams);
	    }
	}
	


	private static void addCheckItemInfo(java.util.Map<String, Object> obj, AdapterView<?> parent) {
		if (parent instanceof AbsListView) {
	    	PluginInvoker.putJSONSafeObjectIntoMap(obj, "checkedItemCount", ((AbsListView) parent).getCheckedItemCount());
	    	PluginInvoker.putJSONSafeObjectIntoMap(obj, "checkedItemPosition", ((AbsListView) parent).getCheckedItemPosition());
	    	long[] checkedItemIds = ((AbsListView) parent).getCheckedItemIds();
	    	List<String> ids = new java.util.ArrayList<>();
	    	for (long checkedItemId: checkedItemIds) {
	    		ids.add(IdGenerator.getName((int) checkedItemId));
			}
			PluginInvoker.putJSONSafeObjectIntoMap(obj, "checkedItemIds", ids);
	    }
	}
	


    private ListAdapter listAdapter;
    class ListAdapter extends BaseAdapter{
        @Override
        public boolean isEnabled(int position) {
            return true;
        }
        public ListAdapter() {
        }
        
        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }
        
        @Override
        public long getItemId(int position) {
            return IdGenerator.getId(ids.get(position));
        }
        
        @Override
        public boolean hasStableIds() {
        	return true;
        }
        
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            com.ashera.model.LoopParam model = dataList.get(position);
            IWidget myWidget;
            if (convertView == null) {
                myWidget = (IWidget) getListItem().loadLazyWidgets(model);
                ((View) myWidget.asNativeWidget()).setTag(myWidget);
            } else {    
                myWidget = (IWidget) convertView.getTag();
            }

            updateModelRecurse(myWidget, model);

            return (View) myWidget.asNativeWidget();
        }
        
    }
    


	int thumbHeight = 0;
	private void postOnMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		((ScrollView) asWidget()).adjustPaddingIfScrollBarPresent(widthMeasureSpec, heightMeasureSpec, thumbHeight);
	}
	

    @SuppressLint("NewApi")
private static class OnItemClickListener implements AdapterView.OnItemClickListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnItemClickListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnItemClickListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onItemClick (AdapterView<?> parent, 
                View view, 
                int position, 
                long id){
    
	if (action == null || action.equals("onItemClick")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onItemClick");
	    java.util.Map<String, Object> obj = getOnItemClickEventObj(parent,view,position,id);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, parent,view,position,id);
		    }
		    if (commandType.equals(":")) {
		    	return;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnItemClickEventObj(AdapterView<?> parent,View view,int position,long id) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "itemclick");ListViewImpl.addCheckItemInfo(obj, parent);
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "position", position);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onItemClick", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

    @SuppressLint("NewApi")
private static class OnItemLongClickListener implements AdapterView.OnItemLongClickListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnItemLongClickListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnItemLongClickListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onItemLongClick (AdapterView<?> parent, 
                View view, 
                int position, 
                long id){
    boolean result = true;
    
	if (action == null || action.equals("onItemLongClick")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onItemLongClick");
	    java.util.Map<String, Object> obj = getOnItemLongClickEventObj(parent,view,position,id);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, parent,view,position,id);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }
		    if (commandType.equals(":")) {
		    	return result;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return result;
}//#####

public java.util.Map<String, Object> getOnItemLongClickEventObj(AdapterView<?> parent,View view,int position,long id) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "itemlongclick");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "position", position);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onItemLongClick", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

    @SuppressLint("NewApi")
private static class OnScrollListener implements AbsListView.OnScrollListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnScrollListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnScrollListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onScroll (AbsListView view, 
                int firstVisibleItem, 
                int visibleItemCount, 
                int totalItemCount){
    
	if (action == null || action.equals("onScrollChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onScrollChange");
	    java.util.Map<String, Object> obj = getOnScrollChangeEventObj(view,firstVisibleItem,visibleItemCount,totalItemCount);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, view,firstVisibleItem,visibleItemCount,totalItemCount);
		    }
		    if (commandType.equals(":")) {
		    	return;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return;
}//
public void onScrollStateChanged (AbsListView view, 
                int scrollState){
    
	if (action == null || action.equals("onScrollStateChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onScrollStateChange");
	    java.util.Map<String, Object> obj = getOnScrollStateChangeEventObj(view,scrollState);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, view,scrollState);
		    }
		    if (commandType.equals(":")) {
		    	return;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnScrollStateChangeEventObj(AbsListView view,int scrollState) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "scrollstatechange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "scrollState", scrollState);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onScrollStateChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}

public java.util.Map<String, Object> getOnScrollChangeEventObj(AbsListView view,int firstVisibleItem,int visibleItemCount,int totalItemCount) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "scrollchange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "firstVisibleItem", firstVisibleItem);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "visibleItemCount", visibleItemCount);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "totalItemCount", totalItemCount);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onScrollChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

    //end - body
    //start - viewcode
    private IWidget headerTemplate;
    private IWidget footerTemplate;
    private LinearLayoutImpl listLinearLayoutImpl;
	private int selectedPosition;
	private ListView listView;
	
    //start - adapter
	private void setChoiceMode(Object objValue) {
		listView.setChoiceMode((int) objValue);
	}

    private Object getChoiceMode() {
		return listView.getChoiceMode();
	}

	private void initListAdapter() {
		listAdapter = new ListAdapter();
		listView.setAdapter(listAdapter);
	}  
    private int updatePosition(java.util.Map<java.lang.String, java.lang.Object> eventMap, int position) {
        return position;
    }
    //end - adapter
    
    private void setAttributesOnComposite(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
	}

    private void addFooterTemplate(Object objValue) {
        this.footerTemplate = (IWidget) objValue;
        updateDividerFlags();
    }

    private void addHeaderTemplate(Object objValue) {
        this.headerTemplate = (IWidget) objValue;
        updateDividerFlags();
    }

    private Object itemClick;
    private void setOnItemClick(Object objValue) {
        this.itemClick = objValue;
    }

    private void nativeCreate(Map<String, Object> params) {
    	listView = new ListView();
    	initListAdapter();
        linearLayoutImpl = new LinearLayoutImpl();
        linearLayoutImpl.setParent(this);
        linearLayoutImpl.create(fragment, params);
        ((LinearLayout)linearLayoutImpl.asWidget()).setOrientation(LinearLayout.VERTICAL);
        ((ScrollView) asWidget()).setFillViewport(true);
        
        listLinearLayoutImpl = new LinearLayoutImpl();
        listLinearLayoutImpl.setParent(linearLayoutImpl);
        listLinearLayoutImpl.create(fragment, params);
        ((LinearLayout)listLinearLayoutImpl.asWidget()).setOrientation(LinearLayout.VERTICAL);
    }
  
    @Override
    public void add(IWidget w, int index) {
        listLinearLayoutImpl.add(w, index);
    }
    
    @Override
    public void updateWidgetMap(WidgetAttribute key, WidgetAttributeValue value) {
        super.updateWidgetMap(key, value);
        if (key.getAttributeName().equals("layout_width") || key.getAttributeName().equals("layout_height")) {
            linearLayoutImpl.updateWidgetMap(key, value);
        }
        
        if (key.getAttributeName().equals("layout_width")) {
            listLinearLayoutImpl.updateWidgetMap(key, value);
        }
    }
    
    @Override
    public void initialized() {
        linearLayoutImpl.add(listLinearLayoutImpl, -1);
        super.add(linearLayoutImpl, -1);
        
        listLinearLayoutImpl.initialized();
        linearLayoutImpl.initialized();
        super.initialized();
        
        if (headerTemplate != null) {
            this.headerTemplate.loadLazyWidgets(linearLayoutImpl, 0, "", null);
        }
        
        if (footerTemplate != null) {
        	this.footerTemplate.loadLazyWidgets(linearLayoutImpl);
        }
    }

    @Override
    protected java.util.List<com.ashera.widget.IWidget> getChildWidgets() {
        return listLinearLayoutImpl.getWidgets();
    }

    @Override
    public HasWidgets getCompositeLeaf() {
        if (linearLayoutImpl.asNativeWidget() == null) {
            return super.getCompositeLeaf();
        }
        return linearLayoutImpl;
    }
    
    @Override
    protected void addItemToParent(int index, java.lang.String id, com.ashera.model.LoopParam childModel) {
        IWidget widget = listItem.loadLazyWidgets(listLinearLayoutImpl, index, id, childModel);
        onChildAdded(widget);
    }
    

    @Override
    protected void onChildAdded(IWidget widget) {
    	if (listSelector != null) {
    		ViewImpl.setBackground(widget, widget.asNativeWidget(), listSelector);
    	}
        if (itemClick != null  || listSelector != null) {
            addClickListener(widget);
        }
        
        if (itemLongClick != null)  {
            View.OnLongClickListener listener = new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					View view = (View) widget.asWidget();
					int position = listLinearLayoutImpl.getWidgets().indexOf(widget);
					AdapterView.OnItemLongClickListener onItemClickListener; 
                    
                    if (itemLongClick instanceof String) {
                    	onItemClickListener = new OnItemLongClickListener(ListViewImpl.this, (String) itemLongClick);
                    } else {
                    	onItemClickListener = (AdapterView.OnItemLongClickListener) itemLongClick;
                    }
                    onItemClickListener.onItemLongClick(new AdapterView<Object>(), view, position, -1l);
                
					return true;
				}

            };
            addLongClickListener(widget, listener);
        }
       
    }
    
    private void handleClickEvent(IWidget widget) {
		View view = updateStateOnClick(widget);

    	int position = listLinearLayoutImpl.getWidgets().indexOf(widget);
    	if (itemClick != null) {
    		AdapterView.OnItemClickListener onItemClickListener;
    		if (itemClick instanceof String) {
    			onItemClickListener= new OnItemClickListener(ListViewImpl.this, (String) itemClick);
    		} else {
    			onItemClickListener = (AdapterView.OnItemClickListener) itemClick;
    		}
            onItemClickListener.onItemClick(listView, view, position, -1l);
    	}
	}
    

	private View updateStateOnClick(IWidget widget) {
        List<IWidget> childWidgets = listLinearLayoutImpl.getWidgets();
        if (selectedPosition < childWidgets.size()) {
        	View oldSelection = (View)childWidgets.get(selectedPosition).asWidget();
        	oldSelection.setSelected(false);
        }

		int position = childWidgets.indexOf(widget);
        selectedPosition = position;
        View view = (View) widget.asWidget();
        view.setSelected(true);
        listView.performItemClick(view, position, -1l);
		return view;
	}

    @Override
    public boolean areWidgetItemsRecycled() {
    	return true;
    }
    
    @Override
    public boolean remove(int index) {
        IWidget widget = listLinearLayoutImpl.getWidgets().get(index);
        boolean remove = listLinearLayoutImpl.removeWidget(index);
        removeIdsAndData(index);

        LinearLayout linearLayout = (LinearLayout) listLinearLayoutImpl.asWidget();
        if (index + 1 <= linearLayout.getChildCount()) {
            linearLayout.removeViewAt(index);
            ViewGroupImpl.nativeRemoveView(widget);            
        }    
        return remove;
    }
    
    @Override
    public void clear() {
    	int startIndex = 0;
    	int endIndex = listLinearLayoutImpl.getWidgets().size();
    	for (int i = endIndex - 1; i >= startIndex; i--) {
    		remove(i);
    	}
    }

	private void setStackFromBottom(Object objValue) {
		if ((boolean)objValue) {
			((LinearLayout)linearLayoutImpl.asWidget()).setGravity(Gravity.BOTTOM);
		} else {
			((LinearLayout)linearLayoutImpl.asWidget()).setGravity(Gravity.TOP);
		}
	}
	
	private Object itemLongClick;
	private void setOnItemLongClick(Object objValue) {
		this.itemLongClick = objValue;
	}

	boolean headerDividersEnabled = true;
	boolean footerDividersEnabled = true;
	private void setHeaderDividersEnabled(Object objValue) {
		headerDividersEnabled = (boolean) objValue;
		updateDividerFlags();
	}

	private void setFooterDividersEnabled(Object objValue) {
		footerDividersEnabled = (boolean) objValue;
		updateDividerFlags();
	}


	private void setDividerHeight(Object objValue) {
		((LinearLayout)listLinearLayoutImpl.asWidget()).updateDividerHeight((int) objValue);
		((LinearLayout)linearLayoutImpl.asWidget()).updateDividerHeight((int) objValue);
	}
	
	
    private Object getDivider(WidgetAttribute key, ILifeCycleDecorator decorator) {
		return listLinearLayoutImpl.getAttribute(key, decorator);
	}


	private void setDivider(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
    	listLinearLayoutImpl.setAttribute(key, strValue, objValue, decorator);
    	linearLayoutImpl.setAttribute(key, strValue, objValue, decorator);
    	updateDividerFlags();
	}

	private void updateDividerFlags() {
		int listDividerFlag = LinearLayout.SHOW_DIVIDER_MIDDLE | LinearLayout.SHOW_DIVIDER_END;
		int dividerFlag = LinearLayout.SHOW_DIVIDER_NONE;

		if (headerTemplate != null) {
			listDividerFlag |= LinearLayout.SHOW_DIVIDER_BEGINNING;
		}
		
		if (footerTemplate != null) {
			dividerFlag |= LinearLayout.SHOW_DIVIDER_END;
		}
		
		if (!footerDividersEnabled) {
			dividerFlag &= ~LinearLayout.SHOW_DIVIDER_END;
			listDividerFlag &= ~LinearLayout.SHOW_DIVIDER_END;
		}
		
		if (!headerDividersEnabled) {
			dividerFlag &= ~LinearLayout.SHOW_DIVIDER_BEGINNING;
			listDividerFlag &= ~LinearLayout.SHOW_DIVIDER_BEGINNING;
		}
		((LinearLayout)listLinearLayoutImpl.asWidget()).setShowDividers(listDividerFlag);
		((LinearLayout)linearLayoutImpl.asWidget()).setShowDividers(dividerFlag);
	}
	
    private Object getStackFromBottom() {
		return ((LinearLayout)linearLayoutImpl.asWidget()).getGravity() == Gravity.BOTTOM;
	}

	private Object getDividerHeight() {
		r.android.graphics.drawable.Drawable dividerDrawable = ((LinearLayout)listLinearLayoutImpl.asWidget()).getDividerDrawable();
		if (dividerDrawable == null) {
			return 0;
		}
		return dividerDrawable.getMinimumHeight();
	}

	private void setOnScroll(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		super.setAttribute(key, strValue, objValue, decorator);
	}

	
	private r.android.graphics.drawable.Drawable listSelector;
	private void setListSelector(String strValue, Object objValue) {
		if (!(objValue instanceof r.android.graphics.drawable.StateListDrawable)) {
			r.android.graphics.drawable.StateListDrawable stateListDrawable = new r.android.graphics.drawable.StateListDrawable();
			stateListDrawable.addState(new int[] { r.android.R.attr.state_selected },  (r.android.graphics.drawable.Drawable) objValue);
			objValue = stateListDrawable;
		}
		listSelector = (r.android.graphics.drawable.Drawable)objValue;
		listSelector.setMinimumHeight(0);
		listSelector.setMinimumWidth(0);
		
	}
	
    private Object getListSelector() {
		return listSelector;
	}
	
	//end - viewcode
	

	private void addClickListener(IWidget widget) {
		org.eclipse.swt.widgets.Listener listener = new org.eclipse.swt.widgets.Listener() {           
		    @Override
		    public void handleEvent( org.eclipse.swt.widgets.Event event ) {
		        handleClickEvent(widget);
		    }
		};
		org.eclipse.swt.widgets.Control control = (org.eclipse.swt.widgets.Control)widget.asNativeWidget();
		ViewImpl.addListener(control, listener);
	}

	private void addLongClickListener(IWidget widget, View.OnLongClickListener listener) {
		org.eclipse.swt.widgets.Control control = (org.eclipse.swt.widgets.Control)widget.asNativeWidget();
		ViewImpl.addLongClickListener(widget, control, (OnLongClickListener) listener);
	}
}
