package com.zy.creditindex.controller;

import com.zy.creditindex.entity.LineChartBean;
import com.zy.creditindex.entity.XParameter;
import com.zy.creditindex.entity.idri.IdriBean;
import com.zy.creditindex.service.IndexService.IdriService;
import com.zy.creditindex.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * 折线图
 * @author huaqin
 * @date 2017/10/19
 */
@Controller
@RequestMapping("/mp")
public class LineChartAction {
    @Autowired
    private IdriService idriService;
    @RequestMapping("/selectData")
    @ResponseBody
    public LineChartBean selectLine(LineChartBean bean) throws Exception {
        /*返回前台参数对象*/
        LineChartBean labels = new LineChartBean();
        /*设置X轴参数*/
        List<String> list = new ArrayList<>();
        //设置查询时间
        Date starttime = DateUtil.starttime();//开始时间
        Date endtime = DateUtil.endtime();    //结束时间
        List<IdriBean> totto = idriService.findIdriByTimesTotto(starttime, endtime);
        for (IdriBean i:totto) {
            list.add(i.getIndexdate().toString());
        }
        labels.setLabels(list);
        /*设置Y轴前台展示折线图*/
        List<XParameter> data = new ArrayList<>();
        XParameter parameter = new XParameter();
        List<BigDecimal> xlist1 = new ArrayList<>();
        for (IdriBean ib:totto) {
            xlist1.add(ib.getIdri());
        }
        parameter.setData(xlist1);
       /* for(int i=0;i<list.size();i++){
            parameter.setMultiTooltipTemplate(list.get(i));
        }*/
        parameter.setBorderColor("rgba(151,187,205,1)");
        parameter.setBackgroundColor("rgba(151,187,205,1)");
        parameter.setLabel("建筑");

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

        parameter2.setLabel("房地产");
        parameter2.setBorderColor("rgba(131,137,205,1)");
        parameter2.setBackgroundColor("rgba(131,137,205,1)");
        XParameter parameter3 = new XParameter();
        List<BigDecimal> xlist3 = new ArrayList<>();
        BigDecimal loanAmount9 = new BigDecimal("31.22");
        BigDecimal loanAmount10 = new BigDecimal("181.22");
        BigDecimal loanAmount11 = new BigDecimal("251.22");
        BigDecimal loanAmount12= new BigDecimal("331.22");
        xlist3.add(loanAmount9);
        xlist3.add(loanAmount10);
        xlist3.add(loanAmount11);
        xlist3.add(loanAmount12);
        parameter3.setData(xlist3);
        parameter3.setLabel("制造业");
        parameter3.setBorderColor("rgb(248, 18, 242)");
        parameter3.setBackgroundColor("rgb(248, 18, 242)");
        data.add(parameter);
        data.add(parameter2);
        data.add(parameter3);
        /*将参数封装到list集合中返回前台展示*/
        labels.setDatasets(data);
       return labels;
    }
}
