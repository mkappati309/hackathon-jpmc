package com.payment.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
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
	private String currency;
	private double amount;
	private Date valueDate;
	private String remittanceInfo;	
}
