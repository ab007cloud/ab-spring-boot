package com.ab.restfulws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(description = "Employee Model")
public class Employee {
	@Id
	@GeneratedValue
	@ApiModelProperty(position = 1, value = "1")
	private int employeeID;
	@Column
	@ApiModelProperty(position = 2, value = "Avishek")
	private String employeeName;

}
