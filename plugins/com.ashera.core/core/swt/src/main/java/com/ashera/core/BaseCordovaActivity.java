package com.ashera.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cordova.CordovaWebViewEngine;
import org.apache.cordova.PluginResult;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.json.JSONObject;

import com.ashera.widget.PluginInvoker;

import r.android.os.Bundle;

public class BaseCordovaActivity extends org.apache.cordova.CordovaActivity implements IActivity {
	//start - body
    private boolean isDeviceReady;
    private Map<String, Object> userData;
    private List<Map<String, Object>> bufferedEvents = new ArrayList<>();
    private Map<String, Object> tempCache;
    @Override
    public String getAssetMode() {
        return preferences.getString("assetmode", "prod");
    }

    @Override
    public String getDevServerIp() {
        return preferences.getString("devserverip", "localhost");
    }

    /* (non-Javadoc)
     * @see com.ashera.core.android.IActivity#onDeviceReady()
     */
    @Override
    public void onDeviceReady() {
        isDeviceReady = true;
        for (Map<String, Object> dataMap: bufferedEvents) {
            sendEventMessage(dataMap);
        }
        bufferedEvents.clear();

    }

	@Override
	public void sendEventMessage(Map<String, Object> dataMap) {
        if (isDeviceReady) {
            if (appView != null) {
                org.apache.cordova.PluginManager pluginManager = appView.getPluginManager();
                org.apache.cordova.CoreAndroid appPlugin = (org.apache.cordova.CoreAndroid) pluginManager.getPlugin(org.apache.cordova.CoreAndroid.PLUGIN_NAME);
                appPlugin.sendResumeEvent(new PluginResult(PluginResult.Status.OK, (JSONObject) PluginInvoker.toJsonTree(dataMap)));
            }
        } else {
            bufferedEvents.add(dataMap);
        }
	}

	@Override
	public Object getUserData(String key) {
		if (userData == null) {
			userData = new HashMap<>();
		}
		
		return userData.get(key);		
	}
	
	@Override
	public void storeUserData(String key, Object object) {
		if (userData == null) {
			userData = new HashMap<>();
		}
		
		userData.put(key, object);
	}
	
	@Override
	public void storeInTempCache(String key, Object object) {
		if (tempCache == null) {
			tempCache = new HashMap<>();
		}
		
		userData.put(key, object);

	}

	@Override
	public Object getFromTempCache(String key) {
		if (tempCache == null) {
			return null;
		}
		return tempCache.get(key);
	}
	

	@Override
	public float getScaleFactor() {
		return (float) preferences.getDouble(PluginInvoker.getOS() +  "ScaleFactor", 1d);
	}
	
	@Override
	public String getPreference(String name) {
		return preferences.getString(name, "");
	}
	//end - body
    /**
     * 
     */
    private Browser webView;
    private StackLayout stackLayout;
    private Composite rootComposite;
	private FragmentManager fragmentManager;

    /**
     * @param viewControllerDelegate
     * @param webView 
     */
    public BaseCordovaActivity(Browser webView, StackLayout stackLayout, Composite rootComposite) {
        this.webView = webView;
        this.rootComposite = rootComposite;
        this.stackLayout = stackLayout;

    }


    @Override
    protected CordovaWebViewEngine makeWebViewEngine() {
        return new MyCordovaWebViewEngine(this.webView);
    }

    
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }


    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getAssetMode().equals("dev")) {
            super.loadUrl(String.format("http://%s/app/src/main/assets/www/index.html?t=%d", getDevServerIp(), System.currentTimeMillis()));
        } else {
            try {
    			super.loadUrl(com.ashera.utils.FileUtils.getFilePathFromClassPath("www/index.html").toString());
    		} catch (Exception e) {
    			throw new RuntimeException(e);
    		}
        }
        
        fragmentManager = new FragmentManager(stackLayout, rootComposite, this);
        fragmentManager.navigate("index", "layout/index.xml");
    }


    @Override
    public com.ashera.core.IFragment getActiveRootFragment() {
    	return fragmentManager.getActiveFragment();
    }

    public Composite getRootComposite() {
		return rootComposite;
	}

	@Override
	public Object getRootWidget() {
		return rootComposite;
	}
}