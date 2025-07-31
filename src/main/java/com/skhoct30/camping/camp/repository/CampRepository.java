package com.skhoct30.camping.camp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skhoct30.camping.camp.domain.Camp;

public interface CampRepository extends JpaRepository<Camp, Long> {

}
