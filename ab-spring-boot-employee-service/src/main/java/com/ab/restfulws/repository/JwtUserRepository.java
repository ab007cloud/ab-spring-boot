package com.ab.restfulws.repository;

import org.springframework.data.repository.CrudRepository;

import com.ab.restfulws.model.JwtUser;

public interface JwtUserRepository extends CrudRepository<JwtUser, Integer> {

}
