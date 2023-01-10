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

	private Boolean filterByState(String phonenumber) {

		if (phonenumber.matches("\\(237\\)\\ ?[2368]\\d{7,8}$") || phonenumber.matches("\\(251\\)\\ ?[1-59]\\d{8}$")
				|| phonenumber.matches("\\(212\\)\\ ?[5-9]\\d{8}$") || phonenumber.matches("\\(258\\)\\ ?[28]\\d{7,8}$")
				|| phonenumber.matches("\\(256\\)\\ ?\\d{9}$")) {
			return true;
		}
		return false;
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

		if (request.getState() != null && request.getCountry() == null) {

			for (Customer customer : customers) {
				if (request.getState() && filterByState(customer.getPhone())) {
					customerPhonenumbers.add(customer.getPhone());
				}
				if (request.getState() == false && filterByState(customer.getPhone()) == false) {
					customerPhonenumbers.add(customer.getPhone());
				}
			}
			return customerPhonenumbers.toArray(new String[customerPhonenumbers.size()]);
		}

		if (request.getState() == null && request.getCountry() != null) {

			for (Customer customer : customers) {
				if (request.getCountry().equals(customer.getPhone().substring(0, 5))) {
					customerPhonenumbers.add(customer.getPhone());
				}

			}
			return customerPhonenumbers.toArray(new String[customerPhonenumbers.size()]);
		}

		return null;
	}
}
