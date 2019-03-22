package com.module.user.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtil {
    public static String FORMAT_MONTH_DAY = "MM-dd";

    public static String FORMAT_SHORT = "yyyy-MM-dd";

    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    public static String FORMAT_LONG_NEW = "yyyy-MM-dd HH:mm";

    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    public static String FORMAT_SHORT_CN_MINI = "MM月dd日 HH:mm";

    public static String FORMAT_SHORT_CN = "yyyy年MM月dd日";

    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    public static String FORMAT_SPEFULL_CN = "yyyy年MM月dd日  HH:mm";
    public static String FORMAT_SHORT_SPE = "yyyyMMdd";
    public static String FORMAT_SHORT_SPE_ = "HH:mm";

    public static String TIMEZONE = "Asia/Shanghai";

    public static String getDatePattern() {
        return FORMAT_LONG;
    }

    public static String getNow() {
        return format(new Date());
    }

    public static String getNow(String format) {
        return format(new Date(), format);
    }

    public static TimeZone getDefTimeZone() {
        return TimeZone.getTimeZone(TIMEZONE);
    }

    public static String format4Phone(Date date) {
        long timeDiff = getCurTime() - date.getTime();
        if (timeDiff < 60000L)
            return "刚刚";
        if (timeDiff < 3600000L)
            return timeDiff / 60000L + "分钟前";

        if (timeDiff < 86400000L)
            return timeDiff / 3600000L + "小时前";

        if (new Date().getYear() == date.getYear()) {

            return format(date, FORMAT_MONTH_DAY);
        }

        return format(date, FORMAT_SHORT);
    }

    public static String format(Date date) {

        return format(date, getDatePattern());
    }

    public static String format(Date date, String pattern) {

        String returnValue = "";

        if (date != null) {

            SimpleDateFormat df = new SimpleDateFormat(pattern);

            df.setTimeZone(getDefTimeZone());
            returnValue = df.format(date);
        }
        return returnValue;
    }

    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        df.setTimeZone(getDefTimeZone());
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertTimeToString(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(getDefTimeZone());
        return sdf.format(Long.valueOf(time));
    }

    public static Calendar getBeforeDay(Calendar cl) {
        int day = cl.get(5);
        cl.set(5, day - 1);
        return cl;
    }

    public static Calendar getAfterDay(Calendar cl) {
        int day = cl.get(5);
        cl.set(5, day + 1);
        return cl;
    }

    public static String getWeek(Calendar c) {
        String Week = "";
        if (c.get(7) == 1) {
            Week = Week + "周天";
        }
        if (c.get(7) == 2) {
            Week = Week + "周一";
        }
        if (c.get(7) == 3) {
            Week = Week + "周二";
        }
        if (c.get(7) == 4) {
            Week = Week + "周三";
        }
        if (c.get(7) == 5) {
            Week = Week + "周四";
        }
        if (c.get(7) == 6) {
            Week = Week + "周五";
        }
        if (c.get(7) == 7) {
            Week = Week + "周六";
        }
        return Week;
    }

    public static Date formatStr2Date(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_LONG);
        sdf.setTimeZone(getDefTimeZone());
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date, String formatType) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatType);
        sdf.setTimeZone(getDefTimeZone());
        return sdf.format(date);
    }

    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType);
        String strTime = dateToString(date, formatType);
        return strTime;
    }

    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        formatter.setTimeZone(getDefTimeZone());
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime);
        String sDateTime = dateToString(dateOld, formatType);
        Date date = stringToDate(sDateTime, formatType);
        return date;
    }

    public static long stringToLong(String strTime, String formatType) {
        Date date = null;
        try {
            date = stringToDate(strTime, formatType);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            return 0L;
        }
        long currentTime = dateToLong(date);
        return currentTime;
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static long getCurTime() {
        Calendar c = Calendar.getInstance(getDefTimeZone());
        return c.getTimeInMillis();
    }
}