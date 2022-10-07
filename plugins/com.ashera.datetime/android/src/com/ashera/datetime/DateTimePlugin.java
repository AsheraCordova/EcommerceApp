package com.ashera.datetime;

import com.ashera.widget.WidgetFactory;

public class DateTimePlugin  {
    public static void initPlugin() {
    	//start - widgets
        WidgetFactory.register(new com.ashera.datetime.DatePickerImpl());
        WidgetFactory.register(new com.ashera.datetime.TimePickerImpl());
        //end - widgets
    }
}
