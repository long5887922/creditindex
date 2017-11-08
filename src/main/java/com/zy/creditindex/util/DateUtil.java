package com.zy.creditindex.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * Created by ${ZhaoYing}on 2017/10/26 0026
 * 设置默认查询的时间
 */
public class DateUtil {
    //获取当天对应的上个月的日期
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static Date starttime(){
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new java.util.Date());//设置当前日期
        calendar.add(Calendar.MONTH, -1);//月份减一
        Date starttime = calendar.getTime();
        return starttime;
    }
    //获取当前系统日期（即昨天的交易，【业务要求】当天的交易还未开始）
    public static Date endtime(){
//        Date endtime=new java.sql.Date(new Date().getTime());
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new java.util.Date());//设置当前日期
        calendar.add(Calendar.DATE, -1);//当天减一 ：昨天
        Date endtime = calendar.getTime();
        return endtime;
    }
    // 一年前的数据
    public static Date oneYer(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new java.util.Date());//设置当前日期
        calendar.add(Calendar.YEAR, -1);//YEAR-1
        Date starttimeyer = calendar.getTime();
        return starttimeyer;
    }

    /**
     * 获取今天是星期几
     * @return
     */
    public static int getWeekend(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }
}
