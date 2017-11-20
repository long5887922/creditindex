package com.zy.creditindex.controller.indexandidri;


import com.zy.creditindex.entity.JsonEntry;
import com.zy.creditindex.entity.idri.BastrdtINFOBean;
import com.zy.creditindex.entity.idri.IdriBean;


import com.zy.creditindex.entity.idri.IdriJson;
import com.zy.creditindex.service.IndexService.BastrdtInfoService;
import com.zy.creditindex.service.IndexService.IdriService;
import com.zy.creditindex.util.DateUtil;
import com.zy.creditindex.util.IdriUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;



/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
@RestController
@RequestMapping(value = "/idri")
//@CacheConfig(cacheNames = "basecache")
public class IdriContorller {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    protected static final Logger logger = LoggerFactory.getLogger(IdriContorller.class);
    @Autowired
    private IdriService idriService;
    //初始化权重
    private String weighttype = "01";//默认等权
    @Autowired
    private BastrdtInfoService bastrdtInfoService;

//    private CacheManager cacheManager;
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
    public List<IdriBean> queryByTimesTotto(Date starttime,
                                            @DateTimeFormat(pattern = "yyyy-MM-dd")
                                            Date endtime){

        Date date;
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
        logger.info("排名类型："+Yoyg);
        logger.info("加权类型："+weighttype);
        List<IdriBean> indexdateNew = null;//接收返回的值，不用重新new新的ArrayList
        try {
            int week = DateUtil.getWeekend();
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
                BastrdtINFOBean  bday = this.effectiveDate(endtime);//获取昨天对应的是上个月
                Date onemonth = bday.getB_1mDay();//获取上个月对应的最近有效日期
                List<IdriBean> beforeidri  = idriService.findIndexdateNew(onemonth,weighttype);//获取上月的数据
                BastrdtINFOBean ybday = this.effectiveDate(endtime);//获取昨天的日期
                Date yestrd_day = ybday.getTrd_day();//获取昨天对应的最近交易日
                indexdateNew =idriService.findIndexdateNew(yestrd_day,weighttype);//(获取昨天的数据);
                indexdateNew =ProportionalValue(indexdateNew,beforeidri);//同比环比计算
                indexdateNew =IdriUtil.idriName(indexdateNew);
            }else if(Yoyg.equals("week")){
                BastrdtINFOBean bday = this.effectiveDate(endtime);//获取上周的日期
                Date lastweek = bday.getB_5dDay();//获取上周对应的最近交易日
                List<IdriBean> beforeidri  = idriService.findIndexdateNew(lastweek,weighttype);//获取上周数据
                BastrdtINFOBean ybday = this.effectiveDate(endtime);//获取昨天的日期
                Date yestrd_day = ybday.getTrd_day();//获取昨天对应的最近交易日
                indexdateNew =idriService.findIndexdateNew(yestrd_day,weighttype);//(获取昨天的数据);
                indexdateNew =ProportionalValue(indexdateNew,beforeidri);//同比环比计算
                indexdateNew =IdriUtil.idriName(indexdateNew);//X轴的汉字转换
            }else {
                if(week==1||week==7){
                    BastrdtINFOBean  bday = this.effectiveDate(endtime);//拿到最近有效交易日trd_day
                    Date trd_day = bday.getTrd_day();
                    Date beforeTradingDay = DateUtil.thedayBeforeTheLatestTradingDay(trd_day);//最近交易日的前一天
                    List<IdriBean> beforeTradingidri = idriService.DailyChain(beforeTradingDay, weighttype);//最近交易日前一天的数据
                    indexdateNew  =  idriService.findIndexdateNew(trd_day,weighttype);//周末没有交易(默认查询最近交易日)
                    indexdateNew =ProportionalValue(indexdateNew,beforeTradingidri);//同比环比计算
                    indexdateNew =IdriUtil.idriName(indexdateNew);
                }else {
                    Date Before;
                    if(week==2){//周一的情况
                        Before = DateUtil.threeDaysAgo();
                    }else{//正常情况
                        Before = DateUtil.theDayBeforeYesterday();//前天的时间
                    }
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
     * 同比环比算法
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
        return day;
    }

    @PostMapping("/testDailyChainls")
    @ResponseBody
    public  HashMap<String, Object> testDailyChainls(Date indexdate,String weighttype) throws Exception {//@RequestBody JsonEntry data
       System.out.println(indexdate+weighttype);
        Date endtime = DateUtil.endtime();//当前时间（昨天）
        BastrdtINFOBean ytrd_day = this.effectiveDate(endtime);//拿到昨天最近有效交易日yesterdaytrd_day|format.parse(data.getStartTime())
        Date yesterdaytrd_day = ytrd_day.getTrd_day();
        Date taday = DateUtil.taday();//今天（一般当天没有数据）
        HashMap<Object, Object> header = new HashMap<>();
        HashMap<Object, Object> body = new HashMap<>();
        header.put("RetCode","3333");
        header.put("RetMessage","SUCCESS");
        List<IdriBean> idriBeans = idriService.DailyChainls(yesterdaytrd_day,"01");// data.getCreditorType()
//        ==============================================
        logger.info("//////////>>返回值："+idriBeans.toString());
        Map<String, String> mapcode = IdriBean.getMap();
     if(idriBeans.size()==0){
         body.put("0000","系统提示！未找到有效数据······");
     }else {
         for (IdriBean i:idriBeans) {
             for (String key : mapcode.keySet()){
                 if(key.equals(i.getInducode())){
                     i.setInducode(mapcode.get(key));
                     body.put(i.getInducode(),i.getIdri());
                 }
             }
         }
     }
//        =======================================
        HashMap<String, Object> object = new HashMap<>();
        object.put("Header",header);
        object.put("Body",body);
//        String sttr = JSONObject.fromObject(object);
        System.out.println(object);
        return object;
    }

    /**
     * 对外提供行业信贷违约指数的查询接口
     * @param idriJson
     * @return
     * @throws Exception
     */
    @PostMapping("/request/idriData")
    @ResponseBody
    public  HashMap<String, Object> idriData(@RequestBody IdriJson idriJson) throws Exception {//Date startTime, Date endTime, String type, String trade
        logger.info("==================>请求时间段从："+idriJson.getStartTime()+"-"+idriJson.getEndTime()+";请求方式："+idriJson.getType()+";行业代码："+idriJson.getIdricode());
        BastrdtINFOBean bday = this.effectiveDate(idriJson.getStartTime());//拿到开始时间对应的最近交易日为了保证每次查询都有数据
        Date beforetrd_startTime = bday.getTrd_day();
        BastrdtINFOBean eday = this.effectiveDate(idriJson.getEndTime());//拿到结束时间对应的最近交易日符合业务了逻辑
        Date beforetrd_endTime = eday.getTrd_day();
        logger.info("==================>实际有效交易日："+beforetrd_startTime+"-"+beforetrd_endTime+";请求方式："+idriJson.getType()+";行业代码："+idriJson.getIdricode());
        HashMap<Object, Object> header = new HashMap<>();
        HashMap<Object, Object> body = new HashMap<>();
        HashMap<String, Object> object = new HashMap<>();
        header.put("RetCode","3333");
        header.put("RetMessage","SUCCESS");
        List<IdriBean>  bodyList = idriService.queryIdriByTrade(beforetrd_startTime,beforetrd_endTime,idriJson.getType(),idriJson.getIdricode());
        logger.info("//////////>>返回值："+bodyList.toString());
        Map<String, String> mapcode = IdriBean.getMap();
        if(bodyList.size()==0){
            body.put("0000","系统提示！未找到有效数据······");
        }else {
            for (IdriBean i:bodyList) {
                for (String key : mapcode.keySet()){
                    if(key.equals(i.getInducode())){
                        i.setInducode(mapcode.get(key));
                        body.put(i.getInducode(),i.getIdri());
                    }
                }
            }
        }
        object.put("Header",header);
        object.put("Body",body);
        return object;
    }
//清除缓存
    @GetMapping("/removedCache")
    public String removedCache(){
        return idriService.removedCache();
    }

}
