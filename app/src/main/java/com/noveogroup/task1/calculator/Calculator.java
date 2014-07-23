package com.noveogroup.task1.calculator;

import java.util.Calendar;

public final class Calculator {
    private Calculator() {}

    public static int calculateAge(final int year, final int month, final int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        int age = calendar.get(Calendar.YEAR) - year - 1;
        if(calendar.get(Calendar.MONTH) >= month
           && calendar.get(Calendar.DAY_OF_MONTH) >= dayOfMonth) {
            ++age;
        }
        return age;
    }
}
