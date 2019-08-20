package com.mxq.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxq.ss;
import com.mxq.pojo.Users;
import com.mxq.service.UsersService;

@Controller
@RequestMapping("/users")
public class Userscontroller {
	@Autowired
	private UsersService usersService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String gotoss(@PathVariable String page) {
		return page;
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(Users user) {
		this.usersService.addUser(user);
		return "ok";
	}
	
	/**
	 * 查询全部用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/findUserAll")
	public String findUserAll(Model model) {
		List<Users> list = this.usersService.selectUsersAll();
		model.addAttribute("list", list);
		return "showUsers";
	}
	
	/**
	 * 根据用户id查询用户
	 */
	@RequestMapping("/findUserByid")
	public String findUserByid(Integer id,Model model) {
		Users user = this.usersService.selectUsersByid(id);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	/**
	 * 更新用户
	 */
	@RequestMapping("/editUser")
	public String editUser(Users user) {
		
		this.usersService.updateUser(user);
		
		return "ok";
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping("/delUser")
	public String delUser(Integer id) {
		
		this.usersService.deleteUserById(id);
		
		return "redirect:/users/findUserAll";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request) {
		
		System.out.println("ssssssssssssssss");
		//${rc.contextPath}/template/testticket/贵阳国家高新技术产业开发区创新检测券实施办法（送审稿).doc
		String realPath = request.getSession().getServletContext().getRealPath("/贵阳国家高新区2019年创新检测券申请指南.doc");//得到文件所在位置
		System.out.println(realPath);
		String realPath1 = request.getSession().getServletContext().getRealPath("/贵阳国家高新区2019年创新检测券申请指南.pdf");
		ss s = new ss();
		
        return s.doc_html("E:\\ss.docx", "E:\\ss.pdf");
	}
}
