package com.ashera.core;

import java.util.HashMap;
import java.util.Map;

public class CordovaActivity extends r.android.app.Activity implements IActivity{
	private @com.google.j2objc.annotations.Weak IActivity delegate;
	private Map<String, Object> userData;
	private Map<String, Object> tempCache;
	
	public CordovaActivity(IActivity delegate) {
		this.delegate = delegate;
	}
	@Override
	public void onDeviceReady() {
		delegate.onDeviceReady();		
	}

	@Override
	public IFragment getActiveRootFragment() {
		return delegate.getActiveRootFragment();
	}

	@Override
	public void sendEventMessage(Map<String, Object> dataMap) {
		delegate.sendEventMessage(dataMap);
		
	}

	@Override
	public String getAssetMode() {
		return delegate.getAssetMode();
	}

	@Override
	public String getDevServerIp() {
		return delegate.getDevServerIp();
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
		
		tempCache.put(key, object);

	}

	@Override
	public Object getFromTempCache(String key) {
		if (tempCache == null) {
			return null;
		}
		return tempCache.get(key);
	}

	@Override
	public Object getRootWidget() {
		throw new RuntimeException("Method not implemented in ios");
	}

	@Override
	public float getScaleFactor() {
		return (float) delegate.getScaleFactor();
	}
	@Override
	public String getPreference(String name) {
		return delegate.getPreference(name);
	}

}
