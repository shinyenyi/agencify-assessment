package com.example.demo.service.customer;

import java.util.List;

import com.example.demo.domain.customer.Customer;

public class CustomerInitialData {
	private List<Customer> customers;

	public CustomerInitialData(List<Customer> customers) {
		super();
		this.customers = customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
