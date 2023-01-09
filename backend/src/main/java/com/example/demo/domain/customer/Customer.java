package com.example.demo.domain.customer;

public class Customer {
	private Integer id;
	private String name;
	private String phone;

	public Customer(Integer id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhonenumber(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return id + name + phone;
	}
}
