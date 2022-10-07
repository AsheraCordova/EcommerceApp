package com.ashera.core;

import java.util.List;
import java.util.Map;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ashera.parser.html.HtmlParserPlugin;
import com.ashera.plugin.PluginManager;
import com.ashera.widget.PluginInvoker;

public class CoreCordovaPlugin extends CordovaPlugin {
	private UINavigatorImpl navigator;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		PluginManager.register(new HtmlParserPlugin());
		PluginManager.register(new CorePlugin());
		navigator = new UINavigatorImpl(); 
	}

	@Override
    public boolean execute(String action, final JSONArray data,
                           final CallbackContext callbackContext) throws JSONException {
		 if (action.equals("executeCommand")) {
            final String strpayLoad = data.getString(0);
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                	final com.ashera.utils.CommandHelper.SucessCallBack successCallBack = new com.ashera.utils.CommandHelper.SucessCallBack( ) {
            			@Override
            			public void success(Object comamnd, String payLoad) {
            				callbackContext.success(payLoad);
            			}
                	};

                	IActivity activity = (IActivity) cordova.getActivity();
					com.ashera.utils.CommandHelper.executeCommand(activity, callbackContext, strpayLoad, successCallBack);
                }
            });
            return true;

        } else if (action.equals("onDeviceReady")) {
            IActivity activity = ((IActivity) cordova.getActivity());
            activity.onDeviceReady();
            return true;
		} else if (action.equals("executeSimpleCommand")) {
        	IActivity activity = ((IActivity) cordova.getActivity());
        	
        	for (int i = 0; i < data.length(); i++) {
        		JSONArray command = data.getJSONArray(i);
        		final String commandName = command.getString(0);
        		
        		switch (commandName) {
					case "loadLocale": {
						Map<String, Object> resultMap = PluginInvoker.getJSONCompatMap();
						
						final JSONArray keys = command.getJSONArray(1);
						// load all locale keys for javascript
			            if (keys.length() > 0) {
							Map<String, Object> localeMap = PluginInvoker.getJSONCompatMap();
							for (int j = 0; j < keys.length(); j++) {
								String key = keys.getString(j);
								String value = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", key,
										activity.getActiveRootFragment());
								localeMap.put(key, value);
							}		
							resultMap.put(commandName, localeMap);
			            }
			            
			            callbackContext.success(PluginInvoker.marshal(resultMap));
						break;
					}
        		}
        	}
			return true;
		} else if (action.equals("navigateCommand")) {
			cordova.getActivity().runOnUiThread(() -> handleNavigateCommand(data, callbackContext)); 
        	return true;
		} else {
            return false;
        }
    }

	public void navigate(final String actionId, String destinationId, boolean inclusive, boolean finish,  final JSONArray scopedObjectsArr, final CallbackContext callbackContext)
			throws JSONException {
		List<Map<String, Object>> scopedObjects = new java.util.ArrayList<>();
		
		for (int j = 0; j < scopedObjectsArr.length(); j++) {
			org.json.JSONObject scopedObject = scopedObjectsArr.getJSONObject(j);
			Map<String, Object> map = new java.util.HashMap<>();
			Object payload = scopedObject.get("payload");
			final String strpayLoad = payload.toString();
			if (payload instanceof JSONArray) {
				payload = PluginInvoker.unmarshal(strpayLoad, List.class);
			} else if (payload instanceof JSONObject) {
				payload = PluginInvoker.unmarshal(strpayLoad, Map.class);
			} else {
				// nothing to do
			}
			map.put("payload", payload);
			map.put("expression", scopedObject.getString("expression"));
			scopedObjects.add(map);
		}
		
		
        IActivity activity = ((IActivity) cordova.getActivity());
        navigator.navigate(actionId, destinationId, inclusive, finish, scopedObjects, activity.getActiveRootFragment());
	}
	
	private void handleNavigateCommand(final JSONArray data, final CallbackContext callbackContext) {
		try {
			JSONArray commands = data.getJSONArray(0);
			IActivity activity = ((IActivity) cordova.getActivity());
			IAsyncCallBack callBack = new IAsyncCallBack() {
				int i = 0;
				public void done() {
					try {
						i++;
						if (i < commands.length()) {
							executeCommand(commands.getJSONArray(i), callbackContext, activity, this);
						} else {
							callbackContext.success("{}");
						}
					} catch (Exception e) {
						callbackContext.error(e.getMessage());
					}
				
				}
			};
			
			if (commands.length() > 0) {
				executeCommand(commands.getJSONArray(0), callbackContext, activity, callBack);
			}
			
			
		} catch (Exception e) {
			callbackContext.error(e.getMessage());
		}
	}
	private void executeCommand(JSONArray command, final CallbackContext callbackContext,
			IActivity activity, IAsyncCallBack callBack) throws Exception {
		final String commandName = command.getString(0);
		boolean asyncCallBackUsed = false;
		switch (commandName) {
		case "navigate": {
			final String actionId = command.getString(1);
			final JSONArray scopedObjectsArr = command.getJSONArray(2);
			navigate(actionId, null, false, false, scopedObjectsArr, callbackContext);
			break;
		}
		case "navigateWithPopBackStack": {
			final String actionId = command.getString(1);
			final JSONArray scopedObjectsArr = command.getJSONArray(2);
			navigate(actionId, null, true, false, scopedObjectsArr, callbackContext);
			break;
		}
		case "navigateAsTop": {
			final String actionId = command.getString(1);
			final JSONArray scopedObjectsArr = command.getJSONArray(2);
			navigate(actionId, null, false, true, scopedObjectsArr, callbackContext);
			break;
		}
		case "navigateWithPopBackStackTo": {
			final String actionId = command.getString(1);
			final String destinationId = command.getString(2);
			final boolean inclusive = command.getBoolean(3);
			final JSONArray scopedObjectsArr = command.getJSONArray(4);
			navigate(actionId, destinationId, inclusive, false, scopedObjectsArr, callbackContext);
			break;
		}
		case "closeDialog":
			navigator.closeDialog(activity.getActiveRootFragment());
			break;
		case "popBackStack":
			asyncCallBackUsed = true;
			navigator.popBackStack(activity.getActiveRootFragment(), callBack);
			break;
		case "popBackStackTo":
			asyncCallBackUsed = true;
			final String destinationId = command.getString(1);
			final boolean inclusive = command.getBoolean(2);
			navigator.popBackStack(activity.getActiveRootFragment(), destinationId, inclusive, callBack);
			break;
		default:
			break;
		}
		if (!asyncCallBackUsed) {
			callBack.done();
		}
	}
}
