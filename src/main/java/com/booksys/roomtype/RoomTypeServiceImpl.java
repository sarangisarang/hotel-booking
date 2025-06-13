package com.booksys.roomtype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of RoomTypeService.
 */
@Service
@RequiredArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    @Override
    public RoomType create(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public List<RoomType> getAll() {
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomType getById(UUID id) {
        return roomTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomType not found with id: " + id));
    }

    @Override
    public void delete(UUID id) {
        roomTypeRepository.deleteById(id);
    }
}
