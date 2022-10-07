package com.ashera.android.factory.ui;

/*-[
#include <UIKit/UIKit.h>
]-*/
public class NativeImpl {
	private static NativeImpl nativeImpl = new NativeImpl();
	private NativeImpl() {
	}
	
	public static NativeImpl getInstance() {
		return nativeImpl;
	}
	
	public native void nativeMakeFrame(Object uiView, int l, int t, int r, int b, int height)/*-[
		[((UIView*) uiView) setFrame:CGRectMake(l, t, r-l, b-t)];
		((UIScrollView*) uiView).contentSize = CGSizeMake(r-l, height);
	]-*/;
	
	public native void nativeMakeFrameForHorizontalScrollView(Object uiView, int l, int t, int r, int b, int width)/*-[
		[((UIView*) uiView) setFrame:CGRectMake(l, t, r-l, b-t)];
		((UIScrollView*) uiView).contentSize = CGSizeMake(width, b-t);
	]-*/;
	
	public native void nativeMakeFrame(Object uiView, int l, int t, int r, int b)/*-[
			if ([uiView isKindOfClass:[UIViewController class]]) {
				[((UIViewController*) uiView).view setFrame:CGRectMake(l, t, r-l, b-t)];
			} else {
				[((UIView*) uiView) setFrame:CGRectMake(l, t, r-l, b-t)];
			}  	
	]-*/;
	
	public native int nativeGetScreenWidth()/*-[
	UIDeviceOrientation orientation = [[UIDevice currentDevice] orientation];
	CGFloat width   = [[UIScreen mainScreen] bounds].size.width;
	CGFloat height   = [[UIScreen mainScreen] bounds].size.height;
	CGRect bounds = CGRectZero;
	if (UIInterfaceOrientationIsLandscape(orientation)) {
    	bounds.size = CGSizeMake(MAX(width, height), MIN(width, height));
	} else {
    	bounds.size = CGSizeMake(MIN(width, height), MAX(width, height));
	}
	return bounds.size.width;
]-*/;
	
	public int getActionItemWidthLimit() {
		return nativeGetScreenWidth()/2;
	}

	public int getMaxItems() {
		return nativeGetScreenWidth()/100;
	}
}
