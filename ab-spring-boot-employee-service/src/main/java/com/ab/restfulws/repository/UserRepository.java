package com.ab.restfulws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.restfulws.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
