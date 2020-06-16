package com.example.demo.dtos;

public class PaymentDto {
  
	private int creditcard ;
	
	private int iddonate;

	public int getCreditcard() {
		return creditcard;
	}
	

	public PaymentDto() {
		super();
	}
	


	public PaymentDto(int creditcard, int iddonate) {
		super();
		this.creditcard = creditcard;
		this.iddonate = iddonate;
	}


	public void setCreditcard(int creditcard) {
		this.creditcard = creditcard;
	}

	public int getIddonate() {
		return iddonate;
	}

	public void setIddonate(int iddonate) {
		this.iddonate = iddonate;
	}
	
}
