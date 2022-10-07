package com.ashera.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

import com.ashera.widget.IWidget;

public class MeasurableView extends com.ashera.view.BaseMeasurableView {
	public MeasurableView(IWidget widget) {
		super(widget);
	}

	
    public int nativeMeasureWidth(Object uiView) {		
    	Control control = (Control) uiView;
	    Point size = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		return size.x;
	}

    public int nativeMeasureHeight(Object uiView, int width) {
	    Control control = (Control) uiView;
		Point size = control.computeSize(width, SWT.DEFAULT);
		return size.y;
	}
}
