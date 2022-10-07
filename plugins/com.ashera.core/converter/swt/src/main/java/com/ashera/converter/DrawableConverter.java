package com.ashera.converter;

import java.util.Map;

import org.eclipse.swt.graphics.Image;

import com.ashera.core.IFragment;

import r.android.graphics.drawable.Drawable;
import r.android.graphics.drawable.StateListDrawable;

public class DrawableConverter extends ColorImageConverter {
    @Override
    public Object convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
       if (value == null || value.equals("@null") || value.startsWith("@drawable") || value.startsWith("#") || value.startsWith("@color/") || value.startsWith("data:image/png;base64,")) {
    	   Object objValue = super.convertFrom(value, dependentAttributesMap, fragment);
    	   
    	   if ("@null".equals(value)) {
    		   Drawable drawable = new Drawable();
    		   objValue = drawable;
    	   } else if (objValue instanceof org.eclipse.swt.graphics.Color) {
    		   Drawable drawable = new r.android.graphics.drawable.ColorDrawable();
    		   drawable.setDrawable(objValue);
    		   objValue = drawable;
    	   } else if (objValue instanceof Image) {
    		   Drawable drawable = new Drawable();
    		   updateWidthAndHeight(drawable, objValue);
    		   drawable.setDrawable(objValue);
    		   objValue = drawable;
    	   } else if (objValue instanceof StateListDrawable) {
       			StateListDrawable stateListDrawable = (StateListDrawable)objValue;
       			Object image = stateListDrawable.getDrawable();
    			if (image != null) {
    				updateWidthAndHeight(stateListDrawable, image);
    				stateListDrawable.setDrawable(image);
    			}
    		}
    	   return objValue;
       }

        throw new RuntimeException("Unable to convert path to image : " + value);
    }

	private static void updateWidthAndHeight(Drawable drawable, Object value) {
		if (value instanceof Image) {
			drawable.setMinimumWidth(((Image) value).getImageData().width);
			drawable.setMinimumHeight(((Image) value).getImageData().height);
		}
	}

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
