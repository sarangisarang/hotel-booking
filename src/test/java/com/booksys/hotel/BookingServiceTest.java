package com.booksys.hotel;
import com.booksys.booking.Booking;
import com.booksys.booking.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Set;

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @Test
    public void givenCheckinCheckoutWithOverlap(){
        // data.sql: existing booking between '2024-03-02','2024-03-13' in H2
        LocalDate checkin = LocalDate.of(2024, 3, 1);
        LocalDate checkout = LocalDate.of(2024, 3, 14);

        Set<Booking> allBookingsOverlap = bookingService.findAllBookingsOverlap(checkin, checkout);
        Assertions.assertFalse(allBookingsOverlap.isEmpty());
    }
    @Test
    public void givenCheckinCheckoutWithoutOverlap(){
        // data.sql: existing booking between '2024-03-02','2024-03-13' in H2
        LocalDate checkin = LocalDate.of(2024, 2, 1);
        LocalDate checkout = LocalDate.of(2024, 2, 14);

        Set<Booking> allBookingsOverlap = bookingService.findAllBookingsOverlap(checkin, checkout);
        Assertions.assertTrue(allBookingsOverlap.isEmpty());
    }
    
}
