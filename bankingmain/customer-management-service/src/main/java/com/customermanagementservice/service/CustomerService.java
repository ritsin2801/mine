package com.customermanagementservice.service;

import java.util.List;

import com.customermanagementservice.model.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer getCustomer(int customerId);
	public boolean saveCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(Customer customer);
}
