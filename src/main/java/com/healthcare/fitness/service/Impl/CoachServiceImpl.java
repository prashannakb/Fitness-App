package com.healthcare.fitness.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.fitness.dto.Login;
import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.repository.Bookingrepository;
import com.healthcare.fitness.repository.CoachRepository;
import com.healthcare.fitness.service.CoachService;

//import jakarta.transaction.Transactional;
@Service
@Transactional
public class CoachServiceImpl implements CoachService {
	
	@Autowired
	private CoachRepository coachRepository;
	@Autowired
	private Bookingrepository bookingrepository;

	@Override
	public Integer createCoach(Coach coach) {
		// TODO Auto-generated method stub
		Coach newCoach=coachRepository.save(coach);
		return newCoach.getCoachId();
	}

	@Override
	public Boolean loginCoach(Login login) throws Exception {
		// TODO Auto-generated method stub
		Coach coach=coachRepository.findById(login.getId()).orElseThrow(()->new Exception("Coach Not Found"));
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
			throw new Exception("Coach Name Is wrong");
		}
	}

	@Override
	public Coach getCoachById(Integer coachId) throws Exception {
		// TODO Auto-generated method stub
		Coach coach=coachRepository.findById(coachId).orElseThrow(()->new Exception("Coach Not Found"));
		return coach;
	}

	@Override
	public List<Coach> getAllCoaches() {
		// TODO Auto-generated method stub
		List<Coach> coachList=coachRepository.findAll();
		return coachList;
	}

	@Override
	public List<Booking> getBookingByCoachId(Integer coachId) throws Exception {
		// TODO Auto-generated method stub
		Coach coach=coachRepository.findById(coachId).orElseThrow(()->new Exception("Coach Not Found"));
		List<Booking> booking=bookingrepository.findByCoach(coach);
		return booking;
	}

}
