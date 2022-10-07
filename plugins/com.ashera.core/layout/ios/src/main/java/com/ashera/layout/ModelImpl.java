package com.ashera.layout;


//start - imports
import java.util.*;

import r.android.content.*;
import r.android.graphics.*;
import r.android.os.Build;
import r.android.view.*;

import com.ashera.core.IFragment;
import com.ashera.converter.*;
import r.android.annotation.SuppressLint;

import com.ashera.widget.bus.*;
import com.ashera.widget.*;

/*-[
#include <UIKit/UIKit.h>
#include "ASUIView.h"
]-*/
import com.google.j2objc.annotations.Property;

import static com.ashera.widget.IWidget.*;
//end - imports
@SuppressLint("NewApi")
public class ModelImpl extends BaseWidget {
	//start - body
	private View viewStub;
	protected @Property Object uiView;
	public final static String LOCAL_NAME = "com.ashera.layout.Model"; 
	public final static String GROUP_NAME = "Model";
	
	@Override
	public void loadAttributes(String attributeName) {
		ViewImpl.register(attributeName);


		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("param").withType("string"));

	}
	
	public ModelImpl() {
		super(LOCAL_NAME, LOCAL_NAME);
	}	

	@Override
	public IWidget newInstance() {
		return new ModelImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		
        viewStub = new View();
        createView();
        ViewImpl.nativeMakeFrame(uiView, 0, 0, 0, 0);
		nativeCreate(fragment, params);	
	}
	

    public native void createView()/*-[
		ASUIView* uiView = [ASUIView new];
		uiView.backgroundColor = [UIColor clearColor];
		uiView_ = uiView;
	]-*/;
    

	@Override
	@SuppressLint("NewApi")
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {		
		Object nativeWidget = asNativeWidget();
		ViewImpl.setAttribute(this, key, strValue, objValue, decorator);

		switch (key.getAttributeName()) {
			case "param": {
				


		this.setModelParam((String)objValue);



			}
			break;
		default:
			break;
		}
	}
	@Override
	public Object asWidget() {
		return viewStub;
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object attributeValue = ViewImpl.getAttribute(this, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "param": {
return this.getModelParam();				}
		}
		
		return null;
	}
	
	

	@Override
	protected boolean applyModelAttributes() {
		return false;
	}
	


    @Override
    public Object asNativeWidget() {
        return uiView;
        
    }
    private void nativeCreate(IFragment fragment, Map<String, Object> params) {
    }
    
	//end - body
}
