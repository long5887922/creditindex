package com.zy.creditindex.service.IndexService;

import com.zy.creditindex.entity.idri.IdriBean;

import com.zy.creditindex.repostory.indexJpa.IdriRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
@Service
public class IdriService {
    @Autowired
    private IdriRepostory idriRepostory;

    /**
     *id查询
     */
    public List<IdriBean> findIdriId(String id){
        return idriRepostory.findByID(id);
    }

    /**
     * 查询所有的数据
     * @return
     */
    public List<IdriBean> findIdriAll(){
        return idriRepostory.findAll();
    }

    /**
     * 行业代码和指数计算日期联合查询
     * @return
     */
    public List<IdriBean> findIdriByCodeAndDate(String inducode, Date indexdate){
        return idriRepostory.findIdriByCodeAndDate(inducode,indexdate);
    }

    /**
     * 加权类型,行业代码,指数计算日期联合查询
     * @return
     */
    public IdriBean findIdriByCDT(String inducode, Date indexdate,String weighttype){
        return idriRepostory.findIdriByCDT(inducode,indexdate,weighttype);
    }

    /**
     * 任意时间段查询
     * @param starttime
     * @param endtime
     * @return
     */
    public List<IdriBean> findIdriByTimesTotto( Date starttime, Date endtime){
        return idriRepostory.findByTimesTotto(starttime,endtime);
    }
}
