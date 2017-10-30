package com.zy.creditindex.controller.indexandidri;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.zy.creditindex.chartLine.CreateJFreeChartLine;
import com.zy.creditindex.entity.idri.IdriBean;
import com.zy.creditindex.service.IndexService.IdriService;

import org.apache.commons.collections.CollectionUtils;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	 * 
	 * @param startTime
	 * @param endTime
	 * @param weightType
	 * @return
	 */
	@RequestMapping("/queryIdriByCondition")
	public List<IdriBean> queryIdriByCondition(Date startTime, Date endTime, String weightType) {

		return idriService.queryIdriByCondition(startTime, endTime, weightType);
	}

	@RequestMapping("/creatJFreeChart")
	public String creatJFreeChart(Date startTime, Date endTime, String weightType) {
		List<IdriBean>  list = idriService.queryIdriByCondition(startTime, endTime, weightType);
		if (CollectionUtils.isEmpty(list)) {
			return "查询数据为空";
		}
		Map<String, String> map = IdriBean.getMap();
		//title
		List<String> columns = new ArrayList<String>(map.size());
		List<String> columnList = new ArrayList<String>();
		List<List<Double>> dataList = new ArrayList<List<Double>>();
		for (String key : map.keySet()) {
			List<Double> d = new ArrayList<Double>();
			for (IdriBean idr : list) {
				if(idr.getInducode().equals(key)) {
					columnList.add(idr.getIndexdate().toString());
					d.add(idr.getIdri().doubleValue());
				}
			}
			dataList.add(d);
			columns.add(map.get(key));
		}
		String[] rowKeys =  columns.toArray(new String[0]);
		/* 封装折线参数 */
		double[][] data = getArray(dataList);
		columnList = columnList.subList(0, data[0].length);
		CategoryDataset dataset = getBarData(data, rowKeys, columnList.toArray(new String[0]));
		String title = "";
//		 加权类型（01：等权；02：债券加权）
		 if("01".equals(weightType)){
		 /*白色背景*/
		 createTimeXYChar("行业信贷风险指数等权-等权", "", "", dataset, "lineAndShap.jpg",
		 weightType,"01");
		 /*暗色背景*/
		 createTimeXYChar("行业信贷风险指数等权-等权", "", "", dataset, "lineAndShapBlack.jpg",
		 weightType,"02");
		 }else{
		 /*白色背景*/
		 createTimeXYChar("行业信贷风险指数等权-加权", "", "", dataset,
		 "lineAndShapWeighting.jpg", weightType,"01");
		 /*暗色背景*/
		 createTimeXYChar("行业信贷风险指数等权-加权", "", "", dataset,
		 "lineAndShapWeightBlack.jpg", weightType,"02");
		 }
		return "生成图片成功";
	}
    public static double[][] getArray(List<List<Double>> list){  
    	Double[][] ps = new Double[list.size()][];  
        for (int i = 0; i < list.size(); i++) {  
            ps[i] = list.get(i).toArray(new Double[list.get(i).size()]);  
        }  
        int x = ps.length;
        int y = 0;
        for (int i = ps.length - 1; i < ps.length; i++) {
            for (int j = ps[i].length - 1; j < ps[i].length; j++) {
                y = ps[i].length;
            }
        }
        double[][] data = new double[x][y];
        for (int i = 0; i < ps.length; i++) {
            for (int j = 0; j < ps[i].length; j++) {// 循环里面的数组
                data[i][j] = ps[i][j].doubleValue();
            }
        }
        return data;  
    }  
	/*
	 * public void generateLineChart(Date startTime,Date endTime,String
	 * weightType,String change ){
	 * 
	 * }
	 */
	// 柱状图,折线图 数据集
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
			String weightType, String change) {
		/* chartTitle图标题，x y，文字介绍，xyDataset 折线参数， */
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
		domainAxis.setLowerMargin(0.001);
		// 设置距离图片右端距离
		domainAxis.setUpperMargin(0.001);
		domainAxis.setMaximumCategoryLabelLines(100);

		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(true);

		TickUnitSource units = NumberAxis.createIntegerTickUnits();
		numberaxis.setStandardTickUnits(units);
		// 获得renderer 注意这里是lineandshaperenderer！！
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();

		lineandshaperenderer.setBaseShapesVisible(false); // series 点（即数据点）可见

		lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见

		// 显示折点数据
		/*
		 * lineandshaperenderer.setBaseItemLabelGenerator(new
		 * StandardCategoryItemLabelGenerator());
		 * lineandshaperenderer.setBaseItemLabelsVisible(true);
		 */
		/* 文件所在位置及文件名称 */
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
