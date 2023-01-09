package com.example.demo.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.customer.CustomerInitialData;
import com.example.demo.service.customer.CustomerService;

@RestController
@RequestMapping(path = "/backend")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/all")
	public ResponseEntity<CustomerInitialData> getCustomerInitialData() {
		CustomerInitialData initialData = customerService.getInitialData();

		return ResponseEntity.ok(initialData);
	}

}
