package com.repairs.model;

public class CustomerModel {

	private String customerName;
	private String customerLocation;
	private String customerPhone;
	private String customerGender;


	public CustomerModel() {
		super();
		this.customerGender = "notselected";
	}

	public CustomerModel(String customerName, String customerLocation, String customerPhone, String customerGender) {
		super();
		this.customerName = customerName;
		this.customerLocation = customerLocation;
		this.customerPhone = customerPhone;
		this.customerGender = customerGender;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLocation() {
		return customerLocation;
	}

	public void setCustomerLocation(String customerLocation) {
		this.customerLocation = customerLocation;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

}
