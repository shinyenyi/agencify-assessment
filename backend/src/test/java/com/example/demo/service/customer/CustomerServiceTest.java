package com.example.demo.service.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.domain.customer.Customer;
import com.example.demo.repository.customer.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	private Customer ian;
	private Customer dan;

	@BeforeEach
	void init() {
//		set up data
		ian = new Customer(1, "", "");
		dan = new Customer(2, "", "");
	}

	@Test
	@DisplayName("Should return list of customers of size 2")
	void getAllCustomers() {

		List<Customer> list = new ArrayList<>();
		list.add(dan);
		list.add(ian);

		when(customerRepository.getAllCustomers()).thenReturn(list);

		CustomerInitialData initialdata = customerService.getInitialData();

		List<Customer> customers = initialdata.getCustomers();

		assertEquals(2, customers.size());
		assertNotNull(customers);
	}

	@Test
	@DisplayName("Should return array of phonenumbers")
	void getAllPhonenumbers() {

		List<Customer> list = new ArrayList<>();
		list.add(dan);
		list.add(ian);

		when(customerRepository.getAllCustomers()).thenReturn(list);

		CustomerPhonenumberRequest request = new CustomerPhonenumberRequest(null, null);

		String[] phonenumbers = customerService.getCustomerPhonenumbers(request);

		assertEquals(2, phonenumbers.length);
		assertNotNull(phonenumbers);
	}

}
