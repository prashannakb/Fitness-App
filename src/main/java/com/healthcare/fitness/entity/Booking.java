package com.healthcare.fitness.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Table(name="bookingtable")
public class Booking {
	
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookingId;
	
	@JoinColumn(name="coach_id")
	@OneToOne
	private Coach coach;
	@JoinColumn(name="user_id")
	@OneToOne
	private User user;
	
	@Column(name="appointment_time")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate appointment;
	
	@Column(name="slot")
	private String slot;
	

}
