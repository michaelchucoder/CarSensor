package com.michael.carsensor.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhxh on 2017/12/5.
 */

public class TimeHelper {

    public static Date getDate(Long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String d = format.format(timeStamp);

        Date date = null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;

    }

    public static String getMonthDateStr(Long timeStamp) {

        Date date = getDate(timeStamp);

        if (date != null) {

            String strMonth = (date.getMonth() + 1) < 10 ? "0" + (date.getMonth() + 1) + "" : (date.getMonth() + 1) + "";
            String strDay = (date.getDate()) < 10 ? "0" + (date.getDate()) + "" : (date.getDate()) + "";
            String strHour = date.getHours() < 10 ? "0" + date.getHours() + "" : date.getHours() + "";
            String strMinute = date.getMinutes() < 10 ? "0" + date.getMinutes() + "" : date.getMinutes() + "";
            String strSecond = date.getSeconds() < 10 ? "0" + date.getSeconds() + "" : date.getSeconds() + "";
            return strMonth + "-" + strDay + " " + strHour + ":" + strMinute + ":" + strSecond;

        } else return "--";

    }
}
