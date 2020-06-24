package com.people10.booking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people10.booking.model.BookingResult;

public interface BookingRepository extends JpaRepository<BookingResult, Long> {

	List<BookingResult> getBookingsByRoomId(Long roomId);

	List<BookingResult> getBookingsByCustomerId(Long customerId);

}
