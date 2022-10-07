package com.ashera.converter;

import java.util.Map;

import org.eclipse.swt.graphics.Color;

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
            return com.ashera.widget.PluginInvoker.getColor(ColorUtil.colorToHex(color));
        }        
        return null;
    }

    @Override
    public String convertTo(Object value, IFragment fragment) {
        if (value instanceof String) {
            return (String) value;
        }
        if (value instanceof Color) {
            Color color = ((Color)value);
            return ColorUtil.getColorString(color.getRed(), color.getBlue(), color.getGreen());
        }
        return null;
    }

    @Override
    public java.util.List<String> getDependentAttributes() {
        return null;
    }
}
