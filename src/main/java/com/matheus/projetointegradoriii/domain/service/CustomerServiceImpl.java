package com.matheus.projetointegradoriii.domain.service;

import com.matheus.projetointegradoriii.domain.exception.CustomerNotFoundException;
import com.matheus.projetointegradoriii.domain.exception.EntityBeingUsedException;
import com.matheus.projetointegradoriii.domain.exception.UniqueResourceBeingUsed;
import com.matheus.projetointegradoriii.domain.model.Customer;
import com.matheus.projetointegradoriii.domain.repository.CustomerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    @Override
    @Transactional
    public Customer insert(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueResourceBeingUsed("Email", customer.getEmail());
        }
    }

    @Override
    @Transactional
    public void delete(Long customerId) {

        Customer customer = getCustomer(customerId);

        try {
            customerRepository.delete(customer);
        } catch (DataIntegrityViolationException e) {
            throw new EntityBeingUsedException(customer.getClass().getSimpleName(), customerId);
        }
    }
}
