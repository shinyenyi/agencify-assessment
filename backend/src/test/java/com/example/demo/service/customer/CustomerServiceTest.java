package com.example.demo.service.customer;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.demo.repository.customer.CustomerRepository;

public class CustomerServiceTest {

	@InjectMocks
	private CustomerService customerService;

	@Mock
	private CustomerRepository customerRepository;

}
