package com.healthcare.fitness.entity.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachDTO {
	
	private Integer coachId;
	@NotNull
	@Pattern(regexp="[A-Z][a-z]*")
	private String name;
	@NotNull
	@Pattern(regexp="[A-Z][a-z]*")
	private String gender;
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
//	@Pattern(regexp="/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?!.* ).{8,16}$/")
	@NotEmpty
	private String password;
	@NotNull
	private Long mobileNumber;
	@NotBlank
	private String speciality;

}
