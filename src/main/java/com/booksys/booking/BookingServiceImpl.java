package com.booksys.booking;
import com.booksys.room.Room;
import com.booksys.room.RoomRepository;
import com.booksys.room.RoomStatus;
import com.sun.source.tree.ContinueTree;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
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
    @Transactional
    public Booking save(UUID roomId, Booking newBooking) throws ParseException {
        // attribute validation
        Objects.requireNonNull(roomId);
        Objects.requireNonNull(newBooking);
        Objects.requireNonNull(newBooking.getCheckIn());
        Objects.requireNonNull(newBooking.getCheckOut());
        // newBooking should not have defined bookingID attribute
        if(newBooking.getBookingID() != null){
            throw new RuntimeException("newBooking should not have defined bookingID attribute");
        }
        // check if room exists
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found by id: " + roomId));
        // now check if this room is available on given checkin checkout dates
        Set<Booking> existingBookings = findAllBookingsOverlap(room, newBooking.getCheckIn(), newBooking.getCheckOut());
        if(existingBookings != null && !existingBookings.isEmpty()){
            throw new RuntimeException(String.format("The given room is not available between dates %s - %s", newBooking.getCheckIn(), newBooking.getCheckOut()));
        }
        // now new Booking can be persisted in database
        newBooking.setRoom(room);
        // calculate difference between checkin and checkout in days
        BigDecimal differenceDays = BigDecimal.valueOf(newBooking.getCheckIn().until(newBooking.getCheckOut(), ChronoUnit.DAYS));
        if(differenceDays.compareTo(BigDecimal.ONE) == -1){
            throw new RuntimeException("Booking could at leas one day");
        }
        // register today is before checkin change status
        String date1 = String.valueOf(LocalDate.now());
        String date2 = String.valueOf(newBooking.getCheckIn());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dateValue = formato.parse(date1);
        Date dateValue2 = formato.parse(date2);
        if(dateValue.before(dateValue2)){
            room.setRoomStatus(RoomStatus.reserved);
        } else if (dateValue.after(dateValue2)) {
            room.setRoomStatus(RoomStatus.occupaid);
        } else if (dateValue2.before(dateValue)) {
            new RuntimeException("Can not time is behind reserve");
        }
        newBooking.setTotalPrice(room.getRoomType().getPricePerNight().multiply(differenceDays));
        return bookingRepository.save(newBooking);
    }

    @Override
    public Set<Booking> findAllBookingsOverlap(Room room, LocalDate checkIn, LocalDate checkOut) {
        return bookingRepository.findAllByRoom(room).stream().filter(booking -> isOverlapUsingLocalDateAndDuration(booking.getCheckIn(), booking.getCheckOut(), checkIn, checkOut)).collect(Collectors.toSet());
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
