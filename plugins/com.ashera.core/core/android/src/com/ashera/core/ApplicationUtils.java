package com.ashera.core;

import android.app.Activity;

public class ApplicationUtils {
    
    /**
     * Method to Check if the application is running.
     *
     * @param context
     *            context.
     * @return true if app running.
     */
    public static boolean isAppRunning(android.content.Context context) {
        android.app.ActivityManager manager = (android.app.ActivityManager) context.getSystemService(Activity.ACTIVITY_SERVICE);
        java.util.List<android.app.ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(Integer.MAX_VALUE);
        boolean found = false;

        for (android.app.ActivityManager.RunningTaskInfo runningTaskInfo : runningTaskInfos) {
            android.content.ComponentName componentInfo = runningTaskInfo.topActivity;

            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                found = true;
                break;
            }
        }

        return found;
    }
}
