package com.booksys.booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/save")  //ok
    public ResponseEntity<Booking> save(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.save(booking), HttpStatus.OK);
    }
    @GetMapping("bookings/{id}") //ok
    public ResponseEntity<Booking>findBookingId(@PathVariable UUID id){
        return new ResponseEntity<>(bookingService.findBookingById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}") //ok
    public ResponseEntity<Booking> deleteBookingById(@PathVariable UUID id){
        bookingService.deleteBooking(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
   @GetMapping("/all") //ok
   public ResponseEntity<List<Booking>> showAll(){
       return new ResponseEntity<>(bookingService.findAll(),HttpStatus.OK);
   }
   @GetMapping("/between/{in}/and/{out}") //ok
   public ResponseEntity<Set<Booking>> allBetween(@PathVariable LocalDate in, @PathVariable LocalDate out){
       return new ResponseEntity<>(bookingService.findAllBookingsBetween(in, out),HttpStatus.OK);
   }
   @GetMapping("/overlap/{in}/and/{out}") //ok
   public ResponseEntity<Set<Booking>> allOverlap(@PathVariable LocalDate in,@PathVariable LocalDate out){
        return new ResponseEntity<>(bookingService.findAllBookingsOverlap(in,out),HttpStatus.OK);
   }
}
