package com.ashera.core;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import com.ashera.converter.CommonConverters;
import com.ashera.converter.ConverterFactory;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

public class UINavigatorImpl {
	public void navigate(String actionId, String destinationId, boolean inclusive, boolean finish, List<Map<String, Object>> scopedObjects, IFragment fragment) {
		IActivity activity = fragment.getRootActivity();

		String[] destinationProps = actionId.split("#", -1);
		
		String type = destinationProps[0];
		String resId = destinationProps[1];
		String fileName = destinationProps[2];

		if (fileName != null && !fileName.equals("")) {
			Bundle bundle = GenericFragment.getInitialBundle(resId, fileName, scopedObjects);
			
			if (type.equals("dialog")) {
				int width = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(destinationProps[3], null, fragment);
				int height = (int) ConverterFactory.get(CommonConverters.dimension).convertFrom(destinationProps[4], null, fragment);
				String style = destinationProps[5];
				if (style != null) {
					style = style.replace("@style/", "");
				}
				String attrStr = com.ashera.utils.ResourceBundleUtils.getString("values/theme", style.replace("@style/", ""), fragment);
				Integer backdropColor = null;
				String windowCloseOnTouchOutside = null;
				if (attrStr != null && !attrStr.isEmpty()) {
			        String[] attrs = attrStr.split(";");
			        for (String attr : attrs) {
			        	String[] nameAndValue = attr.split("\\:");
			        	String key = nameAndValue[0];
			        	String value = nameAndValue.length <= 1 ? "" : nameAndValue[1];
			        	
			        	if (key.equals("backdropColor")) {
			        		backdropColor = (int) ConverterFactory.get("color").convertFrom(value, null, fragment);
			        	}
			        	if (key.equals("windowCloseOnTouchOutside")) {
			        		windowCloseOnTouchOutside = value;
			        	}
			        }
				}
				
				MyDialog.updatedBundle(bundle, width, height, backdropColor, windowCloseOnTouchOutside, style);
			}

			FragmentActivity fragmentActivity = (FragmentActivity) activity;
			int navigationId = fragmentActivity.getResources().getIdentifier(resId, "id",fragmentActivity.getPackageName());
			NavController navController = NavHostFragment.findNavController((Fragment) fragment);			
			NavOptions.Builder navOptions = new NavOptions.Builder();
			
			if (finish) {
				@SuppressLint("RestrictedApi")  Deque<NavBackStackEntry> backStack = navController.getBackStack();
				if (!backStack.isEmpty()) {
					int destinationResId = backStack.getFirst().getDestination().getId();
					navOptions.setPopUpTo(destinationResId, true);
				}
			} else if (destinationId != null) {
				int destinationResId = fragmentActivity.getResources().getIdentifier(destinationId, "id",fragmentActivity.getPackageName());
				navOptions.setPopUpTo(destinationResId, inclusive);
			} else if (inclusive) {
				int destinationResId = navController.getCurrentDestination().getId();
				navOptions.setPopUpTo(destinationResId, inclusive);
			}
			
			navController.navigate(navigationId, bundle, navOptions.build());
		}
	}

	private void hideKeyboard(Activity activity) {
	    InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
	    //Find the currently focused view, so we can grab the correct window token from it.
	    View view = activity.getCurrentFocus();
	    //If no view currently has focus, create a new one, just so we can grab a window token from it
	    if (view == null) {
	        view = new View(activity);
	    }
	    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}

	public void closeDialog(IFragment fragment) {
		NavHostFragment.findNavController((Fragment) fragment).navigateUp();
	}

	public void popBackStack(IFragment fragment) {
		NavHostFragment.findNavController((Fragment) fragment).popBackStack();
	}

	public void popBackStack(IFragment fragment, String destinationId, boolean inclusive) {
		IActivity activity = fragment.getRootActivity();
		FragmentActivity fragmentActivity = (FragmentActivity) activity;
		int navigationId = fragmentActivity.getResources().getIdentifier(destinationId, "id",fragmentActivity.getPackageName());		
		NavHostFragment.findNavController((Fragment) fragment).popBackStack(navigationId, inclusive);
	}

	public void popBackStack(IFragment activeRootFragment, IAsyncCallBack callBack) {
		popBackStack(activeRootFragment);
		callBack.done();
	}

	public void popBackStack(IFragment activeRootFragment, String destinationId, boolean inclusive,
			IAsyncCallBack callBack) {
		popBackStack(activeRootFragment, destinationId, inclusive);
		callBack.done();
	}
	
}
