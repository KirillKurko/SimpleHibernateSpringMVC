package com.kirillkurko.demo.model.DAO.interfaces;

import java.util.List;

import com.kirillkurko.demo.model.beans.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);

	List<Customer> searchCustomers(String name);
}
