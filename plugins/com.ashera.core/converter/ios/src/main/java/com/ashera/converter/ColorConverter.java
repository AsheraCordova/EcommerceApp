package com.ashera.converter;

import java.util.Map;

import com.ashera.converter.IConverter;
import com.ashera.core.IFragment;
import com.ashera.utils.ResourceBundleUtils;

public class ColorConverter implements IConverter<Object, String>{
	java.util.ResourceBundle resourceBundle;
	@Override
	public Object convertFrom(String value,  Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		String color = ResourceBundleUtils.getString("color/color", "color", value, fragment);
		return com.ashera.widget.PluginInvoker.getColor(color);
	}
	@Override
	public String convertTo(Object value, IFragment fragment) {
		return colorToString(value);
	}

	public native String colorToString(Object color)  /*-[	    
	    CGFloat red, green, blue, alpha;
	    [((UIColor*) color) getRed:&red green:&green blue:&blue alpha:&alpha];
  		return [[NSString stringWithFormat:@"#%02x%02x%02x", (int)(red * 255), (int)(green * 255) , (int)(blue * 255)] uppercaseString];
	
	]-*/;

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
