package com.payment.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanctionsList {

	private long transactionId;
	private String status;
	private String errorMessage;
	
}
