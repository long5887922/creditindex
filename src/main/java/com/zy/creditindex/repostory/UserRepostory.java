package com.zy.creditindex.repostory;

import com.zy.creditindex.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 管理用户的数据持久化
 * Created by ${ZhaoYing}on 2017/9/28 0028
 */
    public interface UserRepostory extends JpaRepository<AdminUser,Integer> {
}
