package com.applidium.shutterbug;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public interface ShutterbugImageCallBack {
	public void setImageDrawable(Drawable drawable);
	public void setImageBitmap(Bitmap bitmap);
	public void showError(String url);
}
