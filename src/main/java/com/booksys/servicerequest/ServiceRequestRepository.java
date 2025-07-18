package com.booksys.servicerequest;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, UUID> {
}