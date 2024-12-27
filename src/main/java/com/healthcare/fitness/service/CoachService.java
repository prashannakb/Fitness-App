package com.healthcare.fitness.service;

import java.util.List;

import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.entity.dto.CoachDTO;
import com.healthcare.fitness.entity.dto.Login;

public interface CoachService {
	
	Integer createCoach(CoachDTO coach);
	Boolean loginCoach(Login login) throws Exception;
	CoachDTO getCoachById(Integer coachId) throws Exception;
	List<CoachDTO> getAllCoaches();
	List<BookingDTO> getBookingByCoachId(Integer coachId)throws Exception;

}
