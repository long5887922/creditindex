package com.zy.creditindex.service;

import com.zy.creditindex.entity.User;
import com.zy.creditindex.repostory.UserRepostory;
import com.zy.creditindex.util.RandomSaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

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
        // 先给加盐密码
//		String salt = RandomSaltUtil.getRandomSalt(4);
//		String passwordSalt = user.getPassword() + salt;
//		// 在给用加MD5计算
//		String md5Code = MD5Util.getMd5Code(passwordSalt);
//		user.setPassword(md5Code);// 给密加算
//		user.setSalt(salt);// 给盐设值
//		user.setUpdatedate(new Date());
//		userDao.save(user);
        //先给密码加盐
        String salt = RandomSaltUtil.getRandomSalt(4);
        //给密码加MD5和散列
        System.out.println(salt+"qwwww=====================");
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 20);//hashiterations散列次数
        //处理后密码设置
        System.out.println(md5Hash+"===============================");
        user.setPassword(md5Hash.toString());
        user.setUpdateTime(new Date(1));
        user.setSalt(salt);
        System.out.println(user+"@@@@@@@@@@@@@@@@@@@@@@@@@");
        return userrepostory.save(user);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public User findById(String id){
        return userrepostory.findOne(id);}

    /**
     * 查所有
     * @return
     */
        public List<User> fiindAlls(){
        return userrepostory.findAll();
        }
}
