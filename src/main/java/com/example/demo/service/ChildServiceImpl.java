package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ChildDto;
import com.example.demo.entity.Child;
import com.example.demo.entity.Donate;
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
		//return null;
//		if (entity != null && !entity.isEmpty()) {
//			ModelMapper modelMapper = new ModelMapper();
//			spocsList = modelMapper.map(entity, new TypeToken<List<EntitySpocPersonDto>>() {
//			}.getType());
//		}
	}

	@Override
	public void saveChild(ChildDto dto) {

		if(dto != null) {
			Child c = AppModelMapper.mapChild(dto);
			Child child = childRepo.save(c);
		}
		
	}
}
