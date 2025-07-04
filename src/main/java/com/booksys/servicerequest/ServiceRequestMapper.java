package com.booksys.servicerequest;

import com.booksys.guest.Guest;
import com.booksys.service.ServiceEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface ServiceRequestMapper {

    static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // DTO -> Entity (create)
        static ServiceRequest toEntity(
            ServiceRequestDTO dto,
            Guest guest,
            ServiceEntity service
    ) {
        return ServiceRequest.builder()
                .guest(guest)
                .service(service)
                .status(ServiceRequestStatus.valueOf(String.valueOf(dto.getStatus())))
                .build();
    }

    // Entity -> DTO (response)
        static ServiceRequestDTO toDTO(ServiceRequest entity) {
        return ServiceRequestDTO.builder()
                .id(entity.getId())
                .guestId(entity.getGuest().getId())
                .serviceId(entity.getService().getId())
                .status(ServiceRequestStatus.valueOf(entity.getStatus().name()))
                .requestDate(LocalDateTime.parse(entity.getRequestDate().format(formatter)))
                .build();
    }
}
