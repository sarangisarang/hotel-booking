package com.booksys.roomtype;

import com.booksys.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/roomtype")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping("/save")
    public ResponseEntity<RoomType>save(@RequestBody RoomType roomType){
        roomTypeService.save(roomType);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/roomtype/{name}")
    public ResponseEntity<List<RoomType>> findBayNameRoomType(@PathVariable String name){
        return new ResponseEntity<>(roomTypeService.findbyName(name),HttpStatus.OK);
    }

    @GetMapping("/roomtype/{id}")
    public ResponseEntity<RoomType> findByidRoomType(@PathVariable UUID id){
        return new ResponseEntity<>(roomTypeService.findbyId(id),HttpStatus.OK);
    }

    @DeleteMapping("/roomtype/{id}")
    public ResponseEntity<List<RoomType>> deleteByRoomType(@PathVariable UUID id){
        return new ResponseEntity<>(roomTypeService.deleteByid(id),HttpStatus.NO_CONTENT);
    }
}
