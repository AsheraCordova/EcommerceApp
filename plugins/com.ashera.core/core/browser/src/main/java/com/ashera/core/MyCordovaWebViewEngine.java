package com.ashera.core;

import org.apache.cordova.CordovaBridge;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;
import org.apache.cordova.ICordovaCookieManager;
import org.apache.cordova.NativeToJsMessageQueue;
import org.apache.cordova.PluginManager;
import org.teavm.jso.JSProperty;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.EventListener;

import r.android.os.Build;
import r.android.view.View;
import r.android.webkit.ValueCallback;

public class MyCordovaWebViewEngine implements CordovaWebViewEngine {
    private View browserView = new View();
    private CordovaWebView parentWebView;
    private CordovaBridge bridge;
    private String id;
    interface PromptEvent extends org.teavm.jso.dom.events.Event{
        @JSProperty
        String getArg1();
        @JSProperty
        String getArg2();
    }
    
    @org.teavm.jso.JSBody(params = { "message" }, script = "window.promptResult = message;")
    public static native void setPrompResult(String message);
    public MyCordovaWebViewEngine() {
        final Window window = Window.current();
        window.addEventListener("prompt", new EventListener<PromptEvent>() {

			@Override
			public void handleEvent(PromptEvent evt) {
				String test = bridge.promptOnJsPrompt("", evt.getArg1(),  evt.getArg2());
				setPrompResult(test);
			}
        	
        });
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
//        this.webView.setUrl(url);
    }


    @Override
    public void stopLoading() {
    }


    @Override
    public String getUrl() {
        return null;
    }


    @Override
    public void clearCache() {
    }


    @Override
    public void clearHistory() {
    }


    @Override
    public boolean canGoBack() {
        return false;
    }


    @Override
    public boolean goBack() {
        return false;
    }


    @Override
    public void setPaused(boolean value) {
    }


    @Override
    public void destroy() {

    }
	@org.teavm.jso.JSBody(params = { "js" }, script = "eval(js);")
    public static native void eval(String js);

    @Override
    public void evaluateJavascript(String js, ValueCallback<String> callback) {
    	eval(js);
    }

}
