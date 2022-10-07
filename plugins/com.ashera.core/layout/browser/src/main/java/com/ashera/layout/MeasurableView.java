package com.ashera.layout;

import com.ashera.widget.IWidget;

public class MeasurableView extends r.android.widget.TextView{

	public MeasurableView(IWidget widget) {
		super(widget);
	}

	@Override
	public int nativeMeasureWidth(Object uiView) {		
		return 0;
	}

	@Override
	public int nativeMeasureHeight(Object uiView, int width) {
		return 0;
	}
}
