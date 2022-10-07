package org.apache.cordova.splashscreen;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.teavm.jso.dom.html.HTMLElement;

public class SplashScreen extends org.apache.cordova.CordovaPlugin {
	private static final int DEFAULT_SPLASHSCREEN_DURATION = 3000;
	HTMLElement splashRoot;
	public SplashScreen() {
	}

	@Override
	protected void pluginInitialize() {
		super.pluginInitialize();

		showSplashScreen();
	}

	private void hideSplashScreen() {
		getShadowRoot().removeChild(splashRoot);
	}
	@org.teavm.jso.JSBody(params = {}, script = "return window.shadowRoot;")
    private static native HTMLElement getShadowRoot();
	private void showSplashScreen() {
		boolean autoHide = preferences.getBoolean("AutoHideSplashScreen", true);
		String splashResource = preferences.getString("SplashScreen", "screen");
		final int splashscreenTime = preferences.getInteger("SplashScreenDelay", DEFAULT_SPLASHSCREEN_DURATION);

		HTMLElement p = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
		splashRoot = p;
		p.setAttribute("dialog", "true");
		p.getStyle().setProperty("width", com.ashera.widget.PluginInvoker.getScreenWidth() + "px");
		p.getStyle().setProperty("height", com.ashera.widget.PluginInvoker.getScreenHeight() + "px");
		p.getStyle().setProperty("background", "#fff");
		p.getStyle().setProperty("z-index", "10000");
		p.getStyle().setProperty("position", "absolute");
		p.getStyle().setProperty("left", "0");
		p.getStyle().setProperty("top", "0");
		p.setAttribute("class", "web-dialog");
		
		HTMLElement img = org.teavm.jso.dom.html.HTMLDocument.current().createElement("img");
		img.setAttribute("src", "/res-swt/drawable/" + splashResource + ".png");
		img.getStyle().setProperty("width", "100%");
		img.getStyle().setProperty("height", "100%");
		img.getStyle().setProperty("object-fit", "cover");
		p.appendChild(img);
		
		HTMLElement progressBarContainer = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
		progressBarContainer.getStyle().setProperty("position", "absolute");
		progressBarContainer.getStyle().setProperty("left", "0");
		progressBarContainer.getStyle().setProperty("top", "0");
		progressBarContainer.getStyle().setProperty("width", "100%");
		progressBarContainer.getStyle().setProperty("height", "100%");
		progressBarContainer.getStyle().setProperty("display", "flex");

		HTMLElement progressBar = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
		progressBar.getStyle().setProperty("width", "30px");
		progressBar.getStyle().setProperty("height", "30px");
		progressBar.getStyle().setProperty("border-radius", "50%");
		progressBar.getStyle().setProperty("border", "5px solid #f3f3f3");
		progressBar.getStyle().setProperty("animation", "spin 2s linear infinite");
		progressBar.getStyle().setProperty("border-top", "5px solid #3498db");
		progressBar.getStyle().setProperty("margin", "auto");
		
		progressBarContainer.appendChild(progressBar);
		p.appendChild(progressBarContainer);
		getShadowRoot().appendChild(p);
		
		if (autoHide) {
			org.teavm.jso.browser.Window.setTimeout(new org.teavm.jso.browser.TimerHandler() {
				@Override
				public void onTimer() {
					hideSplashScreen();
				}
			}, splashscreenTime);
		}
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("hide")) {
			hideSplashScreen();
		} else if (action.equals("show")) {
			showSplashScreen();
		} else {
			return false;
		}

		callbackContext.success();
		return true;
	}
}
