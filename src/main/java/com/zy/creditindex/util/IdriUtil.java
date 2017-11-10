package com.zy.creditindex.util;

import com.zy.creditindex.entity.idri.IdriBean;

import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/11/9 0009
 */
public class IdriUtil {


    public static List<IdriBean> idriName( List<IdriBean> idriBean){

        for (IdriBean date : idriBean) {
            if (date.getInducode().equals("I")) {
                date.setInducode("信息");
            } else if (date.getInducode().equals("B")) {
                date.setInducode("采矿业");
            } else if (date.getInducode().equals("C")) {
                date.setInducode("制造业");
            } else if (date.getInducode().equals("D")) {
                date.setInducode("电热气");
            } else if (date.getInducode().equals("E")) {
                date.setInducode("建筑业");
            } else if (date.getInducode().equals("F")) {
                date.setInducode("批发");
            } else if (date.getInducode().equals("G")) {
                date.setInducode("交通业");
            } else if (date.getInducode().equals("K")) {
                date.setInducode("房地产");
            }
        }
        return idriBean;
    }
}