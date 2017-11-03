package com.zy.creditindex.service.IndexService;


import com.zy.creditindex.entity.idri.IdriBean;
import com.zy.creditindex.repostory.indexJpa.IdriRepostory;
import com.zy.creditindex.util.SortTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
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
        return idriRepostory.findIdriByCodeAndDate(inducode, indexdate);
    }

    /**
     * 加权类型,行业代码,指数计算日期联合查询
     * @return
     */
    public IdriBean findIdriByCDT(String inducode, Date indexdate,String weighttype){
        return idriRepostory.findIdriByCDT(inducode, indexdate, weighttype);
    }
    /**
     * 任意时间段查询
     * @param starttime
     * @param endtime
     * @return
     */
    public List<IdriBean> findIdriByTimesTotto( Date starttime, Date endtime){
        return idriRepostory.findByTimesTotto(starttime, endtime);
    }
    /**
     * 行业代码和加权等权计算日期联合查询
     * @param startTime
     * @param endTime
     * @param weightType
     * @return
     */
    public List<IdriBean> queryIdriByCondition(Date startTime,Date endTime,String weightType ){
        return idriRepostory.queryIdriByCondition(startTime, endTime, weightType);
    }

    /**
     *当前时间的违约指数
     * @param indexdate
     * @return
     */
    public List<IdriBean> findIndexdateNew(Date indexdate,String weighttype){
//        return idriRepostory.findByIndexdate(indexdate);
        List<IdriBean> byIndexdate = idriRepostory.findByIndexdate(indexdate,weighttype);
        for (IdriBean date:byIndexdate) {
           if (date.getInducode().equals("I")){
               date.setInducode("信息");
           }else if (date.getInducode().equals("B")){
               date.setInducode("采矿业");
           }else if(date.getInducode().equals("C")){
               date.setInducode("制造业");
           }else if(date.getInducode().equals("D")){
               date.setInducode("电热气");
           }else if(date.getInducode().equals("E")){
               date.setInducode("建筑业");
           }else if(date.getInducode().equals("F")){
               date.setInducode("批发");
           }else if(date.getInducode().equals("G")){
               date.setInducode("交通业");
           }else if(date.getInducode().equals("K")){
               date.setInducode("房地产");
           }
        }
        return byIndexdate;
    }
}
