package com.ashera.core;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.ashera.attributedtext.AttributedString;
import com.ashera.model.FontMetricsDescriptor;
import com.ashera.parser.html.HtmlParserPlugin;
import com.ashera.plugin.IPlugin;
import com.ashera.plugin.PluginManager;
import com.ashera.widget.PluginInvoker;

import androidx.fragment.app.Fragment;

/*-[
#import <sys/utsname.h>
]-*/
public class CorePlugin implements IPlugin, ICore {
	private static final String PLUGIN_NAME_CORE = "core";
    // metric density is hardcoded for ios as ios deals in points
    private static int density = 163;
    private static UINavigatorImpl navigator = new UINavigatorImpl();
    @Override
    public String getName() {
        return PLUGIN_NAME_CORE;
    }
    
	public static void initPlugin() {
		PluginManager.register(new HtmlParserPlugin());
		PluginManager.register(new CorePlugin());
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
		return isLandScape() ? "landscape": "portrait";
	}
	
	public native boolean isLandScape()/*-[
		UIDeviceOrientation orientation = [[UIDevice currentDevice] orientation];
		return UIInterfaceOrientationIsLandscape(orientation);
	]-*/;

	@Override
	public int getScreenWidth() {
		return nativeGetScreenWidth();
	}
	
	
	public native int nativeGetScreenHeight()/*-[
		UIDeviceOrientation orientation = [[UIDevice currentDevice] orientation];
		CGFloat width   = [[UIScreen mainScreen] bounds].size.width;
		CGFloat height   = [[UIScreen mainScreen] bounds].size.height;
		CGRect bounds = CGRectZero;
		
	
		if (UIInterfaceOrientationIsLandscape(orientation)) {
	    	bounds.size = CGSizeMake(MAX(width, height), MIN(width, height));
		} else {
	    	bounds.size = CGSizeMake(MIN(width, height), MAX(width, height));
		}
		return bounds.size.height;
	]-*/;
	public native int nativeGetScreenWidth()/*-[
		UIDeviceOrientation orientation = [[UIDevice currentDevice] orientation];
		CGFloat width   = [[UIScreen mainScreen] bounds].size.width;
		CGFloat height   = [[UIScreen mainScreen] bounds].size.height;
		CGRect bounds = CGRectZero;
		if (UIInterfaceOrientationIsLandscape(orientation)) {
	    	bounds.size = CGSizeMake(MAX(width, height), MIN(width, height));
		} else {
	    	bounds.size = CGSizeMake(MIN(width, height), MAX(width, height));
		}
		return bounds.size.width;
	]-*/;

	@Override
	public int getScreenHeight() {
		return nativeGetScreenHeight();
	}

	@Override
	public String getOS() {
		return "ios";
	}

	@Override
	public String getFileAsset(String path, IFragment fragment) {
		return getFileAsset(path);
	}
	
	public static native String getFileAsset(String path) /*-[
    	NSError* error = nil;
		NSString *abspath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:path];
		NSString *res = [NSString stringWithContentsOfFile: abspath encoding:NSUTF8StringEncoding error: &error];
		return res;
	]-*/;

	@Override
	public String getDensityName() {
		return getDensity() + "";
	}

	@Override
	public int getDensity() {
		return CorePlugin.density;
		/*if (CorePlugin.density != -1) {
			return CorePlugin.density;
		}

		//https://github.com/Clafou/DevicePpi/blob/master/Sources/DevicePpi/Ppi.swift
		String deviceName = getDeviceName();
		int density = 0; 
		switch (deviceName) {
		case "iPhone14,4":
		case "iPhone13,1":
			density = 476;
			break;
		case "iPhone14,5":
		case "iPhone14,2":
		case "iPhone13,2":
			density = 460;
			break;
		case "iPhone14,3":
		case "iPhone13,4":
		case "iPhone12,3":
		case "iPhone12,5":
		case "iPhone11,2":
		case "iPhone11,4":
		case "iPhone11,6":
		case "iPhone10,3":
		case "iPhone10,6":
			density = 458;
			break;
		case "iPhone10,2":
		case "iPhone10,5":
		case "iPhone9,2":
		case "iPhone9,4":
		case "iPhone8,2":
		case "iPhone7,1":
			density = 401;
			break;
			
	        // iPhone 8 Plus
	        // iPhone 11
		case "iPhone12,1":
		        // iPhone XR
		case "iPhone11,8":

		        // iPhone SE (2nd generation)
		case "iPhone12,8":
		        // iPhone 8
		case "iPhone10,1":
		case "iPhone10,4":
		        // iPhone 7
		case "iPhone9,1":
		case "iPhone9,3":
		        // iPhone 6S
		case "iPhone8,1":
		        // iPhone 6
		case "iPhone7,2":
		        
		        // iPhone SE
		case "iPhone8,4":
		        // iPhone 5S
		case "iPhone6,1":
		case "iPhone6,2":
		        // iPhone 5C
		case "iPhone5,3":
		case "iPhone5,4":
		        // iPhone 5
		case "iPhone5,1":
		case "iPhone5,2":
		        // iPod touch (7th generation)
		case "iPod9,1":
		        // iPod touch (6th generation)
		case "iPod7,1":
		        // iPod touch (5th generation)
		case "iPod5,1":
		        
		        // iPhone 4S
		case "iPhone4,1":

		        // iPad mini (6th generation)
		case "iPad14,1":
		case "iPad14,2":
		        // iPad mini (5th generation)
		case "iPad11,1":
		case "iPad11,2":
		        // iPad mini 4
		case "iPad5,1":
		case "iPad5,2":
		        // iPad mini 3
		case "iPad4,7":
		case "iPad4,8":
		case "iPad4,9":
		        // iPad mini 2
		case "iPad4,4":
		case "iPad4,5":
		case "iPad4,6":
			density = 326;
			break;
		case "iPad12,1":
		case "iPad12,2":
		        // iPad Pro (12.9″, 5th generation)
		case "iPad13,8":
		case "iPad13,9":
		case "iPad13,10":
		case "iPad13,11":
		        // iPad Pro (11″, 3rd generation)
		case "iPad13,4":
		case "iPad13,5":
		case "iPad13,6":
		case "iPad13,7":
		        // iPad Air (4th generation)
		case "iPad13,1":
		case "iPad13,2":
		        // iPad (8th generation)
		case "iPad11,6":
		case "iPad11,7":
		        // iPad Pro (12.9″, 4th generation)
		case "iPad8,11":
		case "iPad8,12":
		        // iPad Pro (11″, 2nd generation)
		case "iPad8,9":
		case "iPad8,10":
		        // iPad (7th generation)
		case "iPad7,11":
		case "iPad7,12":
		        // iPad Air (3rd generation)
		case "iPad11,3":
		case "iPad11,4":
		        // iPad Pro (12.9″, 3rd generation)
		case "iPad8,5":
		case "iPad8,6":
		case "iPad8,7":
		case "iPad8,8":
		        // iPad Pro (11″)
		case "iPad8,1":
		case "iPad8,2":
		case "iPad8,3":
		case "iPad8,4":
		        // iPad (6th generation)
		case "iPad7,5":
		case "iPad7,6":
		        // iPad Pro (10.5″)
		case "iPad7,3":
		case "iPad7,4":
		        // iPad Pro (12.9″, 2nd generation)
		case "iPad7,1":
		case "iPad7,2":
		        // iPad (5th generation)
		case "iPad6,11":
		case "iPad6,12":
		        // iPad Pro (12.9″)
		case "iPad6,7":
		case "iPad6,8":
		        // iPad Pro (9.7″)
		case "iPad6,3":
		case "iPad6,4":
		        // iPad Air 2
		case "iPad5,3":
		case "iPad5,4":
		        // iPad Air
		case "iPad4,1":
		case "iPad4,2":
		case "iPad4,3":
		        // iPad (4th generation)
		case "iPad3,4":
		case "iPad3,5":
		case "iPad3,6":
		        // iPad (3rd generation)
		case "iPad3,1":
		case "iPad3,2":
		case "iPad3,3":
			density = 264;
			break;
		case "iPad2,5":
		case "iPad2,6":
		case "iPad2,7":
			density = 163;
			break;
		case "iPad2,1":
		case "iPad2,2":
		case "iPad2,3":
		case "iPad2,4":
			density = 132;
			break;
		default:
			break;
		}
		CorePlugin.density = density;
		return density;*/
	}


	@Override
	public Object postDelayed(Runnable mTickRunnable, int delay) {
		return scheduledTimerWithTimeInterval(mTickRunnable, delay/1000f);
	}

	private native Object scheduledTimerWithTimeInterval(Runnable mTickRunnable, float delay)/*-[
		return 	[NSTimer scheduledTimerWithTimeInterval:delay
		    target:self
		    selector:@selector(onTick:)
		    userInfo:mTickRunnable
		    repeats:NO];
	]-*/;
	/*-[
		-(void)onTick:(NSTimer *)timer {
			[[timer userInfo] run];
		}
	]-*/

	@Override
	public void removeCallbacks(Object handler, Runnable mTickRunnable) {
		invalidateTimer(handler);
	}
	
	private native void invalidateTimer(Object handler)/*-[
		[((NSTimer*) handler) invalidate];
	]-*/;
	
	

	@Override
	public void putObjectToBundle(Object bundle, String key, Object data) {
		((r.android.os.Bundle) bundle).putSerializable(key, data);
	}

	@Override
	public void releaseNativeResources(List<Object> object) {
	}

	@Override
	public FontMetricsDescriptor getFontMetrics(Object font) {
		FontMetricsDescriptor metrics = new FontMetricsDescriptor();
		metrics.top = (int) -getMaxAscent(font);
		metrics.ascent = (int) -getAscent(font);
		metrics.descent = (int) -getDescent(font);
		metrics.bottom = (int) -getMaxDescent(font);
		metrics.leading = (int) getLeading(font);

		return metrics;
	}
	
	private native float getMaxAscent(Object fontObj)/*-[
		UIFont* font = ((UIFont*) fontObj);
		return font.ascender;
	]-*/;
	private native float getAscent(Object fontObj)/*-[
		UIFont* font = ((UIFont*) fontObj);
		return font.ascender;
	]-*/;
	private native float getDescent(Object fontObj)/*-[
		UIFont* font = ((UIFont*) fontObj);
		return font.descender;
	]-*/;
	private native float getMaxDescent(Object fontObj)/*-[
		UIFont* font = ((UIFont*) fontObj);
		return font.descender;
	]-*/;
	private native float getLeading(Object fontObj)/*-[
		UIFont* font = ((UIFont*) fontObj);
		return font.lineHeight + font.descender - font.ascender;
	]-*/;

	@Override
	public Object createDrawable(String type) {
		switch (type) {
		case "shape":
			return new ShapeDrawableImpl();

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

	private native String getDeviceName()/*-[
		struct utsname systemInfo;
        uname(&systemInfo);
    
        return [NSString stringWithCString:systemInfo.machine
                                  encoding:NSUTF8StringEncoding];
	]-*/;

	@Override
	public String getAttributedBulletHtml() {
		return "•\t";
	}
	
	
	public static void navigateAsTop(String actionId, Object scopedObjects, IFragment fragment) {
		List<Map<String, Object>> result = getScopedObjectArray(scopedObjects);
		navigator.navigateAsTop(actionId, result, fragment);		
	}

	public static void navigate(String actionId, Object scopedObjects, IFragment fragment) {
		List<Map<String, Object>> result = getScopedObjectArray(scopedObjects);
		navigator.navigate(actionId, result, fragment);		
	}

	public static List<Map<String, Object>> getScopedObjectArray(Object scopedObjects) {
		Object[] scopedObjectsArr = PluginInvoker.getArray(scopedObjects);
		List<Map<String, Object>> result = new java.util.ArrayList<>();
		
		for (Object map : scopedObjectsArr) {
			result.add(PluginInvoker.getMap(map));
		}
		return result;
	}
	
	public static void navigateWithPopBackStackTo(String actionId, String destinationId, boolean inclusive, Object scopedObjects, IFragment fragment) {
		List<Map<String, Object>> result = getScopedObjectArray(scopedObjects);
		navigator.navigateWithPopBackStackTo(actionId, destinationId, inclusive, result, fragment);		
	}
	
	public static void navigateWithPopBackStack(String actionId, Object scopedObjects, IFragment fragment) {
		List<Map<String, Object>> result = getScopedObjectArray(scopedObjects);
		navigator.navigateWithPopBackStack(actionId, result, fragment);		
	}
	
	public static void closeDialog() {
		navigator.closeDialog();		
	}
	
	public static void popBackStack(IFragment fragment) {
		navigator.popBackStack(fragment);
	}

	public static void popBackStack(IFragment fragment, String destinationId, boolean inclusive) {
		navigator.popBackStack(fragment, destinationId, inclusive);
	}
	
	public static String executeSimpleCommand(Object commands, IFragment fragment) {
		Object[] commandsArr = PluginInvoker.getArray(commands);
		Map<String, Object> resultMap = PluginInvoker.getJSONCompatMap();
		for (Object command : commandsArr) {
			Object[] commandArr = PluginInvoker.getArray(command);
			
			String commandName = PluginInvoker.getString(commandArr[0]);
			
			switch (commandName) {
			case "loadLocale":
				Object[] keys = PluginInvoker.getArray(commandArr[1]);
				
				// load all locale keys for javascript
		        if (keys != null && keys.length > 0) {
					Map<String, Object> localeMap = PluginInvoker.getJSONCompatMap();
					for (int j = 0; j < keys.length; j++) {
						String key = PluginInvoker.getString(keys[j]);
						String value = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", key,
								fragment);
						localeMap.put(key, value);
					}		
					
					PluginInvoker.putJSONSafeObjectIntoMap(resultMap, commandName, localeMap);
		        }	
		        
				break;

			default:
				break;
			}
		

		}
        
        return PluginInvoker.marshal(resultMap);
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
		return new File(nativeGetExternalFilesDir());
	}
	
	private native String nativeGetExternalFilesDir()/*-[
		NSArray *paths=NSSearchPathForDirectoriesInDomains(NSCachesDirectory,NSUserDomainMask, YES);
		NSString *directory = [paths objectAtIndex:0];
		return directory;
	]-*/;

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
		return new MyBitmap(stream);
	}

	@com.google.j2objc.annotations.WeakOuter
    private final static class MyBitmap implements r.android.graphics.Bitmap {
    	private Object image;
		public MyBitmap(InputStream stream) {
			byte[] bytes = com.ashera.utils.FileUtils.readAllBytes(stream);
			image = nativeGetImage(bytes);
		}
		
		private native Object nativeGetImage(byte[] bytes)/*-[
			NSData *data = [bytes toNSData];
			UIImage *image = [UIImage imageWithData:data];
			return image;
		]-*/;
		

		@Override
		public int getRowBytes() {
			return getImageWidth(image) * 4;
		}
		
		public static native int getImageWidth(Object value)/*-[
			UIImage* image = ((UIImage*) value);
			return image.size.width;
		]-*/;
		
		public static native int getImageHeight(Object value)/*-[
			UIImage* image = ((UIImage*) value);
			return image.size.height;
		]-*/;

		@Override
		public int getHeight() {
			return getImageHeight(image);
		}

		@Override
		public Object getImage() {
			return image;
		}
	}
	@Override
	public void runOnMainThread(Runnable runnable) {
		nativeRunOnMainThread(runnable);
	}

	private native void nativeRunOnMainThread(Runnable runnable)/*-[
		dispatch_async(dispatch_get_main_queue(), ^{
		    [runnable run];
		});
	]-*/;
	
}
