package com.ashera.core;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import com.ashera.core.MainActivity;

public class CommandPanel {
    public Shell createControlPanel(Shell shell, MainActivity mainActivity) {
        Shell controlPanel = new Shell(shell, SWT.CLOSE);
        
        controlPanel.setBounds(shell.getBounds().x + shell.getBounds().width + 20, shell.getBounds().y, shell.getBounds().width, shell.getBounds().height);
        
        Button backButton = new Button(controlPanel, SWT.PUSH);
        backButton.setText("Back");     
        backButton.addListener(SWT.MouseDown, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                mainActivity.getFragmentManager().popBackStack();
            }           
        });

        FillLayout fillLayout = new FillLayout();        
        fillLayout.type = SWT.VERTICAL;
        controlPanel.setLayout(fillLayout);
        controlPanel.pack();
        
        return controlPanel;
    }

}
