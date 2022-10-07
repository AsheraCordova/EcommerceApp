package com.ashera.layout;

// start - imports
import java.util.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.*;
import android.widget.*;
import android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

import android.graphics.Canvas;
import android.widget.*;
import androidx.core.view.*;
import android.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports

public class ListViewImpl extends BaseHasWidgets {
	//start - body
	public final static String LOCAL_NAME = "ListView"; 
	public final static String GROUP_NAME = "ListView";
	private android.widget.ListView listView;
	

	
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
		@SuppressLint("NewApi")
		final static class TranscriptMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("alwaysScroll",  0x2);
				mapping.put("disabled",  0x0);
				mapping.put("normal",  0x1);
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
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("divider").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dividerHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("footerDividersEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("headerDividersEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("cacheColorHint").withType("color"));
		ConverterFactory.register("ListView.choiceMode", new ChoiceMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("choiceMode").withType("ListView.choiceMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawSelectorOnTop").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fastScrollEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollingCache").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("smoothScrollbar").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("stackFromBottom").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textFilterEnabled").withType("boolean"));
		ConverterFactory.register("ListView.transcriptMode", new TranscriptMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("transcriptMode").withType("ListView.transcriptMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrollChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrollStateChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemClick").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemLongClick").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("listSelector").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("listheader").withType("template"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("listfooter").withType("template"));
	
	}
	
	public ListViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  ListViewImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  ListViewImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new ListViewImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		listView = new ListViewExt(context);
	} else {
		int defStyleAttr = 0;
		int defStyleRes = 0;
		
		if (systemStyle != null) {
			defStyleRes = context.getResources().getIdentifier((String) systemStyle, "style", context.getPackageName());	
		}
		
		if (systemAndroidAttrStyle != null) {
			defStyleAttr = context.getResources().getIdentifier((String) systemAndroidAttrStyle, "attr", "android");	
		}
		
		if (defStyleRes == 0) {
			listView = new ListViewExt(context, null, defStyleAttr);	
		} else {
			listView = new ListViewExt(context, null, defStyleAttr, defStyleRes);
		}
		
	}

		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return listView;
	}

	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        listView.addView(view);
			    } else {
			        listView.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		android.widget.ListView.LayoutParams layoutParams = (android.widget.ListView.LayoutParams) view.getLayoutParams();
		
		layoutParams = (android.widget.ListView.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new android.widget.ListView.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private android.widget.ListView.LayoutParams getLayoutParams(View view) {
		return (android.widget.ListView.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		android.widget.ListView.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
			break;
		default:
			break;
		}
		
		
		view.setLayoutParams(layoutParams);		
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getChildAttribute(IWidget w, WidgetAttribute key) {
		Object attributeValue = ViewGroupImpl.getChildAttribute(w, key);		
		if (attributeValue != null) {
			return attributeValue;
		}
		View view = (View) w.asWidget();
		android.widget.ListView.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
		
	public class ListViewExt extends android.widget.ListView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private int mMaxWidth = -1;
		private int mMaxHeight = -1;
		@Override
		public void setMaxWidth(int width) {
			mMaxWidth = width;
		}
		@Override
		public void setMaxHeight(int height) {
			mMaxHeight = height;
		}
		@Override
		public int getMaxWidth() {
			return mMaxWidth;
		}
		@Override
		public int getMaxHeight() {
			return mMaxHeight;
		}

		public ListViewExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

	    public ListViewExt(Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
	    	super(context, attrs, defStyleAttr, defStyleRes);
	    }
		public ListViewExt(Context context) {
			super(context);
			
			
			
			
			
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			if(mMaxWidth > 0) {
	        	widthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxWidth, MeasureSpec.AT_MOST);
	        }
	        if(mMaxHeight > 0) {
	            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);

	        }

	        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
			    measureFinished.setWidth(getMeasuredWidth());
			    measureFinished.setHeight(getMeasuredHeight());
				listener.eventOccurred(EventId.measureFinished, measureFinished);
			}
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
			
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
				onLayoutEvent.setB(b);
				onLayoutEvent.setL(l);
				onLayoutEvent.setR(r);
				onLayoutEvent.setT(t);
				onLayoutEvent.setChanged(changed);
				listener.eventOccurred(EventId.onLayout, onLayoutEvent);
			}
			
			if (isInvalidateOnFrameChange() && isInitialised()) {
				ListViewImpl.this.invalidate();
			}
		}	
		
		@Override
		public void onDraw(Canvas canvas) {
			Runnable runnable = () -> super.onDraw(canvas);
			executeMethodListeners("onDraw", runnable, canvas);
		}

		@Override
		public void draw(Canvas canvas) {
			Runnable runnable = () -> super.draw(canvas);
			executeMethodListeners("draw", runnable, canvas);
		}

		@SuppressLint("WrongCall")
		@Override
		public void execute(String method, Object... args) {
			switch (method) {
				case "onDraw":
					setOnMethodCalled(true);
					super.onDraw((Canvas) args[0]);
					break;

				case "draw":
					setOnMethodCalled(true);
					super.draw((Canvas) args[0]);
					break;

				default:
					break;
			}
		}

		public void updateMeasuredDimension(int width, int height) {
			setMeasuredDimension(width, height);
		}


		@Override
		public ILifeCycleDecorator newInstance(IWidget widget) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setAttribute(WidgetAttribute widgetAttribute,
				String strValue, Object objValue) {
			throw new UnsupportedOperationException();
		}		
		

		@Override
		public List<String> getMethods() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void initialized() {
			throw new UnsupportedOperationException();
		}
		
        @Override
        public Object getAttribute(WidgetAttribute widgetAttribute) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void drawableStateChanged() {
        	super.drawableStateChanged();
        	ViewImpl.drawableStateChanged(ListViewImpl.this);
        }
	}
	
	public void updateMeasuredDimension(int width, int height) {
		((ListViewExt) listView).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "divider": {


	listView.setDivider((android.graphics.drawable.Drawable)objValue);



			}
			break;
			case "dividerHeight": {


	listView.setDividerHeight((int)objValue);



			}
			break;
			case "footerDividersEnabled": {


	listView.setFooterDividersEnabled((boolean)objValue);



			}
			break;
			case "headerDividersEnabled": {


	listView.setHeaderDividersEnabled((boolean)objValue);



			}
			break;
			case "cacheColorHint": {


	listView.setCacheColorHint((int)objValue);



			}
			break;
			case "choiceMode": {


	listView.setChoiceMode((int)objValue);



			}
			break;
			case "drawSelectorOnTop": {


	listView.setDrawSelectorOnTop((boolean)objValue);



			}
			break;
			case "fastScrollEnabled": {


	listView.setFastScrollEnabled((boolean)objValue);



			}
			break;
			case "scrollingCache": {


	listView.setScrollingCacheEnabled((boolean)objValue);



			}
			break;
			case "smoothScrollbar": {


	listView.setSmoothScrollbarEnabled((boolean)objValue);



			}
			break;
			case "stackFromBottom": {


	listView.setStackFromBottom((boolean)objValue);



			}
			break;
			case "textFilterEnabled": {


	listView.setTextFilterEnabled((boolean)objValue);



			}
			break;
			case "transcriptMode": {


	listView.setTranscriptMode((int)objValue);



			}
			break;
			case "onScrollChange": {


		if (objValue instanceof String) {listView.setOnScrollListener(new OnScrollListener(this, strValue));} else {setOnScrollListener(listView, objValue);}



			}
			break;
			case "onScrollStateChange": {


		if (objValue instanceof String) {listView.setOnScrollListener(new OnScrollListener(this, strValue));} else {setOnScrollListener(listView, objValue);}



			}
			break;
			case "onItemClick": {


		if (objValue instanceof String) {listView.setOnItemClickListener(new OnItemClickListener(this, strValue));} else {setOnItemClickListener(listView, objValue);}



			}
			break;
			case "onItemLongClick": {


		if (objValue instanceof String) {listView.setOnItemLongClickListener(new OnItemLongClickListener(this, strValue));} else {setOnItemLongClickListener(listView, objValue);}



			}
			break;
			case "listSelector": {


		 setListSelector(objValue);



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
		default:
			break;
		}
		
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
return listView.getDivider();			}
			case "dividerHeight": {
return listView.getDividerHeight();			}
			case "cacheColorHint": {
return listView.getCacheColorHint();			}
			case "choiceMode": {
return listView.getChoiceMode();			}
			case "fastScrollEnabled": {
return listView.isFastScrollEnabled();			}
			case "scrollingCache": {
return listView.isScrollingCacheEnabled();			}
			case "smoothScrollbar": {
return listView.isSmoothScrollbarEnabled();			}
			case "stackFromBottom": {
return listView.isStackFromBottom();			}
			case "textFilterEnabled": {
return listView.isTextFilterEnabled();			}
			case "transcriptMode": {
return listView.getTranscriptMode();			}
			case "listSelector": {
return getListSelector();			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return listView;
    }
    
    @Override
    public void requestLayout() {
    	if (isInitialised()) {
    		ViewImpl.requestLayout(this, asNativeWidget());
    	}
    }
    
    @Override
    public void invalidate() {
    	if (isInitialised()) {
    		ViewImpl.invalidate(this, asNativeWidget());
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


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			listView.setId(IdGenerator.getId(id));
		}
	}
	
    

	
private ListViewCommandBuilder builder;
private ListViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ListViewBean getBean() {
	if (bean == null) {
		bean = new ListViewBean();
	}
	return bean;
}
public ListViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ListViewCommandBuilder();
	}
	return builder;
}


public  class ListViewCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <ListViewCommandBuilder> {
    public ListViewCommandBuilder() {
	}
	
	public ListViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ListViewCommandBuilder tryGetDivider() {
	Map<String, Object> attrs = initCommand("divider");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDivider() {
	Map<String, Object> attrs = initCommand("divider");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setDivider(String value) {
	Map<String, Object> attrs = initCommand("divider");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetDividerHeight() {
	Map<String, Object> attrs = initCommand("dividerHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDividerHeight() {
	Map<String, Object> attrs = initCommand("dividerHeight");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setDividerHeight(String value) {
	Map<String, Object> attrs = initCommand("dividerHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setFooterDividersEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("footerDividersEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setHeaderDividersEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("headerDividersEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetCacheColorHint() {
	Map<String, Object> attrs = initCommand("cacheColorHint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getCacheColorHint() {
	Map<String, Object> attrs = initCommand("cacheColorHint");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setCacheColorHint(String value) {
	Map<String, Object> attrs = initCommand("cacheColorHint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetChoiceMode() {
	Map<String, Object> attrs = initCommand("choiceMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getChoiceMode() {
	Map<String, Object> attrs = initCommand("choiceMode");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setChoiceMode(String value) {
	Map<String, Object> attrs = initCommand("choiceMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setDrawSelectorOnTop(boolean value) {
	Map<String, Object> attrs = initCommand("drawSelectorOnTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetFastScrollEnabled() {
	Map<String, Object> attrs = initCommand("fastScrollEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isFastScrollEnabled() {
	Map<String, Object> attrs = initCommand("fastScrollEnabled");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setFastScrollEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("fastScrollEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetScrollingCache() {
	Map<String, Object> attrs = initCommand("scrollingCache");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isScrollingCache() {
	Map<String, Object> attrs = initCommand("scrollingCache");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setScrollingCache(boolean value) {
	Map<String, Object> attrs = initCommand("scrollingCache");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetSmoothScrollbar() {
	Map<String, Object> attrs = initCommand("smoothScrollbar");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isSmoothScrollbar() {
	Map<String, Object> attrs = initCommand("smoothScrollbar");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setSmoothScrollbar(boolean value) {
	Map<String, Object> attrs = initCommand("smoothScrollbar");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetStackFromBottom() {
	Map<String, Object> attrs = initCommand("stackFromBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isStackFromBottom() {
	Map<String, Object> attrs = initCommand("stackFromBottom");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setStackFromBottom(boolean value) {
	Map<String, Object> attrs = initCommand("stackFromBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetTextFilterEnabled() {
	Map<String, Object> attrs = initCommand("textFilterEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isTextFilterEnabled() {
	Map<String, Object> attrs = initCommand("textFilterEnabled");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setTextFilterEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("textFilterEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetTranscriptMode() {
	Map<String, Object> attrs = initCommand("transcriptMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTranscriptMode() {
	Map<String, Object> attrs = initCommand("transcriptMode");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setTranscriptMode(String value) {
	Map<String, Object> attrs = initCommand("transcriptMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setOnScrollChange(String value) {
	Map<String, Object> attrs = initCommand("onScrollChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setOnScrollStateChange(String value) {
	Map<String, Object> attrs = initCommand("onScrollStateChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setOnItemClick(String value) {
	Map<String, Object> attrs = initCommand("onItemClick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setOnItemLongClick(String value) {
	Map<String, Object> attrs = initCommand("onItemLongClick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder tryGetListSelector() {
	Map<String, Object> attrs = initCommand("listSelector");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getListSelector() {
	Map<String, Object> attrs = initCommand("listSelector");
	return attrs.get("commandReturnValue");
}
public ListViewCommandBuilder setListSelector(String value) {
	Map<String, Object> attrs = initCommand("listSelector");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setListheader(String value) {
	Map<String, Object> attrs = initCommand("listheader");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ListViewCommandBuilder setListfooter(String value) {
	Map<String, Object> attrs = initCommand("listfooter");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ListViewBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public ListViewBean() {
			super(ListViewImpl.this);
		}
public Object getDivider() {
	return getBuilder().reset().tryGetDivider().execute(false).getDivider(); 
}
public void setDivider(String value) {
	getBuilder().reset().setDivider(value).execute(true);
}

public Object getDividerHeight() {
	return getBuilder().reset().tryGetDividerHeight().execute(false).getDividerHeight(); 
}
public void setDividerHeight(String value) {
	getBuilder().reset().setDividerHeight(value).execute(true);
}

public void setFooterDividersEnabled(boolean value) {
	getBuilder().reset().setFooterDividersEnabled(value).execute(true);
}

public void setHeaderDividersEnabled(boolean value) {
	getBuilder().reset().setHeaderDividersEnabled(value).execute(true);
}

public Object getCacheColorHint() {
	return getBuilder().reset().tryGetCacheColorHint().execute(false).getCacheColorHint(); 
}
public void setCacheColorHint(String value) {
	getBuilder().reset().setCacheColorHint(value).execute(true);
}

public Object getChoiceMode() {
	return getBuilder().reset().tryGetChoiceMode().execute(false).getChoiceMode(); 
}
public void setChoiceMode(String value) {
	getBuilder().reset().setChoiceMode(value).execute(true);
}

public void setDrawSelectorOnTop(boolean value) {
	getBuilder().reset().setDrawSelectorOnTop(value).execute(true);
}

public Object isFastScrollEnabled() {
	return getBuilder().reset().tryGetFastScrollEnabled().execute(false).isFastScrollEnabled(); 
}
public void setFastScrollEnabled(boolean value) {
	getBuilder().reset().setFastScrollEnabled(value).execute(true);
}

public Object isScrollingCache() {
	return getBuilder().reset().tryGetScrollingCache().execute(false).isScrollingCache(); 
}
public void setScrollingCache(boolean value) {
	getBuilder().reset().setScrollingCache(value).execute(true);
}

public Object isSmoothScrollbar() {
	return getBuilder().reset().tryGetSmoothScrollbar().execute(false).isSmoothScrollbar(); 
}
public void setSmoothScrollbar(boolean value) {
	getBuilder().reset().setSmoothScrollbar(value).execute(true);
}

public Object isStackFromBottom() {
	return getBuilder().reset().tryGetStackFromBottom().execute(false).isStackFromBottom(); 
}
public void setStackFromBottom(boolean value) {
	getBuilder().reset().setStackFromBottom(value).execute(true);
}

public Object isTextFilterEnabled() {
	return getBuilder().reset().tryGetTextFilterEnabled().execute(false).isTextFilterEnabled(); 
}
public void setTextFilterEnabled(boolean value) {
	getBuilder().reset().setTextFilterEnabled(value).execute(true);
}

public Object getTranscriptMode() {
	return getBuilder().reset().tryGetTranscriptMode().execute(false).getTranscriptMode(); 
}
public void setTranscriptMode(String value) {
	getBuilder().reset().setTranscriptMode(value).execute(true);
}

public void setOnScrollChange(String value) {
	getBuilder().reset().setOnScrollChange(value).execute(true);
}

public void setOnScrollStateChange(String value) {
	getBuilder().reset().setOnScrollStateChange(value).execute(true);
}

public void setOnItemClick(String value) {
	getBuilder().reset().setOnItemClick(value).execute(true);
}

public void setOnItemLongClick(String value) {
	getBuilder().reset().setOnItemLongClick(value).execute(true);
}

public Object getListSelector() {
	return getBuilder().reset().tryGetListSelector().execute(false).getListSelector(); 
}
public void setListSelector(String value) {
	getBuilder().reset().setListSelector(value).execute(true);
}

public void setListheader(String value) {
	getBuilder().reset().setListheader(value).execute(true);
}

public void setListfooter(String value) {
	getBuilder().reset().setListfooter(value).execute(true);
}

}


private ListViewCommandParamsBuilder paramsBuilder;
private ListViewParamsBean paramsBean;

public ListViewParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new ListViewParamsBean();
	}
	return paramsBean;
}
public ListViewCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new ListViewCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class ListViewParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class ListViewCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<ListViewCommandParamsBuilder>{
}

	//end - body
	
    private IWidget headerTemplate;
    private IWidget footerTemplate;
    //start - listAdapter
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
    //end - listAdapter
    
    @Override
    public void initialized() {
    	super.initialized();        
        
        if (headerTemplate != null) {
            listView.addHeaderView((View) headerTemplate.loadLazyWidgets((com.ashera.model.LoopParam) null).asWidget());
        }
        
        if (footerTemplate != null) {
            View footerView = (View) footerTemplate.loadLazyWidgets((com.ashera.model.LoopParam)null).asWidget();
            listView.addFooterView(footerView);
        }
    }
    
    
    private void addFooterTemplate(Object objValue) {
        this.footerTemplate = (IWidget) objValue;
    }

    private void addHeaderTemplate(Object objValue) {
        this.headerTemplate = (IWidget) objValue;
    }
    
	private void nativeCreate(Map<String, Object> params) {
        this.listAdapter = new ListAdapter();
        this.listView.setAdapter(listAdapter);
	}

    //start - model
    private boolean disableUpdate = false;
    @Override
    protected void addObject(com.ashera.model.LoopParam childModel, String modelIdPath, int index, String currentLoopVar) {
        String id = null;
        if (modelIdPath != null) {
            id = PluginInvoker.getString(getModelByPath(modelIdPath, childModel.get(currentLoopVar)));
        } else {
            id = UUID.randomUUID().toString();
        }
        
        if (!ids.contains(id)) {
            if (index == -1) {
                ids.add(id);
                dataList.add(childModel);
            } else {
                ids.add(index, id);
                dataList.add(index, childModel);
            }
            
        } else {
            // update the objects on the widget
            dataList.set(ids.indexOf(id), childModel);
        }

        reloadTable();
    }
    
    @Override
    public void addAllModel(Object objValue) {
    	disableUpdate = true;
    	super.addAllModel(objValue);
    	disableUpdate = false;
    	reloadTable();
    }

    @Override
    public boolean remove(int index) {
        if (index + 1 <= ids.size()) {
            ids.remove(index);
        }
        if (index + 1 <= dataList.size()) {
            dataList.remove(index);
        }
        reloadTable();
        return true;
    }

    
    @Override
    public boolean areWidgetItemsRecycled() {
    	return true;
    }

	
	@Override
	public void clear() {
		ids.clear();
		dataList.clear();
		reloadTable();
	}
	
	@Override
	protected void clearModel() {
		ids.clear();
		dataList.clear();
	}
	
	@Override
	public void notifyDataSetChanged() {
		disableUpdate = true;
		super.notifyDataSetChanged();
		disableUpdate = false;
		reloadTable();
	}
	//end - model
	
	//start - event
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
	//end - event
	

    private int updatePosition(java.util.Map<java.lang.String, java.lang.Object> eventMap, int position) {
        if (headerTemplate != null) {
            position--;
            eventMap.put("position", position);
        }
        return position;
    }
    

	private void reloadTable() {
		if (!disableUpdate && listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
	}

	
	private void setListSelector(Object objValue) {
		listView.setSelector((android.graphics.drawable.Drawable) objValue);
	}
	


	private Object getListSelector() {
		return listView.getSelector();
	}

	//start - addCheckItemInfo
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
	//end - addCheckItemInfo
	
	
	private void setOnScrollListener(ListView listView, Object objValue) {
		listView.setOnScrollListener((ListView.OnScrollListener) objValue);
	}
	

	private void setOnItemLongClickListener(ListView listView, Object objValue) {
		listView.setOnItemLongClickListener((ListView.OnItemLongClickListener) objValue);
		
	}

	private void setOnItemClickListener(ListView listView, Object objValue) {
		listView.setOnItemClickListener((ListView.OnItemClickListener) objValue);
		
	}
}
