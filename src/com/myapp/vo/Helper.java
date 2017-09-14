package com.myapp.vo;

import com.myapp.model.Customer;

public class Helper {

	public static Customer customerFromCustomerVo(CustomerVo customerVo) {
		Customer customer = new Customer();
		customer.setAddress(customerVo.getAddress());
		customer.setMailId(customerVo.getMailId());
		customer.setName(customerVo.getName());
		customer.setId(customerVo.getId());

		return customer;
	}

	public static CustomerVo customerVOFromCustomer(Customer customer) {
		CustomerVo customerVo = new CustomerVo();
		customerVo.setAddress(customer.getAddress());
		customerVo.setMailId(customer.getMailId());
		customerVo.setName(customer.getName());
		customerVo.setId(customer.getId());

		return customerVo;
	}
}
