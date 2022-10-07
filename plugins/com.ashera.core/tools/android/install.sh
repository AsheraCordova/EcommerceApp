export ANDROID_HOME=/Users/ramm/Documents/JAVA/Android
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home
export PATH=$PATH:/Users/ramm/.npm-packages/bin

cordova plugin rm com.ashera.tools
cordova plugin rm com.ashera.converter
cordova plugin rm com.ashera.core
cordova plugin rm com.ashera.jsonadapter
cordova plugin rm com.ashera.navigation
cordova plugin rm com.ashera.layout
cordova plugin rm com.ashera.constraintlayout
cordova plugin rm com.ashera.helloworld


cordova plugin add ../../../core-android-widget/AndroidToolsPlugin
cordova plugin add ../../../core-android-widget/AndroidConverterPlugin
cordova plugin add ../../../core-android-widget/AndroidCorePlugin
cordova plugin add ../../../core-android-widget/AndroidJsonAdapter
cordova plugin add ../../../core-android-widget/AndroidNavigatorPlugin
cordova plugin add ../../../core-android-widget/AndroidLayouts
cordova plugin add ../../../core-android-widget/AndroidXConstraintLayout
cordova plugin add ../../../core-widget_library/widget_library/AsheraHelloWorld
