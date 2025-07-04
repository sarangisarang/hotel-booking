package com.booksys.roomtype;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of RoomTypeService.
 */
@Service
@RequiredArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    private final RoomTypeMapper roomTypeMapper;

    @Override
    public List<RoomTypeDTO> getAllDTO() {
        return roomTypeRepository.findAll()
                .stream()
                .map(roomTypeMapper::toDTO)
                .collect(Collectors.toList());
    }


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

    public boolean existsByName(String name) {
        return roomTypeRepository.existsByName(name);
    }
    public RoomTypeDTO getRoomTypeById(UUID id) {
        RoomType roomType = roomTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomType not found with id: " + id));
        return roomTypeMapper.toDTO(roomType);
    }

}
