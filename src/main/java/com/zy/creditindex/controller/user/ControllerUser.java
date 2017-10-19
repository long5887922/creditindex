package com.zy.creditindex.controller.user;

import com.zy.creditindex.aspect.HttpAspect;
import com.zy.creditindex.entity.User;
import com.zy.creditindex.repostory.UserRepostory;
import com.zy.creditindex.service.AdminUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by ${ZhaoYing}on 2017/9/28 0028
 */
@RestController
@RequestMapping("/user")
public class ControllerUser {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);


    @Autowired
    private AdminUserService adminUserService;

    /**
     * 通过姓名查询用户
     * @param name
     * @return
     */
    @PostMapping("queryByName")
    public User queryByName(String name){
        return adminUserService.querUsernumber(name);
    }
    /**
     * 管理用户注册方法
     * @param
     * @return
     */
    @PostMapping("/save")
    public User SaveUser(@Valid User user ){
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        return adminUserService.addUser(user);
    }

    /**
     * ID查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/finduser/{id}")
    public User getUser(@PathVariable("id")String id){
        return adminUserService.findById(id);
    }

    /**
     * git方式用姓名查询用户信息
     * @param usernumber
     * @return
     */
    @GetMapping("/finduser/number/{number}")
    public User getByUsernumber(@PathVariable("number") String usernumber){
        return adminUserService.querUsernumber(usernumber);
    }

    @PostMapping("/controller")
    public String loginController(@RequestParam("usernumber")String usernumber,@RequestParam("password")String password){
        logger.info("--------------------------AJAX登录请求-----------------------------");
        logger.info(usernumber);
        logger.info(password);
        HashMap<String, Object> map = new HashMap<String, Object>();//传递异常信息
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(usernumber,password);
            subject.login(usernamePasswordToken);
            System.out.println(subject.isAuthenticated());
            map.put("success", true);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "用户名不存在···");
        }catch (IncorrectCredentialsException e) {
            map.put("success", false);
            map.put("message", "密码错误···");
        }catch (RuntimeException e) {
            map.put("success", false);
            map.put("message", e.getMessage());
        }
//        GsonUtil.writeToResponse(map);

        return "frame";
    }

}