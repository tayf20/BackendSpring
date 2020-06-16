package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.enums.Role;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepoo;
  public User saveUser(User user) {
	  user.setRole(Role.USER);
	  return userRepoo.save(user);
  }
  public User fetchUserByEmail(String email) {
	return userRepoo.findByEmail(email);
	  
  }
  public User fetchUserByEmailAndPassword(String email,String password) {
		return userRepoo.findByEmailAndPassword(email, password);
		  
	  }
}
