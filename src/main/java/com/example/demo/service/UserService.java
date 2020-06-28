package com.example.demo.service;

import com.example.demo.dtos.AuthenticateRequest;
import com.example.demo.dtos.AuthenticateResponse;

public interface UserService {
	public AuthenticateResponse validateUser(AuthenticateRequest request);
}
