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
 * Created by Sharker on 2017/10/14.
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
		for (int i = 0; i < 100; i++) {
			JsonEntry jsonEntry = new JsonEntry();
			jsonEntry.setCf("ssafa");
			jsonEntry.setGarch("asd");
			jsonEntry.setLiudong("sdddd");
			jsonEntry.setMerton("bbbbbbbb");
			jsonEntry.setQuke("ssssssssss");
			jsonEntry.setUsername("adminnnnn");
			list.add(jsonEntry);
		}
		return list;
	}
}
