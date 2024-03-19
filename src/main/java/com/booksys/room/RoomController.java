package com.booksys.room;
import com.booksys.hotel.Hotel;
import com.booksys.hotel.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/save") //ok
    public ResponseEntity<Room> save(@RequestBody Room room){
        return new ResponseEntity<>(roomService.save(room),HttpStatus.OK);
    }

    @GetMapping("/{id}") //ok
    public ResponseEntity<Room> findRoomById(@PathVariable UUID id){
        return new ResponseEntity<>((Room) roomService.findRoomById(id),HttpStatus.OK);
    }

    @GetMapping("/all") //ok
    public ResponseEntity<List<Room>> findAllRoom(){
        return new ResponseEntity<>(roomService.findAllByRoom(),HttpStatus.OK);
    }

    @GetMapping("/{hotelID}/available/between/{in}/and/{out}") //need to talk about this.
    public ResponseEntity<Set<Room>> findAvailableRooms(@PathVariable String hotelID, @PathVariable LocalDate in, @PathVariable LocalDate out){
        Hotel hotel = hotelRepository.findById(UUID.fromString(hotelID)).orElseThrow(() -> new RuntimeException("Hotel not found"));
        return new ResponseEntity<>(roomService.findAvailableRooms(hotel, in, out),HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //ok
    public ResponseEntity<Room> deleteRoomById(@PathVariable UUID id){
        roomService.deleteRoom(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
