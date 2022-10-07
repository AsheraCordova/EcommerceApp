package com.ashera.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import com.ashera.converter.CommonConverters;
import com.ashera.converter.ConverterFactory;

public class FragmentManager {
	private StackLayout stackLayout;
	private Composite rootComposite;
	private java.util.Stack<Control> nativeWidgetStack = new java.util.Stack<>();

	public FragmentManager(StackLayout stackLayout, Composite rootComposite, IActivity activity) {
		this.rootComposite = rootComposite;
		this.stackLayout = stackLayout;
		this.activity = activity;
	}

	private void storeInHistory(String type, String resId, String fileName, List<Map<String, Object>> scopedObjects) {
	}
	
	private void addRootToView(GenericFragment genericFragment) {
		stackLayout.topControl = getRoot(genericFragment);
	}

	private void disposeRoot(GenericFragment fragmentToBeDisposed) {
		getRoot(fragmentToBeDisposed).dispose();
	}
	private Composite getRoot(GenericFragment fragment) {
		return (Composite) fragment.getRootWidget().asNativeWidget();
	}	
	

	private void updateSizeIfRequired(DialogFragment dialogFragment) {
		Shell dialog = (Shell) dialogFragment.getParentForRootWidget();
		Rectangle bounds = getRoot(dialogFragment).getBounds();
		Shell activeShell = Display.getDefault().getActiveShell();
		int topBarHeight = activeShell.getBounds().height - activeShell.getClientArea().height;
		int dialogExtraWidth = activeShell.getBounds().width - activeShell.getClientArea().width;
		dialog.setSize(bounds.width + dialogExtraWidth, bounds.height + topBarHeight);
	}
	private void openDialog(Object mydialog, int width, int height, String windowCloseOnTouchOutside, Object backdropColor, String backgroundDimEnabled, DialogFragment dialogFragment) {
		Shell dialog = (Shell) mydialog;
		Shell activeShell = Display.getDefault().getActiveShell();
		GenericDialog de = new GenericDialog(activeShell, dialog);
		Rectangle bounds = getRoot(dialogFragment).getBounds();
		int topBarHeight = activeShell.getBounds().height - activeShell.getClientArea().height;
		int dialogExtraWidth = activeShell.getBounds().width - activeShell.getClientArea().width;
		dialog.setBounds(activeShell.getBounds().x + (activeShell.getBounds().width - bounds.width - dialogExtraWidth) /2, activeShell.getBounds().y 
				+ (activeShell.getBounds().height - bounds.height) /2, bounds.width + dialogExtraWidth, bounds.height + topBarHeight);
		
		
		dialog.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				int maxWidth = dialog.getBounds().width - dialogExtraWidth;
				int maxHeight = dialog.getBounds().height - topBarHeight;
				handleResize(dialogFragment, maxWidth, maxHeight);
			}
		});
		
		dialog.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
				handleDialogClose(dialogFragment);
			}
		});

		de.open();
	}
	
	public void closeDialog() {
		Shell[] shells = Display.getDefault().getShells();
		Shell activeShell = shells[shells.length - 1];
		activeShell.close();
		activeShell.dispose();
	}

	private Shell createDialog() {
		Shell[] shells = Display.getDefault().getShells();
		Shell activeShell = shells[shells.length - 1];
		Shell dialog = GenericDialog.createDialogShell(activeShell);
		return dialog;
	}

	private void layoutIfNeeded(GenericFragment genericFragment) {
		rootComposite.layout();
		rootComposite.setData("bounds", rootComposite.getBounds());
	}
	
	private void deactivateCurrentFragment(GenericFragment activeFragment) {
	}

	private boolean activateCurrentFragment(GenericFragment activeFragment) {
		stackLayout.topControl = getRoot(activeFragment);
		rootComposite.layout();
		Rectangle prevBounds = (Rectangle) rootComposite.getData("bounds");
		return prevBounds != null && !rootComposite.getBounds().equals(prevBounds);
	}


	public void popBackStack() {
		if (nativeWidgetStack.size() > 0) {
			stackLayout.topControl.dispose();
			stackLayout.topControl = nativeWidgetStack.pop();
			rootComposite.layout();
			return;
		}
		pop();
	}
	
	public void popBackStack(String destinationId, boolean inclusive) {
		try {
			popBackStack(destinationId, inclusive, 1);
			makeCurrentFragmentActive();
		} catch (DestinatinNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	//start - navigator
	private List<GenericFragment> fragments = new ArrayList<>();
	private Map<String, DialogFragment> dialogFragments = new LinkedHashMap<>();
	private IActivity activity;

	
	private void popBackStack(String destinationId, boolean inclusive, int indexFromEnd)
			throws DestinatinNotFoundException {
		int popCount = getPopCounter(destinationId, inclusive, indexFromEnd);

		for (int i = 0; i < popCount; i++) {
			pop(indexFromEnd);
		}
	}

	private void pop() {
		if (fragments.size() > 1) {
			pop(1);
			makeCurrentFragmentActive();
		}
	}

	private void makeCurrentFragmentActive() {
		GenericFragment activeFragment = getActiveFragment();
		
		if (activateCurrentFragment(activeFragment)) {
			activeFragment.remeasure();
		}
		activeFragment.onResume();
	}

	private void pop(int indexFromEnd) {
		GenericFragment fragmentToBeDisposed = fragments.get(fragments.size() - indexFromEnd);
		fragmentToBeDisposed.onPause();

		disposeRoot(fragmentToBeDisposed);

		fragmentToBeDisposed.onDestroy();
		fragmentToBeDisposed.onDetach();

		fragments.remove(fragments.size() - indexFromEnd);
	}

	public GenericFragment getActiveFragment() {
		if (dialogFragments.size() > 0) {
			Entry<String, DialogFragment> lastEntry = getLastDialogEntry();
			return lastEntry.getValue();
		}
		return fragments.get(fragments.size() - 1);
	}

	private Entry<String, DialogFragment> getLastDialogEntry() {
		List<Entry<String, DialogFragment>> entryList = new ArrayList<>(dialogFragments.entrySet());
		Entry<String, DialogFragment> lastEntry = entryList.get(entryList.size() - 1);
		return lastEntry;
	}
	

	public void navigate(String resId, String fileName) {
		navigate("fragment", resId, fileName, null, true);
	}

	private void navigate(String type, String resId, String fileName, List<Map<String, Object>> scopedObjects, boolean history) {
		//onpause
		onPause();
		
		if (fragments.size() > 0) {
			deactivateCurrentFragment(getActiveFragment());
			if (history) {
				storeInHistory(type, resId, fileName, scopedObjects);
			}
		}

		GenericFragment genericFragment = new GenericFragment();
		
		//oncreate
		onCreate(resId, fileName, scopedObjects, genericFragment);
		
		//oncreateview
		genericFragment.onCreateView(true);
		
		fragments.add(genericFragment);
		addRootToView(genericFragment);
		
		//onresume
		layoutIfNeeded(genericFragment);
		genericFragment.onResume();
	}


	public void navigate(String actionId, String destinationId, boolean inclusive, boolean finish, List<Map<String, Object>> scopedObjects, IFragment fragment) {
		navigate(actionId, scopedObjects, fragment);
		
		if (finish) {
			try {
				String id = ((r.android.os.Bundle) fragments.get(0).getArgumentsBundle()).getString("id");
				popBackStack(id, true, 2);
			} catch (DestinatinNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} else if (destinationId != null) {
			try {
				popBackStack(destinationId, inclusive, 2);
			} catch (DestinatinNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} else if (inclusive) {
			pop(2);
		}
	}
	
	public void navigate(String actionId, List<Map<String, Object>> scopedObjects, IFragment fragment) {
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
			navigateToDialog(type, resId, fileName, width, height, windowCloseOnTouchOutside, backdropColor, backgroundDimEnabled, marginPercent, scopedObjects);
			break;

		default:
			navigate(type, resId, fileName, scopedObjects, true);
			break;
		}
	}
	

	private void navigateToDialog(String type, String resId, String fileName,
			int width, int height, String windowCloseOnTouchOutside, Object backdropColor, String backgroundDimEnabled, Float marginPercent, List<Map<String, Object>> scopedObjects) {
		//onpause

		Object dialog = createDialog();

		DialogFragment genericFragment = new DialogFragment(dialog, width, height, marginPercent) {
			@Override
			public void remeasure() {
				super.remeasure();
				if (!isMeasuring()) {
					// update size of dialog
					updateSizeIfRequired(this);
				}
				
			}
		};
		
		if (genericFragment.isFullScreen()) {
			onPause();
		}
		
		//oncreate
		onCreate(resId, fileName, scopedObjects, genericFragment);
		dialogFragments.put(genericFragment.getFragmentId(), genericFragment);
		
		//oncreateview for dialog
		genericFragment.onCreateView(true);

		openDialog(dialog, width, height, windowCloseOnTouchOutside, backdropColor, backgroundDimEnabled,  genericFragment);

		//onresume
		layoutIfNeeded(genericFragment);
		genericFragment.onResume();
	}
	
	private void onCreate(String resId, String fileName, List<Map<String, Object>> scopedObjects,
			GenericFragment genericFragment) {
		genericFragment.setArguments(GenericFragment.getInitialBundle(resId, fileName, scopedObjects));
		genericFragment.onAttach(activity);
		genericFragment.onCreate();
	}

	private void onPause() {
		if (fragments.size() > 0) {
			GenericFragment activeFragment = getActiveFragment();
			if (activeFragment != null) {
				activeFragment.onPause();
			}
		}
	}

	private void handleResize(DialogFragment dialogFragment, int maxWidth, int maxHeight) {
		dialogFragment.setMaxWidth(maxWidth);
		dialogFragment.setMaxHeight(maxHeight);
		dialogFragment.remeasure();
	}
	

	private void handleDialogClose(DialogFragment dialogFragment) {
		dialogFragment.onPause();
		dialogFragment.onDestroy();
		dialogFragment.onDetach();
		dialogFragments.remove(dialogFragment.getFragmentId());
		
		GenericFragment fragment = getActiveFragment();
		if (dialogFragment.isFullScreen()) {
			fragment.onResume();
		}
		fragment.onCloseDialog();
	}

	private int getPopCounter(String destinationId, boolean inclusive, int indexFromEnd)
			throws DestinatinNotFoundException {
		boolean foundDestination = false;
		int popCount = 0;
		for (int i = fragments.size() - indexFromEnd; i >= 0; i--) {
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
	
	class DestinatinNotFoundException extends Exception {
		public DestinatinNotFoundException(String message) {
			super(message);
		}
	}
	//end - navigator


	public void popBackStack(IAsyncCallBack callBack) {
		popBackStack();
		callBack.done();
	}

	public void popBackStack(String destinationId, boolean inclusive, IAsyncCallBack callBack) {
		popBackStack(destinationId, inclusive);
		callBack.done();
	} 

	public void pushNativeWidget(Control control) {
		nativeWidgetStack.add(stackLayout.topControl);
		stackLayout.topControl = control;
		rootComposite.layout();
	}
	
	public Composite getRootComposite() {
		return rootComposite;
	}

}