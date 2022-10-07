package com.ashera.layout;
//start - imports

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.*;
import androidx.core.view.*;
import android.view.*;
import android.graphics.drawable.*;


import android.os.Build;
import android.view.View;
import android.text.*;

import com.ashera.core.IFragment;
import com.ashera.converter.*;

import android.annotation.SuppressLint;

import com.ashera.layout.*;
import com.ashera.plugin.*;
import com.ashera.widget.bus.*;
import com.ashera.widget.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.IWidgetLifeCycleListener.EventId;
import com.ashera.widget.IWidgetLifeCycleListener.EventId.*;


import static com.ashera.widget.IWidget.*;
//end - imports
import androidx.core.widget.TextViewCompat;
@SuppressLint("NewApi")
public class MultiSelectionSpinnerImpl extends BaseHasWidgets implements com.ashera.validations.FormElement {
	//start - body
	public final static String LOCAL_NAME = "com.ashera.layout.MultiSelectionSpinner"; 
	public final static String GROUP_NAME = "com.ashera.layout.MultiSelectionSpinner";

	protected com.ashera.layout.MultiSelectionSpinner multiSelectionSpinner;
	
		@SuppressLint("NewApi")
		final static class Font extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("monospace",  0x3);
				mapping.put("normal",  0x0);
				mapping.put("sans",  0x1);
				mapping.put("serif",  0x2);
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
		final static class TextStyle  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("bold", 0x1);
				mapping.put("italic", 0x2);
				mapping.put("normal", 0x0);
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
		final static class DrawableTintMode  extends AbstractStringToEnumConverter{
		private Map<String, Object> mapping = new HashMap<>();
				{
		if (Build.VERSION.SDK_INT >= 11) {
				mapping.put("add", android.graphics.PorterDuff.Mode.ADD);
		}
		
				mapping.put("multiply", android.graphics.PorterDuff.Mode.MULTIPLY);
		
		
				mapping.put("screen", android.graphics.PorterDuff.Mode.SCREEN);
		
		
				mapping.put("src_atop", android.graphics.PorterDuff.Mode.SRC_ATOP);
		
		
				mapping.put("src_in", android.graphics.PorterDuff.Mode.SRC_IN);
		
		
				mapping.put("src_over", android.graphics.PorterDuff.Mode.SRC_OVER);
		
				}
		@Override
		public Map<String, Object> getMapping() {
				return mapping;
				}

		@Override
		public Object getDefault() {
				return null;
				}
				}
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewGroupModelImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("entries").withType("array").withArrayType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selection").withType("array").withArrayType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemSelected").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelOptionTextPath").withType("string").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelOptionValuePath").withType("string").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("values").withType("array").withArrayType("resourcestring").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selectedValues").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hintTextFormat").withType("resourcestring").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("colorstate").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		ConverterFactory.register("com.ashera.layout.MultiSelectionSpinner.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("com.ashera.layout.MultiSelectionSpinner.font").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		ConverterFactory.register("com.ashera.layout.MultiSelectionSpinner.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("com.ashera.layout.MultiSelectionSpinner.textStyle").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editable").withType("boolean").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTint").withType("colorstate").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		ConverterFactory.register("com.ashera.layout.MultiSelectionSpinner.drawableTintMode", new DrawableTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTintMode").withType("com.ashera.layout.MultiSelectionSpinner.drawableTintMode").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hint").withType("resourcestring").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorHint").withType("colorstate").withBufferStrategy(BUFFER_STRATEGY_ALWAYS));
	}
	
	public MultiSelectionSpinnerImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class MultiSelectionSpinnerExt extends com.ashera.layout.MultiSelectionSpinner implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public MultiSelectionSpinnerExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

	    public MultiSelectionSpinnerExt(Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
	    	super(context, attrs, defStyleAttr, defStyleRes);
	    }
		public MultiSelectionSpinnerExt(Context context) {
			super(context, MultiSelectionSpinnerImpl.this);
			
			
			
			
			
			
		}
			public MultiSelectionSpinnerExt(Context context, int mode) {
				super(context, mode, MultiSelectionSpinnerImpl.this);
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
				MultiSelectionSpinnerImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(MultiSelectionSpinnerImpl.this);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	    ((MultiSelectionSpinnerExt) multiSelectionSpinner).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new MultiSelectionSpinnerImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		multiSelectionSpinner = new MultiSelectionSpinnerExt(context);
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
			multiSelectionSpinner = new MultiSelectionSpinnerExt(context, null, defStyleAttr);	
		} else {
			multiSelectionSpinner = new MultiSelectionSpinnerExt(context, null, defStyleAttr, defStyleRes);
		}
		
	}

		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewGroupModelImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "entries": {
				


		setEntries(objValue);



			}
			break;
			case "selection": {
				


		setSelection(objValue);



			}
			break;
			case "onItemSelected": {
				


		if (objValue instanceof String) {multiSelectionSpinner.setOnMultiItemSelectedListener(new OnMultiItemSelectedListener(this, strValue, "onItemSelected"));} else {multiSelectionSpinner.setOnMultiItemSelectedListener((MultiSelectionSpinner.OnMultiItemSelectedListener) objValue);}



			}
			break;
			case "modelOptionTextPath": {
				


		setModelOptionTextPath(objValue);



			}
			break;
			case "modelOptionValuePath": {
				


		setModelOptionValuePath(objValue);



			}
			break;
			case "values": {
				


		setValues(objValue);



			}
			break;
			case "selectedValues": {
				


		setSelectedValues(objValue);



			}
			break;
			case "hintTextFormat": {
				


		setHintTextFormat(objValue);



			}
			break;
			case "drawablePadding": {
				


	appCompatTextView.setCompoundDrawablePadding((int)objValue);



			}
			break;
			case "gravity": {
				


	appCompatTextView.setGravity((int)objValue);



			}
			break;
			case "textColor": {
				


	appCompatTextView.setTextColor((android.content.res.ColorStateList)objValue);



			}
			break;
			case "textSize": {
				


		setMyTextSize(objValue);



			}
			break;
			case "drawableLeft": {
				


		setDrawableLeft(objValue);



			}
			break;
			case "drawableStart": {
				


		setDrawableLeft(objValue);



			}
			break;
			case "drawableRight": {
				


		setDrawableRight(objValue);



			}
			break;
			case "drawableEnd": {
				


		setDrawableRight(objValue);



			}
			break;
			case "drawableTop": {
				


		setDrawableTop(objValue);



			}
			break;
			case "drawableBottom": {
				


		setDrawableBottom(objValue);



			}
			break;
			case "typeface": {
				


		setTypeFace(objValue, strValue);



			}
			break;
			case "textStyle": {
				


		setTextStyle(objValue);



			}
			break;
			case "fontFamily": {
				


		setFontFamily(objValue, strValue);



			}
			break;
			case "enabled": {
				


		 multiSelectionSpinner.setEnabled((boolean) objValue);



			}
			break;
			case "editable": {
				


		 multiSelectionSpinner.setEnabled((boolean) objValue);



			}
			break;
			case "drawableTint": {
				


		setDrawableTintList(objValue);



			}
			break;
			case "drawableTintMode": {
				


		setDrawableTintMode(objValue);



			}
			break;
			case "hint": {
				


	setHint((String)objValue);



			}
			break;
			case "textColorHint": {
				


	setHintTextColor((android.content.res.ColorStateList)objValue);



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
			case "selectedValues": {
return getSelectedValues();				}
			case "drawablePadding": {
if (appCompatTextView == null) return null; return appCompatTextView.getCompoundDrawablePadding();				}
			case "gravity": {
return multiSelectionSpinner.getGravity();				}
			case "textColor": {
if (appCompatTextView == null) return null; return appCompatTextView.getTextColors();				}
			case "textSize": {
if (appCompatTextView == null) return null; return appCompatTextView.getTextSize();				}
			case "hint": {
return getHint();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return multiSelectionSpinner;
	}

	

	@Override
	public boolean isViewVisible() {
		return multiSelectionSpinner.getVisibility() == View.VISIBLE;
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
	


	@Override
	public void focus() {
		multiSelectionSpinner.requestFocus();
	}
	


	private void setDrawableLeft(Object objValue) {
		android.graphics.drawable.Drawable[] drawables = appCompatTextView.getCompoundDrawables();
		setBoundsOfDrawable(objValue);
		TextViewCompat.setCompoundDrawablesRelative(appCompatTextView, (android.graphics.drawable.Drawable) objValue, drawables[1], drawables[2], drawables[3]);		
	}

	private void setBoundsOfDrawable(Object objValue) {
		android.graphics.drawable.Drawable image = (android.graphics.drawable.Drawable) objValue;
		int h = image.getIntrinsicHeight();
		int w = image.getIntrinsicWidth();
		image.setBounds( 0, 0, w, h);
	}
	
	private void setDrawableRight(Object objValue) {
		android.graphics.drawable.Drawable[] drawables = appCompatTextView.getCompoundDrawables();
		setBoundsOfDrawable(objValue);
		TextViewCompat.setCompoundDrawablesRelative(appCompatTextView, drawables[0], drawables[1], (android.graphics.drawable.Drawable) objValue, drawables[3]);
		
	}
	private void setDrawableTop(Object objValue) {
		setBoundsOfDrawable(objValue);
		android.graphics.drawable.Drawable[] drawables = appCompatTextView.getCompoundDrawables();
		TextViewCompat.setCompoundDrawablesRelative(appCompatTextView, drawables[0], (android.graphics.drawable.Drawable) objValue, drawables[2], drawables[3]);
		
	}
	
	private void setDrawableBottom(Object objValue) {
		setBoundsOfDrawable(objValue);
		android.graphics.drawable.Drawable[] drawables = appCompatTextView.getCompoundDrawables();
		TextViewCompat.setCompoundDrawablesRelative(appCompatTextView, drawables[0], drawables[1], drawables[2], (android.graphics.drawable.Drawable) objValue);
		
	}
	
	private android.graphics.drawable.Drawable tintDrawableCompat;
	private void setDrawableTintMode(Object objValue) {
		if (Build.VERSION.SDK_INT >= 23) {
			appCompatTextView.setCompoundDrawableTintMode((android.graphics.PorterDuff.Mode) objValue);
		} else {
			android.graphics.drawable.Drawable[] drawables = appCompatTextView.getCompoundDrawablesRelative();
			for (android.graphics.drawable.Drawable drawable : drawables) {
				if (drawable != null) {
					if (tintDrawableCompat == null) {
						tintDrawableCompat = drawable;
						if (Build.VERSION.SDK_INT < 21) {
							tintDrawableCompat = androidx.core.graphics.drawable.DrawableCompat.wrap(tintDrawableCompat);
						}
					}
					androidx.core.graphics.drawable.DrawableCompat.setTintMode(tintDrawableCompat.mutate(),
							(android.graphics.PorterDuff.Mode) objValue);
					if (isInitialised()) {
						appCompatTextView.invalidate();
					}
				}
			}
		}
	}

	private void setDrawableTintList(Object objValue) {
		if (Build.VERSION.SDK_INT >= 23) {
			appCompatTextView.setCompoundDrawableTintList((android.content.res.ColorStateList) objValue);
		} else {
			android.graphics.drawable.Drawable[] drawables = appCompatTextView.getCompoundDrawablesRelative();
			for (android.graphics.drawable.Drawable drawable : drawables) {
				if (drawable != null) {
					if (tintDrawableCompat == null) {
						tintDrawableCompat = drawable;
						if (Build.VERSION.SDK_INT < 21) {
							tintDrawableCompat = androidx.core.graphics.drawable.DrawableCompat.wrap(tintDrawableCompat);
						}
					}
					androidx.core.graphics.drawable.DrawableCompat.setTintList(tintDrawableCompat.mutate(),
							(android.content.res.ColorStateList) objValue);
					if (isInitialised()) {
						appCompatTextView.invalidate();
					}					
				}
			}
		}
	}
	


	private void setMyTextSize(Object objValue) {
		appCompatTextView.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, getFragment().getRootActivity().getScaleFactor() * (float)objValue);		
	}
	


	private void setFontFamily(Object objValue, String strValue) {
		setTypeFace(objValue, strValue);
	}

	private void setTextStyle(Object objValue) {
		android.graphics.Typeface typeface  = appCompatTextView.getTypeface();
		if (typeface == null) {
			typeface = android.graphics.Typeface.DEFAULT;
		} else {
			typeface = android.graphics.Typeface.create(typeface, (int) objValue);
        }
		
		appCompatTextView.setTypeface(typeface, (int) objValue);
	}

	private void setTypeFace(Object objValue, String strValue) {
		if (objValue instanceof Integer) {
			objValue = PluginInvoker.convertFrom(ConverterFactory.get(CommonConverters.font), null, strValue, fragment);
		}
		android.graphics.Typeface typeface = appCompatTextView.getTypeface();
		if (typeface != null) {
			appCompatTextView.setTypeface((android.graphics.Typeface) objValue, typeface.getStyle());
		} else {
			appCompatTextView.setTypeface((android.graphics.Typeface) objValue);
		}
	}
	


    @Override
	public Object getChildAttribute(IWidget w, WidgetAttribute key) {
		return null;
	}

	@Override
	public void setChildAttribute(IWidget widget, WidgetAttribute key, String strValue, Object value) {
	}
	
	
	private String modelOptionTextPath;
	private String modelOptionValuePath;
	private void setModelOptionTextPath(Object objValue) {
		this.modelOptionTextPath = (String) objValue;
	}
	
	
	private void setModelOptionValuePath(Object objValue) {
		this.modelOptionValuePath = (String) objValue;
	}
	
	private Object getOptionValueFromLoopParam(com.ashera.model.LoopParam loopParam, String path) {
		com.ashera.model.ModelExpressionParser.ModelFromScopeHolder modelFromScopeHolder = com.ashera.model.ModelExpressionParser.parseModelFromScope(path);
		setLoopParam(loopParam);
		Object obj = getModelFromScope(modelFromScopeHolder.varName, modelFromScopeHolder.varScope);
		Object val = getModelByPath(modelFromScopeHolder.varPath, obj);
		if (val == null) {
			val = "";
		}
		return val;
	}

	
	


	@Override
	public void replayBufferedEvents() {
	}
	
	@Override
	protected void attributeBuffered() {
		if (isInitialised()) {
			reloadTable();
		}
	}
	

	@SuppressLint("NewApi")
private static class OnMultiItemSelectedListener implements MultiSelectionSpinner.OnMultiItemSelectedListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnMultiItemSelectedListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnMultiItemSelectedListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onItemSelected(View view, List<Integer> positions){
    
	if (action == null || action.equals("onItemSelected")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onItemSelected");
	    java.util.Map<String, Object> obj = getOnItemSelectedEventObj(view,positions);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, view,positions);
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

public java.util.Map<String, Object> getOnItemSelectedEventObj(View view,List<Integer> positions) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "itemselected");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "positions", positions);Object selectedValues = ((MultiSelectionSpinnerImpl)w).getSelectedValues(); if (selectedValues != null) { PluginInvoker.putJSONSafeObjectIntoMap(obj, "selectedValues", selectedValues);}
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onItemSelected", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}public void onNothingSelected(View view, List<Integer> positions){
    
	if (action == null || action.equals("onNothingSelected")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onNothingSelected");
	    java.util.Map<String, Object> obj = getOnNothingSelectedEventObj(view,positions);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, view,positions);
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

public java.util.Map<String, Object> getOnNothingSelectedEventObj(View view,List<Integer> positions) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "nothingselected");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "positions", positions);Object selectedValues = ((MultiSelectionSpinnerImpl)w).getSelectedValues(); if (selectedValues != null) { PluginInvoker.putJSONSafeObjectIntoMap(obj, "selectedValues", selectedValues);}
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onNothingSelected", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	
	    @Override
	    public Object asNativeWidget() {
	        return multiSelectionSpinner;
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			multiSelectionSpinner.setId(IdGenerator.getId(id));
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
    
	
private MultiSelectionSpinnerCommandBuilder builder;
private MultiSelectionSpinnerBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public MultiSelectionSpinnerBean getBean() {
	if (bean == null) {
		bean = new MultiSelectionSpinnerBean();
	}
	return bean;
}
public MultiSelectionSpinnerCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new MultiSelectionSpinnerCommandBuilder();
	}
	return builder;
}


public  class MultiSelectionSpinnerCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <MultiSelectionSpinnerCommandBuilder> {
    public MultiSelectionSpinnerCommandBuilder() {
	}
	
	public MultiSelectionSpinnerCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public MultiSelectionSpinnerCommandBuilder setEntries(String value) {
	Map<String, Object> attrs = initCommand("entries");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setSelection(String value) {
	Map<String, Object> attrs = initCommand("selection");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setOnItemSelected(String value) {
	Map<String, Object> attrs = initCommand("onItemSelected");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setModelOptionTextPath(String value) {
	Map<String, Object> attrs = initCommand("modelOptionTextPath");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setModelOptionValuePath(String value) {
	Map<String, Object> attrs = initCommand("modelOptionValuePath");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setValues(String value) {
	Map<String, Object> attrs = initCommand("values");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetSelectedValues() {
	Map<String, Object> attrs = initCommand("selectedValues");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSelectedValues() {
	Map<String, Object> attrs = initCommand("selectedValues");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setSelectedValues(Object value) {
	Map<String, Object> attrs = initCommand("selectedValues");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setHintTextFormat(String value) {
	Map<String, Object> attrs = initCommand("hintTextFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setDrawablePadding(String value) {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setDrawableStart(String value) {
	Map<String, Object> attrs = initCommand("drawableStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setDrawableRight(String value) {
	Map<String, Object> attrs = initCommand("drawableRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setDrawableEnd(String value) {
	Map<String, Object> attrs = initCommand("drawableEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setDrawableTop(String value) {
	Map<String, Object> attrs = initCommand("drawableTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setDrawableBottom(String value) {
	Map<String, Object> attrs = initCommand("drawableBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setTypeface(String value) {
	Map<String, Object> attrs = initCommand("typeface");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setTextStyle(String value) {
	Map<String, Object> attrs = initCommand("textStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setFontFamily(String value) {
	Map<String, Object> attrs = initCommand("fontFamily");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setEditable(boolean value) {
	Map<String, Object> attrs = initCommand("editable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setDrawableTint(String value) {
	Map<String, Object> attrs = initCommand("drawableTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setDrawableTintMode(DrawableTintMode value) {
	Map<String, Object> attrs = initCommand("drawableTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetHint() {
	Map<String, Object> attrs = initCommand("hint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHint() {
	Map<String, Object> attrs = initCommand("hint");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setHint(String value) {
	Map<String, Object> attrs = initCommand("hint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setTextColorHint(String value) {
	Map<String, Object> attrs = initCommand("textColorHint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class MultiSelectionSpinnerBean extends com.ashera.layout.ViewImpl.ViewBean{
		public MultiSelectionSpinnerBean() {
			super(MultiSelectionSpinnerImpl.this);
		}
public void setEntries(String value) {
	getBuilder().reset().setEntries(value).execute(true);
}

public void setSelection(String value) {
	getBuilder().reset().setSelection(value).execute(true);
}

public void setOnItemSelected(String value) {
	getBuilder().reset().setOnItemSelected(value).execute(true);
}

public void setModelOptionTextPath(String value) {
	getBuilder().reset().setModelOptionTextPath(value).execute(true);
}

public void setModelOptionValuePath(String value) {
	getBuilder().reset().setModelOptionValuePath(value).execute(true);
}

public void setValues(String value) {
	getBuilder().reset().setValues(value).execute(true);
}

public Object getSelectedValues() {
	return getBuilder().reset().tryGetSelectedValues().execute(false).getSelectedValues(); 
}
public void setSelectedValues(Object value) {
	getBuilder().reset().setSelectedValues(value).execute(true);
}

public void setHintTextFormat(String value) {
	getBuilder().reset().setHintTextFormat(value).execute(true);
}

public Object getDrawablePadding() {
	return getBuilder().reset().tryGetDrawablePadding().execute(false).getDrawablePadding(); 
}
public void setDrawablePadding(String value) {
	getBuilder().reset().setDrawablePadding(value).execute(true);
}

public Object getGravity() {
	return getBuilder().reset().tryGetGravity().execute(false).getGravity(); 
}
public void setGravity(String value) {
	getBuilder().reset().setGravity(value).execute(true);
}

public Object getTextColor() {
	return getBuilder().reset().tryGetTextColor().execute(false).getTextColor(); 
}
public void setTextColor(String value) {
	getBuilder().reset().setTextColor(value).execute(true);
}

public Object getTextSize() {
	return getBuilder().reset().tryGetTextSize().execute(false).getTextSize(); 
}
public void setTextSize(String value) {
	getBuilder().reset().setTextSize(value).execute(true);
}

public void setDrawableLeft(String value) {
	getBuilder().reset().setDrawableLeft(value).execute(true);
}

public void setDrawableStart(String value) {
	getBuilder().reset().setDrawableStart(value).execute(true);
}

public void setDrawableRight(String value) {
	getBuilder().reset().setDrawableRight(value).execute(true);
}

public void setDrawableEnd(String value) {
	getBuilder().reset().setDrawableEnd(value).execute(true);
}

public void setDrawableTop(String value) {
	getBuilder().reset().setDrawableTop(value).execute(true);
}

public void setDrawableBottom(String value) {
	getBuilder().reset().setDrawableBottom(value).execute(true);
}

public void setTypeface(String value) {
	getBuilder().reset().setTypeface(value).execute(true);
}

public void setTextStyle(String value) {
	getBuilder().reset().setTextStyle(value).execute(true);
}

public void setFontFamily(String value) {
	getBuilder().reset().setFontFamily(value).execute(true);
}

public void setEnabled(boolean value) {
	getBuilder().reset().setEnabled(value).execute(true);
}

public void setEditable(boolean value) {
	getBuilder().reset().setEditable(value).execute(true);
}

public void setDrawableTint(String value) {
	getBuilder().reset().setDrawableTint(value).execute(true);
}

public void setDrawableTintMode(DrawableTintMode value) {
	getBuilder().reset().setDrawableTintMode(value).execute(true);
}

public Object getHint() {
	return getBuilder().reset().tryGetHint().execute(false).getHint(); 
}
public void setHint(String value) {
	getBuilder().reset().setHint(value).execute(true);
}

public void setTextColorHint(String value) {
	getBuilder().reset().setTextColorHint(value).execute(true);
}

}


    
	//end - body
	private TextView appCompatTextView;
	public void setAppCompatTextView(TextView appCompatTextView) {
		this.appCompatTextView = appCompatTextView;
	}

	private void setEntries(Object objValue) {
		List<String> values = (List<String>)objValue;
		multiSelectionSpinner.setItems(values);
	}

	
	private void setSelection(Object objValue) {
		multiSelectionSpinner.setSelection(((List<Integer>)objValue));		
	}
	
	@Override
	protected void addItemToParent(int index, java.lang.String id, com.ashera.model.LoopParam loopParam) {
		if (modelOptionTextPath != null) {
			Object val = getOptionValueFromLoopParam(loopParam, modelOptionTextPath);
			multiSelectionSpinner.addItem((String) val);
			
		}
	}
	
	

	private void reloadTable() {
		((ArrayAdapter) multiSelectionSpinner.getAdapter()).notifyDataSetChanged();
	}

	public void resetAttributes() {
		super.replayBufferedEventsInternal();
	}

	//start - values
	private List<String> values;
	private Object tmpSelectedValues;
	private void setValues(Object objValue) {
		this.values = (List<String>) objValue;
	}
	
	
	private void setSelectedValues(Object objValue) {
		if (objValue instanceof String) {
			// try resource string
			objValue = quickConvert(objValue, CommonConverters.resourcestring);
		}
		
		if (objValue instanceof String) {
			objValue = java.util.Arrays.asList(((String) objValue).split(","));
		}

		if (this.values != null) {
			List<Object> selectedValues = PluginInvoker.getList(objValue);
			List<Integer> selectedItemPositions = new ArrayList<>();
			for (Object selectedValue : selectedValues) {
				int index = values.indexOf(selectedValue);
				if (index != -1) {
					selectedItemPositions.add(index);
				}
			}
			
			setSelection(selectedItemPositions);
		} else if (dataList != null && dataList.size() > 0) {
			List<Integer> selectedItemPositions = new ArrayList<>();
			List<Object> selectedValues = PluginInvoker.getList(objValue);
			for (int i = 0; i < dataList.size(); i++) {
				com.ashera.model.LoopParam loopParam = dataList.get(i);

				if (modelOptionValuePath != null) {
					Object data = getOptionValueFromLoopParam(loopParam, modelOptionValuePath);
					for (Object selectedValue : selectedValues) {
						if (data.equals(selectedValue)) {
							selectedItemPositions.add(i);
						}
					}
					selectedItemPositions.add(i);
				} else if (modelOptionTextPath != null) {
					Object data = getOptionValueFromLoopParam(loopParam, modelOptionTextPath);
					for (Object selectedValue : selectedValues) {
						if (data.equals(selectedValue)) {
							selectedItemPositions.add(i);
						}
					}
				}
			}
			setSelection(selectedItemPositions);
		} else {
			tmpSelectedValues = objValue;
		}
	}
	
	private Object getSelectedValues() {
		List<Integer> selectedItemPositions = getSelectedItemPositions();
		
		if (this.values != null && selectedItemPositions != null && selectedItemPositions.size() > 0) {
			List<String> selectedValues = new ArrayList<>();
			for (Integer selectedItemPosition : selectedItemPositions) {
				selectedValues.add(this.values.get(selectedItemPosition));
			}
			return selectedValues;
		}
		
		if (dataList != null && dataList.size() > 0) {
			if (modelOptionValuePath != null) {
				List<String> selectedValues = new ArrayList<>();
				for (Integer selectedItemPosition : selectedItemPositions) {
					selectedValues.add(PluginInvoker.getString(getOptionValueFromLoopParam(dataList.get(selectedItemPosition), modelOptionValuePath)));
				}	
				return selectedValues;
			}
			
			if (modelOptionTextPath != null) {
				List<String> selectedValues = new ArrayList<>();
				for (Integer selectedItemPosition : selectedItemPositions) {
					selectedValues.add(PluginInvoker.getString(getOptionValueFromLoopParam(dataList.get(selectedItemPosition), modelOptionTextPath)));
				}	
				return selectedValues;
			}
		}
		
		return null;
	}
	
	@Override
	public String getTextEntered() {
		List<String> selectedValues = (List<String>) getSelectedValues();
		return selectedValues == null || selectedValues.isEmpty() ? "" : selectedValues.toString();
	}

	
	@Override
	public void initialized() {
		super.initialized();
		setSelection(getSelectedItemPositions());
		if (tmpSelectedValues != null) {
			setSelectedValues(tmpSelectedValues);
		}
	}
	//end - values
	
	private List<Integer> getSelectedItemPositions() {
		return multiSelectionSpinner.getSelectedIndicies();
	}

	private void setHintTextColor(android.content.res.ColorStateList objValue) {
		appCompatTextView.setHintTextColor(objValue);
	}

	private void setHint(String hint) {
		this.appCompatTextView.setHint(hint);
	}
	
	
	private Object getHint() {
		return appCompatTextView.getHint();
	}
	

	private void setError(Object object) {
		
	}


	private void nativeCreate(Map<String, Object> params) {
		registerForAttributeCommandChain("hint");
	}
}
