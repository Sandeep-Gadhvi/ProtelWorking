package com.Protelcrm.Controller;

import com.Protelcrm.Model.Customer;
import com.Protelcrm.Model.Plans;
import com.Protelcrm.Model.Subscription;
import com.Protelcrm.Model.SubscriptionDTO;
import com.Protelcrm.Service.CustomerService;
import com.Protelcrm.Service.PlansService;
import com.Protelcrm.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "http://localhost:63342") // Your frontend URL

public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PlansService plansService;
    // Create a new subscription
    @PostMapping("/subscription")
    public ResponseEntity<Subscription> createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        Customer customer = customerService.findById(subscriptionDTO.getCustomerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        Plans plan = plansService.findById(subscriptionDTO.getPlanId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan not found"));

        Subscription subscription = new Subscription();
        subscription.setCustomer(customer);
        subscription.setPlan(plan);

        Subscription savedSubscription = subscriptionService.saveSubscription(subscription);
        return new ResponseEntity<>(savedSubscription, HttpStatus.CREATED);
    }


    // Get a subscription by ID
    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
        Optional<Subscription> subscription = subscriptionService.getSubscriptionById(id);
        return subscription.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all subscriptions
    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    // Delete a subscription by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }
}
