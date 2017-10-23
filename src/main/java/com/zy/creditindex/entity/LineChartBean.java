package com.zy.creditindex.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 线型参数
 * @author huaqin
 * @date 2017/10/19
 */
public class LineChartBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /*日期*/
    private List<String> labels;
    /*线型对象*/
    private List<XParameter> datasets;

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<XParameter> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<XParameter> datasets) {
        this.datasets = datasets;
    }
}
