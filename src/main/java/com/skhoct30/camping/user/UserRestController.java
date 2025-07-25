package com.skhoct30.camping.user;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skhoct30.camping.user.domain.User;
import com.skhoct30.camping.user.service.UserService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

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
	
	
	// 로그인을 위한 API
	
	@PostMapping("/login")
	public Map<String, String> login(
			@RequestParam String loginId
			, @RequestParam String password
			, HttpSession session) {
		
		User user = userService.getUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null) {
			resultMap.put("result", "success");
			
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoinId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userPhoneNumber", user.getPhoneNumber());
			
			
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	
	
	
	
	
}
