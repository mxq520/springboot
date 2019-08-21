package com.mxq.test;

import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxq.App;
import com.mxq.dao.RolesRepository;
import com.mxq.pojo.Menus;
import com.mxq.pojo.Roles;

/**
 * 多对多关联测试 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ManyToManyTest {

	@Autowired
	private RolesRepository rolesReository;
	
	/**
	 * 添加测试
	 */
	@Test
	public void testSave() {
		//创建角色对象
		Roles r = new Roles();
		r.setRolename("项目经理");
		
		//创建菜单对象
		Menus menus = new Menus();
		menus.setMenusname("xxxx管理系统");
		menus.setFatherid(0);
		
		//关联
		Menus menus2 = new Menus();
		menus2.setMenusname("项目管理");
		menus2.setFatherid(1);
		r.getMenus().add(menus);
		r.getMenus().add(menus2);
		menus.getRoles().add(r);
		menus2.getRoles().add(r);
		
		//保存
		this.rolesReository.save(r);
	}
	
	/**
	 * 添加测试
	 */
	@Test
	public void testFind() {
		Optional<Roles> roles = this.rolesReository.findById(2);
		
		System.out.println(roles.get().getRolename());
		
		Set<Menus> menus = roles.get().getMenus();
		
		for(Menus menus2:menus) {
			System.out.println(menus2.toString());
		}
	}
	
}
