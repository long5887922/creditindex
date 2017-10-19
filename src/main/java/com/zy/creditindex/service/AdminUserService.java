package com.zy.creditindex.service;

import com.zy.creditindex.entity.User;
import com.zy.creditindex.repostory.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ${ZhaoYing}on 2017/10/13 0013
 */
@Service
public class AdminUserService {
    @Autowired
    private UserRepostory userrepostory;

    public User querUsernumber(String usernumber){
        return userrepostory.findByName(usernumber);
    }

    public void addUser(User user){
        userrepostory.save(user);
    }
}
