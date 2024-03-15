package com.booksys.roomtype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoomTypeRepository extends JpaRepository<RoomType,String> {
    List<RoomType> findByName(String name);

    Optional<Object> findByTypeId(UUID id);
}
