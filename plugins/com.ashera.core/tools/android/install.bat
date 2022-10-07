
call phonegap plugin rm com.ashera.converter.android
call phonegap plugin rm com.ashera.core.android
call phonegap plugin rm com.ashera.device.android
call phonegap plugin rm com.ashera.jsonadapter.android
call phonegap plugin rm com.ashera.navigation.android
call phonegap plugin rm com.ashera.webbridge.android
call phonegap plugin rm com.ashera.ui.android

call phonegap plugin add ../../../core-android-widget/AndroidConverterPlugin
call phonegap plugin add ../../../core-android-widget/AndroidCorePlugin
call phonegap plugin add ../../../core-android-widget/AndroidDevicePlugin
call phonegap plugin add ../../../core-android-widget/AndroidJsonAdapter
call phonegap plugin add ../../../core-android-widget/AndroidNavigatorPlugin
call phonegap plugin add ../../../core-android-widget/AndroidWebBridge
call phonegap plugin add ../../../core-android-widget/AndroidLayouts