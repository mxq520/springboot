package com.mxq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mxq.dao.UsersRepository;
import com.mxq.pojo.Users;
import com.mxq.service.UsersService;

/**
 *UsersService接口实现类 
 *
 */
@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Cacheable(value = "users")
	public List<Users> findUserAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	@Cacheable(value = "users",key = "#pageable.pageSize")
	public Page<Users> findUserByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.usersRepository.findAll(pageable);
	}

	@Override
	//@CacheEvict(value = "users",allEntries = true) 清除缓存中以user缓存策略缓存的对象
	@CacheEvict(value = "users",allEntries = true)
	public void saveUsers(Users users) {
		// TODO Auto-generated method stub
		this.usersRepository.save(users);
	}

	@Override
	//@Cacheable:对当前查询的对象做缓存处理
	@Cacheable(value = "users")
	public Users findUserById(Integer id) {
		// TODO Auto-generated method stub
		return this.usersRepository.findById(id).get();
	}

	
	
}
