package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;
import com.ashera.widget.PluginInvoker;

public class CGTintColorCommandConverter extends BaseAttributeCommand {
	private Object drawableTint;
	private int drawableTintMode; 
	
	public CGTintColorCommandConverter(String id) {
		super(id);
		nativeSetDefaultTintMode();
	}
	
	private native void nativeSetDefaultTintMode()  /*-[	    
		self->drawableTintMode_ =  (jint) kCGBlendModeSourceAtop;
	]-*/;
	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (drawableTint == null && drawableTintMode == 0) {
			return value;
		}
		Object myTint = drawableTint;
		if (myTint instanceof r.android.content.res.ColorStateList) {
			r.android.view.View view = (r.android.view.View) widget.asWidget();
			int color = ((r.android.content.res.ColorStateList) myTint).getColorForState(view.getDrawableState(),
					r.android.graphics.Color.RED);
			myTint = getColor(color);
		}
		if (value instanceof r.android.graphics.drawable.Drawable) {
			value = ((r.android.graphics.drawable.Drawable) value).getDrawable();
		}

		return colorImage(value, myTint, drawableTintMode);
	}
	
	public Object getColor(int color) {
		return PluginInvoker.getColor(r.android.graphics.Color.formatColor(color));
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		CGTintColorCommandConverter drawableTintCommandConverter = new CGTintColorCommandConverter(this.id);
		drawableTintCommandConverter.updateArgs(args);
		return drawableTintCommandConverter;
	}
	
	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}

	@Override
	public void updateArgs(Object... args) {
		if (args.length > 0) {
			if (args[0].equals("drawableTint")) {
				drawableTint = args[1];
			}
			
			if (args[0].equals("drawableTintMode")) {
				drawableTintMode = (int) args[1];
			}
		}
	}
	
	@Override
	public Object getValue(String attributeName) {
		switch (attributeName) {
			case "drawableTint":
				return drawableTint;
			case "drawableTintMode":
				return drawableTintMode;
			default:
				break;
		}

		return null;
	}

	private native Object colorImage(Object objImage, Object drawableTintObj, int drawableTintMode) /*-[
		if ([objImage isKindOfClass:[UIImage class]]) {
			UIImage* image = (UIImage*) objImage;
			UIColor* drawableTint = (UIColor*) drawableTintObj;
		    UIGraphicsBeginImageContextWithOptions(image.size, NO, [UIScreen mainScreen].scale);
		    CGContextRef context = UIGraphicsGetCurrentContext();
	
		    CGContextTranslateCTM(context, 0, image.size.height);
		    CGContextScaleCTM(context, 1.0, -1.0);
		    CGRect rect = CGRectMake(0, 0, image.size.width, image.size.height);
		    CGContextSetBlendMode(context, kCGBlendModeNormal);
		    CGContextDrawImage(context, rect, image.CGImage);
		    CGContextSetBlendMode(context, drawableTintMode);
		    [drawableTint setFill];
		    CGContextFillRect(context, rect);
	
		    UIImage *coloredImage = UIGraphicsGetImageFromCurrentImageContext();
		    UIGraphicsEndImageContext();
	
		    return coloredImage;
		} else {
			return objImage;
		}
	]-*/;
}
