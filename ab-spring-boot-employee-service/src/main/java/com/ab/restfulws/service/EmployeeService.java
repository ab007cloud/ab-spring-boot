package com.ab.restfulws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.restfulws.model.Employee;
import com.ab.restfulws.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> saveEmployees(List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	public Employee getEmployeeByEmployeName(String employeeName) {
		return employeeRepository.findByEmployeeName(employeeName);
	}

	public String deleteEmployeeByEmployeeId(int employeeId) {
		employeeRepository.deleteById(employeeId);
		return "Employee Removed with Id : " + employeeId;
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = employeeRepository.findById(employee.getEmployeeID()).orElse(null);
		existingEmployee.setEmployeeName(employee.getEmployeeName());
		return employeeRepository.save(existingEmployee);
	}

}
