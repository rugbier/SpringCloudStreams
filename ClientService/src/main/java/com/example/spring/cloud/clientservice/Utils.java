package com.example.spring.cloud.clientservice;

import java.util.Calendar;
import java.util.Date;

public class Utils {

    public static Date getDate(long timeMillis){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeMillis);
        return c.getTime();
    }

}
