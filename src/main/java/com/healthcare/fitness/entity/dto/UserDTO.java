package com.healthcare.fitness.entity.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@Getter
@Setter
@JacksonXmlRootElement
public class UserDTO {
	
	private Integer userId;
	
	private String name;
	
	private String gender;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	
	private String password;
	
	private Long mobileNumber;
	
	private String email;
	
	private Integer pincode;
	
	private String city;
	
	private String state;
	
	private String country;

}
