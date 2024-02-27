package com.booksys.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booksys/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}
