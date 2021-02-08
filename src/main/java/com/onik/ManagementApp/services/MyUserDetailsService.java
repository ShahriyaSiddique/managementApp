package com.onik.ManagementApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.User;
import com.onik.ManagementApp.models.UserPrincipal;
import com.onik.ManagementApp.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username + "- this username Not found");
		}

		return new UserPrincipal(user);

	}

}
