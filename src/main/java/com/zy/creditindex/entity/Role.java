/**
 * 
 */
package com.zy.creditindex.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @作者： 赵英
 *创建时间：
 */
@Entity
public class Role {
	@Id
	@GenericGenerator(name = "rid", strategy = "uuid")
	@GeneratedValue(generator="rid")
		private String id;
		private String name;//角色名称
		
		//权限集合
		@ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(name="f_role_permission",
					joinColumns={@JoinColumn(name="role_id")},
					inverseJoinColumns={@JoinColumn(name="permission_id")})
		@Cascade(CascadeType.ALL)
		private Set<Permission> permissions = new HashSet<Permission>();

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

		public Set<Permission> getPermissions() {
			return permissions;
		}

		public void setPermissions(Set<Permission> permissions) {
			this.permissions = permissions;
		}

		public Role() {
			super();
		}

		public Role(String id, String name, Set<Permission> permissions) {
			super();
			this.id = id;
			this.name = name;
			this.permissions = permissions;
		}
		
		public Role(String id,String name) {
			super();
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Role [id=" + id + ", name=" + name + "]";
		}
	
}
