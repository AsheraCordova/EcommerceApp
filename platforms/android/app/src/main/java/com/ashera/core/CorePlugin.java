package com.ashera.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import com.ashera.attributedtext.AttributedString;
import com.ashera.model.FontMetricsDescriptor;
import com.ashera.plugin.IPlugin;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

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
		Resources resources = Resources.getSystem();
		return resources.getConfiguration().orientation 
				== Configuration.ORIENTATION_LANDSCAPE ? "landscape": "portrait";
	}

	@Override
	@SuppressLint("NewApi")
	public int getScreenWidth() {
		Resources resources = Resources.getSystem();
		return resources.getDisplayMetrics().widthPixels;
	}

	@Override
	@SuppressLint("NewApi")
	public int getScreenHeight() {
		Resources resources = Resources.getSystem();
		return resources.getDisplayMetrics().heightPixels;
	}
	
	@Override
	public String getOS() {
		return "Android";
	}


	@Override
	public String getFileAsset(String path, IFragment fragment) {
		Context context = (Context) fragment.getRootActivity();
		return loadAssetTextAsString(context, path, fragment);
	}
	

	private String loadAssetTextAsString(Context context, final String fileResource, final IFragment fragment) {
	    if (fragment.hasDevData(fileResource)) {	        
	        return fragment.getDevData(fileResource).toString();
	    } else {
    		InputStream is = null;
    		byte[] b = null;
            try {
            	is = context.getAssets().open(fileResource);
    			b = new byte[is.available()];
    			is.read(b);
    		} catch (IOException e) {
    			throw new RuntimeException(e);
    		} finally {
    			try {
    				if (is != null) {
    					is.close();
    				}
    			} catch (IOException e) {
    			}
    		}
            
            return new String(b);
	    }
		
	}

    @Override
    public String getDensityName() {
    	Resources resources = Resources.getSystem();
        float density = resources.getDisplayMetrics().density;
        if (density >= 4.0) {
            return "xxxhdpi";
        }
        if (density >= 3.0) {
            return "xxhdpi";
        }
        if (density >= 2.0) {
            return "xhdpi";
        }
        if (density >= 1.5) {
            return "hdpi";
        }
        if (density >= 1.0) {
            return "mdpi";
        }
        return "ldpi";    
    }

	@Override
	public int getDensity() {
		int density = 0;
		switch (getDensityName()) {
		case "ldpi":			
			density = 120;
			break;
		case "mdpi":			
			density = 160;
			break;
		case "hdpi":			
			density = 240;
			break;
		case "xhdpi":			
			density = 320;
			break;
		case "xxhdpi":			
			density = 480;
			break;
		case "xxxhdpi":			
			density = 640;
			break;
		default:
			break;
		}
		return density;
	}


	@Override
	public Object postDelayed(Runnable mTickRunnable, int delay) {
		Handler handler = new Handler();
		handler.postDelayed(mTickRunnable, delay);
		return handler;
	}


	@Override
	public void removeCallbacks(Object handler, Runnable mTickRunnable) {
		((Handler) handler).removeCallbacks(mTickRunnable);
	}


	@Override
	public void putObjectToBundle(Object bundle, String key, Object value) {
		((android.os.Bundle) bundle).putSerializable(key, (Serializable) value);
	}


	@Override
	public void releaseNativeResources(List<Object> object) {
		
	}


	@Override
	public FontMetricsDescriptor getFontMetrics(Object mTextPaint) {
		android.graphics.Paint.FontMetricsInt fontMetricsInt = ((android.graphics.Paint) mTextPaint).getFontMetricsInt();
		FontMetricsDescriptor fontMetricsDescriptor = new FontMetricsDescriptor();
		fontMetricsDescriptor.ascent = fontMetricsInt.ascent;
		fontMetricsDescriptor.descent = fontMetricsInt.descent;
		fontMetricsDescriptor.bottom = fontMetricsInt.bottom;
		fontMetricsDescriptor.leading = fontMetricsInt.leading;
		fontMetricsDescriptor.top = fontMetricsInt.top;
		
		return fontMetricsDescriptor;
	}


	@Override
	public Object createDrawable(String type) {
		return new android.graphics.drawable.ShapeDrawable();
	}


	@Override
	public AttributedString createAttributedString(IFragment fragment, String text) {
		Context context = (Context) fragment.getRootActivity();
		return new com.ashera.core.attributedtext.AttributedStringImpl(text, context);
	}


	@Override
	public float getDisplayMetricDensity() {
		Resources resources = Resources.getSystem();
		return resources.getDisplayMetrics().density;
	}


	@Override
	public String getAttributedBulletHtml() {
		return null;
	}


	@Override
	public int getScreenWidthDp() {
		return Resources.getSystem().getConfiguration().screenWidthDp;
	}


	@Override
	public int getScreenHeightDp() {
		return Resources.getSystem().getConfiguration().screenHeightDp;
	}


	@Override
	public File getExternalFilesDir(Object objContext) {
		Context context = (Context) objContext;
		return context.getExternalFilesDir(null);
	}


	@Override
	public int getMaxMemory(Object objContext) {
		Context context = (Context) objContext;
		final int memClass = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
		return memClass;
	}


	@Override
	public Object decodeBitmapStream(InputStream stream, Object options) {
		return BitmapFactory.decodeStream(stream, null, (BitmapFactory.Options) options);
	}


	@Override
	public void runOnMainThread(Runnable runnable) {
		Handler mainHandler = new Handler(Looper.getMainLooper());
		mainHandler.post(runnable);
		
	}
}
