package com.ashera.converter;


import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import com.ashera.plugin.PluginManager;

public class ConverterCordovaPlugin extends CordovaPlugin {

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		PluginManager.register(new ConverterPlugin());
		
		// register converters
		CommonConverters.init();
		ConverterFactory.register("drawable", new DrawableConverter());
		ConverterFactory.register("colorimage", new ColorImageConverter());
		ConverterFactory.register("color", new ColorConverter());
		ConverterFactory.register(CommonConverters.font, new FontConverter());
		ConverterFactory.register("colorstate", new ColorStateConverter());
		ConverterFactory.registerCommandConverter(new ImageRepeatCommandConverter("imageRepeat"));
		ConverterFactory.registerCommandConverter(new AutoLinkifyCommandConverter("autoLink"));
	}

}
