package com.zy.creditindex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.creditindex.entity.JsonEntry;

/**
 * 查询管理员权限类
 * @author huaqin
 * @date 2017/10/31
 */
@Controller
@RequestMapping("/mp")
public class ManagerPowerAction {

    @RequestMapping("/managerPower")
    public String manager() {
        return "managerPower";
    }

    @RequestMapping("/addManager")
    @ResponseBody
    public Object addManager(JsonEntry json) {
        System.out.println(json);
        return json;
    }
}
