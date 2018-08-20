package com.summit.homs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.summit.homs.service.imp.UserDetailsServiceImpl;
import com.summit.homs.tool.security.CustomAuthenticationFilter;
import com.summit.homs.tool.security.LoginFailHandler;
import com.summit.homs.tool.security.LoginSuccessHandler;
import com.summit.homs.util.PasswordEncode;
/**
 * 
 * Security 安全框架配置
 * @Title:：WebSecurityConfig.java 
 * @Package ：com.summit.homs.config 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月16日 下午5:30:53 
 * @version ： 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}
	
	@Bean
	LoginFailHandler loginFailHandler() {
		return new LoginFailHandler();
	}
	
	@Bean
	UserDetailsService customUserService() {
		return new UserDetailsServiceImpl();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncode());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		// swagger start
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("/swagger-resources/**").permitAll()
        .antMatchers("/images/**").permitAll()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/v2/api-docs").permitAll()
        .antMatchers("/configuration/ui").permitAll()
        .antMatchers("/configuration/security").permitAll()
        // swagger end
		.antMatchers("/", "/login").permitAll()
		.anyRequest()
		.authenticated()
		.and().formLogin()
        .loginPage("/login").permitAll()
        .successHandler(loginSuccessHandler())
        .failureHandler(loginFailHandler())
        .and().logout().permitAll();
		http.sessionManagement().maximumSessions(1);
		
		http.addFilterAt(customAuthenticationFilter(),
			    UsernamePasswordAuthenticationFilter.class);
	}
	
	//配置拦截器 处理login是json的情况
	@Bean
	CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
	    CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
	    filter.setAuthenticationSuccessHandler(loginSuccessHandler());
	    filter.setAuthenticationFailureHandler(loginFailHandler());

	    //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
	    filter.setAuthenticationManager(authenticationManagerBean());
	    return filter;
	}

}
