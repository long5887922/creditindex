package com.zy.creditindex.repostory;

import com.zy.creditindex.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 管理用户的数据持久化
 * Created by ${ZhaoYing}on 2017/9/28 0028
 */
public interface UserRepostory extends JpaRepository<User,String> {
    /**
     * 通过名字来查询
     */
    public User findByName(String usernumber);




}
