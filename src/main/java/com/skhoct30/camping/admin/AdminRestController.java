package com.skhoct30.camping.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skhoct30.camping.admin.domain.Admin;
import com.skhoct30.camping.admin.service.AdminService;
import com.skhoct30.camping.user.domain.User;

import jakarta.servlet.http.HttpSession;


@RequestMapping("/admin")
@RestController
public class AdminRestController {
	
	
	
	
	private AdminService adminService;
	
	public AdminRestController(AdminService adminService) {
		this.adminService = adminService;
	}

	// 회원가입을 위한 API
	
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam String loginId
			, @RequestParam String password
			, @RequestParam String name
			, @RequestParam String phoneNumber) {
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(adminService.addAdmin(loginId, password, name, phoneNumber)) {
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
		
		if(adminService.isDuplicateId(loginId)) {
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
		
		Admin admin = adminService.getUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(admin != null) {
			resultMap.put("result", "success");
			
			session.setAttribute("userId", admin.getId());
			session.setAttribute("userLoinId", admin.getLoginId());
			session.setAttribute("userName", admin.getName());
			session.setAttribute("userPhoneNumber", admin.getPhoneNumber());
			
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	
	
}
