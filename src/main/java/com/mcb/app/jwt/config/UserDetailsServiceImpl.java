package com.mcb.app.jwt.config;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) {

		if (username.equals("mcb")) {
			return new User("mcb", "$2a$10$sjIoQd6JRN/aUYdOkPiitOSU8Vy1rMwlVc.tYVsnqNZPDvgWV6GPK", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("username : " + username + " not found!");
		}
	}

}
