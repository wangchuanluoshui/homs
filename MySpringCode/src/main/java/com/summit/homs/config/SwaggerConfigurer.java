package com.summit.homs.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * 
 * @Title:：SwaggerConfigurer.java 
 * @Package ：com.summit.homs.config 
 * @Description： TODO
 * @author： hyn   
 * @date： 2018年8月16日 下午5:31:11 
 * @version ： 1.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfigurer {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select()
				.apis(RequestHandlerSelectors.basePackage("com.summit.homs.controller")).paths(PathSelectors.any())
				.build();
	}

	private List<SecurityContext> securityContexts() {
		// TODO Auto-generated method stub
		return null;
	}

	private ApiInfo buildApiInf() {
		return new ApiInfoBuilder().title("SmartHOMS 接口文档").description("SmartHOMS 项目的接口文档，符合RESTful API。")
				.version("2.0.1").build();

	}
}
