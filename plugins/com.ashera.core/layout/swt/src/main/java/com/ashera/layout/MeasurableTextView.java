package com.ashera.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

import com.ashera.widget.IWidget;

import r.android.content.res.ColorStateList;

public class MeasurableTextView extends r.android.widget.TextView{

	public MeasurableTextView(IWidget widget) {
		super(widget);
	}

	@Override
	public int nativeMeasureWidth(Object uiView) {		
    	Control control = (Control) uiView;
	    Point size = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		return size.x;
	}

	@Override
	public int nativeMeasureHeight(Object uiView, int width) {
	    Control control = (Control) uiView;
		Point size = control.computeSize(width, SWT.DEFAULT);
		return size.y;
	}
}
