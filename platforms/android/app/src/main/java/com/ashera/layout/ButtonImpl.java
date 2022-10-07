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
public class ButtonImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "Button"; 
	public final static String GROUP_NAME = "Button";

	protected androidx.appcompat.widget.AppCompatButton appCompatButton;
	
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


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("elegantTextHeight").withType("boolean"));
		ConverterFactory.register("Button.ellipsize", new Ellipsize());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ellipsize").withType("Button.ellipsize"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ems").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fallbackLineSpacing").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("firstBaselineToTopHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFeatureSettings").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("height").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("includeFontPadding").withType("boolean"));
		ConverterFactory.register("Button.justificationMode", new JustificationMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("justificationMode").withType("Button.justificationMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lastBaselineToBottomHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("letterSpacing").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingExtra").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingMultiplier").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lines").withType("int"));
		ConverterFactory.register("Button.marqueeRepeatLimit", new MarqueeRepeatLimit());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("marqueeRepeatLimit").withType("Button.marqueeRepeatLimit"));
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
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textScaleX").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("width").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLength").withType("int"));
		ConverterFactory.register("Button.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("Button.font"));
		ConverterFactory.register("Button.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("Button.textStyle"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAppearance").withType("style"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTint").withType("colorstate"));
		ConverterFactory.register("Button.drawableTintMode", new DrawableTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTintMode").withType("Button.drawableTintMode"));
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
	
	public ButtonImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class ButtonExt extends androidx.appcompat.widget.AppCompatButton implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public ButtonExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public ButtonExt(Context context) {
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
				ButtonImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(ButtonImpl.this);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	    ((ButtonExt) appCompatButton).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new ButtonImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		appCompatButton = new ButtonExt(context);
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
			appCompatButton = new ButtonExt(context, null, defStyleAttr);	
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
			case "drawablePadding": {
				


	appCompatButton.setCompoundDrawablePadding((int)objValue);



			}
			break;
			case "elegantTextHeight": {
				
if (Build.VERSION.SDK_INT >= 21) {

	appCompatButton.setElegantTextHeight((boolean)objValue);

}

			}
			break;
			case "ellipsize": {
				

objValue = getFinalValueForEllipsize(objValue);
	appCompatButton.setEllipsize((android.text.TextUtils.TruncateAt)objValue);



			}
			break;
			case "ems": {
				


	appCompatButton.setEms((int)objValue);



			}
			break;
			case "fallbackLineSpacing": {
				
if (Build.VERSION.SDK_INT >= 28) {

	appCompatButton.setFallbackLineSpacing((boolean)objValue);

}

			}
			break;
			case "firstBaselineToTopHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	appCompatButton.setFirstBaselineToTopHeight((int)objValue);

}

			}
			break;
			case "fontFeatureSettings": {
				
if (Build.VERSION.SDK_INT >= 21) {

	appCompatButton.setFontFeatureSettings((String)objValue);

}

			}
			break;
			case "gravity": {
				


	appCompatButton.setGravity((int)objValue);



			}
			break;
			case "height": {
				


	appCompatButton.setHeight((int)objValue);



			}
			break;
			case "includeFontPadding": {
				


	appCompatButton.setIncludeFontPadding((boolean)objValue);



			}
			break;
			case "justificationMode": {
				
if (Build.VERSION.SDK_INT >= 26) {

	appCompatButton.setJustificationMode((int)objValue);

}

			}
			break;
			case "lastBaselineToBottomHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	appCompatButton.setLastBaselineToBottomHeight((int)objValue);

}

			}
			break;
			case "letterSpacing": {
				
if (Build.VERSION.SDK_INT >= 21) {

	appCompatButton.setLetterSpacing((float)objValue);

}

			}
			break;
			case "lineHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	appCompatButton.setLineHeight((int)objValue);

}

			}
			break;
			case "lineSpacingExtra": {
				


		appCompatButton.setLineSpacing((float) objValue,appCompatButton.getLineSpacingMultiplier());



			}
			break;
			case "lineSpacingMultiplier": {
				


		appCompatButton.setLineSpacing(appCompatButton.getLineSpacingExtra(),(float) objValue);



			}
			break;
			case "lines": {
				


	appCompatButton.setLines((int)objValue);



			}
			break;
			case "marqueeRepeatLimit": {
				


	appCompatButton.setMarqueeRepeatLimit((int)objValue);



			}
			break;
			case "maxEms": {
				


	appCompatButton.setMaxEms((int)objValue);



			}
			break;
			case "maxHeight": {
				


	appCompatButton.setMaxHeight((int)objValue);



			}
			break;
			case "maxLines": {
				


	appCompatButton.setMaxLines((int)objValue);



			}
			break;
			case "maxWidth": {
				


	appCompatButton.setMaxWidth((int)objValue);



			}
			break;
			case "minEms": {
				


	appCompatButton.setMinEms((int)objValue);



			}
			break;
			case "minHeight": {
				


	appCompatButton.setMinHeight((int)objValue);



			}
			break;
			case "minLines": {
				


	appCompatButton.setMinLines((int)objValue);



			}
			break;
			case "minWidth": {
				


	appCompatButton.setMinWidth((int)objValue);



			}
			break;
			case "scrollHorizontally": {
				


	appCompatButton.setHorizontallyScrolling((boolean)objValue);



			}
			break;
			case "shadowColor": {
				


		appCompatButton.setShadowLayer(appCompatButton.getShadowRadius(),appCompatButton.getShadowDx(),appCompatButton.getShadowDy(),(int) objValue);



			}
			break;
			case "shadowDx": {
				


		appCompatButton.setShadowLayer(appCompatButton.getShadowRadius(),(float) objValue,appCompatButton.getShadowDy(),appCompatButton.getShadowColor());



			}
			break;
			case "shadowDy": {
				


		appCompatButton.setShadowLayer(appCompatButton.getShadowRadius(),appCompatButton.getShadowDx(),(float) objValue,appCompatButton.getShadowColor());



			}
			break;
			case "shadowRadius": {
				


		appCompatButton.setShadowLayer((float) objValue,appCompatButton.getShadowDx(),appCompatButton.getShadowDy(),appCompatButton.getShadowColor());



			}
			break;
			case "singleLine": {
				


	appCompatButton.setSingleLine((boolean)objValue);



			}
			break;
			case "textAllCaps": {
				
if (Build.VERSION.SDK_INT >= 14) {

	appCompatButton.setAllCaps((boolean)objValue);

}

			}
			break;
			case "textColor": {
				


	appCompatButton.setTextColor((android.content.res.ColorStateList)objValue);



			}
			break;
			case "textScaleX": {
				


	appCompatButton.setTextScaleX((float)objValue);



			}
			break;
			case "width": {
				


	appCompatButton.setWidth((int)objValue);



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
				


		TextViewCompat.setTextAppearance(appCompatButton, (int)objValue);



			}
			break;
			case "enabled": {
				


		 appCompatButton.setEnabled((boolean) objValue);



			}
			break;
			case "editable": {
				


		 appCompatButton.setEnabled((boolean) objValue);



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
			case "drawablePadding": {
return appCompatButton.getCompoundDrawablePadding();				}
			case "elegantTextHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatButton.isElegantTextHeight();
}
break;				}
			case "ellipsize": {
return appCompatButton.getEllipsize();				}
			case "fallbackLineSpacing": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatButton.isFallbackLineSpacing();
}
break;				}
			case "firstBaselineToTopHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatButton.getFirstBaselineToTopHeight();
}
break;				}
			case "fontFeatureSettings": {
if (Build.VERSION.SDK_INT >= 21) {
return appCompatButton.getFontFeatureSettings();
}
break;				}
			case "gravity": {
return appCompatButton.getGravity();				}
			case "height": {
return appCompatButton.getHeight();				}
			case "includeFontPadding": {
return appCompatButton.getIncludeFontPadding();				}
			case "justificationMode": {
if (Build.VERSION.SDK_INT >= 26) {
return appCompatButton.getJustificationMode();
}
break;				}
			case "lastBaselineToBottomHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatButton.getLastBaselineToBottomHeight();
}
break;				}
			case "letterSpacing": {
if (Build.VERSION.SDK_INT >= 21) {
return appCompatButton.getLetterSpacing();
}
break;				}
			case "lineHeight": {
return appCompatButton.getLineHeight();				}
			case "lineSpacingExtra": {
return appCompatButton.getLineSpacingExtra();				}
			case "lineSpacingMultiplier": {
return appCompatButton.getLineSpacingMultiplier();				}
			case "marqueeRepeatLimit": {
return appCompatButton.getMarqueeRepeatLimit();				}
			case "maxEms": {
return appCompatButton.getMaxEms();				}
			case "maxHeight": {
return appCompatButton.getMaxHeight();				}
			case "maxLines": {
return appCompatButton.getMaxLines();				}
			case "maxWidth": {
return appCompatButton.getMaxWidth();				}
			case "minEms": {
return appCompatButton.getMinEms();				}
			case "minHeight": {
return appCompatButton.getMinHeight();				}
			case "minLines": {
return appCompatButton.getMinLines();				}
			case "minWidth": {
return appCompatButton.getMinWidth();				}
			case "shadowColor": {
return appCompatButton.getShadowColor();				}
			case "shadowDx": {
return appCompatButton.getShadowDx();				}
			case "shadowDy": {
return appCompatButton.getShadowDy();				}
			case "shadowRadius": {
return appCompatButton.getShadowRadius();				}
			case "textAllCaps": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatButton.isAllCaps();
}
break;				}
			case "textColor": {
return appCompatButton.getTextColors();				}
			case "textScaleX": {
return appCompatButton.getTextScaleX();				}
			case "width": {
return appCompatButton.getWidth();				}
			case "text": {
return getMyText();				}
			case "textSize": {
return appCompatButton.getTextSize();				}
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
		return appCompatButton;
	}

	


	private String getMyText() {
	    if (appCompatButton.getText() != null) {
	        return appCompatButton.getText().toString();
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
		return appCompatButton;
	}
	public void setMyText(Object text) {
		if (html) {
			appCompatButton.setText((SpannableString) com.ashera.parser.html.Html.fromHtml((String) text, null, fragment).get());	
		} else {
			appCompatButton.setText((String) text);	
		}
	}
	//start - textsize
	private void setMyTextSize(Object objValue) {
		appCompatButton.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, getFragment().getRootActivity().getScaleFactor() * (float)objValue);		
	}
	//end - textsize
	
	//start - drawable
	private void setDrawableLeft(Object objValue) {
		android.graphics.drawable.Drawable[] drawables = appCompatButton.getCompoundDrawables();
		setBoundsOfDrawable(objValue);
		TextViewCompat.setCompoundDrawablesRelative(appCompatButton, (android.graphics.drawable.Drawable) objValue, drawables[1], drawables[2], drawables[3]);		
	}

	private void setBoundsOfDrawable(Object objValue) {
		android.graphics.drawable.Drawable image = (android.graphics.drawable.Drawable) objValue;
		int h = image.getIntrinsicHeight();
		int w = image.getIntrinsicWidth();
		image.setBounds( 0, 0, w, h);
	}
	
	private void setDrawableRight(Object objValue) {
		android.graphics.drawable.Drawable[] drawables = appCompatButton.getCompoundDrawables();
		setBoundsOfDrawable(objValue);
		TextViewCompat.setCompoundDrawablesRelative(appCompatButton, drawables[0], drawables[1], (android.graphics.drawable.Drawable) objValue, drawables[3]);
		
	}
	private void setDrawableTop(Object objValue) {
		setBoundsOfDrawable(objValue);
		android.graphics.drawable.Drawable[] drawables = appCompatButton.getCompoundDrawables();
		TextViewCompat.setCompoundDrawablesRelative(appCompatButton, drawables[0], (android.graphics.drawable.Drawable) objValue, drawables[2], drawables[3]);
		
	}
	
	private void setDrawableBottom(Object objValue) {
		setBoundsOfDrawable(objValue);
		android.graphics.drawable.Drawable[] drawables = appCompatButton.getCompoundDrawables();
		TextViewCompat.setCompoundDrawablesRelative(appCompatButton, drawables[0], drawables[1], drawables[2], (android.graphics.drawable.Drawable) objValue);
		
	}
	
	private android.graphics.drawable.Drawable tintDrawableCompat;
	private void setDrawableTintMode(Object objValue) {
		if (Build.VERSION.SDK_INT >= 23) {
			appCompatButton.setCompoundDrawableTintMode((android.graphics.PorterDuff.Mode) objValue);
		} else {
			android.graphics.drawable.Drawable[] drawables = appCompatButton.getCompoundDrawablesRelative();
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
						appCompatButton.invalidate();
					}
				}
			}
		}
	}

	private void setDrawableTintList(Object objValue) {
		if (Build.VERSION.SDK_INT >= 23) {
			appCompatButton.setCompoundDrawableTintList((android.content.res.ColorStateList) objValue);
		} else {
			android.graphics.drawable.Drawable[] drawables = appCompatButton.getCompoundDrawablesRelative();
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
						appCompatButton.invalidate();
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
		android.graphics.Typeface typeface  = appCompatButton.getTypeface();
		if (typeface == null) {
			typeface = android.graphics.Typeface.DEFAULT;
		} else {
			typeface = android.graphics.Typeface.create(typeface, (int) objValue);
        }
		
		appCompatButton.setTypeface(typeface, (int) objValue);
	}

	private void setTypeFace(Object objValue, String strValue) {
		if (objValue instanceof Integer) {
			objValue = PluginInvoker.convertFrom(ConverterFactory.get(CommonConverters.font), null, strValue, fragment);
		}
		android.graphics.Typeface typeface = appCompatButton.getTypeface();
		if (typeface != null) {
			appCompatButton.setTypeface((android.graphics.Typeface) objValue, typeface.getStyle());
		} else {
			appCompatButton.setTypeface((android.graphics.Typeface) objValue);
		}
	}
	//end - font
	
	private void setMaxLength(Object objValue) {
		int maxlength = (int) objValue;
		removeMaxLengthFilter();
		if (maxlength >= 0) {
			android.text.InputFilter[] filtersArr = appCompatButton.getFilters();
			List<android.text.InputFilter> filters = new java.util.ArrayList<>(java.util.Arrays.asList(filtersArr));			
			filters.add(new android.text.InputFilter.LengthFilter(maxlength));
			appCompatButton.setFilters(filters.toArray(new android.text.InputFilter[0]));
        }
		
	}
	
	private void removeMaxLengthFilter() {
		android.text.InputFilter[] filtersArr = appCompatButton.getFilters();
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
		appCompatButton.setFilters(filters.toArray(new android.text.InputFilter[0]));
	}


	
	private void setPasswordType(Object objValue) {
		if (objValue != null && (boolean) objValue) {
			appCompatButton.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
			appCompatButton.setTypeface(android.graphics.Typeface.MONOSPACE);
		} else {
			appCompatButton.setTransformationMethod(null);
			appCompatButton.setTypeface(null);
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
        appCompatButton.setKeyListener(android.text.method.TextKeyListener.getInstance(autotext, cap));
        appCompatButton.setInputType(inputType);
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
			setAutoSizeTextTypeInternal( getAutoSizeTextType(appCompatButton));
		}
	}

	private void setAutoMinTextSize(Object objValue) {
		autoSizeMin = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(appCompatButton));
		}
	}

	private void setAutoMaxTextSize(Object objValue) {
		autoSizeMax = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(appCompatButton));
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
		return getAutoSizeTextType(appCompatButton);
	}
	//end - autosize

	private int getAutoSizeTextType(TextView appCompatButton) {
		return TextViewCompat.getAutoSizeTextType(appCompatButton);
	}

	private void setAutoSizeTextTypeInternal(int autoTextType) {
		TextViewCompat.setAutoSizeTextTypeWithDefaults(appCompatButton, autoTextType);
		
		if (autoTextType == 1) {
			int autoSizeMinTextSize = autoSizeMin == -1 ? TextViewCompat.getAutoSizeMinTextSize(appCompatButton) : autoSizeMin;
			int autoSizeMaxTextSize = autoSizeMax == -1 ? TextViewCompat.getAutoSizeMaxTextSize(appCompatButton) : autoSizeMax;
			int autoSizeStepGranularity = autoSizeGranular == -1 ? TextViewCompat.getAutoSizeStepGranularity(appCompatButton) : autoSizeGranular;
			TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(appCompatButton, 
					autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, 
					android.util.TypedValue.COMPLEX_UNIT_PX);
        }
	}
	
	   
    private void setLinksClickable(Object objValue) {
        if (objValue != null && (boolean) objValue) {
            appCompatButton.setLinksClickable(true);
            
            if (isInitialised()) {
                appCompatButton.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());    
            }
        } else {
            appCompatButton.setLinksClickable(false);
            
            if (isInitialised()) {
                if (appCompatButton.getMovementMethod() instanceof android.text.method.LinkMovementMethod) {
                    appCompatButton.setMovementMethod(null);
                }    
            }
        }
    }

	
	private void startOrStopMarquee(Object objValue) {
		appCompatButton.setSelected((boolean) objValue); 
		
	}

	
	private void setTextAligmentHack(Object objValue) {
		if (isInitialised()) {
			setFieldUsingReflection(appCompatButton, "mLayout", null);
		}
	}
	

	private void resetText() {
		if (isInitialised()) {
			appCompatButton.setText(appCompatButton.getText());
		}
	}
	

	
	private Object getFinalValueForEllipsize(Object objValue) {
		if ("@null".equals(objValue)) {
			return null;
		}
		
		if (objValue == android.text.TextUtils.TruncateAt.MARQUEE) {
			appCompatButton.setSelected(true); 
		}
		return objValue;
	}	

	private void setAutoSizePresetSizes(Object objValue) {
		TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(appCompatButton, (int[]) objValue, android.util.TypedValue.COMPLEX_UNIT_PX);
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
			List<IListener> listeners = (List<IListener>)getFieldValueUsingReflection(appCompatButton, "mListeners");
			if (listeners != null) {
				for (IListener listener : listeners) {
					if (action.equals(listener.getAction())) {
						appCompatButton.removeTextChangedListener((TextWatcher) listener);
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
			appCompatButton.setId(IdGenerator.getId(id));
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
    
	
private ButtonCommandBuilder builder;
private ButtonBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ButtonBean getBean() {
	if (bean == null) {
		bean = new ButtonBean();
	}
	return bean;
}
public ButtonCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ButtonCommandBuilder();
	}
	return builder;
}


public  class ButtonCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <ButtonCommandBuilder> {
    public ButtonCommandBuilder() {
	}
	
	public ButtonCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ButtonCommandBuilder tryGetDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setDrawablePadding(String value) {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetElegantTextHeight() {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isElegantTextHeight() {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setElegantTextHeight(boolean value) {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetEllipsize() {
	Map<String, Object> attrs = initCommand("ellipsize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getEllipsize() {
	Map<String, Object> attrs = initCommand("ellipsize");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setEllipsize(Ellipsize value) {
	Map<String, Object> attrs = initCommand("ellipsize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setEms(int value) {
	Map<String, Object> attrs = initCommand("ems");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetFallbackLineSpacing() {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isFallbackLineSpacing() {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setFallbackLineSpacing(boolean value) {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setFirstBaselineToTopHeight(String value) {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetFontFeatureSettings() {
	Map<String, Object> attrs = initCommand("fontFeatureSettings");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getFontFeatureSettings() {
	Map<String, Object> attrs = initCommand("fontFeatureSettings");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setFontFeatureSettings(String value) {
	Map<String, Object> attrs = initCommand("fontFeatureSettings");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetHeight() {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHeight() {
	Map<String, Object> attrs = initCommand("height");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setHeight(String value) {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetIncludeFontPadding() {
	Map<String, Object> attrs = initCommand("includeFontPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIncludeFontPadding() {
	Map<String, Object> attrs = initCommand("includeFontPadding");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setIncludeFontPadding(boolean value) {
	Map<String, Object> attrs = initCommand("includeFontPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getJustificationMode() {
	Map<String, Object> attrs = initCommand("justificationMode");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setJustificationMode(String value) {
	Map<String, Object> attrs = initCommand("justificationMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setLastBaselineToBottomHeight(String value) {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetLetterSpacing() {
	Map<String, Object> attrs = initCommand("letterSpacing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLetterSpacing() {
	Map<String, Object> attrs = initCommand("letterSpacing");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setLetterSpacing(float value) {
	Map<String, Object> attrs = initCommand("letterSpacing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetLineHeight() {
	Map<String, Object> attrs = initCommand("lineHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineHeight() {
	Map<String, Object> attrs = initCommand("lineHeight");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setLineHeight(String value) {
	Map<String, Object> attrs = initCommand("lineHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetLineSpacingExtra() {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineSpacingExtra() {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setLineSpacingExtra(String value) {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetLineSpacingMultiplier() {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineSpacingMultiplier() {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setLineSpacingMultiplier(float value) {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setLines(int value) {
	Map<String, Object> attrs = initCommand("lines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMarqueeRepeatLimit() {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMarqueeRepeatLimit() {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMarqueeRepeatLimit(String value) {
	Map<String, Object> attrs = initCommand("marqueeRepeatLimit");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMaxEms(int value) {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMaxLines(int value) {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMinEms(int value) {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMinHeight(String value) {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMinLines(int value) {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setMinWidth(String value) {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setScrollHorizontally(boolean value) {
	Map<String, Object> attrs = initCommand("scrollHorizontally");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetShadowColor() {
	Map<String, Object> attrs = initCommand("shadowColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowColor() {
	Map<String, Object> attrs = initCommand("shadowColor");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setShadowColor(String value) {
	Map<String, Object> attrs = initCommand("shadowColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetShadowDx() {
	Map<String, Object> attrs = initCommand("shadowDx");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowDx() {
	Map<String, Object> attrs = initCommand("shadowDx");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setShadowDx(float value) {
	Map<String, Object> attrs = initCommand("shadowDx");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetShadowDy() {
	Map<String, Object> attrs = initCommand("shadowDy");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowDy() {
	Map<String, Object> attrs = initCommand("shadowDy");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setShadowDy(float value) {
	Map<String, Object> attrs = initCommand("shadowDy");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetShadowRadius() {
	Map<String, Object> attrs = initCommand("shadowRadius");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowRadius() {
	Map<String, Object> attrs = initCommand("shadowRadius");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setShadowRadius(float value) {
	Map<String, Object> attrs = initCommand("shadowRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setSingleLine(boolean value) {
	Map<String, Object> attrs = initCommand("singleLine");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetTextAllCaps() {
	Map<String, Object> attrs = initCommand("textAllCaps");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isTextAllCaps() {
	Map<String, Object> attrs = initCommand("textAllCaps");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setTextAllCaps(boolean value) {
	Map<String, Object> attrs = initCommand("textAllCaps");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetTextScaleX() {
	Map<String, Object> attrs = initCommand("textScaleX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextScaleX() {
	Map<String, Object> attrs = initCommand("textScaleX");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setTextScaleX(float value) {
	Map<String, Object> attrs = initCommand("textScaleX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetWidth() {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getWidth() {
	Map<String, Object> attrs = initCommand("width");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setWidth(String value) {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetText() {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getText() {
	Map<String, Object> attrs = initCommand("text");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setText(String value) {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setDrawableStart(String value) {
	Map<String, Object> attrs = initCommand("drawableStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setDrawableRight(String value) {
	Map<String, Object> attrs = initCommand("drawableRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setDrawableEnd(String value) {
	Map<String, Object> attrs = initCommand("drawableEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setDrawableTop(String value) {
	Map<String, Object> attrs = initCommand("drawableTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setDrawableBottom(String value) {
	Map<String, Object> attrs = initCommand("drawableBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setMaxLength(int value) {
	Map<String, Object> attrs = initCommand("maxLength");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setTypeface(String value) {
	Map<String, Object> attrs = initCommand("typeface");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setTextStyle(String value) {
	Map<String, Object> attrs = initCommand("textStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setFontFamily(String value) {
	Map<String, Object> attrs = initCommand("fontFamily");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setTextAppearance(String value) {
	Map<String, Object> attrs = initCommand("textAppearance");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setEditable(boolean value) {
	Map<String, Object> attrs = initCommand("editable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setDrawableTint(String value) {
	Map<String, Object> attrs = initCommand("drawableTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setDrawableTintMode(DrawableTintMode value) {
	Map<String, Object> attrs = initCommand("drawableTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public ButtonCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ButtonCommandBuilder setTextFormat(String value) {
	Map<String, Object> attrs = initCommand("textFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ButtonBean extends com.ashera.layout.ViewImpl.ViewBean{
		public ButtonBean() {
			super(ButtonImpl.this);
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
}
