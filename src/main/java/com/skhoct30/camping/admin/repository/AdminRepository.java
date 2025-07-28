package com.skhoct30.camping.admin.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.camping.admin.domain.Admin;


@Mapper
public interface AdminRepository {
	
	// Mybatis 에서 가져올 정수값들 int
	// 성공 실패 확인을 위해
	public int insertAdmin(
			@Param("loginId") String loginId
			,@Param("password") String password
			, @Param("name") String name
			, @Param("phoneNumber") String phoneNumber);
	
	// 아이디 중복확인
	public int selectCountByLoginId(@Param("loginId") String loginId);
	
	
	public Admin selectAdmin(
			@Param("loginId") String loginId
			, @Param("password") String password);

}
