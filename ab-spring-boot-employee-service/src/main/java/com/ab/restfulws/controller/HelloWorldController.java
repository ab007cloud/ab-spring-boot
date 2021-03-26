package com.ab.restfulws.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)

public class HelloWorldController {

	@RequestMapping(value = "/sayhello")
	public ResponseEntity<String> helloWorld() {

		return ResponseEntity.ok().body("Hello World");

	}

}
