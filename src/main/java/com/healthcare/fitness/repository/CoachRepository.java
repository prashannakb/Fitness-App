package com.healthcare.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.fitness.entity.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer>{
	
	

}
