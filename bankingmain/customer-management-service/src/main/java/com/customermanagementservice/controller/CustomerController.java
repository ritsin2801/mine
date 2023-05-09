package com.customermanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customermanagementservice.model.Customer;
import com.customermanagementservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/getCustomer/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		return customerService.getCustomer(customerId);
	}

	@GetMapping("/getCustomers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@PostMapping("/addCustomer")
	public boolean addCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@PutMapping("/updateCustomer")
	public boolean updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/deleteCustomer/{customerId}")
	public boolean deleteCustomer(@PathVariable("customerId") int customerId) {
		return customerService.deleteCustomer(customerId);
	}

}
