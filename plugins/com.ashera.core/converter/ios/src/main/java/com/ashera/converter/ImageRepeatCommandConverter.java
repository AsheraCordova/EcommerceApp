package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

import r.android.graphics.drawable.Drawable;

public class ImageRepeatCommandConverter extends BaseAttributeCommand {
	private String backgroundRepeat;

	public ImageRepeatCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (backgroundRepeat != null && backgroundRepeat.equals("repeat")) {
			int minWidth = 0;
			int minHeight = 0;
			if (value instanceof r.android.graphics.drawable.Drawable) {
				Drawable drawable = (r.android.graphics.drawable.Drawable) value;
				minWidth = drawable.getMinimumWidth();
				minHeight = drawable.getMinimumHeight();
				value = drawable.getDrawable();
			}
			Object colorWithPatternImage = colorWithPatternImage(value);
			if (colorWithPatternImage != null) {
				r.android.graphics.drawable.Drawable drawable = new r.android.graphics.drawable.Drawable();
				drawable.setMinimumWidth(minWidth);
				drawable.setMinimumHeight(minHeight);
				drawable.setDrawable(colorWithPatternImage);
				return drawable;
			}
		}
		return value;
	}
	
	private native Object colorWithPatternImage(Object image)/*-[
		if ([image isKindOfClass:[UIImage class]]) {
			return [UIColor colorWithPatternImage:(UIImage*) image];
		} else {
			return nil;
		}
	]-*/;

	@Override
	public AttributeCommand newInstance(Object... args) {
		ImageRepeatCommandConverter backgroundRepeatCommandConverter = new ImageRepeatCommandConverter(this.id);
		backgroundRepeatCommandConverter.priority = 10;
		backgroundRepeatCommandConverter.updateArgs(args);
		return backgroundRepeatCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		this.backgroundRepeat = (String) args[0];
	}

}
