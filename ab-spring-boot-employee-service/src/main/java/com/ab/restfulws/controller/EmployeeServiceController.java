package com.ab.restfulws.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ab.restfulws.exception.EmployeeNotFoundException;
import com.ab.restfulws.model.Employee;
import com.ab.restfulws.model.EmployeeContact;
import com.ab.restfulws.repository.EmployeeContactRepository;
import com.ab.restfulws.service.EmployeeService;

@RestController
public class EmployeeServiceController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeContactRepository employeeContactRepository;

	@GetMapping("/employee")
	public List<Employee> findAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees();

		return employees;
	}

	@GetMapping("/employee/{employeeId}")
	public Employee findEmployeeById(@PathVariable int employeeId) {
		Optional<Employee> employee = employeeService.findEmployeeById(employeeId);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with ID= " + employeeId);
		}
		return employee.get();
	}

	@GetMapping("/employee/name/{employeeName}")
	public Employee findEmployeeByName(@PathVariable String employeeName) {
		Employee employee = employeeService.findEmployeeByName(employeeName);

		return employee;
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{employeeId}")
				.buildAndExpand(savedEmployee.getEmployeeID()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/employees/{employeeID}/contacts")
	public List<EmployeeContact> findEmployeeContactByID(@PathVariable int employeeID) {

		Optional<Employee> employee = employeeService.findEmployeeById(employeeID);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with ID= " + employeeID);
		}

		return employee.get().getEmployeeContacts();

	}

	@PostMapping("/employee/{employeeID}/contacts")
	public ResponseEntity<Employee> saveEmployeeContact(@PathVariable int employeeID,
			@RequestBody EmployeeContact employeeContact) {

		Optional<Employee> savedEmployee = employeeService.findEmployeeById(employeeID);
		if (!savedEmployee.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with ID= " + employeeID);
		}
		Employee employee = savedEmployee.get();
		employeeContact.setEmployee(employee);
		employeeContactRepository.save(employeeContact);

		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{employeeID}")
				.buildAndExpand(employeeContact.getEmployeeContactID()).toUri();
		return ResponseEntity.created(location).build();
	}

	/* i18n support */
	@GetMapping("/greeting/{name}")
	public String greeting(@PathVariable String name) {
		return messageSource.getMessage("greeting.message", null, LocaleContextHolder.getLocale()) + " " + name;
	}

}
