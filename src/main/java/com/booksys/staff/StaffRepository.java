package com.booksys.staff;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff,String> {
    List<Staff> findByFirstName(String name);

    List<Staff> findByStaffID(UUID id);

}
