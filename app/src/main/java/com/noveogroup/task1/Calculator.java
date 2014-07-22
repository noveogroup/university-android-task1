package com.noveogroup.task1;

import android.widget.DatePicker;

import java.util.Calendar;

public class Calculator {
    public static int calculateAge(DatePicker datePicker) {
        Calendar calendar = Calendar.getInstance();
        int age = calendar.get(Calendar.YEAR) - datePicker.getYear() - 1;
        if(calendar.get(Calendar.MONTH) >= datePicker.getMonth()
           && calendar.get(Calendar.DAY_OF_MONTH) >= datePicker.getDayOfMonth()) {
            ++age;
        }
        return age;
    }
}
