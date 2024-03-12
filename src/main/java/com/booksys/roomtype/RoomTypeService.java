package com.booksys.roomtype;

import java.util.List;
import java.util.UUID;

public interface RoomTypeService {
    void save(RoomType roomType);
    List<RoomType>findbyName(String name);
    RoomType findbyId(UUID id);
    List<RoomType> deleteByid(UUID id);
}
