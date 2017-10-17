package com.zy.creditindex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by huaqin on 2017/10/13.
 */
@Controller
@RequestMapping("/hello")
public class ManagerPowerAction {
    @RequestMapping("/managerPower")
    public String manager(){
        return "managerPower";
    }

}
