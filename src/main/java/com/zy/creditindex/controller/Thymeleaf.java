package com.zy.creditindex.controller;

import com.zy.creditindex.aspect.HttpAspect;
import com.zy.creditindex.entity.JsonEntry;
import com.zy.creditindex.entity.User;
import com.zy.creditindex.repostory.UserRepostory;
import com.zy.creditindex.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ${ZhaoYing}on 2017/9/28 0028
 */
@Controller
@RequestMapping("/um")
public class Thymeleaf {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    @Autowired
    private UserRepostory userrepostory;
    @Autowired
    private AdminUserService adminUserService;
    @RequestMapping("thymeleaf")
    public String login(ModelMap modelMap){

    return "Hello";
    }
    @RequestMapping("/tologin")
    public ModelAndView YiXin(ModelMap model){
        return  new ModelAndView("Registview");
    }
    /*跳转页面*/
    @RequestMapping("/frameset")
    public ModelAndView frameset(ModelMap model){
        logger.info("--------------------------登录请求-----------------------------");
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
    @RequestMapping("/index")
    public ModelAndView Index(){
        return  new ModelAndView("index");
    }

    @RequestMapping("/403")
    public ModelAndView ERRORS(){
        //        Administrator@cnfic.com.cn
        return  new ModelAndView("403");
    }
    @PostMapping("/buName")
    public User selectName(String name){
        return userrepostory.findByName(name);
    }

    @RequestMapping("/managerPower")
    public String manager() {
        return "managerPower";
    }

}

