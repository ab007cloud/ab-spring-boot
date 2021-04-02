package com.ab.restfulws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.restfulws.model.Employee;
import com.ab.restfulws.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();

	}

	@GetMapping("/employee/id/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);

	}



	@PostMapping("/employee/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}

	@PostMapping("/employee/saveall")
	public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
		return employeeService.saveEmployees(employees);

	}

	@PutMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);

	}

	@DeleteMapping("/employee/id/{employeeId}")
	public String deleteEmployeeByEmployeeId(@PathVariable int employeeId) {
		return employeeService.deleteEmployeeByEmployeeId(employeeId);

	}
}
