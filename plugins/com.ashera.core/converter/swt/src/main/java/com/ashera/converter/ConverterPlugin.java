package com.ashera.converter;

import org.eclipse.swt.widgets.Display;

import com.ashera.common.ColorManager;
import com.ashera.utils.StringUtils;

public class ConverterPlugin extends BaseConverterPlugin  {
	private static final String CONVERTER_PLUGIN_NAME = "converter";
	

	@Override
	public String getName() {
		return CONVERTER_PLUGIN_NAME;
	}



	public Object getColor(String color) {
		return ColorManager.getColor(color);
	}


	@Override
	public float convertDpToPixel(String dimen) {
		int dp = Integer.parseInt(dimen.replace("dp", ""));
        int dpi = Display.getDefault().getDPI().x;
        float px = (dp * dpi) / 160f;

        return px;
		
	}


	@Override
	public float convertSpToPixel(String dimen) {
		int sp = Integer.parseInt(dimen.replace("sp", ""));
        int dpi = Display.getDefault().getDPI().x;
        float px = (sp * dpi) / 160f;
        return px;
		
	}


	@Override
	public String convertPixelToDp(Object objpx, boolean isInt) {
		Number px = (Number) objpx;
		int dpi = Display.getDefault().getDPI().x;
		float dp = (px.floatValue() * 160f) / (dpi);
		if (isInt) {
	    	return StringUtils.floatToString((int) dp) + "dp";
	    }
        return StringUtils.floatToString(dp) + "dp";
	}


	@Override
	public String convertPixelToSp(Object objpx, boolean isInt) {
        Number px = (Number) objpx;
        int dpi = Display.getDefault().getDPI().x;
        float sp = (px.floatValue() * 160f) / (dpi);
        if (isInt) {
	    	return StringUtils.floatToString((int) sp) + "sp";
	    }
        return StringUtils.floatToString(sp) + "sp";
	}


}
