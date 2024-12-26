package com.healthcare.fitness.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.fitness.dto.Login;
import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.User;
import com.healthcare.fitness.repository.Bookingrepository;
import com.healthcare.fitness.repository.UserRepository;
import com.healthcare.fitness.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Bookingrepository bookingrepository;
	@Override
	public Integer createUser(User user) {
		// TODO Auto-generated method stub
		User newUser=userRepository.save(user);
		return newUser.getUserId();
	}
	@Override
	public Boolean loginUser(Login login) throws Exception {
		// TODO Auto-generated method stub
		User user=userRepository.findById(login.getId()).orElseThrow(()->new Exception("User Not Found"));
		if(null==user) {
		return null;
		}
		if(null!=login.getName() && login.getName().equalsIgnoreCase(user.getName())) {
			if(null!=login.getPassword() && login.getPassword().equals(user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			throw new Exception("User Name Is Wrong");
		}
//		return null;
	}
	@Override
	public User getUserById(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userId).orElseThrow(()->new Exception("User Not Found"));
		return user;
	}
	@Override
	public List<Booking> getBookingByUserId(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userId).orElseThrow(()->new Exception("User Not Found"));
		List<Booking> booking=bookingrepository.findByUser(user);
		
		return booking;
	}

}
