package com.zy.creditindex.controller.user;

import com.zy.creditindex.aspect.HttpAspect;
import com.zy.creditindex.entity.User;

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
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
     * 查所有
     * @return
     */
    @GetMapping("/all")
    public List<User> QueryAll(){
        return adminUserService.fiindAlls();
    }
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
    public String loginController(@RequestParam("usernumber")String usernumber,
                                        @RequestParam("password")String password,
                                        HttpSession session){
        logger.info("--------------------------登录请求-----------------------------");
        logger.info(usernumber);
        logger.info(password);
        Map<String, Object> map = new HashMap<String, Object>();//传递异常信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(usernumber,password);
        try {
            subject.login(usernamePasswordToken);   //完成登录
            subject.checkRole("admin");//角色
            subject.isPermitted("/menu/abc");//权限
            subject.checkPermission("add");
//            User user=(User) subject.getPrincipal();
//            session.setAttribute("user", user);
            return "index";
        } catch(Exception e) {
            return "/um/tologin";//返回登录页面
        }

    }

    @PostMapping("/logout")
    public Map<String,Object> logout(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            //退出
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resultMap;
    }

}
