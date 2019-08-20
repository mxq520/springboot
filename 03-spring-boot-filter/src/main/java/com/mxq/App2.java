package com.mxq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.mxq.filter.SecondFilter;
import com.mxq.servlet.SecondServlet;

/**
 * SpringBoot整合Filter 方式二
 *
 */
@SpringBootApplication
public class App2 {

	public static void main(String[] args) {
		
		SpringApplication.run(App2.class, args);
		
	}
	
	/**
	 * 注册Servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		
		bean.addUrlMappings("/second");
		return bean;
	}
	
	/**
	 * 注册Filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean filter = new FilterRegistrationBean(new SecondFilter());
		filter.addUrlPatterns("/second");
		return filter;
	}

}
