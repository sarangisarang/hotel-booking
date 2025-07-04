package com.booksys.roomtype;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing Room Types.
 */
public interface RoomTypeService {
    RoomType create(RoomType roomType);
    List<RoomType> getAll();
    RoomType getById(UUID id);
    void delete(UUID id);
    List<RoomTypeDTO> getAllDTO();
}