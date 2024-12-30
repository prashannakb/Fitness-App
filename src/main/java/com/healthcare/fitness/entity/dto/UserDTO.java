package com.healthcare.fitness.entity.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JacksonXmlRootElement
public class UserDTO {
	
	private Integer userId;
	@NotNull
	@Pattern(regexp="[A-Z][a-z]*")
	private String name;
	@NotNull
	@Pattern(regexp="[A-Z][a-z]*")
	private String gender;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@NotEmpty
	private String password;
	@NotNull
	private Long mobileNumber;
	@Email
	private String email;
	@Positive
	private Integer pincode;
	@NotNull
	@Pattern(regexp="[A-Z][a-z]*")
	private String city;
	@NotNull
	@Pattern(regexp="[A-Z][a-z]*")
	private String state;
	@NotNull
	@Pattern(regexp="[A-Z][a-z]*")
	private String country;

}
