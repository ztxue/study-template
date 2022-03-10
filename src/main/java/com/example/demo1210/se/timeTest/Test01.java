package com.example.demo1210.se.timeTest;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/2/21 19:14
 * @describe
 */
public class Test01 {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // 获取年
        int year = localDate.getYear();
        int year1 = localDate.get(ChronoField.YEAR);

        // 获取月
        Month month = localDate.getMonth();
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);

        // 获取日
        int day = localDate.getDayOfMonth();
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);

// 获取星期几
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);

    }
}
