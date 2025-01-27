package com.user_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.user_service.entities.User;
import com.user_service.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	// We have used the userRepository to get the data from the database and Autowired is used to inject the data.
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User userByEmail = userRepository.getUserByEmail(email);

		if (userByEmail == null) {

			throw new UsernameNotFoundException("User with email " + email + " not found.");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(userByEmail);
		return customUserDetails;
	}

}
