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
    public List<Staff> deleteStaffById(UUID id) {
        Staff staff = (Staff) staffRepository.findByStaffID(id).orElseThrow();
        staffRepository.delete(staff);
        return staffRepository.findAll();
    }

    @Override
    public List<Staff> findByName(String name) {
        return staffRepository.findByFirstName(name);
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff findByIdStaff(UUID id) {
        return (Staff) staffRepository.findByStaffID(id).orElseThrow();
    }
}
