package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

import android.content.Context;

public class StyleConverter extends ColorImageConverter{
	@Override
	public java.lang.Object convertFrom(java.lang.String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
        String key1 = value.replaceFirst("@style/", "");
        Context context = (Context) fragment.getRootActivity();
        int id = context.getResources().getIdentifier(key1, "style", context.getPackageName());
		return id;
	}

}
