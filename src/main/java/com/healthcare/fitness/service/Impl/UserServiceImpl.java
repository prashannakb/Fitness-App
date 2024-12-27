package com.healthcare.fitness.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.User;
import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.entity.dto.Login;
import com.healthcare.fitness.entity.dto.UserDTO;
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
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public Integer createUser(UserDTO user) {
		// TODO Auto-generated method stub
		User newUser=userRepository.save(mapper.map(user,User.class));
		
		return newUser.getUserId();
	}
	@Override
	public Boolean loginUser(Login login) throws Exception {
		// TODO Auto-generated method stub
		User user1=userRepository.findById(login.getId()).orElseThrow(()->new Exception("User Not Found"));
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
			throw new Exception("User Name Is Wrong");
		}
//		return null;
	}
	@Override
	public UserDTO getUserById(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		User user1=userRepository.findById(userId).orElseThrow(()->new Exception("User Not Found"));
		UserDTO user=mapper.map(user1, UserDTO.class);
		return user;
	}
	@Override
	public List<BookingDTO> getBookingByUserId(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userId).orElseThrow(()->new Exception("User Not Found"));
		List<Booking> booking=bookingrepository.findByUser(user);
		List<BookingDTO> DTOlist=new ArrayList<>();
		for(Booking book:booking) {
			BookingDTO dto=mapper.map(book, BookingDTO.class);
			DTOlist.add(dto);
		}
		return DTOlist;
	}

}
