package com.ashera.converter;

import com.ashera.plugin.PluginManager;
import com.ashera.utils.ColorUtil;
import com.ashera.utils.StringUtils;

/*-[
#include <UIKit/UIKit.h>
]-*/
public class ConverterPlugin extends BaseConverterPlugin  {
	private static final String CONVERTER_PLUGIN_NAME = "converter";

	@Override
	public Object getColor(String color) {
		int[] colorInt = ColorUtil.hexStr2Int(color);
		return getColor(colorInt[0], colorInt[1]);
	}
	
	public static native Object getColor(int hexint, int alpha) /*-[	    
		  // Create color object, specifying alpha as well
		  UIColor *color =
		    [UIColor colorWithRed:((CGFloat) ((hexint & 0xFF0000) >> 16))/255
		    green:((CGFloat) ((hexint & 0xFF00) >> 8))/255
		    blue:((CGFloat) (hexint & 0xFF))/255
		    alpha:alpha/255.0];
		
		  return color;
	]-*/;

	@Override
	public float convertDpToPixel(String dimen) {
		if (dimen.endsWith("dp")) {
			return Float.parseFloat(dimen.replace("dp", "")) * com.ashera.widget.PluginInvoker.getDisplayMetricDensity();
		}
		throw new RuntimeException("unsupported dimesion type " + dimen);
	}
	

	private native int getScaleFactor()/*-[
		return [UIScreen mainScreen].scale;
	]-*/;
	
	@Override
	public float convertSpToPixel(String dimen) {
		if (dimen.endsWith("sp")) {
			return Float.parseFloat(dimen.replace("sp", "")) * com.ashera.widget.PluginInvoker.getDisplayMetricDensity();/*getScaleFactor() **/
		}
		throw new RuntimeException("unsupported dimesion type " + dimen);
	}

	@Override
	public String getName() {
		return CONVERTER_PLUGIN_NAME;
	}

	@Override
	public String convertPixelToDp(Object px, boolean isInt) {
	    float f = ((Number) px).floatValue() / com.ashera.widget.PluginInvoker.getDisplayMetricDensity();
	    if (isInt) {
	    	return StringUtils.floatToString((int) f) + "dp";
	    }
		return StringUtils.floatToString(f) + "dp";
	}

	@Override
	public String convertPixelToSp(Object px, boolean isInt) {
		float scalingFactor = 1;
	    float f = ((Number) px).floatValue() / com.ashera.widget.PluginInvoker.getDisplayMetricDensity() / scalingFactor;
	    if (isInt) {
	    	return StringUtils.floatToString((int) f) + "sp";
	    }
	    return StringUtils.floatToString(f) + "sp";
	}
	

	public static void initPlugin() {
		PluginManager.register(new ConverterPlugin());
		
		// register converters
		CommonConverters.init();
		ConverterFactory.register("color", new ColorConverter());
		ConverterFactory.register("colorimage", new ColorImageConverter());
		ConverterFactory.register("image", new ImageConverter());
		ConverterFactory.register("drawable", new DrawableConverter());
		ConverterFactory.register("font", new FontConverter());
		ConverterFactory.register("colorstate", new ColorStateConverter());
		ConverterFactory.registerCommandConverter(new ImageRepeatCommandConverter("imageRepeat"));
		ConverterFactory.registerCommandConverter(new TintColorCommandConverter("tintColor"));
		ConverterFactory.registerCommandConverter(new CGTintColorCommandConverter("cgTintColor"));
		ConverterFactory.registerCommandConverter(new DrawImageCommandConverter("drawImage"));
		ConverterFactory.registerCommandConverter(new DrawImageOrColorCommandConverter("drawImageOrColor"));
		ConverterFactory.registerCommandConverter(new DrawForegroundCommandConverter("drawForeground"));
		ConverterFactory.registerCommandConverter(new DrawDrawableCommandConverter("drawDrawableIcon"));
		ConverterFactory.registerCommandConverter(new TransformCommandConverter("transform"));
	}
}
