package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class BorderCommandConverter extends BaseAttributeCommand {

	public BorderCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		return null;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		return null;
	}

	@Override
	public void updateArgs(Object... args) {
		
	}

	@Override
	public int getPriority() {
		return 20;
	}

	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}

}
