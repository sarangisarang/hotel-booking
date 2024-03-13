package com.booksys.room;
import com.booksys.hotel.Hotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoomService {
    Room save(Room room);
    void deleteRoom(UUID roomId);
    Object findRoomById(UUID roomId);
    List<Room> findAllByRoom();
    Set<Room> findAvailableRooms(Hotel hotel, LocalDate checkin, LocalDate checkout);
}
