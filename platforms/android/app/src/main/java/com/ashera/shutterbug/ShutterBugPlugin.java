package com.ashera.shutterbug;

import com.ashera.image.ITarget;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class ShutterBugPlugin  {
    private static final class Target implements com.ashera.image.IImageDownloader {
		@Override
		public void download(Object context, String url, Object placeholder, Object error, ITarget target) {
			com.applidium.shutterbug.ShutterbugManager.getSharedImageManager((Context) context).download(url, (Drawable) placeholder, new ImageLoader(target, error));				

		}
	}

	public static void initPlugin() {
    	//start - body
    	//end - body
		com.ashera.image.ImageDownloaderFactory.register(new Target());
    }
}
