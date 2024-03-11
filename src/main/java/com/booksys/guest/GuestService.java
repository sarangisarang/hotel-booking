package com.booksys.guest;

import java.util.UUID;

public interface GuestService {
    Guest save (Guest guest);
    void deleteguest(UUID id);
    Guest findById(UUID id);

}
