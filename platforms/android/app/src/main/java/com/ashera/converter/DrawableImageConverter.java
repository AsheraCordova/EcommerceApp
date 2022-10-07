package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import androidx.core.content.ContextCompat;

public class DrawableImageConverter extends ColorImageConverter{
	@Override
	public java.lang.Object convertFrom(java.lang.String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		Context context = (Context) fragment.getRootActivity();
		Object objValue = super.convertFrom(value, dependentAttributesMap, fragment);
		android.graphics.drawable.Drawable drawable = null;
		if (objValue instanceof  String && objValue.equals("@null")) {
			drawable = new ColorDrawable(android.graphics.Color.TRANSPARENT);
		} else if (objValue instanceof  String) {
			drawable = new ColorDrawable(android.graphics.Color.parseColor((String) objValue));
		} else if (objValue instanceof  Integer) {
			drawable = ContextCompat.getDrawable(context, (Integer)objValue);
		}
		else if (objValue instanceof android.graphics.Bitmap) {
			drawable = new android.graphics.drawable.BitmapDrawable(context.getResources(), (android.graphics.Bitmap) objValue);		
		}
		return drawable;
	}

}
