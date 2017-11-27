package com.zy.creditindex.controller.indexandidri;

import com.zy.creditindex.entity.JsonEntry;
import com.zy.creditindex.entity.LineChartBean;
import com.zy.creditindex.entity.XParameter;
import com.zy.creditindex.entity.idri.BastrdtINFOBean;
import com.zy.creditindex.entity.idri.IdriBean;
import com.zy.creditindex.service.IndexService.BastrdtInfoService;
import com.zy.creditindex.service.IndexService.IdriService;
import com.zy.creditindex.util.CacheManager;
import com.zy.creditindex.util.DateTimeUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by huaqin on 2017/10/30.
 */
@Controller
@RequestMapping("/um")
public class PriceTableList {
    @Autowired
    private IdriService idriService;
    @Autowired
    private BastrdtInfoService bastrdtInfoService;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat format3 = new SimpleDateFormat("MM-dd");
    private DateTimeUtil dataTimeUtil = new  DateTimeUtil();
    @RequestMapping("/line")
    public String creditLine(ModelMap model){
/*当前日期*/
        try {
            /*查询最近交易日*/
            BastrdtINFOBean bean  = bastrdtInfoService.queryStartTime(dataTimeUtil.endTime());
            Calendar calendar = Calendar.getInstance();//日历对象
            calendar.setTime(new Date());//设置当前日期
            Date  dayTime= calendar.getTime();
            /*获取当前日期9点0分1秒*/
            Date nowTime = format2.parse(format.format(dayTime) + " 09:00:01");
            /*判断代码执行时间是否小于当前日期9点0分1秒*/
            if(dayTime.getTime()<nowTime.getTime()){
                /*最近交易日*/
                calendar.setTime(bean.getTrd_day());
                calendar.add(Calendar.DATE, -1);//日期减一
                /*查询最近交易日*/
                bean  = bastrdtInfoService.queryStartTime(calendar.getTime());
            }
            /*最近交易日*/
            Date endTime = bean.getTrd_day();
            /*获取10天前的日期*/
            bean =bastrdtInfoService.queryBeforTime(endTime);
            /*10天的交易日*/
            Date startTime =bean.getTrd_day();
            /*查询期间的交易日*/
            List<BastrdtINFOBean> list =  bastrdtInfoService.findWithinTenDay(startTime, endTime);
            /*封装交易日集合*/
            List<Object> l = new ArrayList<>();
            for(BastrdtINFOBean b: list){
                l.add(format3.format(b.getTrd_day()));
            }
            /*查询10个交易日的行业等权数据降序*/
            List<IdriBean>  bodyList = idriService.queryIdriByGradeDown(startTime, endTime, "01");
            /*获取行业编码对应的行业名称集合*/
            Map<String, String> map = IdriBean.getMap();
            /*封装列数据*/
            List<Object> list2 = new ArrayList<>();
            for (String key : map.keySet()) {
                List<Double> d = new ArrayList<Double>();
                JsonEntry jsonEntry = new JsonEntry();
                /*封装最近10天交易日的起始日期结束日期*/
                jsonEntry.setStartTime(format.format(startTime));
                jsonEntry.setEndTime(format.format(endTime));
                /*行业编码*/
                jsonEntry.setId(key);
                /*行业名称*/
                jsonEntry.setUsername(map.get(key));
                /*将参数添加到list集合中*/
                list2.add(jsonEntry);
            }
             /*查询10个交易日的行业加权数据降序*/
            List<IdriBean>  weighting = idriService.queryIdriByGradeDown(startTime, endTime, "02");
            /*页面列表左列行业名称 及弹出框携带参数*/
            model.addAttribute("list2", list2);
            /*页面列表行业等权指数*/
            model.addAttribute("bodyList", bodyList);
            /*页面列表行业加权指数*/
            model.addAttribute("weighting", weighting);
            /*页面列表表头*/
            model.addAttribute("list", l);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  "weightingAndIsobar";
    }
    @RequestMapping("/priceTable")
    public String line(ModelMap model){
		/*当前日期*/
        try {
            /*获取当前日期*/
            BastrdtINFOBean bean  = bastrdtInfoService.queryStartTime(dataTimeUtil.endTime());
            Date endTime = bean.getTrd_day();
            /*获取10天前的日期*/
            bean =bastrdtInfoService.queryBeforTime(dataTimeUtil.withinTenDay());
            Date startTime =bean.getTrd_day();
            /*查询期间的交易日*/
            List<BastrdtINFOBean> list =  bastrdtInfoService.findWithinTenDay(startTime, endTime);
            /*日期集合*/
            List<Object> l = new ArrayList<>();
            for(BastrdtINFOBean b: list){
                l.add(format.format(b.getTrd_day()));
            }
            /*查询最近10个交易日等权的行业指数*/
            List<IdriBean>  bodyList = idriService.queryIdriByCondition(startTime, endTime, "01");
            /*获取行业编码对应的行业名称集合*/
            Map<String, String> map = IdriBean.getMap();
            /*封装行业名称 行业id*/
            List<JsonEntry> list2 = new ArrayList<>();
            for (String key : map.keySet()) {
                    List<Double> d = new ArrayList<Double>();
                    JsonEntry jsonEntry = new JsonEntry();
                    /*封装10个交易日的初始日期与截止日期*/
                    jsonEntry.setStartTime(format.format(startTime));
                    jsonEntry.setEndTime(format.format(endTime));
                    jsonEntry.setId(key);
                    jsonEntry.setUsername(map.get(key));
                    list2.add(jsonEntry);
            }
            /*查询最近10个交易日加权权的行业指数*/
            List<IdriBean>  weighting = idriService.queryIdriByCondition(startTime, endTime, "02");
            /*页面列表左列行业名称*/
            model.addAttribute("list2", list2);
            /*页面列表对应行业等权的指数值*/
            model.addAttribute("bodyList", bodyList);
            /*页面列表对应行业加权的指数值*/
            model.addAttribute("weighting", weighting);
            /*页面列表头日期*/
            model.addAttribute("list", l);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "priceTable";
    }
    @RequestMapping("/tradeLineChart")
    @ResponseBody
    public LineChartBean selectLine(@RequestBody JsonEntry chart) {
           /*返回前台参数对象*/
        LineChartBean labels = new LineChartBean();
        try {
             /*根据前台选中行业查询*/
            List<IdriBean>  bodyList = idriService.queryIdriByTrade(format.parse(chart.getStartTime()),
                    format.parse(chart.getEndTime()), chart.getCreditorType(), chart.getId());
            /*封装参数集合*/
            List<XParameter> data = new ArrayList<>();
            /*行业参数*/
            XParameter parameter = new XParameter();
            /*折线参数*/
            List<BigDecimal> list  = new ArrayList<>();
            /*X轴坐标值*/
            List<String> Xlist  = new ArrayList<>();
            /*添加行业名称*/
            parameter.setLabel(chart.getUsername());
            /*遍历集合*/
            for (IdriBean idr : bodyList) {
                /*添加行业指数*/
                list.add(idr.getIdri());
                /*添加对应X轴刻度值*/
                Xlist.add(format.format(idr.getIndexdate()));
            }
            /*添加行业指数*/
            parameter.setData(list);
            /*将行业参数封装到集合中*/
            data.add(parameter);
            /*添加X轴刻度值*/
            labels.setLabels(Xlist);
            /*封装Y轴数据*/
            labels.setDatasets(data);
            /*添加集合中最小行业指数*/
            labels.setMinIdri(Collections.min(list));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return labels;
    }
    @RequestMapping("/eight")
    public String creatJFreeChart()  {

        return "eight";
    }
    @RequestMapping("/eightEchars")
    @ResponseBody
    public LineChartBean queryLine(String type) {
        LineChartBean labels = new LineChartBean();
        try {
              /*返回前台参数对象*/
            LineChartBean   label =  CacheManager.getCacheInfo(type);
            if(label==null){
                /*接收行业参数*/
                List<IdriBean> list = new ArrayList<IdriBean>();
                /*根据行业编码转换行业名称*/
                Map<String, String> map = IdriBean.getMap();
                /*封装行业参数*/
                List<XParameter> xParameters = new ArrayList<XParameter>();
                /*行业名称*/
                List<String> columns = new ArrayList<String>(map.size());
                /*查询期间内各个行业的数据*/
                list  = idriService.queryAllIdri(dataTimeUtil.endTime(), type);
                /*判断集合是否为空*/
                if (CollectionUtils.isEmpty(list)) {
                    return labels;
                }
                for (String key : map.keySet()) {
                    /*行业idri数据*/
                    List<BigDecimal> decimal=new ArrayList<BigDecimal>();
                    XParameter x = new XParameter();
                    /*X轴日期*/
                    List<String> dateList = new ArrayList<String>();
                    /*遍历list集合*/
                    for (IdriBean idr : list) {
                        /*判断是否匹配行业编码*/
                        if (idr.getInducode().equals(key)) {
                            /*添加X轴刻度*/
                            dateList.add(format.format(idr.getIndexdate()));
                            if(idr.getIdri()!=null){
                                decimal.add(idr.getIdri());
                            }else {
                                decimal.add(new BigDecimal("0.0000"));
                            }
                        }
                    }
                    /*添加行业idri数据*/
                    x.setData(decimal);
                    /*添加日期*/
                    x.setDateTime(dateList);
                    /*将对象封装到参数中*/
                    xParameters.add(x);
                    /*添加行业名称*/
                    columns.add(map.get(key));
                }
                /*添加X轴刻度值*/
                labels.setLabels(columns);
                /*添加行业数据*/
                labels.setDatasets(xParameters);
                /*将数据根据类型放入Map集合缓存中*/
                CacheManager.putCacheInfo(type,labels);
            }else{
                /*根据类型获取缓存中的数据*/
                labels =  CacheManager.getCacheInfo(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return labels;
    }
}
