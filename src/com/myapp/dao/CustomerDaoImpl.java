package com.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.myapp.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	static List<Customer> customerList = new ArrayList<Customer>();

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Bean(name = "customerDaoImpl")
	public boolean addCustomer(Customer customer) throws Exception {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();

		session.close();

		return true;
	}

	@Override
	public List<Customer> getCustomerList() throws Exception {
		Session session = sessionFactory.openSession();
		Query qry = session.createQuery("from Customer ");
		List<Customer> customerList = qry.list();
		return customerList;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws Exception {

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		session.saveOrUpdate(customer);
		t.commit();
		session.close();
		return false;
	}

	@Override
	public boolean deleteCustomer(int id) throws Exception {
		Session session = sessionFactory.openSession();
		Query qry = session.createQuery("delete from Customer where id = " + id);

		int l = qry.executeUpdate();
		if (l > 0) {
			return true;
		} else {
			return false;
		}
	}

}
