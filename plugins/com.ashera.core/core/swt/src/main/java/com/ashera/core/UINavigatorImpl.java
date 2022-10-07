package com.ashera.core;

import java.util.List;
import java.util.Map;

public class UINavigatorImpl {
	public void navigate(String actionId, List<Map<String, Object>> scopedObjects,  IFragment fragment) {
		com.ashera.core.FragmentManager manager = ((com.ashera.core.BaseCordovaActivity) fragment.getRootActivity()).getFragmentManager();
		manager.navigate(actionId, scopedObjects, fragment);
	}

	public void closeDialog(IFragment fragment) {
		com.ashera.core.FragmentManager manager = ((com.ashera.core.BaseCordovaActivity) fragment.getRootActivity()).getFragmentManager();
		manager.closeDialog();
		
	}

	public void popBackStack(IFragment fragment, IAsyncCallBack callBack) {
		com.ashera.core.FragmentManager manager = ((com.ashera.core.BaseCordovaActivity) fragment.getRootActivity()).getFragmentManager();
		manager.popBackStack(callBack);
	}

	public void popBackStack(IFragment fragment, String destinationId, boolean inclusive, IAsyncCallBack callBack) {
		com.ashera.core.FragmentManager manager = ((com.ashera.core.BaseCordovaActivity) fragment.getRootActivity()).getFragmentManager();
		manager.popBackStack(destinationId, inclusive, callBack);
	}


	public void navigate(String actionId, String destinationId, boolean inclusive,
			boolean finish, List<Map<String, Object>> scopedObjects, IFragment fragment) {
		com.ashera.core.FragmentManager manager = ((com.ashera.core.BaseCordovaActivity) fragment.getRootActivity()).getFragmentManager();
		manager.navigate(actionId, destinationId, inclusive, finish, scopedObjects, fragment);
		
	}

}
