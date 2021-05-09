package com.ab.restfulws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.restfulws.model.AuthenticationRequest;
import com.ab.restfulws.model.AuthenticationResponse;
import com.ab.restfulws.service.JwtUserDetailsService;
import com.ab.restfulws.util.JwtTokenUtil;

/**
 * @author Avishek Generates JWT token from AuthenticationRequest if valid
 *
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception(e);
		} catch (BadCredentialsException e) {
			throw new Exception(e);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerJwtUser(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		return ResponseEntity.ok(userDetailsService.registerJwtUser(authenticationRequest));
	}

}
