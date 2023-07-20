package in.stackroute.controller;

import in.stackroute.domain.Address;
import in.stackroute.domain.Customer;
import in.stackroute.dto.AddressDto;
import in.stackroute.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public AddressDto convertAddressToDto(Address address){
        return new AddressDto(address.getCity(),address.getStreet(),address.getState(),address.getCountry());
    }
    public Address convertAddressToEmbedded(AddressDto addressDto){
        return new Address(addressDto.city(),addressDto.street(),addressDto.state(),addressDto.country());
    }
    public CustomerDto convertCustomerToDto(Customer customer){
        return new CustomerDto(customer.getCustomerId(),customer.getCustomerName(),
                convertAddressToDto(customer.getHomeAddress()),convertAddressToDto(customer.getWorkAddress()));
    }
    public Customer convertCustomerToEntity(CustomerDto customerDto){
        return new Customer(customerDto.customerId(),customerDto.customerName(),
                convertAddressToEmbedded(customerDto.homeAddress()),convertAddressToEmbedded(customerDto.workAddress()));
    }
    @PutMapping("")
    public ResponseEntity<CustomerDto> add(@RequestBody CustomerDto customerDto){
        return null;
    }
}
