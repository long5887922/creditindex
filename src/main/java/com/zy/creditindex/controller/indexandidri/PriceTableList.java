package com.zy.creditindex.controller.indexandidri;

import com.zy.creditindex.entity.JsonEntry;
import com.zy.creditindex.entity.LineChartBean;
import com.zy.creditindex.entity.XParameter;
import com.zy.creditindex.entity.idri.BastrdtINFOBean;
import com.zy.creditindex.entity.idri.IdriBean;
import com.zy.creditindex.repostory.indexJpa.BastrdtInfoRepostory;
import com.zy.creditindex.service.IndexService.BastrdtInfoService;
import com.zy.creditindex.service.IndexService.IdriService;
import com.zy.creditindex.util.DateTimeUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DateTimeUtil dataTimeUtil = new  DateTimeUtil();
    @RequestMapping("/line")
    public String creditLine(ModelMap model){
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
            List<Object> l = new ArrayList<>();
            for(BastrdtINFOBean b: list){
                l.add(format.format(b.getTrd_day()));
            }
            /*查询10个交易日的行业数据降序*/
            List<IdriBean>  bodyList = idriService.queryIdriByGradeDown(startTime, endTime, "01");
            String s = "";
            String e="";
            String a="";
            String b="";
            String ce="";
            String er="";


            Map<String, String> map = IdriBean.getMap();
            List<Object> list2 = new ArrayList<>();
            for (String key : map.keySet()) {
                List<Double> d = new ArrayList<Double>();
                JsonEntry jsonEntry = new JsonEntry();
                jsonEntry.setStartTime(format.format(startTime));
                jsonEntry.setEndTime(format.format(endTime));
                jsonEntry.setId(key);
                jsonEntry.setUsername(map.get(key));
                list2.add(jsonEntry);
            }
            List<IdriBean>  weighting = idriService.queryIdriByGradeDown(startTime, endTime, "02");
            model.addAttribute("list2", list2);
            model.addAttribute("bodyList", bodyList);
            model.addAttribute("weighting", weighting);
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
            List<Object> l = new ArrayList<>();
            for(BastrdtINFOBean b: list){
                l.add(format.format(b.getTrd_day()));
            }
            List<IdriBean>  bodyList = idriService.queryIdriByCondition(startTime, endTime, "01");
            Map<String, String> map = IdriBean.getMap();
            List<Object> list2 = new ArrayList<>();
            for (String key : map.keySet()) {
                    List<Double> d = new ArrayList<Double>();
                    JsonEntry jsonEntry = new JsonEntry();
                    jsonEntry.setStartTime(format.format(startTime));
                    jsonEntry.setEndTime(format.format(endTime));
                    jsonEntry.setId(key);
                    jsonEntry.setUsername(map.get(key));
                    list2.add(jsonEntry);
            }
            List<IdriBean>  weighting = idriService.queryIdriByCondition(startTime, endTime, "02");
            model.addAttribute("list2", list2);
            model.addAttribute("bodyList", bodyList);
            model.addAttribute("weighting", weighting);
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
            Map<String, String> map = IdriBean.getMap();
            List<XParameter> data = new ArrayList<>();
            XParameter parameter = new XParameter();
            /*折线参数*/
            List<BigDecimal> list  = new ArrayList<>();
            /*X轴坐标值*/
            List<String> Xlist  = new ArrayList<>();
            for (String key : map.keySet()) {
               if(key.equals(chart.getId())){
                   parameter.setLabel(map.get(key));
               }
            }
            for (IdriBean idr : bodyList) {
                list.add(idr.getIdri());
                Xlist.add(format.format(idr.getIndexdate()));
            }
            parameter.setBorderColor("rgba(151,187,205,1)");
            parameter.setBackgroundColor("rgba(151,187,205,1)");
            parameter.setData(list);

            data.add(parameter);
            labels.setLabels(Xlist);
            labels.setDatasets(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return labels;
    }
}
