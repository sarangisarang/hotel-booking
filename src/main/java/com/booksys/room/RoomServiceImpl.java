package com.booksys.room;
import com.booksys.booking.Booking;
import com.booksys.booking.BookingService;
import com.booksys.hotel.Hotel;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;
    private final BookingService bookingService;

    public RoomServiceImpl(RoomRepository roomRepository, BookingService bookingService){
        this.roomRepository = roomRepository;
        this.bookingService = bookingService;
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(UUID roomId) {
        Room hotelRoom = (Room) roomRepository.findAllByroomID(roomId).orElseThrow();
        roomRepository.delete(hotelRoom);
    }

    @Override
    public Room findRoomById(UUID roomId) {
        Room roomIdResponse = (Room) roomRepository.findAllByroomID(roomId).orElseThrow();
        return roomIdResponse;
    }

    @Override
    public List<Room> findAllByRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Set<Room> findAvailableRooms(Hotel hotel, LocalDate checkin, LocalDate checkout) {
        Set<Room> bookedRooms = bookingService.findAllBookingsBetween(checkin, checkout).stream().map(b -> b.getRoom()).collect(Collectors.toSet());
        Set<Room> availableRooms = roomRepository.findAllByHotel(hotel).stream().filter(room -> !bookedRooms.contains(room)).collect(Collectors.toSet());
        return availableRooms;
    }

    @Override
    public List<Room> statusChangeByPosicion(UUID id) {
        Booking booking = (Booking) bookingService.findAll();
        Room roomUpdateStatus = (Room) roomRepository.findAllByroomID(id).orElseThrow();
        LocalDate localDate = LocalDate.now();
        if((booking.getRoom() == findRoomById(id))){
            roomUpdateStatus.setRoomStatus(RoomStatus.reserved);
            return Collections.singletonList(roomRepository.save(roomUpdateStatus));
        }
        return null;
    }
}
