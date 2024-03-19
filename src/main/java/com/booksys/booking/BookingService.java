package com.booksys.booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface BookingService {
    Booking save(Booking booking);
    Booking findBookingById(UUID id);
    void deleteBooking(UUID id);
    List<Booking> findAll();

    Set<Booking> findAllBookingsBetween(LocalDate checkin, LocalDate checkout);
    Set<Booking> findAllBookingsOverlap(LocalDate checkin, LocalDate checkout);
}
