package com.mxq.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mxq.pojo.Users;

/**
 * 参数一T:当前需要映射的实体
 * 参数二：当前映射的实体中的OID的类型
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

	
	
}
