package com.zy.creditindex.service.IndexService;


import com.zy.creditindex.entity.idri.BastrdtINFOBean;
import com.zy.creditindex.entity.idri.IdriBean;
import com.zy.creditindex.repostory.indexJpa.IdriRepostory;
import com.zy.creditindex.service.IndexService.ideiSeriviceInterface.IdriServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
@Service
@Transactional
public class IdriService implements IdriServiceInterface {
    @Autowired
    private IdriRepostory idriRepostory;

    /**
     * id查询
     */
    public List<IdriBean> findIdriId(String id) {
        return idriRepostory.findByID(id);
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    public List<IdriBean> findIdriAll() {
        return idriRepostory.findAll();
    }

    /**
     * 行业代码和指数计算日期联合查询
     *
     * @return
     */
    public List<IdriBean> findIdriByCodeAndDate(String inducode, Date indexdate) {
        return idriRepostory.findIdriByCodeAndDate(inducode, indexdate);
    }

    /**
     * 加权类型,行业代码,指数计算日期联合查询
     *
     * @return
     */
    public IdriBean findIdriByCDT(String inducode, Date indexdate, String weighttype) {
        return idriRepostory.findIdriByCDT(inducode, indexdate, weighttype);
    }

    /**
     * 任意时间段查询
     *
     * @param starttime
     * @param endtime
     * @return
     */
    public List<IdriBean> findIdriByTimesTotto(Date starttime, Date endtime) {
        return idriRepostory.findByTimesTotto(starttime, endtime);
    }

    /**
     * 行业代码和加权等权计算日期联合查询
     *
     * @param startTime
     * @param endTime
     * @param weightType
     * @return
     */
    public List<IdriBean> queryIdriByCondition(Date startTime, Date endTime, String weightType) {
        return idriRepostory.queryIdriByCondition(startTime, endTime, weightType);
    }

    /**
     * 行业代码和加权等权计算日期联合查询降序
     *
     * @param startTime
     * @param endTime
     * @param weightType
     * @return
     */
    public List<IdriBean> queryIdriByGradeDown(Date startTime, Date endTime, String weightType) {
        return idriRepostory.queryIdriByGradeDown(startTime, endTime, weightType);
    }

    /**
     * 八个行业信贷风险指数排名
     *
     * @param indexdate  查询日期（当前日期，同比，环比）
     * @param weighttype 加权类型（等权/加权）
     * @return
     */
    public List<IdriBean> findIndexdateNew(Date indexdate, String weighttype) {
        return idriRepostory.findByIndexdate(indexdate, weighttype);
    }

    public List<IdriBean> queryIdriByTrade(Date startTime, Date endTime, String type, String trade) {
        return idriRepostory.queryIdriByTrade(startTime, endTime, type, trade);
    }

    public List<IdriBean> queryAllIdri(Date endTime, String weightType) {
        return idriRepostory.queryAllIdri(endTime, weightType);
    }

    /**
     * 查询最近交易日
     *
     * @param dateTime（当当天日期是非交易日时）
     * @return
     */
    public BastrdtINFOBean findRecentTradingDay(Date dateTime) {
        BastrdtINFOBean d = idriRepostory.findByLatestDate(dateTime);
        System.out.println("-==============最近交易日===================" + d.getTrd_day());
        return idriRepostory.findByLatestDate(dateTime);
    }
}
