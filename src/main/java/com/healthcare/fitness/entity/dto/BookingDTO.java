package com.healthcare.fitness.entity.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.entity.User;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {
	
	private Integer bookingId;
	
	private Coach coach;
	
	private User user;
	@FutureOrPresent(message="Date must be present or future.Format yyyy-mm-dd")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate appointment;
	@NotNull(message="Please enter a valid slot")
	@NotEmpty(message="Please enter a valid slot")
	private String slot;
	

}
