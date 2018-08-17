package com.summit.homs.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @Title:：SysRole.java 
 * @Package ：com.summit.homs.dto 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月16日 下午4:46:48 
 * @version ： 1.0
 */
@Entity
@Table(name = "user_sys_role")
public class SysRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid") // 这个是hibernate的注解/生成32位UUID
	@GeneratedValue(generator = "idGenerator")
	// 用户ID
	private String id;

	// 登录用户名
	private String name;

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

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", name=" + name + "]";
	}

}
