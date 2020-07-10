package com.ab.restfulws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ab.restfulws.model.Employee;

@Service
public interface EmployeeService {

	public List<Employee> findAllEmployees();

	public Optional<Employee> findEmployeeById(int employeeId);


	public Employee saveEmployee( Employee employee);

	public Employee findEmployeeByName(String employeeName);

}
