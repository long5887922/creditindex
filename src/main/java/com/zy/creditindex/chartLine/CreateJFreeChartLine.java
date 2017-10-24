package com.zy.creditindex.chartLine;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;

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
/**生成折线图图片
 * Created by huaqin on 2017/10/24.
 */
public class CreateJFreeChartLine {
    // 设置文件下载路径
    private static final String CHART_PATH = "E:/test/";



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CreateJFreeChartLine pm = new CreateJFreeChartLine();
        // 生成折线图
        pm.makeLineAndShapeChart();
    }
    /**
     * 生成折线图
     */
    public void makeLineAndShapeChart() {
        BigDecimal[][] BigData = new BigDecimal[][] {
                { new BigDecimal(55), new BigDecimal(63), new BigDecimal(89),
                        new BigDecimal(111), new BigDecimal(212), new BigDecimal(321),
                        new BigDecimal(461) },
                { new BigDecimal(66), new BigDecimal(31), new BigDecimal(242),
                        new BigDecimal(321), new BigDecimal(451), new BigDecimal(513),
                        new BigDecimal(713) },
                { new BigDecimal(24), new BigDecimal(123), new BigDecimal(231),
                        new BigDecimal(431), new BigDecimal(223), new BigDecimal(441),
                        new BigDecimal(765) },
                { new BigDecimal(77), new BigDecimal(177), new BigDecimal(245),
                        new BigDecimal(367), new BigDecimal(414), new BigDecimal(571),
                        new BigDecimal(689) },
                { new BigDecimal(121.22), new BigDecimal(144), new BigDecimal(189),
                        new BigDecimal(269), new BigDecimal(378), new BigDecimal(512),
                        new BigDecimal(679) },
                { new BigDecimal(123), new BigDecimal(311), new BigDecimal(444),
                        new BigDecimal(513), new BigDecimal(656), new BigDecimal(711),
                        new BigDecimal(812) },
                { new BigDecimal(99), new BigDecimal(145), new BigDecimal(271),
                        new BigDecimal(333), new BigDecimal(415), new BigDecimal(522.21),
                        new BigDecimal(614.21) },
                { new BigDecimal(166.21), new BigDecimal(231.21), new BigDecimal(341.21),
                        new BigDecimal(411), new BigDecimal(321), new BigDecimal(521),
                        new BigDecimal(712) } };
        int x=0;
        int y=-1;
        for (int i = 0; i < BigData.length; i++) {
            x++;
            for(int j = BigData[i].length-1;j<BigData[i].length;j++){
                y++;
            }
        }
        double [][] data = new double[x][y];
        for (int i = 0; i < BigData.length; i++) {
            for(int j = 0;j<BigData[i].length;j++){//循环里面的数组
                data[i][j]=BigData[i][j].doubleValue();
            }
        }
        String a = "建筑业";
        String b = "制造业";
        String c = "运输业";
        String d = "采矿业";
        String e = "批发和零售业";
        String f = "交通运输、仓储和邮政业";
        String g = "信息传输、软件和信息技术业务";
        String h = "电力、热力、燃气、及水生产和供应业";
        String[] rowKeys = {a, b, c,d,e,f,g,h};
        String[] columnKeys = {"2011", "2012", "2013", "2014", "2015","2016","2017"};
        CategoryDataset dataset = getBarData(data, rowKeys, columnKeys);
        createTimeXYChar("行业信贷风险指数等权", "", "", dataset, "lineAndShap.jpg");
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
    public String createTimeXYChar(String chartTitle, String x, String y,
                                   CategoryDataset xyDataset, String charName) {

        JFreeChart chart = ChartFactory.createLineChart(chartTitle, x, y,
                xyDataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setTextAntiAlias(false);
        chart.setBackgroundPaint(Color.WHITE);
        // 设置图标题的字体重新设置title
        Font font = new Font("隶书", Font.BOLD, 25);
        Font yfont = new Font("隶书", Font.BOLD, 16); // Y轴
        Font kfont = new Font("隶书", Font.BOLD, 14); // 底部
        Font titleFont = new Font("隶书", Font.BOLD, 20); // 图片标题
        TextTitle title = new TextTitle(chartTitle);
        title.setFont(font);
        chart.setTitle(title);
        chart.getLegend().setItemFont(kfont);
        chart.getTitle().setFont(titleFont);
        // 设置面板字体
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 11);
        // 获得图表对象
        CategoryPlot p = chart.getCategoryPlot();
        LineAndShapeRenderer lasp = (LineAndShapeRenderer) p.getRenderer();
        // 设置图的背景颜色
        //p.setBackgroundPaint(ChartColor.WHITE);
        p.setBackgroundAlpha(0.1f);
        // 设置表格线颜色
        p.setRangeGridlinePaint(ChartColor.GRAY);
        //设置表格线颜色
        p.setDomainGridlinePaint(ChartColor.BLACK);
        //将网格线改为实线
        p.setDomainGridlineStroke(new BasicStroke());
        p.setRangeGridlineStroke(new BasicStroke());
        // 去除背景边框线
        p.setOutlinePaint(null);
        //设置折线加粗
        lasp.setSeriesStroke(0, new BasicStroke(3F));
        //设置外边框颜色
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        // x轴 // 分类轴网格是否可见
        categoryplot.setDomainGridlinesVisible(false);
        // y轴 //数据轴网格是否可见
        categoryplot.setRangeGridlinesVisible(true);
        // 设置轴和面板之间的距离
        categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        CategoryAxis domainAxis = categoryplot.getDomainAxis();

        domainAxis.setLabelFont(labelFont);// 轴标题

        domainAxis.setTickLabelFont(labelFont);// 轴数值

        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的
        //设置两轴之间的边距
        domainAxis.setCategoryMargin(1);
        // 45度倾斜
        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.0);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.0);

        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);

        // 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();
        lineandshaperenderer.setBaseShapesVisible(false); // series 点（即数据点）可见
        lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
        // 显示折点数据
        // lineandshaperenderer.setBaseItemLabelGenerator(new
        // StandardCategoryItemLabelGenerator());
        // lineandshaperenderer.setBaseItemLabelsVisible(true);
        FileOutputStream fos_jpg = null;
        try {
            isChartPathExist(CHART_PATH);
            String chartName = CHART_PATH + charName;
            fos_jpg = new FileOutputStream(chartName);
            // 将报表保存为png文件
            //ChartUtilities.writeChartAsPNG(fos_jpg, chart, 500, 510);
            // 保存为JPEG文件
            ChartUtilities.writeChartAsJPEG(fos_jpg, chart, 700, 600);
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
