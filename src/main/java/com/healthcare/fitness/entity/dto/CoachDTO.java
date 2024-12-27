package com.healthcare.fitness.entity.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachDTO {
	
	private Integer coachId;
	
	private String name;
	
	private String gender;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	private String password;
	
	private Long mobileNumber;
	
	private String speciality;

}
