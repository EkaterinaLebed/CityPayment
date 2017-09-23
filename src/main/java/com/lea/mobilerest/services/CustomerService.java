package com.lea.mobilerest.services;


import com.lea.mobilerest.model.entities.Customer;

import java.util.List;

public interface CustomerService {
    public Customer getCustomer(int id);
    public List<Customer> getAllCustomers();
}
