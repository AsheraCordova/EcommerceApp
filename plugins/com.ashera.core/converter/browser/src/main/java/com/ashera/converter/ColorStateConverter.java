package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.utils.ColorUtil;
import com.ashera.utils.ResourceBundleUtils;

import r.android.content.res.ColorStateList;
import r.android.graphics.Color;

public class ColorStateConverter implements IConverter<ColorStateList, String>{
	java.util.ResourceBundle resourceBundle;

	@Override
	public ColorStateList convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
		try {
			if (value == null) {
				return null;
			}
			
			String color = ResourceBundleUtils.getString("color/color", "color", value, fragment);
			if (color.startsWith("{")) {
				Map<String, Object> colorMap = com.ashera.widget.PluginInvoker.unmarshal(color, Map.class);
				return com.ashera.drawable.ColorStateListFactory.getColor(colorMap, fragment);
			}
			
			return ColorStateList.valueOf(Color.parseColor(ColorUtil.colorToHex(color)));
		} catch (Exception e) {
			return ColorStateList.valueOf(Color.RED);
		}
	}

	@Override
	public String convertTo(ColorStateList value, IFragment fragment) {
		return ColorUtil.getColorString(value.getColorForState(new int[]{}, value.getDefaultColor()));
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}