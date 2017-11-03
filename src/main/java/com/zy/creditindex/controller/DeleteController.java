package com.zy.creditindex.controller;

import com.zy.creditindex.entity.JsonEntry;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenlong 2017/10/16.
 */
@Controller
@RequestMapping("/hello")
public class DeleteController {
	@RequiresPermissions({ "admin:user:delete" })
	@RequiresRoles("admin")
	@RequestMapping("/tables")
	public String index() {
		return "tables";
	}
	

	@RequestMapping("/delet")
	public static String  delete(JsonEntry jsonEntry,Model model){

		return "";
	}


}
