package com.ashera.constraintlayout;

import com.ashera.widget.WidgetFactory;
public class AndroidXConstraintLayout extends org.apache.cordova.CordovaPlugin {
    @Override
    public void initialize(org.apache.cordova.CordovaInterface cordova, org.apache.cordova.CordovaWebView webView) {
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

