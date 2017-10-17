package com.zy.creditindex.controller;

import com.zy.creditindex.entity.AdminUser;
import com.zy.creditindex.repostory.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by ${ZhaoYing}on 2017/9/28 0028
 */
@RestController
@RequestMapping("/user")
public class ControllerUser {

    @Autowired
    private UserRepostory userrepostory;

    /**
     * 管理用户注册方法
     * @param adminser
     * @return
     */
    @PostMapping("/save")
    public AdminUser SaveUser(@Valid AdminUser adminser ){
        adminser.setName(adminser.getName());
        adminser.setUsernumber(adminser.getUsernumber());
        return userrepostory.save(adminser);
    }

}
