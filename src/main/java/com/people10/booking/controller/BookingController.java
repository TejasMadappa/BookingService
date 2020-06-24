package com.people10.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.people10.booking.exception.BookingDatesNotValidException;
import com.people10.booking.exception.RoomNotAvailableException;
import com.people10.booking.model.BookingCriteria;
import com.people10.booking.model.BookingResult;
import com.people10.booking.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/bookings")
	public BookingResult createBooking(@RequestBody BookingCriteria criteria) {

		BookingResult bookingResult = null;
		try {

			bookingResult = bookingService.performBooking(criteria);

		} catch (BookingDatesNotValidException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation end date is before start date");

		} catch (RoomNotAvailableException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The slot is already booked");

		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room/customer id is not valid");
		}

		return bookingResult;
	}

	@GetMapping("/bookings")
	public List<BookingResult> getAllBookings() {
		return bookingService.getAllBookings();
	}

	@GetMapping("/bookings/{customerId}")
	public List<BookingResult> getBookingsByCustomerId(@RequestParam Long customerId) {
		return bookingService.getBookingsByCustomerId(customerId);
	}
}
