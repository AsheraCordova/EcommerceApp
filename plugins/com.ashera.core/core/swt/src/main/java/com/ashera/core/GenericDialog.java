package com.ashera.core;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

class GenericDialog extends Dialog {
	private Shell dialog;

	GenericDialog(Shell parent, Shell dialog) {
		super(parent);
		this.dialog = dialog;
	}

	public String open() {
		Rectangle bounds = getParent().getBounds();
		//dialog.setBounds(bounds.x, bounds.y, bounds.width * 0.9f, bounds.height);
//		dialog.setText("Java Source and Support");
		dialog.open();

		return "After Dialog";
	}

	public static Shell createDialogShell(Shell parent) {
		Shell dialog = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL| SWT.MIN | SWT.RESIZE);
		dialog.setData("dialog");
		dialog.setBackgroundMode(SWT.INHERIT_FORCE);
		return dialog;
	}
}