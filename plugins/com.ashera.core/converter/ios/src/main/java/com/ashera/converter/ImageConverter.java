package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

public class ImageConverter extends ColorImageConverter {
    @Override
    public Object convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
       if (value == null || value.equals("@null") || value.startsWith("@drawable")) {
			Object image = super.convertFrom(value, dependentAttributesMap, fragment);
			if (isImage(image)) {
				return image;
			}
       }

        throw new RuntimeException("Unable to convert path to image : " + value);
    }
       
   	private native boolean isImage(Object objImage) /*-[
		return [objImage isKindOfClass:[UIImage class]];
	]-*/;


    @Override
    public String convertTo(Object value, IFragment fragment) {
    	return super.convertTo(value, fragment);
    }
    
    @Override
    public java.util.List<String> getDependentAttributes() {
        return super.getDependentAttributes();
    }
}
