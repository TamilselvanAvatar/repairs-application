package com.repairs.service;

import java.text.ParseException;
import org.springframework.stereotype.Service;

import com.repairs.dao.*;
import com.repairs.model.CustomerModel;

@Service
public class CustomerService {

	private CustomerDAO custDAO = new CustomerDAOImp();

	public boolean insertCustomerService(CustomerModel cm) throws ParseException {
		return custDAO.customerInsert(cm);
	}

	public CustomerModel retrivalCustomerService(String cN, String cP) throws ParseException {
		return custDAO.customerRetrival(cN, cP);
	}

	public boolean updateCustomerService(CustomerModel cm) throws ParseException {
		return custDAO.customerUpdate(cm);
	}

	public void deleteCustomerService(CustomerModel cm) throws ParseException {
		custDAO.customerRemove(cm);
	}

}
