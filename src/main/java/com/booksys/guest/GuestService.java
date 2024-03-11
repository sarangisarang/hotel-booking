package com.booksys.guest;
import java.util.List;
import java.util.UUID;

public interface GuestService {
    Guest save (Guest guest);
    void deleteGuest(UUID id);
    Guest findById(UUID id);
    List<Guest> findByFirstName(String firstName);
    Guest findAll();
}
