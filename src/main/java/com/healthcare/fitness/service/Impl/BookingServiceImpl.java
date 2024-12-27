package com.healthcare.fitness.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.fitness.entity.Booking;
import com.healthcare.fitness.entity.Coach;
import com.healthcare.fitness.entity.User;
import com.healthcare.fitness.entity.dto.BookingDTO;
import com.healthcare.fitness.repository.Bookingrepository;
import com.healthcare.fitness.repository.CoachRepository;
import com.healthcare.fitness.repository.UserRepository;
import com.healthcare.fitness.service.BookingService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private Bookingrepository bookingrepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CoachRepository coachRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean appointmentBooking(Integer coachId, Integer userId,BookingDTO book) throws Exception {
		// TODO Auto-generated method stub
		Coach coach=coachRepository.findById(coachId).orElseThrow(()->new Exception("Coach Not Found"));
		User user=userRepository.findById(userId).orElseThrow(()->new Exception("User Not Found"));
		List<Booking> book1=bookingrepository.findByCoachAndAppointmentAndSlot(coach,book.getAppointment(), book.getSlot());
		System.out.println(book1);
		if(book1.size()!=0) {
			throw new Exception("Slot is already booked");
		}
		
		book.setCoach(coach);
		book.setUser(user);
		Booking booking=mapper.map(book, Booking.class);
		Booking newBooking=bookingrepository.save(booking);
		if(null==newBooking.getBookingId()) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean rescheduleBooking(Integer bookingId,BookingDTO book)throws Exception {
		// TODO Auto-generated method stub
		Booking book1=bookingrepository.findById(bookingId).orElseThrow(()-> new Exception("Booking Not Found"));
		List<Booking> booklist=bookingrepository.findByCoachAndAppointmentAndSlot(book1.getCoach(),book.getAppointment(), book.getSlot());

		if(booklist.size()!=0) {
			
			throw new Exception("Slot is already booked");
		}
		book1.setAppointment(book.getAppointment());
		book1.setSlot(book.getSlot());
		Booking booking=mapper.map(book, Booking.class);
		Booking newBooking=bookingrepository.save(booking);
		if(null==newBooking.getBookingId()) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean cancelBooking(Integer bookingId)throws Exception {
		// TODO Auto-generated method stub
		Booking book1=bookingrepository.findById(bookingId).orElseThrow(()-> new Exception("Booking Not Found"));
		bookingrepository.deleteById(book1.getBookingId());
		return true;
	}
	
	

}
