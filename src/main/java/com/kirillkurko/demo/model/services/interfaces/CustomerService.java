package com.kirillkurko.demo.model.services.interfaces;

import com.kirillkurko.demo.model.beans.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String name);
}
