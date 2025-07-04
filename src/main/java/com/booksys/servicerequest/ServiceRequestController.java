package com.booksys.servicerequest;

import com.booksys.guest.Guest;
import com.booksys.guest.GuestRepository;
import com.booksys.service.ServiceEntity;
import com.booksys.service.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servicerequests")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;
    private final GuestRepository guestRepository;
    private final ServiceRepository serviceRepository;

    // GET all
    @GetMapping
    public List<ServiceRequestDTO> getAllRequests() {
        return serviceRequestService.getAllRequests().stream()
                .map(ServiceRequestMapper::toDTO)
                .collect(Collectors.toList());
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequestDTO> getRequestById(@PathVariable UUID id) {
        ServiceRequest request = serviceRequestService.getRequestById(id);
        return ResponseEntity.ok(ServiceRequestMapper.toDTO(request));
    }

    // POST (create)
    @PostMapping
    public ResponseEntity<ServiceRequestDTO> createRequest(@RequestBody ServiceRequestDTO dto) {
        Guest guest = guestRepository.findById(dto.getGuestId())
                .orElseThrow(() -> new RuntimeException("Guest not found"));
        ServiceEntity service = serviceRepository.findById(dto.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        ServiceRequest entity = ServiceRequestMapper.toEntity(dto, guest, service);
        ServiceRequest saved = serviceRequestService.createRequest(entity);
        return ResponseEntity.ok(ServiceRequestMapper.toDTO(saved));
    }

    // PUT (update status, for example)
    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequestDTO> updateRequest(@PathVariable UUID id, @RequestBody ServiceRequestDTO dto) {
        ServiceRequest existing = serviceRequestService.getRequestById(id);

        // update only status (or more if you want)
        existing.setStatus(ServiceRequestStatus.valueOf(String.valueOf(dto.getStatus())));

        ServiceRequest updated = serviceRequestService.createRequest(existing); // reuse save()
        return ResponseEntity.ok(ServiceRequestMapper.toDTO(updated));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable UUID id) {
        serviceRequestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
