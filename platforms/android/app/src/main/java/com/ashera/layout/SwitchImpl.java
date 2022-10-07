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
public class SwitchImpl extends BaseWidget implements com.ashera.validations.FormElement {
	//start - body
	public final static String LOCAL_NAME = "Switch"; 
	public final static String GROUP_NAME = "Switch";

	protected androidx.appcompat.widget.SwitchCompat switchCompat;
	
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
		final static class BreakStrategy extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("balanced",  0x2);
				mapping.put("high_quality",  0x1);
				mapping.put("simple",  0x0);
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
		final static class Ellipsize  extends AbstractStringToEnumConverter{
		private Map<String, Object> mapping = new HashMap<>();
				{
		
				mapping.put("end", android.text.TextUtils.TruncateAt.END);
		
		
				mapping.put("marquee", android.text.TextUtils.TruncateAt.MARQUEE);
		
		
				mapping.put("middle", android.text.TextUtils.TruncateAt.MIDDLE);
		
		
				mapping.put("none", "@null");
		
		
				mapping.put("start", android.text.TextUtils.TruncateAt.START);
		
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
		@SuppressLint("NewApi")
		final static class HyphenationFrequency extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("full",  0x2);
				mapping.put("none",  0x0);
				mapping.put("normal",  0x1);
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
		final static class ThumbTintMode  extends AbstractStringToEnumConverter{
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
		@SuppressLint("NewApi")
		final static class TrackTintMode  extends AbstractStringToEnumConverter{
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
		ViewImpl.register(attributeName);


		ConverterFactory.register("Switch.autoLink", new AutoLink());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoLink").withType("Switch.autoLink"));
		ConverterFactory.register("Switch.breakStrategy", new BreakStrategy());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("breakStrategy").withType("Switch.breakStrategy"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("elegantTextHeight").withType("boolean"));
		ConverterFactory.register("Switch.ellipsize", new Ellipsize());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ellipsize").withType("Switch.ellipsize"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ems").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fallbackLineSpacing").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("firstBaselineToTopHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFeatureSettings").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("height").withType("dimension"));
		ConverterFactory.register("Switch.hyphenationFrequency", new HyphenationFrequency());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hyphenationFrequency").withType("Switch.hyphenationFrequency"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("includeFontPadding").withType("boolean"));
		ConverterFactory.register("Switch.justificationMode", new JustificationMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("justificationMode").withType("Switch.justificationMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lastBaselineToBottomHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("letterSpacing").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingExtra").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingMultiplier").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lines").withType("int"));
		ConverterFactory.register("Switch.marqueeRepeatLimit", new MarqueeRepeatLimit());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("marqueeRepeatLimit").withType("Switch.marqueeRepeatLimit"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxEms").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minEms").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minLines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollHorizontally").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowDx").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowDy").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowRadius").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("singleLine").withType("boolean").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAllCaps").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorHighlight").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorLink").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textIsSelectable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textScaleX").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("width").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("showText").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("splitTrack").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("switchMinWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("switchPadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textOff").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textOn").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("thumb").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("thumbTextPadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("thumbTint").withType("colorstate"));
		ConverterFactory.register("Switch.thumbTintMode", new ThumbTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("thumbTintMode").withType("Switch.thumbTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("track").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("trackTint").withType("colorstate"));
		ConverterFactory.register("Switch.trackTintMode", new TrackTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("trackTintMode").withType("Switch.trackTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onCheckedChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("checked").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("switchTextAppearance").withType("style"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLength").withType("int"));
		ConverterFactory.register("Switch.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("Switch.font"));
		ConverterFactory.register("Switch.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("Switch.textStyle"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAppearance").withType("style"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTint").withType("colorstate"));
		ConverterFactory.register("Switch.drawableTintMode", new DrawableTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTintMode").withType("Switch.drawableTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textFormat").withType("resourcestring").withOrder(-1));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("html").withType("boolean"));
	}
	
	public SwitchImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class SwitchExt extends androidx.appcompat.widget.SwitchCompat implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public SwitchExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public SwitchExt(Context context) {
			super(context);
			
			
			
			
			
			
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
				SwitchImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(SwitchImpl.this);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	    ((SwitchExt) switchCompat).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new SwitchImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		switchCompat = new SwitchExt(context);
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
			switchCompat = new SwitchExt(context, null, defStyleAttr);	
		} else {
		}
		
	}

		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "autoLink": {
				


	switchCompat.setAutoLinkMask((int)objValue);
resetText();


			}
			break;
			case "breakStrategy": {
				
if (Build.VERSION.SDK_INT >= 23) {

	switchCompat.setBreakStrategy((int)objValue);

}

			}
			break;
			case "drawablePadding": {
				


	switchCompat.setCompoundDrawablePadding((int)objValue);



			}
			break;
			case "elegantTextHeight": {
				
if (Build.VERSION.SDK_INT >= 21) {

	switchCompat.setElegantTextHeight((boolean)objValue);

}

			}
			break;
			case "ellipsize": {
				

objValue = getFinalValueForEllipsize(objValue);
	switchCompat.setEllipsize((android.text.TextUtils.TruncateAt)objValue);



			}
			break;
			case "ems": {
				


	switchCompat.setEms((int)objValue);



			}
			break;
			case "fallbackLineSpacing": {
				
if (Build.VERSION.SDK_INT >= 28) {

	switchCompat.setFallbackLineSpacing((boolean)objValue);

}

			}
			break;
			case "firstBaselineToTopHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	switchCompat.setFirstBaselineToTopHeight((int)objValue);

}

			}
			break;
			case "fontFeatureSettings": {
				
if (Build.VERSION.SDK_INT >= 21) {

	switchCompat.setFontFeatureSettings((String)objValue);

}

			}
			break;
			case "gravity": {
				


	switchCompat.setGravity((int)objValue);



			}
			break;
			case "height": {
				


	switchCompat.setHeight((int)objValue);



			}
			break;
			case "hyphenationFrequency": {
				
if (Build.VERSION.SDK_INT >= 23) {

	switchCompat.setHyphenationFrequency((int)objValue);

}

			}
			break;
			case "includeFontPadding": {
				


	switchCompat.setIncludeFontPadding((boolean)objValue);



			}
			break;
			case "justificationMode": {
				
if (Build.VERSION.SDK_INT >= 26) {

	switchCompat.setJustificationMode((int)objValue);

}

			}
			break;
			case "lastBaselineToBottomHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	switchCompat.setLastBaselineToBottomHeight((int)objValue);

}

			}
			break;
			case "letterSpacing": {
				
if (Build.VERSION.SDK_INT >= 21) {

	switchCompat.setLetterSpacing((float)objValue);

}

			}
			break;
			case "lineHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	switchCompat.setLineHeight((int)objValue);

}

			}
			break;
			case "lineSpacingExtra": {
				


		switchCompat.setLineSpacing((float) objValue,switchCompat.getLineSpacingMultiplier());



			}
			break;
			case "lineSpacingMultiplier": {
				


		switchCompat.setLineSpacing(switchCompat.getLineSpacingExtra(),(float) objValue);



			}
			break;
			case "lines": {
				


	switchCompat.setLines((int)objValue);



			}
			break;
			case "marqueeRepeatLimit": {
				


	switchCompat.setMarqueeRepeatLimit((int)objValue);



			}
			break;
			case "maxEms": {
				


	switchCompat.setMaxEms((int)objValue);



			}
			break;
			case "maxHeight": {
				


	switchCompat.setMaxHeight((int)objValue);



			}
			break;
			case "maxLines": {
				


	switchCompat.setMaxLines((int)objValue);



			}
			break;
			case "maxWidth": {
				


	switchCompat.setMaxWidth((int)objValue);



			}
			break;
			case "minEms": {
				


	switchCompat.setMinEms((int)objValue);



			}
			break;
			case "minHeight": {
				


	switchCompat.setMinHeight((int)objValue);



			}
			break;
			case "minLines": {
				


	switchCompat.setMinLines((int)objValue);



			}
			break;
			case "minWidth": {
				


	switchCompat.setMinWidth((int)objValue);



			}
			break;
			case "scrollHorizontally": {
				


	switchCompat.setHorizontallyScrolling((boolean)objValue);



			}
			break;
			case "shadowColor": {
				


		switchCompat.setShadowLayer(switchCompat.getShadowRadius(),switchCompat.getShadowDx(),switchCompat.getShadowDy(),(int) objValue);



			}
			break;
			case "shadowDx": {
				


		switchCompat.setShadowLayer(switchCompat.getShadowRadius(),(float) objValue,switchCompat.getShadowDy(),switchCompat.getShadowColor());



			}
			break;
			case "shadowDy": {
				


		switchCompat.setShadowLayer(switchCompat.getShadowRadius(),switchCompat.getShadowDx(),(float) objValue,switchCompat.getShadowColor());



			}
			break;
			case "shadowRadius": {
				


		switchCompat.setShadowLayer((float) objValue,switchCompat.getShadowDx(),switchCompat.getShadowDy(),switchCompat.getShadowColor());



			}
			break;
			case "singleLine": {
				


	switchCompat.setSingleLine((boolean)objValue);



			}
			break;
			case "textAllCaps": {
				
if (Build.VERSION.SDK_INT >= 14) {

	switchCompat.setAllCaps((boolean)objValue);

}

			}
			break;
			case "textColor": {
				


	switchCompat.setTextColor((android.content.res.ColorStateList)objValue);



			}
			break;
			case "textColorHighlight": {
				


	switchCompat.setHighlightColor((int)objValue);



			}
			break;
			case "textColorLink": {
				


	switchCompat.setLinkTextColor((android.content.res.ColorStateList)objValue);



			}
			break;
			case "textIsSelectable": {
				
if (Build.VERSION.SDK_INT >= 11) {

	switchCompat.setTextIsSelectable((boolean)objValue);

}

			}
			break;
			case "textScaleX": {
				


	switchCompat.setTextScaleX((float)objValue);



			}
			break;
			case "width": {
				


	switchCompat.setWidth((int)objValue);



			}
			break;
			case "showText": {
				
if (Build.VERSION.SDK_INT >= 21) {

	switchCompat.setShowText((boolean)objValue);

}

			}
			break;
			case "splitTrack": {
				
if (Build.VERSION.SDK_INT >= 21) {

	switchCompat.setSplitTrack((boolean)objValue);

}

			}
			break;
			case "switchMinWidth": {
				
if (Build.VERSION.SDK_INT >= 16) {

	switchCompat.setSwitchMinWidth((int)objValue);

}

			}
			break;
			case "switchPadding": {
				
if (Build.VERSION.SDK_INT >= 16) {

	switchCompat.setSwitchPadding((int)objValue);

}

			}
			break;
			case "textOff": {
				
if (Build.VERSION.SDK_INT >= 14) {

	switchCompat.setTextOff((String)objValue);

}

			}
			break;
			case "textOn": {
				
if (Build.VERSION.SDK_INT >= 14) {

	switchCompat.setTextOn((String)objValue);

}

			}
			break;
			case "thumb": {
				
if (Build.VERSION.SDK_INT >= 16) {

	setThumbResource(objValue);

}

			}
			break;
			case "thumbTextPadding": {
				
if (Build.VERSION.SDK_INT >= 16) {

	switchCompat.setThumbTextPadding((int)objValue);

}

			}
			break;
			case "thumbTint": {
				
if (Build.VERSION.SDK_INT >= 23) {

	switchCompat.setThumbTintList((android.content.res.ColorStateList)objValue);

}

			}
			break;
			case "thumbTintMode": {
				
if (Build.VERSION.SDK_INT >= 23) {

	switchCompat.setThumbTintMode((android.graphics.PorterDuff.Mode)objValue);

}

			}
			break;
			case "track": {
				
if (Build.VERSION.SDK_INT >= 16) {

	setTrackResource(objValue);

}

			}
			break;
			case "trackTint": {
				
if (Build.VERSION.SDK_INT >= 23) {

	switchCompat.setTrackTintList((android.content.res.ColorStateList)objValue);

}

			}
			break;
			case "trackTintMode": {
				
if (Build.VERSION.SDK_INT >= 23) {

	switchCompat.setTrackTintMode((android.graphics.PorterDuff.Mode)objValue);

}

			}
			break;
			case "onCheckedChange": {
				


		if (objValue instanceof String) {switchCompat.setOnCheckedChangeListener(new OnCheckedChangeListener(this, strValue));} else {setOnCheckedChangeListener(switchCompat, objValue);}



			}
			break;
			case "checked": {
				


		setChecked(objValue);



			}
			break;
			case "switchTextAppearance": {
				


		setSwitchTextAppearance(objValue);



			}
			break;
			case "text": {
				


		setMyText(objValue);



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
			case "textAppearance": {
				


		TextViewCompat.setTextAppearance(switchCompat, (int)objValue);



			}
			break;
			case "enabled": {
				


		 switchCompat.setEnabled((boolean) objValue);



			}
			break;
			case "editable": {
				


		 switchCompat.setEnabled((boolean) objValue);



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
			case "padding": {
				


		//



			}
			break;
			case "paddingBottom": {
				


		//



			}
			break;
			case "paddingRight": {
				


		//



			}
			break;
			case "paddingLeft": {
				


		//



			}
			break;
			case "paddingStart": {
				


		//



			}
			break;
			case "paddingEnd": {
				


		//



			}
			break;
			case "paddingTop": {
				


		//



			}
			break;
			case "paddingHorizontal": {
				


		//



			}
			break;
			case "paddingVertical": {
				


		//



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
			case "autoLink": {
return switchCompat.getAutoLinkMask();				}
			case "breakStrategy": {
if (Build.VERSION.SDK_INT >= 23) {
return switchCompat.getBreakStrategy();
}
break;				}
			case "drawablePadding": {
return switchCompat.getCompoundDrawablePadding();				}
			case "elegantTextHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return switchCompat.isElegantTextHeight();
}
break;				}
			case "ellipsize": {
return switchCompat.getEllipsize();				}
			case "fallbackLineSpacing": {
if (Build.VERSION.SDK_INT >= 28) {
return switchCompat.isFallbackLineSpacing();
}
break;				}
			case "firstBaselineToTopHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return switchCompat.getFirstBaselineToTopHeight();
}
break;				}
			case "fontFeatureSettings": {
if (Build.VERSION.SDK_INT >= 21) {
return switchCompat.getFontFeatureSettings();
}
break;				}
			case "gravity": {
return switchCompat.getGravity();				}
			case "height": {
return switchCompat.getHeight();				}
			case "hyphenationFrequency": {
if (Build.VERSION.SDK_INT >= 23) {
return switchCompat.getHyphenationFrequency();
}
break;				}
			case "includeFontPadding": {
return switchCompat.getIncludeFontPadding();				}
			case "justificationMode": {
if (Build.VERSION.SDK_INT >= 26) {
return switchCompat.getJustificationMode();
}
break;				}
			case "lastBaselineToBottomHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return switchCompat.getLastBaselineToBottomHeight();
}
break;				}
			case "letterSpacing": {
if (Build.VERSION.SDK_INT >= 21) {
return switchCompat.getLetterSpacing();
}
break;				}
			case "lineHeight": {
return switchCompat.getLineHeight();				}
			case "lineSpacingExtra": {
return switchCompat.getLineSpacingExtra();				}
			case "lineSpacingMultiplier": {
return switchCompat.getLineSpacingMultiplier();				}
			case "marqueeRepeatLimit": {
return switchCompat.getMarqueeRepeatLimit();				}
			case "maxEms": {
return switchCompat.getMaxEms();				}
			case "maxHeight": {
return switchCompat.getMaxHeight();				}
			case "maxLines": {
return switchCompat.getMaxLines();				}
			case "maxWidth": {
return switchCompat.getMaxWidth();				}
			case "minEms": {
return switchCompat.getMinEms();				}
			case "minHeight": {
return switchCompat.getMinHeight();				}
			case "minLines": {
return switchCompat.getMinLines();				}
			case "minWidth": {
return switchCompat.getMinWidth();				}
			case "shadowColor": {
return switchCompat.getShadowColor();				}
			case "shadowDx": {
return switchCompat.getShadowDx();				}
			case "shadowDy": {
return switchCompat.getShadowDy();				}
			case "shadowRadius": {
return switchCompat.getShadowRadius();				}
			case "textAllCaps": {
if (Build.VERSION.SDK_INT >= 28) {
return switchCompat.isAllCaps();
}
break;				}
			case "textColor": {
return switchCompat.getTextColors();				}
			case "textColorHighlight": {
if (Build.VERSION.SDK_INT >= 16) {
return switchCompat.getHighlightColor();
}
break;				}
			case "textIsSelectable": {
return switchCompat.isTextSelectable();				}
			case "textScaleX": {
return switchCompat.getTextScaleX();				}
			case "width": {
return switchCompat.getWidth();				}
			case "showText": {
if (Build.VERSION.SDK_INT >= 21) {
return switchCompat.getShowText();
}
break;				}
			case "splitTrack": {
if (Build.VERSION.SDK_INT >= 21) {
return switchCompat.getSplitTrack();
}
break;				}
			case "switchMinWidth": {
if (Build.VERSION.SDK_INT >= 16) {
return switchCompat.getSwitchMinWidth();
}
break;				}
			case "switchPadding": {
if (Build.VERSION.SDK_INT >= 16) {
return switchCompat.getSwitchPadding();
}
break;				}
			case "textOff": {
if (Build.VERSION.SDK_INT >= 14) {
return switchCompat.getTextOff();
}
break;				}
			case "textOn": {
if (Build.VERSION.SDK_INT >= 14) {
return switchCompat.getTextOn();
}
break;				}
			case "thumb": {
if (Build.VERSION.SDK_INT >= 16) {
return switchCompat.getThumbDrawable();
}
break;				}
			case "thumbTextPadding": {
if (Build.VERSION.SDK_INT >= 16) {
return switchCompat.getThumbTextPadding();
}
break;				}
			case "thumbTint": {
if (Build.VERSION.SDK_INT >= 23) {
return switchCompat.getThumbTintList();
}
break;				}
			case "thumbTintMode": {
if (Build.VERSION.SDK_INT >= 23) {
return switchCompat.getThumbTintMode();
}
break;				}
			case "track": {
if (Build.VERSION.SDK_INT >= 16) {
return switchCompat.getTrackDrawable();
}
break;				}
			case "trackTint": {
if (Build.VERSION.SDK_INT >= 23) {
return switchCompat.getTrackTintList();
}
break;				}
			case "trackTintMode": {
if (Build.VERSION.SDK_INT >= 23) {
return switchCompat.getTrackTintMode();
}
break;				}
			case "checked": {
return getChecked();				}
			case "text": {
return getMyText();				}
			case "textSize": {
return switchCompat.getTextSize();				}
			case "paddingBottom": {
return null;				}
			case "paddingRight": {
return null;				}
			case "paddingLeft": {
return null;				}
			case "paddingStart": {
return null;				}
			case "paddingEnd": {
return null;				}
			case "paddingTop": {
return null;				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return switchCompat;
	}

	


	private String getMyText() {
	    if (switchCompat.getText() != null) {
	        return switchCompat.getText().toString();
	    }
	    return "";
    }

	private boolean html;
	private void nativeCreate(Map<String, Object> params) {
		registerForAttributeCommandChain("text");
		if (params.containsKey("html")) {
			html = params.get("html").equals("true");
		}
	}

	@Override
	public java.lang.Object asNativeWidget() {
		return switchCompat;
	}
	public void setMyText(Object text) {
		if (html) {
			switchCompat.setText((SpannableString) com.ashera.parser.html.Html.fromHtml((String) text, null, fragment).get());	
		} else {
			switchCompat.setText((String) text);	
		}
	}
	//start - textsize
	private void setMyTextSize(Object objValue) {
		switchCompat.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, getFragment().getRootActivity().getScaleFactor() * (float)objValue);		
	}
	//end - textsize
	
	//start - drawable
	private void setDrawableLeft(Object objValue) {
		android.graphics.drawable.Drawable[] drawables = switchCompat.getCompoundDrawables();
		setBoundsOfDrawable(objValue);
		TextViewCompat.setCompoundDrawablesRelative(switchCompat, (android.graphics.drawable.Drawable) objValue, drawables[1], drawables[2], drawables[3]);		
	}

	private void setBoundsOfDrawable(Object objValue) {
		android.graphics.drawable.Drawable image = (android.graphics.drawable.Drawable) objValue;
		int h = image.getIntrinsicHeight();
		int w = image.getIntrinsicWidth();
		image.setBounds( 0, 0, w, h);
	}
	
	private void setDrawableRight(Object objValue) {
		android.graphics.drawable.Drawable[] drawables = switchCompat.getCompoundDrawables();
		setBoundsOfDrawable(objValue);
		TextViewCompat.setCompoundDrawablesRelative(switchCompat, drawables[0], drawables[1], (android.graphics.drawable.Drawable) objValue, drawables[3]);
		
	}
	private void setDrawableTop(Object objValue) {
		setBoundsOfDrawable(objValue);
		android.graphics.drawable.Drawable[] drawables = switchCompat.getCompoundDrawables();
		TextViewCompat.setCompoundDrawablesRelative(switchCompat, drawables[0], (android.graphics.drawable.Drawable) objValue, drawables[2], drawables[3]);
		
	}
	
	private void setDrawableBottom(Object objValue) {
		setBoundsOfDrawable(objValue);
		android.graphics.drawable.Drawable[] drawables = switchCompat.getCompoundDrawables();
		TextViewCompat.setCompoundDrawablesRelative(switchCompat, drawables[0], drawables[1], drawables[2], (android.graphics.drawable.Drawable) objValue);
		
	}
	
	private android.graphics.drawable.Drawable tintDrawableCompat;
	private void setDrawableTintMode(Object objValue) {
		if (Build.VERSION.SDK_INT >= 23) {
			switchCompat.setCompoundDrawableTintMode((android.graphics.PorterDuff.Mode) objValue);
		} else {
			android.graphics.drawable.Drawable[] drawables = switchCompat.getCompoundDrawablesRelative();
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
						switchCompat.invalidate();
					}
				}
			}
		}
	}

	private void setDrawableTintList(Object objValue) {
		if (Build.VERSION.SDK_INT >= 23) {
			switchCompat.setCompoundDrawableTintList((android.content.res.ColorStateList) objValue);
		} else {
			android.graphics.drawable.Drawable[] drawables = switchCompat.getCompoundDrawablesRelative();
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
						switchCompat.invalidate();
					}					
				}
			}
		}
	}
	//end - drawable
	
	//start - font
	private void setFontFamily(Object objValue, String strValue) {
		setTypeFace(objValue, strValue);
	}

	private void setTextStyle(Object objValue) {
		android.graphics.Typeface typeface  = switchCompat.getTypeface();
		if (typeface == null) {
			typeface = android.graphics.Typeface.DEFAULT;
		} else {
			typeface = android.graphics.Typeface.create(typeface, (int) objValue);
        }
		
		switchCompat.setTypeface(typeface, (int) objValue);
	}

	private void setTypeFace(Object objValue, String strValue) {
		if (objValue instanceof Integer) {
			objValue = PluginInvoker.convertFrom(ConverterFactory.get(CommonConverters.font), null, strValue, fragment);
		}
		android.graphics.Typeface typeface = switchCompat.getTypeface();
		if (typeface != null) {
			switchCompat.setTypeface((android.graphics.Typeface) objValue, typeface.getStyle());
		} else {
			switchCompat.setTypeface((android.graphics.Typeface) objValue);
		}
	}
	//end - font
	
	private void setMaxLength(Object objValue) {
		int maxlength = (int) objValue;
		removeMaxLengthFilter();
		if (maxlength >= 0) {
			android.text.InputFilter[] filtersArr = switchCompat.getFilters();
			List<android.text.InputFilter> filters = new java.util.ArrayList<>(java.util.Arrays.asList(filtersArr));			
			filters.add(new android.text.InputFilter.LengthFilter(maxlength));
			switchCompat.setFilters(filters.toArray(new android.text.InputFilter[0]));
        }
		
	}
	
	private void removeMaxLengthFilter() {
		android.text.InputFilter[] filtersArr = switchCompat.getFilters();
		if (filtersArr == null) {
			filtersArr = new android.text.InputFilter[0];
		}
		List<android.text.InputFilter> filters = new java.util.ArrayList<>(java.util.Arrays.asList(filtersArr));
		for (java.util.Iterator<android.text.InputFilter> iterator = filters.iterator(); iterator.hasNext();) {
			android.text.InputFilter inputFilter = iterator.next();
			if (inputFilter instanceof android.text.InputFilter.LengthFilter) {
				iterator.remove();
			}
			
		}
		switchCompat.setFilters(filters.toArray(new android.text.InputFilter[0]));
	}


	
	private void setPasswordType(Object objValue) {
		if (objValue != null && (boolean) objValue) {
			switchCompat.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
			switchCompat.setTypeface(android.graphics.Typeface.MONOSPACE);
		} else {
			switchCompat.setTransformationMethod(null);
			switchCompat.setTypeface(null);
		}
	}


	private void setAutoCap(int autocap, boolean autotext) {
		android.text.method.TextKeyListener.Capitalize cap;
		int inputType = android.view.inputmethod.EditorInfo.TYPE_CLASS_TEXT;
        switch (autocap) {
        case 1:
            cap = android.text.method.TextKeyListener.Capitalize.SENTENCES;
            inputType |= android.view.inputmethod.EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES;
            break;
        case 2:
            cap = android.text.method.TextKeyListener.Capitalize.WORDS;
            inputType |= android.view.inputmethod.EditorInfo.TYPE_TEXT_FLAG_CAP_WORDS;
            break;
        case 3:
            cap = android.text.method.TextKeyListener.Capitalize.CHARACTERS;
            inputType |= android.view.inputmethod.EditorInfo.TYPE_TEXT_FLAG_CAP_CHARACTERS;
            break;
        default:
            cap = android.text.method.TextKeyListener.Capitalize.NONE;
            break;
        }
        switchCompat.setKeyListener(android.text.method.TextKeyListener.getInstance(autotext, cap));
        switchCompat.setInputType(inputType);
	}

	private void setAutoText(Object objValue) {
		storeUserData("autotext", objValue);
		boolean autotext = (boolean) objValue;
		int autocap = getUserData("capitalize") != null ? (int) getUserData("capitalize") : 0;
		setAutoCap(autocap, autotext);
		
	}
	
	//start - autosize
    private int autoSizeMin = -1;
    private int autoSizeMax = -1;
    private int autoSizeGranular = -1;
    
	
	private void setAutoSizeStepGranularity(Object objValue) {
		autoSizeGranular = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(switchCompat));
		}
	}

	private void setAutoMinTextSize(Object objValue) {
		autoSizeMin = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(switchCompat));
		}
	}

	private void setAutoMaxTextSize(Object objValue) {
		autoSizeMax = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(switchCompat));
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
		return getAutoSizeTextType(switchCompat);
	}
	//end - autosize

	private int getAutoSizeTextType(TextView switchCompat) {
		return TextViewCompat.getAutoSizeTextType(switchCompat);
	}

	private void setAutoSizeTextTypeInternal(int autoTextType) {
		TextViewCompat.setAutoSizeTextTypeWithDefaults(switchCompat, autoTextType);
		
		if (autoTextType == 1) {
			int autoSizeMinTextSize = autoSizeMin == -1 ? TextViewCompat.getAutoSizeMinTextSize(switchCompat) : autoSizeMin;
			int autoSizeMaxTextSize = autoSizeMax == -1 ? TextViewCompat.getAutoSizeMaxTextSize(switchCompat) : autoSizeMax;
			int autoSizeStepGranularity = autoSizeGranular == -1 ? TextViewCompat.getAutoSizeStepGranularity(switchCompat) : autoSizeGranular;
			TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(switchCompat, 
					autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, 
					android.util.TypedValue.COMPLEX_UNIT_PX);
        }
	}
	
	   
    private void setLinksClickable(Object objValue) {
        if (objValue != null && (boolean) objValue) {
            switchCompat.setLinksClickable(true);
            
            if (isInitialised()) {
                switchCompat.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());    
            }
        } else {
            switchCompat.setLinksClickable(false);
            
            if (isInitialised()) {
                if (switchCompat.getMovementMethod() instanceof android.text.method.LinkMovementMethod) {
                    switchCompat.setMovementMethod(null);
                }    
            }
        }
    }

	
	private void startOrStopMarquee(Object objValue) {
		switchCompat.setSelected((boolean) objValue); 
		
	}

	
	private void setTextAligmentHack(Object objValue) {
		if (isInitialised()) {
			setFieldUsingReflection(switchCompat, "mLayout", null);
		}
	}
	

	private void resetText() {
		if (isInitialised()) {
			switchCompat.setText(switchCompat.getText());
		}
	}
	

	
	private Object getFinalValueForEllipsize(Object objValue) {
		if ("@null".equals(objValue)) {
			return null;
		}
		
		if (objValue == android.text.TextUtils.TruncateAt.MARQUEE) {
			switchCompat.setSelected(true); 
		}
		return objValue;
	}	

	private void setAutoSizePresetSizes(Object objValue) {
		TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(switchCompat, (int[]) objValue, android.util.TypedValue.COMPLEX_UNIT_PX);
	}
	
	
	private void postSetAttribute(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
		switch (key.getAttributeName()) {
			case "textAlignment": {
				setTextAligmentHack(objValue);
			}
			break;
		}
	}

	
	private void removeaddTextChangedListenerIfNeeded(String action) {
		if (isInitialised()) {
			List<IListener> listeners = (List<IListener>)getFieldValueUsingReflection(switchCompat, "mListeners");
			if (listeners != null) {
				for (IListener listener : listeners) {
					if (action.equals(listener.getAction())) {
						switchCompat.removeTextChangedListener((TextWatcher) listener);
					}
				}
			}
		}
	}

	//start - textFormat
	private void setTextFormat(Object objValue) {
		applyAttributeCommand("text", CommonConverters.command_textformatter, new String[] {"textFormat"}, true, (String) objValue);
	}
	//end - textFormat
	


	@Override
	public boolean isViewVisible() {
		return switchCompat.getVisibility() == View.VISIBLE;
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
		switchCompat.requestFocus();
	}
	


	public void setError(String mesage) {
		switchCompat.setError(mesage);
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
			switchCompat.setId(IdGenerator.getId(id));
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
public SwitchCommandBuilder tryGetBreakStrategy() {
	Map<String, Object> attrs = initCommand("breakStrategy");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBreakStrategy() {
	Map<String, Object> attrs = initCommand("breakStrategy");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setBreakStrategy(String value) {
	Map<String, Object> attrs = initCommand("breakStrategy");
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
public SwitchCommandBuilder tryGetElegantTextHeight() {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isElegantTextHeight() {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setElegantTextHeight(boolean value) {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
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
public SwitchCommandBuilder setEllipsize(Ellipsize value) {
	Map<String, Object> attrs = initCommand("ellipsize");
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
public SwitchCommandBuilder tryGetFallbackLineSpacing() {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isFallbackLineSpacing() {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setFallbackLineSpacing(boolean value) {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
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
public SwitchCommandBuilder tryGetFontFeatureSettings() {
	Map<String, Object> attrs = initCommand("fontFeatureSettings");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getFontFeatureSettings() {
	Map<String, Object> attrs = initCommand("fontFeatureSettings");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setFontFeatureSettings(String value) {
	Map<String, Object> attrs = initCommand("fontFeatureSettings");
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
public SwitchCommandBuilder tryGetHyphenationFrequency() {
	Map<String, Object> attrs = initCommand("hyphenationFrequency");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHyphenationFrequency() {
	Map<String, Object> attrs = initCommand("hyphenationFrequency");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setHyphenationFrequency(String value) {
	Map<String, Object> attrs = initCommand("hyphenationFrequency");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetIncludeFontPadding() {
	Map<String, Object> attrs = initCommand("includeFontPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIncludeFontPadding() {
	Map<String, Object> attrs = initCommand("includeFontPadding");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setIncludeFontPadding(boolean value) {
	Map<String, Object> attrs = initCommand("includeFontPadding");
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
public SwitchCommandBuilder setLines(int value) {
	Map<String, Object> attrs = initCommand("lines");
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
public SwitchCommandBuilder setScrollHorizontally(boolean value) {
	Map<String, Object> attrs = initCommand("scrollHorizontally");
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
public SwitchCommandBuilder setSingleLine(boolean value) {
	Map<String, Object> attrs = initCommand("singleLine");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetTextAllCaps() {
	Map<String, Object> attrs = initCommand("textAllCaps");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isTextAllCaps() {
	Map<String, Object> attrs = initCommand("textAllCaps");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTextAllCaps(boolean value) {
	Map<String, Object> attrs = initCommand("textAllCaps");
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
public SwitchCommandBuilder setTextColorLink(String value) {
	Map<String, Object> attrs = initCommand("textColorLink");
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
public SwitchCommandBuilder tryGetTextScaleX() {
	Map<String, Object> attrs = initCommand("textScaleX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextScaleX() {
	Map<String, Object> attrs = initCommand("textScaleX");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTextScaleX(float value) {
	Map<String, Object> attrs = initCommand("textScaleX");
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
public SwitchCommandBuilder tryGetShowText() {
	Map<String, Object> attrs = initCommand("showText");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isShowText() {
	Map<String, Object> attrs = initCommand("showText");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setShowText(boolean value) {
	Map<String, Object> attrs = initCommand("showText");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetSplitTrack() {
	Map<String, Object> attrs = initCommand("splitTrack");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isSplitTrack() {
	Map<String, Object> attrs = initCommand("splitTrack");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setSplitTrack(boolean value) {
	Map<String, Object> attrs = initCommand("splitTrack");
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
public SwitchCommandBuilder tryGetThumb() {
	Map<String, Object> attrs = initCommand("thumb");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getThumb() {
	Map<String, Object> attrs = initCommand("thumb");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setThumb(String value) {
	Map<String, Object> attrs = initCommand("thumb");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetThumbTextPadding() {
	Map<String, Object> attrs = initCommand("thumbTextPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getThumbTextPadding() {
	Map<String, Object> attrs = initCommand("thumbTextPadding");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setThumbTextPadding(String value) {
	Map<String, Object> attrs = initCommand("thumbTextPadding");
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
public SwitchCommandBuilder tryGetThumbTintMode() {
	Map<String, Object> attrs = initCommand("thumbTintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getThumbTintMode() {
	Map<String, Object> attrs = initCommand("thumbTintMode");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setThumbTintMode(ThumbTintMode value) {
	Map<String, Object> attrs = initCommand("thumbTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder tryGetTrack() {
	Map<String, Object> attrs = initCommand("track");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTrack() {
	Map<String, Object> attrs = initCommand("track");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTrack(String value) {
	Map<String, Object> attrs = initCommand("track");
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
public SwitchCommandBuilder tryGetTrackTintMode() {
	Map<String, Object> attrs = initCommand("trackTintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTrackTintMode() {
	Map<String, Object> attrs = initCommand("trackTintMode");
	return attrs.get("commandReturnValue");
}
public SwitchCommandBuilder setTrackTintMode(TrackTintMode value) {
	Map<String, Object> attrs = initCommand("trackTintMode");
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
public SwitchCommandBuilder setSwitchTextAppearance(String value) {
	Map<String, Object> attrs = initCommand("switchTextAppearance");
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
public SwitchCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
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
public SwitchCommandBuilder setDrawableRight(String value) {
	Map<String, Object> attrs = initCommand("drawableRight");
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
public SwitchCommandBuilder setMaxLength(int value) {
	Map<String, Object> attrs = initCommand("maxLength");
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
public SwitchCommandBuilder setTextAppearance(String value) {
	Map<String, Object> attrs = initCommand("textAppearance");
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
public SwitchCommandBuilder setDrawableTint(String value) {
	Map<String, Object> attrs = initCommand("drawableTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public SwitchCommandBuilder setDrawableTintMode(DrawableTintMode value) {
	Map<String, Object> attrs = initCommand("drawableTintMode");
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
public Object getAutoLink() {
	return getBuilder().reset().tryGetAutoLink().execute(false).getAutoLink(); 
}
public void setAutoLink(String value) {
	getBuilder().reset().setAutoLink(value).execute(true);
}

public Object getBreakStrategy() {
	return getBuilder().reset().tryGetBreakStrategy().execute(false).getBreakStrategy(); 
}
public void setBreakStrategy(String value) {
	getBuilder().reset().setBreakStrategy(value).execute(true);
}

public Object getDrawablePadding() {
	return getBuilder().reset().tryGetDrawablePadding().execute(false).getDrawablePadding(); 
}
public void setDrawablePadding(String value) {
	getBuilder().reset().setDrawablePadding(value).execute(true);
}

public Object isElegantTextHeight() {
	return getBuilder().reset().tryGetElegantTextHeight().execute(false).isElegantTextHeight(); 
}
public void setElegantTextHeight(boolean value) {
	getBuilder().reset().setElegantTextHeight(value).execute(true);
}

public Object getEllipsize() {
	return getBuilder().reset().tryGetEllipsize().execute(false).getEllipsize(); 
}
public void setEllipsize(Ellipsize value) {
	getBuilder().reset().setEllipsize(value).execute(true);
}

public void setEms(int value) {
	getBuilder().reset().setEms(value).execute(true);
}

public Object isFallbackLineSpacing() {
	return getBuilder().reset().tryGetFallbackLineSpacing().execute(false).isFallbackLineSpacing(); 
}
public void setFallbackLineSpacing(boolean value) {
	getBuilder().reset().setFallbackLineSpacing(value).execute(true);
}

public Object getFirstBaselineToTopHeight() {
	return getBuilder().reset().tryGetFirstBaselineToTopHeight().execute(false).getFirstBaselineToTopHeight(); 
}
public void setFirstBaselineToTopHeight(String value) {
	getBuilder().reset().setFirstBaselineToTopHeight(value).execute(true);
}

public Object getFontFeatureSettings() {
	return getBuilder().reset().tryGetFontFeatureSettings().execute(false).getFontFeatureSettings(); 
}
public void setFontFeatureSettings(String value) {
	getBuilder().reset().setFontFeatureSettings(value).execute(true);
}

public Object getGravity() {
	return getBuilder().reset().tryGetGravity().execute(false).getGravity(); 
}
public void setGravity(String value) {
	getBuilder().reset().setGravity(value).execute(true);
}

public Object getHeight() {
	return getBuilder().reset().tryGetHeight().execute(false).getHeight(); 
}
public void setHeight(String value) {
	getBuilder().reset().setHeight(value).execute(true);
}

public Object getHyphenationFrequency() {
	return getBuilder().reset().tryGetHyphenationFrequency().execute(false).getHyphenationFrequency(); 
}
public void setHyphenationFrequency(String value) {
	getBuilder().reset().setHyphenationFrequency(value).execute(true);
}

public Object isIncludeFontPadding() {
	return getBuilder().reset().tryGetIncludeFontPadding().execute(false).isIncludeFontPadding(); 
}
public void setIncludeFontPadding(boolean value) {
	getBuilder().reset().setIncludeFontPadding(value).execute(true);
}

public Object getJustificationMode() {
	return getBuilder().reset().tryGetJustificationMode().execute(false).getJustificationMode(); 
}
public void setJustificationMode(String value) {
	getBuilder().reset().setJustificationMode(value).execute(true);
}

public Object getLastBaselineToBottomHeight() {
	return getBuilder().reset().tryGetLastBaselineToBottomHeight().execute(false).getLastBaselineToBottomHeight(); 
}
public void setLastBaselineToBottomHeight(String value) {
	getBuilder().reset().setLastBaselineToBottomHeight(value).execute(true);
}

public Object getLetterSpacing() {
	return getBuilder().reset().tryGetLetterSpacing().execute(false).getLetterSpacing(); 
}
public void setLetterSpacing(float value) {
	getBuilder().reset().setLetterSpacing(value).execute(true);
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

public void setLines(int value) {
	getBuilder().reset().setLines(value).execute(true);
}

public Object getMarqueeRepeatLimit() {
	return getBuilder().reset().tryGetMarqueeRepeatLimit().execute(false).getMarqueeRepeatLimit(); 
}
public void setMarqueeRepeatLimit(String value) {
	getBuilder().reset().setMarqueeRepeatLimit(value).execute(true);
}

public Object getMaxEms() {
	return getBuilder().reset().tryGetMaxEms().execute(false).getMaxEms(); 
}
public void setMaxEms(int value) {
	getBuilder().reset().setMaxEms(value).execute(true);
}

public Object getMaxHeight() {
	return getBuilder().reset().tryGetMaxHeight().execute(false).getMaxHeight(); 
}
public void setMaxHeight(String value) {
	getBuilder().reset().setMaxHeight(value).execute(true);
}

public Object getMaxLines() {
	return getBuilder().reset().tryGetMaxLines().execute(false).getMaxLines(); 
}
public void setMaxLines(int value) {
	getBuilder().reset().setMaxLines(value).execute(true);
}

public Object getMaxWidth() {
	return getBuilder().reset().tryGetMaxWidth().execute(false).getMaxWidth(); 
}
public void setMaxWidth(String value) {
	getBuilder().reset().setMaxWidth(value).execute(true);
}

public Object getMinEms() {
	return getBuilder().reset().tryGetMinEms().execute(false).getMinEms(); 
}
public void setMinEms(int value) {
	getBuilder().reset().setMinEms(value).execute(true);
}

public Object getMinHeight() {
	return getBuilder().reset().tryGetMinHeight().execute(false).getMinHeight(); 
}
public void setMinHeight(String value) {
	getBuilder().reset().setMinHeight(value).execute(true);
}

public Object getMinLines() {
	return getBuilder().reset().tryGetMinLines().execute(false).getMinLines(); 
}
public void setMinLines(int value) {
	getBuilder().reset().setMinLines(value).execute(true);
}

public Object getMinWidth() {
	return getBuilder().reset().tryGetMinWidth().execute(false).getMinWidth(); 
}
public void setMinWidth(String value) {
	getBuilder().reset().setMinWidth(value).execute(true);
}

public void setScrollHorizontally(boolean value) {
	getBuilder().reset().setScrollHorizontally(value).execute(true);
}

public Object getShadowColor() {
	return getBuilder().reset().tryGetShadowColor().execute(false).getShadowColor(); 
}
public void setShadowColor(String value) {
	getBuilder().reset().setShadowColor(value).execute(true);
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

public Object getShadowRadius() {
	return getBuilder().reset().tryGetShadowRadius().execute(false).getShadowRadius(); 
}
public void setShadowRadius(float value) {
	getBuilder().reset().setShadowRadius(value).execute(true);
}

public void setSingleLine(boolean value) {
	getBuilder().reset().setSingleLine(value).execute(true);
}

public Object isTextAllCaps() {
	return getBuilder().reset().tryGetTextAllCaps().execute(false).isTextAllCaps(); 
}
public void setTextAllCaps(boolean value) {
	getBuilder().reset().setTextAllCaps(value).execute(true);
}

public Object getTextColor() {
	return getBuilder().reset().tryGetTextColor().execute(false).getTextColor(); 
}
public void setTextColor(String value) {
	getBuilder().reset().setTextColor(value).execute(true);
}

public Object getTextColorHighlight() {
	return getBuilder().reset().tryGetTextColorHighlight().execute(false).getTextColorHighlight(); 
}
public void setTextColorHighlight(String value) {
	getBuilder().reset().setTextColorHighlight(value).execute(true);
}

public void setTextColorLink(String value) {
	getBuilder().reset().setTextColorLink(value).execute(true);
}

public Object isTextIsSelectable() {
	return getBuilder().reset().tryGetTextIsSelectable().execute(false).isTextIsSelectable(); 
}
public void setTextIsSelectable(boolean value) {
	getBuilder().reset().setTextIsSelectable(value).execute(true);
}

public Object getTextScaleX() {
	return getBuilder().reset().tryGetTextScaleX().execute(false).getTextScaleX(); 
}
public void setTextScaleX(float value) {
	getBuilder().reset().setTextScaleX(value).execute(true);
}

public Object getWidth() {
	return getBuilder().reset().tryGetWidth().execute(false).getWidth(); 
}
public void setWidth(String value) {
	getBuilder().reset().setWidth(value).execute(true);
}

public Object isShowText() {
	return getBuilder().reset().tryGetShowText().execute(false).isShowText(); 
}
public void setShowText(boolean value) {
	getBuilder().reset().setShowText(value).execute(true);
}

public Object isSplitTrack() {
	return getBuilder().reset().tryGetSplitTrack().execute(false).isSplitTrack(); 
}
public void setSplitTrack(boolean value) {
	getBuilder().reset().setSplitTrack(value).execute(true);
}

public Object getSwitchMinWidth() {
	return getBuilder().reset().tryGetSwitchMinWidth().execute(false).getSwitchMinWidth(); 
}
public void setSwitchMinWidth(String value) {
	getBuilder().reset().setSwitchMinWidth(value).execute(true);
}

public Object getSwitchPadding() {
	return getBuilder().reset().tryGetSwitchPadding().execute(false).getSwitchPadding(); 
}
public void setSwitchPadding(String value) {
	getBuilder().reset().setSwitchPadding(value).execute(true);
}

public Object getTextOff() {
	return getBuilder().reset().tryGetTextOff().execute(false).getTextOff(); 
}
public void setTextOff(String value) {
	getBuilder().reset().setTextOff(value).execute(true);
}

public Object getTextOn() {
	return getBuilder().reset().tryGetTextOn().execute(false).getTextOn(); 
}
public void setTextOn(String value) {
	getBuilder().reset().setTextOn(value).execute(true);
}

public Object getThumb() {
	return getBuilder().reset().tryGetThumb().execute(false).getThumb(); 
}
public void setThumb(String value) {
	getBuilder().reset().setThumb(value).execute(true);
}

public Object getThumbTextPadding() {
	return getBuilder().reset().tryGetThumbTextPadding().execute(false).getThumbTextPadding(); 
}
public void setThumbTextPadding(String value) {
	getBuilder().reset().setThumbTextPadding(value).execute(true);
}

public Object getThumbTint() {
	return getBuilder().reset().tryGetThumbTint().execute(false).getThumbTint(); 
}
public void setThumbTint(String value) {
	getBuilder().reset().setThumbTint(value).execute(true);
}

public Object getThumbTintMode() {
	return getBuilder().reset().tryGetThumbTintMode().execute(false).getThumbTintMode(); 
}
public void setThumbTintMode(ThumbTintMode value) {
	getBuilder().reset().setThumbTintMode(value).execute(true);
}

public Object getTrack() {
	return getBuilder().reset().tryGetTrack().execute(false).getTrack(); 
}
public void setTrack(String value) {
	getBuilder().reset().setTrack(value).execute(true);
}

public Object getTrackTint() {
	return getBuilder().reset().tryGetTrackTint().execute(false).getTrackTint(); 
}
public void setTrackTint(String value) {
	getBuilder().reset().setTrackTint(value).execute(true);
}

public Object getTrackTintMode() {
	return getBuilder().reset().tryGetTrackTintMode().execute(false).getTrackTintMode(); 
}
public void setTrackTintMode(TrackTintMode value) {
	getBuilder().reset().setTrackTintMode(value).execute(true);
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

public void setSwitchTextAppearance(String value) {
	getBuilder().reset().setSwitchTextAppearance(value).execute(true);
}

public Object getText() {
	return getBuilder().reset().tryGetText().execute(false).getText(); 
}
public void setText(String value) {
	getBuilder().reset().setText(value).execute(true);
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

public void setTextAppearance(String value) {
	getBuilder().reset().setTextAppearance(value).execute(true);
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

public void setTextFormat(String value) {
	getBuilder().reset().setTextFormat(value).execute(true);
}

}


    
	//end - body
    private void setChecked(Object objValue) {
        switchCompat.setChecked(PluginInvoker.getBoolean(objValue));
    }
    private Object getChecked() {
        return switchCompat.isChecked();
    }

	
	private void setSwitchTextAppearance(Object objValue) {
		Context context = (Context) fragment.getRootActivity();
		switchCompat.setSwitchTextAppearance(context, (int) objValue);
		
	}
	
	@Override
	public String getTextEntered() {
		return switchCompat.isChecked() ? "checked" : "";
	}
	
	
	private void setOnCheckedChangeListener(androidx.appcompat.widget.SwitchCompat switchCompat, Object objValue) {
		switchCompat.setOnCheckedChangeListener((androidx.appcompat.widget.SwitchCompat.OnCheckedChangeListener)objValue);
	}
	
	
	private void setTrackResource(Object objValue) {
		switchCompat.setTrackDrawable((Drawable) objValue);
	}

	private void setThumbResource(Object objValue) {
		switchCompat.setThumbDrawable((Drawable) objValue);
		
	}
}
