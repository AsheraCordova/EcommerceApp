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
import r.android.widget.Chronometer;
/*-[
#include "ASUILabel.h"
]-*/
@SuppressLint("NewApi")
public class ChronometerImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "Chronometer"; 
	public final static String GROUP_NAME = "Chronometer";

	protected @Property Object uiView;
	protected MeasurableTextView measurableTextView;		
	
	private String DELLOC_EVENT = com.ashera.widget.bus.Event.StandardEvents.dealloc.toString();
	@com.google.j2objc.annotations.WeakOuter
	class DallocHandler extends com.ashera.widget.bus.EventBusHandler {

		public DallocHandler(String type) {
			super(type);
		}

		@Override
		protected void doPerform(Object payload) {
			releaseResource();
		}
		
	}
	private void addDellocHandler() {
		fragment.getEventBus().on(DELLOC_EVENT, new DallocHandler(DELLOC_EVENT));
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
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAdjustsFontSizeToFitWidth").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAllowsDefaultTighteningForTruncation").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosMinimumScaleFactor").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosNumberOfLines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosHighlightedTextColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorHighlight").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsHighlighted").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosShadowColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosPreferredMaxLayoutWidth").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsUserInteractionEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("startStop").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("countDown").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("format").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onChronometerTick").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baseElapsedTimeInMillis").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("stopWhenReached").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
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
		ConverterFactory.register("Chronometer.justificationMode", new JustificationMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("justificationMode").withType("Chronometer.justificationMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowDx").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowDy").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("singleLine").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAllCaps").withType("boolean").withOrder(-1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("Chronometer.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("Chronometer.font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("Chronometer.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("Chronometer.textStyle").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension").withOrder(1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTint").withType("colorstate").withUiFlag(UPDATE_UI_INVALIDATE));
		ConverterFactory.register("Chronometer.drawableTintMode", new DrawableTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTintMode").withType("Chronometer.drawableTintMode").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollHorizontally").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("firstBaselineToTopHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lastBaselineToBottomHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("colorstate"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("html").withType("boolean"));
	}
	
	public ChronometerImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

@com.google.j2objc.annotations.WeakOuter		
	public class ChronometerExt extends MeasurableTextView implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public ChronometerExt() {
			
			
			
			super(ChronometerImpl.this);
			
			
			
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
			ViewImpl.setDrawableBounds(ChronometerImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(ChronometerImpl.this);
			
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
				ChronometerImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(ChronometerImpl.this);
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
        	return ChronometerImpl.this.suggestedSizeFitsInSpace(mAutoSizeTextSizeInPx, availableSpace.width(), availableSpace.height());
        }
        
        @Override
        protected void setTextSizeInternal(int unit, float optimalTextSize, boolean b) {
        	ChronometerImpl.this.setMyTextSize(optimalTextSize);
        }
		  public int getBorderPadding(){
		    return ChronometerImpl.this.getBorderPadding();
		  }

		  public int getLineHeight(){
		    return ChronometerImpl.this.getLineHeight();
		  }

		  public int getBorderWidth(){
		    return ChronometerImpl.this.getBorderWidth();
		  }
		  public int getLineHeightPadding(){
		    return ChronometerImpl.this.getLineHeightPadding();
		  }
		 @Override
		 public void onRtlPropertiesChanged(int layoutDirection) {
			 ChronometerImpl.this.onRtlPropertiesChanged(layoutDirection);
		 }
	}	
	public void updateMeasuredDimension(int width, int height) {
		((ChronometerExt) measurableTextView).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new ChronometerImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableTextView = new ChronometerExt();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
		setWidgetOnNativeClass();
		addDellocHandler();
	}
	private native void setWidgetOnNativeClass() /*-[
		((ASUILabel*) self.uiView).widget = self;
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
			case "enabled":
			case "iosIsEnabled": {
				


		setIsEnabled(nativeWidget, objValue);



			}
			break;
			case "iosAdjustsFontSizeToFitWidth": {
				


		setAdjustsFontSizeToFitWidth(nativeWidget, objValue);



			}
			break;
			case "iosAllowsDefaultTighteningForTruncation": {
				


		setAllowsDefaultTighteningForTruncation(nativeWidget, objValue);



			}
			break;
			case "iosMinimumScaleFactor": {
				


		setMinimumScaleFactor(nativeWidget, objValue);



			}
			break;
			case "iosNumberOfLines": {
				


		setNumberOfLines(nativeWidget, objValue);



			}
			break;
			case "textColorHighlight":
			case "iosHighlightedTextColor": {
				


		setHighlightedTextColor(nativeWidget, objValue);



			}
			break;
			case "iosIsHighlighted": {
				


		setIsHighlighted(nativeWidget, objValue);



			}
			break;
			case "shadowColor":
			case "iosShadowColor": {
				


		setShadowColor(nativeWidget, objValue);



			}
			break;
			case "iosPreferredMaxLayoutWidth": {
				


		setPreferredMaxLayoutWidth(nativeWidget, objValue);



			}
			break;
			case "iosIsUserInteractionEnabled": {
				


		setIsUserInteractionEnabled(nativeWidget, objValue);



			}
			break;
			case "startStop": {
				


		this.startStop(objValue);



			}
			break;
			case "countDown": {
				


		setCountDown(objValue);



			}
			break;
			case "format": {
				


		setFormat(objValue);



			}
			break;
			case "onChronometerTick": {
				


		setOnChronometerTick(objValue);



			}
			break;
			case "baseElapsedTimeInMillis": {
				


		setBaseElapsedTime(objValue);



			}
			break;
			case "stopWhenReached": {
				


		setStopWhenReached(objValue);



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
			case "justificationMode": {
				


		 setJustificationMode(objValue, strValue);



			}
			break;
			case "shadowDx": {
				


		 setShadowDx((Float) objValue, strValue);



			}
			break;
			case "shadowDy": {
				


		 setShadowDy((Float) objValue, strValue);



			}
			break;
			case "singleLine": {
				


		 setSingleLine(objValue);



			}
			break;
			case "textAllCaps": {
				


		 setTextAllCaps(objValue);



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
			case "scrollHorizontally": {
				


		 setScrollHorizontally(objValue);



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
			case "textColor": {
				


		setTextColor(objValue);



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
			case "enabled":
			case "iosIsEnabled": {
return getIsEnabled();				}
			case "iosAdjustsFontSizeToFitWidth": {
return getAdjustsFontSizeToFitWidth();				}
			case "iosAllowsDefaultTighteningForTruncation": {
return getAllowsDefaultTighteningForTruncation();				}
			case "iosMinimumScaleFactor": {
return getMinimumScaleFactor();				}
			case "iosNumberOfLines": {
return getNumberOfLines();				}
			case "textColorHighlight":
			case "iosHighlightedTextColor": {
return getHighlightedTextColor();				}
			case "iosIsHighlighted": {
return getIsHighlighted();				}
			case "shadowColor":
			case "iosShadowColor": {
return getShadowColor();				}
			case "iosPreferredMaxLayoutWidth": {
return getPreferredMaxLayoutWidth();				}
			case "iosIsUserInteractionEnabled": {
return getIsUserInteractionEnabled();				}
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
			case "justificationMode": {
return getJustificationMode();				}
			case "shadowDx": {
return getShadowDx();				}
			case "shadowDy": {
return getShadowDy();				}
			case "drawablePadding": {
return this.getDrawablePadding();				}
			case "firstBaselineToTopHeight": {
return getFirstBaselineToTopHeight();				}
			case "lastBaselineToBottomHeight": {
return getLastBaselineToBottomHeight();				}
			case "textColor": {
return getTextColorState();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return measurableTextView;
	}

	

	r.android.widget.Chronometer chronometer;
    
    
    private void setupChronoMeter() {
        chronometer = new r.android.widget.Chronometer(this);
        chronometer.setWidgetInfo(WidgetFactory.getAttribute(LOCAL_NAME, "text"));
        chronometer.postInit();

        stopOnDispose();
    }

	private void setCountDown(Object objValue) {
		chronometer.setCountDown((boolean) objValue); 
		
	}
	
	
	private void setOnChronometerTick(Object objValue) {
		Chronometer.OnChronometerTickListener listener; 
		if (objValue instanceof String) {
			listener = new OnChronometerTickListener(this, (String) objValue);
		} else {
			listener = (Chronometer.OnChronometerTickListener) objValue;
		}
		chronometer.setOnChronometerTickListener(listener);
		chronometer.start();
	}
	
	


	private String stopWhenReached;
    private void startStop(Object objValue) {
        chronometer.stop();

        if ((boolean) objValue) {
            chronometer.start();
        }
    }
    
	
	private void setFormat(Object objValue) {
		chronometer.setFormat((String) objValue);
		chronometer.setBase(chronometer.getBase());
		
	}
	
	private void setBaseElapsedTime(Object objValue) {
		chronometer.setBase(((int) objValue) + r.android.os.SystemClock.elapsedRealtime());
		
		if (stopWhenReached != null && isInitialised() && !chronometer.getText().equals(stopWhenReached)) {
			chronometer.start();
		}
	}
	
	private void preOnChronometerTick() {
		if (stopWhenReached != null && isInitialised() && chronometer.getText().equals(stopWhenReached)) {
			chronometer.stop();
		}
	}
	
	private void setStopWhenReached(Object objValue) {
		this.stopWhenReached = (String) objValue;
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
	


  	private void setPassword(Object objValue) {
  		if (!html) {
  			applyAttributeCommand("text", CommonConverters.command_password, new String[] {"password"}, (boolean) objValue);
  		} else {
  			htmlConfig.put("password", objValue);
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
	


	private void nativeCreate(Map<String, Object> params) {
		initHtml(params);
		createLabel(params, (MeasurableTextView) asWidget());
		measurableTextView.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.top);
    	registerForAttributeCommandChain("text");
    	registerForAttributeCommandChainWithPhase("predraw", "drawableStart",  "drawableEnd", "drawableLeft", "drawableTop", "drawableRight", "drawableBottom",
    			"drawablePadding", "drawableTint", "drawableTintMode");
	}
	
	//start - text
	

	private void handleHtmlText(String text) {
		nativeSetHtmlText(com.ashera.parser.html.Html.fromHtml(text, htmlConfig, fragment).get());
	}
	private native void nativeSetText(String text)/*-[
		[((ASUILabel*)self->uiView_) setText:text];
	]-*/;
	
	private native void nativeSetHtmlText(Object text)/*-[
		[((ASUILabel*)self->uiView_) setAttributedText : (NSMutableAttributedString*)text];
	]-*/;
	
	private native Object getMyText() /*-[
		return ((ASUILabel*)self.uiView).text;
	]-*/;
	//end - text
	
	//start - padding
	public void setPadding(Object objValue) {
		int value = (int) objValue;
		View view = (View) asWidget();
		ViewImpl.setPadding(value, view);
	}

	public void setPaddingBottom(Object objValue) {
		int value = (int) objValue;
		View view = (View) asWidget();
		ViewImpl.setPaddingBottom(value, view);
	}
	public void setPaddingTop(Object objValue) {
		int value = (int) objValue;
		View view = (View) asWidget();
		ViewImpl.setPaddingTop(value, view);
	}
	public void setPaddingLeft(Object objValue) {
		int value = (int) objValue;
		View view = (View) asWidget();
		ViewImpl.setPaddingLeft(value, view);
	}
	public void setPaddingRight(Object objValue) {
		int value = (int) objValue;
		View view = (View) asWidget();
		ViewImpl.setPaddingRight(value, view);	
	}
	
	private Object getPaddingTop() {
		return ((View) asWidget()).getPaddingTop();
	}

	private Object getPaddingEnd() {
		return ((View) asWidget()).getPaddingEnd();
	}

	private Object getPaddingStart() {
		return ((View) asWidget()).getPaddingStart();
	}

	private Object getPaddingLeft() {
		return ((View) asWidget()).getPaddingLeft();
	}

	private Object getPaddingRight() {
		return ((View) asWidget()).getPaddingRight();
	}

	private Object getPaddingBottom() {
		return ((View) asWidget()).getPaddingBottom();
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
	//end - padding
	
	//start - mytextsize
	private native Object getTextSize() /*-[
		  return [JavaLangFloat valueOfWithFloat:((ASUILabel*)self.uiView).font.pointSize];
	]-*/;
	private void setMyTextSize(Object objValue) {
		float fontSize = ((float) objValue) * getFragment().getRootActivity().getScaleFactor();
		nativeSetTextSize((int) fontSize);
	}
	
	private native void nativeSetTextSize(int value)/*-[
		[((ASUILabel*)self.uiView) setFont: [((ASUILabel*)self.uiView).font fontWithSize: value]];
	]-*/;
	//end - mytextsize

	//start - gravity
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
		((ASUILabel*)self.uiView).textAlignment = NSTextAlignmentCenter;
	]-*/;
	
	private void setHorizontalAligmentRight()  {
		setHorizontalAligmentRightInternal();
	}

	private native void setHorizontalAligmentRightInternal() /*-[
		((ASUILabel*)self.uiView).textAlignment = NSTextAlignmentRight;
	]-*/;

	private void setHorizontalAligmentLeft() {
		setHorizontalAligmentLeftInternal();
	}
	
	private native void setHorizontalAligmentLeftInternal() /*-[
		((ASUILabel*)self.uiView).textAlignment = NSTextAlignmentLeft;
	]-*/;

	private static final int TEXT_ALIGN_CENTER = 2; 
	private static final int TEXT_ALIGN_LEFT = 0; 
	private static final int TEXT_ALIGN_RIGHT = 1; 

    private native int getTextAlignment() /*-[
    	int alignment = (int) ((ASUILabel*)self.uiView).textAlignment;
    	
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
	//end - gravity

	private void addMinMaxListener() {

	}
	
	//start - lineheight
	public int getBorderPadding() {return 0;}
	
	public int getLineHeightPadding() {
		return 0;
	}
	
	private native int getLineHeight() /*-[
  		return ceil(((ASUILabel*)self.uiView).font.lineHeight);
	]-*/;
	private int getBorderWidth() {
		return 0;
	}
	//end - lineheight

	//start - ellipsize
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
	//end - ellipsize
	
	private native Integer nativeGetLinBreakMode() /*-[
		return [JavaLangInteger valueOfWithInt:(jint) ((ASUILabel*)self->uiView_).lineBreakMode];
	]-*/;
	private native void nativeSetLineBreakMode(int lineBreakMode) /*-[
		[((ASUILabel*)self->uiView_) setLineBreakMode:lineBreakMode];
	]-*/;

	private void setJustificationMode(Object objValue, String strValue) {
		nativeSetTextAligment((int) objValue);
		
	}
	
	private native void nativeSetTextAligment(int textAlignment) /*-[
		[((ASUILabel*)self->uiView_) setTextAlignment:textAlignment];
	]-*/;

	private Object getJustificationMode() {
		return nativeGetTextAligment();
	}

	private native Integer nativeGetTextAligment() /*-[
		return [JavaLangInteger valueOfWithInt:(jint)((ASUILabel*)self->uiView_).textAlignment];
	]-*/;

	private native void setShadowDy(Float objValue, String strValue) /*-[
		ASUILabel* label = ((ASUILabel*)self->uiView_);
		[label setShadowOffset:CGSizeMake(label.shadowOffset.width, [objValue floatValue])];
	]-*/;

	private native void setShadowDx(Float objValue, String strValue) /*-[
		ASUILabel* label = ((ASUILabel*)self->uiView_);
		[label setShadowOffset:CGSizeMake([objValue floatValue], label.shadowOffset.height)];		
	]-*/;
	
	
	private native Object getShadowDy() /*-[
		return [JavaLangFloat valueOfWithFloat:(jint)((ASUILabel*)self->uiView_).shadowOffset.height];
	]-*/;

	private native Object getShadowDx() /*-[
		return [JavaLangFloat valueOfWithFloat:(jint)((ASUILabel*)self->uiView_).shadowOffset.width];
	]-*/;
	
	//start - singleLine
	private void setSingleLine(Object objValue) {
		if (objValue != null && (boolean) objValue) {
			setNumberOfLines(asNativeWidget(), 1);
		} else {
			setNumberOfLines(asNativeWidget(), 0);
		}
	}
	//end - singleLine
	
	private native Object getSingleLine() /*-[
  		return [JavaLangBoolean valueOfWithBoolean:((ASUILabel*)self.uiView).numberOfLines == 1];
	]-*/;
	
	
	private void setEnabled(Object objValue) {
		setIsEnabled(asNativeWidget(), objValue);		
	}
	
	//start - uppercase
	public static String toUpperCase(String text) {
		return text.toUpperCase(java.util.Locale.getDefault());
	}
	//end - uppercase


	//start - font
	private static int ITALIC_FONT_TRAIT = LayoutNativeVars.UIFontDescriptorTraitItalic;
	private static int BOLD_FONT_TRAIT = LayoutNativeVars.UIFontDescriptorTraitBold;
	private static final int NORMAL_FONT_TRAIT = 0;
	
    private int nativeGetFontSize() {
    	return (int) Math.ceil((float)getTextSize());
    }
    
    private native int nativeGetFontStyle() /*-[	 
    	ASUILabel* label = ((ASUILabel*)self->uiView_);
    	return label.font.fontDescriptor.symbolicTraits;
   	]-*/;
    private native void nativeSetCustomFont(int height, com.ashera.model.FontDescriptor fontDescriptor) /*-[	
    	ASUILabel* label = ((ASUILabel*)self->uiView_);
     	UIFont* font = [UIFont fontWithName:[fontDescriptor getName] size:height];
     	if (font == nil) {
        	[NSException raise:@"InitNotImplemented" format:@"%@", [NSString stringWithFormat:@"Failed to load the %@ font. Make sure the font file is included in the project and the font name is spelled correctly.", [fontDescriptor getName]]];
    	}
     	if ([fontDescriptor getStyle] != 0) {
	      UIFontDescriptor* fontD = [font.fontDescriptor fontDescriptorWithSymbolicTraits:[fontDescriptor getStyle]];
	      ((ASUILabel*)label).font = [UIFont fontWithDescriptor:fontD size:0];
	    } else {
	        ((ASUILabel*)label).font = font;
	    }
    ]-*/;
    
    private native void nativeSetFontStyle(int style) /*-[
		ASUILabel* label = ((ASUILabel*)self->uiView_);
  		UIFontDescriptor* fontD = [label.font.fontDescriptor fontDescriptorWithSymbolicTraits:style];
  		((ASUILabel*)label).font = [UIFont fontWithDescriptor:fontD size:0];
	]-*/;
    //end - font
    
    //start - drawable
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
	
	//end - drawable
	
	public void updatePadding() {
		
	}
	
	private void setScrollHorizontally(Object objValue) {
		measurableTextView.setHorizontallyScrolling(objValue != null && (boolean) objValue);
	}
	
	//start - iosmarquee
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
	//end - iosmarquee

	//start - textcolor
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
	//end - textcolor
	
	
	//start - drawableStateChanged
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
	//end - drawableStateChanged
	

	private void setHintColor(int currentHintTextColor) {
	}
	

	private void syncPlaceholderLabel() {
	}
	
	@Override
	public int getBaseLine() {
		return nativeGetBaseLine() + measurableTextView.getPaddingTop();
	}
	
	 private native int nativeGetBaseLine() /*-[
		ASUILabel* label = ((ASUILabel*)self->uiView_);
		return label.font.ascender;
	]-*/;
	 
	private native Object getFont() /*-[
		ASUILabel* label = ((ASUILabel*)self->uiView_);
		return label.font;
	]-*/;
	

	private void setTextColorLink(r.android.content.res.ColorStateList linkTextColors) {
		
	}
	

	public native void setText(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).text = (NSString*) value;
]-*/;
	public native Object getText() /*-[
return ((ASUILabel*) uiView_).text;
  ]-*/;
	public native void setTextColor(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).textColor = (UIColor*) value;
]-*/;
	public native Object getTextColor() /*-[
return ((ASUILabel*) uiView_).textColor;
  ]-*/;
	public native void setIsEnabled(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).enabled = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getIsEnabled() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUILabel*) uiView_).enabled];
  ]-*/;
	public native void setAdjustsFontSizeToFitWidth(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).adjustsFontSizeToFitWidth = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getAdjustsFontSizeToFitWidth() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUILabel*) uiView_).adjustsFontSizeToFitWidth];
  ]-*/;
	public native void setAllowsDefaultTighteningForTruncation(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).allowsDefaultTighteningForTruncation = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getAllowsDefaultTighteningForTruncation() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUILabel*) uiView_).allowsDefaultTighteningForTruncation];
  ]-*/;
	public native void setMinimumScaleFactor(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).minimumScaleFactor = [(JavaLangFloat*) value floatValue];
]-*/;
	public native Object getMinimumScaleFactor() /*-[
return [JavaLangFloat valueOfWithFloat :((ASUILabel*) uiView_).minimumScaleFactor];
  ]-*/;
	public native void setNumberOfLines(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).numberOfLines = [(JavaLangInteger*) value intValue];
]-*/;
	public native Object getNumberOfLines() /*-[
return [JavaLangInteger valueOfWithInt :((ASUILabel*) uiView_).numberOfLines];
  ]-*/;
	public native void setHighlightedTextColor(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).highlightedTextColor = (UIColor*) value;
]-*/;
	public native Object getHighlightedTextColor() /*-[
return ((ASUILabel*) uiView_).highlightedTextColor;
  ]-*/;
	public native void setIsHighlighted(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).highlighted = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getIsHighlighted() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUILabel*) uiView_).highlighted];
  ]-*/;
	public native void setShadowColor(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).shadowColor = (UIColor*) value;
]-*/;
	public native Object getShadowColor() /*-[
return ((ASUILabel*) uiView_).shadowColor;
  ]-*/;
	public native void setPreferredMaxLayoutWidth(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).preferredMaxLayoutWidth = [(JavaLangFloat*) value floatValue];
]-*/;
	public native Object getPreferredMaxLayoutWidth() /*-[
return [JavaLangFloat valueOfWithFloat :((ASUILabel*) uiView_).preferredMaxLayoutWidth];
  ]-*/;
	public native void setIsUserInteractionEnabled(Object nativeWidget, Object value) /*-[
((ASUILabel*) nativeWidget).userInteractionEnabled = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public native Object getIsUserInteractionEnabled() /*-[
return [JavaLangBoolean valueOfWithBoolean :((ASUILabel*) uiView_).userInteractionEnabled];
  ]-*/;
	@SuppressLint("NewApi")
private static class OnChronometerTickListener implements Chronometer.OnChronometerTickListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnChronometerTickListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnChronometerTickListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onChronometerTick (Chronometer chronometer){
    	((ChronometerImpl)w).preOnChronometerTick();
    
	if (action == null || action.equals("onChronometerTick")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onChronometerTick");
	    java.util.Map<String, Object> obj = getOnChronometerTickEventObj(chronometer);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, chronometer);
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

public java.util.Map<String, Object> getOnChronometerTickEventObj(Chronometer chronometer) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "chronometertick");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, chronometer, w.getFragment());
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onChronometerTick", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
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
    
	
private ChronometerCommandBuilder builder;
private ChronometerBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ChronometerBean getBean() {
	if (bean == null) {
		bean = new ChronometerBean();
	}
	return bean;
}
public ChronometerCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ChronometerCommandBuilder();
	}
	return builder;
}


public  class ChronometerCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <ChronometerCommandBuilder> {
    public ChronometerCommandBuilder() {
	}
	
	public ChronometerCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ChronometerCommandBuilder tryGetIosText() {
	Map<String, Object> attrs = initCommand("iosText");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosText() {
	Map<String, Object> attrs = initCommand("iosText");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosText(String value) {
	Map<String, Object> attrs = initCommand("iosText");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosTextColor() {
	Map<String, Object> attrs = initCommand("iosTextColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosTextColor() {
	Map<String, Object> attrs = initCommand("iosTextColor");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosTextColor(String value) {
	Map<String, Object> attrs = initCommand("iosTextColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosIsEnabled() {
	Map<String, Object> attrs = initCommand("iosIsEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosIsEnabled() {
	Map<String, Object> attrs = initCommand("iosIsEnabled");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosIsEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetEnabled() {
	Map<String, Object> attrs = initCommand("iosIsEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getEnabled() {
	Map<String, Object> attrs = initCommand("iosIsEnabled");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosAdjustsFontSizeToFitWidth() {
	Map<String, Object> attrs = initCommand("iosAdjustsFontSizeToFitWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosAdjustsFontSizeToFitWidth() {
	Map<String, Object> attrs = initCommand("iosAdjustsFontSizeToFitWidth");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosAdjustsFontSizeToFitWidth(boolean value) {
	Map<String, Object> attrs = initCommand("iosAdjustsFontSizeToFitWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosAllowsDefaultTighteningForTruncation() {
	Map<String, Object> attrs = initCommand("iosAllowsDefaultTighteningForTruncation");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosAllowsDefaultTighteningForTruncation() {
	Map<String, Object> attrs = initCommand("iosAllowsDefaultTighteningForTruncation");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosAllowsDefaultTighteningForTruncation(boolean value) {
	Map<String, Object> attrs = initCommand("iosAllowsDefaultTighteningForTruncation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosMinimumScaleFactor() {
	Map<String, Object> attrs = initCommand("iosMinimumScaleFactor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosMinimumScaleFactor() {
	Map<String, Object> attrs = initCommand("iosMinimumScaleFactor");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosMinimumScaleFactor(float value) {
	Map<String, Object> attrs = initCommand("iosMinimumScaleFactor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosNumberOfLines() {
	Map<String, Object> attrs = initCommand("iosNumberOfLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosNumberOfLines() {
	Map<String, Object> attrs = initCommand("iosNumberOfLines");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosNumberOfLines(int value) {
	Map<String, Object> attrs = initCommand("iosNumberOfLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosHighlightedTextColor() {
	Map<String, Object> attrs = initCommand("iosHighlightedTextColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosHighlightedTextColor() {
	Map<String, Object> attrs = initCommand("iosHighlightedTextColor");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosHighlightedTextColor(String value) {
	Map<String, Object> attrs = initCommand("iosHighlightedTextColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetTextColorHighlight() {
	Map<String, Object> attrs = initCommand("iosHighlightedTextColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColorHighlight() {
	Map<String, Object> attrs = initCommand("iosHighlightedTextColor");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setTextColorHighlight(String value) {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosIsHighlighted() {
	Map<String, Object> attrs = initCommand("iosIsHighlighted");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosIsHighlighted() {
	Map<String, Object> attrs = initCommand("iosIsHighlighted");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosIsHighlighted(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsHighlighted");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosShadowColor() {
	Map<String, Object> attrs = initCommand("iosShadowColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosShadowColor() {
	Map<String, Object> attrs = initCommand("iosShadowColor");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosShadowColor(String value) {
	Map<String, Object> attrs = initCommand("iosShadowColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetShadowColor() {
	Map<String, Object> attrs = initCommand("iosShadowColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowColor() {
	Map<String, Object> attrs = initCommand("iosShadowColor");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setShadowColor(String value) {
	Map<String, Object> attrs = initCommand("shadowColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosPreferredMaxLayoutWidth() {
	Map<String, Object> attrs = initCommand("iosPreferredMaxLayoutWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosPreferredMaxLayoutWidth() {
	Map<String, Object> attrs = initCommand("iosPreferredMaxLayoutWidth");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosPreferredMaxLayoutWidth(float value) {
	Map<String, Object> attrs = initCommand("iosPreferredMaxLayoutWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetIosIsUserInteractionEnabled() {
	Map<String, Object> attrs = initCommand("iosIsUserInteractionEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIosIsUserInteractionEnabled() {
	Map<String, Object> attrs = initCommand("iosIsUserInteractionEnabled");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setIosIsUserInteractionEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsUserInteractionEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setStartStop(boolean value) {
	Map<String, Object> attrs = initCommand("startStop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setCountDown(boolean value) {
	Map<String, Object> attrs = initCommand("countDown");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setFormat(String value) {
	Map<String, Object> attrs = initCommand("format");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setOnChronometerTick(String value) {
	Map<String, Object> attrs = initCommand("onChronometerTick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setBaseElapsedTimeInMillis(int value) {
	Map<String, Object> attrs = initCommand("baseElapsedTimeInMillis");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setStopWhenReached(String value) {
	Map<String, Object> attrs = initCommand("stopWhenReached");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetText() {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getText() {
	Map<String, Object> attrs = initCommand("text");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setText(String value) {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setMinLines(int value) {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setLines(int value) {
	Map<String, Object> attrs = initCommand("lines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setMaxLines(int value) {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setMinWidth(String value) {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setMinHeight(String value) {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetHeight() {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHeight() {
	Map<String, Object> attrs = initCommand("height");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setHeight(String value) {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetWidth() {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getWidth() {
	Map<String, Object> attrs = initCommand("width");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setWidth(String value) {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setMaxEms(int value) {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setMinEms(int value) {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setEms(int value) {
	Map<String, Object> attrs = initCommand("ems");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setJustificationMode(String value) {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetShadowDx() {
	Map<String, Object> attrs = initCommand("shadowDx");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowDx() {
	Map<String, Object> attrs = initCommand("shadowDx");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setShadowDx(float value) {
	Map<String, Object> attrs = initCommand("shadowDx");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetShadowDy() {
	Map<String, Object> attrs = initCommand("shadowDy");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowDy() {
	Map<String, Object> attrs = initCommand("shadowDy");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setShadowDy(float value) {
	Map<String, Object> attrs = initCommand("shadowDy");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setSingleLine(boolean value) {
	Map<String, Object> attrs = initCommand("singleLine");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setTextAllCaps(boolean value) {
	Map<String, Object> attrs = initCommand("textAllCaps");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setTypeface(String value) {
	Map<String, Object> attrs = initCommand("typeface");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setTextStyle(String value) {
	Map<String, Object> attrs = initCommand("textStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setFontFamily(String value) {
	Map<String, Object> attrs = initCommand("fontFamily");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setDrawableStart(String value) {
	Map<String, Object> attrs = initCommand("drawableStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setDrawableRight(String value) {
	Map<String, Object> attrs = initCommand("drawableRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setDrawableEnd(String value) {
	Map<String, Object> attrs = initCommand("drawableEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setDrawableTop(String value) {
	Map<String, Object> attrs = initCommand("drawableTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setDrawableBottom(String value) {
	Map<String, Object> attrs = initCommand("drawableBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setDrawablePadding(String value) {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setDrawableTint(String value) {
	Map<String, Object> attrs = initCommand("drawableTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setDrawableTintMode(String value) {
	Map<String, Object> attrs = initCommand("drawableTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder setScrollHorizontally(boolean value) {
	Map<String, Object> attrs = initCommand("scrollHorizontally");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setFirstBaselineToTopHeight(String value) {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setLastBaselineToBottomHeight(String value) {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ChronometerCommandBuilder tryGetTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	return attrs.get("commandReturnValue");
}
public ChronometerCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ChronometerBean extends com.ashera.layout.ViewImpl.ViewBean{
		public ChronometerBean() {
			super(ChronometerImpl.this);
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

public Object isIosIsEnabled() {
	return getBuilder().reset().tryGetIosIsEnabled().execute(false).isIosIsEnabled(); 
}
public void setIosIsEnabled(boolean value) {
	getBuilder().reset().setIosIsEnabled(value).execute(true);
}

public Object getEnabled() {
	return getBuilder().reset().tryGetEnabled().execute(false).getEnabled();
}
public void setEnabled(boolean value) {
	getBuilder().reset().setEnabled(value).execute(true); 
}

public Object isIosAdjustsFontSizeToFitWidth() {
	return getBuilder().reset().tryGetIosAdjustsFontSizeToFitWidth().execute(false).isIosAdjustsFontSizeToFitWidth(); 
}
public void setIosAdjustsFontSizeToFitWidth(boolean value) {
	getBuilder().reset().setIosAdjustsFontSizeToFitWidth(value).execute(true);
}

public Object isIosAllowsDefaultTighteningForTruncation() {
	return getBuilder().reset().tryGetIosAllowsDefaultTighteningForTruncation().execute(false).isIosAllowsDefaultTighteningForTruncation(); 
}
public void setIosAllowsDefaultTighteningForTruncation(boolean value) {
	getBuilder().reset().setIosAllowsDefaultTighteningForTruncation(value).execute(true);
}

public Object getIosMinimumScaleFactor() {
	return getBuilder().reset().tryGetIosMinimumScaleFactor().execute(false).getIosMinimumScaleFactor(); 
}
public void setIosMinimumScaleFactor(float value) {
	getBuilder().reset().setIosMinimumScaleFactor(value).execute(true);
}

public Object getIosNumberOfLines() {
	return getBuilder().reset().tryGetIosNumberOfLines().execute(false).getIosNumberOfLines(); 
}
public void setIosNumberOfLines(int value) {
	getBuilder().reset().setIosNumberOfLines(value).execute(true);
}

public Object getIosHighlightedTextColor() {
	return getBuilder().reset().tryGetIosHighlightedTextColor().execute(false).getIosHighlightedTextColor(); 
}
public void setIosHighlightedTextColor(String value) {
	getBuilder().reset().setIosHighlightedTextColor(value).execute(true);
}

public Object getTextColorHighlight() {
	return getBuilder().reset().tryGetTextColorHighlight().execute(false).getTextColorHighlight();
}
public void setTextColorHighlight(String value) {
	getBuilder().reset().setTextColorHighlight(value).execute(true); 
}

public Object isIosIsHighlighted() {
	return getBuilder().reset().tryGetIosIsHighlighted().execute(false).isIosIsHighlighted(); 
}
public void setIosIsHighlighted(boolean value) {
	getBuilder().reset().setIosIsHighlighted(value).execute(true);
}

public Object getIosShadowColor() {
	return getBuilder().reset().tryGetIosShadowColor().execute(false).getIosShadowColor(); 
}
public void setIosShadowColor(String value) {
	getBuilder().reset().setIosShadowColor(value).execute(true);
}

public Object getShadowColor() {
	return getBuilder().reset().tryGetShadowColor().execute(false).getShadowColor();
}
public void setShadowColor(String value) {
	getBuilder().reset().setShadowColor(value).execute(true); 
}

public Object getIosPreferredMaxLayoutWidth() {
	return getBuilder().reset().tryGetIosPreferredMaxLayoutWidth().execute(false).getIosPreferredMaxLayoutWidth(); 
}
public void setIosPreferredMaxLayoutWidth(float value) {
	getBuilder().reset().setIosPreferredMaxLayoutWidth(value).execute(true);
}

public Object isIosIsUserInteractionEnabled() {
	return getBuilder().reset().tryGetIosIsUserInteractionEnabled().execute(false).isIosIsUserInteractionEnabled(); 
}
public void setIosIsUserInteractionEnabled(boolean value) {
	getBuilder().reset().setIosIsUserInteractionEnabled(value).execute(true);
}

public void setStartStop(boolean value) {
	getBuilder().reset().setStartStop(value).execute(true);
}

public void setCountDown(boolean value) {
	getBuilder().reset().setCountDown(value).execute(true);
}

public void setFormat(String value) {
	getBuilder().reset().setFormat(value).execute(true);
}

public void setOnChronometerTick(String value) {
	getBuilder().reset().setOnChronometerTick(value).execute(true);
}

public void setBaseElapsedTimeInMillis(int value) {
	getBuilder().reset().setBaseElapsedTimeInMillis(value).execute(true);
}

public void setStopWhenReached(String value) {
	getBuilder().reset().setStopWhenReached(value).execute(true);
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

public Object getJustificationMode() {
	return getBuilder().reset().tryGetJustificationMode().execute(false).getJustificationMode(); 
}
public void setJustificationMode(String value) {
	getBuilder().reset().setJustificationMode(value).execute(true);
}

public Object getShadowDx() {
	return getBuilder().reset().tryGetShadowDx().execute(false).getShadowDx(); 
}
public void setShadowDx(float value) {
	getBuilder().reset().setShadowDx(value).execute(true);
}

public Object getShadowDy() {
	return getBuilder().reset().tryGetShadowDy().execute(false).getShadowDy(); 
}
public void setShadowDy(float value) {
	getBuilder().reset().setShadowDy(value).execute(true);
}

public void setSingleLine(boolean value) {
	getBuilder().reset().setSingleLine(value).execute(true);
}

public void setTextAllCaps(boolean value) {
	getBuilder().reset().setTextAllCaps(value).execute(true);
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

public void setScrollHorizontally(boolean value) {
	getBuilder().reset().setScrollHorizontally(value).execute(true);
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

public Object getTextColor() {
	return getBuilder().reset().tryGetTextColor().execute(false).getTextColor(); 
}
public void setTextColor(String value) {
	getBuilder().reset().setTextColor(value).execute(true);
}

}


    
	//end - body

	private native void createChronoLabel(Map<String, Object> params, MeasurableTextView measurableView)/*-[
		self.uiView = [ASUILabel new];
		((ASUILabel*)self.uiView).numberOfLines = 0;
		((ASUILabel*)self.uiView).lineBreakMode = NSLineBreakByClipping;
	]-*/;
	private void createLabel(Map<String, Object> params, MeasurableTextView asWidget) {
		createChronoLabel(params, asWidget);	
		setupChronoMeter();
	}
	
	private void stopOnDispose() {
		
	}
	

	private void releaseResource() {
		chronometer.stop();
	}
}
