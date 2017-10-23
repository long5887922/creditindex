package com.zy.creditindex.entity.pk;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
@Embeddable
public class CreditIndexPK implements Serializable {

    private String trd_code;//trd_code VARCHAR(16)-- 公司股票ID。联合主键
    private Date reportdate;// -- 日期。联合主键

    @Column(name = "trd_code")
    public String getTrd_code() {
        return trd_code;
    }

    public void setTrd_code(String trd_code) {
        this.trd_code = trd_code;
    }
    @Column(name = "report_date")
    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }
}
