package com.payment.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.payment.dto.PaymentDTO;
import com.payment.exceptions.PaymentException;
import com.payment.model.request.PaymentRequest;
import com.payment.model.response.PaymentResponse;
import com.payment.model.response.SanctionsList;
import com.payment.service.PaymentInstruction;
import com.payment.service.ValidationService;

@RestController
@RequestMapping("/hackathon")
public class PaymentRequestController {

	private PaymentInstruction paymentInstructionService;
	private ValidationService validationService;
	private RestTemplate restTemplate;

	@Autowired
	public PaymentRequestController(PaymentInstruction paymentInstructionService, ValidationService validationService) {
		this.paymentInstructionService = paymentInstructionService;
		this.validationService = validationService;
	}

	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping(path = "/instructions", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> paymentValidation(@Valid @RequestBody PaymentRequest paymentRequest,
			BindingResult bindingResult) {

		// Performing the validation on the JSON input object
		ResponseEntity<?> validateRequest = this.validationService.validateRequest(bindingResult);
		if (validateRequest != null)
			return validateRequest;

		try {
			// Converting the request to DTO to send it to the service layer
			PaymentDTO paymentDto = this.modelMapper.map(paymentRequest, PaymentDTO.class);

			// Send the converted DTO back to service layer
			PaymentDTO savedPaymentDto = this.paymentInstructionService.savePayment(paymentDto);

//			PaymentResponse savedPaymentResponse = modelMapper.map(savedPaymentDto, PaymentResponse.class);
			PaymentResponse savedPaymentResponse = new PaymentResponse();
			savedPaymentResponse.setTransactionId(savedPaymentDto.getMessageId());
			savedPaymentResponse.setStatus((HttpStatus.CREATED).toString());
			savedPaymentResponse.setErrorMessage("");
			return new ResponseEntity<PaymentResponse>(savedPaymentResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new PaymentException(e.getMessage());
		}
	}

	@GetMapping(path = "/instruction-sanctions/{transactionId}")
	public void paymentSanctionsCheck(@PathVariable long transactionId) {
		ResponseEntity<SanctionsList> responseFromSanctions = restTemplate
				.getForEntity("http://localhost:8080/paymentinstruction/api/sanctionsCheck/{transactionId}", SanctionsList.class);
		System.out.println(responseFromSanctions);
	}
}
