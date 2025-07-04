package com.booksys.guest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


//GuestController exposes REST API endpoints for guest CRUD operations,
//using DTOs for consistent, clean data structures with the frontend.
@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

public class GuestController {

 private final GuestService guestService;

 @PostMapping public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
     return ResponseEntity.ok(guestService.createGuest(guest));
 }

 @PutMapping("/{id}") public ResponseEntity<GuestDTO> updateGuest(@PathVariable UUID id, @RequestBody GuestDTO guestDTO) {
     return ResponseEntity.ok(guestService.updateGuest(id, guestDTO));
 }

 @GetMapping("/{id}") public ResponseEntity<GuestDTO> getGuestById(@PathVariable UUID id) {
     return ResponseEntity.ok(guestService.getGuestById(id));
 }

 @GetMapping public ResponseEntity<List<GuestDTO>> getAllGuests(){
     return ResponseEntity.ok(guestService.getAllGuests());
 }

 @DeleteMapping("/{id}") public ResponseEntity<Void> deleteGuest(@PathVariable UUID id) {
     guestService.deleteGuest(id); return ResponseEntity.noContent().build(); }
}
