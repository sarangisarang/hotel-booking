package com.booksys.booking;

import java.util.List;
import java.util.UUID;

/**
 * BookingService defines the business logic operations related to bookings.
 */
public interface BookingService {

    /**
     * Save a new booking.
     *
     * @param booking Booking object to be saved.
     * @return the saved booking.
     */
    Booking save(Booking booking);

    /**
     * Delete a booking by ID.
     *
     * @param id UUID of the booking to delete.
     */
    void deleteBooking(UUID id);

    /**
     * Find a booking by its ID.
     *
     * @param id UUID of the booking.
     * @return the booking object if found.
     */
    Booking findById(UUID id);

    /**
     * Find all bookings by a specific guest.
     *
     * @param guestId UUID of the guest.
     * @return list of bookings.
     */
    List<Booking> findByGuestId(UUID guestId);

    /**
     * Find all bookings.
     *
     * @return list of all bookings.
     */
    List<Booking> findAll();
}
