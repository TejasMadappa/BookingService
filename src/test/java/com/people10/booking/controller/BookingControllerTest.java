package com.people10.booking.controller;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.people10.booking.model.BookingCriteria;
import com.people10.booking.service.BookingService;

//test class for testing booking controller
public class BookingControllerTest {

	private final BookingController bookingController = new BookingController();
	private final BookingService bookingService = mock(BookingService.class);
	private final BookingCriteria bookingCriteria = mock(BookingCriteria.class);

	@BeforeAll
	public void setUp() {
		// set up
	}

	@Test
	public void testAddBooking() {

	}

	@Test
	public void testGetAllBooking() {

	}

}
