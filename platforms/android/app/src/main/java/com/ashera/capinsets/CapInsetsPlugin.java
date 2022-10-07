package com.ashera.capinsets;

import com.ashera.converter.ConverterFactory;

public class CapInsetsPlugin  {
    public static void initPlugin() {
		ConverterFactory.registerCommandConverter(new CapInsetsCommandConverter("capInsets"));
    	//start - widgets
        com.ashera.widget.WidgetFactory.registerAttributableFor("View", new com.ashera.capinsets.CapInsetsViewImpl());
        //end - widgets
    }
}
