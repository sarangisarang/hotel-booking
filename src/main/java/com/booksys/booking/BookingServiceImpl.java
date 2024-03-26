package com.booksys.booking;
import com.booksys.room.Room;
import com.booksys.room.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;

    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public Booking save(UUID room, LocalDate checkin, LocalDate checkout) {
        //validacion
        Set<Booking> rooms = findAllBookingsOverlap(room, checkin, checkout);
        if (rooms != null && !rooms.isEmpty()){
           throw new RuntimeException("This room not avaible");
        }
        Room newRoom = (Room) roomRepository.findAllByroomID(room).orElseThrow();
        Booking booking = new Booking();
        booking.setRoom(newRoom);
        booking.setCheckIn(checkin);
        booking.setCheckOut(checkout);
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
    @Override
    public Set<Booking> findAllBookingsBetween(LocalDate checkin, LocalDate checkout) {
            return bookingRepository.findByCheckInBetween(checkin, checkout);
    }
    @Override
    public Set<Booking> findAllBookingsOverlap(LocalDate checkin, LocalDate checkout) {
        return bookingRepository.findAll().stream().filter(booking -> isOverlapUsingLocalDateAndDuration(checkin, checkout, booking.getCheckIn(), booking.getCheckOut())).collect(Collectors.toSet());
    }

    @Override
    public Set<Booking> findAllBookingsOverlap(UUID room, LocalDate checkin, LocalDate checkout) {
        return bookingRepository.findAllByRoomRoomID(room).stream().filter(booking -> isOverlapUsingLocalDateAndDuration(checkin, checkout, booking.getCheckIn(), booking.getCheckOut())).collect(Collectors.toSet());
    }


    /**
     * method from https://www.baeldung.com/java-check-two-date-ranges-overlap
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */

    private boolean isOverlapUsingLocalDateAndDuration(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        long overlap = Math.min(end1.toEpochDay(), end2.toEpochDay()) -
                Math.max(start1.toEpochDay(), start2.toEpochDay());

        return overlap >= 0;
    }
}
