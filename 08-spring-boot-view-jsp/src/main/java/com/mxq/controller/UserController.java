package com.mxq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mxq.pojo.Users;

/**
 * SpringBoot整合jsp
 *
 */
@Controller
public class UserController {

	/**
	 * 处理请求，产生数据
	 */
	@RequestMapping("/showUser")
	public String showUser(Model model) {
		List<Users> list = new ArrayList<Users>();
		list.add(new Users(1, "张三", 23));
		list.add(new Users(2, "张四", 23));
		list.add(new Users(3, "张五", 23));
		list.add(new Users(4, "张六", 23));
			
		//需要一个model对象
		model.addAttribute("list", list);
		
		//跳转视图
		return "index";
	}
}
