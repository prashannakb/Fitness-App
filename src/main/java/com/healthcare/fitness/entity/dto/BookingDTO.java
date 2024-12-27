package com.healthcare.fitness.entity.dto;

import java.time.LocalDate;

import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {
	
	private Integer bookingId;

	private Coach coach;
	
	private User user;

	private LocalDate appointment;

	private String slot;
	

}
