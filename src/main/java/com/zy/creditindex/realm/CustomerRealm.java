package com.zy.creditindex.realm;

import com.zy.creditindex.entity.Permission;
import com.zy.creditindex.entity.Role;
import com.zy.creditindex.entity.User;
import com.zy.creditindex.repostory.UserRepostory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

/**
 * Created by ${ZhaoYing}on 2017/10/15 0015
 */
public class CustomerRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return 	 super.getName();
    };
    /**
     * 用户的数据持久层
     */
    @Autowired
    private UserRepostory userrepostory;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 通过 身份 获取身份集合
        String primaryPrincipal = (String)  principalCollection.getPrimaryPrincipal();
        User user = userrepostory.findByName(primaryPrincipal);
        // 根据用户查出角色
        Set<Role> roleList = user.getRoles();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role:roleList) {
            //根据角色查出相应资源
            Set<Permission> permissions = role.getPermissions();
            for (Permission permission:permissions) {
                //给角色添加资源权限
                simpleAuthorizationInfo.addStringPermission(permission.getName());
            }

        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
         //根据token获取用户名
        String principal = (String) token.getPrincipal();
        System.out.println("******************************>>>token.toString:"+token.toString());
        System.out.println("******************************>>>token.getPrincipal():"+principal);
        User byName = userrepostory.findByName(principal);
        System.out.println("******************************>>>byName"+byName);
        if(byName!=null){
            System.out.println( ByteSource.Util.bytes(byName.getSalt()));
            System.out.println(this.getName());
             return   new SimpleAuthenticationInfo( byName.getName(),
                                                byName.getPassword(),
                                                ByteSource.Util.bytes(byName.getSalt()),
                                                UUID.randomUUID().toString().replace("-", ""));
        }
        return null;
    }
}
