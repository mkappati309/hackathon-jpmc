package com.payment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(PaymentException.class)
	public final ResponseEntity<PaymentCustomExceptionResponse> handlePaymentException(PaymentException paymentEx, WebRequest webRequest){
		PaymentCustomExceptionResponse paymentCustomExceptionResponse = new PaymentCustomExceptionResponse(paymentEx.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<PaymentCustomExceptionResponse>(paymentCustomExceptionResponse, HttpStatus.CONFLICT);
	}
	
}
