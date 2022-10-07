package com.ashera.layout;
//start - imports
import java.util.*;

import androidx.core.view.*;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

import android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;

import static com.ashera.widget.IWidget.*;
//end - imports
public class ViewGroupModelImpl {
	// start - body
	private ViewGroupModelImpl() {
	}
	public static void register(String localName) {
		ViewImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("addModel").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("addAllModel").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("addModelByIndex").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("removeModelAtIndex").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("removeModelById").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelFor").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelIdPath").withType("string"));
		
	}
	
	@SuppressLint("NewApi")
	public static void setAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		//ViewGroup viewGroup = ((ViewGroup) w.asWidget());
		ViewImpl.setAttribute(w, key, strValue, objValue, decorator);
		switch (key.getAttributeName()) {
			case "addModel": {


		 addModel(w, objValue);



			}
			break;
			case "addAllModel": {


		 addAllModel(w, objValue);



			}
			break;
			case "addModelByIndex": {


		addModelByIndex(w, objValue);



			}
			break;
			case "removeModelAtIndex": {


		 removeModelAtIndex(w, objValue);



			}
			break;
			case "removeModelById": {


		 removeModelById(w, objValue);



			}
			break;
			case "modelFor": {


		 setModelFor(w, objValue);



			}
			break;
			case "modelIdPath": {


		setModelIdPath(w, strValue, objValue);



			}
			break;
		default:
			break;
		}
	}
	@SuppressLint("NewApi")
	public static void setChildAttribute(IWidget w, WidgetAttribute key, Object objValue, Object layoutParams) {
	}
	
	@SuppressLint("NewApi")
	public static Object getAttribute(IWidget w, WidgetAttribute key, ILifeCycleDecorator decorator) {
		//ViewGroup viewGroup = ((ViewGroup) w.asWidget());
		Object attributeValue = ViewImpl.getAttribute(w, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		
		switch (key.getAttributeName()) {
			case "modelIdPath": {				
return getModelIdPath(w);			}
		}
		return null;
	}
	
	@SuppressLint("NewApi")
	public static Object getChildAttribute(IWidget w, WidgetAttribute key) {
		//View viewGroup = ((View) w.asWidget());
		
		return null;
	}
	
	
	
	@SuppressLint("NewApi")
	public static boolean isAttributeSupported(WidgetAttribute key) {
		switch (key.getAttributeName()) {
			case "addModel": {
				return true;
			}
			case "addAllModel": {
				return true;
			}
			case "addModelByIndex": {
				return true;
			}
			case "removeModelAtIndex": {
				return true;
			}
			case "removeModelById": {
				return true;
			}
			case "modelFor": {
				return true;
			}
			case "modelIdPath": {
				return true;
			}
		default:
			break;
		}
		return false;
	}

	


public static abstract class ViewGroupModelCommandBuilder<T> extends com.ashera.layout.ViewImpl.ViewCommandBuilder<T> {
    public ViewGroupModelCommandBuilder() {
	}
	

public T addModel(Object value) {
	Map<String, Object> attrs = initCommand("addModel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T addAllModel(Object value) {
	Map<String, Object> attrs = initCommand("addAllModel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T addModelByIndex(Object value,Object index) {
	Map<String, Object> attrs = initCommand("addModelByIndex");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("index", index);
	wrapper.put("data", value);
	attrs.put("value", wrapper);
return (T) this;}
public T removeModelAtIndex(int value) {
	Map<String, Object> attrs = initCommand("removeModelAtIndex");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T removeModelById(String value) {
	Map<String, Object> attrs = initCommand("removeModelById");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setModelFor(String value) {
	Map<String, Object> attrs = initCommand("modelFor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetModelIdPath() {
	Map<String, Object> attrs = initCommand("modelIdPath");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getModelIdPath() {
	Map<String, Object> attrs = initCommand("modelIdPath");
	return attrs.get("commandReturnValue");
}
public T setModelIdPath(String value) {
	Map<String, Object> attrs = initCommand("modelIdPath");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
}
static class ViewGroupModelCommandBuilderInternal extends ViewGroupModelCommandBuilder<ViewGroupModelCommandBuilderInternal> {
	private IWidget widget;
	public ViewGroupModelCommandBuilderInternal(IWidget widget) {
		this.widget = widget;
	}
	@Override
	protected ViewGroupModelCommandBuilderInternal execute(boolean setter) {
		if (setter) {
			widget.executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			widget.getFragment().remeasure();
		}
		widget.executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);

		return this;
	}
}
public static class ViewGroupModelBean extends com.ashera.layout.ViewImpl.ViewBean{
	private ViewGroupModelCommandBuilderInternal commandBuilder;
	public ViewGroupModelBean(IWidget widget) {
		super(widget);
		commandBuilder = new ViewGroupModelCommandBuilderInternal(widget);
	}
	private ViewGroupModelCommandBuilderInternal getBuilder() {
		return commandBuilder;
	}
public void addModel(Object value) {
	getBuilder().reset().addModel(value).execute(true);
}

public void addAllModel(Object value) {
	getBuilder().reset().addAllModel(value).execute(true);
}

public void addModelByIndex(Object value,Object index) {
	getBuilder().reset().addModelByIndex(value,index).execute(true);
}

public void removeModelAtIndex(int value) {
	getBuilder().reset().removeModelAtIndex(value).execute(true);
}

public void removeModelById(String value) {
	getBuilder().reset().removeModelById(value).execute(true);
}

public void setModelFor(String value) {
	getBuilder().reset().setModelFor(value).execute(true);
}

public Object getModelIdPath() {
	return getBuilder().reset().tryGetModelIdPath().execute(false).getModelIdPath(); 
}
public void setModelIdPath(String value) {
	getBuilder().reset().setModelIdPath(value).execute(true);
}

}


	// end - body
	//start - viewcode
	private static void removeModelAtIndex(IWidget w, Object objValue) {
	    ((HasWidgets)w).removeModelAtIndex((int) objValue);
	}
	
	private static void addModelByIndex(IWidget w, Object objValue) {
	    Map<String, Object> model = PluginInvoker.getMap(objValue);
	    int index = PluginInvoker.getInt(model.get("index"));
	    ((HasWidgets)w).addModel(model.get("data"), index);
	    
	}
	
	
	private static void addModel(IWidget w, Object objValue) {
		((HasWidgets)w).addModel(objValue);
	}
	
	
	
	private static void removeModelById(IWidget w, Object objValue) {
		((HasWidgets)w).removeModelById(PluginInvoker.getString(objValue)); 		
	}
	
	
	private static void setModelFor(IWidget w, Object objValue) {
		((HasWidgets)w).setModelFor((String) objValue); 
	}
	
	private static void setModelIdPath(IWidget w, String strValue, Object objValue) {
		w.setModelIdPath((String) objValue);				
	}
	
	private static Object getModelIdPath(IWidget w) {
		return w.getModelIdPath();
	}
	private static void addAllModel(IWidget w, Object objValue) {
		((HasWidgets)w).addAllModel(objValue);
	}
	//end - viewcode
}
