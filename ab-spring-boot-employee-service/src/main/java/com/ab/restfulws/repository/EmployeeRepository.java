package com.ab.restfulws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.restfulws.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	/*Find by Column name */
	public Employee findByEmployeeName(String employeeName);

}
