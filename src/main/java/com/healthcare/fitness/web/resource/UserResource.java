package com.healthcare.fitness.web.resource;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.fitness.entity.User;
import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.entity.dto.Login;
import com.healthcare.fitness.entity.dto.UserDTO;
import com.healthcare.fitness.exception.UserNotFoundException;
import com.healthcare.fitness.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper mapper;
	@PostMapping("/create")
	public ResponseEntity<Integer> createUser(@Valid @RequestBody User user){
		Integer resp=userService.createUser(mapper.map(user, UserDTO.class));
		return new ResponseEntity<Integer>(resp,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@PostMapping(value="/create",headers="API-Version=2")
	public ResponseEntity<Integer> createUserv2(@Valid @RequestBody UserDTO user){
		Integer resp=userService.createUser(user);
		return new ResponseEntity<Integer>(resp,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody Login login)throws UserNotFoundException
	{
		Boolean log=null;
//		try {
			log=userService.loginUser(login);
//		}
//		catch(Exception ex)
//		{
//			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//		}
		return new ResponseEntity<Boolean>(log,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value="/{userId}",params="v=1",produces="application/json")
	public ResponseEntity<?> getUserById(@PathVariable("userId") Integer userId)throws UserNotFoundException
	{
		UserDTO user=null;
//		try {
			user=userService.getUserById(userId);
//		}
//		catch(Exception ex)
//		{
//			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//		}
		return new ResponseEntity<User>(mapper.map(user, User.class),new HttpHeaders(),HttpStatus.FOUND);
	}
	
	@GetMapping(value="/{userId}",produces="application/vnd.fitness.app-v2+xml")
	public ResponseEntity<?> getUserByIdv2(@PathVariable("userId") Integer userId)throws UserNotFoundException
	{
		UserDTO user=null;
//		try {
			user=userService.getUserById(userId);
//		}
//		catch(Exception ex)
//		{
//			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//		}
		return new ResponseEntity<UserDTO>(user,new HttpHeaders(),HttpStatus.FOUND);
	}
	
	@GetMapping("/booking/{userId}")
	public ResponseEntity<?> getBooking(@PathVariable Integer userId)throws UserNotFoundException{
		
		List<BookingDTO> booking=null;
		
//		try {
			booking=userService.getBookingByUserId(userId);
//		}
//		catch(Exception ex)
//		{
//			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//		}		
//		
		return new ResponseEntity<List<BookingDTO>>(booking,new HttpHeaders(),HttpStatus.OK);
//		return null;
	}
	
	

}
