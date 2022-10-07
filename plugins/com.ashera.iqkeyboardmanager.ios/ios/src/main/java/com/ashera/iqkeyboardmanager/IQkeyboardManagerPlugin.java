package com.ashera.iqkeyboardmanager;

import com.ashera.widget.WidgetFactory;

/*-[
#import "IQKeyboardManager.h"
]-*/
public class IQkeyboardManagerPlugin  {
    public static void initPlugin() {
    	//start - widgets
        com.ashera.widget.WidgetFactory.registerAttributableFor("View", new com.ashera.iqkeyboardmanager.IQkeyboardManagerImpl());
        WidgetFactory.register(new com.ashera.iqkeyboardmanager.IQPreviousNextViewImpl());
        //end - widgets
    	initIQManager();
    }
    
	private native static void initIQManager() /*-[
		[IQKeyboardManager sharedManager].enable = true;
	]-*/;
}
