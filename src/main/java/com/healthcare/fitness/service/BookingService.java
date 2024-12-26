package com.healthcare.fitness.service;

import com.healthcare.fitness.entity.Booking;

public interface BookingService {
	
	public Boolean cancelBooking(Integer bookingId)throws Exception;
	Boolean appointmentBooking(Integer coachId, Integer userId, Booking book)throws Exception;
	Boolean rescheduleBooking(Integer bookingId, Booking book)throws Exception;


}
