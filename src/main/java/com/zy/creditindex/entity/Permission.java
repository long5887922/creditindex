/**
 * 
 */
package com.zy.creditindex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @作者： 赵英
 *创建时间：
 */
@Entity
public class Permission {
	@Id
	@GenericGenerator(name = "pid", strategy = "uuid")
	@GeneratedValue(generator="pid")
		private String id;
		private String name;// 权限标志符
		private String resourceNmame;//资源名称
		private String resourceUrl;//资源路径

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
		public String getResourceNmame() {
			return resourceNmame;
		}
		public void setResourceNmame(String resourceNmame) {
			this.resourceNmame = resourceNmame;
		}
		public String getResourceUrl() {
			return resourceUrl;
		}
		public void setResourceUrl(String resourceUrl) {
			this.resourceUrl = resourceUrl;
		}
		public Permission(String id, String name, String resourceNmame,
				String resourceUrl) {
			super();
			this.id = id;
			this.name = name;
			this.resourceNmame = resourceNmame;
			this.resourceUrl = resourceUrl;
		}
		public Permission() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Permission [id=" + id + ", name=" + name
					+ ", resourceNmame=" + resourceNmame + ", resourceUrl="
					+ resourceUrl + "]";
		}
			
}
