package com.ashera.layout;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;

public class Link extends android.widget.TextView {
	public Link(Context context) {
		super(context);
		initView();
	}

	public Link(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public Link(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	public Link(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initView();
	}
	
	private void initView() {
		setPaintFlags(getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
	}
}
