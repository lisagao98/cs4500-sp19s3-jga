package com.example.cs4500sp19s3jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s3jga.models.Service;
import com.example.cs4500sp19s3jga.repositories.ServiceRepository;

@RestController
public class ServiceService {
	@Autowired
	ServiceRepository serviceRepository;
	@GetMapping("/api/services")
	public List<Service> findAllService() {
		return serviceRepository.findAllServices();
	}
	@GetMapping("/api/services/{serviceId}")
	public Service findServiceById(
			@PathVariable("serviceId") Integer id) {
		return serviceRepository.findServiceById(id);
	}
	@PostMapping("/api/services")
	public Service createService(@RequestBody Service service) {
		return serviceRepository.save(service);
	}
	@PutMapping("/api/services/{serviceId}")
	public Service updateService(
			@PathVariable("serviceId") Integer id,
			@RequestBody Service serviceUpdates) {
		Service service = serviceRepository.findServiceById(id);
		service.setServiceName(serviceUpdates.getServiceName());
		return serviceRepository.save(service);
	}
	@DeleteMapping("/api/services/{serviceId}")
	public void deleteService(
			@PathVariable("serviceId") Integer id) {
		serviceRepository.deleteById(id);
	}
}
