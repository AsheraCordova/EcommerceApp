package com.ashera.layout.filter;

public class FilterSolver {
	private RGBColor target;
	private HSLColor targetHSL;
	private RGBColor reusedColor;

	public FilterSolver(String color) {
		this(hex2Rgb(color));
	}
	public FilterSolver(RGBColor target) {
		this.target = target;
		this.targetHSL = target.hsl();
		this.reusedColor = new RGBColor(0, 0, 0);
	}

	public String solve() {
		Result result = this.solveNarrow(this.solveWide());
		String filter = this.css(result.values);
		return filter;
	}

	class Result {
		double loss = Double.MAX_VALUE;
		public double[] values;

		public Result(double loss, double[] values) {
			super();
			this.loss = loss;
			this.values = values;
		}

		public Result() {
		}
	}

	public Result solveWide() {
		double A = 5;
		double c = 15;
		double[] a = new double[] { 60, 180, 18000, 600, 1.2, 1.2 };

		Result best = new Result();
		for (int i = 0; best.loss > 25 && i < 3; i++) {
			double[] initial = new double[] { 50, 20, 3750, 50, 100, 100 };
			Result result = this.spsa(A, a, c, initial, 1000);
			if (result.loss < best.loss) {
				best = result;
			}
		}
		return best;
	}

	public Result solveNarrow(Result wide) {
		double A = wide.loss;
		double c = 2;
		double A1 = A + 1;
		double[] a = new double[] { 0.25 * A1, 0.25 * A1, A1, 0.25 * A1, 0.2 * A1, 0.2 * A1 };
		return this.spsa(A, a, c, wide.values, 500);
	}

	Result spsa(double A, double[] a, double c, double[] values, int iters) {
		double alpha = 1;
		double gamma = 0.16666666666666666;

		double[] best = null;
		double bestLoss = Float.MAX_VALUE;
		double[] deltas = new double[6];
		double[] highArgs = new double[6];
		double[] lowArgs = new double[6];

		for (int k = 0; k < iters; k++) {
			double ck = c / Math.pow(k + 1, gamma);
			for (int i = 0; i < 6; i++) {
				deltas[i] = Math.random() > 0.5 ? 1 : -1;
				highArgs[i] = values[i] + ck * deltas[i];
				lowArgs[i] = values[i] - ck * deltas[i];
			}

			double lossDiff = this.loss(highArgs) - this.loss(lowArgs);
			for (int i = 0; i < 6; i++) {
				double g = lossDiff / (2 * ck) * deltas[i];
				double ak = a[i] / Math.pow(A + k + 1, alpha);
				values[i] = fix(values[i] - ak * g, i);
			}

			double loss = this.loss(values);
			if (loss < bestLoss) {
				best = values.clone();
				bestLoss = loss;
			}
		}
		return new Result(bestLoss, best);

	}

	double fix(double value, int idx) {
		double max = 100;
		if (idx == 2 /* saturate */) {
			max = 7500;
		} else if (idx == 4 /* brightness */ || idx == 5 /* contrast */) {
			max = 200;
		}

		if (idx == 3 /* hue-rotate */) {
			if (value > max) {
				value %= max;
			} else if (value < 0) {
				value = max + value % max;
			}
		} else if (value < 0) {
			value = 0;
		} else if (value > max) {
			value = max;
		}
		return value;
	}

	double loss(double[] filters) {
		// Argument is array of percentages.
		RGBColor color = this.reusedColor;
		color.set(0, 0, 0);

		color.invert(filters[0] / 100);
		color.sepia(filters[1] / 100);
		color.saturate(filters[2] / 100);
		color.hueRotate(filters[3] * 3.6);
		color.brightness(filters[4] / 100);
		color.contrast(filters[5] / 100);

		HSLColor colorHSL = color.hsl();
		return (Math.abs(color.r - this.target.r) + Math.abs(color.g - this.target.g)
				+ Math.abs(color.b - this.target.b) + Math.abs(colorHSL.h - this.targetHSL.h)
				+ Math.abs(colorHSL.s - this.targetHSL.s) + Math.abs(colorHSL.l - this.targetHSL.l));
	}

	String fmt(double[] filters, int idx, double multiplier) {
		return ((int) Math.round(filters[idx] * multiplier)) +"";
	}

	String css(double[] filters) {
		return "brightness(0) saturate(100%) invert(#0%) sepia(#1%) saturate(#2%) hue-rotate(#3deg) brightness(#4%) contrast(#5%)"
					.replace("#0", fmt(filters, 0, 1))
					.replace("#1", fmt(filters, 1, 1))
					.replace("#2", fmt(filters, 2, 1))
					.replace("#3", fmt(filters, 3, 3.6))
					.replace("#4", fmt(filters, 4, 1))
					.replace("#5", fmt(filters, 5, 1));
	}

	private static RGBColor hex2Rgb(String colorStr) {
		return new RGBColor(Integer.valueOf(colorStr.substring(1, 3), 16),
				Integer.valueOf(colorStr.substring(3, 5), 16), Integer.valueOf(colorStr.substring(5, 7), 16));
	}
}