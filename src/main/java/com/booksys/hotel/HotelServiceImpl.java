package com.booksys.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service implementation for HotelService.
 */
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<HotelDTO> getAll() {
        return hotelRepository.findAll().stream()
                .map(hotel -> HotelDTO.builder()
                        .id(hotel.getId())
                        .name(hotel.getName())
                        .address(hotel.getAddress())
                        .phone(hotel.getPhone())
                        .email(hotel.getEmail())
                        .description(hotel.getDescription())
                        .rating(hotel.getRating())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Hotel getById(UUID id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
    }

    @Override
    public void delete(UUID id) {
        hotelRepository.deleteById(id);
    }
}

