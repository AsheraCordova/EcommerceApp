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
public class EditTextImpl extends BaseWidget implements com.ashera.validations.FormElement{
	//start - body
	public final static String LOCAL_NAME = "EditText"; 
	public final static String GROUP_NAME = "EditText";

	protected androidx.appcompat.widget.AppCompatEditText appCompatEditText;
	
		@SuppressLint("NewApi")
		final static class ImeOptions  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("actionDone", 0x6);
				mapping.put("actionGo", 0x2);
				mapping.put("actionNext", 0x5);
				mapping.put("actionNone", 0x1);
				mapping.put("actionPrevious", 0x7);
				mapping.put("actionSearch", 0x3);
				mapping.put("actionSend", 0x4);
				mapping.put("actionUnspecified", 0x0);
				mapping.put("flagForceAscii", 0x80000000);
				mapping.put("flagNavigateNext", 0x8000000);
				mapping.put("flagNavigatePrevious", 0x4000000);
				mapping.put("flagNoAccessoryAction", 0x20000000);
				mapping.put("flagNoEnterAction", 0x40000000);
				mapping.put("flagNoExtractUi", 0x10000000);
				mapping.put("flagNoFullscreen", 0x2000000);
				mapping.put("flagNoPersonalizedLearning", 0x1000000);
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
		final static class InputType  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("date", 0x14);
				mapping.put("datetime", 0x4);
				mapping.put("none", 0x0);
				mapping.put("number", 0x2);
				mapping.put("numberDecimal", 0x2002);
				mapping.put("numberPassword", 0x12);
				mapping.put("numberSigned", 0x1002);
				mapping.put("phone", 0x3);
				mapping.put("text", 0x1);
				mapping.put("textAutoComplete", 0x10001);
				mapping.put("textAutoCorrect", 0x8001);
				mapping.put("textCapCharacters", 0x1001);
				mapping.put("textCapSentences", 0x4001);
				mapping.put("textCapWords", 0x2001);
				mapping.put("textEmailAddress", 0x21);
				mapping.put("textEmailSubject", 0x31);
				mapping.put("textFilter", 0xb1);
				mapping.put("textImeMultiLine", 0x40001);
				mapping.put("textLongMessage", 0x51);
				mapping.put("textMultiLine", 0x20001);
				mapping.put("textNoSuggestions", 0x80001);
				mapping.put("textPassword", 0x81);
				mapping.put("textPersonName", 0x61);
				mapping.put("textPhonetic", 0xc1);
				mapping.put("textPostalAddress", 0x71);
				mapping.put("textShortMessage", 0x41);
				mapping.put("textUri", 0x11);
				mapping.put("textVisiblePassword", 0x91);
				mapping.put("textWebEditText", 0xa1);
				mapping.put("textWebEmailAddress", 0xd1);
				mapping.put("textWebPassword", 0xe1);
				mapping.put("time", 0x24);
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
		final static class Capitalize extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("characters",  0x3);
				mapping.put("none",  0x0);
				mapping.put("sentences",  0x1);
				mapping.put("words",  0x2);
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
		final static class Numeric  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("decimal", 0x5);
				mapping.put("integer", 0x1);
				mapping.put("signed", 0x3);
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


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("cursorVisible").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawablePadding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("elegantTextHeight").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ems").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fallbackLineSpacing").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("firstBaselineToTopHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("freezesText").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("height").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hint").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imeActionId").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imeActionLabel").withType("resourcestring"));
		ConverterFactory.register("EditText.imeOptions", new ImeOptions());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imeOptions").withType("EditText.imeOptions"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("includeFontPadding").withType("boolean"));
		ConverterFactory.register("EditText.inputType", new InputType());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("inputType").withType("EditText.inputType"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lastBaselineToBottomHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("letterSpacing").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingExtra").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lineSpacingMultiplier").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("lines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxEms").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minEms").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minLines").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("privateImeOptions").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollHorizontally").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selectAllOnFocus").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowDx").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowDy").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("shadowRadius").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("singleLine").withType("boolean").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColor").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorHighlight").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textColorHint").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textIsSelectable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textScaleX").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("width").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onafterTextChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onbeforeTextChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onTextChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onEditorAction").withType("String"));
		ConverterFactory.register("EditText.capitalize", new Capitalize());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("capitalize").withType("EditText.capitalize"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("phoneNumber").withType("boolean"));
		ConverterFactory.register("EditText.numeric", new Numeric());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("numeric").withType("EditText.numeric"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("digits").withType("string").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editorExtras").withType("xmlresource"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autoText").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAllCaps").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selectAll").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hintTextFormat").withType("resourcestring").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("text").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textSize").withType("dimensionsp"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableLeft").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableStart").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableRight").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableEnd").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTop").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableBottom").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxLength").withType("int"));
		ConverterFactory.register("EditText.font", new Font());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("typeface").withType("EditText.font"));
		ConverterFactory.register("EditText.textStyle", new TextStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textStyle").withType("EditText.textStyle"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fontFamily").withType("font"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAppearance").withType("style"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("password").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("editable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTint").withType("colorstate"));
		ConverterFactory.register("EditText.drawableTintMode", new DrawableTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("drawableTintMode").withType("EditText.drawableTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("html").withType("boolean"));
	}
	
	public EditTextImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class EditTextExt extends androidx.appcompat.widget.AppCompatEditText implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public EditTextExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public EditTextExt(Context context) {
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
				EditTextImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(EditTextImpl.this);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	    ((EditTextExt) appCompatEditText).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new EditTextImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		appCompatEditText = new EditTextExt(context);
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
			appCompatEditText = new EditTextExt(context, null, defStyleAttr);	
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
			case "cursorVisible": {
				


	appCompatEditText.setCursorVisible((boolean)objValue);



			}
			break;
			case "drawablePadding": {
				


	appCompatEditText.setCompoundDrawablePadding((int)objValue);



			}
			break;
			case "elegantTextHeight": {
				
if (Build.VERSION.SDK_INT >= 21) {

	appCompatEditText.setElegantTextHeight((boolean)objValue);

}

			}
			break;
			case "ems": {
				


	appCompatEditText.setEms((int)objValue);



			}
			break;
			case "fallbackLineSpacing": {
				
if (Build.VERSION.SDK_INT >= 28) {

	appCompatEditText.setFallbackLineSpacing((boolean)objValue);

}

			}
			break;
			case "firstBaselineToTopHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	appCompatEditText.setFirstBaselineToTopHeight((int)objValue);

}

			}
			break;
			case "freezesText": {
				


	appCompatEditText.setFreezesText((boolean)objValue);



			}
			break;
			case "gravity": {
				


	appCompatEditText.setGravity((int)objValue);



			}
			break;
			case "height": {
				


	appCompatEditText.setHeight((int)objValue);



			}
			break;
			case "hint": {
				


	appCompatEditText.setHint((String)objValue);



			}
			break;
			case "imeActionId": {
				


		appCompatEditText.setImeActionLabel(appCompatEditText.getImeActionLabel(),(int) objValue);



			}
			break;
			case "imeActionLabel": {
				


		appCompatEditText.setImeActionLabel((CharSequence) objValue,appCompatEditText.getImeActionId());



			}
			break;
			case "imeOptions": {
				


	appCompatEditText.setImeOptions((int)objValue);



			}
			break;
			case "includeFontPadding": {
				


	appCompatEditText.setIncludeFontPadding((boolean)objValue);



			}
			break;
			case "inputType": {
				


	appCompatEditText.setRawInputType((int)objValue);



			}
			break;
			case "lastBaselineToBottomHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	appCompatEditText.setLastBaselineToBottomHeight((int)objValue);

}

			}
			break;
			case "letterSpacing": {
				
if (Build.VERSION.SDK_INT >= 21) {

	appCompatEditText.setLetterSpacing((float)objValue);

}

			}
			break;
			case "lineHeight": {
				
if (Build.VERSION.SDK_INT >= 28) {

	appCompatEditText.setLineHeight((int)objValue);

}

			}
			break;
			case "lineSpacingExtra": {
				


		appCompatEditText.setLineSpacing((float) objValue,appCompatEditText.getLineSpacingMultiplier());



			}
			break;
			case "lineSpacingMultiplier": {
				


		appCompatEditText.setLineSpacing(appCompatEditText.getLineSpacingExtra(),(float) objValue);



			}
			break;
			case "lines": {
				


	appCompatEditText.setLines((int)objValue);



			}
			break;
			case "maxEms": {
				


	appCompatEditText.setMaxEms((int)objValue);



			}
			break;
			case "maxHeight": {
				


	appCompatEditText.setMaxHeight((int)objValue);



			}
			break;
			case "maxLines": {
				


	appCompatEditText.setMaxLines((int)objValue);



			}
			break;
			case "maxWidth": {
				


	appCompatEditText.setMaxWidth((int)objValue);



			}
			break;
			case "minEms": {
				


	appCompatEditText.setMinEms((int)objValue);



			}
			break;
			case "minHeight": {
				


	appCompatEditText.setMinHeight((int)objValue);



			}
			break;
			case "minLines": {
				


	appCompatEditText.setMinLines((int)objValue);



			}
			break;
			case "minWidth": {
				


	appCompatEditText.setMinWidth((int)objValue);



			}
			break;
			case "privateImeOptions": {
				


	appCompatEditText.setPrivateImeOptions((String)objValue);



			}
			break;
			case "scrollHorizontally": {
				


	appCompatEditText.setHorizontallyScrolling((boolean)objValue);



			}
			break;
			case "selectAllOnFocus": {
				


	appCompatEditText.setSelectAllOnFocus((boolean)objValue);



			}
			break;
			case "shadowColor": {
				


		appCompatEditText.setShadowLayer(appCompatEditText.getShadowRadius(),appCompatEditText.getShadowDx(),appCompatEditText.getShadowDy(),(int) objValue);



			}
			break;
			case "shadowDx": {
				


		appCompatEditText.setShadowLayer(appCompatEditText.getShadowRadius(),(float) objValue,appCompatEditText.getShadowDy(),appCompatEditText.getShadowColor());



			}
			break;
			case "shadowDy": {
				


		appCompatEditText.setShadowLayer(appCompatEditText.getShadowRadius(),appCompatEditText.getShadowDx(),(float) objValue,appCompatEditText.getShadowColor());



			}
			break;
			case "shadowRadius": {
				


		appCompatEditText.setShadowLayer((float) objValue,appCompatEditText.getShadowDx(),appCompatEditText.getShadowDy(),appCompatEditText.getShadowColor());



			}
			break;
			case "singleLine": {
				


	appCompatEditText.setSingleLine((boolean)objValue);



			}
			break;
			case "textColor": {
				


	appCompatEditText.setTextColor((android.content.res.ColorStateList)objValue);



			}
			break;
			case "textColorHighlight": {
				


	appCompatEditText.setHighlightColor((int)objValue);



			}
			break;
			case "textColorHint": {
				


	appCompatEditText.setHintTextColor((android.content.res.ColorStateList)objValue);



			}
			break;
			case "textIsSelectable": {
				
if (Build.VERSION.SDK_INT >= 11) {

	appCompatEditText.setTextIsSelectable((boolean)objValue);

}

			}
			break;
			case "textScaleX": {
				


	appCompatEditText.setTextScaleX((float)objValue);



			}
			break;
			case "width": {
				


	appCompatEditText.setWidth((int)objValue);



			}
			break;
			case "onafterTextChange": {
				


		removeaddTextChangedListenerIfNeeded("onafterTextChange");if (objValue instanceof String) {appCompatEditText.addTextChangedListener(new TextChangedListener(this, strValue, "onafterTextChange"));} else {addTextChangedListener(appCompatEditText, objValue);}



			}
			break;
			case "onbeforeTextChange": {
				


		removeaddTextChangedListenerIfNeeded("onbeforeTextChange");if (objValue instanceof String) {appCompatEditText.addTextChangedListener(new TextChangedListener(this, strValue, "onbeforeTextChange"));} else {addTextChangedListener(appCompatEditText, objValue);}



			}
			break;
			case "onTextChange": {
				


		removeaddTextChangedListenerIfNeeded("onTextChange");if (objValue instanceof String) {appCompatEditText.addTextChangedListener(new TextChangedListener(this, strValue, "onTextChange"));} else {addTextChangedListener(appCompatEditText, objValue);}



			}
			break;
			case "onEditorAction": {
				


		if (objValue instanceof String) {appCompatEditText.setOnEditorActionListener(new OnEditorActionListener(this, strValue));} else {setOnEditorActionListener(appCompatEditText, objValue);}



			}
			break;
			case "capitalize": {
				


		setCapitalize(objValue);



			}
			break;
			case "phoneNumber": {
				


		setPhoneNumber(objValue);



			}
			break;
			case "numeric": {
				


		setNumeric(objValue);



			}
			break;
			case "digits": {
				


		setDigits(objValue);



			}
			break;
			case "editorExtras": {
				


		setEditorExtras(objValue);



			}
			break;
			case "autoText": {
				


		setAutoText(objValue);



			}
			break;
			case "textAllCaps": {
				


		setTextAllCaps(objValue);



			}
			break;
			case "selectAll": {
				


		selectAll(objValue);



			}
			break;
			case "hintTextFormat": {
				


		setHintTextFormat(objValue);



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
				


		TextViewCompat.setTextAppearance(appCompatEditText, (int)objValue);



			}
			break;
			case "password": {
				


		setPasswordType(objValue);



			}
			break;
			case "enabled": {
				


		 appCompatEditText.setEnabled((boolean) objValue);



			}
			break;
			case "editable": {
				


		 appCompatEditText.setEnabled((boolean) objValue);



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
			case "cursorVisible": {
return appCompatEditText.isCursorVisible();				}
			case "drawablePadding": {
return appCompatEditText.getCompoundDrawablePadding();				}
			case "elegantTextHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatEditText.isElegantTextHeight();
}
break;				}
			case "fallbackLineSpacing": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatEditText.isFallbackLineSpacing();
}
break;				}
			case "firstBaselineToTopHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatEditText.getFirstBaselineToTopHeight();
}
break;				}
			case "freezesText": {
return appCompatEditText.getFreezesText();				}
			case "gravity": {
return appCompatEditText.getGravity();				}
			case "height": {
return appCompatEditText.getHeight();				}
			case "hint": {
return appCompatEditText.getHint();				}
			case "imeOptions": {
return appCompatEditText.getImeOptions();				}
			case "includeFontPadding": {
return appCompatEditText.getIncludeFontPadding();				}
			case "lastBaselineToBottomHeight": {
if (Build.VERSION.SDK_INT >= 28) {
return appCompatEditText.getLastBaselineToBottomHeight();
}
break;				}
			case "letterSpacing": {
if (Build.VERSION.SDK_INT >= 21) {
return appCompatEditText.getLetterSpacing();
}
break;				}
			case "lineHeight": {
return appCompatEditText.getLineHeight();				}
			case "lineSpacingExtra": {
return appCompatEditText.getLineSpacingExtra();				}
			case "lineSpacingMultiplier": {
return appCompatEditText.getLineSpacingMultiplier();				}
			case "maxEms": {
return appCompatEditText.getMaxEms();				}
			case "maxHeight": {
return appCompatEditText.getMaxHeight();				}
			case "maxLines": {
return appCompatEditText.getMaxLines();				}
			case "maxWidth": {
return appCompatEditText.getMaxWidth();				}
			case "minEms": {
return appCompatEditText.getMinEms();				}
			case "minHeight": {
return appCompatEditText.getMinHeight();				}
			case "minLines": {
return appCompatEditText.getMinLines();				}
			case "minWidth": {
return appCompatEditText.getMinWidth();				}
			case "privateImeOptions": {
return appCompatEditText.getPrivateImeOptions();				}
			case "shadowColor": {
return appCompatEditText.getShadowColor();				}
			case "shadowDx": {
return appCompatEditText.getShadowDx();				}
			case "shadowDy": {
return appCompatEditText.getShadowDy();				}
			case "shadowRadius": {
return appCompatEditText.getShadowRadius();				}
			case "textColor": {
return appCompatEditText.getTextColors();				}
			case "textColorHighlight": {
if (Build.VERSION.SDK_INT >= 16) {
return appCompatEditText.getHighlightColor();
}
break;				}
			case "textIsSelectable": {
return appCompatEditText.isTextSelectable();				}
			case "textScaleX": {
return appCompatEditText.getTextScaleX();				}
			case "width": {
return appCompatEditText.getWidth();				}
			case "text": {
return getMyText();				}
			case "textSize": {
return appCompatEditText.getTextSize();				}
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
		return appCompatEditText;
	}

	


	private String getMyText() {
	    if (appCompatEditText.getText() != null) {
	        return appCompatEditText.getText().toString();
	    }
	    return "";
    }

	private boolean html;
	private void nativeCreate(Map<String, Object> params) {
		registerForAttributeCommandChain("text", "hint");
		if (params.containsKey("html")) {
			html = params.get("html").equals("true");
		}
	}

	@Override
	public java.lang.Object asNativeWidget() {
		return appCompatEditText;
	}
	public void setMyText(Object text) {
		if (html) {
			appCompatEditText.setText((SpannableString) com.ashera.parser.html.Html.fromHtml((String) text, null, fragment).get());	
		} else {
			appCompatEditText.setText((String) text);	
		}
	}
	//start - textsize
	private void setMyTextSize(Object objValue) {
		appCompatEditText.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, getFragment().getRootActivity().getScaleFactor() * (float)objValue);		
	}
	//end - textsize
	
	//start - drawable
	private void setDrawableLeft(Object objValue) {
		android.graphics.drawable.Drawable[] drawables = appCompatEditText.getCompoundDrawables();
		setBoundsOfDrawable(objValue);
		TextViewCompat.setCompoundDrawablesRelative(appCompatEditText, (android.graphics.drawable.Drawable) objValue, drawables[1], drawables[2], drawables[3]);		
	}

	private void setBoundsOfDrawable(Object objValue) {
		android.graphics.drawable.Drawable image = (android.graphics.drawable.Drawable) objValue;
		int h = image.getIntrinsicHeight();
		int w = image.getIntrinsicWidth();
		image.setBounds( 0, 0, w, h);
	}
	
	private void setDrawableRight(Object objValue) {
		android.graphics.drawable.Drawable[] drawables = appCompatEditText.getCompoundDrawables();
		setBoundsOfDrawable(objValue);
		TextViewCompat.setCompoundDrawablesRelative(appCompatEditText, drawables[0], drawables[1], (android.graphics.drawable.Drawable) objValue, drawables[3]);
		
	}
	private void setDrawableTop(Object objValue) {
		setBoundsOfDrawable(objValue);
		android.graphics.drawable.Drawable[] drawables = appCompatEditText.getCompoundDrawables();
		TextViewCompat.setCompoundDrawablesRelative(appCompatEditText, drawables[0], (android.graphics.drawable.Drawable) objValue, drawables[2], drawables[3]);
		
	}
	
	private void setDrawableBottom(Object objValue) {
		setBoundsOfDrawable(objValue);
		android.graphics.drawable.Drawable[] drawables = appCompatEditText.getCompoundDrawables();
		TextViewCompat.setCompoundDrawablesRelative(appCompatEditText, drawables[0], drawables[1], drawables[2], (android.graphics.drawable.Drawable) objValue);
		
	}
	
	private android.graphics.drawable.Drawable tintDrawableCompat;
	private void setDrawableTintMode(Object objValue) {
		if (Build.VERSION.SDK_INT >= 23) {
			appCompatEditText.setCompoundDrawableTintMode((android.graphics.PorterDuff.Mode) objValue);
		} else {
			android.graphics.drawable.Drawable[] drawables = appCompatEditText.getCompoundDrawablesRelative();
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
						appCompatEditText.invalidate();
					}
				}
			}
		}
	}

	private void setDrawableTintList(Object objValue) {
		if (Build.VERSION.SDK_INT >= 23) {
			appCompatEditText.setCompoundDrawableTintList((android.content.res.ColorStateList) objValue);
		} else {
			android.graphics.drawable.Drawable[] drawables = appCompatEditText.getCompoundDrawablesRelative();
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
						appCompatEditText.invalidate();
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
		android.graphics.Typeface typeface  = appCompatEditText.getTypeface();
		if (typeface == null) {
			typeface = android.graphics.Typeface.DEFAULT;
		} else {
			typeface = android.graphics.Typeface.create(typeface, (int) objValue);
        }
		
		appCompatEditText.setTypeface(typeface, (int) objValue);
	}

	private void setTypeFace(Object objValue, String strValue) {
		if (objValue instanceof Integer) {
			objValue = PluginInvoker.convertFrom(ConverterFactory.get(CommonConverters.font), null, strValue, fragment);
		}
		android.graphics.Typeface typeface = appCompatEditText.getTypeface();
		if (typeface != null) {
			appCompatEditText.setTypeface((android.graphics.Typeface) objValue, typeface.getStyle());
		} else {
			appCompatEditText.setTypeface((android.graphics.Typeface) objValue);
		}
	}
	//end - font
	
	private void setMaxLength(Object objValue) {
		int maxlength = (int) objValue;
		removeMaxLengthFilter();
		if (maxlength >= 0) {
			android.text.InputFilter[] filtersArr = appCompatEditText.getFilters();
			List<android.text.InputFilter> filters = new java.util.ArrayList<>(java.util.Arrays.asList(filtersArr));			
			filters.add(new android.text.InputFilter.LengthFilter(maxlength));
			appCompatEditText.setFilters(filters.toArray(new android.text.InputFilter[0]));
        }
		
	}
	
	private void removeMaxLengthFilter() {
		android.text.InputFilter[] filtersArr = appCompatEditText.getFilters();
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
		appCompatEditText.setFilters(filters.toArray(new android.text.InputFilter[0]));
	}


	
	private void setPasswordType(Object objValue) {
		if (objValue != null && (boolean) objValue) {
			appCompatEditText.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
			appCompatEditText.setTypeface(android.graphics.Typeface.MONOSPACE);
		} else {
			appCompatEditText.setTransformationMethod(null);
			appCompatEditText.setTypeface(null);
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
        appCompatEditText.setKeyListener(android.text.method.TextKeyListener.getInstance(autotext, cap));
        appCompatEditText.setInputType(inputType);
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
			setAutoSizeTextTypeInternal( getAutoSizeTextType(appCompatEditText));
		}
	}

	private void setAutoMinTextSize(Object objValue) {
		autoSizeMin = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(appCompatEditText));
		}
	}

	private void setAutoMaxTextSize(Object objValue) {
		autoSizeMax = (int) objValue;
		
		if (isInitialised()) {
			setAutoSizeTextTypeInternal( getAutoSizeTextType(appCompatEditText));
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
		return getAutoSizeTextType(appCompatEditText);
	}
	//end - autosize

	private int getAutoSizeTextType(TextView appCompatEditText) {
		return TextViewCompat.getAutoSizeTextType(appCompatEditText);
	}

	private void setAutoSizeTextTypeInternal(int autoTextType) {
		TextViewCompat.setAutoSizeTextTypeWithDefaults(appCompatEditText, autoTextType);
		
		if (autoTextType == 1) {
			int autoSizeMinTextSize = autoSizeMin == -1 ? TextViewCompat.getAutoSizeMinTextSize(appCompatEditText) : autoSizeMin;
			int autoSizeMaxTextSize = autoSizeMax == -1 ? TextViewCompat.getAutoSizeMaxTextSize(appCompatEditText) : autoSizeMax;
			int autoSizeStepGranularity = autoSizeGranular == -1 ? TextViewCompat.getAutoSizeStepGranularity(appCompatEditText) : autoSizeGranular;
			TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(appCompatEditText, 
					autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, 
					android.util.TypedValue.COMPLEX_UNIT_PX);
        }
	}
	
	   
    private void setLinksClickable(Object objValue) {
        if (objValue != null && (boolean) objValue) {
            appCompatEditText.setLinksClickable(true);
            
            if (isInitialised()) {
                appCompatEditText.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());    
            }
        } else {
            appCompatEditText.setLinksClickable(false);
            
            if (isInitialised()) {
                if (appCompatEditText.getMovementMethod() instanceof android.text.method.LinkMovementMethod) {
                    appCompatEditText.setMovementMethod(null);
                }    
            }
        }
    }

	
	private void startOrStopMarquee(Object objValue) {
		appCompatEditText.setSelected((boolean) objValue); 
		
	}

	
	private void setTextAligmentHack(Object objValue) {
		if (isInitialised()) {
			setFieldUsingReflection(appCompatEditText, "mLayout", null);
		}
	}
	

	private void resetText() {
		if (isInitialised()) {
			appCompatEditText.setText(appCompatEditText.getText());
		}
	}
	

	
	private Object getFinalValueForEllipsize(Object objValue) {
		if ("@null".equals(objValue)) {
			return null;
		}
		
		if (objValue == android.text.TextUtils.TruncateAt.MARQUEE) {
			appCompatEditText.setSelected(true); 
		}
		return objValue;
	}	

	private void setAutoSizePresetSizes(Object objValue) {
		TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(appCompatEditText, (int[]) objValue, android.util.TypedValue.COMPLEX_UNIT_PX);
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
			List<IListener> listeners = (List<IListener>)getFieldValueUsingReflection(appCompatEditText, "mListeners");
			if (listeners != null) {
				for (IListener listener : listeners) {
					if (action.equals(listener.getAction())) {
						appCompatEditText.removeTextChangedListener((TextWatcher) listener);
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

	@SuppressLint("NewApi")
private static class OnEditorActionListener implements TextView.OnEditorActionListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnEditorActionListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnEditorActionListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onEditorAction (TextView v, 
                int actionId, 
                KeyEvent event){
    boolean result = true;
    
	if (action == null || action.equals("onEditorAction")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onEditorAction");
	    java.util.Map<String, Object> obj = getOnEditorActionEventObj(v,actionId,event);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,actionId,event);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }
		    if (commandType.equals(":")) {
		    	return result;
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
    return result;
}//#####

public java.util.Map<String, Object> getOnEditorActionEventObj(TextView v,int actionId,KeyEvent event) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "editoraction");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "actionId", actionId);
        ViewImpl.addEventInfo(obj, event);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onEditorAction", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			appCompatEditText.setId(IdGenerator.getId(id));
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
    
	
private EditTextCommandBuilder builder;
private EditTextBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public EditTextBean getBean() {
	if (bean == null) {
		bean = new EditTextBean();
	}
	return bean;
}
public EditTextCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new EditTextCommandBuilder();
	}
	return builder;
}


public  class EditTextCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <EditTextCommandBuilder> {
    public EditTextCommandBuilder() {
	}
	
	public EditTextCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public EditTextCommandBuilder tryGetCursorVisible() {
	Map<String, Object> attrs = initCommand("cursorVisible");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isCursorVisible() {
	Map<String, Object> attrs = initCommand("cursorVisible");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setCursorVisible(boolean value) {
	Map<String, Object> attrs = initCommand("cursorVisible");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getDrawablePadding() {
	Map<String, Object> attrs = initCommand("drawablePadding");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setDrawablePadding(String value) {
	Map<String, Object> attrs = initCommand("drawablePadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetElegantTextHeight() {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isElegantTextHeight() {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setElegantTextHeight(boolean value) {
	Map<String, Object> attrs = initCommand("elegantTextHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setEms(int value) {
	Map<String, Object> attrs = initCommand("ems");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetFallbackLineSpacing() {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isFallbackLineSpacing() {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setFallbackLineSpacing(boolean value) {
	Map<String, Object> attrs = initCommand("fallbackLineSpacing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getFirstBaselineToTopHeight() {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setFirstBaselineToTopHeight(String value) {
	Map<String, Object> attrs = initCommand("firstBaselineToTopHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetFreezesText() {
	Map<String, Object> attrs = initCommand("freezesText");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isFreezesText() {
	Map<String, Object> attrs = initCommand("freezesText");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setFreezesText(boolean value) {
	Map<String, Object> attrs = initCommand("freezesText");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetHeight() {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHeight() {
	Map<String, Object> attrs = initCommand("height");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setHeight(String value) {
	Map<String, Object> attrs = initCommand("height");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetHint() {
	Map<String, Object> attrs = initCommand("hint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getHint() {
	Map<String, Object> attrs = initCommand("hint");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setHint(String value) {
	Map<String, Object> attrs = initCommand("hint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setImeActionId(int value) {
	Map<String, Object> attrs = initCommand("imeActionId");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setImeActionLabel(String value) {
	Map<String, Object> attrs = initCommand("imeActionLabel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetImeOptions() {
	Map<String, Object> attrs = initCommand("imeOptions");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getImeOptions() {
	Map<String, Object> attrs = initCommand("imeOptions");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setImeOptions(String value) {
	Map<String, Object> attrs = initCommand("imeOptions");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetIncludeFontPadding() {
	Map<String, Object> attrs = initCommand("includeFontPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isIncludeFontPadding() {
	Map<String, Object> attrs = initCommand("includeFontPadding");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setIncludeFontPadding(boolean value) {
	Map<String, Object> attrs = initCommand("includeFontPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setInputType(String value) {
	Map<String, Object> attrs = initCommand("inputType");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLastBaselineToBottomHeight() {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setLastBaselineToBottomHeight(String value) {
	Map<String, Object> attrs = initCommand("lastBaselineToBottomHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetLetterSpacing() {
	Map<String, Object> attrs = initCommand("letterSpacing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLetterSpacing() {
	Map<String, Object> attrs = initCommand("letterSpacing");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setLetterSpacing(float value) {
	Map<String, Object> attrs = initCommand("letterSpacing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetLineHeight() {
	Map<String, Object> attrs = initCommand("lineHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineHeight() {
	Map<String, Object> attrs = initCommand("lineHeight");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setLineHeight(String value) {
	Map<String, Object> attrs = initCommand("lineHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetLineSpacingExtra() {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineSpacingExtra() {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setLineSpacingExtra(String value) {
	Map<String, Object> attrs = initCommand("lineSpacingExtra");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetLineSpacingMultiplier() {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLineSpacingMultiplier() {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setLineSpacingMultiplier(float value) {
	Map<String, Object> attrs = initCommand("lineSpacingMultiplier");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setLines(int value) {
	Map<String, Object> attrs = initCommand("lines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxEms() {
	Map<String, Object> attrs = initCommand("maxEms");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setMaxEms(int value) {
	Map<String, Object> attrs = initCommand("maxEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxLines() {
	Map<String, Object> attrs = initCommand("maxLines");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setMaxLines(int value) {
	Map<String, Object> attrs = initCommand("maxLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinEms() {
	Map<String, Object> attrs = initCommand("minEms");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setMinEms(int value) {
	Map<String, Object> attrs = initCommand("minEms");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setMinHeight(String value) {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinLines() {
	Map<String, Object> attrs = initCommand("minLines");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setMinLines(int value) {
	Map<String, Object> attrs = initCommand("minLines");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setMinWidth(String value) {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetPrivateImeOptions() {
	Map<String, Object> attrs = initCommand("privateImeOptions");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPrivateImeOptions() {
	Map<String, Object> attrs = initCommand("privateImeOptions");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setPrivateImeOptions(String value) {
	Map<String, Object> attrs = initCommand("privateImeOptions");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setScrollHorizontally(boolean value) {
	Map<String, Object> attrs = initCommand("scrollHorizontally");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setSelectAllOnFocus(boolean value) {
	Map<String, Object> attrs = initCommand("selectAllOnFocus");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetShadowColor() {
	Map<String, Object> attrs = initCommand("shadowColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowColor() {
	Map<String, Object> attrs = initCommand("shadowColor");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setShadowColor(String value) {
	Map<String, Object> attrs = initCommand("shadowColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetShadowDx() {
	Map<String, Object> attrs = initCommand("shadowDx");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowDx() {
	Map<String, Object> attrs = initCommand("shadowDx");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setShadowDx(float value) {
	Map<String, Object> attrs = initCommand("shadowDx");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetShadowDy() {
	Map<String, Object> attrs = initCommand("shadowDy");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowDy() {
	Map<String, Object> attrs = initCommand("shadowDy");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setShadowDy(float value) {
	Map<String, Object> attrs = initCommand("shadowDy");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetShadowRadius() {
	Map<String, Object> attrs = initCommand("shadowRadius");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getShadowRadius() {
	Map<String, Object> attrs = initCommand("shadowRadius");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setShadowRadius(float value) {
	Map<String, Object> attrs = initCommand("shadowRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setSingleLine(boolean value) {
	Map<String, Object> attrs = initCommand("singleLine");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColor() {
	Map<String, Object> attrs = initCommand("textColor");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setTextColor(String value) {
	Map<String, Object> attrs = initCommand("textColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetTextColorHighlight() {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextColorHighlight() {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setTextColorHighlight(String value) {
	Map<String, Object> attrs = initCommand("textColorHighlight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setTextColorHint(String value) {
	Map<String, Object> attrs = initCommand("textColorHint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetTextIsSelectable() {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isTextIsSelectable() {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setTextIsSelectable(boolean value) {
	Map<String, Object> attrs = initCommand("textIsSelectable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetTextScaleX() {
	Map<String, Object> attrs = initCommand("textScaleX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextScaleX() {
	Map<String, Object> attrs = initCommand("textScaleX");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setTextScaleX(float value) {
	Map<String, Object> attrs = initCommand("textScaleX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetWidth() {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getWidth() {
	Map<String, Object> attrs = initCommand("width");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setWidth(String value) {
	Map<String, Object> attrs = initCommand("width");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setOnafterTextChange(String value) {
	Map<String, Object> attrs = initCommand("onafterTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setOnbeforeTextChange(String value) {
	Map<String, Object> attrs = initCommand("onbeforeTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setOnTextChange(String value) {
	Map<String, Object> attrs = initCommand("onTextChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setOnEditorAction(String value) {
	Map<String, Object> attrs = initCommand("onEditorAction");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setCapitalize(String value) {
	Map<String, Object> attrs = initCommand("capitalize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setPhoneNumber(boolean value) {
	Map<String, Object> attrs = initCommand("phoneNumber");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setNumeric(String value) {
	Map<String, Object> attrs = initCommand("numeric");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDigits(String value) {
	Map<String, Object> attrs = initCommand("digits");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setEditorExtras(String value) {
	Map<String, Object> attrs = initCommand("editorExtras");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setAutoText(boolean value) {
	Map<String, Object> attrs = initCommand("autoText");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setTextAllCaps(boolean value) {
	Map<String, Object> attrs = initCommand("textAllCaps");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder selectAll(boolean value) {
	Map<String, Object> attrs = initCommand("selectAll");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setHintTextFormat(String value) {
	Map<String, Object> attrs = initCommand("hintTextFormat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetText() {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getText() {
	Map<String, Object> attrs = initCommand("text");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setText(String value) {
	Map<String, Object> attrs = initCommand("text");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTextSize() {
	Map<String, Object> attrs = initCommand("textSize");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setTextSize(String value) {
	Map<String, Object> attrs = initCommand("textSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDrawableLeft(String value) {
	Map<String, Object> attrs = initCommand("drawableLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDrawableStart(String value) {
	Map<String, Object> attrs = initCommand("drawableStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDrawableRight(String value) {
	Map<String, Object> attrs = initCommand("drawableRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDrawableEnd(String value) {
	Map<String, Object> attrs = initCommand("drawableEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDrawableTop(String value) {
	Map<String, Object> attrs = initCommand("drawableTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDrawableBottom(String value) {
	Map<String, Object> attrs = initCommand("drawableBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setMaxLength(int value) {
	Map<String, Object> attrs = initCommand("maxLength");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setTypeface(String value) {
	Map<String, Object> attrs = initCommand("typeface");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setTextStyle(String value) {
	Map<String, Object> attrs = initCommand("textStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setFontFamily(String value) {
	Map<String, Object> attrs = initCommand("fontFamily");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setTextAppearance(String value) {
	Map<String, Object> attrs = initCommand("textAppearance");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setPassword(boolean value) {
	Map<String, Object> attrs = initCommand("password");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setEditable(boolean value) {
	Map<String, Object> attrs = initCommand("editable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDrawableTint(String value) {
	Map<String, Object> attrs = initCommand("drawableTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setDrawableTintMode(DrawableTintMode value) {
	Map<String, Object> attrs = initCommand("drawableTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public EditTextCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public EditTextCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class EditTextBean extends com.ashera.layout.ViewImpl.ViewBean{
		public EditTextBean() {
			super(EditTextImpl.this);
		}
public Object isCursorVisible() {
	return getBuilder().reset().tryGetCursorVisible().execute(false).isCursorVisible(); 
}
public void setCursorVisible(boolean value) {
	getBuilder().reset().setCursorVisible(value).execute(true);
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

public Object isFreezesText() {
	return getBuilder().reset().tryGetFreezesText().execute(false).isFreezesText(); 
}
public void setFreezesText(boolean value) {
	getBuilder().reset().setFreezesText(value).execute(true);
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

public Object getHint() {
	return getBuilder().reset().tryGetHint().execute(false).getHint(); 
}
public void setHint(String value) {
	getBuilder().reset().setHint(value).execute(true);
}

public void setImeActionId(int value) {
	getBuilder().reset().setImeActionId(value).execute(true);
}

public void setImeActionLabel(String value) {
	getBuilder().reset().setImeActionLabel(value).execute(true);
}

public Object getImeOptions() {
	return getBuilder().reset().tryGetImeOptions().execute(false).getImeOptions(); 
}
public void setImeOptions(String value) {
	getBuilder().reset().setImeOptions(value).execute(true);
}

public Object isIncludeFontPadding() {
	return getBuilder().reset().tryGetIncludeFontPadding().execute(false).isIncludeFontPadding(); 
}
public void setIncludeFontPadding(boolean value) {
	getBuilder().reset().setIncludeFontPadding(value).execute(true);
}

public void setInputType(String value) {
	getBuilder().reset().setInputType(value).execute(true);
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

public Object getPrivateImeOptions() {
	return getBuilder().reset().tryGetPrivateImeOptions().execute(false).getPrivateImeOptions(); 
}
public void setPrivateImeOptions(String value) {
	getBuilder().reset().setPrivateImeOptions(value).execute(true);
}

public void setScrollHorizontally(boolean value) {
	getBuilder().reset().setScrollHorizontally(value).execute(true);
}

public void setSelectAllOnFocus(boolean value) {
	getBuilder().reset().setSelectAllOnFocus(value).execute(true);
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

public void setTextColorHint(String value) {
	getBuilder().reset().setTextColorHint(value).execute(true);
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

public void setOnafterTextChange(String value) {
	getBuilder().reset().setOnafterTextChange(value).execute(true);
}

public void setOnbeforeTextChange(String value) {
	getBuilder().reset().setOnbeforeTextChange(value).execute(true);
}

public void setOnTextChange(String value) {
	getBuilder().reset().setOnTextChange(value).execute(true);
}

public void setOnEditorAction(String value) {
	getBuilder().reset().setOnEditorAction(value).execute(true);
}

public void setCapitalize(String value) {
	getBuilder().reset().setCapitalize(value).execute(true);
}

public void setPhoneNumber(boolean value) {
	getBuilder().reset().setPhoneNumber(value).execute(true);
}

public void setNumeric(String value) {
	getBuilder().reset().setNumeric(value).execute(true);
}

public void setDigits(String value) {
	getBuilder().reset().setDigits(value).execute(true);
}

public void setEditorExtras(String value) {
	getBuilder().reset().setEditorExtras(value).execute(true);
}

public void setAutoText(boolean value) {
	getBuilder().reset().setAutoText(value).execute(true);
}

public void setTextAllCaps(boolean value) {
	getBuilder().reset().setTextAllCaps(value).execute(true);
}

public void selectAll(boolean value) {
	getBuilder().reset().selectAll(value).execute(true);
}

public void setHintTextFormat(String value) {
	getBuilder().reset().setHintTextFormat(value).execute(true);
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

public void setPassword(boolean value) {
	getBuilder().reset().setPassword(value).execute(true);
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

}


    
	//end - body
	
	private static final int SIGNED = 2;
    private static final int DECIMAL = 4;
	private void setNumeric(Object objValue) {
		int numeric = (int) objValue;
		android.text.method.KeyListener keyListener = android.text.method.DigitsKeyListener.getInstance((numeric & SIGNED) != 0,
                (numeric & DECIMAL) != 0);
		appCompatEditText.setKeyListener(keyListener);
		int inputType = android.view.inputmethod.EditorInfo.TYPE_CLASS_NUMBER;
		if ((numeric & SIGNED) != 0) {
		inputType |= android.view.inputmethod.EditorInfo.TYPE_NUMBER_FLAG_SIGNED;
		}
		if ((numeric & DECIMAL) != 0) {
			inputType |= android.view.inputmethod.EditorInfo.TYPE_NUMBER_FLAG_DECIMAL;
		}
		appCompatEditText.setInputType(inputType);
		
	}
	
	
	private void setDigits(Object objValue) {
		String digits = (String) objValue;
		android.text.method.KeyListener keyListener = android.text.method.DigitsKeyListener.getInstance(digits.toString());
		appCompatEditText.setKeyListener(keyListener);
		appCompatEditText.setInputType(appCompatEditText.getInputType() != android.view.inputmethod.EditorInfo.TYPE_NULL
                ? appCompatEditText.getInputType() : android.view.inputmethod.EditorInfo.TYPE_CLASS_NUMBER);

	}
	

	
	private void setPhoneNumber(Object objValue) {
		if (objValue != null && (boolean) objValue) {
			appCompatEditText.setKeyListener(android.text.method.DialerKeyListener.getInstance());
			appCompatEditText.setInputType(android.view.inputmethod.EditorInfo.TYPE_CLASS_PHONE);
		} else {
			appCompatEditText.setKeyListener(null);
			appCompatEditText.setInputType(android.view.inputmethod.EditorInfo.TYPE_NULL);
		}
	}
		
	
	private void setCapitalize(Object objValue) {
		storeUserData("capitalize", objValue);
		int autocap = (int) objValue;
		boolean autotext = getUserData("autotext") != null && (boolean) getUserData("autotext");
		setAutoCap(autocap, autotext);
		
	}
	
	
	
	private void setEditorExtras(Object objValue) {
		try {
			Context context = (Context) fragment.getRootActivity();
			android.content.res.XmlResourceParser parser = context.getResources().getXml((int) objValue);
			parseBundleExtras(parser, appCompatEditText.getInputExtras(true), context.getResources());
		} catch (Exception e) {
			throw new RuntimeException(e);		
		} 
		
	}

	public void parseBundleExtras(android.content.res.XmlResourceParser parser, android.os.Bundle outBundle, android.content.res.Resources resources)
			throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
		int outerDepth = parser.getDepth();
		String nodeName = parser.getName();
		int type;
		while ((type=parser.next()) != org.xmlpull.v1.XmlPullParser.END_DOCUMENT
				&& (type != org.xmlpull.v1.XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
			if (type == org.xmlpull.v1.XmlPullParser.END_TAG || type == org.xmlpull.v1.XmlPullParser.TEXT || type == org.xmlpull.v1.XmlPullParser.START_DOCUMENT) {
				continue;
			}

			nodeName = parser.getName();
			if (nodeName.equals("input-extras")) {
				continue;
			}
			if (nodeName.equals("extra")) {
				resources.parseBundleExtra("extra", parser, outBundle);
				skipCurrentTag(parser);

			} else {
				skipCurrentTag(parser);
			}
		}
	}

	public static void skipCurrentTag(org.xmlpull.v1.XmlPullParser parser)
			throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
		int outerDepth = parser.getDepth();
		int type;
		while ((type=parser.next()) != org.xmlpull.v1.XmlPullParser.END_DOCUMENT
				&& (type != org.xmlpull.v1.XmlPullParser.END_TAG
				|| parser.getDepth() > outerDepth)) {
		}
	}
	
	
	private void setTextAllCaps(Object objValue) {
		removeAllCapsFilter();
		if (objValue != null && (boolean) objValue) {
			try {
				appCompatEditText.setText(android.icu.lang.UCharacter.toUpperCase(appCompatEditText.getText().toString()));
			} catch (Error e) {
				appCompatEditText.setText(appCompatEditText.getText().toString().toUpperCase(java.util.Locale.getDefault()));
			}
			android.text.InputFilter[] filtersArr = appCompatEditText.getFilters();
			List<android.text.InputFilter> filters = new java.util.ArrayList<>(java.util.Arrays.asList(filtersArr));			
			filters.add(new android.text.InputFilter.AllCaps());
            appCompatEditText.setFilters(filters.toArray(new android.text.InputFilter[0]));
        }
	}

	private void removeAllCapsFilter() {
		android.text.InputFilter[] filtersArr = appCompatEditText.getFilters();
		if (filtersArr == null) {
			filtersArr = new android.text.InputFilter[0];
		}
		List<android.text.InputFilter> filters = new java.util.ArrayList<>(java.util.Arrays.asList(filtersArr));
		for (java.util.Iterator<android.text.InputFilter> iterator = filters.iterator(); iterator.hasNext();) {
			android.text.InputFilter inputFilter = iterator.next();
			if (inputFilter instanceof android.text.InputFilter.AllCaps) {
				iterator.remove();
			}
			
		}
		appCompatEditText.setFilters(filters.toArray(new android.text.InputFilter[0]));
	}
	
	
	private void selectAll(Object objValue) {
		if ((boolean) objValue){
			appCompatEditText.requestFocus();
			appCompatEditText.selectAll();
		}
		
	}

	@Override
	public String getTextEntered() {
		return appCompatEditText.getText().toString();
	}

	//start - isViewVisible
	@Override
	public boolean isViewVisible() {
		return appCompatEditText.getVisibility() == View.VISIBLE;
	}
	//end - isViewVisible

	//start - focus
	@Override
	public void focus() {
		appCompatEditText.requestFocus();
	}
	//end - focus

	//start - errordisplay
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
	//end - errordisplay
	
	//start - popuperror
	public void setError(String mesage) {
		appCompatEditText.setError(mesage);
	}
	//end - popuperror

	private void addTextChangedListener(androidx.appcompat.widget.AppCompatEditText appCompatEditText, Object objValue) {
		if (objValue instanceof android.text.TextWatcher) {
			appCompatEditText.addTextChangedListener((android.text.TextWatcher) objValue);
		}
	}

	
	private void setOnEditorActionListener(androidx.appcompat.widget.AppCompatEditText appCompatEditText, Object objValue) {
		appCompatEditText.setOnEditorActionListener((androidx.appcompat.widget.AppCompatEditText.OnEditorActionListener) objValue);
		
	}
	
	//start - hinttextformat
	private void setHintTextFormat(Object objValue) {
		applyAttributeCommand("hint", CommonConverters.command_textformatter, new String[] {"hintTextFormat"}, true, (String) objValue);
	}
	//end - hinttextformat
}
