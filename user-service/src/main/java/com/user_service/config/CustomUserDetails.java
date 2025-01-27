package com.user_service.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.user_service.entities.User;


//This is the class which implements UserDetails interface as it is already provided by spring security as we have to override the method which help spring security to know what is going on.

public class CustomUserDetails implements UserDetails {
	
	//taking the user details by adding the variable.
	private User user;
	
	//created the field/parameterized constructor so that we can get the data and set it to the User details functions.
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+user.getRoles());
		return Collections.singletonList(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	//By default is added as false just we have to make it true.
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//By default is added as false just we have to make it true.
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//By default is added as false just we have to make it true.
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//By default is added as false just we have to make it true.
	@Override
	public boolean isEnabled() {
		return true;
	}

}
