package com.payment.exceptions;

public class PaymentAlreadyExistsException extends RuntimeException {

	public PaymentAlreadyExistsException(String message) {
		super(message);
	}
}
