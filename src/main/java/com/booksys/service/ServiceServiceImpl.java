package com.booksys.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public ServiceDTO createService(ServiceDTO dto) {
        ServiceEntity saved = serviceRepository.save(ServiceMapper.toEntity(dto));
        return ServiceMapper.toDTO(saved);
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        return ServiceMapper.toDTOList(serviceRepository.findAll());
    }

    @Override
    public ServiceDTO getServiceById(UUID id) {
        ServiceEntity service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + id));
        return ServiceMapper.toDTO(service);
    }

    @Override
    public ServiceDTO updateService(UUID id, ServiceDTO dto) {
        ServiceEntity existing = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + id));
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setPrice(dto.getPrice());
        return ServiceMapper.toDTO(serviceRepository.save(existing));
    }

    @Override
    public void deleteService(UUID id) {
        serviceRepository.deleteById(id);
    }
}