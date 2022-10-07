package com.ashera.core.attributedtext;

import java.util.Map;

import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

import com.ashera.core.IFragment;

public class AttributedStringImpl implements com.ashera.attributedtext.AttributedString {
	private IFragment fragment;
	private  String text;
	private Map<String, StyleRange> styleRanges; 
	public AttributedStringImpl(IFragment fragment, String text) {
		this.fragment = fragment;
		this.text = text;
		styleRanges = new java.util.HashMap<>();
	}
	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public Object get() {
		return styleRanges.values();
	}

	@Override
	public void init(int start, int end) {
		String key = start + "_" + end;
		if (!styleRanges.containsKey(key)) {
			StyleRange styleRange = new StyleRange();
			styleRange.start = start;
			styleRange.length = end - start;
			styleRanges.put(key, styleRange);
		}
	}

	@Override
	public void applyUnderLine(int start, int end) {
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
		styleRange.underline = true;
	}

	@Override
	public void applyColor(Object color, int start, int end) {
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
		styleRange.foreground = (Color) color;
	}

	@Override
	public void applyStrikeThrough(int start, int end) {
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
		styleRange.strikeout = true;
	}
	
	@Override
	public void applyFont(Object objValue, float textSize, int style, int start, int end) {
		
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
		Map<String, com.ashera.model.FontDescriptor> fontDescriptors = (Map<String, com.ashera.model.FontDescriptor>) objValue;
        
		if (fontDescriptors != null) {
	        String weight = "400";
	        if ((style & 0x1) != 0) {
	            weight = "700";
	        }
	        String fontStyle = "normal";
	        if ((style & 0x2) != 0) {
	            fontStyle = "italic";
	        }
	        textSize = fragment.getRootActivity().getScaleFactor() * textSize;
	        com.ashera.model.FontDescriptor fontDescriptor = fontDescriptors.get(fontStyle + "_" + weight);
	        final org.eclipse.swt.graphics.Font newFont = new org.eclipse.swt.graphics.Font(Display.getDefault(), fontDescriptor.getName(), (int) textSize, fontDescriptor.getStyle());
	        styleRange.font = newFont;
		}
	}

	@Override
	public void applyBackgroundColor(Object color, int start, int end) {
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
		styleRange.background = (Color) color;
	}
	
	@Override
	public void applyTextAlign(String value, int start, int end) {
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
		
		int style = org.eclipse.swt.SWT.LEFT;
		if (value.equals("center")) {
			style = org.eclipse.swt.SWT.CENTER;	
		}
		
		if (value.equals("right")) {
			style = org.eclipse.swt.SWT.RIGHT;	
		}
		Map<String, Object> data = getData(styleRange);
		data.put("lineAlignment", style);
		styleRange.data = data;
	}

	private Map<String, Object> getData(StyleRange styleRange) {
		Map<String, Object> data = (Map<String, Object>)styleRange.data;
		if (data == null) {
			data = new java.util.HashMap<>();
		}
		return data;
	}

	@Override
	public void applyLineHeight(float height, int start, int end) {

	}

	@Override
	public void applyVerticalAlign(String verticalAlign, int start, int end) {
//		String key = start + "_" + end;
//		StyleRange styleRange = styleRanges.get(key);
//		styleRange.rise = 5;
	}

	@Override
	public void applyUrl(String href, Object color, int start, int end) {
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
		styleRange.underline = true;
		styleRange.underlineStyle = org.eclipse.swt.SWT.UNDERLINE_LINK;
		
		if (color != null) {
			styleRange.underlineColor = (Color) color;
			styleRange.foreground = (Color) color;
		}
	}

	@Override
	public void applyImg(Object image, int start, int end) {
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
	    Image swtImage = (Image)((r.android.graphics.drawable.Drawable)image).getDrawable();
	    styleRange.metrics = new GlyphMetrics(swtImage.getImageData().height - 5, 0, swtImage.getImageData().width);
	    Map<String, Object> data = getData(styleRange);
	    data.put("image", swtImage);
	    styleRange.data = data;
	}

	@Override
	public void applyBullet(int indent, int spacing, int start, int end) {
		String key = start + "_" + end;
		StyleRange styleRange = styleRanges.get(key);
		Map<String, Object> data = getData(styleRange);
		StyleRange glyphMetricsRange = new StyleRange();
		glyphMetricsRange.metrics = new GlyphMetrics(0, 0, spacing);
		Bullet bullet = new Bullet(glyphMetricsRange);
		data.put("bullet", bullet);
		styleRange.data = data;
	}
}
