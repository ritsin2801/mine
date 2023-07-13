package com.nagarro.ritesh.Application2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.ritesh.Application2.models.Transactions;

public interface FailureRepo extends JpaRepository<Transactions, Long> {
	
	List<Transactions> findByAccountNumberAndStatus(String accountNumber, String status);

	

}
