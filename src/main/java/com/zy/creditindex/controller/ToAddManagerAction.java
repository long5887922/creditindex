package com.zy.creditindex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huaqin on 2017/10/13.
 */
@Controller
@RequestMapping("/hello")
public class ToAddManagerAction {
    @RequestMapping("/toAddManager")
    public String manager(){
        return "addManager";
    }

}
