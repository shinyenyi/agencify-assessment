package com.example.demo.repository.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.customer.Customer;

@Service
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public List<Customer> getAllCustomers() {
		List<Customer> customers = jdbcTemplate.query("SELECT*FROM customer",
				(resultSet, rowNum) -> new Customer(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getString("phone")));

		return customers;
	}

}
