package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
	public void saveDonate(DonateDto dto) {

		if(dto != null) {
			Donate d = AppModelMapper.mapDonate(dto);
			Donate donate = donateRepoo.save(d);
		}
 
	}

	

	
	


	@Override
	public Donate getDonateById(int id) {
		return donateRepoo.findByiddonate(id);
		
		
	}

	@Override
	public Donate getByEmail(String email) {
		return this.donateRepoo.findByDonatoremail(email);
	}

}
