package com.zy.creditindex.shiro;

import com.zy.creditindex.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by ${ZhaoYing}on 2017/10/11 0011
 */
@Configuration
public class ShiroConfiguration {
    @Bean
    public CustomerRealm CustomerRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        customerRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customerRealm;
    }
    /**
     * 注入自己的身份认证realm;
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置Realm
        securityManager.setRealm(CustomerRealm());
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        System.out.println("----------拦截开始--------ShiroConfiguration.shirFilter()------------------");
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/um/tologin");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/um/frameset");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/um/403");
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/user/**", "anon");
        filterChainDefinitionMap.put("/um/**", "anon");
        filterChainDefinitionMap.put("/mp/**", "anon");
        filterChainDefinitionMap.put("/index/**", "anon");
        filterChainDefinitionMap.put("/json/table/**", "anon");
        filterChainDefinitionMap.put("/assets/**", "anon");
        filterChainDefinitionMap.put("/bootstrap/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/jsps/**", "anon");
        filterChainDefinitionMap.put("/**/**.js", "anon");
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1024);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }
    public  static String  getMd5Code(String password){
        char[] encode = null;
        try {
            //创建Md5加密算法的实例
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //ͨ通过实例的digest方法加密字符串
            byte[] digest = messageDigest.digest(password.getBytes());
            encode = Hex.encode(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(encode);
    }
   public static void main(String[] args) throws NoSuchAlgorithmException {
        String md5Code = getMd5Code("e10adc3949ba59abbe56e057f20f883e");
        System.out.println(md5Code);
    }



    public static String getRandomSalt(int n){
        //定义一个字符数组
        char[] randomCode = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        //随机数
        Random random = new Random();
        String randomSalt = "";
        for (int i = 0; i < n; i++) {
            randomSalt+=randomCode[random.nextInt(randomCode.length)];
        }
        return randomSalt;

    }
   /* public static void main(String[] args) {

        String randomSalt = getRandomSalt(4);
        System.out.println(randomSalt);


    }*/


}
