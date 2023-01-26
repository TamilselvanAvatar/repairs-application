package com.repairs.dao;

import java.text.ParseException;

import com.repairs.model.CustomerModel;

public interface CustomerDAO {

	public boolean customerInsert(CustomerModel cm) throws ParseException;

	public void customerRemove(CustomerModel cm);

	public CustomerModel customerRetrival(String custName, String custPhone) throws ParseException;

	public boolean customerUpdate(CustomerModel cm);

}
