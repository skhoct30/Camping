package com.skhoct30.camping.user.service;

import org.springframework.stereotype.Service;

import com.skhoct30.camping.common.MD5HashingEncoder;
import com.skhoct30.camping.user.repository.UserRepository;

@Service
public class UserService {

	
	private final UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	
	
	//사용자 추가 하는 기능
	// boolean << 앞에 repository 에서 int로 성공 실패 여부를 가져오니까 여기서도 boolean 값으로 처리해준다.
	
	public boolean addUser(
			String loginId
			, String password
			, String name
			, String phoneNumber) {
		
		// 해싱 비밀번호 관리

		String hashingPassword = MD5HashingEncoder.encode(password);
		
	
		int count = userRepository.insertUser(loginId, hashingPassword, name, phoneNumber);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	// 아이디 중복 확인
	
	public boolean isDuplicateId(String loginId) {
		
		// 중복되는 행이 있는 지 없는지 count 쿼리로 확인할 것.
		
		
		int count =  userRepository.selectCountByLoginId(loginId);
		
		if(count == 1) {
			return true;
			
		} else {
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
