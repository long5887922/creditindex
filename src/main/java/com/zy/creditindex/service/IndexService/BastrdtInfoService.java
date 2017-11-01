package com.zy.creditindex.service.IndexService;

import com.zy.creditindex.entity.idri.BastrdtINFOBean;
import com.zy.creditindex.repostory.indexJpa.BastrdtInfoRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by huaqin on 2017/10/31.
 */
@Service
public class BastrdtInfoService {
    @Autowired
    private BastrdtInfoRepostory bs;
    /*查询交易日*/
    public BastrdtINFOBean queryStartTime(Date dateTime){
        return bs.queryStartTime(dateTime);
    }
    /*查询10天前的交易日期*/
    public BastrdtINFOBean queryBeforTime(Date dateTime){
        return bs.queryBeforTime(dateTime);
    }
}
