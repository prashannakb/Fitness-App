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

import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.entity.dto.CoachDTO;
import com.healthcare.fitness.entity.dto.Login;
import com.healthcare.fitness.exception.CoachNotFoundException;
import com.healthcare.fitness.service.CoachService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/coach")
public class CoachResource {
	
	@Autowired
	private CoachService coachService;
	
	@Autowired
	private ModelMapper mapper;
	@PostMapping("/create")
	public ResponseEntity<Integer> createCoach(@Valid @RequestBody Coach coach){
		Integer id=null;
		CoachDTO coach1=mapper.map(coach, CoachDTO.class);
		
			id=coachService.createCoach(coach1);
		
		
		return new ResponseEntity<Integer>(id,new HttpHeaders(),HttpStatus.CREATED);
	}
	@PostMapping(value="/create",params="v=2")
	public ResponseEntity<Integer> createCoachv2(@Valid @RequestBody CoachDTO coach){
		Integer id=null;
//		CoachDTO coach1=mapper.map(coach, CoachDTO.class);
		
			id=coachService.createCoach(coach);
		
		
		return new ResponseEntity<Integer>(id,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?>coachLogin(@Valid @RequestBody Login login)throws CoachNotFoundException
	{
		
		Boolean log=false;
//		try {
			log=coachService.loginCoach(login);
//		}
//		catch(Exception ex)
//		{
//			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//		}
		return new ResponseEntity<Boolean>(log,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{coachId}")
	public ResponseEntity<Coach> getCoachById(@PathVariable("coachId") Integer coachId )throws CoachNotFoundException
	{
//		System.out.println("get coach "+coachId);
		CoachDTO coach=null;
//		try {
			coach=coachService.getCoachById(coachId);
//		}
//		catch(Exception ex)
//		{
//			return  ResponseEntity.notFound().build();
//		}
		return new ResponseEntity<Coach>(mapper.map(coach, Coach.class),new HttpHeaders(),HttpStatus.FOUND);
	}
	@GetMapping(value="/{coachId}",params="v=2")
	public ResponseEntity<CoachDTO> getCoachByIdv2(@PathVariable("coachId") Integer coachId )throws CoachNotFoundException
	{
		System.out.println("get coach "+coachId);
		CoachDTO coach=null;
//		try {
			coach=coachService.getCoachById(coachId);
//		}
//		catch(Exception ex)
//		{
//			return  ResponseEntity.notFound().build();
//		}
		return new ResponseEntity<CoachDTO>(coach,new HttpHeaders(),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CoachDTO>>getAllCoach(){
		List<CoachDTO> list=coachService.getAllCoaches();
		
		return new ResponseEntity<List<CoachDTO>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/booking/{coachId}")
	public ResponseEntity<?> getBooking(@PathVariable("coachId") Integer coachId)throws CoachNotFoundException{
		
		List<BookingDTO> booking=null;
		
//		try {
			booking=coachService.getBookingByCoachId(coachId);
//		}
//		catch(Exception ex)
//		{
//			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//		}		
		
		return new ResponseEntity<List<BookingDTO>>(booking,new HttpHeaders(),HttpStatus.OK);
	}

}
