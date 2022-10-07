package com.ashera.layout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class DrawableComposite extends Composite {
	private IDrawable widget;
	private Control placeHolder;
	
	@Override
	public boolean forceFocus() {
		return widget.getControl().forceFocus();
	}
	public DrawableComposite(Composite parent, IDrawable widget, int style) {
		super(parent, style);
		this.widget = widget;
	}

	public Control getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(Control placeHolder) {
		this.placeHolder = placeHolder;
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);

		com.ashera.view.BaseMeasurableView measurableTextView = (com.ashera.view.BaseMeasurableView)  this.widget.asWidget();
		Control mainWidget = widget.getControl();
		setMainWidgetBounds(width, height, measurableTextView, mainWidget);
		
		if (placeHolder != null) {
			setMainWidgetBounds(width, height, measurableTextView, placeHolder);
		}

		Control drawableLeft = widget.getDrawableLeft();
		if (drawableLeft != null) {
			com.ashera.model.RectM bounds = measurableTextView.getLeftDrawableBounds(x, y, width, height);
			drawableLeft.setBounds(bounds.x, bounds.y,
					bounds.width, bounds.height);
		}

		Control drawableRight = widget.getDrawableRight();
		if (drawableRight != null) {
			com.ashera.model.RectM bounds = measurableTextView.getRightDrawableBounds(x, y, width, height);
			drawableRight.setBounds(bounds.x, bounds.y,
					bounds.width, bounds.height);
		}

		Control drawableTop = widget.getDrawableTop();
		if (drawableTop != null) {
			com.ashera.model.RectM bounds = measurableTextView.getTopDrawableBounds(x, y, width, height);
			drawableTop.setBounds(bounds.x, bounds.y,
					bounds.width, bounds.height);
		}

		Control drawableBottom = widget.getDrawableBottom();
		if (drawableBottom != null) {
			com.ashera.model.RectM bounds = measurableTextView.getBottomDrawableBounds(x, y, width, height);
			drawableBottom.setBounds(bounds.x, bounds.y,
					bounds.width, bounds.height);
		}
	}

	private void setMainWidgetBounds(int width, int height, com.ashera.view.BaseMeasurableView measurableTextView,
			Control mainWidget) {
		com.ashera.model.RectM widgetBounds = measurableTextView.getWidgetBounds(width, height, this, mainWidget);
		if (widgetBounds.height <= height) {
			mainWidget.setBounds(widgetBounds.x, widgetBounds.y,
					widgetBounds.width - 2*getBorderWidth(), widgetBounds.height - (2*getBorderWidth()));
		} else {
			mainWidget.setBounds(measurableTextView.getCompoundPaddingLeft(), measurableTextView.getCompoundPaddingTop(), width, height);
		}
	}
}