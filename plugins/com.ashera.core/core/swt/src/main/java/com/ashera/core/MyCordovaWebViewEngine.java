package com.ashera.core;

import org.apache.cordova.CordovaBridge;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;
import org.apache.cordova.ICordovaCookieManager;
import org.apache.cordova.NativeToJsMessageQueue;
import org.apache.cordova.PluginManager;
//import org.eclipse.rap.rwt.widgets.BrowserCallback;
//import org.eclipse.rap.rwt.widgets.BrowserUtil;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import r.android.os.Build;
import r.android.view.View;
import r.android.webkit.ValueCallback;

public class MyCordovaWebViewEngine implements CordovaWebViewEngine {
    private View browserView = new View();
    private CordovaWebView parentWebView;
    private CordovaBridge bridge;
    private Browser webView;
    private String id;

    public MyCordovaWebViewEngine(Browser browser) {
        this.webView = browser;
        new PromptFunction(webView, "prompt");
    }
    
    class PromptFunction extends BrowserFunction {
        PromptFunction (Browser browser, String name) {
            super (browser, name);
        }
        public Object function (Object[] arguments) {
            try {
            	System.out.println(arguments[0] + " " + arguments[1]);
                String test = bridge.promptOnJsPrompt("", arguments[0] + "", (String)arguments[1]);
                return test;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
     }

    @Override
    public void init(CordovaWebView parentWebView, CordovaInterface cordova, Client client,
            CordovaResourceApi resourceApi, PluginManager pluginManager,
            NativeToJsMessageQueue nativeToJsMessageQueue) {
        this.parentWebView = parentWebView;
		nativeToJsMessageQueue.addBridgeMode(new NativeToJsMessageQueue.OnlineEventsBridgeMode(
				new NativeToJsMessageQueue.OnlineEventsBridgeMode.OnlineEventsBridgeModeDelegate() {
					@Override
					public void setNetworkAvailable(boolean value) {

					}

					@Override
					public void runOnUiThread(Runnable r) {
						r.run();
					}
				}));
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2)
            nativeToJsMessageQueue.addBridgeMode(new NativeToJsMessageQueue.EvalBridgeMode(this, cordova));
        
        nativeToJsMessageQueue.setBridgeMode(3);
        bridge = new CordovaBridge(pluginManager, nativeToJsMessageQueue);
    }


    @Override
    public CordovaWebView getCordovaWebView() {
        return parentWebView;
    }


    @Override
    public ICordovaCookieManager getCookieManager() {
        return null;
    }


    @Override
    public View getView() {
        return browserView;
    }


    @Override
    public void loadUrl(String url, boolean clearNavigationStack) {
//        TitleListener tocTitleListener = new TitleListener() {
//            public void changed(TitleEvent event) {
//
//            }
//        };
//        this.webView.addTitleListener(tocTitleListener);
        this.webView.setUrl(url);
    }


    @Override
    public void stopLoading() {
    }


    @Override
    public String getUrl() {
        return webView.getUrl();
    }


    @Override
    public void clearCache() {
    }


    @Override
    public void clearHistory() {
    	Browser.clearSessions();
    }


    @Override
    public boolean canGoBack() {
        return false;
    }


    @Override
    public boolean goBack() {
    	if (webView.isBackEnabled()) {
            return webView.back();
        }
        return false;
    }


    @Override
    public void setPaused(boolean value) {
    }


    @Override
    public void destroy() {

    }


    @Override
    public void evaluateJavascript(String js, ValueCallback<String> callback) {

    	try {
    		webView.evaluate(js);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    
    }

}
