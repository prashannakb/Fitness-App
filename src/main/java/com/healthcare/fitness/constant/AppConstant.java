package com.healthcare.fitness.constant;

public enum AppConstant {
	
	COACH_NOT_FOUND("coach.not.found"),
	COACH_DATA_INVALID("coach.data.invalid"),
	BOOKING_ID_NOTFOIND("booking.id.notfound"),
	BOOKING_SLOT_ALREADYBOOKED("booking.slot.alreadybooked"),
	USER_DATA_INVALID("user.data.invalid"),
	USER_ID_NOTFOUND("user.id.notfound");
	
	
	private final String type;

	private AppConstant(String type) {
		this.type = type;
	}
	
	
	
	@Override
	public String toString() {
	return this.type;
	}
	

}
