package com.ashera.core.attributedtext;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/**
 * Class to load custom typeface fonts.
 */
public class CustomTypefaceSpan extends MetricAffectingSpan {
    private Typeface tf;
    private int style;

    /**
     * @param family The font family for this typeface.
     * @param start  Start.
     * @param end    End.
     * @param context Context.
     */
    public CustomTypefaceSpan(Typeface typeface, int style) {
        tf = typeface;
        this.style = style;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint);
    }

    /**
     * @param paint paint.
     * @param family    font family for which the font needs to be loaded.
     */
    private void apply(Paint paint) {
        if (isSystemFont(tf)) {
            if ((style & Typeface.BOLD) != 0) {
                paint.setFakeBoldText(true);
            }

            if ((style & Typeface.ITALIC) != 0) {
                paint.setTextSkewX(-0.25f);
            }

            paint.setTypeface(tf);
        } else {
        	paint.setTypeface(tf);
        }
    }

	private boolean isSystemFont(Typeface tf) {
		return tf == Typeface.DEFAULT || tf == Typeface.SERIF || tf == Typeface.SANS_SERIF || tf == Typeface.MONOSPACE;
	}
}
