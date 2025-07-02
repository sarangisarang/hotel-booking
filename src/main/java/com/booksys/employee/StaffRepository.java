package com.booksys.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff,String> {
    List<Staff> findByFirstName(String name);

    Optional<Object> findByStaffID(UUID id);

}
