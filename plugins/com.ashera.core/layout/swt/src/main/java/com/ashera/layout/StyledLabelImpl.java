package com.ashera.layout;
//start - imports

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import r.android.content.Context;


import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import androidx.core.view.*;
import static com.ashera.common.DisposeUtil.*;

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
public class StyledLabelImpl extends BaseWidget implements IDrawable, IHasMultiNativeWidgets, ICustomMeasureHeight, ICustomMeasureWidth, com.ashera.validations.ValidationErrorLabel {
	//start - body
	public final static String LOCAL_NAME = "StyledLabel"; 
	public final static String GROUP_NAME = "TextView";

	protected org.eclipse.swt.custom.StyledText styledText;
	protected MeasurableTextView measurableTextView;	
	
		@SuppressLint("NewApi")
		final static class JustificationMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("inter_word",  0x1);
				mapping.put("none",  0x0);
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
		final static class AutoLink  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("all", 0xf);
				mapping.put("email", 0x2);
				mapping.put("map", 0x8);
				mapping.put("none", 0x0);
				mapping.put("phone", 0x4);
				mapping.put("web", 0x1);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
		@Override
		public java.lang.String getAllOption() {
			return "all";
		}
				}
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
		final static class AutoSizeTextType extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none",  0x0);
				mapping.put("uniform",  0x1);
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
		final static class Ellipsize extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("end",  0x3);
				mapping.put("marquee",  0x4);
				mapping.put("middle",  0x2);
				mapping.put("none",  0x0);
				mapping.put("start",  0x1);
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
		final static class MarqueeRepeatLimit extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("marquee_forever",  0xffffffff);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
		@Override
		public boolean supportsIntAlso() {
			return true;
		}
				}
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtText").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtAlwaysShowScrollBars").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtBackground").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtBidiColoring").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtBottomMargin").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtForeground").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtHorizontalIndex").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtHorizontalPixel").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtIndent").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtJustify").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtLeftMargin").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtLineSpacing").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtMarginColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtOrientation").withType("swtbitflag"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtRightMargin").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtSelectionBackground").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtSelectionForeground").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtTabs").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtTextDirection").withType("swtbitflag"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtTextLimit").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtTopIndex").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtTopMargin").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtTopPixel").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtWordWrap").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtWrapIndent").withType("int"));
		ConverterFactory.register("StyledLabel.justificationMode", new JustificationMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("justificationMode").withType("StyledLabel.justificationMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingExtra").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingMultiplier").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textIsSelectable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("singleLine").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("StyledLabel.autoLink", new AutoLink());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoLink").withType("StyledLabel.autoLink").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("linksClickable").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorLink").withType("colorstate").withOrder(-100));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minLines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("height").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("width").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxEms").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minEms").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ems").withType("int"));
		ConverterFactory.register("StyledLabel.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("StyledLabel.font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("StyledLabel.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("StyledLabel.textStyle").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension").withOrder(1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("StyledLabel.autoSizeTextType", new AutoSizeTextType());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizeTextType").withType("StyledLabel.autoSizeTextType").withOrder(1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizeMaxTextSize").withType("dimensionsppxint"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizeMinTextSize").withType("dimensionsppxint"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizeStepGranularity").withType("dimensionsppxint"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLength").withType("int").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAllCaps").withType("boolean").withOrder(-1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("password").withType("boolean").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollHorizontally").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("StyledLabel.ellipsize", new Ellipsize());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ellipsize").withType("StyledLabel.ellipsize"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("startOrStopMarquee").withType("boolean"));
		ConverterFactory.register("StyledLabel.marqueeRepeatLimit", new MarqueeRepeatLimit());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("marqueeRepeatLimit").withType("StyledLabel.marqueeRepeatLimit"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("firstBaselineToTopHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lastBaselineToBottomHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizePresetSizes").withType("array").withArrayType("dimensionsppxint").withArrayListToFinalType("listtointarray"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textFormat").withType("resourcestring").withOrder(-1));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("html").withType("boolean"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("swtTextStyle").withType("string"));
		loadCustomAttributes(attributeName);
	}
	
	public StyledLabelImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class StyledLabelExt extends MeasurableTextView implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public StyledLabelExt() {
			
			
			
			
			
			
			super(StyledLabelImpl.this);
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


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
			ViewImpl.setDrawableBounds(StyledLabelImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(StyledLabelImpl.this);
			
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
				StyledLabelImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(StyledLabelImpl.this);
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
            ((org.eclipse.swt.widgets.Control)asNativeWidget()).setVisible(View.VISIBLE == visibility);
            
        }
	 	@Override
        public boolean suggestedSizeFitsInSpace(int mAutoSizeTextSizeInPx, r.android.graphics.RectF availableSpace) {
        	return StyledLabelImpl.this.suggestedSizeFitsInSpace(mAutoSizeTextSizeInPx, availableSpace.width(), availableSpace.height());
        }
        
        @Override
        protected void setTextSizeInternal(int unit, float optimalTextSize, boolean b) {
        	StyledLabelImpl.this.setMyTextSize(optimalTextSize);
        }
		  public int getBorderPadding(){
		    return StyledLabelImpl.this.getBorderPadding();
		  }

		  public int getLineHeight(){
		    return StyledLabelImpl.this.getLineHeight();
		  }

		  public int getBorderWidth(){
		    return StyledLabelImpl.this.getBorderWidth();
		  }
		  public int getLineHeightPadding(){
		    return StyledLabelImpl.this.getLineHeightPadding();
		  }
		 @Override
		 public void onRtlPropertiesChanged(int layoutDirection) {
			 StyledLabelImpl.this.onRtlPropertiesChanged(layoutDirection);
		 }
	}	
	public void updateMeasuredDimension(int width, int height) {
		((StyledLabelExt) measurableTextView).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new StyledLabelImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableTextView = new StyledLabelExt();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "swtText": {
				


		 styledText.setText((String)objValue);



			}
			break;
			case "swtAlwaysShowScrollBars": {
				


		 styledText.setAlwaysShowScrollBars((boolean)objValue);



			}
			break;
			case "swtBackground": {
				


		 styledText.setBackground((Color)objValue);



			}
			break;
			case "swtBidiColoring": {
				


		 styledText.setBidiColoring((boolean)objValue);



			}
			break;
			case "swtBottomMargin": {
				


		 styledText.setBottomMargin((int)objValue);



			}
			break;
			case "swtForeground": {
				


		 styledText.setForeground((Color)objValue);



			}
			break;
			case "swtHorizontalIndex": {
				


		 styledText.setHorizontalIndex((int)objValue);



			}
			break;
			case "swtHorizontalPixel": {
				


		 styledText.setHorizontalPixel((int)objValue);



			}
			break;
			case "swtIndent": {
				


		 styledText.setIndent((int)objValue);



			}
			break;
			case "swtJustify": {
				


		 styledText.setJustify((boolean)objValue);



			}
			break;
			case "swtLeftMargin": {
				


		 styledText.setLeftMargin((int)objValue);



			}
			break;
			case "swtLineSpacing": {
				


		 styledText.setLineSpacing((int)objValue);



			}
			break;
			case "swtMarginColor": {
				


		 styledText.setMarginColor((Color)objValue);



			}
			break;
			case "swtOrientation": {
				


		 styledText.setOrientation((int)objValue);



			}
			break;
			case "swtRightMargin": {
				


		 styledText.setRightMargin((int)objValue);



			}
			break;
			case "swtSelectionBackground": {
				


		 styledText.setSelectionBackground((Color)objValue);



			}
			break;
			case "swtSelectionForeground": {
				


		 styledText.setSelectionForeground((Color)objValue);



			}
			break;
			case "swtTabs": {
				


		 styledText.setTabs((int)objValue);



			}
			break;
			case "swtTextDirection": {
				


		 styledText.setTextDirection((int)objValue);



			}
			break;
			case "swtTextLimit": {
				


		 styledText.setTextLimit((int)objValue);



			}
			break;
			case "swtTopIndex": {
				


		 styledText.setTopIndex((int)objValue);



			}
			break;
			case "swtTopMargin": {
				


		 styledText.setTopMargin((int)objValue);



			}
			break;
			case "swtTopPixel": {
				


		 styledText.setTopPixel((int)objValue);



			}
			break;
			case "swtWordWrap": {
				


		 styledText.setWordWrap((boolean)objValue);



			}
			break;
			case "swtWrapIndent": {
				


		 styledText.setWrapIndent((int)objValue);



			}
			break;
			case "justificationMode": {
				


		 setJustificationMode(objValue);



			}
			break;
			case "lineSpacingExtra": {
				


		 setLineSpacingExtra(objValue);



			}
			break;
			case "lineSpacingMultiplier": {
				


		 setLineSpacingMultiplier(objValue);



			}
			break;
			case "textIsSelectable": {
				


		 setTextIsSelectable(objValue);



			}
			break;
			case "singleLine": {
				


		 setSingleLine(objValue);



			}
			break;
			case "autoLink": {
				


		 setAutoLink(objValue);



			}
			break;
			case "linksClickable": {
				


		 setLinksClickable(objValue);



			}
			break;
			case "textColorLink": {
				


		 setTextColorLink(objValue);



			}
			break;
			case "text": {
				


		setMyText(objValue);



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
			case "padding": {
				


		setPadding(objValue);



			}
			break;
			case "paddingBottom": {
				


		setPaddingBottom(objValue);



			}
			break;
			case "paddingRight": {
				


		setPaddingRight(objValue);



			}
			break;
			case "paddingLeft": {
				


		setPaddingLeft(objValue);



			}
			break;
			case "paddingStart": {
				


		setPaddingStart(objValue);



			}
			break;
			case "paddingEnd": {
				


		setPaddingEnd(objValue);



			}
			break;
			case "paddingTop": {
				


		setPaddingTop(objValue);



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
			case "minLines": {
				


		 setMinLines(objValue); 



			}
			break;
			case "lines": {
				


		 setLines(objValue); 



			}
			break;
			case "maxLines": {
				


		 setMaxLines(objValue); 



			}
			break;
			case "minWidth": {
				


		 setMinWidth(objValue); 



			}
			break;
			case "minHeight": {
				


		 setMinHeight(objValue); 



			}
			break;
			case "maxWidth": {
				


		 setMaxWidth(objValue); 



			}
			break;
			case "maxHeight": {
				


		 setMaxHeight(objValue); 



			}
			break;
			case "height": {
				


		 setHeight(objValue); 



			}
			break;
			case "width": {
				


		 setWidth(objValue); 



			}
			break;
			case "maxEms": {
				


		 setMaxEms(objValue); 



			}
			break;
			case "minEms": {
				


		 setMinEms(objValue); 



			}
			break;
			case "ems": {
				


		 setEms(objValue); 



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
			case "autoSizeTextType": {
				


		 setAutoSizeTextType(objValue); 



			}
			break;
			case "autoSizeMaxTextSize": {
				


		 setAutoMaxTextSize(objValue); 



			}
			break;
			case "autoSizeMinTextSize": {
				


		 setAutoMinTextSize(objValue); 



			}
			break;
			case "autoSizeStepGranularity": {
				


		 setAutoSizeStepGranularity(objValue); 



			}
			break;
			case "maxLength": {
				


		 setMaxLength(objValue); 



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
			case "textAllCaps": {
				


		 setTextAllCaps(objValue);



			}
			break;
			case "password": {
				


		 setPassword(objValue);



			}
			break;
			case "scrollHorizontally": {
				


		 setScrollHorizontally(objValue);



			}
			break;
			case "ellipsize": {
				


		 setEllipsize(objValue, strValue);



			}
			break;
			case "startOrStopMarquee": {
				


		 startOrStopMarquee(objValue);



			}
			break;
			case "marqueeRepeatLimit": {
				


		 setMarqueeRepeatLimit(objValue);



			}
			break;
			case "firstBaselineToTopHeight": {
				


		setFirstBaselineToTopHeight(objValue);



			}
			break;
			case "lastBaselineToBottomHeight": {
				


		setLastBaselineToBottomHeight(objValue);



			}
			break;
			case "autoSizePresetSizes": {
				


		 setAutoSizePresetSizes(objValue);



			}
			break;
			case "textFormat": {
				


		setTextFormat(objValue);



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
			case "swtText": {
return styledText.getText();				}
			case "swtAlwaysShowScrollBars": {
return styledText.getAlwaysShowScrollBars();				}
			case "swtBackground": {
return styledText.getBackground();				}
			case "swtBidiColoring": {
return styledText.getBidiColoring();				}
			case "swtBottomMargin": {
return styledText.getBottomMargin();				}
			case "swtForeground": {
return styledText.getForeground();				}
			case "swtHorizontalIndex": {
return styledText.getHorizontalIndex();				}
			case "swtHorizontalPixel": {
return styledText.getHorizontalPixel();				}
			case "swtIndent": {
return styledText.getIndent();				}
			case "swtJustify": {
return styledText.getJustify();				}
			case "swtLeftMargin": {
return styledText.getLeftMargin();				}
			case "swtLineSpacing": {
return styledText.getLineSpacing();				}
			case "swtMarginColor": {
return styledText.getMarginColor();				}
			case "swtOrientation": {
return styledText.getOrientation();				}
			case "swtRightMargin": {
return styledText.getRightMargin();				}
			case "swtSelectionBackground": {
return styledText.getSelectionBackground();				}
			case "swtSelectionForeground": {
return styledText.getSelectionForeground();				}
			case "swtTabs": {
return styledText.getTabs();				}
			case "swtTextLimit": {
return styledText.getTextLimit();				}
			case "swtTopIndex": {
return styledText.getTopIndex();				}
			case "swtTopMargin": {
return styledText.getTopMargin();				}
			case "swtTopPixel": {
return styledText.getTopPixel();				}
			case "swtWordWrap": {
return styledText.getWordWrap();				}
			case "swtWrapIndent": {
return styledText.getWrapIndent();				}
			case "justificationMode": {
return getJustificationMode();				}
			case "lineSpacingExtra": {
return getLineSpacingExtra();				}
			case "lineSpacingMultiplier": {
return getLineSpacingMultiplier();				}
			case "textIsSelectable": {
return getTextIsSelectable();				}
			case "autoLink": {
return getAutoLink();				}
			case "linksClickable": {
return getLinksClickable();				}
			case "text": {
return getMyText();				}
			case "textColor": {
return getTextColor();				}
			case "gravity": {
return getGravity();				}
			case "textSize": {
return getTextSize();				}
			case "paddingBottom": {
return getPaddingBottom();				}
			case "paddingRight": {
return getPaddingRight();				}
			case "paddingLeft": {
return getPaddingLeft();				}
			case "paddingStart": {
return getPaddingStart();				}
			case "paddingEnd": {
return getPaddingEnd();				}
			case "paddingTop": {
return getPaddingTop();				}
			case "minLines": {
return getMinLines();				}
			case "maxLines": {
return getMaxLines();				}
			case "minWidth": {
return getMinWidth();				}
			case "minHeight": {
return getMinHeight();				}
			case "maxWidth": {
return getMaxWidth();				}
			case "maxHeight": {
return getMaxHeight();				}
			case "height": {
return getHeight();				}
			case "width": {
return getWidth();				}
			case "maxEms": {
return getMaxEms();				}
			case "minEms": {
return getMinEms();				}
			case "drawablePadding": {
return this.getDrawablePadding();				}
			case "autoSizeTextType": {
return getAutoSizeTextType();				}
			case "autoSizeMaxTextSize": {
return getAutoMaxTextSize();				}
			case "autoSizeMinTextSize": {
return getAutoMinTextSize();				}
			case "autoSizeStepGranularity": {
return getAutoSizeStepGranularity();				}
			case "ellipsize": {
return getEllipsize();				}
			case "marqueeRepeatLimit": {
return getMarqueeRepeatLimit();				}
			case "firstBaselineToTopHeight": {
return getFirstBaselineToTopHeight();				}
			case "lastBaselineToBottomHeight": {
return getLastBaselineToBottomHeight();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return measurableTextView;
	}

	

	private Composite wrapperComposite;

	private void setScrollHorizontally(Object objValue) {
		measurableTextView.setHorizontallyScrolling(objValue != null && (Boolean) objValue);
		
	}
	
	//start - text
	//start - code1
	private void setMyText(Object objValue) {
		String text = (String) objValue;
		if (text == null) {
			text = "";
		}
		
		if (html) {
			handleHtmlText(text);
		} else {
			nativeSetText(text);
		}
	}

    //end - code1
	private Object getMyText() {
		return styledText.getText();
	}
	

	private void nativeSetText(String value) {
		styledText.setText(value);
	}
	//end - text

    @Override
    public Object asNativeWidget() {
        return wrapperComposite;
    }

    
	private void nativeCreate(Map<String, Object> params) {
		if (isHtmlSupported()) {
			initHtml(params);
		}
		Composite parent = (Composite) ViewImpl.getParent(this);
		nativeCreate(parent, params);
	}

	private void nativeCreate(Composite parent, Map<String, Object> params) {
		wrapperComposite = new DrawableComposite(parent, this, getStyle(params, fragment));
		wrapperComposite.setLayout(new org.eclipse.nebula.widgets.layout.AbsoluteLayout());
		
		int textStyle = getStyle("swtTextStyle", org.eclipse.swt.SWT.WRAP, params, fragment) & ~org.eclipse.swt.SWT.MULTI;
		styledText = createStyledText(wrapperComposite, textStyle);
		
		computeLineHeight();
		styledText.addDisposeListener((e) -> {
        	disposeAll(newFont);
        	cancelTimer();
        });
		registerForAttributeCommandChain("text");
	}

	//start - html
	private boolean html;
	private boolean escapeHtml;
	private Map<String, Object> htmlConfig;
	private void initHtml(Map<String, Object> params) {
		if (params.containsKey("html")) {
			html = params.get("html").equals("true");
			if (html) {
				htmlConfig = new HashMap<>();
			} else {
				if (escapeHtml) {
					applyAttributeCommand("text", CommonConverters.command_escapehtml, new String[] {}, true);
				}
			}
		}
	}
	//end - html

    //start - constgravity
	private static final int TEXT_ALIGN_CENTER = org.eclipse.swt.SWT.CENTER;
	private static final int TEXT_ALIGN_LEFT = org.eclipse.swt.SWT.LEFT;
	private static final int TEXT_ALIGN_RIGHT = org.eclipse.swt.SWT.RIGHT;
	//end - constgravity
    //start - gravity
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
		com.ashera.view.BaseMeasurableView.VerticalAligment verticalAligment = measurableTextView.getVerticalAligment();
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

	//end - gravity
	//start - aligment
    //start - valign
	private void setVerticalAligmentCenter() {
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.middle);
	}

	private void setVerticalAligmentBottom() {
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.bottom);
	}

	private void setVerticalAligmentTop() {
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.top);
	}
	//end - valign

    private int getTextAlignment() {
		return styledText.getAlignment();
	}
	private void setHorizontalAligmentCenter() {
		styledText.setAlignment(TEXT_ALIGN_CENTER);
	}

	private void setHorizontalAligmentRight() {
		styledText.setAlignment(org.eclipse.swt.SWT.RIGHT);
	}

	private void setHorizontalAligmentLeft() {
		styledText.setAlignment(org.eclipse.swt.SWT.LEFT);
	}
	//end - aligment
	
	public void nativeRequestLayout() {
		wrapperComposite.requestLayout();
	}
	
	//start - paddingcopy
	private Object getPaddingBottom() {
		return measurableTextView.getPaddingBottom();
	}
	
	private Object getPaddingTop() {
		return measurableTextView.getPaddingTop();
	}

	private Object getPaddingRight() {
		return measurableTextView.getPaddingRight();
	}
	
	private Object getPaddingLeft() {
		return measurableTextView.getPaddingLeft();
	}
	
	private Object getPaddingEnd() {
		return getPaddingRight();
	}
	
	private Object getPaddingStart() {
		return getPaddingLeft();
	}
	
    private void setPaddingVertical(Object objValue) {
    	setPaddingBottom(objValue);
    	setPaddingTop(objValue);
    }

    private void setPaddingHorizontal(Object objValue) {
    	setPaddingRight(objValue);
    	setPaddingLeft(objValue);
    }

	private void setPaddingTop(Object objValue) {
		ViewImpl.setPaddingTop(objValue, measurableTextView);
	}

	private void setPaddingEnd(Object objValue) {
		ViewImpl.setPaddingRight(objValue, measurableTextView);
	}

	private void setPaddingStart(Object objValue) {
		ViewImpl.setPaddingLeft(objValue, measurableTextView);
	}

	private void setPaddingLeft(Object objValue) {
		ViewImpl.setPaddingLeft(objValue, measurableTextView);
	}

	private void setPaddingRight(Object objValue) {
		ViewImpl.setPaddingRight(objValue, measurableTextView);
	}

	private void setPaddingBottom(Object objValue) {
		ViewImpl.setPaddingBottom(objValue, measurableTextView);
	}

    private void setPadding(Object objValue) {
    	setPaddingBottom(objValue);
    	setPaddingTop(objValue);
    	setPaddingRight(objValue);
    	setPaddingLeft(objValue);
    }

    //end - paddingcopy
    //start - font
    private org.eclipse.swt.graphics.Font newFont;
	private static final int ITALIC_FONT_TRAIT = org.eclipse.swt.SWT.ITALIC;
	private static final int BOLD_FONT_TRAIT = org.eclipse.swt.SWT.BOLD;
	private static final int NORMAL_FONT_TRAIT = org.eclipse.swt.SWT.NORMAL;

	//start - code3
    private Map<String, com.ashera.model.FontDescriptor> fontDescriptors ;

    private void setTypeFace(Object objValue, String strValue) {
        setFontFamily(objValue, strValue);
    }
    
    private void setFontFamily(Object objValue, String strValue) {
        if (objValue instanceof Integer) {
            objValue = PluginInvoker.convertFrom(ConverterFactory.get(CommonConverters.font), null, strValue, fragment);
        }
        this.fontDescriptors = (Map<String, com.ashera.model.FontDescriptor>) objValue;
		int style = nativeGetFontStyle();
		int height = nativeGetFontSize();
        
        String weight = "400";
        if ((style & BOLD_FONT_TRAIT) != 0) {
            weight = "700";
        }
        String fontStyle = "normal";
        if ((style & ITALIC_FONT_TRAIT) != 0) {
            fontStyle = "italic";
        }
        com.ashera.model.FontDescriptor fontDescriptor = fontDescriptors.get(fontStyle + "_" + weight);
        nativeSetCustomFont(height, fontDescriptor);
    }

    
    private void setTextStyle(Object objValue) {
        int value = (int)objValue;

        if (fontDescriptors != null) {
            int height = nativeGetFontSize();
            
            String weight = "400";
            if ((value & 0x1) != 0) {
                weight = "700";
            }
            String fontStyle = "normal";
            if ((value & 0x2) != 0) {
                fontStyle = "italic";
            }
            com.ashera.model.FontDescriptor fontDescriptor = fontDescriptors.get(fontStyle + "_" + weight);
            nativeSetCustomFont(height, fontDescriptor);
        } else {
            int style = NORMAL_FONT_TRAIT; 
            if ((value & 0x1) != 0) {
                style = style | BOLD_FONT_TRAIT;
            }
            if ((value & 0x2) != 0) {
                style = style | ITALIC_FONT_TRAIT;
            }       
            nativeSetFontStyle(style);
        }

    }
	//end - code3

	private int nativeGetFontSize() {
		FontData[] fontData = styledText.getFont().getFontData();
        int height = fontData[0].getHeight();
		return height;
	}

	private int nativeGetFontStyle() {
		FontData[] fontData = styledText.getFont().getFontData();
        int style = fontData[0].getStyle();
		return style;
	}

	private void nativeSetCustomFont(int height, com.ashera.model.FontDescriptor fontDescriptor) {
		final org.eclipse.swt.graphics.Font newFont = new org.eclipse.swt.graphics.Font(Display.getDefault(), fontDescriptor.getName(), height, fontDescriptor.getStyle());
		setFont(newFont);
	}

	private void nativeSetFontStyle(int style) {
		FontData[] fontData = styledText.getFont().getFontData();
		for(int i = 0; i < fontData.length; ++i) {
		    fontData[i].setStyle(style);
		}

		final org.eclipse.swt.graphics.Font newFont = new org.eclipse.swt.graphics.Font(Display.getDefault(), fontData);
		setFont(newFont);
	}

    private void setFont(final org.eclipse.swt.graphics.Font newFont) {
        disposeAll(this.newFont);
        this.newFont = newFont;
        setMyFont(newFont);
    }

    private void setMyTextSize(Object objValue) {
        FontData[] fontData = styledText.getFont().getFontData();
        for(int i = 0; i < fontData.length; ++i) {
            float fontSize = ((float) objValue) * getFragment().getRootActivity().getScaleFactor();
			fontData[i].setHeight((int) fontSize);
        }

        final org.eclipse.swt.graphics.Font newFont = new org.eclipse.swt.graphics.Font(Display.getDefault(), fontData);
        setFont(newFont);
    }
    
	
	private void setTextColor(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			measurableTextView.setTextColor(colorStateList);
			objValue = measurableTextView.getCurrentTextColor();
		}
		
		styledText.setForeground((Color)ViewImpl.getColor(objValue));
	}
	
	private Object getTextSize() {
		return styledText.getFont().getFontData()[0].getHeight();
	}

	private Object getTextColor() {
		return measurableTextView.getTextColors();
	}
    //end - font
    
    private void loadCustomAttributes(String attributeName) {
    }
    
    //start - drawable
    private Label drawableTop;
    private Label drawableBottom;
    private Label drawableRight;
	
    @Override
	public void drawableStateChanged() {
    	super.drawableStateChanged();
		drawableStateChange(drawableBottom, measurableTextView.getBottomDrawable(), "drawableBottom");
		drawableStateChange(drawableLeft, measurableTextView.getLeftDrawable(), "drawableLeft");
		drawableStateChange(drawableRight, measurableTextView.getRightDrawable(), "drawableRight");
		drawableStateChange(drawableTop, measurableTextView.getTopDrawable(), "drawableTop");
		
		if (measurableTextView.getTextColors() != null) {
			setTextColor(measurableTextView.getCurrentTextColor());
		}
		drawableStateChangedAdditional();
	}

	private void drawableStateChange(Label mydrawable, r.android.graphics.drawable.Drawable dr, String attribute) {
		if (mydrawable != null) {
			final int[] state = measurableTextView.getDrawableState();
			
			if (dr != null && dr.isStateful() && dr.setState(state)) {
				int width = mydrawable.getBounds().width;
				int height = mydrawable.getBounds().height;
				if (width != 0 && height != 0) { 
					Image image = (Image) dr.getDrawable();
					if (image.getImageData().width != width && image.getImageData().height != height) {
						Image resizedImage = com.ashera.common.ImageUtils.resize(image, width, height, 
								new com.ashera.common.ImageUtils.ResizeOptions.Builder().initFromAttr(this, attribute).build());
						image.dispose();
						image = resizedImage;
						dr.setDrawable(resizedImage);
						fragment.addDisposable(resizedImage);
					}
					mydrawable.setImage(image);
				}
			}
		}
	}
    //start - leftdrawable
    private Label drawableLeft;

	private r.android.graphics.drawable.Drawable getDrawable(Object objValue) {
		r.android.graphics.drawable.Drawable drawable = new r.android.graphics.drawable.Drawable();
		drawable.setMinimumWidth(getImageWidth(objValue));
		drawable.setMinimumHeight(getImageHeight(objValue));
		return drawable;
	}
	
	private int getImageHeight(Object objValue) {
		return ((Image) objValue).getBounds().height;
	}
	
	private int getImageWidth(Object objValue) {
		return ((Image) objValue).getBounds().width;
	}

    //end - leftdrawable
    
	private void setDrawableLeft(Object objValue) {
		if (drawableLeft == null) {
			// create left
			this.drawableLeft = new Label(wrapperComposite, org.eclipse.swt.SWT.NONE);
			drawableLeft.addDisposeListener((e) -> disposeAll(drawableLeft.getImage()));
		}
		
		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable) objValue;
			measurableTextView.setLeftDrawable(drawable);
			disposeAll(drawableLeft.getImage());
			setImageOrColorOnDrawable(drawableLeft, drawable.getDrawable());
		}
	}

	private void setDrawableRight(Object objValue) {		
		if (drawableRight == null) {
			// create right
			this.drawableRight = new Label(wrapperComposite, org.eclipse.swt.SWT.NONE);
			drawableRight.addDisposeListener((e) -> disposeAll(drawableRight.getImage()));
		}

		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable) objValue;
			measurableTextView.setRightDrawable(drawable);
			disposeAll(drawableRight.getImage());
			setImageOrColorOnDrawable(drawableRight,  drawable.getDrawable());
		}
	}
	
	private void setImageOrColorOnDrawable(Label drawable, Object imageOrColor) {
		if (imageOrColor instanceof Color) {
			drawable.setBackground((Color)imageOrColor);
		} else {
			drawable.setBackground(null);
		}
		if (imageOrColor instanceof Image) {
			drawable.setImage((Image) imageOrColor);
		} else {
			drawable.setImage(null);
		}
	}

	private void setDrawableBottom(Object objValue) {
		if (drawableBottom == null) {
			// create bottom
			this.drawableBottom = new Label(wrapperComposite, org.eclipse.swt.SWT.NONE);
			drawableBottom.addDisposeListener((e) -> disposeAll(drawableBottom.getImage()));
		}

		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable) objValue;
			measurableTextView.setBottomDrawable(drawable);
			disposeAll(drawableBottom.getImage());
			setImageOrColorOnDrawable(drawableBottom, drawable.getDrawable());
		}
	}

	private void setDrawableTop(Object objValue) {
		if (drawableTop == null) {
			// create top
			this.drawableTop = new Label(wrapperComposite, org.eclipse.swt.SWT.NONE);
			drawableTop.addDisposeListener((e) -> disposeAll(drawableTop.getImage()));
		}
		
		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable) objValue;
			measurableTextView.setTopDrawable(drawable);
			disposeAll(drawableTop.getImage());
			setImageOrColorOnDrawable(drawableTop,  drawable.getDrawable());
		}
	}

	private void setDrawablePadding(Object objValue) {
		measurableTextView.setDrawablePadding((int) objValue);
	}
	
	private Object getDrawablePadding() {
		return measurableTextView.getDrawablePadding();
	}
	
	@Override
	public Control getControl() {
		return styledText;
	}

	@Override
	public Control getDrawableTop() {
		return drawableTop;
	}

	@Override
	public Control getDrawableLeft() {
		return drawableLeft;
	}

	@Override
	public Control getDrawableRight() {
		return drawableRight;
	}

	@Override
	public Control getDrawableBottom() {
		return drawableBottom;
	}
    //end - drawable
	
    //start - maxminheight
    private Object getMinHeight() {
        return measurableTextView.getMinHeight();
    }

    private Object getMinWidth() {
        return measurableTextView.getMinWidth();
    }
    
    private void setEms(Object objValue) {
        setMinEms(objValue);
        setMaxEms(objValue);
    }
    
    
    public int getMaxEms() {
        return measurableTextView.getMaxEms();
    }
    public int getMinEms() {
        return measurableTextView.getMinEms();
    }

    private void setMinEms(Object objValue) {
    	measurableTextView.setMinEms((int) objValue);
        addMinMaxListener();
    }
    
    public int getMinLines() {
        return measurableTextView.getMinLines();
    }
    
    public int getMaxLines() {
        return measurableTextView.getMaxLines();
    }

    private void setMaxEms(Object objValue) {
    	measurableTextView.setMaxEms((int) objValue);
        addMinMaxListener();
    }

    private void setWidth(Object objValue) {
        setMinWidth(objValue);
        setMaxWidth(objValue);
    }

    private void setHeight(Object objValue) {
        setMinHeight(objValue);
        setMaxHeight(objValue);
    }

    private void setMaxLines(Object objValue) {
    	measurableTextView.setMaxLines((int) objValue);
        addMinMaxListener();
    }

    private void setLines(Object objValue) {
        setMinLines(objValue);
        setMaxLines(objValue);
    }

    private void setMinLines(Object objValue) {
    	measurableTextView.setMinLines((int) objValue);
        addMinMaxListener();
    
    }
    
    private void setMaxHeight(Object objValue) {
    	measurableTextView.setMaxHeight((int) objValue);
        addMinMaxListener();
    }

    private void setMaxWidth(Object objValue) {
    	measurableTextView.setMaxWidth((int) objValue);
        addMinMaxListener();
    }

    public int getMaxWidth() {
        return measurableTextView.getMaxWidth();
    }

    public int getMaxHeight() {
        return measurableTextView.getMaxHeight();
    }
    
    
    private void setMinHeight(Object objValue) {
    	measurableTextView.setMinHeight((int) objValue);
        addMinMaxListener();
    }

    private void setMinWidth(Object objValue) {
    	measurableTextView.setMinWidth((int) objValue);
        addMinMaxListener();
    }

    
    private Object getWidth() {
        return measurableTextView.getWidth();
    }

    private int getHeight() {
        return measurableTextView.getHeight();
    }

    
    //end - maxminheight
    
    //start - autosize
	private int getAutoSizeTextType(MeasurableTextView measurableTextView) {
		return measurableTextView.getAutoSizeTextType();
	}

	private void setAutoSizeTextTypeInternal(int autoTextType) {
		removeResizeListener();
        
		if (measurableTextView.isAutoSizeTextTypeUniform(autoTextType)) {
			measurableTextView.setUpAutoSizeTextTypeUniform(autoSizeMin, autoSizeMax, autoSizeGranular);
            addAutoResizeListener();
        } else {
        	measurableTextView.clearAutoSizeTypeConfiguration();
        }
	}
	
	
	private boolean suggestedSizeFitsInSpace(int suggestedSizeInPx, float width, float height) {
        setMyTextSize(suggestedSizeInPx * 1f);        
        int y = computeSize(width);

        // Height overflow.
		if (y > height) {
            return false;
        }
        return true;
    }
	
	private void setAutoSizePresetSizes(Object objValue) {
		measurableTextView.setAutoSizeTextTypeUniformWithPresetSizes((int[]) objValue, 0);
		
	}

	@com.google.j2objc.annotations.WeakOuter
	class PostMeasureHandler extends com.ashera.widget.bus.EventBusHandler {
		private boolean onlyOnce;
		public PostMeasureHandler(String type) {
			super(type);
		}

		@Override
		protected void doPerform(Object payload) {
			if (!onlyOnce || measurableTextView.isLayoutRequested()) {
				measurableTextView.autoResizeText();
				onlyOnce = true;
			}
		}
	}
	
	private PostMeasureHandler postMeasureHandler;
	private final String POST_MEASURE_EVENT = StandardEvents.postMeasure.toString();
    private void addAutoResizeListener() {
    	if (postMeasureHandler == null) {
    		postMeasureHandler = new PostMeasureHandler(POST_MEASURE_EVENT);
			fragment.getEventBus().on(POST_MEASURE_EVENT, postMeasureHandler);
    	}
	}

	private void removeResizeListener() {
		if (postMeasureHandler != null) {
			fragment.getEventBus().off(postMeasureHandler);
			postMeasureHandler = null;
		}
	}

	private int computeSize(float width) {
		return measurableTextView.nativeMeasureHeight(styledText, (int) width);
	}
    
    //end - autosize

	//start - maxlength
	private void setMaxLength(Object objValue) {
		if (!html) {
			applyAttributeCommand("text", CommonConverters.command_maxlength, new String[] {"maxLength"}, true, objValue);
		} else {
			htmlConfig.put("maxLength", objValue);
		}
	}
    //end - maxlength

	
    //start - enabled
	private void setEnabled(Object objValue) {
		styledText.setEnabled((boolean) objValue);
	}
	//end - enabled

	//start - textallcaps
	//start - code2

	private void setTextAllCaps(Object objValue) {
		if (!html) {
			applyAttributeCommand("text", CommonConverters.command_uppercase, new String[] {"textAllCaps"}, (boolean) objValue);
		} else {
			htmlConfig.put("textAllCaps", objValue);
		}
	}
	//end - code2

	//end - textallcaps

	//start - nativewidgets
	@Override
    public List<Object> getNativeWidgets() {
		return java.util.Arrays.asList(wrapperComposite, styledText, drawableBottom, drawableLeft, drawableTop, drawableRight).
        		stream().filter((p) -> p != null).collect(java.util.stream.Collectors.toList());
    }
	//end - nativewidgets
    
    //start - password
  	private void setPassword(Object objValue) {
  		if (!html) {
  			applyAttributeCommand("text", CommonConverters.command_password, new String[] {"password"}, (boolean) objValue);
  		} else {
  			htmlConfig.put("password", objValue);
  		}
  	}
  	//end - password
  	

  	//start - dimenmeasure
	@Override
	public int measureHeight(int width) {
		int wrapperCompositeHeight = wrapperComposite.computeSize(width, org.eclipse.swt.SWT.DEFAULT).y;
		return styledText.computeSize(width, org.eclipse.swt.SWT.DEFAULT).y + wrapperCompositeHeight;
	}

	@Override
	public int measureWidth() {
		int wrapperCompositeWidth = wrapperComposite.computeSize(org.eclipse.swt.SWT.DEFAULT, org.eclipse.swt.SWT.DEFAULT).y;
		return styledText.computeSize(org.eclipse.swt.SWT.DEFAULT, org.eclipse.swt.SWT.DEFAULT).x + wrapperCompositeWidth;
	}
	//end - dimenmeasure
	
	
    //start - ellipsize
	private void setEllipsize(Object objValue, String strValue) {
		styledText.setData("ellipsize", (int) objValue);

		cancelTimer();
		if (strValue.equals("marquee")) {
			startTimer();	
			
		}
		if (isInitialised()) {
			styledText.redraw();
		}
	}

	private Object getEllipsize() {
		return styledText.getData("ellipsize");
	}
	//end - ellipsize

	//start - marquee
	//start - widgetmarquee
    private MarqueeTask marqueeTask;
	private int marqueeRepeatLimit;
    private MarqueeCommandConverter marqueeCommandConverter;
	
    private int calcNumberOfWhiteSpaces() {
		if (!isLabelMeasured()) {
			return 0;
		}

		float blankSpaceWidth = ((Number) getTextSize()).floatValue();
		int width = getLabelWidth()/3;
		int numberOfBlankSpaces = (int) Math.ceil(width / (blankSpaceWidth * 1f));
		return numberOfBlankSpaces;
	}
	
	private void cancelTimer() {
		cancelNativeTimer();
		if (marqueeTask != null) {
			marqueeTask.cancel();
		}
		if (marqueeCommandConverter != null) {
			marqueeCommandConverter.updateArgs(0, 0);
		}
	}
	private void startTimer() {
		if (canMarquee()) {
			addDeallocHandler();
			if (marqueeTask != null) {
				marqueeTask.restart();
			} else {
				String direction = ViewImpl.isRTLLayoutDirection(this) ? "reverse" : "forward";
				marqueeTask = new MarqueeTask(direction);
			}
			
			schedule();
		}
	}

	@com.google.j2objc.annotations.WeakOuter
	private final class MarqueeTask implements Runnable {
		private int slideLength = 0;
		private int cycles = 0;
		private boolean cancel = false;
		private String direction;
		
		
		private MarqueeTask(String direction) {
			this.direction = direction;
		}

		public void cancel() {
			cancel = true;
		}

		public void restart() {
			cancel = false;
			slideLength = 0;
			cycles = 0;
		}

		@Override
		public void run() {
			int numberOfBlankSpaces = calcNumberOfWhiteSpaces();
			if (marqueeCommandConverter == null) {
				marqueeCommandConverter = (MarqueeCommandConverter) getAttributeCommand("text", CommonConverters.command_marquee, numberOfBlankSpaces, 0, direction);
			}
			slideLength = marqueeCommandConverter.getOffset();
			if (numberOfBlankSpaces > 0) {
				String str = (String) getMyText();
				if (slideLength == str.length()) {
					slideLength = 0;
					cycles++;
				}
				if ((marqueeRepeatLimit > 0 && cycles >= marqueeRepeatLimit)) {
					cancelTimer();
					return;
				}
				slideLength++;

				executeOnMainThread(() -> {
						if (!cancel) {
							applyAttributeCommand("text", CommonConverters.command_marquee, new String[] {"ellipsize"}, true, numberOfBlankSpaces, slideLength, direction);
							schedule();
						}
					
				});
			} else {
				schedule();
			}
		}
	}
	
	private Object getMarqueeRepeatLimit() {
		return marqueeRepeatLimit;
	}
	
	private void setMarqueeRepeatLimit(Object objValue) {
		this.marqueeRepeatLimit = (int) objValue;
	}
	

	private void startOrStopMarquee(Object objValue) {
		cancelTimer();
		if (objValue != null && (boolean) objValue) {
			startTimer();
		}
	}
	
	private int getLabelWidth() {
		if (measurableTextView.isIgnoreDrawableHeight()) {
			return measurableTextView.getMeasuredWidth() - measurableTextView.getPaddingLeft() - measurableTextView.getPaddingRight(); 
		}
		return measurableTextView.getMeasuredWidth() - measurableTextView.getCompoundPaddingRight() - measurableTextView.getCompoundPaddingLeft();
	}

	private boolean isLabelMeasured() {
		return !isDisposed() && getLabelWidth() > 0;
	}
	//end - widgetmarquee
	private void addDeallocHandler() {
		
	}
//	java.util.concurrent.ScheduledExecutorService scheduledExecutorService;
//	java.util.Timer timer;
	private void schedule() {
		Display.getDefault().timerExec(100, marqueeTask);
//		scheduledExecutorService = java.util.concurrent.Executors.newScheduledThreadPool(1);
//		scheduledExecutorService.schedule(task, 100, java.util.concurrent.TimeUnit.MILLISECONDS);
//		if (timer == null) {
//			timer = new java.util.Timer();
//			timer.scheduleAtFixedRate(new java.util.TimerTask() {
//	
//				@Override
//				public void run() {
//					task.run();
//				}
//			}, 0, 100);
//		}
	}
	
	private void executeOnMainThread(Runnable run) {
//		if (!cLabel.isDisposed()) {
//			Display.getDefault().asyncExec(run);
//		}
		run.run();
	}
	

	private void cancelNativeTimer() {
//		timer.cancel();
//		timer = null;
	}


	private boolean isDisposed() {
		return styledText.isDisposed();
	}

	private boolean canMarquee() {
		return (styledText.getStyle() & org.eclipse.swt.SWT.WRAP) == 0 && !html;
	}
	//end - marquee

	//start - baseline
	private void setFirstBaselineToTopHeight(Object objValue) {
		com.ashera.model.FontMetricsDescriptor fontMetrics = PluginInvoker.getFontMetrics(getFont());
		int firstBaselineToTopHeight = (int) objValue;

		final int fontMetricsTop;
        if (getIncludeFontPadding()) {
            fontMetricsTop = fontMetrics.top;
        } else {
            fontMetricsTop = fontMetrics.ascent;
        }

        // TODO: Decide if we want to ignore density ratio (i.e. when the user changes font size
        // in settings). At the moment, we don't.
        if (firstBaselineToTopHeight > Math.abs(fontMetricsTop)) {
            final int paddingTop = firstBaselineToTopHeight - (-fontMetricsTop);
           measurableTextView.setPadding((int) getPaddingLeft(), paddingTop, (int) getPaddingRight(), (int) getPaddingBottom());
        }
	}
	
	
	private boolean getIncludeFontPadding() {
		return false;
	}

	private Object getFirstBaselineToTopHeight() {
		com.ashera.model.FontMetricsDescriptor fontMetrics = PluginInvoker.getFontMetrics(getFont());
		return (int) getPaddingTop() - fontMetrics.top;
	}
	
	
	private void setLastBaselineToBottomHeight(Object objValue) {
		com.ashera.model.FontMetricsDescriptor fontMetrics = PluginInvoker.getFontMetrics(getFont());
		int lastBaselineToBottomHeight = (int) objValue;

        final int fontMetricsBottom;
        if (getIncludeFontPadding()) {
            fontMetricsBottom = fontMetrics.bottom;
        } else {
            fontMetricsBottom = fontMetrics.descent;
        }

        // TODO: Decide if we want to ignore density ratio (i.e. when the user changes font size
        // in settings). At the moment, we don't.

        if (lastBaselineToBottomHeight > Math.abs(fontMetricsBottom)) {
            final int paddingBottom = lastBaselineToBottomHeight - fontMetricsBottom;
            measurableTextView.setPadding((int) getPaddingLeft(), (int) getPaddingTop(), (int) getPaddingRight(), paddingBottom);
        }		
	}
	
	private Object getLastBaselineToBottomHeight() {
		com.ashera.model.FontMetricsDescriptor fontMetrics = PluginInvoker.getFontMetrics(getFont());
		return (int) getPaddingBottom() + fontMetrics.bottom;
	}
	//end - baseline

	private org.eclipse.swt.graphics.Font getFont() {
		return styledText.getFont();
	}
	


    private int autoSizeMin = -1;
    private int autoSizeMax = -1;
    private int autoSizeGranular = -1;
    
	
	private void setAutoSizeStepGranularity(Object objValue) {
		autoSizeGranular = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(measurableTextView));
		}
	}

	private void setAutoMinTextSize(Object objValue) {
		autoSizeMin = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(measurableTextView));
		}
	}

	private void setAutoMaxTextSize(Object objValue) {
		autoSizeMax = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(measurableTextView));
		}
	}
	
    
    private void setAutoSizeTextType(Object objValue) {
    	int autoTextType = (int)objValue;
    	setAutoSizeTextTypeInternal(autoTextType);
    }

	private Object getAutoSizeStepGranularity() {
		return autoSizeGranular;
	}

	private Object getAutoMinTextSize() {
		return autoSizeMin;
	}

	private Object getAutoMaxTextSize() {
		return autoSizeMax;
	}

	private Object getAutoSizeTextType() {
		return getAutoSizeTextType(measurableTextView);
	}
	


	public void setErrorMessage(String message) {
		getBuilder().setText(message).setVisibility(message == null || message.isEmpty() ? "gone" : "visible").execute(true);
		
	}
	


	private void setTextFormat(Object objValue) {
		applyAttributeCommand("text", CommonConverters.command_textformatter, new String[] {"textFormat"}, true, (String) objValue);
	}
	

	
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			measurableTextView.setId(IdGenerator.getId(id));
		}
	}
	
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
    }
	public int getStyle(String key, int initStyle, Map<String, Object> params, IFragment fragment) {
		if (params == null) {
    		return initStyle;
    	}
    	Object style = params.get(key);
		if (style == null) {
			return initStyle;
		}
		int convertFrom = (int) ConverterFactory.get("swtbitflag").convertFrom(style.toString(), null, fragment);
		return convertFrom;
	}
	
	public int getStyle(Map<String, Object> params, IFragment fragment) {
		return getStyle("swtStyle", org.eclipse.swt.SWT.NONE, params, fragment);
	}
	
	public int getStyle(int initStyle, Map<String, Object> params, IFragment fragment) {
		return getStyle("swtStyle", initStyle, params, fragment);
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
    
	
private StyledLabelCommandBuilder builder;
private StyledLabelBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public StyledLabelBean getBean() {
	if (bean == null) {
		bean = new StyledLabelBean();
	}
	return bean;
}
public StyledLabelCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new StyledLabelCommandBuilder();
	}
	return builder;
}


public  class StyledLabelCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <StyledLabelCommandBuilder> {
    public StyledLabelCommandBuilder() {
	}
	
	public StyledLabelCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public StyledLabelCommandBuilder tryGetSwtText() {
	Map<String, Object> attrs = initCommand("swtText");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtText() {
	Map<String, Object> attrs = initCommand("swtText");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtText(String value) {
	Map<String, Object> attrs = initCommand("swtText");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtAlwaysShowScrollBars() {
	Map<String, Object> attrs = initCommand("swtAlwaysShowScrollBars");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isSwtAlwaysShowScrollBars() {
	Map<String, Object> attrs = initCommand("swtAlwaysShowScrollBars");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtAlwaysShowScrollBars(boolean value) {
	Map<String, Object> attrs = initCommand("swtAlwaysShowScrollBars");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtBackground() {
	Map<String, Object> attrs = initCommand("swtBackground");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtBackground() {
	Map<String, Object> attrs = initCommand("swtBackground");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtBackground(String value) {
	Map<String, Object> attrs = initCommand("swtBackground");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtBidiColoring() {
	Map<String, Object> attrs = initCommand("swtBidiColoring");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isSwtBidiColoring() {
	Map<String, Object> attrs = initCommand("swtBidiColoring");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtBidiColoring(boolean value) {
	Map<String, Object> attrs = initCommand("swtBidiColoring");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtBottomMargin() {
	Map<String, Object> attrs = initCommand("swtBottomMargin");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtBottomMargin() {
	Map<String, Object> attrs = initCommand("swtBottomMargin");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtBottomMargin(String value) {
	Map<String, Object> attrs = initCommand("swtBottomMargin");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtForeground() {
	Map<String, Object> attrs = initCommand("swtForeground");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtForeground() {
	Map<String, Object> attrs = initCommand("swtForeground");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtForeground(String value) {
	Map<String, Object> attrs = initCommand("swtForeground");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtHorizontalIndex() {
	Map<String, Object> attrs = initCommand("swtHorizontalIndex");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtHorizontalIndex() {
	Map<String, Object> attrs = initCommand("swtHorizontalIndex");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtHorizontalIndex(int value) {
	Map<String, Object> attrs = initCommand("swtHorizontalIndex");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtHorizontalPixel() {
	Map<String, Object> attrs = initCommand("swtHorizontalPixel");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtHorizontalPixel() {
	Map<String, Object> attrs = initCommand("swtHorizontalPixel");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtHorizontalPixel(int value) {
	Map<String, Object> attrs = initCommand("swtHorizontalPixel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtIndent() {
	Map<String, Object> attrs = initCommand("swtIndent");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtIndent() {
	Map<String, Object> attrs = initCommand("swtIndent");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtIndent(int value) {
	Map<String, Object> attrs = initCommand("swtIndent");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtJustify() {
	Map<String, Object> attrs = initCommand("swtJustify");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isSwtJustify() {
	Map<String, Object> attrs = initCommand("swtJustify");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtJustify(boolean value) {
	Map<String, Object> attrs = initCommand("swtJustify");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtLeftMargin() {
	Map<String, Object> attrs = initCommand("swtLeftMargin");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtLeftMargin() {
	Map<String, Object> attrs = initCommand("swtLeftMargin");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtLeftMargin(String value) {
	Map<String, Object> attrs = initCommand("swtLeftMargin");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtLineSpacing() {
	Map<String, Object> attrs = initCommand("swtLineSpacing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtLineSpacing() {
	Map<String, Object> attrs = initCommand("swtLineSpacing");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtLineSpacing(int value) {
	Map<String, Object> attrs = initCommand("swtLineSpacing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtMarginColor() {
	Map<String, Object> attrs = initCommand("swtMarginColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtMarginColor() {
	Map<String, Object> attrs = initCommand("swtMarginColor");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtMarginColor(String value) {
	Map<String, Object> attrs = initCommand("swtMarginColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtOrientation() {
	Map<String, Object> attrs = initCommand("swtOrientation");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtOrientation() {
	Map<String, Object> attrs = initCommand("swtOrientation");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtOrientation(String value) {
	Map<String, Object> attrs = initCommand("swtOrientation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtRightMargin() {
	Map<String, Object> attrs = initCommand("swtRightMargin");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtRightMargin() {
	Map<String, Object> attrs = initCommand("swtRightMargin");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtRightMargin(String value) {
	Map<String, Object> attrs = initCommand("swtRightMargin");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtSelectionBackground() {
	Map<String, Object> attrs = initCommand("swtSelectionBackground");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtSelectionBackground() {
	Map<String, Object> attrs = initCommand("swtSelectionBackground");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtSelectionBackground(String value) {
	Map<String, Object> attrs = initCommand("swtSelectionBackground");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtSelectionForeground() {
	Map<String, Object> attrs = initCommand("swtSelectionForeground");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtSelectionForeground() {
	Map<String, Object> attrs = initCommand("swtSelectionForeground");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtSelectionForeground(String value) {
	Map<String, Object> attrs = initCommand("swtSelectionForeground");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtTabs() {
	Map<String, Object> attrs = initCommand("swtTabs");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtTabs() {
	Map<String, Object> attrs = initCommand("swtTabs");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtTabs(int value) {
	Map<String, Object> attrs = initCommand("swtTabs");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setSwtTextDirection(String value) {
	Map<String, Object> attrs = initCommand("swtTextDirection");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtTextLimit() {
	Map<String, Object> attrs = initCommand("swtTextLimit");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtTextLimit() {
	Map<String, Object> attrs = initCommand("swtTextLimit");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtTextLimit(int value) {
	Map<String, Object> attrs = initCommand("swtTextLimit");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtTopIndex() {
	Map<String, Object> attrs = initCommand("swtTopIndex");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtTopIndex() {
	Map<String, Object> attrs = initCommand("swtTopIndex");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtTopIndex(int value) {
	Map<String, Object> attrs = initCommand("swtTopIndex");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtTopMargin() {
	Map<String, Object> attrs = initCommand("swtTopMargin");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtTopMargin() {
	Map<String, Object> attrs = initCommand("swtTopMargin");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtTopMargin(String value) {
	Map<String, Object> attrs = initCommand("swtTopMargin");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtTopPixel() {
	Map<String, Object> attrs = initCommand("swtTopPixel");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtTopPixel() {
	Map<String, Object> attrs = initCommand("swtTopPixel");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtTopPixel(int value) {
	Map<String, Object> attrs = initCommand("swtTopPixel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtWordWrap() {
	Map<String, Object> attrs = initCommand("swtWordWrap");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isSwtWordWrap() {
	Map<String, Object> attrs = initCommand("swtWordWrap");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtWordWrap(boolean value) {
	Map<String, Object> attrs = initCommand("swtWordWrap");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetSwtWrapIndent() {
	Map<String, Object> attrs = initCommand("swtWrapIndent");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtWrapIndent() {
	Map<String, Object> attrs = initCommand("swtWrapIndent");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setSwtWrapIndent(int value) {
	Map<String, Object> attrs = initCommand("swtWrapIndent");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setJustificationMode(String value) {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetLineSpacingExtra() {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineSpacingExtra() {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setLineSpacingExtra(String value) {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetLineSpacingMultiplier() {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineSpacingMultiplier() {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setLineSpacingMultiplier(float value) {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetTextIsSelectable() {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isTextIsSelectable() {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setTextIsSelectable(boolean value) {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setSingleLine(boolean value) {
	Map<String, Object> attrs = initCommand("singleLine");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetAutoLink() {
	Map<String, Object> attrs = initCommand("autoLink");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoLink() {
	Map<String, Object> attrs = initCommand("autoLink");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setAutoLink(String value) {
	Map<String, Object> attrs = initCommand("autoLink");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetLinksClickable() {
	Map<String, Object> attrs = initCommand("linksClickable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLinksClickable() {
	Map<String, Object> attrs = initCommand("linksClickable");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setLinksClickable(boolean value) {
	Map<String, Object> attrs = initCommand("linksClickable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setTextColorLink(String value) {
	Map<String, Object> attrs = initCommand("textColorLink");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetText() {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getText() {
	Map<String, Object> attrs = initCommand("text");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setText(String value) {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMinLines(int value) {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setLines(int value) {
	Map<String, Object> attrs = initCommand("lines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMaxLines(int value) {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMinWidth(String value) {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMinHeight(String value) {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetHeight() {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHeight() {
	Map<String, Object> attrs = initCommand("height");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setHeight(String value) {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetWidth() {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getWidth() {
	Map<String, Object> attrs = initCommand("width");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setWidth(String value) {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMaxEms(int value) {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMinEms(int value) {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setEms(int value) {
	Map<String, Object> attrs = initCommand("ems");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setTypeface(String value) {
	Map<String, Object> attrs = initCommand("typeface");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setTextStyle(String value) {
	Map<String, Object> attrs = initCommand("textStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setFontFamily(String value) {
	Map<String, Object> attrs = initCommand("fontFamily");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setDrawableRight(String value) {
	Map<String, Object> attrs = initCommand("drawableRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setDrawableStart(String value) {
	Map<String, Object> attrs = initCommand("drawableStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setDrawableEnd(String value) {
	Map<String, Object> attrs = initCommand("drawableEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setDrawableTop(String value) {
	Map<String, Object> attrs = initCommand("drawableTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setDrawableBottom(String value) {
	Map<String, Object> attrs = initCommand("drawableBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setDrawablePadding(String value) {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetAutoSizeTextType() {
	Map<String, Object> attrs = initCommand("autoSizeTextType");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoSizeTextType() {
	Map<String, Object> attrs = initCommand("autoSizeTextType");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setAutoSizeTextType(String value) {
	Map<String, Object> attrs = initCommand("autoSizeTextType");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetAutoSizeMaxTextSize() {
	Map<String, Object> attrs = initCommand("autoSizeMaxTextSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoSizeMaxTextSize() {
	Map<String, Object> attrs = initCommand("autoSizeMaxTextSize");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setAutoSizeMaxTextSize(String value) {
	Map<String, Object> attrs = initCommand("autoSizeMaxTextSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetAutoSizeMinTextSize() {
	Map<String, Object> attrs = initCommand("autoSizeMinTextSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoSizeMinTextSize() {
	Map<String, Object> attrs = initCommand("autoSizeMinTextSize");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setAutoSizeMinTextSize(String value) {
	Map<String, Object> attrs = initCommand("autoSizeMinTextSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetAutoSizeStepGranularity() {
	Map<String, Object> attrs = initCommand("autoSizeStepGranularity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoSizeStepGranularity() {
	Map<String, Object> attrs = initCommand("autoSizeStepGranularity");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setAutoSizeStepGranularity(String value) {
	Map<String, Object> attrs = initCommand("autoSizeStepGranularity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setMaxLength(int value) {
	Map<String, Object> attrs = initCommand("maxLength");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setEditable(boolean value) {
	Map<String, Object> attrs = initCommand("editable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setTextAllCaps(boolean value) {
	Map<String, Object> attrs = initCommand("textAllCaps");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setPassword(boolean value) {
	Map<String, Object> attrs = initCommand("password");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setScrollHorizontally(boolean value) {
	Map<String, Object> attrs = initCommand("scrollHorizontally");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetEllipsize() {
	Map<String, Object> attrs = initCommand("ellipsize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getEllipsize() {
	Map<String, Object> attrs = initCommand("ellipsize");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setEllipsize(String value) {
	Map<String, Object> attrs = initCommand("ellipsize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setStartOrStopMarquee(boolean value) {
	Map<String, Object> attrs = initCommand("startOrStopMarquee");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetMarqueeRepeatLimit() {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMarqueeRepeatLimit() {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setMarqueeRepeatLimit(String value) {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setFirstBaselineToTopHeight(String value) {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder tryGetLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	return attrs.get("commandReturnValue");
}
public StyledLabelCommandBuilder setLastBaselineToBottomHeight(String value) {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setAutoSizePresetSizes(String value) {
	Map<String, Object> attrs = initCommand("autoSizePresetSizes");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public StyledLabelCommandBuilder setTextFormat(String value) {
	Map<String, Object> attrs = initCommand("textFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class StyledLabelBean extends com.ashera.layout.ViewImpl.ViewBean{
		public StyledLabelBean() {
			super(StyledLabelImpl.this);
		}
public Object getSwtText() {
	return getBuilder().reset().tryGetSwtText().execute(false).getSwtText(); 
}
public void setSwtText(String value) {
	getBuilder().reset().setSwtText(value).execute(true);
}

public Object isSwtAlwaysShowScrollBars() {
	return getBuilder().reset().tryGetSwtAlwaysShowScrollBars().execute(false).isSwtAlwaysShowScrollBars(); 
}
public void setSwtAlwaysShowScrollBars(boolean value) {
	getBuilder().reset().setSwtAlwaysShowScrollBars(value).execute(true);
}

public Object getSwtBackground() {
	return getBuilder().reset().tryGetSwtBackground().execute(false).getSwtBackground(); 
}
public void setSwtBackground(String value) {
	getBuilder().reset().setSwtBackground(value).execute(true);
}

public Object isSwtBidiColoring() {
	return getBuilder().reset().tryGetSwtBidiColoring().execute(false).isSwtBidiColoring(); 
}
public void setSwtBidiColoring(boolean value) {
	getBuilder().reset().setSwtBidiColoring(value).execute(true);
}

public Object getSwtBottomMargin() {
	return getBuilder().reset().tryGetSwtBottomMargin().execute(false).getSwtBottomMargin(); 
}
public void setSwtBottomMargin(String value) {
	getBuilder().reset().setSwtBottomMargin(value).execute(true);
}

public Object getSwtForeground() {
	return getBuilder().reset().tryGetSwtForeground().execute(false).getSwtForeground(); 
}
public void setSwtForeground(String value) {
	getBuilder().reset().setSwtForeground(value).execute(true);
}

public Object getSwtHorizontalIndex() {
	return getBuilder().reset().tryGetSwtHorizontalIndex().execute(false).getSwtHorizontalIndex(); 
}
public void setSwtHorizontalIndex(int value) {
	getBuilder().reset().setSwtHorizontalIndex(value).execute(true);
}

public Object getSwtHorizontalPixel() {
	return getBuilder().reset().tryGetSwtHorizontalPixel().execute(false).getSwtHorizontalPixel(); 
}
public void setSwtHorizontalPixel(int value) {
	getBuilder().reset().setSwtHorizontalPixel(value).execute(true);
}

public Object getSwtIndent() {
	return getBuilder().reset().tryGetSwtIndent().execute(false).getSwtIndent(); 
}
public void setSwtIndent(int value) {
	getBuilder().reset().setSwtIndent(value).execute(true);
}

public Object isSwtJustify() {
	return getBuilder().reset().tryGetSwtJustify().execute(false).isSwtJustify(); 
}
public void setSwtJustify(boolean value) {
	getBuilder().reset().setSwtJustify(value).execute(true);
}

public Object getSwtLeftMargin() {
	return getBuilder().reset().tryGetSwtLeftMargin().execute(false).getSwtLeftMargin(); 
}
public void setSwtLeftMargin(String value) {
	getBuilder().reset().setSwtLeftMargin(value).execute(true);
}

public Object getSwtLineSpacing() {
	return getBuilder().reset().tryGetSwtLineSpacing().execute(false).getSwtLineSpacing(); 
}
public void setSwtLineSpacing(int value) {
	getBuilder().reset().setSwtLineSpacing(value).execute(true);
}

public Object getSwtMarginColor() {
	return getBuilder().reset().tryGetSwtMarginColor().execute(false).getSwtMarginColor(); 
}
public void setSwtMarginColor(String value) {
	getBuilder().reset().setSwtMarginColor(value).execute(true);
}

public Object getSwtOrientation() {
	return getBuilder().reset().tryGetSwtOrientation().execute(false).getSwtOrientation(); 
}
public void setSwtOrientation(String value) {
	getBuilder().reset().setSwtOrientation(value).execute(true);
}

public Object getSwtRightMargin() {
	return getBuilder().reset().tryGetSwtRightMargin().execute(false).getSwtRightMargin(); 
}
public void setSwtRightMargin(String value) {
	getBuilder().reset().setSwtRightMargin(value).execute(true);
}

public Object getSwtSelectionBackground() {
	return getBuilder().reset().tryGetSwtSelectionBackground().execute(false).getSwtSelectionBackground(); 
}
public void setSwtSelectionBackground(String value) {
	getBuilder().reset().setSwtSelectionBackground(value).execute(true);
}

public Object getSwtSelectionForeground() {
	return getBuilder().reset().tryGetSwtSelectionForeground().execute(false).getSwtSelectionForeground(); 
}
public void setSwtSelectionForeground(String value) {
	getBuilder().reset().setSwtSelectionForeground(value).execute(true);
}

public Object getSwtTabs() {
	return getBuilder().reset().tryGetSwtTabs().execute(false).getSwtTabs(); 
}
public void setSwtTabs(int value) {
	getBuilder().reset().setSwtTabs(value).execute(true);
}

public void setSwtTextDirection(String value) {
	getBuilder().reset().setSwtTextDirection(value).execute(true);
}

public Object getSwtTextLimit() {
	return getBuilder().reset().tryGetSwtTextLimit().execute(false).getSwtTextLimit(); 
}
public void setSwtTextLimit(int value) {
	getBuilder().reset().setSwtTextLimit(value).execute(true);
}

public Object getSwtTopIndex() {
	return getBuilder().reset().tryGetSwtTopIndex().execute(false).getSwtTopIndex(); 
}
public void setSwtTopIndex(int value) {
	getBuilder().reset().setSwtTopIndex(value).execute(true);
}

public Object getSwtTopMargin() {
	return getBuilder().reset().tryGetSwtTopMargin().execute(false).getSwtTopMargin(); 
}
public void setSwtTopMargin(String value) {
	getBuilder().reset().setSwtTopMargin(value).execute(true);
}

public Object getSwtTopPixel() {
	return getBuilder().reset().tryGetSwtTopPixel().execute(false).getSwtTopPixel(); 
}
public void setSwtTopPixel(int value) {
	getBuilder().reset().setSwtTopPixel(value).execute(true);
}

public Object isSwtWordWrap() {
	return getBuilder().reset().tryGetSwtWordWrap().execute(false).isSwtWordWrap(); 
}
public void setSwtWordWrap(boolean value) {
	getBuilder().reset().setSwtWordWrap(value).execute(true);
}

public Object getSwtWrapIndent() {
	return getBuilder().reset().tryGetSwtWrapIndent().execute(false).getSwtWrapIndent(); 
}
public void setSwtWrapIndent(int value) {
	getBuilder().reset().setSwtWrapIndent(value).execute(true);
}

public Object getJustificationMode() {
	return getBuilder().reset().tryGetJustificationMode().execute(false).getJustificationMode(); 
}
public void setJustificationMode(String value) {
	getBuilder().reset().setJustificationMode(value).execute(true);
}

public Object getLineSpacingExtra() {
	return getBuilder().reset().tryGetLineSpacingExtra().execute(false).getLineSpacingExtra(); 
}
public void setLineSpacingExtra(String value) {
	getBuilder().reset().setLineSpacingExtra(value).execute(true);
}

public Object getLineSpacingMultiplier() {
	return getBuilder().reset().tryGetLineSpacingMultiplier().execute(false).getLineSpacingMultiplier(); 
}
public void setLineSpacingMultiplier(float value) {
	getBuilder().reset().setLineSpacingMultiplier(value).execute(true);
}

public Object isTextIsSelectable() {
	return getBuilder().reset().tryGetTextIsSelectable().execute(false).isTextIsSelectable(); 
}
public void setTextIsSelectable(boolean value) {
	getBuilder().reset().setTextIsSelectable(value).execute(true);
}

public void setSingleLine(boolean value) {
	getBuilder().reset().setSingleLine(value).execute(true);
}

public Object getAutoLink() {
	return getBuilder().reset().tryGetAutoLink().execute(false).getAutoLink(); 
}
public void setAutoLink(String value) {
	getBuilder().reset().setAutoLink(value).execute(true);
}

public Object isLinksClickable() {
	return getBuilder().reset().tryGetLinksClickable().execute(false).isLinksClickable(); 
}
public void setLinksClickable(boolean value) {
	getBuilder().reset().setLinksClickable(value).execute(true);
}

public void setTextColorLink(String value) {
	getBuilder().reset().setTextColorLink(value).execute(true);
}

public Object getText() {
	return getBuilder().reset().tryGetText().execute(false).getText(); 
}
public void setText(String value) {
	getBuilder().reset().setText(value).execute(true);
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

public void setPadding(String value) {
	getBuilder().reset().setPadding(value).execute(true);
}

public Object getPaddingBottom() {
	return getBuilder().reset().tryGetPaddingBottom().execute(false).getPaddingBottom(); 
}
public void setPaddingBottom(String value) {
	getBuilder().reset().setPaddingBottom(value).execute(true);
}

public Object getPaddingRight() {
	return getBuilder().reset().tryGetPaddingRight().execute(false).getPaddingRight(); 
}
public void setPaddingRight(String value) {
	getBuilder().reset().setPaddingRight(value).execute(true);
}

public Object getPaddingLeft() {
	return getBuilder().reset().tryGetPaddingLeft().execute(false).getPaddingLeft(); 
}
public void setPaddingLeft(String value) {
	getBuilder().reset().setPaddingLeft(value).execute(true);
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

public Object getPaddingTop() {
	return getBuilder().reset().tryGetPaddingTop().execute(false).getPaddingTop(); 
}
public void setPaddingTop(String value) {
	getBuilder().reset().setPaddingTop(value).execute(true);
}

public void setPaddingHorizontal(String value) {
	getBuilder().reset().setPaddingHorizontal(value).execute(true);
}

public void setPaddingVertical(String value) {
	getBuilder().reset().setPaddingVertical(value).execute(true);
}

public Object getMinLines() {
	return getBuilder().reset().tryGetMinLines().execute(false).getMinLines(); 
}
public void setMinLines(int value) {
	getBuilder().reset().setMinLines(value).execute(true);
}

public void setLines(int value) {
	getBuilder().reset().setLines(value).execute(true);
}

public Object getMaxLines() {
	return getBuilder().reset().tryGetMaxLines().execute(false).getMaxLines(); 
}
public void setMaxLines(int value) {
	getBuilder().reset().setMaxLines(value).execute(true);
}

public Object getMinWidth() {
	return getBuilder().reset().tryGetMinWidth().execute(false).getMinWidth(); 
}
public void setMinWidth(String value) {
	getBuilder().reset().setMinWidth(value).execute(true);
}

public Object getMinHeight() {
	return getBuilder().reset().tryGetMinHeight().execute(false).getMinHeight(); 
}
public void setMinHeight(String value) {
	getBuilder().reset().setMinHeight(value).execute(true);
}

public Object getMaxWidth() {
	return getBuilder().reset().tryGetMaxWidth().execute(false).getMaxWidth(); 
}
public void setMaxWidth(String value) {
	getBuilder().reset().setMaxWidth(value).execute(true);
}

public Object getMaxHeight() {
	return getBuilder().reset().tryGetMaxHeight().execute(false).getMaxHeight(); 
}
public void setMaxHeight(String value) {
	getBuilder().reset().setMaxHeight(value).execute(true);
}

public Object getHeight() {
	return getBuilder().reset().tryGetHeight().execute(false).getHeight(); 
}
public void setHeight(String value) {
	getBuilder().reset().setHeight(value).execute(true);
}

public Object getWidth() {
	return getBuilder().reset().tryGetWidth().execute(false).getWidth(); 
}
public void setWidth(String value) {
	getBuilder().reset().setWidth(value).execute(true);
}

public Object getMaxEms() {
	return getBuilder().reset().tryGetMaxEms().execute(false).getMaxEms(); 
}
public void setMaxEms(int value) {
	getBuilder().reset().setMaxEms(value).execute(true);
}

public Object getMinEms() {
	return getBuilder().reset().tryGetMinEms().execute(false).getMinEms(); 
}
public void setMinEms(int value) {
	getBuilder().reset().setMinEms(value).execute(true);
}

public void setEms(int value) {
	getBuilder().reset().setEms(value).execute(true);
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

public Object getAutoSizeTextType() {
	return getBuilder().reset().tryGetAutoSizeTextType().execute(false).getAutoSizeTextType(); 
}
public void setAutoSizeTextType(String value) {
	getBuilder().reset().setAutoSizeTextType(value).execute(true);
}

public Object getAutoSizeMaxTextSize() {
	return getBuilder().reset().tryGetAutoSizeMaxTextSize().execute(false).getAutoSizeMaxTextSize(); 
}
public void setAutoSizeMaxTextSize(String value) {
	getBuilder().reset().setAutoSizeMaxTextSize(value).execute(true);
}

public Object getAutoSizeMinTextSize() {
	return getBuilder().reset().tryGetAutoSizeMinTextSize().execute(false).getAutoSizeMinTextSize(); 
}
public void setAutoSizeMinTextSize(String value) {
	getBuilder().reset().setAutoSizeMinTextSize(value).execute(true);
}

public Object getAutoSizeStepGranularity() {
	return getBuilder().reset().tryGetAutoSizeStepGranularity().execute(false).getAutoSizeStepGranularity(); 
}
public void setAutoSizeStepGranularity(String value) {
	getBuilder().reset().setAutoSizeStepGranularity(value).execute(true);
}

public void setMaxLength(int value) {
	getBuilder().reset().setMaxLength(value).execute(true);
}

public void setEnabled(boolean value) {
	getBuilder().reset().setEnabled(value).execute(true);
}

public void setEditable(boolean value) {
	getBuilder().reset().setEditable(value).execute(true);
}

public void setTextAllCaps(boolean value) {
	getBuilder().reset().setTextAllCaps(value).execute(true);
}

public void setPassword(boolean value) {
	getBuilder().reset().setPassword(value).execute(true);
}

public void setScrollHorizontally(boolean value) {
	getBuilder().reset().setScrollHorizontally(value).execute(true);
}

public Object getEllipsize() {
	return getBuilder().reset().tryGetEllipsize().execute(false).getEllipsize(); 
}
public void setEllipsize(String value) {
	getBuilder().reset().setEllipsize(value).execute(true);
}

public void setStartOrStopMarquee(boolean value) {
	getBuilder().reset().setStartOrStopMarquee(value).execute(true);
}

public Object getMarqueeRepeatLimit() {
	return getBuilder().reset().tryGetMarqueeRepeatLimit().execute(false).getMarqueeRepeatLimit(); 
}
public void setMarqueeRepeatLimit(String value) {
	getBuilder().reset().setMarqueeRepeatLimit(value).execute(true);
}

public Object getFirstBaselineToTopHeight() {
	return getBuilder().reset().tryGetFirstBaselineToTopHeight().execute(false).getFirstBaselineToTopHeight(); 
}
public void setFirstBaselineToTopHeight(String value) {
	getBuilder().reset().setFirstBaselineToTopHeight(value).execute(true);
}

public Object getLastBaselineToBottomHeight() {
	return getBuilder().reset().tryGetLastBaselineToBottomHeight().execute(false).getLastBaselineToBottomHeight(); 
}
public void setLastBaselineToBottomHeight(String value) {
	getBuilder().reset().setLastBaselineToBottomHeight(value).execute(true);
}

public void setAutoSizePresetSizes(String value) {
	getBuilder().reset().setAutoSizePresetSizes(value).execute(true);
}

public void setTextFormat(String value) {
	getBuilder().reset().setTextFormat(value).execute(true);
}

}


    
	//end - body

    //start - styledlabel
    

    private org.eclipse.swt.custom.StyledText createStyledText(Composite wrapperComposite, int style) {
        org.eclipse.swt.custom.StyledText styledText = new org.eclipse.swt.custom.StyledText(wrapperComposite, style) {
        	@Override
        	public void setText(java.lang.String text) {
        		int maxLength = getTextLimit();
        		if (maxLength > 0 && text.length() > maxLength) {
        			text = text.substring(0, maxLength);
        		}
        		super.setText(text);
        	}
        };;
        styledText.setBackground(Display.getDefault().getSystemColor(org.eclipse.swt.SWT.COLOR_TRANSPARENT));
        disableTextBox(styledText);
        return styledText;
    }

    
	private void setJustificationMode(Object objValue) {
		if (((int) objValue) == 0x1) {
			styledText.setJustify(true);
		} else {
			styledText.setJustify(false);
		}
	}
	

    private void setMyFont(org.eclipse.swt.graphics.Font newFont2) {
        org.eclipse.swt.custom.StyleRange styleRange = new org.eclipse.swt.custom.StyleRange();
        styleRange.start = 0;
        styleRange.font = newFont;
        styleRange.length = styledText.getText().length();
        styledText.setStyleRange(styleRange);
	}
    
    //start - linespacing
	private float mSpacingAdd;
	private float mSpacingMult;
	private void setLineSpacingMultiplier(Object objValue) {
		mSpacingMult = (float) objValue;
		setLineSpacing();
	}

	private void setLineSpacingExtra(Object objValue) {
		mSpacingAdd = (float) objValue;
		setLineSpacing();
	}
	
	private Object getLineSpacingMultiplier() {
		return mSpacingMult;
	}

	private Object getLineSpacingExtra() {
		return mSpacingAdd;
	}
	//end - linespacing

	private void setLineSpacing() {
		styledText.setLineSpacingProvider(new org.eclipse.swt.custom.StyledTextLineSpacingProvider() {
			@Override
			public Integer getLineSpacing(int lineIndex) {
				return  Math.round((mSpacingAdd + (mSpacingMult * styledText.getLineHeight())));
			}
			
		});
	}
	
	private Object getJustificationMode() {
		return styledText.getJustify() ?  0x1 : 0x0;
	}
	
	@Override
	public int getBaseLine() {
		int baseline = styledText.getBaseline(styledText.getCharCount()) + measurableTextView.getPaddingTop();
		return baseline;
	}

	
	private void setTextIsSelectable(Object objValue) {
		styledText.setEnabled((boolean) objValue); 
		
	}

	private Object getTextIsSelectable() {
		return styledText.getEnabled();
	}
	
	private void computeLineHeight() {
	}

	//end - styledlabel
	
	//start - defaultmethod
	

	private void drawableStateChangedAdditional() {
		drawableStateChangedForTextLinkColor();
	}

    private void addMinMaxListener() {
        
    }

	private void disableTextBox(org.eclipse.swt.custom.StyledText styledText) {
		styledText.setEditable(false);
        styledText.setEnabled(false);
        styledText.setForeground(Display.getCurrent().getSystemColor(org.eclipse.swt.SWT.COLOR_BLACK));
	}

	
	private void setSingleLine(Object objValue) {
		styledText.setWordWrap(!(boolean) objValue);
	}
	
	
	public int getBorderPadding() {
		return 0;
	}
	
	public int getLineHeightPadding() {
		return 0;
	}
	
	public int getLineHeight() {
		return styledText.getLineHeight();
	}
	
	public int getBorderWidth() {
		return wrapperComposite.getBorderWidth();
	}
	
	private void handleHtmlText(String value) {
		com.ashera.attributedtext.AttributedString attributedString = com.ashera.parser.html.Html.fromHtml(value, htmlConfig, fragment);
		styledText.setText(attributedString.getText());

		java.util.Collection<org.eclipse.swt.custom.StyleRange> styleRanges = (java.util.Collection<org.eclipse.swt.custom.StyleRange>) attributedString.get();
		styledText.addPaintObjectListener(new org.eclipse.swt.custom.PaintObjectListener() {
		    public void paintObject(org.eclipse.swt.custom.PaintObjectEvent event) {
		      GC gc = event.gc;
		      org.eclipse.swt.custom.StyleRange style = event.style;
		      
				if (style.data != null) {
					Map<String, Object> data = (Map<String, Object>) style.data;
					Image image = (Image) data.get("image");
					if (image != null) {
						int x = event.x;
						int y = event.y + event.ascent - style.metrics.ascent;
						gc.drawImage(image, x, y);
					}
				}
		    }
		  });
		for (org.eclipse.swt.custom.StyleRange styleRange : styleRanges) {
			styledText.setStyleRange(styleRange);

			if (styleRange.data != null) {
				Map<String, Object> data = (Map<String, Object>) styleRange.data;

				int lineNumber = styledText.getLineAtOffset(styleRange.start);
				int lineCount = styledText.getLineAtOffset(styleRange.start + styleRange.length) - lineNumber;
				
				if (lineCount == 0) {
					lineCount = 1;
				}
				for (String key : data.keySet()) {
					switch (key) {
					case "lineAlignment":
						styledText.setLineAlignment(lineNumber, lineCount, (int) data.get(key));
						break;
					case "bullet":
						styledText.setLineBullet(lineNumber, lineCount, (org.eclipse.swt.custom.Bullet) data.get(key));
						break;
					default:
						break;
					}
				}
			}
		}
	}
	
	private boolean isHtmlSupported() {
		return true;
	}
	
	//end - defaultmethod

	//start - autolink
	private int autoLink;
	private Object getAutoLink() {
		return autoLink;
	}
	
	
	private void setAutoLink(Object objValue) {
		this.autoLink = (int) objValue;
		applyAttributeCommand("text", "autoLink", new String[] {"autoLink"}, true, "mask", autoLink);		
	}
	
	private boolean linksClickable;
	private void setLinksClickable(Object objValue) {
		this.linksClickable = (boolean) objValue;
		applyAttributeCommand("text", "autoLink", new String[] {"autoLink"}, true, "linksClickable", linksClickable);	
	}
	
	
	private Object getLinksClickable() {
		return linksClickable;
	}
	//end - autolink

	//start - textColorLink 
	private void setTextColorLink(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			measurableTextView.setLinkTextColor(colorStateList);
			objValue = measurableTextView.getPaint().linkColor;
		}
		if (html) {
			htmlConfig.put("textColorLink", ViewImpl.getColor(objValue));
		}
		
		if (isInitialised()) {
			rerunCommandOnSource("text", "statechange");
		}
	}
	
	private void drawableStateChangedForTextLinkColor() {
		if (measurableTextView.getLinkTextColors() != null && measurableTextView.getLinkTextColors().isStateful()) {
			setTextColorLink(measurableTextView.getLinkTextColors());
		}
	}	

	//end - textColorLink
}
