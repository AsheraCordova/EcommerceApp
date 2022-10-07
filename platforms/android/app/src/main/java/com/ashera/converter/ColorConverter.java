package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.utils.ColorUtil;
import com.ashera.utils.ResourceBundleUtils;

import android.graphics.Color;

public class ColorConverter implements IConverter<Integer, String>{
	java.util.ResourceBundle resourceBundle;
	@Override
	public Integer convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		String color = ResourceBundleUtils.getString("color/color", "color", value, fragment);
		return Color.parseColor(ColorUtil.colorToHex(color));
	}
	@Override
	public String convertTo(Integer value, IFragment fragment) {
		return ColorUtil.getColorString(value);
	}


	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
