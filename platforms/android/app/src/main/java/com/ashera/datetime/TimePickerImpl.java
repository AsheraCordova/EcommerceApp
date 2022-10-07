package com.ashera.datetime;
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

import android.app.TimePickerDialog;
import android.widget.DatePicker;
import java.text.SimpleDateFormat;
import android.text.*;

public class TimePickerImpl extends BaseHasWidgets implements android.app.TimePickerDialog.OnTimeSetListener, com.ashera.validations.FormElement {
	//start - body
	public final static String LOCAL_NAME = "com.ashera.datetime.TimePicker"; 
	public final static String GROUP_NAME = "com.ashera.datetime.TimePicker";
	private com.ashera.datetime.TimePicker timePicker;
	

	
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("timeFormat").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hint").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onTextChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onbeforeTextChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onafterTextChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("showClearButton").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hintTextFormat").withType("resourcestring").withOrder(-1));
	
	}
	
	public TimePickerImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  TimePickerImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  TimePickerImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new TimePickerImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		timePicker = new TimePickerExt(context);
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
			timePicker = new TimePickerExt(context, null, defStyleAttr);	
		} else {
			timePicker = new TimePickerExt(context, null, defStyleAttr, defStyleRes);
		}
		
	}

		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return timePicker;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		timePicker.removeView((View) w.asWidget());
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= timePicker.getChildCount()) {
            timePicker.removeViewAt(index);
        }    
        return remove;
    }
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        timePicker.addView(view);
			    } else {
			        timePicker.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		com.ashera.datetime.TimePicker.LayoutParams layoutParams = (com.ashera.datetime.TimePicker.LayoutParams) view.getLayoutParams();
		
		layoutParams = (com.ashera.datetime.TimePicker.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new com.ashera.datetime.TimePicker.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private com.ashera.datetime.TimePicker.LayoutParams getLayoutParams(View view) {
		return (com.ashera.datetime.TimePicker.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		com.ashera.datetime.TimePicker.LayoutParams layoutParams = getLayoutParams(view);
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
		com.ashera.datetime.TimePicker.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
		
	public class TimePickerExt extends com.ashera.datetime.TimePicker implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public TimePickerExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

	    public TimePickerExt(Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
	    	super(context, attrs, defStyleAttr, defStyleRes);
	    }
		public TimePickerExt(Context context) {
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
				TimePickerImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(TimePickerImpl.this);
        }
	}
	
	public void updateMeasuredDimension(int width, int height) {
		((TimePickerExt) timePicker).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "timeFormat": {


		 setTimeFormat(objValue);



			}
			break;
			case "hint": {


		 setHint(key, strValue, objValue, decorator);



			}
			break;
			case "text": {


		setMyText(key, strValue, objValue, decorator);



			}
			break;
			case "onTextChange": {


		 setOnTextChange(key, strValue, objValue, decorator);



			}
			break;
			case "onbeforeTextChange": {


		 setBeforeOnTextChange(key, strValue, objValue, decorator);



			}
			break;
			case "onafterTextChange": {


		 setOnAfterTextChange(key, strValue, objValue, decorator);



			}
			break;
			case "showClearButton": {


		 showClearButton(objValue);



			}
			break;
			case "hintTextFormat": {


		setHintTextFormat(objValue);



			}
			break;
		default:
			break;
		}
		postSetAttribute(key, strValue, objValue, decorator);
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
			case "hint": {
return getHint(key, decorator);			}
			case "text": {
return getMyText(key, decorator);			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return timePicker;
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
    
	

	private void setHint(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		editText.setAttribute(key, strValue, objValue, decorator);
	}
	
	private Object getHint(WidgetAttribute key, ILifeCycleDecorator decorator) {
		return editText.getAttribute(key, decorator);
	}
	
	@Override
	public String getTextEntered() {
		if (editText instanceof com.ashera.validations.FormElement) {
			return ((com.ashera.validations.FormElement) editText).getTextEntered();
		}
		return null;
	}

	@Override
	public boolean isViewVisible() {
		return timePicker.getVisibility() == View.VISIBLE;
	}

	@Override
	public void focus() {
		if (editText instanceof com.ashera.validations.FormElement) {
			((com.ashera.validations.FormElement) editText).focus();
		}
	}
	
	
	private void postSetAttribute(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
		switch (key.getAttributeName()) {
		case "validationErrorDisplayType":
			if (editText instanceof com.ashera.validations.FormElement) {
				((com.ashera.validations.FormElement) editText).setValidationErrorDisplayType(getValidationErrorDisplayType());
			}
			break;

		default:
			break;
		}
		
	}
	
	
	private void setMyText(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		editText.setAttribute(key, strValue, objValue, decorator);
	}

	private Object getMyText(WidgetAttribute key, ILifeCycleDecorator decorator) {
		return editText.getAttribute(key, decorator);
	}
	
	
	private void setOnAfterTextChange(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		editText.setAttribute(key, strValue, new TextChangedListener(this, strValue, "onafterTextChange"), decorator);
	}

	private void setBeforeOnTextChange(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		editText.setAttribute(key, strValue, new TextChangedListener(this, strValue, "onbeforeTextChange"), decorator);
		
	}

	private void setOnTextChange(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		editText.setAttribute(key, strValue, new TextChangedListener(this, strValue, "onTextChange"), decorator);
		
	}
	
	private void showClearButton(Object objValue) {
		IWidget clearButton = findWidgetById("@+id/clearButton");
		int visibility = View.VISIBLE;
		
		if ((boolean) objValue) {
			visibility = View.VISIBLE;
		} else {
			visibility = View.GONE;
		}
		
		clearButton.setAttribute(WidgetFactory.getAttribute(clearButton.getLocalName(), "visibility"), visibility, true);
		
	}
	


	private void setError(String message) {
		if (editText.asNativeWidget() instanceof TextView) {
			((TextView) editText.asNativeWidget()).setError(message);
		}	
	}	
	


	@Override
	public void resetError() {
		int validationErrorDisplayType = getValidationErrorDisplayType();
		if ((validationErrorDisplayType & com.ashera.validations.FormElement.ERROR_DISPLAY_TYPE_POPUP) != 0) {
			setError(null);	
		}
		
		if ((validationErrorDisplayType & com.ashera.validations.FormElement.ERROR_DISPLAY_TYPE_LABEL) != 0) {
			ViewImpl.setMessageOnLabel(this, "");	
		}
		
		if ((validationErrorDisplayType & com.ashera.validations.FormElement.ERROR_DISPLAY_TYPE_STYLE) != 0) {
			ViewImpl.setStyle(this, getNormalStyle());
		}
	}

	@Override
	public void showError(String message) {
		int validationErrorDisplayType = getValidationErrorDisplayType();
		if ((validationErrorDisplayType & com.ashera.validations.FormElement.ERROR_DISPLAY_TYPE_POPUP) != 0) {
			setError(message);
		}
		
		if ((validationErrorDisplayType & com.ashera.validations.FormElement.ERROR_DISPLAY_TYPE_LABEL) != 0) {
			ViewImpl.setMessageOnLabel(this, message);
		}
		
		if ((validationErrorDisplayType & com.ashera.validations.FormElement.ERROR_DISPLAY_TYPE_STYLE) != 0) {
			ViewImpl.setStyle(this, getErrorStyle());
		}
	}
	


	private void setHintTextFormat(Object objValue) {
		applyAttributeCommand("hint", CommonConverters.command_textformatter, new String[] {"hintTextFormat"}, true, (String) objValue);
	}
	

	@SuppressLint("NewApi")
private static class TextChangedListener implements TextWatcher, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public TextChangedListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public TextChangedListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void afterTextChanged (Editable s){
    
	if (action == null || action.equals("onafterTextChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onafterTextChange");
	    java.util.Map<String, Object> obj = getOnafterTextChangeEventObj(s);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, s);
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
public void beforeTextChanged (CharSequence s, 
                int start, 
                int count, 
                int after){
    
	if (action == null || action.equals("onbeforeTextChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onbeforeTextChange");
	    java.util.Map<String, Object> obj = getOnbeforeTextChangeEventObj(s,start,count,after);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, s,start,count,after);
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
public void onTextChanged (CharSequence s, 
                int start, 
                int before, 
                int count){
    
	if (action == null || action.equals("onTextChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onTextChange");
	    java.util.Map<String, Object> obj = getOnTextChangeEventObj(s,start,before,count);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, s,start,before,count);
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

public java.util.Map<String, Object> getOnTextChangeEventObj(CharSequence s,int start,int before,int count) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "textchange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "s", String.valueOf(s));
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "start", start);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "before", before);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "count", count);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onTextChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}

public java.util.Map<String, Object> getOnbeforeTextChangeEventObj(CharSequence s,int start,int count,int after) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "beforetextchange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "s", String.valueOf(s));
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "start", start);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "count", count);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "after", after);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onbeforeTextChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}

public java.util.Map<String, Object> getOnafterTextChangeEventObj(Editable s) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "aftertextchange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onafterTextChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			timePicker.setId(IdGenerator.getId(id));
		}
	}
	
    

	
private TimePickerCommandBuilder builder;
private TimePickerBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public TimePickerBean getBean() {
	if (bean == null) {
		bean = new TimePickerBean();
	}
	return bean;
}
public TimePickerCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new TimePickerCommandBuilder();
	}
	return builder;
}


public  class TimePickerCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <TimePickerCommandBuilder> {
    public TimePickerCommandBuilder() {
	}
	
	public TimePickerCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public TimePickerCommandBuilder setTimeFormat(String value) {
	Map<String, Object> attrs = initCommand("timeFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public TimePickerCommandBuilder tryGetHint() {
	Map<String, Object> attrs = initCommand("hint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHint() {
	Map<String, Object> attrs = initCommand("hint");
	return attrs.get("commandReturnValue");
}
public TimePickerCommandBuilder setHint(String value) {
	Map<String, Object> attrs = initCommand("hint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public TimePickerCommandBuilder tryGetText() {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getText() {
	Map<String, Object> attrs = initCommand("text");
	return attrs.get("commandReturnValue");
}
public TimePickerCommandBuilder setText(String value) {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public TimePickerCommandBuilder setOnTextChange(String value) {
	Map<String, Object> attrs = initCommand("onTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public TimePickerCommandBuilder setOnbeforeTextChange(String value) {
	Map<String, Object> attrs = initCommand("onbeforeTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public TimePickerCommandBuilder setOnafterTextChange(String value) {
	Map<String, Object> attrs = initCommand("onafterTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public TimePickerCommandBuilder showClearButton(boolean value) {
	Map<String, Object> attrs = initCommand("showClearButton");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public TimePickerCommandBuilder setHintTextFormat(String value) {
	Map<String, Object> attrs = initCommand("hintTextFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class TimePickerBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public TimePickerBean() {
			super(TimePickerImpl.this);
		}
public void setTimeFormat(String value) {
	getBuilder().reset().setTimeFormat(value).execute(true);
}

public Object getHint() {
	return getBuilder().reset().tryGetHint().execute(false).getHint(); 
}
public void setHint(String value) {
	getBuilder().reset().setHint(value).execute(true);
}

public Object getText() {
	return getBuilder().reset().tryGetText().execute(false).getText(); 
}
public void setText(String value) {
	getBuilder().reset().setText(value).execute(true);
}

public void setOnTextChange(String value) {
	getBuilder().reset().setOnTextChange(value).execute(true);
}

public void setOnbeforeTextChange(String value) {
	getBuilder().reset().setOnbeforeTextChange(value).execute(true);
}

public void setOnafterTextChange(String value) {
	getBuilder().reset().setOnafterTextChange(value).execute(true);
}

public void showClearButton(boolean value) {
	getBuilder().reset().showClearButton(value).execute(true);
}

public void setHintTextFormat(String value) {
	getBuilder().reset().setHintTextFormat(value).execute(true);
}

}


private TimePickerCommandParamsBuilder paramsBuilder;
private TimePickerParamsBean paramsBean;

public TimePickerParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new TimePickerParamsBean();
	}
	return paramsBean;
}
public TimePickerCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new TimePickerCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class TimePickerParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class TimePickerCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<TimePickerCommandParamsBuilder>{
}

	//end - body
	//start - timepicker
	private int hour;
	private int minute;
	private java.text.DateFormat timeFormat;
	private BaseHasWidgets datePickerWidget;
	private final static String DISPLAY_FORMAT = "HH:mm";
	private IWidget editText;

	public void initTimePicker() {
		timeFormat = new SimpleDateFormat(DISPLAY_FORMAT, java.util.Locale.getDefault());
		IWidget pickerTemplate = (IWidget) com.ashera.converter.ConverterFactory.get("template").convertFrom("@layout/timepicker", null, fragment);
		datePickerWidget = (BaseHasWidgets) pickerTemplate.loadLazyWidgets(this);
		editText = datePickerWidget.findWidgetById("@+id/editText");
		
		
		IWidget clearButton = findWidgetById("@+id/clearButton");
		setOnClickListener(clearButton, new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				setTime(-1, -1);;
			}
		});
	}

	private void setTimeFormat(Object objValue) {
		timeFormat = new SimpleDateFormat((String) objValue, java.util.Locale.getDefault());
	}
	private void setNow() {
		Calendar c = Calendar.getInstance();
		setTime(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
	}

	private void setTime(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
		updateText();
	}
	

	private void setTimeFormat(java.text.DateFormat timeFormat) {
		this.timeFormat = timeFormat;
		updateText();
	}
	
	
	private void updateText() {
		if (hour == -1 || minute == -1) {
			editText.setAttribute(WidgetFactory.getAttribute(editText.getLocalName(), "text"), "", true);
		} else {
			Calendar cal = new GregorianCalendar(0,0,0, hour, minute);
			editText.setAttribute(WidgetFactory.getAttribute(editText.getLocalName(), "text"), timeFormat.format(cal.getTime()), true);
		}
	}
	//end - timepicker
	
	protected void showTimePicker() {
		TimePickerDialog timePickerDialog;
		
		timePickerDialog = new TimePickerDialog(
				(Context) fragment.getRootActivity(),
				this,
				hour,
				minute,
				true);
		timePickerDialog.show();
	}

	@Override
	public void onTimeSet(android.widget.TimePicker view, int hour,
			int minute) {
		setTime(hour, minute);
	}

	private void nativeCreate(Map<String, Object> params) {
		initTimePicker();

		IWidget imageButton = datePickerWidget.findWidgetById("@+id/imageButton");
		((View)imageButton.asWidget()).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showTimePicker();
			}
		});
		registerForAttributeCommandChain("hint");
	}

	private void setOnClickListener(IWidget clearButton, OnClickListener onClickListener) {
		((View)clearButton.asWidget()).setOnClickListener(onClickListener);
		
	}
}
