package com.healthcare.fitness.service;

import java.util.List;

import com.healthcare.fitness.dto.Login;
import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.entity.User;

public interface UserService {
	
	Integer createUser(User user);
	Boolean loginUser(Login login)throws Exception;
	User getUserById(Integer userId)throws Exception;
	
	List<Booking> getBookingByUserId(Integer userId)throws Exception;

}
