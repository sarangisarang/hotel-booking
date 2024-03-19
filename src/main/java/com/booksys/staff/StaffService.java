package com.booksys.staff;
import java.util.List;
import java.util.UUID;

public interface StaffService {
    Staff save(Staff staff);
    List<Staff> deleteStaffById(UUID id);
    List<Staff> findByName(String name);
    List<Staff> findAllStaff();
    Staff findByIdStaff(UUID id);
}
