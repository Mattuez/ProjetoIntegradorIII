package com.matheus.projetointegradoriii.api.assembler.customer;

import com.matheus.projetointegradoriii.api.model.customer.CustomerDTO;
import com.matheus.projetointegradoriii.domain.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDTOAssembler {

    private ModelMapper modelMapper;

    public CustomerDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CustomerDTO toDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> toDtoCollection(List<Customer> customers) {
        return customers.stream()
                .map(customer -> toDto(customer))
                .toList();
    }
}
