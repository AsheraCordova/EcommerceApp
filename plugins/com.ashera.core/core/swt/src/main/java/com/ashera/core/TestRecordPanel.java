package com.ashera.core;

import java.io.File;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ashera.model.TestCase;
import com.google.gson.Gson;


public class TestRecordPanel implements com.ashera.plugin.IPlugin {
    enum TestcaseValue {
        pass, fail, unknown, quirk, child, notsure, notsupported
    }
    private String attributeName;
    private Button saveButton;
    private Group attrInfo;
    private Gson gson = new Gson();
    private TestCase testCaseDto = new TestCase();
    private File jsonFile;
    private Text descText;
    private Button unknown;
    private Button pass;
    private Button passwithQuirk;
    private Button fail; 
    private Button implementedByChildWidget;
    private Button notsure;
    private Button notsupported;
	private Combo enviromentUnderTest;
	private String widgetUnderTest;
    @Override
    public String getName() {
        return null;
    }
    @Override
    public Object invoke(String name, Object... args) {
        switch (name) {
        case "setAttr":
            String widgetNameWithattributeName = (String) args[1];
            String[] arr = widgetNameWithattributeName.split(",");
			setAttr((String) arr[0], arr[1]);
            break;

        default:
            break;
        }
        return null;
    }

    

    public void setAttr(String widgetUnderTest, String attributeName) {
    	this.widgetUnderTest = widgetUnderTest;
        this.attributeName = attributeName;
        saveButton.setEnabled(widgetUnderTest != null);
        attrInfo.setText(enviromentUnderTest.getText() + " - " + attributeName);
        File myFile = new File("../../core-widget_library/code_generator/testcasedata/" + widgetUnderTest + enviromentUnderTest.getText() + ".json");
        myFile.getParentFile().mkdir();
        if (jsonFile == null || !jsonFile.getAbsolutePath().toString().equals(myFile.getAbsolutePath().toString())) {
            jsonFile = myFile;
            try {
                if (jsonFile.exists()) {
                    testCaseDto = gson.fromJson(new java.io.FileReader(jsonFile), TestCase.class);
                    if (testCaseDto == null) {
                        testCaseDto = new TestCase();
                    }
                } else {
                    testCaseDto = new TestCase();
                    jsonFile.createNewFile();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        
        HashMap<String, String> testCaseData = testCaseDto.getTestCaseData();
        String testcaseStatus = testCaseData.get(attributeName);
        String testcaseDesc = testCaseData.get(attributeName + "Desc");
        if (testcaseDesc == null) {
            testcaseDesc = "";
        }
        descText.setText(testcaseDesc);
        unknown.setSelection(false);
        pass.setSelection(false);
        passwithQuirk.setSelection(false);
        fail.setSelection(false);
        implementedByChildWidget.setSelection(false);
        notsupported.setSelection(false);
        notsure.setSelection(false);

        if (testcaseStatus != null) {
            if (testcaseStatus.equals(TestcaseValue.pass.toString())) {
                pass.setSelection(true);
            } else if (testcaseStatus.equals(TestcaseValue.fail.toString())) {
                fail.setSelection(true);
            } else if (testcaseStatus.equals(TestcaseValue.quirk.toString())) {
                passwithQuirk.setSelection(true);
            } else if (testcaseStatus.equals(TestcaseValue.child.toString())) {
                implementedByChildWidget.setSelection(true);
            } else if (testcaseStatus.equals(TestcaseValue.notsure.toString())) {
            	notsure.setSelection(true);
            } else if (testcaseStatus.equals(TestcaseValue.notsupported.toString())) { 
            	notsupported.setSelection(true);
            } else {
                unknown.setSelection(true);
            }
            
        } else {
            unknown.setSelection(true);
        }

    }
    public Shell createPanel(Shell shell, MainActivity mainActivity) {
        Shell controlPanel = new Shell(shell, SWT.CLOSE);
        controlPanel.setData(this);

        controlPanel.setBounds(shell.getBounds().x + shell.getBounds().width + 20, shell.getBounds().y + 70, shell.getBounds().width, shell.getBounds().height);
        
        
        this.attrInfo = new Group(controlPanel, SWT.NULL);
//        attrInfo.setText(PreferenceWrapper.getEnvUnderTest());

        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        attrInfo.setLayout(gridLayout);

        GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 1;
        attrInfo.setLayoutData(gridData);
        
        this.enviromentUnderTest = new Combo(attrInfo, SWT.READ_ONLY);
        enviromentUnderTest.setBounds(50, 50, 150, 65);
        String items[] = { "android", "ios", "swt", "web"};
        enviromentUnderTest.setItems(items);
        enviromentUnderTest.setText(PreferenceWrapper.getEnvUnderTest());
        enviromentUnderTest.addModifyListener(new org.eclipse.swt.events.ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				PreferenceWrapper.saveEnvUnderTest(enviromentUnderTest.getText());
				if (attributeName != null && widgetUnderTest != null) {
					setAttr(widgetUnderTest, attributeName);
				}
				if (attributeName != null) {
					attrInfo.setText(PreferenceWrapper.getEnvUnderTest() +  " - " + attributeName);
				}
			}
        	
        });
        

        this.unknown = new Button(attrInfo, SWT.RADIO);
        unknown.setText("Unknown");        
        this.pass = new Button(attrInfo, SWT.RADIO);
        pass.setText("Pass");
        this.passwithQuirk = new Button(attrInfo, SWT.RADIO);
        passwithQuirk.setText("Pass With Quirk");
        
        this.fail = new Button(attrInfo, SWT.RADIO);
        fail.setText("Fail");

        this.notsure = new Button(attrInfo, SWT.RADIO);
        notsure.setText("Not sure on how to test");
        
        this.implementedByChildWidget = new Button(attrInfo, SWT.RADIO);
        implementedByChildWidget.setText("Implemented By Child Widget");
        
        this.notsupported = new Button(attrInfo, SWT.RADIO);
        notsupported.setText("Not Supported");
        
        new Label(attrInfo, SWT.NONE).setText("Description");;
        this.descText = new Text(attrInfo, SWT.MULTI | SWT.BORDER | SWT.WRAP);
        descText.setLayoutData(new GridData(300, 100));
        controlPanel.setLayout(new GridLayout(1, false));
        
        this.saveButton = new Button(attrInfo, SWT.PUSH | SWT.FILL);
        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addListener(SWT.MouseDown, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                TestcaseValue selection = TestcaseValue.unknown;
                if (pass.getSelection()) {
                    selection = TestcaseValue.pass;
                }
                
                if (passwithQuirk.getSelection()) {
                    selection = TestcaseValue.quirk;
                }
                
                if (fail.getSelection()) {
                    selection = TestcaseValue.fail;
                }
                
                if (implementedByChildWidget.getSelection()) {
                    selection = TestcaseValue.child;
                }
                
                if (notsure.getSelection()) {
                    selection = TestcaseValue.notsure;
                }
                
                if (notsupported.getSelection()) {
                    selection = TestcaseValue.notsupported;
                }
                
                String desc = descText.getText();
                HashMap<String, String> testCaseData = testCaseDto.getTestCaseData();
                testCaseData.put(attributeName, selection.toString());
                testCaseData.put(attributeName + "Desc", desc);
                System.out.println(jsonFile.getAbsolutePath());
                try (java.io.FileWriter f = new java.io.FileWriter(jsonFile)) {
                    f.write(gson.toJson(testCaseDto));
                } catch (Exception e) {
                    throw new RuntimeException(e);                    
                }
            }           
        });
        controlPanel.pack();
        return controlPanel;
    }
}
