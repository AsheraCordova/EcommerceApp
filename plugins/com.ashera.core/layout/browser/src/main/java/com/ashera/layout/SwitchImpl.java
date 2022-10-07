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
import r.android.widget.CompoundButton;
@SuppressLint("NewApi")
public class SwitchImpl extends BaseWidget implements ICustomMeasureWidth{
	//start - body
	public final static String LOCAL_NAME = "Switch"; 
	public final static String GROUP_NAME = "Switch";

	protected org.teavm.jso.dom.html.HTMLElement hTMLElement;
	protected MeasurableSwitch measurableSwitch;	
	
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
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onCheckedChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
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
		ConverterFactory.register("Switch.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("Switch.font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("Switch.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("Switch.textStyle").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension").withOrder(1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLength").withType("int").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("singleLine").withType("boolean").withOrder(-1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAllCaps").withType("boolean").withOrder(-1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollHorizontally").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("Switch.ellipsize", new Ellipsize());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ellipsize").withType("Switch.ellipsize"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("startOrStopMarquee").withType("boolean"));
		ConverterFactory.register("Switch.marqueeRepeatLimit", new MarqueeRepeatLimit());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("marqueeRepeatLimit").withType("Switch.marqueeRepeatLimit"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("firstBaselineToTopHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lastBaselineToBottomHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
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
		ConverterFactory.register("Switch.drawableTintMode", new DrawableTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTintMode").withType("Switch.drawableTintMode"));
		ConverterFactory.register("Switch.justificationMode", new JustificationMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("justificationMode").withType("Switch.justificationMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("letterSpacing").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowDx").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowDy").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowRadius").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textIsSelectable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineHeight").withType("dimensionfloat").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingExtra").withType("dimensionfloat").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingMultiplier").withType("float").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorHighlight").withType("color"));
		ConverterFactory.register("Switch.autoLink", new AutoLink());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoLink").withType("Switch.autoLink").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorLink").withType("colorstate").withOrder(-100));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textFormat").withType("resourcestring").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("checked").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("switchPadding").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("switchMinWidth").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("html").withType("boolean"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("webEnableTintFilter").withType("boolean"));
	}
	
	public SwitchImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class SwitchExt extends MeasurableSwitch implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public SwitchExt() {
			
			
			
			
			
			
			super(SwitchImpl.this);
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
			ViewImpl.setDrawableBounds(SwitchImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			nativeMakeFrameForChildWidget(l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(SwitchImpl.this);
			
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
				SwitchImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(SwitchImpl.this);
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
		  public int getBorderPadding(){
		    return SwitchImpl.this.getBorderPadding();
		  }

		  public int getLineHeight(){
		    return SwitchImpl.this.getLineHeight();
		  }

		  public int getBorderWidth(){
		    return SwitchImpl.this.getBorderWidth();
		  }
		  public int getLineHeightPadding(){
		    return SwitchImpl.this.getLineHeightPadding();
		  }
        @Override
        public int nativeMeasureWidth(java.lang.Object uiView) {
        	return SwitchImpl.this.nativeMeasureWidth(uiView);
        }
        
        @Override
        public int nativeMeasureHeight(java.lang.Object uiView, int width) {
        	return SwitchImpl.this.nativeMeasureHeight(uiView, width);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	}

	@Override
	public IWidget newInstance() {
		return new SwitchImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableSwitch = new SwitchExt();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "onCheckedChange": {
				


		setOnChecked(objValue);



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
			case "singleLine": {
				


		 setSingleLine(objValue);



			}
			break;
			case "textAllCaps": {
				


		 setTextAllCaps(objValue);



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
			case "justificationMode": {
				


		 setJustificationMode(objValue, strValue);



			}
			break;
			case "letterSpacing": {
				


		 setLetterSpacing((Float) objValue, strValue);



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
			case "shadowColor": {
				


		 setShadowColor(objValue, strValue);



			}
			break;
			case "shadowRadius": {
				


		 setShadowRadius((Float) objValue, strValue);



			}
			break;
			case "textIsSelectable": {
				


		 setTextIsSelectable(objValue, strValue);



			}
			break;
			case "lineHeight": {
				


		 setMyLineHeight(objValue);



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
			case "textColorHighlight": {
				


		 setTextColorHighlight(objValue);



			}
			break;
			case "autoLink": {
				


		 setAutoLink(objValue);



			}
			break;
			case "textColorLink": {
				


		 setTextColorLink(objValue);



			}
			break;
			case "textFormat": {
				


		setTextFormat(objValue);



			}
			break;
			case "checked": {
				


		setChecked(objValue);



			}
			break;
			case "switchPadding": {
				


		measurableSwitch.setSwitchPadding((int) objValue);



			}
			break;
			case "switchMinWidth": {
				


		measurableSwitch.setMinWidth((int) objValue);



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
		Object nativeWidget = asNativeWidget();
		Object attributeValue = ViewImpl.getAttribute(this, nativeWidget, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		switch (key.getAttributeName()) {
			case "text": {
return getMyText();				}
			case "textColor": {
return getTextColor();				}
			case "gravity": {
return getGravity();				}
			case "textSize": {
return getTextSize();				}
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
			case "ellipsize": {
return getEllipsize();				}
			case "marqueeRepeatLimit": {
return getMarqueeRepeatLimit();				}
			case "firstBaselineToTopHeight": {
return getFirstBaselineToTopHeight();				}
			case "lastBaselineToBottomHeight": {
return getLastBaselineToBottomHeight();				}
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
			case "justificationMode": {
return getJustificationMode();				}
			case "letterSpacing": {
return getLetterSpacing();				}
			case "shadowDx": {
return getShadowDx();				}
			case "shadowDy": {
return getShadowDy();				}
			case "shadowColor": {
return getShadowColor();				}
			case "shadowRadius": {
return getShadowRadius();				}
			case "textIsSelectable": {
return getTextIsSelectable();				}
			case "lineHeight": {
return getMyLineHeight();				}
			case "lineSpacingExtra": {
return getLineSpacingExtra();				}
			case "lineSpacingMultiplier": {
return getLineSpacingMultiplier();				}
			case "textColorHighlight": {
return getTextColorHighlight();				}
			case "autoLink": {
return getAutoLink();				}
			case "checked": {
return getChecked();				}
			case "switchPadding": {
return measurableSwitch.getSwitchPadding();				}
			case "switchMinWidth": {
return measurableSwitch.getMinWidth();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return measurableSwitch;
	}

	

	@Override
	public java.lang.Object asNativeWidget() {
		return hTMLElement;
	}
    
    //start - nativeMeasure
    @org.teavm.jso.JSBody(params = { "element" }, script = "return window.nativeMeasureWidth(element);")
    private static native int windowNativeMeasureWidth(org.teavm.jso.dom.html.HTMLElement element);
    
    @org.teavm.jso.JSBody(params = { "element", "width" }, script = "return window.nativeMeasureHeight(element, width);")
    private static native int windowNativeMeasureHeight(org.teavm.jso.dom.html.HTMLElement element, int width);
    
	public int nativeMeasureHeight(Object uiView, int width) {
		return windowNativeMeasureHeight(label, width);
	}

	public int nativeMeasureWidth(Object uiView) {
		return windowNativeMeasureWidth(label);
	}
	
	//end - nativeMeasure
	//start - drawable
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
			measurableSwitch.setBottomDrawable(drawable);
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
			measurableSwitch.setTopDrawable(drawable);
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
			measurableSwitch.setRightDrawable(drawable);
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
			measurableSwitch.setLeftDrawable(drawable);
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
		measurableSwitch.setDrawablePadding((int) objValue);
	}
	
	private Object getDrawablePadding() {
		return measurableSwitch.getDrawablePadding();
	}
	
	private void updateDrawableBounds(int l, int t, int r, int b) {
		if (drawableBottom != null) {
			com.ashera.model.RectM bounds = measurableSwitch.getBottomDrawableBounds(l, t, r - l, b - t);
			ViewImpl.updateBounds(drawableBottomWrapper, bounds.x, bounds.y, bounds.width, bounds.height);
		}	
		
		if (drawableTop != null) {
			com.ashera.model.RectM bounds = measurableSwitch.getTopDrawableBounds(l, t, r - l, b - t);
			ViewImpl.updateBounds(drawableTopWrapper, bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		if (drawableLeft != null) {
			com.ashera.model.RectM bounds = measurableSwitch.getLeftDrawableBounds(l, t, r - l, b - t);
			ViewImpl.updateBounds(drawableLeftWrapper, bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		if (drawableRight != null) {
			com.ashera.model.RectM bounds = measurableSwitch.getRightDrawableBounds(l, t, r - l, b - t);
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
			objValue = colorStateList.getColorForState(measurableSwitch.getDrawableState(), r.android.graphics.Color.RED);
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
		drawableStateChange(drawableBottom, measurableSwitch.getBottomDrawable(), () -> {
			setDrawableBottom(measurableSwitch.getBottomDrawable());
		});
		drawableStateChange(drawableLeft, measurableSwitch.getLeftDrawable(), () -> {
			setDrawableLeft(measurableSwitch.getLeftDrawable());
		});
		drawableStateChange(drawableRight, measurableSwitch.getRightDrawable(), () -> {
			setDrawableRight(measurableSwitch.getRightDrawable());
		});
		drawableStateChange(drawableTop, measurableSwitch.getTopDrawable(), () -> {
			setDrawableTop(measurableSwitch.getTopDrawable());
		});
		
		if (measurableSwitch.getTextColors() != null) {
			setTextColor(measurableSwitch.getCurrentTextColor());
		}
		
		if (drawableTint != null && drawableTint.isStateful()) {
			setDrawableTint(drawableTint);
		}
		drawableStateChangedAdditional();
	}
    
	private void drawableStateChange(HTMLElement mydrawable, r.android.graphics.drawable.Drawable dr, Runnable run) {
		if (mydrawable != null) {
			final int[] state = measurableSwitch.getDrawableState();
			
			if (dr != null && dr.isStateful() && dr.setState(state)) {
				run.run();
			}
		}
	}
	//end - drawable
	
	//start - paddingcopy
    private void setPadding(Object objValue) {
    	setPaddingBottom(objValue);
    	setPaddingTop(objValue);
    	setPaddingLeft(objValue);
    	setPaddingRight(objValue);
	}
	
	private void setPaddingLeft(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-left", value  + "px");
		ViewImpl.setPaddingLeft(objValue, measurableSwitch);
	}
	
	private void setPaddingRight(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-right", value + "px");
		ViewImpl.setPaddingRight(objValue, measurableSwitch);
	}

	private void setPaddingTop(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-top", value + "px");
		ViewImpl.setPaddingTop(objValue, measurableSwitch);
	}

	private void setPaddingBottom(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-bottom", value + "px");
		ViewImpl.setPaddingBottom(objValue, measurableSwitch);
	}

	private Object getPaddingTop() {
		return measurableSwitch.getPaddingTop();
	}

	private Object getPaddingBottom() {
		return measurableSwitch.getPaddingBottom();
	}

	private Object getPaddingLeft() {
		return measurableSwitch.getPaddingStart();
	}

	private Object getPaddingRight() {
		return measurableSwitch.getPaddingEnd();
	}

	private void setPaddingHorizontal(Object objValue) {
		setPaddingLeft(objValue);
		setPaddingRight(objValue);
	}

	private void setPaddingVertical(Object objValue) {
		setPaddingTop(objValue);
		setPaddingBottom(objValue);
	}
	//end - paddingcopy
	//start - textcolor
	private Object getTextColor() {
		return measurableSwitch.getTextColors();
	}
	private void setTextColor(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			measurableSwitch.setTextColor(colorStateList);
			objValue = measurableSwitch.getCurrentTextColor();
		}
		hTMLElement.getStyle().setProperty("color", (String) ViewImpl.getColor(objValue));
	}
	//end - textcolor

	//start - gravity
	private void setHorizontalAligmentRight() {
		hTMLElement.getStyle().setProperty("text-align", "right");
	}

	private void setHorizontalAligmentCenter() {
		hTMLElement.getStyle().setProperty("text-align", "center");
	}

	private void setHorizontalAligmentLeft() {
		hTMLElement.getStyle().setProperty("text-align", "left");
	}
	//end - gravity

	
	@org.teavm.jso.JSBody(params = { "element"}, script = "return window.getLineHeight(element);")
    private static native int getLineHeight(org.teavm.jso.dom.html.HTMLElement element);
	public int getLineHeight() {
		int lineHeight = getLineHeight(label);
		return lineHeight;
	}
	
	private void setLetterSpacing(Float objValue, String strValue) {
		label.getStyle().setProperty("letter-spacing", String.valueOf(objValue) + "px");	
	}
	

	private Object getLetterSpacing() {
		return ViewImpl.getPropertyValueAsInt(label, "letter-spacing");
	}
	
	private void setLineSpacing() {
		int lineHeight = getLineHeight();
		int lineSpacing = (int )Math.round((mSpacingAdd + (mSpacingMult * lineHeight)));
		label.getStyle().setProperty("line-height", (lineHeight + lineSpacing) + "px");
		
	}
	
	//start - textsize
	public void setMyTextSize(Object objValue) {
		label.getStyle().setProperty("font-size", ((float)objValue * getFragment().getRootActivity().getScaleFactor()) + "px" );
	}
	//end - textsize

	//start - textstyle
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
        label.getStyle().setProperty("font-style", fontStyle);
        label.getStyle().setProperty("font-weight", fontWeight);
	}
	//end - textstyle
	
	private void setMyLineHeight(Object objValue) {
		label.getStyle().setProperty("line-height", (objValue) + "px");		
	}
	
	private Object getMyLineHeight() {
		return ViewImpl.getPropertyValueAsFloat(label, "line-height");
	}
    
	//start - font
	private Object getFont() {
		return label.getStyle().getPropertyValue("font-family");
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
        label.getStyle().setProperty("font-family", fontDescriptor.getName());
    }

	private void setTypeFace(Object objValue, String strValue) {
		setFontFamily(objValue, strValue);
	}
	//end - font

	private Object getTextSize() {
		String fontSize = label.getStyle().getPropertyValue("font-size");
		if (fontSize != null && !fontSize.isEmpty()) {
			return ViewImpl.getPropertyValueAsInt(label, "font-size");
		}
		return getLineHeight(label);
	}

	private Object textColorHighlight;
	private void setTextColorHighlight(Object objValue) {
		textColorHighlight = objValue;
		if (label.getClassName() == null) {
			label.setClassName("");
		}
		
		String colorCss = "textcolorhighlight_" + ((String) ViewImpl.getColor(objValue)).replaceAll("#", "");
		if (label.getClassName().indexOf("textcolorhighlight_") != -1) {
			label.setClassName(label.getClassName().replaceAll("textcolorhighlight_([0-9|A-Z])*\\s?", ""));
		}
		if (label.getClassName().indexOf(colorCss) == -1) {
			label.setClassName(colorCss + " " + (label.getClassName() == null ? "" : label.getClassName()));
		}
	}
	
	
	private Object getTextColorHighlight() {
		return textColorHighlight;
	}
	
	
	//start - valign
	private void setVerticalAligmentCenter() {
		hTMLElement.getStyle().setProperty("vertical-align", "middle");
		measurableSwitch.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.middle);
	}

	private void setVerticalAligmentBottom() {
		hTMLElement.getStyle().setProperty("vertical-align", "bottom");		
		measurableSwitch.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.bottom);
	}

	private void setVerticalAligmentTop() {
		hTMLElement.getStyle().setProperty("vertical-align", "top");		
		measurableSwitch.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.top);
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
	//end - valign
	
	private float shadowRadius;
	private String shadowColor = "";
	private float shadowDx;
	private float shadowDy;
	

	private Object getShadowRadius() {
		return shadowRadius;
	}

	private Object getShadowColor() {
		return shadowColor;
	}

	private Object getShadowDy() {
		return shadowDy;
	}

	private Object getShadowDx() {
		return shadowDx;
	}
	private void setShadowRadius(Float objValue, String strValue) {
		this.shadowRadius = objValue;
		updateTextShadow();	
	}

	private void updateTextShadow() {
		label.getStyle().setProperty("text-shadow", String.format("%spx %spx %spx %s", String.valueOf(shadowDx), String.valueOf(shadowDy), String.valueOf(shadowRadius), shadowColor));
	}

	private void setShadowColor(Object objValue, String strValue) {
		this.shadowColor = (String) objValue;
		updateTextShadow();
	}

	private void setShadowDy(Float objValue, String strValue) {
		this.shadowDy = objValue;
		updateTextShadow();
	}

	private void setShadowDx(Float objValue, String strValue) {
		this.shadowDx = objValue;
		updateTextShadow();
		
	}
	
	


	private HTMLElement label;
	private HTMLElement labelWrapper;
	
    private void nativeCreateLabel(Map<String, Object> params) {
    	escapeHtml = true;
    	registerForAttributeCommandChain("text");
    	initHtml(params);
    	if ("true".equals(params.get("webEnableTintFilter"))) {
    		enableTintFilter = true;
    	}
		nativeCreateLabel("div");
    }

	private void nativeCreateLabel(String rootTagName) {
		hTMLElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement(rootTagName);
		hTMLElement.getStyle().setProperty("box-sizing", "border-box");
		hTMLElement.getStyle().setProperty("overflow", "hidden");
		
		labelWrapper = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
    	label = org.teavm.jso.dom.html.HTMLDocument.current().createElement("label");
    	label.getStyle().setProperty("display", "table-cell");
    	label.getStyle().setProperty("vertical-align", "inherit");
    	label.getStyle().setProperty("word-break", "break-word");
    	label.getStyle().setProperty("user-select", "text");
    	label.getStyle().setProperty("overflow", "hidden");
    	

    	labelWrapper.getStyle().setProperty("vertical-align", "inherit");
    	labelWrapper.appendChild(label);
    	hTMLElement.appendChild(labelWrapper);
	}

	private void setEnabled(Object objValue) {
		if ((boolean) objValue) {
			hTMLElement.removeAttribute("disabled");
		} else {
			hTMLElement.setAttribute("disabled", "true");
		}
	}



	public void nativeMakeFrameForChildWidget(int l, int t, int r, int b) {
		com.ashera.model.RectM widgetBounds = measurableSwitch.getWidgetBounds(r - l, b - t, label);
		ViewImpl.updateBounds(labelWrapper, widgetBounds.x, widgetBounds.y, widgetBounds.width, widgetBounds.height);
		label.getStyle().setProperty("max-width", widgetBounds.width + "px");
		label.getStyle().setProperty("width", widgetBounds.width + "px");
		label.getStyle().setProperty("height", widgetBounds.height + "px");

		updateDrawableBounds(l, t, r, b);updateSwitchBounds();
	}
	private void nativeSetText(Object objValue) {
		label.setInnerHTML((String) objValue);
	}


	public int getLineHeightPadding() {
		return 0;
	}

	public int getBorderWidth() {
		return 0;
	}

	public int getBorderPadding() {
		return 0;
	}
	

	private Object ellipsize;
	private void setEllipsize(Object objValue, String strValue) {
		this.ellipsize = objValue;
		cancelTimer();
		if (strValue.equals("marquee")) {
			startTimer();	
		}
		
		String textOverFlow = "initial";
		String direction = "ltr";
		switch (strValue) {
		case "end":
			textOverFlow = "ellipsis";
			break;
		case "start":
			textOverFlow = "ellipsis";
			direction =  "rtl";
			break;			
		default:
			break;
		}
		
		label.getStyle().setProperty("direction", direction);
		label.getStyle().setProperty("text-overflow", textOverFlow);
		
	}

	private void setScrollHorizontally(Object objValue) {
		//measurableSwitch.setHorizontallyScrolling(objValue != null && (Boolean) objValue);
		setSingleLine(objValue);
		if ((boolean) objValue) {
			label.getStyle().setProperty("overflow-x", "visible");
		} else {
			label.getStyle().setProperty("overflow-x", "hidden");
		}
	}
	
	
	private Object getEllipsize() {
		return ellipsize;
	}

	private Object getMyText() {
		String innerHTML = label.getInnerHTML();
		if (innerHTML == null) {
			innerHTML = "";
		}
		return innerHTML;
	}
    
    private void addMinMaxListener() {
		
	}
	
	private void cancelNativeTimer() {
		org.teavm.jso.browser.Window.clearInterval(timeoutId);
	}

	private int timeoutId; 
	private boolean isDisposed;
	private DellocHandler dellocHandler;	
	private void schedule() {
		timeoutId = org.teavm.jso.browser.Window.setTimeout(new org.teavm.jso.browser.TimerHandler() {
			@Override
			public void onTimer() {
				marqueeTask.run();
			}
		}, 100);
	}

	private void addDeallocHandler() {
  		if (dellocHandler == null) {
			String type = StandardEvents.dealloc.toString();
			dellocHandler = new DellocHandler(type);
			fragment.getEventBus().on(type, dellocHandler);
  		}
  	
	}
	
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

	private boolean canMarquee() {
		return "nowrap".equals(label.getStyle().getPropertyValue("white-space"));
	}
	
	
	public void executeOnMainThread(Runnable runnable) {
		runnable.run();
	}

  	private boolean isDisposed() {
		return isDisposed;
	}

    private void nativeRequestLayout() {
	}
	
	private void setSingleLine(Object objValue) {
		if ((boolean) objValue) {
			label.getStyle().setProperty("white-space", "nowrap");
		} else {
			label.getStyle().setProperty("white-space", "normal");
		}
	}
	
	private void setTextIsSelectable(Object objValue, String strValue) {
		if ((boolean) objValue) {
			label.getStyle().setProperty("user-select", "text");
		} else {
			label.getStyle().setProperty("user-select", "none");	
		}
	}
	
	
	private Object getTextIsSelectable() {
		return !"none".equals(label.getStyle().getPropertyValue("user-select"));
	}
	
	private void setJustificationMode(Object objValue, String strValue) {
		if ((int) objValue == 1) {
			label.getStyle().setProperty("text-align", "justify");	
		} else {
			label.getStyle().setProperty("text-align", "initial");
		}
		
	}

	private Object getJustificationMode() {
		return "justify".equals(label.getStyle().getPropertyValue("text-align")) ? 0x1 : 0x0;
	}
	

	private void drawableStateChangedAdditional() {
		drawableStateChangedForTextLinkColor();
	}
	
	private void handleHtmlText(String text) {
		HtmlToHtmlConverterHandler contentHandler = new HtmlToHtmlConverterHandler(htmlConfig, fragment);
		com.ashera.parser.html.Html.parseHtml(text, contentHandler);
		label.clear();
		for (HTMLElement htmlElement : contentHandler.getRoots()) {
			label.appendChild(htmlElement);
		}
	}
	


	@org.teavm.jso.JSBody(params = { "input", "val" }, script = "input.checked = val;")
    private static native void setButtonChecked(org.teavm.jso.dom.html.HTMLElement input, boolean val);
	@org.teavm.jso.JSBody(params = { "input" }, script = "return input.checked;")
    private static native boolean isButtonChecked(org.teavm.jso.dom.html.HTMLElement input);
	
	private void setChecked(Object objValue) {
		setButtonChecked(button, (boolean) objValue);
		measurableSwitch.setChecked((boolean)objValue);
	}
	
	private void setOnChecked(Object objValue) {
		ViewImpl.setOnListener(this, button, (e) -> {
			if (measurableSwitch.isEnabled()) {
				measurableSwitch.toggle();
			}
		}, "change", "change");
		CompoundButton.OnCheckedChangeListener onCheckedChangeListener; 
		
		if (objValue instanceof String) {
			onCheckedChangeListener = new OnCheckedChangeListener(this, (String) objValue);
		} else {
			onCheckedChangeListener = (CompoundButton.OnCheckedChangeListener) objValue;
		}
		measurableSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
	}
	
	private Object getChecked() {
		return isButtonChecked(button);
	}
	


	@org.teavm.jso.JSBody(params = { "input" }, script = "input.dispatchEvent(new Event('change'));")
    private static native boolean triggerChangeEvent(org.teavm.jso.dom.html.HTMLElement input);

	private void addClickListenerToSyncCheckbox() {
		HTMLElement[] elements = {label, drawableBottom, drawableLeft, drawableRight, drawableTop};
		int i = 0;
		for (HTMLElement htmlElement : elements) {
			if (htmlElement != null) {
				ViewImpl.setOnListener(this, htmlElement, (event) -> {
					if (measurableSwitch.isEnabled()) {
						boolean isChecked = (boolean)getChecked();
						if (!isChecked || (isChecked && allowUnCheck())) {
							setButtonChecked(button, !isChecked);
							triggerChangeEvent(button);
						}
					}
				}, "click" + i, "click");
			}
			i++;
		}
		
	}
	

	@Override
	public void initialized() {
		super.initialized();
		
		addClickListenerToSyncCheckbox();
	}
	


	private void postSetAttributeCheckBox(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
		switch (key.getAttributeName()) {
		case "editable":
			measurableSwitch.setEnabled((boolean) objValue);
		case "enabled":
			if ((boolean) objValue) {
				button.removeAttribute("disabled");
			} else {
				button.setAttribute("disabled", "disabled");
			}
			break;
		case "drawableTop":
		case "drawableBottom":
		case "drawableLeft":
		case "drawableRight":
		case "drawableStart":
		case "drawableEnd":
			if (isInitialised()) {
				addClickListenerToSyncCheckbox();
			}
			break;
			
		default:
			break;
		}
	}
	


    private int autoSizeMin = -1;
    private int autoSizeMax = -1;
    private int autoSizeGranular = -1;
    
	
	private void setAutoSizeStepGranularity(Object objValue) {
		autoSizeGranular = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(measurableSwitch));
		}
	}

	private void setAutoMinTextSize(Object objValue) {
		autoSizeMin = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(measurableSwitch));
		}
	}

	private void setAutoMaxTextSize(Object objValue) {
		autoSizeMax = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(measurableSwitch));
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
		return getAutoSizeTextType(measurableSwitch);
	}
	


	public void setErrorMessage(String message) {
		getBuilder().setText(message).setVisibility(message == null || message.isEmpty() ? "gone" : "visible").execute(true);
		
	}
	


	private void setTextFormat(Object objValue) {
		applyAttributeCommand("text", CommonConverters.command_textformatter, new String[] {"textFormat"}, true, (String) objValue);
	}
	


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
	

 
	private void setTextColorLink(Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			measurableSwitch.setLinkTextColor(colorStateList);
			objValue = measurableSwitch.getPaint().linkColor;
		}
		if (html) {
			htmlConfig.put("textColorLink", ViewImpl.getColor(objValue));
		}
		
		if (isInitialised()) {
			rerunCommandOnSource("text", "statechange");
		}
	}
	
	private void drawableStateChangedForTextLinkColor() {
		if (measurableSwitch.getLinkTextColors() != null && measurableSwitch.getLinkTextColors().isStateful()) {
			setTextColorLink(measurableSwitch.getLinkTextColors());
		}
	}	

	


    private void setGravity(Object objValue) {
        int value = (int) objValue;
        measurableSwitch.setGravity(value);
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
		r.android.text.Layout.Alignment minor = measurableSwitch.getAlignmentOfLayout();
		boolean isRtl = false;
		boolean hasTextDirection = measurableSwitch.getRawTextDirection() != 0;
		if (hasTextDirection ) {
			r.android.text.TextDirectionHeuristic heuristic =  measurableSwitch.getTextDirectionHeuristic();
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
		if (measurableSwitch.getRawTextAlignment() != 0 || measurableSwitch.getRawLayoutDirection() != 0) {
			updateTextAlignment();
		}
	}

	


    private Object getMinHeight() {
        return measurableSwitch.getMinHeight();
    }

    private Object getMinWidth() {
        return measurableSwitch.getMinWidth();
    }
    
    private void setEms(Object objValue) {
        setMinEms(objValue);
        setMaxEms(objValue);
    }
    
    
    public int getMaxEms() {
        return measurableSwitch.getMaxEms();
    }
    public int getMinEms() {
        return measurableSwitch.getMinEms();
    }

    private void setMinEms(Object objValue) {
    	measurableSwitch.setMinEms((int) objValue);
        addMinMaxListener();
    }
    
    public int getMinLines() {
        return measurableSwitch.getMinLines();
    }
    
    public int getMaxLines() {
        return measurableSwitch.getMaxLines();
    }

    private void setMaxEms(Object objValue) {
    	measurableSwitch.setMaxEms((int) objValue);
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
    	measurableSwitch.setMaxLines((int) objValue);
        addMinMaxListener();
    }

    private void setLines(Object objValue) {
        setMinLines(objValue);
        setMaxLines(objValue);
    }

    private void setMinLines(Object objValue) {
    	measurableSwitch.setMinLines((int) objValue);
        addMinMaxListener();
    
    }
    
    private void setMaxHeight(Object objValue) {
    	measurableSwitch.setMaxHeight((int) objValue);
        addMinMaxListener();
    }

    private void setMaxWidth(Object objValue) {
    	measurableSwitch.setMaxWidth((int) objValue);
        addMinMaxListener();
    }

    public int getMaxWidth() {
        return measurableSwitch.getMaxWidth();
    }

    public int getMaxHeight() {
        return measurableSwitch.getMaxHeight();
    }
    
    
    private void setMinHeight(Object objValue) {
    	measurableSwitch.setMinHeight((int) objValue);
        addMinMaxListener();
    }

    private void setMinWidth(Object objValue) {
    	measurableSwitch.setMinWidth((int) objValue);
        addMinMaxListener();
    }

    
    private Object getWidth() {
        return measurableSwitch.getWidth();
    }

    private int getHeight() {
        return measurableSwitch.getHeight();
    }

    
    


	private int getAutoSizeTextType(MeasurableSwitch measurableSwitch) {
		return measurableSwitch.getAutoSizeTextType();
	}

	private void setAutoSizeTextTypeInternal(int autoTextType) {
		removeResizeListener();
        
		if (measurableSwitch.isAutoSizeTextTypeUniform(autoTextType)) {
			measurableSwitch.setUpAutoSizeTextTypeUniform(autoSizeMin, autoSizeMax, autoSizeGranular);
            addAutoResizeListener();
        } else {
        	measurableSwitch.clearAutoSizeTypeConfiguration();
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
		measurableSwitch.setAutoSizeTextTypeUniformWithPresetSizes((int[]) objValue, 0);
		
	}

	@com.google.j2objc.annotations.WeakOuter
	class PostMeasureHandler extends com.ashera.widget.bus.EventBusHandler {
		private boolean onlyOnce;
		public PostMeasureHandler(String type) {
			super(type);
		}

		@Override
		protected void doPerform(Object payload) {
			if (!onlyOnce || measurableSwitch.isLayoutRequested()) {
				measurableSwitch.autoResizeText();
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
		return measurableSwitch.nativeMeasureHeight(hTMLElement, (int) width);
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
	


	private void setMaxLength(Object objValue) {
		if (!html) {
			applyAttributeCommand("text", CommonConverters.command_maxlength, new String[] {"maxLength"}, true, objValue);
		} else {
			htmlConfig.put("maxLength", objValue);
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
		if (measurableSwitch.isIgnoreDrawableHeight()) {
			return measurableSwitch.getMeasuredWidth() - measurableSwitch.getPaddingLeft() - measurableSwitch.getPaddingRight(); 
		}
		return measurableSwitch.getMeasuredWidth() - measurableSwitch.getCompoundPaddingRight() - measurableSwitch.getCompoundPaddingLeft();
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
           measurableSwitch.setPadding((int) getPaddingLeft(), paddingTop, (int) getPaddingRight(), (int) getPaddingBottom());
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
            measurableSwitch.setPadding((int) getPaddingLeft(), (int) getPaddingTop(), (int) getPaddingRight(), paddingBottom);
        }		
	}
	
	private Object getLastBaselineToBottomHeight() {
		com.ashera.model.FontMetricsDescriptor fontMetrics = PluginInvoker.getFontMetrics(getFont());
		return (int) getPaddingBottom() + fontMetrics.bottom;
	}
	

	@SuppressLint("NewApi")
private static class OnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnCheckedChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnCheckedChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onCheckedChanged (CompoundButton buttonView, 
                boolean isChecked){
    
	if (action == null || action.equals("onCheckedChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onCheckedChange");
	    java.util.Map<String, Object> obj = getOnCheckedChangeEventObj(buttonView,isChecked);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, buttonView,isChecked);
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

public java.util.Map<String, Object> getOnCheckedChangeEventObj(CompoundButton buttonView,boolean isChecked) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "checkedchange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "isChecked", isChecked);
    
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
			measurableSwitch.setId(IdGenerator.getId(id));
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
    
	
private SwitchCommandBuilder builder;
private SwitchBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public SwitchBean getBean() {
	if (bean == null) {
		bean = new SwitchBean();
	}
	return bean;
}
public SwitchCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new SwitchCommandBuilder();
	}
	return builder;
}


public  class SwitchCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <SwitchCommandBuilder> {
    public SwitchCommandBuilder() {
	}
	
	public SwitchCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public SwitchCommandBuilder setOnCheckedChange(String value) {
	Map<String, Object> attrs = initCommand("onCheckedChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetText() {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getText() {
	Map<String, Object> attrs = initCommand("text");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setText(String value) {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMinLines(int value) {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setLines(int value) {
	Map<String, Object> attrs = initCommand("lines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMaxLines(int value) {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMinWidth(String value) {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMinHeight(String value) {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetHeight() {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHeight() {
	Map<String, Object> attrs = initCommand("height");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setHeight(String value) {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetWidth() {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getWidth() {
	Map<String, Object> attrs = initCommand("width");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setWidth(String value) {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMaxEms(int value) {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMinEms(int value) {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setEms(int value) {
	Map<String, Object> attrs = initCommand("ems");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setTypeface(String value) {
	Map<String, Object> attrs = initCommand("typeface");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setTextStyle(String value) {
	Map<String, Object> attrs = initCommand("textStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setFontFamily(String value) {
	Map<String, Object> attrs = initCommand("fontFamily");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableRight(String value) {
	Map<String, Object> attrs = initCommand("drawableRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableStart(String value) {
	Map<String, Object> attrs = initCommand("drawableStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableEnd(String value) {
	Map<String, Object> attrs = initCommand("drawableEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableTop(String value) {
	Map<String, Object> attrs = initCommand("drawableTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableBottom(String value) {
	Map<String, Object> attrs = initCommand("drawableBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setDrawablePadding(String value) {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setMaxLength(int value) {
	Map<String, Object> attrs = initCommand("maxLength");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setEditable(boolean value) {
	Map<String, Object> attrs = initCommand("editable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setSingleLine(boolean value) {
	Map<String, Object> attrs = initCommand("singleLine");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setTextAllCaps(boolean value) {
	Map<String, Object> attrs = initCommand("textAllCaps");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setScrollHorizontally(boolean value) {
	Map<String, Object> attrs = initCommand("scrollHorizontally");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetEllipsize() {
	Map<String, Object> attrs = initCommand("ellipsize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getEllipsize() {
	Map<String, Object> attrs = initCommand("ellipsize");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setEllipsize(String value) {
	Map<String, Object> attrs = initCommand("ellipsize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setStartOrStopMarquee(boolean value) {
	Map<String, Object> attrs = initCommand("startOrStopMarquee");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetMarqueeRepeatLimit() {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMarqueeRepeatLimit() {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setMarqueeRepeatLimit(String value) {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setFirstBaselineToTopHeight(String value) {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setLastBaselineToBottomHeight(String value) {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableTint(String value) {
	Map<String, Object> attrs = initCommand("drawableTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableTintMode(String value) {
	Map<String, Object> attrs = initCommand("drawableTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setJustificationMode(String value) {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetLetterSpacing() {
	Map<String, Object> attrs = initCommand("letterSpacing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLetterSpacing() {
	Map<String, Object> attrs = initCommand("letterSpacing");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setLetterSpacing(float value) {
	Map<String, Object> attrs = initCommand("letterSpacing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetShadowDx() {
	Map<String, Object> attrs = initCommand("shadowDx");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowDx() {
	Map<String, Object> attrs = initCommand("shadowDx");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setShadowDx(float value) {
	Map<String, Object> attrs = initCommand("shadowDx");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetShadowDy() {
	Map<String, Object> attrs = initCommand("shadowDy");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowDy() {
	Map<String, Object> attrs = initCommand("shadowDy");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setShadowDy(float value) {
	Map<String, Object> attrs = initCommand("shadowDy");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetShadowColor() {
	Map<String, Object> attrs = initCommand("shadowColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowColor() {
	Map<String, Object> attrs = initCommand("shadowColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setShadowColor(String value) {
	Map<String, Object> attrs = initCommand("shadowColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetShadowRadius() {
	Map<String, Object> attrs = initCommand("shadowRadius");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowRadius() {
	Map<String, Object> attrs = initCommand("shadowRadius");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setShadowRadius(float value) {
	Map<String, Object> attrs = initCommand("shadowRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetTextIsSelectable() {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isTextIsSelectable() {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTextIsSelectable(boolean value) {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetLineHeight() {
	Map<String, Object> attrs = initCommand("lineHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineHeight() {
	Map<String, Object> attrs = initCommand("lineHeight");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setLineHeight(String value) {
	Map<String, Object> attrs = initCommand("lineHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetLineSpacingExtra() {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineSpacingExtra() {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setLineSpacingExtra(String value) {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetLineSpacingMultiplier() {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineSpacingMultiplier() {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setLineSpacingMultiplier(float value) {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetTextColorHighlight() {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColorHighlight() {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTextColorHighlight(String value) {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetAutoLink() {
	Map<String, Object> attrs = initCommand("autoLink");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAutoLink() {
	Map<String, Object> attrs = initCommand("autoLink");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setAutoLink(String value) {
	Map<String, Object> attrs = initCommand("autoLink");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setTextColorLink(String value) {
	Map<String, Object> attrs = initCommand("textColorLink");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setTextFormat(String value) {
	Map<String, Object> attrs = initCommand("textFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetChecked() {
	Map<String, Object> attrs = initCommand("checked");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isChecked() {
	Map<String, Object> attrs = initCommand("checked");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setChecked(boolean value) {
	Map<String, Object> attrs = initCommand("checked");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwitchPadding() {
	Map<String, Object> attrs = initCommand("switchPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwitchPadding() {
	Map<String, Object> attrs = initCommand("switchPadding");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwitchPadding(String value) {
	Map<String, Object> attrs = initCommand("switchPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwitchMinWidth() {
	Map<String, Object> attrs = initCommand("switchMinWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwitchMinWidth() {
	Map<String, Object> attrs = initCommand("switchMinWidth");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwitchMinWidth(String value) {
	Map<String, Object> attrs = initCommand("switchMinWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class SwitchBean extends com.ashera.layout.ViewImpl.ViewBean{
		public SwitchBean() {
			super(SwitchImpl.this);
		}
public void setOnCheckedChange(String value) {
	getBuilder().reset().setOnCheckedChange(value).execute(true);
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

public void setMaxLength(int value) {
	getBuilder().reset().setMaxLength(value).execute(true);
}

public void setEnabled(boolean value) {
	getBuilder().reset().setEnabled(value).execute(true);
}

public void setEditable(boolean value) {
	getBuilder().reset().setEditable(value).execute(true);
}

public void setSingleLine(boolean value) {
	getBuilder().reset().setSingleLine(value).execute(true);
}

public void setTextAllCaps(boolean value) {
	getBuilder().reset().setTextAllCaps(value).execute(true);
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

public Object getJustificationMode() {
	return getBuilder().reset().tryGetJustificationMode().execute(false).getJustificationMode(); 
}
public void setJustificationMode(String value) {
	getBuilder().reset().setJustificationMode(value).execute(true);
}

public Object getLetterSpacing() {
	return getBuilder().reset().tryGetLetterSpacing().execute(false).getLetterSpacing(); 
}
public void setLetterSpacing(float value) {
	getBuilder().reset().setLetterSpacing(value).execute(true);
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

public Object getShadowColor() {
	return getBuilder().reset().tryGetShadowColor().execute(false).getShadowColor(); 
}
public void setShadowColor(String value) {
	getBuilder().reset().setShadowColor(value).execute(true);
}

public Object getShadowRadius() {
	return getBuilder().reset().tryGetShadowRadius().execute(false).getShadowRadius(); 
}
public void setShadowRadius(float value) {
	getBuilder().reset().setShadowRadius(value).execute(true);
}

public Object isTextIsSelectable() {
	return getBuilder().reset().tryGetTextIsSelectable().execute(false).isTextIsSelectable(); 
}
public void setTextIsSelectable(boolean value) {
	getBuilder().reset().setTextIsSelectable(value).execute(true);
}

public Object getLineHeight() {
	return getBuilder().reset().tryGetLineHeight().execute(false).getLineHeight(); 
}
public void setLineHeight(String value) {
	getBuilder().reset().setLineHeight(value).execute(true);
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

public Object getTextColorHighlight() {
	return getBuilder().reset().tryGetTextColorHighlight().execute(false).getTextColorHighlight(); 
}
public void setTextColorHighlight(String value) {
	getBuilder().reset().setTextColorHighlight(value).execute(true);
}

public Object getAutoLink() {
	return getBuilder().reset().tryGetAutoLink().execute(false).getAutoLink(); 
}
public void setAutoLink(String value) {
	getBuilder().reset().setAutoLink(value).execute(true);
}

public void setTextColorLink(String value) {
	getBuilder().reset().setTextColorLink(value).execute(true);
}

public void setTextFormat(String value) {
	getBuilder().reset().setTextFormat(value).execute(true);
}

public Object isChecked() {
	return getBuilder().reset().tryGetChecked().execute(false).isChecked(); 
}
public void setChecked(boolean value) {
	getBuilder().reset().setChecked(value).execute(true);
}

public Object getSwitchPadding() {
	return getBuilder().reset().tryGetSwitchPadding().execute(false).getSwitchPadding(); 
}
public void setSwitchPadding(String value) {
	getBuilder().reset().setSwitchPadding(value).execute(true);
}

public Object getSwitchMinWidth() {
	return getBuilder().reset().tryGetSwitchMinWidth().execute(false).getSwitchMinWidth(); 
}
public void setSwitchMinWidth(String value) {
	getBuilder().reset().setSwitchMinWidth(value).execute(true);
}

}


    
	//end - body
	private HTMLElement switchButton;
	private HTMLElement button;
	private int switchWidth = 35;
	private int switchHeight = 25;
	private void nativeCreate(Map<String, Object> params) {
		nativeCreateLabel(params);
		
		switchButton = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");

		HTMLElement onoffswitch = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
		onoffswitch.setAttribute("class", "onoffswitch");

		hTMLElement.appendChild(switchButton);
		
		switchButton.appendChild(onoffswitch);
		
		HTMLElement label = org.teavm.jso.dom.html.HTMLDocument.current().createElement("label");
		String uniqueId = java.util.UUID.randomUUID().toString();
		label.setAttribute("for", uniqueId);
		label.setAttribute("class", "onoffswitch-label");
		
		button = org.teavm.jso.dom.html.HTMLDocument.current().createElement("input");
		button.setAttribute("type", "checkbox");
		button.setAttribute("name", "onoffswitch");
		button.setAttribute("class", "onoffswitch-checkbox");
		button.setAttribute("id", uniqueId);
		
		onoffswitch.appendChild(button);
		onoffswitch.appendChild(label);
		
		 /*https://proto.io/freebies/onoff/
		 <div class="onoffswitch">
	    	<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" tabindex="0" checked>
	    	<label class="onoffswitch-label" for="myonoffswitch"></label>
	    	</div>
	    */
	
		updateIntrinsicBounds();
		setGravity(r.android.view.Gravity.CENTER_VERTICAL);
	}

	private void updateIntrinsicBounds() {
		measurableSwitch.setIntrinsicWidth(switchWidth);
		measurableSwitch.setIntrinsicHeight(switchHeight);
	}

	private void updateSwitchBounds() {
		r.android.graphics.Rect switchBounds = measurableSwitch.getSwitchBounds();
		ViewImpl.updateBounds(switchButton, switchBounds.left, switchBounds.top, switchBounds.right - switchBounds.left, switchBounds.bottom - switchBounds.top);
	}

	@Override
	public int measureWidth() {
		return windowNativeMeasureWidth(label) + switchWidth;
	}
	
	


    private boolean allowUnCheck() {
		return true;
	}

	
	private void postSetAttribute(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
		postSetAttributeCheckBox(key, strValue, objValue, decorator);
		switch (key.getAttributeName()) {
		case "text":
			measurableSwitch.setText((String) objValue);
			break;

		default:
			break;
		}
	}
}
