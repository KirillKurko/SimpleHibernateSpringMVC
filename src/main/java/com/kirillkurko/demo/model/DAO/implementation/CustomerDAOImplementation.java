package com.kirillkurko.demo.model.DAO.implementation;

import java.util.List;

import com.kirillkurko.demo.model.DAO.interfaces.CustomerDAO;
import com.kirillkurko.demo.model.beans.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query;
		if (name != null && name.trim().length() > 0) {
			query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
			query.setParameter("name", "%" + name.toLowerCase() + "%");
		}
		else {
			query = session.createQuery("from Customer", Customer.class);
		}
		List<Customer> customers = query.getResultList();
		return customers;
	}
}






