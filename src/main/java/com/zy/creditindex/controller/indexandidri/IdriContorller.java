package com.zy.creditindex.controller.indexandidri;

import com.zy.creditindex.entity.idri.IdriBean;

import com.zy.creditindex.service.IndexService.IdriService;
import com.zy.creditindex.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
@RestController
@RequestMapping(value = "/idri")
public class IdriContorller {

    @Autowired
    private IdriService idriService;

    /**
     * 行业代码和指数计算日期联合查询
     * @param inducode
     * @param indexdate
     * @return
     */
    @PostMapping("/codeanddate")
    public List<IdriBean> queryIdriByCodeAndDate(String inducode, Date indexdate){
        return idriService.findIdriByCodeAndDate(inducode,indexdate);
    }

    /**
     * 加权类型,行业代码,指数计算日期联合查询
     * @param inducode
     * @param indexdate
     * @param weighttype
     * @return
     */
    @PostMapping("/cdt")
    public IdriBean queryIdriByCDT(String inducode, Date indexdate, String weighttype){
        return idriService.findIdriByCDT(inducode,indexdate,weighttype);
    }

    /**
     * id查询 问号传参
     * @param inducode
     * @return
     */
    @GetMapping("/idribyid")
    public List<IdriBean> querIdriById(@RequestParam(value = "inducode")String inducode){//@RequestParam(value = "id")
        return idriService.findIdriId(inducode);
    }

    /**
     * 按时间段查询
     * @param starttime
     * @param endtime
     * @return
     */
    @PostMapping("idritimetoto")
    public List<IdriBean> queryByTimesTotto(Date starttime, Date endtime){
        return idriService.findIdriByTimesTotto(starttime,endtime);
    }

    /**
     *根据当前时间自动查询(一个月内的数据)
     * @return
     */
    @GetMapping("/queryTimeTotto")
    public List<IdriBean> queryTimeTotto(){
        Date starttime = DateUtil.starttime();
        Date endtime = DateUtil.endtime();
        return idriService.findIdriByTimesTotto(starttime,endtime);
    }

    /**
     * 风险指数同比时间段
     * @return
     */
    @GetMapping("/queryOneYerTotto")
    public List<IdriBean> queryOneYerTotto(){
        Date starttime = DateUtil.oneYer();//一年前的数据
        Date endtime = DateUtil.endtime();
        return idriService.findIdriByTimesTotto(starttime,endtime);
    }

    /**
     * 同比
     * @return
     */
    @GetMapping("/queryYoyg")
    public List<IdriBean> queryYoyg(){
        Date starttime = DateUtil.oneYer();//一年前的数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format("一年前的年月日："+starttime));
        return idriService.findIndexdateNew(starttime);
    }
    /**
     * 当前时间的违约指数
     * @return
     */
    @PostMapping("/queryIndexdateNew")
    public List<IdriBean> queryIndexdateNew(){//Yoyg
            Date endtime = DateUtil.endtime();
            List<IdriBean> aNew = idriService.findIndexdateNew(endtime);
            for (IdriBean i:aNew) {
                System.out.println( i.getInducode()+":"+i.getIdri());
            }
            return aNew;
    }
}
