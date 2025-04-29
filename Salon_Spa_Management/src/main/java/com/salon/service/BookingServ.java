package com.salon.service;

import java.util.List;

import com.salon.entity.Service;

public interface BookingServ {
	

	List<Service> getAllServices();
    Service getServiceById(Long id);
    Service createService(Service service);
    Service updateService(Long id, Service service);
    void deleteService(Long id);
}
