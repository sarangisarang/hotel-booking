package com.booksys.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * GuestServiceImpl provides the implementation of the GuestService interface.
 * It handles the business logic for managing guest data, and delegates
 * data persistence operations to the GuestRepository.
 */
@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    /**
     * Constructor injection of the GuestRepository dependency.
     *
     * @param guestRepository Spring Data JPA repository for Guest entities.
     */
    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Guest getGuestById(UUID guestID) {
        return guestRepository.findById(guestID)
                .orElseThrow(() -> new GuestNotFoundException("Guest not found with ID: " + guestID));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Guest updateGuest(UUID guestID, Guest updatedGuest) {
        Guest existingGuest = getGuestById(guestID);

        existingGuest.setFirstName(updatedGuest.getFirstName());
        existingGuest.setLastName(updatedGuest.getLastName());
        existingGuest.setBirthDate(updatedGuest.getBirthDate());
        existingGuest.setAddress(updatedGuest.getAddress());
        existingGuest.setPhone(updatedGuest.getPhone());
        existingGuest.setEmail(updatedGuest.getEmail());

        return guestRepository.save(existingGuest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteGuest(UUID guestID) {
        if (!guestRepository.existsById(guestID)) {
            throw new GuestNotFoundException("Guest not found with ID: " + guestID);
        }
        guestRepository.deleteById(guestID);
    }
}