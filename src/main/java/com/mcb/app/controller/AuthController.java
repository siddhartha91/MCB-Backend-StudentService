package com.mcb.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.app.exception.AuthException;
import com.mcb.app.jwt.config.JwtAuthTokenResponse;
import com.mcb.app.jwt.config.JwtTokenUtil;
import com.mcb.app.jwt.config.LoginRequest;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthController {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	JwtTokenUtil tokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public ResponseEntity<Object> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		UserDetails userDetails = null;
		try {
			userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		} catch (UsernameNotFoundException e) {
			log.error("Error : " + e.getMessage());
		}

		final String token = tokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtAuthTokenResponse(token));
	}

	private void authenticate(String username, String password) throws AuthException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new AuthException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new AuthException("INVALID_CREDENTIALS", e);
		}
	}

}
