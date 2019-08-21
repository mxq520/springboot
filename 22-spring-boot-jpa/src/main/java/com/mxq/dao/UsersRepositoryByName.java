package com.mxq.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.mxq.pojo.Users;

public interface UsersRepositoryByName extends Repository<Users, Integer> {

	//方法的名称必须要遵循驼峰式命名规则。findBy(关键字)+属性名称(首字母要大写)+查询条件(首字母要大写)
	List<Users> findByName(String name);
	
	List<Users> findByNameAndAge(String name, Integer age);
	
	List<Users> findByNameLike(String name);
	
}
