package com.mxq.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mxq.mapper.UsersMapper;
import com.mxq.pojo.Users;
import com.mxq.service.UsersService;

@Service
@Transactional
public class UserServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void addUser(Users user) {
		this.usersMapper.insertUser(user);
	}

	@Override
	public List<Users> selectUsersAll() {
		return this.usersMapper.selectUsersAll();
	}

	@Override
	public Users selectUsersByid(Integer id) {
		return this.usersMapper.selectUsersByid(id);
	}

	@Override
	public void updateUser(Users user) {
		this.usersMapper.updateUser(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		this.usersMapper.deleteUserById(id);
	}

}
