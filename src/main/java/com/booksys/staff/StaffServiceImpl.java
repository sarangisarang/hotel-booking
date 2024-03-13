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
        List<Staff> staff= staffRepository.findByStaffID(id);
        staffRepository.delete((Staff) staff);
    }

    @Override
    public List<Staff> findByName(String name) {
        return staffRepository.findByFirstName(name);
    }

    @Override
    public Staff findAllStaff() {
        return (Staff) staffRepository.findAll();
    }

    @Override
    public List<Staff> findByIdStaff(UUID id) {
        return staffRepository.findByStaffID(id);
    }
}
