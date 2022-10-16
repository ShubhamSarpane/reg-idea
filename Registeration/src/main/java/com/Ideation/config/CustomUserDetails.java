package com.Ideation.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Ideation.entity.employees;

public class CustomUserDetails implements UserDetails{
    
	
    private employees employees;
	
	
	public CustomUserDetails(employees employees) {
		super();
		this.employees = employees;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority simpleGrantedAuthority =	new SimpleGrantedAuthority(employees.getRole());
		
	return List.of(simpleGrantedAuthority);
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return employees.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return employees.getEmail_id();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//efcwe
	
	
	public int getEmployeeid() {
		// TODO Auto-generated method stub
		return employees.getEmployeeid();
	}

}

