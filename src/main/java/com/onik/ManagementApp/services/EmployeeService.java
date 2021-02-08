package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.Employee;
import com.onik.ManagementApp.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> findById(Integer id) {
		return employeeRepository.findById(id);
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteById(Integer id) {
		employeeRepository.deleteById(id);
	}

	public Employee findByUsername(String un) {

		return employeeRepository.findByUsername(un);

	}

}
