package com.mxq.test;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxq.App;
import com.mxq.dao.UsersRepository;
import com.mxq.pojo.Roles;
import com.mxq.pojo.Users;

/**
 *一对多关联测试 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest( classes = App.class)
public class OneToManyTest {

	@Autowired
	private UsersRepository usersRepository;
	
	/**
	 * 一对多关联关系的添加
	 */
	@Test
	public void testSave() {
		//创建一个用户
		Users user = new Users();
		
		user.setAddress("天津");
		user.setName("小刚");
		user.setAge(20);
		
		//创建一个角色
		Roles roles = new Roles();
		roles.setRolename("管理员");
		
		
		//关联
		roles.getUsers().add(user);
		user.setRoles(roles);
		
		//保存
		this.usersRepository.save(user);
	}
	
	/**
	 * 一对多关联关系的查询
	 */
	@Test
	public void testFind() {
		
		Optional<Users> user = this.usersRepository.findById(5);
		System.out.println(user.get());
		Roles roles = user.get().getRoles();
		System.out.println(roles.getRolename());
	}
	
}
