package com.zy.creditindex.controller.indexandidri;

import com.zy.creditindex.entity.idri.IdriBean;

import com.zy.creditindex.service.IndexService.IdriService;
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
     * id查询
     * @param inducode
     * @return
     */
    @GetMapping("/idribyid")
    public List<IdriBean> querIdriById(@RequestParam(value = "id")String inducode){
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
     *根据当前时间自动查询
     * @return
     */
    @GetMapping("/queryTimeTotto")
    public List<IdriBean> queryTimeTotto(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new java.util.Date());//设置当前日期
        calendar.add(Calendar.MONTH, -1);//月份减一
        Date starttime = calendar.getTime();
        Date endtime=new java.sql.Date(new Date().getTime());
        return idriService.findIdriByTimesTotto(starttime,endtime);
    }

}
