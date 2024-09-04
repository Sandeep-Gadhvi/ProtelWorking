package com.Protelcrm.Controller;


import com.Protelcrm.Model.Customer;
import com.Protelcrm.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:63342") // Your frontend URL

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Customer> getCustomerById(@PathVariable Long id) {
        return customerService.findById(id)
                .map(customer->ResponseEntity.ok().body(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        return customerService.findById(id)
                .map(customer ->{
                    customer.setCustomer_id(customerDetails.getCustomer_id());
                    customer.setFirst_name(customerDetails.getFirst_name());
                    customer.setLast_name(customerDetails.getLast_name());
                    customer.setEmail(customerDetails.getEmail());
                    customer.setPhone(customerDetails.getPhone());
                    return ResponseEntity.ok().body(customerService.saveCustomer(customer));
                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
        return customerService.findById(id)
                .map(customer -> {
                    customerService.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
