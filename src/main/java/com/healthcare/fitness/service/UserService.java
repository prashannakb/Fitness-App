package com.healthcare.fitness.service;

import java.util.List;

import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.entity.dto.Login;
import com.healthcare.fitness.entity.dto.UserDTO;

public interface UserService {
	
	Integer createUser(UserDTO user);
	Boolean loginUser(Login login)throws Exception;
	UserDTO getUserById(Integer userId)throws Exception;
	
	List<BookingDTO> getBookingByUserId(Integer userId)throws Exception;

}
