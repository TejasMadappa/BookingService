package com.people10.booking.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class BookingResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long bookingId;

	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "room_id")
	private Long roomId;
	@Column(name = "start_date_time")
	private LocalDateTime rerservationStartDateTime;
	@Column(name = "end_date_time")
	private LocalDateTime rerservationEndDateTime;

	public Long getBookingId() {
		return bookingId;
	}

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

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public void setRerservationStartDateTime(LocalDateTime rerservationStartDateTime) {
		this.rerservationStartDateTime = rerservationStartDateTime;
	}

	public void setRerservationEndDateTime(LocalDateTime rerservationEndDateTime) {
		this.rerservationEndDateTime = rerservationEndDateTime;
	}
}
