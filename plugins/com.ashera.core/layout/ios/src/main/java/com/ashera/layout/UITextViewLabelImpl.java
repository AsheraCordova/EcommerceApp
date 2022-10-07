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
#include "ASUITextViewLabel.h"
]-*/
@SuppressLint("NewApi")
public class UITextViewLabelImpl extends BaseWidget implements com.ashera.validations.ValidationErrorLabel{
	//start - body
	public final static String LOCAL_NAME = "UITextViewLabel"; 
	public final static String GROUP_NAME = "TextView";

	protected @Property Object uiView;
	protected MeasurableTextView measurableTextView;		
	
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
				mapping.put("end",  LayoutNativeVars.NSLineBreakByTruncatingTail);
				mapping.put("marquee",  LayoutNativeVars.NSLineBreakByMarquee);
				mapping.put("middle",  LayoutNativeVars.NSLineBreakByTruncatingMiddle);
				mapping.put("none",  LayoutNativeVars.NSLineBreakByClipping);
				mapping.put("start",  LayoutNativeVars.NSLineBreakByTruncatingHead);
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
		@SuppressLint("NewApi")
		final static class JustificationMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("inter_word",  LayoutNativeVars.NSTextAlignmentJustified);
				mapping.put("none",  LayoutNativeVars.NSTextAlignmentLeft);
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
				mapping.put("all", LayoutNativeVars.UIDataDetectorTypeAll);
				mapping.put("email", LayoutNativeVars.UIDataDetectorTypeLink);
				mapping.put("map", LayoutNativeVars.UIDataDetectorTypeAddress);
				mapping.put("none", LayoutNativeVars.UIDataDetectorTypeNone);
				mapping.put("phone", LayoutNativeVars.UIDataDetectorTypePhoneNumber);
				mapping.put("web", LayoutNativeVars.UIDataDetectorTypeLink);
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
		final static class DrawableTintMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("add",  LayoutNativeVars.kCGBlendModeOverlay);
				mapping.put("multiply",  LayoutNativeVars.kCGBlendModeMultiply);
				mapping.put("screen",  LayoutNativeVars.kCGBlendModeScreen);
				mapping.put("src_atop",  LayoutNativeVars.kCGBlendModeSourceAtop);
				mapping.put("src_in",  LayoutNativeVars.kCGBlendModeSourceIn);
				mapping.put("src_over",  LayoutNativeVars.kCGBlendModeNormal);
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
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosText").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosTextColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosUsesStandardTextScaling").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsEditable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAllowsEditingTextAttributes").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosClearsOnInsertion").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsSelectable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textIsSelectable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("UITextViewLabel.autoSizeTextType", new AutoSizeTextType());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizeTextType").withType("UITextViewLabel.autoSizeTextType").withOrder(1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizeMaxTextSize").withType("dimensionsppxint"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizeMinTextSize").withType("dimensionsppxint"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizeStepGranularity").withType("dimensionsppxint"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoSizePresetSizes").withType("array").withArrayType("dimensionsppxint").withArrayListToFinalType("listtointarray"));
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
		ConverterFactory.register("UITextViewLabel.ellipsize", new Ellipsize());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ellipsize").withType("UITextViewLabel.ellipsize").withOrder(100));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("startOrStopMarquee").withType("boolean").withOrder(100));
		ConverterFactory.register("UITextViewLabel.marqueeRepeatLimit", new MarqueeRepeatLimit());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("marqueeRepeatLimit").withType("UITextViewLabel.marqueeRepeatLimit").withOrder(100));
		ConverterFactory.register("UITextViewLabel.justificationMode", new JustificationMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("justificationMode").withType("UITextViewLabel.justificationMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("singleLine").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("password").withType("boolean"));
		ConverterFactory.register("UITextViewLabel.autoLink", new AutoLink());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoLink").withType("UITextViewLabel.autoLink"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAllCaps").withType("boolean").withOrder(-1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLength").withType("int"));
		ConverterFactory.register("UITextViewLabel.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("UITextViewLabel.font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("UITextViewLabel.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("UITextViewLabel.textStyle").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension").withOrder(1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTint").withType("colorstate").withUiFlag(UPDATE_UI_INVALIDATE));
		ConverterFactory.register("UITextViewLabel.drawableTintMode", new DrawableTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTintMode").withType("UITextViewLabel.drawableTintMode").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("linksClickable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorLink").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollHorizontally").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("firstBaselineToTopHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lastBaselineToBottomHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorHighlight").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textFormat").withType("resourcestring").withOrder(-1));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("html").withType("boolean"));
	}
	
	public UITextViewLabelImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

@com.google.j2objc.annotations.WeakOuter		
	public class UITextViewLabelExt extends MeasurableTextView implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public UITextViewLabelExt() {
			
			
			
			super(UITextViewLabelImpl.this);
			
			
			
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
			ViewImpl.setDrawableBounds(UITextViewLabelImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			nativeMakeFrameForChildWidget(l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(UITextViewLabelImpl.this);
			
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
				UITextViewLabelImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(UITextViewLabelImpl.this);
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
	 	@Override
        public boolean suggestedSizeFitsInSpace(int mAutoSizeTextSizeInPx, r.android.graphics.RectF availableSpace) {
        	return UITextViewLabelImpl.this.suggestedSizeFitsInSpace(mAutoSizeTextSizeInPx, availableSpace.width(), availableSpace.height());
        }
        
        @Override
        protected void setTextSizeInternal(int unit, float optimalTextSize, boolean b) {
        	UITextViewLabelImpl.this.setMyTextSize(optimalTextSize);
        }
		  public int getBorderPadding(){
		    return UITextViewLabelImpl.this.getBorderPadding();
		  }

		  public int getLineHeight(){
		    return UITextViewLabelImpl.this.getLineHeight();
		  }

		  public int getBorderWidth(){
		    return UITextViewLabelImpl.this.getBorderWidth();
		  }
		  public int getLineHeightPadding(){
		    return UITextViewLabelImpl.this.getLineHeightPadding();
		  }
		 @Override
		 public void onRtlPropertiesChanged(int layoutDirection) {
			 UITextViewLabelImpl.this.onRtlPropertiesChanged(layoutDirection);
		 }
	}	
	public void updateMeasuredDimension(int width, int height) {
		((UITextViewLabelExt) measurableTextView).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new UITextViewLabelImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableTextView = new UITextViewLabelExt();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
		setWidgetOnNativeClass();
	}
	private native void setWidgetOnNativeClass() /*-[
		((ASUITextViewLabel*) self.uiView).widget = self;
	]-*/;

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "iosText": {
				


		setText(nativeWidget, objValue);



			}
			break;
			case "iosTextColor": {
				


		setTextColor(nativeWidget, objValue);



			}
			break;
			case "iosUsesStandardTextScaling": {
				
if (checkIosVersion("13.0")) {

		setUsesStandardTextScaling(nativeWidget, objValue);

}

			}
			break;
			case "iosIsEditable": {
				


		setIsEditable(nativeWidget, objValue);



			}
			break;
			case "iosAllowsEditingTextAttributes": {
				


		setAllowsEditingTextAttributes(nativeWidget, objValue);



			}
			break;
			case "iosClearsOnInsertion": {
				


		setClearsOnInsertion(nativeWidget, objValue);



			}
			break;
			case "textIsSelectable":
			case "iosIsSelectable": {
				


		setIsSelectable(nativeWidget, objValue);



			}
			break;
			case "text": {
				


		setMyText(objValue);



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
			case "autoSizePresetSizes": {
				


		 setAutoSizePresetSizes(objValue);



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
			case "justificationMode": {
				


		 setJustificationMode(objValue, strValue);



			}
			break;
			case "singleLine": {
				


		 setSingleLine(objValue);



			}
			break;
			case "password": {
				


		 setPassword(objValue);



			}
			break;
			case "autoLink": {
				


		 setAutoLink(objValue);



			}
			break;
			case "textAllCaps": {
				


		 setTextAllCaps(objValue);



			}
			break;
			case "maxLength": {
				


		 setMaxLength(objValue); 



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
				


		setDrawableLeft("drawableLeft", objValue);



			}
			break;
			case "drawableStart": {
				


		setDrawableLeft("drawableStart", objValue);



			}
			break;
			case "drawableRight": {
				


		setDrawableRight("drawableRight", objValue);



			}
			break;
			case "drawableEnd": {
				


		setDrawableRight("drawableEnd", objValue);



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
			case "drawableTint": {
				


		setDrawableTint(objValue);



			}
			break;
			case "drawableTintMode": {
				


		setDrawableTintMode(objValue);



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
			case "scrollHorizontally": {
				


		 setScrollHorizontally(objValue);



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
			case "firstBaselineToTopHeight": {
				


		setFirstBaselineToTopHeight(objValue);



			}
			break;
			case "lastBaselineToBottomHeight": {
				


		setLastBaselineToBottomHeight(objValue);



			}
			break;
			case "textColorHighlight": {
				


		setTextColorHighlight(objValue);



			}
			break;
			case "textColor": {
				


		setTextColor(objValue);



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
			case "iosText": {
return getText();				}
			case "iosTextColor": {
return getTextColor();				}
			case "iosUsesStandardTextScaling": {
if (checkIosVersion("13.0")) {
return getUsesStandardTextScaling();
}
break;				}
			case "iosIsEditable": {
return getIsEditable();				}
			case "iosAllowsEditingTextAttributes": {
return getAllowsEditingTextAttributes();				}
			case "iosClearsOnInsertion": {
return getClearsOnInsertion();				}
			case "textIsSelectable":
			case "iosIsSelectable": {
return getIsSelectable();				}
			case "text": {
return getMyText();				}
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
			case "autoSizeTextType": {
return getAutoSizeTextType();				}
			case "autoSizeMaxTextSize": {
return getAutoMaxTextSize();				}
			case "autoSizeMinTextSize": {
return getAutoMinTextSize();				}
			case "autoSizeStepGranularity": {
return getAutoSizeStepGranularity();				}
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
			case "ellipsize": {
return getEllipsize();				}
			case "marqueeRepeatLimit": {
return getMarqueeRepeatLimit();				}
			case "justificationMode": {
return getJustificationMode();				}
			case "autoLink": {
return getAutoLink();				}
			case "drawablePadding": {
return this.getDrawablePadding();				}
			case "linksClickable": {
return getLinksClickable();				}
			case "firstBaselineToTopHeight": {
return getFirstBaselineToTopHeight();				}
			case "lastBaselineToBottomHeight": {
return getLastBaselineToBottomHeight();				}
			case "textColorHighlight": {
return getTextColorHighlight();				}
			case "textColor": {
return getTextColorState();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return measurableTextView;
	}

	

	@Override
	public void drawableStateChanged() {
		super.drawableStateChanged();
		drawableStateChange("bottom", measurableTextView.getBottomDrawable());
		drawableStateChange("left", measurableTextView.getLeftDrawable());
		drawableStateChange("right", measurableTextView.getRightDrawable());
		drawableStateChange("top", measurableTextView.getTopDrawable());
		
		if (measurableTextView.getTextColors() != null && measurableTextView.getTextColors().isStateful()) {
			setTextColor(measurableTextView.getCurrentTextColor());
		}
		
		if (measurableTextView.getHintTextColors() != null && measurableTextView.getHintTextColors().isStateful()) {
			setHintColor(measurableTextView.getCurrentHintTextColor());
			syncPlaceholderLabel();
		}
		
		if (drawableTint != null && drawableTint.isStateful()) {
			setDrawableTint(drawableTint);
			invalidate();
		}
		
		if (measurableTextView.getLinkTextColors() != null && measurableTextView.getLinkTextColors().isStateful()) {
			setTextColorLink(measurableTextView.getLinkTextColors());
		}
	}

	private void drawableStateChange(String type, r.android.graphics.drawable.Drawable dr) {
		final int[] state = measurableTextView.getDrawableState();

		if (dr != null && dr.isStateful() && dr.setState(state)) {
			switch (type) {
			case "bottom":
				setDrawableBottom(dr);
				break;
			case "top":
				setDrawableTop(dr);
				break;
			case "left":
				setDrawableLeft("drawableLeft", dr);
				break;
			case "right":
				setDrawableRight("drawableRight", dr);
				break;
			default:
				break;
			}

		}
		invalidate();
	}
	


	

	private void handleHtmlText(String text) {
		nativeSetHtmlText(com.ashera.parser.html.Html.fromHtml(text, htmlConfig, fragment).get());
	}
	private native void nativeSetText(String text)/*-[
		[((ASUITextViewLabel*)self->uiView_) setText:text];
	]-*/;
	
	private native void nativeSetHtmlText(Object text)/*-[
		[((ASUITextViewLabel*)self->uiView_) setAttributedText : (NSMutableAttributedString*)text];
	]-*/;
	
	private native Object getMyText() /*-[
		return ((ASUITextViewLabel*)self.uiView).text;
	]-*/;
	


	private native Object getTextSize() /*-[
		  return [JavaLangFloat valueOfWithFloat:((ASUITextViewLabel*)self.uiView).font.pointSize];
	]-*/;
	private void setMyTextSize(Object objValue) {
		float fontSize = ((float) objValue) * getFragment().getRootActivity().getScaleFactor();
		nativeSetTextSize((int) fontSize);
	}
	
	private native void nativeSetTextSize(int value)/*-[
		[((ASUITextViewLabel*)self.uiView) setFont: [((ASUITextViewLabel*)self.uiView).font fontWithSize: value]];
	]-*/;
	


	private String ellipsize;
	private Object getEllipsize() {
		if (ellipsize.equals("marquee")) {
			return LayoutNativeVars.NSLineBreakByMarquee;
		}
		return nativeGetLinBreakMode();
	}

	private void setEllipsize(Object objValue, String strValue) {
		this.ellipsize = strValue;

		int lineBreakMode = (int) objValue;
		
		if (lineBreakMode == LayoutNativeVars.NSLineBreakByMarquee) {
			lineBreakMode = LayoutNativeVars.NSLineBreakByClipping;
		}

		if (ViewImpl.isRTLLayoutDirection(this)) {
			 if (lineBreakMode == LayoutNativeVars.NSLineBreakByTruncatingTail) {
				 lineBreakMode =  LayoutNativeVars.NSLineBreakByTruncatingHead;
			 } else if (lineBreakMode == LayoutNativeVars.NSLineBreakByTruncatingHead) {
				 lineBreakMode =  LayoutNativeVars.NSLineBreakByTruncatingTail;
			 }
		}
		nativeSetLineBreakMode(lineBreakMode);
		cancelTimer();

		if (strValue.equals("marquee")) {
			startTimer();
		}
	}
	


	private static int ITALIC_FONT_TRAIT = LayoutNativeVars.UIFontDescriptorTraitItalic;
	private static int BOLD_FONT_TRAIT = LayoutNativeVars.UIFontDescriptorTraitBold;
	private static final int NORMAL_FONT_TRAIT = 0;
	
    private int nativeGetFontSize() {
    	return (int) Math.ceil((float)getTextSize());
    }
    
    private native int nativeGetFontStyle() /*-[	 
    	ASUITextViewLabel* label = ((ASUITextViewLabel*)self->uiView_);
    	return label.font.fontDescriptor.symbolicTraits;
   	]-*/;
    private native void nativeSetCustomFont(int height, com.ashera.model.FontDescriptor fontDescriptor) /*-[	
    	ASUITextViewLabel* label = ((ASUITextViewLabel*)self->uiView_);
     	UIFont* font = [UIFont fontWithName:[fontDescriptor getName] size:height];
     	if (font == nil) {
        	[NSException raise:@"InitNotImplemented" format:@"%@", [NSString stringWithFormat:@"Failed to load the %@ font. Make sure the font file is included in the project and the font name is spelled correctly.", [fontDescriptor getName]]];
    	}
     	if ([fontDescriptor getStyle] != 0) {
	      UIFontDescriptor* fontD = [font.fontDescriptor fontDescriptorWithSymbolicTraits:[fontDescriptor getStyle]];
	      ((ASUITextViewLabel*)label).font = [UIFont fontWithDescriptor:fontD size:0];
	    } else {
	        ((ASUITextViewLabel*)label).font = font;
	    }
    ]-*/;
    
    private native void nativeSetFontStyle(int style) /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*)self->uiView_);
  		UIFontDescriptor* fontD = [label.font.fontDescriptor fontDescriptorWithSymbolicTraits:style];
  		((ASUITextViewLabel*)label).font = [UIFont fontWithDescriptor:fontD size:0];
	]-*/;
    


	public static String toUpperCase(String text) {
		return text.toUpperCase(java.util.Locale.getDefault());
	}
	


	//start - aligmentgravity
	private void setVerticalAligmentCenter() {
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.middle);
		nativeSetVerticalAligmentCenter();
	}


	private void setVerticalAligmentBottom() {
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.bottom);
		nativeSetVerticalAligmentBottom();
	}

	private void setVerticalAligmentTop() {
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.top);
		nativeSetVerticalAligmentTop();
	}


	private native void setHorizontalAligmentCenter() /*-[
		((ASUITextViewLabel*)self.uiView).textAlignment = NSTextAlignmentCenter;
	]-*/;
	
	private void setHorizontalAligmentRight()  {
		setHorizontalAligmentRightInternal();
	}

	private native void setHorizontalAligmentRightInternal() /*-[
		((ASUITextViewLabel*)self.uiView).textAlignment = NSTextAlignmentRight;
	]-*/;

	private void setHorizontalAligmentLeft() {
		setHorizontalAligmentLeftInternal();
	}
	
	private native void setHorizontalAligmentLeftInternal() /*-[
		((ASUITextViewLabel*)self.uiView).textAlignment = NSTextAlignmentLeft;
	]-*/;

	private static final int TEXT_ALIGN_CENTER = 2; 
	private static final int TEXT_ALIGN_LEFT = 0; 
	private static final int TEXT_ALIGN_RIGHT = 1; 

    private native int getTextAlignment() /*-[
    	int alignment = (int) ((ASUITextViewLabel*)self.uiView).textAlignment;
    	
    	if (alignment == NSTextAlignmentCenter) {
    		return 2;
    	}
    	
    	if (alignment == NSTextAlignmentLeft) {
    		return 0;
    	}
    	
    	if (alignment == NSTextAlignmentRight) {
    		return 1;
    	}

		return 0;
	]-*/;
    //end - aligmentgravity

	private void nativeSetVerticalAligmentBottom() {
	}

	private void nativeSetVerticalAligmentTop() {
	}
	

	private void nativeSetVerticalAligmentCenter() {
	}
	


	public int getBorderPadding() {return paddingTop + paddingBottom;}
	
	public int getLineHeightPadding() {
		return 0;
	}
	
	private native int getLineHeight() /*-[
  		return ceil(((ASUITextViewLabel*)self.uiView).font.lineHeight);
	]-*/;
	private int getBorderWidth() {
		return 0;
	}
	


	private boolean canMarquee() {
		return getSingleLine().equals(Boolean.TRUE);
	}
	

	private native void cancelNativeTimer() /*-[
		if (self->timer_ != nil) {
			[(NSTimer*) self->timer_ invalidate];
			self->timer_ = nil;
		}
	]-*/;

	private Object timer;
	private boolean isDisposed;
	private DellocHandler dellocHandler;	

  	private boolean isDisposed() {
		return isDisposed;
	}

  	private void addDeallocHandler() {
  		if (dellocHandler == null) {
			String type = StandardEvents.dealloc.toString();
			dellocHandler = new DellocHandler(type);
			fragment.getEventBus().on(type, dellocHandler);
  		}
  	}

	private native void schedule()/*-[
		if (self->timer_ == nil) {
			self->timer_ = [NSTimer scheduledTimerWithTimeInterval:0.1
			    target:self
			    selector:@selector(onTick:)
			    userInfo:nil
			    repeats:YES];
			[[NSRunLoop mainRunLoop] addTimer:self->timer_ forMode:NSRunLoopCommonModes];
		}
	]-*/;
	
	/*-[
	 	- (void)onTick:(NSTimer *)timer {
    		[self executeOnMainThreadWithJavaLangRunnable:self->marqueeTask_];
		}
	]-*/;
	
	private void executeOnMainThread(Runnable runnable) {
		runnable.run();
	}
	@com.google.j2objc.annotations.WeakOuter
	private final class DellocHandler extends com.ashera.widget.bus.EventBusHandler {
		private DellocHandler(String type) {
			super(type);
		}

		@Override
		protected void doPerform(Object payload) {
			cancelTimer();
			isDisposed = true;
		}
	}
	


	private void setDrawablePadding(Object objValue) {
		measurableTextView.setDrawablePadding((int) objValue);
		updatePadding();
	}

	private void setDrawableBottom(Object objValue) {
		if ("@null".equals(objValue)) {
			measurableTextView.setBottomDrawable(null);
			applyAttributeCommand("drawableBottom", "drawDrawableIcon", new String[] {}, false, "bottom");
		} else if (objValue != null && objValue instanceof r.android.graphics.drawable.Drawable) {
			measurableTextView.setBottomDrawable((r.android.graphics.drawable.Drawable) objValue);
			applyAttributeCommand("drawableBottom", "drawDrawableIcon", new String[] {}, true, "bottom");
			updatePadding();
		}
	}

	private void setDrawableTop(Object objValue) {
		if ("@null".equals(objValue)) {
			measurableTextView.setTopDrawable(null);
			applyAttributeCommand("drawableTop", "drawDrawableIcon", new String[] {}, false, "top");
		} else if (objValue != null && objValue instanceof r.android.graphics.drawable.Drawable) {
			measurableTextView.setTopDrawable((r.android.graphics.drawable.Drawable) objValue);
			applyAttributeCommand("drawableTop", "drawDrawableIcon", new String[] {}, true, "top");
			updatePadding();
		}
	}

	private void setDrawableRight(String originalAttr, Object objValue) {
		if (ViewImpl.isRTLLayout(this)) {
			setDrawableLeftInternal(originalAttr, objValue);
		} else {
			setDrawableRightInternal(originalAttr, objValue);
		}
	}

	private void setDrawableRightInternal(String originalAttr, Object objValue) {
		if ("@null".equals(objValue)) {
			measurableTextView.setRightDrawable(null);
			applyAttributeCommand(originalAttr, "drawDrawableIcon", new String[] {}, false, "right");
		} else if (objValue != null && objValue instanceof r.android.graphics.drawable.Drawable) {
			measurableTextView.setRightDrawable((r.android.graphics.drawable.Drawable) objValue);
			applyAttributeCommand(originalAttr, "drawDrawableIcon", new String[] {}, true, "right");
			updatePadding();
		}		
	}

	private void setDrawableLeft(String originalAttr, Object objValue) {
		if (objValue != null) {
			if (ViewImpl.isRTLLayout(this)) {
				setDrawableRightInternal(originalAttr, objValue);
			} else {
				setDrawableLeftInternal(originalAttr, objValue);
			}
		}
	}

	private void setDrawableLeftInternal(String originalAttr, Object objValue) {
		if ("@null".equals(objValue)) {
			measurableTextView.setLeftDrawable(null);
			applyAttributeCommand(originalAttr, "drawDrawableIcon", new String[] {}, false, "left");
		} else if (objValue != null && objValue instanceof r.android.graphics.drawable.Drawable) {
			measurableTextView.setLeftDrawable((r.android.graphics.drawable.Drawable) objValue);
			applyAttributeCommand(originalAttr, "drawDrawableIcon", new String[] {}, true, "left");
			updatePadding();
		}
	}

	private native int getImageHeight(Object objValue) /*-[
		if ([objValue isKindOfClass:[UIImage class]]) {
	    	UIImage* image = ((UIImage*) objValue);
	    	return image.size.height;
	   	}
	   	
	   	return 0;
	]-*/;	
	
	private native int getImageWidth(Object objValue) /*-[
    	if ([objValue isKindOfClass:[UIImage class]]) {
        	UIImage* image = ((UIImage*) objValue);
        	return image.size.width;
       	}
       	
       	return 0;
	]-*/;

	private Object getDrawablePadding() {
		return measurableTextView.getDrawablePadding();
	}

	private void setDrawableTintMode(Object value) {
		if (measurableTextView.getLeftDrawable() != null) {
			applyAttributeCommand("drawableStart", "cgTintColor", new String[] {"drawableTintMode"}, true, "drawableTintMode", value);
			applyAttributeCommand("drawableLeft", "cgTintColor", new String[] {"drawableTintMode"}, true, "drawableTintMode", value);
		}
		if (measurableTextView.getRightDrawable() != null) {
			applyAttributeCommand("drawableRight", "cgTintColor", new String[] {"drawableTintMode"}, true, "drawableTintMode", value);
			applyAttributeCommand("drawableEnd", "cgTintColor", new String[] {"drawableTintMode"}, true, "drawableTintMode", value);
		}
		
		if (measurableTextView.getTopDrawable() != null) {
			applyAttributeCommand("drawableTop", "cgTintColor", new String[] {"drawableTintMode"}, true, "drawableTintMode", value);
		}
		if (measurableTextView.getBottomDrawable() != null) {
			applyAttributeCommand("drawableBottom", "cgTintColor", new String[] {"drawableTintMode"}, true, "drawableTintMode", value);
		}
	}
	private r.android.content.res.ColorStateList drawableTint; 
	private void setDrawableTint(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			this.drawableTint = colorStateList;
			objValue = drawableTint.getColorForState(measurableTextView.getDrawableState(), r.android.graphics.Color.RED);
		}
		
		if (measurableTextView.getLeftDrawable() != null) {
			applyAttributeCommand("drawableLeft", "cgTintColor", new String[] {"drawableTint"}, true, "drawableTint", ViewImpl.getColor(objValue));
			applyAttributeCommand("drawableStart", "cgTintColor", new String[] {"drawableTint"}, true, "drawableTint", ViewImpl.getColor(objValue));
		}
		if (measurableTextView.getRightDrawable() != null) {
			applyAttributeCommand("drawableRight", "cgTintColor", new String[] {"drawableTint"}, true, "drawableTint", ViewImpl.getColor(objValue));			
			applyAttributeCommand("drawableEnd", "cgTintColor", new String[] {"drawableTint"}, true, "drawableTint", ViewImpl.getColor(objValue));
		}
		if (measurableTextView.getTopDrawable() != null) {
			applyAttributeCommand("drawableTop", "cgTintColor", new String[] {"drawableTint"}, true, "drawableTint", ViewImpl.getColor(objValue));
		}
		if (measurableTextView.getBottomDrawable() != null) {
			applyAttributeCommand("drawableBottom", "cgTintColor", new String[] {"drawableTint"}, true, "drawableTint", ViewImpl.getColor(objValue));
		}
	}
	
	


	private void setTextColor(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			measurableTextView.setTextColor(colorStateList);
			objValue = measurableTextView.getCurrentTextColor();
		}
		
		setTextColor(uiView, ViewImpl.getColor(objValue));
	}
	
	private Object getTextColorState() {
		return measurableTextView.getTextColors();
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
		return measurableTextView.nativeMeasureHeight(uiView, (int) width);
	}
    
    


	private void setMaxLength(Object objValue) {
		if (!html) {
			applyAttributeCommand("text", CommonConverters.command_maxlength, new String[] {"maxLength"}, true, objValue);
		} else {
			htmlConfig.put("maxLength", objValue);
		}
	}
    


  	private void setPassword(Object objValue) {
  		if (!html) {
  			applyAttributeCommand("text", CommonConverters.command_password, new String[] {"password"}, (boolean) objValue);
  		} else {
  			htmlConfig.put("password", objValue);
  		}
  	}
  	


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

    



	private void setTextAllCaps(Object objValue) {
		if (!html) {
			applyAttributeCommand("text", CommonConverters.command_uppercase, new String[] {"textAllCaps"}, (boolean) objValue);
		} else {
			htmlConfig.put("textAllCaps", objValue);
		}
	}
	


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
	

	public native void setText(Object nativeWidget, Object value) /*-[
((ASUITextViewLabel*) nativeWidget).text = (NSString*) value;
]-*/;
	public native Object getText() /*-[
return ((ASUITextViewLabel*) uiView_).text;
  ]-*/;
	public native void setTextColor(Object nativeWidget, Object value) /*-[
((ASUITextViewLabel*) nativeWidget).textColor = (UIColor*) value;
]-*/;
	public native Object getTextColor() /*-[
return ((ASUITextViewLabel*) uiView_).textColor;
  ]-*/;
	public native void setUsesStandardTextScaling(Object nativeWidget, Object value) /*-[
((ASUITextViewLabel*) nativeWidget).usesStandardTextScaling = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getUsesStandardTextScaling() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUITextViewLabel*) uiView_).usesStandardTextScaling];
  ]-*/;
	public native void setIsEditable(Object nativeWidget, Object value) /*-[
((ASUITextViewLabel*) nativeWidget).editable = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getIsEditable() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUITextViewLabel*) uiView_).editable];
  ]-*/;
	public native void setAllowsEditingTextAttributes(Object nativeWidget, Object value) /*-[
((ASUITextViewLabel*) nativeWidget).allowsEditingTextAttributes = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getAllowsEditingTextAttributes() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUITextViewLabel*) uiView_).allowsEditingTextAttributes];
  ]-*/;
	public native void setClearsOnInsertion(Object nativeWidget, Object value) /*-[
((ASUITextViewLabel*) nativeWidget).clearsOnInsertion = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getClearsOnInsertion() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUITextViewLabel*) uiView_).clearsOnInsertion];
  ]-*/;
	public native void setIsSelectable(Object nativeWidget, Object value) /*-[
((ASUITextViewLabel*) nativeWidget).selectable = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getIsSelectable() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUITextViewLabel*) uiView_).selectable];
  ]-*/;
	
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
    
	
private UITextViewLabelCommandBuilder builder;
private UITextViewLabelBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public UITextViewLabelBean getBean() {
	if (bean == null) {
		bean = new UITextViewLabelBean();
	}
	return bean;
}
public UITextViewLabelCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new UITextViewLabelCommandBuilder();
	}
	return builder;
}


public  class UITextViewLabelCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <UITextViewLabelCommandBuilder> {
    public UITextViewLabelCommandBuilder() {
	}
	
	public UITextViewLabelCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public UITextViewLabelCommandBuilder tryGetIosText() {
	Map<String, Object> attrs = initCommand("iosText");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosText() {
	Map<String, Object> attrs = initCommand("iosText");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setIosText(String value) {
	Map<String, Object> attrs = initCommand("iosText");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetIosTextColor() {
	Map<String, Object> attrs = initCommand("iosTextColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosTextColor() {
	Map<String, Object> attrs = initCommand("iosTextColor");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setIosTextColor(String value) {
	Map<String, Object> attrs = initCommand("iosTextColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetIosUsesStandardTextScaling() {
	Map<String, Object> attrs = initCommand("iosUsesStandardTextScaling");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosUsesStandardTextScaling() {
	Map<String, Object> attrs = initCommand("iosUsesStandardTextScaling");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setIosUsesStandardTextScaling(boolean value) {
	Map<String, Object> attrs = initCommand("iosUsesStandardTextScaling");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetIosIsEditable() {
	Map<String, Object> attrs = initCommand("iosIsEditable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosIsEditable() {
	Map<String, Object> attrs = initCommand("iosIsEditable");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setIosIsEditable(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsEditable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetIosAllowsEditingTextAttributes() {
	Map<String, Object> attrs = initCommand("iosAllowsEditingTextAttributes");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosAllowsEditingTextAttributes() {
	Map<String, Object> attrs = initCommand("iosAllowsEditingTextAttributes");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setIosAllowsEditingTextAttributes(boolean value) {
	Map<String, Object> attrs = initCommand("iosAllowsEditingTextAttributes");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetIosClearsOnInsertion() {
	Map<String, Object> attrs = initCommand("iosClearsOnInsertion");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosClearsOnInsertion() {
	Map<String, Object> attrs = initCommand("iosClearsOnInsertion");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setIosClearsOnInsertion(boolean value) {
	Map<String, Object> attrs = initCommand("iosClearsOnInsertion");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetIosIsSelectable() {
	Map<String, Object> attrs = initCommand("iosIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosIsSelectable() {
	Map<String, Object> attrs = initCommand("iosIsSelectable");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setIosIsSelectable(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetTextIsSelectable() {
	Map<String, Object> attrs = initCommand("iosIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextIsSelectable() {
	Map<String, Object> attrs = initCommand("iosIsSelectable");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setTextIsSelectable(boolean value) {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetText() {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getText() {
	Map<String, Object> attrs = initCommand("text");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setText(String value) {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetAutoSizeTextType() {
	Map<String, Object> attrs = initCommand("autoSizeTextType");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoSizeTextType() {
	Map<String, Object> attrs = initCommand("autoSizeTextType");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setAutoSizeTextType(String value) {
	Map<String, Object> attrs = initCommand("autoSizeTextType");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetAutoSizeMaxTextSize() {
	Map<String, Object> attrs = initCommand("autoSizeMaxTextSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoSizeMaxTextSize() {
	Map<String, Object> attrs = initCommand("autoSizeMaxTextSize");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setAutoSizeMaxTextSize(String value) {
	Map<String, Object> attrs = initCommand("autoSizeMaxTextSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetAutoSizeMinTextSize() {
	Map<String, Object> attrs = initCommand("autoSizeMinTextSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoSizeMinTextSize() {
	Map<String, Object> attrs = initCommand("autoSizeMinTextSize");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setAutoSizeMinTextSize(String value) {
	Map<String, Object> attrs = initCommand("autoSizeMinTextSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetAutoSizeStepGranularity() {
	Map<String, Object> attrs = initCommand("autoSizeStepGranularity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoSizeStepGranularity() {
	Map<String, Object> attrs = initCommand("autoSizeStepGranularity");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setAutoSizeStepGranularity(String value) {
	Map<String, Object> attrs = initCommand("autoSizeStepGranularity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setAutoSizePresetSizes(String value) {
	Map<String, Object> attrs = initCommand("autoSizePresetSizes");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMinLines(int value) {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setLines(int value) {
	Map<String, Object> attrs = initCommand("lines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMaxLines(int value) {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMinWidth(String value) {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMinHeight(String value) {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetHeight() {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHeight() {
	Map<String, Object> attrs = initCommand("height");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setHeight(String value) {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetWidth() {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getWidth() {
	Map<String, Object> attrs = initCommand("width");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setWidth(String value) {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMaxEms(int value) {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMinEms(int value) {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setEms(int value) {
	Map<String, Object> attrs = initCommand("ems");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetEllipsize() {
	Map<String, Object> attrs = initCommand("ellipsize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getEllipsize() {
	Map<String, Object> attrs = initCommand("ellipsize");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setEllipsize(String value) {
	Map<String, Object> attrs = initCommand("ellipsize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setStartOrStopMarquee(boolean value) {
	Map<String, Object> attrs = initCommand("startOrStopMarquee");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetMarqueeRepeatLimit() {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMarqueeRepeatLimit() {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setMarqueeRepeatLimit(String value) {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setJustificationMode(String value) {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setSingleLine(boolean value) {
	Map<String, Object> attrs = initCommand("singleLine");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setPassword(boolean value) {
	Map<String, Object> attrs = initCommand("password");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetAutoLink() {
	Map<String, Object> attrs = initCommand("autoLink");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoLink() {
	Map<String, Object> attrs = initCommand("autoLink");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setAutoLink(String value) {
	Map<String, Object> attrs = initCommand("autoLink");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setTextAllCaps(boolean value) {
	Map<String, Object> attrs = initCommand("textAllCaps");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setMaxLength(int value) {
	Map<String, Object> attrs = initCommand("maxLength");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setTypeface(String value) {
	Map<String, Object> attrs = initCommand("typeface");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setTextStyle(String value) {
	Map<String, Object> attrs = initCommand("textStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setFontFamily(String value) {
	Map<String, Object> attrs = initCommand("fontFamily");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setDrawableStart(String value) {
	Map<String, Object> attrs = initCommand("drawableStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setDrawableRight(String value) {
	Map<String, Object> attrs = initCommand("drawableRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setDrawableEnd(String value) {
	Map<String, Object> attrs = initCommand("drawableEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setDrawableTop(String value) {
	Map<String, Object> attrs = initCommand("drawableTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setDrawableBottom(String value) {
	Map<String, Object> attrs = initCommand("drawableBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setDrawablePadding(String value) {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setDrawableTint(String value) {
	Map<String, Object> attrs = initCommand("drawableTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setDrawableTintMode(String value) {
	Map<String, Object> attrs = initCommand("drawableTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetLinksClickable() {
	Map<String, Object> attrs = initCommand("linksClickable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLinksClickable() {
	Map<String, Object> attrs = initCommand("linksClickable");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setLinksClickable(boolean value) {
	Map<String, Object> attrs = initCommand("linksClickable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setTextColorLink(String value) {
	Map<String, Object> attrs = initCommand("textColorLink");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setScrollHorizontally(boolean value) {
	Map<String, Object> attrs = initCommand("scrollHorizontally");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setEditable(boolean value) {
	Map<String, Object> attrs = initCommand("editable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setFirstBaselineToTopHeight(String value) {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setLastBaselineToBottomHeight(String value) {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetTextColorHighlight() {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColorHighlight() {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setTextColorHighlight(String value) {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder tryGetTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	return attrs.get("commandReturnValue");
}
public UITextViewLabelCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UITextViewLabelCommandBuilder setTextFormat(String value) {
	Map<String, Object> attrs = initCommand("textFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class UITextViewLabelBean extends com.ashera.layout.ViewImpl.ViewBean{
		public UITextViewLabelBean() {
			super(UITextViewLabelImpl.this);
		}
public Object getIosText() {
	return getBuilder().reset().tryGetIosText().execute(false).getIosText(); 
}
public void setIosText(String value) {
	getBuilder().reset().setIosText(value).execute(true);
}

public Object getIosTextColor() {
	return getBuilder().reset().tryGetIosTextColor().execute(false).getIosTextColor(); 
}
public void setIosTextColor(String value) {
	getBuilder().reset().setIosTextColor(value).execute(true);
}

public Object isIosUsesStandardTextScaling() {
	return getBuilder().reset().tryGetIosUsesStandardTextScaling().execute(false).isIosUsesStandardTextScaling(); 
}
public void setIosUsesStandardTextScaling(boolean value) {
	getBuilder().reset().setIosUsesStandardTextScaling(value).execute(true);
}

public Object isIosIsEditable() {
	return getBuilder().reset().tryGetIosIsEditable().execute(false).isIosIsEditable(); 
}
public void setIosIsEditable(boolean value) {
	getBuilder().reset().setIosIsEditable(value).execute(true);
}

public Object isIosAllowsEditingTextAttributes() {
	return getBuilder().reset().tryGetIosAllowsEditingTextAttributes().execute(false).isIosAllowsEditingTextAttributes(); 
}
public void setIosAllowsEditingTextAttributes(boolean value) {
	getBuilder().reset().setIosAllowsEditingTextAttributes(value).execute(true);
}

public Object isIosClearsOnInsertion() {
	return getBuilder().reset().tryGetIosClearsOnInsertion().execute(false).isIosClearsOnInsertion(); 
}
public void setIosClearsOnInsertion(boolean value) {
	getBuilder().reset().setIosClearsOnInsertion(value).execute(true);
}

public Object isIosIsSelectable() {
	return getBuilder().reset().tryGetIosIsSelectable().execute(false).isIosIsSelectable(); 
}
public void setIosIsSelectable(boolean value) {
	getBuilder().reset().setIosIsSelectable(value).execute(true);
}

public Object getTextIsSelectable() {
	return getBuilder().reset().tryGetTextIsSelectable().execute(false).getTextIsSelectable();
}
public void setTextIsSelectable(boolean value) {
	getBuilder().reset().setTextIsSelectable(value).execute(true); 
}

public Object getText() {
	return getBuilder().reset().tryGetText().execute(false).getText(); 
}
public void setText(String value) {
	getBuilder().reset().setText(value).execute(true);
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

public void setAutoSizePresetSizes(String value) {
	getBuilder().reset().setAutoSizePresetSizes(value).execute(true);
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

public Object getJustificationMode() {
	return getBuilder().reset().tryGetJustificationMode().execute(false).getJustificationMode(); 
}
public void setJustificationMode(String value) {
	getBuilder().reset().setJustificationMode(value).execute(true);
}

public void setSingleLine(boolean value) {
	getBuilder().reset().setSingleLine(value).execute(true);
}

public void setPassword(boolean value) {
	getBuilder().reset().setPassword(value).execute(true);
}

public Object getAutoLink() {
	return getBuilder().reset().tryGetAutoLink().execute(false).getAutoLink(); 
}
public void setAutoLink(String value) {
	getBuilder().reset().setAutoLink(value).execute(true);
}

public void setTextAllCaps(boolean value) {
	getBuilder().reset().setTextAllCaps(value).execute(true);
}

public void setMaxLength(int value) {
	getBuilder().reset().setMaxLength(value).execute(true);
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

public Object getDrawablePadding() {
	return getBuilder().reset().tryGetDrawablePadding().execute(false).getDrawablePadding(); 
}
public void setDrawablePadding(String value) {
	getBuilder().reset().setDrawablePadding(value).execute(true);
}

public void setDrawableTint(String value) {
	getBuilder().reset().setDrawableTint(value).execute(true);
}

public void setDrawableTintMode(String value) {
	getBuilder().reset().setDrawableTintMode(value).execute(true);
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

public void setScrollHorizontally(boolean value) {
	getBuilder().reset().setScrollHorizontally(value).execute(true);
}

public void setEnabled(boolean value) {
	getBuilder().reset().setEnabled(value).execute(true);
}

public void setEditable(boolean value) {
	getBuilder().reset().setEditable(value).execute(true);
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

public Object getTextColorHighlight() {
	return getBuilder().reset().tryGetTextColorHighlight().execute(false).getTextColorHighlight(); 
}
public void setTextColorHighlight(String value) {
	getBuilder().reset().setTextColorHighlight(value).execute(true);
}

public Object getTextColor() {
	return getBuilder().reset().tryGetTextColor().execute(false).getTextColor(); 
}
public void setTextColor(String value) {
	getBuilder().reset().setTextColor(value).execute(true);
}

public void setTextFormat(String value) {
	getBuilder().reset().setTextFormat(value).execute(true);
}

}


    
	//end - body
	private void nativeCreate(Map<String, Object> params) {
		initHtml(params);
		measurableTextView.setIgnoreDrawableHeight(true);
		createNativeWidget(params);
    	registerForAttributeCommandChain("text");
    	registerForAttributeCommandChainWithPhase("predraw", "drawableStart",  "drawableEnd", "drawableLeft", "drawableTop", "drawableRight", "drawableBottom",
    			"drawablePadding", "drawableTint", "drawableTintMode");

	}
	private native void createNativeWidget(Map<String, Object> params)/*-[
		self.uiView = [ASUITextViewLabel new];
	    ((ASUITextViewLabel*) self.uiView).scrollEnabled=NO;
	    ((ASUITextViewLabel*) self.uiView).editable=NO;
	     ((ASUITextViewLabel*) self.uiView).selectable=NO;
	    [((ASUITextViewLabel*) self.uiView) setTextContainerInset:UIEdgeInsetsZero];
	    ((ASUITextViewLabel*) self.uiView).textContainer.lineFragmentPadding = 0;
	    [((ASUITextViewLabel*) self.uiView) setFont:[UIFont systemFontOfSize:[UIFont labelFontSize]]];
	]-*/;
    
    private void addMinMaxListener() {
	}
    
	//start - textColorHighlight
	private void setTextColorHighlight(Object objValue) {
		ViewImpl.setTintColor(uiView, objValue);
	}
	
	
	private Object getTextColorHighlight() {
		return ViewImpl.getTintColor(uiView);
	}
	//end - textColorHighlight

    //start - padding
	//start - templatepadding
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int paddingBottom;
	public Object getPaddingLeft() {
		return paddingLeft;
	}

	public void setPaddingLeft(Object paddingLeft) {
		this.paddingLeft = (int) paddingLeft;
		nativeSetPaddingLeft((int) paddingLeft + measurableTextView.getCompoundPaddingLeft());
	}

	public Object getPaddingRight() {
		return paddingRight;
	}

	public void setPaddingRight(Object paddingRight) {
		this.paddingRight = (int) paddingRight;
		nativeSetPaddingRight((int) paddingRight + measurableTextView.getCompoundPaddingRight());
	}

	public Object getPaddingTop() {
		if (hasFeature("enableFeatures", "cropToPadding")) {
			return measurableTextView.getPaddingTop();
		}
		return paddingTop;
	}

	public void setPaddingTop(Object paddingTop) {
		if (hasFeature("enableFeatures", "cropToPadding")) {
			ViewImpl.setPaddingTop((int) paddingTop, measurableTextView);
		} else {
			this.paddingTop = (int) paddingTop;
			nativeSetPaddingTop((int) paddingTop + measurableTextView.getCompoundPaddingTop());
		}
	}

	public Object getPaddingBottom() {
		if (hasFeature("enableFeatures", "cropToPadding")) {
			return measurableTextView.getPaddingBottom();
		}
		return paddingBottom;
	}
	
	private Object getPaddingEnd() {
		return getPaddingRight();
	}

	private Object getPaddingStart() {
		return getPaddingLeft();
	}	

	public void setPaddingBottom(Object paddingBottom) {
		if (hasFeature("enableFeatures", "cropToPadding")) {
			ViewImpl.setPaddingBottom((int)paddingBottom, measurableTextView);
		} else {
			this.paddingBottom = (int) paddingBottom;
			nativeSetPaddingBottom((int) paddingBottom + measurableTextView.getCompoundPaddingBottom());
		}
	}

	private void setPaddingVertical(Object objValue) {
		setPaddingTop(objValue);
		setPaddingBottom(objValue);
	}

	private void setPaddingHorizontal(Object objValue) {
		setPaddingLeft(objValue);
		setPaddingRight(objValue);
	}

	private void setPaddingEnd(Object objValue) {
		setPaddingRight(objValue);
	}

	private void setPaddingStart(Object objValue) {
		setPaddingLeft(objValue);
	}

	private void setPadding(Object objValue) {
		setPaddingVertical(objValue);
		setPaddingHorizontal(objValue);
	}
	

    public void updatePadding() {
    	setPaddingLeft(paddingLeft);
    	setPaddingRight(paddingRight);
    	setPaddingTop(paddingTop);
    	setPaddingBottom(paddingBottom);
    }
	//end - templatepadding
	private native void nativeSetPaddingBottom(int value) /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
		UIEdgeInsets edgeInsets = label.textContainerInset;
		[label setTextContainerInset:UIEdgeInsetsMake(edgeInsets.top, edgeInsets.left, value, edgeInsets.right)];		
	]-*/;

	private native void nativeSetPaddingLeft(int value) /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
		UIEdgeInsets edgeInsets = label.textContainerInset;
		[label setTextContainerInset:UIEdgeInsetsMake(edgeInsets.top, value, edgeInsets.bottom, edgeInsets.right)];		
	]-*/;

	private native void nativeSetPaddingRight(int value) /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
		UIEdgeInsets edgeInsets = label.textContainerInset;
		[label setTextContainerInset:UIEdgeInsetsMake(edgeInsets.top, edgeInsets.left, edgeInsets.bottom, value)];		
	]-*/;


	private native void nativeSetPaddingTop(int value) /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
		UIEdgeInsets edgeInsets = label.textContainerInset;
		[label setTextContainerInset:UIEdgeInsetsMake(value, edgeInsets.left, edgeInsets.bottom, edgeInsets.right)];		
	]-*/;

    //end - padding

	private native void nativeSetLineBreakMode(int lineBreakMode) /*-[
		((ASUITextViewLabel*)self->uiView_).textContainer.lineBreakMode =lineBreakMode;
	]-*/;
	
	private native Integer nativeGetLinBreakMode() /*-[
		return [JavaLangInteger valueOfWithInt:(jint) ((ASUITextViewLabel*)self->uiView_).textContainer.lineBreakMode];
	]-*/;


	private void setJustificationMode(Object objValue, String strValue) {
		nativeSetTextAligment((int) objValue);
		
	}
	
	private native void nativeSetTextAligment(int textAlignment) /*-[
		[((ASUITextViewLabel*)self->uiView_) setTextAlignment:textAlignment];
	]-*/;

	private Object getJustificationMode() {
		return nativeGetTextAligment();
	}

	private native Integer nativeGetTextAligment() /*-[
		return [JavaLangInteger valueOfWithInt:(jint)((ASUITextViewLabel*)self->uiView_).textAlignment];
	]-*/;
	
	
	private void setSingleLine(Object objValue) {
		if (objValue != null && (boolean) objValue) {
			setNumberOfLines(asNativeWidget(), 1);
		} else {
			setNumberOfLines(asNativeWidget(), 0);
		}
	}
	
	private native void setNumberOfLines(Object asNativeWidget, int numberOfLines) /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) asNativeWidget);
		label.textContainer.maximumNumberOfLines = numberOfLines;
	]-*/;

	private native Object getSingleLine() /*-[
  		return [JavaLangBoolean valueOfWithBoolean:((ASUITextViewLabel*)self.uiView).textContainer.maximumNumberOfLines == 1];
	]-*/;
    
    private void setAutoLink(Object objValue) {
    	nativeSetAutoLink((int) objValue);
    }
    private native void nativeSetAutoLink(int autolinkFlags) /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
		label.selectable = YES;
		label.dataDetectorTypes = autolinkFlags;
	]-*/;
	
	private native Object getAutoLink() /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
		return [JavaLangInteger valueOfWithInt:(jint)label.dataDetectorTypes];
	]-*/;

	private void setEnabled(Object objValue) {
		boolean isEnabled = (boolean) objValue;
		ViewImpl.setIsUserInteractionEnabled(uiView, isEnabled);
	}

	private void setScrollHorizontally(Object objValue) {
		measurableTextView.setHorizontallyScrolling(objValue != null && (Boolean)objValue);
		nativeSetScrollHorizontally(objValue != null && (Boolean)objValue);
	}

	private native void nativeSetScrollHorizontally(boolean scrollHorizontally) /*-[
    	ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
    	[label setScrollEnabled:scrollHorizontally];
	]-*/;

	private void setTextColorLink(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			measurableTextView.setLinkTextColor(colorStateList);
			objValue = measurableTextView.getPaint().linkColor;
		}
		nativesetTextColorLink(ViewImpl.getColor(objValue));
	}
	
	private native void nativesetTextColorLink(Object objValue) /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
		label.linkTextAttributes = @{ NSForegroundColorAttributeName : (UIColor*)objValue };
	]-*/;

	private void setLinksClickable(Object objValue) {
		nativeSetLinksClickable(objValue != null && (Boolean)objValue);
	}

	
	private native void nativeSetLinksClickable(boolean linksClickable) /*-[
    	ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
    	[label setUserInteractionEnabled:linksClickable];
	]-*/;


	private native Object getLinksClickable() /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*) self.uiView);
		return [JavaLangBoolean valueOfWithBoolean:label.userInteractionEnabled];
	]-*/;
	
	@Override
	public int getBaseLine() {
		return nativeGetBaseLine() + measurableTextView.getPaddingTop();
	}
	
	 private native int nativeGetBaseLine() /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*)self->uiView_);
		return label.font.ascender;
	]-*/;

	private native Object getFont() /*-[
		ASUITextViewLabel* label = ((ASUITextViewLabel*)self->uiView_);
		return label.font;
	]-*/;
	
	private void nativeMakeFrameForChildWidget(int l, int t, int r, int b) {
		adjustContentSize(r - l, b - t);
	}
	//start - adjustContentSize
	private com.ashera.view.BaseMeasurableView.VerticalAligment preVerticalAligment;
	private void adjustContentSize(int width, int height) {
		if (measurableTextView.getVerticalAligment() == null && preVerticalAligment == null) {
			return;
		}
		if (!measurableTextView.isVerticalAlignTop()) {
			if (isContentOffsetCorrectionNeeded(uiView)) {
				com.ashera.model.RectM bounds = measurableTextView.getWidgetBounds(width, height, uiView);
				setContentOffset(bounds.y, uiView);
			}
		} else {
			if (preVerticalAligment == null || measurableTextView.getVerticalAligment() != preVerticalAligment) {
				setContentOffset(0, uiView);
			}
		}
		preVerticalAligment = measurableTextView.getVerticalAligment();
	}
	
	private native boolean isContentOffsetCorrectionNeeded(Object view)/*-[
		ASUITextViewLabel* tv = ((ASUITextViewLabel*)view);
		return  [tv contentSize].height <= [tv bounds].size.height;
	]-*/;
	
	private native void setContentOffset(int topCorrect, Object view)/*-[
		((ASUITextViewLabel*) view).topCorrect = -topCorrect;
		[((ASUITextViewLabel*) view) setContentOffset :(CGPoint){.x = 0, .y = -topCorrect}];
	]-*/;
	//end - adjustContentSize
	
	private void setHintColor(int currentHintTextColor) {
	}

	private void syncPlaceholderLabel() {
	}
}
