package com.booksys.booking;

import java.util.List;
import java.util.UUID;

/**
 * BookingService defines booking business operations using DTOs.
 */
public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(UUID bookingId, BookingDTO bookingDTO);

    BookingDTO getBookingById(UUID bookingId);

    List<BookingDTO> getAllBookings();

    void deleteBooking(UUID bookingId);
}