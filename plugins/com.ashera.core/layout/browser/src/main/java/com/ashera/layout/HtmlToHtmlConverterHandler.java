package com.ashera.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.ashera.core.IFragment;
import com.ashera.css.CssTree.Attribute;
import com.ashera.parser.css.CssDataHolder;
import com.ashera.parser.css.CssResult;
import com.ashera.widget.PluginInvoker;

public class HtmlToHtmlConverterHandler implements ContentHandler {
	private Stack<HTMLElement> elements = new Stack<>();
	private List<HTMLElement> roots = new ArrayList<>();
	public List<HTMLElement> getRoots() {
		return roots;
	}

	private IFragment fragment;
	private CssDataHolder pageData;
	private Map<String, Object> htmlConfig;
    public HtmlToHtmlConverterHandler(Map<String, Object> htmlConfig, IFragment fragment) {
        this.fragment = fragment;
        pageData = (CssDataHolder) fragment.getStyleSheet();
        
        this.htmlConfig = htmlConfig;
        
        if (this.htmlConfig == null) {
        	//to avoid npe
        	this.htmlConfig = new java.util.HashMap<>(0);
        }
    }
	@Override
	public void setDocumentLocator(Locator locator) {
		
	}

	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		
	}


	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		
	}
	
	private Object quickConvert(String name, String value) {
		Object objcolor = PluginInvoker.convertFrom(PluginInvoker.getConverter(name), null, value, fragment);
		return objcolor;
	}


	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		localName = localName.toLowerCase();
		if (localName.equals("body") || localName.equals("html")) {
    		return;
    	}
		HTMLElement currentElement = HTMLDocument.current().createElement(localName);
		if (elements.size() == 0) {
			roots.add(currentElement);
		} else {
			elements.peek().appendChild(currentElement);
		}
		final String myName = localName;
		pageData.getCss(localName, atts.getValue("class"), atts.getValue("id"), new CssResult() {
			@Override
			public void put(String key, Attribute value) {
				applyStyle(currentElement, myName, key, value.value);
			}
		});
		
		for (int i = 0; i < atts.getLength(); i++) {
			String key = atts.getLocalName(i);
			String value = atts.getValue(key);
			applyStyle(currentElement, localName, key, value);
			
		}
		
		if (localName.equals("br") || localName.equals("img")) {
			return;
		}
		elements.push(currentElement);
	}

	private void applyStyle(HTMLElement currentElement, String localName, String key, String value) {
		if (localName.equals("a")) {
			Object textColorLink = htmlConfig.get("textColorLink");
			if (textColorLink != null) {
				currentElement.getStyle().setProperty("color", (String) textColorLink);
			}
		}
		
		
		switch (key) {
		case "color":
		case "textColor":{
			Object objcolor = quickConvert("color", value);
			currentElement.getStyle().setProperty("color", (String) objcolor);
		}
		break;
		
		case "background-color":
		case "background":{
			Object objcolor = quickConvert("color", value);
			if (!localName.equals("div")) {
				currentElement.getStyle().setProperty("background-color", (String) objcolor);	
			}
		}
		break;
		
		// text alignment
		case "textAlignment": {
			String textAlign = value;
			String align = "left";
			switch (textAlign) {
			case "center":
				align = "center";
				break;
			case "textEnd":
			case "viewEnd":
				align = "right";
				break;
			case "textStart":
			case "viewStart":
				align = "left";
				break;	
			default:
				break;
			}
			currentElement.getStyle().setProperty("text-align", align);
		}
		break;
		case "gravity": {
			String gravity = value + "|";

			String align = "left";
			if (gravity.contains("center|") || gravity.contains("center_horizontal|")) {
				align = "center";
			}
			
			if (gravity.contains("right|") || gravity.contains("end|")) {
				align = "right";
			}
			
			currentElement.getStyle().setProperty("text-align", align);
		}
		break;
		case "text-align": {
			currentElement.getStyle().setProperty("text-align", value);
		}
		break;

		case "vertical-align": {
			currentElement.getStyle().setProperty("vertical-align", value);
		}
		break;
		
		// apply font attributes
		case "font-family":
		case "fontFamily":{
			Map<String, com.ashera.model.FontDescriptor> fontDescriptors = (Map<String, com.ashera.model.FontDescriptor>) quickConvert("font", value);
			String weight = "400";
		    String fontStyle = "normal";
		    com.ashera.model.FontDescriptor fontDescriptor = fontDescriptors.get(fontStyle + "_" + weight);
		    currentElement.getStyle().setProperty("font-family", fontDescriptor.getName());
		}
		break;
		
		case "font-size":
		case "textSize":{
			float textSize = (float) quickConvert("dimensionsp", value); 
			textSize = fragment.getRootActivity().getScaleFactor() * textSize;
			currentElement.getStyle().setProperty("font-size", textSize + "px");
		}
		break;
		case "textStyle": {
			String textStyle = value + "|";
			if (textStyle.contains("bold|")) {
				currentElement.getStyle().setProperty("font-weight", "bold");
			}
			
			if (textStyle.contains("italics|")) {
				currentElement.getStyle().setProperty("font-style", "italics");
			}
		}
		break;
		case "font-weight": {
			currentElement.getStyle().setProperty("font-weight", value);
		}
		break;
		
		case "font-style": {
			currentElement.getStyle().setProperty("font-weight", value);
		}
		break;
		
		// others
		case "text-decoration": {
			if (value.equals("underline")) {
				currentElement.getStyle().setProperty("text-decoration", value);
			} else if (value.equals("line-through")) {
				currentElement.getStyle().setProperty("line-through", value);
			}
		}
		break;

		case "line-height": 
		case "lineHeight": {
			Float lineHeight = (Float) quickConvert("dimensionfloat", value);
			currentElement.getStyle().setProperty("line-height", lineHeight + "px");
		}
		break;
		case "src":
			r.android.graphics.drawable.Drawable image = (r.android.graphics.drawable.Drawable) quickConvert("drawable",  value);
			currentElement.getStyle().setProperty("width", image.getMinimumWidth() + "px");
			currentElement.getStyle().setProperty("height", image.getMinimumHeight() + "px");
			currentElement.setAttribute(key, (String) image.getDrawable());
			break;
		case "class":
			break;
		default:
			currentElement.setAttribute(key, value);
			break;
		}
	}


	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		localName = localName.toLowerCase();
		if (localName.equals("body") || localName.equals("html") || localName.equals("br") || localName.equals("img")) {
    		return;
    	}
		elements.pop();
		
	}
	
	@org.teavm.jso.JSBody(params = { "element" }, script = "return !element;")
    private static native boolean isNull(org.teavm.jso.dom.html.HTMLElement element);

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		HTMLElement element = elements.peek();
		
		if (isNull(element)) {
			element = org.teavm.jso.dom.html.HTMLDocument.current().createElement("span");
			if (elements.size() == 0) {
				roots.add(element);
			}
			elements.push(element);
		}
		
		try {
			StringBuilder text = new StringBuilder();
	
	    	String str = new String(ch, start,length);
	    	Object textAllCaps = htmlConfig.get("textAllCaps");
			if (textAllCaps != null &&  (boolean) textAllCaps) {
				str = str.toUpperCase();
	    	}
	
	    	String[] arr = str.split("\n");
			Object password = htmlConfig.get("password");
	
	    	for (String splitStr : arr) {
	    		if (password != null &&  (boolean) password) {
	    			String result = "";
	    			for (int i = 0; i < splitStr.length(); i++) {
	    				result += "*";
	    			}
	    			splitStr = result;
	        	}
	    		text = text.append(splitStr/*.trim()*/);
			}	
			element.setInnerHTML(element.getInnerHTML() + text.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
