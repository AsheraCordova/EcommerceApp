package com.ashera.layout;

import com.ashera.widget.IWidget;

public class MeasurableCompoundButton extends r.android.widget.CompoundButton{

	public MeasurableCompoundButton(IWidget widget) {
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
