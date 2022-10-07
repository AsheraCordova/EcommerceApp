package com.ashera.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cordova.PluginResult;
import org.json.JSONObject;

import com.ashera.widget.PluginInvoker;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

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
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadUrl(launchUrl);
    }
	
    @Override
    public IFragment getActiveRootFragment() {
        IFragment activeFragment = null;
        for (Fragment fragment : ((FragmentManager) getSupportFragmentManager ()).getFragments()) {
            if (fragment instanceof NavHostFragment) {
                List fragments = fragment.getChildFragmentManager().getFragments();
                activeFragment = (IFragment) fragments.get(fragments.size() - 1);
                break;
            }
        }
        return activeFragment;
    }

    @Override
    protected void init() {
        super.init();

        appView.getView().setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        Log.e("assetmode", preferences.getString("assetmode", "prod"));

        addContentView(getLayoutInflater().inflate(getResources().getIdentifier("activity_main", "layout", getPackageName()), null),
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));       
    }

    //not used in android/only for swt
	@Override
	public Object getRootWidget() {
		return this;
	}
}
