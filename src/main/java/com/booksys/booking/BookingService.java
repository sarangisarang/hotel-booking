package com.booksys.booking;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    Booking save(Booking booking);
    Booking findBookingById(UUID id);
    void deleteBooking(UUID id);
    List<Booking> findAll();
}
