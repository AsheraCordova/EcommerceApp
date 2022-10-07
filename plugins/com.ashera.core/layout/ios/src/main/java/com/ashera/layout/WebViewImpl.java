package com.ashera.layout;
//start - imports

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import r.android.content.Context;



import r.android.os.Build;
import r.android.view.View;
import r.android.text.*;

import com.ashera.core.IFragment;
import com.ashera.converter.*;

import r.android.annotation.SuppressLint;

import com.ashera.layout.*;
import com.ashera.plugin.*;
import com.ashera.widget.bus.*;
import com.ashera.widget.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.IWidgetLifeCycleListener.EventId;
import com.ashera.widget.IWidgetLifeCycleListener.EventId.*;

/*-[
#include "java/lang/Integer.h"
#include "java/lang/Float.h"
#include "java/lang/Boolean.h"
#include <UIKit/UIKit.h>
#include "HasLifeCycleDecorators.h"
]-*/

import com.google.j2objc.annotations.Property;

import static com.ashera.widget.IWidget.*;
//end - imports

/*-[
#include "ASWKWebView.h"
#include "signal_recovery.h"
]-*/
@SuppressLint("NewApi")
public class WebViewImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "WebView"; 
	public final static String GROUP_NAME = "WebView";

	protected @Property Object uiView;
	protected MeasurableViewGroup measurableViewGroup;		
	
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("loadUrl").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onPageStarted").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onPageFinished").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onReceivedError").withType("string"));
	}
	
	public WebViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

@com.google.j2objc.annotations.WeakOuter		
	public class WebViewExt extends MeasurableViewGroup implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public WebViewExt() {
			
			
			
			super(WebViewImpl.this);
			
			
			
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
			ViewImpl.setDrawableBounds(WebViewImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(WebViewImpl.this);
			
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
				WebViewImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(WebViewImpl.this);
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
            ViewImpl.nativeSetVisibility(asNativeWidget(), visibility != View.VISIBLE);
            
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
		((WebViewExt) measurableViewGroup).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new WebViewImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableViewGroup = new WebViewExt();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
		setWidgetOnNativeClass();
	}
	private native void setWidgetOnNativeClass() /*-[
		((ASWKWebView*) self.uiView).widget = self;
	]-*/;

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "loadUrl": {
				


		loadUrl(objValue);



			}
			break;
			case "onPageStarted": {
				


		setWebViewLoadingListener(new WebViewLoadingListener(this, strValue, "onPageStarted"));



			}
			break;
			case "onPageFinished": {
				


		setWebViewLoadedListener(new WebViewLoadedListener(this, strValue, "onPageFinished"));



			}
			break;
			case "onReceivedError": {
				


		setWebViewErrorListener(new WebViewErrorListener(this, strValue, "onReceivedError"));



			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		Object attributeValue = ViewImpl.getAttribute(this, nativeWidget, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		switch (key.getAttributeName()) {
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return measurableViewGroup;
	}

	

	static class Loader {
		interface WebViewLoadingListener {
			public void onPageStarted(View view);
		}
		
		interface WebViewLoadedListener {
			public void onPageFinished(View view);			
		}
		
		interface WebViewErrorListener {
			public void onReceivedError(View view, String error);			
		}
	}
	
	private Loader.WebViewLoadingListener webviewLoadingListener;
	private Loader.WebViewLoadedListener webviewLoadedListener;
	private Loader.WebViewErrorListener webviewErrorListener;
	private void setWebViewLoadedListener(WebViewLoadedListener webviewLoadedListener) {
		this.webviewLoadedListener = webviewLoadedListener;
	}
	
	private void setWebViewErrorListener(WebViewErrorListener webviewErrorListener) {
		this.webviewErrorListener = webviewErrorListener;
	}

	private void setWebViewLoadingListener(WebViewLoadingListener webviewLoadingListener) {
		this.webviewLoadingListener = webviewLoadingListener;
		
	}
	private boolean pageFinished = false;
	private void onPageFinished(View view) {
		if (!pageFinished && webviewLoadedListener != null) {
			pageFinished = true;
        	try {
				webviewLoadedListener.onPageFinished(view);
			} catch (Exception e) {
				// ignore any exception
			}
        }
	}
	private void onPageStarted(View view) {
		if (webviewLoadingListener != null) {
			webviewLoadingListener.onPageStarted(view);
		}
	}
	
	private void onReceivedError(View view, String error) {
		if (webviewErrorListener != null) {
			webviewErrorListener.onReceivedError(view, error);
		}
	}
	
	

	@SuppressLint("NewApi")
private static class WebViewLoadingListener implements Loader.WebViewLoadingListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public WebViewLoadingListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public WebViewLoadingListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onPageStarted(View view){
    
	if (action == null || action.equals("onPageStarted")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onPageStarted");
	    java.util.Map<String, Object> obj = getOnPageStartedEventObj(view);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, view);
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

public java.util.Map<String, Object> getOnPageStartedEventObj(View view) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "pagestarted");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onPageStarted", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class WebViewLoadedListener implements Loader.WebViewLoadedListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public WebViewLoadedListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public WebViewLoadedListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onPageFinished(View view){
    
	if (action == null || action.equals("onPageFinished")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onPageFinished");
	    java.util.Map<String, Object> obj = getOnPageFinishedEventObj(view);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, view);
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

public java.util.Map<String, Object> getOnPageFinishedEventObj(View view) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "pagefinished");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onPageFinished", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class WebViewErrorListener implements Loader.WebViewErrorListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public WebViewErrorListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public WebViewErrorListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onReceivedError(View view, String error){
    
	if (action == null || action.equals("onReceivedError")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onReceivedError");
	    java.util.Map<String, Object> obj = getOnReceivedErrorEventObj(view,error);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, view,error);
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

public java.util.Map<String, Object> getOnReceivedErrorEventObj(View view,String error) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "receivederror");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "error", error);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onReceivedError", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	
		@Override
	    public Object asNativeWidget() {
	        return uiView;
	    }
	    public native boolean checkIosVersion(String v) /*-[
			return ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedDescending);
		]-*/;
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			measurableViewGroup.setId(IdGenerator.getId(id));
		}
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
    
	
private WebViewCommandBuilder builder;
private WebViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public WebViewBean getBean() {
	if (bean == null) {
		bean = new WebViewBean();
	}
	return bean;
}
public WebViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new WebViewCommandBuilder();
	}
	return builder;
}


public  class WebViewCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <WebViewCommandBuilder> {
    public WebViewCommandBuilder() {
	}
	
	public WebViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public WebViewCommandBuilder loadUrl(String value) {
	Map<String, Object> attrs = initCommand("loadUrl");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public WebViewCommandBuilder setOnPageStarted(String value) {
	Map<String, Object> attrs = initCommand("onPageStarted");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public WebViewCommandBuilder setOnPageFinished(String value) {
	Map<String, Object> attrs = initCommand("onPageFinished");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public WebViewCommandBuilder setOnReceivedError(String value) {
	Map<String, Object> attrs = initCommand("onReceivedError");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class WebViewBean extends com.ashera.layout.ViewImpl.ViewBean{
		public WebViewBean() {
			super(WebViewImpl.this);
		}
public void loadUrl(String value) {
	getBuilder().reset().loadUrl(value).execute(true);
}

public void setOnPageStarted(String value) {
	getBuilder().reset().setOnPageStarted(value).execute(true);
}

public void setOnPageFinished(String value) {
	getBuilder().reset().setOnPageFinished(value).execute(true);
}

public void setOnReceivedError(String value) {
	getBuilder().reset().setOnReceivedError(value).execute(true);
}

}


    
	//end - body
/*-[
- (void)webView:(WKWebView *)webView didFinishNavigation:(WKNavigation *)navigation {
  signal_catch_init();
  signal_try(1) {
  	[self onPageFinishedWithADView: measurableViewGroup_];
  }
  signal_catch(1) {
  	// do nothing
  }
  signal_end(1)
}

- (void)webView:(WKWebView *)webView didFailProvisionalNavigation:(WKNavigation *)navigation withError:(NSError *)error {
    [self onReceivedErrorWithADView:measurableViewGroup_ withNSString:[error localizedDescription]];
  	[self onPageFinishedWithADView: measurableViewGroup_];
}
- (void)webView:(WKWebView *)webView didStartProvisionalNavigation:(WKNavigation *)navigation {
    [self onPageStartedWithADView: measurableViewGroup_];
}

]-*/
	public native void nativeCreate(Map<String, Object> params)/*-[
		ASWKWebView* uiView = [ASWKWebView new];
		uiView.navigationDelegate = self;
		uiView.backgroundColor = [UIColor clearColor];
		uiView_ = uiView;
	]-*/;
	
	private native void loadUrl(Object objValue)  /*-[
    	NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:(NSString*) objValue]];
		[((ASWKWebView*)self->uiView_) loadRequest: request];
	]-*/;
}
