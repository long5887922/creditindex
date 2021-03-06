package com.zy.creditindex.chartLine;

import com.zy.creditindex.service.CreatJFreeChartService;
import com.zy.creditindex.util.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by huaqin on 2017/11/2.
 * 定时调取方法生成图片
 */
@Component
public class SchedulingConfig {
	@Autowired
	CreatJFreeChartService chartService;

	/*@Scheduled(cron = "00 00 09 * * ?")
	public void scheduler() {
		initCreatJFreeChart();
	}

	public void initCreatJFreeChart() {
		chartService.creatJFreeChart("01");
		chartService.creatJFreeChart("02");
	}*/
	@Scheduled(cron = "01 00 09 * * ?")
	public void scheduler() {
		CacheManager.clearAll();
		System.out.print("清除折线图缓存数据");
	}
}
