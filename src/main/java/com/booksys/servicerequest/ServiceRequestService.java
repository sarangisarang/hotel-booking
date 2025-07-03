package com.booksys.servicerequest;

import java.util.List;
import java.util.UUID;

public interface ServiceRequestService {
    ServiceRequest createRequest(ServiceRequest serviceRequest);
    List<ServiceRequest> getAllRequests();
    ServiceRequest getRequestById(UUID id);
    ServiceRequest updateRequest(UUID id, ServiceRequest updatedRequest);
    void deleteRequest(UUID id);
}