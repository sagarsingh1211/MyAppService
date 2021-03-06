package com.myapp.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.model.Customer;
import com.myapp.service.CustomerService;
import com.myapp.vo.CustomerVo;
import com.myapp.vo.Helper;

@Controller
public class AddToCartController {

	@Autowired
	CustomerService customerServiceImpl;

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	@ResponseBody
	public Status test(@RequestBody CustomerVo customerVo) {
		Status status = new Status();
		try {
			Customer customer=Helper.customerFromCustomerVo(customerVo);
			customerServiceImpl.addCustomer(customer);
			status.setMessageCode(1);
			status.setMessage("Added");
			
		} catch (Exception e) {
			e.printStackTrace();
			status.setMessageCode(0);
			status.setMessage(e.getMessage());
		}

		return status;
	}

	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
	@ResponseBody
	public List<Customer> get() {
		List<Customer> list = null;
		try {
			list = customerServiceImpl.getCustomerList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	@ResponseBody
	public Status updateCustomer(@RequestBody Customer customerVo) {
		Status status = new Status();
		try {
//			Customer customer=Helper.customerFromCustomerVo(customerVo);
			customerServiceImpl.updateCustomer(customerVo);
			status.setMessageCode(1);
			status.setMessage("Updated");
			
		} catch (Exception e) {
			e.printStackTrace();
			status.setMessageCode(0);
			status.setMessage(e.getMessage());
		}

		return status;
	}
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Status deleteCustomer(@PathVariable("id" )int id) {
		Status status = new Status();
		try {
			boolean result=customerServiceImpl.deleteCustomer(id);
			if(result){
				status.setMessageCode(1);
				status.setMessage("Deleted");
			}else{
				status.setMessageCode(0);
				status.setMessage("Not Deleted");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			status.setMessageCode(0);
			status.setMessage(e.getMessage());
		}

		return status;
	}

}
	

