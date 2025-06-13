package com.booksys.guest;

import java.util.List;
import java.util.UUID;

/**
 * GuestService defines the contract for all business logic operations
 * related to Guest entities.
 *
 * It is implemented by GuestServiceImpl.
 */
public interface GuestService {

    /**
     * Retrieve a list of all guests from the database.
     *
     * @return List of Guest objects.
     */
    List<Guest> getAllGuests();

    /**
     * Retrieve a single guest by their unique ID.
     *
     * @param guestID UUID of the guest to find.
     * @return Guest object if found.
     */
    Guest getGuestById(UUID guestID);

    /**
     * Create a new guest and save it to the database.
     *
     * @param guest Guest object to be created.
     * @return The created Guest object.
     */
    Guest createGuest(Guest guest);

    /**
     * Update an existing guest by their ID.
     *
     * @param guestID UUID of the guest to update.
     * @param updatedGuest Guest object containing updated data.
     * @return The updated Guest object.
     */
    Guest updateGuest(UUID guestID, Guest updatedGuest);

    /**
     * Delete a guest by their ID.
     *
     * @param guestID UUID of the guest to delete.
     */
    void deleteGuest(UUID guestID);
}