package com.skhoct30.camping.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skhoct30.camping.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	private UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	
	
	
	
	// 회원가입을 위한 API
	
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam String loginId
			, @RequestParam String password
			, @RequestParam String name
			, @RequestParam String phoneNumber) {
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(userService.addUser(loginId, password, name, phoneNumber)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	
	// 아이디 중복 확인을 위한 API
	
	@GetMapping("/duplicate-id")
	public Map<String, Boolean> isDuplicateId(@RequestParam String loginId) {
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if(userService.isDuplicateId(loginId)) {
			resultMap.put("result", true);
		} else {
			resultMap.put("result", false);
		}
		return resultMap;
		
		
	}
	
	
	
	
	
	
	
}
