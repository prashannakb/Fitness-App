package com.healthcare.fitness.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.healthcare.fitness.entity.dto.ErrorMessage;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CoachNotFoundException.class)
	public ResponseEntity<ErrorMessage> CoachNotFoundException(CoachNotFoundException error){
		ErrorMessage msg=new ErrorMessage();
		msg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		msg.setMessage(error.getMessage());
		return ResponseEntity.badRequest().body(msg);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> UserNotFoundException(UserNotFoundException error){
		ErrorMessage msg=new ErrorMessage();
		msg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		msg.setMessage(error.getMessage());
		return ResponseEntity.badRequest().body(msg);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> Exception(Exception error){
		ErrorMessage msg=new ErrorMessage();
		msg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		msg.setMessage(error.getMessage());
		return ResponseEntity.badRequest().body(msg);
	}
	
	//validation failures on DTOs
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleValidationExceptions(
		  MethodArgumentNotValidException ex) {
			 ErrorMessage error = new ErrorMessage();
		     error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		     error.setMessage(ex.getBindingResult().getAllErrors().stream()
	                                                        .map(ObjectError::getDefaultMessage)
		        		                                    .collect(Collectors.joining(", ")));
		     return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		
	//Validation failures on URI parameters	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConstraintValidationExceptions(
			ConstraintViolationException ex) {
			 ErrorMessage error = new ErrorMessage();
	         error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	         error.setMessage(ex.getConstraintViolations().stream()
	                                                         .map(ConstraintViolation::getMessage)
	        		                                      .collect(Collectors.joining(", ")));
	         return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	

	
	

}
