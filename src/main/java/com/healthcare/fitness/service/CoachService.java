package com.healthcare.fitness.service;

import java.util.List;

import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.entity.dto.CoachDTO;
import com.healthcare.fitness.entity.dto.Login;
import com.healthcare.fitness.exception.CoachNotFoundException;

public interface CoachService {
	
	Integer createCoach(CoachDTO coach);
	Boolean loginCoach(Login login) throws CoachNotFoundException;
	CoachDTO getCoachById(Integer coachId) throws CoachNotFoundException;
	List<CoachDTO> getAllCoaches();
	List<BookingDTO> getBookingByCoachId(Integer coachId)throws CoachNotFoundException;

}
