package com.skhoct30.camping.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	// private HttpServletRequest request;

	
	@GetMapping("/join")
	public String mainAdminJoinView() {
		return "user/adminJoin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		
		return "redirect:/main/view";
	}
	
	// 관리자 메인홈
	@GetMapping("/main/view")
	public String adminMainView() {
		return "main/adminMain";
	}
	
	
	//캠핑장 추가하는 페이지
	
	
	@GetMapping("/create")
	public String createCamping() {
		return "admin/create";
	}
	
	
	
	
	
	
}
