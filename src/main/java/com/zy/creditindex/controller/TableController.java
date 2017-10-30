package com.zy.creditindex.controller;

import com.google.common.collect.Maps;
import com.zy.creditindex.entity.JsonEntry;
import com.zy.creditindex.entity.JsonEntryLine;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 查询管理员权限类
 * @author huaqin
 * @date 2017/10/31
 */
@Controller
@RequestMapping("/json/table")
public class TableController {

	@RequiresPermissions({ "admin:user:delete" })
	@RequiresRoles("admin")
	@RequestMapping("/")
	public String index() {
		return "tables";
	}



	@RequestMapping("/list.json")
	@ResponseBody
	public Object list() {
		List<Object> list = new ArrayList<>();
		int j=100;
		for (int i = 1; i < j; i++) {
			JsonEntry jsonEntry = new JsonEntry();
			jsonEntry.setId(i);
			jsonEntry.setCf("1");
			jsonEntry.setGarch("1");
			jsonEntry.setLiudong("0");
			jsonEntry.setMerton("0");
			jsonEntry.setQuke("0");
			jsonEntry.setUsername("刘晓");
			list.add(jsonEntry);
		}
		List<Object> l = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			l.add("测试"+i);
		}
		return list;
	}
	@RequestMapping("/list3.json")
	@ResponseBody
	public Object list3() {
		List<Object> list = new ArrayList<>();
		int j=10;
		for (int i = 1; i < j; i++) {
			JsonEntryLine jsonEntry = new JsonEntryLine();
			jsonEntry.setId(i);
			jsonEntry.setTime1("111");
			jsonEntry.setTime2("222");
			jsonEntry.setTime3("333");
			jsonEntry.setTime4("444");
			jsonEntry.setTime5("555");
			jsonEntry.setTime6("666");
			jsonEntry.setUsername("建筑业");
			list.add(jsonEntry);
		}
		return list;
	}
}
