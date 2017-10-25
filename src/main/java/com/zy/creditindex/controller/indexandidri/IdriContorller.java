package com.zy.creditindex.controller.indexandidri;

import com.zy.creditindex.entity.idri.idri;
import com.zy.creditindex.service.IndexService.IdriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    public List<idri> queryIdriByCodeAndDate(String inducode, Date indexdate){
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
    public idri queryIdriByCDT(String inducode, Date indexdate,String weighttype){
        return idriService.findIdriByCDT(inducode,indexdate,weighttype);
    }

    /**
     * id查询
     * @param inducode
     * @return
     */
    @GetMapping("/idribyid")
    public List<idri> querIdriById(@RequestParam(value = "id")String inducode){
        return idriService.findIdriId(inducode);
    }

    /**
     * 按时间段查询
     * @param starttime
     * @param endtime
     * @return
     */
    @PostMapping("idritimetoto")
    public List<idri> queryByTimesTotto(Date starttime,Date endtime){
        return idriService.findByTimesTotto(starttime,endtime);
    }
}
