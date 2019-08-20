package com.mxq.service;

import java.util.List;

import com.mxq.pojo.Users;

public interface UsersService {

	void addUser(Users user);
	
	List<Users> selectUsersAll();
	
	Users selectUsersByid(Integer id);
	
	void updateUser(Users user);
	
	void deleteUserById(Integer id);
}
