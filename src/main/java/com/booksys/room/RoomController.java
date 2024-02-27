package com.booksys.room;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booksys/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/save")
    public ResponseEntity<Room> save(@RequestBody Room room){
        return new ResponseEntity<>(roomService.save(room),HttpStatus.OK);
    }

//    @GetMapping("/room")
//    //??
//    public ResponseEntity<Room> Room(@RequestBody Room room){
//        return new ResponseEntity<>(roomService.findRoomByName(???,HttpStatus.OK);
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Room> deleteRoom(@PathVariable String id){
//        return new ResponseEntity<>(roomService.deleteRoom(id));
//    }
}
