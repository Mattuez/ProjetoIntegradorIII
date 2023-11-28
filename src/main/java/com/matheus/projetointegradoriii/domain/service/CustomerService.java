package com.matheus.projetointegradoriii.domain.service;

import com.matheus.projetointegradoriii.domain.exception.CustomerNotFoundException;
import com.matheus.projetointegradoriii.domain.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    Customer getCustomer(Long customerId);
    Customer insert(Customer customer);
    void delete(Long customerId);
}
