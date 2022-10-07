package com.ashera.constraintlayout;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import com.ashera.widget.WidgetFactory;

public class AndroidXConstraintLayout extends CordovaPlugin {
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        //start - widgets
        WidgetFactory.register(new com.ashera.constraintlayout.ConstraintLayoutImpl());
        WidgetFactory.register(new com.ashera.constraintlayout.GuidelineImpl());
        WidgetFactory.register(new com.ashera.constraintlayout.BarrierImpl());
        WidgetFactory.register(new com.ashera.constraintlayout.GroupImpl());
        WidgetFactory.register(new com.ashera.constraintlayout.PlaceholderImpl());
        WidgetFactory.register(new com.ashera.constraintlayout.FlowImpl());
        WidgetFactory.register(new com.ashera.constraintlayout.CircularFlowImpl());
        //end - widgets

    }
}
