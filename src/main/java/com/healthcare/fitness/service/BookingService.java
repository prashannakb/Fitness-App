package com.healthcare.fitness.service;

import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.exception.BookingIdNotFoundException;
import com.healthcare.fitness.exception.CoachNotFoundException;
import com.healthcare.fitness.exception.UserNotFoundException;

public interface BookingService {
	
	public Boolean cancelBooking(Integer bookingId)throws BookingIdNotFoundException ;
	Boolean appointmentBooking(Integer coachId, Integer userId, BookingDTO book)throws BookingIdNotFoundException, UserNotFoundException, CoachNotFoundException;
	Boolean rescheduleBooking(Integer bookingId, BookingDTO book)throws BookingIdNotFoundException;


}
