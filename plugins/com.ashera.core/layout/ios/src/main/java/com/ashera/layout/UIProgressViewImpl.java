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
#include "ASUIScrollView.h"
#include "ASUIView.h"
]-*/

import com.google.j2objc.annotations.Property;

import static com.ashera.widget.IWidget.*;
//end - imports
/*-[
#include "ASUIProgressView.h"
]-*/

@SuppressLint("NewApi")
public class UIProgressViewImpl extends BaseWidget  implements ICustomMeasureHeight, ICustomMeasureWidth {
	private final static String FOREGROUND_REGEX = "none";
	private final static String VIEW_HOLDER_REGEX = "none";
	private final static String WIDGET_REGEX = null;

	//start - body
	public final static String LOCAL_NAME = "UIProgressView"; 
	public final static String GROUP_NAME = "ProgressBar";

	protected @Property Object uiView;
	protected MeasurableView measurableView;		
	
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosProgressTintColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosProgressImage").withType("image"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosTrackTintColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosTrackImage").withType("image"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("max").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("min").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progress").withType("int").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("incrementProgressBy").withType("int").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progressTint").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("progressBackgroundTint").withType("colorstate"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("indeterminate").withType("boolean"));
	}
	
	public UIProgressViewImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

@com.google.j2objc.annotations.WeakOuter		
	public class UIProgressViewExt extends MeasurableView implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public UIProgressViewExt() {
			
			
			
			super(UIProgressViewImpl.this);
			
			
			
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
			ViewImpl.setDrawableBounds(UIProgressViewImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			nativeMakeFrameForChildWidget(l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(UIProgressViewImpl.this);
			
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
				UIProgressViewImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(UIProgressViewImpl.this);
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
	}	
	public void updateMeasuredDimension(int width, int height) {
		((UIProgressViewExt) measurableView).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new UIProgressViewImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		measurableView = new UIProgressViewExt();
		createSimpleWrapableView();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
		setWidgetOnNativeClass();
	}
	private native void setWidgetOnNativeClass() /*-[
		((ASUIProgressView*) self.uiView).widget = self;
	]-*/;

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = simpleWrapableView.getWrappedView();
		ViewImpl.setAttribute(this, simpleWrapableView, key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "iosProgressTintColor": {
				


		setProgressTintColor(nativeWidget, objValue);



			}
			break;
			case "iosProgressImage": {
				


		setProgressImage(nativeWidget, objValue);



			}
			break;
			case "iosTrackTintColor": {
				


		setTrackTintColor(nativeWidget, objValue);



			}
			break;
			case "iosTrackImage": {
				


		setTrackImage(nativeWidget, objValue);



			}
			break;
			case "max": {
				


		setMax(objValue);



			}
			break;
			case "min": {
				


		setMin(objValue);



			}
			break;
			case "progress": {
				


		setProgress(objValue);



			}
			break;
			case "incrementProgressBy": {
				


		incrementProgressBy(objValue);



			}
			break;
			case "progressTint": {
				


		setProgressTint(objValue);



			}
			break;
			case "progressBackgroundTint": {
				


		setProgressBackgroundTint(objValue);



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
			case "iosProgressTintColor": {
return getProgressTintColor();				}
			case "iosProgressImage": {
return getProgressImage();				}
			case "iosTrackTintColor": {
return getTrackTintColor();				}
			case "iosTrackImage": {
return getTrackImage();				}
			case "progressTint": {
return getProgressTint();				}
			case "progressBackgroundTint": {
return getProgressBackgroundTint();				}
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
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return measurableView;
	}

	

	private Object getPaddingBottom() {
		return measurableView.getPaddingBottom();
	}
	
	private Object getPaddingTop() {
		return measurableView.getPaddingTop();
	}

	private Object getPaddingRight() {
		return measurableView.getPaddingRight();
	}
	
	private Object getPaddingLeft() {
		return measurableView.getPaddingLeft();
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
		ViewImpl.setPaddingTop(objValue, measurableView);
	}

	private void setPaddingEnd(Object objValue) {
		ViewImpl.setPaddingRight(objValue, measurableView);
	}

	private void setPaddingStart(Object objValue) {
		ViewImpl.setPaddingLeft(objValue, measurableView);
	}

	private void setPaddingLeft(Object objValue) {
		ViewImpl.setPaddingLeft(objValue, measurableView);
	}

	private void setPaddingRight(Object objValue) {
		ViewImpl.setPaddingRight(objValue, measurableView);
	}

	private void setPaddingBottom(Object objValue) {
		ViewImpl.setPaddingBottom(objValue, measurableView);
	}

    private void setPadding(Object objValue) {
    	setPaddingBottom(objValue);
    	setPaddingTop(objValue);
    	setPaddingRight(objValue);
    	setPaddingLeft(objValue);
    }

    


	private void nativeMakeFrameForChildWidget(int l, int t, int r, int b) {
		if (isViewWrapped()) {
			Object progressView = simpleWrapableView.getWrappedView();
			ViewImpl.updateBounds(progressView, measurableView.getPaddingStart(), measurableView.getPaddingTop(), r - l - measurableView.getPaddingStart() - measurableView.getPaddingEnd(), 
					b - t - measurableView.getPaddingTop() - measurableView.getPaddingBottom());
		}
	}
	
	@Override
	public int measureWidth() {
		int width = measurableView.nativeMeasureWidth(uiView);
		return width;
	}

	@Override
	public int measureHeight(int width) {
		int height = measurableView.nativeMeasureHeight(uiView, width);
		return height;
	}
	

	public native void setProgressTintColor(Object nativeWidget, Object value) /*-[
((ASUIProgressView*) nativeWidget).progressTintColor = (UIColor*) value;
]-*/;
	public native Object getProgressTintColor() /*-[
return ((ASUIProgressView*) uiView_).progressTintColor;
  ]-*/;
	public native void setProgressImage(Object nativeWidget, Object value) /*-[
((ASUIProgressView*) nativeWidget).progressImage = (UIImage*) value;
]-*/;
	public native Object getProgressImage() /*-[
return ((ASUIProgressView*) uiView_).progressImage;
  ]-*/;
	public native void setTrackTintColor(Object nativeWidget, Object value) /*-[
((ASUIProgressView*) nativeWidget).trackTintColor = (UIColor*) value;
]-*/;
	public native Object getTrackTintColor() /*-[
return ((ASUIProgressView*) uiView_).trackTintColor;
  ]-*/;
	public native void setTrackImage(Object nativeWidget, Object value) /*-[
((ASUIProgressView*) nativeWidget).trackImage = (UIImage*) value;
]-*/;
	public native Object getTrackImage() /*-[
return ((ASUIProgressView*) uiView_).trackImage;
  ]-*/;
	
	    public native boolean checkIosVersion(String v) /*-[
			return ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedDescending);
		]-*/;
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			measurableView.setId(IdGenerator.getId(id));
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
			if (isViewWrapped()) {
				ViewImpl.invalidate(this, simpleWrapableView.getWrappedView());
				if (simpleWrapableView.getForeground() != null) {
					ViewImpl.invalidate(this, simpleWrapableView.getForeground());
				}
			}			
    	}
    }
    
	
private UIProgressViewCommandBuilder builder;
private UIProgressViewBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public UIProgressViewBean getBean() {
	if (bean == null) {
		bean = new UIProgressViewBean();
	}
	return bean;
}
public UIProgressViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new UIProgressViewCommandBuilder();
	}
	return builder;
}


public  class UIProgressViewCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <UIProgressViewCommandBuilder> {
    public UIProgressViewCommandBuilder() {
	}
	
	public UIProgressViewCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public UIProgressViewCommandBuilder tryGetIosProgressTintColor() {
	Map<String, Object> attrs = initCommand("iosProgressTintColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosProgressTintColor() {
	Map<String, Object> attrs = initCommand("iosProgressTintColor");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setIosProgressTintColor(String value) {
	Map<String, Object> attrs = initCommand("iosProgressTintColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetIosProgressImage() {
	Map<String, Object> attrs = initCommand("iosProgressImage");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosProgressImage() {
	Map<String, Object> attrs = initCommand("iosProgressImage");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setIosProgressImage(String value) {
	Map<String, Object> attrs = initCommand("iosProgressImage");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetIosTrackTintColor() {
	Map<String, Object> attrs = initCommand("iosTrackTintColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosTrackTintColor() {
	Map<String, Object> attrs = initCommand("iosTrackTintColor");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setIosTrackTintColor(String value) {
	Map<String, Object> attrs = initCommand("iosTrackTintColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetIosTrackImage() {
	Map<String, Object> attrs = initCommand("iosTrackImage");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getIosTrackImage() {
	Map<String, Object> attrs = initCommand("iosTrackImage");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setIosTrackImage(String value) {
	Map<String, Object> attrs = initCommand("iosTrackImage");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder setMax(int value) {
	Map<String, Object> attrs = initCommand("max");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder setMin(int value) {
	Map<String, Object> attrs = initCommand("min");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder setProgress(int value) {
	Map<String, Object> attrs = initCommand("progress");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder incrementProgressBy(int value) {
	Map<String, Object> attrs = initCommand("incrementProgressBy");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetProgressTint() {
	Map<String, Object> attrs = initCommand("progressTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getProgressTint() {
	Map<String, Object> attrs = initCommand("progressTint");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setProgressTint(String value) {
	Map<String, Object> attrs = initCommand("progressTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetProgressBackgroundTint() {
	Map<String, Object> attrs = initCommand("progressBackgroundTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getProgressBackgroundTint() {
	Map<String, Object> attrs = initCommand("progressBackgroundTint");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setProgressBackgroundTint(String value) {
	Map<String, Object> attrs = initCommand("progressBackgroundTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public UIProgressViewCommandBuilder setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public UIProgressViewCommandBuilder setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class UIProgressViewBean extends com.ashera.layout.ViewImpl.ViewBean{
		public UIProgressViewBean() {
			super(UIProgressViewImpl.this);
		}
public Object getIosProgressTintColor() {
	return getBuilder().reset().tryGetIosProgressTintColor().execute(false).getIosProgressTintColor(); 
}
public void setIosProgressTintColor(String value) {
	getBuilder().reset().setIosProgressTintColor(value).execute(true);
}

public Object getIosProgressImage() {
	return getBuilder().reset().tryGetIosProgressImage().execute(false).getIosProgressImage(); 
}
public void setIosProgressImage(String value) {
	getBuilder().reset().setIosProgressImage(value).execute(true);
}

public Object getIosTrackTintColor() {
	return getBuilder().reset().tryGetIosTrackTintColor().execute(false).getIosTrackTintColor(); 
}
public void setIosTrackTintColor(String value) {
	getBuilder().reset().setIosTrackTintColor(value).execute(true);
}

public Object getIosTrackImage() {
	return getBuilder().reset().tryGetIosTrackImage().execute(false).getIosTrackImage(); 
}
public void setIosTrackImage(String value) {
	getBuilder().reset().setIosTrackImage(value).execute(true);
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

public void incrementProgressBy(int value) {
	getBuilder().reset().incrementProgressBy(value).execute(true);
}

public Object getProgressTint() {
	return getBuilder().reset().tryGetProgressTint().execute(false).getProgressTint(); 
}
public void setProgressTint(String value) {
	getBuilder().reset().setProgressTint(value).execute(true);
}

public Object getProgressBackgroundTint() {
	return getBuilder().reset().tryGetProgressBackgroundTint().execute(false).getProgressBackgroundTint(); 
}
public void setProgressBackgroundTint(String value) {
	getBuilder().reset().setProgressBackgroundTint(value).execute(true);
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
	public Object createWrapperView(Object wrapperParent, int viewtype) {
		uiView = nativeCreateView(viewtype);
		ViewGroupImpl.nativeAddView(ViewImpl.getFirstChildOrSelf(wrapperParent), uiView);
		return uiView;
	}


	@Override
	public Object createWrapperViewHolder(int viewType) {
		return createWrapperViewHolderNative(viewType);
	}
	public native Object nativeAddForeGround(IWidget w) /*-[
		ASUIView* uiView = [ASUIView new];
		uiView.widget = w;
		uiView.commandRegex  = ASUIProgressViewImpl_FOREGROUND_REGEX; 
		uiView.backgroundColor = [UIColor clearColor];
		return uiView;
	]-*/;
	 public native Object createWrapperViewHolderNative(int viewType)/*-[
	 	if (viewType == 1) {
			ASUIView* uiView = [ASUIView new];
			uiView.widget = self;
			uiView.commandRegex  = ASUIProgressViewImpl_VIEW_HOLDER_REGEX; 
			uiView.backgroundColor = [UIColor clearColor];
			
			return uiView;
		}
		
		if (viewType == 2 || viewType == 3) {
			ASUIView* uiView = [ASUIView new];
			uiView.widget = self;
			uiView.backgroundColor = [UIColor clearColor];
			uiView.commandRegex  = ASUIProgressViewImpl_VIEW_HOLDER_REGEX; 

			ASUIScrollView* scrollview = [ASUIScrollView new];
			scrollview.scrollEnabled=YES;
			scrollview.bounces=NO;
			scrollview.preventAutoScroll=YES;
	    	scrollview.delaysContentTouches=YES;
	    	scrollview.userInteractionEnabled=YES;
			scrollview.widget = self;
			scrollview.backgroundColor = [UIColor clearColor];
			scrollview.commandRegex  = @"none";
			[uiView addSubview:scrollview];
			return uiView;
		}
		
		return nil;
	]-*/;
	 
	private native Object getScrollView() /*-[
		UIView* uiview = (UIView*)[self->simpleWrapableView_ getWrapperViewHolder];
		return uiview.subviews[0];
	]-*/;
	//end - body
	private int max = 100;
	private int min = 0;
	private int progress;
	private void incrementProgressBy(Object objValue) {
		setProgress(progress + (int) objValue);
	}
	
	private void setProgress(Object objValue) {
		progress = (int) objValue;
		
		if (progress < min) {
			progress = min;
		}
		nativeSetProgress((progress) / (max * 1f));
	}
	
	private native void nativeSetProgress(float progress)/*-[
		[(ASUIProgressView*)self.uiView setProgress: progress animated: YES];
	]-*/;



	private native Object nativeCreateView(int viewtype) /*-[
		return [[ASUIProgressView alloc] initWithProgressViewStyle:UIProgressViewStyleDefault];
	]-*/;
	private void setMin(Object objValue) {
		this.min = (int) objValue;
	}
	
	private void setMax(Object objValue) {
		this.max = (int) objValue;
	}
	
	private void nativeCreate(Map<String, Object> params) {
		simpleWrapableView.setDisableForeground(true);
	}
	
	
	private Object progressTint;
	private void setProgressTint(Object objValue) {
		progressTint = objValue;
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			objValue = colorStateList.getColorForState(measurableView.getDrawableState(), r.android.graphics.Color.RED);
		}
		Object color = ViewImpl.getColor(objValue);
		setProgressTintColor(asNativeWidget(), color);
	}

	private Object getProgressTint() {
		return progressTint;
	}
	
	private Object progressTintBackground;
	private void setProgressBackgroundTint(Object objValue) {
		progressTintBackground = objValue;
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			objValue = colorStateList.getColorForState(measurableView.getDrawableState(), r.android.graphics.Color.RED);
		}
		Object color = ViewImpl.getColor(objValue);
		setTrackTintColor(asNativeWidget(), color);
	}

	private Object getProgressBackgroundTint() {
		return progressTintBackground;
	}
}
