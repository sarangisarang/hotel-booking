package com.booksys.guest;

import java.util.List; import java.util.UUID;

/**

 GuestService defines the business operations for managing guests using DTOs. */
public interface GuestService {


    Guest createGuest(Guest guest);

    GuestDTO updateGuest(UUID guestId, GuestDTO guestDTO);

    GuestDTO getGuestById(UUID guestId);

    List<GuestDTO> getAllGuests();

    void deleteGuest(UUID guestId);
}
