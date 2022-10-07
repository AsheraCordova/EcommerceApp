package com.ashera.core.attributedtext;

import com.ashera.attributedtext.AttributedString;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

public class AttributedStringImpl implements AttributedString{
	private SpannableString spannableString;
	private Context context;
	private String text;
	public AttributedStringImpl() {
	}

	@Override
	public String getText() {
		return this.text;
	}

	public AttributedStringImpl(String source, Context context) {
		this.context = context;
		this.text = source;
		spannableString = new SpannableString(source);
		
	}
	
	@Override
	public void applyUnderLine(int start, int end) {
		spannableString.setSpan(new UnderlineSpan(), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
	}

	@Override
	public Object get() {
		return spannableString;
	}

	@Override
	public void applyColor(Object color, int start, int end) {
		spannableString.setSpan(new ForegroundColorSpan((Integer) color), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		
	}

	@Override
	public void applyStrikeThrough(int start, int end) {
		spannableString.setSpan(new StrikethroughSpan(), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
	}

	@Override
	public void applyFont(Object typeFace, float size, int style, int start, int end) {
		size = ((com.ashera.core.MainActivity) context).getScaleFactor() * size;
		if (typeFace != null || style != 0) {
			spannableString.setSpan(new CustomTypefaceSpan((Typeface) typeFace, style), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
		if (size > 0) {
			spannableString.setSpan(new AbsoluteSizeSpan((int) size, false), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
	}

	@Override
	public void applyLineHeight(float height, int start, int end) {
		spannableString.setSpan(new HeightSpan((int) height), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);		
	}

	@Override
	public void applyTextAlign(String value, int start, int end) {
		AlignmentSpan alignmentSpan = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL);
	
		if (value.equals("center")) {
			alignmentSpan = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
		} else if (value.equals("right")) {
			alignmentSpan = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE);
		}

		spannableString.setSpan(alignmentSpan, start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);		
	}

	@Override
	public void applyBackgroundColor(Object objcolor, int start, int end) {
		spannableString.setSpan(new BackgroundColorSpan((Integer) objcolor) , start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);	
		
	}

	@Override
	public void applyVerticalAlign(String verticalAlign, int start, int end) {
		if (verticalAlign.equals("super")) {
			spannableString.setSpan(new SuperscriptSpan() , start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);	
		} else if (verticalAlign.equals("sub")) {
			spannableString.setSpan(new SubscriptSpan() , start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);	
		}
	}

	@Override
	public void applyUrl(String href, Object color, int start, int end) {
		spannableString.setSpan(new URLSpan(href) , start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);	
	}

	@Override
	public void applyImg(Object image, int start, int end) {
		Drawable drawable = (Drawable) image;
		int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, width > 0 ? width : 0, height > 0 ? height : 0);
		spannableString.setSpan(new ImageSpan(drawable), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE); 
	}

	@Override
	public void applyBullet(int indent, int spacing, int start, int end) {
		
		spannableString.setSpan(new LeadingMarginSpan.Standard(indent), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE); 
		spannableString.setSpan(new BulletSpan(spacing), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE); 
	}

	@Override
	public void init(int start, int end) {
	}
}
