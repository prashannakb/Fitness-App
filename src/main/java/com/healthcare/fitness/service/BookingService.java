package com.healthcare.fitness.service;

import com.healthcare.fitness.entity.dto.BookingDTO;

public interface BookingService {
	
	public Boolean cancelBooking(Integer bookingId)throws Exception;
	Boolean appointmentBooking(Integer coachId, Integer userId, BookingDTO book)throws Exception;
	Boolean rescheduleBooking(Integer bookingId, BookingDTO book)throws Exception;


}
