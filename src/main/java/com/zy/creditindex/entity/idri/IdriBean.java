package com.zy.creditindex.entity.idri;


import com.zy.creditindex.entity.pk.IdriPKBean;


import javax.persistence.*;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
@Entity
@IdClass(IdriPKBean.class)
@Table(name = "idri")
public class IdriBean implements Serializable {
    // PRIMARY KEY(indu_code, index_date, weight_type)
    private String inducode;// indu_code VARCHAR(4),   -- 行业代码
    private Date indexdate;//index_date DATE,        -- 指数计算日期
    private String weighttype ; //weight_type VARCHAR(4), -- 加权类型（01：等权；02：债券加权）
    private Integer corpcount;  //corp_count INT,         -- 公司个数。真正计算在内的公司
    private BigDecimal idri;//idri DECIMAL(30, 4),    -- 行业信贷违约指数

    @Id
    @Column(name = "indu_code")
    public String getInducode() {
        return inducode;
    }

    public void setInducode(String inducode) {
        this.inducode = inducode;
    }
    @Id
    @Column(name = "index_date")
    public Date getIndexdate() {
        return indexdate;
    }

    public void setIndexdate(Date indexdate) {
        this.indexdate = indexdate;
    }
    @Id
    @Column(name = "weight_type")
    public String getWeighttype() {
        return weighttype;
    }

    public void setWeighttype(String weighttype) {
        this.weighttype = weighttype;
    }
    @Column(name = "corp_count")
    public Integer getCorpcount() {
        return corpcount;
    }

    public void setCorpcount(Integer corpcount) {
        this.corpcount = corpcount;
    }
    public BigDecimal getIdri() {
        return idri;
    }
    public void setIdri(BigDecimal idri) {
        this.idri = idri;
    }
}
