package com.booksys.booking;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking save(Booking booking){
        return bookingRepository.save(booking);
    }
    @Override
    public Booking findBookingById(UUID uuid){
        return (Booking) bookingRepository.findBybookingID(uuid).orElseThrow();
    }
    @Override
    public void deleteBooking(UUID id){
        Booking bookingId = (Booking) bookingRepository.findBybookingID(id).orElseThrow();
        bookingRepository.delete(bookingId);
    }
    @Override
    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }
}
