package com.booksys.employee;
import java.util.List;
import java.util.UUID;


public interface StaffService {
    StaffDTO createStaff(StaffDTO staffDTO);
    StaffDTO getStaffById(UUID staffID);
    List<StaffDTO> getAllStaff();
    StaffDTO updateStaff(UUID staffID, StaffDTO staffDTO);
    void deleteStaff(UUID staffID);
}

