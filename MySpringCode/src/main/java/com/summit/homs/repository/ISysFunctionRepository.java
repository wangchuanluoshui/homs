package com.summit.homs.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.summit.homs.dto.LoginSysUser;
import com.summit.homs.dto.SysFunction;
import com.summit.homs.dto.SysUser;

import java.lang.String;
import java.util.List;


/**
 * 
 * @Title:：ISysFunctionRepository.java 
 * @Package ：com.summit.homs.repository 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月20日 上午10:51:49 
 * @version ： 1.0
 */
public interface ISysFunctionRepository extends JpaRepository<SysFunction, String> {

    

}
