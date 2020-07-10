package com.ab.restfulws.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int employeeID;
	@Column(nullable = false)
	private String employeeName;
	@OneToMany(mappedBy = "employee")
	private List<EmployeeContact> employeeContacts;
	@Transient
	private String environmentInfo;



	public String getEnvironmentInfo() {
		return environmentInfo;
	}

	public void setEnvironmentInfo(String environmentInfo) {
		this.environmentInfo = environmentInfo;
	}

	public Employee(int employeeID, String employeeName, List<EmployeeContact> employeeContacts) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeContacts = employeeContacts;
	}

	public List<EmployeeContact> getEmployeeContacts() {
		return employeeContacts;
	}

	public void setEmployeeContacts(List<EmployeeContact> employeeContacts) {
		this.employeeContacts = employeeContacts;
	}

	public Employee() {

	}

	public Employee(int employeeID, String employeeName) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
