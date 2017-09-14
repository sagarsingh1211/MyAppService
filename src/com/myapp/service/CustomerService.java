package com.myapp.service;

import java.util.List;

import com.myapp.model.Customer;

public interface CustomerService {
	public boolean addCustomer(Customer customer) throws Exception;
	public boolean updateCustomer(Customer customer)throws Exception;
	public boolean deleteCustomer(int id)throws Exception;

	public List<Customer> getCustomerList() throws Exception;

}

