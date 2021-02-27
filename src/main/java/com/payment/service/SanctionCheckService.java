package com.payment.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payment.model.request.PaymentRequest;
import com.payment.model.response.PaymentResponse;

@Service
public class SanctionCheckService {

	public String[] sanctionsArray = { "Creditor123456", "Nanda", "ABC CITY STATE ZIPCODE" };

	public PaymentResponse sanctionCheck(PaymentRequest request) {
		PaymentResponse paymentInstructionResponse = new PaymentResponse();
		List<String> sanctionslist = Arrays.asList(sanctionsArray);
		if (sanctionslist.contains(request.getCreditorName()) || sanctionslist.contains(request.getCreditorAddress())
				|| sanctionslist.contains(request.getCreditorAccount())) {
			paymentInstructionResponse.setStatus("Declined");
			paymentInstructionResponse.setTransactionId(request.getMessageId());
			paymentInstructionResponse.setErrorMessage("Compliance hit");
		} else {
			paymentInstructionResponse.setStatus("Approved");
			paymentInstructionResponse.setTransactionId(request.getMessageId());
			paymentInstructionResponse.setErrorMessage("");
		}
		return paymentInstructionResponse;
	}
	
	public PaymentResponse getSanctionCheck(long transactionId) {
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setTransactionId(transactionId);
		paymentResponse.setStatus("Active");
		paymentResponse.setErrorMessage("");
		return paymentResponse;
	}
}
