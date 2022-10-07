package com.filfatstudios.spinnerdialog;

import java.util.Stack;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.teavm.jso.dom.html.HTMLElement;

public class SpinnerDialog extends org.apache.cordova.CordovaPlugin {
	public Stack<HTMLElement> spinnerDialogStack = new Stack<HTMLElement>();

	public SpinnerDialog() {
	}

	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("show")) {

			String title = "null".equals(args.get(0).toString()) ? null : args.get(0).toString();
			String message = "null".equals(args.get(1).toString()) ? null : args.get(1).toString();
			final boolean isFixed = (boolean) args.get(2);
			System.out.println(title + " " + message + " " + isFixed);

			HTMLElement p = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
			p.setAttribute("dialog", "true");
			p.getStyle().setProperty("width", "100%");
			p.getStyle().setProperty("height", "100%");
			p.getStyle().setProperty("background", "#00000088");
			p.getStyle().setProperty("z-index", "10000");
			p.getStyle().setProperty("position", "absolute");
			p.getStyle().setProperty("left", "0");
			p.getStyle().setProperty("top", "0");
			p.getStyle().setProperty("display", "flex");
			p.getStyle().setProperty("align-items", "center");
			p.setAttribute("class", "web-dialog");
			com.ashera.widget.IWidget widget =  (com.ashera.widget.IWidget)((com.ashera.core.IActivity) cordova.getActivity()).getActiveRootFragment().getRootWidget();
			spinnerDialogStack.push(p);
			((HTMLElement) widget.asNativeWidget()).appendChild(p);
			
			HTMLElement progressBarContainer = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");
			HTMLElement progressBar = org.teavm.jso.dom.html.HTMLDocument.current().createElement("div");		
			progressBar.getStyle().setProperty("width", "30px");
			progressBar.getStyle().setProperty("height", "30px");
			progressBar.getStyle().setProperty("border-radius", "50%");
			progressBar.getStyle().setProperty("border", "5px solid #f3f3f3");
			progressBar.getStyle().setProperty("animation", "spin 2s linear infinite");
			progressBar.getStyle().setProperty("border-top", "5px solid #3498db");
			progressBarContainer.appendChild(progressBar);
			
			if (message != null) {
				HTMLElement messageLabel = org.teavm.jso.dom.html.HTMLDocument.current().createElement("label");
				messageLabel.getStyle().setProperty("margin-left", "20px");
				messageLabel.setInnerHTML(message);
				progressBarContainer.appendChild(messageLabel);
			}
			progressBarContainer.getStyle().setProperty("width", "80%");
			progressBarContainer.getStyle().setProperty("border-radius", "3px");
			progressBarContainer.getStyle().setProperty("background", "white");
			progressBarContainer.getStyle().setProperty("padding", "20px");
			progressBarContainer.getStyle().setProperty("margin", "auto");
			progressBarContainer.getStyle().setProperty("display", "flex");
			progressBarContainer.getStyle().setProperty("align-items", "center");

			p.appendChild(progressBarContainer);

		} else if (action.equals("hide")) {

			if (!SpinnerDialog.this.spinnerDialogStack.empty()) {
				HTMLElement p = spinnerDialogStack.pop();
				p.getParentNode().removeChild(p);	
			}
		}

		return true;
	}

}
