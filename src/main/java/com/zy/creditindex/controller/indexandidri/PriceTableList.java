package com.zy.creditindex.controller.indexandidri;

import com.zy.creditindex.entity.JsonEntry;
import com.zy.creditindex.entity.idri.IdriBean;
import com.zy.creditindex.util.DateTimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huaqin on 2017/10/30.
 */
@Controller
@RequestMapping("/um")
public class PriceTableList {
    DateTimeUtil dataTimeUtil = new  DateTimeUtil();
    @RequestMapping("/priceTable")
    public String line(ModelMap model){
		/*当前日期*/
        try {
            /*获取截止日期*/
            /*Date endTime = dataTimeUtil.endTime();*/
            /*获取10天后的日期*/
            /*Date startTime =dataTimeUtil.withinTenDay();*/
            List<Object> l = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                l.add("测试"+i);
            }
            model.addAttribute("list",l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "priceTable";
    }

    @RequestMapping("/list9.json")
    @ResponseBody
    public Object list() {
        List<Object> list = new ArrayList<>();
        int j=100;
        for (int i = 1; i < j; i++) {
            JsonEntry jsonEntry = new JsonEntry();
            jsonEntry.setId(i);
            jsonEntry.setCf("1");
            jsonEntry.setGarch("1");
            jsonEntry.setLiudong("0");
            jsonEntry.setMerton("0");
            jsonEntry.setQuke("0");
            jsonEntry.setUsername("刘晓");
            if(i==1){
                jsonEntry.setUsername("刘芸");
            }else if(i==2){
                jsonEntry.setUsername("刘小芸");
            }else if(i==3){
                jsonEntry.setUsername("刘小罄");
            }
            list.add(jsonEntry);
        }

        return list;
    }
}
