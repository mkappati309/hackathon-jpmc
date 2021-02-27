package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.model.request.PaymentRequest;
import com.payment.model.response.PaymentResponse;
import com.payment.models.Balance;
import com.payment.repository.AccountBalanceRepository;

@Service
public class CreditCheckService {
	
	@Autowired
    private AccountBalanceRepository accountBalanceRepository;
    public PaymentResponse checkCredit(PaymentRequest payment){
        PaymentResponse response = new PaymentResponse();
        Balance balance = accountBalanceRepository.findByAccount(payment.getDebtorAccount());
        if(balance==null){
//            response.setTransactionId(payment.getTransactionId());
        	response.setTransactionId(payment.getMessageId());
            response.setStatus("Declined");
            response.setErrorMessage("Account not Found");
        }else if(balance.getStatus()=="inactive"){
//            response.setTransactionId(payment.getTransactionId());
        	response.setTransactionId(payment.getMessageId());
            response.setStatus("Declined");
            response.setErrorMessage("Account Closed");
        }else if(balance.getBalance()<payment.getAmount()){
//            response.setTransactionId(payment.getTransactionId());
        	response.setTransactionId(payment.getMessageId());
            response.setStatus("Declined");
            response.setErrorMessage("Insuficiente Balance");
        }else {
//            response.setTransactionId(payment.getTransactionId());
        	response.setTransactionId(payment.getMessageId());
            response.setStatus("Accepted");
            response.setErrorMessage("Proccessed Ok");
        }
        return response;
    }
}
