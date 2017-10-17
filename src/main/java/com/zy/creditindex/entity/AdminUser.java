package com.zy.creditindex.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by ${ZhaoYing}on 2017/9/28 0025
 */
//@Table(name = "user") �����������������壬Ĭ�����ɵı���Ϊʵ�����������Ĭ�϶�ΪСд����ת�ɡ���ʽadmin_user��
@Entity
public class AdminUser implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;
    // @Column(name = "girl_name")���������ֶζ�Ӧ�����ã�������ӣ��ֶ���Ĭ�����������ͬ
    private String name;
    @Column(unique =true)
    private String usernumber;//�û����
    private String password;//��¼����
    //����ʱ��
    private Date createdtime= new java.sql.Date(new java.util.Date().getTime());



    private String by1; //�����ֶ�1
    private String by2; //�����ֶ�2
    @ManyToMany(fetch=FetchType.EAGER)//���������ݿ��н��м�������;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
   /* private List<SysRole> roleList;// һ���û����ж����ɫ

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
