package com.example.demo.service.customer;

public class CustomerPhonenumberRequest {
	private String country;
	private Boolean state;

	public CustomerPhonenumberRequest(String country, Boolean state) {
		super();
		this.country = country;
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}
