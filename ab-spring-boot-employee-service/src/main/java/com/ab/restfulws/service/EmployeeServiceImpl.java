package com.ab.restfulws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.restfulws.model.Employee;
import com.ab.restfulws.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employeeId);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findEmployeeByName(String employeeName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmployeeName(employeeName);
	}

}
