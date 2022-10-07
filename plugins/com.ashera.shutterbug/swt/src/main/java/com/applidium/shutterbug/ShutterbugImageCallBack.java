package com.applidium.shutterbug;

import r.android.graphics.Bitmap;
import r.android.graphics.drawable.Drawable;

public interface ShutterbugImageCallBack {
	public void setImageDrawable(Drawable drawable);
	public void setImageBitmap(Bitmap bitmap);
	public void showError(String url);
}
