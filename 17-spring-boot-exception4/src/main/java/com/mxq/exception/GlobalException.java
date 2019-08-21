package com.mxq.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 全局一场处理类
 * @author w
 *
 */
@Configuration
public class GlobalException {

	/**
	 * 该方法必须要有返回值。返回值类型必须是：SimpleMappingExceptionResolver
	 */
	@Bean
	public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		
		Properties mappings = new Properties();
		
		/**
		 * 参数一：异常的类型，注意必须是异常类型的全名
		 * 参数二：视图名称
		 */
		mappings.putIfAbsent("java.lang.NullPointerException", "error1");
		mappings.putIfAbsent("java.lang.ArithmeticException", "error");
		
		//设置异常与视图映射信息的
		resolver.setExceptionMappings(mappings);
		
		return resolver;
	}
}
