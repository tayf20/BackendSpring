package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
import com.example.demo.enums.Role;

public interface UserRepository extends JpaRepository<User, Integer> {
	//@Query("SELECT u FROM user u WHERE email = :email AND password = :password")
	//User authenticate(String email, String password);
	/*@Query("SELECT u FROM user u WHERE email = :email AND password = :password")
	User authenticate(String email, String password);*/

	User findByEmail(String email);
	//@Query("SELECT u FROM user u WHERE email = :email AND password = :password ")
	User findByEmailAndPassword(String email,String password);
	
	public List<User>findAllByRole(Role role);
}
