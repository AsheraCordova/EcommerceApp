package com.ashera.android;

import com.ashera.widget.ICustomMeasureHeight;
import com.ashera.widget.IWidget;

import r.android.view.View;
/*-[
#include <UIKit/UIKit.h>
]-*/
public class MeasurableView extends View {
	private @com.google.j2objc.annotations.Weak IWidget widget;
	private com.ashera.android.factory.ui.NativeImpl nativeImpl = com.ashera.android.factory.ui.NativeImpl.getInstance();
	public MeasurableView(IWidget widget) {
		this.widget = widget;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
	    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
	    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
	    int heightSize = MeasureSpec.getSize(heightMeasureSpec);

	    int width;
	    int height;
	    if (widthMode == MeasureSpec.EXACTLY) {
	        // Parent has told us how big to be. So be it.
	        width = widthSize;
	    } else {
	    	width = mPaddingLeft + mPaddingRight;
	    	width += nativeMeasureWidth(widget.asNativeWidget());
	    	
	    	if (width > widthSize) {
	    		width = widthSize;
	    	}

            width = Math.max(getSuggestedMinimumWidth(), width);
            		    
		    if (widget instanceof com.ashera.widget.IMaxWidth) {
		    	int maxWidth = ((com.ashera.widget.IMaxWidth) widget).getMaxWidth();
				if (width > maxWidth) {
					width = maxWidth;
		    	}
		    }
	    }
	    
	    if (heightMode == MeasureSpec.EXACTLY) {
	        // Parent has told us how big to be. So be it.
	        height = heightSize;
	    } else {
	    	
	    	height = mPaddingTop + mPaddingBottom;
	    	if (widget instanceof ICustomMeasureHeight) {
	    		height += ((ICustomMeasureHeight) widget).measureHeight(width - mPaddingLeft - mPaddingRight);
	    	} else {
	    		height += nativeMeasureHeight(widget.asNativeWidget(), width - mPaddingLeft - mPaddingRight);
	    	}
            height = Math.max(getSuggestedMinimumHeight(), height);
	    }
	    
	    if (widget instanceof com.ashera.widget.IMaxHeight) {
	    	int maxHeight = ((com.ashera.widget.IMaxHeight) widget).getMaxHeight();
			if (height > maxHeight) {
	    		height = maxHeight;
	    	}
	    }

	    setMeasuredDimension(width, height);	
	}

	@Override
	protected void onLayout(boolean changed, int left, int top,
			int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		nativeImpl.nativeMakeFrame(widget.asNativeWidget(), left, top, right, bottom);
	}
	
	private native int nativeMeasureWidth(Object uiView)/*-[
    	CGSize maximumLabelSize = CGSizeMake(CGFLOAT_MAX,CGFLOAT_MAX);
    	CGSize requiredSize = [((UIView*)uiView) sizeThatFits:maximumLabelSize];
    	return ceil(requiredSize.width);
	]-*/;

	private native int nativeMeasureHeight(Object uiView, int width)/*-[
	    CGSize maximumLabelSize = CGSizeMake(width,CGFLOAT_MAX);
	    CGSize requiredSize = [((UIView*)uiView) sizeThatFits:maximumLabelSize];
	    return ceil(requiredSize.height);
	]-*/;


//	public native void nativeMakeFrame(Object uiView,int l, int t, int r, int b)/*-[
//		[((UIView*)uiView) setFrame:CGRectMake(l, t, r-l, b-t)];
//	]-*/;


}
