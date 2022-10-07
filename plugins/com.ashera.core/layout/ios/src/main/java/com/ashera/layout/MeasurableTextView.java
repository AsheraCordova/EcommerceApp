package com.ashera.layout;

import com.ashera.widget.IWidget;

public class MeasurableTextView extends r.android.widget.TextView{

	public MeasurableTextView(IWidget widget) {
		super(widget);
	}

	public native int nativeMeasureWidth(Object uiView)/*-[
		CGSize maximumLabelSize = CGSizeMake(CGFLOAT_MAX,CGFLOAT_MAX);
		CGSize requiredSize = [((UIView*)uiView) sizeThatFits:maximumLabelSize];
		return ceil(requiredSize.width);
	]-*/;

	public native int nativeMeasureHeight(Object uiView, int width)/*-[
	    CGSize maximumLabelSize = CGSizeMake(width,CGFLOAT_MAX);
	    CGSize requiredSize = [((UIView*)uiView) sizeThatFits:maximumLabelSize];
	    return ceil(requiredSize.height);
	]-*/;
}
