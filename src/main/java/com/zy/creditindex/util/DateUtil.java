package com.zy.creditindex.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.zy.creditindex.util.DateTimeUtil.initHolidayList;

/**
 * Created by ${ZhaoYing}on 2017/10/26 0026
 * 设置默认查询的时间
 */
public class DateUtil {
    //获取当天对应的上个月的日期
    public static Date starttime(){
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new java.util.Date());//设置当前日期
        calendar.add(Calendar.MONTH, -1);//月份减一
        Date starttime = calendar.getTime();
        return starttime;
    }
    //获取当前系统日期
    public static Date endtime(){
        Date endtime=new java.sql.Date(new Date().getTime());
        return endtime;
    }
    // 一年前的数据
    public static Date oneYer(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new java.util.Date());//设置当前日期
        calendar.add(Calendar.MONTH, -12);//份减6
        Date starttimeyer = calendar.getTime();
        return starttimeyer;
    }
}
