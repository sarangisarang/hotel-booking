package com.booksys.room;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * Repository interface for Room entity.
 */
public interface RoomRepository extends JpaRepository<Room, UUID> {
    boolean existsByRoomNumber(String roomNumber);
}