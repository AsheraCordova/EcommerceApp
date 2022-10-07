package com.ashera;

import com.ashera.core.CoreCordovaPlugin;
import com.ashera.core.MainActivity;

public class Client {
	static {
		//start - body
System.out.println(com.ashera.core.CoreCordovaPlugin.class.getName());
System.out.println(com.ashera.converter.ConverterCordovaPlugin.class.getName());
System.out.println(com.ashera.jsonadapter.JSONAdapterCordovaPlugin.class.getName());
System.out.println(com.ashera.layout.AndroidLayoutsCordovaPlugin.class.getName());
System.out.println(com.ashera.capinsets.CordovaCapInsetsPlugin.class.getName());
System.out.println(com.ashera.constraintlayout.AndroidXConstraintLayout.class.getName());
System.out.println(com.ashera.cssborder.BorderCordovaPlugin.class.getName());
System.out.println(com.ashera.datetime.CordovaDateTimePlugin.class.getName());
System.out.println(com.ashera.drawerlayout.CordovaNavigationDrawerPlugin.class.getName());
System.out.println(com.ashera.gridlayout.AndroidXGridLayoutPlugin.class.getName());
System.out.println(com.ashera.recycleview.CordovaRecycleViewPlugin.class.getName());
System.out.println(com.ashera.toolbar.CordovaToolbarPlugin.class.getName());
System.out.println(org.apache.cordova.splashscreen.SplashScreen.class.getName());
System.out.println(com.filfatstudios.spinnerdialog.SpinnerDialog.class.getName());
//end - body
	}

	public static void main(String[] args) throws Exception {
		MainActivity mainActivity = new MainActivity();
	    mainActivity.onCreate(new r.android.os.Bundle());
	}
}

