package com.zy.creditindex.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
