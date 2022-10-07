package com.ashera.iqkeyboardmanager;
//start - imports
import java.util.*;

import r.android.content.Context;
import r.android.os.Build;
import r.android.view.View;
import r.android.annotation.SuppressLint;
import r.android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;

/*-[
#include <UIKit/UIKit.h>
#include "ASUIView.h"
]-*/
import com.google.j2objc.annotations.Property;
import androidx.core.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports
/*-[
#import "IQUIView+IQKeyboardToolbar.h"
#import "IQUIView+Hierarchy.h"
#import "IQKeyboardManager.h"
#import "ASUITextField.h"
#import "ASUITextView.h"
]-*/
import r.android.widget.TextView;
import r.android.view.KeyEvent;
import com.ashera.layout.ViewImpl;

public class IQkeyboardManagerImpl implements com.ashera.widget.IAttributable {
	// start - body
	public final static String LOCAL_NAME = "IQkeyboardManager"; 
	private IWidget w;
	private IQkeyboardManagerImpl(IWidget widget) {
		this.w = widget;
	}
	
	public String getLocalName() {
		return LOCAL_NAME;
	}
	
	public IQkeyboardManagerImpl() {
	}
	
	@Override
	public com.ashera.widget.IAttributable newInstance(IWidget widget) {
		IQkeyboardManagerImpl newIntance = new IQkeyboardManagerImpl(widget);
		widget.getFragment().addListener(widget, newIntance);
		return newIntance;
	}
	
	
	@SuppressLint("NewApi")
	@Override
	public void loadAttributes(String localName) {

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nextFocusDown").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nextFocusUp").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onEditorAction").withType("string"));
	}

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		Object nativeWidget = w.asNativeWidget();
		switch (key.getAttributeName()) {
		case "nextFocusDown": {


		 setNextFocusDown(strValue, objValue);



			}
			break;
		case "nextFocusUp": {


		 setNextFocusUp(strValue, objValue);



			}
			break;
		case "onEditorAction": {


		 setOnEditorAction(objValue);



			}
			break;
		default:
			break;
		}
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		Object nativeWidget = w.asNativeWidget();
		switch (key.getAttributeName()) {
		}
		return null;
	}
	
	
	@SuppressLint("NewApi")
private static class OnEditorActionListener implements TextView.OnEditorActionListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnEditorActionListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnEditorActionListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onEditorAction (TextView v, 
                int actionId, 
                KeyEvent event){
    boolean result = true;
    
	if (action == null || action.equals("onEditorAction")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onEditorAction");
	    java.util.Map<String, Object> obj = getOnEditorActionEventObj(v,actionId,event);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,actionId,event);
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

public java.util.Map<String, Object> getOnEditorActionEventObj(TextView v,int actionId,KeyEvent event) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "editoraction");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "actionId", actionId);
        ViewImpl.addEventInfo(obj, event);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onEditorAction", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	
private IQkeyboardManagerCommandBuilder builder;
private IQkeyboardManagerBean bean;
public IQkeyboardManagerBean getBean() {
	if (bean == null) {
		bean = new IQkeyboardManagerBean();
	}
	return bean;
}
public IQkeyboardManagerCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new IQkeyboardManagerCommandBuilder();
	}
	return builder;
}


public  class IQkeyboardManagerCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <IQkeyboardManagerCommandBuilder> {
    public IQkeyboardManagerCommandBuilder() {
	}
	
	public IQkeyboardManagerCommandBuilder execute(boolean setter) {
		if (setter) {
			w.executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			w.getFragment().remeasure();
		}
		w.executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public IQkeyboardManagerCommandBuilder setNextFocusDown(String value) {
	Map<String, Object> attrs = initCommand("nextFocusDown");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public IQkeyboardManagerCommandBuilder setNextFocusUp(String value) {
	Map<String, Object> attrs = initCommand("nextFocusUp");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public IQkeyboardManagerCommandBuilder setOnEditorAction(String value) {
	Map<String, Object> attrs = initCommand("onEditorAction");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class IQkeyboardManagerBean extends com.ashera.layout.ViewImpl.ViewBean{
		public IQkeyboardManagerBean() {
			super(IQkeyboardManagerImpl.this.w);
		}
public void setNextFocusDown(String value) {
	getBuilder().reset().setNextFocusDown(value).execute(true);
}

public void setNextFocusUp(String value) {
	getBuilder().reset().setNextFocusUp(value).execute(true);
}

public void setOnEditorAction(String value) {
	getBuilder().reset().setOnEditorAction(value).execute(true);
}

}


	// end - body

	private String nextFocusUpId;
	private String nextFocusDownId;
	private boolean listenerAdded;
	private String editorAction;

	
	
	private void setOnEditorAction(Object objValue) {
		this.editorAction = (String) objValue;
		addKeyboardListener();
	}
	private void setNextFocusUp(String strValue, Object objValue) {
		this.nextFocusUpId = strValue;
		addKeyboardListener();
	}

	private void setNextFocusDown(String strValue, Object objValue) {
		this.nextFocusDownId = strValue;
		addKeyboardListener();
	}

	private native void nativeAddPreviousNextDoneOnKeyboardWithTarget(Object view) /*-[
		[self addPreviousNextDoneOnKeyboardWithTarget: (UIView*)view];
	]-*/;

	private void forceFocusOnView(String strValue) {
		if (strValue != null) {
			IWidget widget = w.getParent().findNearestView(strValue);
			if (widget != null) {
				nativeForceFocus(widget.asNativeWidget());
			}
		}
	}
	
	private void forceFocusOnViewUp() {
		forceFocusOnView(nextFocusUpId);
	}
	
	private void forceFocusOnViewDown() {
		forceFocusOnView(nextFocusDownId);
	}

	private void addKeyboardListener() {
		if (!listenerAdded) {
			Object view = findEditableTextField(w.asNativeWidget());
			if (view != null) {
				nativeAddPreviousNextDoneOnKeyboardWithTarget(view);
				listenerAdded = true;
			}
		}
	}
	
	
	private native Object findEditableTextField(Object view) /*-[
		if ([view isKindOfClass:[ASUITextField class]] || [view isKindOfClass:[ASUITextView class]]) {
	    	return view;
	  	}
	  
	  	for (UIView *subview in ((UIView*)view).subviews) {
	    	UIView* uiview = [self findEditableTextFieldWithId: subview];
	    	if (uiview != nil) {
	      		return uiview;
	    	}
	  	}
		return nil;
	]-*/;

	private native void nativeForceFocus(Object view) /*-[
		if ([view respondsToSelector:@selector(becomeFirstResponder)]) {
			[view becomeFirstResponder];
		}
	]-*/;
	
	private native void nativeLooseFocus(Object view) /*-[
		if ([view respondsToSelector:@selector(resignFirstResponder)]) {
			[view resignFirstResponder];
		}
	]-*/;
	
	private void handleEditorAction() {
		Object view = w.asWidget();
		if (editorAction != null) {
			if (view instanceof TextView) {
				OnEditorActionListener onClickListener = new OnEditorActionListener(w, editorAction);
				onClickListener.onEditorAction((TextView) view, 0, new r.android.view.KeyEvent());
			}
		} else {
			nativeLooseFocus(w.asNativeWidget());
		}
	}
	
	/*-[
	
	-(void)addPreviousNextDoneOnKeyboardWithTarget:(UIView*)view {
		[view addPreviousNextDoneOnKeyboardWithTarget:self previousAction:@selector(previousAction:) nextAction:@selector(nextAction:) doneAction:@selector(doneAction:)];
	}

	-(void)previousAction:(UIBarButtonItem*)button
	{
	     if (nextFocusUpId_ != nil) {
	    	[self forceFocusOnViewUp];
	     } else {
        	if ([[IQKeyboardManager sharedManager] canGoPrevious]) {
            	[[IQKeyboardManager sharedManager] goPrevious];
        	}
    	}
	}

	-(void)nextAction:(UIBarButtonItem*)button
	{
		if (nextFocusDownId_ != nil) {
			[self forceFocusOnViewDown];
		} else {
			if ([[IQKeyboardManager sharedManager] canGoNext]) {
           		[[IQKeyboardManager sharedManager] goNext];
       		}
		}
	}

	-(void)doneAction:(UIBarButtonItem*)doneButton
	{
	    //doneAction
	    [self handleEditorAction];
	}
	]-*/

}
