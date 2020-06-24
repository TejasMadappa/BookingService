package com.people10.booking.exception;

public class BookingDatesNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookingDatesNotValidException(String message) {
		super(message);
	}
}
