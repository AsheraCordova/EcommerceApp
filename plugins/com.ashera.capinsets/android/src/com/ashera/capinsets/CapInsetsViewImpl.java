package com.ashera.capinsets;
import static com.ashera.widget.IWidget.BUFFER_STRATEGY_NONE;
import static com.ashera.widget.IWidget.UPDATE_UI_NONE;
import static com.ashera.widget.IWidget.UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE;

//start - imports
import java.util.*;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.annotation.SuppressLint;
import androidx.core.view.*;
import android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import android.content.res.*;


import static com.ashera.widget.IWidget.*;
//end - imports
public class CapInsetsViewImpl implements com.ashera.widget.IAttributable {
	// start - body
	public final static String LOCAL_NAME = "CapInsetsView"; 
	private IWidget w;
	private CapInsetsViewImpl(IWidget widget) {
		this.w = widget;
	}
	
	public String getLocalName() {
		return LOCAL_NAME;
	}
	
	public CapInsetsViewImpl() {
	}
	
	@Override
	public com.ashera.widget.IAttributable newInstance(IWidget widget) {
		CapInsetsViewImpl newIntance = new CapInsetsViewImpl(widget);
		
		return newIntance;
	}
	
	
	@SuppressLint("NewApi")
	@Override
	public void loadAttributes(String localName) {

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundCapInsets").withType("dimensiondppx").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundCapInsetsTop").withType("dimensiondppx").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundCapInsetsBottom").withType("dimensiondppx").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundCapInsetsLeft").withType("dimensiondppx").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundCapInsetsRight").withType("dimensiondppx").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundCapInsets").withType("dimensiondppx").withOrder(-10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundCapInsetsTop").withType("dimensiondppx").withOrder(-10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundCapInsetsBottom").withType("dimensiondppx").withOrder(-10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundCapInsetsLeft").withType("dimensiondppx").withOrder(-10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundCapInsetsRight").withType("dimensiondppx").withOrder(-10).withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
	}

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		switch (key.getAttributeName()) {
		case "backgroundCapInsets": {


		 applyCapInsets(w, objValue);



			}
			break;
		case "backgroundCapInsetsTop": {


		 applyCapInsetsTop(w, objValue);



			}
			break;
		case "backgroundCapInsetsBottom": {


		 applyCapInsetsBottom(w, objValue);



			}
			break;
		case "backgroundCapInsetsLeft": {


		 applyCapInsetsLeft(w, objValue);



			}
			break;
		case "backgroundCapInsetsRight": {


		 applyCapInsetsRight(w, objValue);



			}
			break;
		case "foregroundCapInsets": {


		 applyForegroundCapInsets(w, objValue);



			}
			break;
		case "foregroundCapInsetsTop": {


		 applyForegroundCapInsetsTop(w, objValue);



			}
			break;
		case "foregroundCapInsetsBottom": {


		 applyForegroundCapInsetsBottom(w, objValue);



			}
			break;
		case "foregroundCapInsetsLeft": {


		 applyForegroundCapInsetsLeft(w, objValue);



			}
			break;
		case "foregroundCapInsetsRight": {


		 applyForegroundCapInsetsRight(w, objValue);



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
		switch (key.getAttributeName()) {
		}
		return null;
	}
	
	

	
private CapInsetsViewCommandBuilder builder;
private CapInsetsViewBean bean;
public CapInsetsViewBean getBean() {
	if (bean == null) {
		bean = new CapInsetsViewBean();
	}
	return bean;
}
public CapInsetsViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new CapInsetsViewCommandBuilder();
	}
	return builder;
}


public  class CapInsetsViewCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <CapInsetsViewCommandBuilder> {
    public CapInsetsViewCommandBuilder() {
	}
	
	public CapInsetsViewCommandBuilder execute(boolean setter) {
		if (setter) {
			w.executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			w.getFragment().remeasure();
		}
		w.executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public CapInsetsViewCommandBuilder setBackgroundCapInsets(String value) {
	Map<String, Object> attrs = initCommand("backgroundCapInsets");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setBackgroundCapInsetsTop(String value) {
	Map<String, Object> attrs = initCommand("backgroundCapInsetsTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setBackgroundCapInsetsBottom(String value) {
	Map<String, Object> attrs = initCommand("backgroundCapInsetsBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setBackgroundCapInsetsLeft(String value) {
	Map<String, Object> attrs = initCommand("backgroundCapInsetsLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setBackgroundCapInsetsRight(String value) {
	Map<String, Object> attrs = initCommand("backgroundCapInsetsRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setForegroundCapInsets(String value) {
	Map<String, Object> attrs = initCommand("foregroundCapInsets");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setForegroundCapInsetsTop(String value) {
	Map<String, Object> attrs = initCommand("foregroundCapInsetsTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setForegroundCapInsetsBottom(String value) {
	Map<String, Object> attrs = initCommand("foregroundCapInsetsBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setForegroundCapInsetsLeft(String value) {
	Map<String, Object> attrs = initCommand("foregroundCapInsetsLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public CapInsetsViewCommandBuilder setForegroundCapInsetsRight(String value) {
	Map<String, Object> attrs = initCommand("foregroundCapInsetsRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class CapInsetsViewBean extends com.ashera.layout.ViewImpl.ViewBean{
		public CapInsetsViewBean() {
			super(CapInsetsViewImpl.this.w);
		}
public void setBackgroundCapInsets(String value) {
	getBuilder().reset().setBackgroundCapInsets(value).execute(true);
}

public void setBackgroundCapInsetsTop(String value) {
	getBuilder().reset().setBackgroundCapInsetsTop(value).execute(true);
}

public void setBackgroundCapInsetsBottom(String value) {
	getBuilder().reset().setBackgroundCapInsetsBottom(value).execute(true);
}

public void setBackgroundCapInsetsLeft(String value) {
	getBuilder().reset().setBackgroundCapInsetsLeft(value).execute(true);
}

public void setBackgroundCapInsetsRight(String value) {
	getBuilder().reset().setBackgroundCapInsetsRight(value).execute(true);
}

public void setForegroundCapInsets(String value) {
	getBuilder().reset().setForegroundCapInsets(value).execute(true);
}

public void setForegroundCapInsetsTop(String value) {
	getBuilder().reset().setForegroundCapInsetsTop(value).execute(true);
}

public void setForegroundCapInsetsBottom(String value) {
	getBuilder().reset().setForegroundCapInsetsBottom(value).execute(true);
}

public void setForegroundCapInsetsLeft(String value) {
	getBuilder().reset().setForegroundCapInsetsLeft(value).execute(true);
}

public void setForegroundCapInsetsRight(String value) {
	getBuilder().reset().setForegroundCapInsetsRight(value).execute(true);
}

}


	// end - body

//start - capinsets 
	private void applyForegroundCapInsets(IWidget w, Object objValue) {
		applyForegroundCapInsetsRight(w, objValue);
		applyForegroundCapInsetsLeft(w, objValue);
		applyForegroundCapInsetsTop(w, objValue);
		applyForegroundCapInsetsBottom(w, objValue);
	}
	private void applyForegroundCapInsetsRight(IWidget w, Object objValue) {
		String capInsetsKey = "capInsetsRight";
		if (isRTLayoutCapInsets(w)) {
			capInsetsKey = "capInsetsLeft";
		}
		w.applyAttributeCommand("foreground", "capInsets", new String[] {"foregroundCapInsetsTop", "foregroundCapInsetsBottom", "foregroundCapInsetsLeft", "foregroundCapInsetsRight"}, true, capInsetsKey, objValue);
	}

	private void applyForegroundCapInsetsLeft(IWidget w, Object objValue) {
		String capInsetsKey = "capInsetsLeft";
		if (isRTLayoutCapInsets(w)) {
			capInsetsKey = "capInsetsRight";
		}
		
		w.applyAttributeCommand("foreground", "capInsets", new String[] {"foregroundCapInsetsTop", "foregroundCapInsetsBottom", "foregroundCapInsetsLeft", "foregroundCapInsetsRight"}, true, capInsetsKey, objValue);
	}

	private void applyForegroundCapInsetsBottom(IWidget w, Object objValue) {
		w.applyAttributeCommand("foreground", "capInsets", new String[] {"foregroundCapInsetsTop", "foregroundCapInsetsBottom", "foregroundCapInsetsLeft", "foregroundCapInsetsRight"}, true, "capInsetsBottom", objValue);
	}

	private void applyForegroundCapInsetsTop(IWidget w, Object objValue) {
		w.applyAttributeCommand("foreground", "capInsets", new String[] {"foregroundCapInsetsTop", "foregroundCapInsetsBottom", "foregroundCapInsetsLeft", "foregroundCapInsetsRight"}, true, "capInsetsTop", objValue);
	}
	private void applyCapInsets(IWidget w, Object objValue) {
		applyCapInsetsRight(w, objValue);
		applyCapInsetsLeft(w, objValue);
		applyCapInsetsTop(w, objValue);
		applyCapInsetsBottom(w, objValue);
	}
	
	private void applyCapInsetsRight(IWidget w, Object objValue) {
		String capInsetsKey = "capInsetsRight";
		if (isRTLayoutCapInsets(w)) {
			capInsetsKey = "capInsetsLeft";
		}
		w.applyAttributeCommand("background", "capInsets", new String[] {"capInsetsTop", "capInsetsBottom", "capInsetsLeft", "capInsetsRight"}, true, capInsetsKey, objValue);
	}

	private void applyCapInsetsLeft(IWidget w, Object objValue) {
		String capInsetsKey = "capInsetsLeft";
		if (isRTLayoutCapInsets(w)) {
			capInsetsKey = "capInsetsRight";
		}
		
		w.applyAttributeCommand("background", "capInsets", new String[] {"capInsetsTop", "capInsetsBottom", "capInsetsLeft", "capInsetsRight"}, true, capInsetsKey, objValue);
	}

	private void applyCapInsetsBottom(IWidget w, Object objValue) {
		w.applyAttributeCommand("background", "capInsets", new String[] {"capInsetsTop", "capInsetsBottom", "capInsetsLeft", "capInsetsRight"}, true, "capInsetsBottom", objValue);
	}

	private void applyCapInsetsTop(IWidget w, Object objValue) {
		w.applyAttributeCommand("background", "capInsets", new String[] {"capInsetsTop", "capInsetsBottom", "capInsetsLeft", "capInsetsRight"}, true, "capInsetsTop", objValue);
	}

	private boolean isRTLayoutCapInsets(IWidget w) {
		if (com.ashera.layout.ViewImpl.isRTLLayoutDirection(w)) {
			return true;
		}
		
		View view  =(View) w.asWidget();
		if (!ViewCompat.isLayoutDirectionResolved(view)) {
			ViewGroup parent = (ViewGroup) view.getParent();
			while (parent != null) {
				if (ViewCompat.getLayoutDirection(parent) == View.LAYOUT_DIRECTION_RTL) {
					return true;
				}
				parent = (ViewGroup) parent.getParent();
			}
		}
		return false;
	}	
	//end - capinsets

}
