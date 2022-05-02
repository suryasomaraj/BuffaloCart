package com.buffalocart.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDateUtility {
    public String currentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate=dateOnly.format(calendar.getTime());
        return currentDate;
    }
}
