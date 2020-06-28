package com.example.demo.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.AppResultDto;
import com.example.demo.dtos.ChildDto;
import com.example.demo.dtos.ChilddonatorDto;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.DonateRepository;
import com.example.demo.service.ChildService;
import com.example.demo.service.ChilddonatorService;
import com.example.demo.service.DonateService;

@RestController
@RequestMapping("api")
public class ChilddonatorController {
	
	@Autowired
	private ChilddonatorService childdonatorService;


	@RequestMapping(value = "/childdonator", method = RequestMethod.POST)
	public AppResultDto createChilddonator(@Valid @RequestBody ChilddonatorDto childDto) {
		childdonatorService.saveChilddonator(childDto);
		return new AppResultDto();
	}
}
