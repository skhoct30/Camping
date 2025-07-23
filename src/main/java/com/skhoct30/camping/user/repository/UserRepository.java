package com.skhoct30.camping.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.camping.user.domain.User;

@Mapper
public interface UserRepository {

	// Mybatis 에서 가져올 정수값들 int
	// 성공 실패 확인을 위해
	public int insertUser(
			@Param("loginId") String loginId
			,@Param("password") String password
			, @Param("name") String name
			, @Param("phoneNumber") String phoneNumber);
	
	
	public int selectCountByLoginId(@Param("loginId") String loginId);
	
	
	public User selectUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
}
