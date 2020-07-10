package com.ab.restfulws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.restfulws.model.Admin;
import com.ab.restfulws.repository.AdminJdbcRepository;

@RestController
public class AdminController {
	@Autowired
	private AdminJdbcRepository adminJdbcRepository;

	@GetMapping("/admin")
	public List<Admin> findAllAdmin() {

		List<Admin> admins = adminJdbcRepository.findAllAdmin();

		return admins;
	}

	@GetMapping("/admin/{adminId}")
	public Admin findAdminById(@PathVariable int adminId) {

		return adminJdbcRepository.findAdminById(adminId);
	}

	@DeleteMapping("/admin/{adminId}")
	public ResponseEntity<Integer> deleteAdminById(@PathVariable int adminId) {
		return new ResponseEntity<Integer>(adminJdbcRepository.deleteAdminById(adminId), HttpStatus.OK);

	}

	@PostMapping("/admin")
	public ResponseEntity<Integer> addAdminJdbc(@RequestBody Admin admin) {
		return new ResponseEntity<Integer>(adminJdbcRepository.saveAdmin(admin), HttpStatus.OK);

	}
	@PutMapping("/admin")
	public ResponseEntity<Integer> updateAdminJdbc(@RequestBody Admin admin) {
		return new ResponseEntity<Integer>(adminJdbcRepository.updateAdmin(admin), HttpStatus.OK);

	}
}
