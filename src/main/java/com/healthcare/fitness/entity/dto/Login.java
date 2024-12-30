package com.healthcare.fitness.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {
	
	private Integer id;
	@NotNull(message="Please Enter Proper Name")
	private String name;
	@NotEmpty(message="Password is invalid")
	private String password;

}
