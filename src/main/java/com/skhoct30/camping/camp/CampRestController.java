package com.skhoct30.camping.camp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skhoct30.camping.camp.service.CampService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/camp")
public class CampRestController {
	
	private final CampService campService;
	
	public CampRestController(CampService campService) {
		this.campService = campService;
	}
	
	
	
	
	// 캠핑장 추가하는 API
	
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam String campName
			, @RequestParam String region
			, @RequestParam String type
			, @RequestParam MultipartFile imageFile
			, HttpSession session) {
		
		Long adminId = (Long)session.getAttribute("adminId");
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(campService.addCamp(adminId, campName, region, type, imageFile)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}

}
