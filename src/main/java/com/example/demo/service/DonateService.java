package com.example.demo.service;

import com.example.demo.dtos.DonateDto;

import com.example.demo.entity.Donate;

public interface DonateService {

	public DonateDto saveDonate(DonateDto dto);
    public Donate getDonateById(int id);
}
