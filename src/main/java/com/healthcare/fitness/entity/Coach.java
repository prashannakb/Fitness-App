package com.healthcare.fitness.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Table(name="coach_table")
public class Coach {
	
	@Id
	@Column(name="coach_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer coachId;
	
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private String gender;
	@Column(name="date_of_birth")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@Column(name="password")
	private String password;
	@Column(name="mobile_number")
	private Long mobileNumber;
	@Column(name="speciality")
	private String speciality;
	

}
