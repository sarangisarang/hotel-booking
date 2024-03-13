package com.booksys.staff;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class StaffServiceImpl implements StaffService{

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    @Override
    public Staff save(Staff staff) {
        return  staffRepository.save(staff);
    }

    @Override
    public void deleteStaffById(UUID id) {
    }

    @Override
    public List<Staff> findByName(String name) {
        return staffRepository.findByFirstName(name);
    }

    @Override
    public Staff findAllStaff() {
        return null;
    }
}
