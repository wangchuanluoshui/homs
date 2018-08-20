package com.summit.homs.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.summit.homs.dto.LoginSysUser;
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
* 用户DAO
 */
public interface ISysUserRepository extends JpaRepository<SysUser, String> {
	SysUser findByLoginUserName(String loginName);
    List<SysUser> findByChineseName(String chineseName);
    List<SysUser> findByLoginUserNameOrChineseNameOrPhone(String loginUserName,String chineseName,String phone);
}
