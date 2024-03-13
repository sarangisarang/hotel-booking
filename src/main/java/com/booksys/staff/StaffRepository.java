package com.booksys.staff;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff,String> {
    List<Staff> findByFirstName(String name);

}
