package com.mxq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mxq.ss;
import com.mxq.pojo.Users;
import com.mxq.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "用户信息管理")
@Controller
@RequestMapping("/users")
public class Userscontroller {
	@Autowired
	private UsersService usersService;
	
	public static MappingJackson2JsonView JSON = new MappingJackson2JsonView();
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
	
	@ApiOperation(value = "获取用户信息列表", notes = "获取用户信息列表")
	@RequestMapping(value = "/findUserAllswagger",method = RequestMethod.GET)
	@ResponseBody
	public View findUserAllswagger(Model model) {
		List<Users> list = this.usersService.selectUsersAll();
		model.addAttribute("list", list);
		return JSON;
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
	@ApiOperation(value = "获取用户信息", notes = "根据id获取用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "id",value = "信息编号",dataType = "Integer",required = true)
	})
	@RequestMapping(value = "/findUserByidswagger",method = RequestMethod.POST)
	@ResponseBody
	public View findUserByidswagger(@ApiParam(value = "id",required = true) Integer id,Model model) {
		
		System.out.println("id:"+id);
		Users user = this.usersService.selectUsersByid(id);
		model.addAttribute("user", user);
		return JSON;
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
