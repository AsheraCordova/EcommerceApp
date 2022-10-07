package com.ashera.layout;
//start - imports

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import r.android.content.Context;


import org.teavm.jso.dom.html.HTMLElement;

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


import static com.ashera.widget.IWidget.*;
//end - imports
@SuppressLint("NewApi")
public class MultiSelectionSpinnerImpl extends BaseHasWidgets implements com.ashera.validations.FormElement {
	//start - body
	public final static String LOCAL_NAME = "com.ashera.layout.MultiSelectionSpinner"; 
	public final static String GROUP_NAME = "com.ashera.layout.MultiSelectionSpinner";

	protected org.teavm.jso.dom.html.HTMLElement hTMLElement;
	protected MeasurableTextView measurableTextView;	
	
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
		final static class DrawableTintMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("add",  0x1);
				mapping.put("multiply",  0x2);
				mapping.put("screen",  0x3);
				mapping.put("src_atop",  0x4);
				mapping.put("src_in",  0x5);
				mapping.put("src_over",  0x6);
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
	public void loadAttributes(String attributeName) {
		ViewGroupModelImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("entries").withType("array").withArrayType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selection").withType("array").withArrayType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelOptionTextPath").withType("string").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onItemSelected").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelOptionValuePath").withType("string").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selectedValues").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("values").withType("array").withArrayType("resourcestring").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("com.ashera.layout.MultiSelectionSpinner.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("com.ashera.layout.MultiSelectionSpinner.font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("com.ashera.layout.MultiSelectionSpinner.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("com.ashera.layout.MultiSelectionSpinner.textStyle").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension").withOrder(1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTint").withType("colorstate"));
		ConverterFactory.register("com.ashera.layout.MultiSelectionSpinner.drawableTintMode", new DrawableTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTintMode").withType("com.ashera.layout.MultiSelectionSpinner.drawableTintMode"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("webEnableTintFilter").withType("boolean"));
	}
	
	public MultiSelectionSpinnerImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class MultiSelectionSpinnerExt extends MeasurableTextView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public MultiSelectionSpinnerExt() {
			
			
			
			
			
			
			super(MultiSelectionSpinnerImpl.this);
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
			ViewImpl.setDrawableBounds(MultiSelectionSpinnerImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			nativeMakeFrameForChildWidget(l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(MultiSelectionSpinnerImpl.this);
			
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
        	ViewImpl.drawableStateChanged(MultiSelectionSpinnerImpl.this);
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
        @Override
        public int nativeMeasureWidth(java.lang.Object uiView) {
        	return MultiSelectionSpinnerImpl.this.nativeMeasureWidth(uiView);
        }
        
        @Override
        public int nativeMeasureHeight(java.lang.Object uiView, int width) {
        	return MultiSelectionSpinnerImpl.this.nativeMeasureHeight(uiView, width);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	}

	@Override
	public IWidget newInstance() {
		return new MultiSelectionSpinnerImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableTextView = new MultiSelectionSpinnerExt();
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
			case "modelOptionTextPath": {
				


		setModelOptionTextPath(objValue);



			}
			break;
			case "onItemSelected": {
				


		if (objValue instanceof String) {setOnMultiItemSelectedListener(new OnMultiItemSelectedListener(this, strValue, "onItemSelected"));} else {setOnMultiItemSelectedListener((MultiSelectionSpinner.OnMultiItemSelectedListener) objValue);}



			}
			break;
			case "modelOptionValuePath": {
				


		setModelOptionValuePath(objValue);



			}
			break;
			case "selectedValues": {
				


		setSelectedValues(objValue);



			}
			break;
			case "values": {
				


		setValues(objValue);



			}
			break;
			case "textColor": {
				


		setTextColor(objValue);



			}
			break;
			case "gravity": {
				


		setGravity(objValue);



			}
			break;
			case "textSize": {
				


		setMyTextSize(objValue);



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
			case "drawableLeft": {
				


		 setDrawableLeft(objValue); 



			}
			break;
			case "drawableRight": {
				


		 setDrawableRight(objValue); 



			}
			break;
			case "drawableStart": {
				


		 setDrawableLeft(objValue); 



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
			case "drawablePadding": {
				


		 setDrawablePadding(objValue); 



			}
			break;
			case "enabled": {
				


		 setEnabled(objValue);



			}
			break;
			case "editable": {
				


		 setEnabled(objValue);



			}
			break;
			case "padding": {
				


		setPadding(objValue);



			}
			break;
			case "paddingTop": {
				


		setPaddingTop(objValue);



			}
			break;
			case "paddingBottom": {
				


		setPaddingBottom(objValue);



			}
			break;
			case "paddingLeft": {
				


		setPaddingLeft(objValue);



			}
			break;
			case "paddingRight": {
				


		setPaddingRight(objValue);



			}
			break;
			case "paddingStart": {
				


		setPaddingLeft(objValue);



			}
			break;
			case "paddingEnd": {
				


		setPaddingRight(objValue);



			}
			break;
			case "paddingHorizontal": {
				


		setPaddingHorizontal(objValue);



			}
			break;
			case "paddingVertical": {
				


		setPaddingVertical(objValue);



			}
			break;
			case "drawableTint": {
				


		setDrawableTint(objValue);



			}
			break;
			case "drawableTintMode": {
				


		setDrawableTintMode(strValue);



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
			case "textColor": {
return getTextColor();				}
			case "gravity": {
return getGravity();				}
			case "textSize": {
return getTextSize();				}
			case "drawablePadding": {
return this.getDrawablePadding();				}
			case "paddingTop": {
return getPaddingTop();				}
			case "paddingBottom": {
return getPaddingBottom();				}
			case "paddingLeft": {
return getPaddingLeft();				}
			case "paddingRight": {
return getPaddingRight();				}
			case "paddingStart": {
return getPaddingLeft();				}
			case "paddingEnd": {
return getPaddingRight();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return measurableTextView;
	}

	

	public static class MultiSelectionSpinner {
	    /**
	     * Interface definition for a callback to be invoked when
	     * an item in this view has been selected.
	     */
	    public interface OnMultiItemSelectedListener {
	        /**
	         * <p>Callback method to be invoked when an item in this view has been
	         * selected. This callback is invoked only when the newly selected
	         * position is different from the previously selected position or if
	         * there was no selected item.</p>
	         *
	         * Impelmenters can call getItemAtPosition(position) if they need to access the
	         * data associated with the selected item.
	         *
	         * @param view The view within the AdapterView that was clicked
	         * @param positions The position of the view in the adapter
	         */
	        void onItemSelected(View view, List<Integer> positions);

	        /**
	         * Callback method to be invoked when the selection disappears from this
	         * view. The selection can disappear for instance when touch is activated
	         * or when the adapter becomes empty.
	         *
	         * @param view The view within the AdapterView that was clicked
	         * @param positions The position of the view in the adapter
	         */
	        void onNothingSelected(View view, List<Integer> positions);
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

	
	


	private void nativeMakeFrameForChildWidget(int l, int t, int r, int b) {
		ViewImpl.updateBounds(select, 0, 0, r - l, b - t);
		select.getStyle().setProperty("padding-left", measurableTextView.getCompoundPaddingLeft()  + "px");
		select.getStyle().setProperty("padding-right", measurableTextView.getCompoundPaddingRight()  + "px");
		select.getStyle().setProperty("padding-top", measurableTextView.getCompoundPaddingTop()  + "px");
		select.getStyle().setProperty("padding-bottom", measurableTextView.getCompoundPaddingBottom()  + "px");
		updateDrawableBounds(l, t, r, b);
	}
	
    
	private void drawableStateChangedAdditional() {
	}
	
	private Object getTextSize() {
		String fontSize = select.getStyle().getPropertyValue("font-size");
		if (fontSize != null && !fontSize.isEmpty()) {
			return ViewImpl.getPropertyValueAsInt(select, "font-size");
		}
		return null;
	}
	
    
	
	private String getMyText() {
		return "";
	}
	
	


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
	


    private void setGravity(Object objValue) {
        int value = (int) objValue;
        measurableTextView.setGravity(value);
        int major = value & GravityConverter.VERTICAL_GRAVITY_MASK;
        updateTextAlignment();

        switch (major) {
        case GravityConverter.TOP:
            setVerticalAligmentTop();
            break;
        case GravityConverter.BOTTOM:
            setVerticalAligmentBottom();
            break;
        case GravityConverter.CENTER_VERTICAL:
            setVerticalAligmentCenter();
            break;
        default:
        	// default is vertical top
        	setVerticalAligmentTop();
            break;
        }

    }

	private void updateTextAlignment() {
		r.android.text.Layout.Alignment minor = measurableTextView.getAlignmentOfLayout();
		boolean isRtl = false;
		boolean hasTextDirection = measurableTextView.getRawTextDirection() != 0;
		if (hasTextDirection ) {
			r.android.text.TextDirectionHeuristic heuristic =  measurableTextView.getTextDirectionHeuristic();
			String text = (String) getMyText();
			isRtl = heuristic.isRtl(text, 0, text.length());
		}

        switch (minor) {
        case ALIGN_LEFT:
        	setHorizontalAligmentLeft();
        	break;
        case ALIGN_NORMAL:
        	if (hasTextDirection) {
        		if (isRtl) {
        			setHorizontalAligmentRight();
        		} else {
        			setHorizontalAligmentLeft();
        		}
        	}  else {
        		setHorizontalAligmentLeft();
        	}
            break;
        case ALIGN_RIGHT:
        	setHorizontalAligmentRight();
        	break;
        case ALIGN_OPPOSITE:
        	if (hasTextDirection) {
        		if (isRtl) {
        			setHorizontalAligmentLeft();
        		} else {
        			setHorizontalAligmentRight();
        		}
        	} else {
        		setHorizontalAligmentRight();
        	}
            break;
        case ALIGN_CENTER:
            setHorizontalAligmentCenter();
            break;
        default:
        	// default is horizontal left
        	setHorizontalAligmentLeft();
            break;
        }
	}
    
	
	private Object getGravity() {
		com.ashera.view.BaseMeasurableView.VerticalAligment verticalAligment = getVerticalAligment();
		if (verticalAligment == null) {
			verticalAligment = com.ashera.view.BaseMeasurableView.VerticalAligment.top;
		}
		int gravityVertical = 0;
		switch (verticalAligment) {
        case top:
        	gravityVertical = GravityConverter.TOP;
            break;
        case middle:
        	gravityVertical = GravityConverter.CENTER_VERTICAL;
            break;
        case bottom:
        	gravityVertical = GravityConverter.BOTTOM;
            break;
        default:
            //
            break;
        }
		int aligment = getTextAlignment();
		int gravitHorizontal = 0;
		switch (aligment) {
        case TEXT_ALIGN_CENTER:
        	gravitHorizontal = GravityConverter.CENTER_HORIZONTAL;
            break;
        case TEXT_ALIGN_LEFT:
        	gravitHorizontal = GravityConverter.LEFT;
            break;
        case TEXT_ALIGN_RIGHT:
        	gravitHorizontal = GravityConverter.RIGHT;
            break;
        default:
            break;
		}
		int gravity = gravitHorizontal | gravityVertical;
		return gravity;
	}
	
	public void onRtlPropertiesChanged(int layoutDirection) {
		if (measurableTextView.getRawTextAlignment() != 0 || measurableTextView.getRawLayoutDirection() != 0) {
			updateTextAlignment();
		}
	}

	


    private void setPadding(Object objValue) {
    	setPaddingBottom(objValue);
    	setPaddingTop(objValue);
    	setPaddingLeft(objValue);
    	setPaddingRight(objValue);
	}
	
	private void setPaddingLeft(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-left", value  + "px");
		ViewImpl.setPaddingLeft(objValue, measurableTextView);
	}
	
	private void setPaddingRight(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-right", value + "px");
		ViewImpl.setPaddingRight(objValue, measurableTextView);
	}

	private void setPaddingTop(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-top", value + "px");
		ViewImpl.setPaddingTop(objValue, measurableTextView);
	}

	private void setPaddingBottom(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-bottom", value + "px");
		ViewImpl.setPaddingBottom(objValue, measurableTextView);
	}

	private Object getPaddingTop() {
		return measurableTextView.getPaddingTop();
	}

	private Object getPaddingBottom() {
		return measurableTextView.getPaddingBottom();
	}

	private Object getPaddingLeft() {
		return measurableTextView.getPaddingStart();
	}

	private Object getPaddingRight() {
		return measurableTextView.getPaddingEnd();
	}

	private void setPaddingHorizontal(Object objValue) {
		setPaddingLeft(objValue);
		setPaddingRight(objValue);
	}

	private void setPaddingVertical(Object objValue) {
		setPaddingTop(objValue);
		setPaddingBottom(objValue);
	}
	


	private boolean enableTintFilter;
	private HTMLElement drawableLeft;
	private HTMLElement drawableLeftWrapper;
	private HTMLElement drawableTop;
	private HTMLElement drawableTopWrapper;
    private HTMLElement drawableBottom;
    private HTMLElement drawableBottomWrapper;
    private HTMLElement drawableRight;
    private HTMLElement drawableRightWrapper;
	private void setDrawableBottom(Object objValue) {
		if (drawableBottom == null) {
			this.drawableBottomWrapper = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
			this.drawableBottom = org.teavm.jso.dom.html.HTMLDocument.current().createElement("img");
			this.drawableBottom.getStyle().setProperty("width", "inherit");
			this.drawableBottom.getStyle().setProperty("height", "inherit");
			drawableBottomWrapper.appendChild(drawableBottom);
			hTMLElement.appendChild(drawableBottomWrapper);
		}

		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable) objValue;
			measurableTextView.setBottomDrawable(drawable);
			updateImageSrc(drawable, drawableBottom);
		}
	}

	private void setDrawableTop(Object objValue) {
		if (drawableTop == null) {
			this.drawableTopWrapper = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
			this.drawableTop = org.teavm.jso.dom.html.HTMLDocument.current().createElement("img");
			this.drawableTop.getStyle().setProperty("width", "inherit");
			this.drawableTop.getStyle().setProperty("height", "inherit");
			drawableTopWrapper.appendChild(drawableTop);
			hTMLElement.appendChild(drawableTopWrapper);
		}

		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable) objValue;
			measurableTextView.setTopDrawable(drawable);
			updateImageSrc(drawable, drawableTop);
		}
	}

	private void updateImageSrc(r.android.graphics.drawable.Drawable drawable, HTMLElement element) {
		String imageColorOrImage = (String) drawable.getDrawable();
		
		if (imageColorOrImage != null && imageColorOrImage.startsWith("#")) {
			element.getStyle().setProperty("background-color", imageColorOrImage);
			element.removeAttribute("src");
		} else if (imageColorOrImage == null) {
			element.removeAttribute("src");
			element.getStyle().setProperty("background-color", null);
		} else {
			element.setAttribute("src", imageColorOrImage);
			element.getStyle().setProperty("background-color", null);
		}
	}

	private void setDrawableRight(Object objValue) {
		if (ViewImpl.isRTLLayoutDirection(this)) {
			setDrawableLeftInternal(objValue);
		} else {
			setDrawableRightInternal(objValue);
		}
	}

	private void setDrawableRightInternal(Object objValue) {
		if (drawableRight == null) {
			// create bottom
			this.drawableRightWrapper = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
			this.drawableRight = org.teavm.jso.dom.html.HTMLDocument.current().createElement("img");
			this.drawableRight.getStyle().setProperty("width", "inherit");
			this.drawableRight.getStyle().setProperty("height", "inherit");
			drawableRightWrapper.appendChild(drawableRight);
			hTMLElement.appendChild(drawableRightWrapper);
		}

		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable) objValue;
			measurableTextView.setRightDrawable(drawable);
			updateImageSrc(drawable, drawableRight);
		}
	}

	private void setDrawableLeftInternal(Object objValue) {
		if (drawableLeft == null) {
			// create bottom
			this.drawableLeftWrapper = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
			this.drawableLeft = org.teavm.jso.dom.html.HTMLDocument.current().createElement("img");
			this.drawableLeft.getStyle().setProperty("width", "inherit");
			this.drawableLeft.getStyle().setProperty("height", "inherit");
			drawableLeftWrapper.appendChild(drawableLeft);
			hTMLElement.appendChild(drawableLeftWrapper);
		}

		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable) objValue;
			measurableTextView.setLeftDrawable(drawable);
			updateImageSrc(drawable, drawableLeft);
		}
	}

	private void setDrawableLeft(Object objValue) {
		if (ViewImpl.isRTLLayoutDirection(this)) {
			setDrawableRightInternal(objValue);
		} else {
			setDrawableLeftInternal(objValue);
		}
	}

	
	private void setDrawablePadding(Object objValue) {
		measurableTextView.setDrawablePadding((int) objValue);
	}
	
	private Object getDrawablePadding() {
		return measurableTextView.getDrawablePadding();
	}
	
	private void updateDrawableBounds(int l, int t, int r, int b) {
		if (drawableBottom != null) {
			com.ashera.model.RectM bounds = measurableTextView.getBottomDrawableBounds(l, t, r - l, b - t);
			ViewImpl.updateBounds(drawableBottomWrapper, bounds.x, bounds.y, bounds.width, bounds.height);
		}	
		
		if (drawableTop != null) {
			com.ashera.model.RectM bounds = measurableTextView.getTopDrawableBounds(l, t, r - l, b - t);
			ViewImpl.updateBounds(drawableTopWrapper, bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		if (drawableLeft != null) {
			com.ashera.model.RectM bounds = measurableTextView.getLeftDrawableBounds(l, t, r - l, b - t);
			ViewImpl.updateBounds(drawableLeftWrapper, bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		if (drawableRight != null) {
			com.ashera.model.RectM bounds = measurableTextView.getRightDrawableBounds(l, t, r - l, b - t);
			ViewImpl.updateBounds(drawableRightWrapper, bounds.x, bounds.y, bounds.width, bounds.height);
		}
	}
	
	private void setDrawableTintMode(String strValue) {
		//add,multiply,screen,src_atop,src_in,src_over
		String mixBlendMode = "initial";
		String maskComposite = "none";
		switch (strValue) {
		case "add":
			break;
		case "screen":
			mixBlendMode = "screen";
			break;
		case "multiply":
			mixBlendMode = "multiply";
			break;
		case "src_atop":
			maskComposite = "source-atop";
			break;
		case "src_in":
			maskComposite = "source-in";
			break;
		case "src_over":
			maskComposite = "source-over";
			mixBlendMode = "overlay";
			break;
		default:
			break;
		}
		
		setDrawableTintMode(mixBlendMode, maskComposite, drawableBottom,  drawableTop, drawableLeft, drawableRight);
	}
	
	private void setDrawableTintMode(String blendMode, String maskComposite, HTMLElement... htmlElements) {
		for (HTMLElement htmlElement : htmlElements) {
			if (htmlElement != null) {
				htmlElement.getStyle().setProperty("mix-blend-mode", blendMode);
				htmlElement.getStyle().setProperty("-webkit-mask-composite", maskComposite);
			}
		}
	}
	private r.android.content.res.ColorStateList drawableTint;
	private void setDrawableTint(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			objValue = colorStateList.getColorForState(measurableTextView.getDrawableState(), r.android.graphics.Color.RED);
			this.drawableTint = colorStateList;
		}
		
		setDrawableTint(objValue, drawableBottomWrapper, drawableTopWrapper, drawableLeftWrapper, drawableRightWrapper);
	}
	
	private void setDrawableTint(Object objValue, HTMLElement... htmlElements) {
		String filter = null;
		String hexColor = (String) ViewImpl.getColor(objValue);
		if (enableTintFilter) {
			filter = new com.ashera.layout.filter.FilterSolver(hexColor).solve();
		}
		for (HTMLElement htmlElement : htmlElements) {
			if (htmlElement != null) {
				if (filter != null) {
					htmlElement.getStyle().setProperty("filter", filter);
				} else {
					htmlElement.getStyle().setProperty("background-color", hexColor);
				}
			}
		}
	}	
	
	
	
    @Override
	public void drawableStateChanged() {
    	super.drawableStateChanged();
		drawableStateChange(drawableBottom, measurableTextView.getBottomDrawable(), () -> {
			setDrawableBottom(measurableTextView.getBottomDrawable());
		});
		drawableStateChange(drawableLeft, measurableTextView.getLeftDrawable(), () -> {
			setDrawableLeft(measurableTextView.getLeftDrawable());
		});
		drawableStateChange(drawableRight, measurableTextView.getRightDrawable(), () -> {
			setDrawableRight(measurableTextView.getRightDrawable());
		});
		drawableStateChange(drawableTop, measurableTextView.getTopDrawable(), () -> {
			setDrawableTop(measurableTextView.getTopDrawable());
		});
		
		if (measurableTextView.getTextColors() != null) {
			setTextColor(measurableTextView.getCurrentTextColor());
		}
		
		if (drawableTint != null && drawableTint.isStateful()) {
			setDrawableTint(drawableTint);
		}
		drawableStateChangedAdditional();
	}
    
	private void drawableStateChange(HTMLElement mydrawable, r.android.graphics.drawable.Drawable dr, Runnable run) {
		if (mydrawable != null) {
			final int[] state = measurableTextView.getDrawableState();
			
			if (dr != null && dr.isStateful() && dr.setState(state)) {
				run.run();
			}
		}
	}
	


	private void setEnabled(Object objValue) {
		if ((boolean) objValue) {
			hTMLElement.getStyle().setProperty("disabled", "true");
			select.setAttribute("disabled", "true");
		} else {
			hTMLElement.getStyle().removeProperty("disabled");
			select.removeAttribute("disabled");
		}
	}
	


	private Object getTextColor() {
		return measurableTextView.getTextColors();
	}
	private void setTextColor(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			measurableTextView.setTextColor(colorStateList);
			objValue = measurableTextView.getCurrentTextColor();
		}
		hTMLElement.getStyle().setProperty("color", (String) ViewImpl.getColor(objValue));
	}
	


	private void setTextStyle(Object objValue) {
		int value = (int)objValue;
		
		String fontStyle = "normal";
		String fontWeight = "normal";
		if ((value & 0x1) != 0) {
			fontWeight = "bold";
        }
        
        if ((value & 0x2) != 0) {
            fontStyle = "italic";
        }
        select.getStyle().setProperty("font-style", fontStyle);
        select.getStyle().setProperty("font-weight", fontWeight);
	}
	


	private Object getFont() {
		return select.getStyle().getPropertyValue("font-family");
	}
	
	private void setFontFamily(Object objValue, String strValue) {
        if (objValue instanceof Integer) {
            objValue = PluginInvoker.convertFrom(ConverterFactory.get(CommonConverters.font), null, strValue, fragment);
        }
        Map<String, com.ashera.model.FontDescriptor> fontDescriptors = (Map<String, com.ashera.model.FontDescriptor>) objValue;
        
        // hardcoded to normal fontStyle and non bold font as broswer is capabale of fake bold/italics the font
        String weight = "400";
        String fontStyle = "normal";
        com.ashera.model.FontDescriptor fontDescriptor = fontDescriptors.get(fontStyle + "_" + weight);
        select.getStyle().setProperty("font-family", fontDescriptor.getName());
    }

	private void setTypeFace(Object objValue, String strValue) {
		setFontFamily(objValue, strValue);
	}
	


	public void setMyTextSize(Object objValue) {
		select.getStyle().setProperty("font-size", ((float)objValue * getFragment().getRootActivity().getScaleFactor()) + "px" );
	}
	


	private void setHorizontalAligmentRight() {
		hTMLElement.getStyle().setProperty("text-align", "right");
	}

	private void setHorizontalAligmentCenter() {
		hTMLElement.getStyle().setProperty("text-align", "center");
	}

	private void setHorizontalAligmentLeft() {
		hTMLElement.getStyle().setProperty("text-align", "left");
	}
	


	private void setVerticalAligmentCenter() {
		hTMLElement.getStyle().setProperty("vertical-align", "middle");
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.middle);
	}

	private void setVerticalAligmentBottom() {
		hTMLElement.getStyle().setProperty("vertical-align", "bottom");		
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.bottom);
	}

	private void setVerticalAligmentTop() {
		hTMLElement.getStyle().setProperty("vertical-align", "top");		
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.top);
	}
	
	private static final int TEXT_ALIGN_CENTER = 0;
	private static final int TEXT_ALIGN_LEFT = 1;
	private static final int TEXT_ALIGN_RIGHT = 2;
	
	
	
	private com.ashera.view.BaseMeasurableView.VerticalAligment getVerticalAligment() {
		String vAlign = hTMLElement.getStyle().getPropertyValue("vertical-align");
		switch (vAlign) {
		case "middle":
			return com.ashera.view.BaseMeasurableView.VerticalAligment.middle;
		case "top":
			return com.ashera.view.BaseMeasurableView.VerticalAligment.top;
		case "bottom":
			return com.ashera.view.BaseMeasurableView.VerticalAligment.bottom;
		default:
			break;
		}
		return null;
	}
	private int getTextAlignment() {
		String textAlign = hTMLElement.getStyle().getPropertyValue("text-align");
		switch (textAlign) {
		case "center":
			return TEXT_ALIGN_CENTER;
		case "left":
			return TEXT_ALIGN_LEFT;
		case "right":
			return TEXT_ALIGN_RIGHT;
		default:
			break;
		}
		return TEXT_ALIGN_LEFT;
	}
	


    @org.teavm.jso.JSBody(params = { "element" }, script = "return window.nativeMeasureWidth(element, true);")
    private static native int windowNativeMeasureWidth(org.teavm.jso.dom.html.HTMLElement element);
    
    @org.teavm.jso.JSBody(params = { "element", "width" }, script = "return window.nativeMeasureHeight(element, width, true);")
    private static native int windowNativeMeasureHeight(org.teavm.jso.dom.html.HTMLElement element, int width);
    
	public int nativeMeasureHeight(Object uiView, int width) {
		return windowNativeMeasureHeight(select, width);
	}

	public int nativeMeasureWidth(Object uiView) {
		return windowNativeMeasureWidth(select);
	}
	
	


	static class AdapterView<T> {
		public interface OnItemSelectedListener {
			void onItemSelected(AdapterView<?> parent, View view, int position, long id);
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
	        return hTMLElement;
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			measurableTextView.setId(IdGenerator.getId(id));
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
public MultiSelectionSpinnerCommandBuilder setModelOptionTextPath(String value) {
	Map<String, Object> attrs = initCommand("modelOptionTextPath");
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
public MultiSelectionSpinnerCommandBuilder setModelOptionValuePath(String value) {
	Map<String, Object> attrs = initCommand("modelOptionValuePath");
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
public MultiSelectionSpinnerCommandBuilder setValues(String value) {
	Map<String, Object> attrs = initCommand("values");
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
public MultiSelectionSpinnerCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
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
public MultiSelectionSpinnerCommandBuilder setDrawableStart(String value) {
	Map<String, Object> attrs = initCommand("drawableStart");
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
public MultiSelectionSpinnerCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public MultiSelectionSpinnerCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public MultiSelectionSpinnerCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
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
public MultiSelectionSpinnerCommandBuilder setDrawableTintMode(String value) {
	Map<String, Object> attrs = initCommand("drawableTintMode");
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

public void setModelOptionTextPath(String value) {
	getBuilder().reset().setModelOptionTextPath(value).execute(true);
}

public void setOnItemSelected(String value) {
	getBuilder().reset().setOnItemSelected(value).execute(true);
}

public void setModelOptionValuePath(String value) {
	getBuilder().reset().setModelOptionValuePath(value).execute(true);
}

public Object getSelectedValues() {
	return getBuilder().reset().tryGetSelectedValues().execute(false).getSelectedValues(); 
}
public void setSelectedValues(Object value) {
	getBuilder().reset().setSelectedValues(value).execute(true);
}

public void setValues(String value) {
	getBuilder().reset().setValues(value).execute(true);
}

public Object getTextColor() {
	return getBuilder().reset().tryGetTextColor().execute(false).getTextColor(); 
}
public void setTextColor(String value) {
	getBuilder().reset().setTextColor(value).execute(true);
}

public Object getGravity() {
	return getBuilder().reset().tryGetGravity().execute(false).getGravity(); 
}
public void setGravity(String value) {
	getBuilder().reset().setGravity(value).execute(true);
}

public Object getTextSize() {
	return getBuilder().reset().tryGetTextSize().execute(false).getTextSize(); 
}
public void setTextSize(String value) {
	getBuilder().reset().setTextSize(value).execute(true);
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

public void setDrawableLeft(String value) {
	getBuilder().reset().setDrawableLeft(value).execute(true);
}

public void setDrawableRight(String value) {
	getBuilder().reset().setDrawableRight(value).execute(true);
}

public void setDrawableStart(String value) {
	getBuilder().reset().setDrawableStart(value).execute(true);
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

public Object getDrawablePadding() {
	return getBuilder().reset().tryGetDrawablePadding().execute(false).getDrawablePadding(); 
}
public void setDrawablePadding(String value) {
	getBuilder().reset().setDrawablePadding(value).execute(true);
}

public void setEnabled(boolean value) {
	getBuilder().reset().setEnabled(value).execute(true);
}

public void setEditable(boolean value) {
	getBuilder().reset().setEditable(value).execute(true);
}

public void setPadding(String value) {
	getBuilder().reset().setPadding(value).execute(true);
}

public Object getPaddingTop() {
	return getBuilder().reset().tryGetPaddingTop().execute(false).getPaddingTop(); 
}
public void setPaddingTop(String value) {
	getBuilder().reset().setPaddingTop(value).execute(true);
}

public Object getPaddingBottom() {
	return getBuilder().reset().tryGetPaddingBottom().execute(false).getPaddingBottom(); 
}
public void setPaddingBottom(String value) {
	getBuilder().reset().setPaddingBottom(value).execute(true);
}

public Object getPaddingLeft() {
	return getBuilder().reset().tryGetPaddingLeft().execute(false).getPaddingLeft(); 
}
public void setPaddingLeft(String value) {
	getBuilder().reset().setPaddingLeft(value).execute(true);
}

public Object getPaddingRight() {
	return getBuilder().reset().tryGetPaddingRight().execute(false).getPaddingRight(); 
}
public void setPaddingRight(String value) {
	getBuilder().reset().setPaddingRight(value).execute(true);
}

public Object getPaddingStart() {
	return getBuilder().reset().tryGetPaddingStart().execute(false).getPaddingStart(); 
}
public void setPaddingStart(String value) {
	getBuilder().reset().setPaddingStart(value).execute(true);
}

public Object getPaddingEnd() {
	return getBuilder().reset().tryGetPaddingEnd().execute(false).getPaddingEnd(); 
}
public void setPaddingEnd(String value) {
	getBuilder().reset().setPaddingEnd(value).execute(true);
}

public void setPaddingHorizontal(String value) {
	getBuilder().reset().setPaddingHorizontal(value).execute(true);
}

public void setPaddingVertical(String value) {
	getBuilder().reset().setPaddingVertical(value).execute(true);
}

public void setDrawableTint(String value) {
	getBuilder().reset().setDrawableTint(value).execute(true);
}

public void setDrawableTintMode(String value) {
	getBuilder().reset().setDrawableTintMode(value).execute(true);
}

}


    
	//end - body
private HTMLElement select;
	private void nativeCreate(Map<String, Object> params) {
		hTMLElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
		hTMLElement.getStyle().setProperty("box-sizing", "border-box");
		
		select = org.teavm.jso.dom.html.HTMLDocument.current().createElement("select");
		select.getStyle().setProperty("color", "inherit");
		select.getStyle().setProperty("text-align", "inherit");
		select.getStyle().setProperty("box-sizing", "border-box");
		select.setAttribute("multiple", "true");
		hTMLElement.appendChild(select);
		registerForAttributeCommandChain("hint");
		
		if ("true".equals(params.get("webEnableTintFilter"))) {
    		enableTintFilter = true;
    	}
	}
	private void setEntries(Object objValue) {
		select.clear();
		
		for (String entry : ((List<String>) objValue)) {
			HTMLElement option = org.teavm.jso.dom.html.HTMLDocument.current().createElement("option");
			option.getStyle().setProperty("font-weight", "inherit");
			option.setInnerHTML(entry);
			select.appendChild(option);
		}
	}
	
	private void setSelection(Object objValue) {
		List<Integer> selections = (List<Integer>) objValue;
		int childNodes = select.getChildNodes().getLength();

		for (int i = 0; i < childNodes; i++) {
			HTMLElement node = (HTMLElement) select.getChildNodes().item(i);
			setSelected(node, false);
			
			if (selections.contains(i)) {
				setSelected(node, true);
			}
		}
		
	}
	
	 @org.teavm.jso.JSBody(params = { "element", "selected"}, script = "element.selected=selected;")
	private static native void setSelected(org.teavm.jso.dom.html.HTMLElement element, boolean selected);
	
    @org.teavm.jso.JSBody(params = { "element"}, script = "var result = [];var options = element && element.options;"
    		+ "  for (var i=0, iLen=options.length; i<iLen; i++) {"
    		+ "    var opt = options[i];"
    		+ "    if (opt.selected) {"
    		+ "      result.push(i);"
    		+ "    }"
    		+ "  }"
    		+ "  return result;")
    private static native int[] getSelectedIndexes(org.teavm.jso.dom.html.HTMLElement element);
	private void setOnMultiItemSelectedListener(MultiSelectionSpinner.OnMultiItemSelectedListener onMultiItemSelectedListener) {
		org.teavm.jso.dom.events.EventListener<org.teavm.jso.dom.events.KeyboardEvent> listener = (event) -> {
			
			List<Integer> positions = new ArrayList<>();
			for (int position : getSelectedIndexes(select)) {
				positions.add(position);
			}
			onMultiItemSelectedListener.onItemSelected(measurableTextView, positions);
		};
		ViewImpl.setOnListener(this, select, listener, "change", "change");
	}
	@Override
	protected void addItemToParent(int index, java.lang.String id, com.ashera.model.LoopParam loopParam) {
		if (modelOptionTextPath != null) {
			Object val = getOptionValueFromLoopParam(loopParam, modelOptionTextPath);
			HTMLElement option = org.teavm.jso.dom.html.HTMLDocument.current().createElement("option");
			option.getStyle().setProperty("font-weight", "inherit");
			option.setInnerHTML((String) val);
			select.appendChild(option);
		}
	}

    private List<Integer> getSelectedItemPositions() {
    	List<Integer> positions = new ArrayList<>();
		for (int position : getSelectedIndexes(select)) {
			positions.add(position);
		}		
		
		return positions;
	}
    
	@Override
	public boolean isViewVisible() {
		return measurableTextView.getVisibility() == View.VISIBLE;
	}

	@Override
	public void focus() {
		hTMLElement.focus();
	}
	
	private void setError(Object object) {
		
	}
}
