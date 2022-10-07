package com.ashera.core;

import java.io.File;
import java.util.List;

import org.eclipse.nebula.widgets.layout.AbsoluteLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import com.ashera.common.OperatingSystem;
import com.ashera.utils.FileUtils;

public abstract class BaseApplication  {
	private MainActivity mainActivity;
	private CommandPanel commandPanel;
	private TestRecordPanel testRecordPanel;
	public BaseApplication() {
	    commandPanel = new CommandPanel();
	    testRecordPanel = new TestRecordPanel();
	}

	public Shell start(Display display, int style) {
	    Shell shell = new Shell(display, style);
	    shell.setBounds(0, 0, PreferenceWrapper.getCurrentWidth(), PreferenceWrapper.getDefaultHeight());
	    shell.setBackgroundMode(SWT.INHERIT_FORCE);
	    
	    // load fonts
	    List<File> fontfiles = FileUtils.getFilenamesForDirnameFromCP("www/res/font");
	    for (File file : fontfiles) {
	    	if (!file.getName().endsWith("xml") && !file.getName().endsWith("properties")) {
	    	    if (!file.getName().endsWith(".xml")) {
	                if (display.loadFont(file.getAbsolutePath())) {
	                    System.out.println("loaded " + file.getAbsolutePath());
	                } else {
	                    System.out.println("failed " + file.getAbsolutePath());
	                }
	    	    }
	    	}
        }
	    
        Browser browser = new Browser(shell, SWT.NONE);
        browser.setBounds(0, 0, 0, 0);
        browser.setLayout(new AbsoluteLayout());

        final Composite contentPanel = new Composite(shell, SWT.BORDER);
	    final StackLayout layout = new StackLayout();
	    contentPanel.setLayout(layout);
	    contentPanel.setBounds(0, 0, PreferenceWrapper.getCurrentWidth(), PreferenceWrapper.getDefaultHeight());
	    this.mainActivity = new MainActivity(browser, layout, contentPanel);
	    this.mainActivity.onCreate(new r.android.os.Bundle());
	    
        Shell controlPanel = commandPanel.createControlPanel(shell, mainActivity);
        Shell testRecordShell = testRecordPanel.createPanel(shell, mainActivity); 
        
		shell.addShellListener(new ShellListener() {
			public void shellActivated(ShellEvent event) {
			}

			public void shellClosed(ShellEvent arg0) {
			}

			public void shellDeactivated(ShellEvent arg0) {
			}

			public void shellDeiconified(ShellEvent arg0) {
				mainActivity.getFragmentManager().getActiveFragment().onResume();
			}

			public void shellIconified(ShellEvent arg0) {
				mainActivity.getFragmentManager().getActiveFragment().onPause();
			}
		});
        shell.addListener(SWT.Resize, new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (OperatingSystem.isWindows()) {
                    controlPanel.setBounds(shell.getBounds().x + shell.getBounds().width + 20, shell.getBounds().y, controlPanel.getBounds().width, controlPanel.getBounds().height);
                }

                if (mainActivity != null && mainActivity.getFragmentManager() != null &&  mainActivity.getFragmentManager().getActiveFragment() != null) {
                    if (shell.getClientArea().height > 0 && shell.getClientArea().width > 0) {
                        PreferenceWrapper.saveSize(shell.getBounds().width, shell.getBounds().height);
                        shell.setBounds(shell.getBounds().x, shell.getBounds().y, PreferenceWrapper.getCurrentWidth(), PreferenceWrapper.getDefaultHeight());
                        contentPanel.setBounds(0, 0, PreferenceWrapper.getCurrentWidth(), PreferenceWrapper.getDefaultHeight());
                        mainActivity.getFragmentManager().getActiveFragment().remeasure();
                    }
                }
            }
        });
        
        if (OperatingSystem.isWindows()) {
            shell.addListener(SWT.Move, new Listener() {
                public void handleEvent(Event e) {
                    controlPanel.setBounds(shell.getBounds().x + shell.getBounds().width + 20, shell.getBounds().y, controlPanel.getBounds().width, controlPanel.getBounds().height);
                    testRecordShell.setBounds(shell.getBounds().x + shell.getBounds().width + 20, controlPanel.getBounds().height + controlPanel.getBounds().y + 20, testRecordShell.getBounds().width, testRecordShell.getBounds().height);
                }
            });
        }

//        Button button = new Button(shell, SWT.PUSH);
//        button.setBounds(0, 0, 0, 0);
//        button.setText("Install");
//        button.addSelectionListener(new SelectionAdapter() {
//            public void widgetSelected(SelectionEvent e) {
//                browser.setUrl("javascript:(function(F,i,r,e,b,u,g,L,I,T,E){if(F.getElementById(b))return;E=F[i+'NS']&&F.documentElement.namespaceURI;E=E?F[i+'NS'](E,'script'):F[i]('script');E[r]('id',b);E[r]('src',I+g+T);E[r](b,u);(F[e]('head')[0]||F[e]('body')[0]).appendChild(E);E=new%20Image;E[r]('src',I+L);})(document,'createElement','setAttribute','getElementsByTagName','FirebugLite','4','firebug-lite.js','releases/lite/latest/skin/xp/sprite.png','https://getfirebug.com/','#startOpened');");
//            }
//        });
//        button.moveAbove(contentPanel);
	    if (isTestPanelEnabled()) {
	    	testRecordShell.open();
	    }
	    if (isControlPanelEnabled()) {
	    	controlPanel.open();
	    }
		shell.open();


		shell.addListener(SWT.Close, new Listener() {
            @Override
            public void handleEvent(Event event) {
                display.dispose();
                System.exit(0);
            }
        });
		return shell;
	}

	public boolean isControlPanelEnabled() {
		return true;
	}

	public boolean isTestPanelEnabled() {
		return true;
	}
}