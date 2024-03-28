package com.booksys.booking;

import com.booksys.room.Room;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface BookingService {
    Booking save(Booking booking);

    /**
     * Create booking with given Room,checkin and checkout.
     * but first validate that the room is available in this period
     *
     * @param room
     * @param checkin
     * @param checkout
     * @return booking
     */
    Booking save(UUID room, LocalDate checkin, LocalDate checkout);
    Booking findBookingById(UUID id);
    void deleteBooking(UUID id);
    List<Booking> findAll();
    Set<Booking> findAllBookingsBetween(LocalDate checkin, LocalDate checkout);
    Set<Booking> findAllBookingsOverlap(LocalDate checkin, LocalDate checkout);
    Set<Booking> findAllBookingsOverlap(UUID room,LocalDate checkin, LocalDate checkout);
    Set<Booking> findAllBookingsOverlap(Room room, LocalDate checkIn, LocalDate checkOut);

    Booking save(UUID roomId, Booking newBooking) throws ParseException;
}
