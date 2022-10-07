package com.ashera.layout;
//start - imports
import java.util.*;

import r.android.content.Context;
import r.android.os.Build;
import r.android.view.View;
import r.android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;

/*-[
#include <UIKit/UIKit.h>
#include "ASUIView.h"
]-*/
import com.google.j2objc.annotations.Property;
import androidx.core.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports
/*-[
#include "ASUITapGestureRecognizer.h"
#include "ASUILongTapGestureRecognizer.h"
]-*/
import r.android.view.View.MotionEvent;
import r.android.view.View.DragEvent;
import r.android.view.KeyEvent;
import r.android.view.MenuItem;

public class ViewImpl {
	// start - body
	private ViewImpl() {
	}
	
		@SuppressLint("NewApi")
		final static class IosAccessibilityTraits extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("uiaccessibilitytraitadjustable",  LayoutNativeVars.UIAccessibilityTraitAdjustable);
				mapping.put("uiaccessibilitytraitallowsdirectinteraction",  LayoutNativeVars.UIAccessibilityTraitAllowsDirectInteraction);
				mapping.put("uiaccessibilitytraitbutton",  LayoutNativeVars.UIAccessibilityTraitButton);
				mapping.put("uiaccessibilitytraitcausespageturn",  LayoutNativeVars.UIAccessibilityTraitCausesPageTurn);
				mapping.put("uiaccessibilitytraitheader",  LayoutNativeVars.UIAccessibilityTraitHeader);
				mapping.put("uiaccessibilitytraitimage",  LayoutNativeVars.UIAccessibilityTraitImage);
				mapping.put("uiaccessibilitytraitkeyboardkey",  LayoutNativeVars.UIAccessibilityTraitKeyboardKey);
				mapping.put("uiaccessibilitytraitlink",  LayoutNativeVars.UIAccessibilityTraitLink);
				mapping.put("uiaccessibilitytraitnone",  LayoutNativeVars.UIAccessibilityTraitNone);
				mapping.put("uiaccessibilitytraitnotenabled",  LayoutNativeVars.UIAccessibilityTraitNotEnabled);
				mapping.put("uiaccessibilitytraitplayssound",  LayoutNativeVars.UIAccessibilityTraitPlaysSound);
				mapping.put("uiaccessibilitytraitsearchfield",  LayoutNativeVars.UIAccessibilityTraitSearchField);
				mapping.put("uiaccessibilitytraitselected",  LayoutNativeVars.UIAccessibilityTraitSelected);
				mapping.put("uiaccessibilitytraitstartsmediasession",  LayoutNativeVars.UIAccessibilityTraitStartsMediaSession);
				mapping.put("uiaccessibilitytraitstatictext",  LayoutNativeVars.UIAccessibilityTraitStaticText);
				mapping.put("uiaccessibilitytraitsummaryelement",  LayoutNativeVars.UIAccessibilityTraitSummaryElement);
				mapping.put("uiaccessibilitytraittabbar",  LayoutNativeVars.UIAccessibilityTraitTabBar);
				mapping.put("uiaccessibilitytraitupdatesfrequently",  LayoutNativeVars.UIAccessibilityTraitUpdatesFrequently);
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
		final static class BackgroundRepeat extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("no-repeat",  0x0);
				mapping.put("repeat",  0x1);
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
		final static class BackgroundTintMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("add",  LayoutNativeVars.kCGBlendModeOverlay);
				mapping.put("multiply",  LayoutNativeVars.kCGBlendModeMultiply);
				mapping.put("screen",  LayoutNativeVars.kCGBlendModeScreen);
				mapping.put("src_atop",  LayoutNativeVars.kCGBlendModeSourceAtop);
				mapping.put("src_in",  LayoutNativeVars.kCGBlendModeSourceIn);
				mapping.put("src_over",  LayoutNativeVars.kCGBlendModeNormal);
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
		final static class ForegroundRepeat extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("no-repeat",  0x0);
				mapping.put("repeat",  0x1);
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
		final static class ForegroundTintMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("add",  LayoutNativeVars.kCGBlendModeOverlay);
				mapping.put("multiply",  LayoutNativeVars.kCGBlendModeMultiply);
				mapping.put("screen",  LayoutNativeVars.kCGBlendModeScreen);
				mapping.put("src_atop",  LayoutNativeVars.kCGBlendModeSourceAtop);
				mapping.put("src_in",  LayoutNativeVars.kCGBlendModeSourceIn);
				mapping.put("src_over",  LayoutNativeVars.kCGBlendModeNormal);
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
		final static class Visibility extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("gone",  0x8);
				mapping.put("invisible",  0x4);
				mapping.put("visible",  0x0);
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
		final static class LayoutDirection extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("inherit",  0x2);
				mapping.put("locale",  0x3);
				mapping.put("ltr",  0x0);
				mapping.put("rtl",  0x1);
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
		final static class TextDirection extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("anyRtl",  0x2);
				mapping.put("firstStrong",  0x1);
				mapping.put("firstStrongLtr",  0x6);
				mapping.put("firstStrongRtl",  0x7);
				mapping.put("inherit",  0x0);
				mapping.put("locale",  0x5);
				mapping.put("ltr",  0x3);
				mapping.put("rtl",  0x4);
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
		final static class TextAlignment extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("center",  0x4);
				mapping.put("gravity",  0x1);
				mapping.put("inherit",  0x0);
				mapping.put("textEnd",  0x3);
				mapping.put("textStart",  0x2);
				mapping.put("viewEnd",  0x6);
				mapping.put("viewStart",  0x5);
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
		final static class Vtype extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("email",  0x1);
				mapping.put("time",  0x2);
				mapping.put("date",  0x3);
				mapping.put("url",  0x4);
				mapping.put("tel",  0x5);
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
		final static class ValidationErrorDisplay  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("popup", 0x1);
				mapping.put("label", 0x2);
				mapping.put("style", 0x4);
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
	public static void register(String localName) {

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosBackgroundColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsHidden").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAlpha").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsOpaque").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosTintColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosClipsToBounds").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosClearsContextBeforeDrawing").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsUserInteractionEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsMultipleTouchEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsExclusiveTouch").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosPreservesSuperviewLayoutMargins").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosInsetsLayoutMarginsFromSafeArea").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAutoresizesSubviews").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosTranslatesAutoresizingMaskIntoConstraints").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosContentScaleFactor").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsFocused").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosRestorationIdentifier").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosTag").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAccessibilityIgnoresInvertColors").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosLargeContentImage").withType("image"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosLargeContentTitle").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosScalesLargeContentImage").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosShowsLargeContentViewer").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosIsAccessibilityElement").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("focusable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAccessibilityLabel").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAccessibilityHint").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contentDescription").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAccessibilityValue").withType("resourcestring"));
		ConverterFactory.register("View.iosAccessibilityTraits", new IosAccessibilityTraits());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosAccessibilityTraits").withType("View.iosAccessibilityTraits"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("id").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelSyncEvents").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelParam").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelPojoToUi").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelUiToPojo").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelPojoToUiParams").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("refreshUiFromModel").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelUiToPojoEventIds").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("updateModelData").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("notifyDataSetChanged").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("background").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		ConverterFactory.register("View.backgroundRepeat", new BackgroundRepeat());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundRepeat").withType("View.backgroundRepeat").withOrder(-10).withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onClick").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onTouch").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("attributeUnderTest").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundTint").withType("colorstate").withOrder(-10).withUiFlag(UPDATE_UI_INVALIDATE));
		ConverterFactory.register("View.backgroundTintMode", new BackgroundTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundTintMode").withType("View.backgroundTintMode").withOrder(-10).withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foreground").withType("drawable").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		ConverterFactory.register("View.foregroundRepeat", new ForegroundRepeat());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundRepeat").withType("View.foregroundRepeat").withOrder(-10).withUiFlag(UPDATE_UI_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundTint").withType("colorstate").withOrder(-10).withUiFlag(UPDATE_UI_INVALIDATE));
		ConverterFactory.register("View.foregroundTintMode", new ForegroundTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundTintMode").withType("View.foregroundTintMode").withOrder(-10).withUiFlag(UPDATE_UI_INVALIDATE));
		ConverterFactory.register("View.visibility", new Visibility());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("visibility").withType("View.visibility").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("alpha").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onLongClick").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("longClickable").withType("boolean").withOrder(1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("clickable").withType("boolean").withOrder(1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("translationX").withType("dimensionfloat").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("translationY").withType("dimensionfloat").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("translationZ").withType("dimensionfloat").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("rotation").withType("float").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("rotationX").withType("float").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("rotationY").withType("float").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scaleX").withType("float").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scaleY").withType("float").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("transformPivotX").withType("dimensionfloat").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("transformPivotY").withType("dimensionfloat").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("invalidate").withType("nil"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("requestLayout").withType("nil"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("keepScreenOn").withType("boolean"));
		ConverterFactory.register("View.layoutDirection", new LayoutDirection());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layoutDirection").withType("View.layoutDirection").beforeChildAdd());
		ConverterFactory.register("View.textDirection", new TextDirection());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textDirection").withType("View.textDirection").withOrder(100));
		ConverterFactory.register("View.textAlignment", new TextAlignment());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAlignment").withType("View.textAlignment"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onDrag").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("asDragSource").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("duplicateParentState").withType("boolean").beforeChildAdd());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundGravity").withType("gravity").withUiFlag(UPDATE_UI_REQUEST_LAYOUT_N_INVALIDATE));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onKey").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosLayerBorderWidth").withType("dimensionfloat").withSimpleWrapableViewStrategy(APPLY_TO_VIEW_HOLDER));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosLayerBorderColor").withType("color").withSimpleWrapableViewStrategy(APPLY_TO_VIEW_HOLDER));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosLayerCornerRadius").withType("dimensionfloat").withSimpleWrapableViewStrategy(APPLY_TO_VIEW_HOLDER));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("iosLayerMasksToBounds").withType("boolean").withSimpleWrapableViewStrategy(APPLY_TO_VIEW_HOLDER));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("zIndex").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selected").withType("boolean").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("style").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("errorStyle").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("validateForm").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("validation").withType("array").withArrayType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("v_required").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("v_minlength").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("v_maxlength").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("v_min").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("v_max").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("v_pattern").withType("resourcestring"));
		ConverterFactory.register("View.vtype", new Vtype());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("v_type").withType("View.vtype"));
		ConverterFactory.register("View.validationErrorDisplay", new ValidationErrorDisplay());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("validationErrorDisplayType").withType("View.validationErrorDisplay"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("customErrorMessageValues").withType("array").withArrayType("resourcestring").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("customErrorMessageKeys").withType("array").withArrayType("resourcestring").withOrder(-1));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("invalidateOnFrameChange").withType("boolean"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("formGroupId").withType("string"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("enableFeatures").withType("string"));
		
		java.util.List<IAttributable> attributables = WidgetFactory.getAttributables("View", localName);
		if (attributables != null) {
			for (IAttributable attributable : attributables) {
				attributable.loadAttributes(localName);
			}
		}
	}

	@SuppressLint("NewApi")
	public static void setAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		setAttribute(w, w.asNativeWidget(), key, strValue, objValue, decorator);
	}
	@SuppressLint("NewApi")
	public static void setAttribute(IWidget w, SimpleWrapableView wrapperView, WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		if (wrapperView.isViewWrapped() && key.getSimpleWrapableViewStrategy() != 0) {
			if ((key.getSimpleWrapableViewStrategy() & IWidget.APPLY_TO_VIEW_WRAPPER) != 0) {
				setAttribute(w, wrapperView.getWrappedView(), key, strValue, objValue, decorator);
			}
			
			if ((key.getSimpleWrapableViewStrategy() & IWidget.APPLY_TO_VIEW_HOLDER) != 0) {
				setAttribute(w, wrapperView.getWrapperViewHolder(), key, strValue, objValue, decorator);
			}
			
			if (((key.getSimpleWrapableViewStrategy() & IWidget.APPLY_TO_FOREGROUND) != 0) && wrapperView.getForeground() != null) {
				setAttribute(w, wrapperView.getForeground(), key, strValue, objValue, decorator);
			}
		} else {
			setAttribute(w, w.asNativeWidget(), key, strValue, objValue, decorator);
		}
	}
	@SuppressLint("NewApi")
	private static void setAttribute(IWidget w, Object nativeWidget, WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		switch (key.getAttributeName()) {
		case "iosBackgroundColor": {


		setBackgroundColor(nativeWidget, objValue);



			}
			break;
		case "iosIsHidden": {


		setIsHidden(nativeWidget, objValue);



			}
			break;
		case "iosAlpha": {


		setAlpha(nativeWidget, objValue);



			}
			break;
		case "iosIsOpaque": {


		setIsOpaque(nativeWidget, objValue);



			}
			break;
		case "iosTintColor": {


		setTintColor(nativeWidget, objValue);



			}
			break;
		case "iosClipsToBounds": {


		setClipsToBounds(nativeWidget, objValue);



			}
			break;
		case "iosClearsContextBeforeDrawing": {


		setClearsContextBeforeDrawing(nativeWidget, objValue);



			}
			break;
		case "iosIsUserInteractionEnabled": {


		setIsUserInteractionEnabled(nativeWidget, objValue);



			}
			break;
		case "iosIsMultipleTouchEnabled": {


		setIsMultipleTouchEnabled(nativeWidget, objValue);



			}
			break;
		case "iosIsExclusiveTouch": {


		setIsExclusiveTouch(nativeWidget, objValue);



			}
			break;
		case "iosPreservesSuperviewLayoutMargins": {


		setPreservesSuperviewLayoutMargins(nativeWidget, objValue);



			}
			break;
		case "iosInsetsLayoutMarginsFromSafeArea": {


		setInsetsLayoutMarginsFromSafeArea(nativeWidget, objValue);



			}
			break;
		case "iosAutoresizesSubviews": {


		setAutoresizesSubviews(nativeWidget, objValue);



			}
			break;
		case "iosTranslatesAutoresizingMaskIntoConstraints": {


		setTranslatesAutoresizingMaskIntoConstraints(nativeWidget, objValue);



			}
			break;
		case "iosContentScaleFactor": {


		setContentScaleFactor(nativeWidget, objValue);



			}
			break;
		
		case "iosRestorationIdentifier": {


		setRestorationIdentifier(nativeWidget, objValue);



			}
			break;
		case "iosTag": {


		setTag(nativeWidget, objValue);



			}
			break;
		case "iosAccessibilityIgnoresInvertColors": {


		setAccessibilityIgnoresInvertColors(nativeWidget, objValue);



			}
			break;
		case "iosLargeContentImage": {
if (checkIosVersion("13.0")) {

		setLargeContentImage(nativeWidget, objValue);

}

			}
			break;
		case "iosLargeContentTitle": {
if (checkIosVersion("13.0")) {

		setLargeContentTitle(nativeWidget, objValue);

}

			}
			break;
		case "iosScalesLargeContentImage": {
if (checkIosVersion("13.0")) {

		setScalesLargeContentImage(nativeWidget, objValue);

}

			}
			break;
		case "iosShowsLargeContentViewer": {
if (checkIosVersion("13.0")) {

		setShowsLargeContentViewer(nativeWidget, objValue);

}

			}
			break;
			case "focusable":
		case "iosIsAccessibilityElement": {


		setIsAccessibilityElement(nativeWidget, objValue);



			}
			break;
		case "iosAccessibilityLabel": {


		setAccessibilityLabel(nativeWidget, objValue);



			}
			break;
			case "contentDescription":
		case "iosAccessibilityHint": {


		setAccessibilityHint(nativeWidget, objValue);



			}
			break;
		case "iosAccessibilityValue": {


		setAccessibilityValue(nativeWidget, objValue);



			}
			break;
		case "iosAccessibilityTraits": {


		setAccessibilityTraits(nativeWidget, objValue);



			}
			break;
		case "id": {


		setId(w, strValue, objValue, view);



			}
			break;
		case "modelSyncEvents": {


		setModelSyncEvents(w, strValue, objValue, view);



			}
			break;
		case "modelParam": {


		setModelParam(w, strValue, objValue, view);



			}
			break;
		case "modelPojoToUi": {


		setModelPojoToUi(w, strValue, objValue, view);



			}
			break;
		case "modelUiToPojo": {


		setModelUiToPojo(w, strValue, objValue, view);



			}
			break;
		case "modelPojoToUiParams": {


		setModelPojoToUiParams(w, objValue);



			}
			break;
		case "refreshUiFromModel": {


		refreshUiFromModel(w, objValue);



			}
			break;
		case "modelUiToPojoEventIds": {


		setModelUiToPojoEventIds(w, objValue);



			}
			break;
		case "updateModelData": {
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object expression = w.quickConvert(data.get("expression"), "string");
		Object payload = w.quickConvert(data.get("payload"), "object");


		 updateModelData(w, expression, payload);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object expression = w.quickConvert(data.get("expression"), "string");
		Object payload = w.quickConvert(data.get("payload"), "object");


		 updateModelData(w, expression, payload);


	}
}
			}
			break;
		case "notifyDataSetChanged": {


		 notifyDataSetChanged(w, objValue);



			}
			break;
		case "background": {


		setBackground(w, nativeWidget, objValue);



			}
			break;
		case "backgroundRepeat": {


		setBackgroundRepeat(w, strValue, objValue, view);



			}
			break;
		case "onClick": {


		 setOnClick(w, nativeWidget, objValue);



			}
			break;
		case "onTouch": {


		 setOnTouch(w, nativeWidget, objValue);



			}
			break;
		case "minWidth": {


		 setMinWidth(w, objValue);



			}
			break;
		case "minHeight": {


		 setMinHeight(w, objValue);



			}
			break;
		case "attributeUnderTest": {


		 //



			}
			break;
		case "backgroundTint": {


		setBackgroundTint(w,objValue);



			}
			break;
		case "backgroundTintMode": {


		setBackgroundTintMode(w, objValue);



			}
			break;
		case "foreground": {


		setForeground(w, nativeWidget, objValue);



			}
			break;
		case "foregroundRepeat": {


		setForegroundRepeat(w, strValue, objValue, view);



			}
			break;
		case "foregroundTint": {


		setForegroundTint(w,objValue);



			}
			break;
		case "foregroundTintMode": {


		setForegroundTintMode(w, objValue);



			}
			break;
		case "visibility": {


		 setVisibility(w, nativeWidget, objValue);



			}
			break;
		case "alpha": {


		 setAlpha(nativeWidget, objValue);



			}
			break;
		case "onLongClick": {


		 setOnLongClick(w, nativeWidget, objValue);



			}
			break;
		case "longClickable": {


		 setLongClickable(w, objValue);



			}
			break;
		case "clickable": {


		 setClickable(w, nativeWidget, objValue);



			}
			break;
		case "translationX": {


		 setTranslationX(w, objValue);



			}
			break;
		case "translationY": {


		 setTranslationY(w, objValue);



			}
			break;
		case "translationZ": {


		 setTranslationZ(w, objValue);



			}
			break;
		case "rotation": {


		 setRotation(w, objValue);



			}
			break;
		case "rotationX": {


		 setRotationX(w, objValue);



			}
			break;
		case "rotationY": {


		 setRotationY(w, objValue);



			}
			break;
		case "scaleX": {


		 setScaleX(w, objValue);



			}
			break;
		case "scaleY": {


		 setScaleY(w, objValue);



			}
			break;
		case "transformPivotX": {


		 setTransformPivotX(w, objValue);



			}
			break;
		case "transformPivotY": {


		 setTransformPivotY(w, objValue);



			}
			break;
		case "invalidate": {


		 invalidate(w);



			}
			break;
		case "requestLayout": {


		 requestLayout(w);



			}
			break;
		case "keepScreenOn": {


		 setKeepScreenOn(w, objValue);



			}
			break;
		case "layoutDirection": {


		 setLayoutDirection(w, objValue);



			}
			break;
		case "textDirection": {


		 setTextDirection(w, objValue);



			}
			break;
		case "textAlignment": {


		 setTextAlignment(w, objValue);



			}
			break;
		case "onDrag": {


		 setOnDrag(w, nativeWidget, objValue);



			}
			break;
		case "asDragSource": {


		 setAsDragSource(w, nativeWidget, objValue);



			}
			break;
		case "enabled": {


		view.setEnabled((boolean)objValue);



			}
			break;
		case "duplicateParentState": {


		 view.setDuplicateParentStateEnabled((boolean)objValue);



			}
			break;
		case "foregroundGravity": {


		view.setForegroundGravity((int) objValue);



			}
			break;
		case "onKey": {


		 setOnKey(w, objValue);



			}
			break;
		case "iosLayerBorderWidth": {


		 setLayerBorderWidth(nativeWidget, objValue);



			}
			break;
		case "iosLayerBorderColor": {


		 setLayerBorderColor(nativeWidget, objValue);



			}
			break;
		case "iosLayerCornerRadius": {


		 setLayerCornerRadius(nativeWidget, objValue);



			}
			break;
		case "iosLayerMasksToBounds": {


		 setLayerMasksToBounds(nativeWidget, objValue);



			}
			break;
		case "zIndex": {


		 setZIndex(w, objValue);



			}
			break;
		case "maxWidth": {


		 setMaxWidth(w, objValue); 



			}
			break;
		case "maxHeight": {


		 setMaxHeight(w, objValue); 



			}
			break;
		case "selected": {


		setSelected(objValue, view);



			}
			break;
		case "style": {


		setStyle(w, view, objValue);



			}
			break;
		case "errorStyle": {


		setErrorStyle(w, view, objValue);



			}
			break;
		case "validateForm": {


		validateForm(w, objValue);



			}
			break;
		case "validation": {


		setValidation(w, objValue);



			}
			break;
		case "v_required": {


		setRequired(w, objValue);



			}
			break;
		case "v_minlength": {


		setMinlength(w, objValue);



			}
			break;
		case "v_maxlength": {


		setMaxlength(w, objValue);



			}
			break;
		case "v_min": {


		setMin(w, objValue);



			}
			break;
		case "v_max": {


		setMax(w, objValue);



			}
			break;
		case "v_pattern": {


		setPattern(w, objValue);



			}
			break;
		case "v_type": {


		setType(w, strValue, objValue);



			}
			break;
		case "validationErrorDisplayType": {


		setValidationErrorDisplay(w, strValue, objValue);



			}
			break;
		case "customErrorMessageValues": {


		setCustomErrorMessageValues(w, objValue);



			}
			break;
		case "customErrorMessageKeys": {


		setCustomErrorMessageKeys(w, objValue);



			}
			break;
		case "invalidateOnFrameChange": {


		setInvalidateOnFrameChange(w, objValue);



			}
			break;
		default:
			java.util.List<IAttributable> attributables = WidgetFactory.getAttributables("View", w.getLocalName());
			if (attributables != null) {
				for (IAttributable attributable : attributables) {
					attributable.newInstance(w).setAttribute(key, strValue, objValue, decorator);
				}
			}
			break;
		}
	}
	
	@SuppressLint("NewApi")
	public static Object getAttribute(IWidget w, WidgetAttribute key, ILifeCycleDecorator decorator) {
		return getAttribute(w, w.asNativeWidget(), key, decorator);
	}
	
	@SuppressLint("NewApi")
	public static Object getAttribute(IWidget w, Object nativeWidget, WidgetAttribute key, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		switch (key.getAttributeName()) {
			case "iosBackgroundColor": {
return getBackgroundColor(nativeWidget);			}
			case "iosIsHidden": {
return getIsHidden(nativeWidget);			}
			case "iosAlpha": {
return getAlpha(nativeWidget);			}
			case "iosIsOpaque": {
return getIsOpaque(nativeWidget);			}
			case "iosTintColor": {
return getTintColor(nativeWidget);			}
			case "iosClipsToBounds": {
return getClipsToBounds(nativeWidget);			}
			case "iosClearsContextBeforeDrawing": {
return getClearsContextBeforeDrawing(nativeWidget);			}
			case "iosIsUserInteractionEnabled": {
return getIsUserInteractionEnabled(nativeWidget);			}
			case "iosIsMultipleTouchEnabled": {
return getIsMultipleTouchEnabled(nativeWidget);			}
			case "iosIsExclusiveTouch": {
return getIsExclusiveTouch(nativeWidget);			}
			case "iosPreservesSuperviewLayoutMargins": {
return getPreservesSuperviewLayoutMargins(nativeWidget);			}
			case "iosInsetsLayoutMarginsFromSafeArea": {
return getInsetsLayoutMarginsFromSafeArea(nativeWidget);			}
			case "iosAutoresizesSubviews": {
return getAutoresizesSubviews(nativeWidget);			}
			case "iosTranslatesAutoresizingMaskIntoConstraints": {
return getTranslatesAutoresizingMaskIntoConstraints(nativeWidget);			}
			case "iosContentScaleFactor": {
return getContentScaleFactor(nativeWidget);			}
			case "iosIsFocused": {
return getIsFocused(nativeWidget);			}
			case "iosRestorationIdentifier": {
return getRestorationIdentifier(nativeWidget);			}
			case "iosTag": {
return getTag(nativeWidget);			}
			case "iosAccessibilityIgnoresInvertColors": {
return getAccessibilityIgnoresInvertColors(nativeWidget);			}
			case "iosLargeContentImage": {
if (checkIosVersion("13.0")) {
return getLargeContentImage(nativeWidget);
}
break;			}
			case "iosLargeContentTitle": {
if (checkIosVersion("13.0")) {
return getLargeContentTitle(nativeWidget);
}
break;			}
			case "iosScalesLargeContentImage": {
if (checkIosVersion("13.0")) {
return getScalesLargeContentImage(nativeWidget);
}
break;			}
			case "iosShowsLargeContentViewer": {
if (checkIosVersion("13.0")) {
return getShowsLargeContentViewer(nativeWidget);
}
break;			}
			case "focusable":
			case "iosIsAccessibilityElement": {
return getIsAccessibilityElement(nativeWidget);			}
			case "iosAccessibilityLabel": {
return getAccessibilityLabel(nativeWidget);			}
			case "contentDescription":
			case "iosAccessibilityHint": {
return getAccessibilityHint(nativeWidget);			}
			case "iosAccessibilityValue": {
return getAccessibilityValue(nativeWidget);			}
			case "iosAccessibilityTraits": {
return getAccessibilityTraits(nativeWidget);			}
			case "id": {
return view.getId();			}
			case "modelSyncEvents": {
return getModelSyncEvents(w);			}
			case "modelParam": {
return getModelParam(w);			}
			case "modelPojoToUi": {
return getModelPojoToUi(w);			}
			case "modelUiToPojo": {
return getModelUiToPojo(w);			}
			case "background": {
return getBackground(w);			}
			case "minWidth": {
return getMinWidth(w);			}
			case "minHeight": {
return getMinHeight(w);			}
			case "backgroundTint": {
return getBackgroundTint(w);			}
			case "backgroundTintMode": {
return getBackgroundTintMode(w);			}
			case "foreground": {
return getForeground(w);			}
			case "foregroundTint": {
return getForegroundTint(w);			}
			case "foregroundTintMode": {
return getForegroundTintMode(w);			}
			case "visibility": {
return getVisibility(w);			}
			case "alpha": {
return getAlpha(nativeWidget);			}
			case "longClickable": {
return getLongClickable(w);			}
			case "clickable": {
return getClickable(nativeWidget);			}
			case "translationX": {
return getTranslationX(w);			}
			case "translationY": {
return getTranslationY(w);			}
			case "translationZ": {
return getTranslationZ(w);			}
			case "rotation": {
return getRotation(w);			}
			case "rotationX": {
return getRotationX(w);			}
			case "rotationY": {
return getRotationY(w);			}
			case "scaleX": {
return getScaleX(w);			}
			case "scaleY": {
return getScaleY(w);			}
			case "transformPivotX": {
return getTransformPivotX(w);			}
			case "transformPivotY": {
return getTransformPivotY(w);			}
			case "keepScreenOn": {
return getKeepScreenOn(w);			}
			case "layoutDirection": {
return getLayoutDirection(w);			}
			case "textDirection": {
return getTextDirection(w);			}
			case "textAlignment": {
return getTextAlignment(w);			}
			case "enabled": {
return view.isEnabled();			}
			case "duplicateParentState": {
return view.isDuplicateParentStateEnabled();			}
			case "foregroundGravity": {
return view.getForegroundGravity();			}
			case "maxWidth": {
return getMaxWidth(w);			}
			case "maxHeight": {
return getMaxHeight(w);			}
			case "selected": {
return getSelected(w, view);			}
			case "validateForm": {
return getValidateFormResult(w);			}
		}
		
		java.util.List<IAttributable> attributables = WidgetFactory.getAttributables("View", w.getLocalName());
		if (attributables != null) {
			for (IAttributable attributable : attributables) {
				Object value = attributable.newInstance(w).getAttribute(key, decorator);
				
				if (value != null) {
					return value;
				}
			}
		}
		return null;
	}
    public static native boolean checkIosVersion(String v) /*-[
		return ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedDescending);
	]-*/;
	


	public static void setPadding(Object objValue, View view) {
		int value = (int) objValue;
		ViewCompat.setPaddingRelative(view, value,value,value,value);
	}
	
	public static void setPaddingLeft(Object objValue, View view) {
		int value = (int) objValue;
		ViewCompat.setPaddingRelative(view, value,view.getPaddingTop(), ViewCompat.getPaddingEnd(view),view.getPaddingBottom());
	}
	
	public static void setPaddingRight(Object objValue, View view) {
		int value = (int) objValue;
		ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view),view.getPaddingTop(), value,view.getPaddingBottom());
	}
	
	public static void setPaddingTop(Object objValue, View view) {
		int value = (int) objValue;
		ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view),value, ViewCompat.getPaddingEnd(view),view.getPaddingBottom());
	}
	
	public static void setPaddingBottom(Object objValue, View view) {
		int value = (int) objValue;
		ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view),view.getPaddingTop(), ViewCompat.getPaddingEnd(view), value);
	}
	
	public static Object getPaddingTop(IWidget w, View view) {
		return view.getPaddingTop();
	}
	
	public static Object getPaddingBottom(IWidget w, View view) {
		return view.getPaddingBottom();
	}
	
	public static Object getPaddingLeft(IWidget w, View view) {
		return ViewCompat.getPaddingStart(view);
	}
	
	public static Object getPaddingRight(IWidget w, View view) {
		return ViewCompat.getPaddingEnd(view);
	}

	
	public static void setPaddingHorizontal(Object objValue, View view) {
		int value = (int) objValue;
		ViewCompat.setPaddingRelative(view, value,view.getPaddingTop(), value,view.getPaddingBottom());
	}
	
	public static void setPaddingVertical(Object objValue, View view) {
		int value = (int) objValue;
		ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view),value, ViewCompat.getPaddingEnd(view), value);
	}

	//start - nopadding
	public static void setId(IWidget w, String strValue, Object objValue, View view) {
        view.setId((int)objValue);
        w.setId(strValue);
        setNativeId(w, strValue);
	}
	
	private static Object getModelSyncEvents(IWidget w) {
		return w.getModelSyncEvents();
	}
	
	private static void setModelSyncEvents(IWidget w, String strValue, Object objValue, View view) {
		w.setModelSyncEvents((String) objValue);
	}

	private static void setModelParam(IWidget w, String strValue, Object objValue, View view) {
		w.setModelParam((String) objValue);
	}
	
	
	private static void setModelPojoToUi(IWidget w, String strValue, Object objValue, View view) {
		w.setModelPojoToUi((String) objValue);
	}
	
	
	private static void setModelUiToPojo(IWidget w, String strValue, Object objValue, View view) {
		w.setModelUiToPojo((String) objValue);
	}

	   
    private static void notifyDataSetChanged(IWidget w, Object objValue) {
        if (PluginInvoker.getBoolean(objValue)) {
            w.notifyDataSetChanged();
        }
    }

    private static void updateModelData(IWidget w, Object expression, Object payload) {
    	w.updateModelData((String) expression, payload);
    }
    
    
    
    private static Object getModelUiToPojo(IWidget w) {
        return w.getModelUiToPojo();
    }

    private static Object getModelPojoToUi(IWidget w) {
        return w.getModelPojoToUi();
    }

    private static Object getModelParam(IWidget w) {
        return w.getModelParam();
    }
    
	
	private static void setModelPojoToUiParams(IWidget w, Object objValue) {
		w.setModelPojoToUiParams((String) objValue);
	}
	
	public static void refreshUiFromModel(IWidget w, Object objValue) {
		refreshUiFromModel(w, objValue, false);
	}
	public static void refreshUiFromModel(IWidget w, Object objValue, boolean remeasure) {
		if (w.isInitialised() && objValue != null) {
			String[] ids = ((String) objValue).split(",");
			
			for (String id : ids) {
				if (!id.startsWith("@+id/")) {
					id = "@+id/" + id;
				}
				IWidget widget = w.findNearestView(id);
				if (widget != null) {
					widget.applyModelToWidget();
				}
			}
			
			if (remeasure) {
				w.getFragment().remeasure();
			}
		}
	}
	
	private static void setModelUiToPojoEventIds(IWidget w, Object objValue) {
		w.setModelUiToPojoEventIds((String) objValue);
	}
	
    //end - nopadding
    
	private static void setZIndex(IWidget w, Object objValue) {
		w.setZIndex((int) objValue);
		
		HasWidgets parent = w.getParent();
		if (parent != null) {
			java.util.List<IWidget> widgets = parent.getWidgets();
			Collections.sort(widgets,  new Comparator<IWidget>() {
				@Override
				public int compare(IWidget arg0, IWidget arg1) {
					return arg0.getZIndex() - arg1.getZIndex();
				}
			});
		
			nativeBringToFront(widgets);
		}
	}


	
	public static void setMaxHeight(IWidget w, Object objValue) {
		Object view = w.asWidget();
		
		if (view instanceof IMaxDimension) {
			((IMaxDimension) view).setMaxHeight((int) objValue);
		}
	}

	public static void setMaxWidth(IWidget w, Object objValue) {
		Object view = w.asWidget();
		
		if (view instanceof IMaxDimension) {
			((IMaxDimension) view).setMaxWidth((int) objValue);
		}
	}
	
	
	public static Object getMaxWidth(IWidget w) {
		Object view = w.asWidget();
		
		if (view instanceof IMaxDimension) {
			return ((IMaxDimension) view).getMaxWidth();
		}
		return null;
	}

	public static Object getMaxHeight(IWidget w) {
		Object view = w.asWidget();
		
		if (view instanceof IMaxDimension) {
			return ((IMaxDimension) view).getMaxHeight();
		}
		return null;
	}
	
	private static void setSelected(Object objValue, View view) {
		view.setSelected((boolean) (objValue));
	}
	
	
	
	private static Object getSelected(IWidget w, View view) {
		return view.isSelected();
	}
	
	
	private static void setInvalidateOnFrameChange(IWidget w, Object objValue) {
		w.setInvalidateOnFrameChange((boolean) objValue);
	}

	

 
	private static void setBackgroundRepeat(IWidget w, String strValue, Object objValue, View view) {
		w.applyAttributeCommand("background", "imageRepeat", new String[] {"backgroundRepeat"}, true, strValue);
	}
	
	private static void setForegroundRepeat(IWidget w, String strValue, Object objValue, View view) {
		w.applyAttributeCommand("foreground", "imageRepeat", new String[] {"foregroundRepeat"}, true, strValue);
	}
	


	public static void addEventInfo(Map<String, Object> obj, MotionEvent event) {
		Map<String, Object> eventInfo = PluginInvoker.getJSONCompatMap();
		eventInfo.put("action", event.getAction());
		eventInfo.put("rawX", event.getRawX());
		eventInfo.put("rawY", event.getRawY());
		eventInfo.put("x", event.getX());
		eventInfo.put("y", event.getY());
		obj.put("eventInfo", PluginInvoker.getNativeMap(eventInfo));
	}
	
	public static void addEventInfo(Map<String, Object> obj, KeyEvent event) {
		Map<String, Object> eventInfo = PluginInvoker.getJSONCompatMap();
		if (event != null) {
			eventInfo.put("action", event.getAction());
			eventInfo.put("keyCode", event.getKeyCode());
		}
		obj.put("eventInfo", PluginInvoker.getNativeMap(eventInfo));
	}
	
	public static void addEventInfo(Map<String, Object> obj, DragEvent event) {
		Map<String, Object> eventInfo = PluginInvoker.getJSONCompatMap();
		eventInfo.put("action", event.getAction());
		eventInfo.put("x", event.getX());
		eventInfo.put("y", event.getY());
		
		PluginInvoker.putJSONSafeObjectIntoMap(eventInfo, "clipData", getClipData(event));
		obj.put("eventInfo", PluginInvoker.getNativeMap(eventInfo));
	}
	public static void addEventInfo(Map<String, Object> obj, r.android.widget.Chronometer chronometer, com.ashera.core.IFragment fragment) {
		obj.put("text", chronometer.getText());
	}
	


	private static void validateForm(IWidget w, Object objValue) {
		String formGroupId = (String) objValue;
		com.ashera.validations.Form form = (com.ashera.validations.Form) w.getFragment().getFromTempCache(formGroupId);
		
		if (form != null) {
			w.getFragment().disableRemeasure();
			w.getFragment().storeInTempCache("formvalidationResult", form.isValid());
			w.getFragment().enableRemeasure();
		}
	}
	
	private static Object getValidateFormResult(IWidget w) {
		Object result = w.getFragment().getFromTempCache("formvalidationResult");
		return result;
	}
	
	private static void setValidation(IWidget w, Object objValue) {
		java.util.List<com.ashera.validations.Form> forms = getForms(w);
		
		if (forms != null) {
			for (com.ashera.validations.Form form : forms) {
				java.util.List<String> validations = (java.util.List<String>) objValue;

				for (String validation : validations) {
					if (w instanceof com.ashera.validations.FormElement) {
						com.ashera.validations.FormElement formElement = (com.ashera.validations.FormElement) w;
						com.ashera.validations.Field field = com.ashera.validations.Field.using(formElement,
								com.ashera.validations.Field.DEFAULT_ORDER);
						String[] params = null;
						int startIndex = validation.indexOf("(");
						int endIndex = validation.indexOf(")");
						if (startIndex != -1 && endIndex != -1) {
							params = validation.substring(startIndex + 1, endIndex).split("\\-");
							validation = validation.substring(0, startIndex);
						}
						com.ashera.validations.Validation validator = com.ashera.validations.ValidatorFactory
								.get(validation);
						com.ashera.validations.Validation newInstance = validator.newInstance(params);
						String customMessage = formElement.getCustomMessage(validation);
						if (customMessage != null) {
							newInstance.setErrorMessage(customMessage);
						}
						field.addValidator(newInstance);
						form.addField(field);
					}

				}
			}
		}
	}

	public static java.util.List<com.ashera.validations.Form> getForms(IWidget w) {
		if (w instanceof com.ashera.validations.FormElement) {
			java.util.List<com.ashera.validations.Form> forms = new java.util.ArrayList<>();
			String formGroupIdStr = ((com.ashera.validations.FormElement)w).getFormGroupId();
			if (formGroupIdStr == null) {
				throw new RuntimeException("Specify a formGroupId for the widget");
			}
			String[] formGroupIds = com.ashera.utils.StringUtils.split(formGroupIdStr, ",");
			
			for (String formGroupId : formGroupIds) {
				com.ashera.validations.Form form = (com.ashera.validations.Form) w.getFragment().getFromTempCache(formGroupId);
				if (form == null) {
					form = new com.ashera.validations.Form();
					w.getFragment().storeInTempCache(formGroupId, form);
				}
				forms.add(form);
			}
			return forms;
		}
		
		return null;
	}
	
	
	private static void setType(IWidget w, String value, Object objValue) {
		switch (value) {
		case "email":
			addValidator(w, "email", new String[] {});
			break;
		case "tel":
			addValidator(w, "mobilenumber", new String[] {});
			break;
		case "url":
			addValidator(w, "url", new String[] {});
			break;
		case "date":
			addValidator(w, "date", new String[] {"dd/MM/yyyy"});
			break;
		case "time":
			addValidator(w, "time", new String[] {});
			break;
		default:
			break;
		}
		
	}

	private static void setPattern(IWidget w, Object objValue) {
		addValidator(w, "pattern", new String[] {(String)objValue});
	}

	private static void setMax(IWidget w, Object objValue) {
		addValidator(w, "maxvalue", new String[] {(String)objValue});
	}

	private static void setMin(IWidget w, Object objValue) {
		addValidator(w, "minvalue", new String[] {(String)objValue});
	}

	private static void setMaxlength(IWidget w, Object objValue) {
		addValidator(w, "maxlength", new String[] {(String)objValue});
	}

	private static void setMinlength(IWidget w, Object objValue) {
		addValidator(w, "minlength", new String[] {(String)objValue});
	}

	private static void setRequired(IWidget w, Object objValue) {
		addValidator(w, "required", null);
	}

	public static void addValidator(IWidget w, String validationName, String[] params) {
		if (w instanceof com.ashera.validations.FormElement) {
			java.util.List<com.ashera.validations.Form> forms = getForms(w);

			if (forms != null) {
				for (com.ashera.validations.Form form : forms) {
					com.ashera.validations.FormElement formElement = (com.ashera.validations.FormElement) w;
					com.ashera.validations.Field field = com.ashera.validations.Field.using(formElement,
							com.ashera.validations.Field.DEFAULT_ORDER);
					com.ashera.validations.Validation validator = com.ashera.validations.ValidatorFactory
							.get(validationName);
					String customMessage = formElement.getCustomMessage(validationName);
					com.ashera.validations.Validation newInstance = validator.newInstance(params);
					if (customMessage != null) {
						newInstance.setErrorMessage(customMessage);
					}
					field.addValidator(newInstance);
					form.addField(field);
				}
			}
		}
	}
	
	
	private static void setCustomErrorMessageKeys(IWidget w, Object objValue) {
		if (w instanceof com.ashera.validations.FormElement) {
			com.ashera.validations.FormElement formElement = (com.ashera.validations.FormElement) w;
			formElement.setCustomErrorMessageKeys((java.util.List<String>) objValue);
		}
		
	}

	private static void setCustomErrorMessageValues(IWidget w, Object objValue) {
		if (w instanceof com.ashera.validations.FormElement) {
			com.ashera.validations.FormElement formElement = (com.ashera.validations.FormElement) w;
			formElement.setCustomErrorMessageValues((java.util.List<String>) objValue);
		}
	}
	
	private static void setValidationErrorDisplay(IWidget w, String strValue, Object objValue) {
		if (w instanceof com.ashera.validations.FormElement) {
			com.ashera.validations.FormElement formElement = (com.ashera.validations.FormElement) w;
			formElement.setValidationErrorDisplayType((int) objValue);
		}
	}
	
	
	private static void setErrorStyle(IWidget w, View view, Object objValue) {
		if (w instanceof com.ashera.validations.FormElement) {
			com.ashera.validations.FormElement formElement = (com.ashera.validations.FormElement) w;
			formElement.setErrorStyle((String) objValue);
		}
	}

	private static void setStyle(IWidget w, View view, Object objValue) {
		if (w instanceof com.ashera.validations.FormElement) {
			com.ashera.validations.FormElement formElement = (com.ashera.validations.FormElement) w;
			formElement.setNormalStyle((String) objValue);
		}
		setStyle(w, objValue);
	}

	public static void setStyle(IWidget w, Object objValue) {
		if (w.isInitialised()) {
			com.ashera.parser.css.CssDataHolder pageData = (com.ashera.parser.css.CssDataHolder) w.getFragment().getStyleSheet();
			String style = (String) objValue;
			
			if (style != null) {
				style = style.replaceFirst("@style/", "");
				
				java.util.List<com.ashera.css.CssTree.Attribute> attributes = pageData.getStyle("." + style);
				
				if (attributes != null) {
					HashMap<String, java.util.List<WidgetAttributeValue>> attributeMap = new HashMap<>();
					for (com.ashera.css.CssTree.Attribute attribute : attributes) {
						String key = attribute.key;
						if (!attributeMap.containsKey(key)) {
							attributeMap.put(key, new java.util.ArrayList<>());
						}
						
						WidgetAttributeValue widgetAttributeValue = new WidgetAttributeValue(attribute.value, 
								attribute.orientation, attribute.minWidth, attribute.minHeight, attribute.maxWidth, attribute.maxHeight);
						attributeMap.get(key).add(widgetAttributeValue);
					}
					
					for (String key : attributeMap.keySet()) {
						WidgetAttribute attribute = w.getAttribute(w.getParent(), w.getLocalName(), key);
						if (attribute != null) {
							((BaseWidget)w).updateWidgetMap(attribute, attributeMap.get(key));
							if (!attribute.isForChild()) {
								String attributeValue = w.getAttributeValue(key);
								((BaseWidget)w).applyStyleToWidget(attribute, attributeValue);
							} else {
								((BaseHasWidgets) w.getParent()).setChildAttribute(w, attribute);
							}	
						}
					}
				}
			}
		}
	}
	

	public static void setMessageOnLabel(IWidget w, String message) {
		String id = w.getId();
		if (id != null) {
			IWidget errorLabel = w.findNearestView(id + "Error");
			
			if (errorLabel instanceof com.ashera.validations.ValidationErrorLabel) {
				((com.ashera.validations.ValidationErrorLabel) errorLabel).setErrorMessage(message);
			}
		}
	}
	


	public static void setLayoutDirection(IWidget w, Object objValue) {
		View view = (View) w.asWidget();
		int value = (int) objValue;
		if (isMirrorSupported() && isRTLLayout()) {
			if (value == View.LAYOUT_DIRECTION_RTL) {
				value = View.LAYOUT_DIRECTION_LTR;
			} else {
				value = View.LAYOUT_DIRECTION_RTL;
			}
		}
		view.setLayoutDirection(value);
	}
	
	private static Object getLayoutDirection(IWidget w) {
		View view = (View) w.asWidget();
		return view.getLayoutDirection();
	}
	
	
	private static void setTextAlignment(IWidget w, Object objValue) {
		View view = (View) w.asWidget();
		view.setTextAlignment((int) objValue);
	}

	private static void setTextDirection(IWidget w, Object objValue) {
		View view = (View) w.asWidget();
		view.setTextDirection((int) objValue);
	}

	private static Object getTextAlignment(IWidget w) {
		View view = (View) w.asWidget();
		return view.getTextAlignment();
	}

	private static Object getTextDirection(IWidget w) {
		View view = (View) w.asWidget();
		return view.getTextDirection();
	}
	
	public static boolean isRTLLayoutDirection(IWidget widget) {
		View view = (View) widget.asWidget();
		return view.isLayoutRtl();
	}	
	


	public static void drawableStateChanged(IWidget w) {
		w.drawableStateChanged();
		View view = (View) w.asWidget();
		
		r.android.graphics.drawable.Drawable background = view.getBackground();
		if (background != null && background.isStateful() && background.setState(view.getDrawableState())) {
			setBackground(w, w.asNativeWidget(), background, true);
		}
		
		r.android.graphics.drawable.Drawable foreground = view.getForeground();
		if (foreground != null && foreground.isStateful() && foreground.setState(view.getDrawableState())) {
			setForeground(w, w.asNativeWidget(), foreground);
		}
		
		if (view.getBackgroundTintList() != null && view.getBackgroundTintList().isStateful()) {
			setBackgroundTint(w, view.getBackgroundTintList());
			w.invalidate();
		}
		
		if (view.getForegroundTintList() != null && view.getForegroundTintList().isStateful()) {
			setForegroundTint(w, view.getForegroundTintList());
			w.invalidate();
		}
	}

	public static Object getColor(Object objValue) {
		if (isColor(objValue)) {
			return objValue;
		}
		
		if (objValue instanceof Integer) {
			return PluginInvoker.getColor(r.android.graphics.Color.formatColor((int) objValue));
		}
		
		throw new RuntimeException("unknown color :" + objValue);
	}

	public static void setDrawableBounds(IWidget widget, int l, int t, int r, int b) {
		widget.setDrawableBounds(l, t, r, b);
		View view = (View) widget.asWidget();
		if (view.getBackground() != null) {
			view.getBackground().setBounds(l, t, r, b);
		}
		
		if (view.getForeground() != null) {
			view.getForeground().setBounds(l, t, r, b);
		}
	}
	
	public static void redrawDrawables(IWidget w) {
		View view = (View) w.asWidget();
		
		r.android.graphics.drawable.Drawable background = view.getBackground();
		if (background != null && background.isRedraw()) {
			setBackground(w, w.asNativeWidget(), background);
			background.setRedraw(false);
		}
		
		r.android.graphics.drawable.Drawable foreground = view.getForeground();
		if (foreground != null && foreground.isRedraw()) {
			setForeground(w, w.asNativeWidget(), background);
			foreground.setRedraw(false);
		}
	}
	

	public static native void setBackgroundColor(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).backgroundColor = (UIColor*) value;
]-*/;
	public static native Object getBackgroundColor(Object uiView) /*-[
return ((UIView*) uiView).backgroundColor;
  ]-*/;
	public static native void setIsHidden(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).hidden = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getIsHidden(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).hidden];
  ]-*/;
	public static native void setAlpha(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).alpha = [(JavaLangFloat*) value floatValue];
]-*/;
	public static native Object getAlpha(Object uiView) /*-[
return [JavaLangFloat valueOfWithFloat :((UIView*) uiView).alpha];
  ]-*/;
	public static native void setIsOpaque(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).opaque = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getIsOpaque(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).opaque];
  ]-*/;
	public static native void setTintColor(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).tintColor = (UIColor*) value;
]-*/;
	public static native Object getTintColor(Object uiView) /*-[
return ((UIView*) uiView).tintColor;
  ]-*/;
	public static native void setClipsToBounds(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).clipsToBounds = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getClipsToBounds(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).clipsToBounds];
  ]-*/;
	public static native void setClearsContextBeforeDrawing(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).clearsContextBeforeDrawing = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getClearsContextBeforeDrawing(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).clearsContextBeforeDrawing];
  ]-*/;
	public static native void setIsUserInteractionEnabled(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).userInteractionEnabled = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getIsUserInteractionEnabled(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).userInteractionEnabled];
  ]-*/;
	public static native void setIsMultipleTouchEnabled(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).multipleTouchEnabled = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getIsMultipleTouchEnabled(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).multipleTouchEnabled];
  ]-*/;
	public static native void setIsExclusiveTouch(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).exclusiveTouch = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getIsExclusiveTouch(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).exclusiveTouch];
  ]-*/;
	public static native void setPreservesSuperviewLayoutMargins(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).preservesSuperviewLayoutMargins = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getPreservesSuperviewLayoutMargins(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).preservesSuperviewLayoutMargins];
  ]-*/;
	public static native void setInsetsLayoutMarginsFromSafeArea(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).insetsLayoutMarginsFromSafeArea = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getInsetsLayoutMarginsFromSafeArea(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).insetsLayoutMarginsFromSafeArea];
  ]-*/;
	public static native void setAutoresizesSubviews(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).autoresizesSubviews = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getAutoresizesSubviews(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).autoresizesSubviews];
  ]-*/;
	public static native void setTranslatesAutoresizingMaskIntoConstraints(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).translatesAutoresizingMaskIntoConstraints = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getTranslatesAutoresizingMaskIntoConstraints(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).translatesAutoresizingMaskIntoConstraints];
  ]-*/;
	public static native void setContentScaleFactor(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).contentScaleFactor = [(JavaLangFloat*) value floatValue];
]-*/;
	public static native Object getContentScaleFactor(Object uiView) /*-[
return [JavaLangFloat valueOfWithFloat :((UIView*) uiView).contentScaleFactor];
  ]-*/;
	public static native Object getIsFocused(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).focused];
  ]-*/;
	public static native void setRestorationIdentifier(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).restorationIdentifier = (NSString*) value;
]-*/;
	public static native Object getRestorationIdentifier(Object uiView) /*-[
return ((UIView*) uiView).restorationIdentifier;
  ]-*/;
	public static native void setTag(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).tag = [(JavaLangInteger*) value intValue];
]-*/;
	public static native Object getTag(Object uiView) /*-[
return [JavaLangInteger valueOfWithInt :((UIView*) uiView).tag];
  ]-*/;
	public static native void setAccessibilityIgnoresInvertColors(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).accessibilityIgnoresInvertColors = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getAccessibilityIgnoresInvertColors(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).accessibilityIgnoresInvertColors];
  ]-*/;
	public static native void setLargeContentImage(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).largeContentImage = (UIImage*) value;
]-*/;
	public static native Object getLargeContentImage(Object uiView) /*-[
return ((UIView*) uiView).largeContentImage;
  ]-*/;
	public static native void setLargeContentTitle(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).largeContentTitle = (NSString*) value;
]-*/;
	public static native Object getLargeContentTitle(Object uiView) /*-[
return ((UIView*) uiView).largeContentTitle;
  ]-*/;
	public static native void setScalesLargeContentImage(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).scalesLargeContentImage = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getScalesLargeContentImage(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).scalesLargeContentImage];
  ]-*/;
	public static native void setShowsLargeContentViewer(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).showsLargeContentViewer = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getShowsLargeContentViewer(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).showsLargeContentViewer];
  ]-*/;
	public static native void setIsAccessibilityElement(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).isAccessibilityElement = [(JavaLangBoolean*) value booleanValue];
]-*/;
	public static native Object getIsAccessibilityElement(Object uiView) /*-[
return [JavaLangBoolean valueOfWithBoolean :((UIView*) uiView).isAccessibilityElement];
  ]-*/;
	public static native void setAccessibilityLabel(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).accessibilityLabel = (NSString*) value;
]-*/;
	public static native Object getAccessibilityLabel(Object uiView) /*-[
return ((UIView*) uiView).accessibilityLabel;
  ]-*/;
	public static native void setAccessibilityHint(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).accessibilityHint = (NSString*) value;
]-*/;
	public static native Object getAccessibilityHint(Object uiView) /*-[
return ((UIView*) uiView).accessibilityHint;
  ]-*/;
	public static native void setAccessibilityValue(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).accessibilityValue = (NSString*) value;
]-*/;
	public static native Object getAccessibilityValue(Object uiView) /*-[
return ((UIView*) uiView).accessibilityValue;
  ]-*/;
	public static native void setAccessibilityTraits(Object nativeWidget, Object value) /*-[
((UIView*) nativeWidget).accessibilityTraits = [(JavaLangInteger*) value intValue];
]-*/;
	public static native Object getAccessibilityTraits(Object uiView) /*-[
return [JavaLangInteger valueOfWithInt :((UIView*) uiView).accessibilityTraits];
  ]-*/;
	@SuppressLint("NewApi")
private static class OnClickListener implements View.OnClickListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnClickListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnClickListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onClick (View v){
    
	if (action == null || action.equals("onClick")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onClick");
	    java.util.Map<String, Object> obj = getOnClickEventObj(v);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v);
		    }
		    if (commandType.equals(":")) {
		    	return;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return;
}//#####

public java.util.Map<String, Object> getOnClickEventObj(View v) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "click");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onClick", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnTouchListener implements View.OnTouchListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnTouchListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnTouchListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onTouch (View v, 
                MotionEvent event){
    boolean result = true;
    
	if (action == null || action.equals("onTouch")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onTouch");
	    java.util.Map<String, Object> obj = getOnTouchEventObj(v,event);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,event);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }
		    if (commandType.equals(":")) {
		    	return result;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return result;
}//#####

public java.util.Map<String, Object> getOnTouchEventObj(View v,MotionEvent event) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "touch");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, event);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onTouch", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnLongClickListener implements View.OnLongClickListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnLongClickListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnLongClickListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onLongClick (View v){
    boolean result = true;
    
	if (action == null || action.equals("onLongClick")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onLongClick");
	    java.util.Map<String, Object> obj = getOnLongClickEventObj(v);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }
		    if (commandType.equals(":")) {
		    	return result;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return result;
}//#####

public java.util.Map<String, Object> getOnLongClickEventObj(View v) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "longclick");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onLongClick", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnDragListener implements View.OnDragListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnDragListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnDragListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onDrag (View v, 
                DragEvent event){
    boolean result = true;
    
	if (action == null || action.equals("onDrag")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onDrag");
	    java.util.Map<String, Object> obj = getOnDragEventObj(v,event);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,event);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }
		    if (commandType.equals(":")) {
		    	return result;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return result;
}//#####

public java.util.Map<String, Object> getOnDragEventObj(View v,DragEvent event) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "drag");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, event);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onDrag", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnKeyListener implements View.OnKeyListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnKeyListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnKeyListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onKey (View v, 
                int keyCode, 
                KeyEvent event){
    boolean result = true;
    
	if (action == null || action.equals("onKey")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onKey");
	    java.util.Map<String, Object> obj = getOnKeyEventObj(v,keyCode,event);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,keyCode,event);
		    	 if (commandResult != null) {
		    		 result = (boolean) commandResult;
		    	 }
		    }
		    if (commandType.equals(":")) {
		    	return result;
		    }
			
			break;
		default:
			break;
		}
		
		if (obj.containsKey("refreshUiFromModel")) {
			Object widgets = obj.remove("refreshUiFromModel");
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, widgets, true);
		}
		if (w.getModelUiToPojoEventIds() != null) {
			com.ashera.layout.ViewImpl.refreshUiFromModel(w, w.getModelUiToPojoEventIds(), true);
		}
		if (strValue != null && !strValue.isEmpty()) {
		    com.ashera.core.IActivity activity = (com.ashera.core.IActivity)w.getFragment().getRootActivity();
		    activity.sendEventMessage(obj);
		}
	}
    return result;
}//#####

public java.util.Map<String, Object> getOnKeyEventObj(View v,int keyCode,KeyEvent event) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "key");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "keyCode", keyCode);
        ViewImpl.addEventInfo(obj, event);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onKey", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}


	


public static abstract class ViewCommandBuilder<T> {
	protected Map<String, Object> command = new HashMap<>();
	protected int orderGet;
    protected int orderSet;
    
    
    protected abstract T execute(boolean set);

    public T reset() {
    	orderGet = 0;
    	orderSet = 0;
    	command = new HashMap<>();
return (T) this;    }
    
    public Map<String, Object> initCommand(String attributeName) {
		Map<String, Object> attrs = (Map<String, Object>) command.get(attributeName);
		if (attrs == null) {
			attrs = new HashMap<>();
			command.put(attributeName, attrs);
		}
		return attrs;
	}
    public ViewCommandBuilder() {
	}
	

public T tryGetIosBackgroundColor() {
	Map<String, Object> attrs = initCommand("iosBackgroundColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosBackgroundColor() {
	Map<String, Object> attrs = initCommand("iosBackgroundColor");
	return attrs.get("commandReturnValue");
}
public T setIosBackgroundColor(String value) {
	Map<String, Object> attrs = initCommand("iosBackgroundColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosIsHidden() {
	Map<String, Object> attrs = initCommand("iosIsHidden");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosIsHidden() {
	Map<String, Object> attrs = initCommand("iosIsHidden");
	return attrs.get("commandReturnValue");
}
public T setIosIsHidden(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsHidden");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosAlpha() {
	Map<String, Object> attrs = initCommand("iosAlpha");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosAlpha() {
	Map<String, Object> attrs = initCommand("iosAlpha");
	return attrs.get("commandReturnValue");
}
public T setIosAlpha(float value) {
	Map<String, Object> attrs = initCommand("iosAlpha");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosIsOpaque() {
	Map<String, Object> attrs = initCommand("iosIsOpaque");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosIsOpaque() {
	Map<String, Object> attrs = initCommand("iosIsOpaque");
	return attrs.get("commandReturnValue");
}
public T setIosIsOpaque(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsOpaque");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosTintColor() {
	Map<String, Object> attrs = initCommand("iosTintColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosTintColor() {
	Map<String, Object> attrs = initCommand("iosTintColor");
	return attrs.get("commandReturnValue");
}
public T setIosTintColor(String value) {
	Map<String, Object> attrs = initCommand("iosTintColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosClipsToBounds() {
	Map<String, Object> attrs = initCommand("iosClipsToBounds");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosClipsToBounds() {
	Map<String, Object> attrs = initCommand("iosClipsToBounds");
	return attrs.get("commandReturnValue");
}
public T setIosClipsToBounds(boolean value) {
	Map<String, Object> attrs = initCommand("iosClipsToBounds");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosClearsContextBeforeDrawing() {
	Map<String, Object> attrs = initCommand("iosClearsContextBeforeDrawing");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosClearsContextBeforeDrawing() {
	Map<String, Object> attrs = initCommand("iosClearsContextBeforeDrawing");
	return attrs.get("commandReturnValue");
}
public T setIosClearsContextBeforeDrawing(boolean value) {
	Map<String, Object> attrs = initCommand("iosClearsContextBeforeDrawing");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosIsUserInteractionEnabled() {
	Map<String, Object> attrs = initCommand("iosIsUserInteractionEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosIsUserInteractionEnabled() {
	Map<String, Object> attrs = initCommand("iosIsUserInteractionEnabled");
	return attrs.get("commandReturnValue");
}
public T setIosIsUserInteractionEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsUserInteractionEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosIsMultipleTouchEnabled() {
	Map<String, Object> attrs = initCommand("iosIsMultipleTouchEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosIsMultipleTouchEnabled() {
	Map<String, Object> attrs = initCommand("iosIsMultipleTouchEnabled");
	return attrs.get("commandReturnValue");
}
public T setIosIsMultipleTouchEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsMultipleTouchEnabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosIsExclusiveTouch() {
	Map<String, Object> attrs = initCommand("iosIsExclusiveTouch");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosIsExclusiveTouch() {
	Map<String, Object> attrs = initCommand("iosIsExclusiveTouch");
	return attrs.get("commandReturnValue");
}
public T setIosIsExclusiveTouch(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsExclusiveTouch");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosPreservesSuperviewLayoutMargins() {
	Map<String, Object> attrs = initCommand("iosPreservesSuperviewLayoutMargins");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosPreservesSuperviewLayoutMargins() {
	Map<String, Object> attrs = initCommand("iosPreservesSuperviewLayoutMargins");
	return attrs.get("commandReturnValue");
}
public T setIosPreservesSuperviewLayoutMargins(boolean value) {
	Map<String, Object> attrs = initCommand("iosPreservesSuperviewLayoutMargins");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosInsetsLayoutMarginsFromSafeArea() {
	Map<String, Object> attrs = initCommand("iosInsetsLayoutMarginsFromSafeArea");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosInsetsLayoutMarginsFromSafeArea() {
	Map<String, Object> attrs = initCommand("iosInsetsLayoutMarginsFromSafeArea");
	return attrs.get("commandReturnValue");
}
public T setIosInsetsLayoutMarginsFromSafeArea(boolean value) {
	Map<String, Object> attrs = initCommand("iosInsetsLayoutMarginsFromSafeArea");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosAutoresizesSubviews() {
	Map<String, Object> attrs = initCommand("iosAutoresizesSubviews");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosAutoresizesSubviews() {
	Map<String, Object> attrs = initCommand("iosAutoresizesSubviews");
	return attrs.get("commandReturnValue");
}
public T setIosAutoresizesSubviews(boolean value) {
	Map<String, Object> attrs = initCommand("iosAutoresizesSubviews");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosTranslatesAutoresizingMaskIntoConstraints() {
	Map<String, Object> attrs = initCommand("iosTranslatesAutoresizingMaskIntoConstraints");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosTranslatesAutoresizingMaskIntoConstraints() {
	Map<String, Object> attrs = initCommand("iosTranslatesAutoresizingMaskIntoConstraints");
	return attrs.get("commandReturnValue");
}
public T setIosTranslatesAutoresizingMaskIntoConstraints(boolean value) {
	Map<String, Object> attrs = initCommand("iosTranslatesAutoresizingMaskIntoConstraints");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosContentScaleFactor() {
	Map<String, Object> attrs = initCommand("iosContentScaleFactor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosContentScaleFactor() {
	Map<String, Object> attrs = initCommand("iosContentScaleFactor");
	return attrs.get("commandReturnValue");
}
public T setIosContentScaleFactor(float value) {
	Map<String, Object> attrs = initCommand("iosContentScaleFactor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosIsFocused() {
	Map<String, Object> attrs = initCommand("iosIsFocused");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosIsFocused() {
	Map<String, Object> attrs = initCommand("iosIsFocused");
	return attrs.get("commandReturnValue");
}

public T tryGetIosRestorationIdentifier() {
	Map<String, Object> attrs = initCommand("iosRestorationIdentifier");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosRestorationIdentifier() {
	Map<String, Object> attrs = initCommand("iosRestorationIdentifier");
	return attrs.get("commandReturnValue");
}
public T setIosRestorationIdentifier(String value) {
	Map<String, Object> attrs = initCommand("iosRestorationIdentifier");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosTag() {
	Map<String, Object> attrs = initCommand("iosTag");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosTag() {
	Map<String, Object> attrs = initCommand("iosTag");
	return attrs.get("commandReturnValue");
}
public T setIosTag(int value) {
	Map<String, Object> attrs = initCommand("iosTag");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosAccessibilityIgnoresInvertColors() {
	Map<String, Object> attrs = initCommand("iosAccessibilityIgnoresInvertColors");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosAccessibilityIgnoresInvertColors() {
	Map<String, Object> attrs = initCommand("iosAccessibilityIgnoresInvertColors");
	return attrs.get("commandReturnValue");
}
public T setIosAccessibilityIgnoresInvertColors(boolean value) {
	Map<String, Object> attrs = initCommand("iosAccessibilityIgnoresInvertColors");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosLargeContentImage() {
	Map<String, Object> attrs = initCommand("iosLargeContentImage");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosLargeContentImage() {
	Map<String, Object> attrs = initCommand("iosLargeContentImage");
	return attrs.get("commandReturnValue");
}
public T setIosLargeContentImage(String value) {
	Map<String, Object> attrs = initCommand("iosLargeContentImage");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosLargeContentTitle() {
	Map<String, Object> attrs = initCommand("iosLargeContentTitle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosLargeContentTitle() {
	Map<String, Object> attrs = initCommand("iosLargeContentTitle");
	return attrs.get("commandReturnValue");
}
public T setIosLargeContentTitle(String value) {
	Map<String, Object> attrs = initCommand("iosLargeContentTitle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosScalesLargeContentImage() {
	Map<String, Object> attrs = initCommand("iosScalesLargeContentImage");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosScalesLargeContentImage() {
	Map<String, Object> attrs = initCommand("iosScalesLargeContentImage");
	return attrs.get("commandReturnValue");
}
public T setIosScalesLargeContentImage(boolean value) {
	Map<String, Object> attrs = initCommand("iosScalesLargeContentImage");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosShowsLargeContentViewer() {
	Map<String, Object> attrs = initCommand("iosShowsLargeContentViewer");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosShowsLargeContentViewer() {
	Map<String, Object> attrs = initCommand("iosShowsLargeContentViewer");
	return attrs.get("commandReturnValue");
}
public T setIosShowsLargeContentViewer(boolean value) {
	Map<String, Object> attrs = initCommand("iosShowsLargeContentViewer");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosIsAccessibilityElement() {
	Map<String, Object> attrs = initCommand("iosIsAccessibilityElement");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIosIsAccessibilityElement() {
	Map<String, Object> attrs = initCommand("iosIsAccessibilityElement");
	return attrs.get("commandReturnValue");
}
public T setIosIsAccessibilityElement(boolean value) {
	Map<String, Object> attrs = initCommand("iosIsAccessibilityElement");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetFocusable() {
	Map<String, Object> attrs = initCommand("iosIsAccessibilityElement");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getFocusable() {
	Map<String, Object> attrs = initCommand("iosIsAccessibilityElement");
	return attrs.get("commandReturnValue");
}
public T setFocusable(boolean value) {
	Map<String, Object> attrs = initCommand("focusable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosAccessibilityLabel() {
	Map<String, Object> attrs = initCommand("iosAccessibilityLabel");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosAccessibilityLabel() {
	Map<String, Object> attrs = initCommand("iosAccessibilityLabel");
	return attrs.get("commandReturnValue");
}
public T setIosAccessibilityLabel(String value) {
	Map<String, Object> attrs = initCommand("iosAccessibilityLabel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosAccessibilityHint() {
	Map<String, Object> attrs = initCommand("iosAccessibilityHint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosAccessibilityHint() {
	Map<String, Object> attrs = initCommand("iosAccessibilityHint");
	return attrs.get("commandReturnValue");
}
public T setIosAccessibilityHint(String value) {
	Map<String, Object> attrs = initCommand("iosAccessibilityHint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetContentDescription() {
	Map<String, Object> attrs = initCommand("iosAccessibilityHint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getContentDescription() {
	Map<String, Object> attrs = initCommand("iosAccessibilityHint");
	return attrs.get("commandReturnValue");
}
public T setContentDescription(String value) {
	Map<String, Object> attrs = initCommand("contentDescription");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosAccessibilityValue() {
	Map<String, Object> attrs = initCommand("iosAccessibilityValue");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosAccessibilityValue() {
	Map<String, Object> attrs = initCommand("iosAccessibilityValue");
	return attrs.get("commandReturnValue");
}
public T setIosAccessibilityValue(String value) {
	Map<String, Object> attrs = initCommand("iosAccessibilityValue");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIosAccessibilityTraits() {
	Map<String, Object> attrs = initCommand("iosAccessibilityTraits");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getIosAccessibilityTraits() {
	Map<String, Object> attrs = initCommand("iosAccessibilityTraits");
	return attrs.get("commandReturnValue");
}
public T setIosAccessibilityTraits(String value) {
	Map<String, Object> attrs = initCommand("iosAccessibilityTraits");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetId() {
	Map<String, Object> attrs = initCommand("id");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getId() {
	Map<String, Object> attrs = initCommand("id");
	return attrs.get("commandReturnValue");
}
public T setId(String value) {
	Map<String, Object> attrs = initCommand("id");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetModelSyncEvents() {
	Map<String, Object> attrs = initCommand("modelSyncEvents");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getModelSyncEvents() {
	Map<String, Object> attrs = initCommand("modelSyncEvents");
	return attrs.get("commandReturnValue");
}
public T setModelSyncEvents(String value) {
	Map<String, Object> attrs = initCommand("modelSyncEvents");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetModelParam() {
	Map<String, Object> attrs = initCommand("modelParam");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getModelParam() {
	Map<String, Object> attrs = initCommand("modelParam");
	return attrs.get("commandReturnValue");
}
public T setModelParam(String value) {
	Map<String, Object> attrs = initCommand("modelParam");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetModelPojoToUi() {
	Map<String, Object> attrs = initCommand("modelPojoToUi");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getModelPojoToUi() {
	Map<String, Object> attrs = initCommand("modelPojoToUi");
	return attrs.get("commandReturnValue");
}
public T setModelPojoToUi(String value) {
	Map<String, Object> attrs = initCommand("modelPojoToUi");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetModelUiToPojo() {
	Map<String, Object> attrs = initCommand("modelUiToPojo");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getModelUiToPojo() {
	Map<String, Object> attrs = initCommand("modelUiToPojo");
	return attrs.get("commandReturnValue");
}
public T setModelUiToPojo(String value) {
	Map<String, Object> attrs = initCommand("modelUiToPojo");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setModelPojoToUiParams(String value) {
	Map<String, Object> attrs = initCommand("modelPojoToUiParams");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T refreshUiFromModel(String value) {
	Map<String, Object> attrs = initCommand("refreshUiFromModel");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setModelUiToPojoEventIds(String value) {
	Map<String, Object> attrs = initCommand("modelUiToPojoEventIds");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T updateModelData(String expression,
Object payload) {
	Map<String, Object> attrs = initCommand("updateModelData");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("expression", expression);
	wrapper.put("payload", payload);
	attrs.put("value", wrapper);
return (T) this;}
public T notifyDataSetChanged(boolean value) {
	Map<String, Object> attrs = initCommand("notifyDataSetChanged");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetBackground() {
	Map<String, Object> attrs = initCommand("background");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getBackground() {
	Map<String, Object> attrs = initCommand("background");
	return attrs.get("commandReturnValue");
}
public T setBackground(String value) {
	Map<String, Object> attrs = initCommand("background");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setBackgroundRepeat(String value) {
	Map<String, Object> attrs = initCommand("backgroundRepeat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnClick(String value) {
	Map<String, Object> attrs = initCommand("onClick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnTouch(String value) {
	Map<String, Object> attrs = initCommand("onTouch");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getMinWidth() {
	Map<String, Object> attrs = initCommand("minWidth");
	return attrs.get("commandReturnValue");
}
public T setMinWidth(String value) {
	Map<String, Object> attrs = initCommand("minWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getMinHeight() {
	Map<String, Object> attrs = initCommand("minHeight");
	return attrs.get("commandReturnValue");
}
public T setMinHeight(String value) {
	Map<String, Object> attrs = initCommand("minHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setAttributeUnderTest(String value) {
	Map<String, Object> attrs = initCommand("attributeUnderTest");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetBackgroundTint() {
	Map<String, Object> attrs = initCommand("backgroundTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getBackgroundTint() {
	Map<String, Object> attrs = initCommand("backgroundTint");
	return attrs.get("commandReturnValue");
}
public T setBackgroundTint(String value) {
	Map<String, Object> attrs = initCommand("backgroundTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetBackgroundTintMode() {
	Map<String, Object> attrs = initCommand("backgroundTintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getBackgroundTintMode() {
	Map<String, Object> attrs = initCommand("backgroundTintMode");
	return attrs.get("commandReturnValue");
}
public T setBackgroundTintMode(String value) {
	Map<String, Object> attrs = initCommand("backgroundTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetForeground() {
	Map<String, Object> attrs = initCommand("foreground");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getForeground() {
	Map<String, Object> attrs = initCommand("foreground");
	return attrs.get("commandReturnValue");
}
public T setForeground(String value) {
	Map<String, Object> attrs = initCommand("foreground");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setForegroundRepeat(String value) {
	Map<String, Object> attrs = initCommand("foregroundRepeat");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetForegroundTint() {
	Map<String, Object> attrs = initCommand("foregroundTint");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getForegroundTint() {
	Map<String, Object> attrs = initCommand("foregroundTint");
	return attrs.get("commandReturnValue");
}
public T setForegroundTint(String value) {
	Map<String, Object> attrs = initCommand("foregroundTint");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetForegroundTintMode() {
	Map<String, Object> attrs = initCommand("foregroundTintMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getForegroundTintMode() {
	Map<String, Object> attrs = initCommand("foregroundTintMode");
	return attrs.get("commandReturnValue");
}
public T setForegroundTintMode(String value) {
	Map<String, Object> attrs = initCommand("foregroundTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetVisibility() {
	Map<String, Object> attrs = initCommand("visibility");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getVisibility() {
	Map<String, Object> attrs = initCommand("visibility");
	return attrs.get("commandReturnValue");
}
public T setVisibility(String value) {
	Map<String, Object> attrs = initCommand("visibility");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetAlpha() {
	Map<String, Object> attrs = initCommand("alpha");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getAlpha() {
	Map<String, Object> attrs = initCommand("alpha");
	return attrs.get("commandReturnValue");
}
public T setAlpha(float value) {
	Map<String, Object> attrs = initCommand("alpha");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnLongClick(String value) {
	Map<String, Object> attrs = initCommand("onLongClick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetLongClickable() {
	Map<String, Object> attrs = initCommand("longClickable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isLongClickable() {
	Map<String, Object> attrs = initCommand("longClickable");
	return attrs.get("commandReturnValue");
}
public T setLongClickable(boolean value) {
	Map<String, Object> attrs = initCommand("longClickable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetClickable() {
	Map<String, Object> attrs = initCommand("clickable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isClickable() {
	Map<String, Object> attrs = initCommand("clickable");
	return attrs.get("commandReturnValue");
}
public T setClickable(boolean value) {
	Map<String, Object> attrs = initCommand("clickable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetTranslationX() {
	Map<String, Object> attrs = initCommand("translationX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTranslationX() {
	Map<String, Object> attrs = initCommand("translationX");
	return attrs.get("commandReturnValue");
}
public T setTranslationX(String value) {
	Map<String, Object> attrs = initCommand("translationX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetTranslationY() {
	Map<String, Object> attrs = initCommand("translationY");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTranslationY() {
	Map<String, Object> attrs = initCommand("translationY");
	return attrs.get("commandReturnValue");
}
public T setTranslationY(String value) {
	Map<String, Object> attrs = initCommand("translationY");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetTranslationZ() {
	Map<String, Object> attrs = initCommand("translationZ");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTranslationZ() {
	Map<String, Object> attrs = initCommand("translationZ");
	return attrs.get("commandReturnValue");
}
public T setTranslationZ(String value) {
	Map<String, Object> attrs = initCommand("translationZ");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetRotation() {
	Map<String, Object> attrs = initCommand("rotation");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getRotation() {
	Map<String, Object> attrs = initCommand("rotation");
	return attrs.get("commandReturnValue");
}
public T setRotation(float value) {
	Map<String, Object> attrs = initCommand("rotation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetRotationX() {
	Map<String, Object> attrs = initCommand("rotationX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getRotationX() {
	Map<String, Object> attrs = initCommand("rotationX");
	return attrs.get("commandReturnValue");
}
public T setRotationX(float value) {
	Map<String, Object> attrs = initCommand("rotationX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetRotationY() {
	Map<String, Object> attrs = initCommand("rotationY");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getRotationY() {
	Map<String, Object> attrs = initCommand("rotationY");
	return attrs.get("commandReturnValue");
}
public T setRotationY(float value) {
	Map<String, Object> attrs = initCommand("rotationY");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScaleX() {
	Map<String, Object> attrs = initCommand("scaleX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScaleX() {
	Map<String, Object> attrs = initCommand("scaleX");
	return attrs.get("commandReturnValue");
}
public T setScaleX(float value) {
	Map<String, Object> attrs = initCommand("scaleX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScaleY() {
	Map<String, Object> attrs = initCommand("scaleY");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScaleY() {
	Map<String, Object> attrs = initCommand("scaleY");
	return attrs.get("commandReturnValue");
}
public T setScaleY(float value) {
	Map<String, Object> attrs = initCommand("scaleY");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetTransformPivotX() {
	Map<String, Object> attrs = initCommand("transformPivotX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTransformPivotX() {
	Map<String, Object> attrs = initCommand("transformPivotX");
	return attrs.get("commandReturnValue");
}
public T setTransformPivotX(String value) {
	Map<String, Object> attrs = initCommand("transformPivotX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetTransformPivotY() {
	Map<String, Object> attrs = initCommand("transformPivotY");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTransformPivotY() {
	Map<String, Object> attrs = initCommand("transformPivotY");
	return attrs.get("commandReturnValue");
}
public T setTransformPivotY(String value) {
	Map<String, Object> attrs = initCommand("transformPivotY");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T invalidate() {
	Map<String, Object> attrs = initCommand("invalidate");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	
return (T) this;}
public T requestLayout() {
	Map<String, Object> attrs = initCommand("requestLayout");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	
return (T) this;}
public T tryGetKeepScreenOn() {
	Map<String, Object> attrs = initCommand("keepScreenOn");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isKeepScreenOn() {
	Map<String, Object> attrs = initCommand("keepScreenOn");
	return attrs.get("commandReturnValue");
}
public T setKeepScreenOn(boolean value) {
	Map<String, Object> attrs = initCommand("keepScreenOn");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetLayoutDirection() {
	Map<String, Object> attrs = initCommand("layoutDirection");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getLayoutDirection() {
	Map<String, Object> attrs = initCommand("layoutDirection");
	return attrs.get("commandReturnValue");
}
public T setLayoutDirection(String value) {
	Map<String, Object> attrs = initCommand("layoutDirection");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetTextDirection() {
	Map<String, Object> attrs = initCommand("textDirection");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTextDirection() {
	Map<String, Object> attrs = initCommand("textDirection");
	return attrs.get("commandReturnValue");
}
public T setTextDirection(String value) {
	Map<String, Object> attrs = initCommand("textDirection");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetTextAlignment() {
	Map<String, Object> attrs = initCommand("textAlignment");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTextAlignment() {
	Map<String, Object> attrs = initCommand("textAlignment");
	return attrs.get("commandReturnValue");
}
public T setTextAlignment(String value) {
	Map<String, Object> attrs = initCommand("textAlignment");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnDrag(String value) {
	Map<String, Object> attrs = initCommand("onDrag");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setAsDragSource(String value) {
	Map<String, Object> attrs = initCommand("asDragSource");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetEnabled() {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isEnabled() {
	Map<String, Object> attrs = initCommand("enabled");
	return attrs.get("commandReturnValue");
}
public T setEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("enabled");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetDuplicateParentState() {
	Map<String, Object> attrs = initCommand("duplicateParentState");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isDuplicateParentState() {
	Map<String, Object> attrs = initCommand("duplicateParentState");
	return attrs.get("commandReturnValue");
}
public T setDuplicateParentState(boolean value) {
	Map<String, Object> attrs = initCommand("duplicateParentState");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetForegroundGravity() {
	Map<String, Object> attrs = initCommand("foregroundGravity");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getForegroundGravity() {
	Map<String, Object> attrs = initCommand("foregroundGravity");
	return attrs.get("commandReturnValue");
}
public T setForegroundGravity(String value) {
	Map<String, Object> attrs = initCommand("foregroundGravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnKey(String value) {
	Map<String, Object> attrs = initCommand("onKey");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setIosLayerBorderWidth(String value) {
	Map<String, Object> attrs = initCommand("iosLayerBorderWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setIosLayerBorderColor(String value) {
	Map<String, Object> attrs = initCommand("iosLayerBorderColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setIosLayerCornerRadius(String value) {
	Map<String, Object> attrs = initCommand("iosLayerCornerRadius");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setIosLayerMasksToBounds(boolean value) {
	Map<String, Object> attrs = initCommand("iosLayerMasksToBounds");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setZIndex(int value) {
	Map<String, Object> attrs = initCommand("zIndex");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getMaxWidth() {
	Map<String, Object> attrs = initCommand("maxWidth");
	return attrs.get("commandReturnValue");
}
public T setMaxWidth(String value) {
	Map<String, Object> attrs = initCommand("maxWidth");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getMaxHeight() {
	Map<String, Object> attrs = initCommand("maxHeight");
	return attrs.get("commandReturnValue");
}
public T setMaxHeight(String value) {
	Map<String, Object> attrs = initCommand("maxHeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetSelected() {
	Map<String, Object> attrs = initCommand("selected");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isSelected() {
	Map<String, Object> attrs = initCommand("selected");
	return attrs.get("commandReturnValue");
}
public T setSelected(boolean value) {
	Map<String, Object> attrs = initCommand("selected");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setStyle(String value) {
	Map<String, Object> attrs = initCommand("style");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setErrorStyle(String value) {
	Map<String, Object> attrs = initCommand("errorStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetValidateForm() {
	Map<String, Object> attrs = initCommand("validateForm_");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getValidateForm() {
	Map<String, Object> attrs = initCommand("validateForm_");
	return attrs.get("commandReturnValue");
}
public T validateForm(String value) {
	Map<String, Object> attrs = initCommand("validateForm");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setValidation(String value) {
	Map<String, Object> attrs = initCommand("validation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setV_required(String value) {
	Map<String, Object> attrs = initCommand("v_required");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setV_minlength(String value) {
	Map<String, Object> attrs = initCommand("v_minlength");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setV_maxlength(String value) {
	Map<String, Object> attrs = initCommand("v_maxlength");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setV_min(String value) {
	Map<String, Object> attrs = initCommand("v_min");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setV_max(String value) {
	Map<String, Object> attrs = initCommand("v_max");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setV_pattern(String value) {
	Map<String, Object> attrs = initCommand("v_pattern");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setV_type(String value) {
	Map<String, Object> attrs = initCommand("v_type");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setValidationErrorDisplayType(String value) {
	Map<String, Object> attrs = initCommand("validationErrorDisplayType");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setCustomErrorMessageValues(String value) {
	Map<String, Object> attrs = initCommand("customErrorMessageValues");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setCustomErrorMessageKeys(String value) {
	Map<String, Object> attrs = initCommand("customErrorMessageKeys");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setInvalidateOnFrameChange(boolean value) {
	Map<String, Object> attrs = initCommand("invalidateOnFrameChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
}
static class ViewCommandBuilderInternal extends ViewCommandBuilder<ViewCommandBuilderInternal> {
	private IWidget widget;
	public ViewCommandBuilderInternal(IWidget widget) {
		this.widget = widget;
	}
	@Override
	protected ViewCommandBuilderInternal execute(boolean setter) {
		if (setter) {
			widget.executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			widget.getFragment().remeasure();
		}
		widget.executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);

		return this;
	}
}
public static class ViewBean {
	private ViewCommandBuilderInternal commandBuilder;
	public ViewBean(IWidget widget) {
		commandBuilder = new ViewCommandBuilderInternal(widget);
	}
	private ViewCommandBuilderInternal getBuilder() {
		return commandBuilder;
	}
public Object getIosBackgroundColor() {
	return getBuilder().reset().tryGetIosBackgroundColor().execute(false).getIosBackgroundColor(); 
}
public void setIosBackgroundColor(String value) {
	getBuilder().reset().setIosBackgroundColor(value).execute(true);
}

public Object isIosIsHidden() {
	return getBuilder().reset().tryGetIosIsHidden().execute(false).isIosIsHidden(); 
}
public void setIosIsHidden(boolean value) {
	getBuilder().reset().setIosIsHidden(value).execute(true);
}

public Object getIosAlpha() {
	return getBuilder().reset().tryGetIosAlpha().execute(false).getIosAlpha(); 
}
public void setIosAlpha(float value) {
	getBuilder().reset().setIosAlpha(value).execute(true);
}

public Object isIosIsOpaque() {
	return getBuilder().reset().tryGetIosIsOpaque().execute(false).isIosIsOpaque(); 
}
public void setIosIsOpaque(boolean value) {
	getBuilder().reset().setIosIsOpaque(value).execute(true);
}

public Object getIosTintColor() {
	return getBuilder().reset().tryGetIosTintColor().execute(false).getIosTintColor(); 
}
public void setIosTintColor(String value) {
	getBuilder().reset().setIosTintColor(value).execute(true);
}

public Object isIosClipsToBounds() {
	return getBuilder().reset().tryGetIosClipsToBounds().execute(false).isIosClipsToBounds(); 
}
public void setIosClipsToBounds(boolean value) {
	getBuilder().reset().setIosClipsToBounds(value).execute(true);
}

public Object isIosClearsContextBeforeDrawing() {
	return getBuilder().reset().tryGetIosClearsContextBeforeDrawing().execute(false).isIosClearsContextBeforeDrawing(); 
}
public void setIosClearsContextBeforeDrawing(boolean value) {
	getBuilder().reset().setIosClearsContextBeforeDrawing(value).execute(true);
}

public Object isIosIsUserInteractionEnabled() {
	return getBuilder().reset().tryGetIosIsUserInteractionEnabled().execute(false).isIosIsUserInteractionEnabled(); 
}
public void setIosIsUserInteractionEnabled(boolean value) {
	getBuilder().reset().setIosIsUserInteractionEnabled(value).execute(true);
}

public Object isIosIsMultipleTouchEnabled() {
	return getBuilder().reset().tryGetIosIsMultipleTouchEnabled().execute(false).isIosIsMultipleTouchEnabled(); 
}
public void setIosIsMultipleTouchEnabled(boolean value) {
	getBuilder().reset().setIosIsMultipleTouchEnabled(value).execute(true);
}

public Object isIosIsExclusiveTouch() {
	return getBuilder().reset().tryGetIosIsExclusiveTouch().execute(false).isIosIsExclusiveTouch(); 
}
public void setIosIsExclusiveTouch(boolean value) {
	getBuilder().reset().setIosIsExclusiveTouch(value).execute(true);
}

public Object isIosPreservesSuperviewLayoutMargins() {
	return getBuilder().reset().tryGetIosPreservesSuperviewLayoutMargins().execute(false).isIosPreservesSuperviewLayoutMargins(); 
}
public void setIosPreservesSuperviewLayoutMargins(boolean value) {
	getBuilder().reset().setIosPreservesSuperviewLayoutMargins(value).execute(true);
}

public Object isIosInsetsLayoutMarginsFromSafeArea() {
	return getBuilder().reset().tryGetIosInsetsLayoutMarginsFromSafeArea().execute(false).isIosInsetsLayoutMarginsFromSafeArea(); 
}
public void setIosInsetsLayoutMarginsFromSafeArea(boolean value) {
	getBuilder().reset().setIosInsetsLayoutMarginsFromSafeArea(value).execute(true);
}

public Object isIosAutoresizesSubviews() {
	return getBuilder().reset().tryGetIosAutoresizesSubviews().execute(false).isIosAutoresizesSubviews(); 
}
public void setIosAutoresizesSubviews(boolean value) {
	getBuilder().reset().setIosAutoresizesSubviews(value).execute(true);
}

public Object isIosTranslatesAutoresizingMaskIntoConstraints() {
	return getBuilder().reset().tryGetIosTranslatesAutoresizingMaskIntoConstraints().execute(false).isIosTranslatesAutoresizingMaskIntoConstraints(); 
}
public void setIosTranslatesAutoresizingMaskIntoConstraints(boolean value) {
	getBuilder().reset().setIosTranslatesAutoresizingMaskIntoConstraints(value).execute(true);
}

public Object getIosContentScaleFactor() {
	return getBuilder().reset().tryGetIosContentScaleFactor().execute(false).getIosContentScaleFactor(); 
}
public void setIosContentScaleFactor(float value) {
	getBuilder().reset().setIosContentScaleFactor(value).execute(true);
}

public Object isIosIsFocused() {
	return getBuilder().reset().tryGetIosIsFocused().execute(false).isIosIsFocused(); 
}
public Object getIosRestorationIdentifier() {
	return getBuilder().reset().tryGetIosRestorationIdentifier().execute(false).getIosRestorationIdentifier(); 
}
public void setIosRestorationIdentifier(String value) {
	getBuilder().reset().setIosRestorationIdentifier(value).execute(true);
}

public Object getIosTag() {
	return getBuilder().reset().tryGetIosTag().execute(false).getIosTag(); 
}
public void setIosTag(int value) {
	getBuilder().reset().setIosTag(value).execute(true);
}

public Object isIosAccessibilityIgnoresInvertColors() {
	return getBuilder().reset().tryGetIosAccessibilityIgnoresInvertColors().execute(false).isIosAccessibilityIgnoresInvertColors(); 
}
public void setIosAccessibilityIgnoresInvertColors(boolean value) {
	getBuilder().reset().setIosAccessibilityIgnoresInvertColors(value).execute(true);
}

public Object getIosLargeContentImage() {
	return getBuilder().reset().tryGetIosLargeContentImage().execute(false).getIosLargeContentImage(); 
}
public void setIosLargeContentImage(String value) {
	getBuilder().reset().setIosLargeContentImage(value).execute(true);
}

public Object getIosLargeContentTitle() {
	return getBuilder().reset().tryGetIosLargeContentTitle().execute(false).getIosLargeContentTitle(); 
}
public void setIosLargeContentTitle(String value) {
	getBuilder().reset().setIosLargeContentTitle(value).execute(true);
}

public Object isIosScalesLargeContentImage() {
	return getBuilder().reset().tryGetIosScalesLargeContentImage().execute(false).isIosScalesLargeContentImage(); 
}
public void setIosScalesLargeContentImage(boolean value) {
	getBuilder().reset().setIosScalesLargeContentImage(value).execute(true);
}

public Object isIosShowsLargeContentViewer() {
	return getBuilder().reset().tryGetIosShowsLargeContentViewer().execute(false).isIosShowsLargeContentViewer(); 
}
public void setIosShowsLargeContentViewer(boolean value) {
	getBuilder().reset().setIosShowsLargeContentViewer(value).execute(true);
}

public Object isIosIsAccessibilityElement() {
	return getBuilder().reset().tryGetIosIsAccessibilityElement().execute(false).isIosIsAccessibilityElement(); 
}
public void setIosIsAccessibilityElement(boolean value) {
	getBuilder().reset().setIosIsAccessibilityElement(value).execute(true);
}

public Object getFocusable() {
	return getBuilder().reset().tryGetFocusable().execute(false).getFocusable();
}
public void setFocusable(boolean value) {
	getBuilder().reset().setFocusable(value).execute(true); 
}

public Object getIosAccessibilityLabel() {
	return getBuilder().reset().tryGetIosAccessibilityLabel().execute(false).getIosAccessibilityLabel(); 
}
public void setIosAccessibilityLabel(String value) {
	getBuilder().reset().setIosAccessibilityLabel(value).execute(true);
}

public Object getIosAccessibilityHint() {
	return getBuilder().reset().tryGetIosAccessibilityHint().execute(false).getIosAccessibilityHint(); 
}
public void setIosAccessibilityHint(String value) {
	getBuilder().reset().setIosAccessibilityHint(value).execute(true);
}

public Object getContentDescription() {
	return getBuilder().reset().tryGetContentDescription().execute(false).getContentDescription();
}
public void setContentDescription(String value) {
	getBuilder().reset().setContentDescription(value).execute(true); 
}

public Object getIosAccessibilityValue() {
	return getBuilder().reset().tryGetIosAccessibilityValue().execute(false).getIosAccessibilityValue(); 
}
public void setIosAccessibilityValue(String value) {
	getBuilder().reset().setIosAccessibilityValue(value).execute(true);
}

public Object getIosAccessibilityTraits() {
	return getBuilder().reset().tryGetIosAccessibilityTraits().execute(false).getIosAccessibilityTraits(); 
}
public void setIosAccessibilityTraits(String value) {
	getBuilder().reset().setIosAccessibilityTraits(value).execute(true);
}

public Object getModelSyncEvents() {
	return getBuilder().reset().tryGetModelSyncEvents().execute(false).getModelSyncEvents(); 
}
public void setModelSyncEvents(String value) {
	getBuilder().reset().setModelSyncEvents(value).execute(true);
}

public Object getModelParam() {
	return getBuilder().reset().tryGetModelParam().execute(false).getModelParam(); 
}
public void setModelParam(String value) {
	getBuilder().reset().setModelParam(value).execute(true);
}

public Object getModelPojoToUi() {
	return getBuilder().reset().tryGetModelPojoToUi().execute(false).getModelPojoToUi(); 
}
public void setModelPojoToUi(String value) {
	getBuilder().reset().setModelPojoToUi(value).execute(true);
}

public Object getModelUiToPojo() {
	return getBuilder().reset().tryGetModelUiToPojo().execute(false).getModelUiToPojo(); 
}
public void setModelUiToPojo(String value) {
	getBuilder().reset().setModelUiToPojo(value).execute(true);
}

public void setModelPojoToUiParams(String value) {
	getBuilder().reset().setModelPojoToUiParams(value).execute(true);
}

public void refreshUiFromModel(String value) {
	getBuilder().reset().refreshUiFromModel(value).execute(true);
}

public void setModelUiToPojoEventIds(String value) {
	getBuilder().reset().setModelUiToPojoEventIds(value).execute(true);
}

public void updateModelData(String expression,
Object payload) {
	getBuilder().reset().updateModelData(expression,
payload).execute(true);
}

public void notifyDataSetChanged(boolean value) {
	getBuilder().reset().notifyDataSetChanged(value).execute(true);
}

public Object getBackground() {
	return getBuilder().reset().tryGetBackground().execute(false).getBackground(); 
}
public void setBackground(String value) {
	getBuilder().reset().setBackground(value).execute(true);
}

public void setBackgroundRepeat(String value) {
	getBuilder().reset().setBackgroundRepeat(value).execute(true);
}

public void setOnClick(String value) {
	getBuilder().reset().setOnClick(value).execute(true);
}

public void setOnTouch(String value) {
	getBuilder().reset().setOnTouch(value).execute(true);
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

public void setAttributeUnderTest(String value) {
	getBuilder().reset().setAttributeUnderTest(value).execute(true);
}

public Object getBackgroundTint() {
	return getBuilder().reset().tryGetBackgroundTint().execute(false).getBackgroundTint(); 
}
public void setBackgroundTint(String value) {
	getBuilder().reset().setBackgroundTint(value).execute(true);
}

public Object getBackgroundTintMode() {
	return getBuilder().reset().tryGetBackgroundTintMode().execute(false).getBackgroundTintMode(); 
}
public void setBackgroundTintMode(String value) {
	getBuilder().reset().setBackgroundTintMode(value).execute(true);
}

public Object getForeground() {
	return getBuilder().reset().tryGetForeground().execute(false).getForeground(); 
}
public void setForeground(String value) {
	getBuilder().reset().setForeground(value).execute(true);
}

public void setForegroundRepeat(String value) {
	getBuilder().reset().setForegroundRepeat(value).execute(true);
}

public Object getForegroundTint() {
	return getBuilder().reset().tryGetForegroundTint().execute(false).getForegroundTint(); 
}
public void setForegroundTint(String value) {
	getBuilder().reset().setForegroundTint(value).execute(true);
}

public Object getForegroundTintMode() {
	return getBuilder().reset().tryGetForegroundTintMode().execute(false).getForegroundTintMode(); 
}
public void setForegroundTintMode(String value) {
	getBuilder().reset().setForegroundTintMode(value).execute(true);
}

public Object getVisibility() {
	return getBuilder().reset().tryGetVisibility().execute(false).getVisibility(); 
}
public void setVisibility(String value) {
	getBuilder().reset().setVisibility(value).execute(true);
}

public Object getAlpha() {
	return getBuilder().reset().tryGetAlpha().execute(false).getAlpha(); 
}
public void setAlpha(float value) {
	getBuilder().reset().setAlpha(value).execute(true);
}

public void setOnLongClick(String value) {
	getBuilder().reset().setOnLongClick(value).execute(true);
}

public Object isLongClickable() {
	return getBuilder().reset().tryGetLongClickable().execute(false).isLongClickable(); 
}
public void setLongClickable(boolean value) {
	getBuilder().reset().setLongClickable(value).execute(true);
}

public Object isClickable() {
	return getBuilder().reset().tryGetClickable().execute(false).isClickable(); 
}
public void setClickable(boolean value) {
	getBuilder().reset().setClickable(value).execute(true);
}

public Object getTranslationX() {
	return getBuilder().reset().tryGetTranslationX().execute(false).getTranslationX(); 
}
public void setTranslationX(String value) {
	getBuilder().reset().setTranslationX(value).execute(true);
}

public Object getTranslationY() {
	return getBuilder().reset().tryGetTranslationY().execute(false).getTranslationY(); 
}
public void setTranslationY(String value) {
	getBuilder().reset().setTranslationY(value).execute(true);
}

public Object getTranslationZ() {
	return getBuilder().reset().tryGetTranslationZ().execute(false).getTranslationZ(); 
}
public void setTranslationZ(String value) {
	getBuilder().reset().setTranslationZ(value).execute(true);
}

public Object getRotation() {
	return getBuilder().reset().tryGetRotation().execute(false).getRotation(); 
}
public void setRotation(float value) {
	getBuilder().reset().setRotation(value).execute(true);
}

public Object getRotationX() {
	return getBuilder().reset().tryGetRotationX().execute(false).getRotationX(); 
}
public void setRotationX(float value) {
	getBuilder().reset().setRotationX(value).execute(true);
}

public Object getRotationY() {
	return getBuilder().reset().tryGetRotationY().execute(false).getRotationY(); 
}
public void setRotationY(float value) {
	getBuilder().reset().setRotationY(value).execute(true);
}

public Object getScaleX() {
	return getBuilder().reset().tryGetScaleX().execute(false).getScaleX(); 
}
public void setScaleX(float value) {
	getBuilder().reset().setScaleX(value).execute(true);
}

public Object getScaleY() {
	return getBuilder().reset().tryGetScaleY().execute(false).getScaleY(); 
}
public void setScaleY(float value) {
	getBuilder().reset().setScaleY(value).execute(true);
}

public Object getTransformPivotX() {
	return getBuilder().reset().tryGetTransformPivotX().execute(false).getTransformPivotX(); 
}
public void setTransformPivotX(String value) {
	getBuilder().reset().setTransformPivotX(value).execute(true);
}

public Object getTransformPivotY() {
	return getBuilder().reset().tryGetTransformPivotY().execute(false).getTransformPivotY(); 
}
public void setTransformPivotY(String value) {
	getBuilder().reset().setTransformPivotY(value).execute(true);
}

public void invalidate() {
	getBuilder().reset().invalidate().execute(true);
}

public void requestLayout() {
	getBuilder().reset().requestLayout().execute(true);
}

public Object isKeepScreenOn() {
	return getBuilder().reset().tryGetKeepScreenOn().execute(false).isKeepScreenOn(); 
}
public void setKeepScreenOn(boolean value) {
	getBuilder().reset().setKeepScreenOn(value).execute(true);
}

public Object getLayoutDirection() {
	return getBuilder().reset().tryGetLayoutDirection().execute(false).getLayoutDirection(); 
}
public void setLayoutDirection(String value) {
	getBuilder().reset().setLayoutDirection(value).execute(true);
}

public Object getTextDirection() {
	return getBuilder().reset().tryGetTextDirection().execute(false).getTextDirection(); 
}
public void setTextDirection(String value) {
	getBuilder().reset().setTextDirection(value).execute(true);
}

public Object getTextAlignment() {
	return getBuilder().reset().tryGetTextAlignment().execute(false).getTextAlignment(); 
}
public void setTextAlignment(String value) {
	getBuilder().reset().setTextAlignment(value).execute(true);
}

public void setOnDrag(String value) {
	getBuilder().reset().setOnDrag(value).execute(true);
}

public void setAsDragSource(String value) {
	getBuilder().reset().setAsDragSource(value).execute(true);
}

public Object isEnabled() {
	return getBuilder().reset().tryGetEnabled().execute(false).isEnabled(); 
}
public void setEnabled(boolean value) {
	getBuilder().reset().setEnabled(value).execute(true);
}

public Object isDuplicateParentState() {
	return getBuilder().reset().tryGetDuplicateParentState().execute(false).isDuplicateParentState(); 
}
public void setDuplicateParentState(boolean value) {
	getBuilder().reset().setDuplicateParentState(value).execute(true);
}

public Object getForegroundGravity() {
	return getBuilder().reset().tryGetForegroundGravity().execute(false).getForegroundGravity(); 
}
public void setForegroundGravity(String value) {
	getBuilder().reset().setForegroundGravity(value).execute(true);
}

public void setOnKey(String value) {
	getBuilder().reset().setOnKey(value).execute(true);
}

public void setIosLayerBorderWidth(String value) {
	getBuilder().reset().setIosLayerBorderWidth(value).execute(true);
}

public void setIosLayerBorderColor(String value) {
	getBuilder().reset().setIosLayerBorderColor(value).execute(true);
}

public void setIosLayerCornerRadius(String value) {
	getBuilder().reset().setIosLayerCornerRadius(value).execute(true);
}

public void setIosLayerMasksToBounds(boolean value) {
	getBuilder().reset().setIosLayerMasksToBounds(value).execute(true);
}

public void setZIndex(int value) {
	getBuilder().reset().setZIndex(value).execute(true);
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

public Object isSelected() {
	return getBuilder().reset().tryGetSelected().execute(false).isSelected(); 
}
public void setSelected(boolean value) {
	getBuilder().reset().setSelected(value).execute(true);
}

public void setStyle(String value) {
	getBuilder().reset().setStyle(value).execute(true);
}

public void setErrorStyle(String value) {
	getBuilder().reset().setErrorStyle(value).execute(true);
}

public Object getValidateForm() {
	return getBuilder().reset().tryGetValidateForm().execute(false).getValidateForm(); 
}
public void validateForm(String value) {
	getBuilder().reset().validateForm(value).execute(true);
}

public void setValidation(String value) {
	getBuilder().reset().setValidation(value).execute(true);
}

public void setV_required(String value) {
	getBuilder().reset().setV_required(value).execute(true);
}

public void setV_minlength(String value) {
	getBuilder().reset().setV_minlength(value).execute(true);
}

public void setV_maxlength(String value) {
	getBuilder().reset().setV_maxlength(value).execute(true);
}

public void setV_min(String value) {
	getBuilder().reset().setV_min(value).execute(true);
}

public void setV_max(String value) {
	getBuilder().reset().setV_max(value).execute(true);
}

public void setV_pattern(String value) {
	getBuilder().reset().setV_pattern(value).execute(true);
}

public void setV_type(String value) {
	getBuilder().reset().setV_type(value).execute(true);
}

public void setValidationErrorDisplayType(String value) {
	getBuilder().reset().setValidationErrorDisplayType(value).execute(true);
}

public void setCustomErrorMessageValues(String value) {
	getBuilder().reset().setCustomErrorMessageValues(value).execute(true);
}

public void setCustomErrorMessageKeys(String value) {
	getBuilder().reset().setCustomErrorMessageKeys(value).execute(true);
}

public void setInvalidateOnFrameChange(boolean value) {
	getBuilder().reset().setInvalidateOnFrameChange(value).execute(true);
}

}


	// end - body
	public native static void nativeMakeFrame(Object uiView, int l, int t, int r, int b, int height)/*-[
		[((UIView*) uiView) setFrame:CGRectMake(l, t, r-l, b-t)];
		((UIScrollView*) uiView).contentSize = CGSizeMake(r-l, height);
	]-*/;
	
	public native static void updateBounds(Object objview, int x, int y, int width, int height) /*-[
		UIView* uiview = ((UIView*) objview);
		uiview.frame = CGRectMake(x, y, width, height);
	]-*/;
	
	public native static Object getFirstChildOrSelf(Object objview) /*-[
		UIView* uiview = ((UIView*) objview);
		return uiview.subviews.count > 0 ? uiview.subviews[0] : uiview;
	]-*/;
	
	public native static void nativeMakeFrameForHorizontalScrollView(Object uiView, int l, int t, int r, int b, int width)/*-[
		[((UIView*) uiView) setFrame:CGRectMake(l, t, r-l, b-t)];
		((UIScrollView*) uiView).contentSize = CGSizeMake(width, b-t);
	]-*/;
	
	public native static void nativeMakeFrame(Object uiView, int l, int t, int r, int b)/*-[
			if ([uiView isKindOfClass:[UIViewController class]]) {
				[((UIViewController*) uiView).view setFrame:CGRectMake(l, t, r-l, b-t)];
			} else {
				[((UIView*) uiView) setFrame:CGRectMake(l, t, r-l, b-t)];
			}  	
	]-*/;

	public static boolean isRTLLayout(IWidget widget) {
		return isRTLLayout();
	}
	
	public native static boolean isRTLLayout() /*-[
		return [UIApplication sharedApplication].userInterfaceLayoutDirection == UIUserInterfaceLayoutDirectionRightToLeft;
	]-*/;

	private static void setBgOnControl(IWidget w, Object uiview, Object objValue) {
		if (isColor(objValue)) {
			nativeSetBgColor(uiview, objValue);
		} else {
			clearBgColor(uiview, objValue);
		}
		
		if (isImage(objValue)) {
			w.applyAttributeCommand("background", "drawImage", new String[] {}, true);
		} else {
			w.applyAttributeCommand("background", "drawImage", new String[] {}, false);
		}
		
		// redraw image
		if (w.isInitialised()) {
			w.invalidate();
		}
	}
	
	public static void setBackground(IWidget w, Object nativeWidget, Object objValue) {
    	setBackground(w, w.asNativeWidget(), objValue, false);
    }
    
	private static void setBackground(IWidget w, Object nativeView, Object objValue, boolean stateChange) {
		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			View view = (View) w.asWidget();
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable)objValue;
			view.setBackground(drawable);
			
			objValue = drawable.getDrawable();
		}
		if (isResizableImage(objValue)) {
			View view = (View) w.asWidget();
			r.android.graphics.drawable.Drawable drawable = view.getBackground();
			
			if (drawable == null) {
				drawable = new r.android.graphics.drawable.Drawable();
			}
			drawable.setMinimumWidth(getImageWidth(objValue));
			drawable.setMinimumHeight(getImageHeight(objValue));
			view.setBackground(drawable);
		}
		
		setBgOnControl(w, nativeView, objValue);

	}
	
	private static void updateWidthAndHeight(IWidget w, r.android.graphics.drawable.StateListDrawable background, Object value, String type, String conveterType) {
		if (isImage(value)) {
			background.setMinimumWidth(getImageWidth(value));
		    background.setMinimumHeight(getImageHeight(value));
		    w.applyAttributeCommand(type, conveterType, new String[] {}, true);
		}
	}
	
	public static void setBgDrawabeOnView(int width, int height, View view) {
		 r.android.graphics.drawable.Drawable background = view.getBackground();
         if (background == null) {
         	background = new r.android.graphics.drawable.Drawable();
         }
	    background.setMinimumWidth(width);
	    background.setMinimumHeight(height);
	    view.setBackground(background);
	}
	
	public static native boolean isColor(Object value) /*-[
		return[value isKindOfClass:[UIColor class]];
	]-*/;
	
	private static boolean isResizableImage(Object obj) {
		return (obj != null && obj.getClass().getName().equals("_UIResizableImage"));
	}

	public static native boolean isImage(Object value) /*-[
		return[value isKindOfClass:[UIImage class]];
	]-*/;
	
	public static native int getImageWidth(Object value)/*-[
		UIImage* image = ((UIImage*) value);
		return image.size.width;
	]-*/;
	
	public static native int getImageHeight(Object value)/*-[
		UIImage* image = ((UIImage*) value);
		return image.size.height;
	]-*/;

	private static native void clearBgColor(Object view, Object value) /*-[
		((UIView *) view).backgroundColor = [UIColor clearColor];
	]-*/;
	private static native void nativeSetBgColor(Object view, Object value) /*-[
		((UIView *) view).backgroundColor = value;
	]-*/;
	
	
	private static void setOnClick(IWidget w, Object nativeView, Object objValue) {
		View.OnClickListener onClickListener;
		
		if (objValue instanceof String) {
			onClickListener = new OnClickListener(w, (String) objValue);
		} else {
			onClickListener = (View.OnClickListener) objValue;
		}
		setOnClick(w, "default", nativeView, onClickListener);
	}

	public static void setOnClick(IWidget w, String id, Object nativeView, View.OnClickListener onClickListener) {
		UITapGestureRecognizerDelegate delegate = new UITapGestureRecognizerDelegate(w, onClickListener);
		delegate.nativeAddClickListener(id, nativeView);
	}
	
	static class UIControlEventTouchDelegate {
		@com.google.j2objc.annotations.Weak private IWidget  widget;
		private View.OnTouchListener listener;
		public UIControlEventTouchDelegate(IWidget widget, View.OnTouchListener listener) {
			// to avoid gc in objective c
			widget.getFragment().addListener(widget, this);
			this.widget = widget;
			this.listener = listener;
		}
		public void onTouchDown(int x, int y, int rawX, int rawY) {
			sendEvent(x, y, rawX, rawY, MotionEvent.ACTION_DOWN);
		}
		
		public void onTouchUp(int x, int y, int rawX, int rawY) {
			sendEvent(x, y, rawX, rawY, MotionEvent.ACTION_UP);
		}
		public void onTouchMove(int x, int y, int rawX, int rawY) {
			sendEvent(x, y, rawX, rawY, MotionEvent.ACTION_MOVE);
		}
		
		public void onTouchCancel(int x, int y, int rawX, int rawY) {
			sendEvent(x, y, rawX, rawY, MotionEvent.ACTION_CANCEL);
		}
		
		public void onTouchOutside(int x, int y, int rawX, int rawY) {
			sendEvent(x, y, rawX, rawY, MotionEvent.ACTION_OUTSIDE);
		}
		
		public void sendEvent(int x, int y, int rawX, int rawY, int action) {
			r.android.view.View.MotionEvent motionEvent = new r.android.view.View.MotionEvent();
			motionEvent.setAction(action);
			motionEvent.setX(x);
			motionEvent.setY(y);
			motionEvent.setRawX(rawX);
			motionEvent.setRawY(rawY);
			listener.onTouch((View) widget.asWidget(), motionEvent);
			System.out.println("action " + action);
		}
		
		public native void nativeAddOnTouchListener(Object nativeWidget)/*-[
			UIView* view = ((UIView*)nativeWidget);
			view.userInteractionEnabled = YES;
			if ([nativeWidget isKindOfClass:[UIControl class]]) {
				UIControl* control = ((UIControl*)nativeWidget);
				[control removeTarget:nil action:NULL forControlEvents:UIControlEventAllEvents];
				[control addTarget:self action:@selector(touchDown:withEvent:) forControlEvents:UIControlEventTouchDown];
				[control addTarget:self action:@selector(touchUpInside:withEvent:) forControlEvents:UIControlEventTouchUpInside];
				[control addTarget:self action:@selector(touchMove:withEvent:) forControlEvents:UIControlEventTouchDragInside];
				[control addTarget:self action:@selector(touchMove:withEvent:) forControlEvents:UIControlEventTouchDragOutside];
				[control addTarget:self action:@selector(touchUpOutside:withEvent:) forControlEvents:UIControlEventTouchUpOutside];
				[control addTarget:self action:@selector(touchCancel:withEvent:) forControlEvents:UIControlEventTouchCancel];

			}
		]-*/;
		
		/*-[
		- (void)touchDown:(id)sender withEvent:(UIEvent *) event{
		 	UITouch* touchEvent = [event.allTouches allObjects][0];
    		CGPoint pointInView = [touchEvent locationInView:sender];
    		CGPoint pointInWindow = [touchEvent locationInView:((UIControl*)sender).window];
			[self onTouchDownWithInt:pointInView.x withInt:pointInView.y withInt:pointInWindow.x withInt:pointInWindow.y];
		}
		- (void)touchUpInside:(id)sender withEvent:(UIEvent *) event{
			UITouch* touchEvent = [event.allTouches allObjects][0];
    		CGPoint pointInView = [touchEvent locationInView:sender];
    		CGPoint pointInWindow = [touchEvent locationInView:((UIControl*)sender).window];
			[self onTouchUpWithInt:pointInView.x withInt:pointInView.y withInt:pointInWindow.x withInt:pointInWindow.y];
		}
		- (void)touchMove:(id)sender withEvent:(UIEvent *) event{
			UITouch* touchEvent = [event.allTouches allObjects][0];
    		CGPoint pointInView = [touchEvent locationInView:sender];
    		CGPoint pointInWindow = [touchEvent locationInView:((UIControl*)sender).window];
			[self onTouchMoveWithInt:pointInView.x withInt:pointInView.y withInt:pointInWindow.x withInt:pointInWindow.y];
		}
		- (void)touchUpOutside:(id)sender withEvent:(UIEvent *) event{
			UITouch* touchEvent = [event.allTouches allObjects][0];
    		CGPoint pointInView = [touchEvent locationInView:sender];
    		CGPoint pointInWindow = [touchEvent locationInView:((UIControl*)sender).window];
			[self onTouchOutsideWithInt:pointInView.x withInt:pointInView.y withInt:pointInWindow.x withInt:pointInWindow.y];
		}
		- (void)touchCancel:(id)sender withEvent:(UIEvent *) event{
			UITouch* touchEvent = [event.allTouches allObjects][0];
    		CGPoint pointInView = [touchEvent locationInView:sender];
    		CGPoint pointInWindow = [touchEvent locationInView:((UIControl*)sender).window];
			[self onTouchCancelWithInt:pointInView.x withInt:pointInView.y withInt:pointInWindow.x withInt:pointInWindow.y];
		}
		
		]-*/;		
	}
	
	static class UILongTapGestureRecognizerDelegate {
		@com.google.j2objc.annotations.Weak private IWidget  widget;
		private View.OnLongClickListener listener;
		public UILongTapGestureRecognizerDelegate(IWidget widget, View.OnLongClickListener listener) {
			// to avoid gc in objective c
			widget.getFragment().addListener(widget, this);
			this.widget = widget;
			this.listener = listener;
		}
		public native void nativeAddLongClickListener(Object nativeWidget)/*-[
			UIView* view = ((UIView*)nativeWidget);
			ASUILongTapGestureRecognizer *gestureRecognizer = [[ASUILongTapGestureRecognizer alloc] initWithTarget:self action:@selector(longPressDetected:)];
	    	view.userInteractionEnabled = YES;		
			
			for (UIGestureRecognizer* interaction in view.gestureRecognizers) {
		        if ([interaction isKindOfClass:[ASUILongTapGestureRecognizer class]]) {
		            [view removeGestureRecognizer:interaction];
		        }
		    }
			[view addGestureRecognizer:gestureRecognizer];
		]-*/;
		
		
		public void onLongClick() {
			listener.onLongClick((View) widget.asWidget());
		}
		/*-[
	 	- (void)longPressDetected:(ASUILongTapGestureRecognizer *)tapRecognizer {
	 		ADView* adView = (ADView*)[widget_ asWidget];
	 		if ([adView isLongClickable]) {
	  			if (tapRecognizer.state == UIGestureRecognizerStateEnded) {
	        		[self onLongClick];
	    		}
    		}
		}
		]-*/
	}
	
	static class UITapGestureRecognizerDelegate {
		@com.google.j2objc.annotations.Weak private IWidget  widget;
		private View.OnClickListener listener;
		public UITapGestureRecognizerDelegate(IWidget widget, View.OnClickListener listener) {
			// to avoid gc in objective c
			widget.getFragment().addListener(widget, this);
			this.widget = widget;
			this.listener = listener;
		}
		public native void nativeAddClickListener(String id, Object nativeWidget)/*-[
			UIView* view = ((UIView*)nativeWidget);
			ASUITapGestureRecognizer *gestureRecognizer = [[ASUITapGestureRecognizer alloc] initWithTarget:self action:@selector(tapDetected:)];
	    	view.userInteractionEnabled = YES;		
			gestureRecognizer.numberOfTapsRequired = 1;
			gestureRecognizer.id = id_;
			
			for (UIGestureRecognizer* interaction in view.gestureRecognizers) {
		        if ([interaction isKindOfClass:[ASUITapGestureRecognizer class]] && [id_ isEqualToString:((ASUITapGestureRecognizer*)interaction).id]) {
		            [view removeGestureRecognizer:interaction];
		        }
		    }
			[view addGestureRecognizer:gestureRecognizer];
		]-*/;
		
		
		public void click() {
			listener.onClick((View) widget.asWidget());
		}
		/*-[
	 	- (void)tapDetected:(ASUITapGestureRecognizer *)tapRecognizer {
	 		if (tapRecognizer.state == UIGestureRecognizerStateEnded) {
  				[self click];
  			}
		}
		]-*/
	}
	
    private static void setMinHeight(IWidget w, Object objValue) {
        ((View) w.asWidget()).setMinimumHeight((int) objValue);
        
    }


    private static void setMinWidth(IWidget w, Object objValue) {
        ((View) w.asWidget()).setMinimumWidth((int) objValue);
        
    }

    private static Object getMinHeight(IWidget w) {
        View view = (View) w.asWidget();
        return view.getMinimumHeight();
    }

    private static Object getMinWidth(IWidget w) {
        View view = (View) w.asWidget();
        return view.getMinimumWidth();
    }
	
    public static void registerCommandConveter(IWidget widget) {
		widget.registerForAttributeCommandChainWithPhase("predraw", "background");
		widget.registerForAttributeCommandChainWithPhase("postdraw", "foreground");
		
		widget.registerForAttributeCommandChainWithPhase("preframe", "translationX", "translationY", "translationZ", "scaleX", "scaleY",
				"rotation", "rotationX", "rotationY", "transformPivotX", "transformPivotY");
		widget.registerForAttributeCommandChainWithPhase("postframe", "translationX", "translationY", "translationZ", "scaleX", "scaleY",
				"rotation", "rotationX", "rotationY", "transformPivotX", "transformPivotY");

	}
    
	private static boolean isNativeRtlSupported() {
		return false;
	}
	
    public static Object getParent(IWidget widget) {        
    	Object parent = widget.getParent().getCompositeLeaf().asNativeWidget();
        return parent;
    }
    
	
	private static void setBackgroundTintMode(IWidget w, Object objValue) {
		w.applyAttributeCommand("background", "cgTintColor", new String[] {"backgroundTintMode"}, true, "drawableTintMode", objValue);
	}

	private static void setBackgroundTint(IWidget w,Object objValue) {
		r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
		View view = (View)w.asWidget();
		view.setBackgroundTintList(colorStateList);
		
		w.applyAttributeCommand("background", "cgTintColor", new String[] {"backgroundTint"}, true, "drawableTint", objValue);		
	}
	

	private static void setForegroundTintMode(IWidget w, Object objValue) {
		w.applyAttributeCommand("foreground", "cgTintColor", new String[] {"foregroundTintMode"}, true, "drawableTintMode", objValue);
	}

	private static void setForegroundTint(IWidget w, Object objValue) {
		r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) objValue;
		View view = (View)w.asWidget();
		view.setForegroundTintList(colorStateList);
		w.applyAttributeCommand("foreground", "cgTintColor", new String[] {"foregroundTint"}, true, "drawableTint", objValue);		
	}

	private static void setForeground(IWidget w, Object nativeWidget, Object objValue) {
		w.addForegroundIfNeeded();

		if (objValue instanceof r.android.graphics.drawable.Drawable) {
			r.android.graphics.drawable.Drawable drawable = (r.android.graphics.drawable.Drawable)objValue;
			((View) w.asWidget()).setForeground(drawable);
			
			objValue = drawable.getDrawable();
		}
		
		setFgOnControl(w, nativeWidget, objValue);
	}
	
	private static void setFgOnControl(IWidget w, Object nativeWidget, Object objValue) {
		if (isImage(objValue) || isColor(objValue)) {
			w.applyAttributeCommand("foreground", "drawImageOrColor", new String[] {}, true);
		} else {
			w.applyAttributeCommand("foreground", "drawImageOrColor", new String[] {}, false);
		}
	}

	public static void setVisibility(IWidget w, Object nativeWidget, Object objValue) {
		 View view = (View) w.asWidget();
	     view.setVisibility((int) objValue);	
	}
	
	public static native void nativeSetVisibility(Object view, boolean hidden) /*-[
		[((UIView *) view) setHidden:  hidden];
	]-*/;


	private static Object getVisibility(IWidget w) {
		View view = (View) w.asWidget();
        return view.getVisibility();
	}
	
	private static void setLongClickable(IWidget w, Object objValue) {
        View view = (View) w.asWidget();
        view.setLongClickable((boolean) objValue); 
	}


	private static Object getLongClickable(IWidget w) {
		View view = (View) w.asWidget();
		return view.isLongClickable();
	}


	private static Object getClickable(Object nativeWidget) {
		return nativeGetClickable(nativeWidget);
	}
	
	private native static boolean nativeGetClickable(Object view)  /*-[
		return ((UIView *) view).userInteractionEnabled;
	]-*/;
	
	
	private static void setClickable(IWidget w, Object nativeWidget, Object objValue) {
		nativeSetClickable(nativeWidget, (boolean) objValue);
		View view = (View)w.asWidget();
		view.setClickable((boolean)objValue);
	}
	
	
	private static native void nativeSetClickable(Object view, boolean clickable) /*-[
		((UIView *) view).userInteractionEnabled = clickable;
	]-*/;


	private static void setOnLongClick(IWidget w, Object nativeView, Object objValue) {
		View.OnLongClickListener listener;
		if (objValue instanceof String) {
			listener = new OnLongClickListener(w, (String) objValue);
		} else {
			listener = (View.OnLongClickListener) objValue;
		}
		setOnLongClick(w, nativeView, listener);		
	}

	public static void setOnLongClick(IWidget w, Object nativeView, View.OnLongClickListener listener) {
		setLongClickable(w, true);
		UILongTapGestureRecognizerDelegate delegate = new UILongTapGestureRecognizerDelegate(w, listener);
		delegate.nativeAddLongClickListener(nativeView);
	}
	
	
	private static void setTranslationX(IWidget w, Object objValue) {
		w.applyAttributeCommand("translationX", "transform", new String[] {}, true, "translationX", objValue);
	}

	private static void setTranslationY(IWidget w, Object objValue) {
		w.applyAttributeCommand("translationY", "transform", new String[] {}, true, "translationY", objValue);
	}

	private static void setTranslationZ(IWidget w, Object objValue) {
		w.applyAttributeCommand("translationZ", "transform", new String[] {}, true, "translationZ", objValue);
	}

	private static void setTransformPivotY(IWidget w, Object objValue) {
		w.applyAttributeCommand("transformPivotY", "transform", new String[] {}, true, "transformPivotY", objValue);
	}

	private static void setTransformPivotX(IWidget w, Object objValue) {
		w.applyAttributeCommand("transformPivotX", "transform", new String[] {}, true, "transformPivotX", objValue);
	}

	private static void setScaleY(IWidget w, Object objValue) {
		w.applyAttributeCommand("scaleY", "transform", new String[] {}, true, "scaleY", objValue);
	}

	private static void setScaleX(IWidget w, Object objValue) {
		w.applyAttributeCommand("scaleX", "transform", new String[] {}, true, "scaleX", objValue);
	}

	private static void setRotationY(IWidget w, Object objValue) {
		w.applyAttributeCommand("rotationY", "transform", new String[] {}, true, "rotationY", objValue);		
	}

	private static void setRotationX(IWidget w, Object objValue) {
		w.applyAttributeCommand("rotationX", "transform", new String[] {}, true, "rotationX", objValue);		
	}

	private static void setRotation(IWidget w, Object objValue) {
		w.applyAttributeCommand("rotation", "transform", new String[] {}, true, "rotation", objValue);
	}
	
	
	private static Object getTranslationX(IWidget w) {
		return w.getAttributeCommandValue("translationX", "transform", "translationX");
	}


	private static Object getTransformPivotY(IWidget w) {
		return w.getAttributeCommandValue("transformPivotY", "transform", "transformPivotY");
	}

	private static Object getTransformPivotX(IWidget w) {
		return w.getAttributeCommandValue("transformPivotX", "transform", "transformPivotX");
	}

	private static Object getScaleY(IWidget w) {
		return w.getAttributeCommandValue("scaleY", "transform", "scaleY");
	}

	private static Object getScaleX(IWidget w) {
		return w.getAttributeCommandValue( "scaleX", "transform", "scaleX");
	}

	private static Object getRotationY(IWidget w) {
		return w.getAttributeCommandValue("rotationY", "transform", "rotationY");
	}

	private static Object getRotationX(IWidget w) {
		return w.getAttributeCommandValue("rotationX", "transform", "rotationX");
	}

	private static Object getRotation(IWidget w) {
		return w.getAttributeCommandValue("rotation", "transform", "rotation");
	}

	private static Object getTranslationZ(IWidget w) {
		return w.getAttributeCommandValue("translationZ", "transform", "translationZ");
	}

	private static Object getTranslationY(IWidget w) {
		return w.getAttributeCommandValue("translationY", "transform", "translationY");
	}

	private static Object getForegroundTint(IWidget w) {
		return ((View) w.asWidget()).getForegroundTintList();
	}

	private static Object getForegroundTintMode(IWidget w) {
		return w.getAttributeCommandValue("foreground", "cgTintColor", "drawableTintMode");
	}

	private static Object getBackgroundTintMode(IWidget w) {
		return w.getAttributeCommandValue("background", "cgTintColor", "drawableTintMode");
	}

	private static Object getBackgroundTint(IWidget w) {
		return ((View) w.asWidget()).getBackgroundTintList();
	}
	
	public static void requestLayout(IWidget w) {
		if (w.isInitialised()) {
			w.requestLayout();
		}
	}
	
	private static void invalidate(IWidget w) {
		if (w.isInitialised()) {
			w.invalidate();
		}
	}
	
	public static void requestLayout(IWidget w, Object nativeView) {
		View view = (View) w.asWidget();
		view.requestLayout();
		nativeRequestLayout(nativeView);
	}
	
	public static void invalidate(IWidget w, Object nativeView) {
		nativeInvalidate(nativeView);
	}
	
	public static native void nativeRequestLayout(Object view) /*-[
		[((UIView *) view) setNeedsLayout];
	]-*/;
	
	public static native void nativeInvalidate(Object view) /*-[
		[((UIView *) view) setNeedsDisplay];
	]-*/;
	
	public static native void setKeepScreenOn(Object nativeWidget, Object value) /*-[
		[UIApplication sharedApplication].idleTimerDisabled = [(JavaLangBoolean*) value booleanValue];
	]-*/;
	public static native Object getKeepScreenOn(Object uiView) /*-[
		return [JavaLangBoolean valueOfWithBoolean :[UIApplication sharedApplication].idleTimerDisabled];
  ]-*/;


	private static boolean isMirrorSupported() {
		return false;
	}
	private static void setOnTouch(IWidget w, Object nativeView, Object objValue) {
		w.storeUserData("touchEvent", objValue);
		
		View.OnTouchListener onTouchListener;
		
		if (objValue instanceof String) {
			onTouchListener = new OnTouchListener(w, (String) objValue);
		} else {
			onTouchListener = (View.OnTouchListener) objValue;
		}
		UIControlEventTouchDelegate delegate = new UIControlEventTouchDelegate(w, onTouchListener);
		delegate.nativeAddOnTouchListener(nativeView);
	}

	public static void startDrag(IWidget w, String eventData) {
		
	}    
	
	private static void setOnDrag(IWidget w, Object nativeView, Object objValue) {
		View.OnDragListener onDragListener;
		
		if (objValue instanceof String) {
			onDragListener = new OnDragListener(w, (String) objValue);
		} else {
			onDragListener = (View.OnDragListener) objValue;	
		}
		w.getFragment().addListener(w, onDragListener);
		UIDropInteractionDelegate dragDropInteractionDelegate = new UIDropInteractionDelegate(w, onDragListener);
		dragDropInteractionDelegate.nativeAddDropInteraction(nativeView);
	}
	
	static class UIDragInteractionDelegate{
		private IWidget widget;
		private String eventArgs;
		public UIDragInteractionDelegate(IWidget widget, String eventArgs) {
			// to avoid gc in objective c
			widget.getFragment().addListener(widget, this);
			this.widget = widget;
			this.eventArgs = eventArgs;
		}
		private Object getEventObj(IWidget w) {
			Map<String, Object> eventData = PluginInvoker.getJSONCompatMap();
			w.updateModelToEventMap(eventData, "", eventArgs);
			return PluginInvoker.marshal(eventData);
		}
		
		public void sendStartEvent(int x, int y) {
			sendEvent(x, y, View.DragEvent.ACTION_DRAG_STARTED, true);
		}
		public void sendEndEvent(int x, int y) {
			sendEvent(x, y, View.DragEvent.ACTION_DRAG_ENDED, false);
		}
		private void sendEvent(int x, int y, int action, boolean dragCanAccept) {
			java.util.List<OnDragListener> listeners = widget.getFragment().getListener(OnDragListener.class);
			if (listeners != null) {
				for (OnDragListener listener : listeners) {
					r.android.view.View.DragEvent dragEvent = new DragEvent();
					dragEvent.setX(x);
					dragEvent.setY(y);
					dragEvent.setAction(action);
					View view = (View) listener.w.asWidget();
					view.setDragCanAccept(dragCanAccept);
					listener.onDrag((View) widget.asWidget(), dragEvent);
				}
			}
		}

		public native void nativeAddDragInteraction(Object nativeWidget) /*-[
			UIDragInteraction* dragInteraction = [[UIDragInteraction alloc] initWithDelegate:self];
			dragInteraction.enabled = TRUE;
			UIView* view = ((UIView*)nativeWidget);
		    for (id<UIInteraction> interaction in view.interactions) {
		        if ([interaction isKindOfClass:[UIDragInteraction class]]) {
		            [view removeInteraction:interaction];
		        }
		    }
			[view addInteraction:dragInteraction];
		]-*/;
		/*-[
		
		- (nonnull NSArray<UIDragItem *> *)dragInteraction:(nonnull UIDragInteraction *)interaction itemsForBeginningSession:(nonnull id<UIDragSession>)session {
    		id<INativeWidget> view = (id<INativeWidget>)interaction.view;
    		UIDragItem* dragItem = [[UIDragItem alloc] initWithItemProvider:  [[NSItemProvider alloc] initWithObject: [self getEventObjWithASIWidget:[view getWidget]]]];
    		CGPoint point = [session locationInView:interaction.view];
    		[self sendStartEventWithInt: point.x withInt: point.y];
    		return [NSArray arrayWithObject:dragItem];
		}

		- (void)dragInteraction:(UIDragInteraction *)interaction session:(id<UIDragSession>)session didEndWithOperation:(UIDropOperation)operation {
		    CGPoint point = [session locationInView:interaction.view];
    		[self sendEndEventWithInt: point.x withInt: point.y];
		}
		]-*/
	}
	
	static class UIDropInteractionDelegate{
		@com.google.j2objc.annotations.Weak private IWidget  widget;
		private View.OnDragListener listener;
		public UIDropInteractionDelegate(IWidget widget, View.OnDragListener onDragListener) {
			// to avoid gc in objective c
			widget.getFragment().addListener(widget, this);
			this.widget = widget;
			this.listener = onDragListener;
		}

		public void dragEnter(int x, int y) {
			View view = (View) widget.asWidget();
			view.setDragHovered(true);
			sendEvent(x, y, null, DragEvent.ACTION_DRAG_ENTERED);
		}
		public void dragLeave(int x, int y) {
			View view = (View) widget.asWidget();
			view.setDragHovered(false);
			sendEvent(x, y, null, DragEvent.ACTION_DRAG_ENDED);
		}
		
		public void dragOver(int x, int y) {
			sendEvent(x, y, null, DragEvent.ACTION_DRAG_LOCATION);
		}

		public void drop(int x, int y, String data) {
			sendEvent(x, y, data, DragEvent.ACTION_DROP);
		}

		public void sendEvent(int x, int y, String data, int action) {
			r.android.view.View.DragEvent dragEvent = new r.android.view.View.DragEvent();
			dragEvent.setAction(action);
			dragEvent.setX(x);
			dragEvent.setY(y);
			dragEvent.setClipData(data);
			listener.onDrag((View) widget.asWidget(), dragEvent);
			System.out.println("action " + action);
		}
		public native void nativeAddDropInteraction(Object nativeWidget) /*-[
			UIDropInteraction* dropInteraction = [[UIDropInteraction alloc] initWithDelegate:self];
			UIView* view = ((UIView*)nativeWidget);
		    for (id<UIInteraction> interaction in view.interactions) {
		        if ([interaction isKindOfClass:[UIDropInteraction class]]) {
		            [view removeInteraction:interaction];
		        }
		    }
			[view addInteraction:dropInteraction];
		]-*/;
		
		/*-[
		
		- (void)dropInteraction:(UIDropInteraction *)interaction performDrop:(id<UIDropSession>)session {
		     CGPoint point = [session locationInView:interaction.view];
    		if ([session canLoadObjectsOfClass:[NSString class]]) {
		        [session loadObjectsOfClass:[NSString class] completion:^(NSArray<__kindof id<NSItemProviderReading>> * _Nonnull objects) {
		                [self dropWithInt: point.x withInt: point.y withNSString:objects.firstObject];
		        }];
		    }
		}
		
		- (void)dropInteraction:(UIDropInteraction *)interaction sessionDidEnter:(id<UIDropSession>)session {
		    CGPoint point = [session locationInView:interaction.view];
    		[self dragEnterWithInt: point.x withInt: point.y];
		}
		
		- (void)dropInteraction:(UIDropInteraction *)interaction sessionDidExit:(id<UIDropSession>)session {
		    CGPoint point = [session locationInView:interaction.view];
    		[self dragLeaveWithInt: point.x withInt: point.y];
		}
		
		- (BOOL)dropInteraction:(UIDropInteraction *)interaction canHandleSession:(id<UIDropSession>)session {
		    return TRUE;
		}
		
		- (UIDropProposal *)dropInteraction:(UIDropInteraction *)interaction sessionDidUpdate:(id<UIDropSession>)session {
			CGPoint point = [session locationInView:interaction.view];
    		[self dragOverWithInt: point.x withInt: point.y];
		    return [[UIDropProposal alloc] initWithDropOperation:UIDropOperationCopy];
		}
		]-*/
	}

	
	private static void setAsDragSource(IWidget w, Object nativeWidget, Object objValue) {
    	UIDragInteractionDelegate dragDropInteractionDelegate = new UIDragInteractionDelegate(w, (String)objValue);
    	dragDropInteractionDelegate.nativeAddDragInteraction(nativeWidget);
	}
	
	private static Object getClipData(DragEvent event) {
		return event.getClipData();
	}

    private static Object getForeground(IWidget w) {
		Object value = null;
		View view = (View)w.asWidget();
		
		if (view.getForeground() != null) {
			if (view.getForeground() instanceof r.android.graphics.drawable.StateListDrawable) {
				return view.getForeground();
			}
			if (view.getForeground() instanceof r.android.graphics.drawable.Drawable) {
				return view.getForeground().getDrawable();
			}
		}
		
		return value;
	}

	private static Object getBackground(IWidget w) {
		Object value = null;
		View view = (View)w.asWidget();
		
		if (view.getBackground() != null) {
			if (view.getBackground() instanceof r.android.graphics.drawable.StateListDrawable) {
				return view.getBackground();
			}
			if (view.getBackground() instanceof r.android.graphics.drawable.Drawable) {
				return view.getBackground().getDrawable();
			}
		}
		
		return value;
	}
	
	
	private static void setOnKey(IWidget w, Object objValue) {
		 View.OnKeyListener onKeyListener;
		 
		 if (objValue instanceof String) {
			 onKeyListener = new OnKeyListener(w, (String) objValue);
		 } else {
			 onKeyListener = (View.OnKeyListener) objValue;
		 }
		 View view = (View) w.asWidget();
		 view.setOnKeyListener(onKeyListener);
	}
	
	private static void setLayerCornerRadius(Object nativeWidget, Object objValue) {
		nativeSetLayerCornerRadius(nativeWidget, (float) objValue);
	}

	private static native void nativeSetLayerCornerRadius(Object nativeWidget, float value) /*-[
		UIView* view = ((UIView*)nativeWidget);
		view.layer.cornerRadius = value;
	]-*/;

	private static void setLayerBorderColor(Object nativeWidget, Object objValue) {
		nativeLayerBorderColor(nativeWidget, objValue);
	}

	private static native void nativeLayerBorderColor(Object nativeWidget, Object value) /*-[
		UIView* view = ((UIView*)nativeWidget);
		view.layer.borderColor = ((UIColor*) value).CGColor;
	]-*/;

	private static void setLayerBorderWidth(Object nativeWidget, Object objValue) {
		nativeLayerBorderWidth(nativeWidget, (float) objValue);
	}

	private static native void nativeLayerBorderWidth(Object nativeWidget, float value) /*-[
		UIView* view = ((UIView*)nativeWidget);
		view.layer.borderWidth = value;
	]-*/;
	
	
	private static void setLayerMasksToBounds(Object nativeWidget, Object objValue) {
		nativeLayerBMasksToBounds(nativeWidget, (boolean) objValue);
	}
	
	private static native void nativeLayerBMasksToBounds(Object nativeWidget, boolean value) /*-[
		UIView* view = ((UIView*)nativeWidget);
		view.layer.masksToBounds = value;
	]-*/;

	 
	private static void nativeBringToFront(List<IWidget> widgets) {
		for (IWidget w : widgets) {
			nativeBringToFront(w.asNativeWidget());
		}
	}

	public static native void nativeBringToFront(Object nativeWidget)/*-[
		UIView* view = ((UIView*)nativeWidget);
		[view.superview bringSubviewToFront:view];
	]-*/;

	public static void addEventInfo(Map<String, Object> obj, MenuItem item) {
		obj.put("itemId", IdGenerator.getName(item.getItemId()));
	}

	private static void setNativeId(IWidget w, String strValue) {
	}

}
