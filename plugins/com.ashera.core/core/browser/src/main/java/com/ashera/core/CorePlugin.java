package com.ashera.core;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.ashera.attributedtext.AttributedString;
import com.ashera.model.FontMetricsDescriptor;
import com.ashera.plugin.IPlugin;

public class CorePlugin implements IPlugin, ICore {
	private static final String PLUGIN_NAME_CORE = "core";
	public static final int DEFAULT_BUFFER_SIZE = 8192;

	@Override
	public String getName() {
		return PLUGIN_NAME_CORE;
	}

	@Override
	public Object invoke(String name, Object... args) {
		// start - core
		switch (name) {
		case "getAssetMode":
			return getAssetMode((IFragment) args[0]);
		case "getDevServerIp":
			return getDevServerIp((IFragment) args[0]);
		case "getOrientation":
			return getOrientation();
		case "getScreenWidth":
			return getScreenWidth();
		case "getScreenHeight":
			return getScreenHeight();
		case "getScreenWidthDp":
			return getScreenWidthDp();
		case "getScreenHeightDp":
			return getScreenHeightDp();
		case "getOS":
			return getOS();
		case "getFileAsset":
			return getFileAsset((String) args[0],(IFragment) args[1]);
		case "getDensityName":
			return getDensityName();
		case "getDensity":
			return getDensity();
		case "postDelayed":
			return postDelayed((Runnable) args[0],(int) args[1]);
		case "removeCallbacks":
			removeCallbacks((Object) args[0],(Runnable) args[1]);
			return null;
		case "putObjectToBundle":
			putObjectToBundle((Object) args[0],(String) args[1],(Object) args[2]);
			return null;
		case "releaseNativeResources":
			releaseNativeResources((List<Object>) args[0]);
			return null;
		case "getFontMetrics":
			return getFontMetrics((Object) args[0]);
		case "createDrawable":
			return createDrawable((String) args[0]);
		case "createAttributedString":
			return createAttributedString((IFragment) args[0],(String) args[1]);
		case "getDisplayMetricDensity":
			return getDisplayMetricDensity();
		case "getAttributedBulletHtml":
			return getAttributedBulletHtml();
		case "getExternalFilesDir":
			return getExternalFilesDir((Object) args[0]);
		case "getMaxMemory":
			return getMaxMemory((Object) args[0]);
		case "decodeBitmapStream":
			return decodeBitmapStream((InputStream) args[0],(Object) args[1]);
		case "runOnMainThread":
			runOnMainThread((Runnable) args[0]);
			return null;
		default:
			break;
		}
		throw new RuntimeException("Unknown method " + name);
		//end - core
	}

	@Override
	public String getAssetMode(IFragment fragment) {
		IActivity activity = fragment.getRootActivity();
		return activity == null ? "prod" : activity.getAssetMode();
	}

	@Override
	public String getDevServerIp(IFragment fragment) {
		IActivity activity = fragment.getRootActivity();
		return activity == null ? "localhost" : activity.getDevServerIp();
	}

	@Override
	public String getOrientation() {
		return "portrait";
	}

	@org.teavm.jso.JSBody(params = {}, script = "return window.getScreenWidth();")
    private static native int getMyScreenWidth();
	@org.teavm.jso.JSBody(params = {}, script = "return window.getScreenHeight();")
    private static native int getMyScreenHeight();
	@Override
	public int getScreenWidth() {
		return getMyScreenWidth();
	}

	@Override
	public int getScreenHeight() {
		return getMyScreenHeight();
	}

	@Override
	public String getOS() {
		return "Web";
	}

	@Override
	public String getFileAsset(String path, IFragment fragment) {
		System.out.println(path);
		return com.ashera.utils.FileUtils.getFileFromClassPath(path);
	}

	@Override
	public String getDensityName() {
		 return getDensity() + "";
	}

	@org.teavm.jso.JSBody(params = {}, script = "return document.getElementById('dpi').offsetHeight;")
    private static native int getDPi();
	
	@Override
	public int getDensity() {
		return (int) getDPi();
	}

	@Override
	public Object postDelayed(Runnable mTickRunnable, int delay) {
		int id = org.teavm.jso.browser.Window.setTimeout(() -> {
			mTickRunnable.run();
		}, delay);
		return id;
	}

	@Override
	public void removeCallbacks(Object handler, Runnable mTickRunnable) {
		org.teavm.jso.browser.Window.clearTimeout((int) handler);
	}

	@Override
	public void putObjectToBundle(Object bundle, String key, Object data) {
		((r.android.os.Bundle) bundle).putSerializable(key, data);
	}

	@Override
	public void releaseNativeResources(List<Object> object) {

	}

	@Override
	public FontMetricsDescriptor getFontMetrics(Object mTextPaint) {
		FontMetricsDescriptor fontMetricsDescriptor = new FontMetricsDescriptor();

		return fontMetricsDescriptor;
	}

	@Override
	public Object createDrawable(String type) {
		return new ShapeDrawableImpl();
	}

	@Override
	public AttributedString createAttributedString(IFragment fragment, String text) {
		throw new RuntimeException("no implementation available");
	}

	@Override
	public float getDisplayMetricDensity() {
		return getDensity()/160f;
	}

	@Override
	public String getAttributedBulletHtml() {
		return null;
	}

	@Override
	public int getScreenWidthDp() {
		return (int) (getScreenWidth() / getDisplayMetricDensity());
	}


	@Override
	public int getScreenHeightDp() {
		return (int) (getScreenHeight() / getDisplayMetricDensity());
	}

	@Override
	public File getExternalFilesDir(Object context) {
		throw new RuntimeException("no implementation available");
	}

	@Override
	public int getMaxMemory(Object context) {
		throw new RuntimeException("no implementation available");
	}

	@Override
	public Object decodeBitmapStream(InputStream stream, Object options) {
		throw new RuntimeException("no implementation available");
	}
	private static boolean isMainThreadRunning = false;
	@Override
	public void runOnMainThread(Runnable runnable) {
		if (isMainThreadRunning) {
			runnable.run();
			return;
		}
		new Thread(() -> {
			try {
				isMainThreadRunning = true;
				runnable.run();
			} finally {
				isMainThreadRunning = false;	
			}
		}).start();	
	}
}
