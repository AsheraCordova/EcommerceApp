package com.ashera.cssborder;

import com.ashera.layout.decorator.BorderDecorator;
import com.ashera.widget.WidgetFactory;

public class BorderPlugin  {
    public static void initPlugin() {
        WidgetFactory.registerLifeCycleDecorator("border", new BorderDecorator());
        WidgetFactory.registerAttributableFor("View", new BorderViewImpl());
    }
}
