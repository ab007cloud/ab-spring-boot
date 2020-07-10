package com.ab.restfulws.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ab.restfulws.model.Employee;

/*Expose REST service from Repository*/
@RepositoryRestResource(path = "employeesdata", collectionResourceRel = "employeesdata")
public interface EmployeeSpringDataRestRepository extends PagingAndSortingRepository<Employee, Integer> {

}
