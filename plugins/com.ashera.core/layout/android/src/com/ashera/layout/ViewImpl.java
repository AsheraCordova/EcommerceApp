package com.ashera.layout;
//start - imports
import java.util.*;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.core.view.*;
import android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import android.content.res.*;


import static com.ashera.widget.IWidget.*;
//end - imports
public class ViewImpl {
	// start - body
	private ViewImpl() {
	}
	
		@SuppressLint("NewApi")
		final static class AccessibilityLiveRegion extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("assertive",  0x2);
				mapping.put("none",  0x0);
				mapping.put("polite",  0x1);
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
		final static class BackgroundTintMode  extends AbstractStringToEnumConverter{
		private Map<String, Object> mapping = new HashMap<>();
				{
		if (Build.VERSION.SDK_INT >= 11) {
				mapping.put("add", android.graphics.PorterDuff.Mode.ADD);
		}
		
				mapping.put("multiply", android.graphics.PorterDuff.Mode.MULTIPLY);
		
		
				mapping.put("screen", android.graphics.PorterDuff.Mode.SCREEN);
		
		
				mapping.put("src_atop", android.graphics.PorterDuff.Mode.SRC_ATOP);
		
		
				mapping.put("src_in", android.graphics.PorterDuff.Mode.SRC_IN);
		
		
				mapping.put("src_over", android.graphics.PorterDuff.Mode.SRC_OVER);
		
				}
		@Override
		public Map<String, Object> getMapping() {
				return mapping;
				}

		@Override
		public Object getDefault() {
				return null;
				}
				}
		@SuppressLint("NewApi")
		final static class ForegroundTintMode  extends AbstractStringToEnumConverter{
		private Map<String, Object> mapping = new HashMap<>();
				{
		if (Build.VERSION.SDK_INT >= 11) {
				mapping.put("add", android.graphics.PorterDuff.Mode.ADD);
		}
		
				mapping.put("multiply", android.graphics.PorterDuff.Mode.MULTIPLY);
		
		
				mapping.put("screen", android.graphics.PorterDuff.Mode.SCREEN);
		
		
				mapping.put("src_atop", android.graphics.PorterDuff.Mode.SRC_ATOP);
		
		
				mapping.put("src_in", android.graphics.PorterDuff.Mode.SRC_IN);
		
		
				mapping.put("src_over", android.graphics.PorterDuff.Mode.SRC_OVER);
		
				}
		@Override
		public Map<String, Object> getMapping() {
				return mapping;
				}

		@Override
		public Object getDefault() {
				return null;
				}
				}
		@SuppressLint("NewApi")
		final static class ImportantForAccessibility extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("auto",  0x0);
				mapping.put("no",  0x2);
				mapping.put("noHideDescendants",  0x4);
				mapping.put("yes",  0x1);
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
		final static class ImportantForAutofill  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("auto", 0x0);
				mapping.put("no", 0x2);
				mapping.put("noExcludeDescendants", 0x8);
				mapping.put("yes", 0x1);
				mapping.put("yesExcludeDescendants", 0x4);
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
		final static class ScrollIndicators  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("bottom", 0x2);
				mapping.put("end", 0x20);
				mapping.put("left", 0x4);
				mapping.put("none", 0x0);
				mapping.put("right", 0x8);
				mapping.put("start", 0x10);
				mapping.put("top", 0x1);
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
		final static class ScrollbarStyle extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("insideInset",  0x1000000);
				mapping.put("insideOverlay",  0x0);
				mapping.put("outsideInset",  0x3000000);
				mapping.put("outsideOverlay",  0x2000000);
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
		final static class LayerType extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("hardware",  0x2);
				mapping.put("none",  0x0);
				mapping.put("software",  0x1);
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
		final static class RequiresFadingEdge  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("horizontal", 0x1000);
				mapping.put("none", 0x0);
				mapping.put("vertical", 0x2000);
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
		final static class HapticFeedbackConstants extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("LONG_PRESS",  android.view.HapticFeedbackConstants.LONG_PRESS);
				mapping.put("VIRTUAL_KEY",  android.view.HapticFeedbackConstants.VIRTUAL_KEY);
				mapping.put("KEYBOARD_TAP",  android.view.HapticFeedbackConstants.KEYBOARD_TAP);
				mapping.put("CLOCK_TICK",  android.view.HapticFeedbackConstants.CLOCK_TICK);
				mapping.put("CONTEXT_CLICK",  android.view.HapticFeedbackConstants.CONTEXT_CLICK);
				mapping.put("KEYBOARD_PRESS",  android.view.HapticFeedbackConstants.KEYBOARD_PRESS);
				mapping.put("KEYBOARD_RELEASE",  android.view.HapticFeedbackConstants.KEYBOARD_RELEASE);
				mapping.put("VIRTUAL_KEY_RELEASE",  android.view.HapticFeedbackConstants.VIRTUAL_KEY_RELEASE);
				mapping.put("TEXT_HANDLE_MOVE",  android.view.HapticFeedbackConstants.TEXT_HANDLE_MOVE);
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
		final static class HapticFeedbackConstantsFlag  extends AbstractBitFlagConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("FLAG_IGNORE_VIEW_SETTING", android.view.HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
				mapping.put("FLAG_IGNORE_GLOBAL_SETTING", android.view.HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
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

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("accessibilityHeading").withType("boolean"));
		ConverterFactory.register("View.accessibilityLiveRegion", new AccessibilityLiveRegion());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("accessibilityLiveRegion").withType("View.accessibilityLiveRegion"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("accessibilityPaneTitle").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("accessibilityTraversalAfter").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("accessibilityTraversalBefore").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("alpha").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("autofillHints").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundTint").withType("colorstate"));
		ConverterFactory.register("View.backgroundTintMode", new BackgroundTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundTintMode").withType("View.backgroundTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("clickable").withType("boolean").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contentDescription").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("contextClickable").withType("boolean").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("defaultFocusHighlightEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("duplicateParentState").withType("boolean").beforeChildAdd());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("elevation").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fadeScrollbars").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fadingEdgeLength").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("filterTouchesWhenObscured").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("fitsSystemWindows").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("focusableInTouchMode").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("focusedByDefault").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("forceHasOverlappingRendering").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundTint").withType("colorstate"));
		ConverterFactory.register("View.foregroundTintMode", new ForegroundTintMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundTintMode").withType("View.foregroundTintMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("hapticFeedbackEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("id").withType("id"));
		ConverterFactory.register("View.importantForAccessibility", new ImportantForAccessibility());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("importantForAccessibility").withType("View.importantForAccessibility"));
		ConverterFactory.register("View.importantForAutofill", new ImportantForAutofill());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("importantForAutofill").withType("View.importantForAutofill"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("isScrollContainer").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("keepScreenOn").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("keyboardNavigationCluster").withType("boolean"));
		ConverterFactory.register("View.layoutDirection", new LayoutDirection());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layoutDirection").withType("View.layoutDirection").beforeChildAdd());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("longClickable").withType("boolean").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minHeight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("minWidth").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nextClusterForward").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nextFocusDown").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nextFocusForward").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nextFocusLeft").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nextFocusRight").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("nextFocusUp").withType("id"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("outlineAmbientShadowColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("outlineSpotShadowColor").withType("color"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("rotation").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("rotationX").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("rotationY").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("saveEnabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scaleX").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scaleY").withType("float"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("screenReaderFocusable").withType("boolean"));
		ConverterFactory.register("View.scrollIndicators", new ScrollIndicators());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollIndicators").withType("View.scrollIndicators"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollbarDefaultDelayBeforeFade").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollbarFadeDuration").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollbarSize").withType("dimension"));
		ConverterFactory.register("View.scrollbarStyle", new ScrollbarStyle());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollbarStyle").withType("View.scrollbarStyle"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("soundEffectsEnabled").withType("boolean"));
		ConverterFactory.register("View.textAlignment", new TextAlignment());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textAlignment").withType("View.textAlignment"));
		ConverterFactory.register("View.textDirection", new TextDirection());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("textDirection").withType("View.textDirection"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("tooltipText").withType("resourcestring"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("transformPivotX").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("transformPivotY").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("transitionName").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("translationX").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("translationY").withType("dimensionfloat"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("translationZ").withType("dimensionfloat"));
		ConverterFactory.register("View.visibility", new Visibility());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("visibility").withType("View.visibility"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onApplyWindowInsets").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onCapturedPointer").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onClick").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onContextClick").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onCreateContextMenu").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onDrag").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onFocusChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onGenericMotion").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onHover").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onKey").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onLongClick").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onScrollChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onSystemUiVisibilityChange").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("onTouch").withType("String"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("padding").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingTop").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingBottom").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingLeft").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingRight").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingStart").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingEnd").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingHorizontal").withType("dimension"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("paddingVertical").withType("dimension"));
		ConverterFactory.register("View.layerType", new LayerType());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layerType").withType("View.layerType"));
		ConverterFactory.register("View.requiresFadingEdge", new RequiresFadingEdge());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("requiresFadingEdge").withType("View.requiresFadingEdge"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("background").withType("drawable"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foreground").withType("drawable"));
		ConverterFactory.register("View.backgroundRepeat", new BackgroundRepeat());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("backgroundRepeat").withType("View.backgroundRepeat").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelSyncEvents").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("updateModelData").withType("object"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("notifyDataSetChanged").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelParam").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelPojoToUi").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelUiToPojo").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelPojoToUiParams").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("refreshUiFromModel").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("modelUiToPojoEventIds").withType("string"));
		ConverterFactory.register("View.foregroundRepeat", new ForegroundRepeat());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundRepeat").withType("View.foregroundRepeat").withOrder(-10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("foregroundGravity").withType("gravity"));
		ConverterFactory.register("View.HapticFeedbackConstants", new HapticFeedbackConstants());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("performHapticFeedback").withType("View.HapticFeedbackConstants"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("performHapticFeedbackWithFlags").withType("object"));
		ConverterFactory.register("View.HapticFeedbackConstants", new HapticFeedbackConstants());
		ConverterFactory.register("View.HapticFeedbackConstantsFlag", new HapticFeedbackConstantsFlag());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("attributeUnderTest").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("selected").withType("boolean").withOrder(10));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("enabled").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("focusable").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollX").withType("dimension").withBufferStrategy(BUFFER_STRATEGY_DURING_INIT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("scrollY").withType("dimension").withBufferStrategy(BUFFER_STRATEGY_DURING_INIT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("invalidate").withType("nil"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("requestLayout").withType("nil"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("asDragSource").withType("string"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("zIndex").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxWidth").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("maxHeight").withType("dimension").withUiFlag(UPDATE_UI_REQUEST_LAYOUT));
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
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("systemStyle").withType("string"));
	WidgetFactory.registerConstructorAttribute(localName, new WidgetAttribute.Builder().withName("systemAndroidAttrStyle").withType("string"));
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
		case "accessibilityHeading": {


		ViewCompat.setAccessibilityHeading(view, (boolean) objValue);



			}
			break;
		case "accessibilityLiveRegion": {


		ViewCompat.setAccessibilityLiveRegion(view, (int) objValue);



			}
			break;
		case "accessibilityPaneTitle": {


		ViewCompat.setAccessibilityPaneTitle(view, (CharSequence) objValue);



			}
			break;
		case "accessibilityTraversalAfter": {
if (Build.VERSION.SDK_INT >= 22) {

	view.setAccessibilityTraversalAfter((int)objValue);

}

			}
			break;
		case "accessibilityTraversalBefore": {
if (Build.VERSION.SDK_INT >= 22) {

	view.setAccessibilityTraversalBefore((int)objValue);

}

			}
			break;
		case "alpha": {


		ViewCompat.setAlpha(view, (float) objValue);



			}
			break;
		case "autofillHints": {


		ViewCompat.setAutofillHints(view, (String) objValue);



			}
			break;
		case "backgroundTint": {


		ViewCompat.setBackgroundTintList(view, (ColorStateList) objValue);



			}
			break;
		case "backgroundTintMode": {


		ViewCompat.setBackgroundTintMode(view, (PorterDuff.Mode) objValue);



			}
			break;
		case "clickable": {


	view.setClickable((boolean)objValue);



			}
			break;
		case "contentDescription": {


	view.setContentDescription((String)objValue);



			}
			break;
		case "contextClickable": {
if (Build.VERSION.SDK_INT >= 23) {

	view.setContextClickable((boolean)objValue);

}

			}
			break;
		case "defaultFocusHighlightEnabled": {
if (Build.VERSION.SDK_INT >= 26) {

	view.setDefaultFocusHighlightEnabled((boolean)objValue);

}

			}
			break;
		case "duplicateParentState": {


	view.setDuplicateParentStateEnabled((boolean)objValue);



			}
			break;
		case "elevation": {


		ViewCompat.setElevation(view, (float) objValue);



			}
			break;
		case "fadeScrollbars": {


	view.setScrollbarFadingEnabled((boolean)objValue);



			}
			break;
		case "fadingEdgeLength": {


	view.setFadingEdgeLength((int)objValue);



			}
			break;
		case "filterTouchesWhenObscured": {
if (Build.VERSION.SDK_INT >= 9) {

	view.setFilterTouchesWhenObscured((boolean)objValue);

}

			}
			break;
		case "fitsSystemWindows": {


		ViewCompat.setFitsSystemWindows(view, (boolean) objValue);



			}
			break;
		case "focusableInTouchMode": {


	view.setFocusableInTouchMode((boolean)objValue);



			}
			break;
		case "focusedByDefault": {


		ViewCompat.setFocusedByDefault(view, (boolean) objValue);



			}
			break;
		case "forceHasOverlappingRendering": {
if (Build.VERSION.SDK_INT >= 24) {

	view.forceHasOverlappingRendering((boolean)objValue);

}

			}
			break;
		case "foregroundTint": {
if (Build.VERSION.SDK_INT >= 23) {

	view.setForegroundTintList((android.content.res.ColorStateList)objValue);

}

			}
			break;
		case "foregroundTintMode": {
if (Build.VERSION.SDK_INT >= 23) {

	view.setForegroundTintMode((android.graphics.PorterDuff.Mode)objValue);

}

			}
			break;
		case "hapticFeedbackEnabled": {


	view.setHapticFeedbackEnabled((boolean)objValue);



			}
			break;
		case "id": {


	view.setId((int)objValue);



			}
			break;
		case "importantForAccessibility": {


		ViewCompat.setImportantForAccessibility(view, (int) objValue);



			}
			break;
		case "importantForAutofill": {


		ViewCompat.setImportantForAutofill(view, (int) objValue);



			}
			break;
		case "isScrollContainer": {


	view.setScrollContainer((boolean)objValue);



			}
			break;
		case "keepScreenOn": {


	view.setKeepScreenOn((boolean)objValue);



			}
			break;
		case "keyboardNavigationCluster": {


		ViewCompat.setKeyboardNavigationCluster(view, (boolean) objValue);



			}
			break;
		case "layoutDirection": {


		ViewCompat.setLayoutDirection(view, (int) objValue);



			}
			break;
		case "longClickable": {


	view.setLongClickable((boolean)objValue);



			}
			break;
		case "minHeight": {


	view.setMinimumHeight((int)objValue);



			}
			break;
		case "minWidth": {


	view.setMinimumWidth((int)objValue);



			}
			break;
		case "nextClusterForward": {


		ViewCompat.setNextClusterForwardId(view, (int) objValue);



			}
			break;
		case "nextFocusDown": {


	view.setNextFocusDownId((int)objValue);



			}
			break;
		case "nextFocusForward": {
if (Build.VERSION.SDK_INT >= 11) {

	view.setNextFocusForwardId((int)objValue);

}

			}
			break;
		case "nextFocusLeft": {


	view.setNextFocusLeftId((int)objValue);



			}
			break;
		case "nextFocusRight": {


	view.setNextFocusRightId((int)objValue);



			}
			break;
		case "nextFocusUp": {


	view.setNextFocusUpId((int)objValue);



			}
			break;
		case "outlineAmbientShadowColor": {
if (Build.VERSION.SDK_INT >= 28) {

	view.setOutlineAmbientShadowColor((int)objValue);

}

			}
			break;
		case "outlineSpotShadowColor": {
if (Build.VERSION.SDK_INT >= 28) {

	view.setOutlineSpotShadowColor((int)objValue);

}

			}
			break;
		case "rotation": {


		ViewCompat.setRotation(view, (float) objValue);



			}
			break;
		case "rotationX": {


		ViewCompat.setRotationX(view, (float) objValue);



			}
			break;
		case "rotationY": {


		ViewCompat.setRotationY(view, (float) objValue);



			}
			break;
		case "saveEnabled": {


	view.setSaveEnabled((boolean)objValue);



			}
			break;
		case "scaleX": {


		ViewCompat.setScaleX(view, (float) objValue);



			}
			break;
		case "scaleY": {


		ViewCompat.setScaleY(view, (float) objValue);



			}
			break;
		case "screenReaderFocusable": {


		ViewCompat.setScreenReaderFocusable(view, (boolean) objValue);



			}
			break;
		case "scrollIndicators": {


		ViewCompat.setScrollIndicators(view, (int) objValue);



			}
			break;
		case "scrollbarDefaultDelayBeforeFade": {
if (Build.VERSION.SDK_INT >= 16) {

	view.setScrollBarDefaultDelayBeforeFade((int)objValue);

}

			}
			break;
		case "scrollbarFadeDuration": {
if (Build.VERSION.SDK_INT >= 16) {

	view.setScrollBarFadeDuration((int)objValue);

}

			}
			break;
		case "scrollbarSize": {
if (Build.VERSION.SDK_INT >= 16) {

	view.setScrollBarSize((int)objValue);

}

			}
			break;
		case "scrollbarStyle": {


	view.setScrollBarStyle((int)objValue);



			}
			break;
		case "soundEffectsEnabled": {


	view.setSoundEffectsEnabled((boolean)objValue);



			}
			break;
		case "textAlignment": {
if (Build.VERSION.SDK_INT >= 17) {

	view.setTextAlignment((int)objValue);

}

			}
			break;
		case "textDirection": {
if (Build.VERSION.SDK_INT >= 17) {

	view.setTextDirection((int)objValue);

}

			}
			break;
		case "tooltipText": {


		ViewCompat.setTooltipText(view, (CharSequence) objValue);



			}
			break;
		case "transformPivotX": {


		ViewCompat.setPivotX(view, (float) objValue);



			}
			break;
		case "transformPivotY": {


		ViewCompat.setPivotY(view, (float) objValue);



			}
			break;
		case "transitionName": {
if (Build.VERSION.SDK_INT >= 21) {

	view.setTransitionName((String)objValue);

}

			}
			break;
		case "translationX": {


		ViewCompat.setTranslationX(view, (float) objValue);



			}
			break;
		case "translationY": {


		ViewCompat.setTranslationY(view, (float) objValue);



			}
			break;
		case "translationZ": {


		ViewCompat.setTranslationZ(view, (float) objValue);



			}
			break;
		case "visibility": {


	view.setVisibility((int)objValue);



			}
			break;
		case "onApplyWindowInsets": {
if (Build.VERSION.SDK_INT >= 20) {

		if (objValue instanceof String) {view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(w, strValue));} else {setOnApplyWindowInsetsListener(view, objValue);}

}

			}
			break;
		case "onCapturedPointer": {
if (Build.VERSION.SDK_INT >= 26) {

		if (objValue instanceof String) {view.setOnCapturedPointerListener(new OnCapturedPointerListener(w, strValue));} else {setOnCapturedPointerListener(view, objValue);}

}

			}
			break;
		case "onClick": {


		if (objValue instanceof String) {view.setOnClickListener(new OnClickListener(w, strValue));} else {setOnClickListener(view, objValue);}



			}
			break;
		case "onContextClick": {
if (Build.VERSION.SDK_INT >= 23) {

		if (objValue instanceof String) {view.setOnContextClickListener(new OnContextClickListener(w, strValue));} else {setOnContextClickListener(view, objValue);}

}

			}
			break;
		case "onCreateContextMenu": {


		if (objValue instanceof String) {view.setOnCreateContextMenuListener(new OnCreateContextMenuListener(w, strValue));} else {setOnCreateContextMenuListener(view, objValue);}



			}
			break;
		case "onDrag": {
if (Build.VERSION.SDK_INT >= 11) {

		if (objValue instanceof String) {view.setOnDragListener(new OnDragListener(w, strValue));} else {setOnDragListener(view, objValue);}

}

			}
			break;
		case "onFocusChange": {


		if (objValue instanceof String) {view.setOnFocusChangeListener(new OnFocusChangeListener(w, strValue));} else {setOnFocusChangeListener(view, objValue);}



			}
			break;
		case "onGenericMotion": {
if (Build.VERSION.SDK_INT >= 12) {

		if (objValue instanceof String) {view.setOnGenericMotionListener(new OnGenericMotionListener(w, strValue));} else {setOnGenericMotionListener(view, objValue);}

}

			}
			break;
		case "onHover": {
if (Build.VERSION.SDK_INT >= 14) {

		if (objValue instanceof String) {view.setOnHoverListener(new OnHoverListener(w, strValue));} else {setOnHoverListener(view, objValue);}

}

			}
			break;
		case "onKey": {


		if (objValue instanceof String) {view.setOnKeyListener(new OnKeyListener(w, strValue));} else {setOnKeyListener(view, objValue);}



			}
			break;
		case "onLongClick": {


		if (objValue instanceof String) {view.setOnLongClickListener(new OnLongClickListener(w, strValue));} else {setOnLongClickListener(view, objValue);}



			}
			break;
		case "onScrollChange": {
if (Build.VERSION.SDK_INT >= 23) {

		if (objValue instanceof String) {view.setOnScrollChangeListener(new OnScrollChangeListener(w, strValue));} else {setOnScrollChangeListener(view, objValue);}

}

			}
			break;
		case "onSystemUiVisibilityChange": {
if (Build.VERSION.SDK_INT >= 11) {

		if (objValue instanceof String) {view.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(w, strValue));} else {setOnSystemUiVisibilityChangeListener(view, objValue);}

}

			}
			break;
		case "onTouch": {


		if (objValue instanceof String) {view.setOnTouchListener(new OnTouchListener(w, strValue));} else {setOnTouchListener(view, objValue);}



			}
			break;
		case "padding": {


		setPadding(objValue, view);



			}
			break;
		case "paddingTop": {


		setPaddingTop(objValue, view);



			}
			break;
		case "paddingBottom": {


		setPaddingBottom(objValue, view);



			}
			break;
		case "paddingLeft": {


		setPaddingLeft(objValue, view);



			}
			break;
		case "paddingRight": {


		setPaddingRight(objValue, view);



			}
			break;
		case "paddingStart": {


		setPaddingLeft(objValue, view);



			}
			break;
		case "paddingEnd": {


		setPaddingRight(objValue, view);



			}
			break;
		case "paddingHorizontal": {


		setPaddingHorizontal(objValue, view);



			}
			break;
		case "paddingVertical": {


		setPaddingVertical(objValue, view);



			}
			break;
		case "layerType": {


		setLayerType(objValue, view);



			}
			break;
		case "requiresFadingEdge": {


		setRequiresFadingEdge(objValue, view);



			}
			break;
		case "background": {


		setBackground(w, strValue, objValue, view);



			}
			break;
		case "foreground": {


		setForeground(w, strValue, objValue, view);



			}
			break;
		case "backgroundRepeat": {


		setBackgroundRepeat(w, strValue, objValue, view);



			}
			break;
		case "modelSyncEvents": {


		setModelSyncEvents(w, strValue, objValue, view);



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
		case "foregroundRepeat": {


		setForegroundRepeat(w, strValue, objValue, view);



			}
			break;
		case "foregroundGravity": {


		setForegroundGravity(w, objValue);



			}
			break;
		case "performHapticFeedback": {


		view.performHapticFeedback((int)objValue);



			}
			break;
		case "performHapticFeedbackWithFlags": {
		if (objValue instanceof Map) {
			Map<String, Object> data = ((Map<String, Object>) objValue);
		Object value = w.quickConvert(data.get("value"), "View.HapticFeedbackConstants");
		Object flags = w.quickConvert(data.get("flags"), "View.HapticFeedbackConstantsFlag");


		 view.performHapticFeedback((int)value, (int)flags);


}
if (objValue instanceof java.util.List) {
	java.util.List<Object> list = (java.util.List<Object>) objValue;
	for (Object object : list) {
		Map<String, Object> data = PluginInvoker.getMap(object);
		Object value = w.quickConvert(data.get("value"), "View.HapticFeedbackConstants");
		Object flags = w.quickConvert(data.get("flags"), "View.HapticFeedbackConstantsFlag");


		 view.performHapticFeedback((int)value, (int)flags);


	}
}
			}
			break;
		case "attributeUnderTest": {


		 //



			}
			break;
		case "selected": {


		setSelected(objValue, view);



			}
			break;
		case "enabled": {


		view.setEnabled((boolean)objValue);



			}
			break;
		case "focusable": {


	view.setFocusable((boolean)objValue);



			}
			break;
		case "scrollX": {


		setScrollX(w, view, objValue);



			}
			break;
		case "scrollY": {


		setScrollY(w, view, objValue);



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
		case "asDragSource": {


		 setAsDragSource(w, objValue);



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
			case "accessibilityHeading": {
if (Build.VERSION.SDK_INT >= 28) {
return view.isAccessibilityHeading();
}
break;			}
			case "accessibilityLiveRegion": {
return ViewCompat.getAccessibilityLiveRegion(view);			}
			case "accessibilityPaneTitle": {
return ViewCompat.getAccessibilityPaneTitle(view);			}
			case "accessibilityTraversalAfter": {
if (Build.VERSION.SDK_INT >= 22) {
return view.getAccessibilityTraversalAfter();
}
break;			}
			case "accessibilityTraversalBefore": {
if (Build.VERSION.SDK_INT >= 22) {
return view.getAccessibilityTraversalBefore();
}
break;			}
			case "alpha": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getAlpha();
}
break;			}
			case "autofillHints": {
if (Build.VERSION.SDK_INT >= 26) {
return view.getAutofillHints();
}
break;			}
			case "backgroundTint": {
return ViewCompat.getBackgroundTintList(view);			}
			case "backgroundTintMode": {
return ViewCompat.getBackgroundTintMode(view);			}
			case "clickable": {
return view.isClickable();			}
			case "contentDescription": {
return view.getContentDescription();			}
			case "contextClickable": {
if (Build.VERSION.SDK_INT >= 23) {
return view.isContextClickable();
}
break;			}
			case "defaultFocusHighlightEnabled": {
if (Build.VERSION.SDK_INT >= 26) {
return view.getDefaultFocusHighlightEnabled();
}
break;			}
			case "duplicateParentState": {
return view.isDuplicateParentStateEnabled();			}
			case "elevation": {
if (Build.VERSION.SDK_INT >= 21) {
return view.getElevation();
}
break;			}
			case "fadeScrollbars": {
return view.isScrollbarFadingEnabled();			}
			case "filterTouchesWhenObscured": {
if (Build.VERSION.SDK_INT >= 9) {
return view.getFilterTouchesWhenObscured();
}
break;			}
			case "fitsSystemWindows": {
return ViewCompat.getFitsSystemWindows(view);			}
			case "focusableInTouchMode": {
return view.isFocusableInTouchMode();			}
			case "focusedByDefault": {
if (Build.VERSION.SDK_INT >= 26) {
return view.isFocusedByDefault();
}
break;			}
			case "foregroundTint": {
if (Build.VERSION.SDK_INT >= 23) {
return view.getForegroundTintList();
}
break;			}
			case "foregroundTintMode": {
if (Build.VERSION.SDK_INT >= 23) {
return view.getForegroundTintMode();
}
break;			}
			case "hapticFeedbackEnabled": {
return view.isHapticFeedbackEnabled();			}
			case "id": {
return view.getId();			}
			case "importantForAccessibility": {
return ViewCompat.getImportantForAccessibility(view);			}
			case "importantForAutofill": {
return ViewCompat.getImportantForAutofill(view);			}
			case "isScrollContainer": {
return view.isScrollContainer();			}
			case "keepScreenOn": {
return view.getKeepScreenOn();			}
			case "keyboardNavigationCluster": {
if (Build.VERSION.SDK_INT >= 26) {
return view.isKeyboardNavigationCluster();
}
break;			}
			case "layoutDirection": {
return ViewCompat.getLayoutDirection(view);			}
			case "longClickable": {
return view.isLongClickable();			}
			case "minHeight": {
if (Build.VERSION.SDK_INT >= 16) {
return view.getMinimumHeight();
}
break;			}
			case "minWidth": {
if (Build.VERSION.SDK_INT >= 16) {
return view.getMinimumWidth();
}
break;			}
			case "nextClusterForward": {
return ViewCompat.getNextClusterForwardId(view);			}
			case "nextFocusDown": {
return view.getNextFocusDownId();			}
			case "nextFocusForward": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getNextFocusForwardId();
}
break;			}
			case "nextFocusLeft": {
return view.getNextFocusLeftId();			}
			case "nextFocusRight": {
return view.getNextFocusRightId();			}
			case "nextFocusUp": {
return view.getNextFocusUpId();			}
			case "outlineAmbientShadowColor": {
if (Build.VERSION.SDK_INT >= 28) {
return view.getOutlineAmbientShadowColor();
}
break;			}
			case "outlineSpotShadowColor": {
if (Build.VERSION.SDK_INT >= 28) {
return view.getOutlineSpotShadowColor();
}
break;			}
			case "rotation": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getRotation();
}
break;			}
			case "rotationX": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getRotationX();
}
break;			}
			case "rotationY": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getRotationY();
}
break;			}
			case "saveEnabled": {
return view.isSaveEnabled();			}
			case "scaleX": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getScaleX();
}
break;			}
			case "scaleY": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getScaleY();
}
break;			}
			case "screenReaderFocusable": {
if (Build.VERSION.SDK_INT >= 28) {
return view.isScreenReaderFocusable();
}
break;			}
			case "scrollIndicators": {
if (Build.VERSION.SDK_INT >= 23) {
return view.getScrollIndicators();
}
break;			}
			case "scrollbarDefaultDelayBeforeFade": {
if (Build.VERSION.SDK_INT >= 16) {
return view.getScrollBarDefaultDelayBeforeFade();
}
break;			}
			case "scrollbarFadeDuration": {
if (Build.VERSION.SDK_INT >= 16) {
return view.getScrollBarFadeDuration();
}
break;			}
			case "scrollbarSize": {
if (Build.VERSION.SDK_INT >= 16) {
return view.getScrollBarSize();
}
break;			}
			case "scrollbarStyle": {
return view.getScrollBarStyle();			}
			case "soundEffectsEnabled": {
return view.isSoundEffectsEnabled();			}
			case "textAlignment": {
if (Build.VERSION.SDK_INT >= 17) {
return view.getTextAlignment();
}
break;			}
			case "textDirection": {
if (Build.VERSION.SDK_INT >= 17) {
return view.getTextDirection();
}
break;			}
			case "tooltipText": {
if (Build.VERSION.SDK_INT >= 26) {
return view.getTooltipText();
}
break;			}
			case "transformPivotX": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getPivotX();
}
break;			}
			case "transformPivotY": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getPivotY();
}
break;			}
			case "transitionName": {
if (Build.VERSION.SDK_INT >= 21) {
return view.getTransitionName();
}
break;			}
			case "translationX": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getTranslationX();
}
break;			}
			case "translationY": {
if (Build.VERSION.SDK_INT >= 11) {
return view.getTranslationY();
}
break;			}
			case "translationZ": {
if (Build.VERSION.SDK_INT >= 21) {
return view.getTranslationZ();
}
break;			}
			case "visibility": {
return view.getVisibility();			}
			case "paddingTop": {
return getPaddingTop(w, view);			}
			case "paddingBottom": {
return getPaddingBottom(w, view);			}
			case "paddingLeft": {
return getPaddingLeft(w, view);			}
			case "paddingRight": {
return getPaddingRight(w, view);			}
			case "paddingStart": {
return getPaddingLeft(w, view);			}
			case "paddingEnd": {
return getPaddingRight(w, view);			}
			case "requiresFadingEdge": {
return getRequiresFadingEdge(w, view);			}
			case "background": {
return view.getBackground();			}
			case "foreground": {
return getForeground(view);			}
			case "modelSyncEvents": {
return getModelSyncEvents(w);			}
			case "modelParam": {
return getModelParam(w);			}
			case "modelPojoToUi": {
return getModelPojoToUi(w);			}
			case "modelUiToPojo": {
return getModelUiToPojo(w);			}
			case "foregroundGravity": {
return getForegroundGravity(w);			}
			case "selected": {
return getSelected(w, view);			}
			case "enabled": {
return view.isEnabled();			}
			case "focusable": {
return view.isFocusable();			}
			case "scrollX": {
return view.getScrollX();			}
			case "scrollY": {
return view.getScrollY();			}
			case "maxWidth": {
return getMaxWidth(w);			}
			case "maxHeight": {
return getMaxHeight(w);			}
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
	
	@SuppressLint("NewApi")
private static class OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnApplyWindowInsetsListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnApplyWindowInsetsListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public WindowInsets onApplyWindowInsets (View v, 
                WindowInsets insets){
    WindowInsets result = insets;
    
	if (action == null || action.equals("onApplyWindowInsets")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onApplyWindowInsets");
	    java.util.Map<String, Object> obj = getOnApplyWindowInsetsEventObj(v,insets);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,insets);
		    	 if (commandResult != null) {
		    		 result = (WindowInsets) commandResult;
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

public java.util.Map<String, Object> getOnApplyWindowInsetsEventObj(View v,WindowInsets insets) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "applywindowinsets");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onApplyWindowInsets", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnCapturedPointerListener implements View.OnCapturedPointerListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnCapturedPointerListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnCapturedPointerListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onCapturedPointer (View view, 
                MotionEvent event){
    boolean result = true;
    
	if (action == null || action.equals("onCapturedPointer")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onCapturedPointer");
	    java.util.Map<String, Object> obj = getOnCapturedPointerEventObj(view,event);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 Object commandResult = EventCommandFactory.getCommand(commandName).executeCommand(w, obj, view,event);
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

public java.util.Map<String, Object> getOnCapturedPointerEventObj(View view,MotionEvent event) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "capturedpointer");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, event);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onCapturedPointer", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

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
private static class OnContextClickListener implements View.OnContextClickListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnContextClickListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnContextClickListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onContextClick (View v){
    boolean result = true;
    
	if (action == null || action.equals("onContextClick")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onContextClick");
	    java.util.Map<String, Object> obj = getOnContextClickEventObj(v);
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

public java.util.Map<String, Object> getOnContextClickEventObj(View v) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "contextclick");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onContextClick", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnCreateContextMenuListener implements View.OnCreateContextMenuListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnCreateContextMenuListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnCreateContextMenuListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onCreateContextMenu (ContextMenu menu, 
                View v, 
                ContextMenu.ContextMenuInfo menuInfo){
    
	if (action == null || action.equals("onCreateContextMenu")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onCreateContextMenu");
	    java.util.Map<String, Object> obj = getOnCreateContextMenuEventObj(menu,v,menuInfo);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, menu,v,menuInfo);
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

public java.util.Map<String, Object> getOnCreateContextMenuEventObj(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "createcontextmenu");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onCreateContextMenu", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
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
private static class OnFocusChangeListener implements View.OnFocusChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnFocusChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnFocusChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onFocusChange (View v, 
                boolean hasFocus){
    
	if (action == null || action.equals("onFocusChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onFocusChange");
	    java.util.Map<String, Object> obj = getOnFocusChangeEventObj(v,hasFocus);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,hasFocus);
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

public java.util.Map<String, Object> getOnFocusChangeEventObj(View v,boolean hasFocus) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "focuschange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "hasFocus", hasFocus);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onFocusChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnGenericMotionListener implements View.OnGenericMotionListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnGenericMotionListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnGenericMotionListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onGenericMotion (View v, 
                MotionEvent event){
    boolean result = true;
    
	if (action == null || action.equals("onGenericMotion")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onGenericMotion");
	    java.util.Map<String, Object> obj = getOnGenericMotionEventObj(v,event);
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

public java.util.Map<String, Object> getOnGenericMotionEventObj(View v,MotionEvent event) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "genericmotion");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, event);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onGenericMotion", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnHoverListener implements View.OnHoverListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnHoverListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnHoverListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public boolean onHover (View v, 
                MotionEvent event){
    boolean result = true;
    
	if (action == null || action.equals("onHover")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onHover");
	    java.util.Map<String, Object> obj = getOnHoverEventObj(v,event);
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

public java.util.Map<String, Object> getOnHoverEventObj(View v,MotionEvent event) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "hover");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        ViewImpl.addEventInfo(obj, event);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onHover", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
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
private static class OnScrollChangeListener implements View.OnScrollChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnScrollChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnScrollChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onScrollChange (View v, 
                int scrollX, 
                int scrollY, 
                int oldScrollX, 
                int oldScrollY){
    
	if (action == null || action.equals("onScrollChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onScrollChange");
	    java.util.Map<String, Object> obj = getOnScrollChangeEventObj(v,scrollX,scrollY,oldScrollX,oldScrollY);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, v,scrollX,scrollY,oldScrollX,oldScrollY);
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

public java.util.Map<String, Object> getOnScrollChangeEventObj(View v,int scrollX,int scrollY,int oldScrollX,int oldScrollY) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "scrollchange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "scrollX", scrollX);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "scrollY", scrollY);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "oldScrollX", oldScrollX);
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "oldScrollY", oldScrollY);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onScrollChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
    return obj;
}
}

	@SuppressLint("NewApi")
private static class OnSystemUiVisibilityChangeListener implements View.OnSystemUiVisibilityChangeListener, com.ashera.widget.IListener{
private IWidget w; private View view; private String strValue; private String action;
public String getAction() {return action;}
public OnSystemUiVisibilityChangeListener(IWidget w, String strValue)  {
this.w = w; this.strValue = strValue;
}
public OnSystemUiVisibilityChangeListener(IWidget w, String strValue, String action)  {
this.w = w; this.strValue = strValue;this.action=action;
}
public void onSystemUiVisibilityChange (int visibility){
    
	if (action == null || action.equals("onSystemUiVisibilityChange")) {
		// populate the data from ui to pojo
		w.syncModelFromUiToPojo("onSystemUiVisibilityChange");
	    java.util.Map<String, Object> obj = getOnSystemUiVisibilityChangeEventObj(visibility);
	    String commandName =  (String) obj.get(EventExpressionParser.KEY_COMMAND_NAME);
	    
	    // execute command based on command type
	    String commandType = (String)obj.get(EventExpressionParser.KEY_COMMAND_TYPE);
		switch (commandType) {
		case "+":
		case ":":
		    if (EventCommandFactory.hasCommand(commandName)) {
		    	 EventCommandFactory.getCommand(commandName).executeCommand(w, obj, visibility);
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

public java.util.Map<String, Object> getOnSystemUiVisibilityChangeEventObj(int visibility) {
	java.util.Map<String, Object> obj = com.ashera.widget.PluginInvoker.getJSONCompatMap();
    obj.put("action", "action");
    obj.put("eventType", "systemuivisibilitychange");
    obj.put("fragmentId", w.getFragment().getFragmentId());
    obj.put("actionUrl", w.getFragment().getActionUrl());
    
    PluginInvoker.putJSONSafeObjectIntoMap(obj, "id", w.getId());
     
        PluginInvoker.putJSONSafeObjectIntoMap(obj, "visibility", visibility);
    
    // parse event info into the map
    EventExpressionParser.parseEventExpression(strValue, obj);
    
    // update model data into map
    w.updateModelToEventMap(obj, "onSystemUiVisibilityChange", (String)obj.get(EventExpressionParser.KEY_EVENT_ARGS));
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
	

public T tryGetAccessibilityHeading() {
	Map<String, Object> attrs = initCommand("accessibilityHeading");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isAccessibilityHeading() {
	Map<String, Object> attrs = initCommand("accessibilityHeading");
	return attrs.get("commandReturnValue");
}
public T setAccessibilityHeading(boolean value) {
	Map<String, Object> attrs = initCommand("accessibilityHeading");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetAccessibilityLiveRegion() {
	Map<String, Object> attrs = initCommand("accessibilityLiveRegion");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getAccessibilityLiveRegion() {
	Map<String, Object> attrs = initCommand("accessibilityLiveRegion");
	return attrs.get("commandReturnValue");
}
public T setAccessibilityLiveRegion(String value) {
	Map<String, Object> attrs = initCommand("accessibilityLiveRegion");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetAccessibilityPaneTitle() {
	Map<String, Object> attrs = initCommand("accessibilityPaneTitle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getAccessibilityPaneTitle() {
	Map<String, Object> attrs = initCommand("accessibilityPaneTitle");
	return attrs.get("commandReturnValue");
}
public T setAccessibilityPaneTitle(String value) {
	Map<String, Object> attrs = initCommand("accessibilityPaneTitle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetAccessibilityTraversalAfter() {
	Map<String, Object> attrs = initCommand("accessibilityTraversalAfter");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getAccessibilityTraversalAfter() {
	Map<String, Object> attrs = initCommand("accessibilityTraversalAfter");
	return attrs.get("commandReturnValue");
}
public T setAccessibilityTraversalAfter(String value) {
	Map<String, Object> attrs = initCommand("accessibilityTraversalAfter");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetAccessibilityTraversalBefore() {
	Map<String, Object> attrs = initCommand("accessibilityTraversalBefore");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getAccessibilityTraversalBefore() {
	Map<String, Object> attrs = initCommand("accessibilityTraversalBefore");
	return attrs.get("commandReturnValue");
}
public T setAccessibilityTraversalBefore(String value) {
	Map<String, Object> attrs = initCommand("accessibilityTraversalBefore");
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
public T tryGetAutofillHints() {
	Map<String, Object> attrs = initCommand("autofillHints");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getAutofillHints() {
	Map<String, Object> attrs = initCommand("autofillHints");
	return attrs.get("commandReturnValue");
}
public T setAutofillHints(String value) {
	Map<String, Object> attrs = initCommand("autofillHints");
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
public T setBackgroundTintMode(BackgroundTintMode value) {
	Map<String, Object> attrs = initCommand("backgroundTintMode");
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
public T tryGetContentDescription() {
	Map<String, Object> attrs = initCommand("contentDescription");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getContentDescription() {
	Map<String, Object> attrs = initCommand("contentDescription");
	return attrs.get("commandReturnValue");
}
public T setContentDescription(String value) {
	Map<String, Object> attrs = initCommand("contentDescription");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetContextClickable() {
	Map<String, Object> attrs = initCommand("contextClickable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isContextClickable() {
	Map<String, Object> attrs = initCommand("contextClickable");
	return attrs.get("commandReturnValue");
}
public T setContextClickable(boolean value) {
	Map<String, Object> attrs = initCommand("contextClickable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetDefaultFocusHighlightEnabled() {
	Map<String, Object> attrs = initCommand("defaultFocusHighlightEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isDefaultFocusHighlightEnabled() {
	Map<String, Object> attrs = initCommand("defaultFocusHighlightEnabled");
	return attrs.get("commandReturnValue");
}
public T setDefaultFocusHighlightEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("defaultFocusHighlightEnabled");
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
public T tryGetElevation() {
	Map<String, Object> attrs = initCommand("elevation");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getElevation() {
	Map<String, Object> attrs = initCommand("elevation");
	return attrs.get("commandReturnValue");
}
public T setElevation(String value) {
	Map<String, Object> attrs = initCommand("elevation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetFadeScrollbars() {
	Map<String, Object> attrs = initCommand("fadeScrollbars");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isFadeScrollbars() {
	Map<String, Object> attrs = initCommand("fadeScrollbars");
	return attrs.get("commandReturnValue");
}
public T setFadeScrollbars(boolean value) {
	Map<String, Object> attrs = initCommand("fadeScrollbars");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setFadingEdgeLength(String value) {
	Map<String, Object> attrs = initCommand("fadingEdgeLength");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetFilterTouchesWhenObscured() {
	Map<String, Object> attrs = initCommand("filterTouchesWhenObscured");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isFilterTouchesWhenObscured() {
	Map<String, Object> attrs = initCommand("filterTouchesWhenObscured");
	return attrs.get("commandReturnValue");
}
public T setFilterTouchesWhenObscured(boolean value) {
	Map<String, Object> attrs = initCommand("filterTouchesWhenObscured");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetFitsSystemWindows() {
	Map<String, Object> attrs = initCommand("fitsSystemWindows");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isFitsSystemWindows() {
	Map<String, Object> attrs = initCommand("fitsSystemWindows");
	return attrs.get("commandReturnValue");
}
public T setFitsSystemWindows(boolean value) {
	Map<String, Object> attrs = initCommand("fitsSystemWindows");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetFocusableInTouchMode() {
	Map<String, Object> attrs = initCommand("focusableInTouchMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isFocusableInTouchMode() {
	Map<String, Object> attrs = initCommand("focusableInTouchMode");
	return attrs.get("commandReturnValue");
}
public T setFocusableInTouchMode(boolean value) {
	Map<String, Object> attrs = initCommand("focusableInTouchMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetFocusedByDefault() {
	Map<String, Object> attrs = initCommand("focusedByDefault");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isFocusedByDefault() {
	Map<String, Object> attrs = initCommand("focusedByDefault");
	return attrs.get("commandReturnValue");
}
public T setFocusedByDefault(boolean value) {
	Map<String, Object> attrs = initCommand("focusedByDefault");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setForceHasOverlappingRendering(boolean value) {
	Map<String, Object> attrs = initCommand("forceHasOverlappingRendering");
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
public T setForegroundTintMode(ForegroundTintMode value) {
	Map<String, Object> attrs = initCommand("foregroundTintMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetHapticFeedbackEnabled() {
	Map<String, Object> attrs = initCommand("hapticFeedbackEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isHapticFeedbackEnabled() {
	Map<String, Object> attrs = initCommand("hapticFeedbackEnabled");
	return attrs.get("commandReturnValue");
}
public T setHapticFeedbackEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("hapticFeedbackEnabled");
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
public T tryGetImportantForAccessibility() {
	Map<String, Object> attrs = initCommand("importantForAccessibility");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getImportantForAccessibility() {
	Map<String, Object> attrs = initCommand("importantForAccessibility");
	return attrs.get("commandReturnValue");
}
public T setImportantForAccessibility(String value) {
	Map<String, Object> attrs = initCommand("importantForAccessibility");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetImportantForAutofill() {
	Map<String, Object> attrs = initCommand("importantForAutofill");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getImportantForAutofill() {
	Map<String, Object> attrs = initCommand("importantForAutofill");
	return attrs.get("commandReturnValue");
}
public T setImportantForAutofill(String value) {
	Map<String, Object> attrs = initCommand("importantForAutofill");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetIsScrollContainer() {
	Map<String, Object> attrs = initCommand("isScrollContainer");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isIsScrollContainer() {
	Map<String, Object> attrs = initCommand("isScrollContainer");
	return attrs.get("commandReturnValue");
}
public T setIsScrollContainer(boolean value) {
	Map<String, Object> attrs = initCommand("isScrollContainer");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
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
public T tryGetKeyboardNavigationCluster() {
	Map<String, Object> attrs = initCommand("keyboardNavigationCluster");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isKeyboardNavigationCluster() {
	Map<String, Object> attrs = initCommand("keyboardNavigationCluster");
	return attrs.get("commandReturnValue");
}
public T setKeyboardNavigationCluster(boolean value) {
	Map<String, Object> attrs = initCommand("keyboardNavigationCluster");
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
public T tryGetNextClusterForward() {
	Map<String, Object> attrs = initCommand("nextClusterForward");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getNextClusterForward() {
	Map<String, Object> attrs = initCommand("nextClusterForward");
	return attrs.get("commandReturnValue");
}
public T setNextClusterForward(String value) {
	Map<String, Object> attrs = initCommand("nextClusterForward");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetNextFocusDown() {
	Map<String, Object> attrs = initCommand("nextFocusDown");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getNextFocusDown() {
	Map<String, Object> attrs = initCommand("nextFocusDown");
	return attrs.get("commandReturnValue");
}
public T setNextFocusDown(String value) {
	Map<String, Object> attrs = initCommand("nextFocusDown");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetNextFocusForward() {
	Map<String, Object> attrs = initCommand("nextFocusForward");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getNextFocusForward() {
	Map<String, Object> attrs = initCommand("nextFocusForward");
	return attrs.get("commandReturnValue");
}
public T setNextFocusForward(String value) {
	Map<String, Object> attrs = initCommand("nextFocusForward");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetNextFocusLeft() {
	Map<String, Object> attrs = initCommand("nextFocusLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getNextFocusLeft() {
	Map<String, Object> attrs = initCommand("nextFocusLeft");
	return attrs.get("commandReturnValue");
}
public T setNextFocusLeft(String value) {
	Map<String, Object> attrs = initCommand("nextFocusLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetNextFocusRight() {
	Map<String, Object> attrs = initCommand("nextFocusRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getNextFocusRight() {
	Map<String, Object> attrs = initCommand("nextFocusRight");
	return attrs.get("commandReturnValue");
}
public T setNextFocusRight(String value) {
	Map<String, Object> attrs = initCommand("nextFocusRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetNextFocusUp() {
	Map<String, Object> attrs = initCommand("nextFocusUp");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getNextFocusUp() {
	Map<String, Object> attrs = initCommand("nextFocusUp");
	return attrs.get("commandReturnValue");
}
public T setNextFocusUp(String value) {
	Map<String, Object> attrs = initCommand("nextFocusUp");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetOutlineAmbientShadowColor() {
	Map<String, Object> attrs = initCommand("outlineAmbientShadowColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getOutlineAmbientShadowColor() {
	Map<String, Object> attrs = initCommand("outlineAmbientShadowColor");
	return attrs.get("commandReturnValue");
}
public T setOutlineAmbientShadowColor(String value) {
	Map<String, Object> attrs = initCommand("outlineAmbientShadowColor");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetOutlineSpotShadowColor() {
	Map<String, Object> attrs = initCommand("outlineSpotShadowColor");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getOutlineSpotShadowColor() {
	Map<String, Object> attrs = initCommand("outlineSpotShadowColor");
	return attrs.get("commandReturnValue");
}
public T setOutlineSpotShadowColor(String value) {
	Map<String, Object> attrs = initCommand("outlineSpotShadowColor");
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
public T tryGetSaveEnabled() {
	Map<String, Object> attrs = initCommand("saveEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isSaveEnabled() {
	Map<String, Object> attrs = initCommand("saveEnabled");
	return attrs.get("commandReturnValue");
}
public T setSaveEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("saveEnabled");
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
public T tryGetScreenReaderFocusable() {
	Map<String, Object> attrs = initCommand("screenReaderFocusable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isScreenReaderFocusable() {
	Map<String, Object> attrs = initCommand("screenReaderFocusable");
	return attrs.get("commandReturnValue");
}
public T setScreenReaderFocusable(boolean value) {
	Map<String, Object> attrs = initCommand("screenReaderFocusable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScrollIndicators() {
	Map<String, Object> attrs = initCommand("scrollIndicators");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScrollIndicators() {
	Map<String, Object> attrs = initCommand("scrollIndicators");
	return attrs.get("commandReturnValue");
}
public T setScrollIndicators(String value) {
	Map<String, Object> attrs = initCommand("scrollIndicators");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScrollbarDefaultDelayBeforeFade() {
	Map<String, Object> attrs = initCommand("scrollbarDefaultDelayBeforeFade");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScrollbarDefaultDelayBeforeFade() {
	Map<String, Object> attrs = initCommand("scrollbarDefaultDelayBeforeFade");
	return attrs.get("commandReturnValue");
}
public T setScrollbarDefaultDelayBeforeFade(int value) {
	Map<String, Object> attrs = initCommand("scrollbarDefaultDelayBeforeFade");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScrollbarFadeDuration() {
	Map<String, Object> attrs = initCommand("scrollbarFadeDuration");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScrollbarFadeDuration() {
	Map<String, Object> attrs = initCommand("scrollbarFadeDuration");
	return attrs.get("commandReturnValue");
}
public T setScrollbarFadeDuration(int value) {
	Map<String, Object> attrs = initCommand("scrollbarFadeDuration");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScrollbarSize() {
	Map<String, Object> attrs = initCommand("scrollbarSize");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScrollbarSize() {
	Map<String, Object> attrs = initCommand("scrollbarSize");
	return attrs.get("commandReturnValue");
}
public T setScrollbarSize(String value) {
	Map<String, Object> attrs = initCommand("scrollbarSize");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScrollbarStyle() {
	Map<String, Object> attrs = initCommand("scrollbarStyle");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScrollbarStyle() {
	Map<String, Object> attrs = initCommand("scrollbarStyle");
	return attrs.get("commandReturnValue");
}
public T setScrollbarStyle(String value) {
	Map<String, Object> attrs = initCommand("scrollbarStyle");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetSoundEffectsEnabled() {
	Map<String, Object> attrs = initCommand("soundEffectsEnabled");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isSoundEffectsEnabled() {
	Map<String, Object> attrs = initCommand("soundEffectsEnabled");
	return attrs.get("commandReturnValue");
}
public T setSoundEffectsEnabled(boolean value) {
	Map<String, Object> attrs = initCommand("soundEffectsEnabled");
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
public T tryGetTooltipText() {
	Map<String, Object> attrs = initCommand("tooltipText");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTooltipText() {
	Map<String, Object> attrs = initCommand("tooltipText");
	return attrs.get("commandReturnValue");
}
public T setTooltipText(String value) {
	Map<String, Object> attrs = initCommand("tooltipText");
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
public T tryGetTransitionName() {
	Map<String, Object> attrs = initCommand("transitionName");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getTransitionName() {
	Map<String, Object> attrs = initCommand("transitionName");
	return attrs.get("commandReturnValue");
}
public T setTransitionName(String value) {
	Map<String, Object> attrs = initCommand("transitionName");
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
public T setOnApplyWindowInsets(String value) {
	Map<String, Object> attrs = initCommand("onApplyWindowInsets");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnCapturedPointer(String value) {
	Map<String, Object> attrs = initCommand("onCapturedPointer");
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
public T setOnContextClick(String value) {
	Map<String, Object> attrs = initCommand("onContextClick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnCreateContextMenu(String value) {
	Map<String, Object> attrs = initCommand("onCreateContextMenu");
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
public T setOnFocusChange(String value) {
	Map<String, Object> attrs = initCommand("onFocusChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnGenericMotion(String value) {
	Map<String, Object> attrs = initCommand("onGenericMotion");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnHover(String value) {
	Map<String, Object> attrs = initCommand("onHover");
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
public T setOnLongClick(String value) {
	Map<String, Object> attrs = initCommand("onLongClick");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnScrollChange(String value) {
	Map<String, Object> attrs = initCommand("onScrollChange");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setOnSystemUiVisibilityChange(String value) {
	Map<String, Object> attrs = initCommand("onSystemUiVisibilityChange");
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
public T setPadding(String value) {
	Map<String, Object> attrs = initCommand("padding");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getPaddingTop() {
	Map<String, Object> attrs = initCommand("paddingTop");
	return attrs.get("commandReturnValue");
}
public T setPaddingTop(String value) {
	Map<String, Object> attrs = initCommand("paddingTop");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getPaddingBottom() {
	Map<String, Object> attrs = initCommand("paddingBottom");
	return attrs.get("commandReturnValue");
}
public T setPaddingBottom(String value) {
	Map<String, Object> attrs = initCommand("paddingBottom");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getPaddingLeft() {
	Map<String, Object> attrs = initCommand("paddingLeft");
	return attrs.get("commandReturnValue");
}
public T setPaddingLeft(String value) {
	Map<String, Object> attrs = initCommand("paddingLeft");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getPaddingRight() {
	Map<String, Object> attrs = initCommand("paddingRight");
	return attrs.get("commandReturnValue");
}
public T setPaddingRight(String value) {
	Map<String, Object> attrs = initCommand("paddingRight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getPaddingStart() {
	Map<String, Object> attrs = initCommand("paddingStart");
	return attrs.get("commandReturnValue");
}
public T setPaddingStart(String value) {
	Map<String, Object> attrs = initCommand("paddingStart");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getPaddingEnd() {
	Map<String, Object> attrs = initCommand("paddingEnd");
	return attrs.get("commandReturnValue");
}
public T setPaddingEnd(String value) {
	Map<String, Object> attrs = initCommand("paddingEnd");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setPaddingHorizontal(String value) {
	Map<String, Object> attrs = initCommand("paddingHorizontal");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setPaddingVertical(String value) {
	Map<String, Object> attrs = initCommand("paddingVertical");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T setLayerType(String value) {
	Map<String, Object> attrs = initCommand("layerType");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetRequiresFadingEdge() {
	Map<String, Object> attrs = initCommand("requiresFadingEdge");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getRequiresFadingEdge() {
	Map<String, Object> attrs = initCommand("requiresFadingEdge");
	return attrs.get("commandReturnValue");
}
public T setRequiresFadingEdge(String value) {
	Map<String, Object> attrs = initCommand("requiresFadingEdge");
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
public T setBackgroundRepeat(String value) {
	Map<String, Object> attrs = initCommand("backgroundRepeat");
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
public T setForegroundRepeat(String value) {
	Map<String, Object> attrs = initCommand("foregroundRepeat");
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
public T performHapticFeedback(String value) {
	Map<String, Object> attrs = initCommand("performHapticFeedback");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T performHapticFeedbackWithFlags(String value,
String flags) {
	Map<String, Object> attrs = initCommand("performHapticFeedbackWithFlags");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	Map<String, Object> wrapper = new HashMap<>();
	wrapper.put("value", value);
	wrapper.put("flags", flags);
	attrs.put("value", wrapper);
return (T) this;}
public T setAttributeUnderTest(String value) {
	Map<String, Object> attrs = initCommand("attributeUnderTest");
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
public T tryGetFocusable() {
	Map<String, Object> attrs = initCommand("focusable");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object isFocusable() {
	Map<String, Object> attrs = initCommand("focusable");
	return attrs.get("commandReturnValue");
}
public T setFocusable(boolean value) {
	Map<String, Object> attrs = initCommand("focusable");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScrollX() {
	Map<String, Object> attrs = initCommand("scrollX");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScrollX() {
	Map<String, Object> attrs = initCommand("scrollX");
	return attrs.get("commandReturnValue");
}
public T setScrollX(String value) {
	Map<String, Object> attrs = initCommand("scrollX");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return (T) this;}
public T tryGetScrollY() {
	Map<String, Object> attrs = initCommand("scrollY");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return (T) this;}

public Object getScrollY() {
	Map<String, Object> attrs = initCommand("scrollY");
	return attrs.get("commandReturnValue");
}
public T setScrollY(String value) {
	Map<String, Object> attrs = initCommand("scrollY");
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
public T setAsDragSource(String value) {
	Map<String, Object> attrs = initCommand("asDragSource");
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
public Object isAccessibilityHeading() {
	return getBuilder().reset().tryGetAccessibilityHeading().execute(false).isAccessibilityHeading(); 
}
public void setAccessibilityHeading(boolean value) {
	getBuilder().reset().setAccessibilityHeading(value).execute(true);
}

public Object getAccessibilityLiveRegion() {
	return getBuilder().reset().tryGetAccessibilityLiveRegion().execute(false).getAccessibilityLiveRegion(); 
}
public void setAccessibilityLiveRegion(String value) {
	getBuilder().reset().setAccessibilityLiveRegion(value).execute(true);
}

public Object getAccessibilityPaneTitle() {
	return getBuilder().reset().tryGetAccessibilityPaneTitle().execute(false).getAccessibilityPaneTitle(); 
}
public void setAccessibilityPaneTitle(String value) {
	getBuilder().reset().setAccessibilityPaneTitle(value).execute(true);
}

public Object getAccessibilityTraversalAfter() {
	return getBuilder().reset().tryGetAccessibilityTraversalAfter().execute(false).getAccessibilityTraversalAfter(); 
}
public void setAccessibilityTraversalAfter(String value) {
	getBuilder().reset().setAccessibilityTraversalAfter(value).execute(true);
}

public Object getAccessibilityTraversalBefore() {
	return getBuilder().reset().tryGetAccessibilityTraversalBefore().execute(false).getAccessibilityTraversalBefore(); 
}
public void setAccessibilityTraversalBefore(String value) {
	getBuilder().reset().setAccessibilityTraversalBefore(value).execute(true);
}

public Object getAlpha() {
	return getBuilder().reset().tryGetAlpha().execute(false).getAlpha(); 
}
public void setAlpha(float value) {
	getBuilder().reset().setAlpha(value).execute(true);
}

public Object getAutofillHints() {
	return getBuilder().reset().tryGetAutofillHints().execute(false).getAutofillHints(); 
}
public void setAutofillHints(String value) {
	getBuilder().reset().setAutofillHints(value).execute(true);
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
public void setBackgroundTintMode(BackgroundTintMode value) {
	getBuilder().reset().setBackgroundTintMode(value).execute(true);
}

public Object isClickable() {
	return getBuilder().reset().tryGetClickable().execute(false).isClickable(); 
}
public void setClickable(boolean value) {
	getBuilder().reset().setClickable(value).execute(true);
}

public Object getContentDescription() {
	return getBuilder().reset().tryGetContentDescription().execute(false).getContentDescription(); 
}
public void setContentDescription(String value) {
	getBuilder().reset().setContentDescription(value).execute(true);
}

public Object isContextClickable() {
	return getBuilder().reset().tryGetContextClickable().execute(false).isContextClickable(); 
}
public void setContextClickable(boolean value) {
	getBuilder().reset().setContextClickable(value).execute(true);
}

public Object isDefaultFocusHighlightEnabled() {
	return getBuilder().reset().tryGetDefaultFocusHighlightEnabled().execute(false).isDefaultFocusHighlightEnabled(); 
}
public void setDefaultFocusHighlightEnabled(boolean value) {
	getBuilder().reset().setDefaultFocusHighlightEnabled(value).execute(true);
}

public Object isDuplicateParentState() {
	return getBuilder().reset().tryGetDuplicateParentState().execute(false).isDuplicateParentState(); 
}
public void setDuplicateParentState(boolean value) {
	getBuilder().reset().setDuplicateParentState(value).execute(true);
}

public Object getElevation() {
	return getBuilder().reset().tryGetElevation().execute(false).getElevation(); 
}
public void setElevation(String value) {
	getBuilder().reset().setElevation(value).execute(true);
}

public Object isFadeScrollbars() {
	return getBuilder().reset().tryGetFadeScrollbars().execute(false).isFadeScrollbars(); 
}
public void setFadeScrollbars(boolean value) {
	getBuilder().reset().setFadeScrollbars(value).execute(true);
}

public void setFadingEdgeLength(String value) {
	getBuilder().reset().setFadingEdgeLength(value).execute(true);
}

public Object isFilterTouchesWhenObscured() {
	return getBuilder().reset().tryGetFilterTouchesWhenObscured().execute(false).isFilterTouchesWhenObscured(); 
}
public void setFilterTouchesWhenObscured(boolean value) {
	getBuilder().reset().setFilterTouchesWhenObscured(value).execute(true);
}

public Object isFitsSystemWindows() {
	return getBuilder().reset().tryGetFitsSystemWindows().execute(false).isFitsSystemWindows(); 
}
public void setFitsSystemWindows(boolean value) {
	getBuilder().reset().setFitsSystemWindows(value).execute(true);
}

public Object isFocusableInTouchMode() {
	return getBuilder().reset().tryGetFocusableInTouchMode().execute(false).isFocusableInTouchMode(); 
}
public void setFocusableInTouchMode(boolean value) {
	getBuilder().reset().setFocusableInTouchMode(value).execute(true);
}

public Object isFocusedByDefault() {
	return getBuilder().reset().tryGetFocusedByDefault().execute(false).isFocusedByDefault(); 
}
public void setFocusedByDefault(boolean value) {
	getBuilder().reset().setFocusedByDefault(value).execute(true);
}

public void setForceHasOverlappingRendering(boolean value) {
	getBuilder().reset().setForceHasOverlappingRendering(value).execute(true);
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
public void setForegroundTintMode(ForegroundTintMode value) {
	getBuilder().reset().setForegroundTintMode(value).execute(true);
}

public Object isHapticFeedbackEnabled() {
	return getBuilder().reset().tryGetHapticFeedbackEnabled().execute(false).isHapticFeedbackEnabled(); 
}
public void setHapticFeedbackEnabled(boolean value) {
	getBuilder().reset().setHapticFeedbackEnabled(value).execute(true);
}

public Object getImportantForAccessibility() {
	return getBuilder().reset().tryGetImportantForAccessibility().execute(false).getImportantForAccessibility(); 
}
public void setImportantForAccessibility(String value) {
	getBuilder().reset().setImportantForAccessibility(value).execute(true);
}

public Object getImportantForAutofill() {
	return getBuilder().reset().tryGetImportantForAutofill().execute(false).getImportantForAutofill(); 
}
public void setImportantForAutofill(String value) {
	getBuilder().reset().setImportantForAutofill(value).execute(true);
}

public Object isIsScrollContainer() {
	return getBuilder().reset().tryGetIsScrollContainer().execute(false).isIsScrollContainer(); 
}
public void setIsScrollContainer(boolean value) {
	getBuilder().reset().setIsScrollContainer(value).execute(true);
}

public Object isKeepScreenOn() {
	return getBuilder().reset().tryGetKeepScreenOn().execute(false).isKeepScreenOn(); 
}
public void setKeepScreenOn(boolean value) {
	getBuilder().reset().setKeepScreenOn(value).execute(true);
}

public Object isKeyboardNavigationCluster() {
	return getBuilder().reset().tryGetKeyboardNavigationCluster().execute(false).isKeyboardNavigationCluster(); 
}
public void setKeyboardNavigationCluster(boolean value) {
	getBuilder().reset().setKeyboardNavigationCluster(value).execute(true);
}

public Object getLayoutDirection() {
	return getBuilder().reset().tryGetLayoutDirection().execute(false).getLayoutDirection(); 
}
public void setLayoutDirection(String value) {
	getBuilder().reset().setLayoutDirection(value).execute(true);
}

public Object isLongClickable() {
	return getBuilder().reset().tryGetLongClickable().execute(false).isLongClickable(); 
}
public void setLongClickable(boolean value) {
	getBuilder().reset().setLongClickable(value).execute(true);
}

public Object getMinHeight() {
	return getBuilder().reset().tryGetMinHeight().execute(false).getMinHeight(); 
}
public void setMinHeight(String value) {
	getBuilder().reset().setMinHeight(value).execute(true);
}

public Object getMinWidth() {
	return getBuilder().reset().tryGetMinWidth().execute(false).getMinWidth(); 
}
public void setMinWidth(String value) {
	getBuilder().reset().setMinWidth(value).execute(true);
}

public Object getNextClusterForward() {
	return getBuilder().reset().tryGetNextClusterForward().execute(false).getNextClusterForward(); 
}
public void setNextClusterForward(String value) {
	getBuilder().reset().setNextClusterForward(value).execute(true);
}

public Object getNextFocusDown() {
	return getBuilder().reset().tryGetNextFocusDown().execute(false).getNextFocusDown(); 
}
public void setNextFocusDown(String value) {
	getBuilder().reset().setNextFocusDown(value).execute(true);
}

public Object getNextFocusForward() {
	return getBuilder().reset().tryGetNextFocusForward().execute(false).getNextFocusForward(); 
}
public void setNextFocusForward(String value) {
	getBuilder().reset().setNextFocusForward(value).execute(true);
}

public Object getNextFocusLeft() {
	return getBuilder().reset().tryGetNextFocusLeft().execute(false).getNextFocusLeft(); 
}
public void setNextFocusLeft(String value) {
	getBuilder().reset().setNextFocusLeft(value).execute(true);
}

public Object getNextFocusRight() {
	return getBuilder().reset().tryGetNextFocusRight().execute(false).getNextFocusRight(); 
}
public void setNextFocusRight(String value) {
	getBuilder().reset().setNextFocusRight(value).execute(true);
}

public Object getNextFocusUp() {
	return getBuilder().reset().tryGetNextFocusUp().execute(false).getNextFocusUp(); 
}
public void setNextFocusUp(String value) {
	getBuilder().reset().setNextFocusUp(value).execute(true);
}

public Object getOutlineAmbientShadowColor() {
	return getBuilder().reset().tryGetOutlineAmbientShadowColor().execute(false).getOutlineAmbientShadowColor(); 
}
public void setOutlineAmbientShadowColor(String value) {
	getBuilder().reset().setOutlineAmbientShadowColor(value).execute(true);
}

public Object getOutlineSpotShadowColor() {
	return getBuilder().reset().tryGetOutlineSpotShadowColor().execute(false).getOutlineSpotShadowColor(); 
}
public void setOutlineSpotShadowColor(String value) {
	getBuilder().reset().setOutlineSpotShadowColor(value).execute(true);
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

public Object isSaveEnabled() {
	return getBuilder().reset().tryGetSaveEnabled().execute(false).isSaveEnabled(); 
}
public void setSaveEnabled(boolean value) {
	getBuilder().reset().setSaveEnabled(value).execute(true);
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

public Object isScreenReaderFocusable() {
	return getBuilder().reset().tryGetScreenReaderFocusable().execute(false).isScreenReaderFocusable(); 
}
public void setScreenReaderFocusable(boolean value) {
	getBuilder().reset().setScreenReaderFocusable(value).execute(true);
}

public Object getScrollIndicators() {
	return getBuilder().reset().tryGetScrollIndicators().execute(false).getScrollIndicators(); 
}
public void setScrollIndicators(String value) {
	getBuilder().reset().setScrollIndicators(value).execute(true);
}

public Object getScrollbarDefaultDelayBeforeFade() {
	return getBuilder().reset().tryGetScrollbarDefaultDelayBeforeFade().execute(false).getScrollbarDefaultDelayBeforeFade(); 
}
public void setScrollbarDefaultDelayBeforeFade(int value) {
	getBuilder().reset().setScrollbarDefaultDelayBeforeFade(value).execute(true);
}

public Object getScrollbarFadeDuration() {
	return getBuilder().reset().tryGetScrollbarFadeDuration().execute(false).getScrollbarFadeDuration(); 
}
public void setScrollbarFadeDuration(int value) {
	getBuilder().reset().setScrollbarFadeDuration(value).execute(true);
}

public Object getScrollbarSize() {
	return getBuilder().reset().tryGetScrollbarSize().execute(false).getScrollbarSize(); 
}
public void setScrollbarSize(String value) {
	getBuilder().reset().setScrollbarSize(value).execute(true);
}

public Object getScrollbarStyle() {
	return getBuilder().reset().tryGetScrollbarStyle().execute(false).getScrollbarStyle(); 
}
public void setScrollbarStyle(String value) {
	getBuilder().reset().setScrollbarStyle(value).execute(true);
}

public Object isSoundEffectsEnabled() {
	return getBuilder().reset().tryGetSoundEffectsEnabled().execute(false).isSoundEffectsEnabled(); 
}
public void setSoundEffectsEnabled(boolean value) {
	getBuilder().reset().setSoundEffectsEnabled(value).execute(true);
}

public Object getTextAlignment() {
	return getBuilder().reset().tryGetTextAlignment().execute(false).getTextAlignment(); 
}
public void setTextAlignment(String value) {
	getBuilder().reset().setTextAlignment(value).execute(true);
}

public Object getTextDirection() {
	return getBuilder().reset().tryGetTextDirection().execute(false).getTextDirection(); 
}
public void setTextDirection(String value) {
	getBuilder().reset().setTextDirection(value).execute(true);
}

public Object getTooltipText() {
	return getBuilder().reset().tryGetTooltipText().execute(false).getTooltipText(); 
}
public void setTooltipText(String value) {
	getBuilder().reset().setTooltipText(value).execute(true);
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

public Object getTransitionName() {
	return getBuilder().reset().tryGetTransitionName().execute(false).getTransitionName(); 
}
public void setTransitionName(String value) {
	getBuilder().reset().setTransitionName(value).execute(true);
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

public Object getVisibility() {
	return getBuilder().reset().tryGetVisibility().execute(false).getVisibility(); 
}
public void setVisibility(String value) {
	getBuilder().reset().setVisibility(value).execute(true);
}

public void setOnApplyWindowInsets(String value) {
	getBuilder().reset().setOnApplyWindowInsets(value).execute(true);
}

public void setOnCapturedPointer(String value) {
	getBuilder().reset().setOnCapturedPointer(value).execute(true);
}

public void setOnClick(String value) {
	getBuilder().reset().setOnClick(value).execute(true);
}

public void setOnContextClick(String value) {
	getBuilder().reset().setOnContextClick(value).execute(true);
}

public void setOnCreateContextMenu(String value) {
	getBuilder().reset().setOnCreateContextMenu(value).execute(true);
}

public void setOnDrag(String value) {
	getBuilder().reset().setOnDrag(value).execute(true);
}

public void setOnFocusChange(String value) {
	getBuilder().reset().setOnFocusChange(value).execute(true);
}

public void setOnGenericMotion(String value) {
	getBuilder().reset().setOnGenericMotion(value).execute(true);
}

public void setOnHover(String value) {
	getBuilder().reset().setOnHover(value).execute(true);
}

public void setOnKey(String value) {
	getBuilder().reset().setOnKey(value).execute(true);
}

public void setOnLongClick(String value) {
	getBuilder().reset().setOnLongClick(value).execute(true);
}

public void setOnScrollChange(String value) {
	getBuilder().reset().setOnScrollChange(value).execute(true);
}

public void setOnSystemUiVisibilityChange(String value) {
	getBuilder().reset().setOnSystemUiVisibilityChange(value).execute(true);
}

public void setOnTouch(String value) {
	getBuilder().reset().setOnTouch(value).execute(true);
}

public void setPadding(String value) {
	getBuilder().reset().setPadding(value).execute(true);
}

public Object getPaddingTop() {
	return getBuilder().reset().tryGetPaddingTop().execute(false).getPaddingTop(); 
}
public void setPaddingTop(String value) {
	getBuilder().reset().setPaddingTop(value).execute(true);
}

public Object getPaddingBottom() {
	return getBuilder().reset().tryGetPaddingBottom().execute(false).getPaddingBottom(); 
}
public void setPaddingBottom(String value) {
	getBuilder().reset().setPaddingBottom(value).execute(true);
}

public Object getPaddingLeft() {
	return getBuilder().reset().tryGetPaddingLeft().execute(false).getPaddingLeft(); 
}
public void setPaddingLeft(String value) {
	getBuilder().reset().setPaddingLeft(value).execute(true);
}

public Object getPaddingRight() {
	return getBuilder().reset().tryGetPaddingRight().execute(false).getPaddingRight(); 
}
public void setPaddingRight(String value) {
	getBuilder().reset().setPaddingRight(value).execute(true);
}

public Object getPaddingStart() {
	return getBuilder().reset().tryGetPaddingStart().execute(false).getPaddingStart(); 
}
public void setPaddingStart(String value) {
	getBuilder().reset().setPaddingStart(value).execute(true);
}

public Object getPaddingEnd() {
	return getBuilder().reset().tryGetPaddingEnd().execute(false).getPaddingEnd(); 
}
public void setPaddingEnd(String value) {
	getBuilder().reset().setPaddingEnd(value).execute(true);
}

public void setPaddingHorizontal(String value) {
	getBuilder().reset().setPaddingHorizontal(value).execute(true);
}

public void setPaddingVertical(String value) {
	getBuilder().reset().setPaddingVertical(value).execute(true);
}

public void setLayerType(String value) {
	getBuilder().reset().setLayerType(value).execute(true);
}

public Object getRequiresFadingEdge() {
	return getBuilder().reset().tryGetRequiresFadingEdge().execute(false).getRequiresFadingEdge(); 
}
public void setRequiresFadingEdge(String value) {
	getBuilder().reset().setRequiresFadingEdge(value).execute(true);
}

public Object getBackground() {
	return getBuilder().reset().tryGetBackground().execute(false).getBackground(); 
}
public void setBackground(String value) {
	getBuilder().reset().setBackground(value).execute(true);
}

public Object getForeground() {
	return getBuilder().reset().tryGetForeground().execute(false).getForeground(); 
}
public void setForeground(String value) {
	getBuilder().reset().setForeground(value).execute(true);
}

public void setBackgroundRepeat(String value) {
	getBuilder().reset().setBackgroundRepeat(value).execute(true);
}

public Object getModelSyncEvents() {
	return getBuilder().reset().tryGetModelSyncEvents().execute(false).getModelSyncEvents(); 
}
public void setModelSyncEvents(String value) {
	getBuilder().reset().setModelSyncEvents(value).execute(true);
}

public void updateModelData(String expression,
Object payload) {
	getBuilder().reset().updateModelData(expression,
payload).execute(true);
}

public void notifyDataSetChanged(boolean value) {
	getBuilder().reset().notifyDataSetChanged(value).execute(true);
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

public void setForegroundRepeat(String value) {
	getBuilder().reset().setForegroundRepeat(value).execute(true);
}

public Object getForegroundGravity() {
	return getBuilder().reset().tryGetForegroundGravity().execute(false).getForegroundGravity(); 
}
public void setForegroundGravity(String value) {
	getBuilder().reset().setForegroundGravity(value).execute(true);
}

public void performHapticFeedback(String value) {
	getBuilder().reset().performHapticFeedback(value).execute(true);
}

public void performHapticFeedbackWithFlags(String value,
String flags) {
	getBuilder().reset().performHapticFeedbackWithFlags(value,
flags).execute(true);
}

public void setAttributeUnderTest(String value) {
	getBuilder().reset().setAttributeUnderTest(value).execute(true);
}

public Object isSelected() {
	return getBuilder().reset().tryGetSelected().execute(false).isSelected(); 
}
public void setSelected(boolean value) {
	getBuilder().reset().setSelected(value).execute(true);
}

public Object isEnabled() {
	return getBuilder().reset().tryGetEnabled().execute(false).isEnabled(); 
}
public void setEnabled(boolean value) {
	getBuilder().reset().setEnabled(value).execute(true);
}

public Object isFocusable() {
	return getBuilder().reset().tryGetFocusable().execute(false).isFocusable(); 
}
public void setFocusable(boolean value) {
	getBuilder().reset().setFocusable(value).execute(true);
}

public Object getScrollX() {
	return getBuilder().reset().tryGetScrollX().execute(false).getScrollX(); 
}
public void setScrollX(String value) {
	getBuilder().reset().setScrollX(value).execute(true);
}

public Object getScrollY() {
	return getBuilder().reset().tryGetScrollY().execute(false).getScrollY(); 
}
public void setScrollY(String value) {
	getBuilder().reset().setScrollY(value).execute(true);
}

public void invalidate() {
	getBuilder().reset().invalidate().execute(true);
}

public void requestLayout() {
	getBuilder().reset().requestLayout().execute(true);
}

public void setAsDragSource(String value) {
	getBuilder().reset().setAsDragSource(value).execute(true);
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
	@SuppressLint("NewApi")
	public static boolean isRTLLayout(IWidget widget) {
		View view = (View) widget.asWidget();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			return view.getResources().getConfiguration().getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
		} else {
			return false;
		}
	}

	public static void nativeMakeFrame(Object asNativeWidget, int l, int t,
			int r, int b) {
		
	}

	private static void setBackground(IWidget widget, String strValue, Object objValue, View view) {
		view.setBackground((android.graphics.drawable.Drawable) objValue);
	}
	
	private static void setForeground(IWidget widget, String strValue, Object objValue, View view) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			view.setForeground((android.graphics.drawable.Drawable) objValue);
		}
	}
	
	@SuppressLint("NewApi")
	private static void setLayerType(Object objValue, View view) {
		if (Build.VERSION.SDK_INT >= 11) {
			view.setLayerType((int) objValue, null);
		}
		
	}
	
	
	private static void setRequiresFadingEdge(Object objValue, View view) {
		int value = (int) objValue;
		view.setHorizontalFadingEdgeEnabled((value & 0x1000) == 0x1000);
		view.setVerticalFadingEdgeEnabled((value & 0x2000) == 0x2000);
	}

	private static Object getRequiresFadingEdge(IWidget w, View view) {
		int requiresFadingEdge = 0;
		if (view.isHorizontalFadingEdgeEnabled()) {
			requiresFadingEdge |= 0x1000;
		}
		if (view.isVerticalFadingEdgeEnabled()) {
			requiresFadingEdge |= 0x2000;
		}
		return requiresFadingEdge;
	}
	
	//start - viewcode

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

	//end - viewcode

    public static void nativeMakeFrame(Object asNativeWidget, int l, int t, int r, int b, int i) {
    }

	public static void nativeMakeFrameForHorizontalScrollView(Object asNativeWidget, int l, int t, int r, int b,
			int i) {
	}
	
	@SuppressLint("NewApi")
	private static void setScrollY(IWidget w, final View view, final Object objValue) {
		view.setScrollY((int) objValue); 
	}

	@SuppressLint("NewApi")
	private static void setScrollX(IWidget w, final View view, final Object objValue) {
		view.setScrollX((int) objValue); 
	}

	public static void registerCommandConveter(IWidget widget) {
		widget.registerForAttributeCommandChain("background", "foreground");
	}
	
	//start - capinsets 
	private static void setBackgroundRepeat(IWidget w, String strValue, Object objValue, View view) {
		w.applyAttributeCommand("background", "imageRepeat", new String[] {"backgroundRepeat"}, true, strValue);
	}
	
	private static void setForegroundRepeat(IWidget w, String strValue, Object objValue, View view) {
		w.applyAttributeCommand("foreground", "imageRepeat", new String[] {"foregroundRepeat"}, true, strValue);
	}
	//end - capinsets 


	private static boolean isRTLayoutCapInsets(IWidget w) {
		return isRTLLayout(w);
	}
	
	private static void invalidate(IWidget w) {
		w.invalidate();
	}
	
	public static void invalidate(IWidget w, Object view) {
		((View) view).invalidate();
	}
	
	private static void requestLayout(IWidget w) {
		if (w.isInitialised() ) {
			w.requestLayout();
		}
	}
	
	public static void requestLayout(IWidget w, Object nativeWidget) {
		((View) w.asWidget()).requestLayout();
	}

	public static void setLayoutDirection(IWidget w, int layoutDirection) {
		ViewCompat.setLayoutDirection(((View) w.asNativeWidget()), layoutDirection);
	}
	
	public static void startDrag(IWidget w, String text) {
		android.content.ClipData.Item item = new android.content.ClipData.Item(text);

		// Create a new ClipData using the tag as a label, the plain text MIME type, and
		// the already-created item. This will create a new ClipDescription object within the
		// ClipData, and set its MIME type entry to "text/plain"
		android.content.ClipData dragData = new android.content.ClipData(
			text,
		    new String[] { android.content.ClipDescription.MIMETYPE_TEXT_PLAIN },
		    item);

		// Instantiates the drag shadow builder.
		View v = (View) w.asWidget();
		View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

		// Starts the drag
		v.startDragAndDrop(dragData,  // the data to be dragged
		            myShadow,  // the drag shadow builder
		            null,      // no need to use local data
		            0          // flags (not currently used, set to 0)
		);
	}
	
	//start - eventInfo
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
	public static void addEventInfo(Map<String, Object> obj, android.widget.Chronometer chronometer, com.ashera.core.IFragment fragment) {
		obj.put("text", chronometer.getText());
	}
	//end - eventInfo

	
	private static String getClipData(DragEvent event) {
		if (event.getClipData() != null && event.getClipData().getDescription() != null) {
			return event.getClipData().getDescription().getLabel().toString();
		}
		return null;
	}

	private static void setAsDragSource(IWidget w, Object objValue) {
		((View) w.asWidget()).setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				Map<String, Object> eventData = new java.util.HashMap<>();
				w.updateModelToEventMap(eventData, "", (String) objValue);
				String text = PluginInvoker.marshal(eventData);
				ViewImpl.startDrag(w, text);
				return true;
			}
			
		});
	}
	
	private static void setForegroundGravity(IWidget w, Object objValue) {
		View view = ((View) w.asWidget());
		if (Build.VERSION.SDK_INT >= 23) {
			((View) w.asWidget()).setForegroundGravity((int)objValue);
			
			if (w.isInitialised() && view.getForeground() != null) {
				// hack to make foregroundGravity change dynamically
				view.setForeground(view.getForeground().getConstantState().newDrawable().mutate());
			}
		}
	}
	
	private static Object getForegroundGravity(IWidget w) {
		if (Build.VERSION.SDK_INT >= 23) {
			View view = ((View) w.asWidget());
			return view.getForegroundGravity();
		}
		
		return null;
	}

	private static Object getForeground(View view) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			return view.getForeground();
		}
		
		return null;
	}

	public static void drawableStateChanged(IWidget widget) {
		widget.drawableStateChanged();
	}

	private static void nativeBringToFront(List<IWidget> widgets) {
		for (IWidget child : widgets) {
			View view = (View) child.asWidget();
			view.bringToFront();
		}
	}

	public static void addEventInfo(Map<String, Object> obj, MenuItem item, com.ashera.core.IFragment fragment) {
		Context context = (Context) fragment.getRootActivity();
		if (item.getItemId() != View.NO_ID) {
			obj.put("itemId", "@+id/" + context.getResources().getResourceEntryName(item.getItemId()));
		}
	}
	//start - validations
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
	//end - validations
	
	public static boolean isRTLLayoutDirection(IWidget widget) {
		View view = (View) widget.asWidget();
		return view.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
	}
	
	private static void setOnCapturedPointerListener(View view, Object objValue) {
		view.setOnCapturedPointerListener((View.OnCapturedPointerListener) objValue);
	}

	private static void setOnApplyWindowInsetsListener(View view, Object objValue) {
		view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) objValue);
	}
	


	private static void setOnTouchListener(View view, Object objValue) {
		view.setOnTouchListener((View.OnTouchListener) objValue);
	}

	private static void setOnSystemUiVisibilityChangeListener(View view, Object objValue) {
		view.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener) objValue);
	}

	private static void setOnScrollChangeListener(View view, Object objValue) {
		view.setOnScrollChangeListener((View.OnScrollChangeListener) objValue);
	}

	private static void setOnLongClickListener(View view, Object objValue) {
		view.setOnLongClickListener((View.OnLongClickListener) objValue);		
	}

	private static void setOnKeyListener(View view, Object objValue) {
		view.setOnKeyListener((View.OnKeyListener) objValue);		
	}

	private static void setOnHoverListener(View view, Object objValue) {
		view.setOnHoverListener((View.OnHoverListener) objValue);		
	}

	private static void setOnContextClickListener(View view, Object objValue) {
		view.setOnContextClickListener((View.OnContextClickListener) objValue);		
	}

	private static void setOnClickListener(View view, Object objValue) {
		view.setOnClickListener((View.OnClickListener) objValue);		
	}

	private static void setOnGenericMotionListener(View view, Object objValue) {
		view.setOnGenericMotionListener((View.OnGenericMotionListener) objValue);		
	}

	private static void setOnFocusChangeListener(View view, Object objValue) {
		view.setOnFocusChangeListener((View.OnFocusChangeListener) objValue);		
	}

	private static void setOnDragListener(View view, Object objValue) {
		view.setOnDragListener((View.OnDragListener) objValue);		
	}

	private static void setOnCreateContextMenuListener(View view, Object objValue) {
		view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) objValue);		
	}
	
	private static void setNativeId(IWidget w, String strValue) {
	}
}
