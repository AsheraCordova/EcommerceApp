package org.apache.cordova.splashscreen;

import java.util.ArrayList;
import java.util.List;

import org.apache.cordova.CallbackContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.json.JSONArray;
import org.json.JSONException;

import com.ashera.model.RectM;
import com.ashera.utils.FileUtils;

public class SplashScreen extends org.apache.cordova.CordovaPlugin {
	private Listener listener;
	private Shell shell;
	private Shell parent;
	private static final int DEFAULT_SPLASHSCREEN_DURATION = 3000;
	private List<Resource> disposables = new ArrayList<>();
	public SplashScreen() {
	}

	@Override
	protected void pluginInitialize() {
		super.pluginInitialize();

		showSplashScreen();
	}

	private void hideSplashScreen() {
		shell.dispose();
		if (!parent.isDisposed()) {
			parent.removeListener(SWT.Resize, listener);
			parent.removeListener(SWT.Move, listener);
		}
		
		com.ashera.common.DisposeUtil.disposeAll(disposables.toArray());
	}

	private void showSplashScreen() {
		boolean autoHide = preferences.getBoolean("AutoHideSplashScreen", true);
		String splashResource = preferences.getString("SplashScreen", "screen");
		final int splashscreenTime = preferences.getInteger("SplashScreenDelay", DEFAULT_SPLASHSCREEN_DURATION);

		java.io.InputStream f = FileUtils.getInputStreamFromClassPath("www/res-swt/drawable/" + splashResource + ".png");
		this.parent = org.eclipse.swt.widgets.Display.getDefault().getShells()[0];
		this.shell = new Shell(parent, SWT.NO_TRIM);
		shell.setLayout(new org.eclipse.nebula.widgets.layout.AbsoluteLayout());

		Image image = new Image(Display.getDefault(), f);
		disposables.add(image);

		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event e) {
				GC gc = e.gc;
				drawImage(gc, image);
				gc.dispose();
			}
		});
		if (preferences.getBoolean("ShowSplashScreenSpinner", true)) {
			ProgressBar progressBar = new ProgressBar(shell, SWT.INDETERMINATE);
			int progressBarWidth = 100;
			int progressBarHeight = 15;
			progressBar.setBounds((com.ashera.widget.PluginInvoker.getScreenWidth() - progressBarWidth) / 2,
					com.ashera.widget.PluginInvoker.getScreenHeight() - progressBarHeight * 2, progressBarWidth,
					progressBarHeight);
		}

		updateBounds();
		this.listener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (shell.getData() == null) {
					shell.open();
					shell.setData(true);

					if (autoHide) {
						Display display = Display.getDefault();
						display.timerExec(splashscreenTime, () -> {
							hideSplashScreen();
						});
					}
				} else {
					updateBounds();

					if (event.type == SWT.Resize) {
						shell.redraw();
					}
				}
			}
		};
		parent.addListener(SWT.Resize, listener);
		parent.addListener(SWT.Move, listener);
	}

	private void updateBounds() {
		int y = parent.getBounds().height - parent.getClientArea().height;
		shell.setBounds(parent.getLocation().x + 10, parent.getLocation().y + y - 6,
				com.ashera.widget.PluginInvoker.getScreenWidth(), com.ashera.widget.PluginInvoker.getScreenHeight());
	}

	private void drawImage(GC gc, Image image) {
		int screenWidth = com.ashera.widget.PluginInvoker.getScreenWidth();
		int screenHeight = com.ashera.widget.PluginInvoker.getScreenHeight();

		if (isMaintainAspectRatio()) {
			RectM rectM = getBounds(image, screenWidth, screenHeight);
			Image resizeImage = com.ashera.common.ImageUtils.resize(image, rectM.width, rectM.height, new com.ashera.common.ImageUtils.ResizeOptions.Builder().build());
			gc.drawImage(resizeImage, rectM.x, rectM.y);
			resizeImage.dispose();
		} else {
			Image resizeImage = com.ashera.common.ImageUtils.resize(image, screenWidth, screenHeight, new com.ashera.common.ImageUtils.ResizeOptions.Builder().build());
			gc.drawImage(resizeImage, 0, 0);
			resizeImage.dispose();
		}
	}

	private RectM getBounds(Image image, int screenWidth, int screenHeight) {
		int dwidth = image.getImageData().width;
		int dheight = image.getImageData().height;

		float scale;
		float dx = 0, dy = 0;

		final int vwidth = screenWidth;
		final int vheight = screenHeight;

		if (dwidth * vheight > vwidth * dheight) {
			scale = (float) vheight / (float) dheight;
			dx = (vwidth - dwidth * scale) * 0.5f;
		} else {
			scale = (float) vwidth / (float) dwidth;
			dy = (vheight - dheight * scale) * 0.5f;
		}
		int newWidth = (int) (dwidth * scale);
		int newHeight = (int) (dheight * scale);
		RectM rectM = new com.ashera.model.RectM((int) dx, (int) dy, newWidth, newHeight);
		return rectM;
	}

	private boolean isMaintainAspectRatio() {
		return preferences.getBoolean("SplashMaintainAspectRatio", false);
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("hide")) {
			hideSplashScreen();
		} else if (action.equals("show")) {
			showSplashScreen();
		} else {
			return false;
		}

		callbackContext.success();
		return true;
	}
}
