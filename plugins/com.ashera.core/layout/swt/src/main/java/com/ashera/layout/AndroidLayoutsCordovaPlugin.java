package com.ashera.layout;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import com.ashera.widget.WidgetFactory;

public class AndroidLayoutsCordovaPlugin extends CordovaPlugin {
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        //start - widgets
        WidgetFactory.register(new com.ashera.layout.ViewOnlyImpl());
        WidgetFactory.register(new com.ashera.layout.FrameLayoutImpl());
        WidgetFactory.register(new com.ashera.layout.LinearLayoutImpl());
        WidgetFactory.register(new com.ashera.layout.TextViewImpl());
        WidgetFactory.register(new com.ashera.layout.CLabelImpl());
        WidgetFactory.register(new com.ashera.layout.LinkImpl());
        WidgetFactory.register(new com.ashera.layout.ModelImpl());
        WidgetFactory.register(new com.ashera.layout.ScrollViewImpl());
        WidgetFactory.register(new com.ashera.layout.RelativeLayoutImpl());
        WidgetFactory.register(new com.ashera.layout.RootImpl());
        WidgetFactory.register(new com.ashera.layout.TableLayoutImpl());
        WidgetFactory.register(new com.ashera.layout.TableRowImpl());
        WidgetFactory.register(new com.ashera.layout.HorizontalScrollViewImpl());
        WidgetFactory.register(new com.ashera.layout.RadioGroupImpl());
        WidgetFactory.register(new com.ashera.layout.ChronometerImpl());
        WidgetFactory.register(new com.ashera.layout.ListViewImpl());
        WidgetFactory.register(new com.ashera.layout.ImageViewImpl());
        WidgetFactory.register(new com.ashera.layout.ImageButtonImpl());
        WidgetFactory.register(new com.ashera.layout.EditTextImpl());
        WidgetFactory.register(new com.ashera.layout.ButtonImpl());
        WidgetFactory.register(new com.ashera.layout.TextViewButtonImpl());
        WidgetFactory.register(new com.ashera.layout.CheckBoxImpl());
        WidgetFactory.register(new com.ashera.layout.ImageCheckBoxImpl());
        WidgetFactory.register(new com.ashera.layout.RadioButtonImpl());
        WidgetFactory.register(new com.ashera.layout.ImageRadioButtonImpl());
        WidgetFactory.register(new com.ashera.layout.ToggleButtonImpl());
        WidgetFactory.register(new com.ashera.layout.SpinnerImpl());
        WidgetFactory.register(new com.ashera.layout.CComboImpl());
        WidgetFactory.register(new com.ashera.layout.MultiSelectionSpinnerImpl());
        WidgetFactory.register(new com.ashera.layout.WebViewImpl());
        WidgetFactory.register(new com.ashera.layout.StyledLabelImpl());
        WidgetFactory.register(new com.ashera.layout.StyledTextImpl());
        WidgetFactory.register(new com.ashera.layout.RadioButtonStyledLabelImpl());
        WidgetFactory.register(new com.ashera.layout.CheckBoxStyledLabelImpl());
        WidgetFactory.register(new com.ashera.layout.SwitchImpl());
        WidgetFactory.register(new com.ashera.layout.SwitchStyledLabelImpl());
        WidgetFactory.register(new com.ashera.layout.ProgressBarImpl());
        //end - widgets
    }
}
