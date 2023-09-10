package com.acleda.crud.controller;

import com.acleda.crud.base.Rest;
import com.acleda.crud.entity.Customer;
import com.acleda.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @PostMapping
    public Rest<?> saveCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.saveCustomer(customer);
        return Rest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Customer have been created!")
                .timestamp(timestamp)
                .data(customer1)
                .build();
    }
    @PutMapping
    public Rest<?> putCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.saveCustomer(customer);
        return Rest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Customer have been update!")
                .timestamp(timestamp)
                .data(customer1)
                .build();
    }

    @GetMapping
    public Rest<?> getCustomers(){
        List<Customer> customer = customerService.findCustomer();
        return Rest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Get customers successfully!")
                .timestamp(timestamp)
                .data(customer)
                .build();

    }
    @DeleteMapping("/{id}")
    public Rest<?> deleteCustomer(@PathVariable Long id){
        Long delete = customerService.deletCustomerById(id);
        return Rest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Customer have been deleted!")
                .timestamp(timestamp)
                .data(delete)
                .build();
    }

}
