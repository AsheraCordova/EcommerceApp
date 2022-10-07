package com.ashera.capinsets;


import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class CapInsetsCommandConverter extends BaseAttributeCommand{
	private int capInsetsStretchTop;
	private int capInsetsStretchBottom;
	private int capInsetsStretchLeft;
	private int capInsetsStretchRight;
	
	public CapInsetsCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {

		boolean isNinePatch = capInsetsStretchTop != 0 || capInsetsStretchBottom != 0 || capInsetsStretchLeft != 0 || capInsetsStretchRight != 0;

        if (isNinePatch) {
        	if (value instanceof r.android.graphics.drawable.Drawable) {
            	value = ((r.android.graphics.drawable.Drawable) value).getDrawable();	
            }
        	return nativeLoadImageBundle(value, capInsetsStretchTop, capInsetsStretchBottom, capInsetsStretchLeft, capInsetsStretchRight);
        }
		return value;

	}
	
	private native Object nativeLoadImageBundle(Object image, int top, int bottom, int left, int right)/*-[
		if ([image isKindOfClass:[UIImage class]]) {
		 	return [(UIImage*) image resizableImageWithCapInsets:UIEdgeInsetsMake(top, left, bottom, right) resizingMode:UIImageResizingModeStretch];
		} else {
			return image;
		}
	]-*/;

	@Override
	public AttributeCommand newInstance(Object... args) {
		CapInsetsCommandConverter capInsetsCommandConverter = new CapInsetsCommandConverter(this.id);
		capInsetsCommandConverter.updateArgs(args);
		return capInsetsCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		for (int i = 0; i < args.length; i+=2) {
			Object attributeName = args[i];
			if (attributeName.equals("capInsetsTop")) {
				capInsetsStretchTop = ((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsBottom")) {
				capInsetsStretchBottom = ((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsLeft")) {
				capInsetsStretchLeft = ((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsRight")) {
				capInsetsStretchRight = ((int) args[i + 1]);	
			}
			
		}
	}
}
