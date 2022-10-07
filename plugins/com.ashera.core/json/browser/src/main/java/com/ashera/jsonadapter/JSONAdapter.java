package com.ashera.jsonadapter;

import java.util.List;
import java.util.Map;

public interface JSONAdapter {
	public Map<String, Object> getMap(Object payLoad);
	public Object getNativeMap(Map<String, Object> payLoad);
	public void putJSONSafeObjectIntoMap(Map<String, Object> map, String key, Object value);
	public Object[] getArray(Object payLoad);
	public List<Object> getList(Object payLoad);
	public boolean isBoolean(Object obj);
	public Boolean getBoolean(Object payLoad);
	public String getString(Object object);
	public Integer getInt(Object object);
	public Float getFloat(Object object);
	public Double getDouble(Object object);
	public String marshal(Object object);
	public Object toJsonTree(Object object);
	public <T> T unmarshal(String json, Class<T> clazz);
	public Map<String, Object> getJSONCompatMap();
	Object getJSONSafeObj(Object obj);
}
