package com.payment.model.request;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	@Size(min=1, max=35, message = "{paymentRequest.messageId.Size}")
	private String transactionId;
	private long messageId;
	private String endToEndId;
	private String debtorAccount;
	private String debtorName;
	private String debtorAddress;
	private String creditorAccount;
	private String creditorName;
	private String creditorAddress;
	private String debtorAgentIdentifier;
	private String creditorAgentIdentifier;
	@Pattern(regexp="", message="{paymentRequest.currency.Currency}")
	private String currency;
	@DecimalMin(value="0.0")
	private double amount;
	@DateTimeFormat(pattern="dd-MM-yyyy", iso=ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date valueDate;
	private String remittanceInfo;
}
