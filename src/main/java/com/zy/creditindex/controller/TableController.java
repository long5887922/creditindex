package com.zy.creditindex.controller;

import com.zy.creditindex.entity.JsonEntry;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
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
		return list;
	}
}
