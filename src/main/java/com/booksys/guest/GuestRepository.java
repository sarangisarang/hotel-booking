package com.booksys.guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * GuestRepository provides CRUD operations for Guest entities using Spring Data JPA.
 * It extends JpaRepository which offers built-in methods such as save, findAll, deleteById, etc.
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest, UUID> {

    /**
     * Find a guest by their unique guest ID.
     *
     * @param guestID UUID of the guest.
     * @return an Optional containing the found Guest or empty if not found.
     */
    Optional<Guest> findByGuestID(UUID guestID);

    /**
     * Find a list of guests by their first name.
     *
     * @param firstName First name to search.
     * @return a list of guests matching the first name.
     */
    List<Guest> findByFirstName(String firstName);
}
