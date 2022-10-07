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
@SuppressLint("NewApi")
public class ImageButtonImpl extends BaseWidget implements com.ashera.image.ITarget{
	//start - body
	public final static String LOCAL_NAME = "ImageButton"; 
	public final static String GROUP_NAME = "ImageButton";

	protected android.widget.ImageButton imageButton;
	
		@SuppressLint("NewApi")
		final static class ScaleType  extends AbstractStringToEnumConverter{
		private Map<String, Object> mapping = new HashMap<>();
				{
		
				mapping.put("center", android.widget.ImageView.ScaleType.CENTER);
		
		
				mapping.put("centerCrop", android.widget.ImageView.ScaleType.CENTER_CROP);
		
		
				mapping.put("centerInside", android.widget.ImageView.ScaleType.CENTER_INSIDE);
		
		
				mapping.put("fitCenter", android.widget.ImageView.ScaleType.FIT_CENTER);
		
		
				mapping.put("fitEnd", android.widget.ImageView.ScaleType.FIT_END);
		
		
				mapping.put("fitStart", android.widget.ImageView.ScaleType.FIT_START);
		
		
				mapping.put("fitXY", android.widget.ImageView.ScaleType.FIT_XY);
		
		
				mapping.put("matrix", android.widget.ImageView.ScaleType.MATRIX);
		
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
		final static class TintMode  extends AbstractStringToEnumConverter{
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


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("adjustViewBounds").withType("boolean").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baseline").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("baselineAlignBottom").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("cropToPadding").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		ConverterFactory.register("ImageButton.scaleType", new ScaleType());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scaleType").withType("ImageButton.scaleType"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("tint").withType("colorstate"));
		ConverterFactory.register("ImageButton.tintMode", new TintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("tintMode").withType("ImageButton.tintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("src").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrl").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrlPlaceHolder").withType("drawable").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("imageFromUrlError").withType("drawable").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension"));
	}
	
	public ImageButtonImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class ImageButtonExt extends android.widget.ImageButton implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public ImageButtonExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

	    public ImageButtonExt(Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
	    	super(context, attrs, defStyleAttr, defStyleRes);
	    }
		public ImageButtonExt(Context context) {
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
				ImageButtonImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(ImageButtonImpl.this);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	    ((ImageButtonExt) imageButton).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new ImageButtonImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		imageButton = new ImageButtonExt(context);
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
			imageButton = new ImageButtonExt(context, null, defStyleAttr);	
		} else {
			imageButton = new ImageButtonExt(context, null, defStyleAttr, defStyleRes);
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
			case "adjustViewBounds": {
				


	imageButton.setAdjustViewBounds((boolean)objValue);



			}
			break;
			case "baseline": {
				
if (Build.VERSION.SDK_INT >= 11) {

	imageButton.setBaseline((int)objValue);

}

			}
			break;
			case "baselineAlignBottom": {
				
if (Build.VERSION.SDK_INT >= 11) {

	imageButton.setBaselineAlignBottom((boolean)objValue);

}

			}
			break;
			case "cropToPadding": {
				
if (Build.VERSION.SDK_INT >= 16) {

	imageButton.setCropToPadding((boolean)objValue);

}

			}
			break;
			case "maxHeight": {
				


	imageButton.setMaxHeight((int)objValue);



			}
			break;
			case "maxWidth": {
				


	imageButton.setMaxWidth((int)objValue);



			}
			break;
			case "scaleType": {
				


	imageButton.setScaleType((android.widget.ImageView.ScaleType)objValue);



			}
			break;
			case "tint": {
				
if (Build.VERSION.SDK_INT >= 21) {

	imageButton.setImageTintList((android.content.res.ColorStateList)objValue);

}

			}
			break;
			case "tintMode": {
				
if (Build.VERSION.SDK_INT >= 21) {

	imageButton.setImageTintMode((android.graphics.PorterDuff.Mode)objValue);

}

			}
			break;
			case "src": {
				


		setSrc(objValue);



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
			case "adjustViewBounds": {
return imageButton.getAdjustViewBounds();				}
			case "baseline": {
return imageButton.getBaseline();				}
			case "baselineAlignBottom": {
if (Build.VERSION.SDK_INT >= 11) {
return imageButton.getBaselineAlignBottom();
}
break;				}
			case "cropToPadding": {
if (Build.VERSION.SDK_INT >= 16) {
return imageButton.getCropToPadding();
}
break;				}
			case "maxHeight": {
return imageButton.getMaxHeight();				}
			case "maxWidth": {
return imageButton.getMaxWidth();				}
			case "scaleType": {
return imageButton.getScaleType();				}
			case "tint": {
if (Build.VERSION.SDK_INT >= 21) {
return imageButton.getImageTintList();
}
break;				}
			case "tintMode": {
if (Build.VERSION.SDK_INT >= 21) {
return imageButton.getImageTintMode();
}
break;				}
			case "src": {
return getSrc();				}
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
		return imageButton;
	}

	

	private Drawable  imageFromUrlPlaceHolder;
	private Drawable  imageFromUrlError;
	
	private void setImageFromUrlError(Object objValue) {
		imageFromUrlError = (android.graphics.drawable.Drawable) objValue;		
	}
    private void setSrc(Object objValue) {
    	imageButton.setImageDrawable((android.graphics.drawable.Drawable) objValue);
    }
	
	private void setImageFromUrlPlaceHolder(Object objValue) {
		imageFromUrlPlaceHolder = (android.graphics.drawable.Drawable) objValue;
	}    
	
	private Object getSrc() {
		return imageButton.getDrawable();
	}
	private void setImageFromUrl(Object objValue) {
		com.ashera.image.ImageDownloaderFactory.get().download(imageButton.getContext(), (String) objValue, imageFromUrlPlaceHolder, imageFromUrlError,  this);
	}


	@Override
	public void onBitmapLoaded(Object bitmap) {
		imageButton.setImageBitmap((android.graphics.Bitmap) bitmap);
	}

	@Override
	public void onBitmapFailed(Object errorDrawable) {
		if (errorDrawable != null) {
			imageButton.setImageDrawable((Drawable) errorDrawable);
		}
		
	}

	@Override
	public void onPrepareLoad(Object placeHolderDrawable) {
		if (placeHolderDrawable == null) {
			imageButton.setImageDrawable(new android.graphics.drawable.ColorDrawable(imageButton.getContext().getColor(android.R.color.transparent)));
		} else {
			imageButton.setImageDrawable((Drawable) placeHolderDrawable);
		}
		
	}

    

	
	    @Override
	    public Object asNativeWidget() {
	        return imageButton;
	    }

	    private void nativeCreate(Map<String, Object> params) {
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			imageButton.setId(IdGenerator.getId(id));
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
public ImageButtonCommandBuilder tryGetCropToPadding() {
	Map<String, Object> attrs = initCommand("cropToPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isCropToPadding() {
	Map<String, Object> attrs = initCommand("cropToPadding");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setCropToPadding(boolean value) {
	Map<String, Object> attrs = initCommand("cropToPadding");
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
public ImageButtonCommandBuilder setScaleType(ScaleType value) {
	Map<String, Object> attrs = initCommand("scaleType");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetTint() {
	Map<String, Object> attrs = initCommand("tint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTint() {
	Map<String, Object> attrs = initCommand("tint");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setTint(String value) {
	Map<String, Object> attrs = initCommand("tint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ImageButtonCommandBuilder tryGetTintMode() {
	Map<String, Object> attrs = initCommand("tintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getTintMode() {
	Map<String, Object> attrs = initCommand("tintMode");
	return attrs.get("commandReturnValue");
}
public ImageButtonCommandBuilder setTintMode(TintMode value) {
	Map<String, Object> attrs = initCommand("tintMode");
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
public ImageButtonCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
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
public Object isAdjustViewBounds() {
	return getBuilder().reset().tryGetAdjustViewBounds().execute(false).isAdjustViewBounds(); 
}
public void setAdjustViewBounds(boolean value) {
	getBuilder().reset().setAdjustViewBounds(value).execute(true);
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

public Object getScaleType() {
	return getBuilder().reset().tryGetScaleType().execute(false).getScaleType(); 
}
public void setScaleType(ScaleType value) {
	getBuilder().reset().setScaleType(value).execute(true);
}

public Object getTint() {
	return getBuilder().reset().tryGetTint().execute(false).getTint(); 
}
public void setTint(String value) {
	getBuilder().reset().setTint(value).execute(true);
}

public Object getTintMode() {
	return getBuilder().reset().tryGetTintMode().execute(false).getTintMode(); 
}
public void setTintMode(TintMode value) {
	getBuilder().reset().setTintMode(value).execute(true);
}

public Object getSrc() {
	return getBuilder().reset().tryGetSrc().execute(false).getSrc(); 
}
public void setSrc(String value) {
	getBuilder().reset().setSrc(value).execute(true);
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

}


    
	//end - body

}
