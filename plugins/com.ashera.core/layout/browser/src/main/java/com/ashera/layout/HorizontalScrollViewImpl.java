package com.ashera.layout;
// start - imports
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

import org.teavm.jso.dom.html.HTMLElement;

import static com.ashera.widget.IWidget.*;
//end - imports

public class HorizontalScrollViewImpl extends BaseHasWidgets {
	//start - body
	private HTMLElement htmlElement;
	public final static String LOCAL_NAME = "HorizontalScrollView"; 
	public final static String GROUP_NAME = "HorizontalScrollView";
	private r.android.widget.HorizontalScrollView horizontalScrollView;
	

	
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundGravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("measureAllChildren").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fillViewport").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollX").withType("dimension").withBufferStrategy(BUFFER_STRATEGY_DURING_INIT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrollChange").withType("string"));
	
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_gravity").withType("gravity").forChild());
	}
	
	public HorizontalScrollViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  HorizontalScrollViewImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  HorizontalScrollViewImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new HorizontalScrollViewImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		horizontalScrollView = new HorizontalScrollViewExt();
		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return horizontalScrollView;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		horizontalScrollView.removeView((View) w.asWidget());
         ViewGroupImpl.nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= horizontalScrollView.getChildCount()) {
            horizontalScrollView.removeViewAt(index);
            ViewGroupImpl.nativeRemoveView(widget);            
        }    
        return remove;
    }
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        horizontalScrollView.addView(view);
			    } else {
			        horizontalScrollView.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		r.android.widget.HorizontalScrollView.LayoutParams layoutParams = (r.android.widget.HorizontalScrollView.LayoutParams) view.getLayoutParams();
		
		layoutParams = (r.android.widget.HorizontalScrollView.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new r.android.widget.HorizontalScrollView.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private r.android.widget.HorizontalScrollView.LayoutParams getLayoutParams(View view) {
		return (r.android.widget.HorizontalScrollView.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		r.android.widget.HorizontalScrollView.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
			break;
			case "layout_gravity": {
				
							layoutParams.gravity = ((int)objValue);
				
			}
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
		r.android.widget.HorizontalScrollView.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
			case "layout_gravity": {
return layoutParams.gravity;			}

		}
		
		return null;

	}
	
		
	public class HorizontalScrollViewExt extends r.android.widget.HorizontalScrollView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public HorizontalScrollViewExt() {
			
			
			
			
			super();
			
			
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
			postOnMeasure(widthMeasureSpec, heightMeasureSpec);
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			ViewImpl.setDrawableBounds(HorizontalScrollViewImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrameForHorizontalScrollView(asNativeWidget(), l, t, r, b, (int) (computeHorizontalScrollRange()));
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(HorizontalScrollViewImpl.this);
			
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
				HorizontalScrollViewImpl.this.invalidate();
			}
		}	
		
		@Override
		public void execute(String method, Object... canvas) {
			
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
        	ViewImpl.drawableStateChanged(HorizontalScrollViewImpl.this);
        }
		@Override
		public void offsetTopAndBottom(int offset) {
			super.offsetTopAndBottom(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
		@Override
		public void offsetLeftAndRight(int offset) {
			super.offsetLeftAndRight(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ((HTMLElement)asNativeWidget()).getStyle().setProperty("display", visibility != View.VISIBLE ? "none" : "block");
            
        }
	}
	
	public void updateMeasuredDimension(int width, int height) {
		((HorizontalScrollViewExt) horizontalScrollView).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "foregroundGravity": {


	horizontalScrollView.setForegroundGravity((int)objValue);



			}
			break;
			case "measureAllChildren": {


	horizontalScrollView.setMeasureAllChildren((boolean)objValue);



			}
			break;
			case "fillViewport": {


	horizontalScrollView.setFillViewport((boolean)objValue);



			}
			break;
			case "scrollX": {


		setScrollX(objValue);



			}
			break;
			case "onScrollChange": {


		 setOnScroll(objValue);



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
			case "measureAllChildren": {
if (Build.VERSION.SDK_INT >= 14) {
return horizontalScrollView.getMeasureAllChildren();
}
break;			}
			case "fillViewport": {
return horizontalScrollView.isFillViewport();			}
			case "scrollX": {
return getScrollX();			}
		}
		return null;
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
    
	

	int thumbHeight = 0;
	private void postOnMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		horizontalScrollView.adjustPaddingIfScrollBarPresent(widthMeasureSpec, heightMeasureSpec, thumbHeight);
	}
	

	@SuppressLint("NewApi")
private static class OnScrollChangeListener implements View.OnScrollChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnScrollChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnScrollChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onScrollChange (View v, 
                int scrollX, 
                int scrollY, 
                int oldScrollX, 
                int oldScrollY){
    
	if (action == null || action.equals("onScrollChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onScrollChange");
	    java.util.Map<String, Object> obj = getOnScrollChangeEventObj(v,scrollX,scrollY,oldScrollX,oldScrollY);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,scrollX,scrollY,oldScrollX,oldScrollY);
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

public java.util.Map<String, Object> getOnScrollChangeEventObj(View v,int scrollX,int scrollY,int oldScrollX,int oldScrollY) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "scrollchange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "scrollX", scrollX);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "scrollY", scrollY);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "oldScrollX", oldScrollX);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "oldScrollY", oldScrollY);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onScrollChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			horizontalScrollView.setId(IdGenerator.getId(id));
		}
	}
	
    

	
private HorizontalScrollViewCommandBuilder builder;
private HorizontalScrollViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public HorizontalScrollViewBean getBean() {
	if (bean == null) {
		bean = new HorizontalScrollViewBean();
	}
	return bean;
}
public HorizontalScrollViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new HorizontalScrollViewCommandBuilder();
	}
	return builder;
}


public  class HorizontalScrollViewCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <HorizontalScrollViewCommandBuilder> {
    public HorizontalScrollViewCommandBuilder() {
	}
	
	public HorizontalScrollViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public HorizontalScrollViewCommandBuilder setForegroundGravity(String value) {
	Map<String, Object> attrs = initCommand("foregroundGravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public HorizontalScrollViewCommandBuilder tryGetMeasureAllChildren() {
	Map<String, Object> attrs = initCommand("measureAllChildren");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isMeasureAllChildren() {
	Map<String, Object> attrs = initCommand("measureAllChildren");
	return attrs.get("commandReturnValue");
}
public HorizontalScrollViewCommandBuilder setMeasureAllChildren(boolean value) {
	Map<String, Object> attrs = initCommand("measureAllChildren");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public HorizontalScrollViewCommandBuilder tryGetFillViewport() {
	Map<String, Object> attrs = initCommand("fillViewport");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isFillViewport() {
	Map<String, Object> attrs = initCommand("fillViewport");
	return attrs.get("commandReturnValue");
}
public HorizontalScrollViewCommandBuilder setFillViewport(boolean value) {
	Map<String, Object> attrs = initCommand("fillViewport");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public HorizontalScrollViewCommandBuilder tryGetScrollX() {
	Map<String, Object> attrs = initCommand("scrollX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getScrollX() {
	Map<String, Object> attrs = initCommand("scrollX");
	return attrs.get("commandReturnValue");
}
public HorizontalScrollViewCommandBuilder setScrollX(String value) {
	Map<String, Object> attrs = initCommand("scrollX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public HorizontalScrollViewCommandBuilder setOnScrollChange(String value) {
	Map<String, Object> attrs = initCommand("onScrollChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class HorizontalScrollViewBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public HorizontalScrollViewBean() {
			super(HorizontalScrollViewImpl.this);
		}
public void setForegroundGravity(String value) {
	getBuilder().reset().setForegroundGravity(value).execute(true);
}

public Object isMeasureAllChildren() {
	return getBuilder().reset().tryGetMeasureAllChildren().execute(false).isMeasureAllChildren(); 
}
public void setMeasureAllChildren(boolean value) {
	getBuilder().reset().setMeasureAllChildren(value).execute(true);
}

public Object isFillViewport() {
	return getBuilder().reset().tryGetFillViewport().execute(false).isFillViewport(); 
}
public void setFillViewport(boolean value) {
	getBuilder().reset().setFillViewport(value).execute(true);
}

public Object getScrollX() {
	return getBuilder().reset().tryGetScrollX().execute(false).getScrollX(); 
}
public void setScrollX(String value) {
	getBuilder().reset().setScrollX(value).execute(true);
}

public void setOnScrollChange(String value) {
	getBuilder().reset().setOnScrollChange(value).execute(true);
}

}


private HorizontalScrollViewCommandParamsBuilder paramsBuilder;
private HorizontalScrollViewParamsBean paramsBean;

public HorizontalScrollViewParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new HorizontalScrollViewParamsBean();
	}
	return paramsBean;
}
public HorizontalScrollViewCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new HorizontalScrollViewCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class HorizontalScrollViewParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
public Object getLayoutGravity(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutGravity().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutGravity();
}
public void setLayoutGravity(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGravity(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

}





public class HorizontalScrollViewCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<HorizontalScrollViewCommandParamsBuilder>{
public HorizontalScrollViewCommandParamsBuilder tryGetLayoutGravity() {
	Map<String, Object> attrs = initCommand("layout_gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGravity() {
	Map<String, Object> attrs = initCommand("layout_gravity");
	return attrs.get("commandReturnValue");
}
public HorizontalScrollViewCommandParamsBuilder setLayoutGravity(String value) {
	Map<String, Object> attrs = initCommand("layout_gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}

	//end - body

	@Override
	public Object asNativeWidget() {
		return htmlElement;
	}
	private void nativeCreate(Map<String, Object> params) {
		htmlElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
		htmlElement.getStyle().setProperty("overflow-x", "auto");
		htmlElement.getStyle().setProperty("overflow-y", "hidden");
		htmlElement.getStyle().setProperty("box-sizing", "border-box");
	}
	
	
	private void setOnScroll(Object objValue) {
		View view = (View) asWidget();
		View.OnScrollChangeListener onScrollChangeListener; 
		
		if (objValue instanceof String) {
			onScrollChangeListener = new OnScrollChangeListener(this, (String) objValue);
		} else {
			onScrollChangeListener = (View.OnScrollChangeListener) objValue;
		}
    	ViewImpl.setOnListener(this, htmlElement, new org.teavm.jso.dom.events.EventListener<org.teavm.jso.dom.events.Event>() {
    	    int oldScrollX = 0;
            @Override
            public void handleEvent(org.teavm.jso.dom.events.Event event) {
                int selection = htmlElement.getScrollLeft();
                onScrollChangeListener.onScrollChange(view, selection, 0, oldScrollX, 0);
                oldScrollX = selection;
            }
    	    
    	}, "scroll", "scroll");
	}
	
	private void setScrollX(Object objValue) {
    	if (!isInitialised()) {
    		 org.teavm.jso.dom.html.HTMLDocument.current().addEventListener("DOMContentLoaded", new org.teavm.jso.dom.events.EventListener<org.teavm.jso.dom.events.Event>() {
				@Override
				public void handleEvent(org.teavm.jso.dom.events.Event evt) {
					htmlElement.setScrollLeft((int) objValue);
				}
    			 
    		 });
    	} else {
			htmlElement.setScrollLeft((int) objValue);
    	}
    }
	
	private Object getScrollX() {
		return htmlElement.getScrollLeft();
	}
	
    @org.teavm.jso.JSBody(params = {}, script = "return window.getScrollbarWidth();")
    private static native int getScrollbarWidth();
    @Override
    public void initialized() {
    	super.initialized();
    	thumbHeight = getScrollbarWidth();
    }
}
