package com.ashera.layout;
// start - imports
import java.util.*;

import r.android.annotation.SuppressLint;
import r.android.content.Context;
import r.android.os.Build;
import r.android.view.*;
import r.android.widget.*;
import r.android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import r.android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

import androidx.core.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports

public class RelativeLayoutImpl extends BaseHasWidgets {
	//start - body
	private Object pane;
	public final static String LOCAL_NAME = "RelativeLayout"; 
	public final static String GROUP_NAME = "RelativeLayout";
	private r.android.widget.RelativeLayout relativeLayout;
	

	
		@SuppressLint("NewApi")
		final static class RemoveRule  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("layout_above", -0x1);
				mapping.put("layout_alignBaseline", -0x2);
				mapping.put("layout_alignBottom", -0x4);
				mapping.put("layout_alignEnd", -0x8);
				mapping.put("layout_alignLeft", -0x16);
				mapping.put("layout_alignParentBottom", -0x32);
				mapping.put("layout_alignParentEnd", -0x64);
				mapping.put("layout_alignParentLeft", -0x128);
				mapping.put("layout_alignParentRight", -0x256);
				mapping.put("layout_alignParentStart", -0x1024);
				mapping.put("layout_alignParentTop", 0x0);
				mapping.put("layout_alignRight", 0x1);
				mapping.put("layout_alignStart", 0x2);
				mapping.put("layout_alignTop", 0x4);
				mapping.put("layout_below", 0x8);
				mapping.put("layout_centerHorizontal", 0x16);
				mapping.put("layout_centerInParent", 0x32);
				mapping.put("layout_centerVertical", 0x64);
				mapping.put("layout_toEndOf", 0x128);
				mapping.put("layout_toLeftOf", 0x256);
				mapping.put("layout_toRightOf", 0x1024);
				mapping.put("layout_toStartOf", 0x2048);
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
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("gravity").withType("gravity"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("ignoreGravity").withType("id"));
	
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_above").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignBaseline").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignBottom").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignEnd").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignLeft").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignParentBottom").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignParentEnd").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignParentLeft").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignParentRight").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignParentStart").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignParentTop").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignRight").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignStart").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignTop").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_below").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_centerHorizontal").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_centerInParent").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_centerVertical").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_toEndOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_toLeftOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_toRightOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_toStartOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_alignWithParentIfMissing").withType("boolean").forChild());
				ConverterFactory.register("RelativeLayout.removeRule", new RemoveRule());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_removeRule").withType("RelativeLayout.removeRule").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_removeAllRules").withType("boolean").forChild());
	}
	
	public RelativeLayoutImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  RelativeLayoutImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  RelativeLayoutImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new RelativeLayoutImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
		relativeLayout = new RelativeLayoutExt();
		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return relativeLayout;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		relativeLayout.removeView((View) w.asWidget());
         ViewGroupImpl.nativeRemoveView(w);            
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= relativeLayout.getChildCount()) {
            relativeLayout.removeViewAt(index);
            ViewGroupImpl.nativeRemoveView(widget);            
        }    
        return remove;
    }
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        relativeLayout.addView(view);
			    } else {
			        relativeLayout.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		r.android.widget.RelativeLayout.LayoutParams layoutParams = (r.android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
		
		layoutParams = (r.android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new r.android.widget.RelativeLayout.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private r.android.widget.RelativeLayout.LayoutParams getLayoutParams(View view) {
		return (r.android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		r.android.widget.RelativeLayout.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
			break;
			case "layout_above": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.ABOVE, objValue);
				
			}
			break;
			case "layout_alignBaseline": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_BASELINE, objValue);
				
			}
			break;
			case "layout_alignBottom": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_BOTTOM, objValue);
				
			}
			break;
			case "layout_alignEnd": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_END, objValue);
				
			}
			break;
			case "layout_alignLeft": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_LEFT, objValue);
				
			}
			break;
			case "layout_alignParentBottom": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM, objValue);
				
			}
			break;
			case "layout_alignParentEnd": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_END, objValue);
				
			}
			break;
			case "layout_alignParentLeft": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_LEFT, objValue);
				
			}
			break;
			case "layout_alignParentRight": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_RIGHT, objValue);
				
			}
			break;
			case "layout_alignParentStart": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_START, objValue);
				
			}
			break;
			case "layout_alignParentTop": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_TOP, objValue);
				
			}
			break;
			case "layout_alignRight": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_RIGHT, objValue);
				
			}
			break;
			case "layout_alignStart": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_START, objValue);
				
			}
			break;
			case "layout_alignTop": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_TOP, objValue);
				
			}
			break;
			case "layout_below": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.BELOW, objValue);
				
			}
			break;
			case "layout_centerHorizontal": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.CENTER_HORIZONTAL, objValue);
				
			}
			break;
			case "layout_centerInParent": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.CENTER_IN_PARENT, objValue);
				
			}
			break;
			case "layout_centerVertical": {
				
							addRemoveRule(layoutParams, r.android.widget.RelativeLayout.CENTER_VERTICAL, objValue);
				
			}
			break;
			case "layout_toEndOf": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.END_OF, objValue);
				
			}
			break;
			case "layout_toLeftOf": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.LEFT_OF, objValue);
				
			}
			break;
			case "layout_toRightOf": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.RIGHT_OF, objValue);
				
			}
			break;
			case "layout_toStartOf": {
				
							addRule(layoutParams, r.android.widget.RelativeLayout.START_OF, objValue);
				
			}
			break;
			case "layout_alignWithParentIfMissing": {
				
							layoutParams.alignWithParent = ((boolean)objValue);
				
			}
			break;
			case "layout_removeRule": {
				
							 removeRule(layoutParams, objValue);
				
			}
			break;
			case "layout_removeAllRules": {
				
							 removeAllRules(layoutParams);
				
			}
			break;
		default:
			break;
		}
		
		
		view.setLayoutParams(layoutParams);		
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getChildAttribute(IWidget w, WidgetAttribute key) {
		Object attributeValue = ViewGroupImpl.getChildAttribute(w, key);		
		if (attributeValue != null) {
			return attributeValue;
		}
		View view = (View) w.asWidget();
		r.android.widget.RelativeLayout.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
			case "layout_above": {
return getRule(layoutParams, r.android.widget.RelativeLayout.ABOVE);			}

			case "layout_alignBaseline": {
return getRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_BASELINE);			}

			case "layout_alignBottom": {
return getRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_BOTTOM);			}

			case "layout_alignEnd": {
return getRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_END);			}

			case "layout_alignLeft": {
return getRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_LEFT);			}

			case "layout_alignParentBottom": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM);			}

			case "layout_alignParentEnd": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_END);			}

			case "layout_alignParentLeft": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_LEFT);			}

			case "layout_alignParentRight": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_RIGHT);			}

			case "layout_alignParentStart": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_START);			}

			case "layout_alignParentTop": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_PARENT_TOP);			}

			case "layout_alignRight": {
return getRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_RIGHT);			}

			case "layout_alignStart": {
return getRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_START);			}

			case "layout_alignTop": {
return getRule(layoutParams, r.android.widget.RelativeLayout.ALIGN_TOP);			}

			case "layout_below": {
return getRule(layoutParams, r.android.widget.RelativeLayout.BELOW);			}

			case "layout_centerHorizontal": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.CENTER_HORIZONTAL);			}

			case "layout_centerInParent": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.CENTER_IN_PARENT);			}

			case "layout_centerVertical": {
return getBoolRule(layoutParams, r.android.widget.RelativeLayout.CENTER_VERTICAL);			}

			case "layout_toEndOf": {
return getRule(layoutParams, r.android.widget.RelativeLayout.END_OF);			}

			case "layout_toLeftOf": {
return getRule(layoutParams, r.android.widget.RelativeLayout.LEFT_OF);			}

			case "layout_toRightOf": {
return getRule(layoutParams, r.android.widget.RelativeLayout.RIGHT_OF);			}

			case "layout_toStartOf": {
return getRule(layoutParams, r.android.widget.RelativeLayout.START_OF);			}

			case "layout_alignWithParentIfMissing": {
return layoutParams.alignWithParent;			}



		}
		
		return null;

	}
	
		
	public class RelativeLayoutExt extends r.android.widget.RelativeLayout implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private int mMaxWidth = -1;
		private int mMaxHeight = -1;
		@Override
		public void setMaxWidth(int width) {
			mMaxWidth = width;
		}
		@Override
		public void setMaxHeight(int height) {
			mMaxHeight = height;
		}
		@Override
		public int getMaxWidth() {
			return mMaxWidth;
		}
		@Override
		public int getMaxHeight() {
			return mMaxHeight;
		}

		public RelativeLayoutExt() {
			
			
			
			
			super();
			
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			if(mMaxWidth > 0) {
	        	widthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxWidth, MeasureSpec.AT_MOST);
	        }
	        if(mMaxHeight > 0) {
	            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);

	        }

	        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
			    measureFinished.setWidth(getMeasuredWidth());
			    measureFinished.setHeight(getMeasuredHeight());
				listener.eventOccurred(EventId.measureFinished, measureFinished);
			}
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			ViewImpl.setDrawableBounds(RelativeLayoutImpl.this, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
	        ViewImpl.redrawDrawables(RelativeLayoutImpl.this);
			
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
				onLayoutEvent.setB(b);
				onLayoutEvent.setL(l);
				onLayoutEvent.setR(r);
				onLayoutEvent.setT(t);
				onLayoutEvent.setChanged(changed);
				listener.eventOccurred(EventId.onLayout, onLayoutEvent);
			}
			
			if (isInvalidateOnFrameChange() && isInitialised()) {
				RelativeLayoutImpl.this.invalidate();
			}
		}	
		
		@Override
		public void execute(String method, Object... canvas) {
			
		}

		public void updateMeasuredDimension(int width, int height) {
			setMeasuredDimension(width, height);
		}


		@Override
		public ILifeCycleDecorator newInstance(IWidget widget) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setAttribute(WidgetAttribute widgetAttribute,
				String strValue, Object objValue) {
			throw new UnsupportedOperationException();
		}		
		

		@Override
		public List<String> getMethods() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void initialized() {
			throw new UnsupportedOperationException();
		}
		
        @Override
        public Object getAttribute(WidgetAttribute widgetAttribute) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void drawableStateChanged() {
        	super.drawableStateChanged();
        	ViewImpl.drawableStateChanged(RelativeLayoutImpl.this);
        }
		@Override
		public void offsetTopAndBottom(int offset) {
			super.offsetTopAndBottom(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
		@Override
		public void offsetLeftAndRight(int offset) {
			super.offsetLeftAndRight(offset);
			ViewImpl.nativeMakeFrame(asNativeWidget(), getLeft(), getTop(), getRight(), getBottom());
		}
        @Override
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            ((org.eclipse.swt.widgets.Control)asNativeWidget()).setVisible(View.VISIBLE == visibility);
            
        }
	}
	
	public void updateMeasuredDimension(int width, int height) {
		((RelativeLayoutExt) relativeLayout).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "gravity": {


	relativeLayout.setGravity((int)objValue);



			}
			break;
			case "ignoreGravity": {


	relativeLayout.setIgnoreGravity((int)objValue);



			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object attributeValue = ViewGroupImpl.getAttribute(this, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "gravity": {
return relativeLayout.getGravity();			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return pane;
    }
    private void nativeCreate(Map<String, Object> params) {
        pane = new org.eclipse.swt.widgets.Composite((org.eclipse.swt.widgets.Composite)ViewImpl.getParent(this), getStyle(params, fragment));
        ((org.eclipse.swt.widgets.Composite)pane).setLayout(new org.eclipse.nebula.widgets.layout.AbsoluteLayout());
    }
    
    @Override
    public void requestLayout() {
    	if (isInitialised()) {
    		ViewImpl.requestLayout(this, asNativeWidget());
    	}
    }
    
    @Override
    public void invalidate() {
    	if (isInitialised()) {
    		ViewImpl.invalidate(this, asNativeWidget());
    	}
    }
    
	

	private void addRule(r.android.widget.RelativeLayout.LayoutParams layoutParams, int rule, Object objValue) {
		layoutParams.addRule(rule, (int) objValue);
	}


	private void addRemoveRule(r.android.widget.RelativeLayout.LayoutParams layoutParams, int rule, Object objValue) {
		if ((boolean) objValue) {
			layoutParams.addRule(rule);
		} else {
			removeRule(layoutParams, rule);
			rule = getInferredRule(rule);
			removeRule(layoutParams, rule);
		}
	}

	@SuppressLint("NewApi")
	private void removeRule(r.android.widget.RelativeLayout.LayoutParams layoutParams, int rule) {
		if (Build.VERSION.SDK_INT >= 17) {
			layoutParams.removeRule(rule);
		} else {
			layoutParams.addRule(rule, 0);	
		}
	}
	
	@SuppressLint("NewApi")
	private Object getRule(r.android.widget.RelativeLayout.LayoutParams layoutParams, int rule) {
		if (Build.VERSION.SDK_INT >= 23) {
			rule = getInferredRule(rule);
			return layoutParams.getRule(rule);
		} 
		return null;
	}
	
	@SuppressLint("NewApi")
	private Object getBoolRule(r.android.widget.RelativeLayout.LayoutParams layoutParams, int rule) {
		if (Build.VERSION.SDK_INT >= 23) {
			rule = getInferredRule(rule);
			return layoutParams.getRule(rule) != 0;
		} 
		return null;
	}

	private int getInferredRule(int rule) {
		if (rule == r.android.widget.RelativeLayout.ALIGN_PARENT_END) {
			rule = ViewImpl.isRTLLayoutDirection(this) ? r.android.widget.RelativeLayout.ALIGN_PARENT_LEFT :  r.android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;
		}
		if (rule == r.android.widget.RelativeLayout.ALIGN_PARENT_START) {
			rule = ViewImpl.isRTLLayoutDirection(this) ? r.android.widget.RelativeLayout.ALIGN_PARENT_RIGHT :  r.android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
		}
		if (rule == r.android.widget.RelativeLayout.END_OF) {
			rule = ViewImpl.isRTLLayoutDirection(this) ? r.android.widget.RelativeLayout.LEFT_OF :  r.android.widget.RelativeLayout.RIGHT_OF;
		}
		if (rule == r.android.widget.RelativeLayout.START_OF) {
			rule = ViewImpl.isRTLLayoutDirection(this) ? r.android.widget.RelativeLayout.RIGHT_OF :  r.android.widget.RelativeLayout.LEFT_OF;
		}
		if (rule == r.android.widget.RelativeLayout.ALIGN_END) {
			rule = ViewImpl.isRTLLayoutDirection(this) ? r.android.widget.RelativeLayout.ALIGN_LEFT :  r.android.widget.RelativeLayout.ALIGN_RIGHT;
		}
		if (rule == r.android.widget.RelativeLayout.ALIGN_START) {
			rule = ViewImpl.isRTLLayoutDirection(this) ? r.android.widget.RelativeLayout.ALIGN_RIGHT :  r.android.widget.RelativeLayout.ALIGN_LEFT;
		}
		return rule;
	}
	private HashMap<String, Integer> ruleMapper = new HashMap<>();
	{
		ruleMapper.put("layout_above", r.android.widget.RelativeLayout.ABOVE);
		ruleMapper.put("layout_alignBaseline", r.android.widget.RelativeLayout.ALIGN_BASELINE);
		ruleMapper.put("layout_alignBottom", r.android.widget.RelativeLayout.ALIGN_BOTTOM);
		ruleMapper.put("layout_alignEnd", r.android.widget.RelativeLayout.ALIGN_END);
		ruleMapper.put("layout_alignLeft", r.android.widget.RelativeLayout.ALIGN_LEFT);
		ruleMapper.put("layout_alignParentBottom", r.android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM);
		ruleMapper.put("layout_alignParentEnd", r.android.widget.RelativeLayout.ALIGN_PARENT_END);
		ruleMapper.put("layout_alignParentLeft", r.android.widget.RelativeLayout.ALIGN_PARENT_LEFT);
		ruleMapper.put("layout_alignParentRight", r.android.widget.RelativeLayout.ALIGN_PARENT_RIGHT);
		ruleMapper.put("layout_alignParentStart", r.android.widget.RelativeLayout.ALIGN_PARENT_START);
		ruleMapper.put("layout_alignParentTop", r.android.widget.RelativeLayout.ALIGN_PARENT_TOP);
		ruleMapper.put("layout_alignRight", r.android.widget.RelativeLayout.ALIGN_RIGHT);
		ruleMapper.put("layout_alignStart", r.android.widget.RelativeLayout.ALIGN_START);
		ruleMapper.put("layout_alignTop", r.android.widget.RelativeLayout.ALIGN_TOP);
		ruleMapper.put("layout_below", r.android.widget.RelativeLayout.BELOW);
		ruleMapper.put("layout_centerHorizontal", r.android.widget.RelativeLayout.CENTER_HORIZONTAL);
		ruleMapper.put("layout_centerVertical", r.android.widget.RelativeLayout.CENTER_VERTICAL);
		ruleMapper.put("layout_centerInParent", r.android.widget.RelativeLayout.CENTER_IN_PARENT);
		ruleMapper.put("layout_toEndOf", r.android.widget.RelativeLayout.END_OF);
		ruleMapper.put("layout_toLeftOf", r.android.widget.RelativeLayout.LEFT_OF);
		ruleMapper.put("layout_toRightOf", r.android.widget.RelativeLayout.RIGHT_OF);
		ruleMapper.put("layout_toStartOf", r.android.widget.RelativeLayout.START_OF);
	}
	private void removeAllRules(r.android.widget.RelativeLayout.LayoutParams layoutParams) {
		RemoveRule removeRule = (RemoveRule) ConverterFactory.get("RelativeLayout.removeRule");
		Collection<String> keys = removeRule.mapping.keySet();
		for (String key : keys) {
			int rule = ruleMapper.get(key);
			removeRule(layoutParams, rule);
			rule = getInferredRule(rule);
			removeRule(layoutParams, rule);
		}
		
	}

	private <A, B> Map<B, A> invertMap(Map<A, B> map) {
	    Map<B, A> reverseMap = new HashMap<>();
	    for (Map.Entry<A, B> entry : map.entrySet()) {
	        reverseMap.put(entry.getValue(), entry.getKey());
	    }
	    return reverseMap;
	}
	private void removeRule(r.android.widget.RelativeLayout.LayoutParams layoutParams, Object objValue) {
		RemoveRule removeRule = (RemoveRule) ConverterFactory.get("RelativeLayout.removeRule");
		int rule = (int) objValue;
		
		Map<Integer, String> reverseMap = invertMap(removeRule.mapping);
		Collection<Integer> flags = removeRule.getReverseMappingFlags();
		for (int flag : flags) {
			if ((rule & flag) != 0) {
				int finalRule  = ruleMapper.get(reverseMap.get(flag));
				removeRule(layoutParams, finalRule);
				finalRule = getInferredRule(finalRule);
				removeRule(layoutParams, finalRule);
			}
		}
		
	}
	


	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			relativeLayout.setId(IdGenerator.getId(id));
		}
	}
	
    
    @Override
    public void setVisible(boolean b) {
        ((View)asWidget()).setVisibility(b ? View.VISIBLE : View.GONE);
    }
    public int getStyle(String key, int initStyle, Map<String, Object> params, IFragment fragment) {
    	if (params == null) {
    		return initStyle;
    	}
    	Object style = params.get(key);
		if (style == null) {
			return initStyle;
		}
		int convertFrom = (int) ConverterFactory.get("swtbitflag").convertFrom(style.toString(), null, fragment);
		return convertFrom;
	}
	
	public int getStyle(Map<String, Object> params, IFragment fragment) {
		return getStyle("swtStyle", org.eclipse.swt.SWT.NONE, params, fragment);
	}
	
	public int getStyle(int initStyle, Map<String, Object> params, IFragment fragment) {
		return getStyle("swtStyle", initStyle, params, fragment);
	}

	
private RelativeLayoutCommandBuilder builder;
private RelativeLayoutBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public RelativeLayoutBean getBean() {
	if (bean == null) {
		bean = new RelativeLayoutBean();
	}
	return bean;
}
public RelativeLayoutCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new RelativeLayoutCommandBuilder();
	}
	return builder;
}


public  class RelativeLayoutCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <RelativeLayoutCommandBuilder> {
    public RelativeLayoutCommandBuilder() {
	}
	
	public RelativeLayoutCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public RelativeLayoutCommandBuilder tryGetGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getGravity() {
	Map<String, Object> attrs = initCommand("gravity");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandBuilder setGravity(String value) {
	Map<String, Object> attrs = initCommand("gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandBuilder setIgnoreGravity(String value) {
	Map<String, Object> attrs = initCommand("ignoreGravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class RelativeLayoutBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public RelativeLayoutBean() {
			super(RelativeLayoutImpl.this);
		}
public Object getGravity() {
	return getBuilder().reset().tryGetGravity().execute(false).getGravity(); 
}
public void setGravity(String value) {
	getBuilder().reset().setGravity(value).execute(true);
}

public void setIgnoreGravity(String value) {
	getBuilder().reset().setIgnoreGravity(value).execute(true);
}

}


private RelativeLayoutCommandParamsBuilder paramsBuilder;
private RelativeLayoutParamsBean paramsBean;

public RelativeLayoutParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new RelativeLayoutParamsBean();
	}
	return paramsBean;
}
public RelativeLayoutCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new RelativeLayoutCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class RelativeLayoutParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
public Object getLayoutAbove(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAbove().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutAbove();
}
public void setLayoutAbove(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAbove(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutAlignBaseline(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignBaseline().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutAlignBaseline();
}
public void setLayoutAlignBaseline(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignBaseline(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutAlignBottom(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignBottom().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutAlignBottom();
}
public void setLayoutAlignBottom(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignBottom(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutAlignEnd(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignEnd().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutAlignEnd();
}
public void setLayoutAlignEnd(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignEnd(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutAlignLeft(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignLeft().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutAlignLeft();
}
public void setLayoutAlignLeft(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignLeft(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutAlignParentBottom(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignParentBottom().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutAlignParentBottom();
}
public void setLayoutAlignParentBottom(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignParentBottom(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutAlignParentEnd(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignParentEnd().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutAlignParentEnd();
}
public void setLayoutAlignParentEnd(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignParentEnd(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutAlignParentLeft(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignParentLeft().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutAlignParentLeft();
}
public void setLayoutAlignParentLeft(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignParentLeft(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutAlignParentRight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignParentRight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutAlignParentRight();
}
public void setLayoutAlignParentRight(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignParentRight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutAlignParentStart(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignParentStart().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutAlignParentStart();
}
public void setLayoutAlignParentStart(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignParentStart(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutAlignParentTop(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignParentTop().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutAlignParentTop();
}
public void setLayoutAlignParentTop(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignParentTop(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutAlignRight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignRight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutAlignRight();
}
public void setLayoutAlignRight(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignRight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutAlignStart(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignStart().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutAlignStart();
}
public void setLayoutAlignStart(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignStart(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutAlignTop(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignTop().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutAlignTop();
}
public void setLayoutAlignTop(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignTop(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutBelow(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutBelow().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutBelow();
}
public void setLayoutBelow(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutBelow(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutCenterHorizontal(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutCenterHorizontal().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutCenterHorizontal();
}
public void setLayoutCenterHorizontal(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutCenterHorizontal(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutCenterInParent(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutCenterInParent().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutCenterInParent();
}
public void setLayoutCenterInParent(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutCenterInParent(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutCenterVertical(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutCenterVertical().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutCenterVertical();
}
public void setLayoutCenterVertical(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutCenterVertical(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutToEndOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutToEndOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutToEndOf();
}
public void setLayoutToEndOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutToEndOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutToLeftOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutToLeftOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutToLeftOf();
}
public void setLayoutToLeftOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutToLeftOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutToRightOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutToRightOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutToRightOf();
}
public void setLayoutToRightOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutToRightOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutToStartOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutToStartOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutToStartOf();
}
public void setLayoutToStartOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutToStartOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutAlignWithParentIfMissing(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutAlignWithParentIfMissing().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutAlignWithParentIfMissing();
}
public void setLayoutAlignWithParentIfMissing(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutAlignWithParentIfMissing(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutRemoveRule(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutRemoveRule(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutRemoveAllRules(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutRemoveAllRules(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

}





public class RelativeLayoutCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<RelativeLayoutCommandParamsBuilder>{
public RelativeLayoutCommandParamsBuilder tryGetLayoutAbove() {
	Map<String, Object> attrs = initCommand("layout_above");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutAbove() {
	Map<String, Object> attrs = initCommand("layout_above");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAbove(String value) {
	Map<String, Object> attrs = initCommand("layout_above");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignBaseline() {
	Map<String, Object> attrs = initCommand("layout_alignBaseline");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutAlignBaseline() {
	Map<String, Object> attrs = initCommand("layout_alignBaseline");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignBaseline(String value) {
	Map<String, Object> attrs = initCommand("layout_alignBaseline");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignBottom() {
	Map<String, Object> attrs = initCommand("layout_alignBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutAlignBottom() {
	Map<String, Object> attrs = initCommand("layout_alignBottom");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignBottom(String value) {
	Map<String, Object> attrs = initCommand("layout_alignBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignEnd() {
	Map<String, Object> attrs = initCommand("layout_alignEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutAlignEnd() {
	Map<String, Object> attrs = initCommand("layout_alignEnd");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignEnd(String value) {
	Map<String, Object> attrs = initCommand("layout_alignEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignLeft() {
	Map<String, Object> attrs = initCommand("layout_alignLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutAlignLeft() {
	Map<String, Object> attrs = initCommand("layout_alignLeft");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignLeft(String value) {
	Map<String, Object> attrs = initCommand("layout_alignLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignParentBottom() {
	Map<String, Object> attrs = initCommand("layout_alignParentBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutAlignParentBottom() {
	Map<String, Object> attrs = initCommand("layout_alignParentBottom");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignParentBottom(boolean value) {
	Map<String, Object> attrs = initCommand("layout_alignParentBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignParentEnd() {
	Map<String, Object> attrs = initCommand("layout_alignParentEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutAlignParentEnd() {
	Map<String, Object> attrs = initCommand("layout_alignParentEnd");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignParentEnd(boolean value) {
	Map<String, Object> attrs = initCommand("layout_alignParentEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignParentLeft() {
	Map<String, Object> attrs = initCommand("layout_alignParentLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutAlignParentLeft() {
	Map<String, Object> attrs = initCommand("layout_alignParentLeft");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignParentLeft(boolean value) {
	Map<String, Object> attrs = initCommand("layout_alignParentLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignParentRight() {
	Map<String, Object> attrs = initCommand("layout_alignParentRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutAlignParentRight() {
	Map<String, Object> attrs = initCommand("layout_alignParentRight");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignParentRight(boolean value) {
	Map<String, Object> attrs = initCommand("layout_alignParentRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignParentStart() {
	Map<String, Object> attrs = initCommand("layout_alignParentStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutAlignParentStart() {
	Map<String, Object> attrs = initCommand("layout_alignParentStart");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignParentStart(boolean value) {
	Map<String, Object> attrs = initCommand("layout_alignParentStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignParentTop() {
	Map<String, Object> attrs = initCommand("layout_alignParentTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutAlignParentTop() {
	Map<String, Object> attrs = initCommand("layout_alignParentTop");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignParentTop(boolean value) {
	Map<String, Object> attrs = initCommand("layout_alignParentTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignRight() {
	Map<String, Object> attrs = initCommand("layout_alignRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutAlignRight() {
	Map<String, Object> attrs = initCommand("layout_alignRight");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignRight(String value) {
	Map<String, Object> attrs = initCommand("layout_alignRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignStart() {
	Map<String, Object> attrs = initCommand("layout_alignStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutAlignStart() {
	Map<String, Object> attrs = initCommand("layout_alignStart");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignStart(String value) {
	Map<String, Object> attrs = initCommand("layout_alignStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignTop() {
	Map<String, Object> attrs = initCommand("layout_alignTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutAlignTop() {
	Map<String, Object> attrs = initCommand("layout_alignTop");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignTop(String value) {
	Map<String, Object> attrs = initCommand("layout_alignTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutBelow() {
	Map<String, Object> attrs = initCommand("layout_below");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutBelow() {
	Map<String, Object> attrs = initCommand("layout_below");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutBelow(String value) {
	Map<String, Object> attrs = initCommand("layout_below");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutCenterHorizontal() {
	Map<String, Object> attrs = initCommand("layout_centerHorizontal");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutCenterHorizontal() {
	Map<String, Object> attrs = initCommand("layout_centerHorizontal");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutCenterHorizontal(boolean value) {
	Map<String, Object> attrs = initCommand("layout_centerHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutCenterInParent() {
	Map<String, Object> attrs = initCommand("layout_centerInParent");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutCenterInParent() {
	Map<String, Object> attrs = initCommand("layout_centerInParent");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutCenterInParent(boolean value) {
	Map<String, Object> attrs = initCommand("layout_centerInParent");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutCenterVertical() {
	Map<String, Object> attrs = initCommand("layout_centerVertical");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutCenterVertical() {
	Map<String, Object> attrs = initCommand("layout_centerVertical");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutCenterVertical(boolean value) {
	Map<String, Object> attrs = initCommand("layout_centerVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutToEndOf() {
	Map<String, Object> attrs = initCommand("layout_toEndOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutToEndOf() {
	Map<String, Object> attrs = initCommand("layout_toEndOf");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutToEndOf(String value) {
	Map<String, Object> attrs = initCommand("layout_toEndOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutToLeftOf() {
	Map<String, Object> attrs = initCommand("layout_toLeftOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutToLeftOf() {
	Map<String, Object> attrs = initCommand("layout_toLeftOf");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutToLeftOf(String value) {
	Map<String, Object> attrs = initCommand("layout_toLeftOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutToRightOf() {
	Map<String, Object> attrs = initCommand("layout_toRightOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutToRightOf() {
	Map<String, Object> attrs = initCommand("layout_toRightOf");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutToRightOf(String value) {
	Map<String, Object> attrs = initCommand("layout_toRightOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutToStartOf() {
	Map<String, Object> attrs = initCommand("layout_toStartOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutToStartOf() {
	Map<String, Object> attrs = initCommand("layout_toStartOf");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutToStartOf(String value) {
	Map<String, Object> attrs = initCommand("layout_toStartOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder tryGetLayoutAlignWithParentIfMissing() {
	Map<String, Object> attrs = initCommand("layout_alignWithParentIfMissing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutAlignWithParentIfMissing() {
	Map<String, Object> attrs = initCommand("layout_alignWithParentIfMissing");
	return attrs.get("commandReturnValue");
}
public RelativeLayoutCommandParamsBuilder setLayoutAlignWithParentIfMissing(boolean value) {
	Map<String, Object> attrs = initCommand("layout_alignWithParentIfMissing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder setLayoutRemoveRule(String value) {
	Map<String, Object> attrs = initCommand("layout_removeRule");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public RelativeLayoutCommandParamsBuilder setLayoutRemoveAllRules(boolean value) {
	Map<String, Object> attrs = initCommand("layout_removeAllRules");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}

	//end - body
}
