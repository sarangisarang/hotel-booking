package com.booksys.booking;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

/**
 * Repository interface for accessing Booking entities from the database.
 * Uses Spring Data JPA to provide CRUD operations and custom queries.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {

    /**
     * Find all bookings by a specific guest's ID.
     *
     * @param guestId UUID of the guest.
     * @return list of bookings made by the guest.
     */
    List<Booking> findByGuestId(UUID guestId);


    @EntityGraph(attributePaths = {"guest","room"})
    List<Booking> findAll();
    /**
     * Find all bookings for a specific room.
     *
     * @param roomId UUID of the room.
     * @return list of bookings associated with the room.
     */
    List<Booking> findByRoomId(UUID roomId);
}
