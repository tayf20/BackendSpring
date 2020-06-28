package com.example.demo.service;

import com.example.demo.dtos.ChildDto;
import com.example.demo.dtos.DonateDto;
import com.example.demo.entity.Child;

public interface ChildService {

	//public ChildDto getChildById(int id);
	public void saveChild(ChildDto dto);
	public Child getChildById(int id);
}
