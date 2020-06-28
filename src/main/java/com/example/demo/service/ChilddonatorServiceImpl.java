package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ChildDto;
import com.example.demo.dtos.ChilddonatorDto;
import com.example.demo.entity.Child;
import com.example.demo.entity.Childdonator;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ChilddonatorRepository;
import com.example.demo.utilities.AppModelMapper;
@Service
public class ChilddonatorServiceImpl implements ChilddonatorService{
	@Autowired
	ChilddonatorRepository childdonateRepo;
	@Override
	
	public void saveChilddonator(ChilddonatorDto dto) {
		
		if(dto != null) {
			Childdonator c = AppModelMapper.mapChilddonator(dto);
			childdonateRepo.save(c);
		
		}
	}


}
