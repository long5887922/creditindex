package com.zy.creditindex.chartLine;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;

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

/**生成折线图图片
 * Created by huaqin on 2017/10/24.
 */
@RestController
@RequestMapping(value = "/idri")
public class CreateJFreeChartLine {
    // 设置文件下载路径
    private static final String CHART_PATH = "\\src\\main\\webapp\\img\\";

    public static void main(String[] args){
        // TODO Auto-generated method stub
        CreateJFreeChartLine pm = new CreateJFreeChartLine();

        // 生成等权折线图
        pm.makeLineAndShapeChart("01","01");
        pm.makeLineAndShapeChart("01","02");
        //债券加权折线图
        pm.makeLineAndShapeChart("02","01");
        pm.makeLineAndShapeChart("02","02");
    }
    /**
     * 生成折线图
     */
    public void makeLineAndShapeChart(String weight,String change) {
        BigDecimal[][] BigData = new BigDecimal[][] {
                { new BigDecimal(55), new BigDecimal(63), new BigDecimal(89), new BigDecimal(111), new BigDecimal(212),
                        new BigDecimal(321), new BigDecimal(461) },
                { new BigDecimal(66), new BigDecimal(31), new BigDecimal(242), new BigDecimal(321), new BigDecimal(451),
                        new BigDecimal(513), new BigDecimal(713) },
                { new BigDecimal(24), new BigDecimal(123), new BigDecimal(231), new BigDecimal(431),
                        new BigDecimal(223), new BigDecimal(441), new BigDecimal(765) },
                { new BigDecimal(77), new BigDecimal(177), new BigDecimal(245), new BigDecimal(367),
                        new BigDecimal(414), new BigDecimal(571), new BigDecimal(689) },
                { new BigDecimal(121.22), new BigDecimal(144), new BigDecimal(189), new BigDecimal(269),
                        new BigDecimal(378), new BigDecimal(512), new BigDecimal(679) },
                { new BigDecimal(123), new BigDecimal(311), new BigDecimal(444), new BigDecimal(513),
                        new BigDecimal(656), new BigDecimal(711), new BigDecimal(812) },
                { new BigDecimal(99), new BigDecimal(145), new BigDecimal(271), new BigDecimal(333),
                        new BigDecimal(415), new BigDecimal(522.21), new BigDecimal(614.21) },
                { new BigDecimal(166.21), new BigDecimal(231.21), new BigDecimal(341.21), new BigDecimal(411),
                        new BigDecimal(321), new BigDecimal(521), new BigDecimal(712) } };
        int x = BigData.length;
        int y = 0;
        for (int i = BigData.length - 1; i < BigData.length; i++) {
            for (int j = BigData[i].length - 1; j < BigData[i].length; j++) {
                y = BigData[i].length;
            }
        }
        double[][] data = new double[x][y];
        for (int i = 0; i < BigData.length; i++) {
            for (int j = 0; j < BigData[i].length; j++) {// 循环里面的数组
                data[i][j] = BigData[i][j].doubleValue();
            }
        }
        // 加权类型（01：等权；02：债券加权）
        String name;
        String title;
        if("01".equals(weight)) {
            title="行业信贷风险指数等权-等权";
            if("01".equals(change)) {
                name="lineAndShap.jpg";
            }else {
                name="lineAndShapBlack.jpg";
            }
        }
        else {
            title="行业信贷风险指数等权-加权";
            if("01".equals(change)) {
                name="lineAndShapWeighting.jpg";
            }else {
                name="lineAndShapWeightBlack.jpg";
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
        String[] rowKeys = { a, b, c, d, e, f, g, h };
        String[] columnKeys = { "2011", "2012", "2013", "2014", "2015", "2016", "2017" };
        CategoryDataset dataset = getBarData(data, rowKeys, columnKeys);
        createTimeXYChar(title, "", "", dataset, name, weight,change);
    }
    // 折线图 数据集
    public CategoryDataset getBarData(double[][] data, String[] rowKeys, String[] columnKeys) {
        // return DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
    }

    /**
     * 判断文件夹是否存在，如果不存在则新建
     *
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
     *
     * @param chartTitle
     * @param x
     * @param y
     * @param xyDataset
     * @param charName
     * @return
     */
    public String createTimeXYChar(String chartTitle, String x, String y, CategoryDataset xyDataset, String charName,
                                   String weight,String change) {

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
            lasp.setSeriesStroke(i, new BasicStroke(2.3F));
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

        //设置轴属性
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
        if ("01".equals(change)) {
            // 设置图的背景颜色
            // p.setBackgroundPaint(ChartColor.WHITE);
            // 设置表格线颜色
            p.setRangeGridlinePaint(ChartColor.GRAY);
            // 设置表格线颜色
            p.setDomainGridlinePaint(ChartColor.BLACK);
            // 设置外边框颜色
            chart.setBackgroundPaint(Color.WHITE);
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
                ChartUtilities.writeChartAsJPEG(fos_jpg, chart, 700, 550);
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
                ChartUtilities.writeChartAsJPEG(fos_jpg, chart, 700, 550);
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
}
