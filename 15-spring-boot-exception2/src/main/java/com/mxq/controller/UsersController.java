package com.mxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * springboot 处理异常方式一，自定义错误页面
 *
 */
@Controller
public class UsersController {

	
	@RequestMapping("/show")
	public String showInfo() {
		
		String str = null;
		str.length();
		return "ok";
	}
	
	@RequestMapping("/show2")
	public String showInfo2() {
		
		int a = 100/0;
		return "ok";
	}
	
	/**
	 * java.lang.ArithmeticException
	 * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数Exception e:会将产生的异常对象注入到方法中
	 */
	@ExceptionHandler(value = {java.lang.ArithmeticException.class,java.lang.NullPointerException.class})
	public ModelAndView arithmeticException(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error1");
		mv.addObject("error", e.toString());
		
		return mv;
	}
}
