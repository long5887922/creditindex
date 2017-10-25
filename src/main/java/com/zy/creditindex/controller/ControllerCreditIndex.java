package com.zy.creditindex.controller;

import com.zy.creditindex.aspect.HttpAspect;
import com.zy.creditindex.entity.CreditIndex;

import com.zy.creditindex.service.CreditIndexService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/9/23 0023
 */
@RestController
@RequestMapping(value = "index")
public class ControllerCreditIndex {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);


    @Autowired
    private CreditIndexService creditIndexService;

    /**
     * 按日期查询
     * @param report_date
     * @return
     */
    @PostMapping("/bydate")
    public List<CreditIndex> queryByDate(Date report_date){
        return creditIndexService.queryIndependentDate(report_date);
    }

    /**
     * 查询所有的数据-升序排序
     * @return
     */
    @GetMapping(value = "indexs")
    public List<CreditIndex> CreditList(){
        logger.info("正在访问该类：CreditList");
        List<CreditIndex> creditIndices = creditIndexService.queryAll();
        for (CreditIndex c:creditIndices) {
            System.out.println(c.getReportdate()+"-->对应的code是："+c.getTrd_code());
        }
        return creditIndices;
    }

    /**trd_code查询
     * 根据
     * @param trd_code
     * @return
     */
    @GetMapping(value = "/trd_code/{id}")
    public CreditIndex CreditOne(@PathVariable("id") String trd_code){
        return creditIndexService.queryOne(trd_code);
    }

    /**
     * 查询当日的股票数据
     * @param
     * @param report_date
     * @return
     */
   @PostMapping(value = "CreditIndex")
    public CreditIndex CreditIndexdata(String trd_code, Date report_date){
        return creditIndexService.queryDayData(trd_code,report_date);
    }

    //查询每个 独立日期 产生的各项数据
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
     * @return CreditIndex 对象集合
     */
   @PostMapping (value = "timeslot")
    public List<CreditIndex> QueryIndexByTimeSlot(String trd_code, Date startime,Date endtime){
        return creditIndexService.queryCompanyStockAnytime(trd_code,startime,endtime);
    }

    /**
     * 时间段的查询
     * @param startime
     * @param endtime
     * @return
     */
    @PostMapping(value = "timeslotto")
    public List<CreditIndex> QueryTimeSlotTo( Date startime,Date endtime){
        List<CreditIndex> creditIndices = creditIndexService.queryTimeSlot(startime, endtime);
        for (CreditIndex c:creditIndices) {
            System.out.println(c.getReportdate()+"----->code："+c.getTrd_code());
        }
        return creditIndices;
    }

    /**
     * 文件下载
     * @param res
     * @throws IOException
     */
    @GetMapping(value="/Download")
    public void testDownload(HttpServletResponse res) throws IOException {
        String fileName="upload.pdf";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=CourseResource.pdf");
        File file=new File("F://Download//upload.pdf");

        FileOutputStream fos=new FileOutputStream(file);

        res.setContentLengthLong(file.length());
        fos.close();
    }

}
