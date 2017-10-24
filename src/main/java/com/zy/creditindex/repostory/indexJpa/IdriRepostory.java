package com.zy.creditindex.repostory.indexJpa;

import com.zy.creditindex.entity.idri.idri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
public interface IdriRepostory extends JpaRepository<idri,String> {

    //通过id查询
    @Query(value ="select i.indu_code,i.index_date,i.weight_type,i.corp_count,i.idri from idri i where i.indu_code = ?1",nativeQuery = true)
    public List<idri> findByID(String inducode);

    //行业代码和指数计算日期联合查询
    @Query(value ="select i.indu_code,i.index_date,i.weight_type,i.corp_count,i.idri from idri i where i.indu_code = ?1 and i.index_date=?2",nativeQuery = true)
    public List<idri> findIdriByCodeAndDate(String inducode, Date indexdate);

    //加权类型,行业代码,指数计算日期联合查询
    @Query(value ="select i.indu_code,i.index_date,i.weight_type,i.corp_count,i.idri from idri i where i.indu_code = ?1 and i.index_date=?2 and i.weight_type = ?3",nativeQuery = true)
    public idri findIdriByCDT(String inducode, Date indexdate,String weighttype);

}
