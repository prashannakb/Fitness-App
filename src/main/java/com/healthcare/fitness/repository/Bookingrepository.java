package com.healthcare.fitness.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.entity.User;

@Repository
public interface Bookingrepository extends JpaRepository<Booking, Integer> {
	List<Booking> findByCoach(Coach coach);
	List<Booking> findByUser(User user);
	List<Booking> findByCoachAndUserAndAppointmentAndSlot(Coach coach,User user,LocalDate appointment,String slot);
	List<Booking> findByCoachAndAppointmentAndSlot(Coach coach,LocalDate appointment,String slot);
}
