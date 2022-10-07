package com.ashera.jsonadapter;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import com.ashera.plugin.PluginManager;

public class JSONAdapterCordovaPlugin extends CordovaPlugin {
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		PluginManager.register(new JSONAdapterImpl());
	}

}
