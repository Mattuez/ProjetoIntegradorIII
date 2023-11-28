package com.matheus.projetointegradoriii.domain.repository;

import com.matheus.projetointegradoriii.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
