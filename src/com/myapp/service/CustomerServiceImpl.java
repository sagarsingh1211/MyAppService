package com.myapp.service;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.myapp.dao.CustomerDao;
import com.myapp.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDaoImpl;
	
	@Override
	@Bean(name="customerServiceImpl")
	@Produces("application/json")
	public boolean addCustomer(Customer customer) throws Exception {
		
		return customerDaoImpl.addCustomer(customer);
	}

	@Override
	@Produces("application/json")
	public List<Customer> getCustomerList() throws Exception {
		// TODO Auto-generated method stub
		return customerDaoImpl.getCustomerList();
	}

	@Override
	@Produces("application/json")
	public boolean updateCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		
		return customerDaoImpl.updateCustomer(customer);
	}

	@Override
	@Produces("application/json")
	public boolean deleteCustomer(int id) throws Exception {
		// TODO Auto-generated method stub
		return customerDaoImpl.deleteCustomer(id);
	}

}
