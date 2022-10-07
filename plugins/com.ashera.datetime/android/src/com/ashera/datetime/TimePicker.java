package com.ashera.datetime;

import android.content.Context;
import android.util.AttributeSet;

public class TimePicker extends android.widget.FrameLayout {

	public TimePicker(Context context) {
		super(context);
		initView();
	}

	public TimePicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}
	
	public TimePicker(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	public TimePicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initView();
	}
	private void initView() {
		inflate(getContext(), getResources().getIdentifier("timepicker", "layout", getContext().getPackageName()), this);
	}
}
