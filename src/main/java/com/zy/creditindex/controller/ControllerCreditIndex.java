package com.zy.creditindex.controller;

import com.zy.creditindex.aspect.HttpAspect;
import com.zy.creditindex.entity.CreditIndex;
import com.zy.creditindex.repostory.IndexRepostory;
import com.zy.creditindex.service.CreditIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/9/23 0023
 */
@RestController
//@Controller
@RequestMapping(value = "index")
public class ControllerCreditIndex {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);


    @Autowired
    private CreditIndexService creditIndexService;




    /**
     * 查询所有的数据
     * @return
     */
    @GetMapping(value = "indexs")
    public List<CreditIndex> CreditList(){
        logger.info("正在访问该类：CreditList");
        return creditIndexService.queryAll();
    }

    //根据id查询
    @GetMapping(value = "/trd_code/{id}")
    public CreditIndex CreditOne(@PathVariable("id") String trd_code){
        return creditIndexService.queryOne(trd_code);
    }

    /**
     * //带参数查询
     * 查询当日的股票数据
     * @param
     * @param report_date
     * @return
     */
   @PostMapping(value = "CreditIndex")
    public CreditIndex CreditIndexdata(String trd_code, Date report_date){
        return creditIndexService.queryDayData(trd_code,report_date);
    }

    //查询每个独立日期产生的各项数据
    @PostMapping(value = "creditdate")
    public List<CreditIndex> QueryCreditDate(Date report_date){
        return creditIndexService.queryIndependentDate(report_date);
    }
    //用公司ID查询
    @PostMapping (value = "comids")
    public List<CreditIndex> QueryComid(BigInteger comid){
        return creditIndexService.queryCompanyID(comid);
    }

    /**
     * 任何时间段查询根据公司股票查询
     * @param trd_code
     * @param startime
     * @param endtime
     * @return
     */
   @PostMapping (value = "timeslot")
    public List<CreditIndex> QueryIndexByTimeSlot(String trd_code, Date startime,Date endtime){
        return creditIndexService.queryCompanyStockAnytime(trd_code,startime,endtime);
    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index() {
//        return "index";
//    }
}
