package com.ashera.core;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.ashera.attributedtext.AttributedString;
import com.ashera.model.FontMetricsDescriptor;

interface ICore {
    String getAssetMode(IFragment fragment);
    String getDevServerIp(IFragment fragment);
	String getOrientation();
	int getScreenWidth();
	int getScreenHeight();
	int getScreenWidthDp();
	int getScreenHeightDp();
	String getOS();
	String getFileAsset(String path, IFragment fragment);
	String getDensityName();
	int getDensity();
	Object postDelayed(Runnable mTickRunnable, int delay);
	void removeCallbacks(Object handler, Runnable mTickRunnable);
	void putObjectToBundle(Object bundle, String key, Object data);
	void releaseNativeResources(List<Object> object);
	FontMetricsDescriptor getFontMetrics(Object font);
	Object createDrawable(String type);
	AttributedString createAttributedString(IFragment fragment, String text);
	float getDisplayMetricDensity();
	String getAttributedBulletHtml();
	File getExternalFilesDir(Object context);
	int getMaxMemory(Object context);
	Object decodeBitmapStream(InputStream stream, Object options);
	void runOnMainThread(Runnable runnable);
}
