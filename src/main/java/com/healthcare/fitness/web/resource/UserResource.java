package com.healthcare.fitness.web.resource;

import java.util.List;

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

import com.healthcare.fitness.dto.Login;
import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.User;
import com.healthcare.fitness.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<Integer> createUser(@RequestBody User user){
		Integer resp=userService.createUser(user);
		return new ResponseEntity<Integer>(resp,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Login login)
	{
		Boolean log=null;
		try {
			log=userService.loginUser(login);
		}
		catch(Exception ex)
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		return new ResponseEntity<Boolean>(log,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") Integer userId)
	{
		User user=null;
		try {
			user=userService.getUserById(userId);
		}
		catch(Exception ex)
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		return new ResponseEntity<User>(user,new HttpHeaders(),HttpStatus.FOUND);
	}
	
	@GetMapping("/booking/{userId}")
	public ResponseEntity<?> getBooking(@PathVariable Integer userId){
		
		List<Booking> booking=null;
		
		try {
			booking=userService.getBookingByUserId(userId);
		}
		catch(Exception ex)
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}		
		
		return new ResponseEntity<List<Booking>>(booking,new HttpHeaders(),HttpStatus.OK);
//		return null;
	}
	
	

}
