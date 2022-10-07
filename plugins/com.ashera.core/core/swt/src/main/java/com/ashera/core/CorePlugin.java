package com.ashera.core;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ashera.attributedtext.AttributedString;
import com.ashera.core.attributedtext.AttributedStringImpl;
import com.ashera.model.FontMetricsDescriptor;
import com.ashera.plugin.IPlugin;

import r.android.graphics.drawable.Drawable;

public class CorePlugin implements IPlugin, ICore {
	private static final String PLUGIN_NAME_CORE = "core";

    @Override
    public String getName() {
        return PLUGIN_NAME_CORE;
    }

    
    @Override
    public Object invoke(String name, Object... args) {
        //start - core
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

	@Override
	public int getScreenWidth() {
		Shell shell = Display.getDefault().getShells()[0];
		return com.ashera.common.PreferenceWrapper.getCurrentWidth() - (shell.getBounds().width - shell.getClientArea().width + 4);
	}

	@Override
	public int getScreenHeight() {		
		Shell shell = Display.getDefault().getShells()[0];
        return com.ashera.common.PreferenceWrapper.getDefaultHeight() - (shell.getBounds().height - shell.getClientArea().height + 4);
	}
	
	@Override
	public String getOS() {
		return "Swt";
	}


	@Override
	public String getFileAsset(String path, IFragment fragment) {
		return getFileAsset(path);
	}
	
	public static String getFileAsset(String path) {
		try {
			String content = com.ashera.utils.FileUtils.getFileFromClassPath(path);
			return content;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


    @Override
    public String getDensityName() {
        return getDensity() + "";
    }

	@Override
	public int getDensity() {
		return Display.getDefault().getDPI().x;
	}


	@Override
	public Object postDelayed(Runnable mTickRunnable, int delay) {
		Display display = Display.getDefault();
		display.timerExec(delay, mTickRunnable);
		return display;
	}


	@Override
	public void removeCallbacks(Object handler, Runnable mTickRunnable) {
		 ((Display) handler).timerExec(-1, mTickRunnable);
	}


	@Override
	public void putObjectToBundle(Object bundle, String key, Object data) {
		((r.android.os.Bundle) bundle).putSerializable(key, data);
	}


	@Override
	public void releaseNativeResources(List<Object> object) {
		if (object != null) {
			com.ashera.common.DisposeUtil.disposeAll(object.toArray());
		}
	}


	@Override
	public FontMetricsDescriptor getFontMetrics(Object swtfont) {
		// https://android.googlesource.com/platform/frameworks/base.git/+/donut-release/tools/layoutlib/bridge/src/android/graphics/Paint.java
		FontData fontData = ((Font) swtfont).getFontData()[0];
		java.awt.Font font = new java.awt.Font(fontData.getName(), java.awt.Font.PLAIN, fontData.getHeight());
		java.awt.Canvas c = new java.awt.Canvas();
		java.awt.FontMetrics javaMetrics = c.getFontMetrics(font);
		FontMetricsDescriptor metrics = new FontMetricsDescriptor();
		metrics.top = -javaMetrics.getMaxAscent();
		metrics.ascent = -javaMetrics.getAscent();
		metrics.descent = javaMetrics.getDescent();
		metrics.bottom = javaMetrics.getMaxDescent();
		metrics.leading = javaMetrics.getLeading();

		return metrics;
	}


	@Override
	public Drawable createDrawable(String type) {
		switch (type) {
		case "shape":
			return new com.ashera.common.ShapeDrawableImpl();

		default:
			break;
		}
		return null;
	}


	@Override
	public AttributedString createAttributedString(IFragment fragment, String text) {
		return new AttributedStringImpl(fragment, text);
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
		return new File(System.getProperty("java.io.tmpdir"));
	}


	@Override
	public int getMaxMemory(Object context) {
		Runtime rt = Runtime.getRuntime();
		int maxMemory = (int) (rt.maxMemory() / (1024 * 1024 * 1f));
		return maxMemory;
	}

	@Override
	public Object decodeBitmapStream(InputStream stream, Object options) {
		if (((r.android.graphics.BitmapFactory.Options) options).inJustDecodeBounds) {
			return null;
		}
		return new MyBitMap(stream);
	}

    private final class MyBitMap implements r.android.graphics.Bitmap {
		private final ImageData imageData;
		private MyBitMap(InputStream stream) {
			this.imageData = new ImageData(stream);
		}

		@Override
		public int getRowBytes() {
			return imageData.width * 4;
		}

		@Override
		public int getHeight() {
			return imageData.height;
		}

		@Override
		public Object getImage() {
			return imageData;
		}
	}
	
	@Override
	public void runOnMainThread(Runnable runnable) {
		Display.getDefault().asyncExec(runnable);		
	}

}
