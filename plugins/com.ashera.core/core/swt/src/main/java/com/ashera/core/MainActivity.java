package com.ashera.core;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;

import r.android.os.Bundle;

public class MainActivity extends BaseCordovaActivity{
    
    public MainActivity(Browser webView, StackLayout stackLayout, Composite rootComposite) {
        super(webView, stackLayout, rootComposite);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
