package com.example.demo.utilities;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dtos.ChildDto;
import com.example.demo.dtos.DonateDto;
import com.example.demo.dtos.PaymentDto;
import com.example.demo.dtos.PaymentResponseDto;
import com.example.demo.entity.Child;
import com.example.demo.entity.Donate;
import com.example.demo.entity.Payment;

public class AppModelMapper {
	public static Payment mapPayment(PaymentDto dto) {
		if(dto == null) {
			return null;
		}
		Payment p = new Payment();
		//p.setDonate(dto.get);
		p.setCreditcard(dto.getCreditcard());
		return p;
	}
	public static PaymentDto mapPaymentDto(Payment payment) {
		if(payment == null) {
			return null;
		}
		PaymentDto dto = new PaymentDto();
		dto.setIddonate(payment.getDonate().getIddonate());
		dto.setCreditcard(payment.getCreditcard());
		return dto;
	}
	
	
	public static Donate mapDonate(DonateDto dto) {
		if(dto == null) {
			return null;
		}
		Donate d = new Donate();
		d.setDonatoremail(dto.getDonatoremail());
		d.setDonatorname(dto.getDonatorname());
		d.setTotal(dto.getTotal());
		return d;
	}
	
	
	public static DonateDto mapDonateDto(Donate donate) {
		if(donate == null) {
			return null;
		}
		DonateDto dto = new DonateDto();
		dto.setDonatoremail(donate.getDonatoremail());
		dto.setDonatorname(donate.getDonatorname());
		dto.setTotal(donate.getTotal());
		List<Child> children =  donate.getChildren();
		List<Integer> idChildren = new ArrayList<>();
		for (Child child : children) {
			idChildren.add(child.getIdchild());
		}
		Integer[] ids = (Integer[])idChildren.toArray();
		dto.setIdchildren(ids);
		return dto;
	}
	
	public static Child mapChild(ChildDto dto) {
		if(dto == null) {
			return null;
		}
		Child c = new Child();
		c.setAdress(dto.getAdress());
		c.setDatenaissance(dto.getDatenaissance());
		c.setFirstname(dto.getFirstname());
		c.setImageUrl(dto.getImageUrl());
		c.setOld(dto.getOld());
		c.setSexe(dto.getSexe());
		c.setVille(dto.getVille());
		c.setDescription(dto.getDescription());
		return c;
	}
	
	public static ChildDto MapChildDto(Child ch) {
		if(ch == null) {
			return null;
		}
		ChildDto dto = new ChildDto();
		dto.setAdress(ch.getAdress());
		dto.setDatenaissance(ch.getDatenaissance());
		dto.setFirstname(ch.getFirstname());
		dto.setImageUrl(ch.getImageUrl());
		dto.setOld(ch.getOld());
		dto.setSexe(ch.getSexe());
		dto.setVille(ch.getVille());
		dto.setDescription(ch.getDescription());
		return dto;
	}
	
	public static PaymentResponseDto mapPaymentResponseDto(Payment pay) {
		if(pay == null) {
			return null;
		}
		PaymentResponseDto dto = new PaymentResponseDto();
		dto.setCreditCardId(pay.getCreditcard());
		dto.setPaymnetId(pay.getIdpayment());
		dto.setDonateDto(mapDonateDto(pay.getDonate()));
		return dto;
	}
	
	public static List<PaymentResponseDto> mapPaymentResponseDto(List<Payment> pay){
		List<PaymentResponseDto> custom = new ArrayList<>();
		for(Payment p: pay) {
			custom.add(mapPaymentResponseDto(p));
		}
		return custom;
		
	}
}
