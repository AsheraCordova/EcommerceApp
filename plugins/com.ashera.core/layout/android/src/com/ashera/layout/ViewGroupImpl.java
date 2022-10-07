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
public class ViewGroupImpl {
	// start - body
	private ViewGroupImpl() {
	}
		@SuppressLint("NewApi")
		final static class DescendantFocusability extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("afterDescendants",  0x40000);
				mapping.put("beforeDescendants",  0x20000);
				mapping.put("blocksDescendants",  0x60000);
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
		final static class LayoutMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("clipBounds",  0x0);
				mapping.put("opticalBounds",  0x1);
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
		final static class PersistentDrawingCache  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("all", 0x3);
				mapping.put("animation", 0x1);
				mapping.put("none", 0x0);
				mapping.put("scrolling", 0x2);
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
	public static void register(String localName) {
		ViewGroupModelImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("alwaysDrawnWithCache").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("animationCache").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("clipChildren").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("clipToPadding").withType("boolean"));
		ConverterFactory.register("ViewGroup.descendantFocusability", new DescendantFocusability());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("descendantFocusability").withType("ViewGroup.descendantFocusability"));
		ConverterFactory.register("ViewGroup.layoutMode", new LayoutMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layoutMode").withType("ViewGroup.layoutMode"));
		ConverterFactory.register("ViewGroup.persistentDrawingCache", new PersistentDrawingCache());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("persistentDrawingCache").withType("ViewGroup.persistentDrawingCache"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("splitMotionEvents").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onChildViewAdded").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onChildViewRemoved").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("animateLayoutChanges").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("listitem").withType("template"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("addStatesFromChildren").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("childXml").withType("resourcestring"));
		
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginBottom").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginTop").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginStart").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginEnd").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginLeft").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginRight").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_margin").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginHorizontal").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginVertical").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_width").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_height").withType("dimension").forChild());
	}
	
	@SuppressLint("NewApi")
	public static void setAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroup viewGroup = ((ViewGroup) w.asWidget());
		ViewGroupModelImpl.setAttribute(w, key, strValue, objValue, decorator);
		switch (key.getAttributeName()) {
			case "alwaysDrawnWithCache": {


	viewGroup.setAlwaysDrawnWithCacheEnabled((boolean)objValue);



			}
			break;
			case "animationCache": {


	viewGroup.setAnimationCacheEnabled((boolean)objValue);



			}
			break;
			case "clipChildren": {


	viewGroup.setClipChildren((boolean)objValue);



			}
			break;
			case "clipToPadding": {


	viewGroup.setClipToPadding((boolean)objValue);



			}
			break;
			case "descendantFocusability": {


	viewGroup.setDescendantFocusability((int)objValue);



			}
			break;
			case "layoutMode": {
if (Build.VERSION.SDK_INT >= 18) {

	viewGroup.setLayoutMode((int)objValue);

}

			}
			break;
			case "persistentDrawingCache": {


	viewGroup.setPersistentDrawingCache((int)objValue);



			}
			break;
			case "splitMotionEvents": {
if (Build.VERSION.SDK_INT >= 11) {

	viewGroup.setMotionEventSplittingEnabled((boolean)objValue);

}

			}
			break;
			case "onChildViewAdded": {


		if (objValue instanceof String) {viewGroup.setOnHierarchyChangeListener(new OnHierarchyChangeListener(w, strValue));} else {setOnHierarchyChangeListener(viewGroup, objValue);}



			}
			break;
			case "onChildViewRemoved": {


		if (objValue instanceof String) {viewGroup.setOnHierarchyChangeListener(new OnHierarchyChangeListener(w, strValue));} else {setOnHierarchyChangeListener(viewGroup, objValue);}



			}
			break;
			case "animateLayoutChanges": {


		animateLayoutChanges(objValue, viewGroup);



			}
			break;
			case "listitem": {


		 addTemplate(w, objValue);



			}
			break;
			case "addStatesFromChildren": {


		 viewGroup.setAddStatesFromChildren((boolean) objValue);



			}
			break;
			case "childXml": {


		 setChild(w, objValue);



			}
			break;
		default:
			break;
		}
	}
	@SuppressLint("NewApi")
	public static void setChildAttribute(IWidget w, WidgetAttribute key, Object objValue, Object layoutParams) {
		switch (key.getAttributeName()) {
			case "layout_marginBottom": {
				
							setBottomMargin(objValue, layoutParams);
				
			}
			break;
			case "layout_marginTop": {
				
							setTopMargin(objValue, layoutParams);
				
			}
			break;
			case "layout_marginStart": {
				if (Build.VERSION.SDK_INT >= 17) {
							setStartMargin(objValue, layoutParams, w);
				}
			}
			break;
			case "layout_marginEnd": {
				if (Build.VERSION.SDK_INT >= 17) {
							setEndMargin(objValue, layoutParams, w);
				}
			}
			break;
			case "layout_marginLeft": {
				
							setLeftMargin(objValue, layoutParams, w);
				
			}
			break;
			case "layout_marginRight": {
				
							setRightMargin(objValue, layoutParams, w);
				
			}
			break;
			case "layout_margin": {
				
							setMargin(objValue, layoutParams, w);
				
			}
			break;
			case "layout_marginHorizontal": {
				
							setHorizontalMargin(objValue, layoutParams, w);
				
			}
			break;
			case "layout_marginVertical": {
				
							setVerticalMargin(objValue, layoutParams, w);
				
			}
			break;
		default:
			break;
		}
	}
	
	@SuppressLint("NewApi")
	public static Object getAttribute(IWidget w, WidgetAttribute key, ILifeCycleDecorator decorator) {
		ViewGroup viewGroup = ((ViewGroup) w.asWidget());
		Object attributeValue = ViewGroupModelImpl.getAttribute(w, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		
		switch (key.getAttributeName()) {
			case "alwaysDrawnWithCache": {				
return viewGroup.isAlwaysDrawnWithCacheEnabled();			}
			case "animationCache": {				
return viewGroup.isAnimationCacheEnabled();			}
			case "clipChildren": {				
if (Build.VERSION.SDK_INT >= 18) {
return viewGroup.getClipChildren();
}
break;			}
			case "clipToPadding": {				
return viewGroup.getClipToPadding();			}
			case "descendantFocusability": {				
return viewGroup.getDescendantFocusability();			}
			case "layoutMode": {				
if (Build.VERSION.SDK_INT >= 18) {
return viewGroup.getLayoutMode();
}
break;			}
			case "persistentDrawingCache": {				
return viewGroup.getPersistentDrawingCache();			}
			case "splitMotionEvents": {				
if (Build.VERSION.SDK_INT >= 11) {
return viewGroup.isMotionEventSplittingEnabled();
}
break;			}
			case "addStatesFromChildren": {				
return viewGroup.addStatesFromChildren();			}
		}
		return null;
	}
	
	@SuppressLint("NewApi")
	public static Object getChildAttribute(IWidget w, WidgetAttribute key) {
		View viewGroup = ((View) w.asWidget());
		
		switch (key.getAttributeName()) {
			case "layout_marginBottom": {				
return getBottomMargin(viewGroup);			}
			case "layout_marginTop": {				
return getTopMargin(viewGroup);			}
			case "layout_marginStart": {				
return getLeftMargin(viewGroup);			}
			case "layout_marginEnd": {				
return getRightMargin(viewGroup);			}
			case "layout_marginLeft": {				
return getLeftMargin(viewGroup);			}
			case "layout_marginRight": {				
return getRightMargin(viewGroup);			}
		}
		return null;
	}
	
	
	@SuppressLint("NewApi")
private static class OnHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnHierarchyChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnHierarchyChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onChildViewAdded (View parent, 
                View child){
    
	if (action == null || action.equals("onChildViewAdded")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onChildViewAdded");
	    java.util.Map<String, Object> obj = getOnChildViewAddedEventObj(parent,child);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, parent,child);
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
public void onChildViewRemoved (View parent, 
                View child){
    
	if (action == null || action.equals("onChildViewRemoved")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onChildViewRemoved");
	    java.util.Map<String, Object> obj = getOnChildViewRemovedEventObj(parent,child);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, parent,child);
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

public java.util.Map<String, Object> getOnChildViewRemovedEventObj(View parent,View child) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "childviewremoved");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onChildViewRemoved", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}

public java.util.Map<String, Object> getOnChildViewAddedEventObj(View parent,View child) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "childviewadded");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onChildViewAdded", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	
	@SuppressLint("NewApi")
	public static boolean isAttributeSupported(WidgetAttribute key) {
		switch (key.getAttributeName()) {
			case "alwaysDrawnWithCache": {
				return true;
			}
			case "animationCache": {
				return true;
			}
			case "clipChildren": {
				return true;
			}
			case "clipToPadding": {
				return true;
			}
			case "descendantFocusability": {
				return true;
			}
			case "layoutMode": {
				return true;
			}
			case "persistentDrawingCache": {
				return true;
			}
			case "splitMotionEvents": {
				return true;
			}
			case "onChildViewAdded": {
				return true;
			}
			case "onChildViewRemoved": {
				return true;
			}
			case "animateLayoutChanges": {
				return true;
			}
			case "listitem": {
				return true;
			}
			case "addStatesFromChildren": {
				return true;
			}
			case "childXml": {
				return true;
			}
		default:
			break;
		}
		return false;
	}

	


public static abstract class ViewGroupCommandBuilder<T> extends com.ashera.layout.ViewGroupModelImpl.ViewGroupModelCommandBuilder<T> {
    public ViewGroupCommandBuilder() {
	}
	

public T tryGetAlwaysDrawnWithCache() {
	Map<String, Object> attrs = initCommand("alwaysDrawnWithCache");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isAlwaysDrawnWithCache() {
	Map<String, Object> attrs = initCommand("alwaysDrawnWithCache");
	return attrs.get("commandReturnValue");
}
public T setAlwaysDrawnWithCache(boolean value) {
	Map<String, Object> attrs = initCommand("alwaysDrawnWithCache");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetAnimationCache() {
	Map<String, Object> attrs = initCommand("animationCache");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isAnimationCache() {
	Map<String, Object> attrs = initCommand("animationCache");
	return attrs.get("commandReturnValue");
}
public T setAnimationCache(boolean value) {
	Map<String, Object> attrs = initCommand("animationCache");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetClipChildren() {
	Map<String, Object> attrs = initCommand("clipChildren");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isClipChildren() {
	Map<String, Object> attrs = initCommand("clipChildren");
	return attrs.get("commandReturnValue");
}
public T setClipChildren(boolean value) {
	Map<String, Object> attrs = initCommand("clipChildren");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetClipToPadding() {
	Map<String, Object> attrs = initCommand("clipToPadding");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isClipToPadding() {
	Map<String, Object> attrs = initCommand("clipToPadding");
	return attrs.get("commandReturnValue");
}
public T setClipToPadding(boolean value) {
	Map<String, Object> attrs = initCommand("clipToPadding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetDescendantFocusability() {
	Map<String, Object> attrs = initCommand("descendantFocusability");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getDescendantFocusability() {
	Map<String, Object> attrs = initCommand("descendantFocusability");
	return attrs.get("commandReturnValue");
}
public T setDescendantFocusability(String value) {
	Map<String, Object> attrs = initCommand("descendantFocusability");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetLayoutMode() {
	Map<String, Object> attrs = initCommand("layoutMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getLayoutMode() {
	Map<String, Object> attrs = initCommand("layoutMode");
	return attrs.get("commandReturnValue");
}
public T setLayoutMode(String value) {
	Map<String, Object> attrs = initCommand("layoutMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetPersistentDrawingCache() {
	Map<String, Object> attrs = initCommand("persistentDrawingCache");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getPersistentDrawingCache() {
	Map<String, Object> attrs = initCommand("persistentDrawingCache");
	return attrs.get("commandReturnValue");
}
public T setPersistentDrawingCache(String value) {
	Map<String, Object> attrs = initCommand("persistentDrawingCache");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetSplitMotionEvents() {
	Map<String, Object> attrs = initCommand("splitMotionEvents");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isSplitMotionEvents() {
	Map<String, Object> attrs = initCommand("splitMotionEvents");
	return attrs.get("commandReturnValue");
}
public T setSplitMotionEvents(boolean value) {
	Map<String, Object> attrs = initCommand("splitMotionEvents");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnChildViewAdded(String value) {
	Map<String, Object> attrs = initCommand("onChildViewAdded");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnChildViewRemoved(String value) {
	Map<String, Object> attrs = initCommand("onChildViewRemoved");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setAnimateLayoutChanges(boolean value) {
	Map<String, Object> attrs = initCommand("animateLayoutChanges");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setListitem(String value) {
	Map<String, Object> attrs = initCommand("listitem");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetAddStatesFromChildren() {
	Map<String, Object> attrs = initCommand("addStatesFromChildren");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isAddStatesFromChildren() {
	Map<String, Object> attrs = initCommand("addStatesFromChildren");
	return attrs.get("commandReturnValue");
}
public T setAddStatesFromChildren(boolean value) {
	Map<String, Object> attrs = initCommand("addStatesFromChildren");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setChildXml(String value) {
	Map<String, Object> attrs = initCommand("childXml");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
}
static class ViewGroupCommandBuilderInternal extends ViewGroupCommandBuilder<ViewGroupCommandBuilderInternal> {
	private IWidget widget;
	public ViewGroupCommandBuilderInternal(IWidget widget) {
		this.widget = widget;
	}
	@Override
	protected ViewGroupCommandBuilderInternal execute(boolean setter) {
		if (setter) {
			widget.executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			widget.getFragment().remeasure();
		}
		widget.executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);

		return this;
	}
}
public static class ViewGroupBean extends com.ashera.layout.ViewGroupModelImpl.ViewGroupModelBean{
	private ViewGroupCommandBuilderInternal commandBuilder;
	public ViewGroupBean(IWidget widget) {
		super(widget);
		commandBuilder = new ViewGroupCommandBuilderInternal(widget);
	}
	private ViewGroupCommandBuilderInternal getBuilder() {
		return commandBuilder;
	}
public Object isAlwaysDrawnWithCache() {
	return getBuilder().reset().tryGetAlwaysDrawnWithCache().execute(false).isAlwaysDrawnWithCache(); 
}
public void setAlwaysDrawnWithCache(boolean value) {
	getBuilder().reset().setAlwaysDrawnWithCache(value).execute(true);
}

public Object isAnimationCache() {
	return getBuilder().reset().tryGetAnimationCache().execute(false).isAnimationCache(); 
}
public void setAnimationCache(boolean value) {
	getBuilder().reset().setAnimationCache(value).execute(true);
}

public Object isClipChildren() {
	return getBuilder().reset().tryGetClipChildren().execute(false).isClipChildren(); 
}
public void setClipChildren(boolean value) {
	getBuilder().reset().setClipChildren(value).execute(true);
}

public Object isClipToPadding() {
	return getBuilder().reset().tryGetClipToPadding().execute(false).isClipToPadding(); 
}
public void setClipToPadding(boolean value) {
	getBuilder().reset().setClipToPadding(value).execute(true);
}

public Object getDescendantFocusability() {
	return getBuilder().reset().tryGetDescendantFocusability().execute(false).getDescendantFocusability(); 
}
public void setDescendantFocusability(String value) {
	getBuilder().reset().setDescendantFocusability(value).execute(true);
}

public Object getLayoutMode() {
	return getBuilder().reset().tryGetLayoutMode().execute(false).getLayoutMode(); 
}
public void setLayoutMode(String value) {
	getBuilder().reset().setLayoutMode(value).execute(true);
}

public Object getPersistentDrawingCache() {
	return getBuilder().reset().tryGetPersistentDrawingCache().execute(false).getPersistentDrawingCache(); 
}
public void setPersistentDrawingCache(String value) {
	getBuilder().reset().setPersistentDrawingCache(value).execute(true);
}

public Object isSplitMotionEvents() {
	return getBuilder().reset().tryGetSplitMotionEvents().execute(false).isSplitMotionEvents(); 
}
public void setSplitMotionEvents(boolean value) {
	getBuilder().reset().setSplitMotionEvents(value).execute(true);
}

public void setOnChildViewAdded(String value) {
	getBuilder().reset().setOnChildViewAdded(value).execute(true);
}

public void setOnChildViewRemoved(String value) {
	getBuilder().reset().setOnChildViewRemoved(value).execute(true);
}

public void setAnimateLayoutChanges(boolean value) {
	getBuilder().reset().setAnimateLayoutChanges(value).execute(true);
}

public void setListitem(String value) {
	getBuilder().reset().setListitem(value).execute(true);
}

public Object isAddStatesFromChildren() {
	return getBuilder().reset().tryGetAddStatesFromChildren().execute(false).isAddStatesFromChildren(); 
}
public void setAddStatesFromChildren(boolean value) {
	getBuilder().reset().setAddStatesFromChildren(value).execute(true);
}

public void setChildXml(String value) {
	getBuilder().reset().setChildXml(value).execute(true);
}

}





public static class ViewGroupParamsBean {
	private ViewGroupCommandParamsBuilderInternal commandBuilder;  
	public ViewGroupParamsBean() {
		commandBuilder = new ViewGroupCommandParamsBuilderInternal();
	}
	
	private ViewGroupCommandParamsBuilderInternal getParamsBuilder() {
		return commandBuilder;
	}
public Object getLayoutMarginBottom(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutMarginBottom().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutMarginBottom();
}
public void setLayoutMarginBottom(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginBottom(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutMarginTop(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutMarginTop().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutMarginTop();
}
public void setLayoutMarginTop(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginTop(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutMarginStart(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutMarginStart().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutMarginStart();
}
public void setLayoutMarginStart(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginStart(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutMarginEnd(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutMarginEnd().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutMarginEnd();
}
public void setLayoutMarginEnd(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginEnd(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutMarginLeft(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutMarginLeft().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutMarginLeft();
}
public void setLayoutMarginLeft(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginLeft(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutMarginRight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutMarginRight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutMarginRight();
}
public void setLayoutMarginRight(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginRight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutMargin(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMargin(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutMarginHorizontal(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginHorizontal(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutMarginVertical(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginVertical(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

}



static class ViewGroupCommandParamsBuilderInternal extends ViewGroupCommandParamsBuilder<ViewGroupCommandParamsBuilderInternal> {
}


public static class ViewGroupCommandParamsBuilder <T>{
	protected Map<String, Object> command = new HashMap<>();
	protected int orderGet;
	protected int orderSet;


	public Map<String, Object> getCommand() {
		return command;
	}

	public T reset() {
		orderGet = 0;
		orderSet = 0;
		command = new HashMap<>();
return (T) this;	}

	public Map<String, Object> initCommand(String attributeName) {
		Map<String, Object> attrs = (Map<String, Object>) command.get(attributeName);
		if (attrs == null) {
			attrs = new HashMap<>();
			command.put(attributeName, attrs);
		}
		return attrs;
	}
public T tryGetLayoutMarginBottom() {
	Map<String, Object> attrs = initCommand("layout_marginBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getLayoutMarginBottom() {
	Map<String, Object> attrs = initCommand("layout_marginBottom");
	return attrs.get("commandReturnValue");
}
public T setLayoutMarginBottom(String value) {
	Map<String, Object> attrs = initCommand("layout_marginBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetLayoutMarginTop() {
	Map<String, Object> attrs = initCommand("layout_marginTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getLayoutMarginTop() {
	Map<String, Object> attrs = initCommand("layout_marginTop");
	return attrs.get("commandReturnValue");
}
public T setLayoutMarginTop(String value) {
	Map<String, Object> attrs = initCommand("layout_marginTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetLayoutMarginStart() {
	Map<String, Object> attrs = initCommand("layout_marginStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getLayoutMarginStart() {
	Map<String, Object> attrs = initCommand("layout_marginStart");
	return attrs.get("commandReturnValue");
}
public T setLayoutMarginStart(String value) {
	Map<String, Object> attrs = initCommand("layout_marginStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetLayoutMarginEnd() {
	Map<String, Object> attrs = initCommand("layout_marginEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getLayoutMarginEnd() {
	Map<String, Object> attrs = initCommand("layout_marginEnd");
	return attrs.get("commandReturnValue");
}
public T setLayoutMarginEnd(String value) {
	Map<String, Object> attrs = initCommand("layout_marginEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetLayoutMarginLeft() {
	Map<String, Object> attrs = initCommand("layout_marginLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getLayoutMarginLeft() {
	Map<String, Object> attrs = initCommand("layout_marginLeft");
	return attrs.get("commandReturnValue");
}
public T setLayoutMarginLeft(String value) {
	Map<String, Object> attrs = initCommand("layout_marginLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetLayoutMarginRight() {
	Map<String, Object> attrs = initCommand("layout_marginRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getLayoutMarginRight() {
	Map<String, Object> attrs = initCommand("layout_marginRight");
	return attrs.get("commandReturnValue");
}
public T setLayoutMarginRight(String value) {
	Map<String, Object> attrs = initCommand("layout_marginRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setLayoutMargin(String value) {
	Map<String, Object> attrs = initCommand("layout_margin");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setLayoutMarginHorizontal(String value) {
	Map<String, Object> attrs = initCommand("layout_marginHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setLayoutMarginVertical(String value) {
	Map<String, Object> attrs = initCommand("layout_marginVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
}
	// end - body
	public static void nativeAddView(Object asNativeWidget, Object asNativeWidget2) {
	}
	
	//start - viewcode
	public static void setMargin(Object objValue, Object layoutParams, IWidget w) {
        setBottomMargin(objValue, layoutParams);
        setTopMargin(objValue, layoutParams);
        setStartMargin(objValue, layoutParams, w);
        setEndMargin(objValue, layoutParams, w);
    }
	public static void setBottomMargin(Object objValue,  Object layoutParams) {		
		int valueInt = (int)objValue;          
		if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {          
				((android.view.ViewGroup.MarginLayoutParams)layoutParams).bottomMargin = valueInt;         
		}		
	}
	public static void setTopMargin(Object objValue,  Object layoutParams) {		
		int valueInt = (int)objValue;          
		if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {          
				((android.view.ViewGroup.MarginLayoutParams)layoutParams).topMargin = valueInt;         
		}		
	}
	
	
	
	private static void setVerticalMargin(Object objValue, Object layoutParams, IWidget w) {		
		int valueInt = (int)objValue;          
		if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {          
				((android.view.ViewGroup.MarginLayoutParams)layoutParams).topMargin = valueInt;         
				((android.view.ViewGroup.MarginLayoutParams)layoutParams).bottomMargin = valueInt;         
		}		
	}
	
	public static void setLeftMargin(Object objValue,  Object layoutParams, IWidget w) {	
		if (Build.VERSION.SDK_INT >= 17) {
			setStartMargin(objValue, layoutParams, w);
		} else {
			int valueInt = (int)objValue;          
			if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {          
					((android.view.ViewGroup.MarginLayoutParams)layoutParams).leftMargin = valueInt;         
			}	
		}
	}
	
	public static void setRightMargin(Object objValue,  Object layoutParams, IWidget w) {	
		if (Build.VERSION.SDK_INT >= 17) {
			setEndMargin(objValue, layoutParams, w);
		} else {
			int valueInt = (int)objValue;          
			if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {          
					((android.view.ViewGroup.MarginLayoutParams)layoutParams).rightMargin = valueInt;         
			}
		}
	}


	private static void setHorizontalMargin(Object objValue, Object layoutParams, IWidget w) {	
		if (Build.VERSION.SDK_INT >= 17) {
			setEndMargin(objValue, layoutParams, w);
			setStartMargin(objValue, layoutParams, w);
		} else {
			int valueInt = (int)objValue;          
			if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {          
					((android.view.ViewGroup.MarginLayoutParams)layoutParams).rightMargin = valueInt;         
					((android.view.ViewGroup.MarginLayoutParams)layoutParams).leftMargin = valueInt;
			}
		}
	}
	
	@SuppressLint("NewApi")
	public static void setEndMargin(Object objValue,  Object layoutParams, IWidget w) {		
		int valueInt = (int)objValue;          
		if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {    
			 android.view.ViewGroup.MarginLayoutParams marginParams = (android.view.ViewGroup.MarginLayoutParams)layoutParams;
			 marginParams.setMarginEnd(valueInt);
			 ((View) w.asWidget()).setLayoutParams(marginParams);
		}		
	}
	
	@SuppressLint("NewApi")
	public static void setStartMargin(Object objValue,  Object layoutParams, IWidget w) {		
		int valueInt = (int)objValue;          
		if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {    
			 android.view.ViewGroup.MarginLayoutParams marginParams = (android.view.ViewGroup.MarginLayoutParams)layoutParams;
			 marginParams.setMarginStart(valueInt);
			 ((View) w.asWidget()).setLayoutParams(marginParams);
		}		
	}

	
	
	private static Object getRightMargin(View viewGroup) {
		return ((android.view.ViewGroup.MarginLayoutParams)viewGroup.getLayoutParams()).getMarginEnd();
	}

	private static Object getLeftMargin(View viewGroup) {
		return ((android.view.ViewGroup.MarginLayoutParams)viewGroup.getLayoutParams()).getMarginStart();
	}

	private static Object getTopMargin(View viewGroup) {
		return ((android.view.ViewGroup.MarginLayoutParams)viewGroup.getLayoutParams()).topMargin;
	}

	private static Object getBottomMargin(View viewGroup) {
		return ((android.view.ViewGroup.MarginLayoutParams)viewGroup.getLayoutParams()).bottomMargin;
	}
    
	private static void addTemplate(IWidget w, Object objValue) {
		((HasWidgets)w).addTemplate(objValue); 
		
	}

	private static void setChild(IWidget w, Object xml) {
		if (w instanceof HasWidgets) {
			HasWidgets hasWidgets = (HasWidgets) w;
			hasWidgets.clear();
			PluginInvoker.parseWithParent((String) xml, false, hasWidgets, w.getFragment());
		}
	}

	//end - viewcode

	@SuppressLint("NewApi")
	private static void animateLayoutChanges(Object objValue, ViewGroup view) {
		if (Build.VERSION.SDK_INT >= 11) {
			if (objValue != null && (boolean) objValue) {
				android.animation.LayoutTransition lt = new android.animation.LayoutTransition();
				view.setLayoutTransition(lt);
			} else {
				view.setLayoutTransition(null);
			}
		}
		
	}
	
	public static void registerCommandConveter(IWidget widget) {
		ViewImpl.registerCommandConveter(widget);
	}
	
	private static void setOnHierarchyChangeListener(ViewGroup viewGroup, Object objValue) {
		viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) objValue);
	}

	
}
