package com.example.demo.controller.customer;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.domain.customer.Customer;
import com.example.demo.service.customer.CustomerInitialData;
import com.example.demo.service.customer.CustomerPhonenumberRequest;
import com.example.demo.service.customer.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class CustomerControllerTest {

	@MockBean
	private CustomerServiceImpl customerService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private Customer ian;
	private Customer dan;

	@BeforeEach
	void init() {
//		set up data
		ian = new Customer(1, "12345", "12345");
		dan = new Customer(2, "12345", "12345");
	}

	@Test
	@DisplayName("It should return all customers")
	void getAllCustomers() throws Exception {
		List<Customer> list = new ArrayList<>();
		list.add(dan);

		CustomerInitialData initialdata = new CustomerInitialData(list);

		when(customerService.getInitialData()).thenReturn(initialdata);

		this.mockMvc.perform(get("/backend/all")).andExpect(status().isOk())
				.andExpectAll(jsonPath("$.size()", is(list.size())));
	}

	@Test
	@DisplayName("It should return all phonenumbers")
	void getAllPhonenumbers() throws JsonProcessingException, Exception {
		List<String> list = new ArrayList<>();
		list.add(dan.getPhone());
		list.add(ian.getPhone());

		CustomerPhonenumberRequest request = new CustomerPhonenumberRequest(null, null);

		when(customerService.getCustomerPhonenumbers(request)).thenReturn(list.toArray(new String[list.size()]));

		this.mockMvc
				.perform(put("/backend/phonenumbers").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk()).andExpect(jsonPath("$", is(list.toArray(new String[list.size()]))));
	}
}
