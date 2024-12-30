package com.healthcare.fitness.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.fitness.constant.AppConstant;
import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.User;
import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.entity.dto.Login;
import com.healthcare.fitness.entity.dto.UserDTO;
import com.healthcare.fitness.exception.UserNotFoundException;
import com.healthcare.fitness.repository.Bookingrepository;
import com.healthcare.fitness.repository.UserRepository;
import com.healthcare.fitness.service.UserService;

@Service
@Transactional
@PropertySource("classpath:validation.properties")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Bookingrepository bookingrepository;
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private Environment env;
	
	@Override
	public Integer createUser(UserDTO user) {
		// TODO Auto-generated method stub
		User newUser=userRepository.save(mapper.map(user,User.class));
		
		return newUser.getUserId();
	}
	@Override
	public Boolean loginUser(Login login) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user1=userRepository.findById(login.getId()).orElseThrow(()->new UserNotFoundException(env.getProperty(AppConstant.USER_ID_NOTFOUND.toString())));
		UserDTO user=mapper.map(user1, UserDTO.class);
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
			throw new UserNotFoundException(env.getProperty(AppConstant.USER_DATA_INVALID.toString()));
		}
//		return null;
	}
	@Override
	public UserDTO getUserById(Integer userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user1=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(env.getProperty(AppConstant.USER_ID_NOTFOUND.toString())));
		UserDTO user=mapper.map(user1, UserDTO.class);
		return user;
	}
	@Override
	public List<BookingDTO> getBookingByUserId(Integer userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(env.getProperty(AppConstant.USER_ID_NOTFOUND.toString())));
		List<Booking> booking=bookingrepository.findByUser(user);
		List<BookingDTO> DTOlist=new ArrayList<>();
		for(Booking book:booking) {
			BookingDTO dto=mapper.map(book, BookingDTO.class);
			DTOlist.add(dto);
		}
		return DTOlist;
	}

}
