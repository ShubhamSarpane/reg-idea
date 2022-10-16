package com.Ideation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Ideation.dao.UserRepository;
import com.Ideation.entity.employees;

public class UserDetailsServiceImpl implements UserDetailsService {
    
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// fetching user from Db
		
		employees employees =userRepository.getUserByUserName(username);
		
		if(employees == null) {
			throw new UsernameNotFoundException("Could not found user!!");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(employees);
		
		
		return customUserDetails;
	}

}
