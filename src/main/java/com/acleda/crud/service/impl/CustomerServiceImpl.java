package com.acleda.crud.service.impl;

import com.acleda.crud.entity.Customer;
import com.acleda.crud.repositorty.CustomerRepository;
import com.acleda.crud.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findCustomer() {
        return customerRepository.findAll();
    }

    @Transactional
    @Override
    public Long deletCustomerById(Long id) {
        return customerRepository.deleteByCustomerNum(id);
    }
}
