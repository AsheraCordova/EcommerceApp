package com.ashera.layout;

import com.ashera.widget.IWidget;

public class MeasurableViewGroup extends com.ashera.view.BaseMeasurableViewGroup{

	public MeasurableViewGroup(IWidget widget) {
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
