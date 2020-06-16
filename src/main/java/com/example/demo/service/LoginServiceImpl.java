/*package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.LoginRepo;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepo repo;
	@Override
	public User checkLogin(User dto) {
		User regDto = null;
		if(dto == null) {
			return null;
		}else //{
		//	User reg = repo.findByUserNameAndUserPassword(dto.getUserName(), dto.getUserPassword());
			//if(reg != null) {
				/*regDto = AuthModelMapper.mapRegistrationDto(reg);
			}
		}
		return regDto;
	}
}
*/