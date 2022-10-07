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
public class ImageButtonImpl extends BaseWidget implements IsImage{
	//start - body
	public final static String LOCAL_NAME = "ImageButton"; 
	public final static String GROUP_NAME = "ImageButton";

	protected org.teavm.jso.dom.html.HTMLElement hTMLElement;
	protected MeasurableImageView measurableImageView;	
	
		@SuppressLint("NewApi")
		final static class ScaleType extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("center",  0x5);
				mapping.put("centerCrop",  0x6);
				mapping.put("centerInside",  0x7);
				mapping.put("fitCenter",  0x3);
				mapping.put("fitEnd",  0x4);
				mapping.put("fitStart",  0x2);
				mapping.put("fitXY",  0x1);
				mapping.put("matrix",  0x0);
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


		ConverterFactory.register("ImageButton.scaleType", new ScaleType());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scaleType").withType("ImageButton.scaleType").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("src").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("adjustViewBounds").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrl").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrlPlaceHolder").withType("drawable").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrlError").withType("drawable").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baseline").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baselineAlignBottom").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
	}
	
	public ImageButtonImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class ImageButtonExt extends MeasurableImageView implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public ImageButtonExt() {
			
			
			
			
			
			
			super(ImageButtonImpl.this);
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
			postOnMeasure(widthMeasureSpec, heightMeasureSpec);
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			ViewImpl.setDrawableBounds(ImageButtonImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			nativeMakeFrameForChildWidget(l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(ImageButtonImpl.this);
			
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
				ImageButtonImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(ImageButtonImpl.this);
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
	}	
	public void updateMeasuredDimension(int width, int height) {
	}

	@Override
	public IWidget newInstance() {
		return new ImageButtonImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableImageView = new ImageButtonExt();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "scaleType": {
				


		setScaleType(strValue, objValue);



			}
			break;
			case "src": {
				


		setImage(objValue);



			}
			break;
			case "adjustViewBounds": {
				


		setAdjustViewBounds(objValue);



			}
			break;
			case "maxHeight": {
				


		setMaxHeight(objValue);



			}
			break;
			case "maxWidth": {
				


		setMaxWidth(objValue);



			}
			break;
			case "imageFromUrl": {
				


		setImageFromUrl(objValue);



			}
			break;
			case "imageFromUrlPlaceHolder": {
				


		setImageFromUrlPlaceHolder(objValue);



			}
			break;
			case "imageFromUrlError": {
				


		setImageFromUrlError(objValue);



			}
			break;
			case "baseline": {
				


		setBaseLine(objValue);



			}
			break;
			case "baselineAlignBottom": {
				


		setBaselineAlignBottom(objValue);



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
			case "scaleType": {
return getScaleType();				}
			case "src": {
return getSrc();				}
			case "adjustViewBounds": {
return getAdjustViewBounds();				}
			case "maxHeight": {
return getMaxHeight();				}
			case "maxWidth": {
return getMaxWidth();				}
			case "baseline": {
return getBaseLine();				}
			case "baselineAlignBottom": {
return getBaselineAlignBottom();				}
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
		return measurableImageView;
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
		ViewImpl.setPaddingLeft(objValue, measurableImageView);
	}
	
	private void setPaddingRight(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-right", value + "px");
		ViewImpl.setPaddingRight(objValue, measurableImageView);
	}

	private void setPaddingTop(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-top", value + "px");
		ViewImpl.setPaddingTop(objValue, measurableImageView);
	}

	private void setPaddingBottom(Object objValue) {
		int value = (int) objValue;
		hTMLElement.getStyle().setProperty("padding-bottom", value + "px");
		ViewImpl.setPaddingBottom(objValue, measurableImageView);
	}

	private Object getPaddingTop() {
		return measurableImageView.getPaddingTop();
	}

	private Object getPaddingBottom() {
		return measurableImageView.getPaddingBottom();
	}

	private Object getPaddingLeft() {
		return measurableImageView.getPaddingStart();
	}

	private Object getPaddingRight() {
		return measurableImageView.getPaddingEnd();
	}

	private void setPaddingHorizontal(Object objValue) {
		setPaddingLeft(objValue);
		setPaddingRight(objValue);
	}

	private void setPaddingVertical(Object objValue) {
		setPaddingTop(objValue);
		setPaddingBottom(objValue);
	}
	


	private Object getBaselineAlignBottom() {
		return measurableImageView.getBaselineAlignBottom();
	}

	@Override
	public int getBaseLine() {
		return measurableImageView.getBaseline();
	}

	private void setBaseLine(Object objValue) {
		measurableImageView.setBaseline((int) objValue);
	}
	
	private void setBaselineAlignBottom(Object objValue) {
		measurableImageView.setBaselineAlignBottom((boolean) objValue);
	}
	
	
	private void setCropToPadding(Object objValue) {
		measurableImageView.setCropToPadding((boolean) objValue); 
	}

	private Object getCropToPadding() {
		return measurableImageView.getCropToPadding();
	}
	
	private Object getMaxWidth() {
		return measurableImageView.getMaxWidth();
	}

	private Object getMaxHeight() {
		return measurableImageView.getMaxHeight();
	}
    
    private void setMaxWidth(Object objValue) {
        measurableImageView.setMaxWidth(((int) objValue));
    }

    private void setMaxHeight(Object objValue) {
        measurableImageView.setMaxHeight(((int) objValue));
    }


	private Object getAdjustViewBounds() {
		return measurableImageView.getAdjustViewBounds();
	}
	

    private void setAdjustViewBounds(Object objValue) {
        measurableImageView.setAdjustViewBounds((boolean) objValue);
    }
    
	@Override
	public void drawableStateChanged() {
		super.drawableStateChanged();
		r.android.graphics.drawable.Drawable imageDrawable = measurableImageView.getImageDrawable();
		if (imageDrawable != null && imageDrawable.isStateful() && imageDrawable.setState(measurableImageView.getDrawableState())) {
			setImage(imageDrawable);
		}
	}
	
    


	private void setImage(Object objValue) {
		measurableImageView.setImageDrawable((r.android.graphics.drawable.Drawable) objValue);
		Object drawable = measurableImageView.getImageDrawable().getDrawable();
		
		// this is case when image has not been loaded
		if (measurableImageView.getImageDrawable().getMinimumHeight() == 0 && measurableImageView.getImageDrawable().getMinimumWidth() == 0) {
			addRemeasureListeners();
		}
		
		if (drawable instanceof String) {
			if (((String) drawable).startsWith("#")) {
				image.removeAttribute("src");
				image.getStyle().setProperty("background-color", (String) drawable);				
			} else {
				image.setAttribute("src", (String) drawable);
			}
			
		}
	}
	
	
	private Object getSrc() {
		Object drawable = measurableImageView.getImageDrawable().getDrawable();
		if (drawable instanceof String) {
			if (((String) drawable).startsWith("res-swt/")) {
				drawable = getImageAsBase64(image);
			}
		}
		return drawable;
	}

	@org.teavm.jso.JSBody(params = {"element"}, script = "return window.getImageAsBase64(element)")
    private static native String getImageAsBase64(HTMLElement element);

	@Override
	public Object getImage() {
		return image.getAttribute("src");
	}

	@Override
	public int[] getImageDimension() {
		r.android.graphics.drawable.Drawable imageDrawable = measurableImageView.getImageDrawable();
		if (imageDrawable == null) {
			return new int[] {-1, -1};
		}
		return new int[] { imageDrawable.getMinimumWidth(), measurableImageView.getImageDrawable().getMinimumHeight() };
	}
	

	private void setScaleType(String strValue) {
		switch (strValue) {
		case "fitXY":
		    image.getStyle().setProperty("object-fit","fill");
		    break;
		case "fitStart":
		    image.getStyle().setProperty("object-fit","contain");
		    break;
		case "fitCenter":
		    image.getStyle().setProperty("object-fit","contain");
		    break;
		case "fitEnd":
		    image.getStyle().setProperty("object-fit","contain");
		    break;
		case "center":
		    image.getStyle().setProperty("object-fit","scale-down");
		    break;            
		case "centerCrop":
		    image.getStyle().setProperty("object-fit","cover");
		    break;
		case "centerInside":
		    image.getStyle().setProperty("object-fit","scale-down");
		    break;            
		default:
		    break;
		}
	}

    private Object getScaleType() {
		return measurableImageView.getScaleTypeInt();
	}
    

    private boolean measureCalled = false;
	private r.android.graphics.drawable.Drawable imageFromUrlError;
	
	private void setImageFromUrlError(Object objValue) {
		imageFromUrlError = (r.android.graphics.drawable.Drawable) objValue;		
	}
	private void postOnMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		measureCalled = true;
	}
	
	private void setImageFromUrlPlaceHolder(Object objValue) {
		setImage(objValue);
	}

	private boolean listenersAdded = false;
	
	private void setImageFromUrl(Object objValue) {
		measureCalled = false;
		
		addRemeasureListeners();
		image.setAttribute("src", (String) objValue);
	}

	private void addRemeasureListeners() {
		image.addEventListener("load", new ImageLoadListener());
		image.addEventListener("error", new ImageErrorListener());
	}
	
	private final class ImageErrorListener implements org.teavm.jso.dom.events.EventListener<org.teavm.jso.dom.events.Event> {
		@Override
		public void handleEvent(org.teavm.jso.dom.events.Event evt) {
			if (imageFromUrlError != null) {
	 			setImage(imageFromUrlError);
	 			remeasureIfRequired();
			}
			image.removeEventListener("error", this);
		}
	}
	
	private final class ImageLoadListener implements org.teavm.jso.dom.events.EventListener<org.teavm.jso.dom.events.Event> {
		@Override
		public void handleEvent(org.teavm.jso.dom.events.Event evt) {
			org.teavm.jso.dom.html.HTMLImageElement imageElement = (org.teavm.jso.dom.html.HTMLImageElement) image;
			r.android.graphics.drawable.Drawable drawable = new r.android.graphics.drawable.Drawable();
			drawable.setMinimumHeight(imageElement.getNaturalHeight());
			drawable.setMinimumWidth(imageElement.getNaturalWidth());
			measurableImageView.setImageDrawable(drawable);
			remeasureIfRequired();
			image.removeEventListener("load", this);
		}
	}

	private void remeasureIfRequired() {
		if (measureCalled) {
			requestLayout();
			fragment.remeasure();
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
			measurableImageView.setId(IdGenerator.getId(id));
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
    
	
private ImageButtonCommandBuilder builder;
private ImageButtonBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ImageButtonBean getBean() {
	if (bean == null) {
		bean = new ImageButtonBean();
	}
	return bean;
}
public ImageButtonCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ImageButtonCommandBuilder();
	}
	return builder;
}


public  class ImageButtonCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <ImageButtonCommandBuilder> {
    public ImageButtonCommandBuilder() {
	}
	
	public ImageButtonCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ImageButtonCommandBuilder tryGetScaleType() {
	Map<String, Object> attrs = initCommand("scaleType");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getScaleType() {
	Map<String, Object> attrs = initCommand("scaleType");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setScaleType(String value) {
	Map<String, Object> attrs = initCommand("scaleType");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetSrc() {
	Map<String, Object> attrs = initCommand("src");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSrc() {
	Map<String, Object> attrs = initCommand("src");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setSrc(String value) {
	Map<String, Object> attrs = initCommand("src");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetAdjustViewBounds() {
	Map<String, Object> attrs = initCommand("adjustViewBounds");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isAdjustViewBounds() {
	Map<String, Object> attrs = initCommand("adjustViewBounds");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setAdjustViewBounds(boolean value) {
	Map<String, Object> attrs = initCommand("adjustViewBounds");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder setImageFromUrl(String value) {
	Map<String, Object> attrs = initCommand("imageFromUrl");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder setImageFromUrlPlaceHolder(String value) {
	Map<String, Object> attrs = initCommand("imageFromUrlPlaceHolder");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder setImageFromUrlError(String value) {
	Map<String, Object> attrs = initCommand("imageFromUrlError");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetBaseline() {
	Map<String, Object> attrs = initCommand("baseline");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBaseline() {
	Map<String, Object> attrs = initCommand("baseline");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setBaseline(String value) {
	Map<String, Object> attrs = initCommand("baseline");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetBaselineAlignBottom() {
	Map<String, Object> attrs = initCommand("baselineAlignBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isBaselineAlignBottom() {
	Map<String, Object> attrs = initCommand("baselineAlignBottom");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setBaselineAlignBottom(boolean value) {
	Map<String, Object> attrs = initCommand("baselineAlignBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ImageButtonBean extends com.ashera.layout.ViewImpl.ViewBean{
		public ImageButtonBean() {
			super(ImageButtonImpl.this);
		}
public Object getScaleType() {
	return getBuilder().reset().tryGetScaleType().execute(false).getScaleType(); 
}
public void setScaleType(String value) {
	getBuilder().reset().setScaleType(value).execute(true);
}

public Object getSrc() {
	return getBuilder().reset().tryGetSrc().execute(false).getSrc(); 
}
public void setSrc(String value) {
	getBuilder().reset().setSrc(value).execute(true);
}

public Object isAdjustViewBounds() {
	return getBuilder().reset().tryGetAdjustViewBounds().execute(false).isAdjustViewBounds(); 
}
public void setAdjustViewBounds(boolean value) {
	getBuilder().reset().setAdjustViewBounds(value).execute(true);
}

public Object getMaxHeight() {
	return getBuilder().reset().tryGetMaxHeight().execute(false).getMaxHeight(); 
}
public void setMaxHeight(String value) {
	getBuilder().reset().setMaxHeight(value).execute(true);
}

public Object getMaxWidth() {
	return getBuilder().reset().tryGetMaxWidth().execute(false).getMaxWidth(); 
}
public void setMaxWidth(String value) {
	getBuilder().reset().setMaxWidth(value).execute(true);
}

public void setImageFromUrl(String value) {
	getBuilder().reset().setImageFromUrl(value).execute(true);
}

public void setImageFromUrlPlaceHolder(String value) {
	getBuilder().reset().setImageFromUrlPlaceHolder(value).execute(true);
}

public void setImageFromUrlError(String value) {
	getBuilder().reset().setImageFromUrlError(value).execute(true);
}

public Object getBaseline() {
	return getBuilder().reset().tryGetBaseline().execute(false).getBaseline(); 
}
public void setBaseline(String value) {
	getBuilder().reset().setBaseline(value).execute(true);
}

public Object isBaselineAlignBottom() {
	return getBuilder().reset().tryGetBaselineAlignBottom().execute(false).isBaselineAlignBottom(); 
}
public void setBaselineAlignBottom(boolean value) {
	getBuilder().reset().setBaselineAlignBottom(value).execute(true);
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

}


    
	//end - body
	private HTMLElement image;

	private void setScaleType(String strValue, Object objValue) {
		this.measurableImageView.setScaleType(strValue, (int) objValue);
		setScaleType(strValue);
	}


	private void nativeCreate(Map<String, Object> params) {
		hTMLElement = org.teavm.jso.dom.html.HTMLDocument.current().createElement("button");
    	hTMLElement.getStyle().setProperty("box-sizing", "border-box");
    	hTMLElement.getStyle().setProperty("padding", "0px");
		
		image = org.teavm.jso.dom.html.HTMLDocument.current().createElement("img");
		image.getStyle().setProperty("object-fit", "contain");
		image.getStyle().setProperty("width", "100%");
		image.getStyle().setProperty("height", "100%");
		image.getStyle().setProperty("box-sizing", "border-box");
    	ViewGroupImpl.nativeAddView(hTMLElement, image);
		
	}
	
	
	private void nativeMakeFrameForChildWidget(int l, int t, int r, int b) {
	}

}
