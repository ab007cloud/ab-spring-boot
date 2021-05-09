package com.ab.restfulws.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ab.restfulws.model.AuthenticationRequest;
import com.ab.restfulws.model.JwtUser;
import com.ab.restfulws.repository.JwtUserRepository;

/**
 * @author Avishek Fetch user details from database
 *
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	JwtUserRepository jwtUserRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("avishek".equals(username)) {
			return new User("avishek", "$2a$10$JaNQLpuB0voHKtoPG1tTkuDiKfWEIgaXhLhjaKDGM2OXLjN48yGaa",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	public JwtUser registerJwtUser(AuthenticationRequest authenticationRequest) {
		JwtUser jwtUser = new JwtUser();
		jwtUser.setUsername(authenticationRequest.getUsername());
		jwtUser.setPassword(bcryptEncoder.encode(authenticationRequest.getPassword()));

		return jwtUserRepository.save(jwtUser);
	}
}
