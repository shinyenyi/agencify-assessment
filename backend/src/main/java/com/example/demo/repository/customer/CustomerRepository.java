package com.example.demo.repository.customer;

import java.util.List;

import com.example.demo.domain.customer.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
