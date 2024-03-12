package com.booksys.roomtype;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public void save(RoomType roomType) {
        roomTypeRepository.save(roomType);
    }

    @Override
    public List<RoomType> findbyName(String name) {
        return roomTypeRepository.findByName(name);
    }

    @Override
    public RoomType findbyId(UUID id) {
        return (RoomType) roomTypeRepository.findBytypeId(id).orElseThrow();
    }

    @Override
    public List<RoomType> deleteByid(UUID id) {
        return null;
    }
}
