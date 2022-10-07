package com.ashera.constraintlayout;
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
]-*/

import com.google.j2objc.annotations.Property;

import static com.ashera.widget.IWidget.*;
//end - imports
/*-[
#include "ASUIView.h"
]-*/
@SuppressLint("NewApi")
public class GuidelineImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "androidx.constraintlayout.widget.Guideline"; 
	public final static String GROUP_NAME = "androidx.constraintlayout.widget.Guideline";

	protected @Property Object uiView;
	protected androidx.constraintlayout.widget.Guideline guideline;		
	
		@SuppressLint("NewApi")
		final static class Orientation extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("horizontal",  0x0);
				mapping.put("vertical",  0x1);
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


		ConverterFactory.register("androidx.constraintlayout.widget.Guideline.orientation", new Orientation());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("orientation").withType("androidx.constraintlayout.widget.Guideline.orientation"));
	}
	
	public GuidelineImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

@com.google.j2objc.annotations.WeakOuter		
	public class GuidelineExt extends androidx.constraintlayout.widget.Guideline implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public GuidelineExt() {
			
			
			super();
			
			
			
			
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
			ViewImpl.setDrawableBounds(GuidelineImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(GuidelineImpl.this);
			
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
				GuidelineImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(GuidelineImpl.this);
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
		((GuidelineExt) guideline).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new GuidelineImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		guideline = new GuidelineExt();
		nativeCreate(params);	
		ViewImpl.registerCommandConveter(this);
		setWidgetOnNativeClass();
	}
	private native void setWidgetOnNativeClass() /*-[
		((ASUIView*) self.uiView).widget = self;
	]-*/;

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this,  key, strValue, objValue, decorator);
		
		switch (key.getAttributeName()) {
			case "orientation": {
				


		 setOrientation(objValue);



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
			case "orientation": {
return getOrientation();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return guideline;
	}

	

    
    private void setOrientation(Object objValue) {
        ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams)guideline.getLayoutParams()).orientation = (Integer) objValue;
        ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams)guideline.getLayoutParams()).validate();
    }

	
	private Object getOrientation() {
		return ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams)guideline.getLayoutParams()).orientation;
	}

    

	
		@Override
	    public Object asNativeWidget() {
	        return uiView;
	    }
	    public native boolean checkIosVersion(String v) /*-[
			return ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedDescending);
		]-*/;
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			guideline.setId(IdGenerator.getId(id));
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
    
	
private GuidelineCommandBuilder builder;
private GuidelineBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public GuidelineBean getBean() {
	if (bean == null) {
		bean = new GuidelineBean();
	}
	return bean;
}
public GuidelineCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new GuidelineCommandBuilder();
	}
	return builder;
}


public  class GuidelineCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <GuidelineCommandBuilder> {
    public GuidelineCommandBuilder() {
	}
	
	public GuidelineCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public GuidelineCommandBuilder tryGetOrientation() {
	Map<String, Object> attrs = initCommand("orientation");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getOrientation() {
	Map<String, Object> attrs = initCommand("orientation");
	return attrs.get("commandReturnValue");
}
public GuidelineCommandBuilder setOrientation(String value) {
	Map<String, Object> attrs = initCommand("orientation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class GuidelineBean extends com.ashera.layout.ViewImpl.ViewBean{
		public GuidelineBean() {
			super(GuidelineImpl.this);
		}
public Object getOrientation() {
	return getBuilder().reset().tryGetOrientation().execute(false).getOrientation(); 
}
public void setOrientation(String value) {
	getBuilder().reset().setOrientation(value).execute(true);
}

}


    
	//end - body

	 public native void nativeCreate(Map<String, Object> params)/*-[
		ASUIView* uiView = [ASUIView new];
		uiView.backgroundColor = [UIColor clearColor];
		uiView_ = uiView;
	]-*/;
}
