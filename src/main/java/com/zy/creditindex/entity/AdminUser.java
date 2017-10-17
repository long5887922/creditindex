package com.zy.creditindex.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by ${ZhaoYing}on 2017/9/28 0025
 */
//@Table(name = "user") 定义表名，如果不定义，默认生成的表名为实体类的类名（默认定为小写）并转成“格式admin_user“
@Entity
public class AdminUser implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;
    // @Column(name = "girl_name")变量名与字段对应的配置，如果不加，字段名默认与变量名相同
    private String name;
    @Column(unique =true)
    private String usernumber;//用户编号
    private String password;//登录密码
    //创建时间
    private Date createdtime= new java.sql.Date(new java.util.Date().getTime());



    private String by1; //备用字段1
    private String by2; //备用字段2
    @ManyToMany(fetch=FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
   /* private List<SysRole> roleList;// 一个用户具有多个角色

    public AdminUser() {
    }
    public List<SysRole> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }*/
    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }

//    @Override
//    public String toString() {
//        return "AdminUser{" +
//                "uid=" + uid +
//                ", name='" + name + '\'' +
//                ", usernumber='" + usernumber + '\'' +
//                ", password='" + password + '\'' +
//                ", createdtime=" + createdtime +
//                ", by1='" + by1 + '\'' +
//                ", by2='" + by2 + '\'' +
//                ", roleList=" + roleList +
//                '}';
//    }
}
