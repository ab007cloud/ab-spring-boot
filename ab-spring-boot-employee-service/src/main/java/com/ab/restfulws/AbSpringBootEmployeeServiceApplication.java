package com.ab.restfulws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbSpringBootEmployeeServiceApplication  {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbSpringBootEmployeeServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AbSpringBootEmployeeServiceApplication.class, args);
	}



}
