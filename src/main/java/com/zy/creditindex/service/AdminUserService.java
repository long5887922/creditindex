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

    /**
     * 根据姓名查询
     * @param usernumber
     * @return
     */
    public User querUsernumber(String usernumber){
        return userrepostory.findByName(usernumber);
    }

    public User addUser(User user){
        return userrepostory.save(user);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public User findById(String id){
        return userrepostory.findOne(id);}
}
