package com.nagarro.ritesh.Application2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.ws.soap.server.endpoint.annotation.SoapActions;

import com.nagarro.ritesh.Application2.models.Transactions;

public interface PendingRepo  extends JpaRepository<Transactions, Long>{
	
	List<Transactions> findByAccountNumberAndStatus(String accountNumber, String status);

}
