package com.hungrybell.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.hungrybell.app.dao.CustomerDao;
import com.hungrybell.app.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDaoImpl;
	
	@Override
	@Bean(name="customerServiceImpl")
	public boolean addCustomer(Customer customer) throws Exception {
		
		return customerDaoImpl.addCustomer(customer);
	}

	@Override
	public List<Customer> getCustomerList() throws Exception {
		// TODO Auto-generated method stub
		return customerDaoImpl.getCustomerList();
	}

	@Override
	public boolean updateCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		
		return customerDaoImpl.updateCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int id) throws Exception {
		// TODO Auto-generated method stub
		return customerDaoImpl.deleteCustomer(id);
	}

}
