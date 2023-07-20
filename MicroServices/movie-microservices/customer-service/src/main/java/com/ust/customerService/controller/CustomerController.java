package com.ust.customerService.controller;

import com.ust.customerService.domain.Customer;
import com.ust.customerService.dto.CustomerDto;
import com.ust.customerService.dto.LoginDto;
import com.ust.customerService.execption.CustomerAlreadyExistsException;
import com.ust.customerService.execption.CustomerNotFoundException;
import com.ust.customerService.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable int id){
        final var customer = customerService.getById(id);
        if(customer.isEmpty()){
            logger.warn("Customer not found");
            throw new CustomerNotFoundException(
                    String.format("Customer with id %d does not exists",id),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        logger.info("Customer: "+EntityToDto(customer.get()).toString());
        return ResponseEntity.status(HttpStatus.OK).body(EntityToDto(customer.get()));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String email){
        final var customer = customerService.getByEmail(email);
        if(customer.isEmpty()){
            logger.warn("Customer not found");
            throw new CustomerNotFoundException(
                    String.format("Customer with email: %s does not exists",email),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        logger.info("Customer: "+EntityToDto(customer.get()).toString());
        return ResponseEntity.status(HttpStatus.OK).body(EntityToDto(customer.get()));
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> saveCustomer(@Valid @RequestBody CustomerDto customerDto){
        final var item  = customerService.getByIdOrEmail(customerDto.id(), customerDto.email());
        if(item.isPresent()){
            logger.warn("Customer already exists");
            throw new CustomerAlreadyExistsException(
                    "Customer already exists",
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        logger.info("Customer: "+customerDto.toString());
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id/{id}").buildAndExpand(customerDto.id()).toUri()
        ).body(EntityToDto(customerService.create(DtoToEntity(customerDto))));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerDto> login(@Valid @RequestBody LoginDto loginDto){
        final var customer = customerService.getByEmailAndPassword(loginDto.email(),loginDto.password());
        if(customer.isEmpty()){
            throw new CustomerNotFoundException(
                    "Login Credentials Invalid",
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(EntityToDto(customer.get()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,@PathVariable int id){
        final var item = customerService.getById(id);
        if(item.isEmpty()){
            logger.warn("Customer not found");
            throw new CustomerNotFoundException(
                    String.format("Customer with id %d does not exists",id),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        logger.info("Customer: "+customerDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(EntityToDto(customerService.update(DtoToEntity(customerDto))));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<CustomerDto> deleteCustomer(@PathVariable int id){
        final var customer = customerService.getById(id);
        if(customer.isEmpty()){
            logger.warn("Customer not found");
            throw new CustomerNotFoundException(
                    String.format("Customer with id %d does not exists",id),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        logger.info("Customer: "+customer.get().toString());
        customerService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(EntityToDto(customer.get()));
    }

    public CustomerDto EntityToDto(Customer customer){
        return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(),customer.getPassword());
    }

    public Customer DtoToEntity(CustomerDto customerDto){
        return new Customer(customerDto.id(), customerDto.name(), customerDto.email(),customerDto.password());
    }
}
