package com.nagarro.ritesh.Application2.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.nagarro.ritesh.Application2.models.*;

@FeignClient(name = "Success", url = "http://localhost:8081/backendserver1/success/")
public interface FeignInterface  {

	@GetMapping("{accountnumber}")
	List<Transactions> getSuccessTransactions(@PathVariable String accountnumber);
	
}
