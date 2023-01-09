package com.example.demo.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.customer.Customer;
import com.example.demo.repository.customer.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerInitialData getInitialData() {
		List<Customer> customers = customerRepository.getAllCustomers();

		CustomerInitialData initialData = new CustomerInitialData(customers);

		return initialData;
	}
}
