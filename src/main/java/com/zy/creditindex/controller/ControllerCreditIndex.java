package com.zy.creditindex.controller;

import com.zy.creditindex.aspect.HttpAspect;
import com.zy.creditindex.entity.CreditIndex;
import com.zy.creditindex.repostory.IndexRepostory;
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
    IndexRepostory indexrepostory;


    @PostMapping(value = "add")
    public CreditIndex CreditAdd(@Valid CreditIndex creditindex){
        return indexrepostory.save(creditindex);
    }
    @GetMapping(value = "indexs")
    public List<CreditIndex> CreditList(){
        logger.info("���ڷ��ʸ��ࣺCreditList");
        return indexrepostory.findAll();
    }

    //����id��ѯ
    @GetMapping(value = "/trd_code/{id}")
    public CreditIndex CreditOne(@PathVariable("id") String trd_code){
        return indexrepostory.findOne(trd_code);
    }

    /**
     * //��������ѯ
     * @param
     * @param report_date
     * @return
     */
/*    @PostMapping(value = "CreditIndex")
    public CreditIndex CreditIndexdata(String trd_code, Date report_date){
        return indexrepostory.findByTrd_codeAndrReport_date(trd_code,report_date);
    }*/

    //ͨ����������ѯ
    @PostMapping(value = "creditdate")
    public List<CreditIndex> QueryCreditDate(Date report_date){
        return indexrepostory.findByReportdate(report_date);
    }
    //�ù�˾ID��ѯ
    @PostMapping (value = "comids")
    public List<CreditIndex> QueryComid(BigInteger comid){
        return indexrepostory.findByComid(comid);
    }

    /**
     * ����ʱ��β�ѯ
     * @param trd_code
     * @param startime
     * @param endtime
     * @return
     */
/*    @PostMapping (value = "timeslot")
    public List<CreditIndex> QueryIndexByTimeSlot(String trd_code, Date startime,Date endtime){
        return indexrepostory.findByReportdates(trd_code,startime,endtime);
    }*/

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index() {
//        return "index";
//    }
}
