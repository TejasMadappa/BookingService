package com.people10.booking.service;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.people10.booking.repo.BookingRepository;

public class BookingServiceTest {

	private BookingRepository bookingRepository = mock(BookingRepository.class);
	private BookingService bookingService = new BookingService();

	@Test
	public void testperformBooking_ValidRequest() {
		// validates booking success
	}

	@Test
	public void testperformBooking_InvalidCustomerId() {
		// need to validate that it throws exception.
	}

	@Test
	public void testperformBooking_InvalidRoomId() {
		// need to validate that it throws exception.
	}

	@Test
	public void testperformBooking_bookingConflict() {
		// need to validate that it throws exception.
	}
}
