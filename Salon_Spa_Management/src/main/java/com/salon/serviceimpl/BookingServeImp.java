package com.salon.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.salon.entity.Service;
import com.salon.repository.ServiceRepository;
import com.salon.service.BookingServ;

@org.springframework.stereotype.Service
public class BookingServeImp implements BookingServ{
	
	@Autowired
	ServiceRepository serviceRepository;

	@Override
	public List<Service> getAllServices() {
		return serviceRepository.findAll();
	}

	@Override
	public Service getServiceById(Long id) {
		Optional<Service> service = serviceRepository.findById(id);
        return service.orElse(null); 
	}

	@Override
	public Service createService(Service service) {
		return serviceRepository.save(service);
	}

	@Override
	public Service updateService(Long id, Service service) {
Optional<Service> existingServiceOpt = serviceRepository.findById(id);
        
        if (existingServiceOpt.isPresent()) {
            Service existingService = existingServiceOpt.get();
            existingService.setName(service.getName());
            existingService.setPrice(service.getPrice());
            existingService.setDescription(service.getDescription());
            return serviceRepository.save(existingService);
        }
        return null;  // Return nul
	}

	@Override
	public void deleteService(Long id) {
		serviceRepository.deleteById(id);
		
	}

}
