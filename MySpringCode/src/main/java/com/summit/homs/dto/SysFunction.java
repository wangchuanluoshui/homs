package com.summit.homs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "user_sys_function")
@Table(name = "user_sys_function")
public class SysFunction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid") // 这个是hibernate的注解/生成32位UUID
	@GeneratedValue(generator = "idGenerator")
	// 菜单ID
	private String id;

	// 菜单NAME
	private String name;

	// PID 上级菜单
	private String pid;

	// 资源类型，[menu|button]
	@Column(columnDefinition = "enum('menu','button')")
	private String resourceType;

	// 资源路径.
	private String url;

	// 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
	//位置后做到按钮控制做预留
	private String permission;
	
/*	@OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<SysFunction> childFunctions;*/

/*	public List<SysFunction> getChildFunctions() {
		return childFunctions;
	}

	public void setChildFunctions(List<SysFunction> childFunctions) {
		this.childFunctions = childFunctions;
	}*/

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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	

	public SysFunction(String id, String name, String pid, String resourceType, String url, String permission/*,
			List<SysFunction> childFunctions*/) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.resourceType = resourceType;
		this.url = url;
		this.permission = permission;
//		this.childFunctions = childFunctions;
	}

	public SysFunction() {
		super();
	}

	@Override
	public String toString() {
		return "SysFunction [id=" + id + ", name=" + name + ", pid=" + pid + ", resourceType=" + resourceType + ", url="
				+ url + ", permission=" + permission + "]";
	} 

}
