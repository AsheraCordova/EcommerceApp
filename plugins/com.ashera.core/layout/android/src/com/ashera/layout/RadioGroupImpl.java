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

public class RadioGroupImpl extends BaseHasWidgets implements com.ashera.validations.FormElement {
	//start - body
	public final static String LOCAL_NAME = "RadioGroup"; 
	public final static String GROUP_NAME = "RadioGroup";
	private android.widget.RadioGroup radioGroup;
	

	
		@SuppressLint("NewApi")
		final static class Orientation extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("horizontal",  0x0);
				mapping.put("vertical",  0x1);
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
		final static class Divider  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none", 0x0);
				mapping.put("beginning", 0x1);
				mapping.put("end", 0x4);
				mapping.put("middle", 0x2);
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

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baselineAligned").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baselineAlignedChildIndex").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("divider").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("measureWithLargestChild").withType("boolean"));
		ConverterFactory.register("RadioGroup.orientation", new Orientation());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("orientation").withType("RadioGroup.orientation"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("weightSum").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onChildViewAdded").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onChildViewRemoved").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("checkedButton").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onCheckedChange").withType("string"));
		ConverterFactory.register("RadioGroup.divider", new Divider());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("showDividers").withType("RadioGroup.divider"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("dividerPadding").withType("dimension"));
	
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_gravity").withType("gravity").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_weight").withType("float").forChild());
	}
	
	public RadioGroupImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  RadioGroupImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  RadioGroupImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new RadioGroupImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	radioGroup = new RadioGroupExt(context);

		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return radioGroup;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		radioGroup.removeView((View) w.asWidget());
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= radioGroup.getChildCount()) {
            radioGroup.removeViewAt(index);
        }    
        return remove;
    }
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        radioGroup.addView(view);
			    } else {
			        radioGroup.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		android.widget.RadioGroup.LayoutParams layoutParams = (android.widget.RadioGroup.LayoutParams) view.getLayoutParams();
		
		layoutParams = (android.widget.RadioGroup.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new android.widget.RadioGroup.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private android.widget.RadioGroup.LayoutParams getLayoutParams(View view) {
		return (android.widget.RadioGroup.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		android.widget.RadioGroup.LayoutParams layoutParams = getLayoutParams(view);
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
			case "layout_weight": {
				
							layoutParams.weight = ((float)objValue);
				
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
		android.widget.RadioGroup.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
			case "layout_gravity": {
return layoutParams.gravity;			}

			case "layout_weight": {
return layoutParams.weight;			}

		}
		
		return null;

	}
	
		
	public class RadioGroupExt extends android.widget.RadioGroup implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public RadioGroupExt(Context context) {
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
				RadioGroupImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(RadioGroupImpl.this);
        }
	}
	
	public void updateMeasuredDimension(int width, int height) {
		((RadioGroupExt) radioGroup).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "baselineAligned": {


	radioGroup.setBaselineAligned((boolean)objValue);



			}
			break;
			case "baselineAlignedChildIndex": {


	radioGroup.setBaselineAlignedChildIndex((int)objValue);



			}
			break;
			case "divider": {
if (Build.VERSION.SDK_INT >= 11) {

	radioGroup.setDividerDrawable((android.graphics.drawable.Drawable)objValue);

}

			}
			break;
			case "gravity": {


	radioGroup.setGravity((int)objValue);



			}
			break;
			case "measureWithLargestChild": {
if (Build.VERSION.SDK_INT >= 11) {

	radioGroup.setMeasureWithLargestChildEnabled((boolean)objValue);

}

			}
			break;
			case "orientation": {


	radioGroup.setOrientation((int)objValue);



			}
			break;
			case "weightSum": {


	radioGroup.setWeightSum((float)objValue);



			}
			break;
			case "onChildViewAdded": {


		if (objValue instanceof String) {radioGroup.setOnHierarchyChangeListener(new OnHierarchyChangeListener(this, strValue));} else {setOnHierarchyChangeListener(radioGroup, objValue);}



			}
			break;
			case "onChildViewRemoved": {


		if (objValue instanceof String) {radioGroup.setOnHierarchyChangeListener(new OnHierarchyChangeListener(this, strValue));} else {setOnHierarchyChangeListener(radioGroup, objValue);}



			}
			break;
			case "checkedButton": {


		setChecked(objValue);



			}
			break;
			case "onCheckedChange": {


		setOnCheckedChange(objValue);



			}
			break;
			case "showDividers": {


		setShowDividers(objValue);



			}
			break;
			case "dividerPadding": {


		setDividerPadding(objValue);



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
			case "baselineAligned": {
return radioGroup.isBaselineAligned();			}
			case "baselineAlignedChildIndex": {
return radioGroup.getBaselineAlignedChildIndex();			}
			case "divider": {
if (Build.VERSION.SDK_INT >= 11) {
return radioGroup.getDividerDrawable();
}
break;			}
			case "gravity": {
if (Build.VERSION.SDK_INT >= 24) {
return radioGroup.getGravity();
}
break;			}
			case "measureWithLargestChild": {
if (Build.VERSION.SDK_INT >= 11) {
return radioGroup.isMeasureWithLargestChildEnabled();
}
break;			}
			case "orientation": {
return radioGroup.getOrientation();			}
			case "weightSum": {
return radioGroup.getWeightSum();			}
			case "checkedButton": {
return getChecked();			}
			case "showDividers": {
return getShowDividers();			}
			case "dividerPadding": {
return getDividerPadding();			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return radioGroup;
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
    
	

	@Override
	public boolean isViewVisible() {
		return radioGroup.getVisibility() == View.VISIBLE;
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
	


	@Override
	public void focus() {
		radioGroup.requestFocus();
	}
	


	@SuppressLint("NewApi")
	private void setDividerPadding(Object objValue) {
		if (Build.VERSION.SDK_INT >= 11) {
			radioGroup.setDividerPadding((int) objValue);
		}
	}

	@SuppressLint("NewApi")
	private void setShowDividers(Object objValue) {
		if (Build.VERSION.SDK_INT >= 11) {
			radioGroup.setShowDividers((int) objValue);
		}
	}

	@SuppressLint("NewApi")
	private Object getDividerPadding() {
		if (Build.VERSION.SDK_INT >= 11) {
			return radioGroup.getDividerPadding();
		}
		
		return null;
	}

	@SuppressLint("NewApi")
	private Object getShowDividers() {
		if (Build.VERSION.SDK_INT >= 11) {
			return radioGroup.getShowDividers();
		}
		return null;
	}
	

	@SuppressLint("NewApi")
private static class OnHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnHierarchyChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnHierarchyChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onChildViewAdded (View parent, 
                View child){
    
	if (action == null || action.equals("onChildViewAdded")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onChildViewAdded");
	    java.util.Map<String, Object> obj = getOnChildViewAddedEventObj(parent,child);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, parent,child);
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
public void onChildViewRemoved (View parent, 
                View child){
    
	if (action == null || action.equals("onChildViewRemoved")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onChildViewRemoved");
	    java.util.Map<String, Object> obj = getOnChildViewRemovedEventObj(parent,child);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, parent,child);
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

public java.util.Map<String, Object> getOnChildViewRemovedEventObj(View parent,View child) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "childviewremoved");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onChildViewRemoved", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}

public java.util.Map<String, Object> getOnChildViewAddedEventObj(View parent,View child) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "childviewadded");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onChildViewAdded", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnCheckedChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnCheckedChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onCheckedChanged (RadioGroup group, 
                int checkedId){
    
	if (action == null || action.equals("onCheckedChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onCheckedChange");
	    java.util.Map<String, Object> obj = getOnCheckedChangeEventObj(group,checkedId);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, group,checkedId);
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

public java.util.Map<String, Object> getOnCheckedChangeEventObj(RadioGroup group,int checkedId) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "checkedchange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "checkedId", checkedId);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onCheckedChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			radioGroup.setId(IdGenerator.getId(id));
		}
	}
	
    

	
private RadioGroupCommandBuilder builder;
private RadioGroupBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public RadioGroupBean getBean() {
	if (bean == null) {
		bean = new RadioGroupBean();
	}
	return bean;
}
public RadioGroupCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new RadioGroupCommandBuilder();
	}
	return builder;
}


public  class RadioGroupCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <RadioGroupCommandBuilder> {
    public RadioGroupCommandBuilder() {
	}
	
	public RadioGroupCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public RadioGroupCommandBuilder tryGetBaselineAligned() {
	Map<String, Object> attrs = initCommand("baselineAligned");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isBaselineAligned() {
	Map<String, Object> attrs = initCommand("baselineAligned");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setBaselineAligned(boolean value) {
	Map<String, Object> attrs = initCommand("baselineAligned");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetBaselineAlignedChildIndex() {
	Map<String, Object> attrs = initCommand("baselineAlignedChildIndex");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBaselineAlignedChildIndex() {
	Map<String, Object> attrs = initCommand("baselineAlignedChildIndex");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setBaselineAlignedChildIndex(int value) {
	Map<String, Object> attrs = initCommand("baselineAlignedChildIndex");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetDivider() {
	Map<String, Object> attrs = initCommand("divider");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDivider() {
	Map<String, Object> attrs = initCommand("divider");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setDivider(String value) {
	Map<String, Object> attrs = initCommand("divider");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetMeasureWithLargestChild() {
	Map<String, Object> attrs = initCommand("measureWithLargestChild");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isMeasureWithLargestChild() {
	Map<String, Object> attrs = initCommand("measureWithLargestChild");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setMeasureWithLargestChild(boolean value) {
	Map<String, Object> attrs = initCommand("measureWithLargestChild");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetOrientation() {
	Map<String, Object> attrs = initCommand("orientation");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getOrientation() {
	Map<String, Object> attrs = initCommand("orientation");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setOrientation(String value) {
	Map<String, Object> attrs = initCommand("orientation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetWeightSum() {
	Map<String, Object> attrs = initCommand("weightSum");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getWeightSum() {
	Map<String, Object> attrs = initCommand("weightSum");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setWeightSum(float value) {
	Map<String, Object> attrs = initCommand("weightSum");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder setOnChildViewAdded(String value) {
	Map<String, Object> attrs = initCommand("onChildViewAdded");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder setOnChildViewRemoved(String value) {
	Map<String, Object> attrs = initCommand("onChildViewRemoved");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetCheckedButton() {
	Map<String, Object> attrs = initCommand("checkedButton");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getCheckedButton() {
	Map<String, Object> attrs = initCommand("checkedButton");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setCheckedButton(String value) {
	Map<String, Object> attrs = initCommand("checkedButton");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder setOnCheckedChange(String value) {
	Map<String, Object> attrs = initCommand("onCheckedChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetShowDividers() {
	Map<String, Object> attrs = initCommand("showDividers");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShowDividers() {
	Map<String, Object> attrs = initCommand("showDividers");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setShowDividers(String value) {
	Map<String, Object> attrs = initCommand("showDividers");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandBuilder tryGetDividerPadding() {
	Map<String, Object> attrs = initCommand("dividerPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDividerPadding() {
	Map<String, Object> attrs = initCommand("dividerPadding");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandBuilder setDividerPadding(String value) {
	Map<String, Object> attrs = initCommand("dividerPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class RadioGroupBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public RadioGroupBean() {
			super(RadioGroupImpl.this);
		}
public Object isBaselineAligned() {
	return getBuilder().reset().tryGetBaselineAligned().execute(false).isBaselineAligned(); 
}
public void setBaselineAligned(boolean value) {
	getBuilder().reset().setBaselineAligned(value).execute(true);
}

public Object getBaselineAlignedChildIndex() {
	return getBuilder().reset().tryGetBaselineAlignedChildIndex().execute(false).getBaselineAlignedChildIndex(); 
}
public void setBaselineAlignedChildIndex(int value) {
	getBuilder().reset().setBaselineAlignedChildIndex(value).execute(true);
}

public Object getDivider() {
	return getBuilder().reset().tryGetDivider().execute(false).getDivider(); 
}
public void setDivider(String value) {
	getBuilder().reset().setDivider(value).execute(true);
}

public Object getGravity() {
	return getBuilder().reset().tryGetGravity().execute(false).getGravity(); 
}
public void setGravity(String value) {
	getBuilder().reset().setGravity(value).execute(true);
}

public Object isMeasureWithLargestChild() {
	return getBuilder().reset().tryGetMeasureWithLargestChild().execute(false).isMeasureWithLargestChild(); 
}
public void setMeasureWithLargestChild(boolean value) {
	getBuilder().reset().setMeasureWithLargestChild(value).execute(true);
}

public Object getOrientation() {
	return getBuilder().reset().tryGetOrientation().execute(false).getOrientation(); 
}
public void setOrientation(String value) {
	getBuilder().reset().setOrientation(value).execute(true);
}

public Object getWeightSum() {
	return getBuilder().reset().tryGetWeightSum().execute(false).getWeightSum(); 
}
public void setWeightSum(float value) {
	getBuilder().reset().setWeightSum(value).execute(true);
}

public void setOnChildViewAdded(String value) {
	getBuilder().reset().setOnChildViewAdded(value).execute(true);
}

public void setOnChildViewRemoved(String value) {
	getBuilder().reset().setOnChildViewRemoved(value).execute(true);
}

public Object getCheckedButton() {
	return getBuilder().reset().tryGetCheckedButton().execute(false).getCheckedButton(); 
}
public void setCheckedButton(String value) {
	getBuilder().reset().setCheckedButton(value).execute(true);
}

public void setOnCheckedChange(String value) {
	getBuilder().reset().setOnCheckedChange(value).execute(true);
}

public Object getShowDividers() {
	return getBuilder().reset().tryGetShowDividers().execute(false).getShowDividers(); 
}
public void setShowDividers(String value) {
	getBuilder().reset().setShowDividers(value).execute(true);
}

public Object getDividerPadding() {
	return getBuilder().reset().tryGetDividerPadding().execute(false).getDividerPadding(); 
}
public void setDividerPadding(String value) {
	getBuilder().reset().setDividerPadding(value).execute(true);
}

}


private RadioGroupCommandParamsBuilder paramsBuilder;
private RadioGroupParamsBean paramsBean;

public RadioGroupParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new RadioGroupParamsBean();
	}
	return paramsBean;
}
public RadioGroupCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new RadioGroupCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class RadioGroupParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
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

public Object getLayoutWeight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutWeight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutWeight();
}
public void setLayoutWeight(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutWeight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

}





public class RadioGroupCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<RadioGroupCommandParamsBuilder>{
public RadioGroupCommandParamsBuilder tryGetLayoutGravity() {
	Map<String, Object> attrs = initCommand("layout_gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGravity() {
	Map<String, Object> attrs = initCommand("layout_gravity");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandParamsBuilder setLayoutGravity(String value) {
	Map<String, Object> attrs = initCommand("layout_gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RadioGroupCommandParamsBuilder tryGetLayoutWeight() {
	Map<String, Object> attrs = initCommand("layout_weight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutWeight() {
	Map<String, Object> attrs = initCommand("layout_weight");
	return attrs.get("commandReturnValue");
}
public RadioGroupCommandParamsBuilder setLayoutWeight(float value) {
	Map<String, Object> attrs = initCommand("layout_weight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}

	//end - body
    private void setChecked(Object objValue) {
        radioGroup.check(PluginInvoker.getInt(objValue));        
    }
    
    private Object getChecked() {
        return radioGroup.getCheckedRadioButtonId();
    }

	
	private void setOnCheckedChange(Object objValue) {
		RadioGroup.OnCheckedChangeListener onCheckedChangeListener;
		
		if (objValue instanceof String) {
			onCheckedChangeListener= new OnCheckedChangeListener(this, (String) objValue);
		} else {
			onCheckedChangeListener= (RadioGroup.OnCheckedChangeListener) objValue;
		}
		radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
		
	}
	
	@Override
	public String getTextEntered() {
		return radioGroup.getCheckedRadioButtonId() != -1 ? "checked" : "";
	}
	
	private void setError(String message) {
		
	}

	
	private void setOnHierarchyChangeListener(RadioGroup radioGroup, Object objValue) {
		radioGroup.setOnHierarchyChangeListener((RadioGroup.OnHierarchyChangeListener) objValue);
		
	}
}
