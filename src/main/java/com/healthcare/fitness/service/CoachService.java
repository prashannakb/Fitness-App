package com.healthcare.fitness.service;

import java.util.List;

import com.healthcare.fitness.dto.Login;
import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.Coach;

public interface CoachService {
	
	Integer createCoach(Coach coach);
	Boolean loginCoach(Login login) throws Exception;
	Coach getCoachById(Integer coachId) throws Exception;
	List<Coach> getAllCoaches();
	List<Booking> getBookingByCoachId(Integer coachId)throws Exception;

}
