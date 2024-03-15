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
    public List<RoomType> findByName(String name) {
        return roomTypeRepository.findByName(name);
    }

    @Override
    public RoomType findById(UUID id) {
        return (RoomType) roomTypeRepository.findByTypeId(id).orElseThrow();
    }

    @Override
    public List<RoomType> deleteByid(UUID id) {
        RoomType roomTypes = (RoomType) roomTypeRepository.findByTypeId(id).orElseThrow();
        roomTypeRepository.delete(roomTypes);
        return roomTypeRepository.findAll();
    }

    @Override
    public List<RoomType> findAll() {
        return roomTypeRepository.findAll();
    }
}
