package com.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.models.Balance;

@Repository
public interface AccountBalanceRepository extends CrudRepository<Balance, String> {

	Balance findByAccount(String debtorAccount);

}
