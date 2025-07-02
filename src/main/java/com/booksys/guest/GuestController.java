package com.booksys.guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing Guest resources.
 * Provides endpoints for creating, retrieving, updating, and deleting guests.
 */
@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "*") // Enable CORS for all origins; customize as needed
public class GuestController {

    private final GuestService guestService;

    /**
     * Constructor injection for GuestService.
     *
     * @param guestService the service handling guest logic
     */
    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    /**
     * GET /api/guests
     * Retrieves a list of all guests.
     *
     * @return List of all guests
     */
    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    /**
     * GET /api/guests/{id}
     * Retrieves a guest by their unique ID.
     *
     * @param guestID the UUID of the guest
     * @return the guest with the given ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable UUID id) {
        return ResponseEntity.ok(guestService.getGuestById(id));
    }

    /**
     * POST /api/guests
     * Creates a new guest record.
     *
     * @param guest the guest object to be created
     * @return the created guest
     */
    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        return ResponseEntity.ok(guestService.createGuest(guest));
    }

    /**
     * PUT /api/guests/{id}
     * Updates the guest with the given ID.
     *
     * @param id           the UUID of the guest to update
     * @param updatedGuest the updated guest object
     * @return the updated guest
     */
    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable UUID id, @RequestBody Guest updatedGuest) {
        return ResponseEntity.ok(guestService.updateGuest(id, updatedGuest));
    }

    /**
     * DELETE /api/guests/{id}
     * Deletes a guest with the specified ID.
     *
     * @param id the UUID of the guest to delete
     * @return no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable UUID id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}

