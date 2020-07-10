package com.ab.restfulws.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ab.restfulws.AbSpringBootEmployeeServiceApplication;
import com.ab.restfulws.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbSpringBootEmployeeServiceApplication.class)
public class EmployeeRepositoryTest {
	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testFindAllEmployeeById() {
		Optional<Employee> actual = employeeRepository.findById(1);
		assertEquals(actual.get().getEmployeeName(), "employee1");
	}

}
