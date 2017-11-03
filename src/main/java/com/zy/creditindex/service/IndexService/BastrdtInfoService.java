package com.zy.creditindex.service.IndexService;

import com.zy.creditindex.entity.idri.BastrdtInfoBean;
import com.zy.creditindex.repostory.indexJpa.BastrdtInfoRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by huaqin on 2017/10/31.
 */
@Service
@Repository
public class BastrdtInfoService {
    @Autowired
    private BastrdtInfoRepostory bs;
    /*查询交易日*/
    public BastrdtInfoBean queryStartTime(Date dateTime){
        return bs.queryStartTime(dateTime);
    }
    /*查询10天前的交易日期*/
    public BastrdtInfoBean queryBeforTime(Date dateTime){
        return bs.queryBeforTime(dateTime);
    }

    /*查询10天前至前一天的交易日*/
    public List<BastrdtInfoBean> findWithinTenDay(Date startTime,Date endTime){
        return bs.findWithinTenDay(startTime,endTime);
    }
}
