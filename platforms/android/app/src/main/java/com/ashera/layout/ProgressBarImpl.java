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

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

@SuppressLint("NewApi")
public class ProgressBarImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "ProgressBar"; 
	public final static String GROUP_NAME = "ProgressBar";

	protected android.widget.ProgressBar progressBar;
	
		@SuppressLint("NewApi")
		final static class IndeterminateTintMode  extends AbstractStringToEnumConverter{
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
		final static class BackgroundTintMode  extends AbstractStringToEnumConverter{
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
		final static class ProgressTintMode  extends AbstractStringToEnumConverter{
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
		final static class SecondaryProgressTintMode  extends AbstractStringToEnumConverter{
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


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("indeterminate").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("indeterminateDrawable").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("indeterminateTint").withType("colorstate"));
		ConverterFactory.register("ProgressBar.indeterminateTintMode", new IndeterminateTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("indeterminateTintMode").withType("ProgressBar.indeterminateTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("max").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("min").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progress").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progressBackgroundTint").withType("colorstate"));
		ConverterFactory.register("ProgressBar.backgroundTintMode", new BackgroundTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progressBackgroundTintMode").withType("ProgressBar.backgroundTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progressDrawable").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progressTint").withType("colorstate"));
		ConverterFactory.register("ProgressBar.progressTintMode", new ProgressTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progressTintMode").withType("ProgressBar.progressTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("secondaryProgress").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("secondaryProgressTint").withType("colorstate"));
		ConverterFactory.register("ProgressBar.secondaryProgressTintMode", new SecondaryProgressTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("secondaryProgressTintMode").withType("ProgressBar.secondaryProgressTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("incrementProgressBy").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("incrementSecondaryProgressBy").withType("int"));
	}
	
	public ProgressBarImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class ProgressBarExt extends android.widget.ProgressBar implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private int mMaxWidth = -1;
		private int mMaxHeight = -1;
		@Override
		public void setMaxWidth(int width) {
			mMaxWidth = width;
		}
		@Override
		public void setMaxHeight(int height) {
			mMaxHeight = height;
		}
		@Override
		public int getMaxWidth() {
			return mMaxWidth;
		}
		@Override
		public int getMaxHeight() {
			return mMaxHeight;
		}

		public ProgressBarExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

	    public ProgressBarExt(Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
	    	super(context, attrs, defStyleAttr, defStyleRes);
	    }
		public ProgressBarExt(Context context) {
			super(context);
			
			
			
			
			
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			if(mMaxWidth > 0) {
	        	widthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxWidth, MeasureSpec.AT_MOST);
	        }
	        if(mMaxHeight > 0) {
	            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);

	        }

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
				ProgressBarImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(ProgressBarImpl.this);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	    ((ProgressBarExt) progressBar).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new ProgressBarImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		progressBar = new ProgressBarExt(context);
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
			progressBar = new ProgressBarExt(context, null, defStyleAttr);	
		} else {
			progressBar = new ProgressBarExt(context, null, defStyleAttr, defStyleRes);
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
			case "indeterminate": {
				


	progressBar.setIndeterminate((boolean)objValue);



			}
			break;
			case "indeterminateDrawable": {
				


	progressBar.setIndeterminateDrawable((Drawable)objValue);



			}
			break;
			case "indeterminateTint": {
				


	progressBar.setIndeterminateTintList((ColorStateList)objValue);



			}
			break;
			case "indeterminateTintMode": {
				


	progressBar.setIndeterminateTintMode((android.graphics.PorterDuff.Mode)objValue);



			}
			break;
			case "max": {
				


	progressBar.setMax((int)objValue);



			}
			break;
			case "min": {
				


	progressBar.setMin((int)objValue);



			}
			break;
			case "progress": {
				


	progressBar.setProgress((int)objValue);



			}
			break;
			case "progressBackgroundTint": {
				


	progressBar.setProgressBackgroundTintList((ColorStateList)objValue);



			}
			break;
			case "progressBackgroundTintMode": {
				


	progressBar.setProgressBackgroundTintMode((android.graphics.PorterDuff.Mode)objValue);



			}
			break;
			case "progressDrawable": {
				


	progressBar.setProgressDrawable((Drawable)objValue);



			}
			break;
			case "progressTint": {
				


	progressBar.setProgressTintList((ColorStateList)objValue);



			}
			break;
			case "progressTintMode": {
				


	progressBar.setProgressTintMode((android.graphics.PorterDuff.Mode)objValue);



			}
			break;
			case "secondaryProgress": {
				


	progressBar.setSecondaryProgress((int)objValue);



			}
			break;
			case "secondaryProgressTint": {
				


	progressBar.setSecondaryProgressTintList((ColorStateList)objValue);



			}
			break;
			case "secondaryProgressTintMode": {
				


	progressBar.setSecondaryProgressTintMode((android.graphics.PorterDuff.Mode)objValue);



			}
			break;
			case "incrementProgressBy": {
				


	progressBar.incrementProgressBy((int)objValue);



			}
			break;
			case "incrementSecondaryProgressBy": {
				


	progressBar.incrementSecondaryProgressBy((int)objValue);



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
			case "indeterminateTint": {
return progressBar.getIndeterminateTintList();				}
			case "indeterminateTintMode": {
return progressBar.getIndeterminateTintMode();				}
			case "progressBackgroundTint": {
return progressBar.getProgressBackgroundTintList();				}
			case "progressBackgroundTintMode": {
return progressBar.getProgressBackgroundTintMode();				}
			case "progressTint": {
return progressBar.getProgressTintList();				}
			case "progressTintMode": {
return progressBar.getProgressTintMode();				}
			case "secondaryProgressTint": {
return progressBar.getSecondaryProgressTintList();				}
			case "secondaryProgressTintMode": {
return progressBar.getSecondaryProgressTintMode();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return progressBar;
	}

	
	
	    @Override
	    public Object asNativeWidget() {
	        return progressBar;
	    }

	    private void nativeCreate(Map<String, Object> params) {
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			progressBar.setId(IdGenerator.getId(id));
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
    
	
private ProgressBarCommandBuilder builder;
private ProgressBarBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ProgressBarBean getBean() {
	if (bean == null) {
		bean = new ProgressBarBean();
	}
	return bean;
}
public ProgressBarCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ProgressBarCommandBuilder();
	}
	return builder;
}


public  class ProgressBarCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <ProgressBarCommandBuilder> {
    public ProgressBarCommandBuilder() {
	}
	
	public ProgressBarCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ProgressBarCommandBuilder setIndeterminate(boolean value) {
	Map<String, Object> attrs = initCommand("indeterminate");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder setIndeterminateDrawable(String value) {
	Map<String, Object> attrs = initCommand("indeterminateDrawable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder tryGetIndeterminateTint() {
	Map<String, Object> attrs = initCommand("indeterminateTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIndeterminateTint() {
	Map<String, Object> attrs = initCommand("indeterminateTint");
	return attrs.get("commandReturnValue");
}
public ProgressBarCommandBuilder setIndeterminateTint(String value) {
	Map<String, Object> attrs = initCommand("indeterminateTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder tryGetIndeterminateTintMode() {
	Map<String, Object> attrs = initCommand("indeterminateTintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIndeterminateTintMode() {
	Map<String, Object> attrs = initCommand("indeterminateTintMode");
	return attrs.get("commandReturnValue");
}
public ProgressBarCommandBuilder setIndeterminateTintMode(IndeterminateTintMode value) {
	Map<String, Object> attrs = initCommand("indeterminateTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder setMax(int value) {
	Map<String, Object> attrs = initCommand("max");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder setMin(int value) {
	Map<String, Object> attrs = initCommand("min");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder setProgress(int value) {
	Map<String, Object> attrs = initCommand("progress");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder tryGetProgressBackgroundTint() {
	Map<String, Object> attrs = initCommand("progressBackgroundTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getProgressBackgroundTint() {
	Map<String, Object> attrs = initCommand("progressBackgroundTint");
	return attrs.get("commandReturnValue");
}
public ProgressBarCommandBuilder setProgressBackgroundTint(String value) {
	Map<String, Object> attrs = initCommand("progressBackgroundTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder tryGetProgressBackgroundTintMode() {
	Map<String, Object> attrs = initCommand("progressBackgroundTintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getProgressBackgroundTintMode() {
	Map<String, Object> attrs = initCommand("progressBackgroundTintMode");
	return attrs.get("commandReturnValue");
}
public ProgressBarCommandBuilder setProgressBackgroundTintMode(BackgroundTintMode value) {
	Map<String, Object> attrs = initCommand("progressBackgroundTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder setProgressDrawable(String value) {
	Map<String, Object> attrs = initCommand("progressDrawable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder tryGetProgressTint() {
	Map<String, Object> attrs = initCommand("progressTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getProgressTint() {
	Map<String, Object> attrs = initCommand("progressTint");
	return attrs.get("commandReturnValue");
}
public ProgressBarCommandBuilder setProgressTint(String value) {
	Map<String, Object> attrs = initCommand("progressTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder tryGetProgressTintMode() {
	Map<String, Object> attrs = initCommand("progressTintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getProgressTintMode() {
	Map<String, Object> attrs = initCommand("progressTintMode");
	return attrs.get("commandReturnValue");
}
public ProgressBarCommandBuilder setProgressTintMode(ProgressTintMode value) {
	Map<String, Object> attrs = initCommand("progressTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder setSecondaryProgress(int value) {
	Map<String, Object> attrs = initCommand("secondaryProgress");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder tryGetSecondaryProgressTint() {
	Map<String, Object> attrs = initCommand("secondaryProgressTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSecondaryProgressTint() {
	Map<String, Object> attrs = initCommand("secondaryProgressTint");
	return attrs.get("commandReturnValue");
}
public ProgressBarCommandBuilder setSecondaryProgressTint(String value) {
	Map<String, Object> attrs = initCommand("secondaryProgressTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder tryGetSecondaryProgressTintMode() {
	Map<String, Object> attrs = initCommand("secondaryProgressTintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getSecondaryProgressTintMode() {
	Map<String, Object> attrs = initCommand("secondaryProgressTintMode");
	return attrs.get("commandReturnValue");
}
public ProgressBarCommandBuilder setSecondaryProgressTintMode(SecondaryProgressTintMode value) {
	Map<String, Object> attrs = initCommand("secondaryProgressTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder incrementProgressBy(int value) {
	Map<String, Object> attrs = initCommand("incrementProgressBy");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ProgressBarCommandBuilder incrementSecondaryProgressBy(int value) {
	Map<String, Object> attrs = initCommand("incrementSecondaryProgressBy");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ProgressBarBean extends com.ashera.layout.ViewImpl.ViewBean{
		public ProgressBarBean() {
			super(ProgressBarImpl.this);
		}
public void setIndeterminate(boolean value) {
	getBuilder().reset().setIndeterminate(value).execute(true);
}

public void setIndeterminateDrawable(String value) {
	getBuilder().reset().setIndeterminateDrawable(value).execute(true);
}

public Object getIndeterminateTint() {
	return getBuilder().reset().tryGetIndeterminateTint().execute(false).getIndeterminateTint(); 
}
public void setIndeterminateTint(String value) {
	getBuilder().reset().setIndeterminateTint(value).execute(true);
}

public Object getIndeterminateTintMode() {
	return getBuilder().reset().tryGetIndeterminateTintMode().execute(false).getIndeterminateTintMode(); 
}
public void setIndeterminateTintMode(IndeterminateTintMode value) {
	getBuilder().reset().setIndeterminateTintMode(value).execute(true);
}

public void setMax(int value) {
	getBuilder().reset().setMax(value).execute(true);
}

public void setMin(int value) {
	getBuilder().reset().setMin(value).execute(true);
}

public void setProgress(int value) {
	getBuilder().reset().setProgress(value).execute(true);
}

public Object getProgressBackgroundTint() {
	return getBuilder().reset().tryGetProgressBackgroundTint().execute(false).getProgressBackgroundTint(); 
}
public void setProgressBackgroundTint(String value) {
	getBuilder().reset().setProgressBackgroundTint(value).execute(true);
}

public Object getProgressBackgroundTintMode() {
	return getBuilder().reset().tryGetProgressBackgroundTintMode().execute(false).getProgressBackgroundTintMode(); 
}
public void setProgressBackgroundTintMode(BackgroundTintMode value) {
	getBuilder().reset().setProgressBackgroundTintMode(value).execute(true);
}

public void setProgressDrawable(String value) {
	getBuilder().reset().setProgressDrawable(value).execute(true);
}

public Object getProgressTint() {
	return getBuilder().reset().tryGetProgressTint().execute(false).getProgressTint(); 
}
public void setProgressTint(String value) {
	getBuilder().reset().setProgressTint(value).execute(true);
}

public Object getProgressTintMode() {
	return getBuilder().reset().tryGetProgressTintMode().execute(false).getProgressTintMode(); 
}
public void setProgressTintMode(ProgressTintMode value) {
	getBuilder().reset().setProgressTintMode(value).execute(true);
}

public void setSecondaryProgress(int value) {
	getBuilder().reset().setSecondaryProgress(value).execute(true);
}

public Object getSecondaryProgressTint() {
	return getBuilder().reset().tryGetSecondaryProgressTint().execute(false).getSecondaryProgressTint(); 
}
public void setSecondaryProgressTint(String value) {
	getBuilder().reset().setSecondaryProgressTint(value).execute(true);
}

public Object getSecondaryProgressTintMode() {
	return getBuilder().reset().tryGetSecondaryProgressTintMode().execute(false).getSecondaryProgressTintMode(); 
}
public void setSecondaryProgressTintMode(SecondaryProgressTintMode value) {
	getBuilder().reset().setSecondaryProgressTintMode(value).execute(true);
}

public void incrementProgressBy(int value) {
	getBuilder().reset().incrementProgressBy(value).execute(true);
}

public void incrementSecondaryProgressBy(int value) {
	getBuilder().reset().incrementSecondaryProgressBy(value).execute(true);
}

}


    
	//end - body
}
