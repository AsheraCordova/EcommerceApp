package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.utils.ColorUtil;
import com.ashera.utils.ResourceBundleUtils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;

public class ColorStateConverter implements IConverter<ColorStateList, String>{
	java.util.ResourceBundle resourceBundle;

	@Override
	public ColorStateList convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		String color = ResourceBundleUtils.getString("color/color", "color", value, fragment);
		if (color.startsWith("{")) {
			Context context = (Context) fragment.getRootActivity();
			return androidx.core.content.ContextCompat.getColorStateList(context, context.getResources().getIdentifier(value, "color", context.getPackageName()));
		}
		return ColorStateList.valueOf(Color.parseColor(ColorUtil.colorToHex(color)));		
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