package com.ashera.converter;


import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class TintColorCommandConverter extends BaseAttributeCommand {
	public TintColorCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {

		if (value != null) {
			value = setImageWithRenderingModeAlwaysTemplate(value);
		}
		return value;

	}
	
	private native Object setImageWithRenderingModeAlwaysTemplate(Object image)/*-[
		if ([image isKindOfClass:[UIImage class]]) {
		 	return [(UIImage*) image imageWithRenderingMode:UIImageRenderingModeAlwaysTemplate];
		} else {
			return image;
		}
	]-*/;

	@Override
	public AttributeCommand newInstance(Object... args) {
		TintColorCommandConverter capInsetsCommandConverter = new TintColorCommandConverter(this.id);
		return capInsetsCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		
	}

}
