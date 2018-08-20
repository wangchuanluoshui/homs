package com.summit.homs.repository;


import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.summit.homs.dto.LoginSysUser;
import com.summit.homs.dto.SysRole;
import com.summit.homs.dto.SysUser;

import java.lang.String;
import java.util.List;


/**
 * 
* @Title:：SysUserRepository.java 
* @Package ：com.summit.homs.repository 
* @Description： TODO
* @author： hyn   
* @date： 2018年8月14日 上午10:36:48 
* @version ： 1.0
* 
* 权限DAO
 */
public interface ISysRoleRepository  extends JpaRepository<SysRole,String>{
	
    @Modifying
	@Query(value = "insert into user_sys_role (id,name) values (?1,?2)",nativeQuery = true)
	int iSave(String id,String name);
	
    @Modifying
	@Query(value = "delete from user_sys_role where id = ?1",nativeQuery = true)
	void iDelete(String id);
	
    @Modifying
	@Query(value = "update user_sys_role set name = ?2 where id = ?1",nativeQuery = true)
    Integer iUpdate(String id,String name);
    
	@Query(value = "select id,name from user_sys_role where id = ?1",nativeQuery = true)
	List<Object[]> iQuert(String id);
    
	
	@Modifying
	@Query(value = "delete from user_sys_user_roles where roles_id = ?1",nativeQuery = true)
	void iDeleteRolesRelatedUser(String roleid);
	
	
}
