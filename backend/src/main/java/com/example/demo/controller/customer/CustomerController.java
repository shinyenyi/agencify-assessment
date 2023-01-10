package com.example.demo.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.customer.CustomerInitialData;
import com.example.demo.service.customer.CustomerPhonenumberRequest;
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

	@PostMapping(path = "/phonenumbers")
	public ResponseEntity<String[]> getCustomerPhonenumbers(@RequestBody CustomerPhonenumberRequest request) {
		String[] phonenumbers = customerService.getCustomerPhonenumbers(request);

		return ResponseEntity.ok(phonenumbers);
	}

}
