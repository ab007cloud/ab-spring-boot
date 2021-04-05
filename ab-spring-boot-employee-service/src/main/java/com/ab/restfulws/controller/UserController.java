package com.ab.restfulws.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ab.restfulws.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "users", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] multipartFiles) {
		for (MultipartFile multipartFile : multipartFiles) {
			userService.saveUsers(multipartFile);
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<ResponseEntity> getAllUsers() {
		return userService.getAllUsers().thenApply(ResponseEntity::ok);
	}

}
