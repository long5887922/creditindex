package com.zy.creditindex.entity.idri;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ${ZhaoYing}on 2017/11/16 0016
 */
public class IdriJson implements Serializable {
    private Date startTime;
    private Date endTime;
    private String type;
    private String idricode;

    public IdriJson() {
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdricode() {
        return idricode;
    }

    public void setIdricode(String idricode) {
        this.idricode = idricode;
    }

    @Override
    public String toString() {
        return "IdriJson{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", type='" + type + '\'' +
                ", idricode='" + idricode + '\'' +
                '}';
    }
}
