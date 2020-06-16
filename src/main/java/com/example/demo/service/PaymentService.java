package com.example.demo.service;


import java.util.List;

import com.example.demo.dtos.PaymentDto;
import com.example.demo.dtos.PaymentResponseDto;

public interface PaymentService {
	public String savePayment(PaymentDto dto);
	
	public List<PaymentResponseDto>getAllPayment();
}
