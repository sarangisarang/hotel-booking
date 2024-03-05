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
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.OK);
    }


    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable String id) {
        return new ResponseEntity<>(hotelService.findHotelById(id), HttpStatus.OK);
    }

    @GetMapping("/hotel/{name}")
    public ResponseEntity<List<Hotel>> findHotelName(@PathVariable String name) {
        return new  ResponseEntity<>(hotelService.findHotelByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable String id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




    //@DeleteMapping("/hotels/{Id}")
    //public ResponseEntity<Hotel> deleteHotel(@PathVariable String Id){
    //  return new ResponseEntity<>(hotelService.deleteHotel(Id), HttpStatus.OK);

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

