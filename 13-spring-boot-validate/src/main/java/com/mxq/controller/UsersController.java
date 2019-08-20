package com.mxq.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mxq.pojo.Users;

/**
 * springboot 表单数据校验
 *
 */
@Controller
public class UsersController {

	/**
	 * 解决异常的方式：可以在跳转的方法中注入一个Users对象。
	 * 注意：由于springmvc会将该对象放入Model中传递。key的名称会使用该对象的驼峰式的命名规则来作为key。
	 * 所以参数的变量名需要与对象的名称相同。将首字母小写。
	 * @param users
	 * @return
	 * 
	 * 如果想为传递的对象更改名称，可以使用@ModelAttribute("")这个表示当前传递的对象的key为aa。
	 * 那么我们在页面中获取对象的key也需要修改为aa
	 * 
	 */
	
	@RequestMapping("/addUser")
	public String showPage(@ModelAttribute("aa") Users users) {
		
		return "add";
	}
	
	/**
	 * 完成用户添加
	 * @Valid 开启Users对象的数据校验
	 * BindingResult 封装了校验的结果
	 */
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute("aa") @Valid Users users,BindingResult result) {
		if(result.hasErrors()) {
			return "add";
		}
		
		System.out.println(users);
		return "ok";
	}
}
