package com.ashera.capinsets;

import com.ashera.capinsets.NinePatchImageUtils.CapInsets;
import com.ashera.core.IFragment;
import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

public class CapInsetsCommandConverter extends BaseAttributeCommand {
	private Integer capInsetsStretchTop;
	private Integer capInsetsStretchBottom;
	private Integer capInsetsStretchLeft;
	private Integer capInsetsStretchRight;

	public CapInsetsCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
        boolean isNinePatch = capInsetsStretchTop != null || capInsetsStretchBottom != null || capInsetsStretchLeft != null || capInsetsStretchRight != null;

        if (isNinePatch) {
        	IFragment fragment = widget.getFragment();
        	Context context = (Context) fragment.getRootActivity();
        	
        	Bitmap bitmap = null;
        	if (value instanceof Integer) {
	            int id = (int) value;
	    		bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        	} else if (value instanceof android.graphics.drawable.BitmapDrawable) {
        		bitmap = ((android.graphics.drawable.BitmapDrawable) value).getBitmap();
        	}
    		
            return getDrawable(capInsetsStretchTop, capInsetsStretchBottom, capInsetsStretchLeft, capInsetsStretchRight, bitmap, "drawable", context);
        }

		return value;
	}

	private Drawable getDrawable(Integer capInsetsStretchTop, Integer capInsetsStretchBottom,
			Integer capInsetsStretchLeft, Integer capInsetsStretchRight, Bitmap bitmap, String name, Context context) {
		CapInsets capInsets = new CapInsets();
		if (capInsetsStretchTop != null) {
			capInsets.setStretchTop(capInsetsStretchTop);
		}
		if (capInsetsStretchRight != null) {
			capInsets.setStretchRight(capInsetsStretchRight);
		}
		if (capInsetsStretchBottom != null) {
			capInsets.setStretchBottom(capInsetsStretchBottom);
		}
		if (capInsetsStretchLeft != null) {
			capInsets.setStretchLeft(capInsetsStretchLeft);
		}
		Drawable drawable = NinePatchImageUtils.createDrawable(bitmap, name, capInsets, context);
		return drawable;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		CapInsetsCommandConverter capInsetsCommandConverter = new CapInsetsCommandConverter(this.id);
		capInsetsCommandConverter.updateArgs(args);
		return capInsetsCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		for (int i = 0; i < args.length; i+=2) {
			Object attributeName = args[i];
			if (attributeName.equals("capInsetsTop")) {
				capInsetsStretchTop = ((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsBottom")) {
				capInsetsStretchBottom = ((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsLeft")) {
				capInsetsStretchLeft = ((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsRight")) {
				capInsetsStretchRight = ((int) args[i + 1]);	
			}
			
		}
	}
}
