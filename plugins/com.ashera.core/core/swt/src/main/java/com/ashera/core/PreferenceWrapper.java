package com.ashera.core;

import java.util.prefs.Preferences;

public class PreferenceWrapper {
    private static final String DEFAULT_ENV = "android";
	public static int DEFAULT_WIDTH = 320;
    public static int DEFAULT_HEIGHT = 400;

    private static Preferences prefs = Preferences.userRoot().node("SystemPreferences");
    
    public static int getCurrentWidth() {
        return prefs.getInt("width", DEFAULT_WIDTH);
    }
    
    public static int getDefaultHeight() {
        return prefs.getInt("height", DEFAULT_HEIGHT);
    }

    public static void saveSize(int width, int height) {
        prefs.putInt("width", width);
        prefs.putInt("height", height);
    }
    
    public static void saveEnvUnderTest(String envUnderTest) {
        prefs.put("envUnderTest", envUnderTest);
    }
    
    public static String getEnvUnderTest() {
    	 return prefs.get("envUnderTest", DEFAULT_ENV);
    }
}
