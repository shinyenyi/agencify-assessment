package com.example.demo.service.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.customer.Customer;
import com.example.demo.repository.customer.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	private String[] filterByCountry() {
		return null;
	}

	private String[] filterByState() {
		return null;
	}

	@Override
	public CustomerInitialData getInitialData() {
		List<Customer> customers = customerRepository.getAllCustomers();

		CustomerInitialData initialData = new CustomerInitialData(customers);

		return initialData;
	}

	@Override
	public String[] getCustomerPhonenumbers(CustomerPhonenumberRequest request) {
		List<Customer> customers = customerRepository.getAllCustomers();
		ArrayList<String> customerPhonenumbers = new ArrayList<String>();

		if (request.getState() == null && request.getCountry() == null) {

			for (Customer customer : customers) {
				customerPhonenumbers.add(customer.getPhone());
			}
			return customerPhonenumbers.toArray(new String[customerPhonenumbers.size()]);
		}

		return null;
	}
}
