package com.example.demo.service;

import com.example.demo.dtos.DonateDto;

import com.example.demo.entity.Donate;

public interface DonateService {

	public void saveDonate(DonateDto dto);
    public Donate getDonateById(int id);
    public Donate getByEmail(String email);
}
