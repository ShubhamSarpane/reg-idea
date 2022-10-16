package com.Ideation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Ideation.entity.employees;

public interface UserRepository extends JpaRepository<employees, Integer> {

	@Query("select u from employees u where u.email_id= :email_id")
	public employees getUserByUserName(@Param("email_id") String email);
}
	
	
	