package com.Protelcrm.customerdetails;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CustomerDetails {
    @GetMapping("/customer-deatils")
    public String customerDetails() {
        return "customer-details";
    }
}
