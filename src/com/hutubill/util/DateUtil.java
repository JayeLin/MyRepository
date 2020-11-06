package com.hutubill.util;


import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 21:27 2018/4/11
 * @Modify By:
 */
public class DateUtil {
    static long millisecondsOfOneDay = 1000*60*60*24;

    public static java.sql.Date util2sql(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * @Description: get the time of today, and set the hour,
     *                  minutes, second, millseconds to zero.
     *                  because the date obtained through the date
     *                  control is the same as the number of seconds
     *                  and milliseconds
     *@return
     */
    public static Date today() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @Description: Get the beginning of the month.
     *          Use Calendar for the first day of the month.
     *          In the statistics of consumption list information,
     *          to view the consumption data of this month,
     *          in fact, from the database to the data from the
     *          first day of the month to the last day to detect,
     *          and then simple statistics, so you need to obtain
     *          the first day of the month Methods.
     *
     *@return
     */
    public static Date monthBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE, 1);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * @Description: Get the end of the month.
     *@return
     */
    public static  Date monthEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONDAY, 1);
        calendar.set(Calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * @Description: Get the number of days in this month.
     *@return
     */
    public static int thisMonthTotalDay() {
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();

        return (int) (((lastDayMilliSeconds - firstDayMilliSeconds)/millisecondsOfOneDay) + 1);
    }

    /**
     * @Description: Get the remaining days of the month
     *@return
     */
    public static int thisMonthLeftDay() {
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        return (int) (((lastDayMilliSeconds - toDayMilliSeconds)/millisecondsOfOneDay) + 1);
    }

    public static void main(String[] args){
        System.out.println(DateUtil.today());
        System.out.println(DateUtil.monthBegin());
        System.out.println(DateUtil.monthEnd());
        System.out.println(thisMonthLeftDay());
        System.out.println(thisMonthTotalDay());
    }
}
