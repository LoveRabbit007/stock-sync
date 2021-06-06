package com.jing.hang.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Since: 2020/3/19 11:07
 * @Description:
 */
public final class DateHandUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

    /**
     * @return
     */
    public static DateFormat getDateFormat() {
        DateFormat df = threadLocal.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_FORMAT);
            threadLocal.set(df);
        }
        return df;
    }

    /**
     * @param date date
     * @return
     * @throws ParseException
     */
    public static String formatDate(Date date) {
        return getDateFormat().format(date);
    }


    /**
     * @param strDate strDate
     * @return
     * @throws ParseException
     */
    public static Date parse(String strDate) {
        Date date = null;
        try {
            date = getDateFormat().parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 时间叠加工具
     *
     * @param calendar calendar
     * @param variate  variate
     * @return
     */

    public static Date plusTime(Calendar calendarDate, int calendar, int variate) {
        calendarDate.add(calendar, -variate);
        return calendarDate.getTime();

    }
}
