package com.payment.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Payment_Request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "messageId")
	private long messageId;
	@Column(name = "endToEndId")
	private String endToEndId;
	@Column(name = "debtorAccount")
	private String debtorAccount;
	@Column(name = "debtorName")
	private String debtorName;
	@Column(name = "debtorAddress")
	private String debtorAddress;
	@Column(name = "creditorAccount")
	private String creditorAccount;
	@Column(name = "credtorName")
	private String creditorName;
	@Column(name = "creditorAddress")
	private String creditorAddress;
	@Column(name = "debtorAgentIdentifier")
	private String debtorAgentIdentifier;
	@Column(name = "creditorAgentIdentifier")
	private String creditorAgentIdentifier;
	@Column(name = "currency")
	private String currency;
	@Column(name = "amount")
	private double amount;
	@Column(name = "valueDate")
	private Date valueDate;
	@Column(name = "remittanceInfo")
	private String remittanceInfo;
}
