package com.dcos.configuration;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dcos.model.Users;

@Service
public class BYSUserDetailServices implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Users user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("not found"+email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthorities("ROLE_ADMIN"));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}
}