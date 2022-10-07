package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

import android.content.Context;

public class XmlResourceConverter implements IConverter<Integer, String> {
	java.util.ResourceBundle resourceBundle;

	@Override
	public Integer convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value.startsWith("@xml/")) {
			String key1 = value.replaceFirst("@xml/", "");
			Context context = (Context) fragment.getRootActivity();
			int identifier = context.getResources().getIdentifier(key1, "xml", context.getPackageName());
			return identifier;
		}
		throw new RuntimeException("Unsupported attribute xml resource : " + value);
	}

	@Override
	public String convertTo(Integer value, IFragment fragment) {
		return null;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
