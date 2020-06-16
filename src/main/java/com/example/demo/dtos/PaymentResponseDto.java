package com.example.demo.dtos;

public class PaymentResponseDto {

	private int paymnetId;
	private DonateDto donateDto;
	private int creditCardId;
	
	public PaymentResponseDto() {

	}
	
	public PaymentResponseDto(int paymnetId, DonateDto donateDto, int creditCardId) {
		this.paymnetId = paymnetId;
		this.donateDto = donateDto;
		this.creditCardId = creditCardId;
	}
	public int getPaymnetId() {
		return paymnetId;
	}
	public void setPaymnetId(int paymnetId) {
		this.paymnetId = paymnetId;
	}
	public DonateDto getDonateDto() {
		return donateDto;
	}
	public void setDonateDto(DonateDto donateDto) {
		this.donateDto = donateDto;
	}
	public int getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}
	
	
}
