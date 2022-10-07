package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

public class ImageConverter extends ColorImageConverter {
    @Override
    public Object convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
       if (value == null || value.equals("@null") || value.startsWith("@drawable")) {
    	   return super.convertFrom(value, dependentAttributesMap, fragment);
       }

        throw new RuntimeException("Unable to convert path to image : " + value);
    }


    @Override
    public String convertTo(Object value, IFragment fragment) {
        return super.convertTo(value, fragment);
    }

    @Override
    public java.util.List<String> getDependentAttributes() {
        return super.getDependentAttributes();
    }
}
