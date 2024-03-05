package com.booksys.hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.OK);
    }

    @GetMapping("/hotels/{name}")
    public ResponseEntity<Hotel> allShow(@PathVariable String name){
        return new ResponseEntity<>((Hotel) hotelService.findHotelByName(name), HttpStatus.OK);
    }
    @DeleteMapping("/hotels/{Id}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable String Id){
        return new ResponseEntity<>((Hotel) hotelService.deleteHotel(Id), HttpStatus.OK);

    //    @GetMapping("/hotels")
//    //???
//    public ResponseEntity<String> findAll(@RequestBody Hotel hotel){
//        return new ResponseEntity<>(hotelService.findHotelByName(hotel.getName());
//    }
//    @GetMapping("/hotelId")
//    //??
//    public  ResponseEntity<String> findForID(@RequestBody Hotel hotel){
//        return new ResponseEntity<>(hotelService.findHotelById(),HttpStatus.OK);
//    }
}

