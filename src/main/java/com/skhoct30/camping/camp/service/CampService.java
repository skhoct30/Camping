package com.skhoct30.camping.camp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skhoct30.camping.camp.domain.Camp;
import com.skhoct30.camping.camp.repository.CampRepository;
import com.skhoct30.camping.common.FileManager;

import jakarta.persistence.PersistenceException;


@Service
public class CampService {
	
	
	public final CampRepository campRepository;
	
	public CampService (CampRepository campRepository) {
		this.campRepository = campRepository;
	}
	
	
	
	
	
	// 캠핑장 추가하는 기능
	public boolean addCamp(
			long adminId
			, String campName
			, String region
			, String type
			, MultipartFile File) {
		
		//파일 추가하는 기능
		
		String imagePath = FileManager.saveFile(adminId, File);
		
		
		Camp camp = Camp.builder()
				.adminId(adminId)
				.campName(campName)
				.region(region)
				.type(type)
				.imagePath(imagePath)
				.build();
		
		try {
			campRepository.save(camp);			
		} catch(PersistenceException e) {
			return false;
		}
		
		return true;
	}

}
