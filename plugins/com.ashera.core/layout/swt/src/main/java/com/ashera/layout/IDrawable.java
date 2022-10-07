package com.ashera.layout;

import org.eclipse.swt.widgets.Control;

public interface IDrawable extends com.ashera.widget.IWidget {
	Control getControl();
	Control getDrawableTop();
	Control getDrawableLeft();
	Control getDrawableRight();
	Control getDrawableBottom();
}
