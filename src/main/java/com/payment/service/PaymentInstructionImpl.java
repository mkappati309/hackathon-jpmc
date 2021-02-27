package com.payment.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dto.PaymentDTO;
import com.payment.exceptions.PaymentAlreadyExistsException;
import com.payment.exceptions.PaymentException;
import com.payment.models.Payment;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentInstructionImpl implements PaymentInstruction {

	private PaymentRepository paymentRepository;
	
	@Autowired
	public PaymentInstructionImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public PaymentDTO savePayment(PaymentDTO paymentDto) {

		//findById before save.
		Optional<Payment> paymentExists = this.paymentRepository.findByMessageId(paymentDto.getMessageId());
		if(paymentExists.isPresent())
			throw new PaymentAlreadyExistsException(paymentExists.get().getMessageId() + " Payment Already Exists.");
		
		//if the payment is 
		Payment payment = modelMapper.map(paymentDto, Payment.class);
		Payment savedPayment = this.paymentRepository.save(payment);
		PaymentDTO paymentDTO = modelMapper.map(savedPayment, PaymentDTO.class);
		return paymentDTO;
	}
}
