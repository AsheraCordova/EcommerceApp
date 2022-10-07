package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class AutoLinkifyCommandConverter  extends BaseAttributeCommand {
	private int mask;
	private boolean linksClickable;

	public AutoLinkifyCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}
		String text = (String) value;
		final String result = r.android.text.util.Linkify.linkify(text, mask, linksClickable);
        return result;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		AutoLinkifyCommandConverter autoLinkifyCommandConverter = new AutoLinkifyCommandConverter(this.id);
		autoLinkifyCommandConverter.updateArgs(args);
		autoLinkifyCommandConverter.setPriority(100);
		return autoLinkifyCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {

		for (int i = 0; i < args.length; i+=2) {
			Object attributeName = args[i];
			if (attributeName.equals("mask")) {
				this.mask = ((int) args[i + 1]);	
			}
			
			if (attributeName.equals("linksClickable")) {
				this.linksClickable = ((boolean) args[i + 1]);	
			}
		}
	}
}
