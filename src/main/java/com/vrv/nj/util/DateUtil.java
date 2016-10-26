package com.vrv.nj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月23日]
 * @category 时间工具类
 */
public class DateUtil
{
    /**
     * <p>
     * pattern:yyyy-MM-dd
     * </p>
     */
    public static final String YYYYMMDD = "yyyyMMdd";
    
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    
    /**
     * <p>
     * pattern:yyyy-MM-dd HH:mm:ss
     * </p>
     */
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    
    public DateUtil()
    {
        super();
    }
    
    /**
     * <p>
     * 按照指定的格式，格式化日期
     * </p>
     * 
     * <pre>
     *  pattern:"yyyy-MM-dd" -> "2016-08-24"
     *  pattern:"yyyy-MM-dd HH:mm:ss" -> "2016-08-24 18:00:00"
     *  pattern:"yyyyMMdd" -> "20160824"
     *  pattern:"yyyyMMddHHmmss" -> "20160824180000"
     * </pre>
     * 
     * @param date 需要格式化的日期
     * @param pattern 模式
     * @return <code>String</code> 返回对应日期字符串
     */
    public static String date2String(Date date, String pattern)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    
    /**
     * <p>
     * 字符串类型日期转成Date类型日期
     * </p>
     * 
     * @param source 需要转换的字符串型日期
     * @param pattern 转换的模式
     * @return <code>Date</code> 返回Date型日期
     */
    public static Date string2Date(String source, String pattern)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try
        {
            date = sdf.parse(source);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * <p>
     * String类型日期转换成Date的指定格式日期
     * </p>
     * 
     * @param source 转换的字符串日期
     * @return <code>Date</code> 返回"yyyyMMdd"格式的Date类型日期
     */
    public static Date format2YYYYMMDD(String source)
    {
        return DateUtil.string2Date(source, YYYYMMDD);
    }
    
    /**
     * <p>
     * String类型日期转换成Date类型的指定模式的日期
     * </p>
     * 
     * @param source 需要格式化字符串日期
     * @return <code>Date</code> 转换成"yyyy-MM-dd HH:mm:ss"型日期
     */
    public static Date format2YYYYMMDDHHMMSS(String source)
    {
        return DateUtil.string2Date(source, YYYYMMDDHHMMSS);
    }
    
    /**
     * <p>
     * 获取当前时间
     * </p>
     * 
     * @return <code>Date</code> 获取系统当前时间
     */
    public static Date getCurrentDate()
    {
        return new Date();
    }
    
    /**
     * 
     * @param start 开始时间
     * @return <code>long</code>
     */
    public static long getDiffTime(long start)
    {
        long end = System.currentTimeMillis();
        return end - start;
    }
    
    /**
     * <一句话功能简述>
     * <功能详细描述>
     * 
     * @param date
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Date getNextDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }
    
    /**
     * 格式化为yyyy-MM-dd格式Date型日期
     * 
     * @param date 日期
     * @return <code>Date</code>
     * @throws ParseException
     */
    public static Date format(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        String currentDateStr = sdf.format(date);
        try
        {
            return sdf.parse(currentDateStr);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    /**
     * <一句话功能简述>
     * <功能详细描述>
     * 
     * @param date
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Date format(String date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        try
        {
            return sdf.parse(date);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    /**
     * 获取当天的long型开始时间
     * <功能详细描述>
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static long getBeginLongDate()
    {
        return getCurrentCalendar(0, 0, 0).getTimeInMillis();
    }
    
    /**
     * 获取当天的long型结束时间
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static long getEndLongDate()
    {
        return getCurrentCalendar(23, 59, 59).getTimeInMillis();
    }
    
    /**
     * 获取指定日历对象
     * 
     * @param hour
     * @param minute
     * @param second
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static Calendar getCurrentCalendar(int hour, int minute, int second)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
    
    /**
     * 获取当前String字符串日期
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getCurrentDateStr()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
        return sdf.format(getCurrentDate());
    }
    
    /**
     * 获取第days天的凌晨时间
     * 
     * @param days
     * @return long
     */
    public static long getLongTimeBeforeDays(int days)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
}
