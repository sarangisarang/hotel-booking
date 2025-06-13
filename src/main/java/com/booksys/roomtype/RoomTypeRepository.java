package com.booksys.roomtype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository interface for RoomType entity.
 */
public interface RoomTypeRepository extends JpaRepository<RoomType, UUID> {
    boolean existsByName(String name);
}
