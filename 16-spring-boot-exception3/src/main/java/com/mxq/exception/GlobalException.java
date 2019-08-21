package com.mxq.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局一场处理类
 * @author w
 *
 */
@ControllerAdvice
public class GlobalException {

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
