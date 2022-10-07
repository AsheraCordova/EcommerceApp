package com.ashera.swt.starter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.DeviceData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ashera.common.ColorManager;
import com.ashera.core.BaseApplication;

public class TestApp extends BaseApplication{
	private static boolean SLEAK_ENABLED = false;
	private static boolean CONTROL_PANEL_ENABLED = false;
	private static boolean TEST_PANEL_ENABLED = false;
	public static void main(String[] args) {
	    TestApp testApp = new TestApp();
		DeviceData data = new DeviceData();
		data.tracking = SLEAK_ENABLED;
		Display display = new Display(data);
		Shell shell = testApp.start(display, SWT.DIALOG_TRIM| SWT.MIN | SWT.RESIZE);
	    
		if (data.tracking) {
    		Sleak sleak = new Sleak();
    	    sleak.open();
		}


        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        ColorManager.dispose();
	    display.dispose();
	}

	@Override
	public boolean isControlPanelEnabled() {
		return CONTROL_PANEL_ENABLED;
	}
	
	@Override
	public boolean isTestPanelEnabled() {
		return TEST_PANEL_ENABLED;
	}
}
