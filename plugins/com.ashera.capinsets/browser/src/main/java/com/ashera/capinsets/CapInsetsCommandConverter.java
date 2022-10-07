package com.ashera.capinsets;

import java.util.Map;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

import freeseawind.ninepatch.common.CapInsets;
import r.android.graphics.drawable.Drawable;

public class CapInsetsCommandConverter extends BaseAttributeCommand{
	private CapInsets capInsets = new CapInsets();
	private static Map<String, String> cache = new java.util.HashMap<>();
	public CapInsetsCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		org.teavm.jso.dom.html.HTMLElement htmlElement = (org.teavm.jso.dom.html.HTMLElement) widget.asNativeWidget();
		
		if (htmlElement.getClientWidth() == 0 || htmlElement.getClientHeight() == 0) {
			return value;
		}
		
	   	Drawable drawable = (r.android.graphics.drawable.Drawable) value;

        if (value instanceof r.android.graphics.drawable.Drawable) {
			value = drawable.getDrawable();	
        }

		String path = (String) value;
		String cachekey = path + "_" + htmlElement.getClientWidth() + "_" + htmlElement.getClientHeight();
		if (cache.containsKey(cachekey)) {
			return cache.get(cachekey);
		}

		org.teavm.jso.dom.html.HTMLCanvasElement canvas = (org.teavm.jso.dom.html.HTMLCanvasElement) org.teavm.jso.dom.html.HTMLDocument.current().createElement("canvas");
		org.teavm.jso.dom.html.HTMLImageElement image = (org.teavm.jso.dom.html.HTMLImageElement) org.teavm.jso.dom.html.HTMLDocument.current().getElementById(path);
//		image.setSrc((String) value);
		canvas.setWidth(htmlElement.getClientWidth());
		canvas.setHeight(htmlElement.getClientHeight());
		
		image.getStyle().setProperty("width", drawable.getMinimumWidth() + "px");
		image.getStyle().setProperty("height", drawable.getMinimumHeight() + "px");
 
        freeseawind.ninepatch.web.ImageHolder imageHolder = new freeseawind.ninepatch.web.ImageHolder(drawable.getMinimumWidth(), drawable.getMinimumHeight(), image);
        
		freeseawind.ninepatch.web.WebNinePatch ninePatch = new freeseawind.ninepatch.web.WebNinePatch(imageHolder, capInsets);
        ninePatch.drawNinePatch(canvas, 0, 0, htmlElement.getClientWidth(), htmlElement.getClientHeight());
        
		String dataURL = canvas.toDataURL();
		cache.put(cachekey, dataURL);
		return dataURL;
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
