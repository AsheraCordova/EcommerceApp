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
public class ImageViewImpl extends BaseWidget implements IsImage, IHasMultiNativeWidgets, com.ashera.image.ITarget{
	//start - body
	public final static String LOCAL_NAME = "ImageView"; 
	public final static String GROUP_NAME = "ImageView";

	protected org.eclipse.swt.widgets.Label label;
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


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("swtImage").withType("image"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("src").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("ImageView.scaleType", new ScaleType());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scaleType").withType("ImageView.scaleType").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("adjustViewBounds").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrl").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrlPlaceHolder").withType("drawable").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrlError").withType("drawable").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension").withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baseline").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baselineAlignBottom").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("cropToPadding").withType("boolean").withUiFlag(UPDATE_UI_INVALIDATE));
	}
	
	public ImageViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class ImageViewExt extends MeasurableImageView implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public ImageViewExt() {
			
			
			
			
			
			
			super(ImageViewImpl.this);
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
			ViewImpl.setDrawableBounds(ImageViewImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			nativeMakeFrameForChildWidget(l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(ImageViewImpl.this);
			
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
				ImageViewImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(ImageViewImpl.this);
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
	}	
	public void updateMeasuredDimension(int width, int height) {
		((ImageViewExt) measurableImageView).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new ImageViewImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableImageView = new ImageViewExt();
		createSimpleWrapableView();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
	}

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = simpleWrapableView.getWrappedView();
		ViewImpl.setAttribute(this, simpleWrapableView, key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "swtImage": {
				


		disposeAll(label.getImage());
		 label.setImage((Image)objValue);



			}
			break;
			case "src": {
				


		setImage(objValue);



			}
			break;
			case "scaleType": {
				


		setScaleType(strValue, objValue);



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
			case "baseline": {
				


		setBaseLine(objValue);



			}
			break;
			case "baselineAlignBottom": {
				


		setBaselineAlignBottom(objValue);



			}
			break;
			case "cropToPadding": {
				


		setCropToPadding(objValue);



			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object nativeWidget = simpleWrapableView.getWrappedView();
		Object attributeValue = ViewImpl.getAttribute(this, nativeWidget, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		switch (key.getAttributeName()) {
			case "swtImage": {
return label.getImage();				}
			case "src": {
return getSrc();				}
			case "scaleType": {
return getScaleType();				}
			case "adjustViewBounds": {
return getAdjustViewBounds();				}
			case "maxHeight": {
return getMaxHeight();				}
			case "maxWidth": {
return getMaxWidth();				}
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
			case "baseline": {
return getBaseLine();				}
			case "baselineAlignBottom": {
return getBaselineAlignBottom();				}
			case "cropToPadding": {
return getCropToPadding();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return measurableImageView;
	}

	

	private Object getPaddingBottom() {
		return measurableImageView.getPaddingBottom();
	}
	
	private Object getPaddingTop() {
		return measurableImageView.getPaddingTop();
	}

	private Object getPaddingRight() {
		return measurableImageView.getPaddingRight();
	}
	
	private Object getPaddingLeft() {
		return measurableImageView.getPaddingLeft();
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
		ViewImpl.setPaddingTop(objValue, measurableImageView);
	}

	private void setPaddingEnd(Object objValue) {
		ViewImpl.setPaddingRight(objValue, measurableImageView);
	}

	private void setPaddingStart(Object objValue) {
		ViewImpl.setPaddingLeft(objValue, measurableImageView);
	}

	private void setPaddingLeft(Object objValue) {
		ViewImpl.setPaddingLeft(objValue, measurableImageView);
	}

	private void setPaddingRight(Object objValue) {
		ViewImpl.setPaddingRight(objValue, measurableImageView);
	}

	private void setPaddingBottom(Object objValue) {
		ViewImpl.setPaddingBottom(objValue, measurableImageView);
	}

    private void setPadding(Object objValue) {
    	setPaddingBottom(objValue);
    	setPaddingTop(objValue);
    	setPaddingRight(objValue);
    	setPaddingLeft(objValue);
    }

    

	
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			measurableImageView.setId(IdGenerator.getId(id));
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
    		
    		nativeRequestLayout();
    	}
    }
    
    @Override
    public void invalidate() {
    	if (isInitialised()) {
			ViewImpl.invalidate(this, asNativeWidget());
			if (isViewWrapped()) {
				ViewImpl.invalidate(this, simpleWrapableView.getWrappedView());
				if (simpleWrapableView.getForeground() != null) {
					ViewImpl.invalidate(this, simpleWrapableView.getForeground());
				}
			}			
			nativeInvalidate();
    	}
    }
    
	
private ImageViewCommandBuilder builder;
private ImageViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ImageViewBean getBean() {
	if (bean == null) {
		bean = new ImageViewBean();
	}
	return bean;
}
public ImageViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ImageViewCommandBuilder();
	}
	return builder;
}


public  class ImageViewCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <ImageViewCommandBuilder> {
    public ImageViewCommandBuilder() {
	}
	
	public ImageViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ImageViewCommandBuilder tryGetSwtImage() {
	Map<String, Object> attrs = initCommand("swtImage");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSwtImage() {
	Map<String, Object> attrs = initCommand("swtImage");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setSwtImage(String value) {
	Map<String, Object> attrs = initCommand("swtImage");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetSrc() {
	Map<String, Object> attrs = initCommand("src");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSrc() {
	Map<String, Object> attrs = initCommand("src");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setSrc(String value) {
	Map<String, Object> attrs = initCommand("src");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetScaleType() {
	Map<String, Object> attrs = initCommand("scaleType");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getScaleType() {
	Map<String, Object> attrs = initCommand("scaleType");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setScaleType(String value) {
	Map<String, Object> attrs = initCommand("scaleType");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetAdjustViewBounds() {
	Map<String, Object> attrs = initCommand("adjustViewBounds");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isAdjustViewBounds() {
	Map<String, Object> attrs = initCommand("adjustViewBounds");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setAdjustViewBounds(boolean value) {
	Map<String, Object> attrs = initCommand("adjustViewBounds");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder setImageFromUrl(String value) {
	Map<String, Object> attrs = initCommand("imageFromUrl");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder setImageFromUrlPlaceHolder(String value) {
	Map<String, Object> attrs = initCommand("imageFromUrlPlaceHolder");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder setImageFromUrlError(String value) {
	Map<String, Object> attrs = initCommand("imageFromUrlError");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetBaseline() {
	Map<String, Object> attrs = initCommand("baseline");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBaseline() {
	Map<String, Object> attrs = initCommand("baseline");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setBaseline(String value) {
	Map<String, Object> attrs = initCommand("baseline");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetBaselineAlignBottom() {
	Map<String, Object> attrs = initCommand("baselineAlignBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isBaselineAlignBottom() {
	Map<String, Object> attrs = initCommand("baselineAlignBottom");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setBaselineAlignBottom(boolean value) {
	Map<String, Object> attrs = initCommand("baselineAlignBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageViewCommandBuilder tryGetCropToPadding() {
	Map<String, Object> attrs = initCommand("cropToPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isCropToPadding() {
	Map<String, Object> attrs = initCommand("cropToPadding");
	return attrs.get("commandReturnValue");
}
public ImageViewCommandBuilder setCropToPadding(boolean value) {
	Map<String, Object> attrs = initCommand("cropToPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ImageViewBean extends com.ashera.layout.ViewImpl.ViewBean{
		public ImageViewBean() {
			super(ImageViewImpl.this);
		}
public Object getSwtImage() {
	return getBuilder().reset().tryGetSwtImage().execute(false).getSwtImage(); 
}
public void setSwtImage(String value) {
	getBuilder().reset().setSwtImage(value).execute(true);
}

public Object getSrc() {
	return getBuilder().reset().tryGetSrc().execute(false).getSrc(); 
}
public void setSrc(String value) {
	getBuilder().reset().setSrc(value).execute(true);
}

public Object getScaleType() {
	return getBuilder().reset().tryGetScaleType().execute(false).getScaleType(); 
}
public void setScaleType(String value) {
	getBuilder().reset().setScaleType(value).execute(true);
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

public Object isCropToPadding() {
	return getBuilder().reset().tryGetCropToPadding().execute(false).isCropToPadding(); 
}
public void setCropToPadding(boolean value) {
	getBuilder().reset().setCropToPadding(value).execute(true);
}

}


    
    private SimpleWrapableView simpleWrapableView;
    
    private void createSimpleWrapableView() {
		boolean wrapViewFeature = hasFeature("enableFeatures", "decorator");
		int viewType = -1;
	
		if (wrapViewFeature) {
			boolean hscroll = hasFeature("enableFeatures", "hscroll");
			boolean vscroll = hasFeature("enableFeatures", "vscroll");
			
			viewType = 1;
			if (hscroll) viewType = 2;
			if (vscroll) viewType = 3;
		}
		
		simpleWrapableView = new SimpleWrapableView(this, viewType);
    }
    
	private boolean hasScrollView() {
		return isViewWrapped() && (simpleWrapableView.getViewtype() == 2 || simpleWrapableView.getViewtype() == 3);
	}

	private boolean isViewWrapped() {
		return simpleWrapableView.isViewWrapped();
	}
	
	@Override
	public void addForegroundIfNeeded() {
		if (isViewWrapped() && !simpleWrapableView.isDisableForeground()) {
			if (simpleWrapableView.getForeground() == null) {
				Object foreground = nativeAddForeGround(this);
				ViewGroupImpl.nativeAddView(simpleWrapableView.asNativeWidget(), foreground);
				simpleWrapableView.setForeground(foreground);
			}
		}
	}

	@Override
	public Object getForeground() {
		return simpleWrapableView.getForeground();
	}

	private void setForegroundFrame(int l, int t, int r, int b) {
		Object foreground = simpleWrapableView.getForeground();
		if (foreground != null) {
			ViewImpl.nativeMakeFrame(foreground, 0, 0, r - l, b - t);
		}
	}

	

	@Override
	public Object asNativeWidget() {
       return simpleWrapableView.asNativeWidget();
	}

	
    private void invalidateWrapViewHolder() {
    	if (isViewWrapped()) {
    		ViewImpl.nativeInvalidate(simpleWrapableView.getWrapperViewHolder());
    	}
	}
    
	@Override
	public Object createWrapperViewHolder(int viewType) {
		Composite parent = (Composite) ViewImpl.getParent(this);
		Composite wrapperComposite = new Composite(parent, getStyle(params, fragment));
        wrapperComposite.setLayout(new org.eclipse.nebula.widgets.layout.AbsoluteLayout());

        return wrapperComposite;	
	}
	//end - body
	//start - allcode
	
	private void nativeCreate(Map<String, Object> params) {
	   measurableImageView.setUsePaddingForBounds(true);
	   registerCommandAttributes();
	}
	private int innerMargin = 0;
	private void nativeMakeFrameForChildWidget(int l, int t, int r, int b) {
		if (simpleWrapableView.isViewWrapped()) {
			ViewImpl.nativeMakeFrame(simpleWrapableView.getWrappedView(), innerMargin, innerMargin, 
					r -l - innerMargin, b -t - innerMargin);
		}
	}


	private void registerCommandAttributes() {
		
	}
   
   public void nativeRequestLayout() {
       for (Object object : getNativeWidgets()) {
    	   ((Control) object).requestLayout();
       }
   }
   
   
   @Override
   public List<Object> getNativeWidgets() {
       return simpleWrapableView.getNativeWidgets();
   } 

	//start - codecopywrapperComposite

   private Rectangle rect;
   
   @Override
   public Object getImage() {
       if (this.imageResizeListener == null) {
    	   if (label.getImage() != null) {
    		   return label.getImage();
    	   }
           return null;
       }
	   return this.imageResizeListener.getImage();
   }

	
	private final class ImageResizeListener implements Listener {
		private final Image image;

		public Image getImage() {
			return image;
		}

		private ImageResizeListener(Image image) {
			this.image = image;
		}

		@Override
		public void handleEvent(org.eclipse.swt.widgets.Event event) {
		    Rectangle bounds = label.getBounds();
		    if (rect == null || !bounds.equals(rect) || (event.data != null && (boolean)event.data)) {
		        rect = label.getBounds();
				Image oldImg = label.getImage();
				
				if (oldImg != this.image && oldImg != null && !oldImg.isDisposed()) {
					internalDisposeImage(oldImg);
				}
			
		        Image scaledimage = (Image)applyScaleType(image, rect.width, 
		                rect.height, measurableImageView.getCropToPadding());
				label.setImage(scaledimage);
		    }
		
		}

	}
	private ImageResizeListener imageResizeListener;

   private void setImage(Object objValue) {
	   measurableImageView.setImageDrawable((r.android.graphics.drawable.Drawable) objValue);
	   setImageNative(((r.android.graphics.drawable.Drawable) objValue).getDrawable());
       
   }
   
	private Object getSrc() {
		return measurableImageView.getImageDrawable();
	}

	private void setImageNative(Object objValue) {
		disposeImage();
		   if (this.imageResizeListener != null) {
			   this.label.removeListener(org.eclipse.swt.SWT.Resize, this.imageResizeListener);
		   }
	
	       if (objValue instanceof Image) {
	           Image image = (Image) objValue;
	           this.imageResizeListener = new ImageResizeListener(image);
	           label.addListener(org.eclipse.swt.SWT.Resize, this.imageResizeListener);
	           if (isInitialised()) {
	        	   rect = null;
	        	   org.eclipse.swt.widgets.Event event = new org.eclipse.swt.widgets.Event();
	        	   this.imageResizeListener.handleEvent(event);
	           }
	           label.setBackground(null);
	       } else if (objValue instanceof Color) {
	    	   this.imageResizeListener = null;
	    	   label.setImage(null);
	    	   label.setBackground((Color) objValue);
	       } else {
	    	   this.imageResizeListener = null;
	    	   label.setImage(null);
	    	   label.setBackground(null);
	       }
	}

	private void disposeImage() {
		if (this.imageResizeListener != null) {
			// clean up images before setting new image
			internalDisposeImage(this.imageResizeListener.getImage());
		}
		
		if (!this.label.isDisposed()) {
			internalDisposeImage(this.label.getImage());
		}
	}
	
	private void internalDisposeImage(Image image) {
		fragment.addDisposable(image);
	}

    // 
    private int extaWidth = 0;
    
	private Object getScaleType() {
		return measurableImageView.getScaleTypeInt();
	}

    private void setScaleType(String strValue, Object objValue) {
    	measurableImageView.setScaleType(strValue, (int) objValue);
    }
    
    private Object applyScaleType(Object image, int width, int height, boolean cropToPadding) {
        com.ashera.model.RectM bounds = measurableImageView.getImageBounds(width, height);
		if (bounds == null || bounds.height == -1 || bounds.width == -1 || width == 0 || height == 0) {
			return image;
		}
		
		com.ashera.model.RectM clip = null;
		if (cropToPadding) {
			clip = measurableImageView.getCropPaddingClipBounds();
		}
		
        com.ashera.common.ImageUtils.ResizeOptions.Builder builder = new com.ashera.common.ImageUtils.ResizeOptions.Builder();
        builder.withBackgroundHint(label.getParent().getBackground()).withUseBackgroundHint(true).initFromAttr(this, "src");
		return com.ashera.common.ImageUtils.resize((Image) image, width, height, bounds, clip, builder.build());
	}

    private void forceRedraw() {
        if (isInitialised()) {
            if (this.imageResizeListener != null) {
                org.eclipse.swt.widgets.Event event = new org.eclipse.swt.widgets.Event();
                event.data = true;
                this.imageResizeListener.handleEvent(event);
            }
        }
    }

    @Override
    public int[] getImageDimension() {        
        Image image = (Image) getImage();
        if (image != null) {
            return new int[] { getImageWidth(image) + extaWidth, 
            		getImageHeight(image) + extaWidth};
        }
        return new int[] {-1, -1};
    }

	private int getImageHeight(Object image) {
		ImageData imageData = ((Image) image).getImageData();
		if (imageData == null) {
			return 0;
		}

		return imageData.height;
	}

	private int getImageWidth(Object image) {
		ImageData imageData = ((Image) image).getImageData();
		if (imageData == null) {
			return 0;
		}
		return imageData.width;
	}

    //start - measurableimageview
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
	
    //end - measurableimageview
	
	//end - codecopywrapperComposite
	//end - allcode

    
	
    private void nativeInvalidate() {
    	forceRedraw();
	}

	private Object nativeAddForeGround(ImageViewImpl imageViewImpl) {
		return null;
	}
	
	@Override
	public Object createWrapperView(Object wrapperParent, int viewType) {
		label = new Label((Composite) wrapperParent, org.eclipse.swt.SWT.NONE);
		label.addDisposeListener((e) -> disposeImage());
		return label;
	}
	//start - imageFromUrl
	private r.android.graphics.drawable.Drawable  imageFromUrlPlaceHolder;

	private void setImageFromUrlPlaceHolder(Object objValue) {
		imageFromUrlPlaceHolder = (r.android.graphics.drawable.Drawable) objValue;
	}  
	
	private r.android.graphics.drawable.Drawable  imageFromUrlError;
	
	private void setImageFromUrlError(Object objValue) {
		imageFromUrlError = (r.android.graphics.drawable.Drawable) objValue;		
	}
	private void setImageFromUrl(Object objValue) {
		measureCalled = false;
		com.ashera.image.ImageDownloaderFactory.get().download(new Context(), (String) objValue, imageFromUrlPlaceHolder, imageFromUrlError,  this);
	}


	@Override
	public void onBitmapLoaded(Object bitmap) {
		r.android.graphics.drawable.Drawable drawable = new r.android.graphics.drawable.Drawable();
		ImageData imageData = (ImageData) ((r.android.graphics.Bitmap) bitmap).getImage();
		drawable.setDrawable(new Image(null, imageData));
		drawable.setMinimumHeight(imageData.height);
		drawable.setMinimumWidth(imageData.width);
		setImage(drawable);
		label.setVisible(true);
		
		if (measureCalled) {
			requestLayout();
			fragment.remeasure();
		}
	}

	@Override
	public void onBitmapFailed(Object errorDrawable) {
		if (imageFromUrlError != null) {
			label.setVisible(true);
			setImage(imageFromUrlError);
			
			if (measureCalled) {
				requestLayout();
				fragment.remeasure();
			}
		}
	
	}

	@Override
	public void onPrepareLoad(Object placeHolderDrawable) {
		if (placeHolderDrawable == null) {
			label.setVisible(false);
		} else {
			setImage(placeHolderDrawable);
		}
	}
	boolean measureCalled = false;

	private void postOnMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		measureCalled = true;
	}

	//end - imageFromUrl


}