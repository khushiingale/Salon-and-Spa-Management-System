package com.salon.serviceimpl;

import com.salon.entity.User;
import com.salon.entity.Booking;
//import com.salon.entity.Service;
import com.salon.repository.UserRepository;
import com.salon.repository.BookingRepository;
import com.salon.repository.ServiceRepository;
import com.salon.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public UserServiceImpl(UserRepository userRepository, BookingRepository bookingRepository, ServiceRepository serviceRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepository.save(user);
        });
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    user.get().getUsername(),
                    "{noop}" + user.get().getPassword(), // No password encoding
                    new ArrayList<>()
            );
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Booking Service
    public Booking bookService(Long userId, Long serviceId, String date, String time) {
        Optional<User> user = userRepository.findById(userId);
        Optional<com.salon.entity.Service> service = serviceRepository.findById(serviceId);

        if (user.isPresent() && service.isPresent()) {
            Booking booking = new Booking();
            booking.setUser(user.get());
            booking.setService(service.get());
            booking.setDate(date);
            booking.setTime(time);
            return bookingRepository.save(booking);
        }
        return null;
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

	@Override
	public Optional<Booking> updateBooking(Long id, Booking booking) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Booking updateBooking(Long bookingId, String date, String time) {
		// TODO Auto-generated method stub
		return null;
	}
}
