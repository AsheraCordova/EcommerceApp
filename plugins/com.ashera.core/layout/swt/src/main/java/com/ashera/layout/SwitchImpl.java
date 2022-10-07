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
import r.android.widget.CompoundButton;
@SuppressLint("NewApi")
public class SwitchImpl extends BaseWidget implements IDrawable, IHasMultiNativeWidgets, ICustomMeasureHeight, ICustomMeasureWidth{
	//start - body
	public final static String LOCAL_NAME = "Switch"; 
	public final static String GROUP_NAME = "Switch";

	protected org.eclipse.nebula.widgets.opal.switchbutton.SwitchButton switchButton;
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
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtText").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtSelection").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtTextForSelect").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtTextForUnselect").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtRound").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtBorderColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtFocusColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtSelectedForegroundColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtSelectedBackgroundColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtUnselectedForegroundColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtUnselectedBackgroundColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtButtonBorderColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtButtonBackgroundColor1").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtButtonBackgroundColor2").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtGap").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtArc").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onCheckedChange").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("checked").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textOn").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textOff").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("switchPadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("switchMinWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("trackTint").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("thumbTint").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtInsideMarginX").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtInsideMarginY").withType("dimension"));
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
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("singleLine").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAllCaps").withType("boolean").withOrder(-1).withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollHorizontally").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("Switch.ellipsize", new Ellipsize());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ellipsize").withType("Switch.ellipsize"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("startOrStopMarquee").withType("boolean"));
		ConverterFactory.register("Switch.marqueeRepeatLimit", new MarqueeRepeatLimit());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("marqueeRepeatLimit").withType("Switch.marqueeRepeatLimit"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("firstBaselineToTopHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lastBaselineToBottomHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textFormat").withType("resourcestring").withOrder(-1));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("swtTextStyle").withType("string"));
		loadCustomAttributes(attributeName);
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
            ((org.eclipse.swt.widgets.Control)asNativeWidget()).setVisible(View.VISIBLE == visibility);
            
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
	}	
	public void updateMeasuredDimension(int width, int height) {
		((SwitchExt) measurableSwitch).updateMeasuredDimension(width, height);
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
			case "swtText": {
				


		 switchButton.setText((String)objValue);



			}
			break;
			case "swtSelection": {
				


		 switchButton.setSelection((boolean)objValue);



			}
			break;
			case "swtTextForSelect": {
				


		 switchButton.setTextForSelect((String)objValue);



			}
			break;
			case "swtTextForUnselect": {
				


		 switchButton.setTextForUnselect((String)objValue);



			}
			break;
			case "swtRound": {
				


		 switchButton.setRound((boolean)objValue);



			}
			break;
			case "swtBorderColor": {
				


		 switchButton.setBorderColor((Color)objValue);



			}
			break;
			case "swtFocusColor": {
				


		 switchButton.setFocusColor((Color)objValue);



			}
			break;
			case "swtSelectedForegroundColor": {
				


		 switchButton.setSelectedForegroundColor((Color)objValue);



			}
			break;
			case "swtSelectedBackgroundColor": {
				


		 switchButton.setSelectedBackgroundColor((Color)objValue);



			}
			break;
			case "swtUnselectedForegroundColor": {
				


		 switchButton.setUnselectedForegroundColor((Color)objValue);



			}
			break;
			case "swtUnselectedBackgroundColor": {
				


		 switchButton.setUnselectedBackgroundColor((Color)objValue);



			}
			break;
			case "swtButtonBorderColor": {
				


		 switchButton.setButtonBorderColor((Color)objValue);



			}
			break;
			case "swtButtonBackgroundColor1": {
				


		 switchButton.setButtonBackgroundColor1((Color)objValue);



			}
			break;
			case "swtButtonBackgroundColor2": {
				


		 switchButton.setButtonBackgroundColor2((Color)objValue);



			}
			break;
			case "swtGap": {
				


		 switchButton.setGap((int)objValue);



			}
			break;
			case "swtArc": {
				


		 switchButton.setArc((int)objValue);



			}
			break;
			case "onCheckedChange": {
				


		setOnChecked(objValue);



			}
			break;
			case "checked": {
				


		setChecked(objValue);



			}
			break;
			case "textOn": {
				


		setTextOn(objValue);



			}
			break;
			case "textOff": {
				


		setTextOff(objValue);



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
			case "trackTint": {
				


		setTrackTint(objValue);



			}
			break;
			case "thumbTint": {
				


		setThumbTint(objValue);



			}
			break;
			case "swtInsideMarginX": {
				


		setInsideMarginX(objValue);



			}
			break;
			case "swtInsideMarginY": {
				


		setInsideMarginY(objValue);



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
				


		 //



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
			case "textFormat": {
				


		setTextFormat(objValue);



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
			case "swtText": {
return switchButton.getText();				}
			case "swtSelection": {
return switchButton.getSelection();				}
			case "swtTextForSelect": {
return switchButton.getTextForSelect();				}
			case "swtTextForUnselect": {
return switchButton.getTextForUnselect();				}
			case "swtRound": {
return switchButton.isRound();				}
			case "swtBorderColor": {
return switchButton.getBorderColor();				}
			case "swtFocusColor": {
return switchButton.getFocusColor();				}
			case "swtSelectedForegroundColor": {
return switchButton.getSelectedForegroundColor();				}
			case "swtSelectedBackgroundColor": {
return switchButton.getSelectedBackgroundColor();				}
			case "swtUnselectedForegroundColor": {
return switchButton.getUnselectedForegroundColor();				}
			case "swtUnselectedBackgroundColor": {
return switchButton.getUnselectedBackgroundColor();				}
			case "swtButtonBorderColor": {
return switchButton.getButtonBorderColor();				}
			case "swtButtonBackgroundColor1": {
return switchButton.getButtonBackgroundColor1();				}
			case "swtButtonBackgroundColor2": {
return switchButton.getButtonBackgroundColor2();				}
			case "swtGap": {
return switchButton.getGap();				}
			case "swtArc": {
return switchButton.getArc();				}
			case "checked": {
return getChecked();				}
			case "textOn": {
return getTextOn();				}
			case "textOff": {
return getTextOff();				}
			case "switchPadding": {
return measurableSwitch.getSwitchPadding();				}
			case "switchMinWidth": {
return measurableSwitch.getMinWidth();				}
			case "trackTint": {
return getTrackTint();				}
			case "thumbTint": {
return getThumbTint();				}
			case "swtInsideMarginX": {
return getInsideMarginX();				}
			case "swtInsideMarginY": {
return getInsideMarginY();				}
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
		return measurableSwitch;
	}

	

	private void setChecked(Object objValue) {
		switchButton.setSelection((boolean)objValue);
		measurableSwitch.setChecked((boolean)objValue);
	}

	
	private Object getChecked() {
		return switchButton.getSelection();
	}
	
	private final class CheckedListener implements org.eclipse.swt.events.SelectionListener {
		@Override
		public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
			if (measurableSwitch.isEnabled()) {
				measurableSwitch.toggle();
			}
		}

		@Override
		public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {

		}
	}	
	private CheckedListener checkedListener;
	private void setOnChecked(Object objValue) {
		if (checkedListener == null) {
			checkedListener = new CheckedListener();
			switchButton.addSelectionListener(checkedListener);
		}
		
		CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
		if (objValue instanceof String) {
			onCheckedChangeListener = new OnCheckedChangeListener(this, (String) objValue);
		} else {
			onCheckedChangeListener = (CompoundButton.OnCheckedChangeListener) objValue;
		}
		measurableSwitch.setOnCheckedChangeListener(onCheckedChangeListener);

	}

	


	private void setTextFormat(Object objValue) {
		applyAttributeCommand("text", CommonConverters.command_textformatter, new String[] {"textFormat"}, true, (String) objValue);
	}
	


	private Composite wrapperComposite;

	private void setScrollHorizontally(Object objValue) {
		measurableSwitch.setHorizontallyScrolling(objValue != null && (Boolean) objValue);
		
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
		return label.getText();
	}
	

	private void nativeSetText(String value) {
		label.setText(value);
	}
	//end - text

    @Override
    public Object asNativeWidget() {
        return wrapperComposite;
    }

    
	private void nativeCreateLabel(Map<String, Object> params) {
		if (isHtmlSupported()) {
			initHtml(params);
		}
		Composite parent = (Composite) ViewImpl.getParent(this);
		nativeCreateLabel(parent, params);
	}

	private void nativeCreateLabel(Composite parent, Map<String, Object> params) {
		wrapperComposite = new DrawableComposite(parent, this, getStyle(params, fragment));
		wrapperComposite.setLayout(new org.eclipse.nebula.widgets.layout.AbsoluteLayout());
		
		int textStyle = getStyle("swtTextStyle", org.eclipse.swt.SWT.WRAP, params, fragment) & ~org.eclipse.swt.SWT.MULTI;
		label = new Label(wrapperComposite, textStyle);
		
		computeLineHeight();
		label.addDisposeListener((e) -> {
        	disposeAll(newFont, label.getImage());
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
		com.ashera.view.BaseMeasurableView.VerticalAligment verticalAligment = measurableSwitch.getVerticalAligment();
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

	//end - gravity
	//start - aligment
    //start - valign
	private void setVerticalAligmentCenter() {
		measurableSwitch.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.middle);
	}

	private void setVerticalAligmentBottom() {
		measurableSwitch.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.bottom);
	}

	private void setVerticalAligmentTop() {
		measurableSwitch.setVerticalAligment(com.ashera.view.BaseMeasurableView.VerticalAligment.top);
	}
	//end - valign

    private int getTextAlignment() {
		return label.getAlignment();
	}
	private void setHorizontalAligmentCenter() {
		label.setAlignment(TEXT_ALIGN_CENTER);
	}

	private void setHorizontalAligmentRight() {
		label.setAlignment(org.eclipse.swt.SWT.RIGHT);
	}

	private void setHorizontalAligmentLeft() {
		label.setAlignment(org.eclipse.swt.SWT.LEFT);
	}
	//end - aligment
	
	public void nativeRequestLayout() {
		wrapperComposite.requestLayout();
	}
	
	//start - paddingcopy
	private Object getPaddingBottom() {
		return measurableSwitch.getPaddingBottom();
	}
	
	private Object getPaddingTop() {
		return measurableSwitch.getPaddingTop();
	}

	private Object getPaddingRight() {
		return measurableSwitch.getPaddingRight();
	}
	
	private Object getPaddingLeft() {
		return measurableSwitch.getPaddingLeft();
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
		ViewImpl.setPaddingTop(objValue, measurableSwitch);
	}

	private void setPaddingEnd(Object objValue) {
		ViewImpl.setPaddingRight(objValue, measurableSwitch);
	}

	private void setPaddingStart(Object objValue) {
		ViewImpl.setPaddingLeft(objValue, measurableSwitch);
	}

	private void setPaddingLeft(Object objValue) {
		ViewImpl.setPaddingLeft(objValue, measurableSwitch);
	}

	private void setPaddingRight(Object objValue) {
		ViewImpl.setPaddingRight(objValue, measurableSwitch);
	}

	private void setPaddingBottom(Object objValue) {
		ViewImpl.setPaddingBottom(objValue, measurableSwitch);
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
		FontData[] fontData = label.getFont().getFontData();
        int height = fontData[0].getHeight();
		return height;
	}

	private int nativeGetFontStyle() {
		FontData[] fontData = label.getFont().getFontData();
        int style = fontData[0].getStyle();
		return style;
	}

	private void nativeSetCustomFont(int height, com.ashera.model.FontDescriptor fontDescriptor) {
		final org.eclipse.swt.graphics.Font newFont = new org.eclipse.swt.graphics.Font(Display.getDefault(), fontDescriptor.getName(), height, fontDescriptor.getStyle());
		setFont(newFont);
	}

	private void nativeSetFontStyle(int style) {
		FontData[] fontData = label.getFont().getFontData();
		for(int i = 0; i < fontData.length; ++i) {
		    fontData[i].setStyle(style);
		}

		final org.eclipse.swt.graphics.Font newFont = new org.eclipse.swt.graphics.Font(Display.getDefault(), fontData);
		setFont(newFont);
	}

    private void setFont(final org.eclipse.swt.graphics.Font newFont) {
        disposeAll(this.newFont);
        this.newFont = newFont;
        label.setFont(newFont);
    }

    private void setMyTextSize(Object objValue) {
        FontData[] fontData = label.getFont().getFontData();
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
			measurableSwitch.setTextColor(colorStateList);
			objValue = measurableSwitch.getCurrentTextColor();
		}
		
		label.setForeground((Color)ViewImpl.getColor(objValue));
	}
	
	private Object getTextSize() {
		return label.getFont().getFontData()[0].getHeight();
	}

	private Object getTextColor() {
		return measurableSwitch.getTextColors();
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
		drawableStateChange(drawableBottom, measurableSwitch.getBottomDrawable(), "drawableBottom");
		drawableStateChange(drawableLeft, measurableSwitch.getLeftDrawable(), "drawableLeft");
		drawableStateChange(drawableRight, measurableSwitch.getRightDrawable(), "drawableRight");
		drawableStateChange(drawableTop, measurableSwitch.getTopDrawable(), "drawableTop");
		
		if (measurableSwitch.getTextColors() != null) {
			setTextColor(measurableSwitch.getCurrentTextColor());
		}
		drawableStateChangedAdditional();
	}

	private void drawableStateChange(Label mydrawable, r.android.graphics.drawable.Drawable dr, String attribute) {
		if (mydrawable != null) {
			final int[] state = measurableSwitch.getDrawableState();
			
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
			measurableSwitch.setLeftDrawable(drawable);
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
			measurableSwitch.setRightDrawable(drawable);
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
			measurableSwitch.setBottomDrawable(drawable);
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
			measurableSwitch.setTopDrawable(drawable);
			disposeAll(drawableTop.getImage());
			setImageOrColorOnDrawable(drawableTop,  drawable.getDrawable());
		}
	}

	private void setDrawablePadding(Object objValue) {
		measurableSwitch.setDrawablePadding((int) objValue);
	}
	
	private Object getDrawablePadding() {
		return measurableSwitch.getDrawablePadding();
	}
	
	@Override
	public Control getControl() {
		return label;
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

    
    //end - maxminheight
    
    //start - autosize
	private int getAutoSizeTextType(MeasurableTextView measurableSwitch) {
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
		return measurableSwitch.nativeMeasureHeight(label, (int) width);
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
		label.setEnabled((boolean) objValue);
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
		return java.util.Arrays.asList(wrapperComposite, label, drawableBottom, drawableLeft, drawableTop, drawableRight).
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
		return label.computeSize(width, org.eclipse.swt.SWT.DEFAULT).y + wrapperCompositeHeight;
	}

	@Override
	public int measureWidth() {
		int wrapperCompositeWidth = wrapperComposite.computeSize(org.eclipse.swt.SWT.DEFAULT, org.eclipse.swt.SWT.DEFAULT).y;
		return label.computeSize(org.eclipse.swt.SWT.DEFAULT, org.eclipse.swt.SWT.DEFAULT).x + wrapperCompositeWidth + getSwitchButtonWidth();
	}
	//end - dimenmeasure
	
	
    //start - ellipsize
	private void setEllipsize(Object objValue, String strValue) {
		label.setData("ellipsize", (int) objValue);

		cancelTimer();
		if (strValue.equals("marquee")) {
			startTimer();	
			
		}
		if (isInitialised()) {
			label.redraw();
		}
	}

	private Object getEllipsize() {
		return label.getData("ellipsize");
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
		if (measurableSwitch.isIgnoreDrawableHeight()) {
			return measurableSwitch.getMeasuredWidth() - measurableSwitch.getPaddingLeft() - measurableSwitch.getPaddingRight(); 
		}
		return measurableSwitch.getMeasuredWidth() - measurableSwitch.getCompoundPaddingRight() - measurableSwitch.getCompoundPaddingLeft();
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
		return label.isDisposed();
	}

	private boolean canMarquee() {
		return (label.getStyle() & org.eclipse.swt.SWT.WRAP) == 0 && !html;
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
	//end - baseline

	private org.eclipse.swt.graphics.Font getFont() {
		return label.getFont();
	}
	


    private void addMinMaxListener() {
    }

	private void nohup() {
	}
	
	private boolean isHtmlSupported() {
		return false;
	}
	private void handleHtmlText(String text) {
		
	}
    


	private int lineHeight;
	private void computeLineHeight() {
		lineHeight = label.computeSize(20, org.eclipse.swt.SWT.DEFAULT).y;
	}
	public int getLineHeight() {
		return lineHeight;
	}
	
	public int getBorderWidth() {
		return wrapperComposite.getBorderWidth();
	}
	
	public int getBorderPadding() {
		return 0;
	}
	
	public int getLineHeightPadding() {
		return 0;
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

public SwitchCommandBuilder tryGetSwtText() {
	Map<String, Object> attrs = initCommand("swtText");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtText() {
	Map<String, Object> attrs = initCommand("swtText");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtText(String value) {
	Map<String, Object> attrs = initCommand("swtText");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtSelection() {
	Map<String, Object> attrs = initCommand("swtSelection");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isSwtSelection() {
	Map<String, Object> attrs = initCommand("swtSelection");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtSelection(boolean value) {
	Map<String, Object> attrs = initCommand("swtSelection");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtTextForSelect() {
	Map<String, Object> attrs = initCommand("swtTextForSelect");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtTextForSelect() {
	Map<String, Object> attrs = initCommand("swtTextForSelect");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtTextForSelect(String value) {
	Map<String, Object> attrs = initCommand("swtTextForSelect");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtTextForUnselect() {
	Map<String, Object> attrs = initCommand("swtTextForUnselect");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtTextForUnselect() {
	Map<String, Object> attrs = initCommand("swtTextForUnselect");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtTextForUnselect(String value) {
	Map<String, Object> attrs = initCommand("swtTextForUnselect");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtRound() {
	Map<String, Object> attrs = initCommand("swtRound");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isSwtRound() {
	Map<String, Object> attrs = initCommand("swtRound");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtRound(boolean value) {
	Map<String, Object> attrs = initCommand("swtRound");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtBorderColor() {
	Map<String, Object> attrs = initCommand("swtBorderColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtBorderColor() {
	Map<String, Object> attrs = initCommand("swtBorderColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtBorderColor(String value) {
	Map<String, Object> attrs = initCommand("swtBorderColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtFocusColor() {
	Map<String, Object> attrs = initCommand("swtFocusColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtFocusColor() {
	Map<String, Object> attrs = initCommand("swtFocusColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtFocusColor(String value) {
	Map<String, Object> attrs = initCommand("swtFocusColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtSelectedForegroundColor() {
	Map<String, Object> attrs = initCommand("swtSelectedForegroundColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtSelectedForegroundColor() {
	Map<String, Object> attrs = initCommand("swtSelectedForegroundColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtSelectedForegroundColor(String value) {
	Map<String, Object> attrs = initCommand("swtSelectedForegroundColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtSelectedBackgroundColor() {
	Map<String, Object> attrs = initCommand("swtSelectedBackgroundColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtSelectedBackgroundColor() {
	Map<String, Object> attrs = initCommand("swtSelectedBackgroundColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtSelectedBackgroundColor(String value) {
	Map<String, Object> attrs = initCommand("swtSelectedBackgroundColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtUnselectedForegroundColor() {
	Map<String, Object> attrs = initCommand("swtUnselectedForegroundColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtUnselectedForegroundColor() {
	Map<String, Object> attrs = initCommand("swtUnselectedForegroundColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtUnselectedForegroundColor(String value) {
	Map<String, Object> attrs = initCommand("swtUnselectedForegroundColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtUnselectedBackgroundColor() {
	Map<String, Object> attrs = initCommand("swtUnselectedBackgroundColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtUnselectedBackgroundColor() {
	Map<String, Object> attrs = initCommand("swtUnselectedBackgroundColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtUnselectedBackgroundColor(String value) {
	Map<String, Object> attrs = initCommand("swtUnselectedBackgroundColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtButtonBorderColor() {
	Map<String, Object> attrs = initCommand("swtButtonBorderColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtButtonBorderColor() {
	Map<String, Object> attrs = initCommand("swtButtonBorderColor");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtButtonBorderColor(String value) {
	Map<String, Object> attrs = initCommand("swtButtonBorderColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtButtonBackgroundColor1() {
	Map<String, Object> attrs = initCommand("swtButtonBackgroundColor1");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtButtonBackgroundColor1() {
	Map<String, Object> attrs = initCommand("swtButtonBackgroundColor1");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtButtonBackgroundColor1(String value) {
	Map<String, Object> attrs = initCommand("swtButtonBackgroundColor1");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtButtonBackgroundColor2() {
	Map<String, Object> attrs = initCommand("swtButtonBackgroundColor2");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtButtonBackgroundColor2() {
	Map<String, Object> attrs = initCommand("swtButtonBackgroundColor2");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtButtonBackgroundColor2(String value) {
	Map<String, Object> attrs = initCommand("swtButtonBackgroundColor2");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtGap() {
	Map<String, Object> attrs = initCommand("swtGap");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtGap() {
	Map<String, Object> attrs = initCommand("swtGap");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtGap(int value) {
	Map<String, Object> attrs = initCommand("swtGap");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtArc() {
	Map<String, Object> attrs = initCommand("swtArc");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtArc() {
	Map<String, Object> attrs = initCommand("swtArc");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtArc(int value) {
	Map<String, Object> attrs = initCommand("swtArc");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setOnCheckedChange(String value) {
	Map<String, Object> attrs = initCommand("onCheckedChange");
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
public SwitchCommandBuilder tryGetTextOn() {
	Map<String, Object> attrs = initCommand("textOn");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextOn() {
	Map<String, Object> attrs = initCommand("textOn");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTextOn(String value) {
	Map<String, Object> attrs = initCommand("textOn");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetTextOff() {
	Map<String, Object> attrs = initCommand("textOff");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextOff() {
	Map<String, Object> attrs = initCommand("textOff");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTextOff(String value) {
	Map<String, Object> attrs = initCommand("textOff");
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
public SwitchCommandBuilder tryGetTrackTint() {
	Map<String, Object> attrs = initCommand("trackTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTrackTint() {
	Map<String, Object> attrs = initCommand("trackTint");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTrackTint(String value) {
	Map<String, Object> attrs = initCommand("trackTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetThumbTint() {
	Map<String, Object> attrs = initCommand("thumbTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getThumbTint() {
	Map<String, Object> attrs = initCommand("thumbTint");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setThumbTint(String value) {
	Map<String, Object> attrs = initCommand("thumbTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtInsideMarginX() {
	Map<String, Object> attrs = initCommand("swtInsideMarginX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtInsideMarginX() {
	Map<String, Object> attrs = initCommand("swtInsideMarginX");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtInsideMarginX(String value) {
	Map<String, Object> attrs = initCommand("swtInsideMarginX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSwtInsideMarginY() {
	Map<String, Object> attrs = initCommand("swtInsideMarginY");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtInsideMarginY() {
	Map<String, Object> attrs = initCommand("swtInsideMarginY");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSwtInsideMarginY(String value) {
	Map<String, Object> attrs = initCommand("swtInsideMarginY");
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
public SwitchCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
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
public SwitchCommandBuilder setTextFormat(String value) {
	Map<String, Object> attrs = initCommand("textFormat");
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
public Object getSwtText() {
	return getBuilder().reset().tryGetSwtText().execute(false).getSwtText(); 
}
public void setSwtText(String value) {
	getBuilder().reset().setSwtText(value).execute(true);
}

public Object isSwtSelection() {
	return getBuilder().reset().tryGetSwtSelection().execute(false).isSwtSelection(); 
}
public void setSwtSelection(boolean value) {
	getBuilder().reset().setSwtSelection(value).execute(true);
}

public Object getSwtTextForSelect() {
	return getBuilder().reset().tryGetSwtTextForSelect().execute(false).getSwtTextForSelect(); 
}
public void setSwtTextForSelect(String value) {
	getBuilder().reset().setSwtTextForSelect(value).execute(true);
}

public Object getSwtTextForUnselect() {
	return getBuilder().reset().tryGetSwtTextForUnselect().execute(false).getSwtTextForUnselect(); 
}
public void setSwtTextForUnselect(String value) {
	getBuilder().reset().setSwtTextForUnselect(value).execute(true);
}

public Object isSwtRound() {
	return getBuilder().reset().tryGetSwtRound().execute(false).isSwtRound(); 
}
public void setSwtRound(boolean value) {
	getBuilder().reset().setSwtRound(value).execute(true);
}

public Object getSwtBorderColor() {
	return getBuilder().reset().tryGetSwtBorderColor().execute(false).getSwtBorderColor(); 
}
public void setSwtBorderColor(String value) {
	getBuilder().reset().setSwtBorderColor(value).execute(true);
}

public Object getSwtFocusColor() {
	return getBuilder().reset().tryGetSwtFocusColor().execute(false).getSwtFocusColor(); 
}
public void setSwtFocusColor(String value) {
	getBuilder().reset().setSwtFocusColor(value).execute(true);
}

public Object getSwtSelectedForegroundColor() {
	return getBuilder().reset().tryGetSwtSelectedForegroundColor().execute(false).getSwtSelectedForegroundColor(); 
}
public void setSwtSelectedForegroundColor(String value) {
	getBuilder().reset().setSwtSelectedForegroundColor(value).execute(true);
}

public Object getSwtSelectedBackgroundColor() {
	return getBuilder().reset().tryGetSwtSelectedBackgroundColor().execute(false).getSwtSelectedBackgroundColor(); 
}
public void setSwtSelectedBackgroundColor(String value) {
	getBuilder().reset().setSwtSelectedBackgroundColor(value).execute(true);
}

public Object getSwtUnselectedForegroundColor() {
	return getBuilder().reset().tryGetSwtUnselectedForegroundColor().execute(false).getSwtUnselectedForegroundColor(); 
}
public void setSwtUnselectedForegroundColor(String value) {
	getBuilder().reset().setSwtUnselectedForegroundColor(value).execute(true);
}

public Object getSwtUnselectedBackgroundColor() {
	return getBuilder().reset().tryGetSwtUnselectedBackgroundColor().execute(false).getSwtUnselectedBackgroundColor(); 
}
public void setSwtUnselectedBackgroundColor(String value) {
	getBuilder().reset().setSwtUnselectedBackgroundColor(value).execute(true);
}

public Object getSwtButtonBorderColor() {
	return getBuilder().reset().tryGetSwtButtonBorderColor().execute(false).getSwtButtonBorderColor(); 
}
public void setSwtButtonBorderColor(String value) {
	getBuilder().reset().setSwtButtonBorderColor(value).execute(true);
}

public Object getSwtButtonBackgroundColor1() {
	return getBuilder().reset().tryGetSwtButtonBackgroundColor1().execute(false).getSwtButtonBackgroundColor1(); 
}
public void setSwtButtonBackgroundColor1(String value) {
	getBuilder().reset().setSwtButtonBackgroundColor1(value).execute(true);
}

public Object getSwtButtonBackgroundColor2() {
	return getBuilder().reset().tryGetSwtButtonBackgroundColor2().execute(false).getSwtButtonBackgroundColor2(); 
}
public void setSwtButtonBackgroundColor2(String value) {
	getBuilder().reset().setSwtButtonBackgroundColor2(value).execute(true);
}

public Object getSwtGap() {
	return getBuilder().reset().tryGetSwtGap().execute(false).getSwtGap(); 
}
public void setSwtGap(int value) {
	getBuilder().reset().setSwtGap(value).execute(true);
}

public Object getSwtArc() {
	return getBuilder().reset().tryGetSwtArc().execute(false).getSwtArc(); 
}
public void setSwtArc(int value) {
	getBuilder().reset().setSwtArc(value).execute(true);
}

public void setOnCheckedChange(String value) {
	getBuilder().reset().setOnCheckedChange(value).execute(true);
}

public Object isChecked() {
	return getBuilder().reset().tryGetChecked().execute(false).isChecked(); 
}
public void setChecked(boolean value) {
	getBuilder().reset().setChecked(value).execute(true);
}

public Object getTextOn() {
	return getBuilder().reset().tryGetTextOn().execute(false).getTextOn(); 
}
public void setTextOn(String value) {
	getBuilder().reset().setTextOn(value).execute(true);
}

public Object getTextOff() {
	return getBuilder().reset().tryGetTextOff().execute(false).getTextOff(); 
}
public void setTextOff(String value) {
	getBuilder().reset().setTextOff(value).execute(true);
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

public Object getTrackTint() {
	return getBuilder().reset().tryGetTrackTint().execute(false).getTrackTint(); 
}
public void setTrackTint(String value) {
	getBuilder().reset().setTrackTint(value).execute(true);
}

public Object getThumbTint() {
	return getBuilder().reset().tryGetThumbTint().execute(false).getThumbTint(); 
}
public void setThumbTint(String value) {
	getBuilder().reset().setThumbTint(value).execute(true);
}

public Object getSwtInsideMarginX() {
	return getBuilder().reset().tryGetSwtInsideMarginX().execute(false).getSwtInsideMarginX(); 
}
public void setSwtInsideMarginX(String value) {
	getBuilder().reset().setSwtInsideMarginX(value).execute(true);
}

public Object getSwtInsideMarginY() {
	return getBuilder().reset().tryGetSwtInsideMarginY().execute(false).getSwtInsideMarginY(); 
}
public void setSwtInsideMarginY(String value) {
	getBuilder().reset().setSwtInsideMarginY(value).execute(true);
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

public void setTextFormat(String value) {
	getBuilder().reset().setTextFormat(value).execute(true);
}

}


    
	//end - body
	//start - switch
	protected org.eclipse.swt.widgets.Label label;

	private void nativeCreate(Map<String, Object> params) {
		nativeCreateLabel(params);
		switchButton = new org.eclipse.nebula.widgets.opal.switchbutton.SwitchButton(wrapperComposite, getStyle(params, fragment));
		updateIntrinsicBounds();
		measurableSwitch.setGravity(r.android.view.Gravity.CENTER_VERTICAL);
	}

	private void updateIntrinsicBounds() {
		measurableSwitch.setIntrinsicWidth(getSwitchButtonWidth());
		measurableSwitch.setIntrinsicHeight(getSwitchButtonHeight());
	}
	
	private void setTextOff(Object objValue) {
		switchButton.setTextForUnselect((String)objValue); 
	}

	private void setTextOn(Object objValue) {
		switchButton.setTextForSelect((String)objValue); 		
	}

	private Object getTextOff() {
		return switchButton.getTextForUnselect();
	}

	private Object getTextOn() {
		return switchButton.getTextForSelect();

	}
	
	private void setInsideMarginY(Object objValue) {
		switchButton.setInsideMargin((int) getInsideMarginX(), (int) objValue);
	}

	private void setInsideMarginX(Object objValue) {
		switchButton.setInsideMargin((int) objValue, (int) getInsideMarginY());		
	}

	
	private Object getInsideMarginY() {
		return switchButton.getInsideMargin().y;
	}

	private Object getInsideMarginX() {
		return switchButton.getInsideMargin().x;
	}
	
	
	private void postSetAttribute(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
		if (isInitialised()) {
			switchButton.redraw();
		}

		switch (key.getAttributeName()) {
		case "text":
			measurableSwitch.setText((String) objValue);
			break;
		case "textOff":
		case "textOn":
		case "swtText":
		case "swtTextForSelect":
		case "swtTextForUnselect":
			updateIntrinsicBounds();
			if (isInitialised()) {
				measurableSwitch.requestLayout();
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
		case "editable":
			measurableSwitch.setEnabled((boolean) objValue);
		case "enabled":
			switchButton.setEnabled((boolean) objValue);
			break;
		default:
			break;
		}

	}
	
    private int autoSizeMin = -1;
    private int autoSizeMax = -1;
    private int autoSizeGranular = -1;
    
	
	private void nativeMakeFrameForChildWidget(int l, int t, int r, int b) {
		
		r.android.graphics.Rect switchBounds = measurableSwitch.getSwitchBounds();
		switchButton.setBounds(switchBounds.left, switchBounds.top, switchBounds.right - switchBounds.left, switchBounds.bottom - switchBounds.top);
	}
	
    private int getSwitchButtonWidth() {
		return switchButton.computeSize(org.eclipse.swt.SWT.DEFAULT, org.eclipse.swt.SWT.DEFAULT).x;
	}
    
    private int getSwitchButtonHeight() {
		return switchButton.computeSize(org.eclipse.swt.SWT.DEFAULT, org.eclipse.swt.SWT.DEFAULT).y;
	}
    
	@Override
	public void initialized() {
		super.initialized();
		
		addClickListenerToSyncCheckbox();
	}

	private void addClickListenerToSyncCheckbox() {
		ViewImpl.setOnListener(this, org.eclipse.swt.SWT.MouseDown, org.eclipse.swt.SWT.MouseDown + "Chk", (event) -> {
			if (measurableSwitch.isEnabled()) {
				boolean isChecked = (boolean)getChecked();
				switchButton.setSelection(!isChecked);
				
				if (checkedListener != null) {
					checkedListener.widgetSelected(null);
				}
				switchButton.redraw();
			}
		});
	}
	
	
	private void setThumbTint(Object objValue) {
		measurableSwitch.setThumbTintList((r.android.content.res.ColorStateList) objValue);

		switchButton.setUnselectedBackgroundColor((Color) ViewImpl.getColor(measurableSwitch.getThumbTintList().getColorForState(
				measurableSwitch.getDrawableState(), r.android.graphics.Color.RED)));
		switchButton.setSelectedBackgroundColor((Color) ViewImpl.getColor(measurableSwitch.getThumbTintList().getColorForState(
				measurableSwitch.getDrawableState(), r.android.graphics.Color.RED)));
	}
	

	private void setTrackTint(Object objValue) {
		measurableSwitch.setTrackTintList((r.android.content.res.ColorStateList) objValue);
		switchButton.setButtonBackgroundColor1((Color) ViewImpl.getColor(measurableSwitch.getTrackTintList().getColorForState(
				measurableSwitch.getDrawableState(), r.android.graphics.Color.RED)));
		
	}
	
	
	private Object getThumbTint() {
		return measurableSwitch.getThumbTintList();
	}

	private Object getTrackTint() {
		return measurableSwitch.getTrackTintList();
	}
	

	private void drawableStateChangedAdditional() {
		if (measurableSwitch.getTrackTintList() != null) {
			setTrackTint(measurableSwitch.getTrackTintList());
		}
		
		if (measurableSwitch.getThumbTintList() != null) {
			setThumbTint(measurableSwitch.getThumbTintList());
		}
		
		switchButton.redraw();
	}
	//end - switch
}
