package com.zy.creditindex.controller.indexandidri;


import com.zy.creditindex.entity.idri.BastrdtINFOBean;
import com.zy.creditindex.entity.idri.IdriBean;


import com.zy.creditindex.service.IndexService.BastrdtInfoService;
import com.zy.creditindex.service.IndexService.IdriService;
import com.zy.creditindex.util.DateUtil;
import com.zy.creditindex.util.IdriUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private BastrdtInfoService bastrdtInfoService;
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
    public List<IdriBean> queryTimeTotto()throws Exception {
        Date starttime = DateUtil.starttime();
        Date endtime = DateUtil.endtime();
        return idriService.findIdriByTimesTotto(starttime,endtime);
    }

    /**
     * 风险指数同比时间段
     * @return
     */
    @GetMapping("/queryOneYerTotto")
    public List<IdriBean> queryOneYerTotto()throws Exception {
        Date starttime = DateUtil.oneYer();//一年前的数据
        Date endtime = DateUtil.endtime();
        return idriService.findIdriByTimesTotto(starttime,endtime);
    }

    /**
     * 八个行业信贷风险指数排名
     * 参数：
     * 1.（Yoyg）行业内排名：同比环比（默认获取），当前时间（默认获取）
     * 2.（weighttype）加权类型（总页面获取,默认等权）//01：等权；02：债券加权
     */
    @PostMapping("/queryIndexdateNew")
    public List<IdriBean> queryIndexdateNew(String Yoyg, String weighttype){//Yoyg
        System.out.println("排名类型："+Yoyg);
        System.out.println("加权类型："+weighttype);
        List<IdriBean> indexdateNew = null;//接收返回的值，不用重新new新的ArrayList
        try {
            Date endtime = DateUtil.endtime();//当前时间（昨天）
            if(Yoyg.equals("yer")){
                Date oneyer = DateUtil.oneYer();//一年前的日期
                BastrdtINFOBean bday = this.effectiveDate(oneyer);//获取有效日期
                Date oneyestrd_day = bday.getTrd_day();//获取一年前的最近交易有效日
                List<IdriBean> beforeidri  = idriService.findIndexdateNew(oneyestrd_day, weighttype);//获取去年的数据
                BastrdtINFOBean ybday = this.effectiveDate(endtime);//获取昨天的日期
                Date yestrd_day = ybday.getTrd_day();//获取昨天对应的最近交易日
                indexdateNew =idriService.findIndexdateNew(yestrd_day,weighttype);//(获取昨天的数据);
                indexdateNew =ProportionalValue(indexdateNew,beforeidri);//同比环比计算
                indexdateNew =IdriUtil.idriName(indexdateNew);
            }else if(Yoyg.equals("months")){
//                Date onemonth = DateUtil.starttime();//一个月前的数据
                BastrdtINFOBean  bday = this.effectiveDate(endtime);//获取昨天对应的是上个月
                Date onemonth = bday.getB_1mDay();//获取上个月对应的最近有效日期
                List<IdriBean> beforeidri  = idriService.findIndexdateNew(onemonth,weighttype);//获取上月的数据
                BastrdtINFOBean ybday = this.effectiveDate(endtime);//获取昨天的日期
                Date yestrd_day = ybday.getTrd_day();//获取昨天对应的最近交易日
                indexdateNew =idriService.findIndexdateNew(yestrd_day,weighttype);//(获取昨天的数据);
                indexdateNew =ProportionalValue(indexdateNew,beforeidri);//同比环比计算
                indexdateNew =IdriUtil.idriName(indexdateNew);
            }else if(Yoyg.equals("week")){
//                Date lastweek = DateUtil.lastWeek();//获取当天对应的上周的日期
                BastrdtINFOBean bday = this.effectiveDate(endtime);//获取上周的日期
                Date lastweek = bday.getB_5dDay();//获取上周对应的最近交易日
                List<IdriBean> beforeidri  = idriService.findIndexdateNew(lastweek,weighttype);//获取上周数据
                BastrdtINFOBean ybday = this.effectiveDate(endtime);//获取昨天的日期
                Date yestrd_day = ybday.getTrd_day();//获取昨天对应的最近交易日
                indexdateNew =idriService.findIndexdateNew(yestrd_day,weighttype);//(获取昨天的数据);
                indexdateNew =ProportionalValue(indexdateNew,beforeidri);//同比环比计算
                indexdateNew =IdriUtil.idriName(indexdateNew);//X轴的汉字转换
            }else {
//                Date endtime = DateUtil.endtime();//当前时间（昨天）
                int week = DateUtil.getWeekend();
                if(week==1||week==7){
                    BastrdtINFOBean  bday = this.effectiveDate(endtime);//拿到最近有效交易日trd_day
                    Date trd_day = bday.getTrd_day();
                    Date beforeTradingDay = DateUtil.thedayBeforeTheLatestTradingDay(trd_day);//最近交易日的前一天
                    List<IdriBean> beforeTradingidri = idriService.DailyChain(beforeTradingDay, weighttype);//最近交易日前一天的数据
                    indexdateNew  =  idriService.findIndexdateNew(trd_day,weighttype);//周末没有交易(默认查询最近交易日)
                    indexdateNew =ProportionalValue(indexdateNew,beforeTradingidri);//同比环比计算
                    indexdateNew =IdriUtil.idriName(indexdateNew);
                }else {
                    Date Before = DateUtil.theDayBeforeYesterday();//前天的时间
                    BastrdtINFOBean bday = this.effectiveDate(Before);//拿到前天最近有效交易日beforetrd_day
                    Date beforetrd_day = bday.getTrd_day();
                    List<IdriBean> beforeidri = idriService.DailyChain(beforetrd_day, weighttype);//前天的数据
                    BastrdtINFOBean ytrd_day = this.effectiveDate(endtime);//拿到昨天最近有效交易日yesterdaytrd_day
                    Date yesterdaytrd_day = ytrd_day.getTrd_day();
                    indexdateNew =idriService.findIndexdateNew(yesterdaytrd_day,weighttype);//昨天的数据
                    indexdateNew =ProportionalValue(indexdateNew,beforeidri);//同比环比计算
                    indexdateNew =IdriUtil.idriName(indexdateNew);//X轴的汉字转换
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return indexdateNew;
    }

    /**
     * 计算同比环比
     * @param idriBean
     * @param beforeidri
     * @return
     */
    public  List<IdriBean> ProportionalValue(List<IdriBean> idriBean,List<IdriBean> beforeidri){//List<IdriBean> idriBean,List<IdriBean> beforeidri
        List<IdriBean> idri = new ArrayList<IdriBean>();
        for (IdriBean idb:idriBean) {
            for (IdriBean bf:beforeidri) {
                if(idb.getInducode().equals(bf.getInducode())){
                    idb.setIdri(IdriUtil.CalculationIdri(idb.getIdri(),bf.getIdri()));//除
                    idri.add(idb);
                }
            }
        }
        Collections.sort(idri);//排个序升序
        Collections.reverse(idri);//reverse-->>>即可反转降序
        return idri;
    }

    /**
     * 获取最近有效交易日
     * @param atThatTime
     * @return
     */
    public BastrdtINFOBean effectiveDate(Date atThatTime){
        BastrdtINFOBean day = idriService.findRecentTradingDay(atThatTime);//获取最近交易日--》effective有效
//      Date trd_day = day.getTrd_day();//最近交易日--》effective有效
        return day;
    }

    @PostMapping("testDailyChainls")
    public  List<IdriBean> testDailyChainls(Date indexdate, String weighttype){
        List<IdriBean> idriBeans = idriService.DailyChainls(indexdate, weighttype);
        return null;
    }
}
