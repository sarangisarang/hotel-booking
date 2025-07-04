package com.booksys.employee;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public interface StaffMapper {

    static StaffDTO toDTO(Staff staff) {
            if (staff == null) return null;

            StaffDTO dto = new StaffDTO();
            dto.setStaffID(staff.getStaffID());
            dto.setFirstName(staff.getFirstName());
            dto.setLastName(staff.getLastName());
            dto.setPositions(staff.getPositions());
            dto.setSalary(staff.getSalary());
            dto.setDateOfBirth(staff.getDateOfBirth());
            dto.setPhone(staff.getPhone());
            dto.setEmail(staff.getEmail());
            dto.setHireDate(staff.getHireDate());
            return dto;
        }

        static Staff toEntity(StaffDTO dto) {
            if (dto == null) return null;

            Staff staff = new Staff();
            staff.setStaffID(dto.getStaffID());
            staff.setFirstName(dto.getFirstName());
            staff.setLastName(dto.getLastName());
            staff.setPositions(dto.getPositions());
            staff.setSalary(dto.getSalary());
            staff.setDateOfBirth(dto.getDateOfBirth());
            staff.setPhone(dto.getPhone());
            staff.setEmail(dto.getEmail());
            staff.setHireDate(dto.getHireDate());
            return staff;
        }

            default List<StaffDTO> toDTOList(List<Staff> staffList) {
            if (staffList == null) return List.of();

            return staffList.stream()
                    .map(StaffMapper::toDTO)
                    .collect(Collectors.toList());
        }

            default List<Staff> toEntityList(List<StaffDTO> dtoList) {
            if (dtoList == null) return List.of();

            return dtoList.stream()
                    .map(StaffMapper::toEntity)
                    .collect(Collectors.toList());
        }
    }


