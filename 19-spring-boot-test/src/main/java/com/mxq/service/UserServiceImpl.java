package com.mxq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxq.dao.UserDaoImpl;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDaoImpl userDaoImpl;
	
	public void addUser() {
		this.userDaoImpl.saveUser();
	}
}
