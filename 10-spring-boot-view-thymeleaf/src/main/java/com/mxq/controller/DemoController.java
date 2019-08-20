package com.mxq.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mxq.pojo.Users;

/**
 *Thymeleaf入门案例 
 *
 */
@Controller
public class DemoController {

	@RequestMapping("/show1")
	public String showInfo(Model model) {
		model.addAttribute("msg", "Thymeleaf第一个案例");
		model.addAttribute("key", new Date());
		return "index";
	}
	
	@RequestMapping("/show2")
	public String showInfo2(Model model) {
		model.addAttribute("sex", "女");
		model.addAttribute("id", "2");
		return "index2";
	}
	
	@RequestMapping("/show3")
	public String showInfo3(Model model) {
		List<Users> list = new ArrayList<Users>();
		list.add(new Users(1, "张三", 23));
		list.add(new Users(2, "张四", 23));
		list.add(new Users(3, "张五", 23));
		list.add(new Users(4, "张六", 23));
		model.addAttribute("list", list);
		return "index3";
	}
	@RequestMapping("/show4")
	public String showInfo4(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("u1", new Users(1, "张三", 20));
		map.put("u2", new Users(2, "张四", 20));
		map.put("u3", new Users(3, "张五", 20));
		model.addAttribute("map", map);
		return "index4";
	}
	
	@RequestMapping("/show5")
	public String showInfo5(HttpServletRequest request,Model model) {
		request.setAttribute("req", "HttpServletRequest");
		request.getSession().setAttribute("sess", "HttpSession");
		request.getSession().getServletContext().setAttribute("app", "Application");
		return "index5";
	}
}
