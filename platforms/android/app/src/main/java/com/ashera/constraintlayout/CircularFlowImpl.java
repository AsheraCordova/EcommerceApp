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
public class CircularFlowImpl extends BaseWidget {
	//start - body
	public final static String LOCAL_NAME = "androidx.constraintlayout.helper.widget.CircularFlow"; 
	public final static String GROUP_NAME = "androidx.constraintlayout.helper.widget.CircularFlow";

	protected androidx.constraintlayout.helper.widget.CircularFlow circularFlow;
	
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("circularflow_radiusInDP").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("circularflow_angles").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("circularflow_viewCenter").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("circularflow_defaultRadius").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("circularflow_defaultAngle").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("constraint_referenced_ids").withType("CircularFlowImpl.constraintReferencedIds"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("addViewToCircularFlow").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("updateReference").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("updateRadius").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("updateAngle").withType("object"));
	}
	
	public CircularFlowImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}

		
	public class CircularFlowExt extends androidx.constraintlayout.helper.widget.CircularFlow implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
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

		public CircularFlowExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public CircularFlowExt(Context context) {
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
				CircularFlowImpl.this.invalidate();
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
        	ViewImpl.drawableStateChanged(CircularFlowImpl.this);
        }
	}	
	public void updateMeasuredDimension(int width, int height) {
	    ((CircularFlowExt) circularFlow).updateMeasuredDimension(width, height);
	}

	@Override
	public IWidget newInstance() {
		return new CircularFlowImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		circularFlow = new CircularFlowExt(context);
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
			circularFlow = new CircularFlowExt(context, null, defStyleAttr);	
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
			case "circularflow_radiusInDP": {
				


		 setRadiusInDP(objValue);



			}
			break;
			case "circularflow_angles": {
				


		 setAngles(objValue);



			}
			break;
			case "circularflow_viewCenter": {
				


		 setViewCenter(objValue);



			}
			break;
			case "circularflow_defaultRadius": {
				


	circularFlow.setDefaultRadius((int)objValue);



			}
			break;
			case "circularflow_defaultAngle": {
				


	circularFlow.setDefaultAngle((float)objValue);



			}
			break;
			case "constraint_referenced_ids": {
				


		 setConstraintReferenced_ids(objValue);



			}
			break;
			case "addViewToCircularFlow": {
				
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object viewId = quickConvert(data.get("viewId"), "id");
		Object radius = quickConvert(data.get("radius"), "int");
		Object angle = quickConvert(data.get("angle"), "float");


		 addViewToCircularFlow ((int) viewId,(int)radius, (float)angle);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object viewId = quickConvert(data.get("viewId"), "id");
		Object radius = quickConvert(data.get("radius"), "int");
		Object angle = quickConvert(data.get("angle"), "float");


		 addViewToCircularFlow ((int) viewId,(int)radius, (float)angle);


	}
}
			}
			break;
			case "updateReference": {
				
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object viewId = quickConvert(data.get("viewId"), "id");
		Object radius = quickConvert(data.get("radius"), "int");
		Object angle = quickConvert(data.get("angle"), "float");


		 updateReference ((int) viewId,(int)radius, (float)angle);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object viewId = quickConvert(data.get("viewId"), "id");
		Object radius = quickConvert(data.get("radius"), "int");
		Object angle = quickConvert(data.get("angle"), "float");


		 updateReference ((int) viewId,(int)radius, (float)angle);


	}
}
			}
			break;
			case "updateRadius": {
				
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object viewId = quickConvert(data.get("viewId"), "id");
		Object radius = quickConvert(data.get("radius"), "int");


		 updateRadius ((int) viewId,(int)radius);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object viewId = quickConvert(data.get("viewId"), "id");
		Object radius = quickConvert(data.get("radius"), "int");


		 updateRadius ((int) viewId,(int)radius);


	}
}
			}
			break;
			case "updateAngle": {
				
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object viewId = quickConvert(data.get("viewId"), "id");
		Object angle = quickConvert(data.get("angle"), "float");


		 updateAngle ((int) viewId, (float)angle);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object viewId = quickConvert(data.get("viewId"), "id");
		Object angle = quickConvert(data.get("angle"), "float");


		 updateAngle ((int) viewId, (float)angle);


	}
}
			}
			break;
		default:
			break;
		}
		postSetAttribute(key, strValue, objValue, decorator);
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
			case "constraint_referenced_ids": {
return getConstraintReferencedIds();				}
		}
		
		return null;
	}
	
	@Override
	public Object asWidget() {
		return circularFlow;
	}

	

    
    static {
        ConverterFactory.register("CircularFlowImpl.constraintReferencedIds", new ConstraintReferencedIdsConverter());
    }
    private void setConstraintReferenced_ids(Object objValue) {
        circularFlow.setReferencedIds((int[]) objValue);
    }
    
    private Object getConstraintReferencedIds() {
        return circularFlow.getReferencedIds();
    }
    

	
	    @Override
	    public Object asNativeWidget() {
	        return circularFlow;
	    }

	    private void nativeCreate(Map<String, Object> params) {
	    }
	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			circularFlow.setId(IdGenerator.getId(id));
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
    
	
private CircularFlowCommandBuilder builder;
private CircularFlowBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public CircularFlowBean getBean() {
	if (bean == null) {
		bean = new CircularFlowBean();
	}
	return bean;
}
public CircularFlowCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new CircularFlowCommandBuilder();
	}
	return builder;
}


public  class CircularFlowCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <CircularFlowCommandBuilder> {
    public CircularFlowCommandBuilder() {
	}
	
	public CircularFlowCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public CircularFlowCommandBuilder setCircularflow_radiusInDP(String value) {
	Map<String, Object> attrs = initCommand("circularflow_radiusInDP");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CircularFlowCommandBuilder setCircularflow_angles(String value) {
	Map<String, Object> attrs = initCommand("circularflow_angles");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CircularFlowCommandBuilder setCircularflow_viewCenter(String value) {
	Map<String, Object> attrs = initCommand("circularflow_viewCenter");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CircularFlowCommandBuilder setCircularflow_defaultRadius(String value) {
	Map<String, Object> attrs = initCommand("circularflow_defaultRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CircularFlowCommandBuilder setCircularflow_defaultAngle(float value) {
	Map<String, Object> attrs = initCommand("circularflow_defaultAngle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CircularFlowCommandBuilder tryGetConstraint_referenced_ids() {
	Map<String, Object> attrs = initCommand("constraint_referenced_ids");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getConstraint_referenced_ids() {
	Map<String, Object> attrs = initCommand("constraint_referenced_ids");
	return attrs.get("commandReturnValue");
}
public CircularFlowCommandBuilder setConstraint_referenced_ids(String value) {
	Map<String, Object> attrs = initCommand("constraint_referenced_ids");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CircularFlowCommandBuilder addViewToCircularFlow(String viewId,
int radius,
float angle) {
	Map<String, Object> attrs = initCommand("addViewToCircularFlow");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("viewId", viewId);
	wrapper.put("radius", radius);
	wrapper.put("angle", angle);
	attrs.put("value", wrapper);
return this;}
public CircularFlowCommandBuilder updateReference(String viewId,
int radius,
float angle) {
	Map<String, Object> attrs = initCommand("updateReference");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("viewId", viewId);
	wrapper.put("radius", radius);
	wrapper.put("angle", angle);
	attrs.put("value", wrapper);
return this;}
public CircularFlowCommandBuilder updateRadius(String viewId,
int radius) {
	Map<String, Object> attrs = initCommand("updateRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("viewId", viewId);
	wrapper.put("radius", radius);
	attrs.put("value", wrapper);
return this;}
public CircularFlowCommandBuilder updateAngle(String viewId,
float angle) {
	Map<String, Object> attrs = initCommand("updateAngle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("viewId", viewId);
	wrapper.put("angle", angle);
	attrs.put("value", wrapper);
return this;}
}
public class CircularFlowBean extends com.ashera.layout.ViewImpl.ViewBean{
		public CircularFlowBean() {
			super(CircularFlowImpl.this);
		}
public void setCircularflow_radiusInDP(String value) {
	getBuilder().reset().setCircularflow_radiusInDP(value).execute(true);
}

public void setCircularflow_angles(String value) {
	getBuilder().reset().setCircularflow_angles(value).execute(true);
}

public void setCircularflow_viewCenter(String value) {
	getBuilder().reset().setCircularflow_viewCenter(value).execute(true);
}

public void setCircularflow_defaultRadius(String value) {
	getBuilder().reset().setCircularflow_defaultRadius(value).execute(true);
}

public void setCircularflow_defaultAngle(float value) {
	getBuilder().reset().setCircularflow_defaultAngle(value).execute(true);
}

public Object getConstraint_referenced_ids() {
	return getBuilder().reset().tryGetConstraint_referenced_ids().execute(false).getConstraint_referenced_ids(); 
}
public void setConstraint_referenced_ids(String value) {
	getBuilder().reset().setConstraint_referenced_ids(value).execute(true);
}

public void addViewToCircularFlow(String viewId,
int radius,
float angle) {
	getBuilder().reset().addViewToCircularFlow(viewId,
radius,
angle).execute(true);
}

public void updateReference(String viewId,
int radius,
float angle) {
	getBuilder().reset().updateReference(viewId,
radius,
angle).execute(true);
}

public void updateRadius(String viewId,
int radius) {
	getBuilder().reset().updateRadius(viewId,
radius).execute(true);
}

public void updateAngle(String viewId,
float angle) {
	getBuilder().reset().updateAngle(viewId,
angle).execute(true);
}

}


    
	//end - body


	private void setViewCenter(Object objValue) {
		setFieldUsingReflection(circularFlow, "mViewCenter", objValue);
	}
	
	private void setAngles(Object objValue) {
		initAngles();
		invokePrivateMethodUsingReflection(circularFlow, "setAngles", objValue);
	}
	
	private void setRadiusInDP(Object objValue) {
		initRadius();
		invokePrivateMethodUsingReflection(circularFlow, "setRadius", objValue);
	}
	
	private void postSetAttribute(WidgetAttribute key, String strValue, Object objValue,
			ILifeCycleDecorator decorator) {
		
		switch (key.getAttributeName()) {
		case "circularflow_defaultRadius": 
			setFieldUsingReflection(circularFlow, "mReferenceDefaultRadius", objValue);
			break;
		case "circularflow_defaultAngle": 
			setFieldUsingReflection(circularFlow, "mReferenceDefaultAngle", objValue);
			break;
		}
		if (isInitialised()) {
			invokePrivateMethodUsingReflection(circularFlow, "onAttachedToWindow");
		}
	}
	private void addViewToCircularFlow(int viewId, int radius, float angle) {
		circularFlow.addViewToCircularFlow((View) getParent().findWidgetById(IdGenerator.getName(viewId)).asWidget(), radius, angle);
	}

	private void initRadius() {
		try {
			circularFlow.getRadius();
		} catch (Exception e) {
			setFieldUsingReflection(circularFlow, "mRadius", new int[1]);
		}
	}

	private void initAngles() {
		try {
			circularFlow.getAngles();
		} catch (Exception e) {
			setFieldUsingReflection(circularFlow, "mAngles", new float[1]);
		}
	}
	
	private void updateAngle(int viewId, float angle) {
		circularFlow.updateAngle((View) getParent().findWidgetById(IdGenerator.getName(viewId)).asWidget(), angle);
		
	}

	private void updateRadius(int viewId, int radius) {
		circularFlow.updateRadius((View) getParent().findWidgetById(IdGenerator.getName(viewId)).asWidget(), radius);
		
	}

	private void updateReference(int viewId, int radius, float angle) {
		circularFlow.updateReference((View) getParent().findWidgetById(IdGenerator.getName(viewId)).asWidget(), radius, angle);
		
	}


}
