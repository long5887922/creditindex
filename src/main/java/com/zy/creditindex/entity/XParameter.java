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
    private String  label;
    /*日期*/
    private List<String> dateTime = new ArrayList<String>();
    /*线型展示连接参数*/
    private List<BigDecimal> data=new ArrayList<BigDecimal>();
    /*小图标颜色*/
    private String pointColor;
    /*折线颜色*/
    private String  strokeColor;
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getPointColor() {
        return pointColor;
    }

    public void setPointColor(String pointColor) {
        this.pointColor = pointColor;
    }
}
