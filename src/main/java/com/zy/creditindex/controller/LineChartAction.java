package com.zy.creditindex.controller;

import com.zy.creditindex.entity.LineChartBean;
import com.zy.creditindex.entity.XParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询管理员权限类
 * @author huaqin
 * @date 2017/10/19
 */
@Controller
@RequestMapping("/mp")
public class LineChartAction {

    @RequestMapping("/selectData")
    @ResponseBody
    public LineChartBean selectLine() {
        /*返回前台参数集合*/

        /*返回前台参数对象*/
        LineChartBean labels = new LineChartBean();
        /*设置X轴参数*/
        List<String> list = new ArrayList<>();
        list.add("2014-10");
        list.add("2015-10");
        list.add("2016-10");
        list.add("2017-10");
        labels.setLabels(list);
        /*设置Y轴前台展示折线图*/
        List<XParameter> data = new ArrayList<>();
        XParameter parameter = new XParameter();
        List<BigDecimal> xlist1 = new ArrayList<>();
        BigDecimal loanAmount = new BigDecimal("121.22");
        BigDecimal loanAmount2 = new BigDecimal("221.22");
        BigDecimal loanAmount3 = new BigDecimal("321.22");
        BigDecimal loanAmount4 = new BigDecimal("421.22");
        xlist1.add(loanAmount);
        xlist1.add(loanAmount2);
        xlist1.add(loanAmount3);
        xlist1.add(loanAmount4);
        parameter.setData(xlist1);

        XParameter parameter2 = new XParameter();
        List<BigDecimal> xlist2 = new ArrayList<>();
        BigDecimal loanAmount5 = new BigDecimal("61.22");
        BigDecimal loanAmount6 = new BigDecimal("111.22");
        BigDecimal loanAmount7 = new BigDecimal("221.22");
        BigDecimal loanAmount8= new BigDecimal("381.22");
        xlist2.add(loanAmount5);
        xlist2.add(loanAmount6);
        xlist2.add(loanAmount7);
        xlist2.add(loanAmount8);
        parameter2.setData(xlist2);
        data.add(parameter);
        data.add(parameter2);
        /*将参数封装到list集合中返回前台展示*/
        labels.setDatasets(data);
       return labels;
    }
}
