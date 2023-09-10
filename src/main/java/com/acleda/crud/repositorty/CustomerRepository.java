package com.acleda.crud.repositorty;

import com.acleda.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long> {

    Long deleteByCustomerNum(Long id);

}
