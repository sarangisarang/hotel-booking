package com.booksys.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public StaffDTO createStaff(StaffDTO staffDTO) {
        Staff staff = StaffMapper.toEntity(staffDTO);
        Staff saved = staffRepository.save(staff);
        return StaffMapper.toDTO(saved);
    }

    @Override
    public StaffDTO getStaffById(UUID staffID) {
        Optional<Staff> staffOptional = staffRepository.findById(String.valueOf(staffID));
        return staffOptional.map(StaffMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + staffID));
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream()
                .map(StaffMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StaffDTO updateStaff(UUID staffID, StaffDTO staffDTO) {
        Staff existing = staffRepository.findById(String.valueOf(staffID))
                .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + staffID));

        existing.setFirstName(staffDTO.getFirstName());
        existing.setLastName(staffDTO.getLastName());
        existing.setPositions(staffDTO.getPositions());
        existing.setSalary(staffDTO.getSalary());
        existing.setDateOfBirth(staffDTO.getDateOfBirth());
        existing.setPhone(staffDTO.getPhone());
        existing.setEmail(staffDTO.getEmail());
        existing.setHireDate(staffDTO.getHireDate());

        Staff updated = staffRepository.save(existing);
        return StaffMapper.toDTO(updated);
    }

    @Override
    public void deleteStaff(UUID staffID) {
        if (!staffRepository.existsById(String.valueOf(staffID))) {
            throw new RuntimeException("Staff not found with ID: " + staffID);
        }
        staffRepository.deleteById(String.valueOf(staffID));
    }
}
