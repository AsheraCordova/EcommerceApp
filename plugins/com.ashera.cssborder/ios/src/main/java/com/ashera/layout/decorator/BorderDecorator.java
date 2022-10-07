package com.ashera.layout.decorator;

import java.util.Arrays;
import java.util.List;

import com.ashera.layout.ViewImpl;
import com.ashera.widget.ICompositeDecorator;
import com.ashera.widget.ILifeCycleDecorator;
import com.ashera.widget.IWidget;
import com.ashera.widget.WidgetAttribute;

import r.android.view.View;

/*-[
#include <UIKit/UIKit.h>
#include "CGRectWrapper.h"
#define degreesToRadians(x) ((x) * M_PI / 180.0)
]-*/

public class BorderDecorator implements ILifeCycleDecorator {
	//start - props
	private Border borderTop;
	private Border borderLeft;
	private Border borderRight;
	private Border borderBottom;
	@com.google.j2objc.annotations.Weak private IWidget widget;
	private float borderTopLeftRadius = 0;
	private float borderTopRightRadius = 0;
	private float borderBottomRightRadius = 0;
	private float borderBottomLeftRadius = 0;
	//end - props
	
	public Object defaultColor;
	private final static java.util.List<String> METHODS = Arrays.asList(new String[] {"drawRect", "setFrame"});
	private @com.google.j2objc.annotations.Weak Object view;
	private boolean isWrappedWidget;
    

	@Override
	public ILifeCycleDecorator newInstance(IWidget widget) {
		BorderDecorator borderDecorator = new BorderDecorator();
		borderDecorator.view = widget.asNativeWidget();
		borderDecorator.isWrappedWidget = widget.getParent() instanceof ICompositeDecorator;
		borderDecorator.widget = widget;
		setDefaultColor(borderDecorator);
		return borderDecorator;
	}


	//start - body

	public BorderDecorator() {
	}
	
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue) {
		switch (key.getAttributeName()) {
		case "borderWidth": {

			createBorderWidth((int) objValue);

		}
			break;
		case "borderColor": {

			createBorderColor(objValue);

		}
			break;
		case "borderStyle": {

			createBorderStyle((String) objValue);

		}
			break;
		case "borderDashWidth": {

			createBorderDashWidth((int) objValue);

		}
			break;
		case "borderDashSpacing": {

			createBorderDashSpacing((int) objValue);

		}
		break;
		case "borderRadius": {

			createBorderRadius((float) objValue);

		}
			break;
		case "borderTopWidth": {

			createBorderWidthTop((int) objValue);

		}
			break;
		case "borderTopColor": {

			createBorderColorTop(objValue);

		}
			break;
		case "borderTopStyle": {

			createBorderStyleTop((String) objValue);

		}
			break;
		case "borderTopDashWidth": {

			createBorderDashWidthTop((int) objValue);

		}
			break;
		case "borderTopDashSpacing": {

			createBorderDashSpacingTop((int) objValue);

		}
			break;
		case "borderTopLeftRadius": {

			createBorderRadiusTopLeft((float) objValue);

		}
			break;
		case "borderTopRightRadius": {

			createBorderRadiusTopRight((float) objValue);

		}
			break;
		case "borderBottomWidth": {

			createBorderWidthBottom((int) objValue);

		}
			break;
		case "borderBottomColor": {

			createBorderColorBottom(objValue);

		}
			break;
		case "borderBottomStyle": {

			createBorderStyleBottom((String) objValue);

		}
			break;
		case "borderBottomDashWidth": {

			createBorderDashWidthBottom((int) objValue);

		}
			break;
		case "borderBottomDashSpacing": {

			createBorderDashSpacingBottom((int) objValue);

		}
			break;
		case "borderBottomLeftRadius": {

			createBorderRadiusBottomLeft((float) objValue);

		}
			break;
		case "borderBottomRightRadius": {

			createBorderRadiusBottomRight((float) objValue);

		}
			break;
		case "borderLeftWidth": {

			createBorderWidthLeft((int) objValue);

		}
			break;
		case "borderLeftColor": {

			createBorderColorLeft(objValue);

		}
			break;
		case "borderLeftStyle": {

			createBorderStyleLeft((String) objValue);

		}
			break;
		case "borderLeftDashWidth": {

			createBorderDashWidthLeft((int) objValue);

		}
			break;
		case "borderLeftDashSpacing": {

			createBorderDashSpacingLeft((int) objValue);

		}
			break;
		case "borderRightWidth": {

			createBorderWidthRight((int) objValue);

		}
			break;
		case "borderRightColor": {

			createBorderColorRight(objValue);

		}
			break;
		case "borderRightStyle": {

			createBorderStyleRight((String) objValue);

		}
			break;
		case "borderRightDashWidth": {

			createBorderDashWidthRight((int) objValue);

		}
			break;
		case "borderRightDashSpacing": {

			createBorderDashSpacingRight((int) objValue);

		}
			break;
		}
		addCommandIfNeeded();
	}

	@Override
	public Object getAttribute(WidgetAttribute widgetAttribute) {
		switch (widgetAttribute.getAttributeName()) {
		case "borderTopWidth": {
			if (borderTop == null) {
				return 0;
			}
			return borderTop.getWidth();
		}
		case "borderTopColor": {
			if (borderTop == null) {
				return null;
			}
			return borderTop.getColor();
		}
		case "borderTopStyle": {
			if (borderTop == null) {
				return null;
			}
			return borderTop.getStyle();

		}
		case "borderTopDashWidth": {
			if (borderTop == null) {
				return 0;
			}
			return borderTop.getDashWidth();
		}
		case "borderTopDashSpacing": {
			if (borderTop == null) {
				return 0;
			}
			return borderTop.getDashSpacing();

		}
		case "borderTopLeftRadius": {
			if (borderTop == null) {
				return 0;
			}
			return borderTop.getTopLeftRadius();

		}
		case "borderTopRightRadius": {
			if (borderTop == null) {
				return 0;
			}
			return borderTop.getTopRightRadius();
		}

		case "borderBottomWidth": {
			if (borderBottom == null) {
				return 0;
			}
			return borderBottom.getWidth();
		}
		case "borderBottomColor": {
			if (borderBottom == null) {
				return null;
			}
			return borderBottom.getColor();
		}
		case "borderBottomStyle": {
			if (borderBottom == null) {
				return null;
			}
			return borderBottom.getStyle();

		}
		case "borderBottomDashWidth": {
			if (borderBottom == null) {
				return 0;
			}
			return borderBottom.getDashWidth();
		}
		case "borderBottomDashSpacing": {
			if (borderBottom == null) {
				return 0;
			}
			return borderBottom.getDashSpacing();

		}
		case "borderBottomLeftRadius": {
			if (borderBottom == null) {
				return 0;
			}
			return borderBottom.getBottomLeftRadius();

		}
		case "borderBottomRightRadius": {
			if (borderBottom == null) {
				return 0;
			}
			return borderBottom.getBottomRightRadius();
		}
		case "borderLeftWidth": {
			if (borderLeft == null) {
				return 0;
			}
			return borderLeft.getWidth();
		}
		case "borderLeftColor": {
			if (borderLeft == null) {
				return null;
			}
			return borderLeft.getColor();
		}
		case "borderLeftStyle": {
			if (borderLeft == null) {
				return null;
			}
			return borderLeft.getStyle();

		}
		case "borderLeftDashWidth": {
			if (borderLeft == null) {
				return 0;
			}
			return borderLeft.getDashWidth();
		}
		case "borderLeftDashSpacing": {
			if (borderLeft == null) {
				return 0;
			}
			return borderLeft.getDashSpacing();

		}
		case "borderRightWidth": {
			if (borderRight == null) {
				return 0;
			}
			return borderRight.getWidth();
		}
		case "borderRightColor": {
			if (borderRight == null) {
				return null;
			}
			return borderRight.getColor();
		}
		case "borderRightStyle": {
			if (borderRight == null) {
				return null;
			}
			return borderRight.getStyle();

		}
		case "borderRightDashWidth": {
			if (borderRight == null) {
				return 0;
			}
			return borderRight.getDashWidth();
		}
		case "borderRightDashSpacing": {
			if (borderRight == null) {
				return 0;
			}
			return borderRight.getDashSpacing();

		}
		}
		return null;
	}

	@Override
	public List<String> getMethods() {
		return METHODS;
	}

	private void initBorderTop() {
		if (borderTop == null) {
			borderTop = new Border();
		}
	}

	private void initBorderLeft() {
		if (borderLeft == null) {
			borderLeft = new Border();
		}
	}

	private void initBorderRight() {
		if (borderRight == null) {
			borderRight = new Border();
		}
	}

	private void initBorderBottom() {
		if (borderBottom == null) {
			borderBottom = new Border();
		}
	}

	public void createBorderStyle(String style) {
		createBorderStyleTop(style);
		createBorderStyleBottom(style);
		createBorderStyleLeft(style);
		createBorderStyleRight(style);
	}

	public void createBorderDashSpacing(int dashSpacing) {
		createBorderDashSpacingTop(dashSpacing);
		createBorderDashSpacingBottom(dashSpacing);
		createBorderDashSpacingLeft(dashSpacing);
		createBorderDashSpacingRight(dashSpacing);
	}

	public void createBorderDashWidth(int dashWidth) {
		createBorderDashWidthTop(dashWidth);
		createBorderDashWidthBottom(dashWidth);
		createBorderDashWidthLeft(dashWidth);
		createBorderDashWidthRight(dashWidth);
	}

	public void createBorderColor(Object color) {
		createBorderColorTop(color);
		createBorderColorBottom(color);
		createBorderColorLeft(color);
		createBorderColorRight(color);
	}

	public void createBorderWidth(int borderWith) {
		createBorderWidthTop(borderWith);
		createBorderWidthBottom(borderWith);
		createBorderWidthLeft(borderWith);
		createBorderWidthRight(borderWith);
	}

	public void createBorderRadius(float radius) {

		createBorderRadiusTopLeft(radius);
		createBorderRadiusBottomLeft(radius);
		createBorderRadiusTopRight(radius);
		createBorderRadiusBottomRight(radius);
	}

	public void createBorderColorBottom(Object color) {
		initBorderBottom();
		borderBottom.setColor(color);
		invalidate();
	}


	public void createBorderColorTop(Object color) {
		initBorderTop();
		borderTop.setColor(color);
		invalidate();
	}

	public void createBorderColorLeft(Object color) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderColorRightInternal(color);
		} else {
			createBorderColorLeftInternal(color);
		}
	}

	private void createBorderColorLeftInternal(Object color) {
		initBorderLeft();
		borderLeft.setColor(color);
		invalidate();
	}

	public void createBorderColorRight(Object color) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderColorLeftInternal(color);
		} else {
			createBorderColorRightInternal(color);
		}
	}

	private void createBorderColorRightInternal(Object color) {
		initBorderRight();
		borderRight.setColor(color);
		invalidate();
	}

	public void createBorderWidthRight(int borderWith) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderWidthLeftInternal(borderWith);
		} else {
			createBorderWidthRightInternal(borderWith);
		}
	}

	private void createBorderWidthRightInternal(int borderWith) {
		initBorderRight();
		borderRight.setWidth(borderWith);
		invalidate();
	}

	public void createBorderWidthTop(int borderWith) {
		initBorderTop();
		borderTop.setWidth(borderWith);
		invalidate();
	}

	public void createBorderWidthBottom(int borderWith) {
		initBorderBottom();
		borderBottom.setWidth(borderWith);
		invalidate();
	}

	public void createBorderWidthLeft(int borderWith) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderWidthRightInternal(borderWith);
		} else {
			createBorderWidthLeftInternal(borderWith);
		}
	}

	private void createBorderWidthLeftInternal(int borderWith) {
		initBorderLeft();
		borderLeft.setWidth(borderWith);
		invalidate();
	}

	public void createBorderStyleTop(String style) {
		initBorderTop();
		borderTop.setStyle(style);
		invalidate();
	}

	public void createBorderDashSpacingTop(int dashSpacing) {
		initBorderTop();
		borderTop.setDashSpacing(dashSpacing);
		invalidate();
	}

	public void createBorderDashWidthTop(int dashWidth) {
		initBorderTop();
		borderTop.setDashWidth(dashWidth);
		invalidate();
	}

	public void createBorderStyleBottom(String style) {
		initBorderBottom();
		borderBottom.setStyle(style);
		invalidate();
	}

	public void createBorderDashSpacingBottom(int dashSpacing) {
		initBorderBottom();
		borderBottom.setDashSpacing(dashSpacing);
		invalidate();
	}

	public void createBorderDashWidthBottom(int dashWidth) {
		initBorderBottom();
		borderBottom.setDashWidth(dashWidth);
		invalidate();
	}

	public void createBorderStyleLeft(String style) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderStyleRightInternal(style);
		} else {
			createBorderStyleLeftInternal(style);
		}
	}

	private void createBorderStyleLeftInternal(String style) {
		initBorderLeft();
		borderLeft.setStyle(style);
		invalidate();
	}

	public void createBorderDashSpacingLeft(int dashSpacing) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderDashSpacingRightInternal(dashSpacing);
		} else {
			createBorderDashSpacingLeftInternal(dashSpacing);
		}
	}

	private void createBorderDashSpacingLeftInternal(int dashSpacing) {
		initBorderLeft();
		borderLeft.setDashSpacing(dashSpacing);
		invalidate();
	}

	public void createBorderDashWidthLeft(int dashWidth) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderDashWidthRightInternal(dashWidth);
		} else {			
			createBorderDashWidthLeftInternal(dashWidth);
		}
	}

	private void createBorderDashWidthLeftInternal(int dashWidth) {
		initBorderLeft();
		borderLeft.setDashWidth(dashWidth);
		invalidate();
	}

	public void createBorderStyleRight(String style) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderStyleLeftInternal(style);
		} else {
			createBorderStyleRightInternal(style);
		}
	}

	private void createBorderStyleRightInternal(String style) {
		initBorderRight();
		borderRight.setStyle(style);
		invalidate();
	}

	public void createBorderDashSpacingRight(int dashSpacing) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderDashSpacingLeftInternal(dashSpacing);
		} else {
			createBorderDashSpacingRightInternal(dashSpacing);
		}
	}

	private void createBorderDashSpacingRightInternal(int dashSpacing) {
		initBorderRight();
		borderRight.setDashSpacing(dashSpacing);
		invalidate();
	}

	public void createBorderDashWidthRight(int dashWidth) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderDashWidthLeftInternal(dashWidth);
		} else {
			createBorderDashWidthRightInternal(dashWidth);
		}
	}

	private void createBorderDashWidthRightInternal(int dashWidth) {
		initBorderRight();
		borderRight.setDashWidth(dashWidth);
		invalidate();
	}

	public void createBorderRadiusTopLeft(float radius) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderRadiusTopRightInternal(radius);
		} else {
			createBorderRadiusTopLeftInternal(radius);
		}
	}

	private void createBorderRadiusTopLeftInternal(float radius) {
		this.borderTopLeftRadius = radius;

		initBorderTop();
		initBorderLeft();
		borderTop.setTopLeftRadius(radius);
		borderLeft.setTopLeftRadius(radius);
		if (invalidate()) {
			createMask();
		}
	}

	public void createBorderRadiusTopRight(float radius) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderRadiusTopLeftInternal(radius);
		} else {
			createBorderRadiusTopRightInternal(radius);
		}
	}

	private void createBorderRadiusTopRightInternal(float radius) {
		this.borderTopRightRadius = radius;
		initBorderTop();
		initBorderRight();
		borderTop.setTopRightRadius(radius);
		borderRight.setTopRightRadius(radius);
		if (invalidate()) {
			createMask();
		}
	}

	public void createBorderRadiusBottomLeft(float radius) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderRadiusBottomRightInternal(radius);
		} else {
			createBorderRadiusBottomLeftInternal(radius);
		}
	}

	private void createBorderRadiusBottomLeftInternal(float radius) {
		this.borderBottomLeftRadius = radius;
		initBorderBottom();
		initBorderLeft();
		borderBottom.setBottomLeftRadius(radius);
		borderLeft.setBottomLeftRadius(radius);
		if (invalidate()) {
			createMask();
		}
	}

	public void createBorderRadiusBottomRight(float radius) {
		if (ViewImpl.isRTLLayout(widget)) {
			createBorderRadiusBottomLeftInternal(radius);
		} else {
			createBorderRadiusBottomRightInternal(radius);
		}
	}

	private void createBorderRadiusBottomRightInternal(float radius) {
		this.borderBottomRightRadius = radius;
		initBorderBottom();
		initBorderRight();
		borderBottom.setBottomRightRadius(radius);
		borderRight.setBottomRightRadius(radius);
		if (invalidate()) {
			createMask();
		}
	}
	
	public static class Arc {
		float left, top, right, bottom;
		int startAngle, sweepAngle;
		public Arc(float left, float top, float right, float bottom, int startAngle, int sweepAngle) {
			this.left = left;
			this.top = top;
			this.right = right;
			this.bottom = bottom;
			this.sweepAngle = sweepAngle;
			this.startAngle = startAngle;
		}
		
		public int getEndAngle() {
			return startAngle + sweepAngle;
		}
		
		public float getRadius() {
			return ((right - left) / 2f);
		}
		
		public float getWidth() {
			return right - left;
		}
		
		public float getHeight() {
			return bottom - top;
		}
		
		public float getMidPointX() {
			return left + ((right - left) / 2f);
		}
		
		public float getMidPointY() {
			return top + ((bottom - top)/2f);
		}
		
		public int getStartAngle() {
			return startAngle;
		}

	}

	public void createBorder(float x1, float y1, float x2, float y2, Object canvas, Object path, Object paint, Border border, String where) {
		reset(path, paint);
		
		Object borderColor = border.getColor();
		if (borderColor == null) {
			borderColor = defaultColor;
		}
		int width = border.getWidth();
		setColorAndWidth(path, paint, borderColor, width);

		switch (border.getStyle()) {
		case "dashed": {
			int defaultDashSpacing = (int) com.ashera.widget.PluginInvoker.convertDpToPixel("1dp");
			int defaultDashWidth = (int) com.ashera.widget.PluginInvoker.convertDpToPixel("3dp");
			int dashWidth = border.getDashWidth() == -1 ? defaultDashWidth : border.getDashWidth();
			int dashSpacing = border.getDashSpacing() == -1 ? defaultDashSpacing : border.getDashSpacing();
			setDashedEffect(path, paint, dashWidth, dashSpacing);
			break;
		}
		case "dotted": {
			int radius = (int) com.ashera.widget.PluginInvoker.convertDpToPixel("1dp");
			int defaultDashSpacing = (int) com.ashera.widget.PluginInvoker.convertDpToPixel("1dp");
			int dashSpacing = border.getDashSpacing() == -1 ? defaultDashSpacing : border.getDashSpacing();
			setDottedEffect(path, paint, radius, dashSpacing);
			break;
		}
		default:
			break;
		}

		boolean hasRadius = hasRadius(border);
		if (hasRadius) {
			createArc(x1, y1, x2, y2, border, path, where);
		} else {
			moveTo(path, x1, y1);
			quadTo(path, x1, y1, x2, y2);
		}
		
		drawPath(canvas, path, paint);
	}
	private void createArc(float x1, float y1, float x2, float y2, Border border, Object path, String where) {
		createArc(x1, y1, x2, y2, border, path, where, true);
	}
	private void createArc(float x1, float y1, float x2, float y2, Border border, Object path, String where, boolean partial) {
		if (border == null) {
			border = new Border();
		}
		
		switch (where) {
		case "left": {
			// x1 == x2
			float topleftRadius = border.getTopLeftRadius();
			float bottomleftRadius = border.getBottomLeftRadius();

			if (partial) {
				moveTo(path, x2, y2);
			}
			arcTo(path, new Arc(x2, y2 - 2 * bottomleftRadius, x2 + 2 * bottomleftRadius, y2, 90 + 45, 45));
			lineTo(path, x1, y1 + topleftRadius);
			arcTo(path, new Arc(x1, y1, x1 + 2 * topleftRadius, y1 + 2 * topleftRadius, 180, 45));

			break;
		}
		case "bottom": {
			// y1==y2
			float leftRadius = border.getBottomLeftRadius();
			float rightRadius = border.getBottomRightRadius();

			if (partial) {
				moveTo(path, x2, y2);
			}
			arcTo(path, new Arc(x2 - 2 * rightRadius, y2 - 2 * rightRadius, x2, y2, 45, 45));
			lineTo(path, x1 + leftRadius, y1);
			arcTo(path, new Arc(x1, y1 - 2 * leftRadius, x1 + 2 * leftRadius, y1, 90, 45));
			break;
		}

		case "right": {
			// x1==x2
			float topRightRadius = border.getTopRightRadius();
			float bottomRightRadius = border.getBottomRightRadius();

			if (partial) {
				moveTo(path, x1, y1);
			}
			arcTo(path, new Arc(x1 - 2 * topRightRadius, y1, x1, y1 + 2 * topRightRadius, 270 + 45, 45));
			lineTo(path, x2, y2 - bottomRightRadius);
			arcTo(path, new Arc(x2 - 2 * bottomRightRadius, y2 - 2 * bottomRightRadius, x2, y2, 0, 45));
			
			break;
		}
		case "top": {
			// y1 == y2
			float leftRadius = border.getTopLeftRadius();
			float rightRadius = border.getTopRightRadius();

			if (partial) {
				moveTo(path, x1, y1);
			}
			arcTo(path, new Arc(x1, y1, x1+ 2 * leftRadius,y1 + 2 * leftRadius, 180 + 45, 45));
			lineTo(path, x2 - rightRadius, y2);
			arcTo(path, new Arc(x2 - 2 * rightRadius, y2, x2, y2 + 2 * rightRadius, 270, 45));

			break;
		}
		default:
			break;
		}
	}

	private boolean hasRadius(Border border) {
		return border.getTopLeftRadius() > 0 || border.getTopRightRadius() > 0
				|| border.getBottomLeftRadius() > 0 || border.getBottomRightRadius() > 0;
	}
	
	private boolean isBorderNotPresent() {
		return borderTop == null && borderLeft == null && borderRight == null && borderBottom == null;
	}

	private void createBorderBottom(Object canvas, Object path, Object paint, int width, int height, int topOffset) {
		if (borderBottom != null && borderBottom.getWidth() > 0) {
			float offset = getOffset(borderBottom, "bottom");
			createBorder(0, height - offset, width, height - offset, canvas, path, paint, borderBottom, "bottom");
		}
	}

	private void createBorderRight(Object canvas, Object path, Object paint, int width, int height, int topOffset) {
		if (borderRight != null && borderRight.getWidth() > 0) {
			float offset = getOffset(borderRight, "right");
			createBorder(width - offset, 0, width - offset, height, canvas, path, paint, borderRight, "right");
		}
	}

	private void createBorderLeft(Object canvas, Object path, Object paint, int width, int height, int topOffset) {
		if (borderLeft != null && borderLeft.getWidth() > 0) {
			float offset = getOffset(borderLeft, "left");
			createBorder(offset, 0, offset, height, canvas, path, paint, borderLeft, "left");
		}
	}

	private void createBorderTop(Object canvas, Object path, Object paint, int width, int height, int topOffset) {
		if (borderTop != null && borderTop.getWidth() > 0) {
			float offset = getOffset(borderTop, "top");
			createBorder(0, topOffset + offset, width, topOffset + offset, canvas, path, paint, borderTop, "top");
		}
	}
	
	private float getOffset(Border border, String where) {
		float offset = (float) border.getWidth() * 0.5f;
		offset = adjustOffset(where, offset);
		return offset;
	}

	

	private boolean useCornerRadius() {
		boolean useCornerRadius = borderTopLeftRadius == borderTopRightRadius && borderBottomRightRadius == borderBottomLeftRadius && borderTopLeftRadius == borderBottomLeftRadius;
		return useCornerRadius;
	}
	
	private void createArcFullPath(Object path, View view) {
		createArc(0, 0, 0, view.getHeight(), borderLeft, path, "left", false);
        createArc(0, 0, view.getWidth(), 0, borderTop, path, "top", false);
        createArc(view.getWidth(), 0, view.getWidth(), view.getHeight(), borderRight, path, "right", false);
        createArc(0, view.getHeight(), view.getWidth(), view.getHeight(), borderBottom, path, "bottom", false);
	}

	private boolean invalidate() {
		boolean success = false;
		if (widget.isInitialised()) {
			nativeInvalidate(widget.asNativeWidget());

			success = true;
		}
		return success;
	}
	
	private boolean isNoClip() {
		boolean noClip = ((borderTopLeftRadius == borderTopRightRadius && borderBottomRightRadius == borderBottomLeftRadius && borderTopLeftRadius == borderBottomLeftRadius) && borderTopLeftRadius == 0);
		return noClip;
	}
	//end - body
	
	@Override
	public void initialized() {
	}
	
	public void execute(String method, Object... args) {
    	switch (method) {
			case "drawRect":
				drawRect(args[0]);
				break;
			case "setFrame":
				setFrame(args[0]);
				break;
    	}
    }
	
	public void createMask() {
	}

	private void setMaskLayer(Object cgRect, Object mypath) {
		if (isBorderNotPresent())
			return;

		boolean useCornerRadius = useCornerRadius();
		float topLeftRadius = 0;

		if (borderTop != null) {
			topLeftRadius = borderTop.getTopLeftRadius();
		}

		if (useCornerRadius) {
			if (isWrappedWidget) {
				setCornerRadiusOnSuperView(topLeftRadius);
			} else {
				setCornerRadiusOnView(topLeftRadius);
			}
			return;
		}

		View view = (View) widget.asWidget();
		createArcFullPath(mypath, view);
		closePath(mypath);
		createMaskLayer(mypath, isWrappedWidget);
	}



	public void drawRect(Object cgRect) {
		if (isBorderNotPresent())
			return;


        if (borderLeft != null) {
        	nativeCreateBorderLeft(borderLeft, cgRect);
        }
        
        if (borderRight != null) {
        	nativeCreateBorderRight(borderRight, cgRect);
        }            
        
        if (borderBottom != null) {
        	nativeCreateBorderBottom(borderBottom, cgRect);
		}
        
        if (borderTop != null) {   
        	nativeCreateBorderTop(borderTop, cgRect);
        }
	}
	
	public native void nativeCreateBorderLeft(Border borderLeft, Object wrapperRect) /*-[
		CGRect rect = ((CGRectWrapper*) wrapperRect).rect;
		CGPoint contentOffset = ((CGRectWrapper*) wrapperRect).contentOffset;
    	UIBezierPath * path = [UIBezierPath new];
  		[self createBorderLeftWithId:nil withId:path withId:nil withInt:rect.size.width withInt:rect.size.height + contentOffset.y withInt:0];
	]-*/;
	
	public native void nativeCreateBorderRight(Border borderRight, Object wrapperRect) /*-[
		CGRect rect = ((CGRectWrapper*) wrapperRect).rect;
		CGPoint contentOffset = ((CGRectWrapper*) wrapperRect).contentOffset;
    	UIBezierPath * path = [UIBezierPath new];
  		[self createBorderRightWithId:nil withId:path withId:nil withInt:rect.size.width withInt:rect.size.height + contentOffset.y withInt:0];
	]-*/;
	
	public native void nativeCreateBorderTop(Border borderTop, Object wrapperRect) /*-[
		CGRect rect = ((CGRectWrapper*) wrapperRect).rect;
		CGPoint contentOffset = ((CGRectWrapper*) wrapperRect).contentOffset;
    	UIBezierPath * path = [UIBezierPath new];
		[self createBorderTopWithId:nil withId:path withId:nil withInt:rect.size.width withInt:rect.size.height + contentOffset.y withInt:0];
	]-*/;
	
	public native void nativeCreateBorderBottom(Border borderBottom, Object wrapperRect) /*-[
		CGRect rect = ((CGRectWrapper*) wrapperRect).rect;
		CGPoint contentOffset = ((CGRectWrapper*) wrapperRect).contentOffset;
    	UIBezierPath * path = [UIBezierPath new];
		[self createBorderBottomWithId:nil withId:path withId:nil withInt:rect.size.width withInt:rect.size.height + contentOffset.y withInt:0];
	]-*/;	

	
	// native methods

	private void reset(Object path, Object paint) {
	}

	private native void setDefaultColor(BorderDecorator borderDecorator) /*-[
  		borderDecorator->defaultColor_ = [UIColor blackColor];
	]-*/;
	
	// draw and reset method
	private native void drawPath(Object canvas, Object mypath, Object paint) /*-[
	  	UIBezierPath * path = (UIBezierPath*) mypath;
		[path stroke];
	]-*/;

	private void setColorAndWidth(Object mypath, Object paint, Object borderColor, int width)  {
		if (borderColor instanceof r.android.content.res.ColorStateList) {
			r.android.content.res.ColorStateList colorStateList = (r.android.content.res.ColorStateList) borderColor;
			View view = (View) widget.asWidget();
			borderColor = colorStateList.getColorForState(view.getDrawableState(), r.android.graphics.Color.RED);
		}
		nativeSetColorAndWidth(mypath, paint, ViewImpl.getColor(borderColor), width);
	}

	private native void nativeSetColorAndWidth(Object mypath, Object paint, Object borderColor, int width) /*-[
    	UIBezierPath * path = (UIBezierPath*) mypath;
    	[path setLineWidth: width];
    	[((UIColor*)borderColor) setStroke];

	]-*/;

	private native void setDottedEffect(Object mypath, Object paint, int radius, int defaultDashSpacing) /*-[
	    UIBezierPath * path = (UIBezierPath*) mypath;
		//CGFloat dashes[] = { [border getDashWidth], [border getDashSpacing] };
      	//[path setLineDash:dashes count:2 phase:0];
	]-*/;


	private native void setDashedEffect(Object mypath, Object paint, int dashWidth, int dashSpacing) /*-[
    	UIBezierPath * path = (UIBezierPath*) mypath;
		CGFloat dashes[] = { dashWidth, dashSpacing};
  		[path setLineDash:dashes count:2 phase:0];
	]-*/;


    private native void nativeInvalidate(Object view) /*-[
    	[((UIView*)view) setNeedsDisplay];
	]-*/;

	private native void createMaskLayer(Object mypath, boolean isWrappedWidget) /*-[
	  	UIBezierPath * path = (UIBezierPath*) mypath;
	  	CAShapeLayer *maskLayer = [[CAShapeLayer alloc] init];
	  	maskLayer.path = path.CGPath;
	  
	  	if (isWrappedWidget) {
	  		((UIView*) self->view_).superview.layer.mask = maskLayer;
	  	} else {
	  		((UIView*) self->view_).layer.mask = maskLayer;
	  	}
	]-*/;

	private native void setCornerRadiusOnSuperView(float topLeftRadius) /*-[
		((UIView*) self->view_).superview.layer.cornerRadius = topLeftRadius;
		((UIView*) self->view_).superview.clipsToBounds = YES;
	]-*/;
	
	private native void setCornerRadiusOnView(float topLeftRadius) /*-[
		((UIView*) self->view_).layer.cornerRadius = topLeftRadius;
		((UIView*) self->view_).clipsToBounds = YES;
	]-*/;
	

	private native void setFrame(Object object) /*-[
	   	UIBezierPath * path = [UIBezierPath new];
    	[self setMaskLayerWithId:object withId:path];
	]-*/;
	
	// path methods
	private native void quadTo(Object mypath, float x1, float y1, float x2, float y2) /*-[
		UIBezierPath * path = (UIBezierPath*) mypath;
	  	[path addLineToPoint:CGPointMake(x2, y2)];
	]-*/;
	
	private native void moveTo(Object mypath, float x, float y)  /*-[
		UIBezierPath * path = (UIBezierPath*) mypath;
	 	[path moveToPoint:CGPointMake(x, y)];
	]-*/;
	
	private native void lineTo(Object mypath, float x, float y)  /*-[
		UIBezierPath * path = (UIBezierPath*) mypath;
	  	[path addLineToPoint:CGPointMake(x, y)];	
	]-*/;
	
	
	private native void arcTo(Object mypath, Arc arc) /*-[
		UIBezierPath * path = (UIBezierPath*) mypath;
		[path addArcWithCenter:CGPointMake([arc getMidPointX], [arc getMidPointY]) radius:[arc getRadius] startAngle:degreesToRadians([arc getStartAngle]) endAngle:degreesToRadians([arc getEndAngle]) clockwise:YES];
	]-*/;

	private native void closePath(Object mypath) /*-[
		UIBezierPath * path = (UIBezierPath*) mypath;
		[path closePath];
	]-*/;


	private void addCommandIfNeeded() {
	}
	
	private float adjustOffset(String where, float offset) {
		return offset;
	}


	@Override
	public void drawableStateChanged() {
		if (isBorderStateful(borderBottom) || isBorderStateful(borderTop) || isBorderStateful(borderLeft) || isBorderStateful(borderRight)) {
			nativeInvalidate(widget.asNativeWidget());
		}
	}

	private boolean isBorderStateful(Border border) {
		return border != null && border.getColor() != null && border.getColor() instanceof r.android.content.res.ColorStateList 
				&& ((r.android.content.res.ColorStateList) border.getColor()).isStateful();
	}
}
