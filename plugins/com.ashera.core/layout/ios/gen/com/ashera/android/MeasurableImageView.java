package com.ashera.android;

import com.ashera.android.factory.ui.NativeImpl;
import com.ashera.widget.IWidget;

import r.android.view.View;

/*-[
#include <UIKit/UIKit.h>
#include "ASImageView.h"
]-*/
public class MeasurableImageView extends View {
	private @com.google.j2objc.annotations.Weak IWidget widget;
	private NativeImpl nativeImpl = NativeImpl.getInstance();
	private boolean mAdjustViewBoundsCompat;
	private boolean mAdjustViewBounds = true;
	private Object mDrawable;
	private int mDrawableWidth;
	private int mDrawableHeight;
	private int mMaxWidth = Integer.MAX_VALUE;
	private int mMaxHeight = Integer.MAX_VALUE;
	public MeasurableImageView(IWidget widget) {
		this.widget = widget;
	}

	public IWidget getWidget() {
		return widget;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        resolveUri();
        int w;
        int h;
        
        // Desired aspect ratio of the view's contents (not including padding)
        float desiredAspect = 0.0f;
        
        // We are allowed to change the view's width
        boolean resizeWidth = false;
        
        // We are allowed to change the view's height
        boolean resizeHeight = false;
        
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        if (mDrawable == null) {
            // If no drawable, its intrinsic size is 0.
            mDrawableWidth = -1;
            mDrawableHeight = -1;
            w = h = 0;
        } else {
            w = mDrawableWidth;
            h = mDrawableHeight;
            if (w <= 0) w = 1;
            if (h <= 0) h = 1;

            // We are supposed to adjust view bounds to match the aspect
            // ratio of our drawable. See if that is possible.
            if (mAdjustViewBounds) {
                resizeWidth = widthSpecMode != MeasureSpec.EXACTLY;
                resizeHeight = heightSpecMode != MeasureSpec.EXACTLY;
                
                desiredAspect = (float) w / (float) h;
            }
        }
        
        int pleft = mPaddingLeft;
        int pright = mPaddingRight;
        int ptop = mPaddingTop;
        int pbottom = mPaddingBottom;

        int widthSize;
        int heightSize;

        if (resizeWidth || resizeHeight) {
            /* If we get here, it means we want to resize to match the
                drawables aspect ratio, and we have the freedom to change at
                least one dimension. 
            */

            // Get the max possible width given our constraints
            widthSize = resolveAdjustedSize(w + pleft + pright, mMaxWidth, widthMeasureSpec);

            // Get the max possible height given our constraints
            heightSize = resolveAdjustedSize(h + ptop + pbottom, mMaxHeight, heightMeasureSpec);

            if (desiredAspect != 0.0f) {
                // See what our actual aspect ratio is
                float actualAspect = (float)(widthSize - pleft - pright) /
                                        (heightSize - ptop - pbottom);
                
                if (Math.abs(actualAspect - desiredAspect) > 0.0000001) {
                    
                    boolean done = false;
                    
                    // Try adjusting width to be proportional to height
                    if (resizeWidth) {
                        int newWidth = (int)(desiredAspect * (heightSize - ptop - pbottom)) +
                                pleft + pright;

                        // Allow the width to outgrow its original estimate if height is fixed.
                        if (!resizeHeight && !mAdjustViewBoundsCompat) {
                            widthSize = resolveAdjustedSize(newWidth, mMaxWidth, widthMeasureSpec);
                        }

                        if (newWidth <= widthSize) {
                            widthSize = newWidth;
                            done = true;
                        } 
                    }
                    
                    // Try adjusting height to be proportional to width
                    if (!done && resizeHeight) {
                        int newHeight = (int)((widthSize - pleft - pright) / desiredAspect) +
                                ptop + pbottom;

                        // Allow the height to outgrow its original estimate if width is fixed.
                        if (!resizeWidth && !mAdjustViewBoundsCompat) {
                            heightSize = resolveAdjustedSize(newHeight, mMaxHeight,
                                    heightMeasureSpec);
                        }

                        if (newHeight <= heightSize) {
                            heightSize = newHeight;
                        }
                    }
                }
            }
        } else {
            /* We are either don't want to preserve the drawables aspect ratio,
               or we are not allowed to change view dimensions. Just measure in
               the normal way.
            */
            w += pleft + pright;
            h += ptop + pbottom;
                
            w = Math.max(w, getSuggestedMinimumWidth());
            h = Math.max(h, getSuggestedMinimumHeight());

            widthSize = resolveSizeAndState(w, widthMeasureSpec, 0);
            heightSize = resolveSizeAndState(h, heightMeasureSpec, 0);
        }

        setMeasuredDimension(widthSize, heightSize);
    }

	private void resolveUri() {
		if (mDrawable != null) {
			return;
		}
		updateDrawable();
	}
	
    private void updateDrawable() {

    	Object d = widget.asNativeWidget();
    		
    	if (d != null) {
            mDrawableWidth = (int) getWidth(d);
            mDrawableHeight = (int) getHeight(d);
        } else {
            mDrawableWidth = mDrawableHeight = -1;
        }
        mDrawable = d;
    }
    
	private native int getWidth(Object nativeWidget)/*-[
  		return ((ASImageView*) nativeWidget).image.size.width;
	]-*/;
	
	private native int getHeight(Object nativeWidget)/*-[
  		return ((ASImageView*) nativeWidget).image.size.height;
	]-*/;

	private int resolveAdjustedSize(int desiredSize, int maxSize,
            int measureSpec) {
		int result = desiredSize;
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize =  MeasureSpec.getSize(measureSpec);
		switch (specMode) {
		case MeasureSpec.UNSPECIFIED:
		/* Parent says we can be as big as we want. Just don't be larger
		than max size imposed on ourselves.
		*/
		result = Math.min(desiredSize, maxSize);
		break;
		case MeasureSpec.AT_MOST:
		// Parent says we can be as big as we want, up to specSize. 
		// Don't be larger than specSize, and don't be larger than 
		// the max size imposed on ourselves.
		result = Math.min(Math.min(desiredSize, specSize), maxSize);
		break;
		case MeasureSpec.EXACTLY:
		// No choice. Do what we are told.
		result = specSize;
		break;
		}
		return result;
	}
	
	@Override
	protected void onLayout(boolean changed, int left, int top,
			int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		nativeImpl.nativeMakeFrame(widget.asNativeWidget(), left, top, right, bottom);
	}

	
	public void setAdjustViewBounds(boolean mAdjustViewBounds) {
		this.mAdjustViewBounds = mAdjustViewBounds;
	}



}
