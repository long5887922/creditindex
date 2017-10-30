package com.zy.creditindex.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by huaqin on 2017/10/30.
 */
public class DateTimeUtil {
    //节假日列表
    private static List<Calendar> holidayList = new ArrayList<Calendar>();
    //周末为工作日
    private static List<Calendar> weekendList = new ArrayList<Calendar>();

    /*获取一年前的日期*/
    public static Date startTime() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new Date());//设置当前日期
        calendar.add(Calendar.YEAR, -1);//份减一
        calendar.add(Calendar.DATE, -1);//日期减一
         /*获取当前节假日*/
        initHolidayList(format.format(calendar.getTime()));
        return  format.parse(format.format(time(calendar).getTime()));
    }

    /*获取当前日期6月前的日期*/
    public static String amongTime() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new java.util.Date());//设置当前日期
        calendar.add(Calendar.MONTH, -6);//份减6
         /*获取当前节假日*/
        initHolidayList(format.format(calendar.getTime()));
        return  format.format(time(calendar).getTime());
    }
    //获取当前系统日期
    public static Date endTime() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new Date());//设置当前日期
        calendar.add(Calendar.DATE, -1);//日期减一
        /*获取当前节假日*/
        initHolidayList(format.format(calendar.getTime()));
        return   format.parse(format.format(time(calendar).getTime()));
    }
    /*判断当前日期是否是节假日*/
    public static Calendar time(Calendar calendar)throws Exception{
          /*判断是否是周末如果是周六则天数减一 如果是周日则天数减二*/
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            calendar.add(Calendar.DATE, -2);
        }else if( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            calendar.add(Calendar.DATE, -1);
        }
        Boolean flag = checkHoliday(calendar);
        while(flag) {
            /*判断当前是否*/
            if(flag){
                calendar.add(Calendar.DATE, -1);
                flag = checkHoliday(calendar);
            }
        }
        return  calendar;
    }
    /*前一个月的最后一天*/
    public static Date lastTime() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //当前月前一个月的1号日期
        Calendar cal = Calendar.getInstance();//获取当前日期
        cal.add(Calendar.MONTH, -1);//设置月份为当前月上个月
        cal.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天 （这里设置就是当前月份上一个月的1号）
        String firstDay = format.format(cal.getTime()); //得到当前月份前一个月的1号日期
        System.out.println(firstDay);
        //当前月前一个月的最后一天日期
        Calendar cale = Calendar.getInstance();    //获取当前日期
        cale.set(Calendar.DAY_OF_MONTH, 0);//设置0,即当前月的前一个月的最后一天日期
        String lastDay = format.format(cale.getTime());//当前月的前一个月的最后一天日期
        System.out.println(lastDay);
        return format.parse(lastDay);
    }
    /**
     *
     * 验证日期是否是节假日
     * @param calendar  传入需要验证的日期
     * @return
     * return boolean    返回类型  返回true是节假日，返回false不是节假日
     * throws
     */
    public static boolean checkHoliday(Calendar calendar) throws Exception{

        //判断日期是否是周六周日
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){

            //判断日期是否是节假日
            for (Calendar ca : weekendList) {
                if(ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                        ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)&&
                        ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)){
                    return false;
                }
            }

            return true;
        }
        //判断日期是否是节假日
        for (Calendar ca : holidayList) {
            if(ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                    ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)&&
                    ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)){
                return true;
            }
        }

        return false;
    }

    /**
     *
     * 把所有节假日放入list
     * @param date  从数据库查 查出来的格式
     * return void    返回类型
     * throws
     */
    public static void initHolidayList(String date){
        String [] da = date.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
        calendar.set(Calendar.MONTH, Integer.valueOf(da[1])-1);//月份比正常小1,0代表一月
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
        holidayList.add(calendar);
    }

    /**
     * 初始化周末被调整为工作日的数据
     */
    public void initWeekendList(String date){
        String [] da = date.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
        calendar.set(Calendar.MONTH, Integer.valueOf(da[1])-1);//月份比正常小1,0代表一月
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
        weekendList.add(calendar);
    }
}