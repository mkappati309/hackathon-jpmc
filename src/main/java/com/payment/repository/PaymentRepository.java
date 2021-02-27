package com.payment.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.models.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{

	Optional<Payment> findByMessageId(long messageId);

}
