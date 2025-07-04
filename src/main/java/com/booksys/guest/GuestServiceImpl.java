package com.booksys.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**

 GuestServiceImpl implements GuestService, managing business logic for

 guest operations using DTOs for clear API responses. */
@Service
@RequiredArgsConstructor

public class GuestServiceImpl implements GuestService {


    @Autowired
    private final GuestRepository guestRepository;

    @Autowired
    private final GuestMapper guestMapper;

    @Override
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override public GuestDTO updateGuest(UUID guestId, GuestDTO guestDTO) {
        Guest existing = guestRepository.findById(guestId) .orElseThrow(() -> new RuntimeException("Guest not found with ID: " + guestId));

        existing.setFirstName(guestDTO.getFirstName());
        existing.setLastName(guestDTO.getLastName());
        existing.setEmail(guestDTO.getEmail());
        existing.setPhone(guestDTO.getPhone());
        existing.setAddress(guestDTO.getAddress());
        existing.setBirthDate(guestDTO.getBirthDate());

        return guestMapper.toDTO(guestRepository.save(existing));

    }

    @Override public GuestDTO getGuestById(UUID guestId) {
        return guestMapper.toDTO(guestRepository.findById(guestId) .orElseThrow(() -> new RuntimeException("Guest not found with ID: " + guestId)));
    }

    @Override public List<GuestDTO> getAllGuests() {
            return guestRepository.findAll().stream()
                    .map(guest -> GuestDTO.builder()
                            .id(guest.getId())
                            .firstName(guest.getFirstName())
                            .lastName(guest.getLastName())
                            .email(guest.getEmail())
                            .phone(guest.getPhone())
                            .address(guest.getAddress())
                            .birthDate(guest.getBirthDate())
                            .build())
                    .collect(Collectors.toList());
        }


        @Override public void deleteGuest(UUID guestId) {
        if (!guestRepository.existsById(guestId)) {
            throw new RuntimeException("Guest not found with ID: " + guestId);
        } guestRepository.deleteById(guestId); }
}