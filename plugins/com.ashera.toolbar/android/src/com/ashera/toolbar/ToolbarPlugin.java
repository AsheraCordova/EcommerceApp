package com.ashera.toolbar;

import com.ashera.widget.WidgetFactory;

public class ToolbarPlugin  {
    public static void initPlugin() {
    	//start - widgets
        WidgetFactory.register(new com.ashera.toolbar.ToolbarImpl());
        //end - widgets
    }
}
