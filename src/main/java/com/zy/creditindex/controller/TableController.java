package com.zy.creditindex.controller;

import com.google.common.collect.Maps;
import com.zy.creditindex.entity.JsonEntry;
import com.zy.creditindex.entity.JsonEntryLine;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
}
