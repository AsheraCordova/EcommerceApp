package com.ashera;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ResourcesSupplierGen extends com.ashera.codegen.CodeGenBase {
	public static void main(String[] args) throws Exception {
		StringBuffer buf = new StringBuffer();
		buf.append("start - body\n");

		String[] paths = { "src/main/resources/www/layout", "src/main/resources/font" };
		String[] prefix = { "www/layout/", "font/" };
		int i = 0;
		for (String path : paths) {
			File f = new java.io.File(path);
			String[] fileNames = f.list();

			if (fileNames != null) {
				for (String fileName : fileNames) {
					buf.append("\"").append(prefix[i]).append(fileName).append("\",\n");
				}
			}
			i++;
		}
		buf.append("//end - body");

		writeOrUpdateFile(buf.toString(), "src/main/java/com/ashera/ResourcesSupplier.java", "body");

		File f = new File("src/main/resources/res/xml/config.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(f);
		org.w3c.dom.NodeList nodeList = document.getElementsByTagName("param");
		buf = new StringBuffer();
		buf.append("start - body\n");
		for (int j = 0; j < nodeList.getLength(); j++) {
			Node node = nodeList.item(j);
			if ("android-package".equals(node.getAttributes().getNamedItem("name").getNodeValue())) {
				buf.append("System.out.println(" + node.getAttributes().getNamedItem("value").getNodeValue() + ".class.getName());\n");
			}
			
		}
		buf.append("//end - body");
		writeOrUpdateFile(buf.toString(), "src/main/java/com/ashera/Client.java", "body");
	}
}
