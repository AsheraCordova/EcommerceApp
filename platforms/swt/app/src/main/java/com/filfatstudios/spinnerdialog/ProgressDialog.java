package com.filfatstudios.spinnerdialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/**
 * Instances of this class are controls located on the top of a shell. They
 * display a dark panel on this shell
 */
public class ProgressDialog {
	private final Shell parent;
	private int alpha;
	private Shell panel;
	private Shell opaquePanel;
	private Canvas canvas;
	private Listener listener;
	private String title;
	private String message;
	private Composite progressBarContainer;

	/**
	 * Constructs a new instance of this class given its parent.
	 *
	 * @param shell   a shell that will be the parent of the new instance (cannot be
	 *                null)
	 * @param isFixed
	 * @param message
	 * @param title
	 * @exception IllegalArgumentException
	 *                                     <ul>
	 *                                     <li>ERROR_NULL_ARGUMENT - if the parent
	 *                                     is null</li>
	 *                                     </ul>
	 * @exception SWTException
	 *                                     <ul>
	 *                                     <li>ERROR_WIDGET_DISPOSED - if the parent
	 *                                     has been disposed</li>
	 *                                     <li>ERROR_THREAD_INVALID_ACCESS - if not
	 *                                     called from the thread that created the
	 *                                     parent</li>
	 *                                     </ul>
	 */
	public ProgressDialog(final Shell shell, String title, String message, boolean isFixed) {
		if (shell == null) {
			SWT.error(SWT.ERROR_NULL_ARGUMENT);
		}

		if (shell.isDisposed()) {
			SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		}

		parent = shell;
		alpha = 100;
		this.message = message;
		this.title = title;
	}

	/**
	 * Show the dark panel
	 */
	public void show() {
		if (parent.isDisposed()) {
			SWT.error(SWT.ERROR_WIDGET_DISPOSED);
		}

		// main transparent panel
		panel = new Shell(parent, SWT.NO_TRIM);
		panel.setLayout(new org.eclipse.nebula.widgets.layout.AbsoluteLayout());
		panel.setAlpha(alpha);
		panel.addListener(SWT.KeyUp, event -> {
			event.doit = false;
		});

		// progress bar panel
		opaquePanel = new Shell(parent, SWT.NO_TRIM);
		opaquePanel.setLayout(new org.eclipse.nebula.widgets.layout.AbsoluteLayout());
		this.progressBarContainer = createComposite();
		
		updateBounds();

		// create canvas
		createCanvas();
		
		parent.addListener(SWT.Move, this.listener);
		panel.open();
		opaquePanel.open();
	}

	private void createCanvas() {
		canvas = new Canvas(panel, SWT.NO_BACKGROUND | SWT.DOUBLE_BUFFERED);
		canvas.addPaintListener(event -> {
			paintCanvas(event);
		});

		canvas.setBounds(0, 0, panel.getBounds().width, panel.getBounds().height);
		this.listener = new Listener() {
			public void handleEvent(Event e) {
				updateBounds();
			}
		};
	}

	private Composite createComposite() {
		Composite composite = new Composite(opaquePanel, SWT.NONE);

		if (this.title != null) {
			final GridData messageData = new GridData(SWT.FILL, SWT.FILL, true, true);
			messageData.horizontalSpan = 2;
			Label label = new Label(composite, SWT.NONE);
			FontData fontData = label.getFont().getFontData()[0];
			Font font = new Font(Display.getDefault(),
					new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
			label.setFont(font);
			label.setText(this.title);
			label.setLayoutData(messageData);
		}

		final GridData progressBarData = new GridData(SWT.FILL, SWT.FILL, true, true);
		progressBarData.widthHint = 30;
		composite.setLayout(new GridLayout(2, false));
		ProgressBar progressBar = new ProgressBar(composite, SWT.INDETERMINATE);
		progressBar.setLayoutData(progressBarData);

		if (this.message != null) {
			final GridData messageData = new GridData(SWT.FILL, SWT.FILL, true, true);
			messageData.widthHint = com.ashera.widget.PluginInvoker.getScreenWidth() - 150;
			Label label = new Label(composite, SWT.NONE);
			label.setText(this.message);
			label.setLayoutData(messageData);
		}
		composite.pack();
		return composite;
	}

	private void updateBounds() {
		int y = parent.getBounds().height - parent.getClientArea().height;
		panel.setBounds(parent.getLocation().x + 10, parent.getLocation().y + y - 4,
				com.ashera.widget.PluginInvoker.getScreenWidth(), com.ashera.widget.PluginInvoker.getScreenHeight());
		
		int panelWidth = panel.getBounds().width;
		int panelHeight = panel.getBounds().height;
		opaquePanel.setBounds(panel.getLocation().x + (panelWidth - progressBarContainer.getBounds().width) / 2,
				panel.getLocation().y + (panelHeight - progressBarContainer.getBounds().height) / 2, progressBarContainer.getBounds().width, progressBarContainer.getBounds().height);
	}

	/**
	 * Paint the canvas that holds the panel
	 *
	 * @param e {@link PaintEvent}
	 */
	private void paintCanvas(final PaintEvent e) {
		// Paint the panel
		final Rectangle clientArea = ((Canvas) e.widget).getClientArea();
		final GC gc = e.gc;
		gc.setBackground(panel.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		gc.fillRectangle(clientArea);
	}

	/**
	 * Hide the dark panel
	 */
	public void hide() {
		if (parent.isDisposed()) {
			SWT.error(SWT.ERROR_WIDGET_DISPOSED);
		}

		if (panel == null || panel.isDisposed()) {
			return;
		}
		parent.removeListener(SWT.Move, this.listener);

		panel.dispose();
		opaquePanel.dispose();
	}

	/**
	 * @return the alpha value
	 */
	public int getAlpha() {
		return alpha;
	}

	/**
	 * @param alpha the alpha to set
	 */
	public void setAlpha(final int alpha) {
		this.alpha = alpha;
	}

}