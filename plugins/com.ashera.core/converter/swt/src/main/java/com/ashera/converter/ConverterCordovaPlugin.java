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
		ConverterFactory.register("colorimage", new ColorImageConverter());
		ConverterFactory.register("colorstate", new ColorStateConverter());
		ConverterFactory.register("image", new ImageConverter());
		ConverterFactory.register("drawable", new DrawableConverter());
		ConverterFactory.register("color", new ColorConverter());
		ConverterFactory.register("font", new FontConverter());
		ConverterFactory.register("swtbitflag", new SWTBitFlagConverter());
		ConverterFactory.registerCommandConverter(new ImageRepeatCommandConverter("imageRepeat"));
		ConverterFactory.registerCommandConverter(new AutoLinkifyCommandConverter("autoLink"));
		

	}

}
