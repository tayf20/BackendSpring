package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.AuthenticateRequest;
import com.example.demo.dtos.AuthenticateResponse;
import com.example.demo.entity.User;
import com.example.demo.enums.Role;
import com.example.demo.exception.DonationBusinessException;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepoo;

	public User saveUser(User user) {
		user.setRole(Role.USER);
		return userRepoo.save(user);
	}

	public User fetchUserByEmail(String email) {
		return userRepoo.findByEmail(email);

	}

	public User fetchUserByEmailAndPassword(String email, String password) {
		return userRepoo.findByEmailAndPassword(email, password);

	}

	@Override
	public AuthenticateResponse validateUser(AuthenticateRequest request) {
		User user = userRepoo.findByEmail(request.getEmail());
		if(user != null) {
			if (user.getEmail().equals(request.getEmail()) && user.getPassword().equals(request.getPassword())) {
				return new AuthenticateResponse(user.getIduser(), user.getEmail(),user.getRole().toString());
			}else {
				throw new DonationBusinessException("Wrong Credentials");
			}
		}
		throw new DonationBusinessException("Invalid User");
	}
}
