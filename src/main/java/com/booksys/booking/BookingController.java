package com.booksys.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/booksys/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/save")
    public ResponseEntity<Booking> save(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.save(booking), HttpStatus.OK);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<Booking>findBookingId(@PathVariable UUID id){
        return new ResponseEntity<>(bookingService.findBookingById(id),HttpStatus.OK);
    }
    @DeleteMapping("/booking/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable UUID id){

    }
}
