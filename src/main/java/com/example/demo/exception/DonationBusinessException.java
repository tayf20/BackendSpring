package com.example.demo.exception;

public class DonationBusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DonationBusinessException(String msg) {
		super(msg);
	}
}
