package r.android.graphics.drawable;

import r.android.graphics.Insets;
import r.android.graphics.Rect;

public class Drawable {
	private int minimumWidth;

	public void setMinimumWidth(int minimumWidth) {
		this.minimumWidth = minimumWidth;
	}

	public void setMinimumHeight(int minimumHeight) {
		this.minimumHeight = minimumHeight;
	}

	private int minimumHeight;

	public void setLayoutDirection(int layoutDirection) {
	}

	public int getMinimumHeight() {
		return minimumHeight;
	}

	public int getMinimumWidth() {
		return minimumWidth;
	}

	public boolean isProjected() {
		return false;
	}

	public boolean getPadding(Rect padding) {
		return false;
	}

	public Insets getOpticalInsets() {
		return null;
	}

}
