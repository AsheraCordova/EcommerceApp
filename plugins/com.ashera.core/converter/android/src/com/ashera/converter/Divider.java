package com.ashera.converter;

import java.util.HashMap;
import java.util.Map;

import com.ashera.converter.AbstractEnumToIntConverter;

public class Divider extends AbstractEnumToIntConverter {
	private Map<String, Integer> mapping = new HashMap<>();
	{
		mapping.put("beginning", 0x1);
		mapping.put("middle", 0x2);
		mapping.put("end", 0x4);
		mapping.put("none", 0x0);
	}

	@Override
	public Map<String, Integer> getMapping() {
		return mapping;
	}

	@Override
	public Integer getDefault() {
		return 0;
	}
}
