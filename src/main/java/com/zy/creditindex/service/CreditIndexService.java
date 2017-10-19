package com.zy.creditindex.service;

import com.zy.creditindex.entity.CreditIndex;
import com.zy.creditindex.repostory.IndexRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/9/26 0026
 */
@Service
public class CreditIndexService {
    @Autowired
    IndexRepostory indexrepostory;

    /**
     * 查询全部数据
     * @return
     */
    public List<CreditIndex> queryAll(){
       return indexrepostory.findAll();
    }

    /**
     * 查询单个的一条数据
     * @param trd_code
     * @return
     */
    public CreditIndex queryOne(String trd_code){
        return indexrepostory.findOne(trd_code);
    }

    /**
     * 查询当日股票数据
     * @param trd_code
     * @param report_date
     * @return
     */
    public CreditIndex queryDayData(String trd_code, Date report_date){
        return indexrepostory.findByTrd_codeAndrReport_date(trd_code,report_date);
    }

    /**
     * 查询每个独立日期产生的各项数据
     * @param report_date
     * @return
     */
    public List<CreditIndex> queryIndependentDate(Date report_date){
        return indexrepostory.findByReportdate(report_date);
    }

    /**
     * 用公司ID查询
     * @param comid
     * @return
     */
    public List<CreditIndex> queryCompanyID(BigInteger comid){
        return indexrepostory.findByComid(comid);
    }

    /**
     * 任何时间段查询根据公司股票查询
     * @param trd_code
     * @param startime
     * @param endtime
     * @return
     */
    public List<CreditIndex>  queryCompanyStockAnytime(String trd_code, Date startime,Date endtime){
        return indexrepostory.findByReportdates(trd_code,startime,endtime);
    }
}
