package com.booksys.room;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findRoomByName(String name) {
        return null;
    }

    @Override
    public void deleteRoom(String roomId) {
        Room hotelRoom = roomRepository.findById(roomId).orElseThrow();
        roomRepository.delete(hotelRoom);
    }

    @Override
    public Room findRoomById(String roomId) {
        return roomRepository.findById(roomId).orElseThrow();
    }
}
