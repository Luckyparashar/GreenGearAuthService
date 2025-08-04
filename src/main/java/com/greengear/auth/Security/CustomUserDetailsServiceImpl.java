package com.greengear.auth.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greengear.auth.Entities.User;
import com.greengear.auth.Repository.UserReposipory;

import lombok.AllArgsConstructor;



@Service //spring bean containing B.L
@Transactional
@AllArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	//depcy
	private final UserReposipory userReposipory;

	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		// invoke dao's method
		User user = userReposipory.findByEmail(email)
				.orElseThrow(() ->
				new UsernameNotFoundException("Invalid email !!!!"));
		return user;
	}

}
