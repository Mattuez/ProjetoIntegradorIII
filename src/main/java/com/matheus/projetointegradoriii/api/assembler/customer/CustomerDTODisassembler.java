package com.matheus.projetointegradoriii.api.assembler.customer;

import com.matheus.projetointegradoriii.api.model.customer.CustomerInputDTO;
import com.matheus.projetointegradoriii.domain.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTODisassembler {

    private ModelMapper modelMapper;

    public CustomerDTODisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Customer toEntityObject(CustomerInputDTO customerInputDTO) {
        return modelMapper.map(customerInputDTO, Customer.class);
    }

    public void copyToEntityObject(CustomerInputDTO source, Customer destination) {
        modelMapper.map(source, destination);
    }
}
