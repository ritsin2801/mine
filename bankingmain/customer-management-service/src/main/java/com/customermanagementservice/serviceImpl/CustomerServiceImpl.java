package com.customermanagementservice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customermanagementservice.model.Customer;
import com.customermanagementservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private RestTemplate restTemplate;

	private static List<Customer> customers = new ArrayList<>();

	static {
		customers.add(new Customer(1, "Anirudh", "Dabral", 1, "Kanpur", 1234567890, 'M'));
		customers.add(new Customer(7, "Jennifer", "Johnson", 2, "New York", 324563422, 'F'));
		customers.add(new Customer(4, "Sam", "Curran", 3, "Sydney", 234456342, 'M'));
	}

	@Override
	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public Customer getCustomer(int customerId) {
		Customer customer = null;
		try {
			customer = customers.stream().filter(item -> item.getCustomerId() == customerId).findFirst().get();
		} catch (NoSuchElementException e) {
			customer = null;
		}
		return customer;
	}

	@Override
	@SuppressWarnings("unused")
	public boolean saveCustomer(Customer customer) {
		int customerId = customer.getCustomerId();
		Customer existingCustomer = null;
		try {
			existingCustomer = customers.stream().filter(item -> item.getCustomerId() == customerId).findFirst().get();
			return false;
		} catch (NoSuchElementException e) {
			customers.add(customer);
			return true;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		int customerId = customer.getCustomerId();
		Customer existingCustomer = null;
		try {
			existingCustomer = customers.stream().filter(item -> item.getCustomerId() == customerId).findFirst().get();
			customers.remove(existingCustomer);
			customers.add(customer);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Customer customer = null;
		try {
			customer = customers.stream().filter(item -> item.getCustomerId() == customerId).findFirst().get();
			customers.remove(customer);
			restTemplate
					.delete("http://account-management-service/account/deleteAccount/" + customer.getAccountNumber());
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
