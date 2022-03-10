package com.example.demo1210.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: sunping
 * @description: TimeUtil
 * @date: 2020/8/8 0008
 */
@Slf4j
public class DateTimeUtil {
    private DateTimeUtil() {
    }

    /**
     * 获得开始与结束日期
     */
    public static Map<String, String> getDateTime(Integer time, String format) {
        Map<String, String> dateTimeMap = new HashMap<>(0);
        String startTime = null;
        String endTime = null;
        String todayTime = null;
        Calendar endCalendar = Calendar.getInstance();
        Calendar startCalendar = Calendar.getInstance();
        if (format == null) {
            format = "yyyy-MM-dd";
            if (time != null) {
                //判断format来区分查询月还是日
                if (time == 12) {
                    format = "yyyy-MM";
                    endCalendar.setTime(new Date());
                    endCalendar.add(Calendar.MONTH, 0);
                    endTime = DateFormatUtils.format(endCalendar.getTime(), format);
                    startCalendar.setTime(new Date());
                    startCalendar.add(Calendar.MONTH, -time + 1);
                    startTime = DateFormatUtils.format(startCalendar.getTime(), format);
                    dateTimeMap.put("startTime", startTime);
                    dateTimeMap.put("endTime", endTime);
                } else {
                    endCalendar.setTime(new Date());
                    endCalendar.add(Calendar.DATE, 0);
                    endTime = DateFormatUtils.format(endCalendar.getTime(), format);
                    startCalendar.setTime(new Date());
                    startCalendar.add(Calendar.DATE, -time + 1);
                    startTime = DateFormatUtils.format(startCalendar.getTime(), format);
                    dateTimeMap.put("startTime", startTime);
                    dateTimeMap.put("endTime", endTime);
                }
            } else {
                endCalendar.setTime(new Date());
                endCalendar.add(Calendar.DATE, 0);
                todayTime = DateFormatUtils.format(endCalendar.getTime(), format);
                dateTimeMap.put("todayTime", todayTime);
            }
        }
        return dateTimeMap;

    }

    /**
     * 获取两日期之间所有月份
     */
    public static List<String> getMonths(String startTime, String endTime) throws ParseException {
        // 返回的日期集合
        List<String> days = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date start = null;
        Date end = null;
        if (StringUtils.isBlank(startTime) || StringUtils.isBlank(endTime)) {
            return new ArrayList<>(0);
        }
        try {
            start = sdf.parse(startTime);
            end = sdf.parse(endTime);
        } catch (ParseException e) {
            log.error("日期异常", e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        // 日期加1
        tempEnd.add(Calendar.MONTH, +1);
        while (calendar.before(tempEnd)) {
            days.add(sdf.format(calendar.getTime()));
            calendar.add(Calendar.MONTH, 1);
        }
        return days;
    }

    /**
     * 获取两日期之间所有天
     */
    public static List<String> getDays(String startTime, String endTime) {
        // 返回的日期集合
        List<String> days = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        if (StringUtils.isBlank(startTime) || StringUtils.isBlank(endTime)) {
            return new ArrayList<>(0);
        }
        try {
            start = sdf.parse(startTime);
            end = sdf.parse(endTime);
        } catch (ParseException e) {
            log.error("日期异常", e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        // 日期加1
        tempEnd.add(Calendar.DATE, +1);
        while (calendar.before(tempEnd)) {
            days.add(sdf.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return days;
    }


    /**
     * 加减天
     *
     * @param day
     * @return
     */
    public static String getDate(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, day);
        return sdf.format(calendar.getTime());
    }

    /**
     * 加减小时
     *
     * @param hour
     * @return
     */
    public static String[] getDateTime(int hour) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        String[] dateTime = new String[2];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, hour);
        dateTime[0] = sdf.format(calendar.getTime() + ":00:00:00");
        dateTime[1] = sdf.format(calendar.getTime() + ":23:59:59");
        return dateTime;
    }

    /**
     * 获取今日分时
     *
     * @return
     */
    public static List<String> getHour() {
        //返回的时间段集合
        List<String> times = new ArrayList<>();
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        for (int i = 0; i <= hour; i++) {
            if (i < 10) {
                times.add("0" + i);
            } else {
                times.add("" + i);
            }
        }
        return times;
    }

}
