package com.ashera.layout.filter;

public class RGBColor {
	public double r;
	public double g;
	public double b;

	public RGBColor(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public String toString() {
		return String.format("rgb(%d, %d, %d)", Math.round(this.r));
	}

	private double clamp(double value) {
		if (value > 255) {
			value = 255;
		} else if (value < 0) {
			value = 0;
		}
		return value;
	}

	public void set(int r, int g, int b) {
		this.r = this.clamp(r);
		this.g = this.clamp(g);
		this.b = this.clamp(b);
	}

	private void multiply(double[] matrix) {
		double newR = this.clamp(this.r * matrix[0] + this.g * matrix[1] + this.b * matrix[2]);
		double newG = this.clamp(this.r * matrix[3] + this.g * matrix[4] + this.b * matrix[5]);
		double newB = this.clamp(this.r * matrix[6] + this.g * matrix[7] + this.b * matrix[8]);
		this.r = newR;
		this.g = newG;
		this.b = newB;
	}

	public void hueRotate(double angle) {
		angle = angle / 180 * Math.PI;
		double sin = Math.sin(angle);
		double cos = Math.cos(angle);

		this.multiply(new double[] { 0.213 + cos * 0.787 - sin * 0.213, 0.715 - cos * 0.715 - sin * 0.715,
				0.072 - cos * 0.072 + sin * 0.928, 0.213 - cos * 0.213 + sin * 0.143, 0.715 + cos * 0.285 + sin * 0.140,
				0.072 - cos * 0.072 - sin * 0.283, 0.213 - cos * 0.213 - sin * 0.787, 0.715 - cos * 0.715 + sin * 0.715,
				0.072 + cos * 0.928 + sin * 0.072, });
	}

	public void grayscale(double value) {
		this.multiply(new double[] { 0.2126 + 0.7874 * (1 - value), 0.7152 - 0.7152 * (1 - value),
				0.0722 - 0.0722 * (1 - value), 0.2126 - 0.2126 * (1 - value), 0.7152 + 0.2848 * (1 - value),
				0.0722 - 0.0722 * (1 - value), 0.2126 - 0.2126 * (1 - value), 0.7152 - 0.7152 * (1 - value),
				0.0722 + 0.9278 * (1 - value), });
	}

	public void sepia(double value) {
		this.multiply(
				new double[] { 0.393 + 0.607 * (1 - value), 0.769 - 0.769 * (1 - value), 0.189 - 0.189 * (1 - value),
						0.349 - 0.349 * (1 - value), 0.686 + 0.314 * (1 - value), 0.168 - 0.168 * (1 - value),
						0.272 - 0.272 * (1 - value), 0.534 - 0.534 * (1 - value), 0.131 + 0.869 * (1 - value), });
	}

	public void saturate(double value) {
		this.multiply(new double[] { 0.213 + 0.787 * value, 0.715 - 0.715 * value, 0.072 - 0.072 * value,
				0.213 - 0.213 * value, 0.715 + 0.285 * value, 0.072 - 0.072 * value, 0.213 - 0.213 * value,
				0.715 - 0.715 * value, 0.072 + 0.928 * value, });
	}

	public void brightness(double value) {
		this.linear(value, 0);
	}

	public void contrast(double value) {
		this.linear(value, -(0.5 * value) + 0.5);
	}

	public void linear(double slope, double intercept) {
		this.r = this.clamp(this.r * slope + intercept * 255);
		this.g = this.clamp(this.g * slope + intercept * 255);
		this.b = this.clamp(this.b * slope + intercept * 255);
	}

	public void invert(double value) {
		this.r = this.clamp((value + this.r / 255 * (1 - 2 * value)) * 255);
		this.g = this.clamp((value + this.g / 255 * (1 - 2 * value)) * 255);
		this.b = this.clamp((value + this.b / 255 * (1 - 2 * value)) * 255);
	}

	HSLColor hsl() {
		// Code taken from https://stackoverflow.com/a/9493060/2688027, licensed under
		// CC BY-SA.
		double r = this.r / 255;
		double g = this.g / 255;
		double b = this.b / 255;
		double max = Math.max(Math.max(r, g), b);
		double min = Math.min(Math.min(r, g), b);
		double h, s, l = (max + min) / 2;

		if (max == min) {
			h = s = 0;
		} else {
			double d = max - min;
			s = l > 0.5 ? d / (2 - max - min) : d / (max + min);
			if (max == r) {
				h = (g - b) / d + (g < b ? 6 : 0);
			} else if (max == g) {
				h = (b - r) / d + 2;
			} else {
				h = (r - g) / d + 4;
			}
			h /= 6;
		}

		return new HSLColor(h * 100, s * 100, l * 100);
	}

}
