package in.stackroute.services;

import in.stackroute.domain.Customer;
import in.stackroute.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements Services<Customer,Integer>{
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public Customer saveData(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getDataById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllData() {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public Customer delete(Customer customer) {
        return null;
    }
}
