package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class ImageRepeatCommandConverter extends BaseAttributeCommand {
	private String backgroundRepeat;

	public ImageRepeatCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		org.teavm.jso.dom.html.HTMLElement htmlElement = ((org.teavm.jso.dom.html.HTMLElement) widget.asNativeWidget());
		if (backgroundRepeat == null || backgroundRepeat.equals("no-repeat") || backgroundRepeat.equals("no_repeat")) {
			htmlElement.getStyle().setProperty("background-repeat", "no-repeat");
			htmlElement.getStyle().setProperty("background-size", "100% 100%");
		} else {
			htmlElement.getStyle().setProperty("background-repeat", "repeat");
			htmlElement.getStyle().removeProperty("background-size");
		}
		return value;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		ImageRepeatCommandConverter backgroundRepeatCommandConverter = new ImageRepeatCommandConverter(this.id);
		backgroundRepeatCommandConverter.updateArgs(args);
		return backgroundRepeatCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		this.backgroundRepeat = (String) args[0];
	}

	@Override
	public boolean executeAfterPostMeasure() {
		return false;
	}

}
