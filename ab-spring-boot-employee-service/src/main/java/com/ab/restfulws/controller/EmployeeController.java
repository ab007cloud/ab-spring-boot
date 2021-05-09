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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "getAllEmployee", notes = "Fetch all employee details", nickname = "getAllEmployee")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = Employee.class, responseContainer = "List") })

	@GetMapping("/employee/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();

	}

	@ApiOperation(value = "getEmployeeById", notes = "Fetch  employee details by Id", nickname = "getEmployeeById")
	@GetMapping("/employee/id/{employeeId}")
	public Employee getEmployeeById(
			@ApiParam(value = "employeeId", required = true, defaultValue = "1") @PathVariable int employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);

	}

	@ApiOperation(value = "saveEmployee", notes = "Save  employee details", nickname = "saveEmployee")
	@PostMapping("/employee/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);

	}

	@ApiOperation(value = "saveEmployees", notes = "Save List of employee details", nickname = "saveEmployees")
	@PostMapping("/employee/saveall")
	public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
		return employeeService.saveEmployees(employees);

	}

	@ApiOperation(value = "updateEmployee", notes = "Update employee details", nickname = "updateEmployee")
	@PutMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);

	}

	@ApiOperation(value = "deleteEmployeeByEmployeeId", notes = "Delete employee details by Id", nickname = "deleteEmployeeByEmployeeId")
	@DeleteMapping("/employee/id/{employeeId}")
	public String deleteEmployeeByEmployeeId(
			@ApiParam(value = "employeeId", required = true, defaultValue = "1") @PathVariable int employeeId) {
		return employeeService.deleteEmployeeByEmployeeId(employeeId);

	}
}
