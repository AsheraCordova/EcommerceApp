package com.ashera.toolbar;
//start - imports
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

import androidx.appcompat.widget.Toolbar;
import android.graphics.drawable.Drawable;

@SuppressLint("NewApi")
public class ToolbarImpl extends BaseHasWidgets {
	//start - body
	public final static String LOCAL_NAME = "androidx.appcompat.widget.Toolbar"; 
	public final static String GROUP_NAME = "androidx.appcompat.widget.Toolbar";
	private androidx.appcompat.widget.Toolbar toolbar;
	

	
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("title").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("subtitle").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("titleMargin").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("titleMarginStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("titleMarginEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("titleMarginTop").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("titleMarginBottom").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("titleMargins").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contentInsetStart").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contentInsetEnd").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contentInsetLeft").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contentInsetRight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contentInsetStartWithNavigation").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contentInsetEndWithActions").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxButtonHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("buttonGravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("collapseIcon").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("collapseContentDescription").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("navigationIcon").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("navigationContentDescription").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("logo").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("logoDescription").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("titleTextColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("subtitleTextColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("menu").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onNavigationIconClick").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("overflowIcon").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onMenuItemClick").withType("string"));
	
	}
	
	public ToolbarImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  ToolbarImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  ToolbarImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new ToolbarImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		toolbar = new ToolbarExt(context);
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
			toolbar = new ToolbarExt(context, null, defStyleAttr);	
		} else {
		}
		
	}

		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return toolbar;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		toolbar.removeView((View) w.asWidget());
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= toolbar.getChildCount()) {
            toolbar.removeViewAt(index);
        }    
        return remove;
    }
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        toolbar.addView(view);
			    } else {
			        toolbar.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		androidx.appcompat.widget.Toolbar.LayoutParams layoutParams = (androidx.appcompat.widget.Toolbar.LayoutParams) view.getLayoutParams();
		
		layoutParams = (androidx.appcompat.widget.Toolbar.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new androidx.appcompat.widget.Toolbar.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private androidx.appcompat.widget.Toolbar.LayoutParams getLayoutParams(View view) {
		return (androidx.appcompat.widget.Toolbar.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		androidx.appcompat.widget.Toolbar.LayoutParams layoutParams = getLayoutParams(view);
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
		androidx.appcompat.widget.Toolbar.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
		
	public class ToolbarExt extends androidx.appcompat.widget.Toolbar implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public ToolbarExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public ToolbarExt(Context context) {
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
				ToolbarImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(ToolbarImpl.this);
        }
	}
	
	public void updateMeasuredDimension(int width, int height) {
		((ToolbarExt) toolbar).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "title": {


	toolbar.setTitle((CharSequence)objValue);



			}
			break;
			case "subtitle": {


	toolbar.setSubtitle((CharSequence)objValue);



			}
			break;
			case "gravity": {


		setGravity(objValue);



			}
			break;
			case "titleMargin": {


		setTitleMargin(objValue);



			}
			break;
			case "titleMarginStart": {


	toolbar.setTitleMarginStart((int)objValue);



			}
			break;
			case "titleMarginEnd": {


	toolbar.setTitleMarginEnd((int)objValue);



			}
			break;
			case "titleMarginTop": {


	toolbar.setTitleMarginTop((int)objValue);



			}
			break;
			case "titleMarginBottom": {


	toolbar.setTitleMarginBottom((int)objValue);



			}
			break;
			case "titleMargins": {


		setTitleMargin(objValue);



			}
			break;
			case "contentInsetStart": {


		setContentInsetStart(objValue);



			}
			break;
			case "contentInsetEnd": {


		setContentInsetEnd(objValue);



			}
			break;
			case "contentInsetLeft": {


		setContentInsetStart(objValue);



			}
			break;
			case "contentInsetRight": {


		setContentInsetEnd(objValue);



			}
			break;
			case "contentInsetStartWithNavigation": {


	toolbar.setContentInsetStartWithNavigation((int)objValue);



			}
			break;
			case "contentInsetEndWithActions": {


	toolbar.setContentInsetEndWithActions((int)objValue);



			}
			break;
			case "maxButtonHeight": {


		setMaxButtonHeight(objValue);



			}
			break;
			case "buttonGravity": {


		setButtonGravity(objValue);



			}
			break;
			case "collapseIcon": {


	toolbar.setCollapseIcon((Drawable)objValue);



			}
			break;
			case "collapseContentDescription": {


	toolbar.setCollapseContentDescription((CharSequence)objValue);



			}
			break;
			case "navigationIcon": {


	toolbar.setNavigationIcon((Drawable)objValue);



			}
			break;
			case "navigationContentDescription": {


	toolbar.setNavigationContentDescription((CharSequence)objValue);



			}
			break;
			case "logo": {


	toolbar.setLogo((Drawable)objValue);



			}
			break;
			case "logoDescription": {


	toolbar.setLogoDescription((String)objValue);



			}
			break;
			case "titleTextColor": {


	toolbar.setTitleTextColor((int)objValue);



			}
			break;
			case "subtitleTextColor": {


	toolbar.setSubtitleTextColor((int)objValue);



			}
			break;
			case "menu": {


		setMenu(objValue);



			}
			break;
			case "onNavigationIconClick": {


		toolbar.setNavigationOnClickListener(new OnClickListener(this, strValue));



			}
			break;
			case "overflowIcon": {


	toolbar.setOverflowIcon((Drawable)objValue);



			}
			break;
			case "onMenuItemClick": {


		toolbar.setOnMenuItemClickListener(new OnMenuItemClickListener(this, strValue, "onMenuItemClick"));



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
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return toolbar;
    }
    private void nativeCreate(Map<String, Object> params) {
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
private static class OnClickListener implements View.OnClickListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnClickListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnClickListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onClick(View v){
    
	if (action == null || action.equals("onClick")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onClick");
	    java.util.Map<String, Object> obj = getOnClickEventObj(v);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v);
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

public java.util.Map<String, Object> getOnClickEventObj(View v) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "click");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onClick", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnMenuItemClickListener implements Toolbar.OnMenuItemClickListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnMenuItemClickListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnMenuItemClickListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onMenuItemClick(MenuItem item){
    boolean result = true;
    
	if (action == null || action.equals("onMenuItemClick")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onMenuItemClick");
	    java.util.Map<String, Object> obj = getOnMenuItemClickEventObj(item);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, item);
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

public java.util.Map<String, Object> getOnMenuItemClickEventObj(MenuItem item) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "menuitemclick");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, item, w.getFragment());
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onMenuItemClick", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			toolbar.setId(IdGenerator.getId(id));
		}
	}
	
    

	
private ToolbarCommandBuilder builder;
private ToolbarBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ToolbarBean getBean() {
	if (bean == null) {
		bean = new ToolbarBean();
	}
	return bean;
}
public ToolbarCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ToolbarCommandBuilder();
	}
	return builder;
}


public  class ToolbarCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <ToolbarCommandBuilder> {
    public ToolbarCommandBuilder() {
	}
	
	public ToolbarCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ToolbarCommandBuilder setTitle(String value) {
	Map<String, Object> attrs = initCommand("title");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setSubtitle(String value) {
	Map<String, Object> attrs = initCommand("subtitle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setTitleMargin(String value) {
	Map<String, Object> attrs = initCommand("titleMargin");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setTitleMarginStart(String value) {
	Map<String, Object> attrs = initCommand("titleMarginStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setTitleMarginEnd(String value) {
	Map<String, Object> attrs = initCommand("titleMarginEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setTitleMarginTop(String value) {
	Map<String, Object> attrs = initCommand("titleMarginTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setTitleMarginBottom(String value) {
	Map<String, Object> attrs = initCommand("titleMarginBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setTitleMargins(String value) {
	Map<String, Object> attrs = initCommand("titleMargins");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setContentInsetStart(String value) {
	Map<String, Object> attrs = initCommand("contentInsetStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setContentInsetEnd(String value) {
	Map<String, Object> attrs = initCommand("contentInsetEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setContentInsetLeft(String value) {
	Map<String, Object> attrs = initCommand("contentInsetLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setContentInsetRight(String value) {
	Map<String, Object> attrs = initCommand("contentInsetRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setContentInsetStartWithNavigation(String value) {
	Map<String, Object> attrs = initCommand("contentInsetStartWithNavigation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setContentInsetEndWithActions(String value) {
	Map<String, Object> attrs = initCommand("contentInsetEndWithActions");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setMaxButtonHeight(String value) {
	Map<String, Object> attrs = initCommand("maxButtonHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setButtonGravity(String value) {
	Map<String, Object> attrs = initCommand("buttonGravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setCollapseIcon(String value) {
	Map<String, Object> attrs = initCommand("collapseIcon");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setCollapseContentDescription(String value) {
	Map<String, Object> attrs = initCommand("collapseContentDescription");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setNavigationIcon(String value) {
	Map<String, Object> attrs = initCommand("navigationIcon");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setNavigationContentDescription(String value) {
	Map<String, Object> attrs = initCommand("navigationContentDescription");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setLogo(String value) {
	Map<String, Object> attrs = initCommand("logo");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setLogoDescription(String value) {
	Map<String, Object> attrs = initCommand("logoDescription");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setTitleTextColor(String value) {
	Map<String, Object> attrs = initCommand("titleTextColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setSubtitleTextColor(String value) {
	Map<String, Object> attrs = initCommand("subtitleTextColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setMenu(String value) {
	Map<String, Object> attrs = initCommand("menu");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setOnNavigationIconClick(String value) {
	Map<String, Object> attrs = initCommand("onNavigationIconClick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setOverflowIcon(String value) {
	Map<String, Object> attrs = initCommand("overflowIcon");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ToolbarCommandBuilder setOnMenuItemClick(String value) {
	Map<String, Object> attrs = initCommand("onMenuItemClick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ToolbarBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public ToolbarBean() {
			super(ToolbarImpl.this);
		}
public void setTitle(String value) {
	getBuilder().reset().setTitle(value).execute(true);
}

public void setSubtitle(String value) {
	getBuilder().reset().setSubtitle(value).execute(true);
}

public void setGravity(String value) {
	getBuilder().reset().setGravity(value).execute(true);
}

public void setTitleMargin(String value) {
	getBuilder().reset().setTitleMargin(value).execute(true);
}

public void setTitleMarginStart(String value) {
	getBuilder().reset().setTitleMarginStart(value).execute(true);
}

public void setTitleMarginEnd(String value) {
	getBuilder().reset().setTitleMarginEnd(value).execute(true);
}

public void setTitleMarginTop(String value) {
	getBuilder().reset().setTitleMarginTop(value).execute(true);
}

public void setTitleMarginBottom(String value) {
	getBuilder().reset().setTitleMarginBottom(value).execute(true);
}

public void setTitleMargins(String value) {
	getBuilder().reset().setTitleMargins(value).execute(true);
}

public void setContentInsetStart(String value) {
	getBuilder().reset().setContentInsetStart(value).execute(true);
}

public void setContentInsetEnd(String value) {
	getBuilder().reset().setContentInsetEnd(value).execute(true);
}

public void setContentInsetLeft(String value) {
	getBuilder().reset().setContentInsetLeft(value).execute(true);
}

public void setContentInsetRight(String value) {
	getBuilder().reset().setContentInsetRight(value).execute(true);
}

public void setContentInsetStartWithNavigation(String value) {
	getBuilder().reset().setContentInsetStartWithNavigation(value).execute(true);
}

public void setContentInsetEndWithActions(String value) {
	getBuilder().reset().setContentInsetEndWithActions(value).execute(true);
}

public void setMaxButtonHeight(String value) {
	getBuilder().reset().setMaxButtonHeight(value).execute(true);
}

public void setButtonGravity(String value) {
	getBuilder().reset().setButtonGravity(value).execute(true);
}

public void setCollapseIcon(String value) {
	getBuilder().reset().setCollapseIcon(value).execute(true);
}

public void setCollapseContentDescription(String value) {
	getBuilder().reset().setCollapseContentDescription(value).execute(true);
}

public void setNavigationIcon(String value) {
	getBuilder().reset().setNavigationIcon(value).execute(true);
}

public void setNavigationContentDescription(String value) {
	getBuilder().reset().setNavigationContentDescription(value).execute(true);
}

public void setLogo(String value) {
	getBuilder().reset().setLogo(value).execute(true);
}

public void setLogoDescription(String value) {
	getBuilder().reset().setLogoDescription(value).execute(true);
}

public void setTitleTextColor(String value) {
	getBuilder().reset().setTitleTextColor(value).execute(true);
}

public void setSubtitleTextColor(String value) {
	getBuilder().reset().setSubtitleTextColor(value).execute(true);
}

public void setMenu(String value) {
	getBuilder().reset().setMenu(value).execute(true);
}

public void setOnNavigationIconClick(String value) {
	getBuilder().reset().setOnNavigationIconClick(value).execute(true);
}

public void setOverflowIcon(String value) {
	getBuilder().reset().setOverflowIcon(value).execute(true);
}

public void setOnMenuItemClick(String value) {
	getBuilder().reset().setOnMenuItemClick(value).execute(true);
}

}


private ToolbarCommandParamsBuilder paramsBuilder;
private ToolbarParamsBean paramsBean;

public ToolbarParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new ToolbarParamsBean();
	}
	return paramsBean;
}
public ToolbarCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new ToolbarCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class ToolbarParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class ToolbarCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<ToolbarCommandParamsBuilder>{
}

	//end - body


	private void setMenu(Object objValue) {
		com.ashera.core.IActivity activity = fragment.getRootActivity();
		androidx.fragment.app.FragmentActivity fragmentActivity = (androidx.fragment.app.FragmentActivity) activity;
		toolbar.getMenu().clear();
		toolbar.inflateMenu(toolbar.getResources().getIdentifier((String) objValue, "menu", fragmentActivity.getPackageName()));
	}
	
	//start - toolbar
	private void setContentInsetEnd(Object objValue) {
		toolbar.setContentInsetsRelative(toolbar.getContentInsetStart(), (int) objValue);
	}

	private void setContentInsetStart(Object objValue) {
		toolbar.setContentInsetsRelative((int) objValue, toolbar.getContentInsetEnd());
	}
	
	
	private void setTitleMargin(Object objValue) {
		toolbar.setTitleMargin((int) objValue, (int) objValue, (int) objValue, (int) objValue);
		
	}
	//end - toolbar


	private void setGravity(Object objValue) {
		setFieldUsingReflection(toolbar, "mGravity", objValue);
	}
	
	private void setButtonGravity(Object objValue) {
		setFieldUsingReflection(toolbar, "mButtonGravity", objValue);
	}

	private void setMaxButtonHeight(Object objValue) {
		setFieldUsingReflection(toolbar, "mMaxButtonHeight", objValue);
	}
}
