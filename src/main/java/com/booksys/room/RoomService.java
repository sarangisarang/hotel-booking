package com.booksys.room;
import java.util.List;
import java.util.UUID;

public interface RoomService {
    Room save(Room room);
    void deleteRoom(UUID roomId);
    List<Room> findRoomByName(String name);
    Room findRoomById(UUID roomId);
}
