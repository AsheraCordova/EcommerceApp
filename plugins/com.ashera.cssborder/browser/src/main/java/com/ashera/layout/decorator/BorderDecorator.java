package com.ashera.layout.decorator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teavm.jso.dom.html.HTMLElement;

import com.ashera.layout.ViewImpl;
import com.ashera.widget.ILifeCycleDecorator;
import com.ashera.widget.IWidget;
import com.ashera.widget.WidgetAttribute;

import r.android.content.res.ColorStateList;
import r.android.view.View;

public class BorderDecorator implements ILifeCycleDecorator {
	//start - props
	@com.google.j2objc.annotations.Weak private IWidget widget;
	//end - props

	private HTMLElement htmlElement;
	private Map<String, r.android.content.res.ColorStateList> colorMap = new HashMap<>();
	private final static java.util.List<String> METHODS = new java.util.ArrayList<>();
	
	@Override
	public ILifeCycleDecorator newInstance(IWidget widget) {
		BorderDecorator borderDecorator = new BorderDecorator();
		borderDecorator.htmlElement = (HTMLElement) widget.asNativeWidget();
		borderDecorator.widget = widget;
		return borderDecorator;
	}
    //start - body

	public BorderDecorator() {
	}
	
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue) {
		String attributeName = key.getAttributeName();
		switch (attributeName) {
		case "borderWidth": {
			htmlElement.getStyle().setProperty("border-width", ((int) objValue) + "px");
		}
			break;
		case "borderColor": {
			
			setBorderColor(attributeName, "border-color", objValue);

		}
			break;
		case "borderStyle": {
			htmlElement.getStyle().setProperty("border-style", strValue);

		}
			break;
		case "borderDashWidth": {


		}
			break;
		case "borderDashSpacing": {


		}
		break;
		case "borderRadius": {

			htmlElement.getStyle().setProperty("border-radius", ((float) objValue) + "px");

		}
			break;
		case "borderTopWidth": {

			htmlElement.getStyle().setProperty("border-top-width", ((int) objValue) + "px");

		}
			break;
		case "borderTopColor": {
			setBorderColor(attributeName, "border-top-color", objValue);
		}
			break;
		case "borderTopStyle": {

			htmlElement.getStyle().setProperty("border-top-style", strValue);

		}
			break;
		case "borderTopDashWidth": {


		}
			break;
		case "borderTopDashSpacing": {


		}
			break;
		case "borderTopLeftRadius": {

			if (ViewImpl.isRTLLayout(widget)) {
				htmlElement.getStyle().setProperty("border-top-right-radius", ((float) objValue) + "px");
			} else {
				htmlElement.getStyle().setProperty("border-top-left-radius", ((float) objValue) + "px");
			}

		}
			break;
		case "borderTopRightRadius": {

			if (!ViewImpl.isRTLLayout(widget)) {
				htmlElement.getStyle().setProperty("border-top-right-radius", ((float) objValue) + "px");
			} else {
				htmlElement.getStyle().setProperty("border-top-left-radius", ((float) objValue) + "px");
			}

		}
			break;
		case "borderBottomWidth": {

			htmlElement.getStyle().setProperty("border-bottom-width", ((int) objValue) + "px");

		}
			break;
		case "borderBottomColor": {
			setBorderColor(attributeName, "border-bottom-color", objValue);

		}
			break;
		case "borderBottomStyle": {

			htmlElement.getStyle().setProperty("border-bottom-style", strValue);

		}
			break;
		case "borderBottomDashWidth": {

		}
			break;
		case "borderBottomDashSpacing": {

		}
			break;
		case "borderBottomLeftRadius": {

			if (ViewImpl.isRTLLayout(widget)) {
				htmlElement.getStyle().setProperty("border-bottom-right-radius", ((float) objValue) + "px");
			} else {
				htmlElement.getStyle().setProperty("border-bottom-left-radius", ((float) objValue) + "px");
			}

		}
			break;
		case "borderBottomRightRadius": {

			if (!ViewImpl.isRTLLayout(widget)) {
				htmlElement.getStyle().setProperty("border-bottom-right-radius", ((float) objValue) + "px");
			} else {
				htmlElement.getStyle().setProperty("border-bottom-left-radius", ((float) objValue) + "px");
			}

		}
			break;
		case "borderLeftWidth": {
			if (ViewImpl.isRTLLayout(widget)) {
				htmlElement.getStyle().setProperty("border-right-width", ((int) objValue) + "px");
			} else {
				htmlElement.getStyle().setProperty("border-left-width", ((int) objValue) + "px");
			}

		}
			break;
		case "borderLeftColor": {
			if (ViewImpl.isRTLLayout(widget)) {
				setBorderColor(attributeName, "border-right-color", objValue);
			} else {
				setBorderColor(attributeName, "border-left-color", objValue);
			}

		}
			break;
		case "borderLeftStyle": {
			if (ViewImpl.isRTLLayout(widget)) {
				htmlElement.getStyle().setProperty("border-right-style", strValue);
			} else {
				htmlElement.getStyle().setProperty("border-left-style", strValue);
			}

		}
			break;
		case "borderLeftDashWidth": {


		}
			break;
		case "borderLeftDashSpacing": {


		}
			break;
		case "borderRightWidth": {
			if (!ViewImpl.isRTLLayout(widget)) {
				htmlElement.getStyle().setProperty("border-right-width", ((int) objValue) + "px");
			} else {
				htmlElement.getStyle().setProperty("border-left-width", ((int) objValue) + "px");
			}

		}
			break;
		case "borderRightColor": {
			if (!ViewImpl.isRTLLayout(widget)) {
				setBorderColor(attributeName, "border-right-color", objValue);
			} else {
				setBorderColor(attributeName, "border-left-color", objValue);
			}

		

		}
			break;
		case "borderRightStyle": {

			if (!ViewImpl.isRTLLayout(widget)) {
				htmlElement.getStyle().setProperty("border-right-style", strValue);
			} else {
				htmlElement.getStyle().setProperty("border-left-style", strValue);
			}

		}
			break;
		case "borderRightDashWidth": {

		}
			break;
		case "borderRightDashSpacing": {

		}
			break;
		}
		
		updateBorderStyle();
	}

	private void updateBorderStyle() {
		if (!isPropertySet("border-style") && (isPropertySet("border-color") || isPropertySet("border-width") || isPropertySet("border-radius"))) {
			if (!isPropertySet("border-bottom-style")) {
				htmlElement.getStyle().setProperty("border-bottom-style", "solid");
			}
			
			if (!isPropertySet("border-top-style")) {
				htmlElement.getStyle().setProperty("border-top-style", "solid");
			}
			
			if (!isPropertySet("border-left-style")) {
				htmlElement.getStyle().setProperty("border-left-style", "solid");
			}
			
			if (!isPropertySet("border-right-style")) {
				htmlElement.getStyle().setProperty("border-right-style", "solid");
			}
		}
		
		if (!isPropertySet("border-bottom-style") && (isPropertySet("border-bottom-color") || isPropertySet("border-bottom-width") || isPropertySet("border-bottom-radius"))) {
			htmlElement.getStyle().setProperty("border-bottom-style", "solid");
		}
		
		if (!isPropertySet("border-top-style") && (isPropertySet("border-top-color") || isPropertySet("border-top-width") || isPropertySet("border-top-radius"))) {
			htmlElement.getStyle().setProperty("border-top-style", "solid");
		}
		
		if (!isPropertySet("border-left-style") && (isPropertySet("border-left-color") || isPropertySet("border-left-width") || isPropertySet("border-left-radius"))) {
			htmlElement.getStyle().setProperty("border-left-style", "solid");
		}
		
		if (!isPropertySet("border-right-style") && (isPropertySet("border-right-color") || isPropertySet("border-right-width") || isPropertySet("border-right-radius"))) {
			htmlElement.getStyle().setProperty("border-right-style", "solid");
		}
	}

	private boolean isPropertySet(String property) {
		String propertyValue = htmlElement.getStyle().getPropertyValue(property);
		return propertyValue != null && !propertyValue.isEmpty();
	}

	private void setBorderColor(String attributeName, String property, Object objValue) {
		if (objValue instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
			View view = (View) widget.asWidget();
			objValue = colorStateList.getColorForState(view.getDrawableState(), r.android.graphics.Color.RED);
			colorMap.put(attributeName, colorStateList);
		}
		
		htmlElement.getStyle().setProperty(property, (String) ViewImpl.getColor(objValue));
	}

	@Override
	public Object getAttribute(WidgetAttribute widgetAttribute) {
		switch (widgetAttribute.getAttributeName()) {
		case "borderTopWidth": {
			return ViewImpl.getPropertyValueAsInt(htmlElement, "border-top-width");
		}
		case "borderTopColor": {
			return colorMap.get("borderTopColor");
		}
		case "borderTopStyle": {
			return htmlElement.getStyle().getPropertyValue("border-top-style");

		}
		case "borderTopDashWidth": {
			return 0;
		}
		case "borderTopDashSpacing": {
			return 0;

		}
		case "borderTopLeftRadius": {
			if (ViewImpl.isRTLLayout(widget)) {
				return ViewImpl.getPropertyValueAsFloat(htmlElement, "border-top-right-radius");
			}
			return ViewImpl.getPropertyValueAsFloat(htmlElement, "border-top-left-radius");
		}
		case "borderTopRightRadius": {
			if (!ViewImpl.isRTLLayout(widget)) {
				return ViewImpl.getPropertyValueAsFloat(htmlElement, "border-top-right-radius");
			}
			return ViewImpl.getPropertyValueAsFloat(htmlElement, "border-top-left-radius");
		}

		case "borderBottomWidth": {
			return ViewImpl.getPropertyValueAsInt(htmlElement, "border-bottom-width");
		}
		case "borderBottomColor": {
			return colorMap.get("borderBottomColor");
		}
		case "borderBottomStyle": {
			return htmlElement.getStyle().getPropertyValue("border-bottom-style");

		}
		case "borderBottomDashWidth": {
			return 0;
		}
		case "borderBottomDashSpacing": {
			return 0;

		}
		case "borderBottomLeftRadius": {
			if (ViewImpl.isRTLLayout(widget)) {
				return ViewImpl.getPropertyValueAsFloat(htmlElement, "border-bottom-right-radius");
			}
			return ViewImpl.getPropertyValueAsFloat(htmlElement, "border-bottom-left-radius");
		}
		case "borderBottomRightRadius": {
			if (!ViewImpl.isRTLLayout(widget)) {
				return ViewImpl.getPropertyValueAsFloat(htmlElement, "border-bottom-right-radius");
			}
			return ViewImpl.getPropertyValueAsFloat(htmlElement, "border-bottom-left-radius");
		}
		case "borderLeftWidth": {
			if (ViewImpl.isRTLLayout(widget)) {
				return ViewImpl.getPropertyValueAsInt(htmlElement, "border-right-width");
			}
			return ViewImpl.getPropertyValueAsInt(htmlElement, "border-left-width");
		}
		case "borderLeftColor": {
			if (ViewImpl.isRTLLayout(widget)) {
				return colorMap.get("borderRightColor");
			}
			return colorMap.get("borderLeftColor");
		}
		case "borderLeftStyle": {
			if (ViewImpl.isRTLLayout(widget)) {
				return htmlElement.getStyle().getPropertyValue("border-right-style");
			}
			return htmlElement.getStyle().getPropertyValue("border-left-style");

		}
		case "borderLeftDashWidth": {
			return 0;
		}
		case "borderLeftDashSpacing": {
			return 0;

		}
		case "borderRightWidth": {
			if (!ViewImpl.isRTLLayout(widget)) {
				return ViewImpl.getPropertyValueAsInt(htmlElement, "border-right-width");
			}
			return ViewImpl.getPropertyValueAsInt(htmlElement, "border-left-width");
		}
		case "borderRightColor": {
			if (!ViewImpl.isRTLLayout(widget)) {
				return colorMap.get("borderRightColor");
			}
			return colorMap.get("borderLeftColor");
		}
		case "borderRightStyle": {
			if (!ViewImpl.isRTLLayout(widget)) {
				return htmlElement.getStyle().getPropertyValue("border-right-style");
			}
			return htmlElement.getStyle().getPropertyValue("border-left-style");

		}
		case "borderRightDashWidth": {
			return 0;
		}
		case "borderRightDashSpacing": {
			return 0;

		}
		}
		return null;
	}

	@Override
	public List<String> getMethods() {
		return METHODS;
	}

	//end - body


	@Override
	public void drawableStateChanged() {
		ColorStateList color = colorMap.get("borderColor");
		
		if (isBorderStateful(color)) {
			setBorderColor("borderColor", "border-color", color);
		}
		
		color = colorMap.get("borderBottomColor");
		if (isBorderStateful(color)) {
			setBorderColor("borderBottomColor", "border-bottom-color", color);
		}
		
		color = colorMap.get("borderTopColor");
		if (isBorderStateful(color)) {
			setBorderColor("borderTopColor", "border-top-color", color);
		}
		
		color = colorMap.get("borderLeftColor");
		if (isBorderStateful(color)) {
			setBorderColor("borderLeftColor", "border-left-color", color);
		}
		
		color = colorMap.get("borderRightColor");
		if (isBorderStateful(color)) {
			setBorderColor("borderRightColor", "border-right-color", color);
		}
	}

	private boolean isBorderStateful(r.android.content.res.ColorStateList color) {
		return color != null && color instanceof r.android.content.res.ColorStateList 
				&& ((r.android.content.res.ColorStateList)color).isStateful();
	}

	@Override
	public void execute(String method, Object... params) {
	}

	@Override
	public void initialized() {
		
	}
	
}
