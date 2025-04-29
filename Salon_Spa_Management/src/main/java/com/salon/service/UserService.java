package com.salon.service;

import com.salon.entity.Booking;
import com.salon.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    
    List<User> getAllUsers();  // Fetch all users
    
    Optional<User> getUserById(Long id);  // Fetch user by ID
    
    User createUser(User user);  // Create a new user
    
    Optional<User> updateUser(Long id, User updatedUser);  // Update user details
    
    void deleteUser(Long id);  // Delete user by ID
    
    Optional<User> findByUsername(String username); // Fetch user by username

    User registerUser(User user);

    Optional<Booking> updateBooking(Long id, Booking booking);
	Booking bookService(Long userId, Long serviceId, String date, String time);
	List<Booking> getUserBookings(Long userId); 
	void cancelBooking(Long bookingId);

	Booking updateBooking(Long bookingId, String date, String time);  
}
