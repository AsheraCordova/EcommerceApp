package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

import r.android.graphics.drawable.Drawable;

public class DrawableConverter extends ColorImageConverter {
    @Override
	public Object convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
    	if (value == null) {
			return null;
		}
		if (value.equals("@null") || value.startsWith("@drawable")
				|| value.startsWith("#") || value.startsWith("@color/") || value.startsWith("data:image/png;base64,")) {
			Object objValue = super.convertFrom(value, dependentAttributesMap, fragment);
			if (value.equals("@null")) {
				Drawable drawable = new Drawable();
				objValue = drawable;
			} else if (isColor(objValue)) {
				Drawable drawable = new r.android.graphics.drawable.ColorDrawable();
				drawable.setDrawable(objValue);
				objValue = drawable;
			} else if (isImage(objValue)) {
				Drawable drawable = new Drawable();
				updateWidthAndHeight(drawable, objValue);
				drawable.setDrawable(objValue);
				objValue = drawable;
			} else if (objValue instanceof Drawable) {
				Drawable drawable = (Drawable) objValue;
				Object image = drawable.getDrawable();
				if (image != null && isImage(image)) {
					updateWidthAndHeight(drawable, image);
					drawable.setDrawable(image);
				}
			}
			return objValue;
		}

		throw new RuntimeException("Unable to convert path to image : " + value);
	}
    
	private void updateWidthAndHeight(Drawable drawable, Object value) {
		drawable.setMinimumWidth(getImageWidth(value));
		drawable.setMinimumHeight(getImageHeight(value));
	}
	
	public static native boolean isImage(Object value) /*-[
		return[value isKindOfClass:[UIImage class]];
	]-*/;
	
	
	public static native boolean isColor(Object value) /*-[
		return[value isKindOfClass:[UIColor class]];
	]-*/;
	
	public static native int getImageWidth(Object value)/*-[
		UIImage* image = ((UIImage*) value);
		return image.size.width;
	]-*/;
	
	public static native int getImageHeight(Object value)/*-[
		UIImage* image = ((UIImage*) value);
		return image.size.height;
	]-*/;


    @Override
    public String convertTo(Object value, IFragment fragment) {    	
    	if (value instanceof Drawable) {
    		return super.convertTo(((Drawable) value).getDrawable(), fragment);
    	}
    	return super.convertTo(value, fragment);
    }
    
    @Override
    public java.util.List<String> getDependentAttributes() {
        return super.getDependentAttributes();
    }
}
