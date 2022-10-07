package com.ashera.layout.decorator;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class BorderAttributeCommand extends BaseAttributeCommand{
	private BorderDecorator borderDecorator;
	
	public BorderAttributeCommand(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		return borderDecorator.getClippedBackgroundImage(value);
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		BorderAttributeCommand command = new BorderAttributeCommand(this.id);
		command.setPriority(20);
		command.updateArgs(args);
		return command;
	}

	@Override
	public void updateArgs(Object... args) {
		borderDecorator = (BorderDecorator) args[0];
	}

	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}

}
