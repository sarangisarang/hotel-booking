package com.booksys.guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/guest")
public class GuestController{

    @Autowired
    private GuestService guestService;

    @PostMapping("/save") //ok
    public ResponseEntity<Guest>save(@RequestBody Guest guest){
        return new ResponseEntity<>(guestService.save(guest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //ok
    public ResponseEntity<Guest>deleteGuest(@PathVariable UUID id){
        guestService.deleteGuest(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}") //ok
    public ResponseEntity<Guest>findByid(@PathVariable UUID id){
        return new ResponseEntity<>(guestService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/guests/{firstName}") //ok
    public ResponseEntity<List<Guest>>findByname(@PathVariable String firstName){
        return new ResponseEntity<>(guestService.findByFirstName(firstName),HttpStatus.OK);
    }

    @GetMapping("/all") //ok
    public ResponseEntity<List<Guest>> findAll(){
        return new ResponseEntity<>(guestService.findAll(), HttpStatus.OK);
    }
}
