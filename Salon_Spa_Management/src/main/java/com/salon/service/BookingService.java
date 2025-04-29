package com.salon.service;


import com.salon.entity.Booking;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long id);
    Booking createBooking(Booking booking);
    void deleteBooking(Long id);
	Optional<Booking> updateBooking(Long id, Booking booking);
	Booking bookService(Long userId, Long serviceId, String date, String time);
	List<Booking> getUserBookings(Long userId); 
	void cancelBooking(Long bookingId);  
}
