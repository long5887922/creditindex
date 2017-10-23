package com.zy.creditindex.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询管理员权限类
 * @author huaqin
 * @date 2017/10/20
 */
public class XParameter implements Serializable{
    /*产业名称*/
    private String name;
    /*日期*/
    private List<String> dateTime = new ArrayList<String>();
    /*线型展示连接参数*/
    private List<BigDecimal> data=new ArrayList<BigDecimal>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDateTime() {
        return dateTime;
    }

    public void setDateTime(List<String> dateTime) {
        this.dateTime = dateTime;
    }

    public List<BigDecimal> getData() {
        return data;
    }

    public void setData(List<BigDecimal> data) {
        this.data = data;
    }
}
