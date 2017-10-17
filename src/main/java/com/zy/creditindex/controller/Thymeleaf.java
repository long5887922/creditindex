package com.zy.creditindex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by ${ZhaoYing}on 2017/9/28 0028
 */
@Controller
@RequestMapping("/hello")
public class Thymeleaf {
    @RequestMapping("thymeleaf")
    public String login(ModelMap modelMap){
        modelMap.put("msg", "SpringBoot Ajax");
    return "Hello";
    }
    @RequestMapping("/yixin")
         public ModelAndView YiXin(ModelMap model){
        model.put("hello","你好");
        return  new ModelAndView("Registview");
    }
    @RequestMapping("/login")
         public ModelAndView login2(ModelMap model){

        return  new ModelAndView("loginView2");
    }
    /*跳转页面*/
    @RequestMapping("/frameset")
    public ModelAndView frameset(ModelMap model){

        return  new ModelAndView("frame");
    }
    /*左侧菜单*/
    @RequestMapping("/left")
    public ModelAndView left(ModelMap model){

        return  new ModelAndView("left");
    }
    /*主菜单*/
    @RequestMapping("/mainFrame2")
    public ModelAndView mainFrame(ModelMap model){

        return  new ModelAndView("mainFrame");
    }
    /*顶层菜单*/
    @RequestMapping("/login3")
         public ModelAndView login3(ModelMap model){

        return  new ModelAndView("loginView3");
    }

    @RequestMapping("/market")
         public ModelAndView market(ModelMap model){

        return  new ModelAndView("marketView");
    }
}

