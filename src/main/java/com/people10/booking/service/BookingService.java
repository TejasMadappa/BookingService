package com.people10.booking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.people10.booking.exception.BookingDatesNotValidException;
import com.people10.booking.exception.RoomNotAvailableException;
import com.people10.booking.model.BookingCriteria;
import com.people10.booking.model.BookingResult;
import com.people10.booking.repo.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public BookingResult performBooking(BookingCriteria criteria) {

		if (criteria.getRerservationEndDateTime().isBefore(criteria.getRerservationStartDateTime())) {
			throw new BookingDatesNotValidException("End date is before start date");
		}

		if (!(roomAvailableForBooking(criteria.getRoomId(), criteria.getRerservationStartDateTime()))) {
			throw new RoomNotAvailableException("Room is already booked");
		}

		BookingResult bookingResult = new BookingResult();
		bookingResult.setCustomerId(criteria.getCustomerId());
		bookingResult.setRoomId(criteria.getRoomId());
		bookingResult.setRerservationStartDateTime(criteria.getRerservationStartDateTime());
		bookingResult.setRerservationEndDateTime(criteria.getRerservationEndDateTime());

		BookingResult newBookingResult = null;
		try {
			newBookingResult = bookingRepository.save(bookingResult);
		} catch (Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				throw new DataIntegrityViolationException("customer/room id is not valid");
			}
		}

		return newBookingResult;
	}

	public List<BookingResult> getAllBookings() {
		return bookingRepository.findAll();
	}

	public List<BookingResult> getBookingsByCustomerId(Long customerId) {
		return bookingRepository.getBookingsByCustomerId(customerId);
	}

	private boolean roomAvailableForBooking(Long roomId, LocalDateTime reservationStartDateTime) {
		// verify booking by validating the date and time.
		List<BookingResult> bookingResults = bookingRepository.getBookingsByRoomId(roomId);

		if (bookingResults.isEmpty()) {
			return true;
		}

		for (BookingResult booking : bookingResults) {
			if (reservationStartDateTime.isAfter(booking.getRerservationEndDateTime())) {
				return true;
			}
		}

		return false;
	}

}
