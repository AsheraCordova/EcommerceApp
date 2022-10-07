package com.ashera;

import org.teavm.classlib.ResourceSupplier;
import org.teavm.classlib.ResourceSupplierContext;

public class ResourcesSupplier implements ResourceSupplier {
	@Override
	public String[] supplyResources(ResourceSupplierContext context) {
		String[] result = { "www/css/styles.css", "res/xml/config.xml",
				//start - body
				//end - body
		};
		return result;
	}
}