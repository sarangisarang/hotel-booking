package com.booksys.hotel;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing hotels.
 */
public interface HotelService {
    Hotel create(Hotel hotel);
    List<HotelDTO> getAll();
    Hotel getById(UUID id);
    void delete(UUID id);
}
