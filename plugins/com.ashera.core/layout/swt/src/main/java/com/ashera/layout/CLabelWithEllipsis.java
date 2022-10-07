package com.ashera.layout;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Composite;

public class CLabelWithEllipsis extends org.eclipse.swt.custom.CLabel {
	private static final String ELLIPSIS = "...";
	private static int DRAW_FLAGS = org.eclipse.swt.SWT.DRAW_MNEMONIC | org.eclipse.swt.SWT.DRAW_TAB
			| org.eclipse.swt.SWT.DRAW_TRANSPARENT | org.eclipse.swt.SWT.DRAW_DELIMITER;

	public CLabelWithEllipsis(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected java.lang.String shortenText(org.eclipse.swt.graphics.GC gc, java.lang.String t, int width) {
		Object data = getData("ellipsize");
		int ellipsize = 0;
		if (data != null) {
			ellipsize = (int) data;
		}
		
		if (com.ashera.layout.ViewImpl.isRTLLayout()) {
			switch (ellipsize) {
			case 0x03:/*start*/
				return shortenMyText(gc, t, width, false);
			case 0x01:/*end*/
				return shortenMyText(gc, t, width, true);
			case 0x02:/*middle*/
				return super.shortenText(gc, t, width);
			default:
				return t;
			}
		} else {
			switch (ellipsize) {
			case 0x01:/*start*/
				return shortenMyText(gc, t, width, false);
			case 0x03:/*end*/
				return shortenMyText(gc, t, width, true);
			case 0x02:/*middle*/
				return super.shortenText(gc, t, width);
			default:
				return t;
			}
		}
	}

	private String shortenMyText(GC gc, String t, int width, boolean end) {
		if (t == null)
			return null;
		int w = gc.textExtent(ELLIPSIS, DRAW_FLAGS).x;
		if (width <= w)
			return t;
		int l = t.length();
		int max = l / 2;
		int min = 0;
		int mid = (max + min) / 2 - 1;
		if (mid <= 0)
			return t;

		String origStr = t;
		if (!end) {
			StringBuilder stringBuilder = new StringBuilder(t);
			// append a string into StringBuilder input1
			t = stringBuilder.reverse().toString();
		}

		TextLayout layout = new TextLayout(getDisplay());
		layout.setText(t);
		mid = validateOffset(layout, mid);
		while (min < mid && mid < max) {
			String s1 = t.substring(0, max);
			int l1 = gc.textExtent(s1, DRAW_FLAGS).x;

			if (l1 + w > width) {
				max = mid;
				mid = validateOffset(layout, (max + min) / 2);
			} else if (l1 + w < width) {
				min = max;
				max = max * 2;
				mid = validateOffset(layout, (max + min) / 2);
			} else {
				min = max;
			}
		}

		String s1 = t.substring(0, max);
		int l1 = gc.textExtent(s1, DRAW_FLAGS).x;
		while (l1 + w > width) {
			max--;
			s1 = t.substring(0, max);
			l1 = gc.textExtent(s1, DRAW_FLAGS).x;
		}

		String result = end ? t.substring(0, max) + ELLIPSIS
				: ELLIPSIS + origStr.substring(origStr.length() - max, origStr.length());
		layout.dispose();

		return result;
	}

	private int validateOffset(TextLayout layout, int offset) {
		int nextOffset = layout.getNextOffset(offset, org.eclipse.swt.SWT.MOVEMENT_CLUSTER);
		if (nextOffset != offset)
			return layout.getPreviousOffset(nextOffset, org.eclipse.swt.SWT.MOVEMENT_CLUSTER);
		return offset;
	}
}