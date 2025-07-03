package com.booksys.service;

import java.util.List;

public interface ServiceService {
    ServiceEntity createService(ServiceEntity serviceEntity);
    List<ServiceEntity> getAllServices();
    ServiceEntity getServiceById(Long id);
    ServiceEntity updateService(Long id, ServiceEntity updatedService);
    void deleteService(Long id);
}