package com.zy.creditindex.entity.pk;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
@Embeddable
public class IdriPK implements Serializable{
    private String inducode;// indu_code VARCHAR(4),   -- 行业代码
    private Date indexdate;//index_date DATE,        -- 指数计算日期
    private String weighttype ; //weight_type VARCHAR(4), -- 加权类型（01：等权；02：债券加权）

    @Column(name = "indu_code")
    public String getInducode() {
        return inducode;
    }

    public void setInducode(String inducode) {
        this.inducode = inducode;
    }
    @Column(name = "index_date")
    public Date getIndexdate() {
        return indexdate;
    }

    public void setIndexdate(Date indexdate) {
        this.indexdate = indexdate;
    }
    @Column(name = "weight_type")
    public String getWeighttype() {
        return weighttype;
    }

    public void setWeighttype(String weighttype) {
        this.weighttype = weighttype;
    }
}
