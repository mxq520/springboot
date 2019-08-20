package com.mxq.mapper;

import java.util.List;

import com.mxq.pojo.Users;

public interface UsersMapper {

	void insertUser(Users user);
	
	List<Users> selectUsersAll();
	
	Users selectUsersByid(Integer id);
	
	void updateUser(Users user);
	
	void deleteUserById(Integer id);
	
}
