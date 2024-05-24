package com.booksys.roomtype;
import java.util.List;
import java.util.UUID;

public interface RoomTypeService {
    void save(RoomType roomType);
    List<RoomType> findByName(String name);
    RoomType findById(UUID id);
    List<RoomType> deleteByid(UUID id);
    List<RoomType> findAll();
}
