package com.nagarro.ritesh.Application2.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nagarro.ritesh.Application2.models.*;

public interface SuccessRepo extends JpaRepository<Transactions, Long> {
	
	List<Transactions> findByAccountNumberAndStatus(String accountNumber, String status);

}
