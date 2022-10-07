package com.bitpay.cordova.qrscanner;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.JRootPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


/**
 * Example of how WebcamPanel can be used in SWT using SWT_AWT bridge.
 * 
 * @author Dimitrios Chondrokoukis
 */
public class WebCameraPanel implements Runnable, ThreadFactory {
	private Executor executor = Executors.newSingleThreadExecutor(this);

	private Webcam webcam;
	private WebcamPanel panel;
	private QRScanner qrScanner;
	private boolean stopDecoding;
	/**
	 * Create the shell.
	 * @param qrScanner 
	 * 
	 * @param display
	 */
	public WebCameraPanel(QRScanner qrScanner, Composite qrcodePanel) {
		this.qrScanner = qrScanner;
		Dimension size = WebcamResolution.QVGA.getSize();

		Composite composite = new Composite(qrcodePanel, SWT.EMBEDDED);
		composite.setBounds(0, 0, qrcodePanel.getBounds().width, qrcodePanel.getBounds().height);
		Frame frame = SWT_AWT.new_Frame(composite);

		JRootPane root = new JRootPane();
		frame.add(root);

		webcam = Webcam.getDefault();
		webcam.setViewSize(size);

		panel = new WebcamPanel(webcam, size, false);
		panel.setFPSDisplayed(true);

		root.getContentPane().add(panel);
	}

	public void start() {
		panel.start();
		executor.execute(this);
	}
	


	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "example-runner");
		t.setDaemon(true);
		return t;
	}
	
	@Override
	public void run() {

		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Result result = null;
			BufferedImage image = null;

			if (webcam.isOpen()) {
				if ((image = webcam.getImage()) == null) {
					continue;
				}
				
				if (stopDecoding) {
					continue;
				}

				LuminanceSource source = new BufferedImageLuminanceSource(image);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

				try {
					result = new MultiFormatReader().decode(bitmap);
				} catch (com.google.zxing.NotFoundException e) {
					// fall thru, it means there is no QR code in image
				}
			}

			if (result != null) {
				qrScanner.resultCallBack(result.getText());
			}

		} while (true);
	}

	public void close() {
		stopDecoding();
		webcam.close();
	}

	public void startDecoding() {
		stopDecoding = false;		
	}
	public void stopDecoding() {
		stopDecoding = true;		
	}
}