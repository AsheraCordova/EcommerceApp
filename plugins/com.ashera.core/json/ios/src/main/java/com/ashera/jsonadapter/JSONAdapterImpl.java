package com.ashera.jsonadapter;

import java.util.List;
import java.util.Map;

import com.ashera.plugin.IPlugin;
import com.ashera.plugin.PluginManager;


/*-[
#include <UIKit/UIKit.h>
#include "ASDictionaryMap.h"
]-*/
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

	@Override
	public Map<String, Object> getMap(Object payLoad) {
		if (payLoad instanceof Map) {
			return (Map<String, Object>) payLoad;
		}
		if (payLoad != null && payLoad.getClass().getSimpleName().equals("__NSDictionaryM")) {
			return (Map<String, Object>) getASDictionaryMap(payLoad);
		}
		
		return null;
	}
	
	private native Object getASDictionaryMap(Object payload)/*-[
		return [[ASDictionaryMap alloc] initWithDictionary:payload];
	]-*/;

	@Override
	public Object[] getArray(Object payLoad) {
		if (payLoad instanceof List) {
			return ((List<Object>) payLoad).toArray();
		}
		return (Object[]) getNativeArray(payLoad);
	}
	private native Object getNativeArray(Object nsarray) /*-[
		if ([nsarray isKindOfClass:[NSMutableArray class]]) {
	  		return [IOSObjectArray arrayWithNSArray:nsarray type:[IOSClass forName: @"java.lang.Object"]];
	  	}
	  	return nil;
	]-*/;

	@Override
	public List<Object> getList(Object payLoad) {
		if (payLoad != null && payLoad.getClass().getSimpleName().equals("__NSDictionaryM") || payLoad instanceof Map) {
			return null;
		}
		if (payLoad instanceof List) {
			return ((List<Object>) payLoad);
		}
		if (isClassNSMutableArray(payLoad)) {
			return new NSMutableArrayJSONSafeList(payLoad);
		}
		Object[] array = getArray(payLoad);
		if (array == null) {
			return null;
		}
		return new java.util.ArrayList<>(java.util.Arrays.asList(array));
	}
	@Override
	public Boolean getBoolean(Object payLoad) {
		return com.ashera.utils.StringUtils.getBoolean(payLoad);
	}
	
	private native boolean isClassNSMutableArray(Object object) /*-[
	  return [object isKindOfClass:[NSMutableArray class]];
	]-*/;
	
	@Override
	public String getString(Object object) {
		if (object instanceof String) {
			return (String)object;
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
		
		Object result = tryNativeType(object);
		if (result != null) {
			return (String) result;
		}
		return null;
	}
	private native Object tryNativeType(Object object) /*-[
	  if ([object isKindOfClass:[NSNumber class]]) {
    		return [(NSNumber*)object stringValue];
	  }
	  return nil;
	]-*/;

	@Override
	public String getName() {
		return "jsonadapter";
	}

	@Override
	public Integer getInt(Object object) {
		if (object == null) {
			return 0;
		}
        
        Object result = tryNativeIntType(object);
		if (result != null) {
			return (Integer) result;
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
	
	private native Object tryNativeIntType(Object object) /*-[
	  if ([object isKindOfClass:[NSNumber class]]) {
        return [JavaLangInteger valueOfWithInt:[(NSNumber*) object intValue] ];
	  }
	  return nil;
	]-*/;

	@Override
	public String marshal(Object payload) {
		if (payload instanceof Map) {
			payload = getNSDictionary(payload);
		}
		
		if (payload instanceof List) {
			payload = nsArrayFromList((List<Object>) payload);
		}
		return getJSONString(payload);
	}

	@Override
	public Object toJsonTree(Object object) {
		throw new RuntimeException("Unsupported method");
	}
	
	private native String getJSONString(Object payload) /*-[
	    if (payload == nil) {
	    	payload = [NSDictionary new];
		}
		NSError *err;
		NSData *jsonData = [NSJSONSerialization dataWithJSONObject:payload options:NSJSONWritingPrettyPrinted error:&err];
		NSString *jsonString = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
		return jsonString;
	]-*/;


	@Override
	public <T> T unmarshal(String json, Class<T> clazz) {
		if (clazz == List.class) {
			Object mutableArray = unmarshal(json);
			return (T) getList(mutableArray);
		}
		Object mutableArray = unmarshal(json);
		return (T) getMap(mutableArray);
	}
	
	private native Object unmarshal(String jsonString) /*-[
		NSData *jsonData = [jsonString dataUsingEncoding:NSUTF8StringEncoding];
	    NSError *e = nil;
	    id jsonArray = [NSJSONSerialization JSONObjectWithData:jsonData options:NSJSONReadingMutableContainers error:&e];
	    return jsonArray;
	]-*/;

	@Override
	public native Map<String, Object> getJSONCompatMap() /*-[
		return [[ASDictionaryMap alloc] initWithDictionary:[NSDictionary new]];
	]-*/;

	
	public Object getJSONSafeObj(Object obj) {
		if (obj instanceof Map) {
			return getNSDictionary(obj);
		}
		
		if (obj instanceof Boolean) {
			return convertToNSInteger(((Boolean) obj).booleanValue() ? 1 : 0);
		}
		
		if (obj instanceof Integer) {
			return convertToNSInteger(((Integer) obj));
		}
		
		if (obj instanceof Double) {
			return convertToNSDouble(((Double) obj));
		}
		
		if (obj instanceof Float) {
			return convertToNSFloat(((Float) obj));
		}
		
		if (obj instanceof Long) {
			return convertToNSLong(((Long) obj));
		}
		
		if (obj instanceof List) {
			return nsArrayFromList((List<Object>) obj);
		}
		
		if (obj instanceof com.ashera.model.Errors) {
			List<Object> jsonErrors = new java.util.ArrayList<>();
			List<com.ashera.model.Error> errors = ((com.ashera.model.Errors) obj).getErrors();
			for (com.ashera.model.Error error : errors) {
				Map<String, Object> jsonError = getJSONCompatMap();
				jsonError.put("path", error.getPath());
				jsonError.put("description", error.getDescription());
				jsonError.put("stackTrace", error.getStackTrace());
				jsonErrors.add(getNSDictionary(jsonError));
			}
			Map<String, Object> jsonErrorMap = getJSONCompatMap();
			jsonErrorMap.put("errors", nsArrayFromList(jsonErrors));
			return getNSDictionary(jsonErrorMap);
		}
		
		return obj;
	}
	
	private native Object convertToNSInteger(int value) /*-[
    	return [NSNumber numberWithInteger:value];
	]-*/;
	
	private native Object convertToNSDouble(double value) /*-[
		return [NSNumber numberWithDouble:value];
	]-*/;

	private native Object convertToNSFloat(float value) /*-[
		return [NSNumber numberWithFloat:value];
	]-*/;

	private native Object convertToNSLong(long value) /*-[
		return [NSNumber numberWithLong:value];
	]-*/;


	public native Object nsArrayFromList(List<Object> list)/*-[
	 	NSMutableArray *result = [NSMutableArray array];
	  for (id object in list) {
	    [result addObject:object];
	  }
	  return result;
	]-*/;
	
	public native Object addObject(Object list, Object object) /*-[
		[list addObject:object];
	]-*/;
	
	
	private native Object getNSDictionary(Object payload)/*-[
		return ((ASDictionaryMap*) payload)->dictionary_;
	]-*/;
	
	public static void initPlugin() {
		PluginManager.register(new JSONAdapterImpl());
	}
	

	@Override
	public Double getDouble(java.lang.Object object) {
		if (object == null) {
			return 0d;
		}
		
		Object result = tryNativeDoubleType(object);
		if (result != null) {
			return (Double) result;
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
	
	private native Object tryNativeDoubleType(Object object) /*-[
	  if ([object isKindOfClass:[NSNumber class]]) {
      	return [JavaLangDouble valueOfWithDouble:[(NSNumber*) object doubleValue] ];
	  }
	  return nil;
	]-*/;
	
	private native Object tryNativeFloatType(Object object) /*-[
	  if ([object isKindOfClass:[NSNumber class]]) {
    	return [JavaLangFloat valueOfWithFloat:[(NSNumber*) object floatValue] ];
	  }
	  return nil;
	]-*/;
	
	@Override
	public Float getFloat(java.lang.Object object) {
		if (object == null) {
			return 0f;
		}
		
		Object result = tryNativeFloatType(object);
		if (result != null) {
			return (Float) result;
		}
		
		if (object instanceof Float) {
			return (Float) object;
		}
        if (object instanceof String) {
            return Float.parseFloat((String) object);
        }
        
        if (object instanceof Float) {
            return ((Float) object).floatValue();
        }
        
        if (object instanceof Integer) {
            return ((Integer) object).floatValue();
        }
        throw new RuntimeException("Unable to convert to float value");
        
	}

	@Override
	public native Object getNativeMap(Map<String, Object> payLoad) /*-[
		return ((ASDictionaryMap*) payLoad)->dictionary_;
	]-*/;

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
		if (obj instanceof Boolean) {
			return true;
		}
		if (obj != null && obj.getClass().getName().equals("__NSCFBoolean")) {
			return true;
		}
		return false;
	}
}
