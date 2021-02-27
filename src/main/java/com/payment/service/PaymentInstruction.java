package com.payment.service;

import com.payment.dto.PaymentDTO;

public interface PaymentInstruction {

	public PaymentDTO savePayment(PaymentDTO paymentDto);
}
