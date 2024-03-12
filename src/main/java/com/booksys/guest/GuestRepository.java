package com.booksys.guest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestRepository extends JpaRepository<Guest,String>{
    Optional<Object> findByguestID(UUID id);

    List<Guest> findByfirstName(String firstName);
}
