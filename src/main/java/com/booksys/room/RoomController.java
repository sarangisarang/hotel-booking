package com.booksys.room;
import com.booksys.hotel.Hotel;
import com.booksys.hotel.HotelService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Room> save(@RequestBody Room room){
        return new ResponseEntity<>(roomService.save(room),HttpStatus.OK);
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> findRoomById(@PathVariable UUID id){
        return new ResponseEntity<>((Room) roomService.findRoomById(id),HttpStatus.OK);
    }

    @GetMapping("/allbyhotel/{id}")
    public ResponseEntity<Set<Room>> findRoomsByHotel(@PathVariable UUID id){
        Hotel hotel = hotelService.findHotelById(id);
        return new ResponseEntity<>(roomService.findAllByHotel(hotel),HttpStatus.OK);
    }

    @DeleteMapping("/room/{id}")
    public ResponseEntity<Room> deleteRoomById(@PathVariable UUID id){
        roomService.deleteRoom(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
