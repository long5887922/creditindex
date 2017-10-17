package com.zy.creditindex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.creditindex.entity.JsonEntry;

/**
 * Created by huaqin on 2017/10/13.
 */
@Controller
@RequestMapping("/hello")
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
