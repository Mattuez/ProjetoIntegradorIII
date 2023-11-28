package com.matheus.projetointegradoriii.api.controller;

import com.matheus.projetointegradoriii.api.assembler.customer.CustomerDTOAssembler;
import com.matheus.projetointegradoriii.api.assembler.customer.CustomerDTODisassembler;
import com.matheus.projetointegradoriii.api.model.customer.CustomerDTO;
import com.matheus.projetointegradoriii.api.model.customer.CustomerInputDTO;
import com.matheus.projetointegradoriii.domain.model.Customer;
import com.matheus.projetointegradoriii.domain.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    private CustomerDTOAssembler customerDTOAssembler;
    private CustomerDTODisassembler customerDTODisassembler;

    public CustomerController(CustomerService customerService, CustomerDTOAssembler customerDTOAssembler,
                              CustomerDTODisassembler customerDTODisassembler) {

        this.customerService = customerService;
        this.customerDTOAssembler = customerDTOAssembler;
        this.customerDTODisassembler = customerDTODisassembler;
    }

    @GetMapping
    public List<CustomerDTO> getAll() {

        return customerDTOAssembler.toDtoCollection(customerService.getAll());
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getById(@PathVariable("customerId") Long customerId) {

        return customerDTOAssembler.toDto(customerService.getCustomer(customerId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO add(@RequestBody @Valid CustomerInputDTO customerInput) {

        Customer customer = customerDTODisassembler.toEntityObject(customerInput);

        return customerDTOAssembler.toDto(customerService.insert(customer));
    }

    @PutMapping("/{customerId}")
    public CustomerDTO update(@PathVariable("customerId") Long customerId,
                              @RequestBody @Valid CustomerInputDTO customerInputDTO) {

        Customer customer = customerService.getCustomer(customerId);

        customerDTODisassembler.copyToEntityObject(customerInputDTO, customer);

        return customerDTOAssembler.toDto(customerService.insert(customer));
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);
    }
}
