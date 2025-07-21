package com.skhoct30.camping.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/main")
@Controller
public class MainController {

	
	@GetMapping("/view")
	public String mainView() {
		
		return "main/main";
	}
	
	
}
