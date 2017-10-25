package com.zy.creditindex.entity;

import com.zy.creditindex.entity.pk.CreditIndexPK;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by ${ZhaoYing}on 2017/9/23 0023
 */
@Entity
@IdClass(CreditIndexPK.class)
@Table(name = "corporate_edf")
public class CreditIndex {

    private String trd_code;//trd_code VARCHAR(16)-- 公司股票ID。联合主键
    private Date reportdate;// -- 日期。联合主键
    private Integer exch_code;  //    exch_code INT,                -- 证券类型（上证/深证等）
    private BigInteger comid;   //    com_id BIGINT,                 -- 公司ID
    private BigInteger secu_id;  //    secu_id BIGINT,                 -- 证券ID
    private BigDecimal ttl_cur_liab;//    ttl_cur_liab DECIMAL(20, 4),    -- 短债
    private BigDecimal ttl_ncur_liab;//    ttl_ncur_liab DECIMAL(20, 4),   -- 长债
    private BigDecimal tmkt_val;//    tmkt_val DECIMAL(20, 4),        -- 股权市值
    private BigDecimal equity_theta; //    equity_theta DECIMAL(12, 8),    -- 波动率
    private BigDecimal edf;//    edf DECIMAL(10, 6), ##预期违约概率 /预期违约概率（Expected Default Frequency），单位（%）

    /**
     * 需提供无参构造
     */
    public CreditIndex() {
    }
    @Id
    @Column(name = "trd_code")
    public String getTrd_code() {
        return trd_code;
    }

    public void setTrd_code(String trd_code) {
        this.trd_code = trd_code;
    }
    @Id
    @Column(name = "report_date")
    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public Integer getExch_code() {
        return exch_code;
    }

    public void setExch_code(Integer exch_code) {
        this.exch_code = exch_code;
    }

    @Column(name = "com_id")
    public BigInteger getComid() {
        return comid;
    }

    public void setComid(BigInteger comid) {
        this.comid = comid;
    }

    public BigInteger getSecu_id() {
        return secu_id;
    }

    public void setSecu_id(BigInteger secu_id) {
        this.secu_id = secu_id;
    }

    public BigDecimal getTtl_cur_liab() {
        return ttl_cur_liab;
    }

    public void setTtl_cur_liab(BigDecimal ttl_cur_liab) {
        this.ttl_cur_liab = ttl_cur_liab;
    }

    public BigDecimal getTtl_ncur_liab() {
        return ttl_ncur_liab;
    }

    public void setTtl_ncur_liab(BigDecimal ttl_ncur_liab) {
        this.ttl_ncur_liab = ttl_ncur_liab;
    }

    public BigDecimal getTmkt_val() {
        return tmkt_val;
    }

    public void setTmkt_val(BigDecimal tmkt_val) {
        this.tmkt_val = tmkt_val;
    }

    public BigDecimal getEquity_theta() {
        return equity_theta;
    }

    public void setEquity_theta(BigDecimal equity_theta) {
        this.equity_theta = equity_theta;
    }

    public BigDecimal getEdf() {
        return edf;
    }

    public void setEdf(BigDecimal edf) {
        this.edf = edf;
    }

    @Override
    public String toString() {
        return "CreditIndex{" +
                "trd_code='" + trd_code + '\'' +
                ", reportdate=" + reportdate +
                ", exch_code=" + exch_code +
                ", comid=" + comid +
                ", secu_id=" + secu_id +
                ", ttl_cur_liab=" + ttl_cur_liab +
                ", ttl_ncur_liab=" + ttl_ncur_liab +
                ", tmkt_val=" + tmkt_val +
                ", equity_theta=" + equity_theta +
                ", edf=" + edf +
                '}';
    }
}
