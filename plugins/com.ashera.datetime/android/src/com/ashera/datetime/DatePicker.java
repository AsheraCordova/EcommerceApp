package com.ashera.datetime;

import android.content.Context;
import android.util.AttributeSet;

public class DatePicker extends android.widget.FrameLayout {

	public DatePicker(Context context) {
		super(context);
		initView();
	}

	public DatePicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public DatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	public DatePicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initView();
	}

	private void initView() {
		inflate(getContext(), getResources().getIdentifier("datepicker", "layout", getContext().getPackageName()), this);
	}
}
