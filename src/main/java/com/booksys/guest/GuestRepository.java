package com.booksys.guest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestRepository extends JpaRepository<Guest,String>{
    Optional<Object> findById(UUID id);

    List<Guest> findByfirstName(String firstName);
}
