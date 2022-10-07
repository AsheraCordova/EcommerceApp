package com.ashera.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.xml.NodeList;

import com.ashera.converter.CommonConverters;
import com.ashera.converter.ConverterFactory;

public class FragmentManager {
    public interface Detail extends org.teavm.jso.JSObject {
    	@org.teavm.jso.JSProperty
 	    String getFrom();
 	    
 	    @org.teavm.jso.JSProperty
 	    String getTo();
 	    
 	    @org.teavm.jso.JSProperty
 	    String getSide();
 	    
 	    @org.teavm.jso.JSProperty
	    String getState();
    }
    public interface HistoryEvent extends Event {
    	@org.teavm.jso.JSProperty
    	Detail getDetail();
    }

	private void layoutIfNeeded(GenericFragment genericFragment) {
	}
	
	private Object createDialog() {
		HTMLElement dialog = org.teavm.jso.browser.Window.current().getDocument().createElement("div");
		dialog.setAttribute("dialog", "true");
		dialog.setAttribute("class", "web-dialog");
		return dialog;
	}
	

	public void closeDialog() {
		HTMLElement shadowRoot = getShadowRoot();
		NodeList<? extends HTMLElement> dialogs = shadowRoot.querySelectorAll(".web-dialog");
		if (dialogs.getLength() > 0) {
			HTMLElement element = dialogs.get(dialogs.getLength() - 1);
			removeChildFromShadowRoot(element);
			handleDialogClose(dialogFragments.get(element.getAttribute("fragmentId")));
		}
	}

	private void openDialog(Object dialogObj, int width, int height, String windowCloseOnTouchOutside, Object backdropColor, String backgroundDimEnabled, DialogFragment genericFragment) {
		HTMLElement dialog = (HTMLElement) dialogObj;
		int screenWidth = com.ashera.widget.PluginInvoker.getScreenWidth();
		int screenHeight = com.ashera.widget.PluginInvoker.getScreenHeight();
		dialog.getStyle().setProperty("width", screenWidth + "px");
		dialog.getStyle().setProperty("height", screenHeight + "px");
		dialog.getStyle().setProperty("position", "absolute");
		dialog.setAttribute("fragmentId", genericFragment.getFragmentId());
		
		if (backgroundDimEnabled == null || "true".equals(backgroundDimEnabled)) {
			dialog.getStyle().setProperty("background-color", backdropColor == null ? "#00000033" : (String) backdropColor);
		}
		
		HTMLElement root = updateLeftAndTop(genericFragment, screenWidth, screenHeight);
		dialog.appendChild(root);
		appendChildToShadowRoot(dialog);

		if ("true".equals(windowCloseOnTouchOutside)) {
			dialog.addEventListener("click", (event) -> {
				HTMLElement element = (HTMLElement) event.getTarget().cast();
				if(element.getAttribute("dialog") != null) {
					removeChildFromShadowRoot(dialog);
					handleDialogClose(genericFragment);
				}
			});		
		}
	}

	private HTMLElement updateLeftAndTop(DialogFragment genericFragment, int screenWidth, int screenHeight) {
		HTMLElement root = getRoot(genericFragment);
		r.android.view.View view = (r.android.view.View)genericFragment.getRootWidget().asWidget();
		root.getStyle().setProperty("left", (screenWidth - view.getMeasuredWidth()) /2 + "");
		root.getStyle().setProperty("top", (screenHeight - view.getMeasuredHeight()) /2 + "");
		return root;
	}

	private void deactivateCurrentFragment(GenericFragment activeFragment) {
		getRoot(activeFragment).getStyle().setProperty("visibility", "hidden");
	}

	private void disposeRoot(GenericFragment fragmentToBeDisposed) {
		removeChildFromShadowRoot(getRoot(fragmentToBeDisposed));		
	}	


	private void addRootToView(GenericFragment genericFragment) {
		appendChildToShadowRoot(getRoot(genericFragment));	
	}

	private HTMLElement getRoot(GenericFragment fragment) {
		return (HTMLElement) fragment.getRootWidget().asNativeWidget();
	}

    public FragmentManager(IActivity activity) {
        this.activity = activity;
        this.disableHistory = "true".equals(activity.getPreference("webDisableHistory"));
        addHistoryChangeEvent();
    }
    
    // history related methods - starts here
    private boolean disableHistory;
	private final class HistoryChangeListener implements org.teavm.jso.dom.events.EventListener<HistoryEvent> {
		private final IAsyncCallBack callback;

		private HistoryChangeListener(IAsyncCallBack callback) {
			this.callback = callback;
		}

		@Override
		public void handleEvent(HistoryEvent evt) {
			org.teavm.jso.browser.Window.current().removeEventListener("historyChange", this);
			com.ashera.widget.PluginInvoker.postDelayed(() -> callback.done(), 30);
		}
	}
	private void addHistoryChangeEvent() {
		if (!disableHistory) {
			org.teavm.jso.browser.Window.current().addEventListener("historyChange", new org.teavm.jso.dom.events.EventListener<HistoryEvent>() {
	
				@Override
				public void handleEvent(HistoryEvent evt) {
					if (evt.getDetail().getSide().equals("back")) {
						handleBackChange(evt);
					} else {
						java.util.HashMap<String, String> obj = com.ashera.widget.PluginInvoker.unmarshal(evt.getDetail().getState(), java.util.HashMap.class);
						Object payload = com.ashera.widget.PluginInvoker.unmarshal(obj.get("payload"), List.class);
						navigate("fragment", obj.get("resId"), obj.get("fileName"), (List<Map<String, Object>>) payload, false);
					}
					
				}
	        });
		}
	}

	private void storeInHistory(String type, String resId, String fileName, List<Map<String, Object>> scopedObjects) {
		if (!disableHistory) {
			String historyUrl = fileName.substring(fileName.lastIndexOf("/"));
	    	String data = String.format("{\"resId\": \"%s\", \"fileName\": \"%s\", \"payload\": \"%s\"}", resId,
	    			fileName, escape(com.ashera.widget.PluginInvoker.marshal(scopedObjects)));
			org.teavm.jso.JSObject obj = org.teavm.jso.json.JSON.parse(data);
			org.teavm.jso.browser.Window.current().getHistory().pushState(obj, "", historyUrl.replace(".xml", ""));
		}
	}
	
	public void popBackStack(IAsyncCallBack callback) {
		if (disableHistory) {
			pop();	
		} else {
			org.teavm.jso.browser.Window.current().addEventListener("historyChange", new HistoryChangeListener(callback));
			org.teavm.jso.browser.Window.current().getHistory().go(-1);	
		}
	}
	
	public void popBackStack(String destinationId, boolean inclusive, IAsyncCallBack callback) {
		try {
			if (disableHistory) {
				popBackStack(destinationId, inclusive, 1);
				callback.done();
			} else {
				int popCount = getPopCounter(destinationId, inclusive, 1);
				org.teavm.jso.browser.Window.current().addEventListener("historyChange", new HistoryChangeListener(callback));
				org.teavm.jso.browser.Window.current().getHistory().go(-popCount);
			}
			makeCurrentFragmentActive();
		} catch (DestinatinNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// history related methods - starts here

	private boolean activateCurrentFragment(GenericFragment activeFragment) {
		getRoot(activeFragment).getStyle().setProperty("visibility", "visible");
		return true;
	}

	private void handleBackChange(HistoryEvent evt) {
		try {
			String state = "{\"fileName\" : \"layout/index.xml\"}";
			
			try {
				state = evt.getDetail().getState();
			} catch (Exception e) {
			}
			java.util.HashMap<String, String> obj = com.ashera.widget.PluginInvoker.unmarshal(state, java.util.HashMap.class);
			String actionUrl = null;
			if (fragments.size() - 2 >= 0) {
				actionUrl = fragments.get(fragments.size() - 2).getActionUrl();
			}
			if (obj.get("fileName").equals(actionUrl)) {
				pop();	
			} else {
				org.teavm.jso.browser.Window.current().getHistory().go(-1);							
			}
			
		} catch (Exception e) {
			// ignore
			org.teavm.jso.browser.Window.current().getHistory().go(-1);
		}
	}

	private static String escape(String jsString) {
	    jsString = jsString.replace("\\", "\\\\");
	    jsString = jsString.replace("\"", "\\\"");
	    jsString = jsString.replace("\b", "\\b");
	    jsString = jsString.replace("\f", "\\f");
	    jsString = jsString.replace("\n", "\\n");
	    jsString = jsString.replace("\r", "\\r");
	    jsString = jsString.replace("\t", "\\t");
	    jsString = jsString.replace("/", "\\/");
	    return jsString;
	}

	@org.teavm.jso.JSBody(params = { "element" }, script = "window.shadowRoot.appendChild(element);")
    private static native void appendChildToShadowRoot(org.teavm.jso.dom.html.HTMLElement element);
	
	@org.teavm.jso.JSBody(params = { "element" }, script = "window.shadowRoot.removeChild(element);")
    private static native void removeChildFromShadowRoot(org.teavm.jso.dom.html.HTMLElement element);
	
	@org.teavm.jso.JSBody(params = {}, script = "return window.shadowRoot;")
    private static native HTMLElement getShadowRoot();
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
	

	private void updateSizeIfRequired(DialogFragment dialogFragment) {
		int screenWidth = com.ashera.widget.PluginInvoker.getScreenWidth();
		int screenHeight = com.ashera.widget.PluginInvoker.getScreenHeight();

		updateLeftAndTop(dialogFragment, screenWidth, screenHeight);		
	}
}