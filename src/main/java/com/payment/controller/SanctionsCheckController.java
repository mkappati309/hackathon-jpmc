package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.request.PaymentRequest;
import com.payment.model.response.PaymentResponse;
import com.payment.service.SanctionCheckService;

@RestController
public class SanctionsCheckController {
	
	@Autowired
    private SanctionCheckService sanctionCheckService;
    
    @PostMapping(path = "paymentinstruction/api/sanctionsCheck", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentResponse sanctionsCheck(@RequestBody PaymentRequest paymentInstructionRequest) {
        return sanctionCheckService.sanctionCheck(paymentInstructionRequest);
    }
    
    @GetMapping(path = "paymentinstruction/api/sanctionsCheck/{transactionId}")
    public PaymentResponse getSanctionsCheck(@PathVariable long transactionId) {
    	return sanctionCheckService.getSanctionCheck(transactionId);
    }
}
	
