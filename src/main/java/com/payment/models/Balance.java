package com.payment.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="balance")
public class Balance {
	
	@Id
    private String account;
    private float balance;
    private String status;
}
