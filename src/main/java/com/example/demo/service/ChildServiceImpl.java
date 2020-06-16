package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ChildDto;
import com.example.demo.entity.Child;
import com.example.demo.repository.ChildRepository;
import com.example.demo.utilities.AppModelMapper;

@Service
public class ChildServiceImpl implements ChildService {


	@Autowired
	ChildRepository childRepo;
	
	//ModelMapper // pom xml
	
	@Override
	public Child getChildById(int id) {
		return childRepo.findByidchild(id);
		
	}
}
