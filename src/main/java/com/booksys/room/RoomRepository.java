package com.booksys.room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room ,String> {
    Optional<Object> findAllById(UUID RoomId);
}
