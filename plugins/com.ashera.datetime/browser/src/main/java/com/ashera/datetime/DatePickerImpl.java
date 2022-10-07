package com.ashera.datetime;
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
import java.text.SimpleDateFormat;
import r.android.text.*;

public class DatePickerImpl extends BaseHasWidgets implements com.ashera.validations.FormElement {
	//start - body
	private HTMLElement htmlElement;
	public final static String LOCAL_NAME = "com.ashera.datetime.DatePicker"; 
	public final static String GROUP_NAME = "com.ashera.datetime.DatePicker";
	private com.ashera.datetime.DatePicker datePicker;
	

	
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onTextChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onbeforeTextChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onafterTextChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dateFormat").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hint").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minDateToday").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxDateToday").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("showClearButton").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hintTextFormat").withType("resourcestring").withOrder(-1));
	
	}
	
	public DatePickerImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  DatePickerImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  DatePickerImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new DatePickerImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		datePicker = new DatePickerExt();
		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return datePicker;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		datePicker.removeView((View) w.asWidget());
         ViewGroupImpl.nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= datePicker.getChildCount()) {
            datePicker.removeViewAt(index);
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
			        datePicker.addView(view);
			    } else {
			        datePicker.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		com.ashera.datetime.DatePicker.LayoutParams layoutParams = (com.ashera.datetime.DatePicker.LayoutParams) view.getLayoutParams();
		
		layoutParams = (com.ashera.datetime.DatePicker.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new com.ashera.datetime.DatePicker.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private com.ashera.datetime.DatePicker.LayoutParams getLayoutParams(View view) {
		return (com.ashera.datetime.DatePicker.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		com.ashera.datetime.DatePicker.LayoutParams layoutParams = getLayoutParams(view);
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
		com.ashera.datetime.DatePicker.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
		}
		
		return null;

	}
	
		
	public class DatePickerExt extends com.ashera.datetime.DatePicker implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public DatePickerExt() {
			
			
			
			
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
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			ViewImpl.setDrawableBounds(DatePickerImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(DatePickerImpl.this);
			
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
				DatePickerImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(DatePickerImpl.this);
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
		((DatePickerExt) datePicker).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
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
			case "dateFormat": {


		 setDateFormat(objValue);



			}
			break;
			case "hint": {


		 setHint(key, strValue, objValue, decorator);



			}
			break;
			case "minDateToday": {


		 setMinDateToday(objValue);



			}
			break;
			case "maxDateToday": {


		 setMaxDateToday(objValue);



			}
			break;
			case "text": {


		setMyText(key, strValue, objValue, decorator);



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
        return htmlElement;
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
		return datePicker.getVisibility() == View.VISIBLE;
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
	


	private BaseHasWidgets datePickerWidget;
	private final static String DISPLAY_FORMAT = "dd/MM/yyyy";
	private IWidget editText;
	private int year;
	private int month;
	private int day;
	private long maxDate = -1;
	private long minDate = -1;
	private SimpleDateFormat displayFormatter;

	private void updateText() {
		if (year == 0 && month == 0 && day == 0) {
			return;
		}
		if (year == -1 || month == -1 || day == -1) {
			editText.setAttribute(WidgetFactory.getAttribute(editText.getLocalName(), "text"), "", true);
		} else {
			Calendar cal = new GregorianCalendar(year, month, day);
			editText.setAttribute(WidgetFactory.getAttribute(editText.getLocalName(), "text"), displayFormatter.format(cal.getTime()), true);
		}
	}

	private void setMaxDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, 23, 59, 59);
		this.maxDate = c.getTimeInMillis();
	}

	private void setMinDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, 0, 0, 0);
		this.minDate = c.getTimeInMillis();
	}
	

	private void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;

		updateText();
	}
	

	private void setMinDateToday(Object objValue) {
		if ((boolean) objValue) {
			this.minDate = java.util.Calendar.getInstance().getTimeInMillis();
		} else {
			this.minDate = -1;
		}
	}
	
	
	private void setMaxDateToday(Object objValue) {
		if ((boolean) objValue) {
			this.maxDate = java.util.Calendar.getInstance().getTimeInMillis();
		} else {
			this.maxDate = -1;
		}
	}
	
	private void setDateFormat(Object objValue) {
		displayFormatter = new SimpleDateFormat((String) objValue, java.util.Locale.getDefault());
	}
	

	public void initDatePicker() {
		displayFormatter = new SimpleDateFormat(DISPLAY_FORMAT, java.util.Locale.getDefault());
		IWidget pickerTemplate = (IWidget) com.ashera.converter.ConverterFactory.get("template").convertFrom("@layout/datepicker", null, fragment);
		datePickerWidget = (BaseHasWidgets) pickerTemplate.loadLazyWidgets(this);
		editText = datePickerWidget.findWidgetById("@+id/editText");
		
		IWidget clearButton = findWidgetById("@+id/clearButton");
		setOnClickListener(clearButton, new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				setDate(-1, -1, -1);;
			}

		});
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
			datePicker.setId(IdGenerator.getId(id));
		}
	}
	
    

	
private DatePickerCommandBuilder builder;
private DatePickerBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public DatePickerBean getBean() {
	if (bean == null) {
		bean = new DatePickerBean();
	}
	return bean;
}
public DatePickerCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new DatePickerCommandBuilder();
	}
	return builder;
}


public  class DatePickerCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <DatePickerCommandBuilder> {
    public DatePickerCommandBuilder() {
	}
	
	public DatePickerCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public DatePickerCommandBuilder setOnTextChange(String value) {
	Map<String, Object> attrs = initCommand("onTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder setOnbeforeTextChange(String value) {
	Map<String, Object> attrs = initCommand("onbeforeTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder setOnafterTextChange(String value) {
	Map<String, Object> attrs = initCommand("onafterTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder setDateFormat(String value) {
	Map<String, Object> attrs = initCommand("dateFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder tryGetHint() {
	Map<String, Object> attrs = initCommand("hint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHint() {
	Map<String, Object> attrs = initCommand("hint");
	return attrs.get("commandReturnValue");
}
public DatePickerCommandBuilder setHint(String value) {
	Map<String, Object> attrs = initCommand("hint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder setMinDateToday(boolean value) {
	Map<String, Object> attrs = initCommand("minDateToday");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder setMaxDateToday(boolean value) {
	Map<String, Object> attrs = initCommand("maxDateToday");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder tryGetText() {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getText() {
	Map<String, Object> attrs = initCommand("text");
	return attrs.get("commandReturnValue");
}
public DatePickerCommandBuilder setText(String value) {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder showClearButton(boolean value) {
	Map<String, Object> attrs = initCommand("showClearButton");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public DatePickerCommandBuilder setHintTextFormat(String value) {
	Map<String, Object> attrs = initCommand("hintTextFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class DatePickerBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public DatePickerBean() {
			super(DatePickerImpl.this);
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

public void setDateFormat(String value) {
	getBuilder().reset().setDateFormat(value).execute(true);
}

public Object getHint() {
	return getBuilder().reset().tryGetHint().execute(false).getHint(); 
}
public void setHint(String value) {
	getBuilder().reset().setHint(value).execute(true);
}

public void setMinDateToday(boolean value) {
	getBuilder().reset().setMinDateToday(value).execute(true);
}

public void setMaxDateToday(boolean value) {
	getBuilder().reset().setMaxDateToday(value).execute(true);
}

public Object getText() {
	return getBuilder().reset().tryGetText().execute(false).getText(); 
}
public void setText(String value) {
	getBuilder().reset().setText(value).execute(true);
}

public void showClearButton(boolean value) {
	getBuilder().reset().showClearButton(value).execute(true);
}

public void setHintTextFormat(String value) {
	getBuilder().reset().setHintTextFormat(value).execute(true);
}

}


private DatePickerCommandParamsBuilder paramsBuilder;
private DatePickerParamsBean paramsBean;

public DatePickerParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new DatePickerParamsBean();
	}
	return paramsBean;
}
public DatePickerCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new DatePickerCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class DatePickerParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
}





public class DatePickerCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<DatePickerCommandParamsBuilder>{
}

	//end - body

	private boolean flag;
	private final static String DATE_PICKER_FORMAT = "yyyy-MM-dd";

	private void nativeCreate(Map<String, Object> params) {
		htmlElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
		htmlElement.getStyle().setProperty("box-sizing", "border-box");
		initDatePicker();
		IWidget imageButton = datePickerWidget.findWidgetById("@+id/imageButton");
		ViewImpl.setOnListener(imageButton, imageButton.asNativeWidget(), (event) -> {
			showDatePicker((HTMLElement) editText.asNativeWidget(), (year, month, day) -> {
				setDate(year, month, day);
			}, () -> {
				String text = (String) editText.getAttribute(WidgetFactory.getAttribute(editText.getLocalName(), "text"), null);
				
				if (text != null && !text.isEmpty()) {
					try {
						text = new java.text.SimpleDateFormat(DATE_PICKER_FORMAT).format(displayFormatter.parse(text));
					} catch (Exception e) {
						return "";
					}
				}
				return text;
			}, getDate(minDate), getDate(maxDate));
		}, "click", "click");
		registerForAttributeCommandChain("hint");
	}

	public String getDate(long date){
		return date == -1 ? "" : new java.text.SimpleDateFormat(DATE_PICKER_FORMAT).format(new Date(date));
	}

	@org.teavm.jso.JSBody(params = { "input", "myformatter", "myparser", "minDate", "maxDate" }, script = "var datePicker = new DateTimePicker.Date({\n"
			+ "     default: myparser(),\n"
			+ "		min: minDate,\n"
			+ "     max: maxDate,"
			+ "      minuteStep: 1\n"
			+ "    })\n"
			+ "    datePicker.on('selected', function (formatTime, now) {\n"
			+ "      	myformatter(now.getFullYear(), now.getMonth(), now.getDate())\n"
			+ "		 	datePicker.destroy()\n"
			+ "    })\n"
			+ "    datePicker.on('cleared', function () {\n"
			+ "      	myformatter(-1, -1, -1)\n"
			+ "			datePicker.destroy()\n"
			+ "    })\n"
			+ "		datePicker.on('canceled', function () {\n"
			+"			datePicker.destroy()\n"
			+ "    })")
    private static native void showDatePicker(org.teavm.jso.dom.html.HTMLElement input, DateFormatter myformatter, DateParser myparser, String minDate, String maxDate);
	
	@org.teavm.jso.JSFunctor
	public interface DateFormatter extends org.teavm.jso.JSObject {
	    void formatDatePicker(int year, int month, int day);
	}
	@org.teavm.jso.JSFunctor
	public interface DateParser extends org.teavm.jso.JSObject {
	    String parseDate();
	}
	
	private void setOnClickListener(IWidget clearButton, OnClickListener onClickListener) {
		ViewImpl.setOnListener(clearButton, clearButton.asNativeWidget(), (event) -> {
			onClickListener.onClick((View) clearButton.asWidget());
		}, "click", "click");
		
	}
	
	private void setError(String message) {
	}
}
