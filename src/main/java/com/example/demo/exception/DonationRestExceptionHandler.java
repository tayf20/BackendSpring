package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class DonationRestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DonationBusinessException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public DonationExceptionResponse handleNotFoundException(DonationBusinessException ex, WebRequest request)
			throws Exception {
		
		ex.printStackTrace();
		System.out.println("-----EnterpriseBusinessException-----");
		return new DonationExceptionResponse(new Date(), ex.getMessage(), "error");
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public DonationExceptionResponse handleAllException(Exception ex, WebRequest request) throws Exception {
	
		ex.printStackTrace();
		System.out.println("----Exception----");
		return new DonationExceptionResponse(new Date(), "Internal Exception", "500");

	}
}
