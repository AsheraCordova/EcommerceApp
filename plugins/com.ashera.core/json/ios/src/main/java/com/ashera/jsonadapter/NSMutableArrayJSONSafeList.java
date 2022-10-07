package com.ashera.jsonadapter;

public class NSMutableArrayJSONSafeList extends NSMutableArrayList<Object> {
	public NSMutableArrayJSONSafeList(Object nsmutableArray) {
		super(nsmutableArray);
	}
	
	@Override
	public void add(int index, Object element) {
		element = com.ashera.widget.PluginInvoker.getJSONSafeObj(element);
		super.add(index, element);
	}
	
	@Override
	public java.lang.Object set(int index, java.lang.Object element) {
		element = com.ashera.widget.PluginInvoker.getJSONSafeObj(element);
		return super.set(index, element);
	}
}
