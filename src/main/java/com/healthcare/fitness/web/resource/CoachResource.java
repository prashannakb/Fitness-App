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
import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.service.CoachService;

@RestController
@RequestMapping("/api/coach")
public class CoachResource {
	
	@Autowired
	private CoachService coachService;
	
	@PostMapping("/create")
	public ResponseEntity<Integer> createCoach(@RequestBody Coach coach){
		Integer id=null;
		
			id=coachService.createCoach(coach);
		
		
		return new ResponseEntity<Integer>(id,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?>coachLogin(@RequestBody Login login)
	{
		
		Boolean log=false;
		try {
			log=coachService.loginCoach(login);
		}
		catch(Exception ex)
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		return new ResponseEntity<Boolean>(log,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{coachId}")
	public ResponseEntity<Coach> getCoachById(@PathVariable("coachId") Integer coachId )
	{
		System.out.println("get coach "+coachId);
		Coach coach=null;
		try {
			coach=coachService.getCoachById(coachId);
		}
		catch(Exception ex)
		{
			return  ResponseEntity.notFound().build();
		}
		return new ResponseEntity<Coach>(coach,new HttpHeaders(),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Coach>>getAllCoach(){
		List<Coach> list=coachService.getAllCoaches();
		
		return new ResponseEntity<List<Coach>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/booking/{coachId}")
	public ResponseEntity<?> getBooking(@PathVariable("coachId") Integer coachId){
		
		List<Booking> booking=null;
		
		try {
			booking=coachService.getBookingByCoachId(coachId);
		}
		catch(Exception ex)
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}		
		
		return new ResponseEntity<List<Booking>>(booking,new HttpHeaders(),HttpStatus.OK);
	}

}
