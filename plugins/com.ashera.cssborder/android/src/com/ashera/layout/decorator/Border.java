package com.ashera.layout.decorator;

public class Border {
	//start - body
	private Object color;
	private String style = "solid";
	private int width;
	private int dashWidth = -1;
	private int dashSpacing = -1;
	
	private float topLeftRadius = 0;
	private float topRightRadius = 0;
	private float bottomLeftRadius = 0;
	private float bottomRightRadius = 0;


	public float getTopLeftRadius() {
		return topLeftRadius;
	}

	public void setTopLeftRadius(float topLeftRadius) {
		this.topLeftRadius = topLeftRadius;
	}

	public float getTopRightRadius() {
		return topRightRadius;
	}

	public void setTopRightRadius(float topRightRadius) {
		this.topRightRadius = topRightRadius;
	}

	public float getBottomLeftRadius() {
		return bottomLeftRadius;
	}

	public void setBottomLeftRadius(float bottomLeftRadius) {
		this.bottomLeftRadius = bottomLeftRadius;
	}

	public float getBottomRightRadius() {
		return bottomRightRadius;
	}

	public void setBottomRightRadius(float bottomRightRadius) {
		this.bottomRightRadius = bottomRightRadius;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Object getColor() {
		return color;
	}

	public void setColor(Object color) {
		this.color = color;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getDashSpacing() {
		return dashSpacing;
	}

	public void setDashSpacing(int dashSpacing) {
		this.dashSpacing = dashSpacing;
	}

	public int getDashWidth() {
		return dashWidth;
	}

	public void setDashWidth(int dashWidth) {
		this.dashWidth = dashWidth;
	}
	//end - body

}
