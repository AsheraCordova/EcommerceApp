package com.ashera.core;

import java.util.List;
import java.util.Map;

import com.ashera.converter.CommonConverters;
import com.ashera.converter.ConverterFactory;

/*-[
#include <UIKit/UIKit.h>
#import "ASGenericFragmentController.h"
#import "ASDialogFragmentController.h"
#include "ASMainViewController.h"
]-*/
public class UINavigatorImpl {
	public UINavigatorImpl() {
	}

	public void navigate(String actionId, List<Map<String, Object>> scopedObjects, IFragment fragment) {
		navigate(actionId, scopedObjects, false, 0, false, fragment);
	}

	public void navigateWithPopBackStack(String actionId, List<Map<String, Object>> scopedObjects, IFragment fragment) {
		navigate(actionId, scopedObjects, true, 0, false, fragment);
	}


	public void navigateAsTop(String actionId, List<Map<String, Object>> scopedObjects, IFragment fragment) {
		navigate(actionId, scopedObjects, false, 0, true, fragment);
	}

	public void navigateWithPopBackStackTo(String actionId, String destinationId, boolean inclusive,
			List<Map<String, Object>> scopedObjects, IFragment fragment) {
		try {
			int popCount = getPopCount(destinationId, inclusive);
			navigate(actionId, scopedObjects, false, popCount, false, fragment);
		} catch (DestinatinNotFoundException e) {
			// nothing to do
			System.out.println(e.getMessage());
		}
	}
	
	public void navigate(String actionId, List<Map<String, Object>> scopedObjects, boolean finish, int popCount, boolean clear, IFragment fragment) {
		String[] destinationProps = actionId.split("#", -1);
		String type = destinationProps[0];
		String resId = destinationProps[1];
		String fileName = destinationProps[2];

		switch (type) {
		case "dialog":
			int width = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(destinationProps[3], null, fragment);
			int height = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(destinationProps[4], null, fragment);
			String style = destinationProps[5];
			if (style != null) {
				style = style.replace("@style/", "");
			}
			String attrStr = com.ashera.utils.ResourceBundleUtils.getString("values/theme", style.replace("@style/", ""), fragment);
			Object backdropColor = null;
			Float marginPercent = null;
			String windowCloseOnTouchOutside = null;
			String backgroundDimEnabled = null;
			if (attrStr != null && !attrStr.isEmpty()) {
		        String[] attrs = attrStr.split(";");
		        for (String attr : attrs) {
		        	String[] nameAndValue = attr.split("\\:");
		        	String key = nameAndValue[0];
		        	String value = nameAndValue.length <= 1 ? "" : nameAndValue[1];
		        	
		        	if (key.equals("marginPercent")) {
		        		marginPercent = (Float) ConverterFactory.get(CommonConverters.floatconverter).convertFrom(value, null, fragment);
		        	}
		        	if (key.equals("backdropColor")) {
		        		backdropColor = ConverterFactory.get("color").convertFrom(value, null, fragment);
		        	}
		        	if (key.equals("windowCloseOnTouchOutside")) {
		        		windowCloseOnTouchOutside = value;
		        	}
		        	
		        	if (key.equals("backgroundDimEnabled")) {
		        		backgroundDimEnabled = value;
		        	}
		        }
			}
			DialogFragment dialogFragment = new IosDialogFragment(null, width, height, marginPercent);
			dialogFragment.setArguments(GenericFragment.getInitialBundle(resId, fileName, scopedObjects));
			navigateToDialog(dialogFragment, backdropColor, windowCloseOnTouchOutside, backgroundDimEnabled);
			break;
		default:
			GenericFragment genericFragment = new GenericFragment();
			genericFragment.setArguments(GenericFragment.getInitialBundle(resId, fileName, scopedObjects));
			navigateToController(genericFragment, finish, clear, popCount);

			break;
		} 
	}
	
	private native void updateViewFrame(Object controller, Object obj) /*-[
		UIView* uiview = (UIView*) obj;
		UINavigationController* currentController =  (UINavigationController*) controller;
		[uiview setFrame:CGRectMake((currentController.view.frame.size.width-uiview.frame.size.width)/2, (currentController.view.frame.size.height-uiview.frame.size.height)/2, uiview.frame.size.width, uiview.frame.size.height)];
	]-*/;
	private native void navigateToDialog(Object rootFragment, Object backdropColor, String windowCloseOnTouchOutside, String backgroundDimEnabled) /*-[
  		ASMainViewController* mainViewController = (ASMainViewController*) [UIApplication sharedApplication].delegate.window.rootViewController;
  		UIViewController* presentedController = [self getTopPresentedController];
  		ASDialogFragmentController* v = [ASDialogFragmentController new];
  		v.backdropColor = (UIColor*)backdropColor;
  		v.windowCloseOnTouchOutside = windowCloseOnTouchOutside;
  		v.backgroundDimEnabled = backgroundDimEnabled;
    	v.modalPresentationStyle = UIModalPresentationOverFullScreen;
  		v.rootFragment = rootFragment;
  		v.cordovaActivity = mainViewController.cordovaActivity;
    	[presentedController presentViewController:v animated:YES completion:nil];
	]-*/;

	private native void navigateToController(Object rootFragment, boolean finish, boolean clear, int popCount)/*-[
    	ASMainViewController* mainViewController = (ASMainViewController*) [UIApplication sharedApplication].delegate.window.rootViewController;
    	UINavigationController* navController =  (UINavigationController*) mainViewController.navController;
  		NSMutableArray *viewControllers = [NSMutableArray arrayWithArray:[navController viewControllers]];
	  
	  	if (finish) {
	    	[viewControllers removeLastObject];
	  	}
	  	if (clear) {
	    	[viewControllers removeAllObjects];
	  	}
	  	if (popCount > 0) {
	  		for (NSUInteger i = 0; i < popCount; i++) {
	  			[viewControllers removeLastObject];
	  		}
	  	}
	  	
	  	if (rootFragment != nil) {
	    	ASGenericFragmentController* v = [ASGenericFragmentController new];
	    	v.rootFragment = rootFragment;
	    	v.cordovaActivity = mainViewController.cordovaActivity;
	    	[viewControllers addObject:v];
	  	}
	  
	  	[CATransaction begin];
	  	[navController setViewControllers:viewControllers animated:YES];	  
	  	[CATransaction commit];
	]-*/;

	public void closeDialog() {
		Object presentedController = getTopPresentedController();
		closeDialog(presentedController);
	}
	
	private native Object getFragment(Object presentedController) /*-[
		if ([presentedController class] == [ASDialogFragmentController class]) {
			ASDialogFragmentController* presentedViewController = (ASDialogFragmentController*) presentedController;
			return presentedViewController.rootFragment;
		}
		return nil;
	]-*/;
	
	private native void closeDialog(Object presentedController) /*-[
		if ([presentedController class] == [ASDialogFragmentController class]) {
			ASDialogFragmentController* presentedViewController = (ASDialogFragmentController*) presentedController;
			[presentedViewController dismiss];
		}
	]-*/;


	private native Object getTopPresentedController() /*-[
		ASMainViewController* mainViewController = (ASMainViewController*) [UIApplication sharedApplication].delegate.window.rootViewController;
		UIViewController* presentedController = mainViewController;
		
		while (presentedController.presentedViewController != nil) {
			presentedController = presentedController.presentedViewController;
		}
		
		return presentedController;
	]-*/;
	
	public void popBackStack(IFragment fragment) {
		navigateToController(null, true, false, 0);		
	}


	private native void getGenericFragments(List<GenericFragment> fragments)/*-[
		ASMainViewController* mainViewController = (ASMainViewController*) [UIApplication sharedApplication].delegate.window.rootViewController;
		UINavigationController* navController =  (UINavigationController*) mainViewController.navController;
		NSMutableArray *viewControllers = [NSMutableArray arrayWithArray:[navController viewControllers]];
		
		for (UIViewController *vc in viewControllers) {
			if ([vc isKindOfClass:[ASGenericFragmentController class]]) {
				[fragments addWithId: ((ASGenericFragmentController*) vc).rootFragment];
			}
		}
	]-*/;
	
	public void popBackStack(IFragment fragment, String destinationId, boolean inclusive) {
		try {
			int popCount = getPopCount(destinationId, inclusive);
			navigateToController(null, false, false, popCount);
		} catch (DestinatinNotFoundException e) {
			// nothing to do
			System.out.println(e.getMessage());
		}
	}


	public int getPopCount(String destinationId, boolean inclusive) throws DestinatinNotFoundException {
		List<GenericFragment> fragments = new java.util.ArrayList<>();
		getGenericFragments(fragments);
		boolean foundDestination = false;
		int popCount = 0;
		for (int i = fragments.size() - 1; i >= 0; i--) {
			GenericFragment genericFragment = fragments.get(i);
			String id = ((r.android.os.Bundle) genericFragment.getArgumentsBundle()).getString("id");
			if (id.equals(destinationId)) {
				foundDestination = true;
				if (inclusive) {
					popCount++;
				}
				break;
			}
			popCount++;
		}

		if (!foundDestination) {
			// We were passed a destinationId that doesn't exist on our back stack.
			// Better to ignore the popBackStack than accidentally popping the entire stack
			throw new DestinatinNotFoundException("Ignoring popBackStack to destination " + destinationId
					+ " as it was not found on the current back stack");
		}
		return popCount;
	}


	@com.google.j2objc.annotations.WeakOuter
	private final class IosDialogFragment extends DialogFragment {
		private IosDialogFragment(Object dialog, int layoutWidth, int layoutHeight, Float marginPercent) {
			super(dialog, layoutWidth, layoutHeight, marginPercent);
		}

		@Override
		public void remeasure() {
			super.remeasure();
			
			if (!isMeasuring()) {
				Object uiview = getRootWidget().asNativeWidget();
				updateViewFrame(getTopPresentedController(), uiview);
			}
		}
	}


	class DestinatinNotFoundException extends Exception {
		public DestinatinNotFoundException(String message) {
			super(message);
		}
	}


}
