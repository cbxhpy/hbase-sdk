package com.github.CCweixiao.hbase.sdk.common.util;

import cn.hutool.core.date.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author leojie 2021/6/13 8:52 下午
 */
public final class DateUtil extends cn.hutool.core.date.DateUtil {
    public static final String MS_FORMAT = "yyyy-MM-dd_HH:mm:ss:SSS";
    public static final String SECOND_FORMAT = "yyyy-MM-dd_HH:mm:ss";
    public static final String MINUTE_FORMAT = "yyyy-MM-dd_HH:mm";
    public static final String HOUR_FORMAT = "yyyy-MM-dd_HH";
    public static final String DAY_FORMAT = "yyyy-MM-dd";


    public static String parseDatetimeToStr(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(localDateTime);
    }
    public static String parseTimestampToTimeStr(long time){
        return DateTime.of(time).toString(SECOND_FORMAT);
    }

    public static void main(String[] args) {
        System.out.println(parseTimestampToTimeStr(1623586470408L));
    }


}