package com.ashera.capinsets;


import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

/*-[
#include <UIKit/UIKit.h>
#include "CGRectWrapper.h"
]-*/
public class CGCapInsetsCommandConverter extends BaseAttributeCommand {
	private int capInsetsStretchTop;
	private int capInsetsStretchBottom;
	private int capInsetsStretchLeft;
	private int capInsetsStretchRight;
	private Object rectObj;
	
	public CGCapInsetsCommandConverter(String id) {
		super(id);
	}
	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}

		boolean isNinePatch = capInsetsStretchTop != 0 || capInsetsStretchBottom != 0 || capInsetsStretchLeft != 0 || capInsetsStretchRight != 0;

        if (isNinePatch) {
        	return nativeLoadImageBundle(value, capInsetsStretchTop, capInsetsStretchBottom, capInsetsStretchLeft, capInsetsStretchRight);
        }
		return value;

	}
	
	/*-[	
	- (void)drawNinePatch:(const CGRect *)sourceRect targetRect:(const CGRect *)targetRect background:(UIImage*) background {
	    CGImageRef cgImg = CGImageCreateWithImageInRect(background.CGImage, *sourceRect);
	    UIImage* slice = [UIImage imageWithCGImage:cgImg];
	    [slice drawInRect:*targetRect];
	    CGImageRelease(cgImg);
	}
	]-*/
	
	private native Object nativeLoadImageBundle(Object imageObj, int top, int bottom, int left, int right)/*-[
		if ([imageObj isKindOfClass:[UIImage class]]) {
			UIImage* background = (UIImage*) imageObj;
		    CGRect rect = ((CGRectWrapper*) self->rectObj_).rect;
		    CGSize finalSize = CGSizeMake(rect.size.width, rect.size.height);
		    
		    UIGraphicsBeginImageContext(finalSize);
		    
		    
		    if (top > 0 && left > 0) {
		      CGRect sourceRect = CGRectMake(0, 0, left, top);
		      [self drawNinePatch:&sourceRect targetRect:&sourceRect background: background];
		    }
		    
		    if (bottom > 0 && left > 0) {
		      CGRect sourceRect = CGRectMake(0, background.size.height - bottom, left, bottom);
		      CGRect destRect = CGRectMake(0, rect.size.height - bottom, left, bottom);
		      [self drawNinePatch:&sourceRect targetRect:&destRect background: background];
		    }
		    
		    if (left > 0) {
		      CGRect sourceRect = CGRectMake(0, top, left, background.size.height - top - bottom);
		      CGRect destRect = CGRectMake(0, top, left, rect.size.height - top - bottom);
		      [self drawNinePatch:&sourceRect targetRect:&destRect background: background];
		    }
		    
		    if (bottom > 0 && right > 0) {
		      CGRect sourceRect = CGRectMake( background.size.width - right, background.size.height - bottom, right, bottom);
		      CGRect destRect = CGRectMake( rect.size.width - right, rect.size.height - bottom, right, bottom);
		      [self drawNinePatch:&sourceRect targetRect:&destRect background: background];
		    }
		    
		    if (top > 0 && right > 0) {
		      CGRect sourceRect = CGRectMake( background.size.width - right, 0, right, top);
		      CGRect destRect = CGRectMake( rect.size.width - right, 0, right, top);
		      [self drawNinePatch:&sourceRect targetRect:&destRect background: background];
		    }
		    
		    if (top > 0) {
		      CGRect sourceRect = CGRectMake(left, 0, background.size.width - right - left, top);
		      CGRect destRect = CGRectMake(left, 0, rect.size.width - right - left, top);
		      [self drawNinePatch:&sourceRect targetRect:&destRect background: background];
		    }
		
		    if (right > 0) {
		      CGRect sourceRect = CGRectMake(background.size.width - right, top,right, background.size.height - top - bottom);
		      CGRect destRect = CGRectMake(rect.size.width - right, top,right, rect.size.height - top - bottom);
		      [self drawNinePatch:&sourceRect targetRect:&destRect background: background];
		    }
		
		    if (bottom > 0) {
		      CGRect sourceRect = CGRectMake(left, background.size.height - bottom,  background.size.width - left - right, bottom);
		      CGRect destRect = CGRectMake(left, rect.size.height - bottom,  rect.size.width - left - right, bottom);
		      [self drawNinePatch:&sourceRect targetRect:&destRect background: background];
		    }
		
		    // middle part
		    CGRect sourceRect = CGRectMake(left, top, background.size.width - left - right, background.size.height - top - bottom);
		    CGRect destRect = CGRectMake(left, top, rect.size.width - left - right, rect.size.height - top - bottom);
		    [self drawNinePatch:&sourceRect targetRect:&destRect background: background];
		
		    UIImage *finalImage = UIGraphicsGetImageFromCurrentImageContext();
		    UIGraphicsEndImageContext();
		    return finalImage;
		} else {
			return imageObj;
		}
	]-*/;

	@Override
	public AttributeCommand newInstance(Object... args) {
		CGCapInsetsCommandConverter capInsetsCommandConverter = new CGCapInsetsCommandConverter(this.id);
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
	
	@Override
	public void updatePhaseArgs(java.lang.Object... args) {
		for (int i = 0; i < args.length; i+=2) {
			Object attributeName = args[i];
			
			if (attributeName.equals("rect")) {
				rectObj = args[i + 1];		
			}
		}
	}

	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}
}
