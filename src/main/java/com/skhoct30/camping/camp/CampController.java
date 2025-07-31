package com.skhoct30.camping.camp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/camp")
public class CampController {

	
	
	
	//캠핑장 추가하는 페이지

	@GetMapping("/create")
	public String createCamping() {
		return "admin/create";
	}
	
	
}
