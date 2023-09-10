package com.acleda.crud.service;

import com.acleda.crud.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> findCustomer();
    Long deletCustomerById(Long id);
}
