package com.zy.creditindex.chartLine;

import com.zy.creditindex.service.CreatJFreeChartService;
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

	@Scheduled(cron = "55 12 17 * * ?")
	public void scheduler() {
		initCreatJFreeChart();
	}

	public void initCreatJFreeChart() {
		chartService.creatJFreeChart("01");
		chartService.creatJFreeChart("02");
	}

}
