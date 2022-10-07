package com.ashera.converter;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import com.ashera.converter.CommonConverters;
import com.ashera.converter.ConverterFactory;
import com.ashera.plugin.PluginManager;

public class ConverterCordovaPlugin extends CordovaPlugin {

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		PluginManager.register(new ConverterPlugin());
		
		// register converters
		CommonConverters.init();
		ConverterFactory.register("color", new ColorConverter());
		ConverterFactory.register("colorstate", new ColorStateConverter());
		ConverterFactory.register("colorimage", new ColorImageConverter());
		ConverterFactory.register("drawable", new DrawableImageConverter());
		ConverterFactory.register("font", new FontConverter());
		ConverterFactory.register("style", new StyleConverter());
		ConverterFactory.register("xmlresource", new XmlResourceConverter());
		ConverterFactory.register("divider", new Divider());
		
		ConverterFactory.registerCommandConverter(new ImageRepeatCommandConverter("imageRepeat"));
	}

}
