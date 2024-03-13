package com.booksys.staff;

import java.util.List;
import java.util.UUID;

public interface StaffService {
    Staff save(Staff staff);
    void deleteStaffById(UUID id);
    List<Staff> findByName(String name);
    Staff findAllStaff();

}
