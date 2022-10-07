package com.ashera.converter;


import com.ashera.utils.StringUtils;

public class ConverterPlugin extends BaseConverterPlugin  {
	private static final String CONVERTER_PLUGIN_NAME = "converter";
	

	@Override
	public String getName() {
		return CONVERTER_PLUGIN_NAME;
	}



	public Object getColor(String color) {
		return color;
	}


	@Override
	public float convertDpToPixel(String dimen) {
		float scalingFactor = 1;
		int dp = Integer.parseInt(dimen.replace("dp", ""));
        int dpi = getDPI();
        float px = (dp * dpi * scalingFactor) / 160f;

        return px;
		
	}



	private int getDPI() {
		return com.ashera.widget.PluginInvoker.getDensity();
	}


	@Override
	public float convertSpToPixel(String dimen) {
		float scalingFactor = 1;
		int sp = Integer.parseInt(dimen.replace("sp", ""));
        int dpi = getDPI();
        float px = (sp * dpi * scalingFactor) / 160f;
        return px;
		
	}


	@Override
	public String convertPixelToDp(Object objpx, boolean isInt) {
       float scalingFactor = 1;
		Number px = (Number) objpx;
		int dpi = getDPI();
		float dp = (px.floatValue() * 160f) / (dpi * scalingFactor);
		if (isInt) {
	    	return StringUtils.floatToString((int) dp) + "dp";
	    }
        return StringUtils.floatToString(dp) + "dp";
	}


	@Override
	public String convertPixelToSp(Object objpx, boolean isInt) {
       float scalingFactor = 1;
        Number px = (Number) objpx;
        int dpi = getDPI();
        float sp = (px.floatValue() * 160f) / (dpi * scalingFactor);
        if (isInt) {
	    	return StringUtils.floatToString((int) sp) + "sp";
	    }
        return StringUtils.floatToString(sp) + "sp";
	}


}
