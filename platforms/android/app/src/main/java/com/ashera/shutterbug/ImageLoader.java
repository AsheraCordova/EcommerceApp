package com.ashera.shutterbug;

import com.ashera.image.ITarget;

import android.graphics.drawable.Drawable;

public class ImageLoader implements com.applidium.shutterbug.ShutterbugImageCallBack {
	private ITarget target;
	private Object error;

	public ImageLoader(ITarget target, Object error) {
		this.target = target;
		this.error = error;
	}

	@Override
	public void setImageDrawable(Drawable drawable) {
		target.onPrepareLoad(drawable);
	}

	@Override
	public void setImageBitmap(android.graphics.Bitmap bitmap) {
		target.onBitmapLoaded(bitmap);
	}

	@Override
	public void showError(String url) {
		target.onBitmapFailed(error);
	}
}