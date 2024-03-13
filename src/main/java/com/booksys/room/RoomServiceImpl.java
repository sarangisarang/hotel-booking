package com.booksys.room;
import com.booksys.hotel.Hotel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
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
        return null;
    }
}
