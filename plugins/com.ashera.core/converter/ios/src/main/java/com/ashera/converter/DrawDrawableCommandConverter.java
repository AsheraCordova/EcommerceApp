package com.ashera.converter;

import com.ashera.model.RectM;
import com.ashera.view.BaseMeasurableView;
import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

/*-[
#include <UIKit/UIKit.h>
]-*/
public class DrawDrawableCommandConverter extends BaseAttributeCommand{
	private String drawable;

	public DrawDrawableCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null || drawable == null || value.equals("@null")) {
			return value;
		}
		
		BaseMeasurableView measurableView = (BaseMeasurableView) widget.asWidget();
		RectM bounds = null;
		switch (drawable) {
			case "left":
		        bounds = measurableView.getLeftDrawableBounds(measurableView.getTop(), measurableView.getLeft(), measurableView.getWidth(), measurableView.getHeight());
				break;
			case "right":
		        bounds = measurableView.getRightDrawableBounds(measurableView.getTop(), measurableView.getLeft(), measurableView.getWidth(), measurableView.getHeight());
				break;
			case "top":
		        bounds = measurableView.getTopDrawableBounds(measurableView.getTop(), measurableView.getLeft(), measurableView.getWidth(), measurableView.getHeight());
				break;
			case "bottom":
		        bounds = measurableView.getBottomDrawableBounds(measurableView.getTop(), measurableView.getLeft(), measurableView.getWidth(), measurableView.getHeight());
				break;
			case "button":
				if (measurableView instanceof r.android.widget.CompoundButton) {
					r.android.graphics.drawable.Drawable drawable = ((r.android.widget.CompoundButton) measurableView).getButtonDrawable();
					bounds = new RectM(drawable.getLeft(), drawable.getTop(), drawable.getRight() - drawable.getLeft(), drawable.getBottom() - drawable.getTop());
				}
				break;
			default:
				break;
			}
		
		if (value instanceof r.android.graphics.drawable.Drawable) {
			value = ((r.android.graphics.drawable.Drawable) value).getDrawable();
		}
        drawDrawable(value, bounds.x, bounds.y, bounds.width, bounds.height);
	    
		return value;
	}
	
	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		DrawDrawableCommandConverter drawDrawableCommandConverter = new DrawDrawableCommandConverter(this.id);
		drawDrawableCommandConverter.setPriority(1000);
		drawDrawableCommandConverter.updateArgs(args);
		return drawDrawableCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		this.drawable = (String) args[0];
	}
	

	private native void drawDrawable(Object image, int x, int y, int width, int height) /*-[
		if ([image isKindOfClass:UIImage.class]) {
			CGRect rect = CGRectMake(x, y, width, height);
        	[((UIImage*) image) drawInRect:rect];
    	}
	]-*/;
	
	@Override
	public void updatePhaseArgs(java.lang.Object... args) {
	}
}
