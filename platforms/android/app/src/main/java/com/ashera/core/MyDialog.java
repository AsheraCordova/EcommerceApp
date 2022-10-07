package com.ashera.core;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

public class MyDialog extends GenericDialogFragment {
	public MyDialog() {
	}
	
	public static void updatedBundle(Bundle args, int width, int height, Integer backdropColor, String windowCloseOnTouchOutside, String style) {
		args.putInt("width", width);
		args.putInt("height", height);
		args.putString("style", style);
		args.putSerializable("backdropColor", backdropColor);
		args.putString("windowCloseOnTouchOutside", windowCloseOnTouchOutside);
	}


	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		String style = getArguments().getString("style");
		int theme = 0;
		if (style != null && !style.isEmpty()) {
			theme = context.getResources().getIdentifier(style, "style", context.getPackageName());
		}
		
		setStyle(androidx.fragment.app.DialogFragment.STYLE_NO_TITLE, theme);
	}

	@SuppressLint("ResourceType")
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Dialog dialog = super.onCreateDialog(savedInstanceState);
		Integer backdropColor = (Integer) getArguments().getSerializable("backdropColor");
		if (backdropColor != null) {
			ViewGroup root = getRoot();
			View view = root.findViewById(Integer.MAX_VALUE);
			if (view == null) {
				view = new View(getContext());
				view.setId(Integer.MAX_VALUE);
				view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
				view.setBackgroundColor(backdropColor);
				root.addView(view);
	
				if ("true".equals(getArguments().getString("windowCloseOnTouchOutside"))) {
					view.setOnClickListener((e) -> {
						NavHostFragment.findNavController(MyDialog.this).navigateUp();
					});
				}
			}
		}
		return dialog;
	}

	private ViewGroup getRoot() {
		ViewGroup root = null;
		NavHostFragment navHostFragment = (NavHostFragment) getParentFragment();
		List fragmentList = navHostFragment.getChildFragmentManager().getFragments();
		for (int i=fragmentList.size() - 1; i >= 0; i--) {
			Fragment fragment = (Fragment) fragmentList.get(i);
			if (fragment instanceof GenericFragment) {
				root = (ViewGroup) ((GenericFragment) fragment).getRootWidget().asWidget();


				break;
			}
		}
		return root;
	}

	@Override
	public void onStart() {
	    super.onStart();
	    Dialog dialog = getDialog();
	    if (dialog != null) {
	        int width = getArguments().getInt("width");
	        int height = getArguments().getInt("height");
	        
	        dialog.getWindow().setLayout(width, height);
	    }
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Object prevFragment = getPrevFragment();
		if (prevFragment instanceof GenericFragment) {
			ViewGroup root = getRoot();
			View view = root.findViewById(Integer.MAX_VALUE);
			if (view != null) {
				root.removeView(view);
			}
		}
	}

	private Object getPrevFragment() {
		NavHostFragment navHostFragment = (NavHostFragment) getParentFragment();
		List fragments = navHostFragment.getChildFragmentManager().getFragments();
		Object prevFragment = fragments.get(fragments.size() - 1);
		return prevFragment;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		
		Object prevFragment = getPrevFragment();
		if (prevFragment instanceof IFragment) {
			((IFragment) prevFragment).onCloseDialog();
		}
	}
}