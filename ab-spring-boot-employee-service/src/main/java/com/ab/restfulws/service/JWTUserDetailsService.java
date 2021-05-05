package com.ab.restfulws.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Avishek Fetch user details from database
 *
 */
@Service
public class JWTUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("avishek".equals(username)) {
			return new User("avishek", "$2a$10$JaNQLpuB0voHKtoPG1tTkuDiKfWEIgaXhLhjaKDGM2OXLjN48yGaa",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
