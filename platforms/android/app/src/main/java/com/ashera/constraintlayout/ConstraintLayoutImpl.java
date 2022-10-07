package com.ashera.constraintlayout;
// start - imports
import java.util.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.*;
import android.widget.*;
import android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

import android.graphics.Canvas;
import android.widget.*;
import androidx.core.view.*;
import android.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports

public class ConstraintLayoutImpl extends BaseHasWidgets {
	//start - body
	public final static String LOCAL_NAME = "androidx.constraintlayout.widget.ConstraintLayout"; 
	public final static String GROUP_NAME = "androidx.constraintlayout.widget.ConstraintLayout";
	private androidx.constraintlayout.widget.ConstraintLayout constraintLayout;
	

	
		@SuppressLint("NewApi")
		final static class OptimizationLevel extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("none",  0x0);
				mapping.put("legacy",  0x0);
				mapping.put("standard",  0x257);
				mapping.put("direct",  0x1);
				mapping.put("barrier",  0x2);
				mapping.put("chains",  0x4);
				mapping.put("dimensions",  0x8);
				mapping.put("ratio",  0x16);
				mapping.put("groups",  0x32);
				mapping.put("graph",  0x64);
				mapping.put("graph_wrap",  0x128);
				mapping.put("cache_measures",  0x256);
				mapping.put("dependency_ordering",  0x512);
				mapping.put("grouping",  0x1024);
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
		@SuppressLint("NewApi")
		final static class Orientation extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("horizontal",  0x0);
				mapping.put("vertical",  0x1);
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
		@SuppressLint("NewApi")
		final static class Layout_constraintWidth extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("match_parent",  -1);
				mapping.put("wrap_content",  -2);
				mapping.put("match_constraint",  -3);
				mapping.put("wrap_content_constrained",  -4);
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
		@SuppressLint("NewApi")
		final static class Layout_constraintHeight extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("match_parent",  -1);
				mapping.put("wrap_content",  -2);
				mapping.put("match_constraint",  -3);
				mapping.put("wrap_content_constrained",  -4);
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
		@SuppressLint("NewApi")
		final static class Layout_constraintWidth_default extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("spread",  0x0);
				mapping.put("wrap",  0x1);
				mapping.put("percent",  0x2);
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
		@SuppressLint("NewApi")
		final static class Layout_constraintHeight_default extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("spread",  0x0);
				mapping.put("wrap",  0x1);
				mapping.put("percent",  0x2);
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
		@SuppressLint("NewApi")
		final static class Layout_constraintHorizontal_chainStyle extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("spread",  0x0);
				mapping.put("spread_inside",  0x1);
				mapping.put("packed",  0x2);
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
		@SuppressLint("NewApi")
		final static class Layout_constraintVertical_chainStyle extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("spread",  0x0);
				mapping.put("spread_inside",  0x1);
				mapping.put("packed",  0x2);
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
		@SuppressLint("NewApi")
		final static class Layout_wrapBehaviorInParent extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("included",  0x0);
				mapping.put("horizontal_only",  0x1);
				mapping.put("vertical_only",  0x2);
				mapping.put("skipped",  0x3);
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

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension"));
		ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.optimizationLevel", new OptimizationLevel());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("optimizationLevel").withType("androidx.constraintlayout.widget.ConstraintLayout.optimizationLevel"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_optimizationLevel").withType("androidx.constraintlayout.widget.ConstraintLayout.optimizationLevel"));
	
				ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.orientation", new Orientation());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_orientation").withType("androidx.constraintlayout.widget.ConstraintLayout.orientation").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintCircle").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintCircleRadius").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintCircleAngle").withType("float").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintGuide_begin").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintGuide_end").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintGuide_percent").withType("float").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintLeft_toLeftOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintLeft_toRightOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintRight_toLeftOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintRight_toRightOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintTop_toTopOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintTop_toBottomOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintBottom_toTopOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintBottom_toBottomOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintBaseline_toBaselineOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintBaseline_toTopOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintBaseline_toBottomOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintStart_toEndOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintStart_toStartOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintEnd_toStartOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintEnd_toEndOf").withType("id").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_goneMarginLeft").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_goneMarginTop").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_goneMarginRight").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_goneMarginBottom").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_goneMarginStart").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_goneMarginEnd").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_goneMarginBaseline").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_marginBaseline").withType("dimension").forChild());
				ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintWidth", new Layout_constraintWidth());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintWidth").withType("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintWidth").forChild());
				ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintHeight", new Layout_constraintHeight());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintHeight").withType("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintHeight").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constrainedWidth").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constrainedHeight").withType("boolean").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintHorizontal_bias").withType("float").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintVertical_bias").withType("float").forChild());
				ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintWidth_default", new Layout_constraintWidth_default());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintWidth_default").withType("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintWidth_default").forChild());
				ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintHeight_default", new Layout_constraintHeight_default());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintHeight_default").withType("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintHeight_default").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintWidth_min").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintWidth_max").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintWidth_percent").withType("float").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintHeight_min").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintHeight_max").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintHeight_percent").withType("float").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintDimensionRatio").withType("string").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintHorizontal_weight").withType("float").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintVertical_weight").withType("float").forChild());
				ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintHorizontal_chainStyle", new Layout_constraintHorizontal_chainStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintHorizontal_chainStyle").withType("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintHorizontal_chainStyle").forChild());
				ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintVertical_chainStyle", new Layout_constraintVertical_chainStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintVertical_chainStyle").withType("androidx.constraintlayout.widget.ConstraintLayout.layout_constraintVertical_chainStyle").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_editor_absoluteX").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_editor_absoluteY").withType("dimension").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_constraintTag").withType("string").forChild());
				ConverterFactory.register("androidx.constraintlayout.widget.ConstraintLayout.layout_wrapBehaviorInParent", new Layout_wrapBehaviorInParent());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_wrapBehaviorInParent").withType("androidx.constraintlayout.widget.ConstraintLayout.layout_wrapBehaviorInParent").forChild());
	}
	
	public ConstraintLayoutImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  ConstraintLayoutImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  ConstraintLayoutImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new ConstraintLayoutImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		constraintLayout = new ConstraintLayoutExt(context);
	} else {
		int defStyleAttr = 0;
		int defStyleRes = 0;
		
		if (systemStyle != null) {
			defStyleRes = context.getResources().getIdentifier((String) systemStyle, "style", context.getPackageName());	
		}
		
		if (systemAndroidAttrStyle != null) {
			defStyleAttr = context.getResources().getIdentifier((String) systemAndroidAttrStyle, "attr", "android");	
		}
		
		if (defStyleRes == 0) {
			constraintLayout = new ConstraintLayoutExt(context, null, defStyleAttr);	
		} else {
		}
		
	}

		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return constraintLayout;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		constraintLayout.removeView((View) w.asWidget());
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= constraintLayout.getChildCount()) {
            constraintLayout.removeViewAt(index);
        }    
        return remove;
    }
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        constraintLayout.addView(view);
			    } else {
			        constraintLayout.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) view.getLayoutParams();
		
		layoutParams = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private androidx.constraintlayout.widget.ConstraintLayout.LayoutParams getLayoutParams(View view) {
		return (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
			break;
			case "layout_orientation": {
				
							layoutParams.orientation = ((int)objValue);
				
			}
			break;
			case "layout_constraintCircle": {
				
							layoutParams.circleConstraint = ((int)objValue);
				
			}
			break;
			case "layout_constraintCircleRadius": {
				
							layoutParams.circleRadius = ((int)objValue);
				
			}
			break;
			case "layout_constraintCircleAngle": {
				
							layoutParams.circleAngle = ((float)objValue);
				
			}
			break;
			case "layout_constraintGuide_begin": {
				
							layoutParams.guideBegin = ((int)objValue);
				
			}
			break;
			case "layout_constraintGuide_end": {
				
							layoutParams.guideEnd = ((int)objValue);
				
			}
			break;
			case "layout_constraintGuide_percent": {
				
							layoutParams.guidePercent = ((float)objValue);
				
			}
			break;
			case "layout_constraintLeft_toLeftOf": {
				
							layoutParams.leftToLeft = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.leftToLeft =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintLeft_toRightOf": {
				
							layoutParams.leftToRight = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.leftToRight =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintRight_toLeftOf": {
				
							layoutParams.rightToLeft = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.rightToLeft =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintRight_toRightOf": {
				
							layoutParams.rightToRight = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.rightToRight =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintTop_toTopOf": {
				
							layoutParams.topToTop = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.topToTop =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintTop_toBottomOf": {
				
							layoutParams.topToBottom = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.topToBottom =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintBottom_toTopOf": {
				
							layoutParams.bottomToTop = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.bottomToTop =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintBottom_toBottomOf": {
				
							layoutParams.bottomToBottom = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.bottomToBottom =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintBaseline_toBaselineOf": {
				
							layoutParams.baselineToBaseline = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.baselineToBaseline =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintBaseline_toTopOf": {
				
							layoutParams.baselineToTop = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.baselineToTop =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintBaseline_toBottomOf": {
				
							layoutParams.baselineToBottom = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.baselineToBottom =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintStart_toEndOf": {
				
							layoutParams.startToEnd = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.startToEnd =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintStart_toStartOf": {
				
							layoutParams.startToStart = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.startToStart =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintEnd_toStartOf": {
				
							layoutParams.endToStart = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.endToStart =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_constraintEnd_toEndOf": {
				
							layoutParams.endToEnd = ((int) objValue);
							if (strValue.equals("parent")) {
								layoutParams.endToEnd =  androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID;
							}
				
			}
			break;
			case "layout_goneMarginLeft": {
				
							layoutParams.goneLeftMargin = ((int)objValue);
				
			}
			break;
			case "layout_goneMarginTop": {
				
							layoutParams.goneTopMargin = ((int)objValue);
				
			}
			break;
			case "layout_goneMarginRight": {
				
							layoutParams.goneRightMargin = ((int)objValue);
				
			}
			break;
			case "layout_goneMarginBottom": {
				
							layoutParams.goneBottomMargin = ((int)objValue);
				
			}
			break;
			case "layout_goneMarginStart": {
				
							layoutParams.goneStartMargin = ((int)objValue);
				
			}
			break;
			case "layout_goneMarginEnd": {
				
							layoutParams.goneEndMargin = ((int)objValue);
				
			}
			break;
			case "layout_goneMarginBaseline": {
				
							layoutParams.goneBaselineMargin = ((int)objValue);
				
			}
			break;
			case "layout_marginBaseline": {
				
							layoutParams.baselineMargin = ((int)objValue);
				
			}
			break;
			case "layout_constraintWidth": {
				
							 setLayout_constraintWidth(layoutParams, objValue);
				
			}
			break;
			case "layout_constraintHeight": {
				
							 setLayout_constraintHeight(layoutParams, objValue);
				
			}
			break;
			case "layout_constrainedWidth": {
				
							layoutParams.constrainedWidth = ((boolean)objValue);
				
			}
			break;
			case "layout_constrainedHeight": {
				
							layoutParams.constrainedHeight = ((boolean)objValue);
				
			}
			break;
			case "layout_constraintHorizontal_bias": {
				
							layoutParams.horizontalBias = ((float)objValue);
				
			}
			break;
			case "layout_constraintVertical_bias": {
				
							layoutParams.verticalBias = ((float)objValue);
				
			}
			break;
			case "layout_constraintWidth_default": {
				
							layoutParams.matchConstraintDefaultWidth = ((int)objValue);
				
			}
			break;
			case "layout_constraintHeight_default": {
				
							layoutParams.matchConstraintDefaultHeight = ((int)objValue);
				
			}
			break;
			case "layout_constraintWidth_min": {
				
							layoutParams.matchConstraintMinWidth = ((int)objValue);
				
			}
			break;
			case "layout_constraintWidth_max": {
				
							layoutParams.matchConstraintMaxWidth = ((int)objValue);
				
			}
			break;
			case "layout_constraintWidth_percent": {
				
							layoutParams.matchConstraintPercentWidth = ((float)objValue);
				
			}
			break;
			case "layout_constraintHeight_min": {
				
							layoutParams.matchConstraintMinHeight = ((int)objValue);
				
			}
			break;
			case "layout_constraintHeight_max": {
				
							layoutParams.matchConstraintMaxHeight = ((int)objValue);
				
			}
			break;
			case "layout_constraintHeight_percent": {
				
							layoutParams.matchConstraintPercentHeight = ((float)objValue);
				
			}
			break;
			case "layout_constraintDimensionRatio": {
				
							layoutParams.dimensionRatio = ((String)objValue);
				
			}
			break;
			case "layout_constraintHorizontal_weight": {
				
							layoutParams.horizontalWeight = ((float)objValue);
				
			}
			break;
			case "layout_constraintVertical_weight": {
				
							layoutParams.verticalWeight = ((float)objValue);
				
			}
			break;
			case "layout_constraintHorizontal_chainStyle": {
				
							layoutParams.horizontalChainStyle = ((int)objValue);
				
			}
			break;
			case "layout_constraintVertical_chainStyle": {
				
							layoutParams.verticalChainStyle = ((int)objValue);
				
			}
			break;
			case "layout_editor_absoluteX": {
				
							layoutParams.editorAbsoluteX = ((int)objValue);
				
			}
			break;
			case "layout_editor_absoluteY": {
				
							layoutParams.editorAbsoluteY = ((int)objValue);
				
			}
			break;
			case "layout_constraintTag": {
				
							layoutParams.constraintTag = ((String)objValue);
				
			}
			break;
			case "layout_wrapBehaviorInParent": {
				
							layoutParams.wrapBehaviorInParent = ((int)objValue);
				
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
		androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;
			case "layout_orientation": {
return layoutParams.orientation;			}

			case "layout_constraintCircle": {
return layoutParams.circleConstraint;			}

			case "layout_constraintCircleRadius": {
return layoutParams.circleRadius;			}

			case "layout_constraintCircleAngle": {
return layoutParams.circleAngle;			}

			case "layout_constraintGuide_begin": {
return layoutParams.guideBegin;			}

			case "layout_constraintGuide_end": {
return layoutParams.guideEnd;			}

			case "layout_constraintGuide_percent": {
return layoutParams.guidePercent;			}

			case "layout_constraintLeft_toLeftOf": {
return layoutParams.leftToLeft;			}

			case "layout_constraintLeft_toRightOf": {
return layoutParams.leftToRight;			}

			case "layout_constraintRight_toLeftOf": {
return layoutParams.rightToLeft;			}

			case "layout_constraintRight_toRightOf": {
return layoutParams.rightToRight;			}

			case "layout_constraintTop_toTopOf": {
return layoutParams.topToTop;			}

			case "layout_constraintTop_toBottomOf": {
return layoutParams.topToBottom;			}

			case "layout_constraintBottom_toTopOf": {
return layoutParams.bottomToTop;			}

			case "layout_constraintBottom_toBottomOf": {
return layoutParams.bottomToBottom;			}

			case "layout_constraintBaseline_toBaselineOf": {
return layoutParams.baselineToBaseline;			}

			case "layout_constraintBaseline_toTopOf": {
return layoutParams.baselineToTop;			}

			case "layout_constraintBaseline_toBottomOf": {
return layoutParams.baselineToBottom;			}

			case "layout_constraintStart_toEndOf": {
return layoutParams.startToEnd;			}

			case "layout_constraintStart_toStartOf": {
return layoutParams.startToStart;			}

			case "layout_constraintEnd_toStartOf": {
return layoutParams.endToStart;			}

			case "layout_constraintEnd_toEndOf": {
return layoutParams.endToEnd;			}

			case "layout_goneMarginLeft": {
return layoutParams.goneLeftMargin;			}

			case "layout_goneMarginTop": {
return layoutParams.goneTopMargin;			}

			case "layout_goneMarginRight": {
return layoutParams.goneRightMargin;			}

			case "layout_goneMarginBottom": {
return layoutParams.goneBottomMargin;			}

			case "layout_goneMarginStart": {
return layoutParams.goneStartMargin;			}

			case "layout_goneMarginEnd": {
return layoutParams.goneEndMargin;			}

			case "layout_goneMarginBaseline": {
return layoutParams.goneBaselineMargin;			}

			case "layout_marginBaseline": {
return layoutParams.baselineMargin;			}

			case "layout_constraintWidth": {
return getLayout_constraintWidth(layoutParams);			}

			case "layout_constraintHeight": {
return getLayout_constraintHeight(layoutParams);			}

			case "layout_constrainedWidth": {
return layoutParams.constrainedWidth;			}

			case "layout_constrainedHeight": {
return layoutParams.constrainedHeight;			}

			case "layout_constraintHorizontal_bias": {
return layoutParams.horizontalBias;			}

			case "layout_constraintVertical_bias": {
return layoutParams.verticalBias;			}

			case "layout_constraintWidth_default": {
return layoutParams.matchConstraintDefaultWidth;			}

			case "layout_constraintHeight_default": {
return layoutParams.matchConstraintDefaultHeight;			}

			case "layout_constraintWidth_min": {
return layoutParams.matchConstraintMinWidth;			}

			case "layout_constraintWidth_max": {
return layoutParams.matchConstraintMaxWidth;			}

			case "layout_constraintWidth_percent": {
return layoutParams.matchConstraintPercentWidth;			}

			case "layout_constraintHeight_min": {
return layoutParams.matchConstraintMinHeight;			}

			case "layout_constraintHeight_max": {
return layoutParams.matchConstraintMaxHeight;			}

			case "layout_constraintHeight_percent": {
return layoutParams.matchConstraintPercentHeight;			}

			case "layout_constraintDimensionRatio": {
return layoutParams.dimensionRatio;			}

			case "layout_constraintHorizontal_weight": {
return layoutParams.horizontalWeight;			}

			case "layout_constraintVertical_weight": {
return layoutParams.verticalWeight;			}

			case "layout_constraintHorizontal_chainStyle": {
return layoutParams.horizontalChainStyle;			}

			case "layout_constraintVertical_chainStyle": {
return layoutParams.verticalChainStyle;			}

			case "layout_editor_absoluteX": {
return layoutParams.editorAbsoluteX;			}

			case "layout_editor_absoluteY": {
return layoutParams.editorAbsoluteY;			}

			case "layout_constraintTag": {
return layoutParams.constraintTag;			}

			case "layout_wrapBehaviorInParent": {
return layoutParams.wrapBehaviorInParent;			}

		}
		
		return null;

	}
	
		
	public class ConstraintLayoutExt extends androidx.constraintlayout.widget.ConstraintLayout implements ILifeCycleDecorator{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();

		public ConstraintLayoutExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public ConstraintLayoutExt(Context context) {
			super(context);
			
			
			
			
			
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


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
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
			
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
				ConstraintLayoutImpl.this.invalidate();
			}
		}	
		
		@Override
		public void onDraw(Canvas canvas) {
			Runnable runnable = () -> super.onDraw(canvas);
			executeMethodListeners("onDraw", runnable, canvas);
		}

		@Override
		public void draw(Canvas canvas) {
			Runnable runnable = () -> super.draw(canvas);
			executeMethodListeners("draw", runnable, canvas);
		}

		@SuppressLint("WrongCall")
		@Override
		public void execute(String method, Object... args) {
			switch (method) {
				case "onDraw":
					setOnMethodCalled(true);
					super.onDraw((Canvas) args[0]);
					break;

				case "draw":
					setOnMethodCalled(true);
					super.draw((Canvas) args[0]);
					break;

				default:
					break;
			}
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
        	ViewImpl.drawableStateChanged(ConstraintLayoutImpl.this);
        }
	}
	
	public void updateMeasuredDimension(int width, int height) {
		((ConstraintLayoutExt) constraintLayout).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "minWidth": {


	constraintLayout.setMinWidth((int)objValue);



			}
			break;
			case "minHeight": {


	constraintLayout.setMinHeight((int)objValue);



			}
			break;
			case "maxWidth": {


	constraintLayout.setMaxWidth((int)objValue);



			}
			break;
			case "maxHeight": {


	constraintLayout.setMaxHeight((int)objValue);



			}
			break;
			case "optimizationLevel": {


		 setOptimizationLevel(objValue);



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
			case "minWidth": {
return constraintLayout.getMinWidth();			}
			case "minHeight": {
return constraintLayout.getMinHeight();			}
			case "maxWidth": {
return constraintLayout.getMaxWidth();			}
			case "maxHeight": {
return constraintLayout.getMaxHeight();			}
			case "layout_optimizationLevel":
			case "optimizationLevel": {
return getOptimizationLevel();			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return constraintLayout;
    }
    private void nativeCreate(Map<String, Object> params) {
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
    
	

	@Override
	public void setId(String id){
		if (id == null) {
			id = UUID.randomUUID().toString();
		}
		if (id != null && !id.equals("")){
			super.setId(id);
			constraintLayout.setId(IdGenerator.getId(id));
		}
	}
	
    

	
private ConstraintLayoutCommandBuilder builder;
private ConstraintLayoutBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public ConstraintLayoutBean getBean() {
	if (bean == null) {
		bean = new ConstraintLayoutBean();
	}
	return bean;
}
public ConstraintLayoutCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new ConstraintLayoutCommandBuilder();
	}
	return builder;
}


public  class ConstraintLayoutCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <ConstraintLayoutCommandBuilder> {
    public ConstraintLayoutCommandBuilder() {
	}
	
	public ConstraintLayoutCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public ConstraintLayoutCommandBuilder tryGetMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandBuilder setMinWidth(String value) {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandBuilder tryGetMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandBuilder setMinHeight(String value) {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandBuilder tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandBuilder setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandBuilder tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandBuilder setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandBuilder tryGetOptimizationLevel() {
	Map<String, Object> attrs = initCommand("optimizationLevel");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getOptimizationLevel() {
	Map<String, Object> attrs = initCommand("optimizationLevel");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandBuilder setOptimizationLevel(String value) {
	Map<String, Object> attrs = initCommand("optimizationLevel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandBuilder tryGetLayout_optimizationLevel() {
	Map<String, Object> attrs = initCommand("optimizationLevel");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayout_optimizationLevel() {
	Map<String, Object> attrs = initCommand("optimizationLevel");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandBuilder setLayout_optimizationLevel(String value) {
	Map<String, Object> attrs = initCommand("layout_optimizationLevel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class ConstraintLayoutBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public ConstraintLayoutBean() {
			super(ConstraintLayoutImpl.this);
		}
public Object getMinWidth() {
	return getBuilder().reset().tryGetMinWidth().execute(false).getMinWidth(); 
}
public void setMinWidth(String value) {
	getBuilder().reset().setMinWidth(value).execute(true);
}

public Object getMinHeight() {
	return getBuilder().reset().tryGetMinHeight().execute(false).getMinHeight(); 
}
public void setMinHeight(String value) {
	getBuilder().reset().setMinHeight(value).execute(true);
}

public Object getMaxWidth() {
	return getBuilder().reset().tryGetMaxWidth().execute(false).getMaxWidth(); 
}
public void setMaxWidth(String value) {
	getBuilder().reset().setMaxWidth(value).execute(true);
}

public Object getMaxHeight() {
	return getBuilder().reset().tryGetMaxHeight().execute(false).getMaxHeight(); 
}
public void setMaxHeight(String value) {
	getBuilder().reset().setMaxHeight(value).execute(true);
}

public Object getOptimizationLevel() {
	return getBuilder().reset().tryGetOptimizationLevel().execute(false).getOptimizationLevel(); 
}
public void setOptimizationLevel(String value) {
	getBuilder().reset().setOptimizationLevel(value).execute(true);
}

public Object getLayout_optimizationLevel() {
	return getBuilder().reset().tryGetLayout_optimizationLevel().execute(false).getLayout_optimizationLevel();
}
public void setLayout_optimizationLevel(String value) {
	getBuilder().reset().setLayout_optimizationLevel(value).execute(true); 
}

}


private ConstraintLayoutCommandParamsBuilder paramsBuilder;
private ConstraintLayoutParamsBean paramsBean;

public ConstraintLayoutParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new ConstraintLayoutParamsBean();
	}
	return paramsBean;
}
public ConstraintLayoutCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new ConstraintLayoutCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class ConstraintLayoutParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
public Object getLayoutOrientation(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutOrientation().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutOrientation();
}
public void setLayoutOrientation(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutOrientation(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintCircle(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintCircle().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintCircle();
}
public void setLayoutConstraintCircle(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintCircle(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintCircleRadius(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintCircleRadius().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintCircleRadius();
}
public void setLayoutConstraintCircleRadius(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintCircleRadius(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintCircleAngle(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintCircleAngle().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintCircleAngle();
}
public void setLayoutConstraintCircleAngle(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintCircleAngle(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintGuide_begin(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintGuide_begin().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintGuide_begin();
}
public void setLayoutConstraintGuide_begin(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintGuide_begin(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintGuide_end(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintGuide_end().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintGuide_end();
}
public void setLayoutConstraintGuide_end(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintGuide_end(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintGuide_percent(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintGuide_percent().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintGuide_percent();
}
public void setLayoutConstraintGuide_percent(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintGuide_percent(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintLeft_toLeftOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintLeft_toLeftOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintLeft_toLeftOf();
}
public void setLayoutConstraintLeft_toLeftOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintLeft_toLeftOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintLeft_toRightOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintLeft_toRightOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintLeft_toRightOf();
}
public void setLayoutConstraintLeft_toRightOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintLeft_toRightOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintRight_toLeftOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintRight_toLeftOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintRight_toLeftOf();
}
public void setLayoutConstraintRight_toLeftOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintRight_toLeftOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintRight_toRightOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintRight_toRightOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintRight_toRightOf();
}
public void setLayoutConstraintRight_toRightOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintRight_toRightOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintTop_toTopOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintTop_toTopOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintTop_toTopOf();
}
public void setLayoutConstraintTop_toTopOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintTop_toTopOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintTop_toBottomOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintTop_toBottomOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintTop_toBottomOf();
}
public void setLayoutConstraintTop_toBottomOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintTop_toBottomOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintBottom_toTopOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintBottom_toTopOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintBottom_toTopOf();
}
public void setLayoutConstraintBottom_toTopOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintBottom_toTopOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintBottom_toBottomOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintBottom_toBottomOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintBottom_toBottomOf();
}
public void setLayoutConstraintBottom_toBottomOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintBottom_toBottomOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintBaseline_toBaselineOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintBaseline_toBaselineOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintBaseline_toBaselineOf();
}
public void setLayoutConstraintBaseline_toBaselineOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintBaseline_toBaselineOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintBaseline_toTopOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintBaseline_toTopOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintBaseline_toTopOf();
}
public void setLayoutConstraintBaseline_toTopOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintBaseline_toTopOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintBaseline_toBottomOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintBaseline_toBottomOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintBaseline_toBottomOf();
}
public void setLayoutConstraintBaseline_toBottomOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintBaseline_toBottomOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintStart_toEndOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintStart_toEndOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintStart_toEndOf();
}
public void setLayoutConstraintStart_toEndOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintStart_toEndOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintStart_toStartOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintStart_toStartOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintStart_toStartOf();
}
public void setLayoutConstraintStart_toStartOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintStart_toStartOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintEnd_toStartOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintEnd_toStartOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintEnd_toStartOf();
}
public void setLayoutConstraintEnd_toStartOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintEnd_toStartOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintEnd_toEndOf(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintEnd_toEndOf().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintEnd_toEndOf();
}
public void setLayoutConstraintEnd_toEndOf(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintEnd_toEndOf(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutGoneMarginLeft(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutGoneMarginLeft().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutGoneMarginLeft();
}
public void setLayoutGoneMarginLeft(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGoneMarginLeft(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutGoneMarginTop(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutGoneMarginTop().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutGoneMarginTop();
}
public void setLayoutGoneMarginTop(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGoneMarginTop(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutGoneMarginRight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutGoneMarginRight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutGoneMarginRight();
}
public void setLayoutGoneMarginRight(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGoneMarginRight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutGoneMarginBottom(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutGoneMarginBottom().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutGoneMarginBottom();
}
public void setLayoutGoneMarginBottom(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGoneMarginBottom(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutGoneMarginStart(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutGoneMarginStart().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutGoneMarginStart();
}
public void setLayoutGoneMarginStart(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGoneMarginStart(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutGoneMarginEnd(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutGoneMarginEnd().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutGoneMarginEnd();
}
public void setLayoutGoneMarginEnd(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGoneMarginEnd(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutGoneMarginBaseline(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutGoneMarginBaseline().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutGoneMarginBaseline();
}
public void setLayoutGoneMarginBaseline(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGoneMarginBaseline(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutMarginBaseline(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutMarginBaseline().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutMarginBaseline();
}
public void setLayoutMarginBaseline(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutMarginBaseline(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintWidth(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintWidth().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintWidth();
}
public void setLayoutConstraintWidth(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintWidth(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintHeight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintHeight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintHeight();
}
public void setLayoutConstraintHeight(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintHeight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutConstrainedWidth(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstrainedWidth().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutConstrainedWidth();
}
public void setLayoutConstrainedWidth(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstrainedWidth(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object isLayoutConstrainedHeight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstrainedHeight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().isLayoutConstrainedHeight();
}
public void setLayoutConstrainedHeight(IWidget w, boolean value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstrainedHeight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintHorizontal_bias(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintHorizontal_bias().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintHorizontal_bias();
}
public void setLayoutConstraintHorizontal_bias(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintHorizontal_bias(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintVertical_bias(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintVertical_bias().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintVertical_bias();
}
public void setLayoutConstraintVertical_bias(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintVertical_bias(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintWidth_default(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintWidth_default().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintWidth_default();
}
public void setLayoutConstraintWidth_default(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintWidth_default(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintHeight_default(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintHeight_default().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintHeight_default();
}
public void setLayoutConstraintHeight_default(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintHeight_default(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintWidth_min(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintWidth_min().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintWidth_min();
}
public void setLayoutConstraintWidth_min(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintWidth_min(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintWidth_max(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintWidth_max().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintWidth_max();
}
public void setLayoutConstraintWidth_max(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintWidth_max(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintWidth_percent(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintWidth_percent().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintWidth_percent();
}
public void setLayoutConstraintWidth_percent(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintWidth_percent(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintHeight_min(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintHeight_min().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintHeight_min();
}
public void setLayoutConstraintHeight_min(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintHeight_min(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintHeight_max(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintHeight_max().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintHeight_max();
}
public void setLayoutConstraintHeight_max(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintHeight_max(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintHeight_percent(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintHeight_percent().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintHeight_percent();
}
public void setLayoutConstraintHeight_percent(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintHeight_percent(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintDimensionRatio(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintDimensionRatio().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintDimensionRatio();
}
public void setLayoutConstraintDimensionRatio(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintDimensionRatio(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintHorizontal_weight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintHorizontal_weight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintHorizontal_weight();
}
public void setLayoutConstraintHorizontal_weight(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintHorizontal_weight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintVertical_weight(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintVertical_weight().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintVertical_weight();
}
public void setLayoutConstraintVertical_weight(IWidget w, float value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintVertical_weight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintHorizontal_chainStyle(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintHorizontal_chainStyle().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintHorizontal_chainStyle();
}
public void setLayoutConstraintHorizontal_chainStyle(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintHorizontal_chainStyle(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintVertical_chainStyle(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintVertical_chainStyle().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintVertical_chainStyle();
}
public void setLayoutConstraintVertical_chainStyle(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintVertical_chainStyle(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutEditor_absoluteX(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutEditor_absoluteX().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutEditor_absoluteX();
}
public void setLayoutEditor_absoluteX(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutEditor_absoluteX(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutEditor_absoluteY(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutEditor_absoluteY().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutEditor_absoluteY();
}
public void setLayoutEditor_absoluteY(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutEditor_absoluteY(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutConstraintTag(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutConstraintTag().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutConstraintTag();
}
public void setLayoutConstraintTag(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutConstraintTag(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public Object getLayoutWrapBehaviorInParent(IWidget w) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	java.util.Map<String, Object> command = getParamsBuilder().reset().tryGetLayoutWrapBehaviorInParent().getCommand();
	
	layoutParams.put("layoutParams", command);
	w.executeCommand(layoutParams, null, COMMAND_EXEC_GETTER_METHOD); 
	return getParamsBuilder().getLayoutWrapBehaviorInParent();
}
public void setLayoutWrapBehaviorInParent(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutWrapBehaviorInParent(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

}





public class ConstraintLayoutCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<ConstraintLayoutCommandParamsBuilder>{
public ConstraintLayoutCommandParamsBuilder tryGetLayoutOrientation() {
	Map<String, Object> attrs = initCommand("layout_orientation");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutOrientation() {
	Map<String, Object> attrs = initCommand("layout_orientation");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutOrientation(String value) {
	Map<String, Object> attrs = initCommand("layout_orientation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintCircle() {
	Map<String, Object> attrs = initCommand("layout_constraintCircle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintCircle() {
	Map<String, Object> attrs = initCommand("layout_constraintCircle");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintCircle(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintCircle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintCircleRadius() {
	Map<String, Object> attrs = initCommand("layout_constraintCircleRadius");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintCircleRadius() {
	Map<String, Object> attrs = initCommand("layout_constraintCircleRadius");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintCircleRadius(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintCircleRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintCircleAngle() {
	Map<String, Object> attrs = initCommand("layout_constraintCircleAngle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintCircleAngle() {
	Map<String, Object> attrs = initCommand("layout_constraintCircleAngle");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintCircleAngle(float value) {
	Map<String, Object> attrs = initCommand("layout_constraintCircleAngle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintGuide_begin() {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_begin");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintGuide_begin() {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_begin");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintGuide_begin(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_begin");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintGuide_end() {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_end");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintGuide_end() {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_end");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintGuide_end(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_end");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintGuide_percent() {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_percent");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintGuide_percent() {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_percent");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintGuide_percent(float value) {
	Map<String, Object> attrs = initCommand("layout_constraintGuide_percent");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintLeft_toLeftOf() {
	Map<String, Object> attrs = initCommand("layout_constraintLeft_toLeftOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintLeft_toLeftOf() {
	Map<String, Object> attrs = initCommand("layout_constraintLeft_toLeftOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintLeft_toLeftOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintLeft_toLeftOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintLeft_toRightOf() {
	Map<String, Object> attrs = initCommand("layout_constraintLeft_toRightOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintLeft_toRightOf() {
	Map<String, Object> attrs = initCommand("layout_constraintLeft_toRightOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintLeft_toRightOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintLeft_toRightOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintRight_toLeftOf() {
	Map<String, Object> attrs = initCommand("layout_constraintRight_toLeftOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintRight_toLeftOf() {
	Map<String, Object> attrs = initCommand("layout_constraintRight_toLeftOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintRight_toLeftOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintRight_toLeftOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintRight_toRightOf() {
	Map<String, Object> attrs = initCommand("layout_constraintRight_toRightOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintRight_toRightOf() {
	Map<String, Object> attrs = initCommand("layout_constraintRight_toRightOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintRight_toRightOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintRight_toRightOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintTop_toTopOf() {
	Map<String, Object> attrs = initCommand("layout_constraintTop_toTopOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintTop_toTopOf() {
	Map<String, Object> attrs = initCommand("layout_constraintTop_toTopOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintTop_toTopOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintTop_toTopOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintTop_toBottomOf() {
	Map<String, Object> attrs = initCommand("layout_constraintTop_toBottomOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintTop_toBottomOf() {
	Map<String, Object> attrs = initCommand("layout_constraintTop_toBottomOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintTop_toBottomOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintTop_toBottomOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintBottom_toTopOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBottom_toTopOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintBottom_toTopOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBottom_toTopOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintBottom_toTopOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintBottom_toTopOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintBottom_toBottomOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBottom_toBottomOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintBottom_toBottomOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBottom_toBottomOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintBottom_toBottomOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintBottom_toBottomOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintBaseline_toBaselineOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toBaselineOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintBaseline_toBaselineOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toBaselineOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintBaseline_toBaselineOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toBaselineOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintBaseline_toTopOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toTopOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintBaseline_toTopOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toTopOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintBaseline_toTopOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toTopOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintBaseline_toBottomOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toBottomOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintBaseline_toBottomOf() {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toBottomOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintBaseline_toBottomOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintBaseline_toBottomOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintStart_toEndOf() {
	Map<String, Object> attrs = initCommand("layout_constraintStart_toEndOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintStart_toEndOf() {
	Map<String, Object> attrs = initCommand("layout_constraintStart_toEndOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintStart_toEndOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintStart_toEndOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintStart_toStartOf() {
	Map<String, Object> attrs = initCommand("layout_constraintStart_toStartOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintStart_toStartOf() {
	Map<String, Object> attrs = initCommand("layout_constraintStart_toStartOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintStart_toStartOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintStart_toStartOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintEnd_toStartOf() {
	Map<String, Object> attrs = initCommand("layout_constraintEnd_toStartOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintEnd_toStartOf() {
	Map<String, Object> attrs = initCommand("layout_constraintEnd_toStartOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintEnd_toStartOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintEnd_toStartOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintEnd_toEndOf() {
	Map<String, Object> attrs = initCommand("layout_constraintEnd_toEndOf");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintEnd_toEndOf() {
	Map<String, Object> attrs = initCommand("layout_constraintEnd_toEndOf");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintEnd_toEndOf(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintEnd_toEndOf");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutGoneMarginLeft() {
	Map<String, Object> attrs = initCommand("layout_goneMarginLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGoneMarginLeft() {
	Map<String, Object> attrs = initCommand("layout_goneMarginLeft");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutGoneMarginLeft(String value) {
	Map<String, Object> attrs = initCommand("layout_goneMarginLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutGoneMarginTop() {
	Map<String, Object> attrs = initCommand("layout_goneMarginTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGoneMarginTop() {
	Map<String, Object> attrs = initCommand("layout_goneMarginTop");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutGoneMarginTop(String value) {
	Map<String, Object> attrs = initCommand("layout_goneMarginTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutGoneMarginRight() {
	Map<String, Object> attrs = initCommand("layout_goneMarginRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGoneMarginRight() {
	Map<String, Object> attrs = initCommand("layout_goneMarginRight");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutGoneMarginRight(String value) {
	Map<String, Object> attrs = initCommand("layout_goneMarginRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutGoneMarginBottom() {
	Map<String, Object> attrs = initCommand("layout_goneMarginBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGoneMarginBottom() {
	Map<String, Object> attrs = initCommand("layout_goneMarginBottom");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutGoneMarginBottom(String value) {
	Map<String, Object> attrs = initCommand("layout_goneMarginBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutGoneMarginStart() {
	Map<String, Object> attrs = initCommand("layout_goneMarginStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGoneMarginStart() {
	Map<String, Object> attrs = initCommand("layout_goneMarginStart");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutGoneMarginStart(String value) {
	Map<String, Object> attrs = initCommand("layout_goneMarginStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutGoneMarginEnd() {
	Map<String, Object> attrs = initCommand("layout_goneMarginEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGoneMarginEnd() {
	Map<String, Object> attrs = initCommand("layout_goneMarginEnd");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutGoneMarginEnd(String value) {
	Map<String, Object> attrs = initCommand("layout_goneMarginEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutGoneMarginBaseline() {
	Map<String, Object> attrs = initCommand("layout_goneMarginBaseline");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutGoneMarginBaseline() {
	Map<String, Object> attrs = initCommand("layout_goneMarginBaseline");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutGoneMarginBaseline(String value) {
	Map<String, Object> attrs = initCommand("layout_goneMarginBaseline");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutMarginBaseline() {
	Map<String, Object> attrs = initCommand("layout_marginBaseline");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutMarginBaseline() {
	Map<String, Object> attrs = initCommand("layout_marginBaseline");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutMarginBaseline(String value) {
	Map<String, Object> attrs = initCommand("layout_marginBaseline");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintWidth() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintWidth() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintWidth(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintHeight() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintHeight() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintHeight(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstrainedWidth() {
	Map<String, Object> attrs = initCommand("layout_constrainedWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutConstrainedWidth() {
	Map<String, Object> attrs = initCommand("layout_constrainedWidth");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstrainedWidth(boolean value) {
	Map<String, Object> attrs = initCommand("layout_constrainedWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstrainedHeight() {
	Map<String, Object> attrs = initCommand("layout_constrainedHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isLayoutConstrainedHeight() {
	Map<String, Object> attrs = initCommand("layout_constrainedHeight");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstrainedHeight(boolean value) {
	Map<String, Object> attrs = initCommand("layout_constrainedHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintHorizontal_bias() {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_bias");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintHorizontal_bias() {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_bias");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintHorizontal_bias(float value) {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_bias");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintVertical_bias() {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_bias");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintVertical_bias() {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_bias");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintVertical_bias(float value) {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_bias");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintWidth_default() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_default");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintWidth_default() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_default");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintWidth_default(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_default");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintHeight_default() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_default");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintHeight_default() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_default");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintHeight_default(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_default");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintWidth_min() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_min");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintWidth_min() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_min");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintWidth_min(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_min");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintWidth_max() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_max");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintWidth_max() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_max");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintWidth_max(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_max");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintWidth_percent() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_percent");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintWidth_percent() {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_percent");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintWidth_percent(float value) {
	Map<String, Object> attrs = initCommand("layout_constraintWidth_percent");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintHeight_min() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_min");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintHeight_min() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_min");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintHeight_min(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_min");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintHeight_max() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_max");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintHeight_max() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_max");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintHeight_max(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_max");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintHeight_percent() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_percent");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintHeight_percent() {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_percent");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintHeight_percent(float value) {
	Map<String, Object> attrs = initCommand("layout_constraintHeight_percent");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintDimensionRatio() {
	Map<String, Object> attrs = initCommand("layout_constraintDimensionRatio");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintDimensionRatio() {
	Map<String, Object> attrs = initCommand("layout_constraintDimensionRatio");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintDimensionRatio(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintDimensionRatio");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintHorizontal_weight() {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_weight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintHorizontal_weight() {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_weight");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintHorizontal_weight(float value) {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_weight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintVertical_weight() {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_weight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintVertical_weight() {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_weight");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintVertical_weight(float value) {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_weight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintHorizontal_chainStyle() {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_chainStyle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintHorizontal_chainStyle() {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_chainStyle");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintHorizontal_chainStyle(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintHorizontal_chainStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintVertical_chainStyle() {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_chainStyle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintVertical_chainStyle() {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_chainStyle");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintVertical_chainStyle(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintVertical_chainStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutEditor_absoluteX() {
	Map<String, Object> attrs = initCommand("layout_editor_absoluteX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutEditor_absoluteX() {
	Map<String, Object> attrs = initCommand("layout_editor_absoluteX");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutEditor_absoluteX(String value) {
	Map<String, Object> attrs = initCommand("layout_editor_absoluteX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutEditor_absoluteY() {
	Map<String, Object> attrs = initCommand("layout_editor_absoluteY");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutEditor_absoluteY() {
	Map<String, Object> attrs = initCommand("layout_editor_absoluteY");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutEditor_absoluteY(String value) {
	Map<String, Object> attrs = initCommand("layout_editor_absoluteY");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutConstraintTag() {
	Map<String, Object> attrs = initCommand("layout_constraintTag");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutConstraintTag() {
	Map<String, Object> attrs = initCommand("layout_constraintTag");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutConstraintTag(String value) {
	Map<String, Object> attrs = initCommand("layout_constraintTag");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public ConstraintLayoutCommandParamsBuilder tryGetLayoutWrapBehaviorInParent() {
	Map<String, Object> attrs = initCommand("layout_wrapBehaviorInParent");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getLayoutWrapBehaviorInParent() {
	Map<String, Object> attrs = initCommand("layout_wrapBehaviorInParent");
	return attrs.get("commandReturnValue");
}
public ConstraintLayoutCommandParamsBuilder setLayoutWrapBehaviorInParent(String value) {
	Map<String, Object> attrs = initCommand("layout_wrapBehaviorInParent");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}

	//end - body
	//start - codecopy
	private void setLayout_constraintHeight(androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams, Object objValue) {
		layoutParams.height = (int) objValue;
		layoutParams.constrainedHeight = true;
	}
	
	private void setLayout_constraintWidth(androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams, Object objValue) {
		layoutParams.width = (int) objValue;
		layoutParams.constrainedWidth = true;
	}
	
	
	
	private Object getLayout_constraintHeight(androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
		return layoutParams.height;
	}
	
	private Object getLayout_constraintWidth(androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
		return layoutParams.width;
	}
	
	
	private void setOptimizationLevel(Object objValue) {
		constraintLayout.setOptimizationLevel((int) objValue);
	}
	
	
	
	private Object getOptimizationLevel() {
		return constraintLayout.getOptimizationLevel();
	}
	//end - codecopy
}
