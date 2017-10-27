package com.zy.creditindex.controller.indexandidri;

import com.zy.creditindex.chartLine.CreateJFreeChartLine;
import com.zy.creditindex.entity.idri.IdriBean;
import com.zy.creditindex.service.IndexService.IdriService;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleInsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huaqin on 2017/10/26.
 */
@RestController
@RequestMapping(value = "/idri")
public class Query {
    @Autowired
    private IdriService idriService;
    // 设置文件下载路径
    private static final String CHART_PATH = "\\src\\main\\webapp\\img\\";
    /**
     * 行业代码和加权等权计算日期联合查询
     * @param startTime
     * @param endTime
     * @param weightType
     * @return
     */
    @RequestMapping("/queryIdriByCondition")
    public List<IdriBean> queryIdriByCondition(Date startTime,Date endTime,String weightType ){
        List<IdriBean> list =new ArrayList<>();
        list =idriService.queryIdriByCondition(startTime, endTime, weightType);
        /*获取集合对象日期值和长度*/
        List<IdriBean> listAll = new ArrayList<>();
        /*采矿业(B)*/
        List<Double> listB = new ArrayList<>();
        String b="";
        /*制造业(C)*/
        List<Double> listC = new ArrayList<>();
        String c="";
         /*电力、热力、燃气及水生产和供应业(D)*/
        List<Double> listD = new ArrayList<>();
        String d="";
         /*建筑业(E)*/
        List<Double> listE = new ArrayList<>();
        String e="";
         /*批发和零售业(F)*/
        String f="";
        List<Double> listF = new ArrayList<>();
         /*交通运输、仓储和邮政业(G)*/
        List<Double> listG = new ArrayList<>();
        String g="";
         /*信息传输、软件和信息技术服务业(I))*/
        List<Double> listI = new ArrayList<>();
        String i="";
         /*房地产业(K)*/
        List<Double> listK = new ArrayList<>();
        String k="";
        /*根据编码设置行业名称*/
        for(int j=0; j<list.size();j++){
          if("B".equals(list.get(j).getInducode())){
              listAll.add(list.get(j));
              listB.add(list.get(j).getIdri().doubleValue());
              if(""==b){
                  b="采矿业";
              }
          }else if("C".equals(list.get(j).getInducode())){
              listC.add(list.get(j).getIdri().doubleValue());
              if(""==c){
                  c="制造业";
              }
          }else if("D".equals(list.get(j).getInducode())){
              listD.add(list.get(j).getIdri().doubleValue());
              if(""==d){
                  d="电力、热力、燃气及水生产和供应业";
              }
          }else if("E".equals(list.get(j).getInducode())){
              listE.add(list.get(j).getIdri().doubleValue());
              if(""==e){
                  e="建筑业";
              }
          }else if("F".equals(list.get(j).getInducode())){
              listF.add(list.get(j).getIdri().doubleValue());
              if(""==f){
                  f="批发和零售业";
              }
          }else if("G".equals(list.get(j).getInducode())){
              listG.add(list.get(j).getIdri().doubleValue());
              if(""==g){
                  g="交通运输、仓储和邮政业";
              }
          }else if("I".equals(list.get(j).getInducode())){
              listI.add(list.get(j).getIdri().doubleValue());
              if(""==i){
                  i="信息传输、软件和信息技术服务业";
              }
          }else if("K".equals(list.get(j).getInducode())){
              listK.add(list.get(j).getIdri().doubleValue());
              if(""==k){
                  k="房地产业";
              }
          }
        }

        String[] rowKeys = {b,c,d,e,f,g,i,k};
        String[] columnKeys= new String[listAll.size()];
        for(int a=0;a<listAll.size();a++){
            columnKeys[a] = listAll.get(a).getIndexdate().toString();
        }

        double[] bbb=new double[listB.size()];
        double[] ccc=new double[listB.size()];
        double[] ddd=new double[listB.size()];
        double[] eee=new double[listB.size()];
        double[] fff=new double[listB.size()];
        double[] ggg=new double[listB.size()];
        double[] iii=new double[listB.size()];
        double[] kkk=new double[listB.size()];
        for(int bb=0;bb<listB.size();bb++){
            bbb[bb]=listB.get(bb);
        } for(int cc=0;cc<listC.size();cc++){
            ccc[cc]=listC.get(cc);
        } for(int dd=0;dd<listD.size();dd++){
            ddd[dd]=listD.get(dd);
        } for(int ee=0;ee<listE.size();ee++){
            eee[ee]=listE.get(ee);
        } for(int ff=0;ff<listF.size();ff++){
            fff[ff]=listF.get(ff);
        } for(int gg=0;gg<listG.size();gg++){
            ggg[gg]=listG.get(gg);
        } for(int ii=0;ii<listI.size();ii++){
            iii[ii]=listI.get(ii);
        } for(int kk=0;kk<listK.size();kk++){
            kkk[kk]=listK.get(kk);
        }
        /*封装折线参数*/
        double[][] data = new double[][]{bbb,ccc,ddd,eee,fff,ggg,iii,kkk};
        CategoryDataset dataset = getBarData(data, rowKeys, columnKeys);
        String title="行业信贷风险指数等权-等权";
        String name="lineAndShap.jpg";
        String weight="02";
        String change="01";
        createTimeXYChar(title, "", "", dataset, name, weight,change);
        return list;
    }
    // 柱状图,折线图 数据集
    public CategoryDataset getBarData(double[][] data, String[] rowKeys,
                                      String[] columnKeys) {
        //return DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
    }
    /**
     * 判断文件夹是否存在，如果不存在则新建
     * @param chartPath
     */
    private void isChartPathExist(String chartPath) {
        File file = new File(chartPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    /**
     * 折线图
     * @param chartTitle
     * @param x
     * @param y
     * @param xyDataset
     * @param charName
     * @return
     */
    public String createTimeXYChar(String chartTitle, String x, String y, CategoryDataset xyDataset, String charName,
                                   String weightType,String change) {

        JFreeChart chart = ChartFactory.createLineChart(chartTitle, x, y, xyDataset, PlotOrientation.VERTICAL, true,
                true, false);
        chart.setTextAntiAlias(false);
        chart.setBackgroundPaint(Color.WHITE);
        // 设置图标题的字体重新设置title
        Font font = new Font("微软雅黑", Font.BOLD, 11);
        // Y轴
		/* Font yfont = new Font("微软雅黑", Font.BOLD, 16); */
        // 底部
        Font kfont = new Font("微软雅黑", Font.BOLD, 14);
        // 图片标题
        Font titleFont = new Font("微软雅黑", Font.BOLD, 17);
        // 设置面板字体
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 11);
        // 获得图表对象
        CategoryPlot p = chart.getCategoryPlot();
        // 设置标签字体
        TextTitle title = new TextTitle(chartTitle);
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        // 设置线条加粗
        LineAndShapeRenderer lasp = (LineAndShapeRenderer) p.getRenderer();
        for (int i = 0; i < xyDataset.getRowKeys().size(); i++) {
            lasp.setSeriesStroke(i, new BasicStroke(3F));
        }
        // x轴 // 分类轴网格是否可见
        categoryplot.setDomainGridlinesVisible(false);
        // y轴 //数据轴网格是否可见
        categoryplot.setRangeGridlinesVisible(true);
        // 设置轴和面板之间的距离
        categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        title.setFont(font);
        chart.setTitle(title);
        chart.getLegend().setItemFont(kfont);
        chart.getTitle().setFont(titleFont);

        p.setBackgroundAlpha(0.1f);
        // 将网格线改为实线
        p.setDomainGridlineStroke(new BasicStroke());
        p.setRangeGridlineStroke(new BasicStroke());
        // 去除背景边框线
        p.setOutlinePaint(null);
        if ("01".equals(weightType)) {
            // 设置图的背景颜色
            // p.setBackgroundPaint(ChartColor.WHITE);
            // 设置表格线颜色
            p.setRangeGridlinePaint(ChartColor.GRAY);
            // 设置表格线颜色
            p.setDomainGridlinePaint(ChartColor.BLACK);
            // 设置外边框颜色
            chart.setBackgroundPaint(Color.WHITE);
        } else {
            // 设置底部图标外围颜色
            chart.getTitle().setBackgroundPaint(new Color(30, 33, 49));

            chart.getLegend().setBackgroundPaint(new Color(30, 33, 49));

            title.setPaint(ChartColor.white);
            // 设置图的背景颜色
            p.setBackgroundPaint(new Color(30, 33, 49));
            p.setBackgroundAlpha(0.1f);
            // 设置表格线颜色
            p.setRangeGridlinePaint(new Color(52, 57, 74));
            // 设置表格线颜色
            p.setDomainGridlinePaint(new Color(52, 57, 74));
            // 设置外边框颜色
            chart.setBackgroundPaint(new Color(30, 33, 49));
        }

        CategoryAxis domainAxis = categoryplot.getDomainAxis();

        domainAxis.setLabelFont(labelFont);// 轴标题

        domainAxis.setTickLabelFont(labelFont);// 轴数值

        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的
        // 设置两轴之间的边距
        domainAxis.setCategoryMargin(1);
        // Lable
        // 45度倾斜
        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.0);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.0);

        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);

        // 获得renderer 注意这里是lineandshaperenderer！！
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();

        lineandshaperenderer.setBaseShapesVisible(false); // series 点（即数据点）可见

        lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
        // 显示折点数据
        // lineandshaperenderer.setBaseItemLabelGenerator(new
        // StandardCategoryItemLabelGenerator());
        // lineandshaperenderer.setBaseItemLabelsVisible(true);

        FileOutputStream fos_jpg = null;
        try {
            File directory = new File("");// 参数为空
            String courseFile = directory.getCanonicalPath();

            String pash = courseFile + CHART_PATH;
            System.out.println(pash);
            isChartPathExist(pash);
            String chartName = pash + charName;
            fos_jpg = new FileOutputStream(chartName);

            // 将报表保存为png文件
            // ChartUtilities.writeChartAsPNG(fos_jpg, chart, 500, 510);
            // 保存为JPEG文件
            ChartUtilities.writeChartAsJPEG(fos_jpg, chart, 700, 500);
            return chartName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                fos_jpg.close();
                System.out.println("create time-createTimeXYChar.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
