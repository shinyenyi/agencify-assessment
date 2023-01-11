package com.example.demo.repository.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.domain.customer.Customer;

@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepositoryImpl customerRepository;

	@BeforeEach
	void init() {
//		set up data
	}

	@Test
	@DisplayName("It should return customers list with size of 41")
	void getAllCustomers() {
		List<Customer> list = customerRepository.getAllCustomers();
		assertNotNull(list);
		assertEquals(41, list.size());
	}

}
