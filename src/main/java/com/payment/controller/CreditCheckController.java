package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.request.PaymentRequest;
import com.payment.model.response.PaymentResponse;
import com.payment.service.CreditCheckService;

@RestController
@RequestMapping("/accounts")
public class CreditCheckController {

	@Autowired
	private CreditCheckService creditCheckService;

	@GetMapping("/check")
	public PaymentResponse checkBalance(@RequestBody PaymentRequest payment) {
		return creditCheckService.checkCredit(payment);
	}
}
