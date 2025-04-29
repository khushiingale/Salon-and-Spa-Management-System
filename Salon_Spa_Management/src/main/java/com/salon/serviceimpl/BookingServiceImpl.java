package com.salon.serviceimpl;


import com.salon.entity.Booking;
import com.salon.entity.User;
import com.salon.repository.BookingRepository;
import com.salon.repository.ServiceRepository;
import com.salon.repository.UserRepository;
import com.salon.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Booking bookService(Long userId, Long serviceId, String date, String time) {
        Optional<User> user = userRepository.findById(userId);
        Optional<com.salon.entity.Service> service = serviceRepository.findById(serviceId);

        if (user.isPresent() && service.isPresent()) {
            Booking booking = new Booking();
            booking.setUser(user.get());
            booking.setService(service.get());
            booking.setDate(date);  // Make sure Booking entity has "date" field
            booking.setTime(time);  // Make sure Booking entity has "time" field
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);  // Ensure this method exists in BookingRepository
    }

    @Override
    public Optional<Booking> updateBooking(Long bookingId, Booking updatedBooking) {
        return bookingRepository.findById(bookingId).map(booking -> {
            booking.setDate(updatedBooking.getDate());
            booking.setTime(updatedBooking.getTime());
            return bookingRepository.save(booking);
        });
    }

    @Override
    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Booking> getBookingById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(Long id) {
		// TODO Auto-generated method stub
		
	}
}