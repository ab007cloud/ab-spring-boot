package com.ab.restfulws.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ab.restfulws.model.User;
import com.ab.restfulws.repository.UserRepository;
import com.ab.restfulws.util.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Async
	public CompletableFuture<List<User>> saveUsers(MultipartFile multipartFile) {
		long statTime = System.currentTimeMillis();
		List<User> users = FileUtil.parseCSVFile(multipartFile);
		log.info("User List Size {}", users.size());
		log.info("User Save Thread name {}", Thread.currentThread().getName());
		users = userRepository.saveAll(users);
		long endTime = System.currentTimeMillis();
		log.info("Total Time {}", (endTime - statTime));
		return CompletableFuture.completedFuture(users);
	}

	@Async
	public CompletableFuture<List<User>> getAllUsers() {
		log.info("User get Thread name {}", Thread.currentThread().getName());
		List<User> users = userRepository.findAll();
		return CompletableFuture.completedFuture(users);
	}
}
