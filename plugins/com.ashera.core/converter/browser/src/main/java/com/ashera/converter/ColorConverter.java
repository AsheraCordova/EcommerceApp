package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.utils.ColorUtil;
import com.ashera.utils.ResourceBundleUtils;

public class ColorConverter implements IConverter<Object, String> {
    java.util.ResourceBundle resourceBundle;


    @Override
    public Object convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
    	if (value == null) {
			return null;
		}
        if (value.startsWith("#") || value.startsWith("@color/") || !value.startsWith("@")) {
            String color = ResourceBundleUtils.getString("color/color", "color", value, fragment);
            color = ColorUtil.colorToHex(color);
            if (color.length() == 9) {
            	color = "#" + color.substring(3) + color.substring(1, 3); 
            }
            return com.ashera.widget.PluginInvoker.getColor(color);
        }        
        return null;
    }

    @Override
    public String convertTo(Object value, IFragment fragment) {

        if (value instanceof String) {
        	String strVal = (String) value;
			if (strVal.startsWith("rgb(")) {
				String[] vals = strVal.split("\\(|,|\\)");
				value = ColorUtil.getColorString(Integer.parseInt(vals[1]), Integer.parseInt(vals[3]), Integer.parseInt(vals[3]));
			}
            return (String) value;
        }

        return null;
    }

    @Override
    public java.util.List<String> getDependentAttributes() {
        return null;
    }
}
