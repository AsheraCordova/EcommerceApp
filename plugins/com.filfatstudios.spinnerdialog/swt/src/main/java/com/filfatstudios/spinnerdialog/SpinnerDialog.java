package com.filfatstudios.spinnerdialog;

import java.util.Stack;

import org.apache.cordova.CallbackContext;
import org.eclipse.swt.widgets.Shell;
import org.json.JSONArray;
import org.json.JSONException;

public class SpinnerDialog extends org.apache.cordova.CordovaPlugin {
	public Stack<ProgressDialog> spinnerDialogStack = new Stack<ProgressDialog>();

	public SpinnerDialog() {
	}

	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("show")) {

			String title = "null".equals(args.get(0).toString()) ? null : args.get(0).toString();
			String message = "null".equals(args.get(1).toString()) ? null : args.get(1).toString();
			final boolean isFixed = (boolean) args.get(2);
			System.out.println(title + " " + message + " " + isFixed);

			Shell shell = org.eclipse.swt.widgets.Display.getDefault().getShells()[0];
			ProgressDialog p = new ProgressDialog(shell, title, message, isFixed);
			spinnerDialogStack.push(p);
			p.show();

		} else if (action.equals("hide")) {

			if (!SpinnerDialog.this.spinnerDialogStack.empty()) {
				ProgressDialog p = SpinnerDialog.this.spinnerDialogStack.pop();
				p.hide();
			}
		}

		return true;
	}

}
