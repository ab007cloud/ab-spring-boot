package com.ab.restfulws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.restfulws.model.EmployeeContact;

@Repository
public interface EmployeeContactRepository extends JpaRepository<EmployeeContact, Integer> {

}
