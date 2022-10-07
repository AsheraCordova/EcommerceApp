package com.ashera.capinsets;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

import freeseawind.ninepatch.common.CapInsets;

public class CapInsetsCommandConverter extends BaseAttributeCommand{
	private CapInsets capInsets = new CapInsets();
	
	public CapInsetsCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		Control control = (Control) widget.asNativeWidget();
		
		Rectangle rect = control.getBounds();
		if (rect.height == 0 || rect.width == 0) {
			return value;
		}
        final org.eclipse.swt.graphics.Image ninePatchImg = new org.eclipse.swt.graphics.Image(Display.getDefault(), rect.width, rect.height);
        widget.getFragment().addDisposable(ninePatchImg);
        
        org.eclipse.swt.graphics.GC gc = new org.eclipse.swt.graphics.GC(ninePatchImg, org.eclipse.swt.SWT.LEFT_TO_RIGHT);
        gc.setBackground(control.getParent().getBackground());
        gc.fillRectangle(0, 0, control.getBounds().width, control.getBounds().height);
        
        if (value instanceof r.android.graphics.drawable.Drawable) {
        	value = ((r.android.graphics.drawable.Drawable) value).getDrawable();	
        }
        
        freeseawind.ninepatch.javafx.SWTNinePatch ninePatch = new freeseawind.ninepatch.javafx.SWTNinePatch(new freeseawind.ninepatch.javafx.ImageHolder(control, (Image) value), capInsets);
        ninePatch.drawNinePatch(gc, 0, 0, rect.width, rect.height);
        
        ninePatch.dispose();
        gc.dispose();
		return ninePatchImg;
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
				capInsets.setStretchTop((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsBottom")) {
				capInsets.setStretchBottom((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsLeft")) {
				capInsets.setStretchLeft((int) args[i + 1]);	
			}
			
			if (attributeName.equals("capInsetsRight")) {
				capInsets.setStretchRight((int) args[i + 1]);	
			}
			
		}
	}

	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}
}
