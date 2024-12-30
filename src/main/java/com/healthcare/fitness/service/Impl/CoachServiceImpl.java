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
import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.entity.dto.CoachDTO;
import com.healthcare.fitness.entity.dto.Login;
import com.healthcare.fitness.exception.CoachNotFoundException;
import com.healthcare.fitness.repository.Bookingrepository;
import com.healthcare.fitness.repository.CoachRepository;
import com.healthcare.fitness.service.CoachService;

//import jakarta.transaction.Transactional;
@Service
@Transactional
@PropertySource("classpath:validation.properties")
public class CoachServiceImpl implements CoachService {
	
	@Autowired
	private CoachRepository coachRepository;
	@Autowired
	private Bookingrepository bookingrepository;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Environment env;

	@Override
	public Integer createCoach(CoachDTO coach) {
		// TODO Auto-generated method stub
		
		Coach newCoach=coachRepository.save(mapper.map(coach, Coach.class));
		return newCoach.getCoachId();
	}

	@Override
	public Boolean loginCoach(Login login) throws CoachNotFoundException {
		// TODO Auto-generated method stub
		Coach coach=coachRepository.findById(login.getId()).orElseThrow(()->new CoachNotFoundException(env.getProperty(AppConstant.COACH_NOT_FOUND.toString())));
		if(null==coach) {
		return null;
		}
		if(null!=login.getName() && login.getName().equalsIgnoreCase(coach.getName())) {
			if(null!=login.getPassword() && login.getPassword().equals(coach.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			throw new CoachNotFoundException(env.getProperty(AppConstant.COACH_DATA_INVALID.toString()));
		}
	}

	@Override
	public CoachDTO getCoachById(Integer coachId) throws CoachNotFoundException {
		// TODO Auto-generated method stub
		Coach coach1=coachRepository.findById(coachId).orElseThrow(()->new CoachNotFoundException(env.getProperty(AppConstant.COACH_NOT_FOUND.toString())));
		CoachDTO coach=mapper.map(coach1, CoachDTO.class);
		return coach;
	}

	@Override
	public List<CoachDTO> getAllCoaches() {
		// TODO Auto-generated method stub
		List<Coach> coachList=coachRepository.findAll();
		List<CoachDTO> coach=new ArrayList<>();
		for(Coach c:coachList) {
			CoachDTO dto=mapper.map(c,CoachDTO.class);
			coach.add(dto);
		}
		return coach;
	}

	@Override
	public List<BookingDTO> getBookingByCoachId(Integer coachId) throws CoachNotFoundException {
		// TODO Auto-generated method stub
		Coach coach=coachRepository.findById(coachId).orElseThrow(()->new CoachNotFoundException(env.getProperty(AppConstant.COACH_NOT_FOUND.toString())));
		List<Booking> booking=bookingrepository.findByCoach(coach);
		List<BookingDTO> DTOlist=new ArrayList<>();
		for(Booking book:booking) {
			BookingDTO dto=mapper.map(book, BookingDTO.class);
			DTOlist.add(dto);
		}
		return DTOlist;
	}

}
