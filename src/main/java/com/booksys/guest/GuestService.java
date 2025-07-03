package com.booksys.guest;

import java.util.List; import java.util.UUID;

/**

 GuestService defines the business operations for managing guests using DTOs. */
public interface GuestService {

    GuestDTO createGuest(GuestDTO guestDTO);

    GuestDTO updateGuest(UUID guestId, GuestDTO guestDTO);

    GuestDTO getGuestById(UUID guestId);

    List<GuestDTO> getAllGuests();

    void deleteGuest(UUID guestId);
}
