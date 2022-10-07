package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

import r.android.graphics.drawable.Drawable;

/*-[
#include <UIKit/UIKit.h>
#include "CGRectWrapper.h"
]-*/
public class DrawImageOrColorCommandConverter extends BaseAttributeCommand{
	private Object rectObj;
	private Object image;
	
	public DrawImageOrColorCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return value;
		}
		if (value instanceof Drawable) {
			Drawable drawable = (Drawable) value;
			setBounds(drawable, widget.asNativeWidget());
			value = ((Drawable) value).getDrawable();
		}
		drawImage(value);
		return value;
	}
	
	private native void setBounds(Drawable drawable, Object nativeWidget) /*-[
		UIView* uiview = (UIView*) nativeWidget;
		[drawable setBoundsWithInt: 0 withInt: 0 withInt:uiview.frame.size.width withInt:uiview.frame.size.height];
	]-*/;
	
	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		DrawImageOrColorCommandConverter drawImageCommandConverter = new DrawImageOrColorCommandConverter(this.id);
		drawImageCommandConverter.setPriority(1000);
		return drawImageCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		
	}
	
	@Override
	public java.lang.Object getValue(java.lang.String attributeName) {
		switch (attributeName) {
		case "image":
			return image;

		default:
			break;
		}
		return super.getValue(attributeName);
	}

	private native void drawImage(Object image) /*-[
		self->image_ = image;
		if ([image isKindOfClass:UIImage.class]) {
			CGRect rect = ((CGRectWrapper*) self->rectObj_).rect;
        	[((UIImage*) image) drawInRect:rect];
    	}
    	if ([image isKindOfClass:UIColor.class]) {
    		CGRect rect = ((CGRectWrapper*) self->rectObj_).rect;
    		[((UIColor*) image) setFill];
    		UIRectFillUsingBlendMode(rect, kCGBlendModeNormal);
    	}
	]-*/;
	
	@Override
	public void updatePhaseArgs(java.lang.Object... args) {
		for (int i = 0; i < args.length; i+=2) {
			Object attributeName = args[i];
			
			if (attributeName.equals("rect")) {
				rectObj = args[i + 1];		
			}
		}
	}
}
