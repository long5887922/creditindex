package com.zy.creditindex.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @作者： John ying
 *创建时间：
 */

@Entity
@Table(name="f_user")
public class User {
	@Id
	@GenericGenerator(name = "fid", strategy = "uuid")
	@GeneratedValue(generator="fid")
		private String id; 
		private String name;
		private String password;
		private String salt;
		private Date updateTime=new java.sql.Date(new Date().getTime());//获取当前系统时间
		
		//角色关系属性
		@ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(name="f_user_role",
					joinColumns={@JoinColumn(name="user_id")},
					inverseJoinColumns={@JoinColumn(name="role_id")})
		//级联权限
		@Cascade(CascadeType.ALL)
		private Set<Role> roles = new HashSet<Role>(); 
		

		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSalt() {
			return salt;
		}
		public void setSalt(String salt) {
			this.salt = salt;
		}
		public Date getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(String id, String name, String password, String salt,
				Date updateTime) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
			this.salt = salt;
			this.updateTime = updateTime;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", password="
					+ password + ", salt=" + salt + ", updateTime="
					+ updateTime + "]";
		}
		public User(String id, String name, String password, String salt,
				Date updateTime, Set<Role> roles) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
			this.salt = salt;
			this.updateTime = updateTime;
			this.roles = roles;
		}

}
