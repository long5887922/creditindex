package com.zy.creditindex.repostory;

import com.zy.creditindex.entity.CreditIndex;
import com.zy.creditindex.util.SortTools;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/9/23 0023
 */
public interface IndexRepostory extends JpaRepository<CreditIndex,String> {
    /**
     * 通过日期查询//猜测，时间不支持当查询条件或需要特殊处理才行
     */
    public List<CreditIndex> findByReportdate(Date report_date);

    /**
     * 用公司ID查询
     * @param com_id
     * @return
     * 注：自定义的方法名中不能带有“_”下划线，否则启动服务时报错 ：Stopping service [Tomcat]，在实体类中找不到
     */
    @Query(value ="select t.* from corporate_edf t where t.com_id = ?1",nativeQuery = true)
    public List<CreditIndex> findByCom_id(BigInteger com_id);

    /**
     * 股票ID和日期联合查询
     * @param trd_code
     * @param report_date
     * @return
     */
    @Query(value ="select t.* from corporate_edf t where t.trd_code = ?1 and t.report_date=?2",nativeQuery = true)
    public CreditIndex findByTrd_codeAndrReport_date(String trd_code, Date report_date);

    /**
     * 时间段和公司股票ID联合查询
     * @param trd_code
     * @param starttime
     * @param endtime
     * @return
     */
    @Query(value ="select t.* from corporate_edf t where t.trd_code = ?1 and t.report_date>=?2 and t.report_date<=?3",nativeQuery = true)
    public List<CreditIndex> findByReportdates(String trd_code, Date starttime,Date endtime);

    /**
     * 任意时间段查询（升序）
     * @param starttime
     * @param endtime
     * @return
     */
    @Query(value ="select t.* from corporate_edf t where  t.report_date>=?1 and t.report_date<=?2 order by t.report_date asc",nativeQuery = true)
    public List<CreditIndex> findByTimeSlot( Date starttime,Date endtime);
}
