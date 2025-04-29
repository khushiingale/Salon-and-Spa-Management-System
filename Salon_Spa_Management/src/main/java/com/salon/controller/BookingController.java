package com.salon.controller;
import com.salon.service.UserService;
import com.salon.entity.Booking;
import com.salon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/{serviceId}")
    public ResponseEntity<Booking> bookService(@PathVariable Long userId, @PathVariable Long serviceId,
                                               @RequestParam String date, @RequestParam String time) {
        Booking booking = userService.bookService(userId, serviceId, date, time);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserBookings(userId));
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateBooking(@PathVariable Long bookingId, @RequestParam String date, @RequestParam String time) {
        Booking updatedBooking = userService.updateBooking(bookingId, date, time);
        if (updatedBooking != null) {
            return ResponseEntity.ok("Booking updated successfully!");
        }
        return ResponseEntity.badRequest().body("Failed to update booking");
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId) {
        userService.cancelBooking(bookingId);
        return ResponseEntity.ok("Booking canceled successfully!");
    }
}
