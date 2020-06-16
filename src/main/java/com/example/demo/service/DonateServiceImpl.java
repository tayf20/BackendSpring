package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ChildDto;
import com.example.demo.dtos.DonateDto;
import com.example.demo.entity.Child;
import com.example.demo.entity.Donate;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.DonateRepository;
import com.example.demo.utilities.AppModelMapper;

@Service
public class DonateServiceImpl implements DonateService {
	@Autowired
	DonateRepository donateRepoo;
	
	@Autowired
	ChildService childService;
	
	@Override
	public DonateDto saveDonate(DonateDto dto) {
		Integer[] childrenIds = dto.getIdchildren();
		List<Child> children = new ArrayList<>();
		for (int childId : childrenIds) {
			children.add(childService.getChildById(childId));
		}
		Donate d = AppModelMapper.mapDonate(dto);
		d.setChildren(children);
		Donate donate = donateRepoo.save(d);
		
		return AppModelMapper.mapDonateDto(donate);
		 
	}

	

	
	


	@Override
	public Donate getDonateById(int id) {
		return donateRepoo.findByiddonate(id);
		
		
	}

}
