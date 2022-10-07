package com.ashera.converter;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ashera.core.IFragment;
import com.ashera.utils.ColorUtil;
import com.ashera.utils.ResourceBundleUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

public class ColorImageConverter implements IConverter<Object, String> {
    private static final java.util.List<String> dependentAttributes = java.util.Arrays.asList(new String[]{"capInsetsTop",
            "capInsetsBottom", "capInsetsLeft", "capInsetsRight"} );

    @Override
    public Object convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
    	if (value == null || value.equals("@null")) {
    		return "@null";
    	}
    	
        if (value.startsWith("#") || value.startsWith("@color/")) {
            String color = ResourceBundleUtils.getString("color/color", "color", value, fragment);
            return ColorUtil.colorToHex(color);
        } else if (value.startsWith("@drawable/")) {
        	Pattern pattern = Pattern.compile("@([a-z0-9_\\-]+)\\/([a-z0-9_\\-]+)");  
            Matcher matcher = pattern.matcher(value);  
            boolean matches = matcher.matches();   

            if (matches) {
	            String fileName = matcher.group(2);
	            String directoryName = matcher.group(1);
	            Context context = (Context) fragment.getRootActivity();
	            int id = context.getResources().getIdentifier(fileName, directoryName, context.getPackageName());
	            return id;
            }
        } else if (value.startsWith("data:image/png;base64,")) {
        	final String pureBase64Encoded = value.substring(value.indexOf(",")  + 1);
        	final byte[] decodedBytes = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
        	Bitmap bitmap = android.graphics.BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        	return bitmap;

        }

		throw new RuntimeException("Unable to convert path to image : " + value);

    }

    @Override
    public String convertTo(Object value, IFragment fragment) {
        if (value instanceof String) {
            return (String) value;
        }
        
        if (value instanceof android.graphics.drawable.Drawable) {
        	if (value instanceof android.graphics.drawable.StateListDrawable) {
        		value = ((android.graphics.drawable.StateListDrawable) value).getCurrent();
        	}
        	if (value instanceof android.graphics.drawable.ColorDrawable) {
        		return ColorUtil.getColorString(((android.graphics.drawable.ColorDrawable) value).getColor());
        	}
        	return drawableToBitmap((android.graphics.drawable.Drawable) value);
        }
        return null;
    }
    
    public String drawableToBitmap (Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return convertToBase64(bitmapDrawable.getBitmap());
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return convertToBase64(bitmap);
    }
    
    public String convertToBase64(Bitmap bitmap) {
        	String base64;
        	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			try {
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
				base64 = "data:image/png;base64,%@" + Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
			} finally {
				try {
					outputStream.close();
				} catch (Exception e) {
				}
			}
			return base64;        	
    }

    @Override
    public java.util.List<String> getDependentAttributes() {
        return dependentAttributes;
    }
}
