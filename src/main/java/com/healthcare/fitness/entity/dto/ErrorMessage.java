package com.healthcare.fitness.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorMessage {
	
	private Integer errorCode;
	private String message;

}
