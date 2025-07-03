package com.booksys.servicerequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List; import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional

public class ServiceRequestServiceImpl implements ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;

    @Override
    public ServiceRequest createRequest(ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    @Override
    public List<ServiceRequest> getAllRequests() {
        return serviceRequestRepository.findAll();
    }

    @Override
    public ServiceRequest getRequestById(UUID id) {
        return serviceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceRequest not found with ID: " + id));
    }

    @Override
    public ServiceRequest updateRequest(UUID id, ServiceRequest updatedRequest) {
        return null;
    }

    @Override
    public void deleteRequest(UUID id) {

    }
}