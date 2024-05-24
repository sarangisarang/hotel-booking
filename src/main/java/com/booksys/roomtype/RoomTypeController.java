package com.booksys.roomtype;
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
    public ResponseEntity<List<RoomType>> findByNameRoomType(@PathVariable String name){
        return new ResponseEntity<>(roomTypeService.findByName(name),HttpStatus.OK);
    }
    @GetMapping("/roomtyps/{id}")
    public ResponseEntity<RoomType> findByIdRoomType(@PathVariable UUID id){
        return new ResponseEntity<>(roomTypeService.findById(id),HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<RoomType>>findall(){
        return new ResponseEntity<>(roomTypeService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<RoomType>> deleteByRoomType(@PathVariable UUID id){
        return new ResponseEntity<>(roomTypeService.deleteByid(id),HttpStatus.NO_CONTENT);
    }
}
