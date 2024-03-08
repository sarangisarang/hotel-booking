package com.booksys.hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.OK);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable UUID id) {
        return new ResponseEntity<>(hotelService.findHotelById(id), HttpStatus.OK);
    }

    @GetMapping("/hotel/{name}")
    public ResponseEntity<List<Hotel>> findHotelName(@PathVariable String name) {
        return new  ResponseEntity<>(hotelService.findHotelByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable UUID id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> findAll(){
        return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
    }
}

