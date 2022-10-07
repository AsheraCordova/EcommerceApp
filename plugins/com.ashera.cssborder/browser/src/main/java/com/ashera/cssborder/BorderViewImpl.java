package com.ashera.cssborder;
//start - imports
import java.util.*;

import r.android.content.Context;
import r.android.os.Build;
import r.android.view.View;
import r.android.annotation.SuppressLint;
import r.android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;


import static com.ashera.widget.IWidget.*;
//end - imports
public class BorderViewImpl implements com.ashera.widget.IAttributable {
	// start - body
	public final static String LOCAL_NAME = "BorderView"; 
	private IWidget w;
	private BorderViewImpl(IWidget widget) {
		this.w = widget;
	}
	
	public String getLocalName() {
		return LOCAL_NAME;
	}
	
	public BorderViewImpl() {
	}
	
	@Override
	public com.ashera.widget.IAttributable newInstance(IWidget widget) {
		BorderViewImpl newIntance = new BorderViewImpl(widget);
		
		return newIntance;
	}
	
	
	@SuppressLint("NewApi")
	@Override
	public void loadAttributes(String localName) {

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderWidth").withType("dimension").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderColor").withType("colorstate").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderStyle").withType("string").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderRadius").withType("dimensionfloat").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderTopWidth").withType("dimension").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderTopColor").withType("colorstate").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderTopStyle").withType("string").withDecorator("border"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderTopLeftRadius").withType("dimensionfloat").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderTopRightRadius").withType("dimensionfloat").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderBottomWidth").withType("dimension").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderBottomColor").withType("colorstate").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderBottomStyle").withType("string").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderBottomLeftRadius").withType("dimensionfloat").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderBottomRightRadius").withType("dimensionfloat").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderLeftWidth").withType("dimension").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderLeftColor").withType("colorstate").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderLeftStyle").withType("string").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderRightWidth").withType("dimension").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderRightColor").withType("colorstate").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("borderRightStyle").withType("string").withDecorator("border").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
	}

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		org.teavm.jso.dom.html.HTMLElement hTMLElement = (org.teavm.jso.dom.html.HTMLElement) w.asNativeWidget();
		switch (key.getAttributeName()) {
		case "borderWidth": {


		 //



			}
			break;
		case "borderColor": {


		 //



			}
			break;
		case "borderStyle": {


		 //



			}
			break;
		case "borderRadius": {


		 //



			}
			break;
		case "borderTopWidth": {


		 //



			}
			break;
		case "borderTopColor": {


		 //



			}
			break;
		case "borderTopStyle": {


		 //



			}
			break;
		case "borderTopLeftRadius": {


		 //



			}
			break;
		case "borderTopRightRadius": {


		 //



			}
			break;
		case "borderBottomWidth": {


		 //



			}
			break;
		case "borderBottomColor": {


		 //



			}
			break;
		case "borderBottomStyle": {


		 //



			}
			break;
		case "borderBottomLeftRadius": {


		 //



			}
			break;
		case "borderBottomRightRadius": {


		 //



			}
			break;
		case "borderLeftWidth": {


		 //



			}
			break;
		case "borderLeftColor": {


		 //



			}
			break;
		case "borderLeftStyle": {


		 //



			}
			break;
		case "borderRightWidth": {


		 //



			}
			break;
		case "borderRightColor": {


		 //



			}
			break;
		case "borderRightStyle": {


		 //



			}
			break;
		default:
			break;
		}
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		org.teavm.jso.dom.html.HTMLElement hTMLElement = (org.teavm.jso.dom.html.HTMLElement) w.asNativeWidget();
		switch (key.getAttributeName()) {
			case "borderTopWidth": {
return null;			}
			case "borderTopColor": {
return null;			}
			case "borderTopStyle": {
return null;			}
			case "borderTopLeftRadius": {
return null;			}
			case "borderTopRightRadius": {
return null;			}
			case "borderBottomWidth": {
return null;			}
			case "borderBottomColor": {
return null;			}
			case "borderBottomStyle": {
return null;			}
			case "borderBottomLeftRadius": {
return null;			}
			case "borderBottomRightRadius": {
return null;			}
			case "borderLeftWidth": {
return null;			}
			case "borderLeftColor": {
return null;			}
			case "borderLeftStyle": {
return null;			}
			case "borderRightWidth": {
return null;			}
			case "borderRightColor": {
return null;			}
			case "borderRightStyle": {
return null;			}
		}
		return null;
	}
	
	

	
private BorderViewCommandBuilder builder;
private BorderViewBean bean;
public BorderViewBean getBean() {
	if (bean == null) {
		bean = new BorderViewBean();
	}
	return bean;
}
public BorderViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new BorderViewCommandBuilder();
	}
	return builder;
}


public  class BorderViewCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <BorderViewCommandBuilder> {
    public BorderViewCommandBuilder() {
	}
	
	public BorderViewCommandBuilder execute(boolean setter) {
		if (setter) {
			w.executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			w.getFragment().remeasure();
		}
		w.executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public BorderViewCommandBuilder setBorderWidth(String value) {
	Map<String, Object> attrs = initCommand("borderWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder setBorderColor(String value) {
	Map<String, Object> attrs = initCommand("borderColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder setBorderStyle(String value) {
	Map<String, Object> attrs = initCommand("borderStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder setBorderRadius(String value) {
	Map<String, Object> attrs = initCommand("borderRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderTopWidth() {
	Map<String, Object> attrs = initCommand("borderTopWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderTopWidth() {
	Map<String, Object> attrs = initCommand("borderTopWidth");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderTopWidth(String value) {
	Map<String, Object> attrs = initCommand("borderTopWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderTopColor() {
	Map<String, Object> attrs = initCommand("borderTopColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderTopColor() {
	Map<String, Object> attrs = initCommand("borderTopColor");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderTopColor(String value) {
	Map<String, Object> attrs = initCommand("borderTopColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderTopStyle() {
	Map<String, Object> attrs = initCommand("borderTopStyle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderTopStyle() {
	Map<String, Object> attrs = initCommand("borderTopStyle");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderTopStyle(String value) {
	Map<String, Object> attrs = initCommand("borderTopStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderTopLeftRadius() {
	Map<String, Object> attrs = initCommand("borderTopLeftRadius");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderTopLeftRadius() {
	Map<String, Object> attrs = initCommand("borderTopLeftRadius");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderTopLeftRadius(String value) {
	Map<String, Object> attrs = initCommand("borderTopLeftRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderTopRightRadius() {
	Map<String, Object> attrs = initCommand("borderTopRightRadius");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderTopRightRadius() {
	Map<String, Object> attrs = initCommand("borderTopRightRadius");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderTopRightRadius(String value) {
	Map<String, Object> attrs = initCommand("borderTopRightRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderBottomWidth() {
	Map<String, Object> attrs = initCommand("borderBottomWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderBottomWidth() {
	Map<String, Object> attrs = initCommand("borderBottomWidth");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderBottomWidth(String value) {
	Map<String, Object> attrs = initCommand("borderBottomWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderBottomColor() {
	Map<String, Object> attrs = initCommand("borderBottomColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderBottomColor() {
	Map<String, Object> attrs = initCommand("borderBottomColor");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderBottomColor(String value) {
	Map<String, Object> attrs = initCommand("borderBottomColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderBottomStyle() {
	Map<String, Object> attrs = initCommand("borderBottomStyle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderBottomStyle() {
	Map<String, Object> attrs = initCommand("borderBottomStyle");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderBottomStyle(String value) {
	Map<String, Object> attrs = initCommand("borderBottomStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderBottomLeftRadius() {
	Map<String, Object> attrs = initCommand("borderBottomLeftRadius");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderBottomLeftRadius() {
	Map<String, Object> attrs = initCommand("borderBottomLeftRadius");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderBottomLeftRadius(String value) {
	Map<String, Object> attrs = initCommand("borderBottomLeftRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderBottomRightRadius() {
	Map<String, Object> attrs = initCommand("borderBottomRightRadius");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderBottomRightRadius() {
	Map<String, Object> attrs = initCommand("borderBottomRightRadius");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderBottomRightRadius(String value) {
	Map<String, Object> attrs = initCommand("borderBottomRightRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderLeftWidth() {
	Map<String, Object> attrs = initCommand("borderLeftWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderLeftWidth() {
	Map<String, Object> attrs = initCommand("borderLeftWidth");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderLeftWidth(String value) {
	Map<String, Object> attrs = initCommand("borderLeftWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderLeftColor() {
	Map<String, Object> attrs = initCommand("borderLeftColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderLeftColor() {
	Map<String, Object> attrs = initCommand("borderLeftColor");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderLeftColor(String value) {
	Map<String, Object> attrs = initCommand("borderLeftColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderLeftStyle() {
	Map<String, Object> attrs = initCommand("borderLeftStyle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderLeftStyle() {
	Map<String, Object> attrs = initCommand("borderLeftStyle");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderLeftStyle(String value) {
	Map<String, Object> attrs = initCommand("borderLeftStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderRightWidth() {
	Map<String, Object> attrs = initCommand("borderRightWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderRightWidth() {
	Map<String, Object> attrs = initCommand("borderRightWidth");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderRightWidth(String value) {
	Map<String, Object> attrs = initCommand("borderRightWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderRightColor() {
	Map<String, Object> attrs = initCommand("borderRightColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderRightColor() {
	Map<String, Object> attrs = initCommand("borderRightColor");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderRightColor(String value) {
	Map<String, Object> attrs = initCommand("borderRightColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public BorderViewCommandBuilder tryGetBorderRightStyle() {
	Map<String, Object> attrs = initCommand("borderRightStyle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getBorderRightStyle() {
	Map<String, Object> attrs = initCommand("borderRightStyle");
	return attrs.get("commandReturnValue");
}
public BorderViewCommandBuilder setBorderRightStyle(String value) {
	Map<String, Object> attrs = initCommand("borderRightStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class BorderViewBean extends com.ashera.layout.ViewImpl.ViewBean{
		public BorderViewBean() {
			super(BorderViewImpl.this.w);
		}
public void setBorderWidth(String value) {
	getBuilder().reset().setBorderWidth(value).execute(true);
}

public void setBorderColor(String value) {
	getBuilder().reset().setBorderColor(value).execute(true);
}

public void setBorderStyle(String value) {
	getBuilder().reset().setBorderStyle(value).execute(true);
}

public void setBorderRadius(String value) {
	getBuilder().reset().setBorderRadius(value).execute(true);
}

public Object getBorderTopWidth() {
	return getBuilder().reset().tryGetBorderTopWidth().execute(false).getBorderTopWidth(); 
}
public void setBorderTopWidth(String value) {
	getBuilder().reset().setBorderTopWidth(value).execute(true);
}

public Object getBorderTopColor() {
	return getBuilder().reset().tryGetBorderTopColor().execute(false).getBorderTopColor(); 
}
public void setBorderTopColor(String value) {
	getBuilder().reset().setBorderTopColor(value).execute(true);
}

public Object getBorderTopStyle() {
	return getBuilder().reset().tryGetBorderTopStyle().execute(false).getBorderTopStyle(); 
}
public void setBorderTopStyle(String value) {
	getBuilder().reset().setBorderTopStyle(value).execute(true);
}

public Object getBorderTopLeftRadius() {
	return getBuilder().reset().tryGetBorderTopLeftRadius().execute(false).getBorderTopLeftRadius(); 
}
public void setBorderTopLeftRadius(String value) {
	getBuilder().reset().setBorderTopLeftRadius(value).execute(true);
}

public Object getBorderTopRightRadius() {
	return getBuilder().reset().tryGetBorderTopRightRadius().execute(false).getBorderTopRightRadius(); 
}
public void setBorderTopRightRadius(String value) {
	getBuilder().reset().setBorderTopRightRadius(value).execute(true);
}

public Object getBorderBottomWidth() {
	return getBuilder().reset().tryGetBorderBottomWidth().execute(false).getBorderBottomWidth(); 
}
public void setBorderBottomWidth(String value) {
	getBuilder().reset().setBorderBottomWidth(value).execute(true);
}

public Object getBorderBottomColor() {
	return getBuilder().reset().tryGetBorderBottomColor().execute(false).getBorderBottomColor(); 
}
public void setBorderBottomColor(String value) {
	getBuilder().reset().setBorderBottomColor(value).execute(true);
}

public Object getBorderBottomStyle() {
	return getBuilder().reset().tryGetBorderBottomStyle().execute(false).getBorderBottomStyle(); 
}
public void setBorderBottomStyle(String value) {
	getBuilder().reset().setBorderBottomStyle(value).execute(true);
}

public Object getBorderBottomLeftRadius() {
	return getBuilder().reset().tryGetBorderBottomLeftRadius().execute(false).getBorderBottomLeftRadius(); 
}
public void setBorderBottomLeftRadius(String value) {
	getBuilder().reset().setBorderBottomLeftRadius(value).execute(true);
}

public Object getBorderBottomRightRadius() {
	return getBuilder().reset().tryGetBorderBottomRightRadius().execute(false).getBorderBottomRightRadius(); 
}
public void setBorderBottomRightRadius(String value) {
	getBuilder().reset().setBorderBottomRightRadius(value).execute(true);
}

public Object getBorderLeftWidth() {
	return getBuilder().reset().tryGetBorderLeftWidth().execute(false).getBorderLeftWidth(); 
}
public void setBorderLeftWidth(String value) {
	getBuilder().reset().setBorderLeftWidth(value).execute(true);
}

public Object getBorderLeftColor() {
	return getBuilder().reset().tryGetBorderLeftColor().execute(false).getBorderLeftColor(); 
}
public void setBorderLeftColor(String value) {
	getBuilder().reset().setBorderLeftColor(value).execute(true);
}

public Object getBorderLeftStyle() {
	return getBuilder().reset().tryGetBorderLeftStyle().execute(false).getBorderLeftStyle(); 
}
public void setBorderLeftStyle(String value) {
	getBuilder().reset().setBorderLeftStyle(value).execute(true);
}

public Object getBorderRightWidth() {
	return getBuilder().reset().tryGetBorderRightWidth().execute(false).getBorderRightWidth(); 
}
public void setBorderRightWidth(String value) {
	getBuilder().reset().setBorderRightWidth(value).execute(true);
}

public Object getBorderRightColor() {
	return getBuilder().reset().tryGetBorderRightColor().execute(false).getBorderRightColor(); 
}
public void setBorderRightColor(String value) {
	getBuilder().reset().setBorderRightColor(value).execute(true);
}

public Object getBorderRightStyle() {
	return getBuilder().reset().tryGetBorderRightStyle().execute(false).getBorderRightStyle(); 
}
public void setBorderRightStyle(String value) {
	getBuilder().reset().setBorderRightStyle(value).execute(true);
}

}


	// end - body
}
