package com.booksys.servicerequest;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequestDTO {

    private UUID id; // optional for GET response
    private UUID guestId;
    private UUID serviceId;
    private ServiceRequestStatus status;
    private LocalDateTime requestDate; // ISO format (optional for POST)

}
