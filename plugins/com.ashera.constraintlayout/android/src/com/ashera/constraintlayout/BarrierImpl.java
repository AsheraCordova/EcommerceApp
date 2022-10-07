package com.ashera.constraintlayout;
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
public class BarrierImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "androidx.constraintlayout.widget.Barrier"; 
	public final static String GROUP_NAME = "androidx.constraintlayout.widget.Barrier";

	protected androidx.constraintlayout.widget.Barrier barrier;
	
		@SuppressLint("NewApi")
		final static class BarrierImpl_barrierDirection extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("start",  0x5);
				mapping.put("end",  0x6);
				mapping.put("left",  0x0);
				mapping.put("right",  0x1);
				mapping.put("top",  0x2);
				mapping.put("bottom",  0x3);
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


		ConverterFactory.register("androidx.constraintlayout.widget.Barrier.BarrierImpl.barrierDirection", new BarrierImpl_barrierDirection());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("barrierDirection").withType("androidx.constraintlayout.widget.Barrier.BarrierImpl.barrierDirection"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("constraint_referenced_ids").withType("BarrierImpl.constraintReferencedIds"));
	}
	
	public BarrierImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class BarrierExt extends androidx.constraintlayout.widget.Barrier implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public BarrierExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public BarrierExt(Context context) {
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
				BarrierImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(BarrierImpl.this);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	    ((BarrierExt) barrier).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new BarrierImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		barrier = new BarrierExt(context);
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
			barrier = new BarrierExt(context, null, defStyleAttr);	
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
			case "barrierDirection": {
				


		 setBarrierDirection(objValue);



			}
			break;
			case "constraint_referenced_ids": {
				


		 setConstraintReferenced_ids(objValue);



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
			case "barrierDirection": {
return getBarrierDirection();				}
			case "constraint_referenced_ids": {
return getConstraintReferencedIds();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return barrier;
	}

	

    private void setConstraintReferenced_ids(Object objValue) {
        barrier.setReferencedIds((int[]) objValue);
    }

    private void setBarrierDirection(Object objValue) {
        barrier.setType((int) objValue);

    }
    
    static {
        ConverterFactory.register("BarrierImpl.constraintReferencedIds", new ConstraintReferencedIdsConverter());
    }
    

    
    private Object getConstraintReferencedIds() {
        return barrier.getReferencedIds();
    }
    
    private Object getBarrierDirection() {
        return barrier.getType();
    }
    

	
	    @Override
	    public Object asNativeWidget() {
	        return barrier;
	    }

	    private void nativeCreate(Map<String, Object> params) {
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			barrier.setId(IdGenerator.getId(id));
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
    
	
private BarrierCommandBuilder builder;
private BarrierBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public BarrierBean getBean() {
	if (bean == null) {
		bean = new BarrierBean();
	}
	return bean;
}
public BarrierCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new BarrierCommandBuilder();
	}
	return builder;
}


public  class BarrierCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <BarrierCommandBuilder> {
    public BarrierCommandBuilder() {
	}
	
	public BarrierCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public BarrierCommandBuilder tryGetBarrierDirection() {
	Map<String, Object> attrs = initCommand("barrierDirection");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBarrierDirection() {
	Map<String, Object> attrs = initCommand("barrierDirection");
	return attrs.get("commandReturnValue");
}
public BarrierCommandBuilder setBarrierDirection(String value) {
	Map<String, Object> attrs = initCommand("barrierDirection");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BarrierCommandBuilder tryGetConstraint_referenced_ids() {
	Map<String, Object> attrs = initCommand("constraint_referenced_ids");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getConstraint_referenced_ids() {
	Map<String, Object> attrs = initCommand("constraint_referenced_ids");
	return attrs.get("commandReturnValue");
}
public BarrierCommandBuilder setConstraint_referenced_ids(String value) {
	Map<String, Object> attrs = initCommand("constraint_referenced_ids");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class BarrierBean extends com.ashera.layout.ViewImpl.ViewBean{
		public BarrierBean() {
			super(BarrierImpl.this);
		}
public Object getBarrierDirection() {
	return getBuilder().reset().tryGetBarrierDirection().execute(false).getBarrierDirection(); 
}
public void setBarrierDirection(String value) {
	getBuilder().reset().setBarrierDirection(value).execute(true);
}

public Object getConstraint_referenced_ids() {
	return getBuilder().reset().tryGetConstraint_referenced_ids().execute(false).getConstraint_referenced_ids(); 
}
public void setConstraint_referenced_ids(String value) {
	getBuilder().reset().setConstraint_referenced_ids(value).execute(true);
}

}


    
	//end - body
	
    public void nativeRequestLayout() {
        barrier.getParent().requestLayout();
    } 
}
