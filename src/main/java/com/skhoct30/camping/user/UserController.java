package com.skhoct30.camping.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@GetMapping("/join")
	public String mainJoinView() {
		return "user/join";
	}
	
	@GetMapping("/adminJoin")
	public String mainAdminJoinView() {
		return "user/adminJoin";
	}
	
	
}
