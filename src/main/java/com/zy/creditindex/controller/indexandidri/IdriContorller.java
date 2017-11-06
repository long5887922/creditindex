package com.zy.creditindex.controller.indexandidri;

import com.zy.creditindex.entity.idri.IdriBean;

import com.zy.creditindex.service.IndexService.IdriService;
import com.zy.creditindex.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
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
    //初始化权重
    private String weighttype = "01";//默认等权
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
    @PostMapping("/queryYoygT")
    public List<IdriBean> queryYoygT(){
        Date starttime = DateUtil.oneYer();//一年前的数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("一年前的年月日："+format.format(starttime));
        return idriService.findIndexdateNew(starttime,weighttype);
    }

    /**
     * 环比
     * @return
     */
    @PostMapping("/queryYoygH")
    public List<IdriBean> queryYoygH(){
        Date onemonth = DateUtil.starttime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("一月前的年月日："+format.format(onemonth));
        return idriService.findIndexdateNew(onemonth,weighttype);
    }
    /**
     * 当前时间的违约指数
     * 参数：
     * 1.行业内排名：同比环比（默认获取），当前时间（默认获取）
     * 2.加权类型（总页面获取,默认等权）//01：等权；02：债券加权
     */
    @PostMapping("/queryIndexdateNew")
    public List<IdriBean> queryIndexdateNew(String Yoyg,String weighttype){//Yoyg
        System.out.println("排名类型"+Yoyg);
        System.out.println("加权类型："+weighttype);
        if(Yoyg=="yer"){
            Date oneyer = DateUtil.oneYer();//一年前的数据
            return idriService.findIndexdateNew(oneyer,weighttype);
        }else if(Yoyg=="months"){
            Date onemonth = DateUtil.starttime();//一个月前的方法
            return idriService.findIndexdateNew(onemonth,weighttype);
        }else {
            Date endtime = DateUtil.endtime();
            List<IdriBean> aNew = idriService.findIndexdateNew(endtime,weighttype);
            for (IdriBean i:aNew) {
                System.out.println("行业-->"+ i.getInducode()+"；违约指数:"+i.getIdri()+"；加权类型："+i.getWeighttype());
            }
            return aNew;
        }

    }
}
