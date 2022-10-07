package com.bitpay.cordova.qrscanner;

import java.util.HashMap;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ashera.core.IActivity;

public class QRScanner extends CordovaPlugin  {
	private CallbackContext nextScanCallback;
	private CallbackContext callbackContext;
    private boolean shouldScanAgain;
    private boolean denied;
    private boolean authorized = true;
    private boolean restricted;
    private boolean oneTime = true;
    private boolean keepDenied = false;
    private boolean appPausedWithActivePreview = false;
    private boolean lightOn = false;
    private boolean showing = false;
    private boolean prepared = false;
    private boolean previewing = false;
    private boolean switchFlashOn = false;
    private boolean switchFlashOff = false;
    private boolean cameraPreviewing;
    private boolean scanning = false;
	private WebCameraPanel panel;
	@Override
    public boolean execute(final String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        try {
            if (action.equals("show")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        show(callbackContext);
                    }
                });
                return true;
            }
            else if(action.equals("scan")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        scan(callbackContext);
                    }
                });
                return true;
            }
            else if(action.equals("cancelScan")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        cancelScan(callbackContext);
                    }
                });
                return true;
            }
            else if(action.equals("openSettings")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        openSettings(callbackContext);
                    }
                });
                return true;
            }
            else if(action.equals("pausePreview")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        pausePreview(callbackContext);
                    }
                });
                return true;
            }
            else if(action.equals("useCamera")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        switchCamera(callbackContext, args);
                    }
                });
                return true;
            }
            else if(action.equals("resumePreview")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        resumePreview(callbackContext);
                    }
                });
                return true;
            }
            else if(action.equals("hide")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        hide(callbackContext);
                    }
                });
                return true;
            }
            else if (action.equals("enableLight")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                    	
                    }
                });
                return true;
            }
            else if (action.equals("disableLight")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {

                    }
                });
                return true;
            }
            else if (action.equals("prepare")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        cordova.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {                                
                                prepare(callbackContext);
                            }
                        });
                    }
                });
                return true;
            }
            else if (action.equals("destroy")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        destroy(callbackContext);
                    }
                });
                return true;
            }
            else if (action.equals("getStatus")) {
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        getStatus(callbackContext);
                    }
                });
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            callbackContext.error(QRScannerError.UNEXPECTED_ERROR);
            return false;
        }
    }
	
	protected void getStatus(CallbackContext callbackContext) {
		JSONObject obj = getStatus();
        PluginResult result = new PluginResult(PluginResult.Status.OK, obj);
        callbackContext.sendPluginResult(result);		
	}

	protected void destroy(CallbackContext callbackContext) {
		scanning = false;
		this.panel.close();
		getStatus(callbackContext);
	}

	protected void hide(CallbackContext callbackContext) {
	}

	protected void resumePreview(CallbackContext callbackContext) {
		this.previewing = true;
		this.panel.start();
		getStatus(callbackContext);
	}

	protected void switchCamera(CallbackContext callbackContext, JSONArray args) {
	}

	protected void pausePreview(CallbackContext callbackContext) {
		this.previewing = false;
		this.panel.close();
		getStatus(callbackContext);
	}

	protected void openSettings(CallbackContext callbackContext) {
	}

	protected void cancelScan(CallbackContext callbackContext) {
		if(this.nextScanCallback != null) {
            this.nextScanCallback.error(QRScannerError.SCAN_CANCELED);
		}
		this.panel.stopDecoding();
		this.nextScanCallback = null;
	}

	protected void scan(CallbackContext callbackContext) {
		com.ashera.widget.PluginInvoker.runOnMainThread(() -> {
			if (nextScanCallback == null) {
				QRScanner.this.panel.start();
			}
			this.panel.startDecoding();
			nextScanCallback = callbackContext;
			scanning = true;
			cameraPreviewing = true;
		});
		
	}

	protected void show(CallbackContext callbackContext) {
	}
	
	protected void prepare(CallbackContext callbackContext) {
		
		com.ashera.widget.PluginInvoker.runOnMainThread(() -> {
			IActivity activity = ((IActivity) cordova.getActivity());
			com.ashera.widget.IWidget widget = activity.getActiveRootFragment().getRootWidget().findWidgetById("@+id/qrcode_scanner");
			QRScanner.this.panel = new WebCameraPanel(QRScanner.this, (org.eclipse.swt.widgets.Composite) widget.asNativeWidget());
			prepared = true;
			getStatus(callbackContext);
		});
	}

	private JSONObject getStatus() {
		HashMap status = new HashMap();
        status.put("authorized",boolToNumberString(authorized));
        status.put("denied",boolToNumberString(denied));
        status.put("restricted",boolToNumberString(restricted));
        status.put("prepared",boolToNumberString(prepared));
        status.put("scanning",boolToNumberString(scanning));
        status.put("previewing",boolToNumberString(previewing));
        status.put("showing",boolToNumberString(showing));
        status.put("lightEnabled",boolToNumberString(lightOn));
        boolean canOpenSettings = false;
        boolean canEnableLight = false;
        status.put("canOpenSettings",boolToNumberString(canOpenSettings));
        status.put("canEnableLight",boolToNumberString(canEnableLight));
        status.put("canChangeCamera",boolToNumberString(false));
        status.put("currentCamera",Integer.toString(1));

        JSONObject obj = new JSONObject(status);
		return obj;
	}
	
	 private String boolToNumberString(Boolean bool) {
	        if(bool)
	            return "1";
	        else
	            return "0";
	    }


	static class QRScannerError {
        private static final int UNEXPECTED_ERROR = 0,
                CAMERA_ACCESS_DENIED = 1,
                CAMERA_ACCESS_RESTRICTED = 2,
                BACK_CAMERA_UNAVAILABLE = 3,
                FRONT_CAMERA_UNAVAILABLE = 4,
                CAMERA_UNAVAILABLE = 5,
                SCAN_CANCELED = 6,
                LIGHT_UNAVAILABLE = 7,
                OPEN_SETTINGS_UNAVAILABLE = 8;
    }

	public void  resultCallBack(String text) {
		if (this.nextScanCallback == null) {
            return;
        }
        scanning = false;
        this.panel.stopDecoding();
        this.nextScanCallback.success(text);
        this.nextScanCallback = null;
	}
}
