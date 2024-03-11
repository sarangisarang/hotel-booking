package com.booksys.booking;

import java.util.UUID;

public interface BookingService {
    Booking save(Booking booking);
    Booking findBookingById(UUID id);
}
