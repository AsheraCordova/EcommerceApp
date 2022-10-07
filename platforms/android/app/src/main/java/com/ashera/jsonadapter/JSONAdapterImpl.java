package com.ashera.jsonadapter;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.ashera.plugin.IPlugin;
import com.google.gson.Gson;

public class JSONAdapterImpl implements JSONAdapter, IPlugin {
	@Override
	public Object invoke(String name, Object... args) {
		//start - jsonadapter
		switch (name) {
		case "getMap":
			return getMap((Object) args[0]);
		case "getNativeMap":
			return getNativeMap((Map<String,Object>) args[0]);
		case "putJSONSafeObjectIntoMap":
			putJSONSafeObjectIntoMap((Map<String,Object>) args[0],(String) args[1],(Object) args[2]);
			return null;
		case "getArray":
			return getArray((Object) args[0]);
		case "getList":
			return getList((Object) args[0]);
		case "isBoolean":
			return isBoolean((Object) args[0]);
		case "getBoolean":
			return getBoolean((Object) args[0]);
		case "getString":
			return getString((Object) args[0]);
		case "getInt":
			return getInt((Object) args[0]);
		case "getFloat":
			return getFloat((Object) args[0]);
		case "getDouble":
			return getDouble((Object) args[0]);
		case "marshal":
			return marshal((Object) args[0]);
		case "toJsonTree":
			return toJsonTree((Object) args[0]);
		case "unmarshal":
			return unmarshal((String) args[0],(Class) args[1]);
		case "getJSONCompatMap":
			return getJSONCompatMap();
		case "getJSONSafeObj":
			return getJSONSafeObj((Object) args[0]);
		default:
			break;
		}
		throw new RuntimeException("Unknown method " + name);
		//end - jsonadapter
	}

	//start - body
	//start - web
	@Override
	public Map<String, Object> getMap(Object payLoad) {
		if (payLoad instanceof Map) {
			return (Map<String, Object>) payLoad;
		}
		return null;
	}

	@Override
	public Object[] getArray(Object payLoad) {
		return ((List<Object>) payLoad).toArray();
	}

	@Override
	public List<Object> getList(Object payLoad) {
		if (payLoad instanceof List) {
			return (List<Object>) payLoad;
		}
		return null;
	}

	@Override
	public Boolean getBoolean(Object payLoad) {
		if (payLoad instanceof Boolean) {
			return (Boolean) payLoad;
		}
		if (payLoad instanceof String) {
			return Boolean.valueOf((String) payLoad);
		}
		return Boolean.FALSE;
	}

	@Override
	public String getString(Object object) {
		if (object instanceof String) {
			return (String) object;
		}

		if (object instanceof Double) {
			Double doubleVar = (Double) object;
			if (doubleVar.doubleValue() == doubleVar.intValue()) {
			    return String.valueOf(doubleVar.intValue());
			}
            return String.valueOf(doubleVar.doubleValue());
		}
		
		if (object instanceof Float) {
			Float doubleVar = (Float) object;
			if (doubleVar.floatValue() == doubleVar.intValue()) {
			    return String.valueOf(doubleVar.intValue());
			}
            return String.valueOf(doubleVar.floatValue());
		}
		
		if (object instanceof Integer) {
			return String.valueOf(((Integer) object).intValue());
		}
		
		if (object instanceof Boolean) {
			return String.valueOf(((Boolean) object).booleanValue());
		}
		return null;
	}
	
    @Override
    public Integer getInt(Object object) {
		if (object == null) {
			return 0;
		}

		if (object instanceof Integer) {
			return (Integer) object;
		}
        if (object instanceof String) {
            return Integer.parseInt((String) object);
        }
        if (object instanceof Double) {
            return ((Double) object).intValue();
        }
        if (object instanceof Float) {
            return ((Float) object).intValue();
        }
        throw new RuntimeException("Unable to convert to int value");
    }
    

	@Override
	public Double getDouble(Object object) {
		if (object == null) {
			return 0d;
		}
		if (object instanceof Double) {
			return (Double) object;
		}
        if (object instanceof String) {
            return Double.parseDouble((String) object);
        }
        
        if (object instanceof Float) {
            return ((Float) object).doubleValue();
        }
        
        if (object instanceof Integer) {
            return ((Integer) object).doubleValue();
        }
        throw new RuntimeException("Unable to convert to double value");
        
	}

	@Override
	public String getName() {
		return "jsonadapter";
	}
	
    @Override
    public Object toJsonTree(Object src) {
        try {
            return new JSONObject(marshal(src));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public Map<String, Object> getJSONCompatMap() {
		return new java.util.HashMap<>();
	}

	@Override
	public Object getJSONSafeObj(Object obj) {
		if (obj instanceof com.ashera.model.Errors) {
			List<Object> jsonErrors = new java.util.ArrayList<>();
			List<com.ashera.model.Error> errors = ((com.ashera.model.Errors) obj).getErrors();
			for (com.ashera.model.Error error : errors) {
				Map<String, Object> jsonError = getJSONCompatMap();
				jsonError.put("path", error.getPath());
				jsonError.put("description", error.getDescription());
				jsonError.put("stackTrace", error.getStackTrace());
				jsonErrors.add(jsonError);
			}
			Map<String, Object> jsonErrorMap = getJSONCompatMap();
			jsonErrorMap.put("errors", jsonErrors);
			obj = jsonErrorMap;
		}
		return obj;
	}

	@Override
	public Float getFloat(Object object) {
		if (object == null) {
			return 0f;
		}
		
		if (object instanceof Float) {
            return (Float) object;
        }

        if (object instanceof String) {
            return Float.parseFloat((String) object);
        }
		
		if (object instanceof Double) {
			return ((Double) object).floatValue();
		}

        
        if (object instanceof Integer) {
            return ((Integer) object).floatValue();
        }
        throw new RuntimeException("Unable to convert to double value");
        
	}

	@Override
	public Object getNativeMap(Map<String, Object> payLoad) {
		return payLoad;
	}

	@Override
	public void putJSONSafeObjectIntoMap(Map<String, Object> map, String key, Object value) {
		if (value != null) {
			map.put(key, getJSONSafeObj(value));
		} else {
			map.remove(key);
		}
	}

	@Override
	public boolean isBoolean(Object obj) {
		return obj instanceof Boolean;
	}
	//end - web
	@Override
	public String marshal(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	@Override
	public <T> T unmarshal(String json, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(json, clazz);
	}

	//end - body
}
