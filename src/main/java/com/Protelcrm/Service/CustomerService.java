package com.Protelcrm.Service;

import com.Protelcrm.Model.Customer;
import com.Protelcrm.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
