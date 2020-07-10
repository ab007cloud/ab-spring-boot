package com.ab.restfulws.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmployeeContact {
	@Id
	@GeneratedValue
	private Integer employeeContactID;
	private String employeePhoneNo;
	private String employeeAddress;
	@ManyToOne(fetch = FetchType.LAZY)
	/* Ignore this for recursive issue */
	@JsonIgnore
	private Employee employee;

	public EmployeeContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeContact(Integer employeeContactID, String employeePhoneNo, String employeeAddress,
			Employee employee) {
		super();
		this.employeeContactID = employeeContactID;
		this.employeePhoneNo = employeePhoneNo;
		this.employeeAddress = employeeAddress;
		this.employee = employee;
	}

	public Integer getEmployeeContactID() {
		return employeeContactID;
	}

	public void setEmployeeContactID(Integer employeeContactID) {
		this.employeeContactID = employeeContactID;
	}

	public String getEmployeePhoneNo() {
		return employeePhoneNo;
	}

	public void setEmployeePhoneNo(String employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
