package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.PaymentDto;
import com.example.demo.dtos.PaymentResponseDto;
import com.example.demo.entity.Child;
import com.example.demo.entity.Donate;
import com.example.demo.entity.Payment;
import com.example.demo.repository.DonateRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.utilities.AppModelMapper;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepoo;
	
	@Autowired
	DonateService donateService;
	
	
	@Override
	public String savePayment(PaymentDto dto) {
		//Payment payment = donateService.getChildById(dto.getIdchild());
		
		Donate donate=donateService.getDonateById(dto.getIddonate());
		String statusMsg = "";
		
		Payment p = new Payment();
		p.setCreditcard(dto.getCreditcard());
		p.setDonate(donate);
		
		Payment payment = paymentRepoo.save(p);
		if(payment == null) {
			statusMsg = "Not Saved";
		}else {
			statusMsg = "Saved";
		}
		
		return statusMsg;
	}


	@Override
	public List<PaymentResponseDto> getAllPayment() {
		List<Payment> pay = paymentRepoo.findAll();
		List<PaymentResponseDto> dtoList = null;
		if(pay != null) {
			dtoList = AppModelMapper.mapPaymentResponseDto(pay); 
		}
		return dtoList;
	}

}
