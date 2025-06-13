package com.booksys.booking;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * BookingServiceImpl provides the concrete implementation of BookingService.
 * It handles all booking-related business logic and interacts with the repository layer.
 */
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    /**
     * Constructor for injecting the BookingRepository dependency.
     *
     * @param bookingRepository repository for booking data access.
     */
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Saves a booking object to the database.
     *
     * @param booking Booking object to save.
     * @return the saved booking.
     */
    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Deletes a booking by its UUID.
     *
     * @param id UUID of the booking to delete.
     */
    @Override
    public void deleteBooking(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
        bookingRepository.delete(booking);
    }

    /**
     * Finds a booking by its UUID.
     *
     * @param id UUID of the booking.
     * @return the found booking.
     */
    @Override
    public Booking findById(UUID id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    /**
     * Retrieves all bookings associated with a specific guest ID.
     *
     * @param guestId UUID of the guest.
     * @return list of bookings for that guest.
     */
    @Override
    public List<Booking> findByGuestId(UUID guestId) {
        return bookingRepository.findByGuestId(guestId);
    }

    /**
     * Retrieves all bookings from the database.
     *
     * @return list of all bookings.
     */
    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
