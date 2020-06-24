package com.people10.booking.model;

import java.time.LocalDateTime;

public class BookingCriteria {
	private Long customerId;
	private Long roomId;
	private LocalDateTime rerservationStartDateTime;
	private LocalDateTime rerservationEndDateTime;

	// instead of getter setters we can use builder pattern. For time being I have
	// used getters and setters.

	public Long getCustomerId() {
		return customerId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public LocalDateTime getRerservationStartDateTime() {
		return rerservationStartDateTime;
	}

	public LocalDateTime getRerservationEndDateTime() {
		return rerservationEndDateTime;
	}

	public void setRerservationStartDateTime(LocalDateTime rerservationStartDateTime) {
		this.rerservationStartDateTime = rerservationStartDateTime;
	}

	public void setRerservationEndDateTime(LocalDateTime rerservationEndDateTime) {
		this.rerservationEndDateTime = rerservationEndDateTime;
	}
}
