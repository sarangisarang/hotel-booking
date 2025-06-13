package com.booksys.booking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * BookingController handles all incoming HTTP requests related to bookings.
 * It provides endpoints to create, retrieve, and delete bookings.
 */
@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService bookingService;

    /**
     * Constructor-based injection of BookingService.
     *
     * @param bookingService service layer for booking operations.
     */
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * GET /api/bookings
     * Retrieves a list of all bookings.
     *
     * @return list of all bookings.
     */
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }

    /**
     * GET /api/bookings/{id}
     * Retrieves a booking by its unique ID.
     *
     * @param id UUID of the booking.
     * @return the booking if found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable UUID id) {
        Booking booking = bookingService.findById(id);
        return ResponseEntity.ok(booking);
    }

    /**
     * GET /api/bookings/guest/{guestId}
     * Retrieves bookings associated with a specific guest ID.
     *
     * @param guestId UUID of the guest.
     * @return list of bookings for the guest.
     */
    @GetMapping("/guest/{guestId}")
    public List<Booking> getBookingsByGuestId(@PathVariable UUID guestId) {
        return bookingService.findByGuestId(guestId);
    }

    /**
     * POST /api/bookings
     * Creates a new booking record.
     *
     * @param booking Booking object from request body.
     * @return the created booking.
     */
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking created = bookingService.save(booking);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * DELETE /api/bookings/{id}
     * Deletes a booking by its ID.
     *
     * @param id UUID of the booking.
     * @return 204 No Content status if successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable UUID id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}